package com.intranet.mef.ics.calendar.file.resource.portlet.action;

import com.intranet.mef.calendar.sender.service.LogMailLocalService;
import com.intranet.mef.ics.calendar.file.resource.constants.IcsCalendarFileResourcePortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = {
            "javax.portlet.name=" + IcsCalendarFileResourcePortletKeys.CALENDARFILERESOURCE,
            "mvc.command.name=/mef/intranet/calendar/ics"
        },
        service = MVCResourceCommand.class
    )
public class IcsCalendarFileMVCResourceCommand extends BaseMVCResourceCommand {
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		
			Long timeStart = ParamUtil.getLong(resourceRequest, "timeStart");
			Long timeFinish = ParamUtil.getLong(resourceRequest, "timeFinish");
			String eventTitle = ParamUtil.getString(resourceRequest, "eventTitle");
			String eventDescription = ParamUtil.getString(resourceRequest, "eventDescription");
			String icsDescription = ParamUtil.getString(resourceRequest, "icsDescription");
			
			File icsFile = _logMailLocalService.generateIcsFile(timeStart, timeFinish, eventTitle, eventDescription, icsDescription);
			resourceResponse.setContentType("text/calendar");
			resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + icsFile.getName() + "\"");
			resourceResponse.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");

			OutputStream out = resourceResponse.getPortletOutputStream();
			InputStream in = new FileInputStream(icsFile);
			
			byte[] buffer = new byte[4096];
			int len;
			while ((len = in.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
			out.flush();
			in.close();
			out.close();
	}
	
	private LogMailLocalService _logMailLocalService;
	
	@Reference(unbind = "-")
    public void setLogMailLocalService(LogMailLocalService guestbookService) {
		_logMailLocalService = guestbookService;
    }
	
	public LogMailLocalService getLogMailLocalService() {
        return _logMailLocalService;
    }
	

}