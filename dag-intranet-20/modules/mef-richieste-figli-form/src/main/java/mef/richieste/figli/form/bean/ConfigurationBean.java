package mef.richieste.figli.form.bean;

public class ConfigurationBean {
	
	private String eventualiNotePDF;
	private String spesaSostenutaPDF;
	private String richiestaPDF;
	private String oggettoPDF;
	
	public ConfigurationBean() {
		super();
	}
	public ConfigurationBean(String eventualiNotePDF, String spesaSostenutaPDF, String richiestaPDF,
			String oggettoPDF) {
		super();
		this.eventualiNotePDF = eventualiNotePDF;
		this.spesaSostenutaPDF = spesaSostenutaPDF;
		this.richiestaPDF = richiestaPDF;
		this.oggettoPDF = oggettoPDF;
	}
	public String getEventualiNotePDF() {
		return eventualiNotePDF;
	}
	public void setEventualiNotePDF(String eventualiNotePDF) {
		this.eventualiNotePDF = eventualiNotePDF;
	}
	public String getSpesaSostenutaPDF() {
		return spesaSostenutaPDF;
	}
	public void setSpesaSostenutaPDF(String spesaSostenutaPDF) {
		this.spesaSostenutaPDF = spesaSostenutaPDF;
	}
	public String getRichiestaPDF() {
		return richiestaPDF;
	}
	public void setRichiestaPDF(String richiestaPDF) {
		this.richiestaPDF = richiestaPDF;
	}
	public String getOggettoPDF() {
		return oggettoPDF;
	}
	public void setOggettoPDF(String oggettoPDF) {
		this.oggettoPDF = oggettoPDF;
	}
	@Override
	public String toString() {
		return "ConfigurationBean [eventualiNotePDF=" + eventualiNotePDF + ", spesaSostenutaPDF=" + spesaSostenutaPDF
				+ ", richiestaPDF=" + richiestaPDF + ", oggettoPDF=" + oggettoPDF + "]";
	}
	
	
	

}
