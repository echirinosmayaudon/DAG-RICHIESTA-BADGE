package com.mef.pdfbox.custom;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.awt.Color;
import java.io.IOException;


import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PDFCustomText {

	private float fontSize = 20;
	private PDFont fontFamily = PDType1Font.TIMES_ROMAN;
	private Color backgroundColor = Color.LIGHT_GRAY;
	private Color fontColor = Color.BLACK;
	private String text;
	private float widthPDF = 10;
	private boolean underline= false;
	final static Log _log = LogFactoryUtil.getLog(PDFCustomText.class);


	public void setText(String text) {
		this.text = text;
	}
	public boolean isUnderline() {
		return underline;
	}
	public void setUnderline(boolean underline) {
		this.underline = underline;
	}
	public String getText() {
		return text;
	}
	public float getFontSize() {
		return fontSize;
	}
	public void setFontSize(float fontSize) {
		this.fontSize = fontSize;
	}
	public PDFont getFontFamily() {
		return fontFamily;
	}
	public void setFontFamily(PDFont fontFamily) {
		this.fontFamily = fontFamily;
	}
	public Color getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public Color getFontColor() {
		return fontColor;
	}
	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}

	public float getWidthPDF() {
		return widthPDF;
	}
	public void setWidthPDF(float widthPDF) {
		this.widthPDF = widthPDF;
	}
	

	public float getMinHeight() {
		return (((this.fontFamily.getFontDescriptor().getCapHeight()) / 1000) * (this.fontSize * 1.5f)+2) ;
	}
	
	public float getMinWidth(){
		try {
			return this.fontFamily.getStringWidth(this.text) / 1000 * this.fontSize;
		} catch (IOException e) {
			_log.warn(e);
		}
		return 0;
		
	}
	public static float getMinWidth(String text, PDFont fontFamily, float fontSize){
		try {
			return fontFamily.getStringWidth(text) / 1000 * fontSize;
		} catch (IOException e) {
			_log.warn(e);

		}
		return 0;
		
	}
}
