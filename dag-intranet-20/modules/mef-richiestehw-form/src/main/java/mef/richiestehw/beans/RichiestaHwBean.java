package mef.richiestehw.beans;

public class RichiestaHwBean implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String tipologia;
	private String quantita;
	private String note;
	
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public String getQuantita() {
		return quantita;
	}
	public void setQuantita(String quantita) {
		this.quantita = quantita;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	
}
