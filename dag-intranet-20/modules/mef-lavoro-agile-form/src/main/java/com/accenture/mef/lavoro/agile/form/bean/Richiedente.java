package com.accenture.mef.lavoro.agile.form.bean;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class Richiedente {

	private String nome;
	private String cognome;
	private String luogoNascita;
	private String dataNascita;
	private String codiceFiscale;
	private String residenzaCitta;
	private String residenzaIndirizzo;
	private String dataAssunzione;

	private String dipartimento;
	private String direzione;
	private String ufficio;
	private long dipartimentoId;
	private long direzioneId;
	private long ufficioId;

	private String mail;
	private String area;
	private String fasciaRetributiva;
	

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
	public String getLuogoNascita() {
		return luogoNascita;
	}
	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}
	public String getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getResidenzaCitta() {
		return residenzaCitta;
	}
	public void setResidenzaCitta(String residenzaCitta) {
		this.residenzaCitta = residenzaCitta;
	}
	public String getResidenzaIndirizzo() {
		return residenzaIndirizzo;
	}
	public void setResidenzaIndirizzo(String residenzaIndirizzo) {
		this.residenzaIndirizzo = residenzaIndirizzo;
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
	public long getDipartimentoId() {
		return dipartimentoId;
	}
	public void setDipartimentoId(long dipartimentoId) {
		this.dipartimentoId = dipartimentoId;
	}
	public long getDirezioneId() {
		return direzioneId;
	}
	public void setDirezioneId(long direzioneId) {
		this.direzioneId = direzioneId;
	}
	public long getUfficioId() {
		return ufficioId;
	}
	public void setUfficioId(long ufficioId) {
		this.ufficioId = ufficioId;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFasciaRetributiva() {
		return fasciaRetributiva;
	}
	public void setFasciaRetributiva(String fasciaRetributiva) {
		this.fasciaRetributiva = fasciaRetributiva;
	}
	

	public String toJSON () {
		
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("luogo_nascita", this.getLuogoNascita());
		json.put("data_nascita", this.getDataNascita());
		json.put("residenza_citta", this.getResidenzaCitta());
		json.put("residenza_indirizzo", this.getResidenzaIndirizzo());
		json.put("dipartimento", this.getDipartimento());
		json.put("direzione", this.getDirezione());
		json.put("ufficio", this.getUfficio());
		json.put("email", this.getMail());
		json.put("area", this.getArea());
		json.put("fascia_retributiva", this.getFasciaRetributiva());
		
		return json.toJSONString();
	}
	
}
