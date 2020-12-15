package com.mef.ricercariunione.beans;

import com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante;
import com.intranet.mef.gestione.riunioni.model.InvitatiRiunione;
import com.intranet.mef.gestione.riunioni.model.TipoRiunione;
import com.intranet.mef.gestione.riunioni.service.AmministrazioneConvocanteLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.InvitatiRiunioneLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.TipoRiunioneLocalServiceUtil;
import com.intranet.mef.util.BeanCreator;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.mef.pdfbox.custom.PDFCustomGeneric;
import com.mef.pdfbox.custom.PDFCustomPageLayout;
import com.mef.pdfbox.custom.PDFCustomTable;
import com.mef.pdfbox.custom.PDFCustomTableCell;
import com.mef.pdfbox.custom.PDFCustomTableRow;
import com.mef.pdfbox.custom.PDFCustomText;
import com.mef.ricercariunione.stub.Partecipante;
import com.mef.ricercariunione.stub.Segreteria;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/*
 * 
 * 
 * identifica tutte le colonne che verrano stampate nel pdf 
 * con relativo spazio di tipo int dedicato per ogni colonna
 * la somma degli spazi dev'essere uguale a 100
 * 
 * 
 */

public enum StampaReport {
	CONSTANT_ID("Id", 0), CONSTANT_E_ROOM("Inserita in E-ROOM il", 9), CONSTANT_LUOGO("Luogo", 13), CONSTANT_CONVOCANTE(
			"Convocante", 14), CONSTANT_ORA_INIZIO("Ora", 4), CONSTANT_OGGETTO("Oggetto",
					15), CONSTANT_GIORNO_INIZIO("Data", 7), CONSTANT_ISPETTORATO("Ispettorato/Uffici di Staff RGS",
							15), CONSTANT_TIPO("Tipo", 7), CONSTANT_NOTE("Note", 11), CONSTANT_STATO_RIUNIONE("Stato",
									5), CONSTANT_PROTOCOLLO("Protocollo", 0), CONSTANT_DURATA_PREVISTA("Durata", 0);

	private String nome;
	private int sizeCol;

	static final int _CONSTANT_HEIGHT = 100;

	private final static BeanCreator _segrCreator = new BeanCreator();
	static final Log _log = LogFactoryUtil.getLog(StampaReport.class);

	
	public int getSizeCol() {
		return sizeCol;

	}

	public String getNome() {
		return nome;
	}

	private StampaReport(String nome, int size) {
		this.nome = nome;
		this.sizeCol = size;
	}

