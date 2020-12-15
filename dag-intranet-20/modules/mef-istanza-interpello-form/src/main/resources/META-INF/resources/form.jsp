<%@ include file="/init.jsp" %>

<%@ page import="com.accenture.mef.istanza.interpello.form.bean.Richiedente" %>
<%@ page import="com.accenture.mef.istanza.interpello.form.bean.ModuloRichiesta" %>
<%@ page import="com.accenture.istanza.interpello.service.TextRichLocalServiceUtil" %>
<%@ page import="com.accenture.istanza.interpello.model.TextRich" %>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>

<%
	Log _log = LogFactoryUtil.getLog("form_jsp");
	
	Richiedente richiedente = null;
	if(request.getAttribute("richiedente")!=null) 
		richiedente = (Richiedente) request.getAttribute("richiedente");
	
	ModuloRichiesta moduloRichiesta = null;
	if(request.getAttribute("moduloRichiesta")!=null) 
		moduloRichiesta = (ModuloRichiesta) request.getAttribute("moduloRichiesta");
	
	TextRich conseguenze = TextRichLocalServiceUtil.getTextByLabel("conseguenze civili/penali");
	TextRich dichiarazione = TextRichLocalServiceUtil.getTextByLabel("dichiarazione");
	TextRich requisiti = TextRichLocalServiceUtil.getTextByLabel("requisiti");
	String[] requisitiList = requisiti.getTesto_text().split(Pattern.quote("|"));
	TextRich funzionidirigenziali = TextRichLocalServiceUtil.getTextByLabel("funzioni dirigenziali");
%>
<portlet:actionURL var="vaiARiepilogo" name="vaiARiepilogo"/> 
   
