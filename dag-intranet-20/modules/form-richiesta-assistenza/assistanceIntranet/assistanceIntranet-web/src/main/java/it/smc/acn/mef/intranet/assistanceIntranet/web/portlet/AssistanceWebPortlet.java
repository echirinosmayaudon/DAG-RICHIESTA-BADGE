package it.smc.acn.mef.intranet.assistanceIntranet.web.portlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import it.smc.acn.mef.intranet.assistanceIntranet.web.constants.AssistanceWebPortletKeys;

/**
 * @author debora
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Mef-Portlet",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Assistance Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.config-jsp=/configuration/configuration.jsp",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AssistanceWebPortletKeys.ASSISTANCE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"

	},
	service = Portlet.class
)
public class AssistanceWebPortlet extends MVCPortlet {

}