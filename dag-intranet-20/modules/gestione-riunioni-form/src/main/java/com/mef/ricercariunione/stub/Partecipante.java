package com.mef.ricercariunione.stub;

import java.io.Serializable;

public class Partecipante implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id_partecipante;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String email;
	private String imagePath;

	public Partecipante(long id, String codiceFiscale, String nome, String cognome, String email, String imagePath) {
		this.email = email;
		this.imagePath = imagePath;
		this.id_partecipante = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public long getId_partecipante() {
		return id_partecipante;
	}

	public void setId_partecipante(long id_partecipante) {
		this.id_partecipante = id_partecipante;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "{\"nome\"  : \"" + this.getNome() + "\" ,\"cognome\":\"" + this.getCognome() + "\" ,\"id\":\""
				+ this.getId_partecipante() + "\" ,\"email\":\"" + this.getEmail() + "\",\"imagePath\":\""
				+ this.getImagePath() + "\"}";
	}

	public String toJSON() {
		return "{\"nome\"  : \"" + this.getNome() + "\" ,\"cognome\":\"" + this.getCognome()
				+ "\" ,\"codiceFiscale\":\"" + this.getCodiceFiscale() + "\" ,\"id\":\"" + this.getId_partecipante()
				+ "\" ,\"email\":\"" + this.getEmail() + "\",\"imagePath\":\"" + this.getImagePath() + "\"}";
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null && obj instanceof Partecipante
				&& this.id_partecipante == ((Partecipante) obj).getId_partecipante());
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
