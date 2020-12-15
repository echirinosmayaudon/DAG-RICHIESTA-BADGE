package com.intranet.mef.search.pre.action;

import com.intranet.mef.central.util.UserInfoUtil;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.security.auth.AuthTokenUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@Component(immediate = true, property = { "key=servlet.service.events.pre" }, service = LifecycleAction.class)
public class SearchPreAction implements LifecycleAction {

	final Log log = LogFactoryUtil.getLog(SearchPreAction.class);
	private static final String IS_SEARCH_PAGE = "isSearchPage";
	private static final String IS_APPLICATION_MANAGEMENT_PAGE = "isApplicationManagementPage";
	private static final String IS_GESTIONE_SCRIVANIE_PAGE = "isGestioneScrivaniePage";
	private static final String URL_MAP = "urlMap";
	private static final String INTERNAL_IP = "217.175.48.51,217.175.51.15,217.175.52.59,217.175.52.60,217.175.52.61,217.175.52.62,217.175.54.59,217.175.54.60,217.175.54.61,217.175.54.62";
	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {

		log.debug("SEARCH PRE-ACTION START");
		HttpServletRequest request = lifecycleEvent.getRequest();
		long companyId = PortalUtil.getCompanyId(request);
//		try {
//			companyId = PortalUtil.getCompany(request).getCompanyId();
//		} catch (PortalException e1) {
//			log.error(e1);
//		}
		long socialCollabLong = GetterUtil.getLong(PropsUtil.get("id.company.social.collaboration"));
		if (companyId != socialCollabLong) {

			Map<String, Object> ftlVariables = (Map<String, Object>) request.getAttribute(WebKeys.FTL_VARIABLES);
			if (ftlVariables == null) {
				ftlVariables = new HashMap<>();
			}
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			if (themeDisplay != null) {
				try {
					populateSiteUrls(ftlVariables,themeDisplay, request);
				} catch (SystemException e) {
					log.fatal("Something went wrong on freemarker injection...", e);
				}
			}
			boolean internalIP = false;
			String ip = request.getRemoteAddr(); //ip client
			ftlVariables.put("ip", ip);
			String gaAnalyticsKey = PropsUtil.get("ga.analytics.key");
			ftlVariables.put("gaAnalitycsKey", gaAnalyticsKey);
			User user = (User) request.getAttribute(WebKeys.USER);
			String listaIPs = (String)ftlVariables.get("internalIPs");
			String[] ips =listaIPs.split(",");
			ArrayList<String> internalIps = new ArrayList<String>(Arrays.asList(ips));
			for (String currentIp : internalIps) {
				if (ip.startsWith(currentIp)) {
					internalIP = true;
					break;
				}
			}
			if (user != null && !user.isDefaultUser()) {
				JSONObject info;
				int socialNotificationCount = 0;
				try {
					User secondaryUser = _userLocalService.fetchUserByScreenName(socialCollabLong, user.getScreenName());
					if (Validator.isNotNull(secondaryUser)) {
						long secondaryUserId = secondaryUser.getUserId();
						socialNotificationCount = UserNotificationEventLocalServiceUtil.getUserNotificationEventsCount(secondaryUserId,
						UserNotificationDeliveryConstants.TYPE_WEBSITE);
					}
					ftlVariables.put("socialNotificationCount", socialNotificationCount);
					ftlVariables.put("userInterno", internalIP);
				} catch (Exception e) {
					log.error("error in network ip verification", e);
				}
				try {
					info = UserInfoUtil.getUserInfo(user);
					Iterator<String> allKeys = info.keys();
					while (allKeys.hasNext()) {
						String key = allKeys.next();
						String value = info.getString(key);
						ftlVariables.put(key, value);
					}
				} catch (PortalException e) {
					log.error("Error retrieving userInfo ", e);
				}
			}
			log.debug("ftlVariables: " + ftlVariables.toString());
			request.setAttribute(WebKeys.FTL_VARIABLES, ftlVariables);
		}
	}

	@Activate
	@Modified
	protected void activate(){
		portalCache.removeAll();
	}

	/**
	 * Questo metodo ha il solo scopo di attivare il componente quando il
	 * portale ha terminato la fase di inizializzazione
	 *
	 * @param moduleServiceLifecycle
	 */
	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(
		ModuleServiceLifecycle moduleServiceLifecycle) {
	}

