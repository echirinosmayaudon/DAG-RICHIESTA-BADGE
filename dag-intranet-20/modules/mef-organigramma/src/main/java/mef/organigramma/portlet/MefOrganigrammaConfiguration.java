package mef.organigramma.portlet;


import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;



@Component(configurationPid = "mef.organigramma.portlet.MefOrganigrammaConfig", configurationPolicy = ConfigurationPolicy.IGNORE, immediate = true, property = {
		"javax.portlet.name=mef_organigramma_portlet_MefOrganigrammaPortlet" }, service = ConfigurationAction.class)
public class MefOrganigrammaConfiguration extends DefaultConfigurationAction {

	final Log _log = LogFactoryUtil.getLog(MefOrganigrammaConfiguration.class);

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		String officeDetailUrl = ParamUtil.getString(actionRequest, "officeDetailUrl");
		
		setPreference(actionRequest, "officeDetailUrl", officeDetailUrl);
		
		super.processAction(portletConfig, actionRequest, actionResponse);

	}
	
	public List<String[]> getLayoutList(long groupId, boolean isPrivate, Locale locale) throws SystemException {
		List<String[]> layoutList = new ArrayList<String[]>();
		for (Layout l : LayoutLocalServiceUtil.getLayouts(groupId, isPrivate)) {
			if (l.isRootLayout()) {
				String[] lData = new String[] { l.getName(locale), "" + l.getLayoutId() };
				layoutList.add(lData);
				layoutList.addAll(_getChildrenLayoutData(locale, l, 1));
			}
		}
		return layoutList;
	}
	
	private List<String[]> _getChildrenLayoutData(Locale locale, Layout layout, int depth) throws SystemException {
		List<String[]> layoutList = new ArrayList<String[]>();
		StringBuilder depthStr = new StringBuilder();
		int depthLayout = depth; 
		for (int i = 0; i < depthLayout; i++)
			depthStr.append("- ");
		for (Layout l : layout.getChildren()) {
			String[] lData = new String[] {  depthStr.toString() + " " + l.getName(locale), "" + l.getLayoutId() };
			layoutList.add(lData);
			layoutList.addAll(_getChildrenLayoutData(locale, l, depthLayout++));
		}
		return layoutList;
	}
	
	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		
		if (DLFolderLocalServiceUtil.getDLFoldersCount() > 0) {
			List<DLFolder> folders = DLFolderLocalServiceUtil.getDLFolders(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			httpServletRequest.setAttribute("folders", folders);
		} else {
			_log.info("error there are no folder");
		}
		ThemeDisplay td = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		//		List<String[]> publicLayoutList = getLayoutList(td.getSiteGroupId(), false, actionRequest.getLocale());
		List<String[]> privateLayoutList = getLayoutList(td.getSiteGroupId(), true, httpServletRequest.getLocale());
		httpServletRequest.setAttribute("privateLayoutList", privateLayoutList);
		httpServletRequest.setAttribute(MefOrganigrammaConfig.class.getName(), _configuration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	
		
		
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(MefOrganigrammaConfig.class, properties);
	}

	private volatile MefOrganigrammaConfig _configuration;
	
	
}
