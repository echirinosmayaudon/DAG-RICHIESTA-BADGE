<%@ include file="/init.jsp" %>
<%@page import="com.intranet.mef.gestione.riunioni.service.AmministrazioneConvocanteLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.LuogoLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.TipoRiunioneLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.Luogo"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.TipoRiunione"%>
<%@page import="com.mef.ricercariunione.stub.Segreteria"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.intranet.mef.util.BeanCreator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
<%
BeanCreator segrUtil = new BeanCreator();

List<AmministrazioneConvocante> amministrazioni = segrUtil.getAmministrazioniConvocantiList();

List<Luogo> luoghi = segrUtil.getLuoghiList();

/*List<AmministrazioneConvocante> amministrazioni_ord = AmministrazioneConvocanteLocalServiceUtil.getAmministrazioneConvocantes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

List<AmministrazioneConvocante> amministrazioni = new ArrayList<AmministrazioneConvocante>();
amministrazioni.addAll(amministrazioni_ord);
Collections.sort(amministrazioni, new Comparator<AmministrazioneConvocante>() {				
	@Override
	public int compare(AmministrazioneConvocante o1, AmministrazioneConvocante o2) {
		return (o1.getNome_amministrazione().trim().toUpperCase().compareTo(o2.getNome_amministrazione().trim().toUpperCase()));
	}
});

List<Luogo> luoghi = new ArrayList<Luogo>();

List<Luogo> luoghi_ord = LuogoLocalServiceUtil.getLuogos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
luoghi.addAll(luoghi_ord);
Collections.sort(luoghi, new Comparator<Luogo>() {				
	@Override
	public int compare(Luogo o1, Luogo o2) {
		return (o1.getNome().trim().toUpperCase().compareTo(o2.getNome().trim().toUpperCase()));
	}
});
*/




List<TipoRiunione> tipiRiunione = segrUtil.createListaTipiRiunione();

List<StatoInvitato> listStatoInvitatoDB = segrUtil.createListaStatoInvitato();




ArrayList <Segreteria> listSegreteria = segrUtil.createListaSegreterie();
List<Segreteria> invitati =new ArrayList<>();

String titoloPrincipaleInserisci=ParamUtil.getString(request, "titleCreaRiunione");
String titoloInserisci=ParamUtil.getString(request, "subTitleCreaRiunione");

if(titoloPrincipaleInserisci.isEmpty() && titoloInserisci.isEmpty()){
	titoloPrincipaleInserisci=(String)request.getAttribute("titleCreaRiunione");
	titoloInserisci=(String)request.getAttribute("subTitleCreaRiunione");
}

String titoloPrincipaleLuoghi=ParamUtil.getString(request, "titleLuoghiRiunione");
String titoloLuoghi=ParamUtil.getString(request, "subTitleLuoghiRiunione");

if(titoloPrincipaleLuoghi.isEmpty() && titoloLuoghi.isEmpty()){
	titoloPrincipaleLuoghi=(String)request.getAttribute("titleLuoghiRiunione");
	titoloLuoghi=(String)request.getAttribute("subTitleLuoghiRiunione");
}
String titoloPrincipaleconvocanti=ParamUtil.getString(request, "titleConvocantiRiunione");
String titoloconvocanti=ParamUtil.getString(request, "subTitleConvocantiRiunione");

if(titoloPrincipaleconvocanti.isEmpty() && titoloconvocanti.isEmpty()){
	titoloPrincipaleconvocanti=(String)request.getAttribute("titleConvocantiRiunione");
	titoloconvocanti=(String)request.getAttribute("subTitleConvocantiRiunione");
}
%>

<portlet:renderURL var="gestioneConvocantiURL">
							<portlet:param name="mvcPath" value="/gestioneConvocanti.jsp" />
							<portlet:param name="titleConvocantiRiunione" value="<%=titoloPrincipaleconvocanti%>" />
							<portlet:param name="subTitleConvocantiRiunione" value="<%=titoloconvocanti%>" />
							<portlet:param name="previousPage" value="inserimentoRiunione" /> 
						</portlet:renderURL>

<portlet:renderURL var="gestioneLuoghiURL">
							<portlet:param name="mvcPath" value="/gestioneLuoghi.jsp" />
							<portlet:param name="titleLuoghiRiunione" value="<%=titoloPrincipaleLuoghi%>" />
							<portlet:param name="subTitleLuoghiRiunione" value="<%=titoloLuoghi%>" />
							<portlet:param name="previousPage" value="inserimentoRiunione" /> 
						</portlet:renderURL>
