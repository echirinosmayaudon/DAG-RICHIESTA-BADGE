package com.mef.ricercariunione.stub;

import java.io.Serializable;
import java.util.List;

public class Segreteria implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id_segreteria;
	private String segreteria_nome;
	private String email;
	private long stato;
	private String note;
	private String descrizione; 
	private boolean capofila;
	private int index; 
	private String nome_stato;


	private List<Partecipante> listPartecipante;



public String getNome_stato() {
		return nome_stato;
	}

	public void setNome_stato(String nome_stato) {
		this.nome_stato = nome_stato;
	}

private Segreteria(long id,String nome, String email, String descrizione,long stato){
	this.id_segreteria=id;
	this.segreteria_nome=nome;
	this.descrizione= descrizione;
	this.email=email;
	this.stato=stato;
	
}

public String getDescrizione() {
	return descrizione;
}

public void setDescrizione(String descrizione) {
	this.descrizione = descrizione;
}


public Segreteria(long id,String nome,String email, String descrizione, long stato, String note, boolean capofila, int index){
	this(id,nome,email,descrizione,stato);
	this.note=note;
	this.capofila=capofila;
	this.index=index;
}

public long getId_segreteria() {
	return id_segreteria;
}




public void setId_segreteria(long id_segreteria) {
	this.id_segreteria = id_segreteria;
}

public String getNote() {
	return note;
}

public void setNote(String note) {
	this.note = note;
}
public String getSegreteria_nome() {
	return segreteria_nome;
}


public void setSegreteria_nome(String segreteria_nome) {
	this.segreteria_nome = segreteria_nome;
}


public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
public long getStato() {
	return stato;
}

public void setStato(long stato) {
	this.stato = stato;
} 
	
@Override
public String toString() {
	return "{\"nome\"  : \"" + this.getSegreteria_nome() + "\" ,\"id\":\""+this.getId_segreteria()+"\"}";
} 


public boolean isCapofila() {
	return capofila;
}

public void setCapofila(boolean capofila) {
	this.capofila = capofila;
}

public int getIndex() {
	return index;
}

public void setIndex(int index) {
	this.index = index;
}

public String toJSON(){
	return "{\"nome\"  : \"" + this.segreteria_nome.toUpperCase() + "\" ,\"index\"  : \"" + this.index + "\" ,\"capofila\"  : \"" + this.capofila + "\" ,\"descrizione\":\"" + this.descrizione + "\",\"id\":\""+this.id_segreteria+"\",\"email\"  : \"" + this.email + "\",\"stato\"  : \"" + this.stato + "\"}";
}

@Override
public boolean equals(Object obj) {
	return (obj !=null && obj instanceof Segreteria && this.id_segreteria==((Segreteria)obj).getId_segreteria());
}

@Override
public int hashCode() {
	return super.hashCode();
}

public List<Partecipante> getListPartecipante() {
	return listPartecipante;
}

public void setListPartecipante(List<Partecipante> listPartecipante) {
	this.listPartecipante = listPartecipante;
}


}
