package modulistica.mef.portlet;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetEntryServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.asset.kernel.service.persistence.AssetEntryQuery;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
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
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LayoutTypePortletFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
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
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import modulistica.mef.beans.Module_bean;

/**
 * @author pier.paolo.annis
 */
@Component(configurationPid = "modulistica.mef.portlet.ModulisticaMefConfig", immediate = true, property = {
	"com.liferay.portlet.display-category=Mef-Portlet", "com.liferay.portlet.instanceable=true",
	"javax.portlet.display-name=modulistica-mef Portlet", "javax.portlet.init-param.template-path=/",
	"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.resource-bundle=content.Language",
	"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class ModulisticaMefPortlet extends MVCPortlet {
	final Log _log = LogFactoryUtil.getLog(ModulisticaMefPortlet.class);
	private final static String PORTLET_NAME = "modulistica_mef_portlet_ModulisticaMefPortlet";
	public static final String CATEGORIA = "modulistica";
	private volatile ModulisticaMefConfig _configuration;
	private static final String CATGO = "catgo";
	private static final String CATGOID = "catgoId";
	private static final String LASTDOWNLOADDATE ="LastDownloadDate";
	
	String days;
	List<Module_bean> list_Bean = new ArrayList<Module_bean>(0);
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		renderRequest.setAttribute(ModulisticaMefConfig.class.getName(), _configuration);
		List<DLFileEntry> filesView = new ArrayList<>();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PermissionChecker permchecker=themeDisplay.getPermissionChecker();
		long groupId = themeDisplay.getLayout().getGroupId();
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		days = renderRequest.getPreferences().getValue("days", _configuration.days());
		try {
			String folder = renderRequest.getPreferences().getValue("folder", _configuration.folder());
			Long  folderId = DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, folder).getFolderId();
			List<DLFileEntry> listaView=moduliListFromSearch(permchecker,groupId, folderId, "", null);
			
			
//			for (DLFileEntry dlFileEntry : listaCategories) {
//				if(themeDisplay.getPermissionChecker().hasPermission(groupId, DLFileEntry.class.getName(), dlFileEntry.getPrimaryKey(), ActionKeys.VIEW)){
//					listaView.add(dlFileEntry);
//				}
//			}

			if (("Categories").equals(renderRequest.getPreferences().getValue("viewTheme", _configuration.viewTheme()))) {
				renderRequest.setAttribute("allDocuments", listaView);
				
			} else {
								
				Date today = new Date();
				Calendar c = Calendar.getInstance();
				c.add(Calendar.DATE, -(Integer.valueOf(days)));
				Collections.sort(listaView,
				(a, b) -> a.getReadCount() > b.getReadCount() ? -1 : a.getReadCount() == b.getReadCount() ? 0 : 1);
				for (DLFileEntry df : listaView) {
					Date lastD;
					lastD = (Date) df.getFileVersion().getExpandoBridge().getAttribute(LASTDOWNLOADDATE);
					if (lastD.before(today) && lastD.after(c.getTime())) {
						filesView.add(df);
					}
				}
				if (filesView.isEmpty()) {
					filesView = listaView;
				}
				String linkLayout = PrefsParamUtil.getString(renderRequest.getPreferences(), renderRequest, "modulisticaPage");
				PortletURL linkLayoutmyUrl = null;
				String porletIdModulistica = "";
				try {
					Layout l = LayoutLocalServiceUtil.getLayout(themeDisplay.getSiteGroupId(), themeDisplay.getLayout().isPrivateLayout(),
					Long.parseLong(linkLayout));
					linkLayout = PortalUtil.getLayoutFriendlyURL(l, themeDisplay);
					LayoutTypePortlet layoutTypePortlet = LayoutTypePortletFactoryUtil.create(l);
					List<String> portletIdList = layoutTypePortlet.getPortletIds();
					for (String pid : portletIdList) {
						if (pid.indexOf(PORTLET_NAME) != -1) {
							porletIdModulistica = pid;
							break;
						}
					}
					linkLayoutmyUrl = PortletURLFactoryUtil.create(renderRequest, porletIdModulistica, l, PortletRequest.ACTION_PHASE);
					
					linkLayoutmyUrl.setParameter("_" + porletIdModulistica + "_javax.portlet.action", "combinedFilters");
				} catch (Exception e) {
					
					_log.warn(e);
				}
				renderRequest.setAttribute("modulisticaPage", linkLayout);
				renderRequest.setAttribute("linkLayoutmyUrl", linkLayoutmyUrl);
				renderRequest.setAttribute("porletId_Modulistica", porletIdModulistica);
				renderRequest.setAttribute("topDocuments", filesView);
			
			}
		} catch (PortalException e) {
		_log.warn(e);
		}
		List<AssetVocabulary> allCategories = AssetVocabularyLocalServiceUtil.getAssetVocabularies(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		AssetVocabulary categoriaMod = null;
		for (AssetVocabulary j : allCategories) {
			if (j.getName().equals(CATEGORIA)) {
				categoriaMod = j;
			}
		}
		renderRequest.setAttribute("category", categoriaMod);
		super.doView(renderRequest, renderResponse);
	}
	
	@Override
	public void processAction(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		
		if (request.getParameter(CATGO) != null && request.getParameter(CATGOID)!=null){
			request.setAttribute(CATGOID, request.getParameter(CATGOID));
			request.setAttribute(CATGO, request.getParameter(CATGO));}
		super.processAction(request, response);
	}
	
	@ProcessAction(name = "selectcategory")
	public void selectcategory(ActionRequest request, ActionResponse response)
	throws IOException, PortalException, ValidatorException, ReadOnlyException, NoSuchFieldException, SecurityException,
	IllegalArgumentException, IllegalAccessException {
		javax.portlet.PortletPreferences preferences = request.getPreferences();
		preferences.setValue("viewTheme", "Categories");
		preferences.store();	
		request.setAttribute("cat", request.getParameter("catId"));
		combinedFilters(request, response);
	}
	
	// dalla lista di Document ottengo la lista di bean
	private List<Module_bean> moduleList(List<DLFileEntry> lista) throws PortalException {
		
		if (!list_Bean.isEmpty()) {
			list_Bean.clear();
		}
		for (DLFileEntry d : lista) {
			Module_bean mb = new Module_bean();
			mb.setId(d.getFileEntryId());
			mb.setTitolo(d.getTitle().toLowerCase());
			mb.setDescrizione(d.getDescription().toLowerCase());
			List<String> categorie = new ArrayList<>();
			List<AssetCategory> categories = AssetEntryLocalServiceUtil.fetchEntry(DLFileEntry.class.getName(), d.getFileEntryId())
			.getCategories();
			for (AssetCategory assetCategory : categories) {
				categorie.add(assetCategory.getName());
			}
			mb.setCategorie(categorie);
			list_Bean.add(mb);
		}
		return list_Bean;
	}
	
	@ProcessAction(name = "combinedFilters")
	public void combinedFilters(ActionRequest request, ActionResponse response)
	throws IOException, PortalException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		String key = request.getParameter("textSearch");
		if (key == null) {
			key = "";
		}
		String[] categories;
		String[] categoriesName= null;
		long[] categoriesLong = null  ;
		String cat = (String) request.getAttribute("cat");
		if (cat == null || ("").equals(cat)) {
			if (ParamUtil.getParameterValues(request, CATGOID) != null && ParamUtil.getParameterValues(request, CATGO)!=null) {
				categoriesName=ParamUtil.getParameterValues(request, CATGO);
				categories = ParamUtil.getParameterValues(request, CATGOID);
				categoriesLong = new long[categories.length];
				for (int i = 0; i < categories.length; i++) {
					categoriesLong[i] = Long.parseLong(categories[i]);
				}
			}
		} else {
			String[] arrayCat = new String[1];
			arrayCat[0] = cat;
			categoriesName = arrayCat;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getLayout().getGroupId();
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		String folder = request.getPreferences().getValue("folder", _configuration.folder());
		Long folderId = DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, folder).getFolderId();	
		List<DLFileEntry> lista_res = moduliListFromSearch(themeDisplay.getPermissionChecker(),groupId, folderId, key, categoriesLong);

		request.setAttribute("lista_res", lista_res);
		request.setAttribute("textSearch", key);
		request.setAttribute("cat", categoriesName);
	}
	
	//Dynamic query ricerca moduli
	private List<DLFileEntry> moduliListFromSearch(PermissionChecker permchecker,long groupId,long folderId, String searchText, long[] categorie) throws PortalException {
		List<DLFileEntry> dlfileentrylist = new ArrayList<>();
		List<DLFileEntry> dlfileentryres = new ArrayList<>();
		DynamicQuery queryModule = DynamicQueryFactoryUtil.forClass(DLFileEntry.class);

	    //search by folder
		queryModule.add(PropertyFactoryUtil.forName("folderId").eq(folderId));
		
		//search by key
		if (!"".equals(searchText)) {
			Disjunction disjunctionKey = RestrictionsFactoryUtil.disjunction();
			String value = (new StringBuilder("%")).append(searchText).append("%").toString();
			disjunctionKey.add(RestrictionsFactoryUtil.ilike("title", value));
			disjunctionKey.add(RestrictionsFactoryUtil.ilike("description", value));
			queryModule.add(disjunctionKey);
		}
		
		   
		 DynamicQuery queryAssetEntry = DynamicQueryFactoryUtil.forClass(AssetEntry.class);	
		 queryAssetEntry.add(PropertyFactoryUtil.forName("visible").eq(true));
		 queryAssetEntry.setProjection(ProjectionFactoryUtil.property("classPK")); 
		 queryModule.add(PropertyFactoryUtil.forName("fileEntryId").in(queryAssetEntry));
		
		 
		//search by categories
			boolean flagCategorie = true;
			   long[] groupIds=new long[1];
			    groupIds[0]=groupId;
		    if (categorie != null && categorie.length > 0) {
			Property propertyDLEntry = PropertyFactoryUtil.forName("fileEntryId");
			AssetEntryQuery assetEntryQuery = new AssetEntryQuery();
			assetEntryQuery.setClassName(DLFileEntry.class.getName());
			assetEntryQuery.setAnyCategoryIds(categorie); // Represent Both ie AND
		
			try {
				List<AssetEntry> assetEntries = AssetEntryServiceUtil.getEntries(assetEntryQuery);
				if (assetEntries != null && !assetEntries.isEmpty()) {
					List<Long> classPks = new ArrayList<>();
					
					for (AssetEntry assetEntry : assetEntries) {
						
							classPks.add(assetEntry.getClassPK());
						
					}
					if (!classPks.isEmpty())
						queryModule.add(propertyDLEntry.in(classPks.toArray()));
					else
						flagCategorie = false;
					
				} else
					flagCategorie = false;
			} catch (PortalException e) {
				_log.warn(e);
			}
		
			}
		//order by createDate
		queryModule.addOrder(OrderFactoryUtil.desc("createDate"));

		if (flagCategorie){
				dlfileentrylist = DLFileEntryLocalServiceUtil.dynamicQuery(queryModule);	
			}
	
		for (DLFileEntry dlFileEntry : dlfileentrylist) {
		if(permchecker.hasPermission(groupId, DLFileEntry.class.getName(), dlFileEntry.getPrimaryKey(), ActionKeys.VIEW)){
			dlfileentryres.add(dlFileEntry);
		}
	}
		
		
		return dlfileentryres;
	}
	
	
	public String getViewTheme(Map viewTheme) {
		return (String) viewTheme.get(_configuration.viewTheme());
	}
	
	public Integer getItemsPerPage(Map itemsPerPage) {
		return (Integer) itemsPerPage.get(_configuration.itemsPerPage());
	}
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(ModulisticaMefConfig.class, properties);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		
		try {
		
			String fileId = ParamUtil.getString(resourceRequest, "dlFileId");
			DLFileEntry dlFile = DLFileEntryLocalServiceUtil.getDLFileEntry(Long.parseLong(fileId));
			Date lastDownL = (Date) dlFile.getFileVersion().getExpandoBridge().getAttribute(LASTDOWNLOADDATE);
			Date today = new Date();
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE, -(Integer.valueOf(days)));
			if (lastDownL.after(today) || lastDownL.before(c.getTime())) {
				
				DLFileEntryLocalService ds = DLFileEntryLocalServiceUtil.getService();
				ds.incrementViewCounter(dlFile, -(dlFile.getReadCount()));
			
			}
			dlFile.getFileVersion().getExpandoBridge().setAttribute("LastDownloadDate", today);
			
		} catch (NumberFormatException | PortalException e) {
		_log.warn(e);
		}
		super.serveResource(resourceRequest, resourceResponse);
	}
	
	
	
}