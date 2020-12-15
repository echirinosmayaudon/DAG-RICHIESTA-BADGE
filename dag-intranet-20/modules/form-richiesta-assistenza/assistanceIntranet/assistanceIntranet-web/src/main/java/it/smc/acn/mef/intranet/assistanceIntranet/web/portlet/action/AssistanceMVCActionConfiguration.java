package it.smc.acn.mef.intranet.assistanceIntranet.web.portlet.action;

import java.io.File;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.intranet.mef.assistance.service.AssistanceHelperLocalServiceUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import it.smc.acn.mef.intranet.assistanceIntranet.web.configuration.AssistanceConfigurationKeys;
import it.smc.acn.mef.intranet.assistanceIntranet.web.constants.AssistanceWebPortletKeys;



/**
 * @author Debora Giovannoli
 */
@Component(
	immediate = true,
	property = {"javax.portlet.name=" + AssistanceWebPortletKeys.ASSISTANCE },
	service = ConfigurationAction.class
)
public class AssistanceMVCActionConfiguration
	extends DefaultConfigurationAction {

	@Override
	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		updateDisplaySettings(actionRequest, actionResponse);

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	@Override
	@Reference(
		target = "(osgi.web.symbolicname=com.intranet.mef.assistance.web)",
		unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}

	protected void updateDisplaySettings(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {
		
		//prelevo i due file 		
		UploadPortletRequest uploadPortletRequest =
				PortalUtil.getUploadPortletRequest(actionRequest);
		
		String fileTableName=uploadPortletRequest.getFileName("fileTable");
		String fileFaqName=uploadPortletRequest.getFileName("fileFaq");
		File fileTable = uploadPortletRequest.getFile("fileTable");
		File fileFaq = uploadPortletRequest.getFile("fileFaq");

 		/* gestire i file a null se uno dei due non e' presente
 		*  non deve essere portato a termine il caricamento
 		*/

		if (!fileTableName.isEmpty() && !fileFaqName.isEmpty()) {
 			
			AssistanceHelperLocalServiceUtil.uploadTripleteFaq(
				fileTable, fileFaq);
		}

		//MAIL
		String emailTemplate= ParamUtil.getString(actionRequest,
			AssistanceConfigurationKeys.EMAIL_ASSISTANCE_TEMPLATE);
		
		PortletPreferences portletPreferences = actionRequest.getPreferences();

		String emailToAddresses = ParamUtil.getString(
			actionRequest, AssistanceConfigurationKeys.
				EMAIL_ASSISTANCE_TO_ADDRESSES);

		portletPreferences.setValue(
			AssistanceConfigurationKeys.EMAIL_ASSISTANCE_TO_ADDRESSES, 
			emailToAddresses);

		portletPreferences.setValue(
			AssistanceConfigurationKeys.EMAIL_ASSISTANCE_TEMPLATE, 
			emailTemplate);

		portletPreferences.store();

	}

}