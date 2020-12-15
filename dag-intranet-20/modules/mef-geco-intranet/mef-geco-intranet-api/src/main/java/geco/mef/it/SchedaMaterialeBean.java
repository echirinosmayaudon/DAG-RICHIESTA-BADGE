package geco.mef.it;

import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.StringBundler;

@JSON(strict = true)
public class SchedaMaterialeBean implements java.io.Serializable{

private static final long serialVersionUID = 1L;

String codiceGruppo;
String codiceSottogruppo;
String numeroScheda;
String descrizione;
String prezzoMedio;
String disponibilita;

@JSON
public String getCodiceGruppo() {
	return codiceGruppo;
}
public void setCodiceGruppo(String codiceGruppo) {
	this.codiceGruppo = codiceGruppo;
}

@JSON
public String getCodiceSottogruppo() {
	return codiceSottogruppo;
}
public void setCodiceSottogruppo(String codiceSottogruppo) {
	this.codiceSottogruppo = codiceSottogruppo;
}

@JSON
public String getNumeroScheda() {
	return numeroScheda;
}
public void setNumeroScheda(String numeroScheda) {
	this.numeroScheda = numeroScheda;
}

@JSON
public String getDescrizione() {
	return descrizione;
}
public void setDescrizione(String descrizione) {
	this.descrizione = descrizione;
}

@JSON
public String getPrezzoMedio() {
	return prezzoMedio;
}
public void setPrezzoMedio(String prezzoMedio) {
	this.prezzoMedio = prezzoMedio;
}

@JSON
public String getDisponibilita() {
	return disponibilita;
}
public void setDisponibilita(String disponibilita) {
	this.disponibilita = disponibilita;
}



@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);
		sb.append("{codiceGruppo=");
		sb.append(getCodiceGruppo());	
		sb.append("{codiceSottogruppo=");
		sb.append(getCodiceSottogruppo());	
		sb.append("{numeroScheda=");
		sb.append(getNumeroScheda());
		sb.append("{descrizione=");
		sb.append(getDescrizione());
		sb.append("{prezzoMedio=");
		sb.append(getPrezzoMedio());
		sb.append("{disponibilita=");
		sb.append(getDisponibilita());
		sb.append("}");		
		
		return sb.toString();
	}
	
	
	
}
