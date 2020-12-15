package mef.richieste.badge.bean;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class RichiestaInScadenzaItemBean  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String id_pk;
	private String id_richiesta;
	private String nome_int;
	private String cognome_int;
	private String cf_int;
	private String numero_badge;
	private String data_scadenza;
	private String tipologia_utente;
	private String societa;
	private String ref_societa;
	private String sedi;
	
	public String getId_pk() {
		return id_pk;
	}
	public void setId_pk(String id_pk) {
		this.id_pk = id_pk;
	}
	public String getId_richiesta() {
		return id_richiesta;
	}
	public void setId_richiesta(String id_richiesta) {
		this.id_richiesta = id_richiesta;
	}
	public String getNome_int() {
		return nome_int;
	}
	public void setNome_int(String nome_int) {
		this.nome_int = nome_int;
	}
	public String getCognome_int() {
		return cognome_int;
	}
	public void setCognome_int(String cognome_int) {
		this.cognome_int = cognome_int;
	}
	public String getCf_int() {
		return cf_int;
	}
	public void setCf_int(String cf_int) {
		this.cf_int = cf_int;
	}
	public String getNumero_badge() {
		return numero_badge;
	}
	public void setNumero_badge(String numero_badge) {
		this.numero_badge = numero_badge;
	}
	public String getData_scadenza() {
		return data_scadenza;
	}
	public void setData_scadenza(String data_scadenza) {
		this.data_scadenza = data_scadenza;
	}
	
	public String getTipologia_utente() {
		return tipologia_utente;
	}
	public void setTipologia_utente(String tipologia_utente) {
		this.tipologia_utente = tipologia_utente;
	}
	public String getSocieta() {
		return societa;
	}
	public void setSocieta(String societa) {
		this.societa = societa;
	}
	public String getRef_societa() {
		return ref_societa;
	}
	public void setRef_societa(String ref_societa) {
		this.ref_societa = ref_societa;
	}
	public String getSedi() {
		return sedi;
	}
	public void setSedi(String sedi) {
		this.sedi = sedi;
	}
	
	public JSONObject toJSONObject() {

		JSONObject jo = JSONFactoryUtil.createJSONObject();

		jo.put("id_pk", this.getId_pk());
		jo.put("id_richiesta", this.getId_richiesta());
		jo.put("nome_int", this.getNome_int());
		jo.put("cognome_int", this.getCognome_int());
		jo.put("cf_int", this.getCf_int());
		jo.put("num_badge", this.getNumero_badge());
		jo.put("data_scadenza", this.getData_scadenza());
		jo.put("tipologia_utente", this.getTipologia_utente());
		jo.put("societa", this.getSocieta());
		jo.put("ref_societa", this.getRef_societa());
		jo.put("sedi", this.getSedi());

		return jo;

	}
	
}
