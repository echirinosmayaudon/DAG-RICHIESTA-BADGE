package modulistica.mef.portlet;

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

@Component(configurationPid = "modulistica.mef.portlet.ModulisticaMefConfig", configurationPolicy = ConfigurationPolicy.IGNORE, immediate = true, property = {
	"javax.portlet.name=modulistica_mef_portlet_ModulisticaMefPortlet" }, service = ConfigurationAction.class)
public class ModulisticaMefConfiguration extends DefaultConfigurationAction {
	final Log _log = LogFactoryUtil.getLog(ModulisticaMefConfiguration.class);
	private volatile ModulisticaMefConfig _configuration;
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		String itemsPerPage = ParamUtil.getString(actionRequest, "itemsPerPage");
		String viewTheme = ParamUtil.getString(actionRequest, "viewTheme");
		String days = ParamUtil.getString(actionRequest, "days");
		String modulisticaPage = ParamUtil.getString(actionRequest, "modulisticaPage");
		String folder = ParamUtil.getString(actionRequest, "folder");
		setPreference(actionRequest, "folder", folder);
		setPreference(actionRequest, "itemsPerPage", itemsPerPage);
		setPreference(actionRequest, "modulisticaPage", modulisticaPage);
		setPreference(actionRequest, "viewTheme", viewTheme);
		setPreference(actionRequest, "days", days);
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	
	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
	throws Exception {
		ThemeDisplay td = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (DLFolderLocalServiceUtil.getDLFoldersCount() > 0) {
			List<DLFolder> folders = DLFolderLocalServiceUtil.getCompanyFolders(td.getCompanyId(),QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			httpServletRequest.setAttribute("folders", folders);
		} else {
			_log.info("error there are no folder");
		}
		
		List<String[]> privateLayoutList = getLayoutList(td.getSiteGroupId(), true, httpServletRequest.getLocale());
		httpServletRequest.setAttribute("privateLayoutList", privateLayoutList);
		httpServletRequest.setAttribute(ModulisticaMefConfig.class.getName(), _configuration);
		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(ModulisticaMefConfig.class, properties);
	}
	
	public List<String[]> getLayoutList(long groupId, boolean isPrivate, Locale locale) throws SystemException {
		List<String[]> layoutList = new ArrayList<>();
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
		List<String[]> layoutList = new ArrayList<>();
		StringBuilder depthStr = new StringBuilder();
		int depthLayoutData = depth;
		for (int i = 0; i < depth; i++)
			depthStr.append("- ");
		for (Layout l : layout.getChildren()) {
			String[] lData = new String[] { depthStr + " " + l.getName(locale), "" + l.getLayoutId() };
			layoutList.add(lData);
			layoutList.addAll(_getChildrenLayoutData(locale, l,depthLayoutData++));
		}
		return layoutList;
	}
	
	
}