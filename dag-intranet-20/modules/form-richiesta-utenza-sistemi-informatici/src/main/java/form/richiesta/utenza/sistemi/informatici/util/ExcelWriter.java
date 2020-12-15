package form.richiesta.utenza.sistemi.informatici.util;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import form.richiesta.utenza.sistemi.informatici.beans.RichiestaUtenzaBean;





public class ExcelWriter {

	
	  static final Log _log = LogFactoryUtil.getLog(ExcelWriter.class);

	public static boolean writeRichiesteExcel(RichiestaUtenzaBean dati, File file) {

		if (file != null) {

			return writeRichieste(dati, file);
		}

		return false;
	}

	
	public static void populateSheet(Workbook workbook, RichiestaUtenzaBean dati, String sheetName ){
		// Create a new sheet
		Sheet sheet = workbook.createSheet(sheetName);

		if (sheet != null) {

			// Create header row
			Row header = sheet.createRow(0);
			
			Cell cell = header.createCell(0);
			cell.setCellValue("Asset Computer");
			
			cell = header.createCell(1);
			cell.setCellValue("Applicazione");
			
			cell = header.createCell(2);
			cell.setCellValue("Codice Fiscale");
			
			cell = header.createCell(3);
			cell.setCellValue("Utenza");
			
			cell = header.createCell(4);
			cell.setCellValue("Cambio Ufficio");
			
			cell = header.createCell(5);
			cell.setCellValue("Reset Password");

				if (dati != null) {

					// Create content row
					Row row = sheet.createRow(1);

				
					cell = row.createCell(0);
					cell.setCellValue(dati.getAssetPc());

	
					cell = row.createCell(1);
					cell.setCellValue(dati.getApplicazione());
					
					cell = row.createCell(2);
					cell.setCellValue(dati.getCodFiscale());
					
					cell = row.createCell(3);
					cell.setCellValue(dati.getUtenza());
					
					cell = row.createCell(4);
					cell.setCellValue(dati.getCambioUfficio());
					
					cell = row.createCell(5);
					cell.setCellValue(dati.getResetPassword());
					
//					cell = row.createCell(6);
//					cell.setCellValue(dati.getResetPassword());

				}		
		}
	}
	
	
	public static boolean writeRichieste(RichiestaUtenzaBean dati, File file) {

		if (file != null) {

			try {

				// Create a new workbook
				Workbook workbook = new HSSFWorkbook();
				populateSheet(workbook,dati,"dati richiesta");
				FileOutputStream fileOutputStream = new FileOutputStream(file);

				workbook.write(fileOutputStream);

				workbook.close();

				return true;
				
			} catch (FileNotFoundException e) {
				_log.warn(e);
			} catch (IOException e) {
				_log.warn(e);

			}
		}
		return false;
	}
	
	
	
}