<div class="gestione-riunioni-crea-wrapper">

<div class="gestione-riunioni-title-box">
		<div class="ama-container-fluid">
			<div class="ama-row">
				<div class="ama-col-xs-12">
					<div class="title-wrapper">
						<h2 class="title text-uppercase"><%=titoloPrincipaleInserisci%></h2>
						<div class="wrapper-content">
							<a title="Luoghi" class="icomoon-location2" href="<%=gestioneLuoghiURL%>">
								<span class="sr-only text-uppercase" >
								<liferay-ui:message key="header-riunioni-luoghi" /></span>
							</a> 
							<a title="<liferay-ui:message key="header-riunioni-convocanti-title" />" class="icomoon-convocanti" href="<%=gestioneConvocantiURL%>"> <span
								class="sr-only text-uppercase"><liferay-ui:message key="header-riunioni-convocanti" /></span>
							</a>
						</div>
						<p class="subtitle dot-point dot-200"><%=titoloInserisci%></p>
					</div>
				</div>
			</div>
		</div>
</div>	
<div class="ama-container-fluid">
		<div class="ama-row">
			<div class="ama-col-xs-12">
				<div class="dati-riunione-wrap">
					<div class="title-wrapper-blank pb-50-xs">
						<div class="title text-uppercase">
							<liferay-ui:message key="gestione-riunione-inserimento-dati" /> <a href="#" title='<liferay-ui:message key="gestione-riunione-inserimento-info-title" />'
								class="tooltip-field icon-information"> <span
								class="icomoon-info"></span>
							</a>
						</div>
					</div>

					<portlet:actionURL var="inserisciRiunioneURL"
						name="inserisciRiunione" />
					</portletactionURL>

					<form class="form-riunioni-crea" action="<%=inserisciRiunioneURL%>"
						method="POST" id="saveForm" data-parsley-validate="" enctype="multipart/form-data">
						<div class="ama-row">
							<div class="ama-col-sm-6 ama-col-xs-12">
								<label class="label-form text-uppercase">
									<liferay-ui:message key="gestione-riunione-inserimento-amministrazione-convocante" />*
								</label> 
								<select
									 name="<portlet:namespace/>AmministrazioneConvocante" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
									<c:if test="<%=amministrazioni != null%>">
										<option value="" hidden><liferay-ui:message key="gestione-riunione-inserimento-amministrazione-convocante-select" /></option>
										<c:forEach items="<%=amministrazioni%>" var="amministrazioneC">
											<option
												value="${amministrazioneC.getId_amministrazione_convocante()}">${amministrazioneC.getNome_amministrazione().toUpperCase()}</option>
										</c:forEach>
									</c:if>
								</select>
							</div>
							<div class="ama-col-sm-6 ama-col-xs-12 ">	
								<label class="label-form text-uppercase">
								<liferay-ui:message key="gestione-riunione-inserimento-tipologia" />
								</label> 
								<select name="<portlet:namespace/>Tipo">
									<option value="" hidden><liferay-ui:message key="gestione-riunione-inserimento-tipologia-select" /></option>
									<c:if test="<%=tipiRiunione != null%>">
										<c:forEach items="<%=tipiRiunione%>" var="tipoR">
											<option value="${tipoR.getId_tipo()}">${tipoR.getDescrizione().toUpperCase()}</option>
										</c:forEach>
									</c:if>
								</select>
							</div>
						</div>
						<div class="ama-row mt-25-sm">
							<div class="ama-col-xs-6 ama-col-sm-3 ">
								<label class="label-form text-uppercase"><liferay-ui:message key="gestione-riunione-inserimento-data-inizio" />*</label> <input
									type="text" 
									id="startDate"
									class="datepicker-custom input-custom-light" name="<portlet:namespace/>DataInizio"
									placeholder="DD/MM/AAAA" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
									data-parsley-pattern="/(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(20)\d\d/"
									data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
									>
							</div>
							<div class="ama-col-xs-6 ama-col-sm-3 ">
								<label class="label-form text-uppercase"><liferay-ui:message key="gestione-riunione-inserimento-ora-inizio" />*</label> <input type="text"
									name="<portlet:namespace/>OraInizio" class="input-custom-light"
									placeholder="HH:MM" data-parsley-required="true" 
									data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
									data-parsley-pattern="([0-1][0-9]|[2][0-4]):([0-5][0-9])" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
									data-parsley-checkhour="#startDate" data-parsley-check-start-date="#startDate" value="">
							</div>
							<div class="ama-col-xs-12 ama-col-sm-6 ama-col-xs-12 ">
								<label class="label-form text-uppercase"><liferay-ui:message key="gestione-riunione-inserimento-luogo"/>*</label> <select
									name="<portlet:namespace/>Luogo" data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
									<option value="" hidden><liferay-ui:message key="gestione-riunione-inserimento-luogo-select"/></option>
									<c:if test="<%=luoghi != null%>">
										<c:forEach items="<%=luoghi%>" var="luogoR">
											<option value="${luogoR.getId_luogo()}">${luogoR.getNome().toUpperCase()}</option>
										</c:forEach>
									</c:if>
								</select>
							</div>
						</div>
						
						<div class="ama-row mt-25-sm">
				
				<div class="ama-col-sm-6 ama-col-xs-12">
					<div class="wrapper-content-textarea">
					 <label class="label-form"><liferay-ui:message key="gestione-riunione-inserimento-protocollo"/></label>
                     
					 <textarea class="form-control textarea-custom-light textarea-protocollo" 
						   	id="setProtocollo" 			
