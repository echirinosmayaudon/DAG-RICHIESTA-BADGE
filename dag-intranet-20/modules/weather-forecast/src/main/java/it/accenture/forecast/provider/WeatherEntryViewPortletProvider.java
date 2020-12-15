package it.accenture.forecast.provider;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.portlet.ViewPortletProvider;

import it.accenture.forecast.portlet.WeatherPortletKeys;


@Component(
	    immediate = true,
	    property = {"model.class.name=it.accenture.forecast.provider.WeatherEntryViewPortletProvider"},
	    service = WeatherEntryViewPortletProvider.class
	)
public class WeatherEntryViewPortletProvider extends BasePortletProvider implements ViewPortletProvider {
 
	@Override
	public String getPortletName() {
		return WeatherPortletKeys.WEATHER;
	}
}
