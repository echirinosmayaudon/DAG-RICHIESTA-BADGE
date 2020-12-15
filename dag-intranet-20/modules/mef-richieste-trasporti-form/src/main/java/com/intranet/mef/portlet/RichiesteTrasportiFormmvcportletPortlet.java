package com.intranet.mef.portlet;

import com.intranet.mef.bean.ModuloRichiedente;
import com.intranet.mef.bean.Richiedente;
import com.intranet.mef.job.siap.model.City;
import com.intranet.mef.job.siap.model.ClassificationLevel;
import com.intranet.mef.job.siap.model.OrganizationChart;
import com.intranet.mef.job.siap.service.CityLocalServiceUtil;
import com.intranet.mef.job.siap.service.ClassificationLevelLocalServiceUtil;
import com.intranet.mef.job.siap.service.OrganizationChartLocalServiceUtil;
import com.intranet.mef.util.EmailSender;
import com.intranet.mef.util.ModuloPdf;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.ResourcePermission;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletMode;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import service.intranet.mef.model.ModuloTrasporti;
import service.intranet.mef.service.ModuloTrasportiLocalServiceUtil;
import servizio.richiesta.trasporti.model.Mobilita;
import servizio.richiesta.trasporti.service.MobilitaLocalServiceUtil;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=Mef-Portlet", "com.liferay.portlet.instanceable=true",
	"javax.portlet.display-name=Mef Richiesta Rimborso Trasporti Portlet", "javax.portlet.init-param.template-path=/",
	"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.resource-bundle=content.Language",
	"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class RichiesteTrasportiFormmvcportletPortlet extends MVCPortlet {
	
	private static final String TEMP_PATH = "/wos1/java/products/liferay/tmp/";
	final Log _log = LogFactoryUtil.getLog(RichiesteTrasportiFormmvcportletPortlet.class);
	private final String _customFieldUserOrg = "idOrgChart";
	private final String _customFieldUserLevel = "levelId";
	private final String _customFieldPersonalId = "personalId";
	private final String _customFieldDateStartFunction = "dateStartFunction";
	private final String _navigation = "navigation";
	private final String _navigationRiepilogo = "riepilogo";
	private final String _navigationHome = "home";
	private final static String baseDir = "/rimborsiTrasporti";
	private static String ROOT_FOLDER_NAME = "com.liferay.portal.kernel.util.TempFileEntryUtil";
	private static long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	
	private Richiedente createStubRichiedente() {
		Richiedente richiedente = new Richiedente();
		richiedente.setNome("");
		richiedente.setCognome("");
		richiedente.setCodiceFiscale("");
		richiedente.setProvinciaNascita("");
		richiedente.setDataNascita("");
		richiedente.setLuogoNascita("");
		richiedente.setIndirizzo("");
		richiedente.setCitta("");
		richiedente.setCap("");
		richiedente.setProvincia("");
		richiedente.setDipartimento("");
		richiedente.setServizioDal("");
		richiedente.setComandato("OTHER");
		richiedente.setFasciaEconomica("");
		richiedente.setMail("");
		richiedente.setTelefono("");
		return richiedente;
	}
	
	private Richiedente createRichiedente(User user, long companyId) {
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		Richiedente richiedente = createStubRichiedente();
		if (user.getFirstName() != null)
			richiedente.setNome(user.getFirstName());
		if (user.getLastName() != null)
			richiedente.setCognome(user.getLastName());
		if (user.getScreenName() != null)
			richiedente.setCodiceFiscale(user.getScreenName());
		try {
			if (user.getBirthday() != null) {
				richiedente.setDataNascita(formatDate.format(user.getBirthday()));
			}
			if (user.getEmailAddress() != null)
				richiedente.setMail(user.getEmailAddress());
			
			List<Address> listaIndirizzi = user.getAddresses();
			List<Phone> listaPhones = user.getPhones();
			for (Address addressItem : listaIndirizzi) {
				if (("Personal").equalsIgnoreCase(addressItem.getType().getName())) {
					if (addressItem.getStreet1() != null)
						richiedente.setIndirizzo(addressItem.getStreet1());
					if (addressItem.getCity() != null) {
						City citta = CityLocalServiceUtil.getCity(addressItem.getCity());
						if (citta != null) {
							if (citta.getProvince() != null)
								richiedente.setProvincia(citta.getProvince());
							if (citta.getName() != null)
								richiedente.setCitta(citta.getName());
							richiedente.setCap(addressItem.getZip());
						}
					}
				}
				if (("Other").equalsIgnoreCase(addressItem.getType().getName())) {
					City cittaNatale = CityLocalServiceUtil.getCity(addressItem.getCity());
					if (cittaNatale != null) {
						if (cittaNatale.getProvince() != null)
							richiedente.setProvinciaNascita(cittaNatale.getProvince());
						if (cittaNatale.getName() != null)
							richiedente.setLuogoNascita(cittaNatale.getName());
					}
				}
			}
			for (Phone phoneItem : listaPhones) {
				if (("Business").equalsIgnoreCase(phoneItem.getType().getName())) {
					if (phoneItem.getNumber() != null)
						richiedente.setTelefono(phoneItem.getNumber());
					break;
				}
			}
			String levelId = (String) user.getExpandoBridge().getAttribute(_customFieldUserLevel);
			if (levelId != null && !("").equals(levelId)) {
				ClassificationLevel areaFascia = ClassificationLevelLocalServiceUtil.getClassificationLevel(Long.parseLong(levelId));
				if (areaFascia != null) {
					if (areaFascia.getArea() != null)
						richiedente.setFasciaEconomica(areaFascia.getArea());
					
				}
			}
			if ((user != null) && (user.getExpandoBridge() != null)
			&& (user.getExpandoBridge().getAttribute(_customFieldUserOrg) != null)) {
				String organizationId = (String) user.getExpandoBridge().getAttribute(_customFieldUserOrg);
				if (organizationId != null && organizationId != "") {
					Long idChart = Long.parseLong(organizationId);
					OrganizationChart orgChart = OrganizationChartLocalServiceUtil.getOrganizationChart(idChart);
					if (orgChart != null) {
						int livello = orgChart.getLevel();
						long direzioneId = orgChart.getIdParent();
						if (livello != 2) {
							OrganizationChart direzioneOrgChart = OrganizationChartLocalServiceUtil.getOrganizationChart(direzioneId);
							if (direzioneOrgChart != null) {
								int livelloDipartimento = direzioneOrgChart.getLevel();
								long dipartimentoId = direzioneOrgChart.getIdParent();
								if (livelloDipartimento != 2) {
									OrganizationChart dipartimentoOrgChart = OrganizationChartLocalServiceUtil
									.getOrganizationChart(dipartimentoId);
									if (dipartimentoOrgChart.getName() != null)
										richiedente.setDipartimento(dipartimentoOrgChart.getName());
								} else {
									if (direzioneOrgChart.getName() != null)
										richiedente.setDipartimento(direzioneOrgChart.getName());
								}
							}
						} else {
							if (orgChart.getName() != null)
								richiedente.setDipartimento(orgChart.getName());
						}
					}
				}
			} else
				_log.warn(_customFieldUserOrg + " not defined for this user: " + user.getFullName());
			
			String inServizioDal = (String) user.getExpandoBridge().getAttribute(_customFieldDateStartFunction);
			if (inServizioDal != null && (!("").equals(inServizioDal))) {
				Date dateInServizio = new Date();
				dateInServizio.setTime(Long.parseLong(inServizioDal));
				richiedente.setServizioDal(formatDate.format(dateInServizio));
			} 
			
			String personalId = (String) user.getExpandoBridge().getAttribute(_customFieldPersonalId);
			if (personalId != null && (!("").equals(personalId))) {
				List<Mobilita> mobilita = MobilitaLocalServiceUtil.getMobilitaByPersonId(Long.parseLong(personalId));
				richiedente.setComandato(mobilita.get(0).getTipo_mobilita());
			} 
			
		} catch (Exception e) {
			
			_log.warn(e);
		}
		return richiedente;
	}
	
	private Richiedente createRichiedenteByTheme(ThemeDisplay themeDisplay) {
		User user = themeDisplay.getUser();
		long companyId = themeDisplay.getCompanyId();
		return createRichiedente(user, companyId);
	}
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		renderRequest.setAttribute(RichiesteTrasportiFormConfig.class.getName(), _configuration);
		if (renderRequest.getAttribute(_navigation) == null) {
			renderRequest.setAttribute(_navigation, _navigationHome);
		}
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Richiedente richiedente = createRichiedenteByTheme(themeDisplay);
		renderRequest.setAttribute("richiedente", richiedente);
		super.doView(renderRequest, renderResponse);
	}
	
	@ProcessAction(name = "richiestaRimborso")
	public void richiestaRimborso(ActionRequest actionRequest, ActionResponse actionResponse) {
		ModuloRichiedente moduloRichiedente = new ModuloRichiedente();
		moduloRichiedente.setIban(actionRequest.getParameter("Iban"));
		StringBuilder importo = new StringBuilder();
		
		String importoRichiesta = actionRequest.getParameter("Importo");
		if (!"".equals(importoRichiesta)){
			String listImportoRichiesta[] = importoRichiesta.split(",");
			
			
			if (!importoRichiesta.contains(".")){
				int number = Integer.parseInt(listImportoRichiesta[0]);
				String txt = String.format("%,d", number);
				txt = txt.replaceAll(",", ".");
				importo.append(txt);
				
			}else{
				importo.append(listImportoRichiesta[0]);
			}
			
			if (importoRichiesta.contains(",")){
				importo.append(",");
				importo.append(listImportoRichiesta[1]);
			}else{
				importo.append(",00");
			}
			moduloRichiedente.setImporto(importo.toString());

		}
		moduloRichiedente.setTipoViaggio(actionRequest.getParameter("TipoViaggio"));
		moduloRichiedente.setNumeroViaggi(actionRequest.getParameter("NumeroViaggi"));
		moduloRichiedente.setDataAcquistoViaggio(actionRequest.getParameter("DataAcquistoViaggio"));
		moduloRichiedente.setDescrizione(actionRequest.getParameter("Descrizione"));
		moduloRichiedente.setFlagTipoSpesa(actionRequest.getParameter("FlagTipoSpesa"));
		moduloRichiedente.setNomeFiglio(actionRequest.getParameter("NomeFiglio"));
		moduloRichiedente.setCognomeFiglio(actionRequest.getParameter("CognomeFiglio"));
		moduloRichiedente.setLuogoNascitaFiglio(actionRequest.getParameter("LuogoNascitaFiglio"));
		moduloRichiedente.setCfFiglio(actionRequest.getParameter("CFFiglio"));
		moduloRichiedente.setDataNascitaFiglio(actionRequest.getParameter("DataNascitaFiglio"));
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		if (actionRequest.getParameter("VecchioAllegato") == null || (("").equals(actionRequest.getParameter("VecchioAllegato"))))
			copyFileToServer(actionRequest, moduloRichiedente, user.getScreenName());
		else {
			moduloRichiedente.setAllegatoNome(actionRequest.getParameter("AllegatoNome"));
			moduloRichiedente.setAllegatoMimeType(actionRequest.getParameter("AllegatoMimeType"));
			moduloRichiedente.setAllegato(new File(actionRequest.getParameter("VecchioAllegato")));
		}
		if (moduloRichiedente.getFlagTipoSpesa() == null)
			moduloRichiedente.setFlagTipoSpesa("personale");
		if (moduloRichiedente.getTipoViaggio() == null)
			moduloRichiedente.setTipoViaggio("mensile");
		
		actionRequest.setAttribute("moduloRichiedente", moduloRichiedente);
		actionRequest.setAttribute(_navigation, _navigationRiepilogo);
		SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}
	
	@ProcessAction(name = "eventoRichiestaRimborso")
	public void eventoRichiestaRimborso(ActionRequest actionRequest, ActionResponse actionResponse) {
		ModuloRichiedente moduloRichiedente = new ModuloRichiedente();
		moduloRichiedente.setIban(actionRequest.getParameter("Iban"));
		moduloRichiedente.setImporto(actionRequest.getParameter("Importo"));
		moduloRichiedente.setTipoViaggio(actionRequest.getParameter("TipoViaggio"));
		moduloRichiedente.setNumeroViaggi(actionRequest.getParameter("NumeroViaggi"));
		moduloRichiedente.setDataAcquistoViaggio(actionRequest.getParameter("DataAcquistoViaggio"));
		moduloRichiedente.setDescrizione(actionRequest.getParameter("Descrizione"));
		moduloRichiedente.setFlagTipoSpesa(actionRequest.getParameter("FlagTipoSpesa"));
		moduloRichiedente.setNomeFiglio(actionRequest.getParameter("NomeFiglio"));
		moduloRichiedente.setCognomeFiglio(actionRequest.getParameter("CognomeFiglio"));
		moduloRichiedente.setLuogoNascitaFiglio(actionRequest.getParameter("LuogoNascitaFiglio"));
		moduloRichiedente.setCfFiglio(actionRequest.getParameter("CFFiglio"));
		moduloRichiedente.setDataNascitaFiglio(actionRequest.getParameter("DataNascitaFiglio"));
		moduloRichiedente.setAllegatoNome(actionRequest.getParameter("AllegatoNome"));
		moduloRichiedente.setAllegatoMimeType(actionRequest.getParameter("AllegatoMimeType"));
		moduloRichiedente.setAllegato(new File(actionRequest.getParameter("Allegato")));
		if (actionRequest.getParameter("evento") != null && (("modifica").equalsIgnoreCase(actionRequest.getParameter("evento")))) {
			actionRequest.setAttribute("moduloRichiedente", moduloRichiedente);
			actionRequest.setAttribute(_navigation, _navigationHome);
		} else {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			Richiedente richiedente = createRichiedenteByTheme(themeDisplay);
			try {
				
				//insert db
				
				User user = themeDisplay.getUser();
				Date dataAcquisto=null;
				Date dataFiglioNascita=null; 
				String allegatoUuid=null;
				String flag_inviato=null;
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				if (moduloRichiedente.getDataAcquistoViaggio() != null && !(("").equals(moduloRichiedente.getDataAcquistoViaggio()))) {
					 dataAcquisto = sdf.parse(moduloRichiedente.getDataAcquistoViaggio());
					//modulo.setData_titolo_annuale(dataAcquisto);
				}
				if (moduloRichiedente.getDataNascitaFiglio() != null && !(("").equals(moduloRichiedente.getDataNascitaFiglio()))) {
					 dataFiglioNascita = sdf.parse(moduloRichiedente.getDataNascitaFiglio());
					//modulo.setFiglio_data_nascita(dataFiglioNascita);
				}
				FileEntry fileEntry;
				if (moduloRichiedente.getAllegato() != null) {
					fileEntry = fileUpload(themeDisplay, actionRequest, moduloRichiedente);
				if (fileEntry != null)
						allegatoUuid=fileEntry.getUuid();
				}
				
				ModuloTrasporti moduloTrasporti =ModuloTrasportiLocalServiceUtil.insertModuloTrasporti(richiedente.getCognome(), richiedente.getNome(), richiedente.getCodiceFiscale(), user.getScreenName(), new Date(), moduloRichiedente.getFlagTipoSpesa(), moduloRichiedente.getIban(), moduloRichiedente.getImporto(), dataAcquisto, moduloRichiedente.getNumeroViaggi(), moduloRichiedente.getNomeFiglio(), moduloRichiedente.getCognomeFiglio(), dataFiglioNascita, moduloRichiedente.getLuogoNascitaFiglio(), moduloRichiedente.getCfFiglio(), moduloRichiedente.getDescrizione(), flag_inviato, richiedente.getTelefono(), allegatoUuid);
				
//				ModuloTrasporti modulo = ModuloTrasportiLocalServiceUtil
//				.createModuloTrasporti(CounterLocalServiceUtil.increment(ModuloTrasporti.class.getName()));
//				modulo.setNome(richiedente.getNome());
//				modulo.setCognome(richiedente.getCognome());
//				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//				if (moduloRichiedente.getDataAcquistoViaggio() != null && !(("").equals(moduloRichiedente.getDataAcquistoViaggio()))) {
//					Date dataAcquisto = sdf.parse(moduloRichiedente.getDataAcquistoViaggio());
//					modulo.setData_titolo_annuale(dataAcquisto);
//				}
//				modulo.setCodice_fiscale(richiedente.getCodiceFiscale());
//				
//				modulo.setUtente_inserimento(user.getScreenName());
//				Date data_inserimento = new Date();
//				modulo.setData_inserimento(data_inserimento);
//				modulo.setFlag_tipospesa(moduloRichiedente.getFlagTipoSpesa());
//				modulo.setImporto(moduloRichiedente.getImporto());
//				modulo.setFiglio_nome(moduloRichiedente.getNomeFiglio());
//				modulo.setFiglio_cognome(moduloRichiedente.getCognomeFiglio());
				
//				modulo.setFiglio_luogo_data(moduloRichiedente.getLuogoNascitaFiglio());
//				modulo.setFiglio_codicefiscale(moduloRichiedente.getCfFiglio());
//				modulo.setNote(moduloRichiedente.getDescrizione());
//				modulo.setTelefono(richiedente.getTelefono());
//				modulo.setIban(moduloRichiedente.getIban());
//				modulo.setNr_titoli_mensili(moduloRichiedente.getNumeroViaggi());
		
				//ModuloTrasporti moduloUpdate = ModuloTrasportiLocalServiceUtil.addModuloTrasporti(modulo);
				
				if(moduloTrasporti!=null){
				
				ModuloPdf moduloPdf = new ModuloPdf(richiedente, moduloRichiedente);
				File file = FileUtil.createTempFile("temp-file-name", "pdf");
				file = moduloPdf.drawPDFModulo(file);
				String subject = actionRequest.getPreferences().getValue("subjectRichiestaRimborso",_configuration.subjectRichiestaRimborso());
				String emailReferente = actionRequest.getPreferences().getValue("emailReferente", _configuration.emailReferente());
				String sender = actionRequest.getPreferences().getValue("senderInvito", _configuration.senderRichiestaRimborso());
				String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
				String body = actionRequest.getPreferences().getValue("richiestaRimborsoTmpl", _configuration.richiestaRimborsoTmpl());
				subject = StringUtil.replace(subject, new String[] {"[$NOME$]","[$COGNOME$]"},new String[] { richiedente.getNome(), richiedente.getCognome()});
				

				
				body = StringUtil.replace(body, new String[] { "[$COGNOME$]", "[$NOME$]", "[$CODICEFISCALE$]" },
				new String[] { richiedente.getCognome(), richiedente.getNome(), richiedente.getCodiceFiscale() });
				EmailSender mail = new EmailSender();
				StringBuilder nameFileBuilder = new StringBuilder();
				nameFileBuilder.append("ModuloRichiesta_IstanzaTrasporti_");
				nameFileBuilder.append(richiedente.getNome());
				nameFileBuilder.append("_");
				nameFileBuilder.append(richiedente.getCognome());
				nameFileBuilder.append("_");
				nameFileBuilder.append(richiedente.getCodiceFiscale());
				nameFileBuilder.append(".pdf");
				if (mail.sendMailMessage(subject, body, sender, smtpUser, emailReferente, file, nameFileBuilder.toString(),
				moduloRichiedente.getAllegato())) {
					if (mail.sendMailMessage(subject, body, sender, smtpUser, richiedente.getMail(), file, nameFileBuilder.toString(),
					moduloRichiedente.getAllegato())) {
						moduloTrasporti.setFlag_inviato("S");
						ModuloTrasportiLocalServiceUtil.updateModuloTrasporti(moduloTrasporti);
					} else
						_log.warn("email non inviata al richiedente " + richiedente.getMail());
					
				} else {
					_log.warn("email non inviata al referente " + emailReferente);
				}
				PortletURL render = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
				themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
				render.setWindowState(LiferayWindowState.NORMAL);
				render.setPortletMode(LiferayPortletMode.VIEW);
				actionResponse.sendRedirect(render.toString());
				}
				else {
					throw new RichiesteTrasportiException("WARNING: inserimento richiesta non avvenuto");
				}
			} catch (Exception e) {
				_log.warn(e);
				SessionErrors.add(actionRequest, "Errore-durante-invio-richiesta-modulo-trasporti");
				SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
				actionRequest.setAttribute("moduloRichiedente", moduloRichiedente);
				actionRequest.setAttribute(_navigation, _navigationRiepilogo);
			}
		}
	}
	
	private Folder getFolder(ThemeDisplay themeDisplay) {
		Folder folder = null;
		try {
			folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
		} catch (Exception e) {
			_log.warn(e);
		}
		return folder;
	}
	
	private FileEntry fileUpload(ThemeDisplay themeDisplay, ActionRequest actionRequest, ModuloRichiedente moduloRichiedente) throws IOException {
		FileEntry fileEntry = null;
		String fileName = moduloRichiedente.getAllegato().getName();
		File file = moduloRichiedente.getAllegato();
		String mimeType = moduloRichiedente.getAllegatoMimeType();
		StringBuilder title = new StringBuilder();
		title.append(fileName.substring(0, fileName.lastIndexOf('.')));
		title.append((new Date()).toString().replace(":", "-"));
		title.append(fileName.substring(fileName.lastIndexOf('.')));
		String description = "";
		long repositoryId = themeDisplay.getScopeGroupId();
		Folder folder = getFolder(themeDisplay);
		if (folder == null) {
			try {
				extracted();
			} catch (RichiesteTrasportiException e) {
				_log.warn(e);
			}
		}
		InputStream is = new FileInputStream(file);
		ServiceContext serviceContext;
		try {
			
			serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
			
			List<AssetCategory> asset_category_strumenti = new ArrayList<AssetCategory>(0);
	
			DynamicQuery query_asset_category_strumenti = DynamicQueryFactoryUtil.forClass(AssetCategory.class)
					.add(PropertyFactoryUtil.forName("name").eq("strumenti"));
			try {
				asset_category_strumenti = AssetCategoryLocalServiceUtil.dynamicQuery(query_asset_category_strumenti, 0, 1);
			} catch (Exception e) {
				_log.error("Errore nel recupero dell'area tematica: " + e);
			}
	
			if(!asset_category_strumenti.isEmpty()) {
				long[] assetCategoryIds = {asset_category_strumenti.get(0).getCategoryId()};
				serviceContext.setAssetCategoryIds(assetCategoryIds);
			}
			
			fileEntry = DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), fileName, mimeType, title.toString(),
			description, "", is, file.getTotalSpace(), serviceContext);
			
		 Role ownerRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.OWNER);	
	     Role siteMemberRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.SITE_MEMBER);	
	     Role guestRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.GUEST);
	     Role powerUserRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.POWER_USER);
		 
	     ResourcePermissionLocalServiceUtil.removeResourcePermission(themeDisplay.getCompanyId(), DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(fileEntry.getFileEntryId()), ownerRole.getRoleId(), ActionKeys.VIEW);
	     ResourcePermissionLocalServiceUtil.removeResourcePermission(themeDisplay.getCompanyId(), DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(fileEntry.getFileEntryId()), guestRole.getRoleId(), ActionKeys.VIEW);
		 ResourcePermissionLocalServiceUtil.removeResourcePermission(themeDisplay.getCompanyId(), DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(fileEntry.getFileEntryId()), siteMemberRole.getRoleId(), ActionKeys.VIEW);
		 ResourcePermissionLocalServiceUtil.removeResourcePermission(themeDisplay.getCompanyId(), DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(fileEntry.getFileEntryId()), powerUserRole.getRoleId(), ActionKeys.VIEW);

			
			
		} catch (Exception e) {
			_log.warn(e);
		}
		 finally {
			is.close();
		}
		return fileEntry;
	}
	
	private void extracted() throws RichiesteTrasportiException {
		throw new RichiesteTrasportiException("Folder not defined");
	}
	
	private void copyFileToServer(ActionRequest actionRequest, ModuloRichiedente moduloRichiedente, String codiceFiscale) {
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		try {
			File uploadedFile = uploadRequest.getFile("Allegato");
			if (uploadedFile != null && uploadedFile.exists() && !uploadedFile.equals(moduloRichiedente.getAllegato())) {
				moduloRichiedente.setAllegatoMimeType(uploadRequest.getContentType("Allegato"));
				moduloRichiedente.setAllegatoNome(uploadRequest.getFileName("Allegato"));
				ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				StringBuilder stringPath = new StringBuilder();
				stringPath.append(TEMP_PATH);
				stringPath.append("documents");
				stringPath.append(File.separator);
				stringPath.append(themeDisplay.getLayout().getGroupId());
				stringPath.append(File.separator);
				stringPath.append(baseDir);
				stringPath.append(File.separator);
				stringPath.append(codiceFiscale);
				File folder = new File(stringPath.toString());
				moduloRichiedente.setAllegato(new File(folder.getAbsolutePath() + File.separator + moduloRichiedente.getAllegatoNome()));
				FileUtil.copyFile(uploadedFile, moduloRichiedente.getAllegato());
			}
		} catch (Exception e) {
			_log.warn(e);
		}
	}
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(RichiesteTrasportiFormConfig.class, properties);
	}
	
	private volatile RichiesteTrasportiFormConfig _configuration;
}