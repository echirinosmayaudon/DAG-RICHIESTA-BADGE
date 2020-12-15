package mef.richieste.figli.configuration.action;


import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;



import mef.richieste.figli.form.Configuration.mefRichiesteFigliFormConfiguration;
import mef.richieste.figli.form.constants.MefRichiesteFigliFormPortletKeys;


@Component(
		configurationPid = "mef.richieste.figli.form.Configuration.mefRichiesteFigliFormConfiguration",
		configurationPolicy = ConfigurationPolicy.OPTIONAL,
		immediate = true,
		property = {
				"javax.portlet.name=" + MefRichiesteFigliFormPortletKeys.MEFRICHIESTEFIGLIFORM
		},
		service = ConfigurationAction.class
		)
 public class mefRichiesteFigliConfigurationAction  extends DefaultConfigurationAction{
	Log _log=LogFactoryUtil.getLog(mefRichiesteFigliConfigurationAction.class);
	@Override
	   public void processAction(PortletConfig portletConfig, ActionRequest actionRequest,ActionResponse actionResponse) throws Exception  
	   {
	 		String type_config = ParamUtil.getString(actionRequest, "type_config"); 
	    	
	    	switch (type_config) {
	    	case "configPrincipale":
	    		
	    		configurazione( actionRequest, actionResponse, type_config);
	    		break;
	    	}
			super.processAction(portletConfig, actionRequest, actionResponse);
	   }
	public void configurazione ( ActionRequest actionRequest,ActionResponse actionResponse, String type_config) throws FileNotFoundException, IOException{
		String richiestaRimborsoTmpl = ParamUtil.getString(actionRequest, "richiestaRimborsoTmpl");
		String subjectRichiestaRimborso = ParamUtil.getString(actionRequest, "subjectRichiestaRimborso");
		String senderRichiestaRimborso = ParamUtil.getString(actionRequest, "senderRichiestaRimborso");
		String emailReferente = ParamUtil.getString(actionRequest, "emailReferente");
	     String dataRichiestaRimborso = ParamUtil.getString(actionRequest, "dataRichiestaRimborso");
	     String dimensioneAllegato = ParamUtil.getString(actionRequest, "dimensioneAllegato");
	     String oggettoPDF = ParamUtil.getString(actionRequest, "oggettoPDF");
	     String richiestaPDF = ParamUtil.getString(actionRequest, "richiestaPDF");
	     String spesaSostenutaPDF = ParamUtil.getString(actionRequest, "spesaSostenutaPDF");
	     String eventualiNotePDF = ParamUtil.getString(actionRequest, "eventualiNotePDF");
	     
	     
		       
        if((Validator.isNotNull(richiestaRimborsoTmpl))|| (Validator.isNotNull(subjectRichiestaRimborso))||( Validator.isNotNull(senderRichiestaRimborso)) || (Validator.isNotNull(emailReferente))||(Validator.isNotNull(dataRichiestaRimborso)) ) {  
	        
        	setPreference(actionRequest, "richiestaRimborsoTmpl", richiestaRimborsoTmpl);			
    		setPreference(actionRequest, "subjectRichiestaRimborso", subjectRichiestaRimborso);
    		setPreference(actionRequest, "senderRichiestaRimborso", senderRichiestaRimborso);
    		setPreference(actionRequest, "emailReferente", emailReferente);
    		setPreference(actionRequest, "dataRichiestaRimborso", dataRichiestaRimborso);
    		setPreference(actionRequest, "dimensioneAllegato", dimensioneAllegato);
    		setPreference(actionRequest, "oggettoPDF", oggettoPDF);
    		setPreference(actionRequest, "richiestaPDF", richiestaPDF);
    		setPreference(actionRequest, "spesaSostenutaPDF", spesaSostenutaPDF);
    		setPreference(actionRequest, "eventualiNotePDF", eventualiNotePDF);
    		
		}
		else 
		{ 		
			setPreference(actionRequest, "richiestaRimborsoTmpl", "");			
			setPreference(actionRequest, "subjectRichiestaRimborso", "");
			setPreference(actionRequest, "senderRichiestaRimborso", "");
			setPreference(actionRequest, "emailReferente", "");
			setPreference(actionRequest, "dataRichiestaRimborso", "");
			setPreference(actionRequest, "dimensioneAllegato", "");
    		setPreference(actionRequest, "oggettoPDF", "");
    		setPreference(actionRequest, "richiestaPDF", "");
    		setPreference(actionRequest, "spesaSostenutaPDF", "");
    		setPreference(actionRequest, "eventualiNotePDF", "");
		}
	}
	@Override
    public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) throws Exception {

        httpServletRequest.setAttribute(mefRichiesteFigliFormConfiguration.class.getName(), _configuration);

        super.include(portletConfig, httpServletRequest, httpServletResponse);
    }
    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
    	_configuration = ConfigurableUtil.createConfigurable(mefRichiesteFigliFormConfiguration.class, properties);
    }
    private volatile mefRichiesteFigliFormConfiguration _configuration;
}

	
	
	
	
	
	
	

    
