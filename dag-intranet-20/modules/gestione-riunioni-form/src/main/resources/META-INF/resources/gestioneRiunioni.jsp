
<%
double itemsdelta = 0;
double numeroPagine = 0;


List<RiunioneBean> lista_res = new ArrayList<RiunioneBean>();	

boolean flagRicerca = false;
if(request.getAttribute("risultati")!= null) {
	lista_res =(List<RiunioneBean>)request.getAttribute("risultati");
flagRicerca = true;
	}
else {
	lista_res =(List<RiunioneBean>)request.getAttribute("prossime_riunioni");
}

String idSegreteria = (String)request.getAttribute("idSegreteria");

double numeroTotRisultati = new Double(lista_res.size());

SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
SimpleDateFormat sdfOra = new SimpleDateFormat("HH:mm");
Date da =(Date)request.getAttribute("data_oggi");
Date a =(Date)request.getAttribute("data_settimana");

String param_chiave="";
if(request.getAttribute("param_chiave")!= null){
	param_chiave = (String) request.getAttribute("param_chiave");	
}

String param_da = "";
if(request.getAttribute("param_da")!= null){
	param_da=(String) request.getAttribute("param_da");	
}

String param_a = "";
if(request.getAttribute("param_a") != null){
	param_a = (String) request.getAttribute("param_a");	
}

String param_stato = "";
if(request.getAttribute("param_stato")!= null){
	param_stato =(String) request.getAttribute("param_stato");	
}

String param_isp="";
if(request.getAttribute("param_isp")!=null){
	param_isp=(String) request.getAttribute("param_isp");	
}

if (itemsPerPage.isEmpty()){
	itemsPerPage = "5";
}

if (Double.valueOf(itemsPerPage) > 0 ) {
	 itemsdelta = Double.valueOf(itemsPerPage);	
}

if(numeroTotRisultati != 0){
	if((numeroTotRisultati/itemsdelta) > 1){
		numeroPagine = numeroTotRisultati%itemsdelta;
	}
}



String classeHeader="";

if(request.getAttribute("segreteria")!=null && !request.getAttribute("segreteria").equals("")){

	classeHeader="segreteriaClass";


}


%>

<c:set var="param_Segret" value="<%=param_isp%>" />
<c:set var="param_stato" value="<%=param_stato %>" />

<portlet:actionURL name="ricerca" var="ricercaUrl">
	<portlet:param name="roleSegreteria" value="${segreteria}" />
</portlet:actionURL>


<div class="gestione-riunioni-title-box <%=classeHeader%>">
	<div class="ama-container-fluid">
		<div class="ama-row">
			<div class="ama-col-xs-12">
				<div class="title-wrapper">
					<h2 class="title"><%=ricercaRiunionetitle%></h2>
					<a class="icomoon-star title-star btn-star-bookmarks"
						title="Aggiungi ai preferiti"> <span class="sr-only"><liferay-ui:message
								key="header-preferiti-aggiungi" />
							</span>
					</a>
					<div class="wrapper-content">
						<liferay-portlet:renderURL var="stampaURL">
							<portlet:param name="mvcPath" value="/stampa.jsp" />
							<portlet:param name="titleStampaRiunione"
								value="<%=stampaRiunionetitle%>" />
							<portlet:param name="subTitleStampaRiunione"
								value="<%=stampaRiunionetxt%>" />
							<portlet:param name="roleCoordinatore"
								value="${roleCoordinatore}" />
							<portlet:param name="roleSegreteria"
								value="${segreteria}" />
							<portlet:param name="roleAdministrator"
								value="${roleAdministrator}" />
								<portlet:param name="companyId" value="${companyId}"/>
						</liferay-portlet:renderURL>
						<a title="<liferay-ui:message key="header-riunioni-stampa-title" />" class="icomoon-print title-print"
							href="<%=stampaURL%>"> <span class="sr-only"><liferay-ui:message
									key="header-riunioni-stampa-sr-only" /></span>
						</a>
						<c:if
							test="${roleCoordinatore.equals('coordinatore') || roleAdministrator.equals('Administrator')}">
							<portlet:renderURL var="inserimentoURL">
								<portlet:param name="mvcPath" value="/inserimentoRiunione.jsp" />
								<portlet:param name="titleCreaRiunione"
									value="<%=creaRiunionetitle%>" />
								<portlet:param name="subTitleCreaRiunione"
									value="<%=creaRiunionetxt%>" />
								<portlet:param name="titleLuoghiRiunione"
									value="<%=luoghiRiunionetitle%>" />
								<portlet:param name="subTitleLuoghiRiunione"
									value="<%=luoghiRiunionetxt%>" />
								<portlet:param name="titleConvocantiRiunione"
									value="<%=convocantiRiunionetitle%>" />
								<portlet:param name="subTitleConvocantiRiunione"
									value="<%=convocantiRiunionetxt%>" />

							</portlet:renderURL>
							<button class="button button-primary hidden-xs"
								onclick="window.location.href='<%=inserimentoURL%>'">
								<span class="icomoon-plus icon-plus"></span><liferay-ui:message
								key="header-riunioni-crea"/>
							</button>
						</c:if>
					</div>
					<p class="subtitle dot-point dot-200"><%=ricercaRiunionetxt%></p>
					<c:if
							test="${roleCoordinatore.equals('coordinatore') || roleAdministrator.equals('Administrator')}">
					<button class="button-meeting button button-primary visible-xs">
						<span class="icomoon-plus icon-plus" href="#"></span>
						<liferay-ui:message key="header-riunioni-crea" />
					</button>
				</c:if>
				</div>
			</div>
		</div>
	</div>
