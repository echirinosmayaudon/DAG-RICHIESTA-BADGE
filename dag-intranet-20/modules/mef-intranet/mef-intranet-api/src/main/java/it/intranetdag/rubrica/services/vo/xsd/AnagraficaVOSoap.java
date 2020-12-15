package it.intranetdag.rubrica.services.vo.xsd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import aQute.bnd.annotation.ProviderType;

@ProviderType
public class AnagraficaVOSoap implements Serializable{

	
	public static AnagraficaVOSoap toSoapModel(AnagraficaVO model) {
		AnagraficaVOSoap soapModel = new AnagraficaVOSoap();
		
		soapModel.setAcronimo(model.getAcronimo());	
		soapModel.setAttiva(model.getAttiva());
		soapModel.setCellulare(model.getCellulare());
		soapModel.setCodiceFiscale(model.getCodiceFiscale());
		soapModel.setCodstrutt(model.getCodstrutt());
		soapModel.setComandato(model.getComandato());
		soapModel.setComandatoUffDestinazione(model.getComandatoUffDestinazione());
		soapModel.setComandatoUffProvenienza(model.getComandatoUffProvenienza());
		soapModel.setConsip(model.getConsip());
		soapModel.setCorridoioId(model.getCorridoioId());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setExtraField1(model.getExtraField1());
		soapModel.setExtraField2(model.getExtraField2());
		soapModel.setExtraField3(model.getExtraField3());
		soapModel.setFax(model.getFax());
		soapModel.setFaxUff(model.getFaxUff());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setIncarico(model.getIncarico());
		soapModel.setLastName(model.getLastName());
		soapModel.setLiv1(model.getLiv1());
		soapModel.setLiv2(model.getLiv2());
		soapModel.setLiv3(model.getLiv3());
		soapModel.setLiv4(model.getLiv4());
		soapModel.setLiv5(model.getLiv5());
		soapModel.setLivello1(model.getLivello1());
		soapModel.setLivello2(model.getLivello2());
		soapModel.setLivellogerarchia(model.getLivellogerarchia());
		soapModel.setPianoId(model.getPianoId());
		soapModel.setPosizione(model.getPosizione());
		soapModel.setScalaCorpoId(model.getScalaCorpoId());
		soapModel.setSede(model.getSede());
		soapModel.setSettoreId(model.getSettoreId());
		soapModel.setSex(model.getSex());
		soapModel.setStanzaId(model.getStanzaId());
		soapModel.setTelUffi1(model.getTelUffi1());
		soapModel.setTelUffi2(model.getTelUffi2());
		soapModel.setTelefono(model.getTelefono());
		soapModel.setUbicazione(model.getUbicazione());
	
		return soapModel;
	}
	
	
	public static AnagraficaVOSoap[] toSoapModels(AnagraficaVO[] models) {
		AnagraficaVOSoap[] soapModels = new AnagraficaVOSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}
	
	
	public static AnagraficaVOSoap[][] toSoapModels(AnagraficaVO[][] models) {
		AnagraficaVOSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AnagraficaVOSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnagraficaVOSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}
	
	public static AnagraficaVOSoap[] toSoapModels(List<AnagraficaVO> models) {
		List<AnagraficaVOSoap> soapModels = new ArrayList<AnagraficaVOSoap>(models.size());

		for (AnagraficaVO model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AnagraficaVOSoap[soapModels.size()]);
	}
	
	public AnagraficaVOSoap() {
		
	}
	protected JAXBElement<String> acronimo;
    protected JAXBElement<String> attiva;
    protected JAXBElement<String> cellulare;
    protected Integer codice;
    protected JAXBElement<String> codiceFiscale;
    protected JAXBElement<String> codstrutt;
    protected JAXBElement<String> comandato;
    protected JAXBElement<String> comandatoUffDestinazione;
    protected JAXBElement<String> comandatoUffProvenienza;
    protected JAXBElement<String> consip;
    protected JAXBElement<String> corridoioId;
    protected JAXBElement<String> emailAddress;
    protected JAXBElement<String> extraField1;
    protected JAXBElement<String> extraField2;
    protected JAXBElement<String> extraField3;
    protected JAXBElement<String> fax;
    protected JAXBElement<String> faxUff;
    protected JAXBElement<String> firstName;
    protected JAXBElement<String> incarico;
    protected JAXBElement<String> lastName;
    protected JAXBElement<String> liv1;
    protected JAXBElement<String> liv2;
    protected JAXBElement<String> liv3;
    protected JAXBElement<String> liv4;
    protected JAXBElement<String> liv5;
    protected JAXBElement<String> livello1;
    protected JAXBElement<String> livello2;
    protected JAXBElement<String> livellogerarchia;
    protected JAXBElement<String> pianoId;
    protected JAXBElement<String> posizione;
    protected JAXBElement<String> scalaCorpoId;
    protected JAXBElement<String> sede;
    protected JAXBElement<String> settoreId;
    protected JAXBElement<String> sex;
    protected JAXBElement<String> stanzaId;
    protected JAXBElement<String> telUffi1;
    protected JAXBElement<String> telUffi2;
    protected JAXBElement<String> telefono;
    protected JAXBElement<String> ubicazione;
    
