package geco.mef.it;

import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.StringBundler;

@JSON(strict = true)
public class SottoGruppoBean implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private String codice;
	private String descrizione;
	
	 @JSON
	public String getCodice() {
		return codice;
	}
	 
	public void setCodice(String codice) {
		this.codice = codice;
	}
	 @JSON
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	 @Override
	   	public String toString() {
	   		StringBundler sb = new StringBundler(5);

	   		sb.append("{codice=");
	   		sb.append(getCodice());	
	   		sb.append("{descrizione=");
	   		sb.append(getDescrizione());	
	   		sb.append("}");		
	   		

	   		return sb.toString();
	   	}
	  

}
