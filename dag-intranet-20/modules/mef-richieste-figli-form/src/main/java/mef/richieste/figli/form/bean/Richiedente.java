package mef.richieste.figli.form.bean;

public class Richiedente implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String provinciaNascita;
	private String dataNascita;
	private String luogoNascita;
	private String indirizzo;
	private String citta;
	private String cap;
	private String provincia;
	private String dipartimento;
	private String comandato; //MEF, OTHER, SERVIZIO
	private String servizioDal;
	private String fasciaEconomica;
	private String mail;
	private String telefono;
	private String tipoContoCorrente;
	private String numContoCorrente;
	private String iban;
	private String eventualiNote;
	private long userId;
	
	public Richiedente() {}

	public Richiedente(long userId,String nome, String cognome, String codiceFiscale, String provinciaNascita, String dataNascita,
			String luogoNascita, String indirizzo, String citta, String cap, String provincia, String dipartimento,
			String comandato, String servizioDal, String fasciaEconomica, String mail, String telefono, String tipoContoCorrente, String numContoCorrente, String Iban, String eventualiNote) {
		setUserId(userId);
		setNome(nome);
		setCognome(cognome);
		setCodiceFiscale(codiceFiscale);
		setProvinciaNascita(provinciaNascita);
		setDataNascita(dataNascita);
		setLuogoNascita(luogoNascita);
		setIndirizzo(indirizzo);
		setCitta(citta);
		setCap(cap);
		setProvincia(provincia);
		setDipartimento(dipartimento);
		setComandato(comandato);
		setServizioDal(servizioDal);
		setFasciaEconomica(fasciaEconomica);
		setMail(mail);
		setTelefono(telefono);
		setTipoContoCorrente(tipoContoCorrente);
		setNumContoCorrente(numContoCorrente);
		setIban(Iban);
		
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getEventualiNote() {
		return eventualiNote;
	}

	public void setEventualiNote(String eventualiNote) {
		this.eventualiNote = eventualiNote;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getTipoContoCorrente() {
		return tipoContoCorrente;
	}

	public void setTipoContoCorrente(String tipoContoCorrente) {
		this.tipoContoCorrente = tipoContoCorrente;
	}

	public String getNumContoCorrente() {
		return numContoCorrente;
	}

	public void setNumContoCorrente(String numContoCorrente) {
		this.numContoCorrente = numContoCorrente;
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

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getProvinciaNascita() {
		return provinciaNascita;
	}

	public void setProvinciaNascita(String provinciaNascita) {
		this.provinciaNascita = provinciaNascita;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(String dipartimento) {
		this.dipartimento = dipartimento;
	}

	public String getComandato() {
		return comandato;
	}

	public void setComandato(String comandato) {
		this.comandato = comandato;
	}

	public String getServizioDal() {
		return servizioDal;
	}

	public void setServizioDal(String servizioDal) {
		this.servizioDal = servizioDal;
	}

	public String getFasciaEconomica() {
		return fasciaEconomica;
	}

	public void setFasciaEconomica(String fasciaEconomica) {
		this.fasciaEconomica = fasciaEconomica;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Richiedente [nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale
				+ ", provinciaNascita=" + provinciaNascita + ", dataNascita=" + dataNascita + ", luogoNascita="
				+ luogoNascita + ", indirizzo=" + indirizzo + ", citta=" + citta + ", cap=" + cap + ", provincia="
				+ provincia + ", dipartimento=" + dipartimento + ", comandato=" + comandato + ", servizioDal="
				+ servizioDal + ", fasciaEconomica=" + fasciaEconomica + ", mail=" + mail + ", telefono=" + telefono
				+ ", tipoContoCorrente=" + tipoContoCorrente + ", numContoCorrente=" + numContoCorrente + ", iban="
				+ iban + ", eventualiNote=" + eventualiNote + "]";
	}

	
	
	
	
	
	
	
}
