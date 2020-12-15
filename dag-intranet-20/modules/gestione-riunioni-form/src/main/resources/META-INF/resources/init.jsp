<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="com.intranet.mef.gestione.riunioni.service.StatoRiunioneLocalServiceUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Calendar" %>
<%@page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@page import="com.intranet.mef.gestione.riunioni.service.StatoInvitatoLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.InvitatiRiunioneLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.RiunioneLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.AmministrazioneConvocanteLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.TipoRiunioneLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.LuogoLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.Riunione"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.TipoRiunione"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.StatoInvitato"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.Luogo"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante"%>
<%@page import="com.intranet.mef.portlet.GestioneRiunioniFormConfig"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione"%>
<%@page import="java.util.Collection"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.StatoRiunione"%>
<%@page import="com.mef.ricercariunione.stub.Segreteria"%>
<%@page import="com.mef.ricercariunione.stub.Partecipante"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.persistence.InvitatiRiunionePK"%>
<%@page import="com.intranet.mef.util.BeanCreator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>

<%@page import="com.mef.ricercariunione.stub.RiunioneBean"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
GestioneRiunioniFormConfig riunioniMefConfig =
        (GestioneRiunioniFormConfig)
        renderRequest.getAttribute(GestioneRiunioniFormConfig.class.getName());

    String modificariunioneTmpl = StringPool.BLANK;
    
	
	String aggiuntainvitatiriunioneTmpl = StringPool.BLANK;
    String modificainvitatiriunioneTmpl = StringPool.BLANK;
    String senderModificaInvitati = StringPool.BLANK;
    String subjectModificaInvitati = StringPool.BLANK;
    String senderAggiuntaInvitati = StringPool.BLANK;
    String subjectAggiuntaInvitati = StringPool.BLANK;
	
    String riunionerinviataTmpl = StringPool.BLANK;
    String subjectRiunioneRinviata = StringPool.BLANK;
    String senderRiunioneRinviata = StringPool.BLANK;

	 
    String sollecitoriunioneTmpl = StringPool.BLANK;
	String sollecitoaccettatariunioneTmpl = StringPool.BLANK;
    String invitoriunioneTmpl = StringPool.BLANK;
    String cancellainvitoriunioneTmpl = StringPool.BLANK;
    String spostariunioneTmpl = StringPool.BLANK;
    String cambiostatoriunioneTmpl = StringPool.BLANK;    
	String cambiostatoriunioneindettaTmpl = StringPool.BLANK;
    String senderModifica = StringPool.BLANK;
    String subjectModifica = StringPool.BLANK;
  
    String senderSollecito = StringPool.BLANK;
    String subjectSollecito = StringPool.BLANK;
	String senderSollecitoAccettata = StringPool.BLANK;
    String subjectSollecitoAccettata = StringPool.BLANK;
    String senderInvito = StringPool.BLANK;
    String subjectInvito = StringPool.BLANK;
	String senderCancellaInvito = StringPool.BLANK;
    String subjectCancellaInvito = StringPool.BLANK;
    String senderSposta = StringPool.BLANK;
    String subjectSposta = StringPool.BLANK;
    String senderCambioStato = StringPool.BLANK;
    String subjectCambioStato = StringPool.BLANK; 
	String senderStatoIndetta = StringPool.BLANK;
    String subjectStatoIndetta = StringPool.BLANK; 
    String itemsPerPage = StringPool.BLANK;
    String ricercaRiunionetxt = StringPool.BLANK;
    String ricercaRiunionetitle = StringPool.BLANK;
    String creaRiunionetxt = StringPool.BLANK;
    String creaRiunionetitle = StringPool.BLANK;
    String luoghiRiunionetxt = StringPool.BLANK;
    String luoghiRiunionetitle = StringPool.BLANK;
    String convocantiRiunionetxt = StringPool.BLANK;
    String convocantiRiunionetitle = StringPool.BLANK;
    String modificaRiunionetxt = StringPool.BLANK;
    String modificaRiunionetitle = StringPool.BLANK;
    String stampaRiunionetxt = StringPool.BLANK;
    String stampaRiunionetitle = StringPool.BLANK;
    String accettaRiunionetxt = StringPool.BLANK;
    String accettaRiunionetitle = StringPool.BLANK;
    
    if (Validator.isNotNull(riunioniMefConfig)) {
    	riunionerinviataTmpl = portletPreferences.getValue(
					"riunionerinviataTmpl", riunioniMefConfig.riunionerinviataTmpl());
		subjectRiunioneRinviata = portletPreferences.getValue(
					"subjectRiunioneRinviata", riunioniMefConfig.subjectRiunioneRinviata());
		senderRiunioneRinviata = portletPreferences.getValue(
					"senderRiunioneRinviata", riunioniMefConfig.senderRiunioneRinviata());

					
		aggiuntainvitatiriunioneTmpl = portletPreferences.getValue(
					"aggiuntainvitatiriunioneTmpl", riunioniMefConfig.aggiuntainvitatiriunioneTmpl());
		
		modificainvitatiriunioneTmpl = portletPreferences.getValue(
					"modificainvitatiriunioneTmpl", riunioniMefConfig.modificainvitatiriunioneTmpl());
		
		senderModificaInvitati = portletPreferences.getValue(
					"senderModificaInvitati", riunioniMefConfig.senderModificaInvitati());
		
		subjectModificaInvitati = portletPreferences.getValue(
					"subjectModificaInvitati", riunioniMefConfig.subjectModificaInvitati());
		
		senderAggiuntaInvitati = portletPreferences.getValue(
					"senderAggiuntaInvitati", riunioniMefConfig.senderAggiuntaInvitati());
		
		subjectAggiuntaInvitati = portletPreferences.getValue(
					"subjectAggiuntaInvitati", riunioniMefConfig.subjectAggiuntaInvitati());

    	modificariunioneTmpl = portletPreferences.getValue(
                "modificariunioneTmpl", riunioniMefConfig.modificariunioneTmpl());
    	
   
    	
    	sollecitoriunioneTmpl = portletPreferences.getValue(
                "sollecitoriunioneTmpl", riunioniMefConfig.sollecitoriunioneTmpl());
    	
		sollecitoaccettatariunioneTmpl = portletPreferences.getValue(
                "sollecitoaccettatariunioneTmpl", riunioniMefConfig.sollecitoaccettatariunioneTmpl());
		
    	invitoriunioneTmpl = portletPreferences.getValue(
                "invitoriunioneTmpl", riunioniMefConfig.invitoriunioneTmpl());
    	
		cancellainvitoriunioneTmpl = portletPreferences.getValue(
                "cancellainvitoriunioneTmpl", riunioniMefConfig.cancellainvitoriunioneTmpl());
    	spostariunioneTmpl = portletPreferences.getValue(
                "spostariunioneTmpl", riunioniMefConfig.spostariunioneTmpl());
    	
    	cambiostatoriunioneTmpl = portletPreferences.getValue(
                "cambiostatoriunioneTmpl", riunioniMefConfig.cambiostatoriunioneTmpl());
    	
		cambiostatoriunioneindettaTmpl = portletPreferences.getValue(
                "cambiostatoriunioneindettaTmpl", riunioniMefConfig.cambiostatoriunioneindettaTmpl());
		
    	senderModifica = portletPreferences.getValue(
                "senderModifica", riunioniMefConfig.senderModifica());
    	
    	subjectModifica = portletPreferences.getValue(
                "subjectModifica", riunioniMefConfig.subjectModifica());
    	
    	
    	senderSollecito = portletPreferences.getValue(
                "senderSollecito", riunioniMefConfig.senderSollecito());
    	
    	subjectSollecito = portletPreferences.getValue(
                "subjectSollecito", riunioniMefConfig.subjectSollecito());
    	
		senderSollecitoAccettata = portletPreferences.getValue(
                "senderSollecitoAccettata", riunioniMefConfig.senderSollecitoAccettata());
    	
    	subjectSollecitoAccettata = portletPreferences.getValue(
                "subjectSollecitoAccettata", riunioniMefConfig.subjectSollecitoAccettata());
				
    	senderInvito = portletPreferences.getValue(
                "senderInvito", riunioniMefConfig.senderInvito());
    	
    	subjectInvito = portletPreferences.getValue(
                "subjectInvito", riunioniMefConfig.subjectInvito());
    	senderCancellaInvito = portletPreferences.getValue(
                "senderCancellaInvito", riunioniMefConfig.senderCancellaInvito());
    	
    	subjectCancellaInvito = portletPreferences.getValue(
                "subjectCancellaInvito", riunioniMefConfig.subjectCancellaInvito());
    	senderSposta = portletPreferences.getValue(
                "senderSposta", riunioniMefConfig.senderSposta());
    	
    	subjectSposta = portletPreferences.getValue(
                "subjectSposta", riunioniMefConfig.subjectSposta());
    	
    	senderCambioStato = portletPreferences.getValue(
                "senderCambioStato", riunioniMefConfig.senderCambioStato());
    	
    	subjectCambioStato = portletPreferences.getValue(
                "subjectCambioStato", riunioniMefConfig.subjectCambioStato());
    	
		senderStatoIndetta = portletPreferences.getValue(
                "senderStatoIndetta", riunioniMefConfig.senderStatoIndetta());
    	
    	subjectStatoIndetta = portletPreferences.getValue(
                "subjectStatoIndetta", riunioniMefConfig.subjectStatoIndetta());
      	itemsPerPage =  portletPreferences.getValue(
         		"itemsPerPage", String.valueOf(riunioniMefConfig.itemsPerPage()));
      	
      	ricercaRiunionetxt =  portletPreferences.getValue(
         		"ricercaRiunionetxt", riunioniMefConfig.ricercaRiunionetxt());
      	
    	ricercaRiunionetitle =  portletPreferences.getValue(
         		"ricercaRiunionetitle", riunioniMefConfig.ricercaRiunionetitle());
      	
      	creaRiunionetxt =  portletPreferences.getValue(
         		"creaRiunionetxt", riunioniMefConfig.creaRiunionetxt());
      	
    	creaRiunionetitle =  portletPreferences.getValue(
         		"creaRiunionetitle", riunioniMefConfig.creaRiunionetitle());
      	
      	luoghiRiunionetxt =  portletPreferences.getValue(
         		"luoghiRiunionetxt", riunioniMefConfig.luoghiRiunionetxt());
      	
      	luoghiRiunionetitle =  portletPreferences.getValue(
         		"luoghiRiunionetitle", riunioniMefConfig.luoghiRiunionetitle());
      	
      	convocantiRiunionetxt =  portletPreferences.getValue(
         		"convocantiRiunionetxt", riunioniMefConfig.convocantiRiunionetxt());
      	
     	convocantiRiunionetitle =  portletPreferences.getValue(
         		"convocantiRiunionetitle", riunioniMefConfig.convocantiRiunionetitle());
      	
      	modificaRiunionetxt =  portletPreferences.getValue(
         		"modificaRiunionetxt", riunioniMefConfig.modificaRiunionetxt());
      	
      	modificaRiunionetitle =  portletPreferences.getValue(
         		"modificaRiunionetitle", riunioniMefConfig.modificaRiunionetitle());
      	
      	stampaRiunionetxt =  portletPreferences.getValue(
         		"stampaRiunionetxt", riunioniMefConfig.stampaRiunionetxt());
      	
      	stampaRiunionetitle =  portletPreferences.getValue(
         		"stampaRiunionetitle", riunioniMefConfig.stampaRiunionetitle());
      	
    	accettaRiunionetxt =  portletPreferences.getValue(
         		"accettaRiunionetxt", riunioniMefConfig.accettaRiunionetxt());
      	
    	accettaRiunionetitle =  portletPreferences.getValue(
         		"accettaRiunionetitle", riunioniMefConfig.accettaRiunionetitle());
    }
    
    String id_r=null;
    if(request.getAttribute("ID_riunione")!=null){
    	id_r=(String)request.getAttribute("ID_riunione");
    }
    
%>