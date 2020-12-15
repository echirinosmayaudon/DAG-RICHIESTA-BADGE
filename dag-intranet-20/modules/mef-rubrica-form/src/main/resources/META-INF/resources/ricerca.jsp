<%@taglib uri="http://liferay.com/tld/aui" prefix="aui" %> 
<%@page import="java.util.Map"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@page import="javax.jws.Oneway"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.mef.intranet.rubrica.model.SearchData"%>
<%@page import="com.mef.intranet.rubrica.stub.Struttura"%>
<%@page import="it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioVO"%>
<%@page import="it.intranetdag.rubrica.services.vo.xsd.AnagraficaVO"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.mef.intranet.rubrica.service.SearchDataLocalServiceUtil"%>




<c:if test="<%=request.getAttribute("inputQualifica")!=null%>">
<c:set value="<%=request.getAttribute("inputQualifica")%>" var="inputQualifica"></c:set>
</c:if>
<c:if test="<%=request.getAttribute("inputStrutturaMadre")!=null%>">
<c:set value="<%=request.getAttribute("inputStrutturaMadre")%>" var="inputStrutturaMadre"></c:set>
</c:if>
<c:set value="<%=request.getAttribute("countRisultatiPersone")%>" var="countRisultatiPersone"></c:set>

<%
String json = (String)request.getAttribute("jsonArrayPersone");

JSONArray jsonArrayPersone = null;

if (json!=null) {
	jsonArrayPersone = JSONFactoryUtil.createJSONArray(json);
}

String jsonUffici = (String)request.getAttribute("dettaglioUffici");

JSONArray jsonArrayUffici = null;

if (jsonUffici!=null) {
	jsonArrayUffici = JSONFactoryUtil.createJSONArray(jsonUffici);
}
 
int itemsdelta=0;
int tagNumber=6;

if (Integer.valueOf(itemsPerPage) > 0 ) {
	 itemsdelta=Integer.valueOf(itemsPerPage);	
}

String textSearch = request.getAttribute("textSearch") == null ? "" : (String) request.getAttribute("textSearch");

String param_personeClass ="collapse in";
String param_ufficiClass="collapse";
String param_ufficiClassActive="";
String param_personeClassActive="active";


if (request.getAttribute("dettaglioUffici") != null){
	
	param_personeClass = "collapse";
	param_ufficiClass="collapse in";
	param_ufficiClassActive="active";
	param_personeClassActive="";

} 
Integer pageNumber=0;
%>

