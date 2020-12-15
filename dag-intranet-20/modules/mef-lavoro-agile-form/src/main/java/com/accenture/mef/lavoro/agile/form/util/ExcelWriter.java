package com.accenture.mef.lavoro.agile.form.util;

import com.accenture.mef.lavoro.agile.form.bean.RichiestaLavAgileExcelBean;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.List;

import javax.portlet.ResourceResponse;

import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.ss.util.SheetUtil;

public class ExcelWriter {
	private static final Log _log = LogFactoryUtil.getLog(ExcelWriter.class);

	/*
	 * The below method is used to call write richieste method to create excel
	 * workbook, sheet and populate the sheet with data.
	 *
	 **/
	public static void writeRichiesteExcel(List<RichiestaLavAgileExcelBean> excelData,
			ResourceResponse resourceResponse) {

		writeRichieste(excelData, resourceResponse);

	}

	/*
	 * The populate sheet method takes all the data in form a list of type
	 * ExcelBean. It creates row and cell and then populate all the data using
	 * that has been passed through list.
	 *
	 **/
	public static void populateSheet(Workbook workbook, List<RichiestaLavAgileExcelBean> elenco_richlavagile_list,
			String sheetName) {

		// Create a new sheet
		Sheet sheet = workbook.createSheet(sheetName);
		// Set custom width for some columns
		sheet.setColumnWidth(2, 4900);
		sheet.setColumnWidth(3, 4900);
		sheet.setColumnWidth(4, 4900);
		sheet.setColumnWidth(9, 4900);
		sheet.setColumnWidth(19, 11900);
		sheet.setColumnWidth(20, 20900);

		// Create custom Cellstyle
		CellStyle style = workbook.createCellStyle();
		// Set bold font in header
		Font font = workbook.createFont();
		font.setBold(true);
		style.setFont(font);
		// Get gray color and set in header
		HSSFWorkbook hwb = new HSSFWorkbook();
		HSSFPalette palette = hwb.getCustomPalette();
		// Get the color which most closely matches the color you want to use
		HSSFColor myColor = palette.findSimilarColor(191, 191, 191);
		// Get the palette index of that color
		short palIndex = myColor.getIndex();
		style.setFillForegroundColor(palIndex);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		// Set THIN Border Bottom
		style.setBorderBottom(BorderStyle.THIN);

		Row header = sheet.createRow(0);

		Cell cell = header.createCell(0);
		cell.setCellValue("#");
		cell.setCellStyle(style);
		CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

		cell = header.createCell(1);
		cell.setCellValue("Istanza");
		cell.setCellStyle(style);
		CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

		cell = header.createCell(2);
		cell.setCellValue("Cognome");
		cell.setCellStyle(style);
		CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

		cell = header.createCell(3);
		cell.setCellValue("Nome");
		cell.setCellStyle(style);
		CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

		cell = header.createCell(4);
		cell.setCellValue("Codice Fiscale");
		cell.setCellStyle(style);
		CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

		cell = header.createCell(5);
		cell.setCellValue("Dip");
		cell.setCellStyle(style);
		CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

		cell = header.createCell(6);
		cell.setCellValue("Dir");
		cell.setCellStyle(style);
		CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

		cell = header.createCell(7);
		cell.setCellValue("Priorit\u00E0");
		cell.setCellStyle(style);
		CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

		cell = header.createCell(8);
		cell.setCellValue("Punteggio");
		cell.setCellStyle(style);
		CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);
		
		cell = header.createCell(9);
		cell.setCellValue("Data di nascita");
		cell.setCellStyle(style);
		CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

		cell = header.createCell(10);
		cell.setCellValue("2a");
		cell.setCellStyle(style);
		CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

		cell = header.createCell(11);
		cell.setCellValue("2b");
		cell.setCellStyle(style);
		CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

		cell = header.createCell(12);
		cell.setCellValue("3a");
		cell.setCellStyle(style);
		CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

		cell = header.createCell(13);
		cell.setCellValue("3b");
		cell.setCellStyle(style);
		CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

		cell = header.createCell(14);
		cell.setCellValue("3c1");
		cell.setCellStyle(style);
		CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

