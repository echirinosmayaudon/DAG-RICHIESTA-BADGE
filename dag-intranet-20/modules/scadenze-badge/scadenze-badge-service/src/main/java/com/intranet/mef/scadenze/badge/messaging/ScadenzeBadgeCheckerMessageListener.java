package com.intranet.mef.scadenze.badge.messaging;



import com.intranet.mef.scadenze.badge.costants.ScadenzeBadgeDestinationNames;
import com.intranet.mef.scadenze.badge.messaging.ScadenzeBadgeCheckerMessageListenerConfiguration;
import com.intranet.mef.scadenze.badge.service.ScadenzeBadgeHelperLocalService;
import com.intranet.mef.scadenze.badge.service.util.ScadenzeBadgeUtil;
import com.liferay.petra.mail.MailEngineException;
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

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicyOption;

import aQute.bnd.annotation.metatype.Configurable;






@Component(
		configurationPid = ScadenzeBadgeCheckerMessageListenerConfiguration.PID,
		immediate = true,
		property = {
			"destination.name=" + ScadenzeBadgeDestinationNames.SCADENZE_BADGE
		},
		service = {
			ScadenzeBadgeCheckerMessageListener.class,
			MessageListener.class
		}
	)
public class ScadenzeBadgeCheckerMessageListener extends BaseMessageListener{

	public static final String GROUP_NAME = "Scadenze Badge Entry";
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = Configurable.createConfigurable(
				ScadenzeBadgeCheckerMessageListenerConfiguration.class,
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
			_log.info("Start send email checker...");
		}

		_activateScadenze();
		
		_log.info("End send email checker...");

	}
	
	
	
	
	private void _activateScadenze() {
		//here the code
		try {
			ScadenzeBadgeUtil.prepareMaiForMantainers();
		} catch (UnsupportedEncodingException e) {
			_log.info(e);
			
		} catch (MailEngineException e) {
			_log.info(e);
			
		}
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

	private volatile ScadenzeBadgeCheckerMessageListenerConfiguration
		_configuration;

	@Reference(
		policyOption = ReferencePolicyOption.GREEDY,
		target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-"
	)
	private ModuleServiceLifecycle _moduleServiceLifecycle;

	@Reference(policyOption = ReferencePolicyOption.GREEDY, unbind = "-")
	private SchedulerEngineHelper _schedulerEngineHelper;

	@Reference(policyOption = ReferencePolicyOption.GREEDY, unbind = "-")
	private ScadenzeBadgeHelperLocalService _scadenzeBadgeHelperLocalService;

	private static final Log _log = LogFactoryUtil.getLog(
		ScadenzeBadgeCheckerMessageListener.class);
	
	@Reference(unbind = "-")
	  protected void setTriggerFactory(TriggerFactory triggerFactory) {
	    _triggerFactory = triggerFactory;
	  }
	
	 private TriggerFactory _triggerFactory;
	 private volatile boolean _initialized;
	   
	 private SchedulerEntry schedulerEntry;

}
