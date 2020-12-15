package it.accenture.twitter.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
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
import it.accenture.twitter.configuration.TweetPortletInstanceConfiguration;
import it.accenture.twitter.model.JsonTweet;
import it.accenture.twitter.service.api.TweetService;

@Component(
	configurationPid =
				"it.accenture.twitter.configuration.TweetPortletInstanceConfiguration",
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Mef-Portlet",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-javascript=/js/main.js",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Mef Twitter Portlet",
		"javax.portlet.init-param.config-template=/html/configuration.jsp",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/view.jsp",
		"javax.portlet.name=" + TweetPortletKeys.Tweet,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.add-default-resource=true"		
		
	},
	service = Portlet.class
)
public class TweetPortlet extends MVCPortlet {

	private TweetService _TweetService;

	@Override
	public void doView(RenderRequest renderRequest,
		RenderResponse renderResponse)
	throws IOException, PortletException {
		
		JsonTweet jsonTweet = _TweetService.getData();
		renderRequest.setAttribute("jsonTweet", jsonTweet);
		include(viewTemplate, renderRequest, renderResponse);
	}


	public String getTitle(Map labels) {
		return (String) labels.get(_TweetPortletInstanceConfiguration.title());
	}


	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_TweetPortletInstanceConfiguration = Configurable.createConfigurable(
				TweetPortletInstanceConfiguration.class, properties);
	}

	private volatile TweetPortletInstanceConfiguration _TweetPortletInstanceConfiguration;

	@Reference(unbind = "-")
	protected void setTweetService(TweetService TweetService) {
		_TweetService = TweetService;
	}

	private static Log _log = LogFactoryUtil.getLog(TweetPortlet.class.getName());

}