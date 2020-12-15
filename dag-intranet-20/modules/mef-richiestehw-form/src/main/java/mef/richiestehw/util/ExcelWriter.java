package mef.richiestehw.util;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;



import mef.richiestehw.beans.RichiestaHwBean;


public class ExcelWriter {

	
	private static final Log _log = LogFactoryUtil.getLog(ExcelWriter.class);
	public static boolean writeRichiesteExcel(List<RichiestaHwBean> richiesteComputer, List<RichiestaHwBean> richiesteStampanti,List<RichiestaHwBean> richiestePeriferiche,List<RichiestaHwBean> richiesteSoftware, File file) {

		if (file != null) {

			return writeRichieste(richiesteComputer,richiesteStampanti,richiestePeriferiche,richiesteSoftware, file);
		}

		return false;
	}
	
	public static void populateSheet(Workbook workbook, List<RichiestaHwBean> richieste, String sheetName ){
		// Create a new sheet
		Sheet sheet = workbook.createSheet(sheetName);

			// Create header row
			Row header = sheet.createRow(0);

			// Tipologia
			Cell cell = header.createCell(0);
			cell.setCellValue("Tipologia");

			// Quantit
			cell = header.createCell(1);
			cell.setCellValue("Quantit\u00E0");

			// Note
			cell = header.createCell(2);
			cell.setCellValue("Note");

			
			// Create content rows
			if(richieste != null && !richieste.isEmpty()){
			 for (int i = 0; i < richieste.size(); i++) {
			
					RichiestaHwBean richiesta = richieste.get(i);

				     if (richiesta != null) {

					  // Create content row
					  Row row = sheet.createRow(i + 1);

					  // Tipologia
					  cell = row.createCell(0);
					  cell.setCellValue(richiesta.getTipologia());

					  // Quantita
					  cell = row.createCell(1);
					  cell.setCellValue(richiesta.getQuantita());

					  // Note
					  cell = row.createCell(2);
					  cell.setCellValue(richiesta.getNote());
				}
			}
		  }
		}
	
	public static boolean writeRichieste(List<RichiestaHwBean> richiesteComputer, List<RichiestaHwBean> richiesteStampanti,List<RichiestaHwBean> richiestePeriferiche,List<RichiestaHwBean> richiesteSoftware, File file) {

		if (file != null) {

			try {

				// Create a new workbook
				Workbook workbook = new HSSFWorkbook();

					populateSheet(workbook,richiesteComputer,"Computer");
					populateSheet(workbook,richiesteStampanti,"Stampanti");
					populateSheet(workbook,richiestePeriferiche,"Periferiche");
					populateSheet(workbook,richiesteSoftware,"Software");
					FileOutputStream fileOutputStream = new FileOutputStream(file);

					workbook.write(fileOutputStream);

					workbook.close();

					return true;
				
			} catch (FileNotFoundException e) {

				_log.error(e);
			} catch (IOException e) {

				_log.error(e);
			}
		}
		return false;
	}
	
	
	
}
