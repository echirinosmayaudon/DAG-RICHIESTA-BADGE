<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0"   prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui"        prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet"    prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme"      prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui"         prefix="liferay-ui" %>

<%@ page import="mef.richieste.badge.portlet.MefRichiesteBadgeConfig"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<%  MefRichiesteBadgeConfig richiestaMefConfig = (MefRichiesteBadgeConfig) renderRequest.getAttribute(MefRichiesteBadgeConfig.class.getName());
	String formTitle = StringPool.BLANK;
	String formSubtitle = StringPool.BLANK;
	String gestioneUtentiTitle = StringPool.BLANK;
	String gestioneUtentiSubtitle = StringPool.BLANK;
	String servizioProrogaTitle = StringPool.BLANK;
	String servizioProrogaSubtitle = StringPool.BLANK;
	String riepilogoProrogaTitle = StringPool.BLANK;
	String riepilogoProrogaSubtitle = StringPool.BLANK;
	String ricercaTitle = StringPool.BLANK;
	String ricercaSubtitle = StringPool.BLANK;
	String sender = StringPool.BLANK;
	
	String subjectNuova = StringPool.BLANK;
	String subjectModifica = StringPool.BLANK;
	String subjectRichiediModifica = StringPool.BLANK;
	String subjectApprova = StringPool.BLANK;
	String subjectRifiuta = StringPool.BLANK;
	
	String emailReferente = StringPool.BLANK;
	String richiestaTmpl = StringPool.BLANK;
	String itemsPerPage = StringPool.BLANK;
	String itemsPerPageUtenti = StringPool.BLANK;
	
	if (Validator.isNotNull(richiestaMefConfig)){
		  formTitle =  portletPreferences.getValue( "formTitle", String.valueOf(richiestaMefConfig.formTitle()));
		  formSubtitle =  portletPreferences.getValue( "formSubtitle", String.valueOf(richiestaMefConfig.formSubtitle()));
		  gestioneUtentiTitle =  portletPreferences.getValue( "gestioneUtentiTitle", String.valueOf(richiestaMefConfig.gestioneUtentiTitle()));
		  gestioneUtentiSubtitle =  portletPreferences.getValue( "gestioneUtentiSubtitle", String.valueOf(richiestaMefConfig.gestioneUtentiSubtitle()));
		  servizioProrogaTitle =  portletPreferences.getValue("servizioProrogaTitle", String.valueOf(richiestaMefConfig.servizioProrogaTitle()));
		  servizioProrogaSubtitle =  portletPreferences.getValue("servizioProrogaSubtitle", String.valueOf(richiestaMefConfig.servizioProrogaSubtitle()));
		  riepilogoProrogaTitle =  portletPreferences.getValue("riepilogoProrogaTitle", String.valueOf(richiestaMefConfig.riepilogoProrogaTitle()));
		  riepilogoProrogaSubtitle =  portletPreferences.getValue("riepilogoProrogaSubtitle", String.valueOf(richiestaMefConfig.riepilogoProrogaSubtitle()));
		  ricercaTitle =  portletPreferences.getValue( "ricercaTitle", String.valueOf(richiestaMefConfig.ricercaTitle()));
		  ricercaSubtitle =  portletPreferences.getValue( "ricercaSubtitle", String.valueOf(richiestaMefConfig.ricercaSubtitle()));
		  sender =  portletPreferences.getValue( "sender", String.valueOf(richiestaMefConfig.sender()));
		  
		  subjectNuova =  portletPreferences.getValue( "subjectNuova", String.valueOf(richiestaMefConfig.subjectNuova()));
		  subjectModifica =  portletPreferences.getValue( "subjectModifica", String.valueOf(richiestaMefConfig.subjectModifica()));
		  subjectRichiediModifica =  portletPreferences.getValue( "subjectRichiediModifica", String.valueOf(richiestaMefConfig.subjectRichiediModifica()));
		  subjectApprova =  portletPreferences.getValue( "subjectApprova", String.valueOf(richiestaMefConfig.subjectApprovazione()));
		  subjectRifiuta =  portletPreferences.getValue( "subjectRifiuta", String.valueOf(richiestaMefConfig.subjectRifiuta()));
		  
		  richiestaTmpl =  portletPreferences.getValue( "richiestaTmpl", String.valueOf(richiestaMefConfig.richiestaTmpl()));
		  emailReferente =  portletPreferences.getValue( "emailReferente", String.valueOf(richiestaMefConfig.emailReferente()));
		  itemsPerPage =  portletPreferences.getValue( "itemsPerPage", String.valueOf(richiestaMefConfig.itemsPerPage()));
		  itemsPerPageUtenti =  portletPreferences.getValue( "itemsPerPageUtenti", String.valueOf(richiestaMefConfig.itemsPerPageUtenti()));
		  
	}
%>