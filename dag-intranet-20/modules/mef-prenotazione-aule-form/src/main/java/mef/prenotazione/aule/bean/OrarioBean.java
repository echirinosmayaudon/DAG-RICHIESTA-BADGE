package mef.prenotazione.aule.bean;

public class OrarioBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String ora;

	public OrarioBean(String id, String ora) {
		this.id = id;
		this.ora = ora;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOra() {
		return ora;
	}

	public void setOra(String ora) {
		this.ora = ora;
	}

	public String toJSON() {
		return "{\"id\"  : \"" + this.id + "\" ,\"ora\":\"" + this.ora + "\"}";
	}

}
