
package it.intranetdag.rubrica.services;

import javax.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 3.1.12
 * 2017-07-24T18:02:54.755+02:00
 * Generated source version: 3.1.12
 * 
 */
 
public class AnagraficaWSPortType_AnagraficaWSHttpSoap12Endpoint_Server{

    protected AnagraficaWSPortType_AnagraficaWSHttpSoap12Endpoint_Server() throws java.lang.Exception {
        System.out.println("Starting Server");
        Object implementor = new AnagraficaWSHttpSoap12EndpointImpl();
        String address = "http://18.194.147.230/MEFIntranetRubricaWS/services/AnagraficaWS.AnagraficaWSHttpSoap12Endpoint/";
        Endpoint.publish(address, implementor);
    }
    
    public static void main(String args[]) throws java.lang.Exception { 
        new AnagraficaWSPortType_AnagraficaWSHttpSoap12Endpoint_Server();
        System.out.println("Server ready..."); 
        
        Thread.sleep(5 * 60 * 1000); 
        System.out.println("Server exiting");
        System.exit(0);
    }
}
