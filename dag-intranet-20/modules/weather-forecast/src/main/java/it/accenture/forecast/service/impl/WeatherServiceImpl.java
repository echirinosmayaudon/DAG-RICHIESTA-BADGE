package it.accenture.forecast.service.impl;

import com.cacheportlet.mef.model.CachePortlet;
import com.cacheportlet.mef.service.CachePortletLocalServiceUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.service.component.annotations.Component;

import it.accenture.forecast.model.DarkSky;
import it.accenture.forecast.portlet.WeatherPortletKeys;
import it.accenture.forecast.service.api.WeatherService;

@Component(
		immediate = true,
		service = WeatherService.class
		)
public class WeatherServiceImpl implements WeatherService {

	@Override
	public DarkSky getData(String portletInstance, String darkSkyAPIKey, long secondsBetweenRequests, double latitud, double longitude, String proxyHost, int proxyPort, String proxyUsername, String proxyPassword) {
		
		ObjectMapper mapper = new ObjectMapper();
		DarkSky darkSky = new DarkSky();
		try {
			CachePortlet cacheWeather = CachePortletLocalServiceUtil.getCachePortlet(WeatherPortletKeys.WEATHER);
			darkSky = mapper.readValue(cacheWeather.getJsonData(), DarkSky.class);
		}catch (Exception e){
			_log.error("Nessun json presente nella CachePortlet " +e);
			darkSky = null;
		}
		return darkSky;
	}

	private static Log _log = LogFactoryUtil.getLog(WeatherServiceImpl.class.getName());
}
