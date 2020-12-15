package bacheca.annunci.list.portlet;

import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

//Non ustao da nessuno ma potrebbe servire (Upload Img da File System)
@Component(property = { "javax.portlet.name=" + BachecaAnnunciKeys.BACHECAANNUNCI,
	"mvc.command.name=/bacheca_annunci/upload_multiple_file_entries" }, service = MVCResourceCommand.class)
public class BachecaAnnunciMVCResourceCommand extends BaseMVCResourceCommand {
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		try {
			String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
			if (cmd.equals(Constants.GET_TEMP)) {
				String uuid = ParamUtil.getString(resourceRequest, "uuid");
				ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
				FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntryByUuidAndGroupId(uuid, themeDisplay.getSiteGroupId());
				byte[] bytes = FileUtil.getBytes(fileEntry.getContentStream());
				resourceResponse.setContentType(MimeTypesUtil.getExtensionContentType(fileEntry.getExtension()));
				PortletResponseUtil.write(resourceResponse, bytes);
			}
		}
		//		catch (NoSuchFileEntryException nsfee) {
		//		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static final Log _log = LogFactoryUtil.getLog(BaseMVCResourceCommand.class);
}
