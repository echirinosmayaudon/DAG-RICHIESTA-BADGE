package com.mef.intranet.rubrica.stub;

public class Qualifica {
	
	private String id_qualifica;
    private String nome_qualifica;
    
    public Qualifica(String id_qualifica, String nome_qualifica){
    	this.id_qualifica=id_qualifica;
    	this.nome_qualifica=nome_qualifica;
    }

	public String getId_qualifica() {
		return id_qualifica;
	}


	public void setId_qualifica(String id_qualifica) {
		this.id_qualifica = id_qualifica;
	}


	public String getNome_qualifica() {
		return nome_qualifica;
	}


	public void setNome_qualifica(String nome_qualifica) {
		this.nome_qualifica = nome_qualifica;
	} 
	
	@Override
	public String toString() {
		return "{\"nome\"  : \"" + this.getNome_qualifica() + "\" ,\"id\":\""+this.getId_qualifica()+"\"}";
	} 

	@Override
	public boolean equals(Object obj) {
		return (obj !=null && obj instanceof Qualifica && this.id_qualifica==((Qualifica)obj).getId_qualifica());
	}
	
	@Override
	public int hashCode(){
		 int result = 17;
	        result = 31 * result + this.id_qualifica.hashCode();
		return result;
		
	}


}
