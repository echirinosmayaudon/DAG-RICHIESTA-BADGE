package com.mef.pdfbox.custom.rotate;



import org.apache.pdfbox.pdmodel.font.PDType1Font;


public class PDFCustomPageLayout {
	private PDFCustomTable textTableHeader;
	private PDFCustomTable textTableFooter;

	private boolean flagNumberPage =true;
	private float offsetRight = 20;
	private float offsetLeft = 20;
	private float offsetUp = 20;
	private float offsetDown = 20;

	//public static final String _PAGE_OF = "_page_of_";


	public PDFCustomPageLayout(PDFCustomTable tableHeader, PDFCustomTable tableFooter) {
		this.textTableHeader = tableHeader;
		this.textTableFooter = tableFooter;
		
	}

	public PDFCustomPageLayout(String textHeader, String textFooter) {
		
		this.textTableHeader = PDFCustomTable.createTable(textHeader, 0, PDType1Font.TIMES_ROMAN, 10, 0, false);
		this.textTableFooter = PDFCustomTable.createTable(textFooter, 0, PDType1Font.TIMES_ROMAN, 10, 0, false);
	}
	public PDFCustomPageLayout(String textHeader) {
		
		this.textTableHeader = PDFCustomTable.createTable(textHeader, 0, PDType1Font.TIMES_ROMAN, 10, 0, false);
	}
	
	public boolean isFlagNumberPage() {
		return flagNumberPage;
	}

	public void setFlagNumberPage(boolean flagNumberPage) {
		this.textTableFooter=null;
		this.flagNumberPage = flagNumberPage;
	}

	public PDFCustomTable getTextTableHeader() {
		return textTableHeader;
	}

	public void setTextTableHeader(PDFCustomTable textTableHeader) {
		this.textTableHeader = textTableHeader;
	}

	public PDFCustomTable getTextTableFooter() {
		return textTableFooter;
	}

	public void setTextTableFooter(PDFCustomTable textTableFooter) {
		this.textTableFooter = textTableFooter;
	}

	protected float getOffsetTextFooter(float overHeight, boolean rotatePage) {

		float x = this.textTableFooter.calculateTableHeightPDF(rotatePage);
		return overHeight - x;

	}

	protected boolean validate(float heightOff, float heightOver, boolean rotatePage) {
		float height = 0;
		if (this.textTableHeader != null)
			height += this.textTableHeader.calculateTableHeightPDF(rotatePage);
		if (this.textTableFooter != null)
			height += this.textTableFooter.calculateTableHeightPDF(rotatePage);

		return height < (heightOver - heightOff);

	}

	
	public float getOffsetRight() {
		return offsetRight;
	}

	public void setOffsetRight(float offsetRight) {
		this.offsetRight = offsetRight;
	}

	public float getOffsetLeft() {
		return offsetLeft;
	}

	public void setOffsetLeft(float offsetLeft) {
		this.offsetLeft = offsetLeft;
	}

	public float getOffsetUp() {
		return offsetUp;
	}

	public void setOffsetUp(float offsetUp) {
		this.offsetUp = offsetUp;
	}

	public float getOffsetDown() {
		return offsetDown;
	}

	public void setOffsetDown(float offsetDown) {
		this.offsetDown = offsetDown;
	}

}
