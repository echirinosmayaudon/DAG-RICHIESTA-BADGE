<%@page import="javax.xml.bind.JAXBElement"%>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui" %> 
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.journal.util.impl.JournalContentImpl"%>
<%@page import="com.liferay.journal.model.JournalArticleDisplay"%>
<%@page import="com.liferay.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.journal.model.JournalArticle"%>
<%@page import="it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioVO"%>
<%@page import="it.intranetdag.rubrica.services.vo.xsd.AnagraficaVO"%>
<%@page import="it.intranetdag.rubrica.services.vo.xsd.StrutturaInternaVO"%>
<%@page import="com.mef.intranet.rubrica.stub.Struttura"%>
<%@page import="com.mef.intranet.rubrica.service.SearchDataLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>




<%
String struttura1="";
AnagraficaUfficioVO uff=null;
String id_uff= null;
if(request.getParameter("id_ufficio")!=null) {
	id_uff=(String)request.getParameter("id_ufficio");
}
else if(request.getParameter("codStruttura")!=null) {
	id_uff=(String)request.getParameter("codStruttura");
}
List<AnagraficaUfficioVO> list_uff;
if(id_uff!=null){
list_uff=SearchDataLocalServiceUtil.servDettagliUfficio(id_uff);
uff=list_uff.get(0);


List<Struttura> list_strutt=(ArrayList<Struttura>)request.getAttribute("listaStrutture");
String codStrutt1=uff.getLiv1().getValue();
if(request.getAttribute("listaStrutture")!=null){

for(Struttura s:list_strutt){
	if(codStrutt1.equals(s.getId_struttura())){
		struttura1=s.getNome_struttura();
	}
}

}
}
String article = null;
try{
JournalArticle journalArticle = JournalArticleLocalServiceUtil.getDisplayArticleByUrlTitle(themeDisplay.getScopeGroupId(), ("Office_"+id_uff).toLowerCase());

JournalArticleDisplay articleDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(themeDisplay.getScopeGroupId(), journalArticle.getArticleId(), WebKeys.JOURNAL_ARTICLE_DISPLAY, themeDisplay.getLanguageId(), themeDisplay);
article = articleDisplay.getContent();
}catch(PortalException e){
	article = null;
}

User utente = themeDisplay.getUser();
boolean amministratore = false;
for (Role ruolo : user.getRoles()) {
	if (ruolo.getName().equalsIgnoreCase("ADMINISTRATOR")) {
		amministratore = true;
	}
}
String roleAdministrator = null;
if (amministratore == true) {
	roleAdministrator = "Administrator";
}
else {
	roleAdministrator = "Not Administrator";
}

//ottengo il team dall'id ufficio
List <AnagraficaVO> teamByCodStrutt= new ArrayList<AnagraficaVO>();
teamByCodStrutt = SearchDataLocalServiceUtil.getPersoneByCodStrut(id_uff);


//controllo se l'utente è loggato e se appartiene al team dell'ufficio
boolean belongToTeam = false;
for (AnagraficaVO personaTeam : teamByCodStrutt) {
	if (utente.getEmailAddress().equalsIgnoreCase(personaTeam.getEmailAddress().getValue())) {
		belongToTeam = true;
	}
}
%>
<%-- <liferay-ui:journal-article articleId="<%= journalArticle.getArticleId()%>" groupId="<%= themeDisplay.getScopeGroupId()%>"/> --%>


<c:if test="<%=article!=null%>">
<%=article%>
</c:if>

<c:if test="<%= article==null%>">
<c:set var="ufficio" value="<%=uff%>"/>
<c:set var="dirigente" value="${ufficio.getDirigente().getValue()}"/>
<%
AnagraficaVO dirigenteVO = (AnagraficaVO) pageContext.getAttribute("dirigente");
User dirigente = UserLocalServiceUtil.fetchUserByEmailAddress(themeDisplay.getCompanyId(), dirigenteVO.getEmailAddress().getValue());
String avatar = themeDisplay.getPathImage()+"/user_male_portrait?img_id=0";
if (dirigente!=null) {
	avatar = dirigente.getPortraitURL(themeDisplay);
}
List<AnagraficaVO> lista_dirigente=new ArrayList<>(0);
AnagraficaVO dirig_dettagl=null;
if(dirigenteVO.getFirstName().getValue()!=null && dirigenteVO.getFirstName().getValue()!="" && dirigenteVO.getLastName().getValue()!=null && dirigenteVO.getLastName().getValue()!="" && dirigenteVO.getIncarico().getValue()!=null && dirigenteVO.getIncarico().getValue()!=""){
lista_dirigente=SearchDataLocalServiceUtil.getListPersone(null, null, dirigenteVO.getFirstName().getValue(), dirigenteVO.getIncarico().getValue(), dirigenteVO.getLastName().getValue(), null, null, id_uff);

if(lista_dirigente!=null)
dirig_dettagl=lista_dirigente.get(0);
}
%>

