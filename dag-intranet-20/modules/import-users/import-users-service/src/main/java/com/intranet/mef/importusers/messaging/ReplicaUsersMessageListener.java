package com.intranet.mef.importusers.messaging;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicyOption;

import com.intranet.mef.importusers.costants.ImportUsersDestinationNames;
import com.intranet.mef.importusers.service.ReplicaUsersHelperLocalService;
import com.intranet.mef.importusers.service.util.MailUtil;
import com.intranet.mef.importusers.service.util.ReplyUserUtil;
import com.intranet.mef.job.siap.service.UserFrontierBindLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;

/**
 * @author Domenico Costa
 */

@Component(
	immediate = true,
	property = {
		"destination.name=" + ImportUsersDestinationNames.REPLICA_USER},
	service = MessageListener.class
)
public class ReplicaUsersMessageListener extends BaseMessageListener {

	@Override
	protected void doReceive(Message message) throws Exception {

		long targetCompanyId = message.getLong("companyId");

		_checkReplicaUsers(targetCompanyId);

		if (_log.isInfoEnabled()) {
			_log.info("End Replica Users checker...");
		}

		//Lancio BCK user Frontiera a conclusione
		_log.info("CALL FUNCTION BCK FRONTIER");
		String logLoadBCK = UserFrontierBindLocalServiceUtil.callLoadBCK();

		if (Boolean.valueOf(logLoadBCK)){
			_log.info("CARICAMENTO BACKUP USERS FRONTIERA EFFETTUATO CON SUCCESSO !!!");
		}else{
			_log.error("CARICAMENTO BACKUP USERS FRONTIERA CALL FALSE");
		}

	}

	private void _checkReplicaUsers(long targetCompanyId) {
		StringBuilder emailBody = new StringBuilder();

		try {

			ReplyUserUtil.checkReplicaUsers(targetCompanyId, emailBody);

		}
		catch (Exception e) {
			_log.error(e, e);
		}finally {
			try {
				MailUtil sendMail = new MailUtil();
				sendMail.sendReportEmailToReplicaUsers(emailBody);
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}

	}

	@Reference(policyOption = ReferencePolicyOption.GREEDY, unbind = "-")
	private ReplicaUsersHelperLocalService _replicaUsersHelperLocalService;

	private static final Log _log = LogFactoryUtil.getLog(
		ReplicaUsersMessageListener.class);

}
