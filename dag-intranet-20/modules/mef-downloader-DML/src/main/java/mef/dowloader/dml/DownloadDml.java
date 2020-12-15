package mef.dowloader.dml;


import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import java.io.InputStream;
import java.io.OutputStream;


import javax.portlet.ResourceResponse;

import org.apache.commons.io.IOUtils;

public class DownloadDml {
	public void downloadDmlFile(long fileEntryId, ThemeDisplay themeDisplay, ResourceResponse response){               
		downloadDml(fileEntryId,themeDisplay,response);
        }
       



private void downloadDml(long fileEntryId, ThemeDisplay themeDisplay, ResourceResponse response){
    
    OutputStream out = null;
    InputStream in = null;
    
    try {
     
    	   DLFileEntry fileentry= DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId);   	
          //in = DLFileEntryLocalServiceUtil.getFileAsStream(33015,fileEntryId, "1.0");
          response.setContentType(fileentry.getMimeType()); 
          
          response.setProperty("Content-Disposition",
					("attachment; ") + "filename=" + fileentry.getFileName());
          
         // response.addProperty("Content-disposition", "attachment; filename="+  fileentry.getFileName());
          in=  fileentry.getContentStream();
          out = response.getPortletOutputStream();
          IOUtils.copy(in, out);        
    } catch (Exception e) {
          _log.error(e);
    } finally {
                           
          try {
                
        
                if (Validator.isNotNull(out)) {
                      out.flush();
                      out.close();
                }
                if (Validator.isNotNull(in)) {
                      in.close();
                }

          } catch (final Exception e) {
        	  _log.error(e);
          }

    }
}



final Log _log = LogFactoryUtil.getLog(DownloadDml.class);

}