	public static void drawPDFStampaDettagliata(ResourceResponse resourceResponse, ResourceRequest resourceRequest,
			List<Map<StampaReport, String>> content, RiunioneRes ricercaCampi) {
		try {
			float fontSizeHeader = 14;
			float fontSizeContainer = 12;
			float fontSizeTable = 10;
			int tab = 1;
			PDFont font = PDType1Font.TIMES_ROMAN;
			PDFCustomGeneric pdfCustomStampa = new PDFCustomGeneric();
			pdfCustomStampa.setOutputStream(resourceResponse.getPortletOutputStream());
			pdfCustomStampa.setPageLayout(drawHeader(false));
			// parametri da stampare nel pdf
			String criteri_selezione = "-Criteri di Selezione:";
			String informazion_generali = "-Informazioni Generali";
			String Stampa_Rounione_Title = "1 Stampa Report Riunioni";

			Date data_oggi = Calendar.getInstance().getTime();

			DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat simpleDateFormatOra = new SimpleDateFormat("HH:mm");

			String data_di_oggi = simpleDateFormat.format(data_oggi);
			String ora_di_produzione = simpleDateFormatOra.format(data_oggi.getTime());

			pdfCustomStampa.writeTextPDF(Stampa_Rounione_Title, font, fontSizeHeader);
			pdfCustomStampa.writeTextPDF(informazion_generali, font, fontSizeContainer);
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			User user = themeDisplay.getUser();

			pdfCustomStampa.writeTextPDF("-Utente: " + user.getFullName(), font, fontSizeContainer, tab);
			pdfCustomStampa.writeTextPDF("-Data produzione report: " + data_di_oggi, font, fontSizeContainer, tab);
			pdfCustomStampa.writeTextPDF("-Ora produzione report: " + ora_di_produzione, font, fontSizeContainer, tab);

			pdfCustomStampa.writeTextPDF(criteri_selezione, font, fontSizeContainer);

			if ("".equals(ricercaCampi.getParola_chiave())) {
				pdfCustomStampa.writeTextPDF("- Parola chiave: ", font, fontSizeContainer, tab);

			} else {
				pdfCustomStampa.writeTextPDF("- Parola chiave: " + ricercaCampi.getParola_chiave(), font, fontSizeContainer, tab);
			}

			if ("0".equals(ricercaCampi.getAmministrazione())) {
				pdfCustomStampa.writeTextPDF("- Convocante: ", font, fontSizeContainer, tab);
			} else {

				String amministrazione = ricercaCampi.getAmministrazione();
				Long amministrazione_id = Long.parseLong(amministrazione);
				AmministrazioneConvocante amministrazione_convocante;

				amministrazione_convocante = AmministrazioneConvocanteLocalServiceUtil
						.getAmministrazioneConvocante(amministrazione_id);

				pdfCustomStampa.writeTextPDF("- Convocante: " + amministrazione_convocante.getNome_amministrazione(),
						font, 10, 1);

			}

			if ("0".equals(ricercaCampi.getTipologia())) {
				pdfCustomStampa.writeTextPDF("- Tipologia: ", font, fontSizeContainer, tab);

			} else {

				String tipologia = ricercaCampi.getTipologia();
				long tipologia_id = Long.parseLong(tipologia);
				TipoRiunione tipologia_name = TipoRiunioneLocalServiceUtil.getTipoRiunione(tipologia_id);
				pdfCustomStampa.writeTextPDF("- Tipologia: " + tipologia_name.getDescrizione(), font, fontSizeContainer,
						1);
			}

			// ispettorato/segreteria che stata cercato
			if ("0".equals(ricercaCampi.getIspettorato())) {
				pdfCustomStampa.writeTextPDF("- Ispettorato/Ufficio di Staff RGS Invitato: ", font, fontSizeContainer,
						1);

			} else {
				Segreteria s = _segrCreator.getElementByIdSegreteria(Long.valueOf(ricercaCampi.getIspettorato()));
				StringBuilder builderSegreteria =new StringBuilder();
				builderSegreteria.append("- Ispettorato/Ufficio di Staff RGS Invitato: ");
				builderSegreteria.append(s.getSegreteria_nome());

				pdfCustomStampa.writeTextPDF(
						builderSegreteria.toString() ,
						font, fontSizeContainer, 1);
			}

			// protocollo che stata cercato
			if ("".equals(ricercaCampi.getProtocollo())) {
				pdfCustomStampa.writeTextPDF("- Protocollo: ", font, fontSizeContainer, tab);

			} else {

				pdfCustomStampa.writeTextPDF("- Protocollo:" + ricercaCampi.getProtocollo(), font, fontSizeContainer,
						tab);

			}

			if (ricercaCampi.getData() == null || (!"".equals(ricercaCampi.getData()))) {
				pdfCustomStampa.writeTextPDF("- Data dal: " + ricercaCampi.getData_da(), font, fontSizeContainer, tab);
				pdfCustomStampa.writeTextPDF("- Data al: " + ricercaCampi.getData_a(), font, fontSizeContainer, tab);
			} else {
				pdfCustomStampa.writeTextPDF("- Data: " + ricercaCampi.getData(), font, fontSizeContainer, tab);

			}
			pdfCustomStampa.addLine(10);
			double numero_riunione = 1.1;
			for (int i = 0; i < content.size(); i++) {
				pdfCustomStampa.writeTextPDF(
						numero_riunione + ". Riunione del " + content.get(i).get(StampaReport.CONSTANT_GIORNO_INIZIO),
						font, fontSizeHeader);

				pdfCustomStampa.writeTextPDF("- Ora inizio: " + content.get(i).get(StampaReport.CONSTANT_ORA_INIZIO),
						font, fontSizeContainer);
				pdfCustomStampa.writeTextPDF(
						"- Inserita in E-ROOM il: " + content.get(i).get(StampaReport.CONSTANT_E_ROOM), font,
						fontSizeContainer);
				pdfCustomStampa.writeTextPDF("- Oggetto: ", font,fontSizeContainer);
				pdfCustomStampa.writeTextPDF(content.get(i).get(StampaReport.CONSTANT_OGGETTO), font,
				fontSizeContainer,1);
				
				pdfCustomStampa.writeTextPDF("- Luogo: " + content.get(i).get(StampaReport.CONSTANT_LUOGO), font,
						fontSizeContainer);
				pdfCustomStampa.writeTextPDF("- Tipo: " + content.get(i).get(StampaReport.CONSTANT_TIPO), font,
						fontSizeContainer);

				pdfCustomStampa.writeTextPDF(
						"- Durata Prevista: " + content.get(i).get(StampaReport.CONSTANT_DURATA_PREVISTA), font,
						fontSizeContainer);

				pdfCustomStampa.writeTextPDF("- Convocante: " + content.get(i).get(StampaReport.CONSTANT_CONVOCANTE),
						font, fontSizeContainer);
				pdfCustomStampa.writeTextPDF("- Stato: " + content.get(i).get(StampaReport.CONSTANT_STATO_RIUNIONE),
						font, fontSizeContainer);
				pdfCustomStampa.writeTextPDF("- Protocollo: " + content.get(i).get(StampaReport.CONSTANT_PROTOCOLLO),
						font, fontSizeContainer);
				pdfCustomStampa.writeTextPDF("- Note coordinatore: ",font, fontSizeContainer);
				
				String[] arraySplitNote=content.get(i).get(StampaReport.CONSTANT_NOTE).split("\r\n");
				
				for(int j=0; j<arraySplitNote.length; j++){
					pdfCustomStampa.writeTextPDF(arraySplitNote[j],font, fontSizeContainer,1);
				} 
				
				
				
				pdfCustomStampa.addLine(10);

				List<InvitatiRiunione> segreterie = InvitatiRiunioneLocalServiceUtil
						.getInvitatiRiunioneByIdRiunione(Long.parseLong(content.get(i).get(StampaReport.CONSTANT_ID)));
				
				if (segreterie != null && !segreterie.isEmpty()) {
					pdfCustomStampa.writeTextPDF("Invitati ", PDType1Font.COURIER_OBLIQUE, 12);

					List<PDFCustomTableRow> rowsHeader = new ArrayList<>();

					// createHeader campi
					List<PDFCustomTableCell> cellsHeader = new ArrayList<>();
					cellsHeader.add(new PDFCustomTableCell("Partecipanti", PDType1Font.HELVETICA_BOLD, fontSizeTable, 7,
							true, true));
					cellsHeader.add(new PDFCustomTableCell(StampaReport.CONSTANT_NOTE.getNome(),
							PDType1Font.HELVETICA_BOLD, fontSizeTable, 7, true, true));

					cellsHeader.add(new PDFCustomTableCell(StampaReport.CONSTANT_STATO_RIUNIONE.getNome(),
							PDType1Font.HELVETICA_BOLD, fontSizeTable, 3, true, true));
					cellsHeader.add(new PDFCustomTableCell(StampaReport.CONSTANT_ISPETTORATO.getNome(),
							PDType1Font.HELVETICA_BOLD, fontSizeTable, 5, true, true));

					rowsHeader.add(new PDFCustomTableRow(cellsHeader, 1));

					List<PDFCustomTableRow> rows = new ArrayList<>();
					// tutte le righe
					
					for (InvitatiRiunione segreteriaDB : segreterie) {
						Segreteria s = _segrCreator.getElementByIdSegreteria(segreteriaDB.getId_segreteria());
						
						String stato = "In attesa di risposta";
						if (segreteriaDB.getId_stato_invitato() == 1)
							stato = "Accettata";
						else if (segreteriaDB.getId_stato_invitato() == 2)
							stato = "Rifiutata";
						List<PDFCustomTableCell> cells = new ArrayList<>();
						if (segreteriaDB.getPartecipanti() != null) {
							
							List<Partecipante> partecipantiList = _segrCreator.getListaPartecipantiJSONforForm(segreteriaDB.getPartecipanti(),themeDisplay);
							
							StringBuilder invitati = new StringBuilder();

							boolean flag = false;
							for(Partecipante partecipante: partecipantiList){
								if (flag)
									invitati.append(", ");
								else
									flag=true;
								invitati.append(partecipante.getCognome());
								invitati.append(" ");
								invitati.append(partecipante.getNome());
								
							}
							
							cells.add(new PDFCustomTableCell(invitati.toString(), PDType1Font.TIMES_ROMAN,
									fontSizeTable, 7));

							
						}
						cells.add(new PDFCustomTableCell(segreteriaDB.getNote(), PDType1Font.TIMES_ROMAN, fontSizeTable, 7));
						cells.add(new PDFCustomTableCell(stato, PDType1Font.TIMES_ROMAN, fontSizeTable, 3));
						
					
						cells.add(new PDFCustomTableCell(s.getSegreteria_nome(), PDType1Font.TIMES_ROMAN,
								fontSizeTable, 5));

						rows.add(new PDFCustomTableRow(cells, 3));

					}
					PDFCustomTable table =new PDFCustomTable(rows, rowsHeader);
					table.setBorder(true);
					table.setBorderX(10);
					table.setBorderY(10);
					pdfCustomStampa.drawTablePDF(table);
				} else {
					pdfCustomStampa.writeTextPDF("Non sono presenti invitati ", PDType1Font.COURIER_OBLIQUE, 12);

				}
				pdfCustomStampa.addLine(50);
				numero_riunione = numero_riunione + 0.1;

				DecimalFormat df = new DecimalFormat("#.0");
				String df_format = df.format(numero_riunione);
				String df_format_con_punto = df_format.replace(",", ".");
				numero_riunione = Double.parseDouble(df_format_con_punto);

			}

			pdfCustomStampa.close();

		} catch (Exception e) {
			_log.warn(e);
		}

	}

