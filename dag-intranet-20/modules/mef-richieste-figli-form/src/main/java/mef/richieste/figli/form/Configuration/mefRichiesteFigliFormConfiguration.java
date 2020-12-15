package mef.richieste.figli.form.Configuration;
import aQute.bnd.annotation.metatype.Meta; 
@Meta.OCD(
	    id = "mef.richieste.figli.form.Configuration.mefRichiesteFigliFormConfiguration"
	)
	public interface mefRichiesteFigliFormConfiguration {
	
	@Meta.AD(deflt = "<p>Si invia, in allegato, il modulo per il rimborso "
			+ "delle spese per i figli fiscalmente "
			+ "a carico relativo a [$COGNOME$] [$NOME$] ([$CODICEFISCALE$])</p> ", required = false)
	public String richiestaRimborsoTmpl();
	
	@Meta.AD(deflt = "MEF Centri Estivi", required = false)
	public String senderRichiestaRimborso();
	
	@Meta.AD(deflt = "Richiesta rimborso per figli fiscalmente a carico relativo a [$NOME$] [$COGNOME$]", required = false)
	public String subjectRichiestaRimborso();
	
	@Meta.AD(deflt = "iniziativesocialipersonale.dag@tesoro.it", required = false)
	public String emailReferente();
	
	@Meta.AD(deflt = "2020-09-30", required = false)
	public String dataRichiestaRimborso();
	
	@Meta.AD(deflt = "3", required = false)
	public String dimensioneAllegato();
	
	@Meta.AD(deflt = "Istanza per la concessione del contributo istituito con Regolamento prot. n. 71936 del 8 luglio 2020. ", required = false)
	public String oggettoPDF();
	
	@Meta.AD(deflt = "il contributo previsto dal Regolamento di cui all’oggetto, per le spese sostenute per i centri estivi che offrano un programma di attività ludico-ricreative nel periodo giugno - settembre 2020 per i figli fiscalmente a carico.", required = false)
	public String richiestaPDF();
	
	@Meta.AD(deflt = "Spesa sostenuta nel periodo giugno - settembre 2020 ", required = false)
	public String spesaSostenutaPDF();
	
	@Meta.AD(deflt = "- Dichiara, sotto la propria responsabilita' anche ai sensi del d.P.R. n. 445/2000, che la documentazione inviata e' conforme all'originale dallo stesso conservata e di non aver ricevuto contributi né formulato richieste di contribuzione per la medesima spesa ad altre Amministrazioni, Enti, Societa' o Associazioni e che il proprio nucleo familiare non ha fruito del contributo di cui all'articolo 72, comma 1, lettera c), del decreto legge 19 maggio 2020, n. 34. In corso di conversione;!-!" + 
			" conserva l' originale dell'istanza e la documentazione necessaria, e li esibisce all'Ufficio I della Direzione del Personale in occasioni dei controlli a campione condotti nell'ambito dell'iniziativa;!-!" + 
			" ai sensi dell'art. 13 del Reg. UE n. 2016/679 (GDPR) si informa che i dati personali forniti dall'interessato saranno trattati dalla Direzione del personale esclusivamente ai fini dell'istruttoria necessaria per procedere al rimborso. Per le ulteriori informazioni, si rinvia alla privacy policy del MEF, rinvenibile al seguente link: https://intranet.mef.gov.it/group/guest/privacy1." 
			, required = false)
	public String eventualiNotePDF();
}
