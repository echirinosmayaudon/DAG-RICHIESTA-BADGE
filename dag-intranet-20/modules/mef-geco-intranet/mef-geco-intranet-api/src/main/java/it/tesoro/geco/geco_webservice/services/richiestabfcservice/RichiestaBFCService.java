package it.tesoro.geco.geco_webservice.services.richiestabfcservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * This class was generated by Apache CXF 3.2.0
 * 2017-12-05T18:47:07.712+01:00
 * Generated source version: 3.2.0
 * 
 */
@WebService(targetNamespace = "http://geco.tesoro.it/geco-webservice/services/RichiestaBFCService", name = "RichiestaBFCService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface RichiestaBFCService {

    @WebMethod
    @WebResult(name = "nuovaRichiestaMaterialeReturn", targetNamespace = "http://geco.tesoro.it/geco-webservice/services/RichiestaBFCService", partName = "nuovaRichiestaMaterialeReturn")
    public java.lang.String nuovaRichiestaMateriale(
        @WebParam(partName = "in0", name = "in0")
        java.lang.String in0
    );
}
