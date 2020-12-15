package mef.prenotazione.aule.bean;

public class SalaStrutturaBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private long id_sala;
	private long id_struttura;

	public long getId_sala() {
		return id_sala;
	}

	public void setId_sala(long id_sala) {
		this.id_sala = id_sala;
	}

	public long getId_struttura() {
		return id_struttura;
	}

	public void setId_struttura(long id_struttura) {
		this.id_struttura = id_struttura;
	}

}
