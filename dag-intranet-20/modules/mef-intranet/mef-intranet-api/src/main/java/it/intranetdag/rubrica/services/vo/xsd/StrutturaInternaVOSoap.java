package it.intranetdag.rubrica.services.vo.xsd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import aQute.bnd.annotation.ProviderType;

@ProviderType
public class StrutturaInternaVOSoap implements Serializable{

	
	public static StrutturaInternaVOSoap toSoapModel(StrutturaInternaVO model) {
		StrutturaInternaVOSoap soapModel = new StrutturaInternaVOSoap();
		soapModel.setAcronimo(model.getAcronimo());	
		soapModel.setCodStruttura(model.getCodStruttura());	
		return soapModel;
	}	
	
	
	public static StrutturaInternaVOSoap[] toSoapModels(StrutturaInternaVO[] models) {
		StrutturaInternaVOSoap[] soapModels = new StrutturaInternaVOSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}
	
	public static StrutturaInternaVOSoap[][] toSoapModels(StrutturaInternaVO[][] models) {
		StrutturaInternaVOSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StrutturaInternaVOSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StrutturaInternaVOSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}
	
	public static StrutturaInternaVOSoap[] toSoapModels(List<StrutturaInternaVO> models) {
		List<StrutturaInternaVOSoap> soapModels = new ArrayList<StrutturaInternaVOSoap>(models.size());

		for (StrutturaInternaVO model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StrutturaInternaVOSoap[soapModels.size()]);
	}
	
	public StrutturaInternaVOSoap(){
		
	}
	
protected JAXBElement<String> acronimo;
protected JAXBElement<String> codStruttura;
	
public JAXBElement<String> getAcronimo() {
    return acronimo;
}
public void setAcronimo(JAXBElement<String> value) {
    this.acronimo = value;
}
public JAXBElement<String> getCodStruttura() {
    return codStruttura;
}

public void setCodStruttura(JAXBElement<String> value) {
    this.codStruttura = value;
}

}
