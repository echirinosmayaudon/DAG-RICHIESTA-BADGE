package it.intranetdag.rubrica.services.vo.xsd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import aQute.bnd.annotation.ProviderType;

@ProviderType
public class UfficioVOSoap implements Serializable{
	
	
	public static UfficioVOSoap toSoapModel(UfficioVO model) {
		UfficioVOSoap soapModel = new UfficioVOSoap();
		soapModel.setAcronimo(model.getAcronimo());	
		soapModel.setCodStruttura(model.getCodStruttura());	
		return soapModel;
	}
	
	public static UfficioVOSoap[] toSoapModels(UfficioVO[] models) {
		UfficioVOSoap[] soapModels = new UfficioVOSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}
	
	public static UfficioVOSoap[][] toSoapModels(UfficioVO[][] models) {
		UfficioVOSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UfficioVOSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UfficioVOSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}
	
	public static UfficioVOSoap[] toSoapModels(List<UfficioVO> models) {
		List<UfficioVOSoap> soapModels = new ArrayList<UfficioVOSoap>(models.size());

		for (UfficioVO model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UfficioVOSoap[soapModels.size()]);
	}
	
	public UfficioVOSoap(){
		
	}
	
	protected JAXBElement<String> acronimo;
    protected JAXBElement<String> codStruttura;
    
	public JAXBElement<String> getAcronimo() {
		return acronimo;
	}
	public void setAcronimo(JAXBElement<String> acronimo) {
		this.acronimo = acronimo;
	}
	public JAXBElement<String> getCodStruttura() {
		return codStruttura;
	}
	public void setCodStruttura(JAXBElement<String> codStruttura) {
		this.codStruttura = codStruttura;
	}
	 
	 
}