<div class="tab-rubrica-cerca">
        <div class="ama-container-fluid">
            <div class="tab-filtri filtro-categoria">
                <div class="filtro-tabs-wrapper riunione-modifica-stato-tabs">
                    <a href="" title="CERCA PERSONE"  id="tab_persone" class="tab-title <%=param_personeClassActive%>" data-toggle="collapse" data-target="#rubricaCercaPersone"><liferay-ui:message key="rubrica-ricerca-persone"/></a>
                    <a href="" title="CERCA UFFICI" id="tab_uffici" class="tab-title <%=param_ufficiClassActive%>" data-toggle="collapse" data-target="#rubricaCercaUffici"><liferay-ui:message key="rubrica-ricerca-competenze-uffici"/></a>
                </div>
					<div id="rubricaCercaPersone" class="<%=param_personeClass%> mobile-padding-none">
                    <div class="tab-rubrica-cerca-wrapper">
                        <div class="rubrica-cerca-container">
                        <portlet:actionURL var="ricercaPersoneURL" name="ricercaPersone"/></portletactionURL>
                            <form class="persone-form" id="frmRicercaPersone" action="<%=ricercaPersoneURL%>" method="POST" data-parsley-validate="true" enctype="multipart/form-data">
                               <div class="validatorParsleyCustom" data-parsley-check-fields-or-validator="" data-parsley-validate-if-empty="" id="mefRicercaId">
                                <div class="ama-row">
											<div class="col-xs-12 pb-10-xs">
											<p class="copy-text blue-color"><liferay-ui:message key="rubrica-campi-obbligatori"/></p>
											</div>
								</div> 
                                <div class="ama-row">
                                    <div class="ama-col-xs-12 ama-col-sm-6 ama-col-md-3 mb-30-sm">
                                        <label class="label-form parsley-or-validator-label" for="surname"><liferay-ui:message key="rubrica-cognome"/>*</label>
                                        	 <div class="wrapper-input-search-rubrica">
                                        	<input type="text" id="inputLastname" name="<portlet:namespace/>surname" 
                                        	    data-parsley-minlength="3" 
                                        	    data-parsley-minlength-message="<liferay-ui:message key="error-minlength-message-surname"/>" 
                                        		class="input-custom-light  parsley-or-validator-field data-parsley-validated" value="" placeholder="Inserisci il cognome" 
                                        		 list="suggLastnameList" >
                                        		 <span id="<portlet:namespace/>lenteRicercaCognome" class="icomoon-search ico-search-rubrica"></span>
                                        		 </div>
                                        		 <datalist id="suggLastnameList"></datalist>              
                                    </div>
                                    <div class="ama-col-xs-12 ama-col-sm-6 ama-col-md-3 mb-30-sm">
                                        <label class="label-form" for="name"><liferay-ui:message key="rubrica-nome"/></label>
                                        <div class="wrapper-input-search-rubrica">
                                         <input type="text" onkeydown = "if (event.keyCode == 13) document.getElementById('btn-search').click()"   
                                         	name="<portlet:namespace/>name" class="input-custom-light" placeholder="Inserisci il nome">
                                         	 <span id="<portlet:namespace/>lenteRicercaNome" class="icomoon-search ico-search-rubrica"></span>
                                        </div> 
                                    </div>
                                    <div class="ama-col-xs-12 ama-col-sm-6 ama-col-md-3 mb-30-sm">
                                        <label class="label-form parsley-or-validator-label" for="qualification"><liferay-ui:message key="rubrica-qualifica"/>*</label>
                                        <select id="qualification" name="<portlet:namespace/>qualification" class="parsley-or-validator-field data-parsley-validated" onkeydown = "if (event.keyCode == 13) document.getElementById('btn-search').click()" >
                                            <option  value="" ><liferay-ui:message key="rubrica-scelta-elenco"/></option>
												<c:if test="<%=request.getAttribute("listaQualifiche")!=null %>">
													<c:forEach items="<%=request.getAttribute("listaQualifiche") %>" var="qualifica">
															<option value="${qualifica.getId_qualifica()}">${qualifica.getNome_qualifica()}</option>
													</c:forEach>
												</c:if>
                                        </select>
                                    </div>
                                    <div class="ama-col-xs-12 ama-col-sm-6 ama-col-md-3 mb-30-sm">
                                        <label class="label-form parsley-or-validator-label" id="structure-label" for="structure"><liferay-ui:message key="rubrica-struttura"/>*</label>
                                        <select id="structure" name="<portlet:namespace/>structure" class="parsley-or-validator-field data-parsley-validated" onchange="handleSelect(this.value, this.id)">
                                            <option value="" ><liferay-ui:message key="rubrica-scelta-elenco"/></option>
												<c:if test="<%=request.getAttribute("listaStrutture")!=null %>">
													<c:forEach items="<%=request.getAttribute("listaStrutture") %>" var="struttura">
															<option value="${struttura.getId_struttura()}">${struttura.getNome_struttura()}</option>
													</c:forEach>
												</c:if>
                                        </select>
                                    </div>
                                    <div class=" ama-col-xs-12 ama-col-sm-6 ama-col-md-3 mb-30-sm hide structure_hidden" >
                                        <label class="label-form" id="structure-one-label" for="structure-one" ><liferay-ui:message key="rubrica-ricerca-struttura-uno"/>*</label>
                                        <select  id="structure-one" disabled name="<portlet:namespace/>structure-one"  onchange="handleSelect(this.value, this.id)" onkeydown = "if (event.keyCode == 13) document.getElementById('btn-search').click()"   >
                                            <option value="" ><liferay-ui:message key="rubrica-scelta-elenco"/></option>
                                        </select>
                                    </div>
                                    <div class="ama-col-xs-12 ama-col-sm-6 ama-col-md-3 mb-30-sm hide structure_hidden">
                                        <label class="label-form" for="structure-two"><liferay-ui:message key="rubrica-ricerca-struttura-due"/></label>
                                        <select  id="structure-two" disabled name="<portlet:namespace/>structure-two" onchange="handleSelect(this.value, this.id)" onkeydown = "if (event.keyCode == 13) document.getElementById('btn-search').click()"   >
                                            <option value="" ><liferay-ui:message key="rubrica-scelta-elenco"/></option>
                                        </select>
                                    </div>
                                    <div class="ama-col-xs-12 ama-col-sm-6 ama-col-md-3 mb-30-sm hide structure_hidden">
                                        <label class="label-form" for="structure-three"><liferay-ui:message key="rubrica-ricerca-struttura-tre"/></label>
                                        <select  id="structure-three" disabled  name="<portlet:namespace/>structure-three" onchange="handleSelect(this.value, this.id)" onkeydown = "if (event.keyCode == 13) document.getElementById('btn-search').click()"   >
                                            <option value="" ><liferay-ui:message key="rubrica-scelta-elenco"/></option>
                                        </select>
                                    </div>
                                    <div class="ama-col-xs-12 ama-col-sm-6 ama-col-md-3 mb-30-sm hide structure_hidden">
                                        <label class="label-form" for="structure-four"><liferay-ui:message key="rubrica-ricerca-struttura-quattro"/></label>
                                        <select  id="structure-four" disabled name="<portlet:namespace/>structure-four" onkeydown = "if (event.keyCode == 13) document.getElementById('btn-search').click()"   >
                                            <option value="" ><liferay-ui:message key="rubrica-scelta-elenco"/></option>
                                        </select>
                                    </div>
                                </div>
                                </div>
                                 <div class="ama-row">
                                    <div class="buttons-wrapper ama-col-xs-12 mt-20-xs">
                                        <div class="ama-col-sm-6 ama-col-xs-12 text-center mobile-no-padding">
                                            <button type="button" class="button button-secondary" onclick="resetForm()"><liferay-ui:message key="rubrica-ricerca-annulla"/></button>
                                        </div>
                                        <div class="ama-col-sm-6 ama-col-xs-12 text-center mobile-no-padding">
                                            <button  type="button" id="btn-search" class="button button-primary validate" onclick="showSpinner()"><liferay-ui:message key="rubrica-ricerca-label-cerca"/></button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
				<div id="rubricaCercaUffici" class="<%=param_ufficiClass%> mobile-padding-none">
                    <div class="tab-rubrica-cerca-wrapper">
                        <div class="rubrica-cerca-container">
	                        <portlet:actionURL var="cercaUfficiUrl" name="cercaUffici">                                                   
	                        </portlet:actionURL> 
	                        <portlet:renderURL var="vaiatutteUrl">
	                           <portlet:param name="mvcPath" value="/ricerca_parola_chiave.jsp"/>
	                           </portlet:renderURL>    
                                <form action="<%=cercaUfficiUrl%>" method="post" id="submitKey" enctype="multipart/form-data">
                                    <div class="ama-row">
                                        <div class="ama-col-xs-12 ama-col-sm-4 ama-col-md-3">
                                            <div class="ama-row">
	                                            <div class="ama-col-xs-12">
	                                                <label class="label-form" for="parolaChiave"><liferay-ui:message key="rubrica-ricerca-parola-chiave"/></label>
	                                                <div class="wrapper-input-search-rubrica">
	                                                <input type="text" id="inputKeyword" name="<portlet:namespace/>parolaChiave" class="input-custom-light input-word-key data-parsley-validated" placeholder="Che cosa stai cercando?" list="suggKeywordList"
	                                                data-parsley-required="true"
						                            data-parsley-required-message="<liferay-ui:message key="rubrica-input-parola-chiave"/>"
	                                                  >
	                                                <span id="<portlet:namespace/>lenteRicercaUfficio" class="icomoon-search ico-search-rubrica"></span>
                                                     </div> 
	                                            	<datalist id="suggKeywordList"></datalist>
	                                            </div>
                                            </div>
                                        </div>
                                     	<input type="hidden" id="tagNuvola" name="<portlet:namespace/>tagNuvola"/> 
                                     	<div class="ama-col-xs-12 ama-col-sm-8 ama-col-md-9 container-tag mobile-text-center">
                                                <div class="ama-col-xs-12">
                                                    <label class="label-form mb-10-sm" for="parolaChiave"><liferay-ui:message key="rubrica-ricerca-chiave-cercata"/></label>
                                                </div>
                                                <div class="ama-col-xs-12 mobile-no-padding">
                                                	<div class="mobile-bg-white">                                                                       
		                                              <c:forEach items="<%=request.getAttribute("nuvolaTag")%>" var="tag">                        
		                                                        <a title="${tag.getTagName().getValue()}" href="" onclick="submitTag(event,this.title)" class="rubrica-tag rubrica-key">
		                                                            <h2>${tag.getTagName().getValue().toUpperCase()}</h2>                                                                   
		                                                        </a>     
		                                               </c:forEach>         
                                                       <a href="<%=vaiatutteUrl%>">
                                                       	<button type="button" class="button button-primary button-vai" ><h2><liferat-ui:message key="rubrica-vai-tutte"/></h2><span class="icomoon-vai ml-10-xs"></span></button>                                              
                                                        </a>
                                                    </div>
                                                </div>
                                        </div>
                                    </div>
                                    <div class="ama-row">
                                        <div class="buttons-wrapper ama-col-xs-12">
                                            <div class="ama-col-sm-6 ama-col-xs-12 text-center mobile-no-padding">
                                                <button type ="button" class="button button-secondary" onclick="reset()"><liferay-ui:message key="rubrica-ricerca-annulla"/></button>
                                            </div>
                                            <div class="ama-col-sm-6 ama-col-xs-12 text-center mobile-no-padding">
                                               <button   type ="button" id="btn-search-uffici" onclick="submitFormUffici()" class="button button-primary"><liferay-ui:message key="rubrica-ricerca-label-cerca"/></button>
                                            </div>
                                        </div>   
                                    </div>
                                </form>                         
                        </div>
                    </div>         
                </div>
            </div>
        </div>