</div>


<div class="gestione-riunioni-wrapper">
	<div class="ama-container-fluid">
		<div class="ama-row">
			<div class="ama-col-xs-12">
				<div class="tab-filtri filtro-categoria">
					<div class="filtro-tabs-wrapper">
							<span class="tab-title active"><liferay-ui:message
								key="gestione-riunione-ricerca-elenco-riunioni" /></span>
						
					</div>
					<div id="filtro-riunioni" class="filter-full-grid">
						<form data-parsley-validate="" id="form-gestione-riunioni" action="<%=ricercaUrl%>"
							method="post" id="<portlet:namespace/>myForm" enctype="multipart/form-data">
							<div class="filtro-body-box">
								<div id="filtro-additional" class="collapse in">
									<div class="filtro-content-box filtro-additional">
										<div class="ama-row">
											<div class="ama-col-md-5">
												<div class="ama-row">
													<div class="ama-col-sm-5">
														<div class="ama-row ">
															<div class="wrapper-content-date border-right">
																<div
																	class="ama-col-sm-12 ama-col-xs-6 filtro-type-wrapper">
																	<label for="date1" class="label-form-notice title">
																	<liferay-ui:message key="gestione-riunione-ricerca-dal" />*</label> <input id="da_hidden"
																		name="<portlet:namespace/>da_hidden" type="hidden"
																		value="<%=param_da%>" /> <input
																		data-parsley-required="true"
																		data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
																		data-parsley-pattern="^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$"
																		data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
																		id="date1" type="text" name="<portlet:namespace/>da"
																		class="datepicker-custom input-custom-light data-parsley-validated"
																		placeholder="DD/MM/AAAA"
																		>
																</div>
																<div
																	class="ama-col-sm-12 ama-col-xs-6 filtro-type-wrapper">
																	<label for="date"
																		class="label-form-notice title margin-top"><liferay-ui:message
																			key="gestione-riunione-ricerca-al" />*</label> <input id="a_hidden"
																		name="<portlet:namespace/>a_hidden" type="hidden"
																		value="<%=param_a%>" /> <input
																		data-parsley-required="true"
																		data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
																		data-parsley-pattern="^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$"
																		data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
																		id="Deadline" type="text" name="<portlet:namespace/>a"
																		class="datepicker-custom input-custom-light"
																		placeholder="DD/MM/AAAA"
																		data-parsley-compare-sumbission-expiration-date="#date1"
																		data-parsley-check-start-date="#date1" value="">
																</div>
															</div>
														</div>
													</div>
													<div class="ama-col-sm-7">
														<div class="ama-row">
															<div class="ama-col-sm-12 filtro-type-wrapper">
																<label for="date" class="label-form-notice title">
																	<liferay-ui:message key="gestione-riunione-ricerca-parola-chiave" />
																</label> 
																<input type="hidden"
																	value="<%=param_chiave%>" id="chiave_hidden"
																	name="chiave_hidden" /> <input id="input_chiave"
																	class="input-meetings ico-search" type="text"
																	name="<portlet:namespace/>parola_chiave"
																	placeholder='<liferay-ui:message key="gestione-riunione-ricerca-parola-chiave-placeholder" />'>
															</div>
															<c:if
																test="${roleCoordinatore.equals('coordinatore') || roleAdministrator.equals('Administrator')}">
																<div class="ama-col-sm-12 filtro-type-wrapper">
																	<label for="argument"
																		class="label-form-notice title margin-top">
																			<liferay-ui:message key="gestione-riunione-ricerca-ispettorato" />
																		</label> <select
																		id="argument" name="<portlet:namespace/>ispettorato"
																		class="option-select">
																		<option value="0" hidden><liferay-ui:message key="gestione-riunione-ricerca-ispettorato-select" /></option>
																		<c:forEach
																			items="<%=request.getAttribute("listaIsp") %>"
																			var="isp">
																			<c:set var="id_segr"
																				value="${isp.getId_segreteria().toString()}" />

																			<c:if test="${param_Segret == id_segr}">
																				<option selected="true"
																					value="${isp.getId_segreteria()}">${isp.getSegreteria_nome()}</option>
																			</c:if>
																			<c:if test="${param_Segret!=id_segr}">
																				<option value="${isp.getId_segreteria()}">${isp.getSegreteria_nome()}</option>
																			</c:if>
																		</c:forEach>
																	</select>
																</div>
															</c:if>
															<c:if
																test="${(!roleCoordinatore.equalsIgnoreCase('coordinatore') && !roleAdministrator.equalsIgnoreCase('Administrator') && roleSegreteria.equalsIgnoreCase('segreteria'))}">
																<input type="hidden" name="<portlet:namespace/>roleSegreteria">
															</c:if>
														</div>
													</div>
												</div>
											</div>
											<div class="ama-col-md-7">
												<div class="ama-row pt-10-xs pt-0-md">
													<div
														class="ama-col-xs-12 ama-col-sm-12 filtro-type-wrapper">
														<span class="title"><liferay-ui:message
																key="gestione-riunione-ricerca-stato" /></span>
														<div class="ama-row">
															<input id="stato_hidden" name="stato_hidden"
																type="hidden" value="<%=param_stato%>" /> <input
																id="statoSelected" type="hidden"
																name="<portlet:namespace/>statoSelected" value="" />
															<% int count = 1; %>
															<c:forEach
																items="<%=request.getAttribute("listaStati") %>"
																var="statoR">

																<div class="ama-col-md-3 ama-col-xs-12 ama-col-sm-6">
																	<a id="ahref_stato<%=count%>" href=""
																		title="${statoR.getLabel()}" class="filtro-type-item"
																		onclick="setStatoValue(<%=count%>);"> <c:choose>
																			<c:when test="${statoR.getPrimaryKey() eq 1}">
																				<div id="${statoR.getPrimaryKey()}"
																					class="type-item-icon">
																					<span class="icomoon-meeting ico-meeting"></span>
																				</div>
																				<div class="type-item-text">
																					${statoR.getLabel()}</div>
																			</c:when>
																			<c:when test="${statoR.getPrimaryKey() eq 2}">
																				<div id="${statoR.getPrimaryKey()}"
																					class="type-item-icon">
																					<span class="icomoon-hourglass ico-meeting"></span>
																				</div>
																				<div class="type-item-text">
																					${statoR.getLabel()}</div>
																			</c:when>
																			<c:when test="${statoR.getPrimaryKey() eq 3}">
																				<div id="${statoR.getPrimaryKey()}"
																					class="type-item-icon">
																					<span class="icomoon-cancel ico-meeting"></span>
																				</div>
																				<div class="type-item-text">
																					${statoR.getLabel()}</div>
																			</c:when>
																			<c:otherwise>
																				<div id="${statoR.getPrimaryKey()}"
																					class="type-item-icon">
																					<span class="icomoon-success-blu ico-meeting"></span>
																				</div>
																				<div class="type-item-text">
																					${statoR.getLabel()}</div>
																			</c:otherwise>
																		</c:choose>
																	</a>
																</div>
																<%count++; %>
															</c:forEach>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="buttons-wrapper ama-col-xs-12">
											<div class="ama-col-sm-6 ama-col-xs-12 text-center">
												<button type="button" class="button button-secondary"
													onclick="resetform();">
													<liferay-ui:message key="gestione-riunione-ricerca-annulla" />
												</button>
											</div>
											<div class="ama-col-sm-6 ama-col-xs-12 text-center">
												<button type="button" class="button button-primary" onclick="applySearch()">
													<liferay-ui:message key="gestione-riunione-ricerca-applica" />
												</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</form>
					  
					  
						<div class="ama-col-xs-12 riunioni-switch-grid">
                            	<a href=""  title="Visualizzazione riunioni estesa" class="cta-riunioni-grid active">Visualizzazione estesa</a>
                            	<a href="" title="Visualizzazione riunioni compatta" class="cta-riunioni-grid compact-grid">Visualizzazione compatta</a>
                        </div> 
						<% 
										Boolean first_Element = true;
										int conta_last = 0;
										Boolean insertedLabelOneThreeDays = false;
										Boolean insertedLabelFourSevenDays = false;
										int countLabel = 0;
										Date today = new Date();
										Calendar c = Calendar.getInstance();
										c.setTime(today);
										c.add(Calendar.DATE,3);
										Date endDate = c.getTime();
										
						%>
						<c:choose>
						<c:when test="<%= lista_res!=null && lista_res.size()>0 %>">

						<c:choose>
						<c:when test="${roleCoordinatore.equalsIgnoreCase('coordinatore') || roleAdministrator.equalsIgnoreCase('Administrator')}">
						

						
						<div  class="ama-col-xs-12 riunioni-day-title-wrap">
							<div class="ama-row">
								<div class="ama-col-xs-8"><div id="periodo-breve" style="display:none"> <span class="riunioni-day-title">Riunioni fra <span class="bold">1-3 giorni</span></span></div></div>
								<div class="ama-col-xs-4 text-right"><span class="riunioni-day-title"><span class="bold" id="first">3</span> riunioni</span></div>
							</div>
						</div>	
						
						
						<div class="js-list-pagination top-paginator-scroll">
						<c:forEach items="<%=lista_res %>" var="riunione">
						<% RiunioneBean r =(RiunioneBean) pageContext.getAttribute("riunione"); %>
						
							
							<c:if test="<%=!flagRicerca && r.getData_inizio().after(endDate) && r.getData_inizio().before(a) %>">
									<% conta_last++; %>

									<c:if test="<%=!insertedLabelFourSevenDays %>">
									<% insertedLabelFourSevenDays=true; 				
									%>
									<div class="ama-col-xs-12 riunioni-day-title-wrap">
                                        <div class="ama-row">
                                            <div class="ama-col-xs-8"><span class="riunioni-day-title">Riunioni fra <span class="bold">4-14 giorni</span></span></div>
                                            <div class="ama-col-xs-4 text-right"><span class="riunioni-day-title"><span class="bold" id="last">10</span> riunioni</span></div>
                                        </div>
                                    </div>
									</c:if>
							
							</c:if>
								
								<c:if test="<%= first_Element || ( insertedLabelFourSevenDays && conta_last==1 )%>">
									<% first_Element=false; %>

                                    <div class="ama-col-xs-12 thead-compact-grid">

                                    	<div class="item-compact-grid compact-grid-1">
                                    		<span class="title-grid">ID</span>
                                    	</div>
                                    	<div class="item-compact-grid compact-grid-2">
                                    		<span class="title-grid">Oggetto</span>
                                    	</div>
                                    	<div class="item-compact-grid compact-grid-3">
                                    		<span class="title-grid">Data</span>
                                    	</div>
                                    	<div class="item-compact-grid compact-grid-4">
                                    		<span class="title-grid">Tipo</span>
                                    	</div>
                                    	<div class="item-compact-grid compact-grid-5">
                                    		<span class="title-grid">Protocollo</span>
                                    	</div>
                                    	<div class="item-compact-grid compact-grid-6">
                                    		<span class="title-grid">Invitati</span>
                                    	</div>
                                    	<div class="item-compact-grid compact-grid-7">
                                    		<span class="title-grid">Sollecita</span>
                                    	</div>
										</div>
								</c:if>
								<c:if test="<%= !flagRicerca && r.getData_inizio().after(today) && r.getData_inizio().before(endDate) %>">
									<% insertedLabelOneThreeDays=true; %>
									<script>
										$("#periodo-breve").show();
									</script>
								</c:if>
								
	

								
								
								<%
											String tipoRiunione = r.getTipoRiunione();
											String labelStato = r.getStatoRiunione();
	                            %>
						<div class="item-pagination">
						<liferay-portlet:renderURL var="dettaglioUrl">
									<portlet:param name="mvcPath" value="/dettaglioRiunione.jsp" />
									<portlet:param name="idRiunione"
										value="${riunione.getId_riunione()}" />
									<portlet:param name="roleCoordinatore"
										value="${roleCoordinatore}" />
									<portlet:param name="roleAdministrator"
										value="${roleAdministrator}" />
									<portlet:param name="companyId"
											value="${companyId}"/>			
								</liferay-portlet:renderURL>
                                    	<div class="ama-col-xs-12 tbody-grid">
                                    		<div class="item-compact-grid compact-grid-1">
                                    			<div class="container-compact-grid">
					                                <a class="container-link-grid" href="<%=dettaglioUrl%>" >
                                    				<span class="title-head"><liferay-ui:message
																	key="gestione-riunione-ricerca-coordinatore-id" />:</span>
                                    				<span class="title-grid">${riunione.getId_riunione()}</span>
                                    			</a>
												</div>
                                    		</div>
                                    		<div class="item-compact-grid compact-grid-2">
                                    			<div class="container-compact-grid">
												<a class="container-link-grid" href="<%=dettaglioUrl%>" >
                                   				<div class="meeting-type">
                                    					<span class="label-riunioni-state">
                                    						<span class="label-state-name"><%=tipoRiunione %></span>
                                    					</span>
                                    					<span class="label-riunioni-state">
															<c:choose>
                                    						<c:when test="<%= labelStato.equalsIgnoreCase("indetta")%>">
																<span class="label-icon icomoon-meeting"></span> <span class="label-state-name"><%= labelStato %></span>
															</c:when>
															<c:when test="<%= labelStato.equalsIgnoreCase("effettuata")%>">
																<span class="label-icon icomoon-success-blu"></span> <span class="label-state-name"><%= labelStato %></span>
															</c:when>
															<c:when test="<%= labelStato.equalsIgnoreCase("rinviata")%>">
																<span class="label-icon icomoon-hourglass"></span> <span class="label-state-name"><%= labelStato %></span>
															</c:when>
															<c:when test="<%= labelStato.equalsIgnoreCase("annullata")%>">
																<span class="label-icon icomoon-cancel"></span> <span class="label-state-name"><%= labelStato %></span>
															</c:when>
															<c:otherwise>
																<span class="label-icon "></span> <span class="label-state-name"><%= labelStato %></span>

															</c:otherwise>
															</c:choose>
														</span>
                                    				</div>
                                    				<span class="title-grid">${riunione.getOggetto()}</span>
                                    			</a>
												</div>
                                    		</div>
                                    		<div class="item-compact-grid compact-grid-3">
                                    			<div class="container-compact-grid">
												<a class="container-link-grid" href="<%=dettaglioUrl%>" >
                                   				<span class="title-grid"><span class="icomoon-calendar-date"></span><%=sdfData.format(r.getData_inizio())%></span>
                                    				<span class="title-grid meeting-time"><span class="icomoon-time"></span><%=sdfOra.format(r.getData_inizio())%></span>
                                    			</a>
												</div>
                                    		</div>
                                    		<div class="item-compact-grid compact-grid-4">
                                    			<div class="container-compact-grid">
                                    				<span class="label-riunioni-state">
                                    					<span class="label-state-name"><%=tipoRiunione %></span>
                                    				</span>
                                    			</div>
                                    		</div>
                                    		<div class="item-compact-grid compact-grid-5">
                                    			<div class="container-compact-grid">
												<a class="container-link-grid" href="<%=dettaglioUrl%>" >
                                    				<span class="protocoll-text">
                                    					<span class="title-head"><liferay-ui:message
																	key="gestione-riunione-ricerca-coordinatore-protocollo" />:</span>
                                    					<span class="title-grid">${riunione.getProtocollo()}</span>
                                    				</span>
													</a>
                                    				<span class="reminder-text">
														<c:if test="<%=r.isFlagSollecita() && r.getData_ultimo_sollecito()!=null  %>">
															<span class="title-head"><liferay-ui:message key="gestione-riunione-ricerca-coordinatore-sollecitato" />: </span>
															<span class="title-grid"><%=sdfData.format(r.getData_ultimo_sollecito())%></span>
														</c:if>
													</span> 
                                    			</div>
                                    		</div>
                                    		<div class="item-compact-grid compact-grid-6">
                                    			<div class="container-compact-grid">
												<%
												
													List<Segreteria> listSegreteria = r.getListSegreteria();
													BeanCreator segrUtil= new BeanCreator();
													int countSegreteria=0;
													Boolean flagSollecito =false;
													%>
													<c:forEach items="<%=listSegreteria %>" var="invitatiRiunione">
													<%  
															Segreteria segreteriaInvitata =(Segreteria) pageContext.getAttribute("invitatiRiunione");
														 %>
                                    				<span class="riunione-label">
														<span class="riunione-label-text">${invitatiRiunione.getSegreteria_nome()}
															
															<c:choose>
																	<c:when test="${ invitatiRiunione.getStato()>0}" >
																	
																	<c:choose>
																	<c:when test="<%=segreteriaInvitata.getNome_stato().equalsIgnoreCase("accettata") %>">
															<span class="ml-10-xs ico-label icomoon-riunione-ok"></span>
															<span class="title-grid">: <%= segreteriaInvitata.getNome_stato() %></span>
																											<c:if test="<%=segreteriaInvitata.getListPartecipante()!=null && !segreteriaInvitata.getListPartecipante().isEmpty()%>">
																					
																					<%
																						List<Partecipante> partecipanti = segreteriaInvitata.getListPartecipante();
																						String partecipantiNominativo="";
																						boolean flagN = false;

																						for(Partecipante partecipanteSeg : partecipanti){
																							if(flagN){
																								partecipantiNominativo +=", ";
																							}else
																								flagN=true;	
																							partecipantiNominativo += partecipanteSeg.getNome() + " " + partecipanteSeg.getCognome();
																							
																						}
																					%>
																					
																					
																					<a href="#"  class="text-position tooltip-field icon-information pull-right" title="<%=partecipantiNominativo%>" aria-label="<%=partecipantiNominativo%>">
		                                												<span class="icomoon-invitati"></span>
		                                											</a>
																					
																				</c:if>
																	</c:when>
															<c:when test="<%= segreteriaInvitata.getNome_stato().equalsIgnoreCase("rifiutata") %>">
																<span class="ml-10-xs ico-label icomoon-riunione-ko"></span>
																<span class="title-grid">: <%= segreteriaInvitata.getNome_stato() %></span>

															</c:when>
															<c:otherwise>
																<span class="ml-10-xs ico-label"></span>
																<span class="title-grid">: <%= segreteriaInvitata.getNome_stato() %></span>

															</c:otherwise>
																	
																	
															</c:choose>

														
														</c:when>
																	<c:otherwise>
																	<%
																		flagSollecito = true;
																	%>
																		<span class="ml-10-xs ico-label icomoon-riunione-wait"></span>
																		<span class="title-grid">: in attesa di risposta</span>

																</c:otherwise>
																</c:choose>
														</span>
													</span>

													</c:forEach>
													
													
													
												</div>
                                    		</div>
                                    		<div class="item-compact-grid compact-grid-7">
                                    			<div class="container-compact-grid">
                                    				<span class="title-head title-meeting">INVITATI</span>
													<c:if test="<%= r.isFlagSollecita() == true %>">
														<a href="" class="button button-primary button-alert" data-toggle="modal" data-target="#modal-invia-sollecito<%= r.getId_riunione() %>"><span class="icomoon-riunione-alert"></span>&nbsp;</a>
													</c:if>
													<a href="" class="button button-primary button-trash" data-toggle="modal" data-target="#modal-eliminaRiunione<%= r.getId_riunione() %>"><span class="icomoon-trash1"></span>&nbsp;</a>
          										</div>
                                    		</div>
                                    	</div>
                                    </div>                  
						
						                                    				<c:if test="<%= r.isFlagSollecita() == true %>">
														<portlet:actionURL name="sendAlert" var="sendAlertUrl" >
															<portlet:param name="idRiunione"
																value="${riunione.getId_riunione()}" />
															<portlet:param name="da" value="<%=param_da%>" />
															<portlet:param name="a" value="<%=param_a%>" />
															<portlet:param name="statoSelected" value="<%=param_stato%>" />
															<portlet:param name="ispettorato" value="<%=param_isp%>" />
															<portlet:param name="parola_chiave" value="<%=param_chiave%>" />
															<portlet:param name="flagRicerca"
																value="<%=String.valueOf(flagRicerca)%>" />
														</portlet:actionURL>
                                    				<form id="myadvForm${riunione.getId_riunione()}"
										action="<%=sendAlertUrl%>" method="post" enctype="multipart/form-data"></form>
											<div id="modal-invia-sollecito${riunione.getId_riunione()}"
										class="modal modal-custom fade modal-sollecito" role="dialog">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-body">
													<div class="modal-title-box">
														<a href="#" class="icomoon-close-white"
															data-dismiss="modal"></a>
														<div class="title-modal">
															<h2 class="title">
																<liferay-ui:message	key="gestione-riunione-modale-sollecita-invia" />
															</h2>
														</div>
													</div>
													<span class="icomoon-sollecito-mail"></span>
													<h2 class="riunione-name">${riunione.getOggetto()}</h2>
													<div class="ama-row mb-50-xs buttons-bottom">
														<div class="ama-col-xs-12 ama-col-sm-6">
															<button class="button button-secondary"
																data-dismiss="modal">
																<liferay-ui:message
																	key="gestione-riunione-modale-sollecita-annulla" />
															</button>
														</div>
														<div class="ama-col-xs-12 ama-col-sm-6">
															<button id="sendAlertbtn${riunione.getId_riunione()}"
																type="button" class="button button-primary">
																<liferay-ui:message
																	key="gestione-riunione-modale-sollecita-sollecita" />
															</button>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>	

									
									
									
									
									<script>
	        							$("#sendAlertbtn"+${riunione.getId_riunione()}).click(function(){
		        							$("#myadvForm"+${riunione.getId_riunione()}).submit();
		        							$("#modal-invia-sollecito"+${riunione.getId_riunione()}).modal("hide");
 										});	
	        						</script>
										
													
													</c:if>
									<portlet:actionURL name="eliminaRiunione" var="eliminaRiunioneUrl" >
										<portlet:param name="idRiunione"
											value="${riunione.getId_riunione()}" />
										<portlet:param name="da" value="<%=param_da%>" />
										<portlet:param name="a" value="<%=param_a%>" />
										<portlet:param name="statoSelected" value="<%=param_stato%>" />
										<portlet:param name="ispettorato" value="<%=param_isp%>" />
										<portlet:param name="parola_chiave" value="<%=param_chiave%>" />
										<portlet:param name="flagRicerca" value="<%=String.valueOf(flagRicerca)%>" />
									</portlet:actionURL>
									<form id="eliminaRiunioneForm${riunione.getId_riunione()}"
										action="<%=eliminaRiunioneUrl%>" method="post" enctype="multipart/form-data"></form>
									
								<div id="modal-eliminaRiunione${riunione.getId_riunione()}"
										class="modal modal-custom fade modal-elimina" role="dialog">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-body">
													<div class="modal-title-box">
														<a href="#" class="icomoon-close-white"
															data-dismiss="modal"></a>
														<div class="title-modal">
															<h2 class="title">
															<liferay-ui:message	key="gestione-riunione-modale-elimina-riunione-title" />
															</h2>
														</div>
													</div>
													<span class="icomoon-trash"></span>
													<h2 class="riunione-name">${riunione.getOggetto()}</h2>
													<div class="ama-row mb-50-xs buttons-bottom">
														<div class="ama-col-xs-12 ama-col-sm-6">
															<button class="button button-secondary"
																data-dismiss="modal">
																<liferay-ui:message
																	key="gestione-riunione-modale-annulla" />
															</button>
														</div>
														<div class="ama-col-xs-12 ama-col-sm-6">
															<button id="eliminaRiunione${riunione.getId_riunione()}"
																type="button" class="button button-primary">
															<liferay-ui:message
																	key="gestione-riunione-modale-elimina" />
															</button>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									
								<script>
								
								    $("#eliminaRiunione"+${riunione.getId_riunione()}).click(function(){
        							$("#eliminaRiunioneForm"+${riunione.getId_riunione()}).submit();
        							$("#modal-eliminaRiunione"+${riunione.getId_riunione()}).modal("hide");
									});
								
								</script>	
						</c:forEach>
	
									
						<div class="ama-row">
                                        <div class="ama-col-xs-12 text-align-center">
                                            <div data-totpage="<%=itemsdelta %>" data-totpage-mobile="" class="paginator-wrap-dark js-pagination paginator-wrap">
                                                <div class="btn-back-arrow disabled">
                                                    <a href="" title="Pagina precedente">
                                                        <em class="icomoon-arrow"></em>
                                                    </a>
                                                </div>
                                                <ul class="pagination-numbers">
                                                    <li class="current-page"><a title="Vai a pagina" href="">1</a></li>
                                                    <li><a title="Vai a pagina" href="">2</a></li>
                                                </ul>
                                                <div class="btn-forward-arrow">
                                                    <a href="" title="Pagina successiva">
                                                        <em class="icomoon-arrow">
                                                            <span class=""></span>
                                                        </em>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

						    </div>
							</c:when>
							<c:otherwise>
										<%@ include file="/risultatiRicercaSegreteria.jsp"%>	

							
							</c:otherwise>
							</c:choose>
						</c:when>
						<c:when test="<%=flagRicerca%>">
						<div class="ama-row">
							<div class="ama-col-md-12 ama-col-xs-12">

								<p class="copy-text wysiwyg-editor"><liferay-ui:message key="gestione-riunione-ricerca-nessuna-riunione"/></p> 

							</div>
						</div>
						
						</c:when>
						<c:otherwise>
						<div class="ama-row">
							<div class="ama-col-md-12 ama-col-xs-12">

								<p class="copy-text wysiwyg-editor"><liferay-ui:message key="gestione-riunione-ricerca-nessuna-riunione-giorni"/></p> 

							</div>
						</div>
						</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
	
	
	var chiave=$('#chiave_hidden').val();
	var data_da=$('#da_hidden').val();
	var data_a=$('#a_hidden').val();
	var stato="";
	stato=$('#stato_hidden').val();
					
	if(chiave!=""){
		$('#input_chiave').val(chiave);
	}
					
	if(data_da!=""){
		$('#date1').val(data_da);
	}
					
	if(data_a!=""){
		$('#Deadline').val(data_a);
	}

	if(stato!=""){
		$('#statoSelected').val(stato);
		$('#ahref_stato'+stato).attr("class","filtro-type-item active");
	}
					
	function resetform() {
		
		$('#Deadline').val("");
		$('#date1').val("");
		$('#ahref_stato'+1).val(0);
		$('#statoSelected').val("");
		$('#ahref_stato'+2).val(0);
		$('#ahref_stato'+3).val(0);
		$('#ahref_stato'+4).val(0);
		$('#ahref_stato'+1).attr("class","filtro-type-item");
		$('#ahref_stato'+2).attr("class","filtro-type-item");
		$('#ahref_stato'+3).attr("class","filtro-type-item");
		$('#ahref_stato'+4).attr("class","filtro-type-item");
		$('#input_chiave').val("");
		$('#stato_hidden').val("");
		$('#chiave_hidden').val("");
		$('#da_hidden').val("");
		$('#a_hidden').val("");
		$('#argument').val(0);
	}
	
	
	function applySearch(){
		$("#form-gestione-riunioni").parsley().validate();
		if($("#form-gestione-riunioni").parsley().isValid){
			$("#form-gestione-riunioni").submit();
		}
	}

	function setStatoValue(id) {
		$('#statoSelected').val(id);	
	}	

	if(document.getElementById('first'))
		document.getElementById('first').innerHTML = <%=lista_res.size() - conta_last %>;
	if(document.getElementById('last'))
		document.getElementById('last').innerHTML = <%=conta_last%>;


</script>