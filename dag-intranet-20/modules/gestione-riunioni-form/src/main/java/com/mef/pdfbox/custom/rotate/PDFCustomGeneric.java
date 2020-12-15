package com.mef.pdfbox.custom.rotate;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.PDPageContentStream;


public class PDFCustomGeneric {
	private PDDocument doc;
	private PDPage page;
	private int pageCount =0;

	private OutputStream outputStream;
	private PDPageContentStream contentStream;
	private PDFCustomPageLayout pageLayout;
	private boolean rotatePage = false;
	private double rotateText = 0;

	private float offsetPageX = 0;
	private float offsetPageY = 0;
	private float overflowPageX = 10;
	private float overflowPageY = 10;

	private String fileName = "PDFBOXCustom";

	private static final double _ROTATE_TEXT = Math.PI * 0.5;
	private static final double _DEFAULT_TEXT = Math.PI;

	private static final int _ROTATE_PAGE = 90;
	private static final int _DEFAULT_PAGE = 180;
	final static Log _log = LogFactoryUtil.getLog(PDFCustomGeneric.class);

	public PDFCustomGeneric() {
		this.doc = new PDDocument();
		this.createNewPagePDF(this.rotatePage);
	}

	public PDFCustomGeneric(boolean rotatePage) {
		this.doc = new PDDocument();
		this.createNewPagePDF(rotatePage);
	}

	public PDFCustomGeneric(String filename, boolean rotatePage) {
		this.doc = new PDDocument();
		this.rotatePage = rotatePage;
		this.fileName = filename;
		this.createNewPagePDF(rotatePage);
	}

	public PDFCustomGeneric(String filename) {
		super();
		this.fileName = filename;
	}


	public void setPageLayout(PDFCustomPageLayout pageLayout) {
		this.pageLayout = pageLayout;
		this.drawCustomPageLayoutPDF(-1);
	}

	public boolean isRotatePage() {
		return rotatePage;
	}

	public void setRotatePage(boolean rotatePage) {
		this.rotatePage = rotatePage;
	}

	public OutputStream getOutputStream() {
		return outputStream;
	}

	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	
	
	@SuppressWarnings("deprecation")
	private void drawRectBorderPDF(float startX, float startY, float endX, float endY) {
		if (this.page != null) {
			PDRectangle box = this.page.getBBox();
			try {
				if ((box != null) && (startY > box.getLowerLeftY()) && (startX > box.getLowerLeftX())) {
					contentStream.drawLine(endX, startY, endX, endY);
					contentStream.drawLine(startX, startY, endX, startY);
					contentStream.drawLine(startX, endY, endX, endY);
					contentStream.drawLine(startX, startY, startX, endY);
				} else {
					throw new PDFCustomException("the rect cannot be drawn");

				}
			} catch (Exception e) {
					_log.warn(e);
			_log.warn(e);
			}
		}
	}

	@SuppressWarnings("deprecation")
	private boolean drawTextPDF(String text, float x, float y, float fontSize, PDFont pdfFont, double rotateText) {
		try {
			contentStream.beginText();
			contentStream.setTextRotation(rotateText, x, y);
			contentStream.setFont(pdfFont, fontSize);

			contentStream.drawString(text);

			contentStream.endText();
			return true;

		} catch (IOException e) {
			_log.warn(e);
			return false;
		}

	}
	
	@SuppressWarnings("deprecation")
	private boolean drawCustomTextPDF(List<PDFCustomText> text, float x, float y, double rotateText) {
		try {
			contentStream.beginText();
			contentStream.setTextRotation(rotateText, x, y);
			for(PDFCustomText textCustom : text){
				contentStream.setFont(textCustom.getFontFamily(), textCustom.getFontSize());
				contentStream.drawString(textCustom.getText());
			}
			contentStream.endText();
			float width = x;
	
			if (this.rotatePage){
				width = y;
			
			}
			
			
			for(PDFCustomText textCustom : text){
				
				
				if (textCustom.isUnderline())
					if (this.rotatePage)
						contentStream.drawLine(x+1, width, x+1, width+textCustom.getMinWidth());				
					else
						contentStream.drawLine(width, y+1, width-textCustom.getMinWidth(), y+1);
				if (this.rotatePage)
					width +=  textCustom.getMinWidth();  
				else
					width -=  textCustom.getMinWidth();  
					
			}

			return true;

		} catch (IOException e) {
			_log.warn(e);
			return false;
		}

	}
	

