package form.richiesta.utenza.sistemi.informatici.beans;

public class RichiestaUtenzaBean implements java.io.Serializable {
	
private static final long serialVersionUID = 1L;
private String ufficioRichiedente;
private String nome;
private String cognome;
private String ubicazione;
private String palazzina;
private String piano;
private String scala;
private String stanza;
private String telefono;
private String emailDirigente;
private String assetPc;
private String applicazione;
private String codFiscale;
private String utenza;
private String cambioUfficio;
private String resetPassword;



public String toJSON(){	
		
	return "{\"ufficioRichiedente\"  : \"" + this.ufficioRichiedente + "\" ,\"nome\":\""+this.nome+"\",\"cognome\"  : \"" 
+ this.cognome + "\",\"ubicazione\"  : \"" + this.ubicazione+ "\" ,\"palazzina\":\""+this.palazzina + "\" ,\"piano\":\""+this.piano
+ "\" ,\"scala\":\""+this.scala+ "\" ,\"stanza\":\""+this.stanza+ "\" ,\"telefono\":\""+this.telefono+ "\" ,\"emailDirigente\":\""+this.emailDirigente
+ "\" ,\"assetPc\":\""+this.assetPc+ "\" ,\"applicazione\":\""+this.applicazione+ "\" ,\"codFiscale\":\""+this.codFiscale+ "\" ,\"utenza\":\""+this.utenza
+ "\" ,\"cambioUfficio\":\""+this.cambioUfficio+ "\" ,\"resetPassword\":\""+this.resetPassword+ "\"}";
}


public String getUfficioRichiedente() {
	return ufficioRichiedente;
}
public void setUfficioRichiedente(String ufficioRichiedente) {
	this.ufficioRichiedente = ufficioRichiedente;
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
public String getPalazzina() {
	return palazzina;
}
public void setPalazzina(String palazzina) {
	this.palazzina = palazzina;
}
public String getPiano() {
	return piano;
}
public void setPiano(String piano) {
	this.piano = piano;
}
public String getScala() {
	return scala;
}
public void setScala(String scala) {
	this.scala = scala;
}
public String getStanza() {
	return stanza;
}
public void setStanza(String stanza) {
	this.stanza = stanza;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public String getEmailDirigente() {
	return emailDirigente;
}
public void setEmailDirigente(String emailDirigente) {
	this.emailDirigente = emailDirigente;
}
public String getAssetPc() {
	return assetPc;
}
public void setAssetPc(String assetPc) {
	this.assetPc = assetPc;
}
public String getApplicazione() {
	return applicazione;
}
public void setApplicazione(String applicazione) {
	this.applicazione = applicazione;
}
public String getCodFiscale() {
	return codFiscale;
}
public void setCodFiscale(String codFiscale) {
	this.codFiscale = codFiscale;
}
public String getUtenza() {
	return utenza;
}
public void setUtenza(String utenza) {
	this.utenza = utenza;
}
public String getCambioUfficio() {
	return cambioUfficio;
}
public void setCambioUfficio(String cambioUfficio) {
	this.cambioUfficio = cambioUfficio;
}
public String getResetPassword() {
	return resetPassword;
}
public void setResetPassword(String resetPassword) {
	this.resetPassword = resetPassword;
}






}
