package com.mef.pdfbox.custom.rotate;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PDFCustomTableCell {
	private List<String> textPDF;
	private List<String> listText;
	private float fontSize = 20;
	private PDFont fontFamily = PDType1Font.TIMES_ROMAN;
	private float width = 10;
	private float widthPDF = 10;
	
	private Color backgroundColor = Color.LIGHT_GRAY;
	private Color fontColor = Color.BLACK;
	
	private boolean background = false;
	private float heightPDF = this.getMinHeight();
	private boolean border = true;
	private int align = 0;//-1;0;1

	private boolean selfHeight = false; // if is true and if border is true then
										// the border of this cell is different
										// than others cell of the same row
	
	
	private boolean validCell=true;
	
	static final  Log _log = LogFactoryUtil.getLog(PDFCustomTableCell.class);
	// one row more Customtext
	private List<List<PDFCustomText>> customTextList;
	private List<PDFCustomText> customText;

	
	public boolean isValidCell() {
		return validCell;
	}


	public void setValidCell(boolean validCell) {
		this.validCell = validCell;
	}

	private PDFCustomTableCell() {
		
	}
	
	public PDFCustomTableCell(String text){
		generateCell(text);	
	}

	
	
	private void generateCell(String text) {
		PDFCustomText pdfCustomText = new PDFCustomText();
		pdfCustomText.setText(text);
		pdfCustomText.setBackgroundColor(this.backgroundColor);
		pdfCustomText.setFontColor(this.fontColor);
		pdfCustomText.setFontFamily(this.fontFamily);
		pdfCustomText.setFontSize(this.fontSize);
		
		List<PDFCustomText> textCustom = new ArrayList<>(0);
		textCustom.add(pdfCustomText);
		this.createPdfCustomTextList(textCustom);
		
		

	}
	private void createPdfCustomTextList(List<PDFCustomText> textCustom) {
		if (textCustom != null) {
			
			this.listText = new ArrayList<>();
			this.customText = textCustom;
			
				StringBuilder stringText = new StringBuilder();
				for (PDFCustomText customTextItem : this.customText) {
					stringText.append(customTextItem.getText());
				}
				this.listText.add(stringText.toString());
			
			this.fontFamily = getMaxFontFamilyForCustomText();
			this.fontSize = getMaxFontSizeCustomText();
			
			this.textPDF = new ArrayList<>();
			this.heightPDF = this.getMinHeight();
			textPDF.addAll(this.listText);

		} else
			try {
				throw new PDFCustomException("the text is null");
			} catch (PDFCustomException e) {
				_log.warn(e);
			}
		
	}
	public PDFCustomTableCell(List<PDFCustomText> textCustom) {
		this.createPdfCustomTextList(textCustom);
		
	}
	
	
	public PDFCustomTableCell(String text, PDFont pdfFont) {
		
		this.fontFamily = pdfFont;
		this.heightPDF = this.getMinHeight();
		generateCell(text);

	}

	public PDFCustomTableCell(String text, PDFont pdfFont, float fontSize, boolean border)  {
		this.fontFamily = pdfFont;
		this.fontSize = fontSize;
		this.border = border;
		this.heightPDF = this.getMinHeight();
		generateCell(text);
	}

	public PDFCustomTableCell(String text, PDFont pdfFont, float fontSize, boolean border, boolean background)
			{
		this.fontFamily = pdfFont;
		this.fontSize = fontSize;
		this.border = border;
		
		this.background = background;
		generateCell(text);

	}

	public PDFCustomTableCell(String text, PDFont pdfFont, float fontSize) {
		this.fontFamily = pdfFont;

		this.fontSize = fontSize;
		this.heightPDF = this.getMinHeight();
		generateCell(text);


	}

	public PDFCustomTableCell(String text, PDFont pdfFont, float fontSize, float width)  {
		//this(text, pdfFont, fontSize);
		this.fontFamily = pdfFont;

		this.fontSize = fontSize;

		this.width = width;
		this.heightPDF = this.getMinHeight();
		generateCell(text);

		

	}

	public PDFCustomTableCell(String text, PDFont pdfFont, float fontSize, float width, boolean border,
			boolean background)  {
		this.fontFamily = pdfFont;

		this.fontSize = fontSize;

		this.width = width;
		this.border = border;
		this.background = background;
		generateCell(text);


	}

	public PDFCustomTableCell(String text, float width) {
		this.width = width;
		this.heightPDF = this.getMinHeight();
		generateCell(text);

	}
	public boolean isSelfHeight() {
		return selfHeight;
	}

	public void setSelfHeight(boolean selfHeight) {
		this.selfHeight = selfHeight;
	}




	public List<List<PDFCustomText>> getCustomTextList() {
		return customTextList;
	}

	public void setCustomTextList(List<List<PDFCustomText>> customTextList) {
		this.customTextList = customTextList;
	}


	public List<PDFCustomText> getCustomText() {
		return customText;
	}

	public void setCustomText(List<PDFCustomText> customText) {
		this.customText = customText;
	}
	private PDFont getMaxFontFamilyForCustomText() {
		PDFont fontFamilyItem = this.fontFamily;
		
		float minHeight = 0;
		float minWidth = 0;
		for (PDFCustomText customTextItem : this.customText) {
			if (minHeight < customTextItem.getMinHeight() && (minWidth < PDFCustomText.getMinWidth(" ",
			customTextItem.getFontFamily(), customTextItem.getFontSize()))) {
				minHeight = customTextItem.getMinHeight();
				fontFamilyItem = customTextItem.getFontFamily();
			}
		}
		return fontFamilyItem;
	}
	private float getMaxFontSizeCustomText() {
		float minHeight = 0;
		float minWidth = 0;
		for (PDFCustomText customTextItem : this.customText) {
			if (minHeight < customTextItem.getMinHeight() && (minWidth < PDFCustomText.getMinWidth(" ",
			customTextItem.getFontFamily(), customTextItem.getFontSize()))) {
				minHeight = customTextItem.getFontSize();
			}
		}
		return minHeight;
	}



	private List<List<PDFCustomText>> textCustomDistribute(List<PDFCustomText> textCustom, float width) {
		List<List<PDFCustomText>> lines = new ArrayList<>();

		List<String> strings = null;
		PDFCustomText tempCustom = null;
		for (PDFCustomText custom : textCustom) {
			if (strings == null) {
				tempCustom = custom;
		
				strings = textDistribute(custom.getText(), width, custom.getFontSize(), null, custom.getFontFamily(),
						0);
				// converte in pdfcustomText
				for (int i = 0; i < strings.size() - 1; i++) {
					PDFCustomText text = new PDFCustomText();
					text.setFontFamily(custom.getFontFamily());
					text.setText(strings.get(i));
					text.setFontSize(custom.getFontSize());
					text.setUnderline(custom.isUnderline());
					List<PDFCustomText> lineCustom = new ArrayList<>();
					lineCustom.add(text);
					lines.add(lineCustom);
				}

			} else {
				
				List<PDFCustomText> lineCustom = new ArrayList<>();
				PDFCustomText textBefore = new PDFCustomText();
				textBefore.setFontFamily(tempCustom.getFontFamily());
				textBefore.setUnderline(tempCustom.isUnderline());

				textBefore.setText(strings.get(strings.size() - 1));
				textBefore.setFontSize(tempCustom.getFontSize());

				lineCustom.add(textBefore);

				float widthBefore = PDFCustomText.getMinWidth(strings.get(strings.size() - 1),
						tempCustom.getFontFamily(), tempCustom.getFontSize());
			
				strings = textDistribute(custom.getText(), width, custom.getFontSize(), null, custom.getFontFamily(),
						width - widthBefore);

				if (!strings.isEmpty()) {
					PDFCustomText text = new PDFCustomText();
					text.setFontFamily(custom.getFontFamily());
					text.setText(strings.get(0));
					text.setUnderline(custom.isUnderline());
					text.setFontSize(custom.getFontSize());
					lineCustom.add(text);
				}

				lines.add(lineCustom);
				
					
				
				
					for (int i = 1; i < strings.size() - 1; i++) {
						PDFCustomText text = new PDFCustomText();
						text.setFontFamily(custom.getFontFamily());
						text.setText(strings.get(i));
						text.setFontSize(custom.getFontSize());
						text.setUnderline(custom.isUnderline());
						List<PDFCustomText> lineRegularCustom = new ArrayList<>();
						lineRegularCustom.add(text);
						lines.add(lineRegularCustom);
					}
				if (strings.size()<2){
					strings=null;
				}
				tempCustom = custom;
			}
		}

		if (strings != null && !strings.isEmpty()) {
			List<PDFCustomText> lineCustom = new ArrayList<>();
			PDFCustomText textBefore = new PDFCustomText();
			textBefore.setFontFamily(tempCustom.getFontFamily());
			textBefore.setText(strings.get(strings.size() - 1));
			textBefore.setUnderline(tempCustom.isUnderline());
			textBefore.setFontSize(tempCustom.getFontSize());
			lineCustom.add(textBefore);
			lines.add(lineCustom);

		}
		return lines;

	}

	

	private String textJustification(String text, float width, float fontSize, PDFont pdfFont) {
		String returnText=text;
		try {
			int widthInt = (int)width;
			
			StringBuilder subStringIntBuilder = new StringBuilder();
			subStringIntBuilder.append(returnText.substring(0, returnText.length()));
			int sizeInt = (int)(fontSize * pdfFont.getStringWidth(subStringIntBuilder.toString()) / 1000);
			StringBuilder stringSpaceBuilder = new StringBuilder();

			int countSpace=0;
				while(sizeInt<widthInt) {
					countSpace++;
					subStringIntBuilder.append(" ");

					stringSpaceBuilder.append(" ");
					sizeInt = (int)(fontSize * pdfFont.getStringWidth(subStringIntBuilder.toString()) / 1000);

				}
				String subStringInt = subStringIntBuilder.toString();
				String stringSpace =stringSpaceBuilder.toString();

				if (countSpace>0) {
					subStringInt = subStringInt.substring(0,subStringInt.length()-1);
					countSpace--;
					int spaceIndex = text.indexOf(' ', 0);
					if (spaceIndex==0) { //aggiunti spazi a dx
						returnText = subStringInt + stringSpace;
					}else {
						String[] strings = subStringInt.split(" ");
						int size = strings.length;
						if (size > countSpace) {
							int startSpace = (size/2) - (countSpace/2);
							int j= startSpace;
							for(int i=0; i<countSpace; i++) {
								j++;
								if(strings.length<j)
									strings[j] = strings[j]+=" ";
							}
							StringBuilder tmpString = new StringBuilder();
							for(int i=0; i<strings.length; i++) {
								tmpString.append(strings[i]);
								if (i<strings.length-1)
									tmpString.append(" ");
							}
							returnText = tmpString.toString();

						}else
							returnText=text;
					}
					
				}
		

			
			
		} catch (IOException e2) {
			_log.warn(e2);
		}
		return returnText;
	}
	
	private List<String>	textDistribute(String textPar, float regularWidth, float fontSize, List<String> linesPar,
			PDFont pdfFont, float widthBefore) {
		List<String> lines = new ArrayList<>();
		
		String text = textPar;
		if (linesPar != null)
			lines = linesPar;

	

		int lastSpace = -1;
		float widthInside;
		if (widthBefore > 0)
			widthInside = widthBefore;
		else
			widthInside = regularWidth;

		try {
			if (widthInside < 2)
				try {
					throw new PDFCustomException("width must be major than 1");
				} catch (PDFCustomException e) {
					_log.warn(e);
				}

			while (text.length() > 0) {
				int spaceIndex = text.indexOf(' ', lastSpace + 1);
				if (spaceIndex < 0)
					spaceIndex = text.length();
				String subString = text.substring(0, spaceIndex);

				float size;
				try {
					size = fontSize * pdfFont.getStringWidth(subString) / 1000;
					if (size > widthInside) {
						if (lastSpace < 0)
							lastSpace = spaceIndex;
						subString = text.substring(0, lastSpace);

						if(lastSpace==text.length() || (fontSize * pdfFont.getStringWidth(subString) / 1000)>widthInside) {
					
							String subString2 = subString;
							String subString3 = subString;
							float sizeTmp = size;
							int lastPs =lastSpace;
							while(subString3.length()>0 && sizeTmp>widthInside) {
								
								if (sizeTmp>widthInside) {
									lastPs= subString3.length();
									while(sizeTmp>widthInside) {
										subString2 = subString2.substring(0, subString2.length()-1);
										lastPs--;
										try {
											sizeTmp = (int)(fontSize * pdfFont.getStringWidth(subString2) / 1000);
										} catch (IOException e) {
												_log.warn(e);										}
									}
									lines.add(subString2);
	
									StringBuilder st = new StringBuilder();
									st.append(subString2);
									st.append(" ");
									subString3 = subString3.substring(lastPs);
									st.append(subString3);
									subString2 = subString3;
								
								}
							}
							text = text.substring(lastPs).trim();
							lastSpace = -1;
						}else {
							
							lines.add(textJustification(subString,widthInside,fontSize,pdfFont));

							widthInside = regularWidth;
							text = text.substring(lastSpace).trim();
							lastSpace = -1;
						}
						
						
				} else if (spaceIndex == text.length()) {
						lines.add(text);
						text = "";
					} else {
						lastSpace = spaceIndex;
					}
				} catch (IOException e) {
					_log.warn(e);
				}
			}
		} catch (Exception e1) {
			_log.warn(e1);
		}

		return lines;

	}

	private float getCenterTextHeight(float position) {
		float height = (this.fontFamily.getFontDescriptor().getCapHeight()) / 1000 * this.fontSize;
		float space = (this.heightPDF / (this.getTextPDF().size()));
		return position - (((space) / 2) - (height / 2));
	}

	private float rightTextWidth(int index, float position, boolean flagRotate) {
		float result;
		
		try {
			float width = this.fontFamily.getStringWidth(this.getTextPDF().get(index)) / 1000 * this.fontSize;

			if (flagRotate)
				result = position + ((this.widthPDF - width));
			else
				result = position + width;

		} catch (IOException e) {
			_log.warn(e);
			if (flagRotate)
				result = position + 1;
			else
				result = position - 1;
		}
		return result;

	}

	private float leftTextWidth(float position, boolean flagRotate) {
		if (flagRotate)
			return position + 1;
		else
			return position + this.widthPDF - 1;
	}

	private float centerTextWidth(int index, float position, boolean flagRotate) {
		float result;
	
		try {
			float textWidth = this.fontFamily.getStringWidth(this.textPDF.get(index)) / 1000 * this.fontSize;
			if (flagRotate)
				result = position + ((this.widthPDF / 2) - (textWidth / 2));
			else {
				result = ((this.widthPDF / 2) + (textWidth) / 2) + position;

			}
		} catch (IOException e) {
			_log.warn(e);
			if (flagRotate)
				result = position + 1;
			else
				result = position - 1;
		}
		return result;

	}

	public float getWidthPDF() {
		return widthPDF;
	}

	public void setWidthPDF(float widthPDF) {
		this.widthPDF = widthPDF;
	}

	public void setText(String text) {
		this.listText = new ArrayList<>();
		this.listText.add(text);
	}

	public void setText(List<String> listText) {
		this.listText = listText;
	}

	public String getText() {
		return listText.get(0);
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

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeightPDF() {
		return this.heightPDF;
	}

	public void setHeightPDF(float heightPDF) {
		this.heightPDF = (heightPDF);
	}

	public int getAlign() {
		return align;
	}

	public void setAlign(int align) {
		this.align = align;
	}

	public float getPositionTextPDF(int index, boolean rotatePage, float pos) {
		if (rotatePage) {
			if (this.align > 0)// align right
				return this.rightTextWidth(index, pos, rotatePage);
			if (this.align < 0)// align left
				return this.leftTextWidth(pos, rotatePage);
			return this.centerTextWidth(index, pos, rotatePage);
		} else
			return this.getCenterTextHeight(pos);
	}

	public float getPositionTextPDFX(int index, boolean rotatePage, float pos) {
		if (!rotatePage) {
			if (this.align > 0)// align right
				return this.rightTextWidth(index, pos, rotatePage);
			if (this.align < 0)// align left
				return this.leftTextWidth(pos, rotatePage);
			return this.centerTextWidth(index, pos, rotatePage);
		} else
			return this.getCenterTextHeight(pos);

	}

	public float getPositionTextPDFY(int index, boolean rotatePage, float pos) {
		return this.getPositionTextPDF(index, rotatePage, pos);

	}

	

	public void setUnderline(boolean underline) {
		if(this.customText!=null && !this.customText.isEmpty()) {
			for(PDFCustomText customText : this.customText) {
					customText.setUnderline(underline);
				
			}
		}
		
		if(this.customTextList!=null && !this.customTextList.isEmpty()) {
			for(List<PDFCustomText> customTextList : this.customTextList) {
				for(PDFCustomText customText : customTextList) {
					customText.setUnderline(underline);
				}
			}
		}
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

	public boolean isBackground() {
		return background;
	}

	public void setBackground(boolean background) {
		this.background = background;
	}

	public List<String> getListText() {
		return listText;
	}

	public void setListText(List<String> listText) {
		this.listText = listText;
	}

	public void addListText(String text) {
		if (this.listText == null)
			
			this.listText = new ArrayList<>();
		this.listText.add(text);
	}

	public boolean isBorder() {
		return border;
	}

	public void setBorder(boolean border) {
		this.border = border;
	}

	public List<String> getTextPDF() {

		return textPDF;
	}

	
	public void setTextPDF()  {
		this.textPDF = new ArrayList<>();
		/*if (this.customText == null) {
			for (String text : this.listText) {
				this.textPDF
						.addAll(this.textDistribute(text, this.widthPDF, this.fontSize, null, this.fontFamily, 0));
			}
		} else*/
		if(this.customText != null){
			//if(this.customTextList==null || this.customTextList.isEmpty()) {
				this.customTextList = new ArrayList<>(0);
				List<PDFCustomText> pdfCustomTextList = new ArrayList<>(0);
				for(PDFCustomText pdfCustomText : this.customText){
					if(pdfCustomText.isNewLine()){
						pdfCustomTextList.add(pdfCustomText);
						this.customTextList.addAll(textCustomDistribute(pdfCustomTextList, this.widthPDF));
						pdfCustomTextList = new ArrayList<>(0);
					}else{
						pdfCustomTextList.add(pdfCustomText);
					}
					
	
				}
				this.customTextList.addAll(textCustomDistribute(pdfCustomTextList, this.widthPDF));
		}
				for (List<PDFCustomText> customText : this.customTextList) {
					StringBuilder strings = new StringBuilder();
					for (PDFCustomText text : customText) {
						strings.append(text.getText());	
	
					}
	
					this.textPDF.add(strings.toString());
				}
			//}

		
		this.heightPDF = (this.getMinHeight() * this.textPDF.size());
	
	}
	
	
	public PDFCustomTableCell setTextPagePDF(float begin, float offset)  {
		setTextPDF();
	
		List<String> textPdfBuilder = new ArrayList<>();
		List<List<PDFCustomText>> customPdfList = new ArrayList<>(0);

		
		while(this.heightPDF+begin>offset){
			
			this.heightPDF-=this.getMinHeight();
			textPdfBuilder.add(this.textPDF.get(textPDF.size()-1));
			this.textPDF.remove(textPDF.size()-1);
			if(this.customTextList!=null){
				customPdfList.add(new ArrayList<>(this.customTextList.get(this.customTextList.size()-1)));
				
					
				this.customTextList.remove(this.customTextList.size()-1);
				//this.customText =null;
			}
			


		}
		PDFCustomTableCell returnPdf = new PDFCustomTableCell("");
		if(!textPdfBuilder.isEmpty()) {
			
			
			if(!customPdfList.isEmpty()) {
				
				returnPdf = new PDFCustomTableCell();
				returnPdf.customTextList = new ArrayList<>(customPdfList);

				for(int j=customPdfList.size()-1; j==-1; j--) {
					returnPdf.customTextList.add(customPdfList.get(j));
				}
				returnPdf.textPDF = new ArrayList<>(0);
				
				/*for (List<PDFCustomText> customText : this.customTextList) {
					StringBuilder strings = new StringBuilder();
					for (PDFCustomText text : customText) {
						strings.append(text.getText());	
	
					}
	
					returnPdf.textPDF.add(strings.toString());
				}
	*/		
				
			}
			returnPdf.widthPDF = this.widthPDF;
			returnPdf.width = this.width;
			returnPdf.validCell=true;
			returnPdf.fontColor = this.fontColor;
			returnPdf.background = this.background;
			returnPdf.border = this.border;
			returnPdf.align = this.align;
			returnPdf.backgroundColor = this.backgroundColor;
			returnPdf.fontFamily=this.fontFamily;
			returnPdf.fontSize =this.fontSize;
			returnPdf.listText=textPdfBuilder;
			Collections.reverse(returnPdf.customTextList);
			//returnPdf.textPDF=textPdfBuilder;
		//	
		}else {
			returnPdf.widthPDF = this.widthPDF;
			returnPdf.width = this.width;
			returnPdf.fontColor = this.fontColor;
			returnPdf.background = this.background;
			returnPdf.border = this.border;
			returnPdf.align = this.align;
			returnPdf.backgroundColor = this.backgroundColor;
			returnPdf.fontFamily=this.fontFamily;
			returnPdf.fontSize =this.fontSize;
			//returnPdf.listText=textPdfBuilder;
			
			returnPdf.validCell=false;

		}
		returnPdf.setTextPDF();
		
		//returnPdf.heightPDF = (returnPdf.getMinHeight() * this.textPDF.size());	
		return returnPdf;
		
	}

	public float getMinWidthPDF(int i) {
		try {
			return this.fontFamily.getStringWidth(this.getTextPDF().get(i)) / 1000 * this.fontSize;
		} catch (IOException e) {
			_log.warn(e);
		}
		return 0;

	}

	public float getMinHeight() {
		return (((this.fontFamily.getFontDescriptor().getCapHeight()) / 1000) * (this.fontSize * 1.5f) + 2);
	
	}

	public float getMinHeightCheck() {
		return (((this.fontFamily.getFontDescriptor().getCapHeight()) / 1000) * (this.fontSize * 1.5f));
	}


	public PDFCustomTableCell copyCell() {
		PDFCustomTableCell returnPdf = new PDFCustomTableCell();

		if(this.customText!=null && !this.customText.isEmpty()) {
			returnPdf = new PDFCustomTableCell(new ArrayList<>(this.customText));
		}
		if(this.customText!=null && !this.customText.isEmpty()) {
			returnPdf = new PDFCustomTableCell(new ArrayList<>(this.customText));
		}
	
		returnPdf.listText = new ArrayList<>(this.listText);
		returnPdf.textPDF= new ArrayList<>(this.textPDF);

		returnPdf.fontColor = this.fontColor;
		returnPdf.background = this.background;
		returnPdf.border = this.border;
		returnPdf.align = this.align;
		returnPdf.backgroundColor = this.backgroundColor;
		returnPdf.fontFamily=this.fontFamily;
		returnPdf.fontSize =this.fontSize;
		

		returnPdf.heightPDF = this.heightPDF;
		returnPdf.selfHeight = this.selfHeight;
		returnPdf.width = this.width;
		returnPdf.widthPDF = this.widthPDF;
		returnPdf.validCell=this.validCell;
		//returnPdf.setTextPDF();
		if(this.customTextList!=null){
			returnPdf.customTextList = new ArrayList<>(this.customTextList);
		}
		return returnPdf;
	}

}
