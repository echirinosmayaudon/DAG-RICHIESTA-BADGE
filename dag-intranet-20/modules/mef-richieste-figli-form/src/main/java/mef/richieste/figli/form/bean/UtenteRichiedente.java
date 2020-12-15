package mef.richieste.figli.form.bean;

public class UtenteRichiedente {
	
	
	
	
		private String NOMINATIVO; 
		private String CODICE_FISCALE;
		private String PROVINCIA_NASCITA;
		private String DATA_NASCITA;
		private String LUOGO_NASCITA;

		private String INDIRIZZO;
		private String CITTA;
		private String CAP;
		private String PROVINCIA;

		private String DIPARTIMENTO;
		private String AREA_APPARTENENZA;
		private String EMAIL;
		private String TELEFONO;
		
		private long USERID;
		
		
		
		
		
		
		public UtenteRichiedente(long USERID, String nOMINATIVO, String cODICE_FISCALE, String pROVINCIA_NASCITA,
				String dATA_NASCITA, String lUOGO_NASCITA, String iNDIRIZZO, String cITTA, String cAP, String pROVINCIA,
				String dIPARTIMENTO, String aREA_APPARTENENZA, String eMAIL, String tELEFONO) {
			this.USERID = USERID;
			NOMINATIVO = nOMINATIVO;
			CODICE_FISCALE = cODICE_FISCALE;
			PROVINCIA_NASCITA = pROVINCIA_NASCITA;
			DATA_NASCITA = dATA_NASCITA;
			LUOGO_NASCITA = lUOGO_NASCITA;
			INDIRIZZO = iNDIRIZZO;
			CITTA = cITTA;
			CAP = cAP;
			PROVINCIA = pROVINCIA;
			DIPARTIMENTO = dIPARTIMENTO;
			AREA_APPARTENENZA = aREA_APPARTENENZA;
			EMAIL = eMAIL;
			TELEFONO = tELEFONO;
		}
		public String getNOMINATIVO() {
			return NOMINATIVO;
		}
		public void setNOMINATIVO(String nOMINATIVO) {
			NOMINATIVO = nOMINATIVO;
		}
		public String getCODICE_FISCALE() {
			return CODICE_FISCALE;
		}
		public void setCODICE_FISCALE(String cODICE_FISCALE) {
			CODICE_FISCALE = cODICE_FISCALE;
		}
		public String getPROVINCIA_NASCITA() {
			return PROVINCIA_NASCITA;
		}
		public void setPROVINCIA_NASCITA(String pROVINCIA_NASCITA) {
			PROVINCIA_NASCITA = pROVINCIA_NASCITA;
		}
		public String getDATA_NASCITA() {
			return DATA_NASCITA;
		}
		public void setDATA_NASCITA(String dATA_NASCITA) {
			DATA_NASCITA = dATA_NASCITA;
		}
		public String getLUOGO_NASCITA() {
			return LUOGO_NASCITA;
		}
		public void setLUOGO_NASCITA(String lUOGO_NASCITA) {
			LUOGO_NASCITA = lUOGO_NASCITA;
		}
		public String getINDIRIZZO() {
			return INDIRIZZO;
		}
		public void setINDIRIZZO(String iNDIRIZZO) {
			INDIRIZZO = iNDIRIZZO;
		}
		public String getCITTA() {
			return CITTA;
		}
		public void setCITTA(String cITTA) {
			CITTA = cITTA;
		}
		public String getCAP() {
			return CAP;
		}
		public void setCAP(String cAP) {
			CAP = cAP;
		}
		public String getPROVINCIA() {
			return PROVINCIA;
		}
		public void setPROVINCIA(String pROVINCIA) {
			PROVINCIA = pROVINCIA;
		}
		public String getDIPARTIMENTO() {
			return DIPARTIMENTO;
		}
		public void setDIPARTIMENTO(String dIPARTIMENTO) {
			DIPARTIMENTO = dIPARTIMENTO;
		}
		public String getAREA_APPARTENENZA() {
			return AREA_APPARTENENZA;
		}
		public void setAREA_APPARTENENZA(String aREA_APPARTENENZA) {
			AREA_APPARTENENZA = aREA_APPARTENENZA;
		}
		public String getEMAIL() {
			return EMAIL;
		}
		public void setEMAIL(String eMAIL) {
			EMAIL = eMAIL;
		}
		public String getTELEFONO() {
			return TELEFONO;
		}
		public void setTELEFONO(String tELEFONO) {
			TELEFONO = tELEFONO;
		}
		public long getUSERID() {
			return USERID;
		}
		public void setUSERID(long uSERID) {
			USERID = uSERID;
		}
		@Override
		public String toString() {
			return "UtenteRichiedente [NOMINATIVO=" + NOMINATIVO + ", CODICE_FISCALE=" + CODICE_FISCALE
					+ ", PROVINCIA_NASCITA=" + PROVINCIA_NASCITA + ", DATA_NASCITA=" + DATA_NASCITA + ", LUOGO_NASCITA="
					+ LUOGO_NASCITA + ", INDIRIZZO=" + INDIRIZZO + ", CITTA=" + CITTA + ", CAP=" + CAP + ", PROVINCIA="
					+ PROVINCIA + ", DIPARTIMENTO=" + DIPARTIMENTO + ", AREA_APPARTENENZA=" + AREA_APPARTENENZA
					+ ", EMAIL=" + EMAIL + ", TELEFONO=" + TELEFONO + ", USERID=" + USERID + "]";
		}
		
		
		
		
		
		
	

}