	private void drawRectBackgroundPDF(float startX, float startY, float endX, float endY, PDFCustomTableCell cell) {

		if (this.page != null) {
			PDRectangle box = this.page.getBBox();
			try {
				if ((box != null) && (endX < box.getWidth()) && (startY > box.getLowerLeftY())
						&& (startX > box.getLowerLeftX()) && (endY < box.getHeight())) {

					contentStream.setNonStrokingColor(cell.getBackgroundColor());
					contentStream.addRect(startX, startY, endX - startX, endY - startY);
					contentStream.fill();
					contentStream.setNonStrokingColor(cell.getFontColor());

				} else {
					throw new PDFCustomException("the rect cannot be drawn");

				}

			} catch (Exception e) {
				_log.warn(e);			}
		}

	}

	
	
	@SuppressWarnings("deprecation")
	private void drawCellTextPDF(PDFCustomTableCell cell, float positionX, float positionY) {
		
		float move = (cell.getHeightPDF() / (cell.getTextPDF().size()));
		float posX= positionX;
		float posY = positionY;
		float pos;
		if (this.rotatePage) {
			pos = posX;
			posY -= cell.getWidthPDF();
		} else {
			pos = posY;
			posX -= cell.getWidthPDF();
		}

		if (cell.getTextPDF().size() > 1){
			pos -= (move * (cell.getTextPDF().size() - 1));
		}
		
			int size=  cell.getCustomTextList().size();
		
		float y;
		float x;
		for (int i = 0; i < size; i++) {
		
			if (this.rotatePage) {
				 y = cell.getPositionTextPDF(i, this.rotatePage, posY);
				 x = cell.getPositionTextPDFX(i, this.rotatePage, pos);
			} else {

				 y = cell.getPositionTextPDFY(i, this.rotatePage, pos);
				 x = cell.getPositionTextPDFX(i, this.rotatePage, posX);

			}
			
			this.drawCustomTextPDF(cell.getCustomTextList().get(i), x, y, this.rotateText);
			
			
			pos += move;

		}

	}

	
	
	
	
