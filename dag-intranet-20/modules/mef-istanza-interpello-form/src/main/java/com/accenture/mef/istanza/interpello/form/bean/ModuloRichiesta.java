package com.accenture.mef.istanza.interpello.form.bean;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.io.File;

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

	private Opzione conseguenzeCiviliPenali;
	private Opzione dichiarazione;
	private Opzione requisiti;
	private Opzione funzioniDirigenziali;

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

	public Opzione getConseguenzeCiviliPenali() {
		return conseguenzeCiviliPenali;
	}

	public void setConseguenzeCiviliPenali(Opzione conseguenzeCiviliPenali) {
		this.conseguenzeCiviliPenali = conseguenzeCiviliPenali;
	}

	public Opzione getDichiarazione() {
		return dichiarazione;
	}

	public void setDichiarazione(Opzione dichiarazione) {
		this.dichiarazione = dichiarazione;
	}

	public Opzione getRequisiti() {
		return requisiti;
	}

	public void setRequisiti(Opzione requisiti) {
		this.requisiti = requisiti;
	}

	public Opzione getFunzioniDirigenziali() {
		return funzioniDirigenziali;
	}

	public void setFunzioniDirigenziali(Opzione funzioniDirigenziali) {
		this.funzioniDirigenziali = funzioniDirigenziali;
	}

	public String toJSONOptions() {

		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("id_conseguenzecivilipenali", this.getConseguenzeCiviliPenali().getId());
		json.put("id_dichiarazione", this.getDichiarazione().getId());
		json.put("id_requisiti", this.getRequisiti().getId());
		json.put("id_funzionidirigenziali", this.getFunzioniDirigenziali().getId());

		return json.toJSONString();
	}

}