package it.intranetdag.rubrica.services.vo.xsd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import aQute.bnd.annotation.ProviderType;



@ProviderType
public class SuggestCognomeVOSoap implements Serializable {
	
	public static SuggestCognomeVOSoap toSoapModel(SuggestCognomeVO model) {
		SuggestCognomeVOSoap soapModel = new SuggestCognomeVOSoap();
		soapModel.setLastName(model.getLastName());	
		return soapModel;
	}
	
	
	public static SuggestCognomeVOSoap[] toSoapModels(SuggestCognomeVO[] models) {
		SuggestCognomeVOSoap[] soapModels = new SuggestCognomeVOSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}
	
	public static SuggestCognomeVOSoap[][] toSoapModels(SuggestCognomeVO[][] models) {
		SuggestCognomeVOSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SuggestCognomeVOSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SuggestCognomeVOSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}
	
	
	public static SuggestCognomeVOSoap[] toSoapModels(List<SuggestCognomeVO> models) {
		List<SuggestCognomeVOSoap> soapModels = new ArrayList<SuggestCognomeVOSoap>(models.size());

		for (SuggestCognomeVO model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SuggestCognomeVOSoap[soapModels.size()]);
	}
	
	
	public SuggestCognomeVOSoap(){
		
	}
	
	protected JAXBElement<String> lastName;
	
	 public JAXBElement<String> getLastName() {
	        return lastName;
	    }
	 
	  public void setLastName(JAXBElement<String> value) {
	        this.lastName = value;
	    }
}
