package mef.richieste.pub.siti.internet.bean;

public class Richiedente {
	private String ispettorato;
	private String ufficio;
	private String primoReferente;
	private String secondoReferente;
	private String telefonoInterno;
	private String email;
    private String emailDirigente;
    private String nome;
    private String cognome;
    private String nomeDirigente;
    private String cognomeDirigente;
    public String toJSON(){
		
	return 
			"{\"ispettorato\"  : \"" + this.ispettorato + "\" ,\"ufficio\":\""+this.ufficio+"\",\"primoReferente\"  : \"" 
			+ this.primoReferente + "\",\"secondoReferente\"  : \"" + this.secondoReferente+ "\" ,\"telefonoInterno\":\""+this.telefonoInterno + "\" ,\"email\":\""
			+ this.email + "\" ,\"emailDirigente\":\""+ this.emailDirigente + "\",\"nome\":\""+ this.nome + "\",\"cognome\":\""+ this.cognome + "\",\"nomeDirigente\":\""+ this.nomeDirigente + "\",\"cognomeDirigente\":\""+ this.cognomeDirigente + "\" }";
    }
    
	public String getIspettorato() {
		return ispettorato;
	}
	public void setIspettorato(String ispettorato) {
		this.ispettorato = ispettorato;
	}
	public String getUfficio() {
		return ufficio;
	}
	public void setUfficio(String ufficio) {
		this.ufficio = ufficio;
	}
	public String getPrimoReferente() {
		return primoReferente;
	}
	public void setPrimoReferente(String primoReferente) {
		this.primoReferente = primoReferente;
	}
	public String getSecondoReferente() {
		return secondoReferente;
	}
	public void setSecondoReferente(String secondoReferente) {
		this.secondoReferente = secondoReferente;
	}
	public String getTelefonoInterno() {
		return telefonoInterno;
	}
	public void setTelefonoInterno(String telefonoInterno) {
		this.telefonoInterno = telefonoInterno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailDirigente() {
		return emailDirigente;
	}

	public void setEmailDirigente(String emailDirigente) {
		this.emailDirigente = emailDirigente;
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

	public String getNomeDirigente() {
		return nomeDirigente;
	}

	public void setNomeDirigente(String nomeDirigente) {
		this.nomeDirigente = nomeDirigente;
	}

	public String getCognomeDirigente() {
		return cognomeDirigente;
	}

	public void setCognomeDirigente(String cognomeDirigente) {
		this.cognomeDirigente = cognomeDirigente;
	}
	
	
	
}
