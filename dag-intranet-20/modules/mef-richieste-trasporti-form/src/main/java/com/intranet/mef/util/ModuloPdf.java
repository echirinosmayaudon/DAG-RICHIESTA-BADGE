package com.intranet.mef.util;

import com.intranet.mef.bean.ModuloRichiedente;
import com.intranet.mef.bean.Richiedente;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.mef.pdfbox.custom.PDFCustomGeneric;
import com.mef.pdfbox.custom.PDFCustomPageLayout;
import com.mef.pdfbox.custom.PDFCustomTable;
import com.mef.pdfbox.custom.PDFCustomTableCell;
import com.mef.pdfbox.custom.PDFCustomTableRow;
import com.mef.pdfbox.custom.PDFCustomText;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class ModuloPdf {
	final Log _log = LogFactoryUtil.getLog(ModuloPdf.class);

	private Richiedente richiedente;
	private ModuloRichiedente moduloRichiedente;

	private final int align = -1;
	private final PDType1Font fontFamily = PDType1Font.TIMES_ROMAN;
	private final PDType1Font fontFamilyBold = PDType1Font.TIMES_BOLD;

	private final int fontSizeMin = 5;

	private final int fontSizeHeader = 11;
	private final int fontSizeFields = 11;
	private final int checkTab = 5;
	private final String emptySpace = " ";

	public ModuloPdf(Richiedente richiedente, ModuloRichiedente moduloRichiedente) {
		this.moduloRichiedente = moduloRichiedente;
		this.richiedente = richiedente;
	}

	private void generateTextWithBorder(List<StringBuilder> text, PDFCustomGeneric pdfCustom) {
		List<PDFCustomTableRow> rows = new ArrayList<>();
		try {

			for (StringBuilder rowText : text) {
				PDFCustomTableCell cell;
				cell = new PDFCustomTableCell(rowText.toString(), fontFamily, fontSizeFields, false);

				cell.setBorder(false);
				cell.setUnderline(false);
				cell.setAlign(align);
				List<PDFCustomTableCell> cells = new ArrayList<PDFCustomTableCell>();
				cells.add(cell);
				PDFCustomTableRow row = new PDFCustomTableRow(cells, 1);
				rows.add(row);

			}
			PDFCustomTable table = new PDFCustomTable(rows);
			table.setBorder(true);
			pdfCustom.drawTablePDF(table);
		} catch (Exception e) {
			_log.warn(e);
		}
	}

	@SuppressWarnings("deprecation")
	public File drawPDFModulo(File temp) {
		try {
			
			PDFCustomGeneric pdfCustom = new PDFCustomGeneric(false);

			pdfCustom.setPageLayout(drawHeader(false));

			StringBuilder rowText = new StringBuilder();
			rowText.append("Il/La sottoscritto/a ");
			rowText.append(this.richiedente.getNome());
			rowText.append(emptySpace);
			rowText.append(this.richiedente.getCognome());

			pdfCustom.writeTextPDF(rowText.toString(), align, fontFamily, fontSizeFields);

			rowText = new StringBuilder();
			
			rowText.append("C.F. ");
			rowText.append(this.richiedente.getCodiceFiscale());
			rowText.append(" nato/a a ");
			rowText.append(this.richiedente.getLuogoNascita());
			rowText.append(" prov ");
			rowText.append(this.richiedente.getProvinciaNascita());
			rowText.append(" il ");
			rowText.append(this.richiedente.getDataNascita());
			pdfCustom.writeTextPDF(rowText.toString(), align, fontFamily, fontSizeFields);

			rowText = new StringBuilder();
			
			if ( this.richiedente.getCitta()!= null && !"".equals(this.richiedente.getCitta())) {
				rowText.append("Residente in ");
				rowText.append(this.richiedente.getCitta());
			}
			
			if (this.richiedente.getProvincia() != null && !"".equals(this.richiedente.getProvincia())) {
				rowText.append(" Prov. ");
				rowText.append(this.richiedente.getProvincia());
			}
			rowText.append(", ");
			rowText.append(this.richiedente.getIndirizzo());
			
			
			if (this.richiedente.getCap() != null && !"".equals(this.richiedente.getCap())) {
				rowText.append(" CAP ");
				rowText.append(this.richiedente.getCap());
			}
			pdfCustom.writeTextPDF(rowText.toString(), align, fontFamily, fontSizeFields);

			rowText = new StringBuilder();
			
			if (this.richiedente.getDipartimento() != null && !"".equals(this.richiedente.getDipartimento())) {
				rowText.append("In servizio presso ");
				rowText.append(this.richiedente.getDipartimento());
				rowText.append(", ");
			}
			
			
			if (this.richiedente.getFasciaEconomica() != null && !"".equals(this.richiedente.getFasciaEconomica())) {
				rowText.append("Area di appartenenza ");
				rowText.append(this.richiedente.getFasciaEconomica());
			}
			pdfCustom.writeTextPDF(rowText.toString(), align, fontFamily, fontSizeFields);

			pdfCustom.writeTextPDF(emptySpace, align, fontFamily, fontSizeMin);

			rowText = new StringBuilder();
			rowText.append("comandato/distaccato c/o M.E.F.");
			pdfCustom.drawTextWithCheck(rowText.toString(), align, fontFamily, fontSizeFields, checkTab, (richiedente.getComandato()!=null && ("COM_IN").equalsIgnoreCase(richiedente.getComandato())));

			rowText = new StringBuilder();
			rowText.append("comandato/distaccato presso altra amministrazione");
			pdfCustom.drawTextWithCheck(rowText.toString(), align, fontFamily, fontSizeFields, checkTab, (richiedente.getComandato()!=null && ("COM_OUT").equalsIgnoreCase(richiedente.getComandato())));

			rowText = new StringBuilder();
			rowText.append("assunto in servizio dal ");
			rowText.append(richiedente.getServizioDal());
			pdfCustom.drawTextWithCheck(rowText.toString(), align, fontFamily, fontSizeFields, checkTab, (richiedente.getServizioDal()!=null && !("").equals(richiedente.getServizioDal()) && !("COM_OUT").equalsIgnoreCase(richiedente.getComandato()) && !("COM_IN").equalsIgnoreCase(richiedente.getComandato()) ));

			rowText = new StringBuilder();

			
			if (this.richiedente.getTelefono() != null && !"".equals(this.richiedente.getTelefono())) {
				rowText.append("Telefono ufficio: ");
				rowText.append(this.richiedente.getTelefono());
				rowText.append(", ");
			}
			if (this.richiedente.getMail() != null && !"".equals(this.richiedente.getMail())) {
				rowText.append("email istituzionale: ");
				rowText.append(this.richiedente.getMail());
			}
			pdfCustom.writeTextPDF(rowText.toString(), align, fontFamily, fontSizeFields);

			
			rowText = new StringBuilder();
			if (moduloRichiedente.getIban() != null && !"".equals(moduloRichiedente.getIban())) {
				rowText.append("Codice IBAN: ");
				rowText.append(moduloRichiedente.getIban());
			}
			pdfCustom.writeTextPDF(rowText.toString(), align, fontFamily, fontSizeFields);
			
			
			
			pdfCustom.writeTextPDF(emptySpace);
			pdfCustom.writeTextPDF("CHIEDE", 0, fontFamilyBold, fontSizeFields);

			rowText = new StringBuilder();
			rowText.append("Il rimborso per le spese, pari ad euro ");
			rowText.append(this.moduloRichiedente.getImporto());
			rowText.append(", sostenute nell'anno ");

			Calendar prevYear = Calendar.getInstance();
			prevYear.add(Calendar.YEAR, -1);

			rowText.append(prevYear.get(Calendar.YEAR));
			rowText.append(", al netto di sconti fruiti avvalendosi di altre iniziative (es. Mobility Manager), per"
					+ " l'utilizzo dei mezzi di trasporto pubblico ai sensi dell'art. 3 e dell'art. 4 del vigente regolamento, acquistato:");
			pdfCustom.writeTextPDF(rowText.toString(), align, fontFamilyBold, fontSizeFields);
			pdfCustom.writeTextPDF(emptySpace, align, fontFamily, fontSizeMin);
			
			if (("personale").equalsIgnoreCase(moduloRichiedente.getFlagTipoSpesa())) {
				pdfCustom.drawTextWithCheck("Per s\u00E8", align, fontFamily, fontSizeFields, checkTab, true);
				pdfCustom.drawTextWithCheck("Per il/la figlio/a fiscalmente a carico", align, fontFamily,
						fontSizeFields, checkTab, false);

			} else {
				pdfCustom.drawTextWithCheck("Per s\u00E8", align, fontFamily, fontSizeFields, checkTab, false);
				pdfCustom.drawTextWithCheck("Per il/la figlio/a fiscalmente a carico", align, fontFamily,
						fontSizeFields, checkTab, true);

			}

			pdfCustom.writeTextPDF(emptySpace);

			rowText = new StringBuilder();
			rowText.append("Tali spese sono state sostenute:");
			pdfCustom.writeTextPDF(rowText.toString(), align, fontFamily, fontSizeFields);
			pdfCustom.writeTextPDF(emptySpace, align, fontFamily, fontSizeMin);

			rowText = new StringBuilder();
			List<StringBuilder> stringsBuilder = new ArrayList<>();
			if(!("personale").equalsIgnoreCase(moduloRichiedente.getFlagTipoSpesa())) {
				rowText.append("Figlio/a ");
				rowText.append(moduloRichiedente.getNomeFiglio());
				rowText.append(" ");
				rowText.append(moduloRichiedente.getCognomeFiglio());
				stringsBuilder.add(rowText);
				rowText = new StringBuilder();
				rowText.append("nato/a a ");
				rowText.append(moduloRichiedente.getLuogoNascitaFiglio());
				rowText.append(" il ");
				rowText.append(moduloRichiedente.getDataNascitaFiglio());
				rowText.append(" C.F. ");
				rowText.append(moduloRichiedente.getCfFiglio());
				stringsBuilder.add(rowText);
				rowText = new StringBuilder();
			}
			
			if(("mensile").equalsIgnoreCase(moduloRichiedente.getTipoViaggio())) {
				rowText.append("per n. ");
				rowText.append(moduloRichiedente.getNumeroViaggi());
				rowText.append(" titoli di viaggio personali con durata ");
				rowText.append(moduloRichiedente.getTipoViaggio());
				rowText.append(" a favore del/la ");
				if (("personale").equalsIgnoreCase(moduloRichiedente.getFlagTipoSpesa()))
					rowText.append("sottoscritto/a");
				else
					rowText.append("figlio/a");

			} else {
				rowText.append("per il titolo di viaggio personale con durata ");
				rowText.append(moduloRichiedente.getTipoViaggio());
				rowText.append(" acquistato il ");
				rowText.append(moduloRichiedente.getDataAcquistoViaggio());
				rowText.append(" a favore del/la ");
				if (("personale").equalsIgnoreCase(moduloRichiedente.getFlagTipoSpesa()))
					rowText.append("sottoscritto/a");
				else
					rowText.append("figlio/a");
			}

			stringsBuilder.add(rowText);
			generateTextWithBorder(stringsBuilder, pdfCustom);
			
			
		
			if (moduloRichiedente.getAllegato() != null && moduloRichiedente.getAllegatoNome()!=null) {
				rowText = new StringBuilder();
				rowText.append("file allegato alla richiesta:");
				List<StringBuilder> stringsBuilderAllegato = new ArrayList<>();
				stringsBuilderAllegato.add(rowText);

				rowText = new StringBuilder();
				rowText.append(moduloRichiedente.getAllegatoNome());
				stringsBuilderAllegato.add(rowText);

				generateTextWithBorder(stringsBuilderAllegato, pdfCustom);
			}
			
			if (moduloRichiedente.getDescrizione() != null && ! ("").equals(moduloRichiedente.getDescrizione())) {
				rowText = new StringBuilder();
				rowText.append("Note");
				List<StringBuilder> stringsBuilderNote = new ArrayList<>();
				stringsBuilderNote.add(rowText);

				rowText = new StringBuilder();
				rowText.append(moduloRichiedente.getDescrizione());
				stringsBuilderNote.add(rowText);

				generateTextWithBorder(stringsBuilderNote, pdfCustom);
			}

			pdfCustom.writeTextPDF(emptySpace);
			createCustomTextWithCheck(pdfCustom);
			
			
			rowText = new StringBuilder();
			rowText.append(
					"Dichiara che la somma per la quale si richiede il rimborso \u00E8 quella effettivamente corrisposta all'ente gestore del   servizio di trasporto (al netto di eventuali sconti percepiti in forza di altre iniziative, come quella del Mobility Manager).");
			pdfCustom.drawTextWithCheck(rowText.toString(), align, fontFamily, fontSizeFields, 0, true);
			
			
			
			
			
			rowText = new StringBuilder();
			rowText.append(
					"Ai sensi dell'art.13 del Reg. UE n. 2016/679(GDPR) si informa che i dati personali forniti dall'interessato saranno   trattati dalla Direzione del personale esclusivamente ai fini dell'istruttoria necessaria per procedere al rimborso. Per le ulteriori informazioni, si rinvia alla privacy policy del MEF, rinvenibile al seguente link: https://intranet.mef.gov.it/group/guest/privacy1.");

			pdfCustom.drawTextWithCheck(rowText.toString(), align, fontFamily, fontSizeFields, 0, true);

			pdfCustom.close(temp);
			return temp;
		} catch (Exception e) {
			_log.warn(e);
		}
		return null;

	}

	
	
	
	private void createCustomTextWithCheck(PDFCustomGeneric pdfCustom) {
		int tab = 0;
		PDFCustomText textNormal = new PDFCustomText();
		textNormal.setFontFamily(fontFamily);
		textNormal.setFontSize(fontSizeFields);
		textNormal.setText("Dichiara, sotto la propria responsabilit\u00E0 anche ai sensi" + " del d.P.R. n. 445/2000, ");

		PDFCustomText textBold = new PDFCustomText();
		textBold.setFontFamily(fontFamilyBold);
		textBold.setFontSize(fontSizeFields);
		textBold.setText("che la documentazione inviata \u00E8  conforme all'originale");
		textBold.setUnderline(true);

		PDFCustomText textFinal = new PDFCustomText();
		textFinal.setFontFamily(fontFamily);
		textFinal.setFontSize(fontSizeFields);
		textFinal.setText(
				" dallo stesso conservata e che non sono stati percepiti ulteriori rimborsi per la spesa sostenuta a corredo"
						+ " della presente istanza e che non inoltrer\u00E0 analoga richiesta presso altre Amministrazioni, Enti, Societ\u00E0 o Associazioni.");

		List<PDFCustomText> customText = new ArrayList<>();
		customText.add(textNormal);
		customText.add(textBold);
		customText.add(textFinal);

		try {
			PDFCustomTableCell cellCustom = new PDFCustomTableCell(customText);
			List<PDFCustomTableCell> cellsCustom = new ArrayList<>();
			cellCustom.setAlign(align);
			cellCustom.setWidth(80);
			cellCustom.setBorder(false);
			cellsCustom.add(cellCustom);

			PDFCustomTableCell cellEmpty = new PDFCustomTableCell(" ", fontFamily, fontSizeFields, false);
			cellEmpty.setAlign(align);
			cellEmpty.setWidth(1);
			cellsCustom.add(cellEmpty);
			PDFCustomTableCell cellCheck = new PDFCustomTableCell("X", fontFamily, fontSizeFields, true);
			cellCheck.setAlign(align);
			cellCheck.setWidth(0); 
			cellCheck.setSelfHeight(true);
			cellsCustom.add(cellCheck);

			if (tab > 0) {
				PDFCustomTableCell cellTab = new PDFCustomTableCell(" ", fontFamily, fontSizeFields, false);
				cellTab.setWidth(tab * 0.5f);
				cellTab.setBorder(false);
				cellsCustom.add(cellTab);
			}

			PDFCustomTableRow row = new PDFCustomTableRow(cellsCustom, 1);
			List<PDFCustomTableRow> rows = new ArrayList<>();
			row.setCheckText(true);
			rows.add(row);
			PDFCustomTable table = new PDFCustomTable(rows);
			table.setBorder(true);
			table.setBorderVisible(false);
			table.setBorderY(2);
			table.setBorderX(0);
			pdfCustom.drawTablePDF(table);

		} catch (Exception e) {
			_log.warn(e);
		}
	}

	private PDFCustomPageLayout drawHeader(boolean flagRotate) {
		String textHeaderLX = "MODELLO A)";
		String textHeaderCX = "MODELLO DI DOMANDA";

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String data = sdf.format(date);
		StringBuilder textHeaderDXBuilder = new StringBuilder();
		textHeaderDXBuilder.append("Data invio istanza: ");
		textHeaderDXBuilder.append(data);
		String textHeaderDX = textHeaderDXBuilder.toString();

		String textBodyDX = "Al Dipartimento dell'Amministrazione Generale, del"
				+ " personale e dei servizi Direzione del personale - Ufficio I";

		String temp;

		try {
			if (!flagRotate) {
				temp = textHeaderLX;
				textHeaderLX = textHeaderDX;
				textHeaderDX = temp;
			}
			List<PDFCustomTableCell> cellsLayoutHeader = new ArrayList<>();
			PDFCustomTableCell cellLeft;

			cellLeft = new PDFCustomTableCell(textHeaderDX, fontFamilyBold, fontSizeHeader, false);
			cellLeft.setBorder(false);
			cellLeft.setUnderline(false);

			cellLeft.setAlign(-1);

			PDFCustomTableCell cellRight = new PDFCustomTableCell(textHeaderLX, fontFamily, fontSizeHeader, false);

			cellRight.setAlign(-1);

			cellRight.setBorder(false);

			cellsLayoutHeader.add(cellRight);
			PDFCustomTableCell cellCenter = new PDFCustomTableCell(textHeaderCX, fontFamilyBold, fontSizeHeader, false);
			cellsLayoutHeader.add(cellCenter);
			cellsLayoutHeader.add(cellLeft);

			PDFCustomTableCell cellSpace = new PDFCustomTableCell(" ", fontFamily, fontSizeHeader, false);
			cellRight.setBorder(false);

			List<PDFCustomTableCell> cellsSpace = new ArrayList<>();
			cellsSpace.add(cellSpace);

			List<PDFCustomTableRow> rowsHeaderLayout = new ArrayList<>();
			rowsHeaderLayout.add(new PDFCustomTableRow(cellsLayoutHeader, 1));
			rowsHeaderLayout.add(new PDFCustomTableRow(cellsSpace, 1));

			List<PDFCustomTableCell> cellsBody = new ArrayList<>();
			PDFCustomTableCell cellBodyDx = new PDFCustomTableCell(textBodyDX, fontFamily, fontSizeHeader, false);
			if (flagRotate)
				cellBodyDx.setAlign(1);
			else
				cellBodyDx.setAlign(-1);
			cellsBody.add(cellBodyDx);
			cellsBody.add(cellSpace);
			cellsBody.add(cellSpace);

			rowsHeaderLayout.add(new PDFCustomTableRow(cellsBody, 1));
			rowsHeaderLayout.add(new PDFCustomTableRow(cellsSpace, 1));
			rowsHeaderLayout.add(new PDFCustomTableRow(cellsSpace, 1));

			PDFCustomTable tableHeader = new PDFCustomTable(rowsHeaderLayout, null);
			tableHeader.setBorder(false);
			PDFCustomPageLayout pageLayout = new PDFCustomPageLayout(tableHeader, null);
			pageLayout.setOffsetDown(20);
			pageLayout.setOffsetUp(20);
			pageLayout.setOffsetLeft(30);
			pageLayout.setOffsetRight(30);
			pageLayout.setFlagNumberPage(false);

			return pageLayout;
		} catch (Exception e) {
			_log.warn(e);
		}
		return null;
	}

}
