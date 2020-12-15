package bacheca.annunci.list.portlet;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetEntryServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.asset.kernel.service.persistence.AssetEntryQuery;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalServiceUtil;
import com.liferay.dynamic.data.mapping.storage.Field;
import com.liferay.dynamic.data.mapping.storage.Fields;
import com.liferay.dynamic.data.mapping.util.DDMUtil;
import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.criteria.URLItemSelectorReturnType;
import com.liferay.item.selector.criteria.image.criterion.ImageItemSelectorCriterion;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.model.JournalFolderConstants;
import com.liferay.journal.model.impl.JournalArticleImpl;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.journal.service.JournalFolderServiceUtil;
import com.liferay.journal.util.JournalConverter;
import com.liferay.journal.util.impl.JournalUtil;
import com.liferay.journal.web.portlet.action.ActionUtil;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletMode;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.LayoutTypePortletFactoryUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;
import javax.portlet.WindowStateException;


import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import bacheca.annunci.list.beans.AnnuncioBean;
import bacheca.annunci.list.utils.AnnunciUtils;
import bacheca.annunci.list.utils.EmailSender;

/**
 * @author roberto.puddu
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=Mef-Portlet", "com.liferay.portlet.instanceable=true",
	"javax.portlet.display-name=bacheca-annunci-list Portlet", "javax.portlet.init-param.template-path=/",
	"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + BachecaAnnunciKeys.BACHECAANNUNCI,
	"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",
	"com.liferay.portlet.add-default-resource=true" }, service = Portlet.class)
public class BachecaAnnunciListPortlet extends MVCPortlet {
	
	private Portal _portal;
	private final String _roleAdministrator = "Administrator";

	private DDMStructure _ddmStructure = null;
	private DDMTemplate _ddmTemplate = null;
	public static final String DDM_STRUCTURE_NAME = "Annunci";
	public static final String ROLE_NAME = "Moderatore annunci";
	public static final String CATEGORIA = "annunci";
	private static final String DISPLAY_FIELDS_NAME = "_fieldsDisplay";
	private static final String FOLDER_NAME = "fold_annunci";
	private JournalConverter _journalConverter;
	private static final Log _log = LogFactoryUtil.getLog(BachecaAnnunciListPortlet.class);
	
	
	AssetVocabulary _categoriaMod = null;
	@Reference
	private ItemSelector _itemSelector;
	private final static String PORTLET_NAME = "bacheca_annunci_list_portlet_BachecaAnnunciListPortlet";
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			
		if (renderRequest.getParameter("added")!=null){
			renderRequest.setAttribute("added", Boolean.getBoolean(renderRequest.getParameter("added")));
		}

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		RequestBackedPortletURLFactory requestBackedPortletURLFactory = RequestBackedPortletURLFactoryUtil.create(renderRequest);
		List<ItemSelectorReturnType> desiredItemSelectorReturnTypes = new ArrayList<>();
		desiredItemSelectorReturnTypes.add(new URLItemSelectorReturnType());
		ImageItemSelectorCriterion imageItemSelectorCriterion = new ImageItemSelectorCriterion();
		imageItemSelectorCriterion.setDesiredItemSelectorReturnTypes(desiredItemSelectorReturnTypes);
		PortletURL itemSelectorURL = _itemSelector.getItemSelectorURL(requestBackedPortletURLFactory, "imageSelection",
		imageItemSelectorCriterion);
		renderRequest.setAttribute("itemSelectorURL", itemSelectorURL.toString());
		String linkLayout = PrefsParamUtil.getString(renderRequest.getPreferences(), renderRequest, "bachecaPage");
		if (linkLayout == null || "".equals(linkLayout)){
			linkLayout = ""+themeDisplay.getLayout().getLayoutId();
		}
		Long lid = Long.parseLong(linkLayout);
		
		String porletId_Bacheca = "";
		
			Layout l = LayoutLocalServiceUtil.getLayout(themeDisplay.getSiteGroupId(), themeDisplay.getLayout().isPrivateLayout(),
			lid);
			LayoutTypePortlet layoutTypePortlet = LayoutTypePortletFactoryUtil.create(l);
			List<String> portletIdList = layoutTypePortlet.getPortletIds();
			for (String pid : portletIdList) {
				if (pid.indexOf(PORTLET_NAME) != -1) {
					porletId_Bacheca = pid;
					break;
				}
			}
			PortletURL	linkLayoutmyUrl = PortletURLFactoryUtil.create(renderRequest, porletId_Bacheca, l, PortletRequest.RENDER_PHASE);
		
		renderRequest.setAttribute(BachecaAnnunciListConfig.class.getName(), _configuration);
		String viewtheme = renderRequest.getPreferences().getValue("viewTheme", _configuration.viewTheme());
		AnnunciUtils util = new AnnunciUtils();
		User user = themeDisplay.getUser();
		long groupId = themeDisplay.getLayout().getGroupId();
		List<DDMStructure> ddmStructures = DDMStructureLocalServiceUtil.getStructures(themeDisplay.getCompanyGroupId());
		List<DDMStructure> ddmStructuresResult = new ArrayList<>();
		for (DDMStructure ddmStructure : ddmStructures) {
			if (BachecaAnnunciListPortlet.DDM_STRUCTURE_NAME.equalsIgnoreCase(ddmStructure.getName(Locale.getDefault(), true))) {
				ddmStructuresResult.add(ddmStructure);
			}
		}
		if (ddmStructuresResult.size() == 1) {
			_ddmStructure = ddmStructuresResult.get(0);
			if (_ddmStructure.getTemplates().size() == 1) {
				_ddmTemplate = _ddmStructure.getTemplates().get(0);
			} else {
				SessionErrors.add(renderRequest, "nome-del-template-non-univoco");
			}
		} else {
			SessionErrors.add(renderRequest, "nome-della-struttura-non-univoco");
		}
		// caricamento di tutte le sottocategorie presenti sono la categoria
		// definita nella costante CATEGORIA
		if (_categoriaMod == null) {
			List<AssetVocabulary> allCategories = AssetVocabularyLocalServiceUtil.getAssetVocabularies(QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
			for (AssetVocabulary j : allCategories) {
				if (j.getName().equals(CATEGORIA)) {
					_categoriaMod = j;
					break;
				}
			}
		}
		if (_categoriaMod != null && _categoriaMod.getCategories() != null && _categoriaMod.getCategories().size() > 0) {
			renderRequest.setAttribute("category", _categoriaMod);
		} else {
			if (_categoriaMod == null)
				SessionErrors.add(renderRequest, "nome-della-categoria-non-univoco");
			else
				SessionErrors.add(renderRequest, " la-categoria-non-contiene-sottocategorie");
		}
		if (renderRequest.getParameter("errorInserimento") != null && "false".equals(renderRequest.getParameter("errorInserimento"))) {
			SessionErrors.add(renderRequest, "Errore-durante-inserimento");
			SessionMessages.add(renderRequest,
			PortalUtil.getPortletId(renderRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		}
		// Ricavo la chiave della struttura annunci
		String strkey = util.getStructureIdFromName(DDM_STRUCTURE_NAME);
		List<AnnuncioBean> annunciparam = (List<AnnuncioBean>) renderRequest.getAttribute("advList");
		List<AnnuncioBean> myadvertiseList = annunciListFromSearch(groupId, strkey, util, "", user.getUserId(), null, 0);
		renderRequest.setAttribute("myadvList", myadvertiseList);
		List<AnnuncioBean> advertiseList;
		if (annunciparam == null) {
			if (!"myadvertise".equals(viewtheme)) {
				advertiseList = annunciListFromSearch(groupId, strkey, util, "", 0, null, 0);
				
			} else {
			advertiseList = annunciListFromSearch(groupId, strkey, util, "", 0, null, _configuration.itemsPerPage());
				
			}
			renderRequest.setAttribute("advList", advertiseList);
		}
		renderRequest.setAttribute("linkLayoutmyUrl", linkLayoutmyUrl);
		renderRequest.setAttribute("porletId_Bacheca", porletId_Bacheca);
		List<Role> listaRuoli=user.getRoles();
		for(Role ruolo: listaRuoli){
			if(ruolo.getName().equalsIgnoreCase(_roleAdministrator)) {
				renderRequest.setAttribute("roleAdministrator", _roleAdministrator);
			    break;
		}
		}		
		super.doView(renderRequest, renderResponse);
		} catch (Exception e) {
			_log.warn(e);
		}
	}
	
	@ProcessAction(name = "addAnnuncio")
	public void addAnnuncio(ActionRequest request, ActionResponse response) throws IOException, WindowStateException, PortletModeException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL renderUrl = PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(),
		PortletRequest.RENDER_PHASE);
		renderUrl.setWindowState(LiferayWindowState.NORMAL);
		renderUrl.setPortletMode(LiferayPortletMode.VIEW);
		renderUrl.setParameter("navigation", "inserisciannuncio");
		response.sendRedirect(renderUrl.toString());
	}
	

	@ProcessAction(name = "deleteAdv")
	public void deleteAdv(ActionRequest request, ActionResponse response) throws IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Long annuncioId = ParamUtil.getLong(request, "annuncioId");
		Long userId = ParamUtil.getLong(request, "userId");
		if (annuncioId != null && userId != null) {
			// per cancellare il journal article
			try {
				// il metodo cancella definitivamente l'ultima versione del
				// documento dal db
				// JournalArticleLocalServiceUtil.deleteJournalArticle(annuncioId);
				// recupero l'article
				JournalArticle article = JournalArticleLocalServiceUtil.getArticle(annuncioId);
				// controllo se non è nel cestino
				if (article.getStatus() != 8) {
					// lo sposto nel cestino
					JournalArticleLocalServiceUtil.moveArticleToTrash(userId, article);
					PortletURL renderUrl = PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
					try {
						renderUrl.setWindowState(LiferayWindowState.NORMAL);
						renderUrl.setPortletMode(LiferayPortletMode.VIEW);
					} catch (Exception e1) {
						_log.warn(e1);
					}
					response.sendRedirect(renderUrl.toString());
				}
			} catch (PortalException e) {
				_log.warn(e);
			}
		}
	}
	
	@ProcessAction(name = "annullaAdv")
	public void annullaAdv(ActionRequest request, ActionResponse response)
	throws IOException, PortalException, ValidatorException, ReadOnlyException {
		String ss = request.getParameter("navigation");
		if (ss == null) {
			javax.portlet.PortletPreferences preferences = request.getPreferences();
			preferences.setValue("viewTheme", "list");
			preferences.store();
		}
	}
	
	@ProcessAction(name = "updateAdv")
	public void updateAdv(ActionRequest request, ActionResponse response) throws IOException, PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL renderUrl = PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(),
		PortletRequest.RENDER_PHASE);
		Long annuncioId = ParamUtil.getLong(request, "annuncioId");
		String photoup1 = ParamUtil.getString(request, "photoup1");
		String photoup2 = ParamUtil.getString(request, "photoup2");
		String photoup3 = ParamUtil.getString(request, "photoup3");
		String photoup4 = ParamUtil.getString(request, "photoup4");
		try {
			renderUrl.setWindowState(LiferayWindowState.NORMAL);
			renderUrl.setPortletMode(LiferayPortletMode.VIEW);
			String photo1 = ParamUtil.getString(request, "Photo1");
			String photo2 = ParamUtil.getString(request, "Photo2");
			String photo3 = ParamUtil.getString(request, "Photo3");
			String photo4 = ParamUtil.getString(request, "Photo4");
			String src1 = ParamUtil.getString(request, "src1");
			String src2 = ParamUtil.getString(request, "src2");
			String src3 = ParamUtil.getString(request, "src3");
			String src4 = ParamUtil.getString(request, "src4");
			long folderId = JournalFolderConstants.DEFAULT_PARENT_FOLDER_ID;
			List<JournalFolder> dlFolders = JournalFolderServiceUtil.getFolders(themeDisplay.getSiteGroupId());
			for (JournalFolder folder : dlFolders) {
				if (folder.getName().equals(BachecaAnnunciListPortlet.FOLDER_NAME)) {
					folderId = folder.getFolderId();
				}
			}
			long userId = themeDisplay.getUserId();
			long groupId = themeDisplay.getScopeGroupId();
			Map<String, byte[]> img = new HashMap<String, byte[]>();
			List<DDMStructure> ddmStructures = DDMStructureLocalServiceUtil.getStructures(themeDisplay.getCompanyGroupId());
			List<DDMStructure> ddmStructuresResult = new ArrayList<>();
			for (DDMStructure ddmStructure : ddmStructures) {
				if (BachecaAnnunciListPortlet.DDM_STRUCTURE_NAME.equals(ddmStructure.getName(Locale.getDefault(), true))) {
					ddmStructuresResult.add(ddmStructure);
				}
			}
			if (ddmStructuresResult.size() == 1) {
				_ddmStructure = ddmStructuresResult.get(0);
				if (_ddmStructure.getTemplates().size() == 1) {
					_ddmTemplate = _ddmStructure.getTemplates().get(0);
				}
			}
			UploadPortletRequest uploadPortletRequest = _portal.getUploadPortletRequest(request);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(JournalArticle.class.getName(), uploadPortletRequest);
			Fields fields = DDMUtil.getFields(_ddmStructure.getStructureId(), serviceContext);
			Field fieldTitle = new Field();
			String topicField = request.getParameter("Topic");
			AssetCategory topicCat = null;
			if (topicField != null && topicField != "") {
				topicCat = AssetCategoryLocalServiceUtil.getAssetCategory(Long.parseLong(topicField));
			}
			Field fieldTopic = new Field();
			fieldTopic.setName("Topic");
			fieldTopic.setValue(topicCat.getName());
			fieldTopic.setDDMStructureId(_ddmStructure.getStructureId());
			fields.remove("Topic");
			fields.put(fieldTopic);
			fieldTitle.setName("Title");
			fieldTitle.setValue(fields.get("Topic").getValue(themeDisplay.getLocale()).toString());
			fieldTitle.setDDMStructureId(_ddmStructure.getStructureId());
			fields.put(fieldTitle);
			// prendiamo i parametri
			JournalArticle article = JournalArticleLocalServiceUtil.getArticle(annuncioId);
			//article.getDDMStructure().getName().equals(anObject)
			String contentpreupdate = article.getContent();
			AnnunciUtils util = new AnnunciUtils();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
			Date startDate = article.getDisplayDate();
			Calendar todayCalendar = Calendar.getInstance();
			todayCalendar.add(Calendar.DATE, -1);
			boolean neverExpire = true;
			boolean neverReview = false;
			String displayDateString = sdf2.format(startDate);
			String[] dateDisplay = { "01", "01", "2017" };
			if (displayDateString != null && !"".equals(displayDateString)) {
				dateDisplay = displayDateString.split("/");
				String sd = util.getValueFromStructure(contentpreupdate, "StartDate");
				if (sd != null) {
					Field fielddate = new Field();
					fielddate.setName("StartDate");
					fielddate.setValue((Serializable) sd);
					fielddate.setDDMStructureId(_ddmStructure.getStructureId());
					fields.remove("StartDate");
					fields.put(fielddate);
				}
			}
			int displayDateMonth = Integer.parseInt(dateDisplay[1]) - 1;
			int displayDateDay = Integer.parseInt(dateDisplay[0]);
			int displayDateYear = Integer.parseInt(dateDisplay[2]);
			int displayDateHour = 0;
			int displayDateMinute = 0;
			String[] dateExp = { "01", "01", "2017" };
			String expDateString = request.getParameter("Deadline");
			if (expDateString != null && !"".equals(expDateString)) {
				dateExp = expDateString.split("/");
				if (fields.get("Deadline") != null) {
					Date date = new Date();
					try {
						date = sdf2.parse(request.getParameter("Deadline"));
					} catch (ParseException e) {
						_log.warn(e);
					}
					Field fielddate = new Field();
					fielddate.setName("Deadline");
					fielddate.setValue(sdf.format(date));
					fielddate.setDDMStructureId(_ddmStructure.getStructureId());
					fields.remove("Deadline");
					fields.put(fielddate);
				}
			}
			int expirationDateMonth = Integer.parseInt(dateExp[1]) - 1;
			int expirationDateDay = Integer.parseInt(dateExp[0]);
			int expirationDateYear = Integer.parseInt(dateExp[2]);
			int expirationDateHour = 0;
			int expirationDateMinute = 0;
			int reviewDateMonth = Integer.parseInt(dateExp[1]) - 1;
			int reviewDateDay = Integer.parseInt(dateExp[0]);
			int reviewDateYear = Integer.parseInt(dateExp[2]);
			int reviewDateHour = 0;
			int reviewDateMinute = 0;
			Field fieldDisplay = new Field();
			fieldDisplay.setName(DISPLAY_FIELDS_NAME);
			fieldDisplay.setValue(
			"Title_INSTANCE_tgjd,User_INSTANCE_asqf,StartDate_INSTANCE_wmll,Deadline_INSTANCE_wmld,Topic_INSTANCE_poiu,Body_INSTANCE_asdf,"
			+ "Email_INSTANCE_lkjh,Photo1_INSTANCE_ljkq,Photo2_INSTANCE_phts,Photo3_INSTANCE_kafg,Photo4_INSTANCE_svfr,Type_INSTANCE_fghj,Zona_INSTANCE_zxfc,PhoneNumber_INSTANCE_ghqp");
			fieldDisplay.setDDMStructureId(_ddmStructure.getStructureId());
			fields.put(fieldDisplay);
			String content = StringPool.BLANK;
			String structureContent = _journalConverter.getContent(_ddmStructure, fields);
			Map<String, byte[]> structureImages;
			structureImages = ActionUtil.getImages(structureContent, fields);
			Object[] contentAndImages = new Object[] { structureContent, structureImages };
			if (contentAndImages.length > 0) {
				content = (String) contentAndImages[0];
				img = (HashMap<String, byte[]>) contentAndImages[1];
			}
			content = content.replace("default-locale=\"en_US\"", "default-locale=\"it_IT\"");
			if (!"".equals(photoup1) && (src1 == null || !"".equals(src1)) && (photo1 == null || "".equals(photo1))) {
				Element photo1Element = util.getPhotoElement(contentpreupdate, "Photo1");
				content = util.setPhotoElement(content, "Photo1", photo1Element.element("dynamic-content"));
			}
			if (!"".equals(photoup2) && (src2 == null || !"".equals(src2)) && (photo2 == null || "".equals(photo2))) {
				Element photo2Element = util.getPhotoElement(contentpreupdate, "Photo2");
				content = util.setPhotoElement(content, "Photo2", photo2Element.element("dynamic-content"));
			}
			if (!"".equals(photoup3) && (src3 == null || !"".equals(src3)) && (photo3 == null || "".equals(photo3))) {
				Element photo3Element = util.getPhotoElement(contentpreupdate, "Photo3");
				content = util.setPhotoElement(content, "Photo3", photo3Element.element("dynamic-content"));
			}
			if (!"".equals(photoup4) && (src4 == null || !"".equals(src4)) && (photo4 == null || "".equals(photo4))) {
				Element photo4Element = util.getPhotoElement(contentpreupdate, "Photo4");
				content = util.setPhotoElement(content, "Photo4", photo4Element.element("dynamic-content"));
			}
			String idCategoria = request.getPreferences().getValue("metaAreaCategoria", _configuration.metaAreaCategoria());
			long[] assetCategoryIds = { Long.parseLong(idCategoria), topicCat.getCategoryId() };
			serviceContext.setAssetCategoryIds(assetCategoryIds);
			JournalArticle articleUp = JournalArticleLocalServiceUtil.updateArticle(userId, groupId, folderId, article.getArticleId(),
			article.getVersion(), article.getTitleMap(), article.getDescriptionMap(), content, article.getDDMStructureKey(),
			article.getDDMTemplateKey(), article.getLayoutUuid(), displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
			displayDateMinute, expirationDateMonth, expirationDateDay, expirationDateYear, expirationDateHour, expirationDateMinute,
			neverExpire, reviewDateMonth, reviewDateDay, reviewDateYear, reviewDateHour, reviewDateMinute, neverReview, true,
			article.getSmallImage(), article.getSmallImageURL(), null, img, article.getArticleId(), serviceContext);
			renderUrl.setParameter("annuncioId", Long.toString(articleUp.getPrimaryKey()));
			renderUrl.setParameter("navigation", "advdetail");
			response.sendRedirect(renderUrl.toString());
		} catch (Exception e) {
			request.setAttribute("added", false);
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			SessionErrors.add(request, PortalUtil.getPortletId(request));
			_log.warn("Exception", e);
			
			//comment following part to not set parameters in renderUrl
//			renderUrl.setParameter("itemSelectorURL", ParamUtil.getString(request, "itemSelectorURL"));
//			renderUrl.setParameter("mvcPath", "/dialogupdate.jsp");
//			renderUrl.setParameter("annuncioId", annuncioId.toString());
//			renderUrl.setParameter("titolo", ParamUtil.getString(request, "titoloDefault"));
//			renderUrl.setParameter("userId", ParamUtil.getString(request, "userId"));
//			renderUrl.setParameter("email", ParamUtil.getString(request, "emailDefault"));
//			renderUrl.setParameter("type", ParamUtil.getString(request, "typeDefault"));
//			renderUrl.setParameter("topic", ParamUtil.getString(request, "topicDefault"));
//			renderUrl.setParameter("body", ParamUtil.getString(request, "bodyDefault"));
//			renderUrl.setParameter("deadline", ParamUtil.getString(request, "deadlineDefault"));
//			renderUrl.setParameter("startdate", ParamUtil.getString(request, "startdateDefault"));
//			renderUrl.setParameter("phone", ParamUtil.getString(request, "phoneDefault"));
//			renderUrl.setParameter("username", ParamUtil.getString(request, "usernameDefault"));
//			renderUrl.setParameter("zonaparam", ParamUtil.getString(request, "zonaparamDefault"));
//			renderUrl.setParameter("zona", ParamUtil.getString(request, "zonaDefault"));
//			renderUrl.setParameter("photo1", photoup1);
//			renderUrl.setParameter("photo2", photoup2);
//			renderUrl.setParameter("photo3", photoup3);
//			renderUrl.setParameter("photo4", photoup4);
//			renderUrl.setParameter("errorInserimento", "false");
//			response.sendRedirect(renderUrl.toString());
			
			//set and send attributes in POST
			request.setAttribute("itemSelectorURL", ParamUtil.getString(request, "itemSelectorURL"));
			request.setAttribute("annuncioId", annuncioId.toString());
			request.setAttribute("titolo", ParamUtil.getString(request, "titoloDefault"));
			request.setAttribute("userId", ParamUtil.getString(request, "userId"));
			request.setAttribute("email", ParamUtil.getString(request, "emailDefault"));
			request.setAttribute("type", ParamUtil.getString(request, "typeDefault"));
			request.setAttribute("topic", ParamUtil.getString(request, "topicDefault"));
			request.setAttribute("body", ParamUtil.getString(request, "bodyDefault"));
			request.setAttribute("deadline", ParamUtil.getString(request, "deadlineDefault"));
			request.setAttribute("startdate", ParamUtil.getString(request, "startdateDefault"));
			request.setAttribute("phone", ParamUtil.getString(request, "phoneDefault"));
			request.setAttribute("username", ParamUtil.getString(request, "usernameDefault"));
			request.setAttribute("zona", ParamUtil.getString(request, "zonaDefault"));
			request.setAttribute("zonaparam", ParamUtil.getString(request, "zonaparamDefault"));
			request.setAttribute("photo1", photoup1);
			request.setAttribute("photo2", photoup2);
			request.setAttribute("photo3", photoup3);
			request.setAttribute("photo4", photoup4);
			request.setAttribute("errorInserimento", "false");
			
			request.setAttribute("navigation", "dialogupdate");
			
		}
	}
	
	
	@ProcessAction(name = "searchAdvCombine")
	public void searchAdvCombine(ActionRequest request, ActionResponse response) throws IOException, PortalException {
		
		String keyword = request.getParameter("textSearch");
		if (keyword == null) {
			keyword = "";
		} 
		String categories[] = null;
		long categoriesLong[] = null;
		if (ParamUtil.getParameterValues(request, "catgo") != null) {
			categories = ParamUtil.getParameterValues(request, "catgo");
			categoriesLong = new long[categories.length];
			for (int i = 0; i < categories.length; i++) {
				categoriesLong[i] = Long.parseLong(categories[i]);
			}
		}
		if (categories != null && categories.length == 0) {
			List<AssetVocabulary> allCategories = AssetVocabularyLocalServiceUtil.getAssetVocabularies(QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
			for (AssetVocabulary j : allCategories) {
				if (j.getName().equals(CATEGORIA)) {
					categoriesLong = new long[j.getCategories().size()];
					int index = 0;
					for (AssetCategory assetCat : j.getCategories()) {
						categoriesLong[index] = assetCat.getCategoryId();
						index++;
					}
					break;
				}
			}
		}
		String filter = ParamUtil.getString(request, "filter");
		AnnunciUtils util = new AnnunciUtils();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getLayout().getGroupId();
		String strkey = util.getStructureIdFromName(DDM_STRUCTURE_NAME);
		List<AnnuncioBean> listannunci = annunciListFromSearch(groupId, strkey, util, keyword, 0, categoriesLong, 0);
		request.setAttribute("filter", filter);
		request.setAttribute("advList", listannunci);
		request.setAttribute("textSearch", keyword);
		String categoriesText[] = ParamUtil.getParameterValues(request, "catgotext");
		if (categoriesText != null && categoriesText.length > 0 && !"tutte".equals(categoriesText[0]))
			request.setAttribute("cat", categoriesText);
	}
	
	
	public void importAnnunciAction(ActionRequest actionRequest, ActionResponse actionResponse) throws ParseException {
		_log.debug("eseguo l'import degli annunci");
	
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");		
		SimpleDateFormat sdf0 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		String listaXML = ParamUtil.getString(actionRequest,"listaXML");
		_log.debug("xml status: "+listaXML);
		
		AssetVocabulary vocabulary=null;
		try {
			vocabulary = AssetVocabularyLocalServiceUtil.getGroupVocabulary(themeDisplay.getScopeGroupId(), DDM_STRUCTURE_NAME.toLowerCase());
		} catch (PortalException e2) {
			// TODO Auto-generated catch block
			_log.error(e2);
		} //pass name of Vocabulary 
		long vocabularyId = vocabulary.getVocabularyId();
		List<AssetCategory> categoryList = AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabularyId, -1, -1, null); //List of all categories
		
		ArrayList<AnnuncioBean> listaAnnunci = new ArrayList<>();
		try {
			Document document = SAXReaderUtil.read(new StringReader(listaXML));
			Element element = document.getRootElement();
			_log.debug(element.asXML());
			List<Node> rows = document.selectNodes("/RESULTS/ROW");
			
			for (Node row: rows){
				AssetCategory topicCat = null;
				AnnuncioBean annuncio = new AnnuncioBean();
				_log.debug("riga individuata");
				Node columnID = row.selectSingleNode("COLUMN[@NAME = 'ID']");
				Node columnDataIns = row.selectSingleNode("COLUMN[@NAME = 'DATA_INSERIMENTO']");
				Node columnUser = row.selectSingleNode("COLUMN[@NAME = 'UTENTE']");
				Node columnDescription = row.selectSingleNode("COLUMN[@NAME = 'ANNUNCIO']");
				Node columnEmail = row.selectSingleNode("COLUMN[@NAME = 'EMAIL']");
				Node columnPhone = row.selectSingleNode("COLUMN[@NAME = 'TELEFONO']");
				Node columnDeadline = row.selectSingleNode("COLUMN[@NAME = 'DATA_SCADENZA']");
				Node columnArgomento = row.selectSingleNode("COLUMN[@NAME = 'ARGOMENTO']");
				Node columnProvincia = row.selectSingleNode("COLUMN[@NAME = 'PROVINCIA']");
				
				try{
					annuncio.setDatainserimento(sdf0.parse(columnDataIns.getText()));
		    		annuncio.setDeadline(sdf0.parse(columnDeadline.getText()));
		    		annuncio.setDescrizione(columnDescription.getText());
		    		annuncio.setTipologia("offresi");
		    		for(AssetCategory asset: categoryList)
		    		{
		    			String categoryName = asset.getName(); //get category Name
		    			if(categoryName.equalsIgnoreCase(columnArgomento.getText())){
		    				topicCat = asset;
		    				annuncio.setCategoriaDescrizione(""+asset.getCategoryId());
				    		annuncio.setCategoriaNome(categoryName);
				    		break;
		    			}
		    		}
		    		if (topicCat==null){
		    			continue;
		    		}
		    		
		    		annuncio.setNomeUtente(columnUser.getText());
		    		annuncio.setEmail(columnEmail.getText());
		    		annuncio.setTelefono(columnPhone.getText());
		    		annuncio.setZona(columnProvincia.getText());
		    		annuncio.setTitolo(columnID.getText());		    		
		    		listaAnnunci.add(annuncio);
				}catch(Exception e){
					_log.debug("L'annuncio con id" +columnID.getText());
					_log.error(e);
					continue;
				}
			}
			
		} catch (DocumentException e) {
			_log.debug("errore nel parse dell'xml "+e);
		}
    	
		_log.debug("Ho preparato la lista degli annunci");
		
		
		
		
		String ddmStructureKey = _ddmStructure.getStructureKey();
		String ddmTemplateKey = _ddmTemplate.getTemplateKey();
		_log.debug("structureKey: "+ddmStructureKey);
		_log.debug("ddmTemplateKey: "+ddmTemplateKey);
		_log.debug("ddmStructureId: "+_ddmStructure.getStructureId());
		long folderId = JournalFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		_log.debug("folderId: "+folderId);

		
		long groupId = themeDisplay.getScopeGroupId();
		Fields fields = null;
		ServiceContext serviceContext = null;
		try {
			 serviceContext = ServiceContextFactory.getInstance(actionRequest);
			 fields = DDMUtil.getFields(_ddmStructure.getStructureId(), serviceContext);
		}catch (PortalException e){
			_log.debug(e);
		}
		_log.debug("INIZIO IL CICLO DEGLI ANNUNCI");
		
		
		for (AnnuncioBean annuncio: listaAnnunci){
			
			Field deadlineField = new Field(_ddmStructure.getStructureId(), "Deadline", sdf.format(annuncio.getDeadline()));
			fields.put(deadlineField);
			Field startDateField = new Field(_ddmStructure.getStructureId(), "StartDate", sdf.format(annuncio.getDatainserimento()));
			fields.put(startDateField);
			Field title = new Field(_ddmStructure.getStructureId(), "Title", annuncio.getTitolo());
			fields.put(title);
			Field user = new Field(_ddmStructure.getStructureId(), "User", annuncio.getNomeUtente());
			fields.put(user);
			Field topic = new Field(_ddmStructure.getStructureId(), "Topic", annuncio.getCategoriaNome()); 
			fields.put(topic);
			Field zona = new Field(_ddmStructure.getStructureId(), "Zona", annuncio.getZona()); 
			fields.put(zona);
			Field body = new Field(_ddmStructure.getStructureId(), "Body", annuncio.getDescrizione()); 
			fields.put(body);
			Field phoneNumber = new Field(_ddmStructure.getStructureId(), "PhoneNumber", annuncio.getTelefono());  
			fields.put(phoneNumber);
			Field email = new Field(_ddmStructure.getStructureId(), "Email", annuncio.getEmail());  
			fields.put(email);
			Field type = new Field(_ddmStructure.getStructureId(), "Type", annuncio.getTipologia());  
			fields.put(type);
			
			Map<Locale, String> titleMap = LocalizationUtil.getLocalizationMap(actionRequest, "title");
			titleMap.put(themeDisplay.getLocale(), fields.get("Title").getValue(themeDisplay.getLocale()).toString());
			Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(actionRequest, "description");
			descriptionMap.put(themeDisplay.getLocale(), annuncio.getDescrizione());
			Field fieldDisplay = new Field();
			
			Field fieldTopic = new Field();
			fieldTopic.setName("Topic");
			fieldTopic.setValue(annuncio.getCategoriaNome());
			fieldTopic.setDDMStructureId(_ddmStructure.getStructureId());
			fields.remove("Topic");
			fields.put(fieldTopic);
			
			fieldDisplay.setName(DISPLAY_FIELDS_NAME);			
			fieldDisplay.setValue(
			"Title_INSTANCE_tgjd,User_INSTANCE_asqf,StartDate_INSTANCE_wmll,Deadline_INSTANCE_wmld,Topic_INSTANCE_poiu,Body_INSTANCE_asdf,"
			+ "Email_INSTANCE_lkjh,Photo1_INSTANCE_ljkq,Photo2_INSTANCE_phts,Photo3_INSTANCE_kafg,Photo4_INSTANCE_svfr,Type_INSTANCE_fghj,Zona_INSTANCE_zxfc,PhoneNumber_INSTANCE_ghqp");
			fieldDisplay.setDDMStructureId(_ddmStructure.getStructureId());
			fields.put(fieldDisplay);
			String content = "";
			String structureContent = StringPool.BLANK;
			Map<String, byte[]> structureImages = null;
			try { 
				structureContent = _journalConverter.getContent(_ddmStructure, fields);
				structureImages = ActionUtil.getImages(structureContent, fields);
			}catch (Exception e){
				_log.debug(e);
			}
			
			Object[] contentAndImages = new Object[] { structureContent, structureImages };
		
			if (contentAndImages.length > 1) {
				content = (String) contentAndImages[0];
				
			}
			content = content.replace("default-locale=\"en_US\"", "default-locale=\"it_IT\"");
			
			_log.debug("Sto per salvare l'annuncio");
			_log.debug("content: "+content);
			
			String idCategoria = actionRequest.getPreferences().getValue("metaAreaCategoria", _configuration.metaAreaCategoria());
			long[] assetCategoryIds = { Long.parseLong(idCategoria), Long.parseLong(annuncio.getCategoriaDescrizione()) };
			serviceContext.setAssetCategoryIds(assetCategoryIds);
			long idUtente = 0;
			try {
				idUtente = UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(), annuncio.getNomeUtente()).getUserId();
			} catch (PortalException e1) {
				_log.error(e1);
			}
			try {
				if (idUtente !=0){
					JournalArticle	article = JournalArticleLocalServiceUtil.addArticle(idUtente, groupId, folderId, titleMap, descriptionMap, content, ddmStructureKey, ddmTemplateKey, serviceContext);
					article.setReviewDate(annuncio.getDeadline());
					article.setDisplayDate(annuncio.getDatainserimento());
					JournalArticleLocalServiceUtil.updateJournalArticle(article);
					JournalUtil.addRecentArticle(actionRequest, article);
					_log.debug("Annuncio inserito");
				}else {
					_log.debug("Utente con email: "+annuncio.getEmail()+" non trovato");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				_log.debug("non riesco ad inserire l'annuncio con id "+annuncio.getId());
				_log.error(e);
			}
			
		}
		PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
		themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		renderUrl.setParameter("added", "true");
		try {
			actionResponse.sendRedirect(renderUrl.toString());
		} catch (IOException e) {
			_log.error(e);
		}
		
	}
	
	
	public void addWebContentAction(ActionRequest actionRequest, ActionResponse actionResponse)
	throws IOException, PortletException, PortalException, Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			
			String ddmStructureKey = _ddmStructure.getStructureKey();
			String ddmTemplateKey = _ddmTemplate.getTemplateKey();
			_log.debug("structureKey: "+ddmStructureKey);
			_log.debug("ddmTemplateKey: "+ddmTemplateKey);
			_log.debug("ddmStructureId: "+_ddmStructure.getStructureId());
			long folderId = JournalFolderConstants.DEFAULT_PARENT_FOLDER_ID;
			List<JournalFolder> dlFolders = JournalFolderServiceUtil.getFolders(themeDisplay.getSiteGroupId());
			for (JournalFolder folder : dlFolders) {
				if (folder.getName().equals(BachecaAnnunciListPortlet.FOLDER_NAME)) {
					folderId = folder.getFolderId();
				}
			}
			_log.debug("folderId: "+folderId);
			
			long userId = themeDisplay.getUserId();
			long groupId = themeDisplay.getScopeGroupId();
			long classNameId = ParamUtil.getLong(actionRequest, "classNameId", 0);
			long classPK = ParamUtil.getLong(actionRequest, "classPK", 0);
			String articleId = ParamUtil.getString(actionRequest, "articleId", StringPool.BLANK);
			boolean autoArticleId = ParamUtil.getBoolean(actionRequest, "autoArticleId", true);
			double version = ParamUtil.getDouble(actionRequest, "version", 1.0);
			String layoutUuid = ParamUtil.getString(actionRequest, "layoutUuid", null);
			boolean indexable = true;
			boolean smallImage = ParamUtil.getBoolean(actionRequest, "smallImage", false);
			String smallImageURL = ParamUtil.getString(actionRequest, "smallImageURL", null);
			File smallFile = null;
			Map<String, byte[]> img = new HashMap<String, byte[]>();
			String articleURL = ParamUtil.getString(actionRequest, "articleURL");
			UploadPortletRequest uploadPortletRequest = _portal.getUploadPortletRequest(actionRequest);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(JournalArticle.class.getName(), uploadPortletRequest);
			Fields fields = DDMUtil.getFields(_ddmStructure.getStructureId(), serviceContext);
			// Costruisce la titleMap partendo dalla form. I campi dei titoli
			// devono chiamarsi "title_{LanguageId}", quelli del summary
			// "description_{languageId}"
			Field fieldTitle = new Field();
			String topicField = actionRequest.getParameter("Topic");
			AssetCategory topicCat;
			if (topicField != null && topicField != "") {
				topicCat = AssetCategoryLocalServiceUtil.getAssetCategory(Long.parseLong(topicField));
			} else
				throw new BachecaAnnunciException("topic empty");
			Field fieldTopic = new Field();
			fieldTopic.setName("Topic");
			fieldTopic.setValue(topicCat.getName());
			fieldTopic.setDDMStructureId(_ddmStructure.getStructureId());
			fields.remove("Topic");
			fields.put(fieldTopic);
			fieldTitle.setName("Title");
			fieldTitle.setValue(fields.get("Topic").getValue(themeDisplay.getLocale()).toString());
			fieldTitle.setDDMStructureId(_ddmStructure.getStructureId());
			fields.put(fieldTitle);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
			Date startDate = new Date();
			Calendar todayCalendar = Calendar.getInstance();
			todayCalendar.add(Calendar.DATE, -1);
			Date yesterday = new Date(todayCalendar.getTimeInMillis());
			boolean neverExpire = true;
			boolean neverReview = false;
			String displayDateString = actionRequest.getParameter("StartDate");
			String[] dateDisplay = { "01", "01", "2017" };
			if (displayDateString != null && !"".equals(displayDateString)) {
				dateDisplay = displayDateString.split("/");
			}
			String[] dateExp = { "01", "01", "2017" };
			String expDateString = actionRequest.getParameter("Deadline");
			if (expDateString != null && !"".equals(expDateString)) {
				dateExp = expDateString.split("/");
			}
			int reviewDateMonth = Integer.parseInt(dateExp[1]) - 1;
			int reviewDateDay = Integer.parseInt(dateExp[0]);
			int reviewDateYear = Integer.parseInt(dateExp[2]);
			int reviewDateHour = 0;
			int reviewDateMinute = 0;
			if (fields.get("StartDate") != null) {
				startDate = sdf2.parse(actionRequest.getParameter("StartDate"));
				if (startDate.after(yesterday)) {
					Field fielddate = new Field();
					fielddate.setName("StartDate");
					fielddate.setValue(sdf.format(startDate));
					fielddate.setDDMStructureId(_ddmStructure.getStructureId());
					fields.remove("StartDate");
					fields.put(fielddate);
				} else {
					actionRequest.setAttribute("added", false);
					PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
					renderUrl.setWindowState(LiferayWindowState.NORMAL);
					renderUrl.setPortletMode(LiferayPortletMode.VIEW);
					renderUrl.setParameter("navigation", "inserisciannuncio");
					renderUrl.setParameter("errorInserimento", "false");
					actionResponse.sendRedirect(renderUrl.toString());
					Exception e = new Exception("StartDate cannot set before today");
					_log.warn("Exception", e);
					throw e;
				}
			}
			if (fields.get("Deadline") != null) {
				
				Date endDate = sdf2.parse(actionRequest.getParameter("Deadline"));
				Calendar previousStartDate = Calendar.getInstance();
				previousStartDate.setTime(startDate);
				previousStartDate.add(Calendar.DAY_OF_MONTH, -1);
				Date beforeStartDate = new Date(todayCalendar.getTimeInMillis());
				if (endDate.after(yesterday) && endDate.after(beforeStartDate)) {
					Field fielddate = new Field();
					fielddate.setName("Deadline");
					fielddate.setValue(sdf.format(endDate));
					fielddate.setDDMStructureId(_ddmStructure.getStructureId());
					fields.remove("Deadline");
					fields.put(fielddate);
				} else {
					actionRequest.setAttribute("added", false);
					PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
					renderUrl.setWindowState(LiferayWindowState.NORMAL);
					renderUrl.setPortletMode(LiferayPortletMode.VIEW);
					renderUrl.setParameter("navigation", "inserisciannuncio");
					renderUrl.setParameter("errorInserimento", "false");
					actionResponse.sendRedirect(renderUrl.toString());
					Exception e = new Exception("StartDate cannot set before today");
					_log.warn("Exception", e);
					throw e;
				}
			}
			Map<Locale, String> titleMap = LocalizationUtil.getLocalizationMap(actionRequest, "title");
			titleMap.put(themeDisplay.getLocale(), fields.get("Topic").getValue(themeDisplay.getLocale()).toString());
			Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(actionRequest, "description");
			descriptionMap.put(themeDisplay.getLocale(), fields.get("Body").getValue(themeDisplay.getLocale()).toString());
			Field fieldDisplay = new Field();
			fieldDisplay.setName(DISPLAY_FIELDS_NAME);
			// TODO ricavare il value di _fieldsDisplay dinamicamente dai campi
			// della form !!!attenzione non inserire spazi
			fieldDisplay.setValue(
			"Title_INSTANCE_tgjd,User_INSTANCE_asqf,StartDate_INSTANCE_wmll,Deadline_INSTANCE_wmld,Topic_INSTANCE_poiu,Body_INSTANCE_asdf,"
			+ "Email_INSTANCE_lkjh,Photo1_INSTANCE_ljkq,Photo2_INSTANCE_phts,Photo3_INSTANCE_kafg,Photo4_INSTANCE_svfr,Type_INSTANCE_fghj,Zona_INSTANCE_zxfc,PhoneNumber_INSTANCE_ghqp");
			fieldDisplay.setDDMStructureId(_ddmStructure.getStructureId());
			fields.put(fieldDisplay);
			String content = StringPool.BLANK;
			String structureContent = _journalConverter.getContent(_ddmStructure, fields);
			_log.debug("Structure content: "+structureContent);
			Map<String, byte[]> structureImages = ActionUtil.getImages(structureContent, fields);
			Object[] contentAndImages = new Object[] { structureContent, structureImages };
			if (contentAndImages.length > 1) {
				content = (String) contentAndImages[0];
				img = (HashMap<String, byte[]>) contentAndImages[1];
			}
			content = content.replace("default-locale=\"en_US\"", "default-locale=\"it_IT\"");
			_log.debug("content: "+content);
			String idCategoria = actionRequest.getPreferences().getValue("metaAreaCategoria", _configuration.metaAreaCategoria());
			long[] assetCategoryIds = { Long.parseLong(idCategoria), topicCat.getCategoryId() };
			serviceContext.setAssetCategoryIds(assetCategoryIds);
			JournalArticle article = JournalArticleLocalServiceUtil.addArticle(userId, groupId, folderId, classNameId, classPK, articleId, autoArticleId,
			version, titleMap, descriptionMap, content, ddmStructureKey, ddmTemplateKey, layoutUuid, Integer.parseInt(dateDisplay[1]) - 1,
			Integer.parseInt(dateDisplay[0]), Integer.parseInt(dateDisplay[2]), 0, 0, Integer.parseInt(dateExp[1]) - 1,
			Integer.parseInt(dateExp[0]), Integer.parseInt(dateExp[2]), 0, 0, neverExpire, reviewDateMonth, reviewDateDay, reviewDateYear,
			reviewDateHour, reviewDateMinute, neverReview, indexable, smallImage, smallImageURL, smallFile, img, articleURL,
			serviceContext);
			JournalUtil.addRecentArticle(actionRequest, article);
			if (article != null) {
				
				//prepare id for link	
				Long annuncioid = article.getPrimaryKey();
				String artcontent = article.getContent();
				//prepare data for template mail
				AnnunciUtils util = new AnnunciUtils();
				String zona = util.getValueFromStructure(artcontent, "Zona");
				String user = util.getValueFromStructure(artcontent, "User");
				String type = util.getValueFromStructure(artcontent, "Type");
				if (type.contains("offresi"))
					type = "offerta";
				if (type.contains("cercasi"))
					type = "richiesta";
				String startDatestr = util.getValueFromStructure(artcontent, "StartDate");
				String deadlinestr = util.getValueFromStructure(artcontent, "Deadline");
				String email = util.getValueFromStructure(artcontent, "Email");
				String topic = util.getValueFromStructure(artcontent, "Topic");
				String body = util.getValueFromStructure(artcontent, "Body");
				String phoneNumber = util.getValueFromStructure(artcontent, "PhoneNumber");
				StringBuilder dati = new StringBuilder();
				dati.append("<p><b>Utente:</b>");
				dati.append(user);
				dati.append("</p>");
				dati.append("</br>");
				dati.append("<p><b>Data inserimento: </b>");
				dati.append(formatDate(startDatestr));
				dati.append("</p>");
				dati.append("</br>");
				dati.append("<p><b>Data scadenza: </b>");
				dati.append(formatDate(deadlinestr));
				dati.append("</p>");
				dati.append("</br>");
				dati.append("<p><b>Zona: </b>");
				dati.append(zona);
				dati.append("</p>");
				dati.append("</br>");
				dati.append("<p><b>Argomento: </b>");
				dati.append(topic);
				dati.append("</p>");
				dati.append("</br>");
				dati.append("<p><b>Tipologia: </b>");
				dati.append(type);
				dati.append("</p>");
				dati.append("</br>");
				dati.append("<p><b>Telefono: </b>");
				dati.append(phoneNumber);
				dati.append("</p>");
				dati.append("</br>");
				dati.append("<p><b>Email: </b>");
				dati.append(email);
				dati.append("</p>");
				dati.append("</br>");
				dati.append("<p><b>Testo Annuncio: </b>");
				dati.append(body);
				dati.append("</p>");
				dati.append("</br>");
				String subject = actionRequest.getPreferences().getValue("subject", _configuration.subject());
				PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
				themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
				renderUrl.setWindowState(LiferayWindowState.NORMAL);
				renderUrl.setPortletMode(LiferayPortletMode.VIEW);
				renderUrl.setParameter("annuncioId", Long.toString(annuncioid));
				renderUrl.setParameter("navigation", "advdetail");
				String mailbody = actionRequest.getPreferences().getValue("inserisciannuncioTmpl", _configuration.inserisciannuncioTmpl());
				mailbody = StringUtil.replace(mailbody, new String[] { "[$UTENTEANNUNCIO$]", "[$DATI$]", "[$LINK$]" },
				new String[] { user, dati.toString(), renderUrl.toString() });
				EmailSender mail = new EmailSender();
				//get moderatore annunci users
				Role ruolo = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), ROLE_NAME);
				Long rolemoderatoreid = ruolo.getRoleId();

				
				List<User> users = UserLocalServiceUtil.getRoleUsers(rolemoderatoreid);
				String sender = actionRequest.getPreferences().getValue("sender", _configuration.sender());
				sender = sender.replaceAll(" ", ".");
				String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
				for (User usermod : users) {
					mail.sendMailMessage(subject, mailbody, sender, smtpUser, usermod.getEmailAddress());
				}
			}
			PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
			themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			renderUrl.setParameter("added", "true");
			actionResponse.sendRedirect(renderUrl.toString());

		} catch (Exception e) {
			actionRequest.setAttribute("added", false);
			PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
			themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			renderUrl.setWindowState(LiferayWindowState.NORMAL);
			renderUrl.setPortletMode(LiferayPortletMode.VIEW);
			renderUrl.setParameter("navigation", "inserisciannuncio");
			renderUrl.setParameter("errorInserimento", "false");
			actionResponse.sendRedirect(renderUrl.toString());
			_log.warn("Exception", e);
		}
	}
	
	//method to go to dialogupdate.jsp
	public void dialogviewupdate(ActionRequest actionRequest, ActionResponse actionResponse) throws WindowStateException, PortletModeException, IOException, ParseException {
		
		actionRequest.setAttribute("itemSelectorURL", actionRequest.getParameter("itemSelectorURL"));
		actionRequest.setAttribute("annuncioId", actionRequest.getParameter("annuncioId"));
		actionRequest.setAttribute("titolo", actionRequest.getParameter("titolo"));
		actionRequest.setAttribute("userId", actionRequest.getParameter("userId"));
		actionRequest.setAttribute("email", actionRequest.getParameter("email"));
		actionRequest.setAttribute("type", actionRequest.getParameter("type"));
		actionRequest.setAttribute("topic", actionRequest.getParameter("topic"));
		actionRequest.setAttribute("body", actionRequest.getParameter("body"));
		actionRequest.setAttribute("deadline", actionRequest.getParameter("deadline"));
		actionRequest.setAttribute("startdate", actionRequest.getParameter("startdate"));
		actionRequest.setAttribute("phone", actionRequest.getParameter("phone"));
		actionRequest.setAttribute("username", actionRequest.getParameter("username"));
		actionRequest.setAttribute("zona", actionRequest.getParameter("zona"));
		actionRequest.setAttribute("zonaparam", actionRequest.getParameter("zonaparam"));
		actionRequest.setAttribute("photo1", actionRequest.getParameter("photo1"));
		actionRequest.setAttribute("photo2", actionRequest.getParameter("photo2"));
		actionRequest.setAttribute("photo3", actionRequest.getParameter("photo3"));
		actionRequest.setAttribute("photo4", actionRequest.getParameter("photo4"));
		
		actionRequest.setAttribute("navigation", "dialogupdate");
		
	}
	
	private List<AnnuncioBean> annunciListFromSearch(long groupId, String strkey, AnnunciUtils util, String searchText, long postedByIdUser,
		long[] categorie, int rowNumber) {
		List<AnnuncioBean> advertiseList = new ArrayList<>();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		DynamicQuery queryJournal = DynamicQueryFactoryUtil.forClass(JournalArticle.class, "article",
		JournalArticleImpl.class.getClassLoader());
		Property propertyGroupId = PropertyFactoryUtil.forName("article.groupId");
		queryJournal.add(propertyGroupId.eq(groupId));
		Property propertyStatus = PropertyFactoryUtil.forName("article.status");
		queryJournal.add(propertyStatus.ne(8));
		Property propertyStructure = PropertyFactoryUtil.forName("article.DDMStructureKey");
		queryJournal.add(propertyStructure.eq(strkey));
		Property propertyVersion = PropertyFactoryUtil.forName("article.version");
		DynamicQuery versionQuery = DynamicQueryFactoryUtil.forClass(JournalArticle.class, "versiontable",
		JournalArticleImpl.class.getClassLoader());
		versionQuery.setProjection(ProjectionFactoryUtil.max("versiontable.version"));
		Property propertyVersionA = PropertyFactoryUtil.forName("versiontable.articleId");
		versionQuery.add(propertyVersionA.eqProperty("article.articleId"));
		queryJournal.add(propertyVersion.in(versionQuery));
		Property propertyStartDate = PropertyFactoryUtil.forName("article.displayDate");
		Property propertyDeadline = PropertyFactoryUtil.forName("article.reviewDate");
		Calendar todayCalendar = Calendar.getInstance();
		todayCalendar.add(Calendar.DATE, -1);
		Calendar tommorowCalendar = Calendar.getInstance();
		tommorowCalendar.add(Calendar.DATE, 1);
		Date yesterday = new Date(todayCalendar.getTimeInMillis());
		Date tomorrow = new Date(tommorowCalendar.getTimeInMillis());
		
		
		if (!"".equals(searchText)) {
			Disjunction disjunctionKey = RestrictionsFactoryUtil.disjunction();
			String value = (new StringBuilder("%")).append(searchText).append("%").toString();
			disjunctionKey.add(RestrictionsFactoryUtil.ilike("article.title", value));
			disjunctionKey.add(RestrictionsFactoryUtil.ilike("article.content", value));
			disjunctionKey.add(RestrictionsFactoryUtil.ilike("article.title", value));
			queryJournal.add(disjunctionKey);
		}
		if (postedByIdUser > 0) {
			Property propertyPostedBy = PropertyFactoryUtil.forName("article.userId");
			queryJournal.add(propertyPostedBy.eq(postedByIdUser));
		}
		if (postedByIdUser == 0) {
			tomorrow.setHours(0);
			tomorrow.setMinutes(0);
			tomorrow.setSeconds(0);
			queryJournal.add(propertyStartDate.lt(tomorrow));
			queryJournal.add(propertyDeadline.gt(yesterday));	
		}
		boolean flagCategorie = true;
		if (categorie != null && categorie.length > 0) {
			
			Property propertyResource = PropertyFactoryUtil.forName("article.resourcePrimKey");
			AssetEntryQuery assetEntryQuery = new AssetEntryQuery();
			assetEntryQuery.setAnyCategoryIds(categorie); // Represent Both ie AND
			try {
				List<AssetEntry> assetEntries = AssetEntryServiceUtil.getEntries(assetEntryQuery);
				if (assetEntries != null && !assetEntries.isEmpty()) {
					List<Long> classPks = new ArrayList<>();
					for (AssetEntry assetEntry : assetEntries) {
						if (assetEntry != null) {
							classPks.add(assetEntry.getClassPK());
						}
					}
					if (classPks != null && !classPks.isEmpty())
						queryJournal.add(propertyResource.in(classPks.toArray()));
					else
						flagCategorie = false;
					
				} else
					flagCategorie = false;
			} catch (PortalException e) {
				_log.warn(e);
			}
		}
		queryJournal.addOrder(OrderFactoryUtil.desc("article.displayDate"));
		queryJournal.addOrder(OrderFactoryUtil.desc("article.articleId"));
		List<JournalArticle> journalList = null;
		if (flagCategorie){
			if (rowNumber > 0){
				journalList = JournalArticleLocalServiceUtil.dynamicQuery(queryJournal, 0, rowNumber);
			}else {
				journalList = JournalArticleLocalServiceUtil.dynamicQuery(queryJournal);
			}
			}
		
		if (_categoriaMod == null){
			List<AssetVocabulary> allCategories = AssetVocabularyLocalServiceUtil.getAssetVocabularies(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			for (AssetVocabulary j : allCategories) {
				if (j.getName().equals(CATEGORIA)) {
					_categoriaMod = j;
					break;
				}
			}
		}
		if (_categoriaMod != null){	
			List<AssetCategory> categorieList = _categoriaMod.getCategories();
			Map<String,String> categorieMap = new HashMap<>();
			for(AssetCategory categoria: categorieList){
				categorieMap.put(categoria.getName(),categoria.getDescriptionCurrentValue());
			}
			
			if (journalList != null){
				for (JournalArticle adv : journalList) {
					
					Long idBean = adv.getId();
					
					String content = adv.getContent();
					AnnuncioBean annuncio = new AnnuncioBean();
					// ricavo gli elementi dalla struttura DDM
					String zona = util.getValueFromStructure(content, "Zona");
					String user = util.getValueFromStructure(content, "User");
					// tipologia offresi....
					String type = util.getValueFromStructure(content, "Type");
					String startDatestr = util.getValueFromStructure(content, "StartDate");
					String deadlinestr = util.getValueFromStructure(content, "Deadline");
					Date deadline = new Date();
					Date startDate = new Date();
					try {
						deadline = format.parse(deadlinestr);
						startDate = format.parse(startDatestr);
					} catch (ParseException e) {
						_log.warn(e);
					}
					String email = util.getValueFromStructure(content, "Email");
					// categoria
					String topic = util.getValueFromStructure(content, "Topic");
					String body = util.getValueFromStructure(content, "Body");
					String phoneNumber = util.getValueFromStructure(content, "PhoneNumber");
					// image url
					List<String> photolist = new ArrayList<String>(0);
					String photo1 = util.getValueFromStructure(content, "Photo1");
					if (photo1 != null)
						photolist.add(photo1);
					String photo2 = util.getValueFromStructure(content, "Photo2");
					if (photo2 != null)
						photolist.add(photo2);
					String photo3 = util.getValueFromStructure(content, "Photo3");
					if (photo3 != null)
						photolist.add(photo3);
					String photo4 = util.getValueFromStructure(content, "Photo4");
					if (photo4 != null)
						photolist.add(photo4);
					
					// setting valori sul bean annuncio
					annuncio.setId(idBean);
					annuncio.setNomeUtente(user);
					try {
						User userAnnuncio = UserLocalServiceUtil.getUserById(adv.getUserId());
						annuncio.setNomeUtente(userAnnuncio.getFirstName() + " " + userAnnuncio.getLastName() );
					
					} catch (PortalException e) {
						_log.warn(e);
					}
					
		

					annuncio.setTipologia(type);
					annuncio.setDeadline(deadline);
					annuncio.setDatainserimento(startDate);
					annuncio.setEmail(email);
				
					annuncio.setCategoriaNome(topic);
					if (categorieMap.get(topic)!=null){
						annuncio.setCategoriaDescrizione(categorieMap.get(topic));
					}
					annuncio.setDescrizione(body);
					annuncio.setTelefono(phoneNumber);
					annuncio.setFoto(photolist);
					annuncio.setZona(zona);
					advertiseList.add(annuncio);
				}
			}
		}else{
			_log.warn("not exist category: " + CATEGORIA);
		}
		
		return advertiseList;
	}
	
	private String formatDate(String date) {
		String out = "";
		if (date != null && date != StringPool.BLANK) {
			StringBuilder datastr = new StringBuilder();
			String[] datechunk = date.split("-");
			datastr.append(datechunk[2]);
			datastr.append("-");
			datastr.append(datechunk[1]);
			datastr.append("-");
			datastr.append(datechunk[0]);
			out = datastr.toString();
		}
		return out;
	}
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(BachecaAnnunciListConfig.class, properties);
	}
	
	private volatile BachecaAnnunciListConfig _configuration;
	
	
	
	@Reference
	protected void setPortal(Portal portal) {
		_portal = portal;
	}
	
	@Reference
	protected void setJournalConverter(JournalConverter journalConverter) {
		_journalConverter = journalConverter;
	}
}