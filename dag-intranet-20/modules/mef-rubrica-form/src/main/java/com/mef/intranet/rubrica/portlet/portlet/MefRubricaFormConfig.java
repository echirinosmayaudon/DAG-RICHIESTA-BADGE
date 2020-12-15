package com.mef.intranet.rubrica.portlet.portlet;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.mef.intranet.rubrica.portlet.portlet.MefRubricaFormConfig")
public interface MefRubricaFormConfig {
	
	@Meta.AD(deflt = "10", required = false)
	public int itemsPerPage(); 
	
	@Meta.AD(deflt = "6", required = false)
	public String lastResearch();

}

