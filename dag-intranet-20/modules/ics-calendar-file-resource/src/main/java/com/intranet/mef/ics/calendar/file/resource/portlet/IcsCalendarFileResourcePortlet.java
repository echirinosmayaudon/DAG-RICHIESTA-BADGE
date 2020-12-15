package com.intranet.mef.ics.calendar.file.resource.portlet;

import com.intranet.mef.ics.calendar.file.resource.constants.IcsCalendarFileResourcePortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author daniele.zirpoli
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Mef-Portlet",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ics-calendar-file-resource Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + IcsCalendarFileResourcePortletKeys.CALENDARFILERESOURCE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class IcsCalendarFileResourcePortlet extends MVCPortlet {
	
}