package geco.mef.it;





import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import aQute.bnd.annotation.ProviderType;
@ProviderType
public class SottoGruppoBeanSoap implements Serializable {
	
	//primo metodo setto i valori dal model al soap
	public static SottoGruppoBeanSoap toSoapModel(SottoGruppoBean model) {
		SottoGruppoBeanSoap soapModel = new SottoGruppoBeanSoap();
		soapModel.setCodice(model.getCodice());
		soapModel.setDescrizione(model.getDescrizione());

		return soapModel;
	}
	
	//secondo metodo preparo l'array 
	public static SottoGruppoBeanSoap[] toSoapModels(SottoGruppoBean[] models) {
		SottoGruppoBeanSoap[] soapModels = new SottoGruppoBeanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	
	//terzo metodo metodo preparo l'array bidimensionale
	public static SottoGruppoBeanSoap[][] toSoapModels(SottoGruppoBean[][] models) {
		SottoGruppoBeanSoap[][] soapModels = new SottoGruppoBeanSoap[0][0];

		if (models.length > 0) {
			soapModels = new SottoGruppoBeanSoap[models.length][models[0].length];
		}
	
		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	//quarto metodo preparo l'array dalla lista di stringhe
	public static SottoGruppoBeanSoap[] toSoapModels(List<SottoGruppoBean> models) {
		List<SottoGruppoBeanSoap> soapModels = new ArrayList<SottoGruppoBeanSoap>(models.size());

		for (SottoGruppoBean model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SottoGruppoBeanSoap[soapModels.size()]);
	}
	
	//costruttore
	public SottoGruppoBeanSoap(){}
	
	private String codice;
	private String descrizione;
	
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
	
}
