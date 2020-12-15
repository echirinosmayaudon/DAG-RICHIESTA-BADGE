package com.mef.intranet.bean;

public class ServizioMaterialeBean implements java.io.Serializable {

	private String gruppo;
	private String descrizione;
	private String categoria;
	
	public ServizioMaterialeBean(String gruppo, String descrizione, String categoria) {
		super();
		this.gruppo = gruppo;
		this.descrizione = descrizione;
		this.categoria = categoria;
	}
	
	public String getGruppo() {
		return gruppo;
	}
	public void setGruppo(String gruppo) {
		this.gruppo = gruppo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}
