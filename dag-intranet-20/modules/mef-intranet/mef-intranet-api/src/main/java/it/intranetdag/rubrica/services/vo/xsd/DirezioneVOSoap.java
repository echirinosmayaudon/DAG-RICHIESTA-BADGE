package it.intranetdag.rubrica.services.vo.xsd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import aQute.bnd.annotation.ProviderType;

@ProviderType
public class DirezioneVOSoap implements Serializable{

	
	
	public static DirezioneVOSoap toSoapModel(DirezioneVO model) {
		DirezioneVOSoap soapModel = new DirezioneVOSoap();
		
		soapModel.setAcronimo(model.getAcronimo());	
		soapModel.setCodiceStruttura(model.getCodiceStruttura());
	
		return soapModel;
	}
	
	public static DirezioneVOSoap[] toSoapModels(DirezioneVO[] models) {
		DirezioneVOSoap[] soapModels = new DirezioneVOSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}
	
	
	public static DirezioneVOSoap[][] toSoapModels(DirezioneVO[][] models) {
		DirezioneVOSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DirezioneVOSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DirezioneVOSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}
	
	
	public static DirezioneVOSoap[] toSoapModels(List<DirezioneVO> models) {
		List<DirezioneVOSoap> soapModels = new ArrayList<DirezioneVOSoap>(models.size());

		for (DirezioneVO model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DirezioneVOSoap[soapModels.size()]);
	}
	
	
	public DirezioneVOSoap(){
		
	}
	protected JAXBElement<String> acronimo;
    protected JAXBElement<String> codiceStruttura;
    
	public JAXBElement<String> getAcronimo() {
		return acronimo;
	}
	public void setAcronimo(JAXBElement<String> acronimo) {
		this.acronimo = acronimo;
	}
	public JAXBElement<String> getCodiceStruttura() {
		return codiceStruttura;
	}
	public void setCodiceStruttura(JAXBElement<String> codiceStruttura) {
		this.codiceStruttura = codiceStruttura;
	}
    
}