</div>
<c:if test="<%=json==null && jsonUffici==null && request.getAttribute("ultime_ricerche")!=null%>">
    <div class="ama-container-fluid pb-50-xs">
        <div class="rubrica-cerca-persone-title top-paginator-scroll ">
            <span class="name-search title-span mb-20-xs"><liferay-ui:message key="rubrica-ultime-ricerche"/></span>
        </div>
		   <div class="ama-row carousel-research">
		    <c:forEach items="<%=request.getAttribute("ultime_ricerche")%>" var="last_ricerca">
                     <c:set var="jsonString" value="${last_ricerca.getSearchData()}"/>
          <div class="wrapper-box-latest-research">  
            <div class="ama-col-md-6">
                <div class="wrapper-content-total">                    
                       <%
                       String jsonData=(String)pageContext.getAttribute("jsonString");
                       JSONObject jsonObj = JSONFactoryUtil.createJSONObject(jsonData);
                      
                       int size=jsonObj.length();
                       %>                                      
                    <c:choose>
	                    <c:when test="<%=jsonObj.get("parolaChiave")==null%>">
	                    <div class="title-box">   
	                    <form action="<%=ricercaPersoneURL%>" method="post" enctype="multipart/form-data"> 
	                    	<button class="title button button-primary"><liferay-ui:message key="rubrica-ricerca-persone"/></button>                      
	                   	 	<c:if test="<%=!jsonObj.getString("surname").equals("")%>">
	                    		<input type="hidden" name="<portlet:namespace/>surname" value="<%=jsonObj.getString("surname")%>"/>
	                    	</c:if> 
		                    <c:if test="<%=!jsonObj.getString("name").equals("")%>">
		                    	<input type="hidden" name="<portlet:namespace/>name" value="<%=jsonObj.getString("name")%>"/> 
		                    </c:if>
						    <c:if test="<%=jsonObj.getJSONObject("qualification")!=null%>">
	                   			<input type="hidden" name="<portlet:namespace/>qualification" value="<%=jsonObj.getJSONObject("qualification").getString("id")%>"/>                 
	                    	</c:if> 
		                   	<c:if test="<%=jsonObj.getJSONObject("structure")!=null%>">
		                   		<input type="hidden" name="<portlet:namespace/>structure" value="<%=jsonObj.getJSONObject("structure").getString("id")%>"/>                 
		                   	</c:if>
		                   	<c:if test="<%=jsonObj.getJSONObject("structure-one")!=null%>">
		                   		<input type="hidden" name="<portlet:namespace/>structure-one" value="<%=jsonObj.getJSONObject("structure-one").getString("id")%>"/>    
		                    </c:if>
		                    <c:if test="<%=jsonObj.getJSONObject("structure-two")!=null%>">
		                    	<input type="hidden" name="<portlet:namespace/>structure-two" value="<%=jsonObj.getJSONObject("structure-two").getString("id")%>"/>                   
		                    </c:if>
		                    <c:if test="<%=jsonObj.getJSONObject("structure-three")!=null%>">
		                    	<input type="hidden" name="<portlet:namespace/>structure-three" value="<%=jsonObj.getJSONObject("structure-three").getString("id")%>"/>                 
		                    </c:if>
		                    <c:if test="<%=jsonObj.getJSONObject("structure-four")!=null%>">
		                    	<input type="hidden" name="<portlet:namespace/>structure-four" value="<%=jsonObj.getJSONObject("structure-four").getString("id")%>"/> 
		                    </c:if>  
	                    </form> 
	                    </div>
	                    </c:when>
	                    <c:otherwise>
		                    <div class="title-box"> 
			                     <form action="<%=cercaUfficiUrl%>" method="post" enctype="multipart/form-data">                
			                       <button class="title button button-primary"><liferay-ui:message key="rubrica-ricerca-competenze-uffici"/></button>
			                       <input type="hidden" name="<portlet:namespace/>parolaChiave" value="<%=jsonObj.getString("parolaChiave")%>"/>                 
			                    </form>
		                    </div>
	                    </c:otherwise>
                    </c:choose>
					<div class="wrapper-content"> 
						<c:choose>
				   			<c:when test="<%=jsonObj.get("parolaChiave")==null%>">
								<c:if test="<%=!jsonObj.getString("name").equals("")%>">
                    				<div class="div-label-rubrica">
                        				<span class="label"><%=jsonObj.getString("name").toUpperCase()%></span> 
                         			</div>
                         		</c:if>
								<c:if test="<%=!jsonObj.getString("surname").equals("")%>">
			                    	<div class="div-label-rubrica">
			                        	<span class="label"><%=jsonObj.getString("surname").toUpperCase()%></span> 
			                        </div>
			                    </c:if>
								<c:if test="<%=jsonObj.getJSONObject("qualification")!=null%>">
							    	<div class="div-label-rubrica">
			                        	<span class="label"><%=(jsonObj.getJSONObject("qualification")).getString("nomeQ").toUpperCase()%></span> 
			                        </div>
                         		</c:if>
			                    <c:if test="<%=jsonObj.getJSONObject("structure")!=null%>">
				                    <div class="div-label-rubrica">
				                        <span class="label"><%=(jsonObj.getJSONObject("structure")).getString("nomeS").toUpperCase()%></span> 
				                    </div>
                         		</c:if> 
			                    <c:if test="<%=jsonObj.getJSONObject("structure-one")!=null%>">
			                    	<div class="div-label-rubrica">
			                        	<span class="label"><%=(jsonObj.getJSONObject("structure-one")).getString("nomeS").toUpperCase()%></span> 
			                         </div>
			                    </c:if>
			                    <c:if test="<%=jsonObj.getJSONObject("structure-two")!=null%>">
				                    <div class="div-label-rubrica">
				                        <span class="label"><%=(jsonObj.getJSONObject("structure-two")).getString("nomeS").toUpperCase()%></span> 
				                    </div>
			                    </c:if>
			                    <c:if test="<%=jsonObj.getJSONObject("structure-three")!=null%>">
				                    <div class="div-label-rubrica">
				                        <span class="label"><%=(jsonObj.getJSONObject("structure-three")).getString("nomeS").toUpperCase()%></span> 
				                   	</div>
			                    </c:if>
                     			<c:if test="<%=jsonObj.getJSONObject("structure-four")!=null%>">
				                    <div class="div-label-rubrica">
				                        <span class="label"><%=(jsonObj.getJSONObject("structure-four")).getString("nomeS").toUpperCase()%></span> 
				                    </div>
                    			</c:if>
                  
                    		</c:when>
                    		<c:otherwise>
                    			<c:if test="<%=jsonObj.getString("parolaChiave")!=null%>">
					    			<div class="div-label-rubrica">
	                        			<span class="label"><%=jsonObj.getString("parolaChiave").toUpperCase()%></span> 
	                         		</div>
                  				</c:if>
                    		</c:otherwise>
                    	</c:choose>
                    </div>
                 </div>
			</div>
            	</div>
			</c:forEach>
		</div>
	</div>
