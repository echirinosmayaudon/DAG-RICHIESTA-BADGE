package mef.richieste.badge.util;

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

import mef.richieste.badge.bean.RichiestaBadgeExcelBean;


public class ExcelWriter {
	private static final Log _log = LogFactoryUtil.getLog(ExcelWriter.class);
	/*
	 * The below method is used to call write richieste method to create excel
	 * workbook, sheet and populate the sheet with data.
	 *
	 **/
	public static void writeRichiesteExcel(List<RichiestaBadgeExcelBean> excelData, ResourceResponse resourceResponse) {

		writeRichieste(excelData, resourceResponse);

	}

	/*
	 * The populate sheet method takes all the data in form a list of type
	 * ExcelBean. It creates row and cell and then populate all the data using
	 * that has been passed through list.
	 *
	 **/
	public static void populateSheet(Workbook workbook, List<RichiestaBadgeExcelBean> richieste, String sheetName) {
		// Create a new sheet

		Sheet sheet = workbook.createSheet(sheetName);
		Row header = sheet.createRow(0);
		
		Cell cell = header.createCell(0);
		cell.setCellValue("Id richiesta badge");
		
		cell = header.createCell(1);
		cell.setCellValue("Nome richiedente");
		
		cell = header.createCell(2);
		cell.setCellValue("Cognome richiedente");
		
		cell = header.createCell(3);
		cell.setCellValue("Dipartimento richiedente");
		
		cell = header.createCell(4);
		cell.setCellValue("Direzione richiedente");
		
		cell = header.createCell(5);
		cell.setCellValue("Ufficio richiedente");
		
		cell = header.createCell(6);
		cell.setCellValue("Telefono richiedente");
		
		cell = header.createCell(7);
		cell.setCellValue("Email richiedente");
		
		cell = header.createCell(8);
		cell.setCellValue("Data richiesta");

		cell = header.createCell(9);
		cell.setCellValue("Tipo richiesta");

		cell = header.createCell(10);
		cell.setCellValue("Stato richiesta");
		
		cell = header.createCell(11);
		cell.setCellValue("Dipartimento struttura richiedente");

		cell = header.createCell(12);
		cell.setCellValue("Direzione struttura richiedente");
		
		cell = header.createCell(13);
		cell.setCellValue("Ufficio struttura richiedente");
		
		cell = header.createCell(14);
		cell.setCellValue("Referente MEF");
		
		cell = header.createCell(15);
		cell.setCellValue("Telefono referente MEF");
		
		cell = header.createCell(16);
		cell.setCellValue("Email referente MEF");
		
		cell = header.createCell(17);
		cell.setCellValue("Nome intestatario");
		
		cell = header.createCell(18);
		cell.setCellValue("Cognome intestatario");
		
		cell = header.createCell(19);
		cell.setCellValue("CF intestatario");
		
		cell = header.createCell(20);
		cell.setCellValue("Luogo nascita intestatario");
		
		cell = header.createCell(21);
		cell.setCellValue("Data nascita intestatario");
		
		cell = header.createCell(22);
		cell.setCellValue("società");
		
		cell = header.createCell(23);
		cell.setCellValue("Sede legale società");
		
		cell = header.createCell(24);
		cell.setCellValue("Indirizzo ");
		
		cell = header.createCell(25);
		cell.setCellValue("Recapito telefonico società");
		
		cell = header.createCell(26);
		cell.setCellValue("Fax società");
		
		cell = header.createCell(27);
		cell.setCellValue("Pec società");
		
		cell = header.createCell(28);
		cell.setCellValue("Email società");
		
		cell = header.createCell(29);
		cell.setCellValue("Referente società");
		
		cell = header.createCell(30);
		cell.setCellValue("Email referente società");
		
		cell = header.createCell(31);
		cell.setCellValue("Telefono ufficio referente società");
		
		cell = header.createCell(32);
		cell.setCellValue("Cellulare referente società");
		
		cell = header.createCell(33);
		cell.setCellValue("Contratto");
		
		cell = header.createCell(34);
		cell.setCellValue("Progetto");
		
		cell = header.createCell(35);
		cell.setCellValue("Riga di piano");
		
		cell = header.createCell(36);
		cell.setCellValue("Postazione");
		
		cell = header.createCell(37);
		cell.setCellValue("Sedi abilitate");
		
		cell = header.createCell(38);
		cell.setCellValue("Data scadenza");
		
		cell = header.createCell(39);
		cell.setCellValue("Motivazione");
		
		cell = header.createCell(40);
		cell.setCellValue("Oggetto richiesta");
		
		cell = header.createCell(41);
		cell.setCellValue("Numero badge");
		
		cell = header.createCell(43);
		cell.setCellValue("Allegati");
		
		cell = header.createCell(44);
		cell.setCellValue("Note");
		

		// Create content rows
		if(richieste!=null && !richieste.isEmpty()){
		for (int i = 0; i < richieste.size(); i++) {
		
			RichiestaBadgeExcelBean richiesta = richieste.get(i);


				// Create content row
				Row row = sheet.createRow(i + 1);

				cell = row.createCell(0);
				cell.setCellValue(richiesta.getId_richiesta_badge());

				cell = row.createCell(1);
				cell.setCellValue(richiesta.getNome_richiedente());

				cell = row.createCell(2);
				cell.setCellValue(richiesta.getCognome_richiedente());

				cell = row.createCell(3);
				cell.setCellValue(richiesta.getDip_richiedente());
				
				cell = row.createCell(4);
				cell.setCellValue(richiesta.getDir_richiedente());
				
				cell = row.createCell(5);
				cell.setCellValue(richiesta.getUff_richiedente());
				
				cell = row.createCell(6);
				cell.setCellValue(richiesta.getTel_richiedente());
				
				cell = row.createCell(7);
				cell.setCellValue(richiesta.getEmail_richiedente());
				
				cell = row.createCell(8);
				cell.setCellValue(richiesta.getData_richiesta());

				cell = row.createCell(9);
				cell.setCellValue(richiesta.getTipo_richiesta());

				cell = row.createCell(10);
				cell.setCellValue(richiesta.getStato_richiesta());
				
				cell = row.createCell(11);
				cell.setCellValue(richiesta.getDipartimento());

				cell = row.createCell(12);
				cell.setCellValue(richiesta.getDirezione());
				
				cell = row.createCell(13);
				cell.setCellValue(richiesta.getUfficio());
				
				cell = row.createCell(14);
				cell.setCellValue(richiesta.getReferente_mef());
				
				cell = row.createCell(15);
				cell.setCellValue(richiesta.getTel_referente_mef());
				
				cell = row.createCell(16);
				cell.setCellValue(richiesta.getEmail_referente_mef());
				
				cell = row.createCell(17);
				cell.setCellValue(richiesta.getNome_int());
				
				cell = row.createCell(18);
				cell.setCellValue(richiesta.getCognome_int());
				
				cell = row.createCell(19);
				cell.setCellValue(richiesta.getCf_int());
				
				cell = row.createCell(20);
				cell.setCellValue(richiesta.getLuogo_nascita_int());
				
				cell = row.createCell(21);
				cell.setCellValue(richiesta.getData_nascita_int());
				
				cell = row.createCell(22);
				cell.setCellValue(richiesta.getSocieta());
				
				cell = row.createCell(23);
				cell.setCellValue(richiesta.getSede_legale_societa());
				
				cell = row.createCell(24);
				cell.setCellValue(richiesta.getIndirizzo());
				
				cell = row.createCell(25);
				cell.setCellValue(richiesta.getRecapito_tel());
				
				cell = row.createCell(26);
				cell.setCellValue(richiesta.getFax());
				
				cell = row.createCell(27);
				cell.setCellValue(richiesta.getPec());
				
				cell = row.createCell(28);
				cell.setCellValue(richiesta.getEmail());
				
				cell = row.createCell(29);
				cell.setCellValue(richiesta.getReferente_societa());
				
				cell = row.createCell(30);
				cell.setCellValue(richiesta.getEmail_referente_societa());
				
				cell = row.createCell(31);
				cell.setCellValue(richiesta.getTel_ufficio());
				
				cell = row.createCell(32);
				cell.setCellValue(richiesta.getCell());
				
				cell = row.createCell(33);
				cell.setCellValue(richiesta.getContratto());
				
				cell = row.createCell(34);
				cell.setCellValue(richiesta.getProgetto());
				
				cell = row.createCell(35);
				cell.setCellValue(richiesta.getPiano());
				
				cell = row.createCell(36);
				cell.setCellValue(richiesta.getPostazione());
				
				cell = row.createCell(37);
				cell.setCellValue(richiesta.getSedi());
				
				cell = row.createCell(38);
				cell.setCellValue(richiesta.getData_scadenza_badge());
				
				cell = row.createCell(39);
				cell.setCellValue(richiesta.getMotivazione());
				
				cell = row.createCell(40);
				cell.setCellValue(richiesta.getOggetto());
				
				cell = row.createCell(41);
				cell.setCellValue(richiesta.getNumero_badge());
				
				cell = row.createCell(43);
				cell.setCellValue(richiesta.getAllegati());
				
				cell = row.createCell(44);
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

	public static void writeRichieste(List<RichiestaBadgeExcelBean> excelData, ResourceResponse resourceResponse) {

		try {

			// Create a new workbook
			Workbook workbook = new HSSFWorkbook();

				populateSheet(workbook, excelData, "elenco richieste badge");

				workbook.write(resourceResponse.getPortletOutputStream());

				workbook.close();

			
		} catch (FileNotFoundException e) {
          _log.warn(e);
			
		} catch (IOException e) {
			   _log.warn(e);
			
		}

	}

}