	public JAXBElement<String> getAcronimo() {
		return acronimo;
	}
	public void setAcronimo(JAXBElement<String> acronimo) {
		this.acronimo = acronimo;
	}
	public JAXBElement<String> getAttiva() {
		return attiva;
	}
	public void setAttiva(JAXBElement<String> attiva) {
		this.attiva = attiva;
	}
	public JAXBElement<String> getCellulare() {
		return cellulare;
	}
	public void setCellulare(JAXBElement<String> cellulare) {
		this.cellulare = cellulare;
	}
	public Integer getCodice() {
		return codice;
	}
	public void setCodice(Integer codice) {
		this.codice = codice;
	}
	public JAXBElement<String> getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(JAXBElement<String> codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public JAXBElement<String> getCodstrutt() {
		return codstrutt;
	}
	public void setCodstrutt(JAXBElement<String> codstrutt) {
		this.codstrutt = codstrutt;
	}
	public JAXBElement<String> getComandato() {
		return comandato;
	}
	public void setComandato(JAXBElement<String> comandato) {
		this.comandato = comandato;
	}
	public JAXBElement<String> getComandatoUffDestinazione() {
		return comandatoUffDestinazione;
	}
	public void setComandatoUffDestinazione(JAXBElement<String> comandatoUffDestinazione) {
		this.comandatoUffDestinazione = comandatoUffDestinazione;
	}
	public JAXBElement<String> getComandatoUffProvenienza() {
		return comandatoUffProvenienza;
	}
	public void setComandatoUffProvenienza(JAXBElement<String> comandatoUffProvenienza) {
		this.comandatoUffProvenienza = comandatoUffProvenienza;
	}
	public JAXBElement<String> getConsip() {
		return consip;
	}
	public void setConsip(JAXBElement<String> consip) {
		this.consip = consip;
	}
	public JAXBElement<String> getCorridoioId() {
		return corridoioId;
	}
	public void setCorridoioId(JAXBElement<String> corridoioId) {
		this.corridoioId = corridoioId;
	}
	public JAXBElement<String> getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(JAXBElement<String> emailAddress) {
		this.emailAddress = emailAddress;
	}
	public JAXBElement<String> getExtraField1() {
		return extraField1;
	}
	public void setExtraField1(JAXBElement<String> extraField1) {
		this.extraField1 = extraField1;
	}
	public JAXBElement<String> getExtraField2() {
		return extraField2;
	}
	public void setExtraField2(JAXBElement<String> extraField2) {
		this.extraField2 = extraField2;
	}
	public JAXBElement<String> getExtraField3() {
		return extraField3;
	}
	public void setExtraField3(JAXBElement<String> extraField3) {
		this.extraField3 = extraField3;
	}
	public JAXBElement<String> getFax() {
		return fax;
	}
	public void setFax(JAXBElement<String> fax) {
		this.fax = fax;
	}
	public JAXBElement<String> getFaxUff() {
		return faxUff;
	}
	public void setFaxUff(JAXBElement<String> faxUff) {
		this.faxUff = faxUff;
	}
	public JAXBElement<String> getFirstName() {
		return firstName;
	}
	public void setFirstName(JAXBElement<String> firstName) {
		this.firstName = firstName;
	}
	public JAXBElement<String> getIncarico() {
		return incarico;
	}
	public void setIncarico(JAXBElement<String> incarico) {
		this.incarico = incarico;
	}
	public JAXBElement<String> getLastName() {
		return lastName;
	}
	public void setLastName(JAXBElement<String> lastName) {
		this.lastName = lastName;
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
	public JAXBElement<String> getLivello1() {
		return livello1;
	}
	public void setLivello1(JAXBElement<String> livello1) {
		this.livello1 = livello1;
	}
	public JAXBElement<String> getLivello2() {
		return livello2;
	}
	public void setLivello2(JAXBElement<String> livello2) {
		this.livello2 = livello2;
	}
	public JAXBElement<String> getLivellogerarchia() {
		return livellogerarchia;
	}
	public void setLivellogerarchia(JAXBElement<String> livellogerarchia) {
		this.livellogerarchia = livellogerarchia;
	}
	public JAXBElement<String> getPianoId() {
		return pianoId;
	}
	public void setPianoId(JAXBElement<String> pianoId) {
		this.pianoId = pianoId;
	}
	public JAXBElement<String> getPosizione() {
		return posizione;
	}
	public void setPosizione(JAXBElement<String> posizione) {
		this.posizione = posizione;
	}
	public JAXBElement<String> getScalaCorpoId() {
		return scalaCorpoId;
	}
	public void setScalaCorpoId(JAXBElement<String> scalaCorpoId) {
		this.scalaCorpoId = scalaCorpoId;
	}
	public JAXBElement<String> getSede() {
		return sede;
	}
	public void setSede(JAXBElement<String> sede) {
		this.sede = sede;
	}
	public JAXBElement<String> getSettoreId() {
		return settoreId;
	}
	public void setSettoreId(JAXBElement<String> settoreId) {
		this.settoreId = settoreId;
	}
	public JAXBElement<String> getSex() {
		return sex;
	}
	public void setSex(JAXBElement<String> sex) {
		this.sex = sex;
	}
	public JAXBElement<String> getStanzaId() {
		return stanzaId;
	}
	public void setStanzaId(JAXBElement<String> stanzaId) {
		this.stanzaId = stanzaId;
	}
	public JAXBElement<String> getTelUffi1() {
		return telUffi1;
	}
	public void setTelUffi1(JAXBElement<String> telUffi1) {
		this.telUffi1 = telUffi1;
	}
	public JAXBElement<String> getTelUffi2() {
		return telUffi2;
	}
	public void setTelUffi2(JAXBElement<String> telUffi2) {
		this.telUffi2 = telUffi2;
	}
	public JAXBElement<String> getTelefono() {
		return telefono;
	}
	public void setTelefono(JAXBElement<String> telefono) {
		this.telefono = telefono;
	}
	public JAXBElement<String> getUbicazione() {
		return ubicazione;
	}
	public void setUbicazione(JAXBElement<String> ubicazione) {
		this.ubicazione = ubicazione;
	}
    
    
}