</c:if>
<c:if test="<%=json!=null%>">
    <div class="ama-container-fluid">
        <div class="ama-row">
            <div class="ama-col-xs-12">
                <div class="rubrica-cerca-persone-title top-paginator-scroll ">
                    <span class="name-search title-span mb-20-xs"><liferay-ui:message key="rubrica-risultati-ricerca-persone"/></span>
					<%
                          String countRisultatiPersone=request.getAttribute("countRisultatiPersone").toString();	
	                      String labelRes="";
	                      if(countRisultatiPersone.equals("1")){
		                   labelRes="persona trovata";
	                      }
	                      else if(!countRisultatiPersone.equals("1")){
		                   labelRes="persone trovate";
	                      }
	                %>	
                    <span class="items-trovati"><span class="bold"><%=countRisultatiPersone%>
                    
                    </span><%=labelRes%></span>
						 <div class="labels-container mobile-click-open">
                        <span class="labels-container-title"><liferay-ui:message key="rubrica-ricerca-risultati"/>:</span>
	                                  <c:forEach items="<%=request.getAttribute("filtriRicercaPersone")%>" var="filtro">
	                                  	 <div class="filter-label-item">
	                                        <h2>${filtro}</h2>
	                                    </div>
	                                  </c:forEach>
	                                  <div class="filter-label-item btn-filter-reset">
                            <h2><liferay-ui:message key="rubrica-ricerca-reset"/></h2><span class="icomoon-close-white"></span>
                        </div>
                        </div>
                </div>
            </div>
        </div>
    </div>    
    
   
    <div class="js-list-pagination">
		<div class="ama-container-fluid pl-0-xs pr-0-xs mb-80-xs">
             <div class="ama-col-xs-12 wrapper-content-cerca-persone-item mb-0-xs">
                 <div class="ama-row">
                               
                                <c:if test="<%=jsonArrayPersone.length()<1%>">                   
                                <div class="ama-col-xs-12">
                                    <p class="copy-text wysiwyg-editor"><liferay-ui:message key="rubrica-nessun-risultato-persone"/></p>
                                </div>
                                </c:if>   
                            <%
                            for(int i=0;i<jsonArrayPersone.length();i++) {
                         		JSONObject jsonAnagrafica = JSONFactoryUtil.createJSONObject(jsonArrayPersone.get(i).toString());
                         		%>
                          <div class="ama-col-xs-12 item-pagination animated fadeIn">
                        <div class="ama-col-xs-12 address-book-people">
                    
                            <div class="ama-row">
                                <div class="ama-col-xs-12 content-people">
                                                         
                                    <div class="ama-col-sm-2 amacol-xs-12 avatar-wrap">
                                        <span class="scheda-avatar" style="background-image:url(<%=jsonAnagrafica.getString("urlImage")%>);" ></span>               
                                    </div>
                                    <div class="ama-col-sm-5 amacol-xs-12 text-center-xs">
                                        <span class="name"><%=jsonAnagrafica.getString("firstName")%> <%=jsonAnagrafica.getString("lastName")%></span>
                                        <c:if test="<%=(jsonAnagrafica.getString("comandato")!=null &&  !("").equalsIgnoreCase(jsonAnagrafica.getString("comandato")))||
                                        (jsonAnagrafica.getString("comandatoUffDestinazione")!=null &&   !("").equalsIgnoreCase(jsonAnagrafica.getString("comandatoUffDestinazione")))%>">
                                                                                
                                             <span class="style-label pr-15-md"><liferay-ui:message key="rubrica-comandato"/> : <%=jsonAnagrafica.getString("comandato")%> </span>
                                             <span class="style-label d-block"><%=jsonAnagrafica.getString("comandatoUffDestinazione")%></span>                           
                                        </c:if>
                                        <c:if test="<%=!jsonAnagrafica.getString("livello2").equals("null")%>">
                                        	<span class="style-label">
                                        <c:if test="<%=(!jsonAnagrafica.getString("livello2").equals("SOGEI")) && (!jsonAnagrafica.getString("livello2").equals("CONSIP"))%>">
                                        	<liferay-ui:message key="rubrica-ricerca-dipartimento"/> 
                                        </c:if>
                                        <%=jsonAnagrafica.getString("livello2")%></span>
                                        </c:if>
                                        <div class="telefono-container">
                                            <span class="icomoon-rubrica-tel icon-telefono">
                                            <c:if test="<%=!jsonAnagrafica.getString("telUffi1").equals("null")%>">
                                            	<span class="telefono-text"><%=jsonAnagrafica.getString("telUffi1")%></span>
                                            </c:if>
                                            <c:if test="<%=!jsonAnagrafica.getString("telUffi2").equals("null")%>">
                                            	<span class="telefono-text"><%=jsonAnagrafica.getString("telUffi2")%></span>
                                            </c:if>
                                            </span>
                                        </div>
                                    </div>
                                    <div class="ama-col-sm-5 amacol-xs-12">
                                        <div class="container-office">   
                                        <%
                                        String idUff=null;
                                        if(jsonAnagrafica.getString("liv4")!=null && jsonAnagrafica.getString("liv4")!="" && !jsonAnagrafica.getString("liv4").equals("null")){
                                        	idUff=jsonAnagrafica.getString("liv4");         	
                                       
                                        }
                                        else if(jsonAnagrafica.getString("liv3")!=null && jsonAnagrafica.getString("liv3")!="" && !jsonAnagrafica.getString("liv3").equals("null")){
                                        	idUff=jsonAnagrafica.getString("liv3");         	
                                        
                                        }
                                        else if(jsonAnagrafica.getString("liv2")!=null && jsonAnagrafica.getString("liv2")!="" && !jsonAnagrafica.getString("liv2").equals("null")){
                                        	idUff=jsonAnagrafica.getString("liv2");         	
                                      
                                        }
                                        else if(jsonAnagrafica.getString("liv1")!=null && jsonAnagrafica.getString("liv1")!="" && !jsonAnagrafica.getString("liv1").equals("null")){
                                        	idUff=jsonAnagrafica.getString("liv1");         	
                                      
                                        }
                                       
                                        %>
                                            <portlet:renderURL var="ufficioDett">
                                            	<portlet:param name="id_ufficio" value="<%=idUff%>"/>
                                            </portlet:renderURL>
                                            <c:if test="<%=!jsonAnagrafica.getString("livello1").equalsIgnoreCase("MEF")%>">
                                            	<span class="icon-office icomoon-dipartimento mr-10-xs"></span>
                                            	 <span class="name-office"><%=jsonAnagrafica.getString("acronimo")%></span> 
                                            </c:if>	 
                                             <c:if test="<%=jsonAnagrafica.getString("livello1").equalsIgnoreCase("MEF")%>">
                                            	<a href="<%=ufficioDett%>"><span class="icon-office icomoon-dipartimento mr-10-xs"></span></a>
                                            	<a href="<%=ufficioDett%>" class="name-office"><%=jsonAnagrafica.getString("acronimo")%></a> 
                                            </c:if>	                     	
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
                                        <c:if test="<%=!jsonAnagrafica.getString("emailAddress").equals("null")%>">
                                          <a href="mailto:<%=jsonAnagrafica.getString("emailAddress")%>" class="info mb-20-xs"><%=jsonAnagrafica.getString("emailAddress")%></a>
                                        </c:if>
                                    </div>
                                    
                                    <div class="ama-col-md-6 ama-col-xs-12">
                                        <span class="label-info-people mb-10-xs"><liferay-ui:message key="rubrica-cellulare"/>:</span>
                                        <c:if test="<%=!jsonAnagrafica.getString("cellulare").equals("null")%>">
                                        <span class="info mb-20-xs"><%=jsonAnagrafica.getString("cellulare")%></span>
                                    	</c:if>
                                    </div>
                                    <div class="ama-col-md-6 ama-col-xs-12">
                                        <span class="label-info-people mb-10-xs"><liferay-ui:message key="rubrica-fax"/>:</span>
                                        <c:if test="<%=!jsonAnagrafica.getString("fax").equals("null")%>">
                                        <span class="info mb-20-xs"><%=jsonAnagrafica.getString("fax")%></span>
                                    	</c:if>
                                    	<c:if test="<%=!jsonAnagrafica.getString("faxUff").equals("null")%>">
                                        <span class="info mb-20-xs"><%=jsonAnagrafica.getString("faxUff")%></span>
                                    	</c:if>
                                    </div>
                                </div>
                                <div class="ama-col-sm-6 ama-col-xs-12">
                                    <div class="ama-col-xs-12 mb-35-xs">
                                        <span class="title"><liferay-ui:message key="rubrica-info"/></span>
                                    </div>
                                    <div class="ama-col-md-6 ama-col-xs-12">
                                        <span class="label-info-people mb-10-xs"><liferay-ui:message key="rubrica-incarico"/>:</span>
                                        <c:if test="<%=!jsonAnagrafica.getString("incarico").equals("null")%>">
                                        <span class="info mb-20-xs"><%=jsonAnagrafica.getString("incarico")%></span>
                                        </c:if>
                                        <span class="label-info-people mb-10-xs"><liferay-ui:message key="rubrica-ubicazione"/>:</span>
                                        <c:if test="<%=!jsonAnagrafica.getString("ubicazione").equals("null")%>">
                                        <span class="info mb-20-xs"><%=jsonAnagrafica.getString("ubicazione")%></span>
                                    	</c:if>
                                    </div>
                                    <div class="ama-col-md-6 ama-col-xs-12">
                                        <span class="label-info-people mb-10-xs"><liferay-ui:message key="rubrica-sede"/>:</span>
                                        <c:if test="<%=!jsonAnagrafica.getString("sede").equals("null")%>">
                                        <span class="info mb-20-xs"><%=jsonAnagrafica.getString("sede")%></span>
                                    	</c:if>
                                    </div>
                                </div>
                            </div>
                            <a href="" class="address-office-icon icomoon-plus" data-role="collapsible"></a>
                        </div>    
                    </div>
                         <% } %>
                    
                 </div>
				 <% 
						Integer pageCurrent = (Integer)request.getAttribute("page");
						pageNumber = (Integer)request.getAttribute("numPage");
						String back_btn = pageCurrent==1 ? "disabled" : "";
						String forward_btn = pageCurrent.equals(pageNumber) ? "disabled" : "";
				

					 %>
				 	<c:if test="<%= pageNumber>1 %>">

				      <portlet:actionURL var="paginaPersoneURL" name="paginaPersone"/></portletactionURL>

                    <form style="display:none" id="formPaginaPersone" action="<%=paginaPersoneURL%>" method="POST" enctype="multipart/form-data">
						<input type="hidden" name="<portlet:namespace/>numpage" id="numpagePersone">
					</form>
				   
				   <div class="ama-col-xs-12 text-align-center">
                                    <div data-totpage-mobile="" class="paginator-wrap-dark paginator-wrap">
					
									<div class="btn-back-arrow <%= back_btn %>">
                                        <a href="#" onclick="showPagina(event, <%=pageCurrent-1%>,'Persone')"><em class="icomoon-arrow"></em></a>
                                        </div>
                                        <ul class="pagination-numbers">
										
										<c:set var="currentPage" value="<%= pageCurrent %>"/>
										<c:forEach var="tag" begin="1" end="<%=pageNumber%>" >
											<c:choose>
											<c:when test="${tag==currentPage}">
												<li id="pageClick${tag}" class="current-page"><a href="#" onclick="showPagina(event, ${tag},'Persone')" >${tag}</a></li>
											</c:when>
											<c:otherwise>
												<li id="pageClick${tag}"><a href="#" onclick="showPagina(event, ${tag},'Persone')">${tag}</a></li>
											</c:otherwise>
											</c:choose>
										</c:forEach>
                                        </ul>
                                        <div class="btn-forward-arrow <%= forward_btn %>">
                                            <a href="#" onclick="showPagina(event, <%=pageCurrent+1%>,'Persone')">
                                                <em class="icomoon-arrow"></em>
                                            </a>
                                        </div>
                                    </div>

                      </div>
				</c:if>					  
              </div>
        </div>
    </div>
	 
	</c:if>
         		
