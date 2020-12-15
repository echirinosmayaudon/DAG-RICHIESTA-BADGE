package mef.richieste.interventi.util;

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

import mef.richieste.interventi.beans.RichiestaInterventiBean;


public class ExcelWriter {
	
	final static Log _log = LogFactoryUtil.getLog(ExcelWriter.class);
	
	public static boolean writeRichiesteExcel(List<RichiestaInterventiBean> assetPc, List<RichiestaInterventiBean> software,List<RichiestaInterventiBean> hardware,
			List<RichiestaInterventiBean> postaElectronica,List<RichiestaInterventiBean> condivisioneStampanti,
			List<RichiestaInterventiBean> condivisioneDati,List<RichiestaInterventiBean> altro,List<RichiestaInterventiBean> richiesta, File file) {

		if (file != null) {
		
			return writeRichieste(assetPc,software,hardware,postaElectronica,condivisioneStampanti,condivisioneDati,altro,richiesta, file);
		}

		return false;
	}

	public static void populateSheet(Workbook workbook, List<RichiestaInterventiBean> richieste, String sheetName ){
		// Create a new sheet
		
		Sheet sheet = workbook.createSheet(sheetName);

			// Create header row
			Row header = sheet.createRow(0);
			Cell cell = header.createCell(0);
			
			if("assetPc".equals(sheetName)){
			
			// Code
			
			cell.setCellValue("Asset pc");

			// Tipo hardware asset pc
			cell = header.createCell(1);
			cell.setCellValue("Tipo hardware asset pc");

			// Marca
			cell = header.createCell(2);
			cell.setCellValue("Marca");
			//Modello
			cell = header.createCell(3);
			cell.setCellValue("Modello");

			}
			if("software".equals(sheetName))
			{

				cell.setCellValue("La richiesta");
			}	

			if("hardware".equals(sheetName))
			{
			
			cell.setCellValue("Tipo attivit\u00E0");
			//Tipologia Hardware
		    cell = header.createCell(1);
			cell.setCellValue("Tipo hardware");
			//Marca Modello Serie
			cell = header.createCell(2);
			cell.setCellValue("Marca Modello Numero Serie Hw");

			}	

			if("postaElectronica".equals(sheetName))
			{
			cell.setCellValue("Codice fiscale");

			// Tipo attività
			cell = header.createCell(1);
			cell.setCellValue("Tipo attivit\u00E0/");
			
			}	

			if("condivisioneStampanti".equals(sheetName))
			{
			cell.setCellValue("Di rete - asset stampante");
			

			//Locale - asset pc
			cell = header.createCell(1);
			cell.setCellValue("Locale - asset pc");
			
			//MARCA / MODELLO / NUMERO DI SERIE
			cell = header.createCell(2);
			cell.setCellValue("Marca / Modello / Numero di serie");
			
			//UBICAZIONE
			cell = header.createCell(3);
			cell.setCellValue("Ubicazione");
			
			}	

			if("condivisioneDati".equals(sheetName))
			{
			cell.setCellValue("Creazione nuova cartella condivisa sul server");
			
			//Condivisione cartella (già esistente) sul server
			cell = header.createCell(1);
			cell.setCellValue("Condivisione cartella (gi\u00E0/ esistente) sul server");
			
			//Utenti da abilitare in lettura
			cell = header.createCell(2);
			cell.setCellValue("Utenti da abilitare in lettura");
			
			//Utenti da abilitare in scrittura
			cell = header.createCell(3);
			cell.setCellValue("Utenti da abilitare in scrittura");
			
			}


			if("apparecchiatura".equals(sheetName))
			{
			cell.setCellValue("Spostamento apparecchiatura");
			
			//Ritiro apparecchiatura
			cell = header.createCell(1);
			cell.setCellValue("Ritiro apparecchiatura");
			
			//Abilitazione presa di rete
			cell = header.createCell(2);
			cell.setCellValue("Abilitazione presa di rete");
			
			}

			if("altro".equals(sheetName))
			{
			cell.setCellValue("La tua richiesta");
			
			}		
			// Create content rows
			if(richieste != null && !richieste.isEmpty()){
			 for (int i = 0; i < richieste.size(); i++) {
			
				RichiestaInterventiBean richiesta = richieste.get(i);

				if (richiesta != null && "assetPc".equals(sheetName) ) {
		
					// Create content row
					Row row = sheet.createRow(i + 1);

					// Asset pc
					cell = row.createCell(0);
			
					cell.setCellValue(richiesta.getAssetPc());

					// Tipologia hardware
					cell = row.createCell(1);
					
					cell.setCellValue(richiesta.getTipologiaHardware());

					// Marca
					cell = row.createCell(2);
		
					
					cell.setCellValue(richiesta.getMarca());
					
					//Modello
					cell = row.createCell(3);

					
					cell.setCellValue(richiesta.getModello());

				
				}
					
			if(richiesta != null && "software".equals(sheetName)){

					// Create content row
					Row row = sheet.createRow(i + 1);

					// Tipologia
					cell = row.createCell(0);
					cell.setCellValue(richiesta.getDescrizione());
			
			}
			if(richiesta != null && "hardware".equals(sheetName))
			{

					// Create content row
					Row row = sheet.createRow(i + 1);

					// Tipologia attività
					cell = row.createCell(0);
					cell.setCellValue(richiesta.getTipoAttivita());
					
					// Tipologia hardware
					cell = row.createCell(1);
					cell.setCellValue(richiesta.getTipologiaHardware());
					
					// Marca
					cell = row.createCell(2);
					cell.setCellValue(richiesta.getMarcaModelloNumeroSerieHw());
			
			
			}
			
			if(richiesta != null && "postaElectronica".equals(sheetName))
			{
	
					// Create content row
					Row row = sheet.createRow(i + 1);

					// Codice fiscale
					cell = row.createCell(0);
					cell.setCellValue(richiesta.getCodiceFiscale());
					
					// Tipo Attività
					cell = row.createCell(1);
					cell.setCellValue(richiesta.getTipoAttivita());
			
			}
			
			if(richiesta != null && "condivisioneStampanti".equals(sheetName))
			{
		
					// Create content row
					Row row = sheet.createRow(i + 1);

					// Di rete - asset stampante
					cell = row.createCell(0);
					cell.setCellValue(richiesta.getDiReteAssetStampante());
					
					// Locale - asset pc
					cell = row.createCell(1);
					cell.setCellValue(richiesta.getLocalAssetPc());
					
					// MARCA / MODELLO / NUMERO DI SERIE
					cell = row.createCell(2);
					cell.setCellValue(richiesta.getMarcaModelloNumeroSerie());
					
					// Ubicazione
					cell = row.createCell(3);
					cell.setCellValue(richiesta.getUbicazione());
			
			}
			
			
			if(richiesta != null && "condivisioneDati".equals(sheetName))
			{
			
					// Create content row
					Row row = sheet.createRow(i + 1);

					// Creazione nuova cartella condivisa sul server
					cell = row.createCell(0);
					cell.setCellValue(richiesta.getCreazioneCartella());
					
					// Condivisione cartella (già esistente) sul server
					cell = row.createCell(1);
					cell.setCellValue(richiesta.getCondivisioneCartella());
					
					// Utenti da abilitare in lettura
					cell = row.createCell(2);
					cell.setCellValue(richiesta.getAbilitareUtenteLettura());
					
					// Utenti da abilitare in scrittura
					cell = row.createCell(3);
					cell.setCellValue(richiesta.getAbilitareUtenteScrittura());
			
			}
			
			if(richiesta != null && "condivisioneDati".equals(sheetName))
			{

					// Create content row
					Row row = sheet.createRow(i + 1);

					// Creazione nuova cartella condivisa sul server
					cell = row.createCell(0);
					cell.setCellValue(richiesta.getCreazioneCartella());
					
					// Condivisione cartella (già esistente) sul server
					cell = row.createCell(1);
					cell.setCellValue(richiesta.getCondivisioneCartella());
					
					// Utenti da abilitare in lettura
					cell = row.createCell(2);
					cell.setCellValue(richiesta.getAbilitareUtenteLettura());
					
					// Utenti da abilitare in scrittura
					cell = row.createCell(3);
					cell.setCellValue(richiesta.getAbilitareUtenteScrittura());
			
			}
			
			if(richiesta != null && "apparecchiatura".equals(sheetName))
			{
	
					// Create content row
					Row row = sheet.createRow(i + 1);

					// Creazione nuova cartella condivisa sul server
					cell = row.createCell(0);
					cell.setCellValue(richiesta.getSpostamentoApparecchiatura());
					
					// Condivisione cartella (già esistente) sul server
					cell = row.createCell(1);
					cell.setCellValue(richiesta.getRitiroApparecchiatura());
					
					// Utenti da abilitare in lettura
					cell = row.createCell(2);
					cell.setCellValue(richiesta.getAbilitazionePresaRete());
			
			}
			
			
			if(richiesta != null && "altro".equals(sheetName))
			{
	
					// Create content row
					Row row = sheet.createRow(i + 1);

					// Dettaglio della richiesta
					cell = row.createCell(0);
					cell.setCellValue(richiesta.getDescrizione());
			
			}
				}
			}
			
		}
	

