package mef.organigramma.portlet;

import aQute.bnd.annotation.metatype.Meta;
@Meta.OCD(id ="mef.organigramma.portlet.MefOrganigrammaConfig")
public interface MefOrganigrammaConfig {

	
	@Meta.AD(required = false)
	public String officeDetailUrl();
	
	
	
	
}
