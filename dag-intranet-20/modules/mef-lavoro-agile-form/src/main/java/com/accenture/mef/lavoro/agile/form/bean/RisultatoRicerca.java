package com.accenture.mef.lavoro.agile.form.bean;

public class RisultatoRicerca {
	
	long id;
	int progressivo;
	String cognome;
	String nome;
	String dip;
	String dir;
	int punteggio;
	boolean priorita;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getProgressivo() {
		return progressivo;
	}
	public void setProgressivo(int progressivo) {
		this.progressivo = progressivo;
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
	public int getPunteggio() {
		return punteggio;
	}
	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}
	public boolean isPriorita() {
		return priorita;
	}
	public void setPriorita(boolean priorita) {
		this.priorita = priorita;
	}
	
	
	

}
