package it.intranetdag.rubrica.services.vo.xsd;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;


public class GerarchiaVOSoap {

	public static GerarchiaVOSoap toSoapModel(GerarchiaVO model) {
		GerarchiaVOSoap soapModel = new GerarchiaVOSoap();
		
		soapModel.setCodStrutt(model.getCodStrutt());	
		soapModel.setLiv2(model.getLiv2());
		soapModel.setLiv3(model.getLiv3());
		soapModel.setLiv4(model.getLiv4());
		soapModel.setLiv5(model.getLiv5());
	
		return soapModel;
	}
	
	public static GerarchiaVOSoap[] toSoapModels(GerarchiaVO[] models) {
		GerarchiaVOSoap[] soapModels = new GerarchiaVOSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}
	
	public static GerarchiaVOSoap[][] toSoapModels(GerarchiaVO[][] models) {
		GerarchiaVOSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GerarchiaVOSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GerarchiaVOSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}
	
	public static GerarchiaVOSoap[] toSoapModels(List<GerarchiaVO> models) {
		List<GerarchiaVOSoap> soapModels = new ArrayList<GerarchiaVOSoap>(models.size());

		for (GerarchiaVO model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GerarchiaVOSoap[soapModels.size()]);
	}
	
	public GerarchiaVOSoap(){
		
	}
	 protected JAXBElement<String> codStrutt;	   
	 protected JAXBElement<Object> liv2;	   
	 protected JAXBElement<Object> liv3;	    
	 protected JAXBElement<Object> liv4;	  
	 protected JAXBElement<Object> liv5;
	 
	public JAXBElement<String> getCodStrutt() {
		return codStrutt;
	}
	public void setCodStrutt(JAXBElement<String> codStrutt) {
		this.codStrutt = codStrutt;
	}
	public JAXBElement<Object> getLiv2() {
		return liv2;
	}
	public void setLiv2(JAXBElement<Object> liv2) {
		this.liv2 = liv2;
	}
	public JAXBElement<Object> getLiv3() {
		return liv3;
	}
	public void setLiv3(JAXBElement<Object> liv3) {
		this.liv3 = liv3;
	}
	public JAXBElement<Object> getLiv4() {
		return liv4;
	}
	public void setLiv4(JAXBElement<Object> liv4) {
		this.liv4 = liv4;
	}
	public JAXBElement<Object> getLiv5() {
		return liv5;
	}
	public void setLiv5(JAXBElement<Object> liv5) {
		this.liv5 = liv5;
	}
	 
	 
}
