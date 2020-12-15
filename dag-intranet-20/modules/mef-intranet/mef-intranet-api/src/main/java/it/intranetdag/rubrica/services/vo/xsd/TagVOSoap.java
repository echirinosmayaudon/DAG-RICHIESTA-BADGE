package it.intranetdag.rubrica.services.vo.xsd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import aQute.bnd.annotation.ProviderType;

@ProviderType
public class TagVOSoap implements Serializable{

	
	public static TagVOSoap toSoapModel(TagVO model) {
		TagVOSoap soapModel = new TagVOSoap();
		soapModel.setIdTAg(model.getIdTAg());	
		soapModel.setNumUffAssoc(model.getNumUffAssoc());
		soapModel.setTagCount(model.getTagCount());
		soapModel.setTagName(model.getTagName());
		return soapModel;
	}
	
	
	public static TagVOSoap[] toSoapModels(TagVO[] models) {
		TagVOSoap[] soapModels = new TagVOSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}
	
	public static TagVOSoap[][] toSoapModels(TagVO[][] models) {
		TagVOSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TagVOSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TagVOSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}
	
	public static TagVOSoap[] toSoapModels(List<TagVO> models) {
		List<TagVOSoap> soapModels = new ArrayList<TagVOSoap>(models.size());

		for (TagVO model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TagVOSoap[soapModels.size()]);
	}
	
	public TagVOSoap(){
		
	}
	  protected Integer idTAg;
	  protected Integer numUffAssoc;
	  protected Integer tagCount;
	  protected JAXBElement<String> tagName;
	  protected JAXBElement<String> tagNameAcronym;
	  
	  
	  
	public Integer getIdTAg() {
		return idTAg;
	}
	public void setIdTAg(Integer idTAg) {
		this.idTAg = idTAg;
	}
	public Integer getNumUffAssoc() {
		return numUffAssoc;
	}
	public void setNumUffAssoc(Integer numUffAssoc) {
		this.numUffAssoc = numUffAssoc;
	}
	public Integer getTagCount() {
		return tagCount;
	}
	public void setTagCount(Integer tagCount) {
		this.tagCount = tagCount;
	}
	public JAXBElement<String> getTagName() {
		return tagName;
	}
	public void setTagName(JAXBElement<String> tagName) {
		this.tagName = tagName;
	}

	
	
	
}
