package com.intranet.mef.importusers.messaging;


import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicyOption;

import com.intranet.mef.importusers.costants.ImportUsersDestinationNames;
import com.intranet.mef.importusers.service.ImportUsersHelperLocalService;
import com.intranet.mef.importusers.service.configuration.ImportUsersConfigurationValues;
import com.intranet.mef.importusers.service.util.ImportUserUtil;
import com.intranet.mef.importusers.service.util.MailUtil;
import com.intranet.mef.job.siap.service.UserFrontierBindLocalServiceUtil;
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

import aQute.bnd.annotation.metatype.Configurable;

/**
* @author Domenico Costa
*/

@Component(
      configurationPid = ImportUsersCheckerMessageListenerConfiguration.PID,
      immediate = true,
      property = {
            "destination.name=" + ImportUsersDestinationNames.IMPORT_USER
      },
      service = {
            ImportUsersCheckerMessageListener.class,
            MessageListener.class
      }
)
public class ImportUsersCheckerMessageListener
      extends BaseMessageListener {

      public static final String GROUP_NAME = "Import Users Entry";

      @Activate
      @Modified
      protected void activate(Map<String, Object> properties) {
            _configuration = Configurable.createConfigurable(
                        ImportUsersCheckerMessageListenerConfiguration.class,
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
            

      
                  
//                schedulerEntryImpl.setTrigger(
//                  TriggerFactoryUtil.createTrigger(getEventListenerClass(),
//                      GROUP_NAME, _getConfiguredCronExpression()));

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
                  _log.info("Start Import Users checker...");
            }

            _checkImportUsers();

      }

      private void _checkImportUsers() {

            //TEST DUMMY 
            _log.info("CALL FUNCTION DUMMY");
            String logErrorFunction = UserFrontierBindLocalServiceUtil.
                  callDummy();

            if (Boolean.valueOf(logErrorFunction)){
                  _log.info("CALL FUNCTION DUMMY RESULT: SUCCESS");
            }else{
                  _log.error("CALL FUNCTION DUMMY RESULT: ERROR");
            }

            if (ImportUsersConfigurationValues.START_IMPORT_LISTENER){
                  StringBuilder emailBody = new StringBuilder();

                  ImportUserUtil.checkImportUsers(emailBody);

                  MailUtil sendMail = new MailUtil();

                  try {
                        sendMail.sendReportEmailToImportUsers(emailBody);
                  } catch (Exception e) {
                        _log.error(e, e);
                  }

                  if (_log.isInfoEnabled()) {
                        _log.info("End Import Users checker...");
                  }
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

      private volatile ImportUsersCheckerMessageListenerConfiguration
            _configuration;

      @Reference(
            policyOption = ReferencePolicyOption.GREEDY,
            target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-"
      )
      private ModuleServiceLifecycle _moduleServiceLifecycle;

      @Reference(policyOption = ReferencePolicyOption.GREEDY, unbind = "-")
      private SchedulerEngineHelper _schedulerEngineHelper;

      @Reference(policyOption = ReferencePolicyOption.GREEDY, unbind = "-")
      private ImportUsersHelperLocalService _importUsersHelperLocalService;

      @Reference(unbind = "-")
        protected void setTriggerFactory(TriggerFactory triggerFactory) {
          _triggerFactory = triggerFactory;
        }
      
      private TriggerFactory _triggerFactory;
      
      
      private static final Log _log = LogFactoryUtil.getLog(
            ImportUsersCheckerMessageListener.class);
      
      
   private volatile boolean _initialized;
   
 private SchedulerEntry schedulerEntry;

}