<c:if test="<%=jsonUffici!=null%>">
     <div class="ama-container-fluid">
        <div class="ama-row">
            <div class="ama-col-xs-12">
                <div class="rubrica-cerca-persone-title top-paginator-scroll ">
                    <span class="name-search title-span mb-20-xs"><liferay-ui:message key="rubrica-ricerca-uffici-risultati"/></span>
                    <%
                          String countRisultatiUffici= request.getAttribute("countRisultatiUffici").toString();	
	                      String labelRes="";
	                      if(countRisultatiUffici.equals("1")){
		                   labelRes="struttura trovata";
	                      }
	                      else if(!countRisultatiUffici.equals("1")){
		                   labelRes="strutture trovate";
	                      }
	                    %>
                    <span class="items-trovati"><span class="bold"><%=countRisultatiUffici%>
                  
                    </span><%=labelRes%></span>
                    <%if(textSearch != null && !textSearch.equals("")) {%> 
					<div class="labels-container mobile-click-open">
                        <span class="labels-container-title"><liferay-ui:message key="rubrica-ricerca-risultati"/>:</span>
                        <div class="filter-label-item">
                             <h2><%=textSearch.toUpperCase()%></h2>
                        </div>
                        <div class="filter-label-item btn-filter-reset">
                            <h2><liferay-ui:message key="rubrica-ricerca-reset"/></h2><span class="icomoon-close-white"></span>
                        </div>
                    </div>
                    <%} %>                 
                </div>
            </div>
        </div>
    </div>