onkeypress="if (event.keyCode==13){return false;}"							
							data-parsley-maxlength="50" 
							data-parsley-maxlength-message='<liferay-ui:message key="error-maxlength-char-message" arguments="<%=new String[]{\"50\"}%>"/>'
                        placeholder='<liferay-ui:message key="gestione-riunione-inserimento-protocollo-placeholder"/>'

							name="<portlet:namespace/>Protocollo" ></textarea>
                        <div class="content-textarea">0/   
							<p class="color-gray">50</p>
                        </div>
						
					 
				</div>
				</div>

			</div>
			
			
						
					
					
						
						
						<div class="ama-row mt-25-sm">
							<div class="ama-col-xs-12 ">
								<div class="wrapper-content-textarea">
								<label class="label-form text-uppercase"><liferay-ui:message key="gestione-riunione-inserimento-oggetto"/>*</label> 
								<textarea 
										data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"
                                        data-parsley-maxlength="500" 
										onkeypress="if (event.keyCode==13){return false;}"
										data-parsley-maxlength-message='<liferay-ui:message key="error-maxlength-char-message" arguments="<%=new String[]{\"500\"}%>"/>'
										data-parsley-required="true"
                                        data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
										class="form-control textarea-custom-light textarea-oggetto"
										name="<portlet:namespace/>Oggetto"                                       
										placeholder='<liferay-ui:message key="gestione-riunione-inserimento-oggetto-placeholder"/>'></textarea>
									<div class="content-textarea" >
										0/ 
										<p class="color-gray">500</p>
									</div>
									
									
								
							</div>
							</div>
						</div>
						
						<div class="ama-row mt-25-sm">
							<div class="ama-col-xs-12 ">
								<div class="wrapper-content-textarea">
									<label class="label-form margin-top text-uppercase" for="textarea-detail">
									<liferay-ui:message key="gestione-riunione-inserimento-note"/></label>
									<textarea 
										data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"
                                        data-parsley-maxlength="4000" 
										data-parsley-maxlength-message='<liferay-ui:message key="error-maxlength-char-message" arguments="<%=new String[]{\"4000\"}%>"/>'
                                        data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
                                     	
										class="form-control textarea-custom-light textarea-note"
										name="<portlet:namespace/>Note"                                       
										placeholder='<liferay-ui:message key="gestione-riunione-inserimento-note-placeholder"/>'></textarea>
									<div class="content-textarea" >
										0/ 
										<p class="color-gray">4000</p>
									</div>
								</div>
							</div>
						</div>
						<div class="tab-filtri">
							<div class="filtro-tabs-wrapper mt-40-xs">
                                    <span title="<liferay-ui:message key="gestione-riunione-inserimento-invitati-title"/>" class="tab-title active text-uppercase"><liferay-ui:message key="gestione-riunione-inserimento-invitati"/></span>
                            </div>	
							<div class="clearfix box-tab-invitati">
								<div class="ama-col-md-3 ama-col-sm-4">
                                        <div class="invitati-selection-container">
                                            <div class="invitati-selection-header">
                                                <span class="header-text"><liferay-ui:message key="gestione-riunione-inserimento-ispettorato"/></span>
                                            </div>
                                            <div class="invitati-selection-body">
                                                <div id="segreterie" class="selection-item-container">
                                                   
												   
                                                </div>
                                            </div>
                                            <div class="invitati-selection-footer">
                                                <button class="button button-primary" type="button" onclick='addInvite(".checkbox-custom")'>
												<liferay-ui:message key="gestione-riunione-inserimento-aggiungi"/>
												</button>
                                            </div>
                                        </div>
                                    </div>
								<div id="invitati" class="ama-col-md-9 ama-col-sm-8 invitati-item-selected-wrap mobile-no-padding">
								 
								 
								</div>
							</div>
							<div class="buttons-wrapper ama-col-xs-12 mb-60-xs mobile-no-padding">
                                    <div class="ama-col-sm-6 ama-col-xs-12 text-center mobile-no-padding">
                                        <button class="button button-secondary text-uppercase" type="button" onclick="resetForm()">
										<liferay-ui:message key="gestione-riunione-inserimento-annulla"/></button>
                                    </div>
                                    <div class="ama-col-sm-6 ama-col-xs-12 text-center mobile-no-padding">
                                        <button class="button button-primary text-uppercase"  type="button" onclick="saveForm()">
										<liferay-ui:message key="gestione-riunione-inserimento-salva"/></button>
                                    </div>
                                </div>
						</div>
						<input type="hidden" id="listInvitati"
							name="<portlet:namespace/>saveInvitati">
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript"> 

