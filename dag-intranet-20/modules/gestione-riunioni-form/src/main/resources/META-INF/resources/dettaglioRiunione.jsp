<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.Riunione"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.RiunioneLocalServiceUtil"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@page import="com.intranet.mef.gestione.riunioni.model.StatoInvitato"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.StatoRiunione"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.TipoRiunione"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.Luogo"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante"%>



<%@page import="com.intranet.mef.gestione.riunioni.service.StatoInvitatoLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.model.InvitatiRiunione"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.InvitatiRiunioneLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.RiunioneLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.StatoRiunioneLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.LuogoLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.AmministrazioneConvocanteLocalServiceUtil"%>
<%@page import="com.intranet.mef.gestione.riunioni.service.TipoRiunioneLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.intranet.mef.util.BeanCreator"%>
<%@page import="com.mef.ricercariunione.stub.Segreteria"%>
<%@page import="com.mef.ricercariunione.stub.Partecipante"%>

<%@page import="java.util.Calendar" %>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>


<%
String roleCoordinatore = ParamUtil.getString(request, "roleCoordinatore");
if (roleCoordinatore.equals(""))
	roleCoordinatore = (String) request.getAttribute("roleCoordinatore");
if (roleCoordinatore==null)
	roleCoordinatore="";

Long companyId = ParamUtil.getLong(request, "companyId");
if (companyId==0)
	companyId = (Long) request.getAttribute("companyId");									

String roleAdministrator = ParamUtil.getString(request, "roleAdministrator");
if (roleAdministrator.equals(""))
	roleAdministrator = (String) request.getAttribute("roleAdministrator");
if (roleAdministrator==null)
	roleAdministrator="";

