package it.intranetdag.rubrica.services.vo.xsd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import aQute.bnd.annotation.ProviderType;

@ProviderType
public class AnagraficaUfficioSmartVOSoap implements Serializable{

	public static AnagraficaUfficioSmartVOSoap toSoapModel(AnagraficaUfficioSmartVO model) {
		AnagraficaUfficioSmartVOSoap soapModel = new AnagraficaUfficioSmartVOSoap();
		soapModel.setAcronimo(model.getAcronimo());	
		soapModel.setChiaviUfficio(model.getChiaviUfficio());
		soapModel.setDescr(model.getDescr());
		soapModel.setDescrizione(model.getDescrizione());
		soapModel.setDipartimento(model.getDipartimento());
		soapModel.setIdUfficio(model.getIdUfficio());
		soapModel.setLiv1(model.getLiv1());
		soapModel.setLiv2(model.getLiv2());
		soapModel.setLiv3(model.getLiv3());
		soapModel.setLiv4(model.getLiv4());
		soapModel.setLiv5(model.getLiv5());
		soapModel.setLivGerarchia(model.getLivGerarchia());
		return soapModel;
	}	

	public static AnagraficaUfficioSmartVOSoap[] toSoapModels(AnagraficaUfficioSmartVO[] models) {
		AnagraficaUfficioSmartVOSoap[] soapModels = new AnagraficaUfficioSmartVOSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}
	
	
	public static AnagraficaUfficioSmartVOSoap[][] toSoapModels(AnagraficaUfficioSmartVO[][] models) {
		AnagraficaUfficioSmartVOSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AnagraficaUfficioSmartVOSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnagraficaUfficioSmartVOSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}
	
	public static AnagraficaUfficioSmartVOSoap[] toSoapModels(List<AnagraficaUfficioSmartVO> models) {
		List<AnagraficaUfficioSmartVOSoap> soapModels = new ArrayList<AnagraficaUfficioSmartVOSoap>(models.size());

		for (AnagraficaUfficioSmartVO model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AnagraficaUfficioSmartVOSoap[soapModels.size()]);
	}
	
   public AnagraficaUfficioSmartVOSoap(){}	
protected JAXBElement<String> acronimo;
protected List<String> chiaviUfficio;
protected JAXBElement<String> descr;
protected JAXBElement<String> descrizione;
protected JAXBElement<String> dipartimento;
protected JAXBElement<String> idUfficio;
protected JAXBElement<String> liv1;
protected JAXBElement<String> liv2;
protected JAXBElement<String> liv3;
protected JAXBElement<String> liv4;
protected JAXBElement<String> liv5;
protected JAXBElement<String> livGerarchia;

public JAXBElement<String> getAcronimo() {
	return acronimo;
}
public void setAcronimo(JAXBElement<String> acronimo) {
	this.acronimo = acronimo;
}
public List<String> getChiaviUfficio() {
	return chiaviUfficio;
}
public void setChiaviUfficio(List<String> chiaviUfficio) {
	this.chiaviUfficio = chiaviUfficio;
}
public JAXBElement<String> getDescr() {
	return descr;
}
public void setDescr(JAXBElement<String> descr) {
	this.descr = descr;
}
public JAXBElement<String> getDescrizione() {
	return descrizione;
}
public void setDescrizione(JAXBElement<String> descrizione) {
	this.descrizione = descrizione;
}
public JAXBElement<String> getDipartimento() {
	return dipartimento;
}
public void setDipartimento(JAXBElement<String> dipartimento) {
	this.dipartimento = dipartimento;
}
public JAXBElement<String> getIdUfficio() {
	return idUfficio;
}
public void setIdUfficio(JAXBElement<String> idUfficio) {
	this.idUfficio = idUfficio;
}
public JAXBElement<String> getLiv1() {
	return liv1;
}
public void setLiv1(JAXBElement<String> liv1) {
	this.liv1 = liv1;
}
public JAXBElement<String> getLiv2() {
	return liv2;
}
public void setLiv2(JAXBElement<String> liv2) {
	this.liv2 = liv2;
}
public JAXBElement<String> getLiv3() {
	return liv3;
}
public void setLiv3(JAXBElement<String> liv3) {
	this.liv3 = liv3;
}
public JAXBElement<String> getLiv4() {
	return liv4;
}
public void setLiv4(JAXBElement<String> liv4) {
	this.liv4 = liv4;
}
public JAXBElement<String> getLiv5() {
	return liv5;
}
public void setLiv5(JAXBElement<String> liv5) {
	this.liv5 = liv5;
}
public JAXBElement<String> getLivGerarchia() {
	return livGerarchia;
}
public void setLivGerarchia(JAXBElement<String> livGerarchia) {
	this.livGerarchia = livGerarchia;
}



	
}
