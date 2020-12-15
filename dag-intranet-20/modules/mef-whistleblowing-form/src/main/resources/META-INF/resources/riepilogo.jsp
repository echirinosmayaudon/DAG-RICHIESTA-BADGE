<%
List<Allegato> allegati = (List<Allegato>) moduloSegnalazione.getAllegati();

int count_allegati = allegati.size();

String descrizione = HtmlUtil.escape((String) request.getAttribute("descrizione"));
String autore = HtmlUtil.escape((String) request.getAttribute("autore"));
String altriTestimoni = HtmlUtil.escape((String) request.getAttribute("altri_testimoni"));
%>

<div class="trasporti-header">
    <div class="ama-container-fluid">
        <div class="ama-row">
            <div class="ama-col-xs-12">
                <div class="title-wrapper">
                    <h2 class="title"><%=recapTitle%>
                    </h2>
                    <p class="subtitle dot-point dot-200"><%=recapSubtitle%></p>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="ama-container-fluid">

    <div class="ama-row">
        <div class="ama-col-md-12">
            <div class="wrapper-title-small">
                <h2 class="title-box borders"><liferay-ui:message key="whistleblowing-riepilogo-title"/></h2>
            </div>
        </div>
    </div>
    <div class="wrapper-riepilogo-whistleblowing">
        <div class="ama-row">
            <div class="ama-col-xs-12 ama-col-md-6">
                <h5 class="title-information"><liferay-ui:message key="whistleblowing-riepilogo-nome-cognome-segnalante"/></h5>
                <p class="text-information"><%=richiedente.getNome_cognome()%></p>
            </div>
            
            <div class="ama-col-xs-12 ama-col-md-6">
                <h5 class="title-information"><liferay-ui:message key="whistleblowing-riepilogo-qualifica"/></h5>
                <p class="text-information"><%=richiedente.getQualifica()%></p>
            </div>
    
        <div class="ama-col-xs-12 ama-col-md-6">
            <h5 class="title-information"><liferay-ui:message key="whistleblowing-riepilogo-struttura-servizio"/></h5>
            <p class="text-information"><%=richiedente.getUfficioRichiedente()%></p>
        </div>
    
        <div class="ama-col-xs-12 ama-col-md-6">
            <h5 class="title-information"><liferay-ui:message key="whistleblowing-riepilogo-tel-cell"/></h5>
            <p class="text-information"><%=richiedente.getTelefono()%></p>
        </div>
        
        <div class="ama-col-xs-12 ama-col-md-6">
            <h5 class="title-information"><liferay-ui:message key="whistleblowing-riepilogo-email"/></h5>
            <p class="text-information"><%=richiedente.getEmail()%></p>
        </div>
    
        <div class="ama-col-xs-12 ama-col-md-6">
            <h5 class="title-information"><liferay-ui:message key="whistleblowing-riepilogo-data-fatto"/></h5>
            <p class="text-information"><%=richiedente.getData_fatto()%></p>
        </div>
    
        <div class="ama-col-xs-12">
            <h5 class="title-information"><liferay-ui:message key="whistleblowing-riepilogo-luogo-fatto"/></h5>
            
            <c:if test="<%=moduloSegnalazione.getUfficio()!=null && !"".equalsIgnoreCase(moduloSegnalazione.getUfficio())%>">
	            <p class="text-information"><liferay-ui:message key="whistleblowing-riepilogo-ufficio"/>: <%=moduloSegnalazione.getUfficio()%></p>
            </c:if>
            
            <c:if test="<%=moduloSegnalazione.getUfficio_esterno()!=null && !"".equalsIgnoreCase(moduloSegnalazione.getUfficio_esterno())%>">
	            <p class="text-information"><liferay-ui:message key="whistleblowing-riepilogo-luogo-esterno"/>: <%=moduloSegnalazione.getUfficio_esterno()%></p>
            </c:if>
            
        </div>
    
        <div class="ama-col-xs-12">
            <h5 class="title-information"><liferay-ui:message key="whistleblowing-riepilogo-azioni-omissioni"/>:</h5>
            
            <c:if test="<%=!moduloSegnalazione.getCheck().isEmpty()%>">
	            <c:forEach items="<%=moduloSegnalazione.getCheck()%>" var="azione_omissione">
	                
	                <%
	                String azione_omissione =(String) pageContext.getAttribute("azione_omissione");
	                
	                if ("altro (specificare)".equalsIgnoreCase(azione_omissione.trim())) {
	                	azione_omissione = azione_omissione + " " + moduloSegnalazione.getAltro();
	                }
	                %>
	                
	                <p class="text-information">- <%=azione_omissione%></p>
	                
	            </c:forEach>
	        </c:if>
        
        </div>
    
        <div class="ama-col-xs-12">
            <h5 class="title-information"><liferay-ui:message key="whistleblowing-riepilogo-descrizione"/></h5>
            <p class="text-information"><%=moduloSegnalazione.getDescrizione()%></p>
        </div>
        
        <div class="ama-col-xs-12">
            <h5 class="title-information"><liferay-ui:message key="whistleblowing-riepilogo-autore"/></h5>
            <p class="text-information"><%=moduloSegnalazione.getAutore()%></p>
        </div>
    
        <div class="ama-col-xs-12">
            <h5 class="title-information"><liferay-ui:message key="whistleblowing-riepilogo-altri-soggetti"/></h5>
            <p class="text-information"><%=moduloSegnalazione.getAltri_soggetti()%></p>
        </div>
    
        </div>
    </div>    
    <div class="wrapper-allegati-general">
        <div class="ama-row">
            <div class="ama-col-md-12">
                <div class="wrapper-title-general">
                    <h2 class="title-box borders"><liferay-ui:message key="whistleblowing-riepilogo-allegati"/></h2>
                </div>
            </div>
        </div>
        <div class="ama-row">
            <div class="ama-col-md-12 mobile-no-padding">
                <div class="wrapper-content">
                    <div class="wrapper-white">
                    	
                    	<c:if test="<%=!moduloSegnalazione.getAllegati().isEmpty()%>">
                    		<c:forEach items="<%=moduloSegnalazione.getAllegati()%>" var="allegato">
                    	
	                        	<p class="text">${allegato.getAllegatoNome()}</p>
                        
                        	</c:forEach>
                    	</c:if>
                    	
                    </div>
                </div>
            </div>
        </div>
        <div class="container-button-allegati">
            <div class="ama-row">
                <div class="ama-col-sm-6">
                    <button href="#" type="reset" class="button button-secondary" onclick="vaiAModifica()"><liferay-ui:message key="whistleblowing-riepilogo-btn-modifica"/></button>
                </div>
                <div class="ama-col-sm-6">
                    <button href="#" type="button" class="button button-primary" onclick="vaiASubmit()"><liferay-ui:message key="whistleblowing-riepilogo-btn-invia"/></button>
                </div>
            </div>
        </div>
    </div>
    
    <portlet:actionURL name="inserisciSegnalazione" var="inserisciSegnalazione">
    			<portlet:param name="DatiSegnalanteSubmit" value="<%=(String)request.getAttribute("jsonSegnalante")%>" />
		    	<portlet:param name="Ufficio" value="<%=moduloSegnalazione.getUfficio()%>" />
		    	<portlet:param name="LuogoEsterno" value="<%=moduloSegnalazione.getUfficio_esterno()%>" />
		    	<portlet:param name="AzioniOmissioni" value="<%=(String)request.getAttribute("azioni_omissioni")%>" />
		    	<portlet:param name="Altro" value="<%=(String)request.getAttribute("input_altro_specificare")%>" />
                <portlet:param name="NumeroDiAllegati" value="<%=String.valueOf(count_allegati)%>" />
    </portlet:actionURL>
    
    <portlet:actionURL name="modificaSegnalazione" var="modificaSegnalazione">
    			<portlet:param name="DatiSegnalanteSubmit" value="<%=(String)request.getAttribute("jsonSegnalante")%>" />
		    	<portlet:param name="Ufficio" value="<%=moduloSegnalazione.getUfficio()%>" />
		    	<portlet:param name="LuogoEsterno" value="<%=moduloSegnalazione.getUfficio_esterno()%>" />
		    	<portlet:param name="AzioniOmissioni" value="<%=(String)request.getAttribute("azioni_omissioni")%>" />
		    	<portlet:param name="Altro" value="<%=(String)request.getAttribute("input_altro_specificare")%>" />
                <portlet:param name="NumeroDiAllegati" value="<%=String.valueOf(count_allegati)%>" />
    </portlet:actionURL>

	<form id="<portlet:namespace/>inviaSegnalazioneFrm" data-parsley-validate="true" method="post" enctype="multipart/form-data" action="<%=inserisciSegnalazione%>">
	   	
                <div id="<portlet:namespace/>divAllegati"></div>
                
	</form>
	
	<form id="<portlet:namespace/>modificaSegnalazioneFrm" data-parsley-validate="true" method="post" enctype="multipart/form-data" action="<%=modificaSegnalazione%>">
	   			
                <div id="<portlet:namespace/>divAllegatiModifica"></div>
                
	</form>
    
