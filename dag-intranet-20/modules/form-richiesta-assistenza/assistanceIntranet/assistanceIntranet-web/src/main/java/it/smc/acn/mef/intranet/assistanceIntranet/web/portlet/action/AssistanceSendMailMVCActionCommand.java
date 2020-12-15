/**
 * Unpublished Copyright SMC TREVISO SRL. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.smc.acn.mef.intranet.assistanceIntranet.web.portlet.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;

import com.intranet.mef.assistance.model.Servizio;
import com.intranet.mef.assistance.service.AreaLocalServiceUtil;
import com.intranet.mef.assistance.service.ProblemLocalServiceUtil;
import com.intranet.mef.assistance.service.ServizioLocalServiceUtil;
import com.intranet.mef.assistance.service.TopicLocalServiceUtil;
import com.liferay.mail.kernel.model.FileAttachment;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

import it.smc.acn.mef.intranet.assistanceIntranet.web.configuration.AssistanceConfigurationKeys;
import it.smc.acn.mef.intranet.assistanceIntranet.web.configuration.AssistanceConfigurationValues;
import it.smc.acn.mef.intranet.assistanceIntranet.web.constants.AssistanceWebPortletKeys;

/**
 * @author Debora Giovannoli
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + AssistanceWebPortletKeys.ASSISTANCE,
		"mvc.command.name=/assistance/sendMail"
	},
	service = MVCActionCommand.class
)


public class AssistanceSendMailMVCActionCommand extends BaseMVCActionCommand {
	private static final String TEMP_PATH = "/wos1/java/products/liferay/tmp/"; 
	private final static String baseDir = "/richieste/assistenza";
	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String service = ParamUtil.getString(actionRequest, "service");
		String area = ParamUtil.getString(actionRequest, "area");
		String topic = ParamUtil.getString(actionRequest, "topic");
		String problem = ParamUtil.getString(actionRequest, "problem");
		String description = ParamUtil.getString(actionRequest, "description");
		
		Servizio serviceObject = ServizioLocalServiceUtil.getServizio(service);

		String areaDesc = AreaLocalServiceUtil.findAreaNameByPK(area);

		String topicDesc = TopicLocalServiceUtil.findTopicNameByPK(topic);

		String problemDesc = ProblemLocalServiceUtil.findProblemNameByPK(problem);

		UploadPortletRequest uploadPortletRequest = 
	 		PortalUtil.getUploadPortletRequest(actionRequest);

		String attachmentName=uploadPortletRequest.getFileName("attachmentName");
		File attachment = uploadPortletRequest.getFile("attachmentName");

		

		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
		File attachFile=copyFileToServer(attachment,attachmentName,themeDisplay.getLayout().getGroupId());

		User user = themeDisplay.getUser();

		PortletPreferences portletPreferences = actionRequest.getPreferences();

		String emailTemplate = portletPreferences.getValue(
			AssistanceConfigurationKeys.EMAIL_ASSISTANCE_TEMPLATE,
			AssistanceConfigurationValues.EMAIL_ASSISTANCE_TEMPLATE) ;

		emailTemplate = StringUtil.replace(
			emailTemplate,
			new String[] {"[$CF_USER$]", "[$FULLNAME_USER$]", "[$DESCRIZIONE$]",
				"[$SERVIZIO$]","[$AREA$]","[$TEMATICA$]",
				"[$TIPOLOGIA_PROBLEMATICA$]", "[$EMAIL_USER$]",
				"[$LIVELLO_ASSISTENZA$]"},
			new String[] {user.getScreenName().toUpperCase(), user.getFullName(), description,
				serviceObject.getServiceName(), areaDesc, topicDesc, problemDesc,
				user.getEmailAddress(), serviceObject.getLevelAssistance()		
			});

		String sendEmailTo = portletPreferences.getValue(
			AssistanceConfigurationKeys.EMAIL_ASSISTANCE_TO_ADDRESSES,
			AssistanceConfigurationValues.EMAIL_ASSISTANCE_TO_ADDRESSES);

		_doSendEmail(emailTemplate, sendEmailTo, attachmentName, attachFile);

		//TRACCIATURA LOG
		String tracking = StringUtil.replace(
				TRACKING,
				new String[] {"[$CF_USER$]", "[$FULLNAME_USER$]",
					"[$SERVIZIO$]","[$AREA$]","[$TEMATICA$]",
					"[$TIPOLOGIA_PROBLEMATICA$]", "[$EMAIL_USER$]",
					"[$LIVELLO_ASSISTENZA$]"},
				new String[] {user.getScreenName().toUpperCase(),user.getFullName(),
					serviceObject.getServiceName(), areaDesc, topicDesc,
					problemDesc, user.getEmailAddress(),
					serviceObject.getLevelAssistance()		
				});

		_log.info(tracking);

		PortletURL render = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),	themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		actionResponse.sendRedirect(render.toString());
		
 		//sendRedirect(actionRequest, actionResponse);
	}
	private File copyFileToServer(File uploadedFile, String fileName, long groupId){
	
		try {
			
			
			if(uploadedFile!=null && uploadedFile.exists()){
				
				StringBuilder stringPath = new StringBuilder();
				stringPath.append(TEMP_PATH);
				stringPath.append("documents");
				stringPath.append(File.separator);
				stringPath.append(groupId);
				stringPath.append(File.separator);
				stringPath.append(baseDir);
				File folder = new File(stringPath.toString());	
				
				File fileTemp = (new File(folder.getAbsolutePath() + File.separator + fileName));
				FileUtil.copyFile(uploadedFile, fileTemp);

				return fileTemp;
			}
		} catch (Exception e) {
			_log.warn(e);
		}		
		return null;
	}	
	private void _doSendEmail(String emailTemplate, String sendEmailTo,
			String attachmentFileName, File attachment) 
		throws UnsupportedEncodingException {

		InternetAddress fromAddress = new InternetAddress(
				AssistanceConfigurationValues.EMAIL_ASSISTANCE_FROM_ADDRESS,
				AssistanceConfigurationValues.EMAIL_ASSISTANCE_FROM_NAME);
		

		InternetAddress[] toAddresses = _toInternetAddresses(
			sendEmailTo.split(StringPool.SEMICOLON));

		MailMessage mailMessage = new MailMessage();

		mailMessage.setTo(toAddresses);
		mailMessage.setFrom(fromAddress);
		mailMessage.setSubject(AssistanceConfigurationValues.
			EMAIL_ASSISTANCE_SUBJECT);
		mailMessage.setBody(emailTemplate);
		mailMessage.setHTMLFormat(false);
		if (!attachmentFileName.isEmpty()){
			FileAttachment fileAttachment = new FileAttachment(
				attachment, attachmentFileName);
			mailMessage.addFileAttachment(
				fileAttachment.getFile(), fileAttachment.getFileName());
			_log.info("with attachment file");
		}

		MailServiceUtil.sendEmail(mailMessage);

	}

	private InternetAddress[] _toInternetAddresses(String[] emailAddresses) {
		List<InternetAddress> addresses = new ArrayList<InternetAddress>();

		for (String emailAddress : emailAddresses) {
			try {
				InternetAddress address = new InternetAddress(emailAddress);
				addresses.add(address);
			}
			catch (Exception e) {
				_log.warn(e);
				_log.warn(String.format(
					"Received %s converting %s", e.getMessage(), emailAddress));
			}
		}

		InternetAddress[] result = new InternetAddress[addresses.size()];

		for (int x = 0; x < addresses.size(); x++) {
			result[x] = addresses.get(x);
		}

		return result;
	}

	private final static String TRACKING ="Richiesta Assistenza da"
			+ "[$FULLNAME_USER$] con codice fiscale [$CF_USER$] ed email "
			+ "[$EMAIL_USER$] per Servizio [$SERVIZIO$], area [$AREA$], "
			+ "tematica [$TEMATICA$], problematica [$TIPOLOGIA_PROBLEMATICA$], "
			+ "livello [$LIVELLO_ASSISTENZA$]";
	
	private static final Log _log = LogFactoryUtil.getLog(
		AssistanceSendMailMVCActionCommand.class);
}
 