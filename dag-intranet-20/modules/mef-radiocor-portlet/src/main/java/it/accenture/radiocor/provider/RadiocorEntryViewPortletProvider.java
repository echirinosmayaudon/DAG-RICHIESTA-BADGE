package it.accenture.radiocor.provider;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.portlet.ViewPortletProvider;

import mef.radiocor.form.constants.MefRadiocorFormPortletKeys;


@Component(
	    immediate = true,
	    property = {"model.class.name=it.accenture.radiocor.provider.RadiocorEntryViewPortletProvider"},
	    service = RadiocorEntryViewPortletProvider.class
	)
public class RadiocorEntryViewPortletProvider extends BasePortletProvider implements ViewPortletProvider {
 
	@Override
	public String getPortletName() {
		return MefRadiocorFormPortletKeys.MefRadiocorForm;
	}
}
