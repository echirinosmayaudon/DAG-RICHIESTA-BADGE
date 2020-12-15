package mef.whistleblowing.form.beans;

import java.io.Serializable;

public class Richiedente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ufficioRichiedente;
	private String nome;
	private String cognome;
	private String qualifica;
	private String ubicazione;
	private String telefono;
	private String email;
	private String nome_cognome;
	private String data_fatto;
	
	
    public String toJSON(){
		
	return "{\"ufficioRichiedente\"  : \"" + this.ufficioRichiedente + "\" ,\"nome\":\""+this.nome+"\",\"cognome\"  : \"" 
+ this.cognome + "\",\"qualifica\"  : \"" + this.qualifica+ "\" ,\"ubicazione\"  : \"" + this.ubicazione+ "\" ,\"email\"  : \"" + this.email+ "\" ,\"telefono\":\""+this.telefono+ "\",\"nome_cognome\"  : \"" + this.nome_cognome+ "\" ,\"data_fatto\"  : \"" + this.data_fatto+ "\"}";
    }

	public String getUfficioRichiedente() {
		return ufficioRichiedente;
	}

	public void setUfficioRichiedente(String ufficioRichiedente) {
		this.ufficioRichiedente = ufficioRichiedente;
	}

	public String getQualifica() {
		return qualifica;
	}

	public void setQualifica(String qualifica) {
		this.qualifica = qualifica;
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

	public String getUbicazione() {
		return ubicazione;
	}

	public void setUbicazione(String ubicazione) {
		this.ubicazione = ubicazione;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome_cognome() {
		return nome_cognome;
	}

	public void setNome_cognome(String nome_cognome) {
		this.nome_cognome = nome_cognome;
	}

	public String getData_fatto() {
		return data_fatto;
	}

	public void setData_fatto(String data_fatto) {
		this.data_fatto = data_fatto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
