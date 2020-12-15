package mef.richieste.figli.form.portlet;

public class RichiesteTrasportiException extends Exception {
	private static final long serialVersionUID = 1L;
	
	String message;
	
	

	public RichiesteTrasportiException() {
		super();
	}



	public RichiesteTrasportiException(String message){
		super(message);
	}



	
	
}