//!!! nell'HTML devono essere presenti due div con i seguenti id
invitatiDiv = "#invitati"; // tutti gli invitati saranno all'interno di un div con id="invitati" presente nell'HTML
segreterieDiv = "#segreterie"; // tutte le segreterie non ancora invitate saranno all'interno di un div con id="segreterie" presente nell'HTML

var arrayInvitati; //contiene la lista di tutti gli invitati alla riunione in formato json
var arraySegreterie; //contiene la lista di tutte le segreterie non ancora invitate in formato json

var arrayStatoInvitato; //contiene tutti gli stati possibili degli invitati
	
	
	var flagCapoFila = false;
	
	
	resetForm(); //ritorna alla visualizzazione iniziale
	
	function resetForm(){
		document.getElementById("saveForm").reset(); //resetta tutti i campi del form
//inizializza l'array degli invitati prendendo i valori dall'array invitati scritto in java 
		arrayInvitati = new Array(<%
				for(int i = 0; i < invitati.size(); i++) {
					   out.print(invitati.get(i).toJSON());
					  if(i+1 < invitati.size()) {
					    out.print(",");
					  }
					}	
			%>); 
//inizializza l'array degli invitati prendendo i valori dall'array listSegreteria scritto in java 
		arraySegreteria = new Array(<%
				for(int i = 0; i < listSegreteria.size(); i++) {
				   out.print(listSegreteria.get(i).toJSON());
				  if(i+1 < listSegreteria.size()) {
				    out.print(",");
				  }
				}	
		%>); 
		
		//stato
		arrayStatoInvitato = new Array(<%
				for(int i = 0; i < listStatoInvitatoDB.size(); i++) {
				   out.print("{'id':'" + listStatoInvitatoDB.get(i).getId_stato_invitato()+"', 'nome':'"+ listStatoInvitatoDB.get(i).getNome_stato()+"'}");
				  if(i+1 < listStatoInvitatoDB.size()) {
				    out.print(",");
				  }
				}	
		%>); 
		
		updateHTML(); //aggiorna la visualizzazione della pagina

				

	}

	function findElement(arr, propName, propValue) {
	  for (var i=0; i < arr.length; i++)
		if (arr[i][propName] == propValue)
		  return i;
	  return -1;
	}
	

	/*sposta le segreterie selezionate nella lista degli invitati alla riunione
		classCheckbox -> è la variabile che contiene il nome della classe presente nel 
		tag input con l'attributo type=checkbox della segreteria
		ad esempio:
			Se questo tag contiene la segreteria
				<input class="checkbox-custom" type="checkbox" id="segreteria1">
			per richiamare questo metodo occorre scrivere:
				addInvite(".checkbox-custom")
		
	*/
	function addInvite(classCheckbox) {
				
		$(classCheckbox).each(function() {

			if ($(this).is(":Checked")){
		
            	arrayInvitati.push(JSON.parse($(this).val()));
            	//var index = arraySegreteria.findIndex(i => i.id === (JSON.parse($(this).val()).id));
				arrayInvitati.sort(function(a, b){
					if(a.index < b.index) return -1;
					if(a.index > b.index) return 1;
					return 0;
				});
				var index = findElement(arraySegreteria,"id",JSON.parse($(this).val()).id);
            	arraySegreteria.splice(index, 1);
            	updateHTML();
            }
		});
	}
	
	
	
	//rimuove un invitato dalla lista degli invitati e lo aggiunge alla lista delle segreterie
	function deleteInvite(index, item){
			event.preventDefault();
			
			if(item.capofila==true){
				item.capofila = false;
			}
			item.index=0;
			
			arraySegreteria.push(item);
			arraySegreteria.sort(function(a, b){
					if(a.nome < b.nome) return -1;
					if(a.nome > b.nome) return 1;
					return 0;});
			arrayInvitati.splice(index, 1);
			arrayInvitati.sort(function(a, b){
				if(a.index < b.index) return -1;
				if(a.index > b.index) return 1;
				return 0;
			});
					
			if (arrayInvitati.length>0){
				arrayInvitati[0].capofila=true;
			}else
				flagCapoFila = false;
			updateHTML();
	}