		cell = header.createCell(15);
		cell.setCellValue("3c2");
		cell.setCellStyle(style);
		CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

		cell = header.createCell(16);
		cell.setCellValue("3d");
		cell.setCellStyle(style);
		CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

		cell = header.createCell(17);
		cell.setCellValue("3e");
		cell.setCellStyle(style);
		CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

		cell = header.createCell(18);
		cell.setCellValue("3f");
		cell.setCellStyle(style);
		CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

		cell = header.createCell(19);
		cell.setCellValue("Allegato");
		cell.setCellStyle(style);
		CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

		cell = header.createCell(20);
		cell.setCellValue("Note");
		cell.setCellStyle(style);
		CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

		// Create content rows
		if (elenco_richlavagile_list != null && !elenco_richlavagile_list.isEmpty()) {
			for (int i = 0; i < elenco_richlavagile_list.size(); i++) {

				RichiestaLavAgileExcelBean richiesta = elenco_richlavagile_list.get(i);

				// Create content row
				Row row = sheet.createRow(i + 1);

				cell = row.createCell(0);
				cell.setCellValue(i + 1);
				CellUtil.setAlignment(cell, HorizontalAlignment.RIGHT);

				cell = row.createCell(1);
				cell.setCellValue(richiesta.getIstanza());
				CellUtil.setAlignment(cell, HorizontalAlignment.RIGHT);

				cell = row.createCell(2);
				cell.setCellValue(richiesta.getCognome());

				cell = row.createCell(3);
				cell.setCellValue(richiesta.getNome());

				cell = row.createCell(4);
				cell.setCellValue(richiesta.getCodice_fiscale());

				cell = row.createCell(5);
				cell.setCellValue(richiesta.getDip());

				cell = row.createCell(6);
				cell.setCellValue(richiesta.getDir());

				cell = row.createCell(7);
				cell.setCellValue(richiesta.getPriorita());
				CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

				cell = row.createCell(8);
				cell.setCellValue(richiesta.getPunteggio());
				CellUtil.setAlignment(cell, HorizontalAlignment.RIGHT);
				
				cell = row.createCell(9);
				cell.setCellValue(richiesta.getData_nascita());
				CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

				cell = row.createCell(10);
				cell.setCellValue(richiesta.getFlag_2a());
				CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

				cell = row.createCell(11);
				cell.setCellValue(richiesta.getFlag_2b());
				CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

				cell = row.createCell(12);
				cell.setCellValue(richiesta.getFlag_3a());
				CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

				cell = row.createCell(13);
				cell.setCellValue(richiesta.getFlag_3b());
				CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

				cell = row.createCell(14);
				cell.setCellValue(richiesta.getValue_3c1());
				CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

				cell = row.createCell(15);
				cell.setCellValue(richiesta.getValue_3c2());
				CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

				cell = row.createCell(16);
				cell.setCellValue(richiesta.getValue_3d());
				CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

				cell = row.createCell(17);
				cell.setCellValue(richiesta.getValue_3e());
				CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

				cell = row.createCell(18);
				cell.setCellValue(richiesta.getFlag_3f());
				CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

				cell = row.createCell(19);
				cell.setCellValue(richiesta.getAllegato());

				cell = row.createCell(20);
				cell.setCellValue(richiesta.getNote());

			}

		}

	}

	/*
	 * The method below is used when the excel button is clicked to download the
	 * excel this method calls the populate sheet method, that helps to enter
	 * data inside the cells in excel.The data is passed through list which is
	 * called in our case as excelData and after the setting up cell using
	 * populateSheet it allows to download the excel using method
	 * workbook.write(resourceReponse.getPortletOutputStream())
	 */

	public static void writeRichieste(List<RichiestaLavAgileExcelBean> excelData, ResourceResponse resourceResponse) {

		try {

			// Create a new workbook
			Workbook workbook = new HSSFWorkbook();

			populateSheet(workbook, excelData, "Classifica");

			workbook.write(resourceResponse.getPortletOutputStream());

			workbook.close();

		} catch (FileNotFoundException e) {
			_log.warn(e);

		} catch (IOException e) {
			_log.warn(e);

		}

	}

}