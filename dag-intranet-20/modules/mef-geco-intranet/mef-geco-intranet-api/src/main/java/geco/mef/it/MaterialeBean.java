package geco.mef.it;

public class MaterialeBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String gruppo;
	private String sottogruppo;
	private String  scheda;
	private String qtarichiesta;
	
	public String getGruppo() {
		return gruppo;
	}
	public void setGruppo(String gruppo) {
		this.gruppo = gruppo;
	}
	public String getSottogruppo() {
		return sottogruppo;
	}
	public void setSottogruppo(String sottogruppo) {
		this.sottogruppo = sottogruppo;
	}
	public String getScheda() {
		return scheda;
	}
	public void setScheda(String scheda) {
		this.scheda = scheda;
	}
	public String getQtarichiesta() {
		return qtarichiesta;
	}
	public void setQtarichiesta(String qtarichiesta) {
		this.qtarichiesta = qtarichiesta;
	}
	
	
	
	
	
	
}
