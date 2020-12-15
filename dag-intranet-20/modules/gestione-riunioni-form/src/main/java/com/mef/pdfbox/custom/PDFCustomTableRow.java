package com.mef.pdfbox.custom;




import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;



public class PDFCustomTableRow {
	
	private List<PDFCustomTableCell> cells;
	private float width; //non &egrave; la lunghezza effettiva 
	private float height;
	
	private boolean checkText = false;
	final static Log _log = LogFactoryUtil.getLog(PDFCustomTableRow.class);

	public float getWidth() {
		return width;
	}




	public boolean isCheckText() {
		return checkText;
	}




	public void setCheckText(boolean checkText) {
		this.checkText = checkText;
	}




	public void setWidth(float width) {
		this.width = width;
	}




	

	


	public PDFCustomTableRow(List<PDFCustomTableCell> cells, float height){
		try {
			float heightTmp =0;
			if (this.validCells(cells)){
				for(PDFCustomTableCell cell: cells){
					float heightMin = cell.getMinHeight();
					if (heightTmp<heightMin)
						heightTmp = heightMin;
				}
			}else
				throw new PDFCustomException("the list of cell is null");
			this.height = heightTmp * height;
			 
			

			
			this.calculateRow(cells);
			
			this.cells=cells;
		} catch (Exception e) {
			_log.warn(e);
		}
	}

	
	
	
	private boolean validCells(List<PDFCustomTableCell> cells){
		
		return cells!=null;
	}
	
	private float calculateRow(List<PDFCustomTableCell> cells) throws PDFCustomException{
		if (this.validCells(cells)){
			for(PDFCustomTableCell cell: cells){
				
				if (this.height<cell.getHeightPDF())
					this.height=cell.getHeightPDF();
				this.width += cell.getWidth();
			}
			return height;
		}else
			throw new PDFCustomException("the list of cell is null");

	}
	
	
	public void calculateRow(boolean flag)throws PDFCustomException{
		this.calculateRow();
		if (flag){
			for(int i=0; i<this.cells.size();i++){
				if(this.cells.get(i).isSelfHeight())
					this.cells.get(i).setHeightPDF(this.cells.get(i).getMinHeight());
				else
					this.cells.get(i).setHeightPDF(this.height);
				
			}
		}
			
			

	}
	
	public void calculateRow() throws PDFCustomException{
		this.width=0;
		if (this.validCells(this.cells)){
			for(PDFCustomTableCell cell: this.cells){
				if (this.height<cell.getHeightPDF())
					this.height=cell.getHeightPDF();
				
				this.width += cell.getWidth();
			}
		}else
			throw new PDFCustomException("the list of cell is null");

	}
	
	
	public List<PDFCustomTableCell> getCells() {
		return cells;
	}

	public void setCells(List<PDFCustomTableCell> cells) {
		try {
			this.calculateRow(cells);
			this.cells=cells;
		} catch (Exception e) {
			_log.warn(e);
		}
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		if (!this.validCells(this.cells))
			this.height = height;
		try {
			if (this.calculateRow(cells)<height){
				this.height=height;
			}
		} catch (Exception e) {
			_log.warn(e);
		}
	}




	public static float correctColSize(float widthCell, float widthPDF, float widthRow) {
		return (widthCell * widthPDF)/widthRow;
		
	}
	
	public static float correctColSizeCheck(float widthCell, float widthPDFPar, float widthRow, float widthCheck) {
		float widthPDF = (widthPDFPar - widthCheck);
		return (widthCell * widthPDF)/widthRow;
		
	}
}
