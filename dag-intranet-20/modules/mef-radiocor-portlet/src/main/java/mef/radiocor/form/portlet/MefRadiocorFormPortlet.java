package mef.radiocor.form.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import aQute.bnd.annotation.metatype.Configurable;
import it.accenture.radiocor.configuration.RadiocorPortletInstanceConfiguration;
import it.accenture.radiocor.model.JsonRadiocor;
import it.accenture.radiocor.service.api.RadiocorService;
import mef.radiocor.form.constants.MefRadiocorFormPortletKeys;

@Component(
	configurationPid =
		"it.accenture.radiocor.configuration.RadiocorPortletInstanceConfiguration",
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Mef-Portlet",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-javascript=/js/main.js",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=mef-radiocor-form Portlet",
		"javax.portlet.init-param.config-template=/configuration.jsp",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MefRadiocorFormPortletKeys.MefRadiocorForm,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		 "com.liferay.portlet.add-default-resource=true" 
	},
	service = Portlet.class
)
public class MefRadiocorFormPortlet extends MVCPortlet {
	
	private RadiocorService _RadiocorService;
	
	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		JsonRadiocor jsonRadiocor = new JsonRadiocor();
		RadiocorPortletInstanceConfiguration portletInstanceConfiguration = null;
		
		try {
			portletInstanceConfiguration = themeDisplay.getPortletDisplay().getPortletInstanceConfiguration(RadiocorPortletInstanceConfiguration.class);
		} catch (ConfigurationException e) {
			_log.error("Errore nel recupero della configuration",e);
			throw new PortletException(e.getMessage());
		}
		
		if(portletInstanceConfiguration != null){
			_log.debug("Numero di news richieste: " + portletInstanceConfiguration.numNewsForPage());
			jsonRadiocor = _RadiocorService.getData(
					themeDisplay.getPortletDisplay().getInstanceId()
					, portletInstanceConfiguration.numNewsForPage());
		}
		JSONArray news = jsonRadiocor.getJsonArray();
		renderRequest.setAttribute("news", news);
		include(viewTemplate, renderRequest, renderResponse);
	}
	

	public String getTitle(Map labels) {
		return (String) labels.get(_RadiocorPortletInstanceConfiguration.title());
	}


	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_RadiocorPortletInstanceConfiguration = Configurable.createConfigurable(
				RadiocorPortletInstanceConfiguration.class, properties);
	}

	private volatile RadiocorPortletInstanceConfiguration _RadiocorPortletInstanceConfiguration;

	@Reference(unbind = "-")
	protected void setRadiocorService(RadiocorService RadiocorService) {
		_RadiocorService = RadiocorService;
	}

	private static Log _log = LogFactoryUtil.getLog(MefRadiocorFormPortlet.class.getName());
	
}