package com.accenture.mef.lavoro.agile.form.bean;

import com.accenture.lavoro.agile.istanza.mef.model.OpzioneRich;
import com.accenture.lavoro.agile.istanza.mef.service.OpzioneRichLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class Opzione {

	private Long id ;
	private Long idDipendenza;
	private String testoOpzione;
	private String tipo;
	private String[] valore;
	private int peso;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdDipendenza() {
		return idDipendenza;
	}
	public void setIdDipendenza(Long idDipendenza) {
		this.idDipendenza = idDipendenza;
	}
	public String getTestoOpzione() {
		return testoOpzione;
	}
	public void setTestoOpzione(String testoOpzione) {
		this.testoOpzione = testoOpzione;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String[] getValore() {
		return valore;
	}
	public void setValore(String[] valore) {
		this.valore = valore;
	}
	public int getPeso() {
		if( ("true").equals(this.getValore()[0]) ){
			return this.peso;
		} 
		return 0;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public String toJSON () {
		
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("id", this.getId());
		json.put("id_dip", this.getIdDipendenza());
		json.put("type", this.getTipo());
		json.put("valore", this.getValore() );

		return json.toJSONString();
	}
	
	public void setOpzioneByJSON ( JSONObject jsonObject) throws PortalException {
		
		JSONArray json_valore = jsonObject.getJSONArray("valore");
		valore = new String[json_valore.length()];
		for(int i = 0; i < json_valore.length(); i++) {
		    valore[i] = json_valore.getString(i);
		}
		
		this.setId(jsonObject.getLong("id"));
		this.setTipo(jsonObject.getString("type"));
		this.setIdDipendenza(jsonObject.getLong("id_dip"));
		this.setValore( valore );
		
		OpzioneRich tmp_rich = OpzioneRichLocalServiceUtil.fetchOpzioneRich( this.getId() );
		this.peso = 0;
		if( tmp_rich != null ){
			this.setPeso( tmp_rich.getPeso_opt() );			
		}

	}
	
}
