package mef.richieste.figli.form.portlet;


import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.pdfbox.io.IOUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import mef.richieste.figli.form.Configuration.mefRichiesteFigliFormConfiguration;
import mef.richieste.figli.form.bean.ConfigurationBean;
import mef.richieste.figli.form.bean.ModuloRichiedente;
import mef.richieste.figli.form.bean.Richiedente;
import mef.richieste.figli.form.bean.UtenteRichiedente;
import mef.richieste.figli.form.constants.MefRichiesteFigliFormPortletKeys;
import mef.richieste.figli.form.util.AllegatoDLUtil;
import mef.richieste.figli.form.util.MefFigliUtils;
import mef.richieste.figli.form.util.PDFSender;
import mef.richieste.figli.model.RICHIESTA_RIMBORSO;
import mef.richieste.figli.service.RICHIESTA_RIMBORSOLocalServiceUtil;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=Mef-Portlet",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=MefRichiesteFigliForm", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MefRichiesteFigliFormPortletKeys.MEFRICHIESTEFIGLIFORM,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class MefRichiesteFigliFormPortlet extends MVCPortlet {

	Log _log = LogFactoryUtil.getLog(this.getClass());

	private static String ROOT_FOLDER_NAME = "Rimborso Centri Estivi";
	private static long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	// private static long FOLDER_ID = DLFolderConstants.

	private String FOLDER_NAME = "";
	
	private final static String RIEPILO = "/functions/richiesta-riepilogo.jsp";
	
	private final static String baseDirName = "Istanza per la concessione contributo figli";
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
	
/* 	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		_log.debug("SONO NEL METODO AJAX");
		
		Enumeration<String> keys = resourceRequest.getAttributeNames();
		while(keys.hasMoreElements()) {
			String key = keys.nextElement();
			_log.debug("============================>"+key+": "+resourceRequest.getAttribute(key) );
		}
		AllegatoDLUtil allegatoDLUtil = new AllegatoDLUtil();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User currentUser;
		ServiceContext serviceContext;
		try {
			currentUser = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
			serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), resourceRequest);
			String folderNameRichiesta = "RICHIESTA RIMBORSO_" + currentUser.getScreenName();
			allegatoDLUtil.deleteFolder(baseDirName, PARENT_FOLDER_ID, currentUser.getUserId(), serviceContext, themeDisplay, folderNameRichiesta);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error("PROBLEMA CON CHIAMATA AJAX " );
		}
		
		 super.serveResource(resourceRequest, resourceResponse);
	} */
	

	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		PortletPreferences preferences = renderRequest.getPreferences();
		String subject = preferences.getValue("subjectRichiestaRimborso", _configuration.subjectRichiestaRimborso());
		String emailReferente = preferences.getValue("emailReferente", _configuration.emailReferente());
		String sender = preferences.getValue("senderInvito", _configuration.senderRichiestaRimborso());
		String body = preferences.getValue("richiestaRimborsoTmpl", _configuration.richiestaRimborsoTmpl());
		String data = preferences.getValue("dataRichiestaRimborso", _configuration.dataRichiestaRimborso());
		String dimensioneAllegato = preferences.getValue("dimensioneAllegato", _configuration.dimensioneAllegato());
		String oggettoPDF = preferences.getValue("oggettoPDF", _configuration.oggettoPDF());
		String richiestaPDF = preferences.getValue("richiestaPDF", _configuration.richiestaPDF());
		String spesaSostenutaPDF = preferences.getValue("spesaSostenutaPDF", _configuration.spesaSostenutaPDF());
		String eventualiNotePDF = preferences.getValue("eventualiNotePDF", _configuration.eventualiNotePDF());
		
		renderRequest.setAttribute("subjectRichiestaRimborso", subject);
		renderRequest.setAttribute("emailReferente", emailReferente);
		renderRequest.setAttribute("senderInvito", sender);
		renderRequest.setAttribute("richiestaRimborsoTmpl", body);
		renderRequest.setAttribute("dataRichiestaRimborso", data);
		renderRequest.setAttribute("dimensioneAllegato", dimensioneAllegato);
		renderRequest.setAttribute("oggettoPDF", oggettoPDF);
		renderRequest.setAttribute("richiestaPDF", richiestaPDF);
		renderRequest.setAttribute("spesaSostenutaPDF", spesaSostenutaPDF);
		renderRequest.setAttribute("eventualiNotePDF", eventualiNotePDF);
		renderRequest.setAttribute(mefRichiesteFigliFormConfiguration.class.getName(), _configuration);
		ModuloRichiedente moduloRichiedente = new ModuloRichiedente();

		List<ModuloRichiedente> moduliRichieste = new ArrayList<ModuloRichiedente>();

		try {
			if (Validator.isNotNull(PortalUtil.getUser(renderRequest))) {
				ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
				
				User utente = PortalUtil.getUser(renderRequest);
				MefFigliUtils mefUtils = new MefFigliUtils();
				Richiedente utenteRichiedente = mefUtils.createRichiedente(utente, themeDisplay.getCompanyId());
				//renderRequest.setAttribute("utenteRichiedente", getUtenteRicheidente(utente));
				renderRequest.setAttribute("utenteRichiedente", utenteRichiedente);

			} else {

			}

		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		moduliRichieste.add(moduloRichiedente);

		renderRequest.setAttribute("moduliRichieste", moduliRichieste);
		renderRequest.setAttribute("moduloRichiedente", moduloRichiedente);

		super.doView(renderRequest, renderResponse);
	}
	
	public void goToServiziTrasportiRiepilogo(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortalException {
		actionRequest.setAttribute("viewDivError", false);
		hiddenDefaultMessage(actionRequest);
		_log.debug("=======================================>goToServiziTrasportiRiepilogo");
		//RECUPERO CONFIGURAZIONE DA FORM
		PortletPreferences preferences = actionRequest.getPreferences();
		String dimensioneAllegatoRecuperata = preferences.getValue("dimensioneAllegato", _configuration.dimensioneAllegato());
		_log.debug("**************** DIMENSIONE FILE RECUPERATA " + dimensioneAllegatoRecuperata);
		
		
		
		//CONTROLLO CODICE FISCALE
		_log.debug("CONTROLLO CODICI FISCALE INSERITI");
		Integer counterFigli = Integer.parseInt(actionRequest.getParameter("counterFigli"));
			//recupero data dalla configurazione
		
		String dataConfig = preferences.getValue("dataRichiestaRimborso", _configuration.dataRichiestaRimborso());
		_log.debug("DATA CONFIGURAZIONE RECUPERATA: " + dataConfig);
			//parso la stringa come yyyy-MM-dd
		Date dataConfigParsed = null;
		try {
			 dataConfigParsed =new SimpleDateFormat("yyyy-MM-dd").parse(dataConfig);
			
		} catch (ParseException e1) {
			_log.debug("DATA NON PARSABILE PRENDO VALORE DI DEFAULT 30-09-2020" + e1);
			try {
				dataConfigParsed =new SimpleDateFormat("yyyy-MM-dd").parse("2020-09-30");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				_log.debug("ERRORE PARSING DATA DI DEFAULT " + e);
			}
		}
		//CONFIGURO DATA MAX E DATA MIN
		Calendar cal = Calendar.getInstance();
	    cal.setTime(dataConfigParsed);
		cal.add(Calendar.YEAR, -15);
		cal.setTime(dataConfigParsed);
		cal.add(Calendar.YEAR, -5);
		cal.add(Calendar.DATE, 1);
		cal.setTime(dataConfigParsed);
		cal.add(Calendar.YEAR, -15);
		cal.add(Calendar.DATE, 1);
		Date dataMin = cal.getTime();
		cal.setTime(dataConfigParsed);
		cal.add(Calendar.YEAR, -5);
		Date dataMax = cal.getTime();
		
		_log.debug("DATA MAX : " + dataMax + " " + dataMax.getClass() + " DATA MIN: " + dataMin + " " + dataMin.getClass());
		
		boolean checkCF = false;
		for (int i = 1; i <= counterFigli; i++) {
			String codiceFiscale = "";
			if(Validator.isNotNull((actionRequest.getParameter("CFFiglio" + i)))){
				
				codiceFiscale = actionRequest.getParameter("CFFiglio" + i);
				String data_cf = codiceFiscale.substring(6,11);
				String anno = data_cf.substring(0,2);
				anno="20"+anno;
				String mese =  data_cf.substring(2,3);
				Long giorno = Long.parseLong(data_cf.substring(3,5));    
				_log.debug("DATA_CF : " + data_cf + "   ANNO: " + anno + " MESE: " + mese + " GIORNO: " + giorno);
				//CONTROLLO GIORNO
				if(giorno>71){
					checkCF=true;
				}else if(giorno>31 && giorno<41){
					checkCF=true;
			     }else if(giorno>40 && giorno<72) {
			    	 giorno = giorno-40;
			     }
				//CONTROLLO MESE
				long meseN = getMeseFromCF(mese);
				if(meseN<1 || meseN>12) {
					checkCF=true;
				}
				//TRASFORMO IN DATA IL CF
				String sDate1 = giorno+"/"+meseN+"/"+anno;
				Date dateCF = null;
				_log.debug("DATA RECUPERATA DA CF " + sDate1);
				try {
					dateCF=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
				//CONTROLLO ANNO
				 if(dateCF.before(dataMin) || dateCF.after(dataMax)) {
					 checkCF = true;
				 }

			}
		}
	
		//FINE CONTROLLO CODICE FISCALE
		
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletSession session = actionRequest.getPortletSession();
		
		
		//Utente richiedente
		
		User utente = PortalUtil.getUser(actionRequest);
		MefFigliUtils mefUtils = new MefFigliUtils();
		Richiedente richiedente = mefUtils.createRichiedente(utente, themeDisplay.getCompanyId());
		
		//Richiedente richiedente = new Richiedente();

		
		//richiedente.setNome(utenteRichiedente.getNOMINATIVO());
		//richiedente.setCognome(utenteRichiedente.getNOMINATIVO());
		//richiedente.setTelefono(actionRequest.getParameter("TelefonoUtente"));
		//richiedente.setCodiceFiscale(utenteRichiedente.getCODICE_FISCALE());
		//richiedente.setNumContoCorrente(actionRequest.getParameter("Numconto"));
		//richiedente.setTipoContoCorrente(actionRequest.getParameter("tipoContoCorrente"));
		richiedente.setIban(actionRequest.getParameter("IbanFiglio"));
		richiedente.setEventualiNote(actionRequest.getParameter("NoteRimborso"));
		
		int[] rowIndexes = ParamUtil.getIntegerValues(actionRequest, "rowIndexes", new int[1]);
		
		
		_log.debug("*_*_*_*_*_*_*_*_*_*_*_*_*_ --> COUNTER FIGLI " + counterFigli);
		_log.debug("=============>Numero di figli: "+Arrays.asList(rowIndexes));

		//Recupero il file
		
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		PortletSession sessione = actionRequest.getPortletSession();
		
		File file = uploadPortletRequest.getFile("documento");
		boolean noFile = false;
		String mimeTypeFile="";
		try {
			mimeTypeFile = Files.probeContentType(file.toPath());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(Validator.isNull(mimeTypeFile) && Validator.isNull((file)) && Validator.isNotNull(sessione.getAttribute("fileEntryFiglio"))) {
			noFile=true;
		}
		//SET E GET DEL FILE IN SESSIONE
		
		else if(!(file.exists() && file.length()>0)) {
			if( Validator.isNotNull(sessione.getAttribute("fileEntryFiglio"))){
				_log.debug("*************************** ---> RECUPERO IL FILE DALLA SESSIONE " );
			FileEntry fileEntryFiglio = (FileEntry) sessione.getAttribute("fileEntryFiglio");
			String fileName = fileEntryFiglio.getFileName();
			try {
				file = copyFile(fileEntryFiglio,fileName);
			} catch (IOException e) {
				
				_log.error(e);
			}
			}
			
		}
		
		_log.debug("STAMPO IL FILE RECUPERATO " + file.getAbsolutePath() + "     " + file.getName() + "  " + mimeTypeFile) ;
		String fileNameUpload = uploadPortletRequest.getFileName("documento");
		
		
		String mimeType = MimeTypesUtil.getContentType(file);
		String oldFileName=actionRequest.getParameter("allegatoN");
		_log.debug("============> MI STAMPO L'ALLEGATO DI RITONO: "+fileNameUpload);
		
		//verifico che il nome del file non sia vuoto
		String nomeFile="";
		if(fileNameUpload.equals("")) {
			nomeFile = oldFileName;
		}else {
			nomeFile = fileNameUpload;
		}
		_log.debug("============> MI STAMPO IL NOME DEL FILE: "+nomeFile);
		
		
		//CONTROLLO DATA
		boolean isValidateDate = true;
		for (int i = 1; i <= counterFigli; i++) {
			Date dataNascitaF = new Date();
			if(Validator.isNotNull(actionRequest.getParameter("DataNascitaFiglio" + i))){
			try {
				String dataStringaFiglio = actionRequest.getParameter("DataNascitaFiglio" + i);
				SimpleDateFormat sdfFiglio = new SimpleDateFormat("dd/MM/yyyy");
				dataNascitaF = sdfFiglio.parse(dataStringaFiglio);
				_log.debug("DATA PARSATA " + dataNascitaF);
				_log.debug("VERIFICA : " + (dataNascitaF.before(dataMin) || dataNascitaF.after(dataMax)));
				if(dataNascitaF.before(dataMin) || dataNascitaF.after(dataMax)) {
					_log.debug("CONTROLLO IF DATA " + isValidateDate);
					
					isValidateDate = false;
					break;
				}
				
			} catch (ParseException e) {
				_log.error("ERRORE PARSE DATE NASCITA FIGLIO " , e);
			}
			}else{
				_log.debug("DATA FIGLIO NON RECUPERATA " );
			}
		}
		
		//
		
		List<ModuloRichiedente> listaModuliRichieste = new ArrayList<ModuloRichiedente>();
		for (int i = 1; i <= counterFigli; i++) {
			
			if(Validator.isNotNull(actionRequest.getParameter("NomeFiglio" + i))){
			ModuloRichiedente moduloRichiesta = new ModuloRichiedente();
			StringBuilder importo = new StringBuilder();
			moduloRichiesta.setNomeFiglio(actionRequest.getParameter("NomeFiglio" + i));

			moduloRichiesta.setCognomeFiglio(actionRequest.getParameter("CognomeFiglio" + i));
			moduloRichiesta.setCfFiglio(actionRequest.getParameter("CFFiglio" + i));
			moduloRichiesta.setDataNascitaFiglio(actionRequest.getParameter("DataNascitaFiglio" + i));
			moduloRichiesta.setLuogoNascitaFiglio(actionRequest.getParameter("LuogoNascitaFiglio" + i));
			moduloRichiesta.setIban(actionRequest.getParameter("IbanFiglio"));
			moduloRichiesta.setDescrizione(actionRequest.getParameter("NoteRimborso"));
	
			String importoRichiesta = actionRequest.getParameter("ImportoFiglio" + i);
			
	
			if (!"".equals(importoRichiesta)) {
				String listImportoRichiesta[] = importoRichiesta.split(",");

				if (!importoRichiesta.contains(".")) {
					int number = Integer.parseInt(listImportoRichiesta[0]);
					String txt = String.format("%,d", number);
					txt = txt.replaceAll(",", ".");
					importo.append(txt);

				} else {
					importo.append(listImportoRichiesta[0]);
				}

				if (importoRichiesta.contains(",")) {
					importo.append(",");
					importo.append(listImportoRichiesta[1]);
				} else {
					importo.append(",00");
				}
				moduloRichiesta.setImporto(importo.toString());
			}
			
			

			moduloRichiesta.setAllegatoNome(nomeFile);
			moduloRichiesta.setAllegatoMimeType(mimeType);
			moduloRichiesta.setAllegato(file);
			
			_log.debug("===============> Aggiungo figlio: "+moduloRichiesta);
			
			listaModuliRichieste.add(moduloRichiesta);
			}
			
		}
		
		
		//String numeroCC = actionRequest.getParameter("Numconto");
		//String tipoCC = actionRequest.getParameter("tipoCC");
		String dlURL = "";
			
		actionRequest.setAttribute("counterFigli",counterFigli);
		//actionRequest.setAttribute("numeroCC", numeroCC);
		actionRequest.setAttribute("file", file);
		actionRequest.setAttribute("richiedente", richiedente);
		actionRequest.setAttribute("utenteRichiedente", richiedente );
		//actionRequest.setAttribute("tipoCC", tipoCC);
		actionRequest.setAttribute("allegatoN", nomeFile);
		
				
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
		Folder parentFolder = createAndGetFolder(baseDirName, "Cartella degli allegati", PARENT_FOLDER_ID, richiedente.getUserId(), serviceContext);
					
		String folderNameRichiesta = "RICHIESTA RIMBORSO_" + richiedente.getCodiceFiscale();
		Folder folder = createAndGetFolder(folderNameRichiesta,
				"Cartella degli allegati con CFUtente " + richiedente.getCodiceFiscale(), parentFolder.getFolderId(),
				richiedente.getUserId(), serviceContext);
		_log.debug("=================>Creo la cartella per la richiesta: "+folderNameRichiesta);
			
		String fileEntryId_MOD = actionRequest.getParameter("fEntryID");
		
		boolean checkOldFile = Validator.isNotNull( fileEntryId_MOD );
		_log.debug("Verifico se esiste un file ("+fileEntryId_MOD+") da modificare <"+checkOldFile+">");
		
		DLFileEntry fEntry = null;
		//RECUPERO FENTRYID DA REQUEST
		boolean exsisteFile = false;
		if(!checkOldFile) {
			try {
					//fEntry = DLFileEntryLocalServiceUtil.getFileEntryByName(themeDisplay.getScopeGroupId(), folder.getFolderId(),nomeFile );
					List<DLFileEntry> listaFile = DLFileEntryLocalServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), folder.getFolderId());
					for(DLFileEntry dlFile : listaFile) {
						_log.debug("DLFILE NAME TROVATO NEL FOR    _-> " + dlFile.getFileName());
						if(dlFile.getFileName().equals(nomeFile)) {
							_log.debug("SONO ENTRATO NEL FOR PER CHECK FILE ");
							fEntry= dlFile;
							fileEntryId_MOD = Long.toString(fEntry.getFileEntryId());
							_log.debug("***************** -> FILE ENTRY DA DLFileEntryLocalServiceUtil : " + fileEntryId_MOD);
							exsisteFile = true;
							break;
						}
					}
					
					
			}catch ( Exception pe) {
				_log.error("Impossibile trovare il file",pe);
				exsisteFile = false;
			}
		}else {
			List<DLFileEntry> listaFile = DLFileEntryLocalServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), folder.getFolderId());
			for(DLFileEntry dlFile : listaFile) {
				_log.debug("DLFILE NAME TROVATO NEL FOR    _-> " + dlFile.getFileName());
				if(dlFile.getFileName().equals(nomeFile)) {
					_log.debug("SONO ENTRATO NEL FOR ");
					exsisteFile = true;
		}
				}
		}
		if(exsisteFile){
			_log.debug("================>Il file esiste. Viene eliminato.");
			try{
				_log.debug("FILE ENTRY RECUPERATO " + fileEntryId_MOD);
				DLAppLocalServiceUtil.deleteFileEntry(Long.parseLong(fileEntryId_MOD));
			}catch(Exception e ) {
				_log.error("ERRORE NELLA CANCELLAZIONE DEL FILE " + e);
			}
		}
		
		FileEntry fileEntry = null;
		try {
			_log.debug("CARICO IL FILE" + nomeFile + "    " + file);
			fileEntry = fileUpload(themeDisplay, actionRequest, folder, nomeFile, file, mimeType);
			String allegatoUuid = fileEntry.getUuid();
			if(Validator.isNull(dlURL))
				dlURL = getDlFileDownloadUrl(fileEntry.getFileEntryId(), actionRequest);
			_log.debug("DLFILE URL RECUPERATO" + dlURL);
			actionRequest.setAttribute("allegatoUuid", allegatoUuid);
			actionRequest.setAttribute("fEntryID", Long.toString(fileEntry.getFileEntryId()));
			
		} catch (Exception e) {
			_log.error("Errore nell'upload del file <"+nomeFile+"> ",e);
			//TODO Impostare il ritorno alla view.jsp con tutti i paramatri inseriti e segnalare che c'è stato un errore!!
			actionRequest.removeAttribute("allegatoUuid");
			actionRequest.removeAttribute("fEntryID");
			actionRequest.removeAttribute("allegatoN");
			actionRequest.removeAttribute("file");
			actionRequest.removeAttribute("fEntryID");
			actionRequest.setAttribute("cfErrorUpload", true);
			actionRequest.setAttribute("viewDivError", true);
			String ibanF = actionRequest.getParameter("IbanFiglio");
			actionRequest.setAttribute("IbanF", ibanF);
			actionRequest.setAttribute("Note", actionRequest.getParameter("NoteRimborso"));
			actionRequest.setAttribute("dataRichiestaRimborso2", dataConfig);
			actionRequest.setAttribute("moduliRichieste", listaModuliRichieste);
			actionRequest.setAttribute("erroreAllegatoNoFile", true);
			//String dimensioneAllegato = preferences.getValue("dimensioneAllegato", _configuration.dimensioneAllegato());
			actionRequest.setAttribute("dimensioneAllegatoRiepilogo",dimensioneAllegatoRecuperata);
			actionResponse.setRenderParameter("mvcPath", "/view.jsp");
			return;
		}
		
		
		if(file!=null){
			byte[] data = new byte[(int) file.length()];		
			try {
				data = FileUtil.getBytes(file);
			} catch (IOException e) {
				_log.error("Errore nel recupero del bytaArray", e);
			}
			session.setAttribute("byteArrayFile",data);
		}
		if(noFile) {
		
			actionRequest.setAttribute("errorNoFile", true);
			
			String ibanF = actionRequest.getParameter("IbanFiglio");
			actionRequest.setAttribute("IbanF", ibanF);
			actionRequest.setAttribute("Note", actionRequest.getParameter("NoteRimborso"));
			actionRequest.setAttribute("dataRichiestaRimborso2", dataConfig);
			actionRequest.setAttribute("moduliRichieste", listaModuliRichieste);
			actionRequest.setAttribute("viewDivError", true);
			//String dimensioneAllegato = preferences.getValue("dimensioneAllegato", _configuration.dimensioneAllegato());
			actionRequest.setAttribute("dimensioneAllegatoRiepilogo",dimensioneAllegatoRecuperata);
			actionResponse.setRenderParameter("mvcPath", "/view.jsp");
		}
		
		
		if(checkCF || !isValidateDate ) {
			
	        
			if(checkCF) {
				SessionErrors.add(actionRequest, "error.mef.cf");
				actionRequest.setAttribute("cfError", true);
			}else if(!isValidateDate) {
				SessionErrors.add(actionRequest, "error.mef.datafiglio");
				actionRequest.setAttribute("dataFiglioError", true);
			}
						
			actionRequest.setAttribute("viewDivError", true);
			String ibanF = actionRequest.getParameter("IbanFiglio");
			actionRequest.setAttribute("IbanF", ibanF);
			actionRequest.setAttribute("Note", actionRequest.getParameter("NoteRimborso"));
			actionRequest.setAttribute("dataRichiestaRimborso2", dataConfig);
			actionRequest.setAttribute("moduliRichieste", listaModuliRichieste);
			//String dimensioneAllegato = preferences.getValue("dimensioneAllegato", _configuration.dimensioneAllegato());
			actionRequest.setAttribute("dimensioneAllegatoRecuperata",dimensioneAllegatoRecuperata);
			actionRequest.setAttribute("dlURL", dlURL);
			actionResponse.setRenderParameter("mvcPath", "/view.jsp");
		} else {
			actionRequest.setAttribute("cfError", false);
			//String dimensioneAllegato = preferences.getValue("dimensioneAllegato", _configuration.dimensioneAllegato());
			actionRequest.setAttribute("dimensioneAllegatoRiepilogo",dimensioneAllegatoRecuperata);
			actionRequest.setAttribute("listaModuliRichieste", listaModuliRichieste);
			actionRequest.setAttribute("dlURL", dlURL);
			actionResponse.setRenderParameter("mvcPath", RIEPILO);
			setConfigurationForPortlet(actionRequest);			
		}
		
		actionRequest.setAttribute("dimensioneAllegatoRiepilogo", dimensioneAllegatoRecuperata);
		
	}
	
	
	
	private File copyFile(FileEntry fileEntryFiglio, String fileName) throws PortalException, IOException {
		
		File tempFile = File.createTempFile(fileName,"");
		_log.debug("Creo il file temp: "+tempFile);
		FileOutputStream out = new FileOutputStream(tempFile);
		
		IOUtils.copy(fileEntryFiglio.getContentStream(), out);
		return tempFile;
		
		
		
	}


	public void setConfigurationForPortlet(PortletRequest request){
		PortletPreferences preferences = request.getPreferences();
		String dimensioneAllegato = preferences.getValue("dimensioneAllegato", _configuration.dimensioneAllegato());
		request.setAttribute("dimensioneAllegato",dimensioneAllegato);
	}
	
	

	public static long getDocumentFolderId(User user, long repositoryId, String folderName, Long parentFolderId,
			ServiceContext serviceContext) {
		Folder folder = null;

		try {

			folder = DLAppLocalServiceUtil.getFolder(repositoryId, parentFolderId, folderName);

			// log.debug("Document Directory: " +folderName+" trovata");
		} catch (Exception e) {
			/* If not -> create */

			try {

				folder = DLAppLocalServiceUtil.addFolder(user.getUserId(), repositoryId, parentFolderId, folderName,
						"documenti " + folderName, serviceContext);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// _log.debug("Document Directory: " +folderName+" creato");
		}
		if (folder == null)
			return 0;
		else
			return folder.getFolderId();
	}

	@ProcessAction(name = "eventoRichiestaRimborso")
	public void eventoRichiestaRimborso(ActionRequest actionRequest, ActionResponse actionResponse)
			throws AddressException, UnsupportedEncodingException, PortalException {
		hiddenDefaultMessage(actionRequest);
		
		String evento = actionRequest.getParameter("evento");

		_log.debug("Entro in eventoRichiestaRimborso...." + evento);
	
		User utente = null;


		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
		
		try {

			utente = PortalUtil.getUser(actionRequest);

			actionRequest.setAttribute("utente", utente);

		} catch (PortalException e) {

			e.printStackTrace();
		}
		
		PortletSession session = actionRequest.getPortletSession();
		
		FileEntry fileEntryS = (FileEntry) session.getAttribute("fileEntry"); 
		
		byte[] byteArrayFile = (byte[]) session.getAttribute("byteArrayFile");
		
		File fileS = null;
		
		try {
			
			fileS = FileUtil.createTempFile(byteArrayFile);
		
		} catch (IOException e1) {
		
			e1.printStackTrace();
		}
		
		_log.debug("byteeeeeee "+ byteArrayFile);
		
		if(fileEntryS!=null) {
			session.removeAttribute("fileEntry");
			
		}
		
		
		
		
		String nomeAllegato = actionRequest.getParameter("allegatoN");
		int rowIndexes = Integer.parseInt(actionRequest.getParameter("LListRich"));
		Integer counterFigli = Integer.parseInt(actionRequest.getParameter("counterFigli"));
		List<ModuloRichiedente> moduliRichiedente = new ArrayList<ModuloRichiedente>();

		for (int i = 1; i <= counterFigli; i++) {
			if(Validator.isNotNull(actionRequest.getParameter("NomeF" + String.valueOf(i)))){
			StringBuilder importoModuloRichiesta = new StringBuilder();
			ModuloRichiedente moduloRichiedente = new ModuloRichiedente();

			moduloRichiedente.setNomeFiglio(actionRequest.getParameter("NomeF" + String.valueOf(i)));
			moduloRichiedente.setCognomeFiglio(actionRequest.getParameter("CognomeF" + String.valueOf(i)));
			String dataNascitaFiglio = (actionRequest.getParameter("DataNF" + String.valueOf(i)));
//			try {
//				dataNascitaFiglio = sdf2.format(sdf1.parse(actionRequest.getParameter("DataNF" + String.valueOf(i))));
//				
//				
//				_log.debug("DATA FORMATTATA : " + dataNascitaFiglio);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				_log.error("Impossibile formattare la data " + e );
//			}
			
			moduloRichiedente.setDataNascitaFiglio(dataNascitaFiglio);
			moduloRichiedente.setLuogoNascitaFiglio(actionRequest.getParameter("LuogoNF" + String.valueOf(i)));
			moduloRichiedente.setCfFiglio(actionRequest.getParameter("CFF" + String.valueOf(i)));
			moduloRichiedente.setAllegato(new File(actionRequest.getParameter("Allegato")));
			moduloRichiedente.setAllegatoNome(actionRequest.getParameter("allegatoN"));
			_log.debug("=========>ALLEGATO NOME MODIFICA: "+actionRequest.getParameter("allegatoN"));
			moduloRichiedente.setAllegatoMimeType(actionRequest.getParameter("AllegatoMimeType"));
			moduloRichiedente.setDescrizione(actionRequest.getParameter("Note"));
			moduloRichiedente.setIban(actionRequest.getParameter("IbanF"));

			String importoRichiestaModulo = actionRequest.getParameter("ImportoF" + String.valueOf(i));

			if (!"".equals(importoRichiestaModulo)) {
				String listImportoRichiesta[] = importoRichiestaModulo.split(",");

				if (!importoRichiestaModulo.contains(".")) {
					int number = Integer.parseInt(listImportoRichiesta[0]);
					String txt = String.format("%,d", number);
					txt = txt.replaceAll(",", ".");
					importoModuloRichiesta.append(txt);

				} else {
					importoModuloRichiesta.append(listImportoRichiesta[0]);
				}

				if (importoRichiestaModulo.contains(",")) {
					importoModuloRichiesta.append(",");
					importoModuloRichiesta.append(listImportoRichiesta[1]);
				} else {
					importoModuloRichiesta.append(",00");
				}

				moduloRichiedente.setImporto(importoModuloRichiesta.toString());

				moduliRichiedente.add(moduloRichiedente);
			}
			}
		}

		_log.debug("evento: " + actionRequest.getParameter("evento"));
		
		
		if(evento.equals("modifica")) {
			
_log.debug("*************** Sono dentro Modifica ***************");
			PortletPreferences preferences = actionRequest.getPreferences();
			String dataConfigurazione = preferences.getValue("dataRichiestaRimborso",_configuration.dataRichiestaRimborso());	
			String dimensioneModifica = preferences.getValue("dimensioneAllegato",_configuration.dimensioneAllegato());

			
			String allegatoN = actionRequest.getParameter("allegatoN");
			String dlURL = actionRequest.getParameter("dlURL");	
			actionRequest.setAttribute("dlURL",dlURL);
			actionRequest.setAttribute("fileS", fileS);
			actionRequest.setAttribute("dataRichiestaRimborso2", dataConfigurazione);
			actionRequest.setAttribute("dimensioneModifica", dimensioneModifica );
			actionRequest.setAttribute("moduliRichieste", moduliRichiedente);
			_log.debug("=============>Lista  Moduli richiedente "+moduliRichiedente);
			
			
			actionRequest.setAttribute("allegatoN", allegatoN);
			actionRequest.setAttribute("IbanF", actionRequest.getParameter("IbanF"));
			actionRequest.setAttribute("Note", actionRequest.getParameter("Note"));
			//actionRequest.setAttribute("tipoCC", actionRequest.getParameter("tipoCC"));	
			//actionRequest.setAttribute("numCC", actionRequest.getParameter("numCC"));
			actionRequest.setAttribute("fEntryID", actionRequest.getParameter("fEntryID"));
			
			//COUNTER FIGLI MODIFICA
			actionRequest.setAttribute("counterFigli",actionRequest.getParameter("counterFigli"));
			_log.debug("SONO IN MODIFICA COUNTER FIGLI RECUPERATO : " + actionRequest.getParameter("counterFigli"));
			
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			MefFigliUtils mefUtils = new MefFigliUtils();
			Richiedente richiedente = mefUtils.createRichiedente(utente, themeDisplay.getCompanyId());
			//actionRequest.setAttribute("utenteRichiedente", getUtenteRicheidente(utente));
			actionRequest.setAttribute("utenteRichiedente", richiedente);
			
			if(Validator.isNotNull(actionRequest.getAttribute("folderId"))) {
				Long folderId = Long.parseLong((String)(actionRequest.getAttribute("folderId")));
				DLFolderLocalServiceUtil.deleteDLFolder(folderId);
			}
			
			actionResponse.setRenderParameter("mvcPath", "/view.jsp");
			
		} // FINE EVENTO MODIFICA

		
		
		File file = null;
		
		
		if (evento.equals("invio")) {
				
			_log.debug("EVENTO INVIO");

			try {
			//List<com.liferay.portal.kernel.model.Address> listaIndirizzi = utente.getAddresses();
			//List<Phone> numeriTelefoniciUtente = utente.getPhones();

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			MefFigliUtils mefUtils = new MefFigliUtils();
			Richiedente richiedente = mefUtils.createRichiedente(utente, themeDisplay.getCompanyId());
			
		
			richiedente.setIban(actionRequest.getParameter("IbanF"));
			richiedente.setEventualiNote(actionRequest.getParameter("Note"));

			

			String fileAllegato=null;
			for (ModuloRichiedente moduloRich : moduliRichiedente) {

				
				fileAllegato= moduloRich.getAllegatoNome();
			}
			List<RICHIESTA_RIMBORSO> listaRichiesteRimborso = new ArrayList<RICHIESTA_RIMBORSO>();
			for (int i = 1; i <= rowIndexes; i++) {
				_log.debug("Sono dentro il for della lista richieste");
				Long id = CounterLocalServiceUtil.increment(RICHIESTA_RIMBORSO.class.getName());

				RICHIESTA_RIMBORSO richiestaRimborso = RICHIESTA_RIMBORSOLocalServiceUtil.createRICHIESTA_RIMBORSO(id);

				String dataInserimento = sdf.format(new Date());

				

				StringBuilder importo = new StringBuilder();
				richiestaRimborso.setNome_Richiedente(actionRequest.getParameter("NomeU"));
				richiestaRimborso.setCognome_Richiedente(actionRequest.getParameter("CognomeU"));
				richiestaRimborso.setTelefono(actionRequest.getParameter("TeleU"));
				richiestaRimborso.setCodice_Fiscale_Richiedente(actionRequest.getParameter("CFU"));
				richiestaRimborso.setFiglio_Nome(actionRequest.getParameter("NomeF" + String.valueOf(i)));
				richiestaRimborso.setFiglio_Cognome(actionRequest.getParameter("CognomeF" + String.valueOf(i)));
				richiestaRimborso.setFiglio_Codice_Fiscale(actionRequest.getParameter("CFF" + String.valueOf(i)));
				richiestaRimborso.setData_Inserimento(dataInserimento);
				
				richiestaRimborso.setFiglio_Data_Nascita(actionRequest.getParameter("DataNF" + String.valueOf(i)));
				richiestaRimborso.setFiglio_Luogo_Nascita(actionRequest.getParameter("LuogoNF" + String.valueOf(i)));
				richiestaRimborso.setIban(actionRequest.getParameter("IbanF"));
				richiestaRimborso.setNote(actionRequest.getParameter("Note"));
				richiestaRimborso.setUtente_Inserimento(utente.getFullName());
				// richiestaRimborso.setImporto(actionRequest.getParameter("ImportoFiglio"));
				richiestaRimborso.setAllegato_UUID(actionRequest.getParameter("AllegatoUuid"));
				richiestaRimborso.setFlag_Inviato(true);

				String importoRichiesta = actionRequest.getParameter("ImportoF" + String.valueOf(i));
				if (!"".equals(importoRichiesta)) {
					String listImportoRichiesta[] = importoRichiesta.split(",");

					if (!importoRichiesta.contains(".")) {
						int number = Integer.parseInt(listImportoRichiesta[0]);
						String txt = String.format("%,d", number);
						txt = txt.replaceAll(",", ".");
						importo.append(txt);

					} else {
						importo.append(listImportoRichiesta[0]);
					}

					if (importoRichiesta.contains(",")) {
						importo.append(",");
						importo.append(listImportoRichiesta[1]);
					} else {
						importo.append(",00");
					}
					richiestaRimborso.setImporto(importo.toString());
					
				}

				listaRichiesteRimborso.add(richiestaRimborso);

				_log.debug("listaRichiesteRimborso: " + listaRichiesteRimborso);

			}

			actionRequest.setAttribute("listaRichiesteRimborso", listaRichiesteRimborso);
			for (RICHIESTA_RIMBORSO richiestaRimborso : listaRichiesteRimborso) {

				// for(ModuloRichiedente moduloRichiedente : moduliRichiedente ) {

				if (richiestaRimborso != null) {

					// PDFSender moduloPDF = new PDFSender(richiedente, moduloRichiedente);
					PortletPreferences preferences = actionRequest.getPreferences();
					String oggettoPDF = preferences.getValue("oggettoPDF", _configuration.oggettoPDF());
					String richiestaPDF = preferences.getValue("richiestaPDF", _configuration.richiestaPDF());
					String spesaSostenutaPDF = preferences.getValue("spesaSostenutaPDF",
							_configuration.spesaSostenutaPDF());
					String eventualiNotePDF = preferences.getValue("eventualiNotePDF",
							_configuration.eventualiNotePDF());
					
					ConfigurationBean confBean = new ConfigurationBean();
					
					confBean.setOggettoPDF(oggettoPDF);
					confBean.setRichiestaPDF(richiestaPDF);
					confBean.setEventualiNotePDF(eventualiNotePDF);
					confBean.setSpesaSostenutaPDF(spesaSostenutaPDF);

					//PDFSender moduloPDF = new PDFSender(richiedente, moduliRichiedente, nomeAllegato);
					PDFSender moduloPDF = new PDFSender(richiedente, moduliRichiedente);
					file = FileUtil.createTempFile("", "pdf");
					_log.debug("----------------->file: " + file);
					 file = moduloPDF.drawPDFModuloListaRichieste(file, confBean);
					_log.debug("----------------->file: " + file);
					
				}
			}
					
					String subject = actionRequest.getPreferences().getValue("subjectRichiestaRimborso",
							_configuration.subjectRichiestaRimborso());
					String emailReferente = actionRequest.getPreferences().getValue("emailReferente",
							_configuration.emailReferente());
					String sender = actionRequest.getPreferences().getValue("senderInvito",
							_configuration.senderRichiestaRimborso());
					String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
					String body = actionRequest.getPreferences().getValue("richiestaRimborsoTmpl",
							_configuration.richiestaRimborsoTmpl());
					subject = StringUtil.replace(subject, new String[] { "[$NOME$]", "[$COGNOME$]" },
							new String[] { richiedente.getNome(), richiedente.getCognome() });

					body = StringUtil.replace(body, new String[] { "[$COGNOME$]", "[$NOME$]", "[$CODICEFISCALE$]" },
							new String[] { richiedente.getCognome(), richiedente.getNome(),
									richiedente.getCodiceFiscale() });
		

					StringBuilder nameFileBuilder = new StringBuilder();
					nameFileBuilder.append("ModuloRichiesta_Rimborso_");
					nameFileBuilder.append(richiedente.getNome());
					nameFileBuilder.append("_");
					nameFileBuilder.append(richiedente.getCognome());
					nameFileBuilder.append("_");
					nameFileBuilder.append(richiedente.getCodiceFiscale());
					nameFileBuilder.append(".pdf");


					
					
				//Invio email 
					MailMessage messaggio = new MailMessage();
					messaggio.setHTMLFormat(true);
					messaggio.setBody(body);
					messaggio.setSubject(subject);
					messaggio.setFrom(new InternetAddress(richiedente.getMail(), sender));
					messaggio.setTo(new InternetAddress(emailReferente));
					//INSERIMENTO FILE PDF
					if(file!=null && file.exists())
						messaggio.addFileAttachment(file, nameFileBuilder.toString());
					//INSERIMENTO FILE ALLEGATO
					if(fileS!=null && file!=null && file.exists()) {
						messaggio.addFileAttachment( fileS,  fileAllegato);
					}
				//Invio email a richiedente
					MailMessage userMessage = new MailMessage();
					userMessage.setHTMLFormat(true);
					userMessage.setBody(body);
					userMessage.setSubject(subject);
					userMessage.setFrom(new InternetAddress(emailReferente));
					userMessage.setTo(new InternetAddress(richiedente.getMail()));
					//INSERIMENTO FILE PDF
					if(file!=null && file.exists())
						userMessage.addFileAttachment(file, nameFileBuilder.toString());
					//INSERIMENTO FILE ALLEGATO
					if(fileS!=null && file!=null && file.exists()) {
						userMessage.addFileAttachment( fileS,  fileAllegato);
					}
					
					
					
					try{
						
						MailServiceUtil.sendEmail(messaggio);
						MailServiceUtil.sendEmail(userMessage);
						for (RICHIESTA_RIMBORSO richiestaRimborso : listaRichiesteRimborso) {
							if (richiestaRimborso != null) {
							richiestaRimborso.setFlag_Inviato(true);
							_log.debug("*************************************** SALVO I DATI SUL DATABASE");
							RICHIESTA_RIMBORSOLocalServiceUtil.updateRICHIESTA_RIMBORSO(richiestaRimborso);
							}
								
							}
					     AllegatoDLUtil allegatoDLUtil = new AllegatoDLUtil();
				         ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
				         String folderName  = "RICHIESTA RIMBORSO_" + richiedente.getCodiceFiscale();
				         boolean delete = allegatoDLUtil.deleteFolder(baseDirName, PARENT_FOLDER_ID, richiedente.getUserId(), serviceContext, themeDisplay, folderName);
				         if(delete) {
				        	 _log.debug("****************** ---> CARTELLA ELIMINATA CORRETTAMENTE");
				         }
				         else {
				        	 _log.debug("PROBLEMA ELIMINAZIONE CARTELLA");
				         }
						actionResponse.setRenderParameter("mvcPath", "/confermaInvio.jsp");
					}catch(Exception e) {

					_log.error("ERRORE INVIO EMAIL" + e);
					SessionErrors.add(actionRequest, "error.mef.mail");
					actionRequest.setAttribute("cfErrorMail", true);
					actionRequest.setAttribute("viewDivError", true);
					actionResponse.setRenderParameter("mvcPath", "/view.jsp");
					//AGGIUNGERE ERRORE IN VIEW
					}
			//CATCH GENERICA PER QUALSIASI EXCEPTION
			}catch(Exception e) {
				_log.error("ERRORE NELL'INVIO DATI: " + e );
				actionRequest.setAttribute("viewDivError", true);
				actionRequest.setAttribute("errorGeneral", true);
				SessionErrors.add(actionRequest, "error.mef");
				
				actionResponse.setRenderParameter("mvcPath", "/view.jsp");
				
			}
					// fine if

			 PortletSession sessione = actionRequest.getPortletSession();
			 //ELIMINO SESSIONE
	         sessione.removeAttribute("fileEntryFiglio");
	    
	}
			
		}
	

	private FileEntry fileUpload(ThemeDisplay themeDisplay, ActionRequest actionRequest, Folder folder, String fileName, File file, String mimeType) throws IOException {

		_log.debug("entra in fileUpload.....");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

		FileEntry fileEntry = null;

		//String fileName = moduloRichiedente.getAllegato().getName();

		_log.debug("fileName : " + fileName);
		
		_log.debug("FILE INPUT STREAM " + file.getAbsolutePath() +" NOME DEL FILE " + file.getName());
		StringBuilder title = new StringBuilder();
		title.append(fileName.substring(0, fileName.lastIndexOf('.')));
		title.append(sdf.format(new Date()));
		title.append(fileName.substring(fileName.lastIndexOf('.')));
		String description = "-";
		long repositoryId = themeDisplay.getScopeGroupId();



		byte[] data = FileUtil.getBytes(file);
		_log.debug("***** METODO FILE UPLOAD - GRANDEZZA DATA " + data.length);
		InputStream is = new FileInputStream(file);
		ServiceContext serviceContext;

		try {
			serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
			long currentUser = themeDisplay.getUser().getUserId();
			List<DLFileEntry> listaFile = DLFileEntryLocalServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), folder.getFolderId());
            for(DLFileEntry dlFile : listaFile) {
                _log.debug("DLFILE NAME TROVATO NEL FOR    _-> " + dlFile.getFileName());
                if(dlFile.getFileName().equals(fileName)) {
                    _log.debug("SONO ENTRATO NEL FOR ALL INTERNO DI FILE UPLOAD");
                    DLFileEntryLocalServiceUtil.deleteDLFileEntry(dlFile);
                    break;
                }
            }
			AllegatoDLUtil allegatoUtil = new AllegatoDLUtil();
			allegatoUtil.setAreaTematica(serviceContext);
			
			fileEntry = DLAppLocalServiceUtil.addFileEntry(currentUser,repositoryId, folder.getFolderId(), fileName, mimeType,
				         data, serviceContext);
			
			 
			
			
			
			
			PortletSession sessione = actionRequest.getPortletSession();
			_log.debug("FILE TROVATO SETTO LA SESSIONE " );
			sessione.setAttribute("fileEntryFiglio", fileEntry,PortletSession.PORTLET_SCOPE);
			
			

		} catch (Exception e) {
			_log.error("Errore nel caricamento ", e);
		} finally {
			is.close();
		}

		return fileEntry;
	}

	private FileEntry fileUploadPdf(ThemeDisplay themeDisplay, ActionRequest actionRequest, File filePDF, String folderName)
			throws IOException {

		_log.debug("entra in fileUploadPDF.....");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

		FileEntry fileEntry = null;

		String fileName = filePDF.getName();
		File file = filePDF;
		String mimeType = MimeTypesUtil.getContentType(filePDF);

		StringBuilder title = new StringBuilder();
		title.append(fileName.substring(0, fileName.lastIndexOf('.')));
		title.append(sdf.format(new Date()));
		title.append(fileName.substring(fileName.lastIndexOf('.')));
		String description = "";
		long repositoryId = themeDisplay.getScopeGroupId();

		Folder folder = getFolder(themeDisplay, folderName);

	

		byte[] data = FileUtil.getBytes(file);

		InputStream is = new FileInputStream(file);
		ServiceContext serviceContext;

		try {

			serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);

			List<AssetCategory> asset_category_strumenti = new ArrayList<AssetCategory>(0);

			DynamicQuery query_asset_category_strumenti = DynamicQueryFactoryUtil.forClass(AssetCategory.class)
					.add(PropertyFactoryUtil.forName("name").eq("strumenti"));
			try {
				asset_category_strumenti = AssetCategoryLocalServiceUtil.dynamicQuery(query_asset_category_strumenti, 0,
						1);
			} catch (Exception e) {
				_log.error("Errore nel recupero dell'area tematica: " + e);
			}

			if (!asset_category_strumenti.isEmpty()) {
				long[] assetCategoryIds = { asset_category_strumenti.get(0).getCategoryId() };
				serviceContext.setAssetCategoryIds(assetCategoryIds);
			}

			long currentUser = themeDisplay.getUser().getUserId();

			fileEntry = DLAppLocalServiceUtil.addFileEntry(currentUser, repositoryId, folder.getFolderId(), fileName,
					mimeType, data, serviceContext);

			Role ownerRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.OWNER);
			Role siteMemberRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.SITE_MEMBER);
			Role guestRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.GUEST);
			Role powerUserRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.POWER_USER);

			ResourcePermissionLocalServiceUtil.removeResourcePermission(themeDisplay.getCompanyId(),
					DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
					String.valueOf(fileEntry.getFileEntryId()), ownerRole.getRoleId(), ActionKeys.VIEW);
			ResourcePermissionLocalServiceUtil.removeResourcePermission(themeDisplay.getCompanyId(),
					DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
					String.valueOf(fileEntry.getFileEntryId()), guestRole.getRoleId(), ActionKeys.VIEW);
			ResourcePermissionLocalServiceUtil.removeResourcePermission(themeDisplay.getCompanyId(),
					DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
					String.valueOf(fileEntry.getFileEntryId()), siteMemberRole.getRoleId(), ActionKeys.VIEW);
			ResourcePermissionLocalServiceUtil.removeResourcePermission(themeDisplay.getCompanyId(),
					DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
					String.valueOf(fileEntry.getFileEntryId()), powerUserRole.getRoleId(), ActionKeys.VIEW);

		} catch (Exception e) {
			_log.debug("errore upload file");
			_log.warn(e);
		} finally {
			is.close();
		}

		return fileEntry;
	}


	public void salvaRimborso(ActionRequest actionRequest, ActionResponse actionResponse) {
 
		_log.debug("Entro in salvaRimborso....");

		Date dataInserimento = new Date();
		Boolean flagInviato = true;
		String dataInserimentoString = sdf.format(dataInserimento);

		Long id = CounterLocalServiceUtil.increment(RICHIESTA_RIMBORSO.class.getName());

		RICHIESTA_RIMBORSO richiestaRimborso = RICHIESTA_RIMBORSOLocalServiceUtil.createRICHIESTA_RIMBORSO(id);

		richiestaRimborso.setNome_Richiedente(actionRequest.getParameter("NomeUtente"));
		richiestaRimborso.setCognome_Richiedente(actionRequest.getParameter("CognomeUtente"));
		richiestaRimborso.setTelefono(actionRequest.getParameter("TelefonoUtente"));
		richiestaRimborso.setCodice_Fiscale_Richiedente(actionRequest.getParameter("CFUtente"));
		richiestaRimborso.setIban(actionRequest.getParameter("Iban"));
		richiestaRimborso.setNote(actionRequest.getParameter("NoteRimborso"));
		richiestaRimborso.setFiglio_Nome(actionRequest.getParameter("NomeFiglio"));
		richiestaRimborso.setFiglio_Cognome(actionRequest.getParameter("CognomeFiglio"));
		richiestaRimborso.setFiglio_Codice_Fiscale(actionRequest.getParameter("CFFiglio"));
		richiestaRimborso.setFiglio_Data_Nascita(actionRequest.getParameter("DataNascitaFiglio"));
		richiestaRimborso.setFiglio_Luogo_Nascita(actionRequest.getParameter("LuogoNascitaFiglio"));
		richiestaRimborso.setImporto(actionRequest.getParameter("Importo"));
		richiestaRimborso.setData_Inserimento(dataInserimentoString);
		richiestaRimborso.setFlag_Inviato(flagInviato);
		richiestaRimborso.setFiglio_Codice_Fiscale(actionRequest.getParameter("CFFiglio"));// si

		ModuloRichiedente moduloRichiedente = new ModuloRichiedente();
		_log.debug("errore *************");
		_log.debug("allegato: " + actionRequest.getParameter("Allegato"));

		String allegatoUuid = "";

		richiestaRimborso.setAllegato_UUID(UUID.randomUUID().toString());

		_log.debug("richiestaRimborsoUUID " + richiestaRimborso.getAllegato_UUID());

		RICHIESTA_RIMBORSOLocalServiceUtil.updateRICHIESTA_RIMBORSO(richiestaRimborso);

	}

	

	private Folder getFolder(ThemeDisplay themeDisplay, String folderName) {
		Folder folder = null;
		try {
			// folder =
			// DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(),PARENT_FOLDER_ID,ROOT_FOLDER_NAME);
			folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, FOLDER_NAME);
		} catch (Exception e) {
			_log.warn(e);
		}
		return folder;
	}
	
	public Folder createAndGetFolder(String name, String description, long parentFolderId, long creatUserId,
			ServiceContext serviceContext) {

		long repositoryId = serviceContext.getScopeGroupId();
		String pattern = "[&,\'@\\\\\\]}\\:=>/<\\[{%|+#`?\\\";~*]";
		String replacedName = name.replaceAll(pattern, "-");
		Folder folder = null;
		try {
			folder = DLAppLocalServiceUtil.getFolder(repositoryId, parentFolderId, replacedName);
		} catch (PortalException e) {
			_log.debug("FOLDER " + replacedName + " NOT FOUND");
			_log.debug("TRY TO CREATE FOLDER " + replacedName);

			try {
				folder = DLAppLocalServiceUtil.addFolder(creatUserId, repositoryId, parentFolderId, replacedName,
						description, serviceContext);
				_log.debug("FOLDER " + replacedName + " CREATED WITH FOLDER ID " + folder.getFolderId());
			} catch (PortalException e1) {
				_log.error("CREATION FOLDER " + replacedName + " FAILED", e1);
			}
		}

		return folder;
	}

	public String getDlFilePreviewUrl(long fileEntryId, PortletRequest request) throws PortalException {

		_log.debug("entro in getDlFilePreviewUrl..... ");

		// Get file entry from DB (here we get it by its AssetEntry instance)
		FileEntry fileEntry = DLAppServiceUtil.getFileEntry(fileEntryId);
		_log.debug("fileName " + fileEntry.getFileName());
		_log.debug("cartella " + fileEntry.getFolder().getName());
		_log.debug("cartella " + fileEntry.getFolder().getParentFolder().getName());

		// Get last version of the file entry
		FileVersion fileVersion = fileEntry.getFileVersion();
		_log.debug("fileVersion " + fileVersion);

		// Get ThemeDisplay instance
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		// If you want to add additional GET parameters you can modify this var
		String queryString = "";

		// Append the requested file version as GET parameter
		boolean appendFileEntryVersion = false;

		// Choose to prefix or not the URL by the portal URL
		boolean useAbsoluteURL = true;

		// Compute the download URL of the file entry
		String dlURL = DLUtil.getPreviewURL(fileEntry, fileVersion, themeDisplay, queryString);

		return dlURL;
	}

	public String getDlFileDownloadUrl(long fileEntryId, PortletRequest request) throws PortalException {

		_log.debug("entro in getDlFilePreviewUrl..... ");

		// Get file entry from DB (here we get it by its AssetEntry instance)
		FileEntry fileEntry = DLAppServiceUtil.getFileEntry(fileEntryId);
		_log.debug("fileName " + fileEntry.getFileName());
		_log.debug("cartella " + fileEntry.getFolder().getName());
		_log.debug("cartella " + fileEntry.getFolder().getParentFolder().getName());

		// Get last version of the file entry
		FileVersion fileVersion = fileEntry.getFileVersion();
		_log.debug("fileVersion " + fileVersion);

		// Get ThemeDisplay instance
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		// If you want to add additional GET parameters you can modify this var
		String queryString = "";

		// Append the requested file version as GET parameter
		boolean appendFileEntryVersion = false;

		// Choose to prefix or not the URL by the portal URL
		boolean useAbsoluteURL = true;

		// Compute the download URL of the file entry
		String dlURL = DLUtil.getDownloadURL(fileEntry, fileVersion, themeDisplay, queryString);

		return dlURL;
	}
	private Long getMeseFromCF(String mese) {
		long meseN = 0L;
		switch (mese) {
	    case "A":
	        meseN = 1;
	        break;
	    case "E":
	        meseN = 5;
	        break;
	    case "P":
	        meseN = 9;
	        break;
	    case "B":
	        meseN = 2;
	        break;
	    case "H":
	        meseN = 6;
	        break;
	    case "R":
	        meseN = 10;
	        break;
	    case "C":
	        meseN = 3;
	        break;
	    case "L":
	        meseN = 7;
	        break;
	    case "S":
	        meseN = 11;
	        break;
	    case "D":
	        meseN = 4;
	        break;
	    case "M":
	        meseN = 8;
	        break;
	    case "T":
	        meseN = 12;
	        break;
	    }
		return meseN;
	}
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(mefRichiesteFigliFormConfiguration.class, properties);
	}

	private volatile mefRichiesteFigliFormConfiguration _configuration;
	
	private void hiddenDefaultMessage(PortletRequest portletRequest) {
		SessionMessages.add(portletRequest,PortalUtil.getPortletId(portletRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		SessionMessages.add(portletRequest,PortalUtil.getPortletId(portletRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}


}