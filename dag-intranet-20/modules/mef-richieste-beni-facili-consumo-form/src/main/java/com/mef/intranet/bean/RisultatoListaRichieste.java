package com.mef.intranet.bean;

import java.util.Date;

public class RisultatoListaRichieste implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String stato;
	private String nome;
	private String cognome;
	private Date data;
	
	private String tipoMateriale;
	

	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
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

	public String getTipoMateriale() {
		return tipoMateriale;
	}
	public void setTipoMateriale(String tipoMateriale) {
		this.tipoMateriale = tipoMateriale;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
	
}
