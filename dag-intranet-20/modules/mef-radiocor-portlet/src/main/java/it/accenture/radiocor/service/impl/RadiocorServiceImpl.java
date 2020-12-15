package it.accenture.radiocor.service.impl;

import com.cacheportlet.mef.model.CachePortlet;
import com.cacheportlet.mef.service.CachePortletLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.service.component.annotations.Component;

import it.accenture.radiocor.model.JsonRadiocor;
import it.accenture.radiocor.service.api.RadiocorService;
import mef.radiocor.form.constants.MefRadiocorFormPortletKeys;

@Component(
		immediate = true,
		service = RadiocorService.class
		)
public class RadiocorServiceImpl implements RadiocorService {

	@Override
	public JsonRadiocor getData(String portletInstance, int numeroNews) {
		
		
		JsonRadiocor jsonRadiocor = new JsonRadiocor();
		try {
			CachePortlet cacheRadiocor = CachePortletLocalServiceUtil.getCachePortlet(MefRadiocorFormPortletKeys.MefRadiocorForm);
			jsonRadiocor.setJsonArray(JSONFactoryUtil.createJSONArray(cacheRadiocor.getJsonData()));
			
		}catch (PortalException e){
			_log.error("Nessun json presente nella CachePortlet "+e);
			try {
				jsonRadiocor.setJsonArray(JSONFactoryUtil.createJSONArray("[]"));
				
			} catch (JSONException e1) {
				_log.error("Errore nella creazione del json delle news di Radiocor "+e1);
			}
		}		
		return jsonRadiocor;
		
	}

	private static Log _log = LogFactoryUtil.getLog(RadiocorServiceImpl.class.getName());
}