<div class="ama-container-fluid mb-80-xs">
        <div class="rubrica-risultati-uffici-wrapper">
            <div class="ama-row">
                <div class="ama-col-xs-12">
                    <div class="js-list-pagination">
                    
                             <c:if test="<%=jsonArrayUffici.length()<1%>"> 
                                <div class="ama-row">
                                <div class="ama-col-xs-12">
                                    <p class="copy-text wysiwyg-editor"><liferay-ui:message key="rubrica-nessun-risultato-strutture"/></p>
                                </div>
                                </div>
                             </c:if>     

							<%
                            for(int i=0;i<jsonArrayUffici.length();i++) {
                         		JSONObject jsonAnagraficaUfficio = JSONFactoryUtil.createJSONObject(jsonArrayUffici.get(i).toString());
                         	%>		 
							 
                   
                    <portlet:renderURL var="dettaglioUfficioUrl" >
                   
                    <portlet:param name="id_ufficio" value="<%=jsonAnagraficaUfficio.getJSONObject("codStruttura").getString("value")%>"/>      
			        </portlet:renderURL>   
			          
                        <div class="rubrica-item-uffici item-pagination animated fadeIn">
                            <div class="ama-col-xs-12 item-uffici-header">
                                <div class="ama-col-md-8 ama-col-xs-12 pt-10-sm border-right-box">
                               
                                     <a href="<%=dettaglioUfficioUrl%>"   class="ufficio-click">
                                     
                                        <span class="item-uffici-icon icomoon-convocanti"></span>
                                        <span class="item-uffici-labels">
                                            <h2 class="item-uffici-name"><%=jsonAnagraficaUfficio.getJSONObject("descrizione").getString("value")%></h2>                
                                            <%
											String descrCompetenza="";
                                            %>
                                           <c:if test="<%=jsonAnagraficaUfficio.getJSONObject("descr").getString("value")!=null && !jsonAnagraficaUfficio.getJSONObject("descr").getString("value").equals("")%>">
                                            
                                           <% 
                                            Document doc=Jsoup.parse(jsonAnagraficaUfficio.getJSONObject("descr").getString("value"));
                                            descrCompetenza=doc.text();
                                            %>
                                            </c:if>
                                            
                                            <p class="item-uffici-description dot-point dot-60 mt-15-xs"><%=descrCompetenza%></p>
                                        </span>
                                    </a>
                                </div>
                                
                                <%
								    JSONObject jsonDirigente = JSONFactoryUtil.createJSONObject(jsonAnagraficaUfficio.getJSONObject("dirigente").getString("value"));
                                    User utente = UserLocalServiceUtil.fetchUserByEmailAddress(themeDisplay.getCompanyId(), jsonDirigente.getJSONObject("emailAddress").getString("value"));
                                    String avatar = themeDisplay.getPathImage()+"/user_male_portrait?img_id=0";
  									if (utente!=null) {
  										avatar = utente.getPortraitURL(themeDisplay);
  									}
  								%>
                                <div class="ama-col-md-4 ama-col-xs-12 pt-10-xs pr-0-md">
                                    <div class="avatar-wrap ml-15-md ml-0-xs">
                                        <span class="scheda-anagrafica-avatar" style="background-image: url(<%=avatar%>);"></span>
                                    </div>
                                    <div class="avatar-labels">
                                        <c:if test="<%=!jsonDirigente.getJSONObject("incarico").getString("value").trim().equals("null")%>">
                                        <h2 class="label-position"><%=jsonDirigente.getJSONObject("incarico").getString("value")%></h2>
                                        </c:if>
                                        <h2 class="label-name"><%=jsonDirigente.getJSONObject("firstName").getString("value")%> <%=jsonDirigente.getJSONObject("lastName").getString("value")%></h2>
                                    </div>
                                    
                                </div>
                            </div>
                            <c:set var="tagNumber" value="<%=tagNumber%>"/>
                            
                             <c:if test="<%=jsonAnagraficaUfficio.getJSONArray("chiaviUfficio")!=null%>">
							<%
							JSONArray arrayTag = jsonAnagraficaUfficio.getJSONArray("chiaviUfficio");
							List<String> tagsAList = new ArrayList<String>(0);
							for (int index=0; index<arrayTag.length(); index++) {
								tagsAList.add(arrayTag.get(index).toString());
							}
							%>
							
                            <div class="ama-col-xs-12 item-uffici-footer text-center tags-container">    
                             <c:if test="<%=tagsAList.size()>3%>">
                             <c:forEach items="<%=tagsAList%>" var="tag" begin="0" end="2" >
                                <div class="div-label-rubrica tag"><span class="label">${tag}</span></div>       
                               </c:forEach>
                               <c:forEach items="<%=tagsAList%>" var="tag" begin="3" end="<%=tagsAList.size()-1%>">
                                 <div class="div-label-rubrica tag hide-tag"><span class="label">${tag}</span></div>
                               </c:forEach>
                                 <a href="javascript:void(0)" title="Vedi altri tag" class="div-label-rubrica yellow tags-more-click-js"><span class="label">...</span></a>
                              </c:if>  
                              <c:if test="<%=tagsAList.size()<3%>">
                              <c:forEach items="<%=tagsAList%>" var="tag">
                               <div class="div-label-rubrica tag"><span class="label">${tag}</span></div>       
                               </c:forEach>
                               </c:if>  
                            </div>
							
                             </c:if>
                            
         
                            </div>
                            
							<% } %>
							<% 
					
					 Integer pageCurrent = (Integer)request.getAttribute("pageUffici");
						 pageNumber = (Integer)request.getAttribute("numPageUffici");
					String back_btn = pageCurrent==1 ? "disabled" : "";
					String forward_btn = pageCurrent==pageNumber ? "disabled" : "";

					 %>
							<c:if test="<%= pageNumber>1 %>">
							 <portlet:actionURL var="paginaUfficiURL" name="paginaUffici"/></portletactionURL>

                    <form style="display:none" id="formPaginaUffici" action="<%=paginaUfficiURL%>" method="POST" enctype="multipart/form-data">
						<input type="hidden" name="<portlet:namespace/>numpage" id="numpageUffici">
					</form>
                   	   <div class="ama-col-xs-12 text-align-center">
                                    <div data-totpage-mobile="" class="paginator-wrap-dark paginator-wrap">
					
									<div class="btn-back-arrow <%= back_btn %>">
                                        <a href="#" onclick="showPagina(event, <%=pageCurrent-1%>,'Uffici')"><em class="icomoon-arrow"></em></a>
                                        </div>
                                        <ul class="pagination-numbers">
										
										<c:set var="currentPage" value="<%= pageCurrent %>"/>
										<c:forEach var="tag" begin="1" end="<%=pageNumber%>" >
											<c:choose>
											<c:when test="${tag==currentPage}">
												<li id="pageClick${tag}" class="current-page"><a href="#" onclick="showPagina(event,${tag},'Uffici')" >${tag}</a></li>
											</c:when>
											<c:otherwise>
												<li id="pageClick${tag}"><a href="#" onclick="showPagina(event,${tag},'Uffici')">${tag}</a></li>
											</c:otherwise>
											</c:choose>
										</c:forEach>
                                        </ul>
                                        <div class="btn-forward-arrow <%= forward_btn %>">
                                            <a href="#" onclick="showPagina(event,<%=pageCurrent+1%>,'Uffici')">
                                                <em class="icomoon-arrow"></em>
                                            </a>
                                        </div>
                                    </div>
                      </div> 

					  </c:if>
                    </div> 
                </div>
            </div>
        </div>
    </div>
   </c:if>
   <div id="idSpinner" class="spinner-wrap">
        <div class="spinner">
            <div class="bounce1"></div>
            <div class="bounce2"></div>
            <div class="bounce3"></div>
        </div>
    </div>
   
