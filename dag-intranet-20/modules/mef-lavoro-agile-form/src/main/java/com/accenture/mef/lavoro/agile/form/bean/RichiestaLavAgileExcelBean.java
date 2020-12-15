package com.accenture.mef.lavoro.agile.form.bean;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class RichiestaLavAgileExcelBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String istanza;
	private String cognome;
	private String nome;
	private String codice_fiscale;
	private String dip;
	private String dir;
	private String priorita;
	private String punteggio;
	private String data_nascita;
	private String flag_2a;
	private String flag_2b;
	private String flag_3a;
	private String flag_3b;
	private String value_3c1;
	private String value_3c2;
	private String value_3d;
	private String value_3e;
	private String flag_3f;
	private String allegato;
	private String note;

	public String getIstanza() {
		return istanza;
	}

	public void setIstanza(String istanza) {
		this.istanza = istanza;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodice_fiscale() {
		return codice_fiscale;
	}

	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}

	public String getDip() {
		return dip;
	}

	public void setDip(String dip) {
		this.dip = dip;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getPriorita() {
		return priorita;
	}

	public void setPriorita(String priorita) {
		this.priorita = priorita;
	}

	public String getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(String punteggio) {
		this.punteggio = punteggio;
	}
	
	public String getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(String data_nascita) {
		this.data_nascita = data_nascita;
	}

	public String getFlag_2a() {
		return flag_2a;
	}

	public void setFlag_2a(String flag_2a) {
		this.flag_2a = flag_2a;
	}

	public String getFlag_2b() {
		return flag_2b;
	}

	public void setFlag_2b(String flag_2b) {
		this.flag_2b = flag_2b;
	}

	public String getFlag_3a() {
		return flag_3a;
	}

	public void setFlag_3a(String flag_3a) {
		this.flag_3a = flag_3a;
	}

	public String getFlag_3b() {
		return flag_3b;
	}

	public void setFlag_3b(String flag_3b) {
		this.flag_3b = flag_3b;
	}

	public String getValue_3c1() {
		return value_3c1;
	}

	public void setValue_3c1(String value_3c1) {
		this.value_3c1 = value_3c1;
	}

	public String getValue_3c2() {
		return value_3c2;
	}

	public void setValue_3c2(String value_3c2) {
		this.value_3c2 = value_3c2;
	}

	public String getValue_3d() {
		return value_3d;
	}

	public void setValue_3d(String value_3d) {
		this.value_3d = value_3d;
	}

	public String getValue_3e() {
		return value_3e;
	}

	public void setValue_3e(String value_3e) {
		this.value_3e = value_3e;
	}

	public String getFlag_3f() {
		return flag_3f;
	}

	public void setFlag_3f(String flag_3f) {
		this.flag_3f = flag_3f;
	}

	public String getAllegato() {
		return allegato;
	}

	public void setAllegato(String allegato) {
		this.allegato = allegato;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public JSONObject toJSONObject() {

		JSONObject jo = JSONFactoryUtil.createJSONObject();

		jo.put("istanza", this.getIstanza());
		jo.put("cognome", this.getCognome());
		jo.put("nome", this.getNome());
		jo.put("codice_fiscale", this.getCodice_fiscale());
		jo.put("dip", this.getDip());
		jo.put("dir", this.getDir());
		jo.put("priorita", this.getPriorita());
		jo.put("punteggio", this.getPunteggio());
		jo.put("data_nascita", this.getData_nascita());
		jo.put("flag_2a", this.getFlag_2a());
		jo.put("flag_2b", this.getFlag_2b());
		jo.put("flag_3a", this.getFlag_3a());
		jo.put("flag_3b", this.getFlag_3b());
		jo.put("value_3c1", this.getValue_3c1());
		jo.put("value_3c2", this.getValue_3c2());
		jo.put("value_3d", this.getValue_3d());
		jo.put("value_3e", this.getValue_3e());
		jo.put("flag_3f", this.getFlag_3f());
		jo.put("allegato", this.getAllegato());
		jo.put("note", this.getNote());

		return jo;

	}
	
}