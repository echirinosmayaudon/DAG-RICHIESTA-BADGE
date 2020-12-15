package mef.organigramma.beans;

import java.util.List;

public class StrutturaBean implements java.io.Serializable{
	
private static final long serialVersionUID = 1L;


private String id;
private String nome;
private String dirigente;
private List<StrutturaBean> strutture;



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
public List<StrutturaBean> getStrutture() {
	return strutture;
}
public void setStrutture(List<StrutturaBean> strutture) {
	this.strutture = strutture;
}

public String getDirigente() {
	return dirigente;
}
public void setDirigente(String dirigente) {
	this.dirigente = dirigente;
}





}