</div>    

<script>

var azione;

function generateInputTextArea(azione) {
	
	var inputDescrizione = document.createElement("input");
	var nameInputDescrizione = "<portlet:namespace/>Descrizione";
    $(inputDescrizione).attr("name",nameInputDescrizione);
    $(inputDescrizione).attr("type","hidden");
    $(inputDescrizione).attr("value","<%=descrizione%>");
    
    var inputAutore = document.createElement("input");
	var nameInputAutore = "<portlet:namespace/>Autore";
    $(inputAutore).attr("name",nameInputAutore);
    $(inputAutore).attr("type","hidden");
    $(inputAutore).attr("value","<%=autore%>");
    
    var inputAltriTestimoni = document.createElement("input");
	var nameInputAltriTestimoni = "<portlet:namespace/>AltriTestimoni";
    $(inputAltriTestimoni).attr("name",nameInputAltriTestimoni);
    $(inputAltriTestimoni).attr("type","hidden");
    $(inputAltriTestimoni).attr("value","<%=altriTestimoni%>");
    
    if (azione=="invia") {
	    $("#<portlet:namespace/>divAllegati").append(inputDescrizione); 
	    $("#<portlet:namespace/>divAllegati").append(inputAutore); 
    	$("#<portlet:namespace/>divAllegati").append(inputAltriTestimoni); 
    } else {
	    $("#<portlet:namespace/>divAllegatiModifica").append(inputDescrizione); 
	    $("#<portlet:namespace/>divAllegatiModifica").append(inputAutore); 
    	$("#<portlet:namespace/>divAllegatiModifica").append(inputAltriTestimoni); 
    }
    
}