<script>
	
	function showPagina(event, id, tagId) {
		event.preventDefault();
		$("#numpage" + tagId).val(id);
		$("#formPagina" + tagId).submit();
	}


var enterPressedPersone = false;
var enterPressedUffici = false;	
$('.icomoon-close-white').on('click',function(){
	 window.location.href =  window.location.href.split('?')[0];
});
	
$('#inputLastname').keyup(function(e){	
	if (e.which <= 90 && e.which >= 48 || e.which == 8)
    {	
		suggestInput($(this).val(),$(this).attr('id'));
		enterPressedPersone = false
    }
	else if(e.which==13){
		if($("html").hasClass("ie10") || $("html").hasClass("ie11")){
			
			  if (enterPressedPersone == false) {	 
				  enterPressedPersone =true;		
			  }
			  else if(enterPressedPersone == true){		
				  document.getElementById('btn-search').click();  
				  enterPressedPersone=false;
			  }	
		}
		else{
			 document.getElementById('btn-search').click();  
		}
		
	}
	else{
		enterPressedPersone = false
	}
});


$('#inputKeyword').keyup(function(e){	
	if (e.which <= 90 && e.which >= 48 || e.which == 8)
    {	
		suggestInput($(this).val(),$(this).attr('id'));
		enterPressedUffici = false
    }
	else if(e.which==13){
		if($("html").hasClass("ie10") || $("html").hasClass("ie11")){
			
			  if (enterPressedUffici == false) {	 
				  enterPressedUffici =true;		
			  }
			  else if(enterPressedUffici == true){		
				  document.getElementById('btn-search-uffici').click();  
				  enterPressedUffici=false;
			  }	
		}
		else{
			 document.getElementById('btn-search-uffici').click();  
		}
		
	}
	else{
		enterPressedUffici = false
	}
});



function suggestInput(input, id){
		
	   if(input.length>2){

	          
	          if(id==="inputLastname") {
	                Liferay.Service(
	                              '/mefrubrica.searchdata/suggest-last-name',
	                              {
	                                firstName: '',
	                                lastName: input
	                              },
	                              function(obj) {
	                                   var options = ''; 
	                                   document.getElementById('suggLastnameList').innerHTML=''; 
	                                    $.each(obj,function(key, value){                             
	                                          var list=value.lastName.value;

	                                          options += '<option value="'+list+'" />';                              
	                                    });
	                                
	                                   document.getElementById('suggLastnameList').innerHTML=options;     
	   	                  	    	$('#inputLastname').trigger("focus"); 
	   	                  
	                              });
	               
	             
	                              }
	            if(id==="inputKeyword") {
	                  Liferay.Service(
	                                '/mefrubrica.searchdata/suggest-parola-chiave',
	                                {
	                                  chiave: input
	                                },
	                                function(obj) {
	                                	
	                                    var options = ''; 
	                                    document.getElementById('suggKeywordList').innerHTML = '';
	                             $.each(obj,function(key, value){                               
	                                   var list=value.parolaChiave.value;
	                                   options += '<option value="'+list+'" />';                              
	                             });
	                              document.getElementById('suggKeywordList').innerHTML = options;   
	                              $('#inputKeyword').trigger("focus"); 
	                                }
	                              );    
	         }      
	    }
	    
	    else {
	    	if(document.getElementById("suggLastnameList").options.length>0) {
	    	document.getElementById('suggLastnameList').innerHTML = '';
	    	$('#inputLastname').trigger("blur");
	    	$('#inputLastname').trigger("focus");  
	    	}
	    	else if (document.getElementById("suggKeywordList").options.length>0) {
	    	document.getElementById('suggKeywordList').innerHTML = '';
	    	 $('#inputKeyword').trigger("blur");
	    	 $('#inputKeyword').trigger("focus");
	    }   
	}

}

$('#inputLastname').focus(function(){
	
});

$('#inputKeyword').focus(function(){
	
});


