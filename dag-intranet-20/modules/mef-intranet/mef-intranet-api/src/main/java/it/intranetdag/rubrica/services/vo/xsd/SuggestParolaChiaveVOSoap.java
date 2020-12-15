package it.intranetdag.rubrica.services.vo.xsd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import aQute.bnd.annotation.ProviderType;

@ProviderType
public class SuggestParolaChiaveVOSoap implements Serializable{

	
	public static SuggestParolaChiaveVOSoap toSoapModel(SuggestParolaChiaveVO model) {
		SuggestParolaChiaveVOSoap soapModel = new SuggestParolaChiaveVOSoap();
		soapModel.setParolaChiave(model.getParolaChiave());	
		
		return soapModel;
	}
	
	public static SuggestParolaChiaveVOSoap[] toSoapModels(SuggestParolaChiaveVO[] models) {
		SuggestParolaChiaveVOSoap[] soapModels = new SuggestParolaChiaveVOSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}
	
	
	public static SuggestParolaChiaveVOSoap[][] toSoapModels(SuggestParolaChiaveVO[][] models) {
		SuggestParolaChiaveVOSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SuggestParolaChiaveVOSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SuggestParolaChiaveVOSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}
	
	public static SuggestParolaChiaveVOSoap[] toSoapModels(List<SuggestParolaChiaveVO> models) {
		List<SuggestParolaChiaveVOSoap> soapModels = new ArrayList<SuggestParolaChiaveVOSoap>(models.size());

		for (SuggestParolaChiaveVO model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SuggestParolaChiaveVOSoap[soapModels.size()]);
	}
	
	
	public SuggestParolaChiaveVOSoap(){
		
	}
	
	protected JAXBElement<String> parolaChiave;
	
	  public JAXBElement<String> getParolaChiave() {
	        return parolaChiave;
	    }
	  public void setParolaChiave(JAXBElement<String> value) {
	        this.parolaChiave = value;
	    }
}
