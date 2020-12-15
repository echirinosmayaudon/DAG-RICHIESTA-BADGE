package bacheca.annunci.list.portlet;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "bacheca.annunci.list.portlet.BachecaAnnunciListConfig")
public interface BachecaAnnunciListConfig {
	
	@Meta.AD(deflt = "list", required = false)
	public String viewTheme();
	
	@Meta.AD(deflt = "Roma,Milano,Napoli,Cagliari", required = false)
	public String zona();
	
	@Meta.AD(deflt = "10", required = false)
	public int itemsPerPage();
	
	@Meta.AD(deflt = "Home", required = false)
	public String bachecaPage();
	
	@Meta.AD(deflt = "mef per me",required = false)
	public String metaAreaCategoria();
	
	@Meta.AD(deflt = "MEF annuncio", required = false)
	public String sender();
	
	@Meta.AD(deflt = "Portale IDAG: Annuncio", required = false)
	public String subject();
	
	@Meta.AD(deflt = "<p>  Sul Portale IDAG &Egrave; presente un nuovo annuncio in Bacheca inserito da [$UTENTEANNUNCIO$]</p> <br/><p><font color=red>Annuncio:</font></p><br/>[$DATI$]<br/><p> Per accedere all'annuncio utilizzare il seguente collegamento: </p><br/><a href='[$LINK$]'> Vai all'annuncio </a><br/><p>---------------------------------------------</p>", required = false)
	public String inserisciannuncioTmpl();
}
