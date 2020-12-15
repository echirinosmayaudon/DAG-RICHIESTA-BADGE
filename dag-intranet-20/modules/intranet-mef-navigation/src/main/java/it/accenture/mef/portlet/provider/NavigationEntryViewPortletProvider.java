package it.accenture.mef.portlet.provider;


import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.portlet.ViewPortletProvider;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    property = {"model.class.name=it.accenture.mef.portlet.provider.NavigationEntryViewPortletProvider"},
	    service = ViewPortletProvider.class
	)
public class NavigationEntryViewPortletProvider extends BasePortletProvider implements ViewPortletProvider {
 
	@Override
	public String getPortletName() {
		return "it_accenture_mef_portlet_Navigation";
	}
}