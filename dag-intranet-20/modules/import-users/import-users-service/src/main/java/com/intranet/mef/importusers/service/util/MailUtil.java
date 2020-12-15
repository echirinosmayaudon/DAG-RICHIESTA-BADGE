package com.intranet.mef.importusers.service.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.InternetAddress;

import com.intranet.mef.importusers.service.configuration.ImportUsersConfigurationValues;
import com.intranet.mef.job.siap.model.UserFrontierBind;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.petra.mail.MailEngine;
import com.liferay.petra.mail.MailEngineException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.StringUtil;

public class MailUtil {

	public void sendReportEmailToImportUsers(StringBuilder emailBody)
		throws UnsupportedEncodingException, MailEngineException {

		InternetAddress fromAddress = new InternetAddress(
			ImportUsersConfigurationValues.
				IMPORT_USERS_RESULT_EMAIL_FROM_ADDRESS,
			ImportUsersConfigurationValues.
				IMPORT_USERS_RESULT_EMAIL_FROM_NAME);

		InternetAddress[] toAddresses = _toInternetAddresses(
			ImportUsersConfigurationValues.
				IMPORT_USERS_RESULT_EMAIL_TO_ADDRESSES);

		MailMessage mailMessage = new MailMessage();

		mailMessage.setTo(toAddresses);
		mailMessage.setFrom(fromAddress);
		mailMessage.setSubject("Report Import Utenti");
		mailMessage.setBody(emailBody.toString());
		mailMessage.setHTMLFormat(true);

		MailEngine.send(mailMessage);
	}
	
	public void sendReportEmailToReplicaUsers(StringBuilder emailBody)
		throws UnsupportedEncodingException, MailEngineException{

		InternetAddress fromAddress = new InternetAddress(
			ImportUsersConfigurationValues.
				IMPORT_USERS_RESULT_EMAIL_FROM_ADDRESS,
			ImportUsersConfigurationValues.
				IMPORT_USERS_RESULT_EMAIL_FROM_NAME);

		InternetAddress[] toAddresses = _toInternetAddresses(
			ImportUsersConfigurationValues.
				IMPORT_USERS_RESULT_EMAIL_TO_ADDRESSES);

		MailMessage mailMessage = new MailMessage();

		mailMessage.setTo(toAddresses);
		mailMessage.setFrom(fromAddress);
		mailMessage.setSubject("Report Replica Utenti");
		mailMessage.setBody(emailBody.toString());
		mailMessage.setHTMLFormat(true);

		MailEngine.send(mailMessage);
	}

