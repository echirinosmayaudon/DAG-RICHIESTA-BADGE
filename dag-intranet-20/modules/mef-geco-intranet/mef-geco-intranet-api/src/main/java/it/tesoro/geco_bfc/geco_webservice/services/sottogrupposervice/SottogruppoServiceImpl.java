
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package it.tesoro.geco_bfc.geco_webservice.services.sottogrupposervice;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.mef.geco.intranet.exception.MessageRuntimeException;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import it.tesoro.geco.geco_webservice.services.richiestabfcservice.RichiestaBFCServiceImpl;



/**
 * This class was generated by Apache CXF 3.2.0
 * 2017-12-05T09:11:41.451+01:00
 * Generated source version: 3.2.0
 * 
 */

@javax.jws.WebService(
                      serviceName = "SottogruppoServiceService",
                      portName = "SottogruppoService",
                      targetNamespace = "http://geco-bfc.tesoro.it/geco-webservice/services/SottogruppoService",
                      wsdlLocation = "http://geco-bfc.tesoro.it/geco-webservice/services/SottogruppoService?wsdl",
                      endpointInterface = "it.tesoro.geco_bfc.geco_webservice.services.sottogrupposervice.SottogruppoService")
                      
public class SottogruppoServiceImpl implements SottogruppoService {

	final Log _log = LogFactoryUtil.getLog(SottogruppoServiceImpl.class);

    /* (non-Javadoc)
     * @see it.tesoro.geco_bfc.geco_webservice.services.sottogrupposervice.SottogruppoService#getSottogruppi(java.lang.String in0)*
     */
    public java.lang.String getSottogruppi(java.lang.String in0) { 
    	_log.info("Executing operation getSottogruppi");
        System.out.println(in0);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
        	_log.error(ex);
            throw new MessageRuntimeException(ex.getMessage());
        }
    }

}