//aggiorna la visualizzazione degli invitati e delle segreterie non ancora invitate
	function updateHTML(){
		$(segreterieDiv).empty();
	    $(invitatiDiv).empty();
	
		//crea la struttura HTML per ogni singola segreteria non ancora invitata all'interno del div il cui id è presente nel tag divMaster
		//type:checkbox -> identifica che la segreteria si può selezionare attraverso l'attributo checkbox
		arraySegreteria.forEach(addSegreterieHTML,{type:"checkbox",divMaster:segreterieDiv});
		//crea la struttura HTML per ogni singolo invitato all'interno del div il cui id è presente nel tag divMaster
		arrayInvitati.forEach(addInvitatiHTML,{divMaster: invitatiDiv});	
	}


	/*salva tutti gli invitati in un input di tipo hidden, il quale verrà ripreso lato backend 
	per potere aggiungere gli invitati effettivamente alla riunione */
	function saveForm(){	
	
		json = {"invitati" : arrayInvitati};
		$("#listInvitati").val(JSON.stringify(json));
		$("#saveForm").submit();
		
	}
	    
	 /* per ogni invitato contenuto nell'array invitati viene richiamata questa funziona,
	 la quale crea dei tag HTML per la visualizzazione degli invitati nella pagina di riferimento
	
	Ogni invitato avrà questa struttura HTML:
		 <div class="ama-col-md-4 ama-col-sm-6 invitati-item-container">
			 <div class="invitati-item">
				 <div class="invitati-message">DA NOTIFICARE</div>
				 <p class=" invitati-name">IGECOFIP</p>
				 <a href="" class="icomoon-close-white"></a>
			</div>
		</div>
	!!!specificare sempre il div dove saranno inseriti gli invitati, utilizzando la struttura json {divMaster: "#idDivPadre" }

	esempio di richiamo della funzione:
		arrayInvitati.forEach(addInvitatiHTML,{divMaster: "#invitati" });
		arrayInvitati è un array che contiene gli invitati in formato json 
		divMaster è l'id del tag HTML nella quale saranno inseriti gli invitati
	
 */
	
 	function addInvitatiHTML(item,index,arr){

	 		var divContainer = document.createElement("div");
			$(divContainer).addClass('ama-col-md-4 ama-col-sm-6 invitati-item-container');
			var divItem =  document.createElement("div");
			$(divItem).addClass('invitati-item');
			
			var divMessage =  document.createElement("div");
			$(divMessage).addClass('invitati-message');
			
			var indexStato = findElement(arrayStatoInvitato,"id",item.stato);
			
			if (indexStato==-1)
				stato = "<liferay-ui:message key='gestione-riunione-inserimento-in-attesa'/>";
			else{
				stato = (JSON.stringify(arrayStatoInvitato[indexStato])).nome;
			}

			
			$(divMessage).text(stato);

			/*salva l'invitato in un tag input di tipo 
			hidden per poterlo cancellare successivamente*/
			var input = document.createElement("input");
			$(input).attr("type","hidden");
			$(input).attr("value",item.id);
			
			var pNomeInvitato = document.createElement("p");
			$(pNomeInvitato).addClass('invitati-name');
			$(pNomeInvitato).text(item.nome);

			
			var aClose = document.createElement("a");
			$(aClose).attr('href','');
			$(aClose).addClass('icomoon-close-white');
			
			$(aClose).click(function() {
				deleteInvite(index,item);
			});

			$(divItem).append(divMessage);
			$(divItem).append(pNomeInvitato);
			$(divItem).append(aClose);
			$(divItem).append(input);
			
			

			$(divContainer).append(divItem);
			if 	($(this.divMaster)!= null){
				$(this.divMaster).append(divContainer);
			}else{
			}

		}
		
 /* per ogni segreteria contenuta nell'array segreteria viene richiamata questa funziona,
	 la quale crea dei tag HTML per la visualizzazione delle segreterie non ancora invitate nella pagina di riferimento
	
	Ogni segreteria avrà questa struttura HTML:
		<div class="checkbox-invitati">
			<input class="checkbox-custom" type="checkbox" id="segreterie1">
			<label class="selection-item" for="segreterie1">
				<span class="item-name">LOREM IPSUM DOLOR CONSECTETUR</span>
				<span class="icomoon-riunione-ok item-icon"></span>
			</label>
		
		</div>      
	!!!specificare sempre il div dove saranno inseriti le segreterie, utilizzando la struttura json {divMaster: "#idDivPadre" }

	esempio di richiamo della funzione:
		arraySegreteria.forEach(addSegreterieHTML,{type:"checkbox",divMaster:segreterieDiv});
		arraySegreteria è un array che contiene le segreterie in formato json 
		divMaster è l'id del tag HTML nella quale saranno inseriti gli invitati
		type:checkbox -> identifica che la segreteria si può selezionare attraverso l'attributo checkbox, 
						questo parametro non è obbligatorio, di default viene specificato checkbox
*/
	function addSegreterieHTML(item,index,arr) {

		var div = document.createElement("div");
		$(div).addClass('checkbox-invitati');
		var label = document.createElement("label");
		$(label).addClass('selection-item');
		label.innerHTML= ' <span class="item-name">' + item.nome + '</span><span class="icomoon-riunione-ok item-icon"></span>' ;
		
		var input = document.createElement("input");
		if 	($(this.type)!= null){
			$(input).attr("type", this.type);
		}else{
			$(input).attr("type", "checkbox");	
		}
		
		$(input).click(function() {
			indexSeg = findElement(arraySegreteria,"id",JSON.parse($(this).val()).id);

			if ( $(this).is(":Checked")){
				
				if(flagCapoFila==false){
					arraySegreteria[indexSeg].capofila=true;
					flagCapoFila = true;
				}
				
				arrayAux = arrayInvitati.slice();
				arraySegAux = arraySegreteria.slice();
										
				arrayAux.sort(function(a, b){
					if(a.index < b.index) return -1;
					if(a.index > b.index) return 1;
					return 0;
				});
				indexInvitato=0;
				if(arrayAux.length >0){
					indexInvitato= arrayAux[arrayAux.length-1].index;
				}
				 
				
				arraySegAux.sort(function(a, b){
					if(a.index < b.index) return -1;
					if(a.index > b.index) return 1;
					return 0;
				});
				indexSegreteria = 0;
				if(arraySegAux.length >0){
					indexSegreteria =arraySegAux[arraySegAux.length-1].index;
				}				
				if (indexSegreteria>indexInvitato)
					arraySegreteria[indexSeg].index=indexSegreteria+1;
				else
					arraySegreteria[indexSeg].index=indexInvitato+1;

			}else{
				if(arraySegreteria[indexSeg].capofila==true){
					arraySegreteria[indexSeg].capofila=false;
					flagCapoFila = false;
				}
				arraySegreteria[indexSeg].index=0;

				
			}
			$(this).val(JSON.stringify(arraySegreteria[indexSeg]));
			
		});
		
		$(input).attr("id", index);
		$(input).val(JSON.stringify(item));
		$(input).addClass('checkbox-custom').appendTo(div);
		$(label).attr("for", index);
		$(div).append(label); 

		if 	($(this.divMaster)!= null){
			$(this.divMaster).append(div);
		}else{
		}
		
		
	   
	}
	


	
	
</script>