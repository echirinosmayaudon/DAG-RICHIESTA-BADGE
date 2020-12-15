package com.intranet.mef.user.profile.view.provider;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.portlet.ViewPortletProvider;

@Component(
	    immediate = true,
	    property = {"model.class.name=com.intranet.mef.user.profile.view.provider.MyProfileViewPortletProvider"},
	    service = ViewPortletProvider.class
	)
public class MyProfileViewPortletProvider extends BasePortletProvider implements ViewPortletProvider {
 
	@Override
	public String getPortletName() {
		return "com_intranet_mef_user_profile_portlet_ProfilePortlet";
	}
}
