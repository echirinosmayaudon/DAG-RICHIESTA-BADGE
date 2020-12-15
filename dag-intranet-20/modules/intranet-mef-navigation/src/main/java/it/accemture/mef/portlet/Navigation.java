package it.accemture.mef.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

@Component(
		configurationPid = "it.accemture.mef.portlet.Navigation",
		immediate = true, 
		property = {
		"com.liferay.portlet.display-category=Mef-Portlet",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.name=it_accemture_mef_portlet_Navigation",
		"javax.portlet.display-name=Intranet Mef Navigation",	
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user,guest",
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.css-class-wrapper=sample-system-settings-portlet",
		"com.liferay.portlet.use-default-template=true",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.supports.mime-type=text/html"
		},
		service = Portlet.class)

public class Navigation  extends MVCPortlet  {

}