<div class="trasporti-header">
         <div class="ama-container-fluid">
             <div class="ama-row">
                 <div class="ama-col-xs-12">
                     <div class="title-wrapper">
                         <h2 class="title"><%=formTitle%></h2>
                         <p class="subtitle dot-point dot-200"><%=formSubTitle%></p>
                     </div>
                 </div>
             </div>
         </div>
     </div>
        <div class="ama-container-fluid">
		<form id="<portlet:namespace/>form1" data-parsley-validate="true" method="post" enctype="multipart/form-data" action="<%=vaiARiepilogo%>" >
            <div class="ama-row">
                <div class="ama-col-md-12">
                    <div class="wrapper-title-small title-data-agile">
                        <h2 class="title-box borders"><liferay-ui:message key="interpello-form-dati-richiedente"/></h2>
                    </div>
                </div>
            </div>
            <div class="ama-row">
                <div class="ama-col-xs-12 mobile-no-padding">
                    <div class="form-request mobile-no-padding">
                        <div class="box-gray">
                            <div class=" box-white pb-0-xs">
                                <p class="name"><%=richiedente.getNome()%> <%=richiedente.getCognome()%></p>
                                <span class="vedi-dark icomoon-vedi-dark hidden-lg hidden-md hidden-sm" data-toggle="collapse" data-target="#collapse-trasporti" data-parent="#accordion"></span>
                                <div id="collapse-trasporti" class="collapse1 in no-overflow">
                                <div class="ama-row border-section border-mobile">
                                      <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
                                        <span class="section-information"><liferay-ui:message key="interpello-luogo-nascita"/>:</span>
                                        <p class="info"><%=richiedente.getLuogoNascita()%></p>
                                    </div>
                                   <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
                                        <span class="section-information"><liferay-ui:message key="interpello-data-nascita"/>:</span>
                                        <p class="info"><%=richiedente.getDataNascita()%></p>
                                    </div>
                                   <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
                                        <span class="section-information"><liferay-ui:message key="interpello-codice-fiscale"/>:</span>
                                        <p class="info"><%=richiedente.getCodiceFiscale().toUpperCase()%></p>
                                    </div>
                                </div>
                                <p class="name-section"><liferay-ui:message key="interpello-residenza-section"/></p>
                                <div class="ama-row border-section">
                                     <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
                                        <span class="section-information"><liferay-ui:message key="interpello-indirizzo"/>:</span>
                                        <p class="info"><%=richiedente.getResidenzaIndirizzo()%></p>
                                    </div>
            
                                     <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
                                        <span class="section-information"><liferay-ui:message key="interpello-citta"/>:</span>
                                        <p class="info"><%=richiedente.getResidenzaCitta()%></p>
                                    </div>
                                </div>
                                <p class="name-section"><liferay-ui:message key="interpello-assegnazione-section"/></p>
								<div class="ama-row">
									<div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
										<span class="section-information"><liferay-ui:message key="interpello-dipartimento"/>:</span>
										<p class="info"><%=richiedente.getDipartimento()%></p>
									</div>
									<div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
										<span class="section-information"><liferay-ui:message key="interpello-direzione"/>:</span>
										<p class="info"><%=richiedente.getDirezione()%></p>
									</div>
									<div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
										<span class="section-information"><liferay-ui:message key="interpello-ufficio"/>:</span>
										<p class="info"><%=richiedente.getUfficio()%></p>
									</div>
								</div>
								<div class="ama-row">
									 <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
										<span class="section-information"><liferay-ui:message key="interpello-email"/>:</span>
										<p class="info"><%=richiedente.getMail()%></p>
									</div>
									 <div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
										<span class="section-information"><liferay-ui:message key="interpello-area"/>:</span>
										<p class="info"><%=richiedente.getArea()%></p>
									</div>
									<div class="ama-col-md-4 ama-col-sm-6 mb-20-xs">
										<span class="section-information"><liferay-ui:message key="interpello-fascia-retributiva"/>:</span>
										<p class="info"><%=richiedente.getFasciaRetributiva()%></p>
									</div>
								</div>
							</div>
                        </div>
                    </div>
                    </div>
                </div>
            </div>
            <div class="ama-row">
                <div class="ama-col-md-12">
                    <div class="wrapper-title-small title-request-agile">
                        <h2 class="title-box borders"><liferay-ui:message key="interpello-form-richiesta"/></h2>
                    </div>
                </div>
            </div>
			<div class="ama-row">
                <div class="ama-col-xs-12 mobile-no-padding">
                    <div class="form-request mobile-no-padding">
                        <div class="box-gray">
                            <div class=" box-white pb-0-xs">
								<p class="copy-text blue-color mb-20-xs"><strong>(*) <liferay-ui:message key="interpello-form-campo-obbligatorio"/></strong></p> 
                                 <div class="mt-20-xs mb-20-xs">
                                    <p class="copy-text blue-color"><%=conseguenze.getTesto_text()%></p>
                                </div>
                                  <div class="ama-row mb-20-xs">
                                       
                                        <div class="ama-col-xs-12 text-center">
                                            <p class="copy-text blue-color"><strong><liferay-ui:message key="interpello-dichiara"/></strong></p>
                                        </div>
                                    </div>
                                    <div class="ama-row">
                                        <div class="ama-col-xs-12">
                                            <div class="checkbox-blue long-test-checkbox">
                                                <div class="squaredOne">
                                                    <input type="checkbox" 
                                                           value="dichiaraz1" 
                                                    	   data-parsley-required="true"
                                                    	   data-parsley-required-message="<liferay-ui:message key="interpello-form-required-error-msg"/>"
                                                    	   data-parsley-errors-container=".errorDichiarazione"
                                                    	   id="dichiaraz1"
                                                    	   name="dichiaraz-check"
                                                    	   class="data-parsley-validated">
                                                    <label for="dichiaraz1"></label>
                                                </div>
                                                <div class="text-check ml-15-md ml-15-xs custom-label">
                                                   <%=dichiarazione.getTesto_text()%>*                                                    
                                                </div>
											    <c:forEach items="<%=requisitiList%>" var="requisito">
											        <div class="text-check ml-15-md ml-15-xs custom-label">
											        	${requisito}
                                                	</div>
											    </c:forEach>
											    <div class="errorDichiarazione"></div></br>
                                            </div>
                                        </div>
                                    </div>
                                    <p class="mb-25-xs pl-10-xs pr-10-xs"><em><%=funzionidirigenziali.getTesto_text()%></em></p>
                               </div>
                            </div>
                        </div>
                    </div>
                </div>
            <div class="wrapper-allegati-general">
                <div class="container-button-general-allegati">
                    <div class="ama-row">
                        <div class="ama-col-sm-12">
                            <button type="button" onclick="formSubmit()" class="button button-primary margin-top"><liferay-ui:message key="interpello-form-btn-prosegui"/></button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
</div>       
        
<script type="text/javascript">

function formSubmit(){
	 $("#<portlet:namespace/>form1").parsley().validate();
	 var isValidForm = $("#<portlet:namespace/>form1").parsley().isValid();
		 if(isValidForm) {
			$("#<portlet:namespace/>form1").submit();
		 }
}

</script>