	private InternetAddress[] _toInternetAddresses(String[] emailAddresses) {
		List<InternetAddress> addresses = new ArrayList<InternetAddress>();

		for (String emailAddress : emailAddresses) {
			try {
				InternetAddress address = new InternetAddress(emailAddress);
				addresses.add(address);
			}
			catch (Exception e) {
				if(_log.isDebugEnabled()){
					_log.error(e);
				}
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

	public static void _trackCompanyHeader(StringBuilder emailBody, String type){

		String value = StringUtil.replace(
			_HEADER_MAIL,
			new String[] {"[$VAR$]"},
			new String[] {type});

		emailBody.append(value);
	}

	public static void _trackWarning(StringBuilder emailBody, String testWarning){

		String value = StringUtil.replace(
			_WARNING_MAIL,
			new String[] {"[$WARNING$]"},
			new String[] {testWarning});

		emailBody.append(value);
	}

	public static void _trackUser(StringBuilder emailBody, String screenName){

		String value = StringUtil.replace(
			_PROCESS_USER_MAIL,
			new String[] {"[$SCREEN_NAME$]"},
			new String[] {screenName});

		emailBody.append(value);
	}

	public static void _trackCreateUser(
		StringBuilder emailBody, User targetUser) {

		if (_log.isInfoEnabled()){
			_log.info(
				"Create user : "
				+ targetUser.getUserId() + " - "
				+ targetUser.getScreenName() + " - "
				+ targetUser.getEmailAddress()
			);
		}

		String value = StringUtil.replace(
			_USER_BODY,
			new String[] {"[$SCREEN_NAME$]", "[$EMAIL$]", "[$USER_ID$]"},
			new String[] {
				targetUser.getScreenName(), targetUser.getEmailAddress(),
				String.valueOf(targetUser.getUserId())
			});

		emailBody.append(value);
	}

	public static void _trackDeleteUser(StringBuilder emailBody,
		User targetUser){

		if (_log.isInfoEnabled()) {
			_log.info(
				"Deleted user " +
				targetUser.getScreenName() + " - " +
				targetUser.getEmailAddress() + " - " +
				targetUser.getUserId());
		}

		String value = StringUtil.replace(
			_DELETE_BODY,
			new String[] {"[$SCREEN_NAME$]", "[$EMAIL$]", "[$USER_ID$]"},
			new String[] {
				targetUser.getScreenName(),
				targetUser.getEmailAddress(),
				String.valueOf(targetUser.getUserId())
			});

		emailBody.append(value);
	}

	public static void _trackErrorCreateSiteTargetUser(
		StringBuilder emailBody, User targetUser, Company targetCompany) {

		if (_log.isInfoEnabled()) {
			_log.info(
				"Error on create site target for user " +
					targetUser.getEmailAddress() +
				" for company " + targetCompany.getCompanyId()
				+ " - " + targetCompany.getWebId());
		}

		String value = StringUtil.replace(
			_ERROR_CREATE_SITE_TARGET,
			new String[] {"[$SCREEN_NAME$]", "[$USER_ID$]", "[$MAIL$]"},
			new String[] {
				targetUser.getScreenName(),
				String.valueOf(targetUser.getUserId()),
				targetUser.getEmailAddress()
		});

		emailBody.append(value);
	}

	public static void _trackErrorImport(
			StringBuilder emailBody, UserFrontierBind userFrontierBind,
			String type, String errorMsg){

		if (_log.isInfoEnabled()) {

			_log.info(
				"Unable to import user "
				+ userFrontierBind.getScreenName() + " - "
				+ userFrontierBind.getEmail());
		}

		String value = StringUtil.replace(
			_ERROR_IMPORT_USER,
			new String[] {"[$TYPE$]","[$SCREEN_NAME$]", "[$EMAIL$]","[$ERROR$]"},
			new String[] {
				type, userFrontierBind.getScreenName(),
				userFrontierBind.getEmail(), errorMsg				
		});

		emailBody.append(value);
	}

	
	public static void _trackErrorReplica(
			StringBuilder emailBody, User masterUser,
			String type, String errorMsg){

		if (_log.isInfoEnabled()) {

			_log.info(
				"Unable to import user "
				+ masterUser.getScreenName() + " - "
				+ masterUser.getEmailAddress());
		}

		String value = StringUtil.replace(
			_ERROR_IMPORT_USER,
			new String[] {"[$TYPE$]","[$SCREEN_NAME$]", "[$EMAIL$]","[$ERROR$]"},
			new String[] {
				type, masterUser.getScreenName(),
				masterUser.getEmailAddress(), errorMsg				
		});

		emailBody.append(value);
	}
	
	
	
	
	
	public static void _trackErrorUpdateEmail(
			StringBuilder emailBody, User targetUser){

		if (_log.isInfoEnabled()) {

			_log.info(
				"Unable to update user email for user "
				+ targetUser.getScreenName() + " - "
				+ targetUser.getUserId()
				+ " because already exist user with email " 
				+ targetUser.getEmailAddress());
		}

		String value = StringUtil.replace(
			_ERROR_UPDATE_MAIL,
			new String[] {"[$SCREEN_NAME$]", "[$USER_ID$]", "[$MASTER_MAIL$]"},
			new String[] {
				targetUser.getScreenName(),
				String.valueOf(targetUser.getUserId()),
				targetUser.getEmailAddress()
		});

		emailBody.append(value);
	}

	public static void _trackImpossibileDeleteUser(
		StringBuilder emailBody, User targetUser) {

		if(_log.isInfoEnabled()){
			_log.info(
				"Impossibile rimuovere l'utente : "
				+ targetUser.getScreenName()
				+ " - " + targetUser.getEmailAddress()
				+ " - " + targetUser.getUserId()
				+ " in quanto risulta essere l'utente di default");
		}

		String value = StringUtil.replace(
			_IMPOSSIBILE_DELETE_BODY,
			new String[] {"[$SCREEN_NAME$]", "[$EMAIL$]", "[$USER_ID$]"},
			new String[] {
				targetUser.getScreenName(), targetUser.getEmailAddress(),
				String.valueOf(targetUser.getUserId())
			});

		emailBody.append(value);
	}

	public static void _trackUpdateUser(
			StringBuilder emailBody, User targetUser)
		throws PortalException {

		if (_log.isInfoEnabled()) {

			_log.info(
				"Update User " + targetUser.getUserId()
				+ " - " + targetUser.getScreenName()
				+ " - " + targetUser.getEmailAddress());
		}

		String value = StringUtil.replace(
			_UPDATE_USER,
			new String[] {"[$SCREEN_NAME$]", "[$EMAIL$]", "[$USER_ID$]"},
			new String[] {
				targetUser.getScreenName(), targetUser.getEmailAddress(),
				String.valueOf(targetUser.getUserId())
			});

		emailBody.append(value);
	}

	public static final String _HEADER_MAIL =
		"<div style='width:100%;'>" +
		"<br/><hr><br/>" +
		"<h1><strong>Sincronizzazione [$VAR$] Utenti</strong>" +
		"</h1><br/>" +
		"</div>";

	public static final String _UPDATE_USER =
		"<div style='width:100%;'>" +
		"Aggiornato User: [$SCREEN_NAME$] - [$EMAIL$] con id [$USER_ID$]" +
		"</div>";

	public static final String _ERROR_IMPORT_USER =
		"<div style='width:100%;'>" +
		"Impossibile [$TYPE$] User: [$SCREEN_NAME$] con e-mail [$EMAIL$], "+
		"Error Msg: [$ERROR$]</div>";

	
	public static final String _ERROR_UPDATE_MAIL =
		"<div style='width:100%;'>" +
		"Impossibile aggiornare User: [$SCREEN_NAME$] con id [$USER_ID$]" +
		" in quanto la mail [$MASTER_MAIL$] risulta gia' associata" +
		" ad un altro utente" +
		"</div>";

	public static final String _ERROR_CREATE_SITE_TARGET =
		"<div style='width:100%;'>" +
		"ERRORE in creazione sito target User: [$SCREEN_NAME$] con id"
		+ "[$USER_ID$] ed mail [$MAIL$] "+
		"</div>";

	public static final String _USER_BODY =
		"<div style='width:100%;'>" +
		"Creato User: [$SCREEN_NAME$] - [$EMAIL$] con id [$USER_ID$]" +
		"</div>";

	public static final String _DELETE_BODY =
		"<div style='width:100%;'>" +
		"Eliminato User:: [$SCREEN_NAME$] - [$EMAIL$] con id [$USER_ID$]" +
		"</div>";

	public static final String _IMPOSSIBILE_DELETE_BODY =
		"<div style='width:100%;'>"+
		"Impossibile eliminare l'User: [$SCREEN_NAME$] - [$EMAIL$] con id " +
		"[$USER_ID$] in quanto risulta essere l'utente di default " +
		"</div>";

	public static final String _PROCESS_USER_MAIL =
		"<div style='width:100%;'><br/>" +
		"<strong>PROCESSO Utente [$SCREEN_NAME$]" +
		"</strong>" +
		"</div>";

	public static final String _WARNING_MAIL =
		"<div style='width:100%;'>" +
		"WARNING: [$WARNING$] " +
		"</div>";

	private static final Log _log = LogFactoryUtil.getLog(
		MailUtil.class);
}