	private static PDFCustomPageLayout drawHeader(boolean flagRotate) {
		String textHeaderLX = "Gestione Riunioni";
		String textHeaderDX = "Ministero dell'Economia e delle Finanze";
		String temp;

		try {
			if (!flagRotate) {
				temp = textHeaderLX;
				textHeaderLX = textHeaderDX;
				textHeaderDX = temp;
			}
			int fontHeader = 8;
			List<PDFCustomTableCell> cellsLayoutHeader = new ArrayList<>();
			PDFCustomTableCell cellLeft;

			cellLeft = new PDFCustomTableCell(textHeaderDX, PDType1Font.HELVETICA_OBLIQUE, fontHeader, false);
			cellLeft.setBorder(false);
			cellLeft.setUnderline(true);
			if (flagRotate)
				cellLeft.setAlign(-1);
			else
				cellLeft.setAlign(1);

			PDFCustomTableCell cellRight = new PDFCustomTableCell(textHeaderLX, PDType1Font.HELVETICA_OBLIQUE,
					fontHeader, false);
			cellRight.setUnderline(true);
			if (flagRotate)
				cellRight.setAlign(1);
			else
				cellRight.setAlign(-1);
			cellRight.setBorder(false);

			cellsLayoutHeader.add(cellLeft);
			cellsLayoutHeader.add(cellRight);

			PDFCustomTableCell cellSpace = new PDFCustomTableCell(" ", PDType1Font.HELVETICA_OBLIQUE, fontHeader,
					false);
			cellRight.setBorder(false);

			List<PDFCustomTableCell> cellsSpace = new ArrayList<>();
			cellsSpace.add(cellSpace);

			List<PDFCustomTableRow> rowsHeaderLayout = new ArrayList<>();
			rowsHeaderLayout.add(new PDFCustomTableRow(cellsLayoutHeader, 1));
			rowsHeaderLayout.add(new PDFCustomTableRow(cellsSpace, 1));

			PDFCustomTable tableHeader = new PDFCustomTable(rowsHeaderLayout, null);
			tableHeader.setBorder(false);
			PDFCustomPageLayout pageLayout = new PDFCustomPageLayout(tableHeader, null);
			pageLayout.setOffsetDown(20);
			pageLayout.setOffsetUp(20);
			pageLayout.setOffsetLeft(30);
			pageLayout.setOffsetRight(30);

			return pageLayout;
		} catch (Exception e) {
			_log.warn(e);
		}
		return null;
	}

