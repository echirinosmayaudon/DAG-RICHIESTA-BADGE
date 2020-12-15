package mef.whistleblowing.form.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.mef.pdfbox.custom.PDFCustomGeneric;
import com.mef.pdfbox.custom.PDFCustomPageLayout;
import com.mef.pdfbox.custom.PDFCustomTable;
import com.mef.pdfbox.custom.PDFCustomTableCell;
import com.mef.pdfbox.custom.PDFCustomTableRow;
import com.mef.pdfbox.custom.PDFCustomText;

import java.awt.Color;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.pdfbox.pdmodel.font.PDType1Font;

import mef.whistleblowing.form.beans.Richiedente;
import mef.whistleblowing.form.beans.Segnalazione;

public class ModuloPdf {
	final Log _log = LogFactoryUtil.getLog(ModuloPdf.class);

	private Richiedente segnalante;
	private Segnalazione segnalazione;

	private final PDType1Font fontFamily = PDType1Font.TIMES_ROMAN;
	private final PDType1Font fontFamilyBold = PDType1Font.TIMES_BOLD;

	private final int fontSizeHeader = 11;

	public ModuloPdf(Richiedente segnalante, Segnalazione segnalazione) {
		this.segnalante = segnalante;
		this.segnalazione = segnalazione;
	}

	private PDFCustomTableRow getRowSpace() {
		try {
			List<PDFCustomTableCell> cells = new ArrayList<PDFCustomTableCell>();
			List<PDFCustomText> customTexts = new ArrayList<PDFCustomText>();

			PDFCustomTableCell cell;
			PDFCustomText customText = new PDFCustomText();
			customText.setText(" ");
			customText.setFontSize(3);

			customTexts.add(customText);

			cell = new PDFCustomTableCell(customTexts);
			cell.setBorder(false);
			cells.add(cell);
			return new PDFCustomTableRow(cells, 1);

		} catch (Exception e) {

			_log.warn(e);
			return null;
		}
	}

	private PDFCustomTableRow getRow(String sx, String dx) {
		try {
			List<PDFCustomTableCell> cells = new ArrayList<PDFCustomTableCell>();
			List<PDFCustomText> customTexts = new ArrayList<PDFCustomText>();

			PDFCustomTableCell cell;
			PDFCustomText customText = new PDFCustomText();

			customText.setText(dx);
			customText.setBackgroundColor(Color.GRAY);
			customText.setFontSize(12);
			
			customTexts.add(customText);

			cell = new PDFCustomTableCell(customTexts);
			cell.setBackground(true);

			cell.setBackgroundColor(Color.LIGHT_GRAY);
			cell.setBorder(false);
			cell.setAlign(-1);
			cells.add(cell);

			customText = new PDFCustomText();
			customTexts = new ArrayList<PDFCustomText>();

			customText.setText(sx);
			customText.setBackgroundColor(Color.GRAY);
			customText.setFontSize(8);
			customText.setUnderline(true);

			customTexts.add(customText);
			cell = new PDFCustomTableCell(customTexts);
			cell.setBackground(true);
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			cell.setBorder(false);
			cell.setAlign(-1);
			cells.add(cell);

			return new PDFCustomTableRow(cells, 1);

		} catch (Exception e) {

			_log.warn(e);
			return null;
		}

	}