	public static boolean writeRichieste(List<RichiestaInterventiBean> assetPc, List<RichiestaInterventiBean> software,List<RichiestaInterventiBean> hardware,
			List<RichiestaInterventiBean> postaElectronica,List<RichiestaInterventiBean> condivisioneStampanti,
			List<RichiestaInterventiBean> condivisioneDati,List<RichiestaInterventiBean> altro,List<RichiestaInterventiBean> richiesta, File file) {

		if (file != null) {

			try {

				// Create a new workbook
				Workbook workbook = new HSSFWorkbook();
				
					if(!assetPc.isEmpty()){
				
						populateSheet(workbook,assetPc,"assetPc");	
					}
					if(!software.isEmpty())
					{
				
						populateSheet(workbook,software,"software");
					}
					if(!hardware.isEmpty()){
			
						populateSheet(workbook,hardware,"hardware");
					}
					if(!postaElectronica.isEmpty()){
				
						populateSheet(workbook,postaElectronica,"postaElectronica");	
					}
					if(!condivisioneStampanti.isEmpty()){
				
						populateSheet(workbook,condivisioneStampanti,"condivisioneStampanti");
					}
					if(!condivisioneDati.isEmpty()){
				
						populateSheet(workbook,condivisioneDati,"condivisioneDati");
					}
					if(!altro.isEmpty()){
				
						populateSheet(workbook,altro,"apparecchiatura");
					}
					if(!richiesta.isEmpty()){
				
						populateSheet(workbook,richiesta,"altro");
					}
										
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
