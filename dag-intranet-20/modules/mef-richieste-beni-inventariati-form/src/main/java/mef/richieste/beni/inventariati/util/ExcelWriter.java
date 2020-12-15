package mef.richieste.beni.inventariati.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.List;

import javax.portlet.ResourceResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import mef.richieste.beni.inventariati.bean.ExcelBean;


public class ExcelWriter {
	private static final Log _log = LogFactoryUtil.getLog(ExcelWriter.class);
	/*
	 * The below method is used to call write richieste method to create excel
	 * workbook, sheet and populate the sheet with data.
	 *
	 **/
	public static void writeRichiesteExcel(List<ExcelBean> excelData, ResourceResponse resourceResponse) {

		writeRichieste(excelData, resourceResponse);

	}

	/*
	 * The populate sheet method takes all the data in form a list of type
	 * ExcelBean. It creates row and cell and then populate all the data using
	 * that has been passed through list.
	 *
	 **/
	public static void populateSheet(Workbook workbook, List<ExcelBean> richieste, String sheetName) {
		// Create a new sheet

		Sheet sheet = workbook.createSheet(sheetName);
		Row header = sheet.createRow(0);
		Cell cell = header.createCell(0);
		

			// Create header row

			// Id richiesta

			cell.setCellValue("Id richiesta");

			// Nome
			cell = header.createCell(1);
			cell.setCellValue("Nome");

			// Cognome
			cell = header.createCell(2);
			cell.setCellValue("Cognome");

			// Oggetto
			cell = header.createCell(3);
			cell.setCellValue("Oggetto");

			// Data
			cell = header.createCell(4);
			cell.setCellValue("Data");

			// Stato
			cell = header.createCell(5);
			cell.setCellValue("Stato");

	
		// Create content rows
		if(richieste!=null && !richieste.isEmpty()){
		for (int i = 0; i < richieste.size(); i++) {

		
			ExcelBean richiesta = richieste.get(i);

			

				// Create content row
				Row row = sheet.createRow(i + 1);

				// Id richiesta
				cell = row.createCell(0);

				cell.setCellValue(richiesta.getId_richiesta());

				// Nome
				cell = row.createCell(1);

				cell.setCellValue(richiesta.getNome_richiedente());

				// Cognome
				cell = row.createCell(2);

				cell.setCellValue(richiesta.getCognome_richiedente());

				cell = row.createCell(3);

				// Oggetto
				cell.setCellValue(richiesta.getOggetto());

				cell = row.createCell(4);

				// Data
				cell.setCellValue(richiesta.getData());

				// Stato
				cell = row.createCell(5);

				cell.setCellValue(richiesta.getStato());

		
		
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

	public static void writeRichieste(List<ExcelBean> excelData, ResourceResponse resourceResponse) {

		try {

			// Create a new workbook
			Workbook workbook = new HSSFWorkbook();

				populateSheet(workbook, excelData, "elenco richiesta");

				workbook.write(resourceResponse.getPortletOutputStream());

				workbook.close();

			
		} catch (FileNotFoundException e) {
          _log.warn(e);
			
		} catch (IOException e) {
			   _log.warn(e);
			
		}

	}

}