long id=0;
if(ParamUtil.getLong(request, "idRiunione")!=0 || request.getAttribute("idRiunione")!=null){
	if(ParamUtil.getLong(request, "idRiunione")!=0){
		id=(ParamUtil.getLong(request, "idRiunione"));
}
else if(request.getAttribute("idRiunione")!=null){
	id=(long)request.getAttribute("idRiunione");
}

Riunione riun=null;
riun = RiunioneLocalServiceUtil.getRiunione(id);
String obj = riun.getOggetto();
long idStatoRiu = riun.getId_stato_riunione();
long idTipoRiu = riun.getId_tipo();
String labelStatoRiu="";
if(idStatoRiu!=0){
	StatoRiunione statoRiunione = StatoRiunioneLocalServiceUtil.fetchStatoRiunione(idStatoRiu);
	if(statoRiunione!=null){
		labelStatoRiu = statoRiunione.getLabel();
	}

}
String labelTipoRiu ="";
if(idTipoRiu!=0){
	TipoRiunione tipoRiunione = TipoRiunioneLocalServiceUtil.fetchTipoRiunione(idTipoRiu);
	if(tipoRiunione!=null){
		labelTipoRiu = tipoRiunione.getDescrizione();
	}
} 
String dat =  riun.getData_inizio().toString();
SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
SimpleDateFormat sdfOra = new SimpleDateFormat("HH:mm");
Date dataR = riun.getData_inizio();
String luog ="";
if (riun.getId_luogo()!=0){
	Luogo luogoRiunione = LuogoLocalServiceUtil.fetchLuogo(riun.getId_luogo());
	if(luogoRiunione!=null){
		luog = luogoRiunione.getNome();
	}
}


String admin = "";
if(riun.getId_amministrazione_convocante()!=0){
	AmministrazioneConvocante ammConvocante = AmministrazioneConvocanteLocalServiceUtil.fetchAmministrazioneConvocante(riun.getId_amministrazione_convocante());
	if(ammConvocante!=null){
		admin = ammConvocante.getNome_amministrazione();
	}
}


String prot = riun.getProtocollo();

List <InvitatiRiunione> invR = InvitatiRiunioneLocalServiceUtil.getInvitatiRiunioneByIdRiunione(id);
String not = riun.getNote();


SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 'alle' HH:mm");
Date dat_cre =  riun.getData_creazione();
Date dat_mod = riun.getData_modifica();

BeanCreator segrUtil= new BeanCreator();
List <Segreteria> listSegreteria = segrUtil.updateListaSegreterie(invR);
Collections.sort(listSegreteria,new Comparator<Segreteria>() {
			          
	@Override
	public int compare(Segreteria arg0, Segreteria arg1) {
		return arg0.getIndex()-arg1.getIndex();
	}
});

Date today = new Date();
Calendar c = Calendar.getInstance();
c.setTime(today);
c.add(Calendar.DATE,3);
Date endDate = c.getTime();

%>

	<portlet:actionURL name="sendAlert" var="sendAlertUrl">
		<portlet:param name="idRiunione" value="<%= Long.toString(id)%>" />
		<portlet:param name="flagDettaglio" value="true" />
	</portlet:actionURL>
<form id="myadvForm" action="<%=sendAlertUrl%>" method="post"></form>

<div class="gestione-riunioni-title-box">
        <div class="ama-container-fluid">
            <div class="ama-row">
                <div class="ama-col-xs-12">
                    <div class="title-wrapper">
                        <portlet:actionURL var="passamodificaUrl" name="passamodifica"> 
 							<portlet:param name="idRiunione" value="<%=riun.getId_riunione() + ""%>"/>
						</portlet:actionURL>  
						 <portlet:actionURL var="eliminaRiunioneUrl" name="eliminaRiunione"> 	
						</portlet:actionURL>  
						<form action="<%=passamodificaUrl%>" method="post">
                        <h2 class="title"><%=obj.toUpperCase()%></h2>
                         <c:if test="<%= ((roleCoordinatore.equalsIgnoreCase("coordinatore") || roleAdministrator.equalsIgnoreCase("Administrator"))) %>">
							<div class="wrapper-content">
							<a title="Elimina" class="icomoon-trash1 title-delete" data-target="#modal-eliminaRiunione" href=""  data-toggle="modal">
								<span class="sr-only"><liferay-ui:message key="gestione-riunione-dettaglio-riunione-elimina"/></span>
							</a>
							</div>
                        </c:if>
						<c:if test="<%= ((!labelStatoRiu.equalsIgnoreCase("effettuata") && !labelStatoRiu.equalsIgnoreCase("annullata") ) && (roleCoordinatore.equalsIgnoreCase("coordinatore") || roleAdministrator.equalsIgnoreCase("Administrator"))) %>">
							 <div class="wrapper-content">
								<a title="Modifica" class="icomoon-edit-border title-print" href="<%=passamodificaUrl%>">
									<span class="sr-only"><liferay-ui:message key="gestione-riunione-dettaglio-riunione-edita"/></span>
								</a>
							</div>
                        </c:if>
                       
                        <div class="ama-row text-center gestione-buttons-holder">
                            <span class="label-riunioni-state"><span class="label-icon icomoon-meeting"></span><span class="label-state-name"><%=labelStatoRiu.toUpperCase()%></span></span>
                            <c:if test="<%= !labelTipoRiu.equals("")%>">
								<span class="label-riunioni-state ml-0-xs ml-20-sm"><span class="label-state-name"><%=labelTipoRiu.toUpperCase()%></span></span>
                              </c:if>
						</div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
</div>
                        <form action="<%=eliminaRiunioneUrl%>" id="deleteRiunione" method="post" enctype="multipart/form-data">
							<input type="hidden" name="<portlet:namespace/>idRiunione" value="<%=riun.getId_riunione() + ""%>">			
						</form>
                                    <script>
	        							$("#eliminaRiunione").click(function(){
		        							$("#deleteRiunione").submit();
		        							$("#modal-eliminaRiunione").modal("hide");
 										});
	        						</script>



                                    <div id="modal-eliminaRiunione"
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
													<h2 class="riunione-name"><%=riun.getOggetto()%></h2>
													<div class="ama-row mb-50-xs buttons-bottom">
														<div class="ama-col-xs-12 ama-col-sm-6">
															<button class="button button-secondary"
																data-dismiss="modal">
																<liferay-ui:message
																	key="gestione-riunione-modale-annulla" />
															</button>
														</div>
														<div class="ama-col-xs-12 ama-col-sm-6">
															<button id="eliminaRiunione"
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






<div class="ama-container-fluid">
        <div class="ama-row">
            <div class="ama-col-xs-12">
                <div class="gestione-riunioni-wrapper">
                    <div class="gestione-riunioni-dettaglio">
                        <div class="container-info-riunioni">
							<div class="wrapper-info-riunioni">
                                <div class="ama-row"> 
                                    <div class="ama-col-sm-3 ama-col-xs-6 text-left"><span class="icomoon-calendar-date"></span><span class="text-bold mobile-hidden">
									<liferay-ui:message key="gestione-riunione-dettaglio-riunione-data"/>: </span><span> <%=sdfData.format(dataR)%></span></div>
                                    <div class="ama-col-sm-3 ama-col-xs-6 mobile-text-right"><span class="icomoon-time"></span><span class="text-bold mobile-hidden"> 
									<liferay-ui:message key="gestione-riunione-dettaglio-riunione-ora"/>: </span><span> <%=sdfOra.format(dataR)%></span></div>
                                    <div class="ama-col-sm-6 ama-col-xs-12 text-right mobile-text-center mt-20-xs mt-0-md"><span class="icomoon-pin"></span><span class="text-bold"> 
									<liferay-ui:message key="gestione-riunione-dettaglio-riunione-luogo"/>: </span><span> <%=luog%></span></div>
                                </div>
                            </div>
							
							
						
							<div class="wrapper-info-riunioni bg-white">
                                <div class="ama-row">
                                    <div class="ama-col-xs-12 mobile-text-center"><span class="text-bold">
										<liferay-ui:message key="gestione-riunione-dettaglio-riunione-amministrazione-convocante"/> </span><span><%=admin%></span></div>
                                    <c:if test="<%=!prot.isEmpty()%>">
										<div class="ama-col-xs-12 mobile-text-center"><span class="text-bold">
									
										<liferay-ui:message key="gestione-riunione-dettaglio-riunione-protocollo"/>
										
										</span><span> <%=prot%></span></div>
                                   </c:if>
								</div>		
                            </div>
						</div>
						
						<c:if test="<%=!invR.isEmpty()%>">
						<div class="container-box box-sollecita">
                            <span class="span-bold mobile-text"><liferay-ui:message key="gestione-riunione-dettaglio-riunione-ispettorato"/></span>
							<c:if test="<%= riun.getData_ultimo_sollecito()!=null && !riun.getData_ultimo_sollecito().equals("") %>">
								<span class="span-bold data-sollecito">
								<liferay-ui:message key="gestione-riunione-dettaglio-riunione-sollecitato"/>
								<%=sdfData.format(riun.getData_ultimo_sollecito()) %></span>
							 </c:if>
							<c:if test="<%=  segrUtil.sollecitaInvitati(riun.getId_riunione(),today,endDate)  %>">
									
								<button data-toggle="modal" data-target="#modal-invia-sollecito" class="button button-primary button-sollecita mb-20-xs mb-0-sm">
									<span class="icon-button icomoon-riunione-alert mr-10-xs"></span>
									<liferay-ui:message key="gestione-riunione-dettaglio-riunione-sollecita" />
								</button>
							</c:if>
						</div>
						<div class="container-box">
								<div class="ama-row">
						<c:forEach items="<%=listSegreteria%>" var="invitatoR">
							<% Segreteria segreteria =(Segreteria) pageContext.getAttribute("invitatoR");
							   StringBuilder sb = new StringBuilder();
							    
								if (segreteria.getStato()==1) {
								 
									InvitatiRiunione invitatiRiunione = InvitatiRiunioneLocalServiceUtil.getInvitatiRiunioneByPK(segreteria.getId_segreteria(), id);
							 	 								
								
								   		ThemeDisplay theme_Display = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

								   boolean flagB = false;
								for(Partecipante partecipante : segrUtil.getListaPartecipantiJSONforForm(invitatiRiunione.getPartecipanti(), theme_Display)){
									if(flagB){
										sb.append(", ");
									}else
										flagB = true;
									sb.append(partecipante.getNome());
 							 		sb.append(" ");
 							 		sb.append(partecipante.getCognome());
 							 			
 							 			
								}
								   
								}
							%>

		                      <div class="ama-col-md-3 ama-col-sm-6 ama-col-xs-12 mobile-text-center">
										<div class="rect-notify">
											<span class="label-riunioni-state">
												<span class="label-state-name" >
												<c:choose>
													<c:when test="${ invitatoR.getStato()>0}" >
														<% StatoInvitato statoInvitatiDB = StatoInvitatoLocalServiceUtil.getStatoInvitato(segreteria.getStato());%>
														<%= statoInvitatiDB.getNome_stato().toUpperCase() %>

														<c:choose>
															<c:when test="<%= statoInvitatiDB.getNome_stato().equalsIgnoreCase("accettata")%>">
															
																<span class="ml-10-xs ico-label icomoon-riunione-ok"></span>
															</c:when>
															<c:when test="<%= statoInvitatiDB.getNome_stato().equalsIgnoreCase("rifiutata")%>">
																<span class="ml-10-xs ico-label icomoon-riunione-ko"></span>

															</c:when>
															<c:otherwise>
															</c:otherwise>
														</c:choose>
													
													</c:when>
													<c:otherwise>
														<liferay-ui:message key='gestione-riunione-dettaglio-riunione-stato-in-attesa'/>
														<span class="ml-10-xs ico-label icomoon-riunione-wait"></span>
													</c:otherwise>
												</c:choose>
												
																						
												
												
												</span>
											</span>
											
											
											
										<c:if test='${invitatoR.getStato()!=0 && invitatoR.getNote()!=null && !invitatoR.getNote().equals("") }'>
											<a href="#" title="${invitatoR.getNote()}" class="text-position tooltip-field icon-information">
												<span class="ico-commento icomoon-commento"></span>
											</a>
										</c:if>
										
										<p class="mt-20-xs" id="itemSegreteria<%=segreteria.getId_segreteria()%>">${invitatoR.getSegreteria_nome().toUpperCase()}
											
											<c:if test='${invitatoR.getStato()==1}'>
												<c:if test="<%=!sb.toString().trim().equals("")%>">
												<a href="#" id="partecipanti" class="text-position tooltip-field icon-information pull-right" title="<%=sb.toString().toUpperCase()%>">
		                                			
		                                			<span class="icomoon-partecipanti"></span>
		                                			
		                                		</a>
		                                		</c:if>
											</c:if>
                                        
                                        </p>
										</div>
									</div>
						
                        </c:forEach>
						</div>
						</div>
                        </c:if>
                        <c:if test="<%=!not.isEmpty()%>">
						<div class="container-box"><span class="span-bold"><liferay-ui:message key="gestione-riunione-dettaglio-riunione-note"/></span></div>
                        <div class="container-box box-bg-white mobile-text-center">
							<textarea readonly class="form-control textarea-custom-light textarea-note meeting-detail"><%=not%></textarea>
                        </div>
                        </c:if>
					</div>
					<div class="ama-row mobile-text-center">
                        <div class="ama-col-sm-6 ama-col-xs-12 text-modify mt-15-xs"><span class="bold"><liferay-ui:message key="gestione-riunione-dettaglio-riunione-inserita-in-e-room"/>: </span><span><%=dateFormat.format(dat_cre)%></span></div>
                        <c:if test="<%=dat_mod!=null%>">
						<div class="ama-col-sm-6 ama-col-xs-12 text-right text-modify mt-15-xs"><span class="bold"><liferay-ui:message key="gestione-riunione-dettaglio-riunione-ultima-modifica"/>:</span><span> <%=dateFormat.format(dat_mod)%></span></div>
						</c:if> 
					</div> 
				</div>            
			</div>
        </div>
    </div>
	
	
			<div id="modal-invia-sollecito"	class="modal modal-custom fade modal-sollecito" role="dialog">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-body">
													<div class="modal-title-box">
														<a href="#" class="icomoon-close-white"
															data-dismiss="modal"></a>
														<div class="title-modal">
															<h2 class="title">
																<liferay-ui:message
																	key="gestione-riunione-modale-sollecita-sollecita" />
															</h2>
														</div>
													</div>
													<span class="icomoon-sollecito-mail"></span>
													<h2 class="riunione-name"><%=riun.getOggetto()%></h2>
													<div class="ama-row mb-50-xs buttons-bottom">
														<div class="ama-col-xs-12 ama-col-sm-6">
															<button class="button button-secondary"
																data-dismiss="modal">
																<liferay-ui:message
																	key="gestione-riunione-modale-sollecita-annulla" />
															</button>
														</div>
														<div class="ama-col-xs-12 ama-col-sm-6">
															<button id="sendAlertbtn"
																type="button" class="button button-primary">
																<liferay-ui:message
																	key="gestione-riunione-modale-sollecita-invia" />
															</button>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>	
	
	

<%}else{ %>
<%@ include file="/erroreRiunione.jsp"%>
<%}%>

<script>
		
			$("#sendAlertbtn").click(function(){
				$("#myadvForm").submit();
				$("#modal-invia-sollecito").modal("hide");
			});
</script>