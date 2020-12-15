package com.cacheportlet.mef.messaging;

import com.cacheportlet.mef.constants.CachePorletConstants;
import com.cacheportlet.mef.exception.NoSuchCachePortletException;
import com.cacheportlet.mef.model.CachePortlet;
import com.cacheportlet.mef.service.CachePortletLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntry;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.StorageTypeAware;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.scheduler.messaging.SchedulerResponse;
import com.liferay.portal.kernel.util.Validator;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicyOption;


import aQute.bnd.annotation.metatype.Configurable;

/**
 * @author Roberto Sangiovanni
 */

@Component(
		configurationPid = TwitterMessageListenerConfigurator.PID,
		immediate = true,
		service = {
				TwitterMessageListener.class,
				MessageListener.class
		}
		)
public class TwitterMessageListener extends BaseMessageListener {

	public static final String GROUP_NAME = "Get Tweets";
	
	  @Deactivate
      protected void deactivate() {
            
            // if we previously were initialized
          if (_initialized) {
            // unschedule the job so it is cleaned up
        	  Class<?> clazz = getClass();

              String className = clazz.getName();

            _removeScheduledJob(className, getStorageType(schedulerEntry));
            // unregister this listener
            _schedulerEngineHelper.unregister(this);
          }
          
          // clear the initialized flag
          _initialized = false;
            
      }

	@Override
	protected void doReceive(Message message) throws Exception {
		if (_log.isInfoEnabled()) {
			_log.info("Start Import Tweets");
		}

		try {
			_getTweets();

		}
		catch(PortalException pe) {
			_log.error(pe);
		}
		if (_log.isInfoEnabled()) {
			_log.info("End Import Tweets");
		}
	}

	private void _getTweets() throws PortalException {
		Date date = new Date();
		Timestamp timeStamp = new Timestamp(date.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		String jsonString = callURL(_configuration.getUrlTwitter(),"",80,"","");
		CachePortlet cacheRadiocor = null;
		try {
			cacheRadiocor = _cachePortletLocalService.getCachePortlet(CachePorletConstants.TWITTER_PORTLET_NAME);
		} catch (NoSuchCachePortletException e) {
			_log.error("No such CachePorlet exist with name "+CachePorletConstants.TWITTER_PORTLET_NAME+". The record will now be created"+e);
			cacheRadiocor = _cachePortletLocalService.createCachePortlet(CachePorletConstants.TWITTER_PORTLET_NAME);
		}
		
		if(jsonString!=null && !"null".equals(jsonString) && !jsonString.isEmpty()){
			cacheRadiocor.setJsonData(jsonString);
			cacheRadiocor.setTimestamp(""+sdf.format(timeStamp));
			_cachePortletLocalService.updateCachePortlet(cacheRadiocor);
		}
	}
	
	private String callURL(
			final String urlParam,
			final String proxyHost,
			int proxyPort,
			final String proxyUsername,
			final String proxyPassword) {

		_log.debug("Init request to: " + urlParam);

		int timeout = 1 * 1000;

		Properties systemProperties = System.getProperties();
		if (Validator.isNotNull(proxyHost))
			systemProperties.setProperty("http.proxyHost", proxyHost);
		if (Validator.isNotNull(proxyPort))
			systemProperties.setProperty("http.proxyPort", String.valueOf(proxyPort));
		if (Validator.isNotNull(proxyUsername))
			systemProperties.setProperty("http.proxyUser", proxyUsername);
		if (Validator.isNotNull(proxyPassword))
			systemProperties.setProperty("http.proxyPassword", proxyPassword);

		StringBuilder sb = new StringBuilder();
		URLConnection urlConn;
		InputStreamReader in;
		try {
			URL url = new URL(urlParam);
			urlConn = url.openConnection();
			urlConn.setConnectTimeout(timeout);
			urlConn.setReadTimeout(timeout);

			in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
			BufferedReader bufferedReader = new BufferedReader(in);
			int cp;
			while ((cp = bufferedReader.read()) != -1) {
				sb.append((char) cp);
			}

			bufferedReader.close();
			in.close();
		} catch (SocketTimeoutException e) {
			_log.error(e);
			_log.warn("Call in TIMEOUT" + timeout  + "millsec elapsed.");
		}catch (IOException e) {
			_log.error(e);
			//e.printStackTrace();
		}

		return sb.toString();
	}
	
	
    private void _removeScheduledJob(String jobName, StorageType storageType) {
        try {
              SchedulerResponse response = _schedulerEngineHelper.getScheduledJob(jobName, GROUP_NAME, storageType);

              if (response != null) {
                    if (_log.isInfoEnabled()) {
                          _log.info("unschedule and unregister");
                    }

                    _schedulerEngineHelper.unschedule(jobName, GROUP_NAME, storageType);

                    _schedulerEngineHelper.delete(jobName, GROUP_NAME, storageType);
              }
        } catch (Exception e) {
              if (_log.isWarnEnabled()) {
                    _log.warn(e, e);
              }
        }
  }
	
	  protected StorageType getStorageType(SchedulerEntry schedulerEntry) {
          if (schedulerEntry instanceof StorageTypeAware) {
            return ((StorageTypeAware) schedulerEntry).getStorageType();
          }
          
          return StorageType.MEMORY_CLUSTERED;
        }
	
	
	private String _getConfiguredCronExpression() {
		return _configuration.getCronExpression();
	}
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = Configurable.createConfigurable(
				TwitterMessageListenerConfigurator.class,
				properties);

		if (_log.isInfoEnabled()) {
			_log.info("Cron Expression: " + _getConfiguredCronExpression());
		}

		
		 Class<?> clazz = getClass();

         String className = clazz.getName();

         Trigger trigger = _triggerFactory.createTrigger(
                        className, GROUP_NAME, null, null, _getConfiguredCronExpression());
		
		
         SchedulerEntry schedulerEntry = new SchedulerEntryImpl(
                 className, trigger);
         
         this.schedulerEntry= schedulerEntry;
		
         if (_initialized) {
		      // first deactivate the current job before we schedule.
		      deactivate();
		    }

		_schedulerEngineHelper.register(
				this, schedulerEntry, DestinationNames.SCHEDULER_DISPATCH);
	
	
		 // set the initialized flag.
  	    _initialized = true;
	
	}
	private volatile TwitterMessageListenerConfigurator
	_configuration;

	@Reference(
			policyOption = ReferencePolicyOption.GREEDY,
			target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-"
			)
	private ModuleServiceLifecycle _moduleServiceLifecycle;

	@Reference(policyOption = ReferencePolicyOption.GREEDY, unbind = "-")
	private SchedulerEngineHelper _schedulerEngineHelper;


	private static final Log _log = LogFactoryUtil.getLog(TwitterMessageListener.class);

	@Reference
	private CachePortletLocalService _cachePortletLocalService;
	
	@Reference(unbind = "-")
	  protected void setTriggerFactory(TriggerFactory triggerFactory) {
	    _triggerFactory = triggerFactory;
	  }
	
	 private TriggerFactory _triggerFactory;
	 private volatile boolean _initialized;
	   
	 private SchedulerEntry schedulerEntry;

}