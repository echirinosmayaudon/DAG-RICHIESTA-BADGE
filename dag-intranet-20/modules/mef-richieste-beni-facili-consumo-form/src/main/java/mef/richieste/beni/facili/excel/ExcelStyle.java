package mef.richieste.beni.facili.excel;



import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;

public class ExcelStyle {
	
	/*Cell font applies diffrent to the text in excel
	 * */
	@SuppressWarnings("deprecation")
	public Font CellFont(String fontcolor, Workbook workbook) {

		Font font = workbook.createFont();

		if ("red".equals(fontcolor)) {

			font.setColor(HSSFColor.RED.index);
			font.setBold(true);

		}

		if ("white".equals(fontcolor)) {

			font.setColor(HSSFColor.WHITE.index);
			font.setBold(true);

		}
		return font;

	}
/*verticalText is a method which can be used for wraping a text in a vertical 
 * form */
	public CellStyle verticalText(Workbook workbook) {

		CellStyle style = workbook.createCellStyle();
		style.setWrapText(true);
		
		return style;

	}
	/*background Color is used for giving background color to the cell*/
	@SuppressWarnings("deprecation")
	public CellStyle backgroundColor(Workbook workbook) {

	
		HSSFWorkbook hwb = new HSSFWorkbook();
		HSSFPalette palette = hwb.getCustomPalette();
		// get the color which most closely matches the color you want to use
		HSSFColor myColor = palette.findSimilarColor(0, 127, 133);
		// get the palette index of that color
		short palIndex = myColor.getIndex();
		CellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(palIndex);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		return style;
	}
/*borderStyling is used to give border to the cell according to value provided 
 * upon calling the method we can pass only one value and other strings can be
 * null.The string which is not null the method will be give only that border in return 
 * in form a style. 
 * */
	public CellStyle borderStyling(String right, String left, String top, String bottom, Workbook workbook) {
		CellStyle cellStyle = workbook.createCellStyle();

		if ("bottom".equals(bottom))
			cellStyle.setBorderBottom(BorderStyle.THIN);

		if ("top".equals(top))
			cellStyle.setBorderTop(BorderStyle.THIN);

		if ("left".equals(left))
			cellStyle.setBorderLeft(BorderStyle.THIN);

		if ("right".equals(right))
			cellStyle.setBorderRight(BorderStyle.THIN);

		return cellStyle;

	}
	/*cell design method is used to design the cell 
	 * we have to booleans which can be true if we want background color or have border
	 * both of the booleans can also be true in case we want both background and border*/

	public CellStyle cellDesign(boolean backgroundColor, boolean displayBorder, Workbook workbook) {

		CellStyle cellStyle = workbook.createCellStyle();
		if (backgroundColor == true) {
			workbook.createCellStyle();
			CellStyle backgroundStyle = backgroundColor(workbook);
			cellStyle.cloneStyleFrom(backgroundStyle);
			Font font = CellFont("white", workbook);
			cellStyle.setFont(font);
			if (displayBorder == true) {

				cellStyle.setBorderBottom(BorderStyle.THIN);
				cellStyle.setBorderLeft(BorderStyle.THIN);
				cellStyle.setBorderRight(BorderStyle.THIN);
				cellStyle.setBorderTop(BorderStyle.THIN);
			}
		} else {

			cellStyle.setBorderBottom(BorderStyle.THIN);
			cellStyle.setBorderLeft(BorderStyle.THIN);
			cellStyle.setBorderRight(BorderStyle.THIN);
			cellStyle.setBorderTop(BorderStyle.THIN);

		}
		return cellStyle;
	}

}