<div class="rubrica-scheda-ufficio-dettaglio">
        <div class="ama-container-fluid">
            <div class="ama-row">
                <div class="ama-col-xs-12">
                    <h2 class="office-name">${ufficio.getDescrizione().getValue()}<br></h2>
                </div>
            </div>
                <div class="ama-col-xs-12 mobile-no-padding">
                    <div class="ama-col-xs-12 scheda-ufficio-dettaglio">
                        <div class="ama-col-xs-12 scheda-ufficio-dettaglio-content">
                            <div class="ama-col-sm-5 ama-col-xs-12 pb-20-xs border-right-box">
                                <h2 class="scheda-ufficio-title mb-15-xs"><liferay-ui:message key="rubrica-info-dirigente"/></h2>
                                <div class="avatar-wrap">
                                    <span class="scheda-ufficio-avatar" style="background-image: url(<%=avatar%>);"></span>
                                </div>
                                <span class="scheda-ufficio-labels">    
                                      <c:if test="<%=dirig_dettagl!=null%>">
                                    <h2 class="dirigente-name"> <%=dirig_dettagl.getFirstName().getValue()%> <%=dirig_dettagl.getLastName().getValue()%>
                                    </h2>
                                    <h2 class="dirigente-role mt-5-xs"><%=dirig_dettagl.getIncarico().getValue()%></h2>
                                    <div class="divider"></div>
                                    <h2 class="dirigente-info-generic mt-15-xs">email:  <a href="mailto:<%=dirig_dettagl.getEmailAddress().getValue()%>" class="info mb-20-xs"><%=dirig_dettagl.getEmailAddress().getValue()%></a></h2>
                                      <h2 class="dirigente-info-generic mt-10-xs">telefono: <%=dirig_dettagl.getTelUffi1().getValue()%> <%=dirig_dettagl.getTelUffi2().getValue()%> <%=dirig_dettagl.getTelefono().getValue()%></h2>
                                    <h2 class="dirigente-info-generic mt-10-xs">cell: <%=dirig_dettagl.getCellulare().getValue()%></h2>
                                    <h2 class="dirigente-info-generic mt-10-xs">fax: <%=dirig_dettagl.getFax().getValue()%></h2>
                                  </c:if>
                                   <c:if test="<%=dirig_dettagl==null%>">
                                    <h2 class="dirigente-name">${dirigente.getFirstName().getValue()} ${dirigente.getLastName().getValue()}</h2>
                                    <h2 class="dirigente-role mt-5-xs">${dirigente.getIncarico().getValue()}</h2>
                                    <div class="divider"></div>
                                    <h2 class="dirigente-info-generic mt-15-xs">email:  <a href="mailto:${dirigente.getEmailAddress().getValue()}" class="info mb-20-xs">${dirigente.getEmailAddress().getValue()}</a></h2>
                                    <h2 class="dirigente-info-generic mt-10-xs">telefono: ${dirigente.getTelUffi1().getValue()} ${dirigente.getTelUffi2().getValue()} ${dirigente.getTelefono().getValue()}</h2>
                                    <h2 class="dirigente-info-generic mt-10-xs">cell: ${dirigente.getCellulare().getValue()}</h2>
                                    <h2 class="dirigente-info-generic mt-10-xs">fax: ${dirigente.getFax().getValue()}</h2>
                                  </c:if>
                                </span>
                            </div>
                              <%AnagraficaUfficioVO ufficio=(AnagraficaUfficioVO)pageContext.getAttribute("ufficio");%>
                            <c:if test="<%=ufficio.getDescr().getValue()!=null && !ufficio.getDescr().getValue().equals("")%>">
                            
                            <div class="ama-col-sm-7 ama-col-xs-12 pl-35-sm">
                                <h2 class="scheda-ufficio-title mb-15-xs mt-25-xs mt-0-sm"><liferay-ui:message key="rubrica-competenze"/></h2>
                                <p class="scheda-ufficio-competenze mt-20-xs">
                                
                                 <% 
                                            Document doc=Jsoup.parse(ufficio.getDescr().getValue());
                                            String descrCompetenza=doc.text();                
                                            %>
                                
                                  <%=descrCompetenza%>
                                </p>
                            </div>
                         
                            </c:if>
                            
                            <c:if test="<%=ufficio.getChiaviUfficio()!=null && ufficio.getChiaviUfficio().size()>0 &&  !ufficio.getChiaviUfficio().contains(null)%>">
					

                            <portlet:actionURL var="cercaUfficiUrl" name="cercaUffici">                                                   
                            </portlet:actionURL> 
                            <form action="<%=cercaUfficiUrl%>" method="post" id="fm">
                            <input type="hidden" name="<portlet:namespace/>tagChiave" id="tagChiave"/>                      
                            </form>
							
                            <div class="ama-col-xs-12 mt-30-xs"><h2 class="scheda-ufficio-title mb-15-xs text-uppercase"><liferay-ui:message key="rubrica-ufficio-competenze"/></h2>
							
							<div class="ama-col-xs-12 mt-0-xs pl-75-sm"> 
							
                            
                            <c:forEach items="${ufficio.getChiaviUfficio()}" var="tag">
                              <div class="div-label-rubrica pull-left mr-10-xs"><a title="${tag}" href="" onclick="cercaUfficidaTag(this.title)" class="label">${tag}</a>
                                <c:if test="<%=roleAdministrator.equals("Administrator") || (themeDisplay.isSignedIn() && belongToTeam==true)%>">
                                <!-- <button class="button-close"><span class="icon-close icomoon-close-white"></span></button> -->
                                </c:if>
                                </div>
                            </c:forEach>
                            
							<c:if test="<%=roleAdministrator.equals("Administrator")|| (themeDisplay.isSignedIn() && belongToTeam==true)%>">
                            <div class="div-label-rubrica div-button-rubrica pull-left">
                           <!--  <button hidden="hidden" class="button button-primary button-rubrica" data-toggle="modal" data-target="#modal-add-tags">
                            	<span class="label"><liferay-ui:message key="rubrica-tag"/></span>
                            </button> 
                            </div>-->
                            </c:if>
                            </div>
							 </div>

                           </c:if>
                            
                            <div id="modal-add-tags" class="modal modal-custom fade modal-sollecito" role="dialog">
                                <div class="modal-dialog">
                            
                                    <div class="modal-content">
                                        <div class="modal-body">
                                            <div class="modal-title-box">
                                                <a href="#" class="icon-close-modal icomoon-close-white" data-dismiss="modal"></a>
                            
                                                <div class="title-modal">
                                                    <h2 class="title"><liferay-ui:message key="rubrica-aggiungi-tag"/></h2>
                                                </div>
                                            </div>
                                            <portlet:actionURL var="gestioneTagUrl" name="gestioneTag">                                                   
                        </portlet:actionURL> 
                                <form action="<%=gestioneTagUrl%>" method="post" id="idGestioneTag" data-parsley-validate data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
                                                <div class="ama-col-xs-12 mt-30-xs">
                                                    <input type="text" id="inputSuggestTag" name="<portlet:namespace/>searchTag" class="input-custom-light input-custom-tag data-parsley-validated" placeholder="Inserisci un tag" onkeyup="suggestInput(this.value, this.id)" list="suggInputTagList" data-parsley-required="true">
                                                    <datalist id="suggInputTagList"></datalist>
                                                    <input type="hidden" name="<portlet:namespace/>codStruttura" value="<%= id_uff%>">
                                                    <button type="button" id="addTagBtn" class="button button-secondary button-add-tag mt-20-xs pull-left" onclick="gestisciTag(this.id)"><span class="label"><liferay-ui:message key="rubrica-crea-tag"/></span><span class="icon-add-tag icomoon-plus ml-10-xs"></span></button>
                                                </div>
                                                <div class="ama-col-xs-12 mt-20-xs mb-30-xs text-center">
                                                <c:forEach items="${ufficio.getChiaviUfficio()}" var="tag">
                                						<div class="div-label-rubrica mr-10-xs pull-left"><span class="label">${tag}</span>
                                						<!-- <button hidden="hidden" class="button-close"><span class="icon-close icomoon-close-white"></span></button> -->
                                						</div>
                            					</c:forEach>   
                                                </div>
                                                <div class="ama-row mb-50-xs buttons-bottom">
                                                    <div class="ama-col-xs-12 ama-col-sm-6">
                                                        <button class="button button-secondary" data-dismiss="modal" onclick="this.form.reset()"><liferay-ui:message key="rubrica-annulla"/></button>
                                                    </div>
                                                    <div class="ama-col-xs-12 ama-col-sm-6">
                                                        <button id="associaTagBtn" type="button" class="button button-primary" onclick="gestisciTag(this.id)"><liferay-ui:message key="rubrica-aggiungi"/></button>
                                                    </div>
                                                </div>
                                                <input type="hidden" id="recButtonOnClick" name="<portlet:namespace/>recButtonOnClick">
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>  
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</c:if>
    
    <div class="ama-container-fluid">
        <div class="ama-row">
            <div class="ama-col-xs-12">
                <div class="rubrica-cerca-persone-title">
                    <h2 class="name-search mb-20-xs"><liferay-ui:message key="rubrica-team"/></h2>
                </div>
            </div>
        </div>
    </div>    <div class="ama-container-fluid pl-0-xs pr-0-xs mb-90-xs">
        <div class="wrapper-content-cerca-persone-item">
        
        <c:forEach items="<%=teamByCodStrutt %>" var="personaTeam">
            <div class="ama-col-xs-12 item-pagination animated fadeIn">
                <div class="ama-col-xs-12 address-book-people">
            
                    <div class="ama-row">
                        <div class="ama-col-xs-12 content-people">
                        
                        <% 
                            AnagraficaVO personaTeam = (AnagraficaVO)pageContext.getAttribute("personaTeam");
                            User utenteTeam = UserLocalServiceUtil.fetchUserByEmailAddress(themeDisplay.getCompanyId(), personaTeam.getEmailAddress().getValue());
                            String avatar = themeDisplay.getPathImage()+"/user_female_portrait?img_id=0";
                            if (utenteTeam!=null) {
                            	avatar = utenteTeam.getPortraitURL(themeDisplay);
                            }
                        %>
                        
                            <div class="ama-col-sm-2 amacol-xs-12 avatar-wrap">
                                <span class="scheda-avatar" style="background-image:url(<%=avatar%>);" ></span>                
                            </div>
                            <div class="ama-col-sm-5 amacol-xs-12 text-center-xs">     
                                <span class="name">${personaTeam.getFirstName().getValue()} ${personaTeam.getLastName().getValue()}</span>
                               
                                  <c:if test="${personaTeam.getComandato().getValue()!=null || personaTeam.getComandatoUffDestinazione().getValue()!=null}">
                                        	 <span class="style-label pr-15-md"><liferay-ui:message key="rubrica-comandato"/> : ${personaTeam.getComandato().getValue()} </span>
                                        	 <span class="style-label d-block"><liferay-ui:message key="rubrica-comandato-ufficio"/> : ${personaTeam.getComandatoUffDestinazione().getValue()} </span>
                                        </c:if>
                               
                                
                                 <c:if test="<%=personaTeam.getLivello2().getValue()!=null%>">
                                        	<span class="style-label">
                                        <c:if test="<%=(!personaTeam.getLivello2().getValue().equals("SOGEI")) && (!personaTeam.getLivello2().getValue().equals("CONSIP"))%>">
                                        	<liferay-ui:message key="rubrica-ricerca-dipartimento"/> 
                                        </c:if>
                                        ${personaTeam.getLivello2().getValue()}</span>
                                        </c:if>
                                
                                
                                 <div class="telefono-container">
                                            <span class="icomoon-rubrica-tel icon-telefono">
                                            <c:if test="${personaTeam.getTelUffi1().getValue()!=null}">
                                            	<span class="telefono-text">${personaTeam.getTelUffi1().getValue()}</span>
                                            </c:if>
                                            <c:if test="${personaTeam.getTelUffi2().getValue()!=null}">
                                            	<span class="telefono-text">${personaTeam.getTelUffi2().getValue()}</span>
                                            </c:if>
                                            </span>
                                        </div>
                            </div>
                            <div class="ama-col-sm-5 amacol-xs-12">
                                <div class=" container-office">
                                    <span class="icon-office icomoon-dipartimento mr-10-xs"></span>      
                                    <span class="name-office">${personaTeam.getAcronimo().getValue()}</span>           
                                </div>
                            </div>
                        </div>
                    </div>
            
                    <div class="ama-col-xs-12 address-info-people border-left">
                    
                        <div class="ama-col-sm-6 ama-col-xs-12">
                                    <div class="ama-col-xs-12 mb-35-xs">
                                        <span class="title"><liferay-ui:message key="rubrica-contatti"/></span>
                                    </div>
                                    <div class="ama-col-md-12 ama-col-xs-12">
                                        <span class="label-info-people mb-10-xs"><liferay-ui:message key="rubrica-email"/>:</span>
                                        <c:if test="${personaTeam.getEmailAddress().getValue()!=null}">
                                        <a href="mailto:${personaTeam.getEmailAddress().getValue()}" class="info mb-20-xs">${personaTeam.getEmailAddress().getValue()}</a>
                                        </c:if>
                                    </div>
                                    <div class="ama-col-md-6 ama-col-xs-12">
                                        <span class="label-info-people mb-10-xs"><liferay-ui:message key="rubrica-cellulare"/>:</span>
                                        <c:if test="${personaTeam.getCellulare().getValue()!=null}">
                                        <span class="info mb-20-xs">${personaTeam.getCellulare().getValue()}</span>
                                    	</c:if>
                                    </div>
                                    <div class="ama-col-md-6 ama-col-xs-12">
                                        <span class="label-info-people mb-10-xs"><liferay-ui:message key="rubrica-fax"/>:</span>
                                        <c:if test="${personaTeam.getFax().getValue()!=null}">
                                        <span class="info mb-20-xs">${personaTeam.getFax().getValue()}</span>
                                    	</c:if>
                                    	<c:if test="${personaTeam.getFaxUff().getValue()!=null}">
                                        <span class="info mb-20-xs">${personaTeam.getFaxUff().getValue()}</span>
                                    	</c:if>
                                    </div>
                                </div>
 
                        <div class="ama-col-sm-6 ama-col-xs-12">
                            <div class="ama-col-xs-12 mb-35-xs">
                                <span class="title"><liferay-ui:message key="rubrica-info"/></span>
                            </div>
                            <div class="ama-col-md-6 ama-col-xs-12">
                                <span class="label-info-people mb-10-xs"><liferay-ui:message key="rubrica-incarico"/>:</span>
                                <span class="info mb-20-xs">${personaTeam.getIncarico().getValue()}</span>
                                <span class="label-info-people mb-10-xs">UBICAZIONE:</span>
                                <span class="info mb-20-xs">${personaTeam.getUbicazione().getValue()}</span>
                            </div>
                            <div class="ama-col-md-6 ama-col-xs-12">
                                <span class="label-info-people mb-10-xs"><liferay-ui:message key="rubrica-sede"/>:</span>
                                <span class="info mb-20-xs">${personaTeam.getSede().getValue()}</span>
                            </div>
                        </div>
                    </div>
                    <a href="" class="address-office-icon icomoon-plus" data-role="collapsible"></a>
                </div>    
            </div>
            </c:forEach>
            
            
        </div>
    </div>
    
    
 
<script>
function cercaUfficidaTag(key){

	$('#tagChiave').val(key);
	$('#fm').submit();
	
}

function suggestInput(input, id){
	
    if(input.length>2){
                Liferay.Service(
                                '/mefrubrica.searchdata/suggest-parola-chiave',
                                {
                                  chiave: input
                                },
                                function(obj) {
                                    var options = ''; 
                             $.each(obj,function(key, value){                               
                                   var list=value.parolaChiave.value;
                                   options += '<option value="'+list+'" />';                              
                             });
                              document.getElementById('suggInputTagList').innerHTML = options;
                                }
                              );
                
         }
            
    else {
    	
    	document.getElementById('suggInputTagList').innerHTML = '';
    	
    }
    
}

$("#idGestioneTag").parsley();

function gestisciTag(id) {
	var inputVal = $("#inputSuggestTag").val();
	
	if(id=="associaTagBtn") {
		$("#recButtonOnClick").val("ASSOCIA");
	
	}
	else if(id=="addTagBtn") {
		$("#recButtonOnClick").val("AGGIUNGI");
	}
	
	$("#idGestioneTag").submit();
	
	if(inputVal.length > 0) {
	$("#modal-add-tags").modal("hide");
	
	}
	
}

</script>