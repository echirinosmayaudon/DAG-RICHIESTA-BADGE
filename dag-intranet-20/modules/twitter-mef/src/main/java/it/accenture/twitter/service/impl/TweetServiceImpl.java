package it.accenture.twitter.service.impl;

import com.cacheportlet.mef.model.CachePortlet;
import com.cacheportlet.mef.service.CachePortletLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.service.component.annotations.Component;

import it.accenture.twitter.model.JsonTweet;
import it.accenture.twitter.portlet.TweetPortletKeys;
import it.accenture.twitter.service.api.TweetService;

@Component(
		immediate = true,
		service = TweetService.class
		)
public class TweetServiceImpl implements TweetService {

	@Override
	public JsonTweet getData() {
		JsonTweet jsonTweet = new JsonTweet();
		try {
			CachePortlet cacheTweet = CachePortletLocalServiceUtil.getCachePortlet(TweetPortletKeys.Tweet);
			jsonTweet.setJsonArray(JSONFactoryUtil.createJSONArray(cacheTweet.getJsonData()));
			
		}catch (PortalException e){
			_log.error("Nessun json presente nella CachePortlet " +e);
			try {
				jsonTweet.setJsonArray(JSONFactoryUtil.createJSONArray("[]"));
			
			} catch (JSONException e1) {
				_log.error("Errore nella creazione del json dei Tweets "+e1);
			}


			
		}		
		return jsonTweet;
	}
		private static Log _log = LogFactoryUtil.getLog(TweetServiceImpl.class.getName());
	}