var selectIdArray = [$("#structure").attr("id"), $("#structure-one").attr("id"), $("#structure-two").attr("id"), $("#structure-three").attr("id"), $("#structure-four").attr("id")];

function handleSelect(selectedVal, id) {
	if(selectedVal!='847' &&  id=='structure'){
	if (selectedVal==='CONSIP' || selectedVal==='SOGEI') {
		
		$("#qualification").prop("disabled",true);
		$("label[for = qualification]").text("");
		$("label[for = qualification]").text("<liferay-ui:message key='rubrica-qualifica'/>");
		$("#qualification").val("");
		$("label[for = surname]").text("");
		$("label[for = surname]").text("<liferay-ui:message key='rubrica-cognome'/>");
	}
	if (selectedVal==='') {
		$("#structure").addClass("parsley-or-validator-field data-parsley-validated");
		$("#structure-label").addClass("parsley-or-validator-label");
		$("#structure-one").removeClass("parsley-or-validator-field data-parsley-validated");
		$("#structure-one-label").removeClass("parsley-or-validator-label");
	}
		
		for (var i = 1; i < selectIdArray.length; i++) {
		var select = document.getElementById(selectIdArray[i]);
		$(select).find('option').remove().end().append("<option value='0'>Scegli dall'elenco</option>").val('0');
		select.disabled = true;
		$(select).closest('div').addClass('hide');
		}
	
	}
	else {
		
	$('.structure_hidden').each(function(key,value){
		$(this).removeClass('hide');
	});
		
	$("#structure-one").addClass("parsley-or-validator-field data-parsley-validated");
	$("#structure-one-label").addClass("parsley-or-validator-label");
	$("#structure").removeClass("parsley-or-validator-field data-parsley-validated");
	$("#structure-label").removeClass("parsley-or-validator-label");
	$("label[for = surname]").text("");
	$("label[for = surname]").text("<liferay-ui:message key='rubrica-cognome'/>*");
	$("#qualification").prop("disabled",false);
	$("label[for = qualification]").text("");
	$("label[for = qualification]").text("<liferay-ui:message key='rubrica-qualifica'/>*");
	
	$('#idSpinner').addClass('visible');
	    
	    for (var i = 0; i < selectIdArray.length; i++) {
	    
	    	if(id==selectIdArray[i]) {
	    		
	    		var select = document.getElementById(selectIdArray[i+1]);
	    		$(select).find('option').remove().end().append("<option value=''>Scegli dall'elenco</option>").val('');
	    		
        		Liferay.Service(
        		  '/mefrubrica.searchdata/get-list-strutture-interne',
        		  {
        		    idStruttura: selectedVal
        		  },
        		  function(obj) {
        			
        		    if(obj.length > 0) {
        		    
        		    jsonObj = [];
        		    	
        		    for (var i=0; i<obj.length; i++) {
        		    	
        		    	var codiceStruttura = (obj[i].codStruttura).value;
        		    	
        		    	Liferay.Service(
        		    			  '/mefrubrica.searchdata/serv-dettagli-ufficio',
        		    			  {
        		    			    idUfficio: codiceStruttura
        		    			  },
        		    			  function(obj2) {
        		    				  
        		    				  var item = {};
        		    				 
        		    				  if(id=="structure"){
        		    					 
        		    					 item = {
        		        		    			    'codiceStruttura' : (obj2[0].codStruttura).value,
        		        		    			    'descStruttura' : (obj2[0].acronimo).value
        		        		    			    }  
        		    				  }
        		    				  else{
        		    			     item = {
        		    			    'codiceStruttura' : (obj2[0].codStruttura).value,
        		    			    'descStruttura' : (obj2[0].descrizione).value
        		    			    }
        		    				  }
        		    			    jsonObj.push(item);
        		    			    
        		    			    jsonObj.sort(function(a, b) {
  											return compareStrings(a.descStruttura, b.descStruttura);
									});
									
									if (obj.length===jsonObj.length) {
										for (var i=0; i<jsonObj.length; i++) {
        		    			    	var structureOption = document.createElement('option');
        		        		    	structureOption.text = jsonObj[i].descStruttura;
        		        		    	structureOption.value = jsonObj[i].codiceStruttura;
        		        		    	select.appendChild(structureOption);
        		        		    	
        		        		    	var selectLength = select.length;
        		            		    if (obj.length+1===selectLength) {
         		            		    	select.disabled = false;
        		            		    	$('#idSpinner').removeClass('visible'); 	
        		            		    }
        		    			    }
									}  

        		    			  });
        		    };
        		    }
        		    else {
                    select.disabled = true;
        		      $('#idSpinner').removeClass('visible');
        		    }
        		    
        		    
        		  }
        		);
        }
    }
}
}

function submitFormUffici(){
	$("#inputKeyword").parsley().validate();
	if($("#inputKeyword").parsley().isValid()){
	$('#submitKey').submit();
	}
}



function submitTag(e,key){
	e.preventDefault();
	$('#tagNuvola').val("");
	$('#tagNuvola').val(key);
	
	var tagNuvola=$('#tagNuvola').val();

	$('#submitKey').submit();
}

function resetForm() {
	document.getElementById("frmRicercaPersone").reset();
	for (var i = 1; i < selectIdArray.length; i++) {
		var select = document.getElementById(selectIdArray[i]);
		$(select).find('option').remove().end().append("<option value='0'>Scegli dall'elenco</option>").val('0');
		select.disabled = true;
		
	}
	
}

function compareStrings(a, b) {
    a = a.toLowerCase();
    b = b.toLowerCase();

    return (a < b) ? -1 : (a > b) ? 1 : 0;
}

function showSpinner() {
	$('#inputLastname').val($('#inputLastname').val().trim());	
	if($('#inputLastname').val()!='' ){
		$("#inputLastname").parsley().validate();
		if($("#inputLastname").parsley().isValid()){
			 $("#idSpinner").addClass("visible");
			$("#frmRicercaPersone").submit();
		 }
	}
	
	else{
	
	$("#mefRicercaId").parsley().validate();
	
	if($("#mefRicercaId").parsley().isValid()){
		 $("#idSpinner").addClass("visible");
		 $("#frmRicercaPersone").submit();
	 }
	}
}

if('<%=json%>'!=null && '<%=json%>'!=""){
	$("#idSpinner").removeClass("visible");
}



$('#<portlet:namespace/>lenteRicercaUfficio').on('click',function(){	 
	submitFormUffici();
});

$('#<portlet:namespace/>lenteRicercaNome').on('click',function(){	 
	showSpinner();
});

$('#<portlet:namespace/>lenteRicercaCognome').on('click',function(){	 
	showSpinner();
});


</script>
