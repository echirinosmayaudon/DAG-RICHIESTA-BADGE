package com.mef.pdfbox.custom.rotate;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.font.PDFont;



public class PDFCustomTable {

	private List<PDFCustomTableRow> rows;
	private List<PDFCustomTableRow> rowsHeader;

	private float widthPDF = 10;

	private float rowsHeaderHeightPDF;
	private boolean border = true;
	private float borderX = 5;
	private float borderY = 5;
	private boolean borderVisible = true;
	final static Log _log = LogFactoryUtil.getLog(PDFCustomTable.class);

	
	public PDFCustomTable(List<PDFCustomTableRow> rows, List<PDFCustomTableRow> rowsHeader) {
		if (rows != null && !rows.isEmpty()) {
			this.rows = rows;
			this.rowsHeader = rowsHeader;
		} else
			try {
				throw new PDFCustomException("rows not found");
			} catch (PDFCustomException e) {
				_log.warn(e);
			}
	}

	public PDFCustomTable(List<PDFCustomTableRow> rows)  {
		if (rows != null && !rows.isEmpty()) {
			this.rows = rows;

		} else
			try {
				throw new PDFCustomException("rows not found");
			} catch (PDFCustomException e) {
				_log.warn(e);
			}
	}

	public float calculateAllRowsPDF() {
		float heightPDF = 0;
		if (this.rows != null) {
			for (PDFCustomTableRow row : this.rows) {
				try {
					row.calculateRow(true);
					heightPDF += row.getHeight();
				} catch (Exception e) {
					_log.warn(e);
				}
			}

		}

		return this.calculateRowsHeaderHeightPDF() + heightPDF;
	}

	public float calculateTableHeightPDF(boolean rotatePage) {
		float height = this.calculateAllRowsPDF();
		if (rotatePage && this.isBorder()) {
			height += (this.getBorderX() * 2);

		} else if (!rotatePage && this.isBorder()) {
			height += (this.getBorderY() * 2);
		}
		return height;
	}

	
	protected static PDFCustomTable createCheckBox(String text, int align, PDFont fontFamily, float fontSize, int tab, boolean checked) {
		List<PDFCustomTableCell> cells = new ArrayList<>();
		try {
			//create cell with checkbox
		
				PDFCustomTableCell cell = new PDFCustomTableCell(text,fontFamily,fontSize,false);
				cell.setAlign(align);
				cell.setWidth(80);
				cells.add(cell);
				PDFCustomTableCell cellEmpty= new PDFCustomTableCell(" ",fontFamily,fontSize,false);
				cellEmpty.setAlign(align);
				cellEmpty.setWidth(1);
				cells.add(cellEmpty);
				String check=  checked ? "X" : " ";
				PDFCustomTableCell cellCheck = new PDFCustomTableCell(check,fontFamily,fontSize,true);
				cellCheck.setAlign(align);
				cellCheck.setWidth(0); //il check box viene calcolato diversamente rispetto alle altre celle
				cellCheck.setSelfHeight(true);
				cells.add(cellCheck);

				if (tab > 0) {
					PDFCustomTableCell cellTab = new PDFCustomTableCell(" ",fontFamily,fontSize,false);
					cellTab.setWidth(tab*0.5f);
					cellTab.setBorder(false);
					cells.add(cellTab);
				}
				List<PDFCustomTableRow> rows = new ArrayList<>();
				
				PDFCustomTableRow row = new PDFCustomTableRow(cells,1);
				row.setCheckText(true);
				rows.add(row);
				PDFCustomTable table = new PDFCustomTable(rows, null);
				table.setBorder(true);
				table.setBorderVisible(false);
				table.setBorderY(2);
				table.setBorderX(0);
				return table;
			
		} catch (Exception e) {
			_log.warn(e);
			return null;

		}
	}
	
	
	protected static PDFCustomTable createTable(String text, int align, PDFont fontFamily, float fontSize, int tab, boolean flagBorders) {
		List<PDFCustomTableCell> cells = new ArrayList<>();
		try {
			
			PDFCustomTableCell cell = new PDFCustomTableCell(text,fontFamily,fontSize,flagBorders);
			
		
			cell.setAlign(align);

			
			cells.add(cell);
			
			if (tab > 0) {
				PDFCustomTableCell cellTab = new PDFCustomTableCell(" ",fontFamily,fontSize,false);
				cellTab.setWidth(tab*0.5f);
				cellTab.setBorder(false);
				cells.add(cellTab);
			}
			List<PDFCustomTableRow> rows = new ArrayList<>();
			rows.add(new PDFCustomTableRow(cells,1));
			PDFCustomTable table = new PDFCustomTable(rows, null);
			table.setBorder(false);
			return table;
		} catch (Exception e) {
			_log.warn(e);
			return null;

		}
	}
	
	public float getRowsHeaderHeightPDF() {
		return rowsHeaderHeightPDF;
	}

	public void setRowsHeaderHeightPDF(float rowsHeaderHeightPDF) {
		this.rowsHeaderHeightPDF = rowsHeaderHeightPDF;
	}

	public float calculateRowsHeaderHeightPDF() {
		float heightPDF = 0;
		if (this.rowsHeader != null) {
			for (PDFCustomTableRow row : this.rowsHeader) {
				try {
					row.calculateRow(true);
					heightPDF += row.getHeight();
				} catch (Exception e) {
					_log.warn(e);
				}
			}

		}
		this.rowsHeaderHeightPDF = heightPDF;
		return this.rowsHeaderHeightPDF;

	}

	public List<PDFCustomTableRow> getRowsHeader() {
		return rowsHeader;
	}

	public void setRowsHeader(List<PDFCustomTableRow> rowsHeader) {
		this.rowsHeader = rowsHeader;
	}

	public boolean isBorder() {
		return border;
	}

	public void setBorder(boolean border) {
		this.border = border;
	}

	public float getBorderX() {
		return borderX;
	}

	public void setBorderX(float borderX) {
		this.borderX = borderX;
	}

	public float getBorderY() {
		return borderY;
	}

	public void setBorderY(float borderY) {
		this.borderY = borderY;
	}

	
	public float getWidthPDF() {
		return widthPDF;
	}

	public void setWidthPDF(float widthPDF) {
		this.widthPDF = widthPDF;
	}

	public List<PDFCustomTableRow> getRows() {
		return rows;
	}

	public void setRows(List<PDFCustomTableRow> rows) {
		this.rows = rows;
	}

	public boolean isBorderVisible() {
		return borderVisible;
	}

	public void setBorderVisible(boolean borderVisible) {
		this.borderVisible = borderVisible;
	}

	

}
