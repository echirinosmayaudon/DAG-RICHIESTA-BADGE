package com.mef.ricercariunione.beans;


public class RiunioneRes implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String data_da;
	private String data_a;
	

	private String ispettorato;
	private String parola_chiave;
	private String protocollo;
	private String amministrazione;
	
	
	private long id;
	private String oggetto;
	private String data;
	private String ora_inizio;
	private String tipologia;
	private String stato;
	private String numero_protocollo;
	private String dataUltimoSollecito;
	private String userName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOggetto() {
		return oggetto;
	}

	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getOra_inizio() {
		return ora_inizio;
	}

	public void setOra_inizio(String ora_inizio) {
		this.ora_inizio = ora_inizio;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getNumero_protocollo() {
		return numero_protocollo;
	}

	public void setNumero_protocollo(String numero_protocollo) {
		this.numero_protocollo = numero_protocollo;
	}

	public String getDataUltimoSollecito() {
		return dataUltimoSollecito;
	}

	public void setDataUltimoSollecito(String dataUltimoSollecito) {
		this.dataUltimoSollecito = dataUltimoSollecito;
	}
	
	public String getData_da() {
		return data_da;
	}

	public void setData_da(String data_da) {
		this.data_da = data_da;
	}

	public String getData_a() {
		return data_a;
	}

	public void setData_a(String data_a) {
		this.data_a = data_a;
	}

	public String getIspettorato() {
		return ispettorato;
	}

	public void setIspettorato(String ispettorato) {
		this.ispettorato = ispettorato;
	}

	public String getParola_chiave() {
		return parola_chiave;
	}

	public void setParola_chiave(String parola_chiave) {
		this.parola_chiave = parola_chiave;
	}

	public String getProtocollo() {
		return protocollo;
	}

	public void setProtocollo(String protocollo) {
		this.protocollo = protocollo;
	}

	public String getAmministrazione() {
		return amministrazione;
	}

	public void setAmministrazione(String amministrazione) {
		this.amministrazione = amministrazione;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
