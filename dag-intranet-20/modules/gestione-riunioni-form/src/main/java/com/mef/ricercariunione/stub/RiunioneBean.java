package com.mef.ricercariunione.stub;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RiunioneBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id_riunione;
	private Date data_inizio;
	private String protocollo;
	private String tipoRiunione;
	private String statoRiunione;
	private String oggetto;
	private String convocante;
	private String luogo;

	private Long id_stato_riunione;
	private Date data_ultimo_sollecito;
	
	private boolean flagSollecita;
	
	private List<Segreteria> listSegreteria;

	public String getOggetto() {
		return oggetto;
	}

	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}

	public String getConvocante() {
		return convocante;
	}

	public void setConvocante(String convocante) {
		this.convocante = convocante;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public boolean isFlagSollecita() {
		return flagSollecita;
	}

	public void setFlagSollecita(boolean flagSollecita) {
		this.flagSollecita = flagSollecita;
	}

	public Long getId_stato_riunione() {
		return id_stato_riunione;
	}

	public void setId_stato_riunione(Long id_stato_riunione) {
		this.id_stato_riunione = id_stato_riunione;
	}

	public Date getData_ultimo_sollecito() {
		return data_ultimo_sollecito;
	}

	public void setData_ultimo_sollecito(Date data_ultimo_sollecito) {
		this.data_ultimo_sollecito = data_ultimo_sollecito;
	}

	public Long getId_riunione() {
		return id_riunione;
	}

	public void setId_riunione(Long id_riunione) {
		this.id_riunione = id_riunione;
	}

	public Date getData_inizio() {
		return data_inizio;
	}

	public void setData_inizio(Date data_inizio) {
		this.data_inizio = data_inizio;
	}

	public String getProtocollo() {
		return protocollo;
	}

	public void setProtocollo(String protocollo) {
		this.protocollo = protocollo;
	}

	public String getTipoRiunione() {
		return tipoRiunione;
	}

	public void setTipoRiunione(String tipoRiunione) {
		this.tipoRiunione = tipoRiunione;
	}

	public String getStatoRiunione() {
		return statoRiunione;
	}

	public void setStatoRiunione(String statoRiunione) {
		this.statoRiunione = statoRiunione;
	}

	public List<Segreteria> getListSegreteria() {
		return listSegreteria;
	}

	public void setListSegreteria(List<Segreteria> listSegreteria) {
		this.listSegreteria = listSegreteria;
	}
	
	
}
