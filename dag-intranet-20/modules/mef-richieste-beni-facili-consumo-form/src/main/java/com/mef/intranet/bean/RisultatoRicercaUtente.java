package com.mef.intranet.bean;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class RisultatoRicercaUtente implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String nome;
	private String cognome;
	private String ufficio;
	private boolean delega;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getUfficio() {
		return ufficio;
	}

	public void setUfficio(String ufficio) {
		this.ufficio = ufficio;
	}

	public boolean isDelega() {
		return delega;
	}

	public void setDelega(boolean delega) {
		this.delega = delega;
	}

	public JSONObject toJSONObject() {

		JSONObject jo = JSONFactoryUtil.createJSONObject();

		jo.put("id", this.getId());
		jo.put("nome", this.getNome());
		jo.put("cognome", this.getCognome());
		jo.put("ufficio", this.getUfficio());
		jo.put("delega", this.isDelega());

		return jo;

	}

}