	@SuppressWarnings("deprecation")
	public File drawPDFModulo(File temp) {
		try {

			PDFCustomGeneric pdfCustom = new PDFCustomGeneric(false);

			pdfCustom.setPageLayout(drawHeader(false));

			pdfCustom.writeTextPDF("Modello per la segnalazione di condotte illecite");

			List<PDFCustomTableRow> rows = new ArrayList<PDFCustomTableRow>();

			rows.add(getRow("Data di invio della segnalazione", new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date())));
			rows.add(getRowSpace());
			
			rows.add(getRow("Nome e cognome del segnalante", segnalante.getNome_cognome()));
			rows.add(getRowSpace());
			
			rows.add(getRow("Qualifica o posizione professionale", segnalante.getQualifica()));
			rows.add(getRowSpace());
			
			rows.add(getRow("Struttura di servizio", segnalante.getUfficioRichiedente()));
			rows.add(getRowSpace());
		
			rows.add(getRow("Tel/Cell", segnalante.getTelefono()));
			rows.add(getRowSpace());
		
			rows.add(getRow("E-mail", segnalante.getEmail()));
			rows.add(getRowSpace());
			
			rows.add(getRow("Data/periodo in cui si \u00E8 verificato il fatto", segnalante.getData_fatto()));
			rows.add(getRowSpace());

			if (segnalazione.getUfficio()!=null && !"".equalsIgnoreCase(segnalazione.getUfficio())) {
				rows.add(getRow("Luogo in cui si \u00E8 verificato il fatto", segnalazione.getUfficio()));
			} else if (segnalazione.getUfficio_esterno()!=null && !"".equalsIgnoreCase(segnalazione.getUfficio_esterno())) {
				rows.add(getRow("Luogo in cui si \u00E8 verificato il fatto", segnalazione.getUfficio_esterno()));
			}
			
			rows.add(getRowSpace());
			
			String primaAzione = "";
			if(!segnalazione.getCheck().isEmpty()) {
				primaAzione = "- " + segnalazione.getCheck().get(0);
				if(primaAzione.contains("altro (specificare")) {
					primaAzione = primaAzione + " " + segnalazione.getAltro();
				}
			}
			
			rows.add(getRow("Ritengo che le azioni od omissioni commesse o tentate siano:", primaAzione));
			
			if(segnalazione.getCheck().size()>1) {
				String azionesuccessiva;
				for (int i = 2; i <= segnalazione.getCheck().size(); i++) {
					azionesuccessiva = "- " +  segnalazione.getCheck().get(i-1);
					if(azionesuccessiva.contains("altro (specificare")) {
						StringBuilder sb = new StringBuilder();
						sb.append(azionesuccessiva);
						sb.append(" ");
						sb.append(segnalazione.getAltro());
						azionesuccessiva = sb.toString();
					}
				rows.add(getRow("", azionesuccessiva));
				}
			}
			
			rows.add(getRowSpace());
			
			rows.add(getRow("Descrizione del fatto (condotta ed evento)", segnalazione.getDescrizione()));
			rows.add(getRowSpace());
			
			rows.add(getRow("Autore/i del fatto", segnalazione.getAutore()));
			rows.add(getRowSpace());
			
			rows.add(getRow("Altri eventuali soggetti a conoscenza del fatto e/o in grado di riferire sul medesimo", segnalazione.getAltri_soggetti()));
			rows.add(getRowSpace());
			
			String primoAllegato = "";
			if(!segnalazione.getAllegati().isEmpty()) {
				primoAllegato = "- " + segnalazione.getAllegati().get(0).getAllegatoNome();
			}
			
			rows.add(getRow("Eventuali allegati a sostegno della segnalazione", primoAllegato));
			
			if(segnalazione.getAllegati().size()>1) {
				String allegatosuccessivo;
				for (int i = 2; i <= segnalazione.getAllegati().size(); i++) {
					if(segnalazione.getAllegati().get(i-1).getAllegatoNome()!=null && !"".equalsIgnoreCase(segnalazione.getAllegati().get(i-1).getAllegatoNome())) {
					allegatosuccessivo = "- " +  segnalazione.getAllegati().get(i-1).getAllegatoNome();
					rows.add(getRow("", allegatosuccessivo));
					}
				}
			}
			rows.add(getRowSpace());
				
			PDFCustomTable table = new PDFCustomTable(rows, null);
			table.setBorderVisible(false);
			table.setBorder(false);
			pdfCustom.drawTablePDF(table);

			pdfCustom.close(temp);
			return temp;

		} catch (Exception e) {
			_log.warn(e);
		}
		return null;

	}

	private PDFCustomPageLayout drawHeader(boolean flagRotate) {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String data = sdf.format(date);
		StringBuilder textHeaderDXBuilder = new StringBuilder();
		textHeaderDXBuilder.append("Data invio richiesta: ");
		textHeaderDXBuilder.append(data);

		String textBodyDX = "";

		try {
			
			List<PDFCustomTableCell> cellsLayoutHeader = new ArrayList<>();
			PDFCustomTableCell cellLeft;

			cellLeft = new PDFCustomTableCell("", fontFamilyBold, fontSizeHeader, false);
			cellLeft.setBorder(false);
			cellLeft.setUnderline(false);

			cellLeft.setAlign(-1);

			PDFCustomTableCell cellRight = new PDFCustomTableCell("", fontFamily, fontSizeHeader, false);

			cellRight.setAlign(-1);

			cellRight.setBorder(false);

			cellsLayoutHeader.add(cellRight);
			PDFCustomTableCell cellCenter = new PDFCustomTableCell("", fontFamilyBold, fontSizeHeader, false);
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