	private float drawRowsPDF(PDFCustomTable table, float heightOff, float widthOffset, float heightOverflow,
			float widthOverflow, boolean flagHeader) {
		float heightOffset = heightOff;
		float height = heightOffset;
		float width = widthOffset;

		float y;
		float x;
		float yMove;
		float xMove;

		List<PDFCustomTableRow> rows;
		try {
			if (flagHeader)
				rows = table.getRowsHeader();
			else
				rows = table.getRows();

			PDFCustomTableRow rowTmp = null;
			
			int i=0;
			
			List <PDFCustomTableRow> listRow = new ArrayList<>(0);
			boolean flagPageForRow = false;
			
			boolean flagRowOtt = true;
			
			
			int j;
			while ( i<rows.size()) {
				PDFCustomTableRow row  = rows.get(i).copyRow();

				if(rowTmp!=null && rowTmp.cellValid()) {
					 row  = rowTmp.copyRow();
					 row.setFlagSplitedRow(true);
				}
				j=i;
				
					
								
				row.calculateRow();
								
			
				float widthCheck=0; 
				List<PDFCustomTableCell> listTmp = new ArrayList<>(0);
					for (PDFCustomTableCell cell: row.getCells()) {
						if (!row.isCheckText()){
							boolean flagCellSize = cell.getListText()==null || cell.getListText().isEmpty() || "".equals(cell.getListText().get(0));
							
							
							
							cell.setWidthPDF(
								PDFCustomTableRow.correctColSize(cell.getWidth(), table.getWidthPDF(), row.getWidth()));
							if(!flagRowOtt) {
								cell.setCustomText(null);
							}
							listTmp.add(cell.setTextPagePDF(height,heightOverflow));
					
							
							
							if(!flagCellSize && cell.getTextPDF().size()==0) {
								flagPageForRow = true;
							}
								
						}else{ //calcola lo spazio occupato dal check
							if (cell.isSelfHeight()){
								
								cell.setWidthPDF(cell.getMinHeightCheck());
								if(!flagRowOtt) {
									cell.setCustomText(null);
								}
								listTmp.add(cell.setTextPagePDF(height,heightOverflow));
								widthCheck=cell.getWidthPDF();
								break;
							}
															
						}
					}
				
						if(!flagPageForRow) {
							rowTmp = new PDFCustomTableRow(listTmp,row.getNumberRow());
							//row.calculateRow(true);
							if(height + row.getHeight() >heightOverflow) {
								row.setNumberRow(1);
								row.setHeightMin(row.getNumberRow()*row.getHeightMinimal());

							}row.calculateRow(true);
							if(height + row.getHeight() >heightOverflow) {
								_log.warn("error ");

							}
								height+=row.getHeight();
								listRow.add(row);

							

							if(rowTmp!=null && rowTmp.cellValid()) {
								flagRowOtt = false;
								height = heightOffset;
								
								i=j;
							}else {
								flagRowOtt = true;

							}
							
						}
						else {
							height = heightOffset;
						}
						
							
						
					
						
					
					
					//set the width of other cells
					if(row.isCheckText()){
						for (PDFCustomTableCell cell : row.getCells()) {
							if (!cell.isSelfHeight()){
								cell.setWidthPDF(
										PDFCustomTableRow.correctColSizeCheck(cell.getWidth(), table.getWidthPDF(), row.getWidth(), widthCheck));
								cell.setTextPagePDF(height,heightOverflow);
									
							}
						}
					}
					if (flagRowOtt)
						i++;
			}
			
			height = heightOffset;
			
			for (PDFCustomTableRow row: listRow) {
			
				/*row.calculateRow();
				
				float widthCheck=0; 

				for (PDFCustomTableCell cell: row.getCells()) {
					if (!row.isCheckText()){
						cell.setWidthPDF(
							PDFCustomTableRow.correctColSize(cell.getWidth(), table.getWidthPDF(), row.getWidth()));
						//if(row.isFlagSplitedRow())
							//	cell.setTextPDF();
					//	rowBuffer.getCells().get(j).setTextPDF();
				
					}else{ //calcola lo spazio occupato dal check
						if (cell.isSelfHeight()){
							//rowBuffer.getCells().get(j).setTextPDF();
							cell.setWidthPDF(cell.getMinHeightCheck());
							//if(row.isFlagSplitedRow())
								//cell.setTextPDF();							
							widthCheck=cell.getWidthPDF();

							break;
						}
														
					}
				}
				//set the width of other cells
				if(row.isCheckText()){
					for (PDFCustomTableCell cell : row.getCells()) {
						if (!cell.isSelfHeight()){
							//cell.setWidthPDF(
									//PDFCustomTableRow.correctColSizeCheck(cell.getWidth(), table.getWidthPDF(), row.getWidth(), widthCheck));
							//cell.setTextPagePDF(height,heightOverflow);
								
						}
					}
				}
				row.calculateRow(true);
				*/
				
				height += row.getHeight();

				if ( height > heightOverflow) { // fine pagina
					if (flagHeader && table.getRows() != null && table.getRows().size() > 0) {
						// Error
						
						contentStream.close();
						createNewPagePDF(this.rotatePage);
						return -1;
				
					} else {
						
						if (table.isBorder()) {
							if (table.getRowsHeader() != null && table.getRowsHeader().size() > 0 && (!flagHeader))
								heightOffset -= table.calculateRowsHeaderHeightPDF();
							if (this.rotatePage) {
								y = widthOverflow;
								x = height - row.getHeight();
								yMove = widthOffset;
								xMove = heightOffset;
								if (row.isFlagSplitedRow())
									xMove = heightOffset- table.getBorderX();

							} else {
								y = height - row.getHeight();
								

								x = widthOverflow;
								yMove = heightOffset;
								xMove = widthOffset;
								if (row.isFlagSplitedRow())
									yMove = heightOffset- table.getBorderY();

							}
							if (table.isBorderVisible())
								drawRectBorderPDF(xMove - table.getBorderX(), yMove - table.getBorderY(),
									x + table.getBorderX(), y + table.getBorderY());

						}
						contentStream.close();
						createNewPagePDF(this.rotatePage);
						
						heightOffset = drawTablePDF(table, true);
						if(row.isFlagSplitedRow()) {
							_log.warn("riga");
						}
						height = heightOffset + row.getHeight();
						
					}
				}

				for (PDFCustomTableCell cell : row.getCells()) {
					width += cell.getWidthPDF();
					if (this.rotatePage) {
						y = width;
						if (cell.isSelfHeight())
							x = (height -row.getHeight())+cell.getMinHeight();
						else
							x = height;
						xMove = height - row.getHeight();
						yMove = width - cell.getWidthPDF();

					} else {
						if (cell.isSelfHeight())
							y = (height -row.getHeight())+cell.getMinHeight();
						else
							y = height;
						x = width;
						yMove = height - row.getHeight();
						xMove = width - cell.getWidthPDF();
					}

					if (cell.isBackground()) {
						this.drawRectBackgroundPDF(x, y, xMove, yMove, cell);
					}

					if (cell.isBorder()) {
						this.drawRectBorderPDF(x, y, xMove, yMove);
						
							
					}

					drawCellTextPDF(cell, x, y);
				}
				i++;

			}

			if (table.isBorder() && (!flagHeader)) {
				if (table.getRowsHeader() != null && table.getRowsHeader().size() > 0 && (!flagHeader))
					heightOffset -= table.calculateRowsHeaderHeightPDF();

				if (this.rotatePage) {
					y = widthOverflow;
					x = height;
					yMove = widthOffset;
					xMove = heightOffset - table.getBorderX();
					
				} else {
					y = height;
					x = widthOverflow;
					yMove = heightOffset;
					xMove = widthOffset - table.getBorderY();
					

				}
				if (table.isBorderVisible())
					drawRectBorderPDF(xMove - table.getBorderX(), yMove - table.getBorderY(), x + table.getBorderX(),
						y + table.getBorderY());
				if (this.rotatePage)
					height += (table.getBorderX() * 2);
				else
					height += (table.getBorderY() * 2);

			}
			return height;

		} catch (Exception e) {
			_log.warn(e);
			return -1;

		}
	}

