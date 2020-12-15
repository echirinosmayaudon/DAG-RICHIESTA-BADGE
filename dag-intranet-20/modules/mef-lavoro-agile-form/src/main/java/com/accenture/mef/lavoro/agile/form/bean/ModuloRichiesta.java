package com.accenture.mef.lavoro.agile.form.bean;

import java.io.File;
import com.liferay.portal.kernel.util.HtmlUtil;

public class ModuloRichiesta {
	
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String dataNascita;
	private String luogoNascita;
	private String residenzaCitta;
	private String residenzaVia;
	private String dataAssunzione;
	
	private String dipartimento;
	private String direzione;
	private String ufficio;
	private String email;
	private String areaAppartenenza;
	private String fasciaRetributiva;
	
	private Opzione dotazione;
	private Opzione opzione1;
	private Opzione opzione2;
	private Opzione opzione3;
	private Opzione opzione4;
	private Opzione opzione5;
	private Opzione opzione6;
	private Opzione opzione7;
	private Opzione opzione8;
	private Opzione opzione9;
	
	private File allegato;
	private String allegatoNome;
	private String allegatoMimeType;
	
	private String note;
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getLuogoNascita() {
		return luogoNascita;
	}
	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}
	public String getResidenzaCitta() {
		return residenzaCitta;
	}
	public void setResidenzaCitta(String residenzaCitta) {
		this.residenzaCitta = residenzaCitta;
	}
	public String getResidenzaVia() {
		return residenzaVia;
	}
	public void setResidenzaVia(String residenzaVia) {
		this.residenzaVia = residenzaVia;
	}
	public String getDataAssunzione() {
		return dataAssunzione;
	}
	public void setDataAssunzione(String dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}
	public String getDipartimento() {
		return dipartimento;
	}
	public void setDipartimento(String dipartimento) {
		this.dipartimento = dipartimento;
	}
	public String getDirezione() {
		return direzione;
	}
	public void setDirezione(String direzione) {
		this.direzione = direzione;
	}
	public String getUfficio() {
		return ufficio;
	}
	public void setUfficio(String ufficio) {
		this.ufficio = ufficio;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAreaAppartenenza() {
		return areaAppartenenza;
	}
	public void setAreaAppartenenza(String areaAppartenenza) {
		this.areaAppartenenza = areaAppartenenza;
	}
	public String getFasciaRetributiva() {
		return fasciaRetributiva;
	}
	public void setFasciaRetributiva(String fasciaRetributiva) {
		this.fasciaRetributiva = fasciaRetributiva;
	}
	public Opzione getOpzione1() {
		return opzione1;
	}
	public void setOpzione1(Opzione opzione1) {
		this.opzione1 = opzione1;
	}
	public Opzione getOpzione2() {
		return opzione2;
	}
	public void setOpzione2(Opzione opzione2) {
		this.opzione2 = opzione2;
	}
	public Opzione getOpzione3() {
		return opzione3;
	}
	public void setOpzione3(Opzione opzione3) {
		this.opzione3 = opzione3;
	}
	public Opzione getOpzione4() {
		return opzione4;
	}
	public void setOpzione4(Opzione opzione4) {
		this.opzione4 = opzione4;
	}
	public Opzione getOpzione5() {
		return opzione5;
	}
	public void setOpzione5(Opzione opzione5) {
		this.opzione5 = opzione5;
	}
	public Opzione getOpzione6() {
		return opzione6;
	}
	public void setOpzione6(Opzione opzione6) {
		this.opzione6 = opzione6;
	}
	public Opzione getOpzione7() {
		return opzione7;
	}
	public void setOpzione7(Opzione opzione7) {
		this.opzione7 = opzione7;
	}
	public Opzione getOpzione8() {
		return opzione8;
	}
	public void setOpzione8(Opzione opzione8) {
		this.opzione8 = opzione8;
	}
	public Opzione getOpzione9() {
		return opzione9;
	}
	public void setOpzione9(Opzione opzione9) {
		this.opzione9 = opzione9;
	}
	public Opzione getDotazione() {
		return dotazione;
	}
	public void setDotazione(Opzione dotazione) {
		this.dotazione = dotazione;
	}
	public File getAllegato() {
		return allegato;
	}
	public void setAllegato(File allegato) {
		this.allegato = allegato;
	}
	public String getAllegatoNome() {
		return allegatoNome;
	}
	public void setAllegatoNome(String allegatoNome) {
		this.allegatoNome = allegatoNome;
	}
	public String getAllegatoMimeType() {
		return allegatoMimeType;
	}
	public void setAllegatoMimeType(String allegatoMimeType) {
		this.allegatoMimeType = allegatoMimeType;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	
	public String toJSONOptions (){
		String json =   "{ \"opzioni\": ["+this.dotazione.toJSON()+","
										+this.opzione1.toJSON()+","
										+this.opzione2.toJSON()+","
										+this.opzione3.toJSON()+","
										+this.opzione4.toJSON()+","
										+this.opzione5.toJSON()+","
										+this.opzione6.toJSON()+","
										+this.opzione7.toJSON()+","
										+this.opzione8.toJSON()+","
										+this.opzione9.toJSON()+"],"
						  +"\"note\": \"<#note>\""
					  + "}";
		return json;
	}
	
}
