package com.intranet.mef.app;

import com.intranet.mef.constants.JobOnDemandPanelCategoryKeys;
import com.intranet.mef.constants.JobOnDemandPortletKeys;
import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + JobOnDemandPanelCategoryKeys.CONTROL_PANEL_CATEGORY
	},
	service = PanelApp.class
)
public class JobOnDemandPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return JobOnDemandPortletKeys.JOB_ON_DEMAND;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + JobOnDemandPortletKeys.JOB_ON_DEMAND + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}