	private void populateSiteUrls(Map<String, Object> ftlVariables,ThemeDisplay themeDisplay, HttpServletRequest request) {
		try {
			/*
			 *Implemenatata gestione portal cache
			 ************* TIMETOLIVE 10min ***************
			*/
			String keyPortalCache = URL_MAP+"_"+themeDisplay.getLayoutSet().getLayoutSetId();
			SiteUrls urlMap = portalCache.get(keyPortalCache);
			String auth = AuthTokenUtil.getToken(request);
			ftlVariables.put("s_authToken", auth);
			//			String searchPageURL = urlMap.get(SEARCH_PAGE_URL);
			//			String applicationManagementPageURL = urlMap.get(APPLICATION_MANAGEMENT_PAGE_URL);
			//			String gestioneScrivaniePageURL = urlMap.get(GESTIONE_SCRIVANIE_PAGE_URL);
			if (Validator.isNull(urlMap)) {
				urlMap = new SiteUrls();
				
				/*
				Layout targetLayout;

				targetLayout = _getLayoutByCustomField(
					themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(),
					true, IS_SEARCH_PAGE, Boolean.TRUE.toString());

				if (targetLayout != null) {
					urlMap.setSearchPageUrl(
						_portal.getLayoutFriendlyURL(targetLayout, themeDisplay)
						+ "?p_p_id=com_liferay_portal_search_web_portlet_SearchPortlet&amp;p_p_lifecycle=0&amp;p_p_state=maximized&amp;p_p_mode=view&amp;_com_liferay_portal_search_web_portlet_SearchPortlet_mvcPath=%2Fsearch.jsp");
				}

				targetLayout = _getLayoutByCustomField(
					themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(),
					true, IS_APPLICATION_MANAGEMENT_PAGE,
					Boolean.TRUE.toString());

				if (targetLayout != null) {
					urlMap.setApplicationManagementPageUrl(
						_portal.getLayoutFriendlyURL(targetLayout, themeDisplay));
				}

				targetLayout = _getLayoutByCustomField(
					themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(),
					true, IS_GESTIONE_SCRIVANIE_PAGE, Boolean.TRUE.toString());

				if (targetLayout != null) {
					urlMap.setGestioneScrivaniePageUrl(
						_portal.getLayoutFriendlyURL(targetLayout, themeDisplay));
				}
				*/
				String internalIPsString = (String) themeDisplay.getSiteGroup().getExpandoBridge().getAttribute("internalIPs");
				if (internalIPsString!=null) {
					urlMap.setInternalIPs(internalIPsString);
				}
				List<Layout> layouts = LayoutLocalServiceUtil.getLayouts(themeDisplay.getSiteGroupId(), true);
				for (Layout l : layouts) {

					Boolean isSearchPage = (Boolean) l.getExpandoBridge().getAttribute(IS_SEARCH_PAGE, false);
					Boolean isApplicationManagementPage = (Boolean) l.getExpandoBridge().getAttribute(IS_APPLICATION_MANAGEMENT_PAGE,
					false);
					Boolean isGestioneScrivaniePage = (Boolean) l.getExpandoBridge().getAttribute(IS_GESTIONE_SCRIVANIE_PAGE, false);

					if (isSearchPage != null && isSearchPage) {
						urlMap.setSearchPageUrl(PortalUtil.getLayoutFriendlyURL(l, themeDisplay)
						+ "?p_p_id=com_liferay_portal_search_web_portlet_SearchPortlet&amp;p_p_lifecycle=0&amp;p_p_state=maximized&amp;p_p_mode=view&amp;_com_liferay_portal_search_web_portlet_SearchPortlet_mvcPath=%2Fsearch.jsp");
					}
					if (isApplicationManagementPage != null && isApplicationManagementPage) {
						urlMap.setApplicationManagementPageUrl(PortalUtil.getLayoutFriendlyURL(l, themeDisplay));
					}
					if (isGestioneScrivaniePage != null && isGestioneScrivaniePage) {
						urlMap.setGestioneScrivaniePageUrl(PortalUtil.getLayoutFriendlyURL(l, themeDisplay));
					}
				}
				

				portalCache.put(keyPortalCache, urlMap);
			}
//			urlMap = portalCache.get(URL_MAP);
			ftlVariables.put("searchPageURL", urlMap.getSearchPageUrl());
			ftlVariables.put("applicationManagementPage", urlMap.getApplicationManagementPageUrl());
			ftlVariables.put("gestioneScrivaniePage", urlMap.getGestioneScrivaniePageUrl());
			ftlVariables.put("internalIPs", urlMap.getInternalIPs());
		} catch (Exception e) {
			log.debug("Something went wrong on layout retriving...", e);
		}
	}
/*
	private Layout _getLayoutByCustomField(
			long companyId, long groupId, boolean privateLayout,
			String fieldName, String fieldValue)
		throws PortalException {

		List<ExpandoValue> values = _expandoValueLocalService.getColumnValues(
			companyId, Layout.class.getName(),
			ExpandoTableConstants.DEFAULT_TABLE_NAME, fieldName, fieldValue,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (ExpandoValue value : values) {
			Layout layout = _layoutLocalService.getLayout(value.getClassPK());

			if (layout.getGroupId() == groupId &&
					layout.getPrivateLayout() == privateLayout) {

				return layout;
			}
		}

		return null;
	}

	@Reference(policyOption = ReferencePolicyOption.GREEDY)
	private ExpandoValueLocalService _expandoValueLocalService;

	@Reference(policyOption = ReferencePolicyOption.GREEDY)
	private LayoutLocalService _layoutLocalService;

	@Reference(policyOption = ReferencePolicyOption.GREEDY)
	private Portal _portal;
*/
	@Reference(policyOption = ReferencePolicyOption.GREEDY)
	private UserLocalService _userLocalService;

	private static PortalCache<String, SiteUrls> portalCache = MultiVMPoolUtil.getPortalCache(SearchPreAction.class.getName());
}
