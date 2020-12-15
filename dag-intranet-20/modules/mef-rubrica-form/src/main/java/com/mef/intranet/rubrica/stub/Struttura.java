package com.mef.intranet.rubrica.stub;

public class Struttura {
	
	private String id_struttura;
    private String nome_struttura;
    
    public Struttura(String id_struttura, String nome_struttura){
    	this.id_struttura=id_struttura;
    	this.nome_struttura=nome_struttura;
}

	public String getId_struttura() {
		return id_struttura;
	}

	public void setId_struttura(String id_struttura) {
		this.id_struttura = id_struttura;
	}

	public String getNome_struttura() {
		return nome_struttura;
	}

	public void setNome_struttura(String nome_struttura) {
		this.nome_struttura = nome_struttura;
	}
	
	@Override
	public String toString() {
		return "{\"nome\"  : \"" + this.getNome_struttura() + "\" ,\"id\":\""+this.getId_struttura()+"\"}";
	} 

	@Override
	public boolean equals(Object obj) {
		return (obj !=null && obj instanceof Struttura && this.id_struttura==((Struttura)obj).getId_struttura());
	}
	@Override
	public int hashCode(){
		 int result = 17;
	        result = 31 * result + this.id_struttura.hashCode();
		return result;
		
	}
}
