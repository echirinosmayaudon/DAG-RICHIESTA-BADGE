package geco.mef.it;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import aQute.bnd.annotation.ProviderType;
@ProviderType
public class SchedaMaterialeBeanSoap implements Serializable {
	
	public static SchedaMaterialeBeanSoap toSoapModel(SchedaMaterialeBean model) {
		SchedaMaterialeBeanSoap soapModel = new SchedaMaterialeBeanSoap();
		soapModel.setCodiceGruppo(model.getCodiceGruppo());
		soapModel.setCodiceSottogruppo(model.getCodiceSottogruppo());
		soapModel.setNumeroScheda(model.getNumeroScheda());
		soapModel.setDescrizione(model.getDescrizione());
		soapModel.setPrezzoMedio(model.getPrezzoMedio());
		soapModel.setDisponibilita(model.getDisponibilita());
		return soapModel;
	}
	
	public static SchedaMaterialeBeanSoap[] toSoapModels(SchedaMaterialeBean[] models) {
		SchedaMaterialeBeanSoap[] soapModels = new SchedaMaterialeBeanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}
	
	
	public static SchedaMaterialeBeanSoap[][] toSoapModels(SchedaMaterialeBean[][] models) {
		SchedaMaterialeBeanSoap[][] soapModels = new SchedaMaterialeBeanSoap[0][0];

		if (models.length > 0) {
			soapModels = new SchedaMaterialeBeanSoap[models.length][models[0].length];
		}
		
		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}
	
	
	public static SchedaMaterialeBeanSoap[] toSoapModels(List<SchedaMaterialeBean> models) {
		List<SchedaMaterialeBeanSoap> soapModels = new ArrayList<SchedaMaterialeBeanSoap>(models.size());

		for (SchedaMaterialeBean model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SchedaMaterialeBeanSoap[soapModels.size()]);
	}
	
	
	public SchedaMaterialeBeanSoap(){}
	
	String codiceGruppo;
	String codiceSottogruppo;
	String numeroScheda;
	String descrizione;
	String prezzoMedio;
	String disponibilita;
	
	
	public String getCodiceGruppo() {
		return codiceGruppo;
	}
	public void setCodiceGruppo(String codiceGruppo) {
		this.codiceGruppo = codiceGruppo;
	}
	public String getCodiceSottogruppo() {
		return codiceSottogruppo;
	}
	public void setCodiceSottogruppo(String codiceSottogruppo) {
		this.codiceSottogruppo = codiceSottogruppo;
	}
	public String getNumeroScheda() {
		return numeroScheda;
	}
	public void setNumeroScheda(String numeroScheda) {
		this.numeroScheda = numeroScheda;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getPrezzoMedio() {
		return prezzoMedio;
	}
	public void setPrezzoMedio(String prezzoMedio) {
		this.prezzoMedio = prezzoMedio;
	}
	public String getDisponibilita() {
		return disponibilita;
	}
	public void setDisponibilita(String disponibilita) {
		this.disponibilita = disponibilita;
	}
	
	
	
	
	
}
