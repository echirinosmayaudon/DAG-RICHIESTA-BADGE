<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.Riunione"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.RiunioneLocalServiceUtil"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@page import="com.intranet.mef.gestione.riunioni.model.StatoInvitato"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.StatoInvitatoLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.InvitatiRiunione"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.InvitatiRiunioneLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.RiunioneLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.StatoRiunioneLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.LuogoLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.TipoRiunioneLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.AmministrazioneConvocanteLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.mef.ricercariunione.stub.Partecipante"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.liferay.portal.kernel.model.User"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>


<div class="gestione-riunioni-title-box">
        <div class="ama-container-fluid">
            <div class="ama-row">
                <div class="ama-col-xs-12">
                    <div class="title-wrapper">
                        <h2 class="title"><%=accettaRiunionetitle%></h2>
                        <p class="subtitle dot-point dot-200"><%=accettaRiunionetxt%></p>
                    </div>
                </div>
            </div>
        </div>
    </div>

<%
				
String abilitato = (String) request.getAttribute("utenteAbilitato");
if (abilitato!=null && abilitato.equalsIgnoreCase("true")){


String idRiunioneByMail = request.getParameter("idRiunione");
String idSegreteriaByMail = request.getParameter("idSegreteria");
String obj ="";
long idStatoRiu=0;
String labelStatoRiu ="";
long tipoRiu =0;
String labelTipoRiu ="";
String dat="";
String luog="";
String admin="";
Riunione riun=null;
String prot="";
String note ="";
if (idRiunioneByMail!=null ){
	riun = RiunioneLocalServiceUtil.getRiunione(Long.parseLong(idRiunioneByMail));
	obj = riun.getOggetto();
	idStatoRiu = riun.getId_stato_riunione();
	labelStatoRiu = (StatoRiunioneLocalServiceUtil.getStatoRiunione(idStatoRiu)).getLabel();
	tipoRiu = riun.getId_tipo();
	labelTipoRiu = "";
	if(tipoRiu>0){
		labelTipoRiu=(TipoRiunioneLocalServiceUtil.getTipoRiunione(tipoRiu)).getDescrizione();
	}
	dat =  riun.getData_inizio().toString();
	SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdfOra = new SimpleDateFormat("HH:mm");
	Date dataR = riun.getData_inizio();
	 luog= (LuogoLocalServiceUtil.getLuogo(riun.getId_luogo())).getNome();
	admin = (AmministrazioneConvocanteLocalServiceUtil.getAmministrazioneConvocante(riun.getId_amministrazione_convocante())).getNome_amministrazione();
	prot = riun.getProtocollo();
	note = riun.getNote();
	
	String noteRiunione =(String)request.getAttribute("noteRiunione");
	Boolean flagEdit = (Boolean)request.getAttribute("flagEdit");
	Boolean flagAccettato = (Boolean)request.getAttribute("flagAccettato");
	List<Partecipante> boxPartecipanti =(List<Partecipante>)request.getAttribute("partecipantiInvitati");

		
	List<Partecipante> listPartecipanti =  (List<Partecipante>)request.getAttribute("partecipanti");
	
%>

<div class="ama-container-fluid">
			
        <div class="ama-row">
        
        <div class="ama-col-xs-12">
                <div class="page-title-wrapper">
                    <div class="title-wrapper">
                        <div class="ama-row">
                        <div class="ama-col-xs-12">
                        <h2 class="title"><%=obj.toUpperCase()%></h2>
                        </div>
                        <div class="ama-col-xs-12 mt-40-xs mt-0-md pt-10-xs text-right text-center-mobile">
                            <span class="label-riunioni-state"><span class="label-icon icomoon-meeting"></span><%=labelStatoRiu.toUpperCase()%></span>
                             <c:if test="<%= !labelTipoRiu.equals("")%>">
								<span class="label-riunioni-state ml-20-xs"><%=labelTipoRiu.toUpperCase()%></span>
                              </c:if>
						</div>
                        </div>
                    </div>
                </div>            
                
                </div>
        
            <div class="ama-col-xs-12">
                <div class="gestione-riunioni-wrapper pb-40-xs">
                    <div class="gestione-riunioni-dettaglio">
                        <div class="container-info-riunioni">
                            <div class="wrapper-info-riunioni">
                                <div class="ama-row"> 
                                    <div class="ama-col-sm-3 ama-col-xs-6 text-left"><span class="icomoon-calendar-date"></span><span class="text-bold mobile-hidden">
									<liferay-ui:message key="gestione-riunione-conferma-invito-data"/>:</span><span>&nbsp;<%=sdfData.format(dataR)%></span></div>
                                    <div class="ama-col-sm-3 ama-col-xs-6 mobile-text-right"><span class="icomoon-time"></span><span class="text-bold mobile-hidden">&nbsp;
									<liferay-ui:message key="gestione-riunione-conferma-invito-data"/>:</span><span>&nbsp;<%=sdfOra.format(dataR)%></span></div>
                                    <div class="ama-col-sm-6 ama-col-xs-12 text-right mobile-text-center mt-20-xs mt-0-md"><span class="icomoon-pin"></span><span class="text-bold">&nbsp;
									<liferay-ui:message key="gestione-riunione-conferma-invito-luogo"/>:</span><span>&nbsp;<%=luog%></span></div>
                                </div>
                            </div>
                            <div class="wrapper-info-riunioni bg-white">
                                <div class="ama-row">
                                   <div class="ama-col-xs-12 mobile-text-center"><span class="text-bold">
									<liferay-ui:message key="gestione-riunione-conferma-invito-amministrazione-convocante"/> </span><span><%=admin.toUpperCase()%></span></div>
                                  <div class="ama-col-xs-12 mobile-text-center">
                    <c:if test="<%=!prot.isEmpty()%>">
                              <span class="text-bold"><liferay-ui:message key="gestione-riunione-conferma-invito-protocollo"/> </span><span><%=prot%></span>
                              </c:if>
                              </div>
                                </div>
                            </div>
                        </div>       
                         <div class="container-box mb-10-xs">
                          <span class="span-bold"><liferay-ui:message key="gestione-riunione-conferma-invito-note"/></span>                                   
                                           
                        <div class="container-box box-bg-white mobile-text-center">
                        <c:if test="<%=!note.isEmpty()%>">
                                   <span><%=note%></span>
                                   </c:if></div>
                                   </div>
                    </div>
                </div>            </div>
			   <c:choose>
			   <c:when test="<%=flagEdit%>">
			   
			   <portlet:actionURL var="rispostaInvitoRiunioneURL" name="rispostaInvitoRiunione">
               <portlet:param name="idSegreteria" value="<%=idSegreteriaByMail%>"/>
               <portlet:param name="idRiunione" value="<%=idRiunioneByMail%>"/>
                 </portlet:actionURL>
      <form action="<%=rispostaInvitoRiunioneURL%>" method="POST" id="saveForm" enctype="multipart/form-data">
            <div class="ama-col-xs-12 mobile-no-padding">
                <div class="tab-filtri filtro-categoria">
                    <div class="filtro-tabs-wrapper mt-0-xs">
                        <span class="tab-title active">
						<liferay-ui:message key="gestione-riunione-conferma-invito-partecipanti"/>
						</span>
                    </div>
                </div>
                <div class="ama-col-xs-12 box-tab-invitati mobile-no-padding">
                    <div class="ama-col-md-3 ama-col-sm-4">
                        <div class="invitati-selection-container">
                            <div class="invitati-selection-header">
                                <span class="header-text"><liferay-ui:message key="gestione-riunione-conferma-invito-select-partecipanti"/></span>
                            </div>
                            <div class="invitati-selection-body">
                                <div class="selection-item-container tab-invitati">
                                                        <div class="wrapper-input-search-riunioni">
                                                        
                                                        <input id="<portlet:namespace/>ricerca"  class="text-search-input" type="text" placeholder="<liferay-ui:message key="gestione-riunione-conferma-invito-search"/>" onkeyup="getSuggestions(this,event)" name="<portlet:namespace/>ricerca">
                                                        <span class="icomoon-search ico-search"></span>
                                                    	
                                                    </div>
								<div id="partecipantiBoxCheck" class="wrapper-div-container-item">
									
								</div>
                                   
									
                                </div>
                                                     
                            </div>
                            <div class="invitati-selection-footer">
                               <button type="button" class="button button-primary" onclick="addInvite('.checkbox-custom')" id="catsubmbtn">
								<liferay-ui:message key="gestione-riunione-conferma-invito-aggiungi"/>
							   </button>
                            </div>
                        </div>
                    </div>
                    <div class="ama-col-md-9 ama-col-sm-8 invitati-item-selected-wrap mobile-no-padding" id="partecipantiBox">
					
                                  
                        
                    </div>
                </div>
            </div>
            <div class="ama-col-xs-12">
                <div class="gestione-riunioni-wrapper pt-0-xs pb-40-xs">
                    <div class="gestione-riunioni-dettaglio">
                        <div class="container-box mb-10-xs"><span class="span-bold"><liferay-ui:message key="gestione-riunione-conferma-invito-commenti"/></span></div>
                         <div class="wrapper-content-textarea">
								<textarea class="form-control textarea-custom-light" id="commento"
								data-parsley-maxlength="4000" 
							data-parsley-maxlength-message='<liferay-ui:message key="error-maxlength-char-message" arguments="<%=new String[]{\"4000\"}%>"/>'								
								name="<portlet:namespace/>Commenti"
								placeholder='<liferay-ui:message key="gestione-riunione-conferma-invito-commenti-placeholder"/> ...' ><%=noteRiunione%></textarea>
							
						</div> 
                    </div>
                </div>
            </div>
			
            <div class="ama-col-xs-12 container-button-form-notice pb-100-xs">
                <div class="ama-col-sm-4 text-right">
                    <button  type="button" onclick="resetForm();" class="button button-secondary"><liferay-ui:message key="gestione-riunione-conferma-invito-annulla"/></button>
                </div>
					<div class="ama-col-sm-4 text-center">
						<button  onclick="saveReject()" type="button" class="button button-primary"><liferay-ui:message key="gestione-riunione-conferma-invito-rifiuta"/></button>
					</div>
					<c:if test="<%= !flagAccettato%>">
					<div class="ama-col-sm-4">
						<button  onclick="saveAccept()" type="button" class="button button-primary"><liferay-ui:message key="gestione-riunione-conferma-invito-accetta"/></button>
					</div>
				</c:if>
				<c:if test="<%=flagAccettato%>">
					<div class="ama-col-sm-4">
						<button  onclick="saveAccept()" type="button" class="button button-primary"><liferay-ui:message key="gestione-riunione-conferma-invito-modifica"/></button>
					</div>
				</c:if>

                        <input type="hidden" id="<portlet:namespace/>listPartecipantiBox" name="<portlet:namespace/>savePartecipanti" >
<input type="hidden" id="responseInvite" name="<portlet:namespace/>responseInvite" >

            </div>
                  </form>
				  </c:when>
				  <c:otherwise>
			
			  <div class="ama-col-xs-12">
                <div class="gestione-riunioni-wrapper pt-0-xs pb-40-xs">
                    <div class="gestione-riunioni-dettaglio">
                        <div class="container-box mb-10-xs"><span class="span-bold"><liferay-ui:message key="gestione-riunione-conferma-invito-commenti"/></span></div>
                        <div class="container-box box-bg-white mobile-text-center">
                            <span><%=noteRiunione%></span>
                        </div>
						</div>
						</div>
					</div>
					
						
			    
          
				  
				  </c:otherwise>
				  </c:choose>
        </div>
    </div>
	
<script type="text/javascript"> 


      var flagEdit = "<%=flagEdit%>";
 if (flagEdit == "true") {
    
     partecipantiBoxDiv = "#partecipantiBox"; 
     partecipantiBoxCheckDiv = "#partecipantiBoxCheck";

     var arrayPartecipantiBox; 
     var arrayPartecipantiCheck; 
     var arrayPartecipantiCheckConstant;

     resetForm(); 

	 
    
	 
	 
     function resetForm() {

         document.getElementById("saveForm").reset(); 
          
         arrayPartecipantiBox = new Array(<%
												   for(int i = 0; i < boxPartecipanti.size(); i++) {
																	  out.print(boxPartecipanti.get(i).toJSON());
																	 if(i+1 < boxPartecipanti.size()) {
																	   out.print(",");
																	 }
																   }              
                                               %>);
         
         arrayPartecipantiCheckConstant = new Array(<%
                                                               for(int i = 0; i < listPartecipanti.size(); i++) {
                                                                  out.print(listPartecipanti.get(i).toJSON());
                                                                 if(i+1 < listPartecipanti.size()) {
                                                                   out.print(",");
                                                                 }
                                                               }              
                               %>);

         arrayPartecipantiCheck = arrayPartecipantiCheckConstant.slice();


         updateHTML(); 


     }

     function findElement(arr, propName, propValue) {
         for (var i = 0; i < arr.length; i++)
             if (arr[i][propName] == propValue)
                 return i;
         return -1;
     }

     
     function addInvite(classCheckbox) {


         $(classCheckbox).each(function() {

             if ($(this).is(":Checked")) {

                 arrayPartecipantiBox.push(JSON.parse($(this).val()));
                 arrayPartecipantiBox.sort(function(a, b) {
                     if (a.cognome < b.cognome) return -1;
                     if (a.cognome > b.cognome) return 1;
                     if (a.nome < b.nome) return -1;
                     if (a.nome > b.nome) return 1;
                     return 0;
                 });
                 var index = findElement(arrayPartecipantiCheck, "id", JSON.parse($(this).val()).id);


                 arrayPartecipantiCheck.splice(index, 1);
                 index = findElement(arrayPartecipantiCheckConstant, "id", JSON.parse($(this).val()).id);

                 arrayPartecipantiCheckConstant.splice(index, 1);
                 updateHTML();
             }
         });



     }
    
     function deleteInvite(index, item) {
         event.preventDefault();
         arrayPartecipantiCheck.push(item);

         arrayPartecipantiCheckConstant.push(item);
         arrayPartecipantiCheck.sort(function(a, b) {
             if (a.cognome < b.cognome) return -1;
             if (a.cognome > b.cognome) return 1;
             if (a.nome < b.nome) return -1;
             if (a.nome > b.nome) return 1;
             return 0;
         });

         arrayPartecipantiBox.splice(index, 1);
         updateHTML();
     }

    
     function updateHTML() {
         $(partecipantiBoxCheckDiv).empty();
         $(partecipantiBoxDiv).empty();


         
         arrayPartecipantiCheck.forEach(addSegreterieHTML, {
             type: "checkbox",
             divMaster: partecipantiBoxCheckDiv
         });
        
         arrayPartecipantiBox.forEach(addInvitatiHTML, {
             divMaster: partecipantiBoxDiv
         });


     }

     function addInvitatiHTML(item, index, arr) {
		
		var divContainer = document.createElement("div");
		$(divContainer).addClass('ama-col-md-4 ama-col-sm-6 invitati-item-container');

		 var divItem = document.createElement("div");
		 $(divItem).addClass('invitati-item text-center');


        
         var input = document.createElement("input");
         $(input).attr("type", "hidden");
         $(input).attr("value", item.id);


         var spanImage = document.createElement("span");
         $(spanImage).addClass('partecipanti-avatar');
         $(spanImage).attr("href", "#");
         
         $(spanImage).attr("style", "background-image:url(" + item.imagePath + ")");



         var pNomeInvitato = document.createElement("p");
         $(pNomeInvitato).addClass('partecipanti-name');
         $(pNomeInvitato).text(item.nome + " " + item.cognome);


         var aClose = document.createElement("a");
         $(aClose).attr('href', '');
         $(aClose).addClass('icomoon-close-white');

         $(aClose).click(function() {
             deleteInvite(index, item);
         });

         $(divItem).append(spanImage);
         $(divItem).append(pNomeInvitato);
         $(divItem).append(aClose);
         $(divItem).append(input);
         $(divContainer).append(divItem);


         if ($(this.divMaster) != null) {
             $(this.divMaster).append(divContainer);
         } else {}

     }

     
     function addSegreterieHTML(item, index, arr) {

         var div = document.createElement("div");
         $(div).addClass('checkbox-invitati');

         var label = document.createElement("label");
         $(label).addClass('selection-item');
         label.innerHTML = ' <span class="item-name">' + item.nome + ' ' + item.cognome + '</span><span class="icomoon-riunione-ok item-icon"></span>';

         var input = document.createElement("input");
         if ($(this.type) != null) {
             $(input).attr("type", this.type);
         } else {
             $(input).attr("type", "checkbox");
         }
         $(input).attr("id", index);
         $(input).val(JSON.stringify(item));
         $(input).addClass('checkbox-custom').appendTo(div);
         $(label).attr("for", index);
         $(div).append(label);

         if ($(this.divMaster) != null) {
             $(this.divMaster).append(div);
         } else {}



     }


     function saveAccept() {

         json = {
             "partecipantiBox": arrayPartecipantiBox
         };
         $("#<portlet:namespace/>listPartecipantiBox").val(JSON.stringify(json));
		$("#commento").val($("#commento").val().trim());
         $("#responseInvite").val("ACCETTA");
         $("#saveForm").submit();

     }

     function saveReject() {

         json = {
             "partecipantiBox": arrayPartecipantiBox
         };
         $("#<portlet:namespace/>listPartecipantiBox").val(JSON.stringify(json));

         $("#responseInvite").val("RIFIUTA");
         $("#saveForm").submit();

     }
	  function getSuggestions(element, e) {
		 var inputValueId = "#" +element.id;
		 var inputElementName = element.name;
		 var inputValue = $(inputValueId).val();
		 arrayPartecipantiCheck = arrayPartecipantiCheckConstant.filter(function(item){ return item.cognome.toUpperCase().startsWith(inputValue.toUpperCase()) || item.nome.toUpperCase().startsWith(inputValue.toUpperCase()) ||
			 (inputValue.length > 0 && inputValue.length > item.cognome.length && inputValue.substring(0, item.cognome.length).toUpperCase() == item.cognome.toUpperCase() && item.nome.toUpperCase().startsWith(inputValue.substring(item.cognome.length + 1).toUpperCase())) ||
		 (inputValue.length > 0 && inputValue.length > item.nome.length && inputValue.substring(0, item.nome.length).toUpperCase() == item.nome.toUpperCase() && item.cognome.toUpperCase().startsWith(inputValue.substring(item.nome.length + 1).toUpperCase()))});

		 updateHTML();

		}
 }




</script>

<%}
}else{%>
	

	


<div class="ama-container-fluid">
        <div class="ama-row">
        
        <div class="ama-col-xs-12">
                <div class="page-title-wrapper">
                    <div class="title-wrapper">
                        <div class="ama-row">
                        <div class="ama-col-md-7 ama-col-xs-12">
                        <h2 class="title"><liferay-ui:message key="gestione-riunione-conferma-invito-utente-non-abilitato" />:</span> </h2>
                        </div>
                        <div class="ama-col-md-5 ama-col-xs-12 mt-40-xs mt-0-md text-right text-center-mobile">
                            <span class="label-riunioni-state ml-20-xs"><liferay-ui:message key="gestione-riunione-conferma-invito-utente-non-abilitato-message" />.</span>
							
				
                        </div>
						<div class="ama-col-sm-4 text-center">
							<a href="<%= PortalUtil.getPortalURL(request) %>/c/portal/logout"><button  type="button" class="button button-primary">Log Out</button>
						</a>
						</div>
                        </div>
                    </div>
                </div>            
                                </div>
                </div>

                </div>

<%} %>