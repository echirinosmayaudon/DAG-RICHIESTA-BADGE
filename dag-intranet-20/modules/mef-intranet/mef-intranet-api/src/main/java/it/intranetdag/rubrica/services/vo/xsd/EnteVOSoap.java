package it.intranetdag.rubrica.services.vo.xsd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import aQute.bnd.annotation.ProviderType;
@ProviderType
public class EnteVOSoap implements Serializable{

	public static EnteVOSoap toSoapModel(EnteVO model) {
		EnteVOSoap soapModel = new EnteVOSoap();		
		soapModel.setAcronimo(model.getAcronimo());	
		soapModel.setCodStruttura(model.getCodStruttura());	
		return soapModel;
	}
	
	public static EnteVOSoap[] toSoapModels(EnteVO[] models) {
		EnteVOSoap[] soapModels = new EnteVOSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}
	
	public static EnteVOSoap[][] toSoapModels(EnteVO[][] models) {
		EnteVOSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EnteVOSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EnteVOSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}
	
	public static EnteVOSoap[] toSoapModels(List<EnteVO> models) {
		List<EnteVOSoap> soapModels = new ArrayList<EnteVOSoap>(models.size());

		for (EnteVO model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EnteVOSoap[soapModels.size()]);
	}
	
	public EnteVOSoap(){
		
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
