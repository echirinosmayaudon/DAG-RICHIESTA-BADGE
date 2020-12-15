package com.mef.pdfbox.custom.rotate;




import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;



public class PDFCustomTableRow {
	

private boolean flagSplitedRow = false;

	private List<PDFCustomTableCell> cells;
	private float width; //non &egrave; la lunghezza effettiva 
	private float height;
	private float heightMin;
	private float heightMinimal;

	private int numberRow;
	
	private PDFCustomTableCell cellHeightMax;
	
	private boolean checkText = false;
	final static Log _log = LogFactoryUtil.getLog(PDFCustomTableRow.class);

	
	private int index = 0;
	
	
	public float getHeightMinimal() {
		return heightMinimal;
	}




	public void setHeightMinimal(float heightMinimal) {
		this.heightMinimal = heightMinimal;
	}




	public float getHeightMin() {
		return heightMin;
	}




	public void setHeightMin(float heightMin) {
		this.heightMin = heightMin;
	}




	public boolean isFlagSplitedRow() {
		return flagSplitedRow;
	}




	public void setFlagSplitedRow(boolean flagSplitedRow) {
		this.flagSplitedRow = flagSplitedRow;
	}




	public int getIndex() {
		return index;
	}




	public void setIndex(int index) {
		this.index = index;
	}




	public float getWidth() {
		return width;
	}




	public int getNumberRow() {
		return numberRow;
	}




	public void setNumberRow(int numberRow) {
		this.numberRow = numberRow;
	}




	public PDFCustomTableCell getCellHeightMax() {
		return cellHeightMax;
	}




	public void setCellHeightMax(PDFCustomTableCell cellHeightMax) {
		this.cellHeightMax = cellHeightMax;
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




	

	


	public PDFCustomTableRow(List<PDFCustomTableCell> cells, int numberRow){
		try {
			float heightTmp =0;
			if (this.validCells(cells)){
				for(PDFCustomTableCell cell: cells){
					float heightMin = cell.getMinHeight();
					if (heightTmp<heightMin && cell.isValidCell())
						heightTmp = heightMin;
				}
			}else
				throw new PDFCustomException("the list of cell is null");
			this.heightMinimal = this.height;

			this.height = heightTmp * numberRow;
			this.heightMin = this.height;
			this.numberRow = numberRow;
			 
			

			
			this.calculateRow(cells);
			
			this.cells=new ArrayList<>(cells);
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
				
				if (this.height<cell.getHeightPDF() && cell.isValidCell())
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
		this.height=this.heightMin;
		
		if (this.validCells(this.cells)){
			for(PDFCustomTableCell cell: this.cells){
				if (/*(offset<0 || offset>=cell.getHeightPDF()+begin) && */this.height<cell.getHeightPDF() && cell.isValidCell()){
					this.height=cell.getHeightPDF();
					this.cellHeightMax = cell;
				}/*else {
					/*if (offset>0 && offset>=cell.getHeightPDF()+begin) {
						
						_log.warn("error cell is too height" + offset);
						_log.warn(cell.getTextPDF());
						_log.warn("error cell is too height2");
					}
				}*/
				
				this.width += cell.getWidth();
			}
		}else
			throw new PDFCustomException("the list of cell is null");

	}
	
	
	public void doubleFixRowHeight() throws PDFCustomException{
		this.width=0;
		//this.height=0;
		if (this.validCells(this.cells)){
			for(PDFCustomTableCell cell: this.cells){
				if (/*(offset<0 || offset>=cell.getHeightPDF()+begin) && */this.height<cell.getMinHeight()){
					this.height=cell.getMinHeight();
				}/*else {
					/*if (offset>0 && offset>=cell.getHeightPDF()+begin) {
						
						_log.warn("error cell is too height" + offset);
						_log.warn(cell.getTextPDF());
						_log.warn("error cell is too height2");
					}
				}*/
				
			}
			
			for(int i=0; i<this.cells.size();i++){
				if(this.cells.get(i).isSelfHeight())
					this.cells.get(i).setHeightPDF(this.cells.get(i).getMinHeight());
				else
					this.cells.get(i).setHeightPDF(this.height);
				
			}
		}else
			throw new PDFCustomException("the list of cell is null");

	}
	
	
	public List<PDFCustomTableCell> getCells() {
		return cells;
	}

	/*
	public List<PDFCustomTableRow> setMinCell(float min){
		this.width=0;
		List<PDFCustomTableRow> rows = new ArrayList<>(0);
		if (this.validCells(this.cells)){
			for(PDFCustomTableCell cell: this.cells){
				if (min>cell.getMinHeight()){
					String text = cell.
					
				}
				
				this.width += cell.getWidth();
			}
		}else
			throw new PDFCustomException("the list of cell is null");
		
	}*/
	
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




	public boolean cellValid() {
		for(PDFCustomTableCell cell: this.cells) {
			if(cell.isValidCell()) {
				return true;
			}
			
		}
		return false;
	}
	
	
	public PDFCustomTableRow copyRow() {
		
		List<PDFCustomTableCell> listCell = new ArrayList<>(0);
		for(PDFCustomTableCell cell: this.getCells()) {
			listCell.add(cell.copyCell());
			
		}
		PDFCustomTableRow returnPDF =  new PDFCustomTableRow(listCell, this.numberRow);
		returnPDF.cellHeightMax = this.cellHeightMax;
		returnPDF.checkText = this.checkText;
		returnPDF.height= this.height;
		returnPDF.width=this.width;
		
		
		return returnPDF;
	}




	
}
