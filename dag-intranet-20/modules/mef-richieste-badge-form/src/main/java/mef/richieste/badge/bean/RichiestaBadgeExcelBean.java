package mef.richieste.badge.bean;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class RichiestaBadgeExcelBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id_richiesta_badge;
	private String nome_richiedente;
	private String cognome_richiedente;
	private String dip_richiedente;
	private String dir_richiedente;
	private String uff_richiedente;
	private String tel_richiedente;
	private String email_richiedente;
	private String data_richiesta;
	private String tipo_richiesta;
	private String stato_richiesta;
	private String dipartimento;
	private String direzione;
	private String ufficio;
	private String referente_mef;
	private String tel_referente_mef;
	private String email_referente_mef;
	private String nome_int;
	private String cognome_int;
	private String cf_int;
	private String luogo_nascita_int;
	private String data_nascita_int;
	private String societa;
	private String sede_legale_societa;
	private String indirizzo;
	private String recapito_tel;
	private String fax;
	private String pec;
	private String email;
	private String referente_societa;
	private String email_referente_societa;
	private String tel_ufficio;
	private String cell;
	private String contratto;
	private String progetto;
	private String piano;
	private String postazione;
	private String sedi;
	private String data_scadenza_badge;
	private String motivazione;
	private String oggetto;
	private String numero_badge;
	private String allegati;
	private String note;
	

	public String getId_richiesta_badge() {
		return id_richiesta_badge;
	}

	public void setId_richiesta_badge(String id_richiesta_badge) {
		this.id_richiesta_badge = id_richiesta_badge;
	}

	public String getNome_richiedente() {
		return nome_richiedente;
	}

	public void setNome_richiedente(String nome_richiedente) {
		this.nome_richiedente = nome_richiedente;
	}

	public String getCognome_richiedente() {
		return cognome_richiedente;
	}

	public void setCognome_richiedente(String cognome_richiedente) {
		this.cognome_richiedente = cognome_richiedente;
	}

	public String getData_richiesta() {
		return data_richiesta;
	}

	public void setData_richiesta(String data_richiesta) {
		this.data_richiesta = data_richiesta;
	}

	public String getStato_richiesta() {
		return stato_richiesta;
	}

	public void setStato_richiesta(String stato_richiesta) {
		this.stato_richiesta = stato_richiesta;
	}

	public String getNumero_badge() {
		return numero_badge;
	}


	public void setNumero_badge(String numero_badge) {
		this.numero_badge = numero_badge;
	}

	public String getData_scadenza_badge() {
		return data_scadenza_badge;
	}

	public void setData_scadenza_badge(String data_scadenza_badge) {
		this.data_scadenza_badge = data_scadenza_badge;
	}

	public String getTipo_richiesta() {
		return tipo_richiesta;
	}

	public void setTipo_richiesta(String tipo_richiesta) {
		this.tipo_richiesta = tipo_richiesta;
	}

	public String getDip_richiedente() {
		return dip_richiedente;
	}

	public void setDip_richiedente(String dip_richiedente) {
		this.dip_richiedente = dip_richiedente;
	}

	public String getDir_richiedente() {
		return dir_richiedente;
	}

	public void setDir_richiedente(String dir_richiedente) {
		this.dir_richiedente = dir_richiedente;
	}

	public String getUff_richiedente() {
		return uff_richiedente;
	}

	public void setUff_richiedente(String uff_richiedente) {
		this.uff_richiedente = uff_richiedente;
	}

	public String getTel_richiedente() {
		return tel_richiedente;
	}

	public void setTel_richiedente(String tel_richiedente) {
		this.tel_richiedente = tel_richiedente;
	}

	public String getEmail_richiedente() {
		return email_richiedente;
	}

	public void setEmail_richiedente(String email_richiedente) {
		this.email_richiedente = email_richiedente;
	}

	public String getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(String dipartimento) {
		this.dipartimento = dipartimento;
	}

	public String getDirezione() {
		return direzione;
	}

	public void setDirezione(String direzione) {
		this.direzione = direzione;
	}

	public String getUfficio() {
		return ufficio;
	}

	public void setUfficio(String ufficio) {
		this.ufficio = ufficio;
	}

	public String getReferente_mef() {
		return referente_mef;
	}

	public void setReferente_mef(String referente_mef) {
		this.referente_mef = referente_mef;
	}

	public String getTel_referente_mef() {
		return tel_referente_mef;
	}

	public void setTel_referente_mef(String tel_referente_mef) {
		this.tel_referente_mef = tel_referente_mef;
	}

	public String getEmail_referente_mef() {
		return email_referente_mef;
	}

	public void setEmail_referente_mef(String email_referente_mef) {
		this.email_referente_mef = email_referente_mef;
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

	public String getLuogo_nascita_int() {
		return luogo_nascita_int;
	}

	public void setLuogo_nascita_int(String luogo_nascita_int) {
		this.luogo_nascita_int = luogo_nascita_int;
	}

	public String getData_nascita_int() {
		return data_nascita_int;
	}
	
	public void setData_nascita_int(String data_nascita_int) {
		this.data_nascita_int = data_nascita_int;
	}

	public String getSocieta() {
		return societa;
	}

	public void setSocieta(String societa) {
		this.societa = societa;
	}

	public String getSede_legale_societa() {
		return sede_legale_societa;
	}

	public void setSede_legale_societa(String sede_legale_societa) {
		this.sede_legale_societa = sede_legale_societa;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getRecapito_tel() {
		return recapito_tel;
	}

	public void setRecapito_tel(String recapito_tel) {
		this.recapito_tel = recapito_tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPec() {
		return pec;
	}

	public void setPec(String pec) {
		this.pec = pec;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReferente_societa() {
		return referente_societa;
	}

	public void setReferente_societa(String referente_societa) {
		this.referente_societa = referente_societa;
	}

	public String getEmail_referente_societa() {
		return email_referente_societa;
	}

	public void setEmail_referente_societa(String email_referente_societa) {
		this.email_referente_societa = email_referente_societa;
	}
	
	public String getTel_ufficio() {
		return tel_ufficio;
	}

	public void setTel_ufficio(String tel_ufficio) {
		this.tel_ufficio = tel_ufficio;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getContratto() {
		return contratto;
	}

	public void setContratto(String contratto) {
		this.contratto = contratto;
	}

	public String getProgetto() {
		return progetto;
	}

	public void setProgetto(String progetto) {
		this.progetto = progetto;
	}

	public String getPiano() {
		return piano;
	}

	public void setPiano(String piano) {
		this.piano = piano;
	}

	public String getPostazione() {
		return postazione;
	}

	public void setPostazione(String postazione) {
		this.postazione = postazione;
	}

	public String getSedi() {
		return sedi;
	}

	public void setSedi(String sedi) {
		this.sedi = sedi;
	}

	public String getMotivazione() {
		return motivazione;
	}

	public void setMotivazione(String motivazione) {
		this.motivazione = motivazione;
	}

	public String getOggetto() {
		return oggetto;
	}

	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}

	public String getAllegati() {
		return allegati;
	}

	public void setAllegati(String allegati) {
		this.allegati = allegati;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public JSONObject toJSONObject() {

		JSONObject jo = JSONFactoryUtil.createJSONObject();

		jo.put("id_richiesta_badge", this.getId_richiesta_badge());
		jo.put("nome_richiedente", this.getNome_richiedente());
		jo.put("cognome_richiedente", this.getCognome_richiedente());
		jo.put("dip_richiedente", this.getDip_richiedente());
		jo.put("dir_richiedente", this.getDir_richiedente());
		jo.put("uff_richiedente", this.getUff_richiedente());
		jo.put("tel_richiedente", this.getTel_richiedente());
		jo.put("email_richiedente", this.getEmail_richiedente());
		jo.put("data_richiesta", this.getData_richiesta());
		jo.put("tipo_richiesta", this.getTipo_richiesta());
		jo.put("stato_richiesta", this.getStato_richiesta());
		jo.put("dipartimento", this.getDipartimento());
		jo.put("direzione", this.getDirezione());
		jo.put("ufficio", this.getUfficio());
		jo.put("referente_mef", this.getReferente_mef());
		jo.put("tel_referente_mef", this.getTel_referente_mef());
		jo.put("email_referente_mef", this.getEmail_referente_mef());
		jo.put("nome_int", this.getNome_int());
		jo.put("cognome_int", this.getCognome_int());
		jo.put("cf_int", this.getCf_int());
		jo.put("luogo_nascita_int", this.getLuogo_nascita_int());
		jo.put("data_nascita_int", this.getData_nascita_int());
		jo.put("societa", this.getSocieta());
		jo.put("sede_legale_societa", this.getSede_legale_societa());
		jo.put("indirizzo", this.getIndirizzo());
		jo.put("recapito_tel", this.getRecapito_tel());
		jo.put("fax", this.getFax());
		jo.put("pec", this.getPec());
		jo.put("email", this.getEmail());
		jo.put("referente_societa", this.getReferente_societa());
		jo.put("email_referente_societa", this.getEmail_referente_societa());
		jo.put("tel_ufficio", this.getTel_ufficio());
		jo.put("cell", this.getCell());
		jo.put("contratto", this.getContratto());
		jo.put("progetto", this.getProgetto());
		jo.put("piano", this.getPiano());
		jo.put("postazione", this.getPostazione());
		jo.put("sedi", this.getSedi());
		jo.put("data_scadenza_badge", this.getData_scadenza_badge());
		jo.put("motivazione", this.getMotivazione());
		jo.put("oggetto", this.getOggetto());
		jo.put("numero_badge", this.getNumero_badge());
		jo.put("allegati", this.getAllegati());
		jo.put("note", this.getNote());
		
		return jo;

	}
	
}