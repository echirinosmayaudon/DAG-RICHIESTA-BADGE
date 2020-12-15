package com.cacheportlet.mef.messaging;

import com.cacheportlet.mef.constants.CachePorletConstants;
import com.cacheportlet.mef.exception.NoSuchCachePortletException;
import com.cacheportlet.mef.model.CachePortlet;
import com.cacheportlet.mef.service.CachePortletLocalService;
import com.cacheportlet.mef.service.configuration.CachePortletConfigurationValues;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.BaseSchedulerEntryMessageListener;
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
import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;
import com.liferay.portal.kernel.scheduler.messaging.SchedulerResponse;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicyOption;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import aQute.bnd.annotation.metatype.Configurable;

/**
 * @author Roberto Sangiovanni
 */

@Component(
		configurationPid = RadiocorMessageListenerConfigurator.PID,
		immediate = true,
		service = {
				RadiocorMessageListener.class,
				MessageListener.class
		}
		)
public class RadiocorMessageListener
extends BaseMessageListener {

	public static final String GROUP_NAME = "Get Radiocor News";


	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = Configurable.createConfigurable(
				RadiocorMessageListenerConfigurator.class,
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
			_log.info("Start Radiocor Import News ");
		}

		try {
			_getRadiocorNews();

		}
		catch(PortalException pe) {
			_log.error(pe);
		}
		if (_log.isInfoEnabled()) {
			_log.info("End Radiocor Import News ");
		}
	}

	private void _getRadiocorNews() throws PortalException {
		Date date = new Date();
		Timestamp timeStamp = new Timestamp(date.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

		JSONArray json = JSONFactoryUtil.createJSONArray();
		JSch jsch = new JSch();

		ChannelSftp.LsEntry[] listaFiles;
		ChannelSftp channelSftp = null;
		Session session = null;

		try{
			session = jsch.getSession(USER,HOST,PORT);
			session.setPassword(PWD);
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			_log.debug("before connect");
			session.connect();
			_log.debug("connect");
			Channel channel = session.openChannel("sftp");
			channelSftp = (ChannelSftp) channel;
			channelSftp.connect();
		}catch(JSchException jse){
			_log.error(jse);
		}

		_log.debug("connect to channel");
		ArrayList<ChannelSftp.LsEntry> list = new ArrayList<ChannelSftp.LsEntry>();
		try{
			channelSftp.cd(DIR);
			list = new ArrayList<ChannelSftp.LsEntry>(channelSftp.ls("*.xml"));
		}catch(SftpException se){
			_log.error(se);
		}
		listaFiles = new ChannelSftp.LsEntry[list.size()];
		_log.debug("Radiocor news list Size "+list.size());
		list.toArray(listaFiles);


		Arrays.sort(listaFiles, new Comparator<ChannelSftp.LsEntry>(){
			public int compare(ChannelSftp.LsEntry f1, ChannelSftp.LsEntry f2)
			{
				int value = Integer.valueOf(f1.getAttrs().getMTime()).compareTo(f2.getAttrs().getMTime());
				if (value > 0) {
					value = -1;
				}else if (value < 0){
					value = 1;
				}
				return value;
			} });


		int count = 0;
		for (ChannelSftp.LsEntry fileLs : listaFiles) {
			_log.debug(count+1+")-----------------------------------");
			_log.debug("Filename: "+fileLs.getFilename());
			JSONObject entry = JSONFactoryUtil.createJSONObject();
			InputStream fileInputStream = null;
			try {
				fileInputStream = channelSftp.get(fileLs.getFilename());
			} catch (SftpException se) {
				// TODO Auto-generated catch block
				_log.error(se);
			}
			File fileEntry = null;
			try {
				fileEntry = createFileFromInputStream(fileInputStream);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				_log.error(e1);
			}

			Document doc = null;
			try {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				doc = dBuilder.parse(fileEntry);
				doc.getDocumentElement().normalize();
				NodeList listHeadline = doc.getElementsByTagName("HeadLine");
				Element headline = (Element) listHeadline.item(0);
				String headlineText = headline.getTextContent();

				_log.debug("HeadLine: "+headlineText);
				entry.put("headline", headlineText);
				NodeList listDateLabel = doc.getElementsByTagName("DateLabel");
				Element dateLabel = (Element) listDateLabel.item(0);
				String dateLabelText = dateLabel.getTextContent();
				_log.debug("dateLabelText: "+dateLabelText);
				String ora;
				ora = dateLabelText.split(" ")[1];
				String [] orainfo = ora.split(":");
				ora = orainfo[0]+":"+orainfo[1];
				entry.put("dateTime", ora);
				NodeList listTopic = doc.getElementsByTagName("Topic");
				int topicsSize = listTopic.getLength();
				String topicText = "";
				for (int c=0; c<topicsSize; c++){
					Element topic = (Element) listTopic.item(c);
					if ("tp_3".equals(topic.getAttribute("Duid"))){
						topicText = topic.getElementsByTagName("FormalName").item(0).getTextContent();
						topicText = topicText.replaceAll("_", " ");
					}	    			
				}       	

				_log.debug("topicText: "+topicText);

				entry.put("topic", topicText);

				json.put(entry);
				count++;
				if (count == _configuration.getFilesNumber()) break;
			} catch (Exception e) {
				_log.error(e);
			}


		}

		_log.debug("radiocor json: "+json.toJSONString());

		session.disconnect();
		channelSftp.exit();

		//Settings settings = SettingsFactoryUtil.getSettings(new CompanyServiceSettingsLocator(CompanyLocalServiceUtil.getCompanyByWebId("liferay.com").getCompanyId(),"filesNumber"));
		CachePortlet cacheRadiocor = null;
		try {
			cacheRadiocor = _cachePortletLocalService.getCachePortlet(CachePorletConstants.RADIOCOR_PORTLET_NAME);
		} catch (NoSuchCachePortletException e) {
			// TODO Auto-generated catch block
			_log.error("No such CachePorlet exist with name "+CachePorletConstants.RADIOCOR_PORTLET_NAME+". The record will now be created"+e);
			cacheRadiocor = _cachePortletLocalService.createCachePortlet(CachePorletConstants.RADIOCOR_PORTLET_NAME);
		}
		cacheRadiocor.setJsonData(json.toJSONString());

		cacheRadiocor.setTimestamp(""+sdf.format(timeStamp));
		_cachePortletLocalService.updateCachePortlet(cacheRadiocor);
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

	private volatile RadiocorMessageListenerConfigurator
	_configuration;

	@Reference(
			policyOption = ReferencePolicyOption.GREEDY,
			target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-"
			)
	private ModuleServiceLifecycle _moduleServiceLifecycle;

	@Reference(policyOption = ReferencePolicyOption.GREEDY, unbind = "-")
	private SchedulerEngineHelper _schedulerEngineHelper;


	private File createFileFromInputStream (InputStream fileInputStream ) throws IOException{

		OutputStream outputStream = null;
		File tempFile = new File(TEMP_PATH + "temp");
		try {			

			// write the inputStream to a FileOutputStream
			outputStream = new FileOutputStream(tempFile);

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = fileInputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}

		} catch (IOException e) {
			_log.error(e);
		} finally {
			if (fileInputStream != null) {

				fileInputStream.close();

			}
			if (outputStream != null) {

				outputStream.close();


			}
		}
		return tempFile;
	}
	private final String PWD = CachePortletConfigurationValues.SFTP_RADIOCOR_PWD;
	private final String USER = CachePortletConfigurationValues.SFTP_RADIOCOR_USER;
	private final String HOST = CachePortletConfigurationValues.SFTP_RADIOCOR_HOST;
	private final String DIR = CachePortletConfigurationValues.SFTP_RADIOCOR_DIR;
	private final int PORT = CachePortletConfigurationValues.SFTP_RADIOCOR_PORT;
	private static final String TEMP_PATH = CachePortletConfigurationValues.FILE_CREATION_TEMP_PATH;

	private static final Log _log = LogFactoryUtil.getLog(RadiocorMessageListener.class);

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