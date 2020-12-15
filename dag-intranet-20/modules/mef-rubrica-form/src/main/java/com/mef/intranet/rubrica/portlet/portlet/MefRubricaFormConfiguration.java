package com.mef.intranet.rubrica.portlet.portlet;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
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

@Component(configurationPid = "com.mef.intranet.rubrica.portlet.portlet.MefRubricaFormConfig", configurationPolicy = ConfigurationPolicy.IGNORE, immediate = true, property = {
"javax.portlet.name=com_mef_intranet_rubrica_portlet_portlet_MefRubricaFormmvcportletPortlet" }, service = ConfigurationAction.class)
public class MefRubricaFormConfiguration extends DefaultConfigurationAction {
	final Log _log = LogFactoryUtil.getLog(MefRubricaFormConfiguration.class);
	private volatile MefRubricaFormConfig _configuration;
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		String itemsPerPage = ParamUtil.getString(actionRequest, "itemsPerPage");
		String lastResearch = ParamUtil.getString(actionRequest, "lastResearch");
		setPreference(actionRequest, "itemsPerPage", itemsPerPage);
		setPreference(actionRequest, "lastResearch", lastResearch);
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	
	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
				
		httpServletRequest.setAttribute(MefRubricaFormConfig.class.getName(), _configuration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(MefRubricaFormConfig.class, properties);
	}
	
	
}
