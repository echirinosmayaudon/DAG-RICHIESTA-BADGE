package mef.richieste.beni.facili.excel;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.mef.beni.facili.consumo.stub.ExcelDati;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.portlet.ResourceResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;


import mef.richieste.beni.facili.excel.ExcelStyle;

public class ExcelWriter {

	private static final Log _log = LogFactoryUtil.getLog(ExcelWriter.class);
	public static void writeRichiesteExcel(List<ExcelDati> excelDatiStub, ExcelDati datiStub,
			ResourceResponse resourceResponse) throws FileNotFoundException {

		writeModule(excelDatiStub, datiStub, resourceResponse);

	}

	/*
	 * the method below should be decommented when we have mail system to attach
	 * an excel
	 */
	public static boolean writeRichiesteExcel(List<ExcelDati> excelDatiStub, ExcelDati datiStub, File file)
			throws FileNotFoundException {

		if (file != null) {

			return writeModule(excelDatiStub, datiStub, file);
		}

		return false;
	}

	public static void populateSheet(Workbook workbook, String sheetName, List<ExcelDati> richieste,
			ExcelDati excelDati) {

		Sheet sheet = workbook.createSheet(sheetName);
		/* Setting default width for Column A , C, D and F */
		sheet.setColumnWidth(0, 8900);
		sheet.setColumnWidth(2, 8900);
		sheet.setColumnWidth(3, 6900);
		sheet.setColumnWidth(5, 7900);

		ExcelStyle excelStyle = new ExcelStyle();

		/*
		 * styleObj is an object that has been used for getting style for cell
		 * of header for example headers like Name etc and we need background ,
		 * font and border
		 **/

		CellStyle styleObj = workbook.createCellStyle();

		/*
		 * styleCell is an object that has been used for getting style for cell
		 * which contains value and where we only need border
		 **/

		workbook.createCellStyle();

		/*
		 * font is an object that has been used for getting font for cell
		 **/
		 workbook.createFont();

		 Font font = excelStyle.CellFont("red", workbook);

		if (sheet != null) {

			/*
			 * rowNumber is a variable that is incremented each time a new is
			 * created
			 */
			int rowNumber = 0;

			/* Cell and row for the header with red font */
			Row header = sheet.createRow(rowNumber);
			/*
			 * sheet addMergedRegion is used for merging desire columns and rows
			 */
			sheet.addMergedRegion(new CellRangeAddress(rowNumber, // first row
																	// (0-based)
					rowNumber, // last row (0-based)
					0, // first column (0-based)
					5 // last column (0-based)
			));

			styleObj.setFont(font);
			CellStyle stylingHeader = workbook.createCellStyle();
			stylingHeader.cloneStyleFrom(styleObj);

			// Header Consegnatario con indirizzo

			/*
			 * CellUtil is used to create a cell with header as name of the row
			 * , excelDati.getHeader() as values we want in cell and
			 * stylingHeader for having style on that cell it is used for
			 * aligning the text in center of the merged cell and having text in
			 * center has been done by using setAlignment
			 **/

			Cell cellCenter = CellUtil.createCell(header, 0, excelDati.getHeader(), stylingHeader);
			CellUtil.setAlignment(cellCenter, HorizontalAlignment.CENTER);

			/*
			 * Cell and rows where we have informazione di ritiro , sostutizione
			 * and their timing
			 */

			/*
			 * Vertical Text is a method in excel style class for wraping the
			 * text to display it in vertical form all 4 of the cell below use
			 * the same object which contains the style of vertical text
			 **/

			styleObj = excelStyle.verticalText(workbook);
			rowNumber = rowNumber + 2;
			Row rowInformzaioneRitiro = sheet.createRow(rowNumber);

			Cell informzaioneRitiroCell = rowInformzaioneRitiro.createCell(0);
			informzaioneRitiroCell.setCellStyle(styleObj);
			informzaioneRitiroCell.setCellValue(excelDati.getAddress());

			Cell informzaioneRitiroTimeCell = rowInformzaioneRitiro.createCell(2);
			informzaioneRitiroTimeCell.setCellStyle(styleObj);
			informzaioneRitiroTimeCell.setCellValue(excelDati.getRitiroTime());

			rowNumber = rowNumber + 1;
			Row rowSostituzioneProdotti = sheet.createRow(rowNumber);

			Cell sostituzioneProdottiCell = rowSostituzioneProdotti.createCell(0);
			sostituzioneProdottiCell.setCellStyle(styleObj);
			sostituzioneProdottiCell.setCellValue(excelDati.getSostituireInformation());

			Cell sostituzioneProdottiTimeCell = rowSostituzioneProdotti.createCell(2);
			sostituzioneProdottiTimeCell.setCellStyle(styleObj);
			sostituzioneProdottiTimeCell.setCellValue(excelDati.getSostituireTime());

			rowNumber = rowNumber + 2;
			sheet.addMergedRegion(new CellRangeAddress(rowNumber, // first row
																	// (0-based)
					rowNumber, // last row (0-based)
					0, // first column (0-based)
					5 // last column (0-based)
			));

			/*
			 * CellDesign is method in excel style that can be used for having
			 * style like background , border and font(white) CellDesign(boolean
			 * background,boolean border,workbook) we can set true or false for
			 * our need
			 */

			styleObj = excelStyle.cellDesign(true, true, workbook);

			CellStyle stylingRichiedenteHeader = workbook.createCellStyle();

			stylingRichiedenteHeader.cloneStyleFrom(styleObj);

			Row rowHeaderRichiedente = sheet.createRow(rowNumber);

			Cell cellCenterRichiedente = CellUtil.createCell(rowHeaderRichiedente, 0, "Richiedente",
					stylingRichiedenteHeader);

			CellUtil.setAlignment(cellCenterRichiedente, HorizontalAlignment.CENTER);

			/* the for below is used for the cell where we need to add border */

			for (int i = 1; i <= 5; i++) {
				workbook.createCellStyle();
				Cell headerRichiedenteEmpty = rowHeaderRichiedente.createCell(i);
				CellStyle headerRichiedenteEmptyStyle = excelStyle.borderStyling("", "", "top", "bottom", workbook);				
				if (i == 5) {
					headerRichiedenteEmptyStyle = excelStyle.borderStyling("right", "", "top", "bottom", workbook);
				} 
				headerRichiedenteEmpty.setCellStyle(headerRichiedenteEmptyStyle);

			}
			/*
			 * Cell and rows for name , surname , dipartment , direzione , scala
			 * , telephone, email , attuale ubicazione , piano and stanza
			 */
			CellStyle styleCell = excelStyle.cellDesign(false, true, workbook);
			rowNumber = rowNumber + 1;

			Row rowDipartimentoOrganizzazione = sheet.createRow(rowNumber);
			
			Cell organizzazioneCell = rowDipartimentoOrganizzazione.createCell(0);
			organizzazioneCell.setCellStyle(styleObj);
			organizzazioneCell.setCellValue("Organizzazione");

			Cell organizzazioneValueCell = rowDipartimentoOrganizzazione.createCell(1);
			CellStyle organizzazioneStyle = workbook.createCellStyle();
			organizzazioneStyle.cloneStyleFrom(styleCell);
			organizzazioneValueCell.setCellStyle(organizzazioneStyle);
			organizzazioneValueCell.setCellValue(excelDati.getOrganizzazione());

			Cell DipartimentoCell = rowDipartimentoOrganizzazione.createCell(2);
			DipartimentoCell.setCellStyle(styleObj);
			DipartimentoCell.setCellValue("Dipartimento");

			Cell dipartimentoValueCell = rowDipartimentoOrganizzazione.createCell(3);
			CellStyle dipartimentoStyle = workbook.createCellStyle();
			dipartimentoStyle.cloneStyleFrom(styleCell);
			dipartimentoValueCell.setCellStyle(dipartimentoStyle);
			dipartimentoValueCell.setCellValue(excelDati.getDipartimento());
			
			rowNumber = rowNumber + 1;
			
			Row rowDirezioneUfficio = sheet.createRow(rowNumber);
			
			Cell direzioneCell = rowDirezioneUfficio.createCell(0);
			direzioneCell.setCellStyle(styleObj);
			direzioneCell.setCellValue("Direzione");

			Cell direzioneValueCell = rowDirezioneUfficio.createCell(1);
			CellStyle direzioneStyle = workbook.createCellStyle();
			direzioneStyle.cloneStyleFrom(styleCell);
			direzioneValueCell.setCellStyle(direzioneStyle);
			direzioneValueCell.setCellValue(excelDati.getDirezione());

			Cell ufficioCell = rowDirezioneUfficio.createCell(2);
			ufficioCell.setCellStyle(styleObj);
			ufficioCell.setCellValue("Ufficio");

			Cell ufficioValueCell = rowDirezioneUfficio.createCell(3);
			CellStyle ufficioStyle = workbook.createCellStyle();
			ufficioStyle.cloneStyleFrom(styleCell);
			ufficioValueCell.setCellStyle(ufficioStyle);
			ufficioValueCell.setCellValue(excelDati.getUfficio());

			rowNumber = rowNumber + 1;

			Row rowNomeCognome = sheet.createRow(rowNumber);

			Cell nomeCell = rowNomeCognome.createCell(0);
			nomeCell.setCellStyle(styleObj);
			nomeCell.setCellValue("Nome");

			Cell nomeValueCell = rowNomeCognome.createCell(1);
			CellStyle styleNome = workbook.createCellStyle();
			styleNome.cloneStyleFrom(styleCell);
			nomeValueCell.setCellStyle(styleNome);
			nomeValueCell.setCellValue(excelDati.getNome());

			Cell cognomeCell = rowNomeCognome.createCell(2);
			cognomeCell.setCellStyle(styleObj);
			cognomeCell.setCellValue("Cognome");

			Cell cognomeValueCell = rowNomeCognome.createCell(3);
			CellStyle styleCognome = workbook.createCellStyle();
			styleCognome.cloneStyleFrom(styleCell);
			cognomeValueCell.setCellStyle(styleCognome);
			cognomeValueCell.setCellValue(excelDati.getCognome());

			Cell emailCell = rowNomeCognome.createCell(4);
			emailCell.setCellStyle(styleObj);
			emailCell.setCellValue("Email");

			Cell emailValueCell = rowNomeCognome.createCell(5);
			emailValueCell.setCellValue(excelDati.getEmail());
			CellStyle emailStyle = workbook.createCellStyle();
			emailStyle.cloneStyleFrom(styleCell);
			emailValueCell.setCellStyle(emailStyle);

			rowNumber = rowNumber + 1;

			Row rowTelefoneUbicazione = sheet.createRow(rowNumber);

			Cell telefoneCell = rowTelefoneUbicazione.createCell(0);
			telefoneCell.setCellStyle(styleObj);
			telefoneCell.setCellValue("Telefono");

			Cell telefoneValueCell = rowTelefoneUbicazione.createCell(1);
			CellStyle telefoneStyle = workbook.createCellStyle();
			telefoneStyle.cloneStyleFrom(styleCell);
			telefoneValueCell.setCellStyle(telefoneStyle);
			telefoneValueCell.setCellValue(excelDati.getTelefono());

			Cell ubicazioneCell = rowTelefoneUbicazione.createCell(2);
			ubicazioneCell.setCellStyle(styleObj);
			ubicazioneCell.setCellValue("Attuale ubicazione");

			Cell ubicazioneValueCell = rowTelefoneUbicazione.createCell(3);
			workbook.createCellStyle();
			CellStyle ubicazioneStyle = excelStyle.borderStyling("", "", "top", "bottom", workbook);
			ubicazioneValueCell.setCellStyle(ubicazioneStyle);
			ubicazioneValueCell.setCellValue(excelDati.getAttualeUbicazione());
			sheet.addMergedRegion(new CellRangeAddress(rowNumber, // first row
																	// (0-based)
					rowNumber, // last row (0-based)
					3, // first column (0-based)
					5 // last column (0-based)
			));

			for (int j = 4; j <= 5; j++) {
				workbook.createCellStyle();
				Cell  ubicazioneEmpty = rowTelefoneUbicazione.createCell(j);
				CellStyle ubicazioneEmptyStyle = excelStyle.borderStyling("", "", "top", "bottom", workbook);
				if (j == 5) {
					ubicazioneEmptyStyle = excelStyle.borderStyling("right", "", "top", "bottom", workbook);
				} 
				ubicazioneEmpty.setCellStyle(ubicazioneEmptyStyle);

			}

			rowNumber = rowNumber + 1;

			Row rowPianoStanza = sheet.createRow(rowNumber);

			Cell pianoCell = rowPianoStanza.createCell(0);
			pianoCell.setCellStyle(styleObj);
			pianoCell.setCellValue("Piano");

			Cell pianoValueCell = rowPianoStanza.createCell(1);
			CellStyle StylePiano = workbook.createCellStyle();
			StylePiano.cloneStyleFrom(styleCell);
			pianoValueCell.setCellStyle(StylePiano);
			pianoValueCell.setCellValue(excelDati.getPiano());

			Cell scalaCell = rowPianoStanza.createCell(2);
			scalaCell.setCellStyle(styleObj);
			scalaCell.setCellValue("Scala");

			Cell scalaValueCell = rowPianoStanza.createCell(3);
			CellStyle styleScala = workbook.createCellStyle();
			styleScala.cloneStyleFrom(styleCell);
			scalaValueCell.setCellStyle(styleScala);
			scalaValueCell.setCellValue(excelDati.getScala());

			Cell stanzaCell = rowPianoStanza.createCell(4);
			CellStyle styleStanza = workbook.createCellStyle();
			styleStanza.cloneStyleFrom(styleObj);
			stanzaCell.setCellStyle(styleStanza);
			stanzaCell.setCellValue("Stanza");

			Cell stanzaValueCell = rowPianoStanza.createCell(5);
			stanzaValueCell.setCellValue(excelDati.getStanza());
			CellStyle styleLineStanza = workbook.createCellStyle();
			styleLineStanza.cloneStyleFrom(styleCell);
			stanzaValueCell.setCellStyle(styleLineStanza);

			rowNumber = rowNumber + 2;
			sheet.addMergedRegion(new CellRangeAddress(rowNumber, // first row
																	// (0-based)
					rowNumber, // last row (0-based)
					0, // first column (0-based)
					5 // last column (0-based)
			));

			workbook.createCellStyle();
			CellStyle styleRichiestaHeader = styleObj;
			Row rowList = sheet.createRow(rowNumber);

			Cell cellCenterRichiesta = CellUtil.createCell(rowList, 0, "Richiesta", styleRichiestaHeader);
			CellUtil.setAlignment(cellCenterRichiesta, HorizontalAlignment.CENTER);

			for (int i = 1; i <= 5; i++) {
				 workbook.createCellStyle();
				CellStyle headerRichiestaEmptyStyle = excelStyle.borderStyling("", "", "top", "bottom", workbook);
				Cell headerRichiestaEmpty = rowList.createCell(i);
				if (i == 5) {
					headerRichiestaEmptyStyle = excelStyle.borderStyling("right", "", "top", "bottom", workbook);
				} 
				headerRichiestaEmpty.setCellStyle(headerRichiestaEmptyStyle);

			}
			/*
			 * Cells and rows for list of the material , sotto gruppo , oggetto
			 * , gruppo
			 */
			rowNumber = rowNumber + 1;

			Row rowTitle = sheet.createRow(rowNumber);

			Cell oggettoCell = rowTitle.createCell(0);
			oggettoCell.setCellStyle(styleObj);
			oggettoCell.setCellValue("Oggetto");
			oggettoCell.setCellValue("Costo Unitario");

			Cell gruppoCell = rowTitle.createCell(1);
			gruppoCell.setCellStyle(styleObj);
			gruppoCell.setCellValue("Gruppo");

			Cell sottoGruppoCell = rowTitle.createCell(2);
			sottoGruppoCell.setCellStyle(styleObj);
			sottoGruppoCell.setCellValue("Sotto Gruppo");

			Cell materialeCell = rowTitle.createCell(3);
			materialeCell.setCellStyle(styleObj);
			materialeCell.setCellValue("Materiale");

			Cell quantitaCell = rowTitle.createCell(4);
			quantitaCell.setCellStyle(styleObj);
			quantitaCell.setCellValue("Quantit");

			CellStyle cellStyle = workbook.createCellStyle();
			cellStyle.cloneStyleFrom(styleCell);

			int i = rowNumber;

			for (ExcelDati excelDatiList : richieste) {

				if (richieste != null) {
					i = i + 1;
					Row row = sheet.createRow(i);

					Cell cell = row.createCell(0);

					cell.setCellStyle(cellStyle);
					cell.setCellValue(excelDatiList.getOggetto());

					cell = row.createCell(1);
					cell.setCellStyle(cellStyle);
					cell.setCellValue(excelDatiList.getGruppo());

					cell = row.createCell(2);
					cell.setCellStyle(cellStyle);
					cell.setCellValue(excelDatiList.getSottogruppo());

					cell = row.createCell(3);
					cell.setCellStyle(cellStyle);
					cell.setCellValue(excelDatiList.getMateriale());

					cell = row.createCell(4);
					cell.setCellStyle(cellStyle);
					cell.setCellValue(excelDatiList.getQuantita());

					rowNumber = i;

				}

			}

			rowNumber = rowNumber + 1;
			sheet.addMergedRegion(new CellRangeAddress(rowNumber, // first row
																	// (0-based)
					rowNumber, // last row (0-based)
					0, // first column (0-based)
					5 // last column (0-based)
			));

			/* Cell and row for Ubicazione per consegna/sostituzione prodotti */

			Row rowUbicazioneHeader = sheet.createRow(rowNumber);
			 workbook.createCellStyle();
			 CellStyle rowubicazioneHeaderStyle = excelStyle.cellDesign(true, false, workbook);

			Cell cellCenterUbicazione = CellUtil.createCell(rowUbicazioneHeader, 0,
					"Ubicazione per consegna/sostituzione prodotti", rowubicazioneHeaderStyle);
			CellUtil.setAlignment(cellCenterUbicazione, HorizontalAlignment.CENTER);

			rowNumber = rowNumber + 1;
			sheet.addMergedRegion(new CellRangeAddress(rowNumber, // first row
																	// (0-based)
					rowNumber, // last row (0-based)
					0, // first column (0-based)
					5 // last column (0-based)
			));
			Row rowUbicazioneHeaderValue = sheet.createRow(rowNumber);
			Cell ubicazioneHeaderValueCell = rowUbicazioneHeaderValue.createCell(0);
			ubicazioneHeaderValueCell.setCellValue(excelDati.getUbicazione());

		}
	}

	public static void writeModule(List<ExcelDati> excelDatistub, ExcelDati excelStub,
			ResourceResponse resourceResponse) {

		try {

			// Create a new workbook
			Workbook workbook = new HSSFWorkbook();

			

				populateSheet(workbook, "beni consumo", excelDatistub, excelStub);

				workbook.write(resourceResponse.getPortletOutputStream());

				workbook.close();

		
		} catch (FileNotFoundException e) {

			_log.error(e);
		} catch (IOException e) {

			_log.error(e);
		}

	}

	public static boolean writeModule(List<ExcelDati> excelDatistub, ExcelDati excelStub, File file) {

		try {

			Workbook workbook = new HSSFWorkbook();

			

				 populateSheet(workbook, "beni consumo", excelDatistub,
				 excelStub);

				FileOutputStream fileOutputStream = new FileOutputStream(file);

				workbook.write(fileOutputStream);

				workbook.close();

				return true;
			
		} catch (FileNotFoundException e) {

			_log.error(e);
		} catch (IOException e) {

			_log.error(e);
		}

		return false;
	}

}