function generateInputAllegati(azione) {
	
	<% for (int i=1; i <= count_allegati; i++) { %>
	
	var inputAllegato = document.createElement("input");
	var nameAllegato = "<portlet:namespace/>allegato"+<%=i%>;
    $(inputAllegato).attr("name",nameAllegato);
    $(inputAllegato).attr("type","hidden");
    $(inputAllegato).attr("value","<%=allegati.get(i-1).getAllegato().toString()%>");
    
    var inputAllegatoNome = document.createElement("input");
	var nameAllegatoNome = "<portlet:namespace/>allegatoNome"+<%=i%>;
    $(inputAllegatoNome).attr("name",nameAllegatoNome);
    $(inputAllegatoNome).attr("type","hidden");
    $(inputAllegatoNome).attr("value","<%=allegati.get(i-1).getAllegatoNome()%>");
    
    var inputAllegatoMimeType = document.createElement("input");
	var nameAllegatoMimeType = "<portlet:namespace/>allegatoMimeType"+<%=i%>;
    $(inputAllegatoMimeType).attr("name",nameAllegatoMimeType);
    $(inputAllegatoMimeType).attr("type","hidden");
    $(inputAllegatoMimeType).attr("value","<%=allegati.get(i-1).getAllegatoMimeType().toString()%>");
    
    if (azione=="invia") {
	    $("#<portlet:namespace/>divAllegati").append(inputAllegato); 
	    $("#<portlet:namespace/>divAllegati").append(inputAllegatoNome); 
    	$("#<portlet:namespace/>divAllegati").append(inputAllegatoMimeType); 
    } else {
	    $("#<portlet:namespace/>divAllegatiModifica").append(inputAllegato); 
	    $("#<portlet:namespace/>divAllegatiModifica").append(inputAllegatoNome); 
    	$("#<portlet:namespace/>divAllegatiModifica").append(inputAllegatoMimeType); 
    }

	<% } %>
	
}

function vaiASubmit() {
	
	azione = "invia";
	
	generateInputTextArea(azione);
	
	generateInputAllegati(azione);
	
	$("#<portlet:namespace/>inviaSegnalazioneFrm").submit();
}

function vaiAModifica() {
	
	azione = "modifica";
	
	generateInputTextArea(azione);
	
	generateInputAllegati(azione);
	
	$("#<portlet:namespace/>modificaSegnalazioneFrm").submit();
}
</script>