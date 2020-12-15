package modulistica.mef.portlet;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "modulistica.mef.portlet.ModulisticaMefConfig")
public interface ModulisticaMefConfig {

	@Meta.AD(deflt = "10", required = false)
	public int itemsPerPage(); 
	
	@Meta.AD(required = false)
	public String modulisticaPage(); 

	@Meta.AD(deflt = "Classic", required = false)
	public String viewTheme();
	
	@Meta.AD(deflt = "modulistica", required = false)
	public String folder();
	@Meta.AD(deflt = "15", required = false)
	public String days();
}