	private static void drawPDFStampa(List<Map<StampaReport, String>> content, ResourceResponse resourceResponse,
			String textHeader, boolean flagGiornaliera, ThemeDisplay themeDisplay) {
		try {

			float fontSizeHeader = 10;
			float fontSizeFields = 9;
			PDFCustomGeneric pdfCustom = new PDFCustomGeneric(true);

			pdfCustom.setOutputStream(resourceResponse.getPortletOutputStream());
			pdfCustom.setPageLayout(drawHeader(true));

			// createHeader dal al oppure la data di oggi
			String title = textHeader;

			List<PDFCustomTableRow> rowsHeader = new ArrayList<>();
			List<PDFCustomTableCell> cellsHeaderData = new ArrayList<>();
			cellsHeaderData.add(new PDFCustomTableCell(title, PDType1Font.HELVETICA_BOLD, fontSizeHeader, true, true));

			rowsHeader.add(new PDFCustomTableRow(cellsHeaderData, 1));

			// createHeader campi
			List<PDFCustomTableCell> cellsHeader = new ArrayList<>();
			for (StampaReport s : content.get(0).keySet()) {
				if (s.getSizeCol() > 0)
					if ((flagGiornaliera && (!s.equals(StampaReport.CONSTANT_GIORNO_INIZIO)))|| !flagGiornaliera)
						cellsHeader.add(new PDFCustomTableCell(s.getNome(), PDType1Font.HELVETICA_BOLD, fontSizeHeader,
								s.getSizeCol(), true, true));
					

			}
			rowsHeader.add(new PDFCustomTableRow(cellsHeader, 1));

			List<PDFCustomTableRow> rows = new ArrayList<>();
			// tutte le righe
			for (int i = 0; i < content.size(); i++) {
				List<PDFCustomTableCell> cells = new ArrayList<>();
				for (StampaReport s : content.get(i).keySet()) {
					if (s.getSizeCol() > 0){
						if(s.equals(StampaReport.CONSTANT_ISPETTORATO)){
							List<PDFCustomText> pdfCustomTextList = new ArrayList<>(0);
							List<InvitatiRiunione> segreterie = InvitatiRiunioneLocalServiceUtil
							.getInvitatiRiunioneByIdRiunione(Long.parseLong(content.get(i).get(StampaReport.CONSTANT_ID)));
							PDFCustomText pdfCustomTextEmpty = new PDFCustomText();
							pdfCustomTextEmpty.setText("                        ");
							pdfCustomTextEmpty.setFontSize(fontSizeFields);
							pdfCustomTextEmpty.setNewLine(true);

							for(InvitatiRiunione invitatiSegreterie : segreterie){
								PDFCustomText pdfCustomText = new PDFCustomText();
								Segreteria segreteriaInvitata = _segrCreator.getSegreteriaWithPartecipanti(invitatiSegreterie, themeDisplay);
								StringBuilder segInvitata = new StringBuilder();
								segInvitata.append(segreteriaInvitata.getSegreteria_nome());
								pdfCustomText.setFontSize(fontSizeFields);
								pdfCustomText.setNewLine(true);
								if(segreteriaInvitata.getListPartecipante()!=null && !segreteriaInvitata.getListPartecipante().isEmpty()){
									segInvitata.append(":");
									pdfCustomText.setText(segInvitata.toString());
									
		
									
									pdfCustomTextList.add(pdfCustomText);

									
									int countN = 0;
									for(Partecipante partecipante: segreteriaInvitata.getListPartecipante()){
										PDFCustomText pdfCustomTextPartecipante = new PDFCustomText();
										StringBuilder partecipanteString = new StringBuilder();
										countN++;

										partecipanteString.append(partecipante.getNome().substring(0,1));

										partecipanteString.append(partecipante.getNome().substring(1,partecipante.getNome().length()).toLowerCase());
										partecipanteString.append(" ");
										partecipanteString.append(partecipante.getCognome().substring(0,1));

										partecipanteString.append(partecipante.getCognome().substring(1,partecipante.getCognome().length()).toLowerCase());
										if(countN!=segreteriaInvitata.getListPartecipante().size()){
											partecipanteString.append(",");
										}
										pdfCustomTextPartecipante.setText( partecipanteString.toString() );
										pdfCustomTextPartecipante.setFontSize(fontSizeFields);
										pdfCustomTextPartecipante.setNewLine(true);
										pdfCustomTextList.add(pdfCustomTextPartecipante);
										
									}
									
									pdfCustomTextList.add(pdfCustomTextEmpty);
								}
								else{
									pdfCustomText.setText(segInvitata.toString());
									pdfCustomTextList.add(pdfCustomText);
								}
								
							}
							
							
							PDFCustomTableCell pdfCustomCell = new PDFCustomTableCell(pdfCustomTextList);
							pdfCustomCell.setWidth(s.getSizeCol());
							cells.add(pdfCustomCell);

						}else{
							if(s.equals(StampaReport.CONSTANT_NOTE)){
								
								String note=content.get(i).get(StampaReport.CONSTANT_NOTE).replace("\r\n"," ");
								cells.add(new PDFCustomTableCell(note, PDType1Font.TIMES_ROMAN,
								fontSizeFields, s.getSizeCol()));
							}else{
								if ((flagGiornaliera && (!s.equals(StampaReport.CONSTANT_GIORNO_INIZIO)))|| !flagGiornaliera)
									cells.add(new PDFCustomTableCell(content.get(i).get(s), PDType1Font.TIMES_ROMAN,
										fontSizeFields, s.getSizeCol()));
								}	
							}
						}
						

				}
				rows.add(new PDFCustomTableRow(cells, 3));

			}

			PDFCustomTable table = new PDFCustomTable(rows, rowsHeader);
			table.setBorder(true);
			table.setBorderX(10);
			table.setBorderY(10);
			pdfCustom.drawTablePDF(table);

			pdfCustom.close();
		} catch (Exception e) {
			_log.warn(e);
		}

	}

	public static void drawPDFStampa(List<Map<StampaReport, String>> content, ResourceResponse resourceResponse,
			String dataDa, String dataA,ThemeDisplay themeDisplay) {

		String title = "Riunioni dal " + dataDa + " al " + dataA;
		drawPDFStampa(content, resourceResponse, title, false,themeDisplay);

	}

	public static void drawPDFStampaGiornaliera(List<Map<StampaReport, String>> content,
			ResourceResponse resourceResponse, String data,ThemeDisplay themeDisplay) {
		String title = "Riunioni del " + data;
		drawPDFStampa(content, resourceResponse, title, true,themeDisplay);

	}

}