	private float drawTablePDF(PDFCustomTable table, boolean flagRepeat)  {
		float offsetPageX = this.offsetPageX;
		float offsetPageY = this.offsetPageY;
		float overflowPageY = this.overflowPageY;
		float overflowPageX = this.overflowPageX;
		if (table.isBorder()) {
			offsetPageX += table.getBorderX();
			offsetPageY += table.getBorderY();
			overflowPageY -= table.getBorderY();
			overflowPageX -= table.getBorderX();
		}

		
		if (this.rotatePage) {
			//table.fixRows();

			table.setWidthPDF(overflowPageY - offsetPageY);
			float offHeader = this.offsetPageX;
			if (table.getRowsHeader() != null && (table.getRowsHeader().size()) > 0) {
				offHeader = drawRowsPDF(table, offsetPageX, offsetPageY, overflowPageX, overflowPageY, true);
				if (offHeader>0){
					this.offsetPageX = offHeader;
				}
			
			}
			if (offHeader<0){
				return drawTablePDF(table,false);
			}else{
			
				if (!flagRepeat && this.offsetPageX > 0) {
					this.offsetPageX = drawRowsPDF(table, this.offsetPageX, offsetPageY, overflowPageX, overflowPageY,
							false);
				}

				return this.offsetPageX;
			}
		} else {
			//table.fixRows();

			table.setWidthPDF(overflowPageX - offsetPageX);
			float offHeader = this.offsetPageY;

			if (table.getRowsHeader() != null && table.getRowsHeader().size() > 0) {
					offHeader = drawRowsPDF(table, offsetPageY, offsetPageX, overflowPageY, overflowPageX, true);
					if (offHeader>0)
						this.offsetPageY = offHeader;
				
			}
			if (offHeader<0){
				return drawTablePDF(table,false);
			}else{
				if (!flagRepeat && this.offsetPageY > 0)
					this.offsetPageY = drawRowsPDF(table, this.offsetPageY, offsetPageX, overflowPageY, overflowPageX,
							false);
				return this.offsetPageY;
			}
		}

	}

	public void drawTablePDF(PDFCustomTable table) {
		this.drawTablePDF(table, false);

	}

	private void drawCustomPageLayoutPDF(int nPage) {
		try {
			if (this.rotatePage) {
				this.offsetPageY += this.pageLayout.getOffsetLeft();
				this.offsetPageX += this.pageLayout.getOffsetUp();
				this.overflowPageX -= this.pageLayout.getOffsetDown();
				this.overflowPageY -= this.pageLayout.getOffsetRight();
				if(this.pageLayout.isFlagNumberPage())
					this.pageLayout.setTextTableFooter(PDFCustomTable.createTable("Pagina " + String.valueOf(nPage+1) + " di " + String.valueOf(this.pageCount), -1,  PDType1Font.TIMES_ROMAN, 10, 0, false));
				
				if (this.pageLayout.validate(this.offsetPageX, this.overflowPageX, this.rotatePage)) {
				if (this.pageLayout.getTextTableFooter() != null) {
						float offset = this.offsetPageX;
						float overflowAfter = this.pageLayout.getOffsetTextFooter(this.overflowPageX, rotatePage);
						this.offsetPageX = overflowAfter;
						if(this.pageLayout.isFlagNumberPage() && nPage>=0)
							this.drawTablePDF(this.pageLayout.getTextTableFooter());
						this.overflowPageX = overflowAfter;
						this.offsetPageX = offset;
					}

					if ((this.pageLayout.getTextTableHeader() != null) && (nPage<0)){
						this.drawTablePDF(this.pageLayout.getTextTableHeader());
					}
				} else
					throw new PDFCustomException("layout is too big");

			} else {
				this.offsetPageY += this.pageLayout.getOffsetUp();
				this.offsetPageX += this.pageLayout.getOffsetRight();
				this.overflowPageX -= this.pageLayout.getOffsetLeft();
				this.overflowPageY -= this.pageLayout.getOffsetDown();
				if(this.pageLayout.isFlagNumberPage())
					this.pageLayout.setTextTableFooter(PDFCustomTable.createTable("Pagina " + String.valueOf(nPage+1) + " di " + String.valueOf(this.pageCount), -1,  PDType1Font.TIMES_ROMAN, 10, 0, false));
				if (this.pageLayout.validate(this.offsetPageX, this.overflowPageX, this.rotatePage)) {
					if (this.pageLayout.getTextTableFooter() != null) {
						float offset = this.offsetPageY;
						float overflowAfter = this.pageLayout.getOffsetTextFooter(this.overflowPageY, rotatePage);
						this.offsetPageY = overflowAfter;
						if(this.pageLayout.isFlagNumberPage() && nPage>=0)
							this.drawTablePDF(this.pageLayout.getTextTableFooter());
						this.overflowPageY = overflowAfter;
						this.offsetPageY = offset;
					}

					if ((this.pageLayout.getTextTableHeader() != null) && (nPage<0)){
						this.drawTablePDF(this.pageLayout.getTextTableHeader());
					}
				} else
					throw new PDFCustomException("layout is too big");
			}
			
		} catch (Exception e) {
			_log.warn(e);
		}

	}

	public void createNewPagePDF() {
		createNewPagePDF(this.rotatePage);
	}

	public void createNewPagePDF(boolean rotatePage) {
		try {
			this.rotatePage = rotatePage;
			this.offsetPageX = 0;
			this.offsetPageY = 0;
			this.page = new PDPage();
			if (this.rotatePage) {
				this.page.setRotation(PDFCustomGeneric._ROTATE_PAGE);
				this.rotateText = PDFCustomGeneric._ROTATE_TEXT;
				this.overflowPageX = this.page.getBBox().getWidth() - 1;
				this.overflowPageY = this.page.getBBox().getHeight() - 1;

			} else {
				this.page.setRotation(PDFCustomGeneric._DEFAULT_PAGE);
				this.rotateText = PDFCustomGeneric._DEFAULT_TEXT;
				this.overflowPageX = this.page.getBBox().getWidth() - 1;
				this.overflowPageY = this.page.getBBox().getHeight() - 1;

			}
			this.doc.addPage(page);
			this.pageCount++;
			if (this.contentStream != null)
				this.contentStream.close();
			this.contentStream = new PDPageContentStream(this.doc, this.page);

			if (this.pageLayout != null) {
				this.drawCustomPageLayoutPDF(-1);

			}

		} catch (IOException e) {
			_log.warn(e);
		}
	}

	/* tutti i metodi per scrivere */
	public void writeTextPDF(String text) {
		this.writeTextPDF(text, 0, PDType1Font.TIMES_ROMAN, 20, 0);
	}

	public void writeTextPDF(String text, PDFont fontFamily, float fontSize) {
		this.writeTextPDF(text, -1, fontFamily, fontSize, 0);
	}

	public void writeTextPDF(String text, float fontSize) {
		this.writeTextPDF(text, -1, PDType1Font.TIMES_ROMAN, fontSize, 0);
	}

	public void writeTextPDF(String text, PDFont fontFamily) {
		this.writeTextPDF(text, -1, fontFamily, 10, 0);
	}

	public void writeTextPDF(String text, int align) {
		this.writeTextPDF(text, align, PDType1Font.TIMES_ROMAN, 12, 0);
	}

	public void writeTextPDF(String text, int align, PDFont fontFamily, float fontSize) {
		this.writeTextPDF(text, align, fontFamily, fontSize, 0);
	}

	public void writeTextPDF(String text, int align, PDFont fontFamily) {
		this.writeTextPDF(text, align, fontFamily, 10, 0);
	}

	public void writeTextPDF(String text, int align, float fontSize) {
		this.writeTextPDF(text, align, PDType1Font.TIMES_ROMAN, fontSize, 0);
	}

	public void writeTextPDF(String text, PDFont fontFamily, float fontSize, int tab) {
		this.writeTextPDF(text, -1, fontFamily, fontSize, tab);
	}

	public void writeTextPDF(String text, int align, PDFont fontFamily, float fontSize, int tab) {
		this.drawTablePDF(PDFCustomTable.createTable(text, align, fontFamily, fontSize, tab, false), false);
	}
	


	
	public void drawTextWithCheck(String text, int align, PDFont fontFamily, float fontSize, int tab, boolean flagCheck) {
		this.drawTablePDF(PDFCustomTable.createCheckBox(text, align, fontFamily, fontSize, tab, flagCheck), false);
	}
	public void addLine(float move){
		if (this.rotatePage){
		//	this.offsetPageY += this.pageLayout.getOffsetLeft();
			this.offsetPageX += move;
			/*if (this.offsetPageX>this.overflowPageX){
				this.createNewPagePDF(this.rotatePage);
			}*/
			

		}else{
			this.offsetPageY += move;
			/*if (this.offsetPageY>this.overflowPageY){
				this.createNewPagePDF(this.rotatePage);
			}*/
		}
	}

	
	public void close() {
		try {
			if (this.doc != null) {
				if (this.contentStream != null)
					this.contentStream.close();
				
				if (this.pageLayout!=null && this.pageLayout.isFlagNumberPage()) {
					//scrive in tutte le pagine ilnumero di pagina nel footer
					for(int i=0; i<this.pageCount; i++ ) {
						this.contentStream = new PDPageContentStream(this.doc, this.doc.getPage(i),true,false);
						this.offsetPageX = 0;
						this.offsetPageY = 0;
						/*if  (this.doc.getPage(i).getBBox().getWidth()>670) {
							this.overflowPageX = this.page.getBBox().getWidth() - 1;
							this.overflowPageY = this.page.getBBox().getHeight() - 1;
						}else {*/
							this.overflowPageX = this.page.getBBox().getWidth() - 1;
							this.overflowPageY = this.page.getBBox().getHeight() - 1;
					
							
							this.drawCustomPageLayoutPDF(i);
							contentStream.close();
							
					}
					
				}

				
				if (this.outputStream == null)
					if (this.fileName != null)
						this.doc.save(this.fileName + ".pdf");
					else {
						this.doc.save("noName.pdf");
					}
				else
					this.doc.save(this.outputStream);

				this.doc.close();
			}
		} catch (IOException e) {
			_log.warn(e);
		}
	}

	public void close(String fileName) {
		this.fileName = fileName;
		this.close();
	}
	public void close(File file) {
		try {
			if (this.doc != null) {
				if (this.contentStream != null)
					this.contentStream.close();
				
				if (this.pageLayout!=null && this.pageLayout.isFlagNumberPage()) {
					//scrive in tutte le pagine ilnumero di pagina nel footer
					for(int i=0; i<this.pageCount; i++ ) {
						this.contentStream = new PDPageContentStream(this.doc, this.doc.getPage(i),true,false);
						this.offsetPageX = 0;
						this.offsetPageY = 0;
						/*if  (this.doc.getPage(i).getBBox().getWidth()>670) {
							this.overflowPageX = this.page.getBBox().getWidth() - 1;
							this.overflowPageY = this.page.getBBox().getHeight() - 1;
						}else {*/
							this.overflowPageX = this.page.getBBox().getWidth() - 1;
							this.overflowPageY = this.page.getBBox().getHeight() - 1;
						//}
							
							this.drawCustomPageLayoutPDF(i);
							contentStream.close();
							
					}
					
				}

				
					this.doc.save(file);

				this.doc.close();
				
			}
		} catch (IOException e) {
			_log.warn(e);
		}
	}
}
