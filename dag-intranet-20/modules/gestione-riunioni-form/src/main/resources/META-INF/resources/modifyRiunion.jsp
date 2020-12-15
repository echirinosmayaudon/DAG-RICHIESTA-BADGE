<% 

Long idRiunioneDefault =0L;
if(request.getAttribute("idRiunione") != null)  {
      idRiunioneDefault=Long.parseLong(request.getAttribute("idRiunione").toString());
	  Riunione dettaglioRiunioneDefault = RiunioneLocalServiceUtil.getRiunione(idRiunioneDefault);
		long idStatoRiuDefault = dettaglioRiunioneDefault.getId_stato_riunione();
	String labelStatoRiuDefault = (StatoRiunioneLocalServiceUtil.getStatoRiunione(idStatoRiuDefault)).getLabel();
    String tab = "#riunioneModificaDati";
	

	if(request.getAttribute("changeTab") != null)  {
		tab = (String) request.getAttribute("changeTab");
	}
	String labelTipoRiu = "";
	long idTipoRiu = dettaglioRiunioneDefault.getId_tipo();
	BeanCreator creatorBean= new BeanCreator();
if(idTipoRiu>0)
	labelTipoRiu = TipoRiunioneLocalServiceUtil.getTipoRiunione(idTipoRiu).getDescrizione();
	  %>

<c:choose>
<c:when test="<%= labelStatoRiuDefault.equalsIgnoreCase("indetta") || labelStatoRiuDefault.equalsIgnoreCase("rinviata")%>">
<div class="gestione-riunioni-title-box">
    <div class="ama-container-fluid">
        <div class="ama-row">
            <div class="ama-col-xs-12">
                <div class="title-wrapper">
                    <h2 class="title"><%=modificaRiunionetitle%></h2>
                    <!--<a class="icomoon-convocanti icon-convocanti" href="#"></a>-->
                    <p class="subtitle dot-point dot-170"><%=modificaRiunionetxt%></p>
                </div>
            </div>
        </div>
    </div>
</div>


<% 
    long idRiunione=idRiunioneDefault;
	Riunione dettaglioRiunione = dettaglioRiunioneDefault;
	long idStatoRiu = idStatoRiuDefault;
	String labelStatoRiu = labelStatoRiuDefault;
%>
<div class="gestione-riunioni-modifica-wrapper">
    <div class="ama-container-fluid">

        <div class="tab-negative-wrap">
			<c:choose>
            <c:when test="<%= labelStatoRiu.equalsIgnoreCase("indetta")%>">
            <input type="hidden" id="flagModal">
				
				<ul class="nav nav-pills">
                    <li id="riunioneModificaDatitab" class="tabModifica"><a onclick="modificaRiunioneTabChange('#riunioneModificaDati')" title="DATI PRINCIPALI" ><span class="icomoon-dati"></span>DATI PRINCIPALI</a></li>
                    <li id="riunioneModificaStatotab"  class="tabModifica"><a onclick="modificaRiunioneTabChange('#riunioneModificaStato')" title="STATO"><span class="icomoon-stato"></span>STATO</a></li>
                    <li id="riunioneModificaInvitatitab" class="tabModifica"><a onclick="modificaRiunioneTabChange('#riunioneModificaInvitati')" title="INVITATI"><span class="icomoon-invitati"></span>INVITATI</a></li>
                    <li id="riunioneModificaDataLuogotab" class="tabModifica"><a onclick="modificaRiunioneTabChange('#riunioneModificaDataLuogo')" title="DATA/LUOGO"><span class="icomoon-pin-white-bold"></span>DATA/LUOGO</a></li>
                </ul>
				
				<a id="customRiunioneTab" data-toggle="pill" href="#"></a>
				<div class="tab-content">
					<%@ include file="/modifyDati.jsp"%> 
					<%@ include file="/modifyStato.jsp"%> 
					<%@ include file="/modifyInvitati.jsp"%> 
					<%@ include file="/modifyLuogo.jsp"%> 
				</div>
			
				
				<div id="modal-change-tab" class="modal modal-custom fade modal-icon-page" role="dialog"> 
								<div class="modal-dialog"> 
									<div class="modal-content"> 
										<div class="modal-body"> 
											<div class="modal-title-box"> 
												<a href="#" class="icomoon-close-white" data-dismiss="modal"></a> 
													<div class="title-modal"> 
														<h2 class="title"><liferay-ui:message key="gestione-riunione-modifica-modale-titolo"/></h2> 
													</div> 
											 </div> 
												<h2 class="text"><liferay-ui:message key="gestione-riunione-modifica-modale-messaggio"/>.</h2> 
			 
							  <div class="ama-row mb-50-xs buttons-bottom"> 
								  <div class="ama-col-xs-12 ama-col-sm-6"> 
									  <button id="annullaModal" class="button button-secondary" data-dismiss="modal"><liferay-ui:message key="gestione-riunione-modifica-modale-no"/></button> 
								 </div> 
								  <div class="ama-col-xs-12 ama-col-sm-6"> 
									  <button id="salvaModal" type="button" class="button button-primary" name="<portlet:namespace/>btnSalvaModifiche"><liferay-ui:message key="gestione-riunione-modifica-modale-si"/></button> 									   
								 </div>
							  </div> 
						  </div> 
						</div> 
					</div> 
				</div>  
				
				<script>
				var currentContent;
				var tab = "<%=tab%>";
				
				modificaRiunioneTabChange(tab);
				function removeActiveTab(){
					$(".tabModifica").each(function(){
						$(this).removeClass("active");
					
					});
				};

				function modificaRiunioneTabChange(tab){
					$("#customRiunioneTab").attr("href",tab);
					if ($('#flagModal').val()!=null && $('#flagModal').val()!="") {
						$('.tab-pane').each(function () {
							if ($(this).hasClass("active")){
								currentContent = $(this).attr("id");
							}
					
						});
						$('#modal-change-tab').modal('show');
					}else{
						$("#customRiunioneTab").click();
						removeActiveTab();
						$(tab+"tab").addClass("active");

						$("#customRiunioneTab").attr("href","#");

					}
					
				};
					
				
				function resetTab(a){
					switch(a){
						case "riunioneModificaDati":
						
							$("#setAmministrazione").val(
									$("#setAmministrazione option").filter(function() {
								return this.text.trim() == ammConvocante.trim(); })
							.val()).change();
							
							$('#setOggetto').val(oggetto).change();
							
							$("#setTipo").val(
							$("#setTipo option").filter(function() {
								return this.text.trim() == tipo.trim(); })
						    .val()).change();
							
							$('#setProtocollo').val(protocollo).change();
							$('#textarea-detail').val(note).change();
						break;
						
						case "riunioneModificaStato":
							resetStato();
							break;
							
						case "riunioneModificaInvitati":
							resetInvitati();
							break;
						
						case "riunioneModificaDataLuogo":
							$('#setData').val(data).change();
							$('#setHour').val(ora).change();
							$("#setLuogo").val(
							$("#setLuogo option").filter(function() {
								return this.text.trim().toUpperCase() == luogo.trim().toUpperCase(); })
						    .val()).change();
						break;
						
						default:
							console.log("default");
					}
					
				}
				
				$('#annullaModal').on('click', function(event){
					$('#modal-change-tab').modal('hide');
					$("#customRiunioneTab").click();
					removeActiveTab();
					$($("#customRiunioneTab").attr("href") + "tab").addClass("active");								
					resetTab(currentContent);
					$('#flagModal').val("");
				});
				
				$('#salvaModal').on('click', function(event){
				    $('#modal-change-tab').modal('hide');
				    $("#"+currentContent).find('.changeTab').val($("#customRiunioneTab").attr("href"));
				    $("#"+currentContent).find('.button-primary').trigger('click');
			});
				</script>
				
			</c:when>
			 <c:when test="<%= labelStatoRiu.equalsIgnoreCase("rinviata") %>">
				
				<ul class="nav nav-pills">
                    <li><a id="statoModifica" class="active" title="STATO" data-toggle="pill" href="#riunioneModificaStato" ><span class="icomoon-stato"></span>STATO</a></li>
                </ul>
			 
			
				<div class="tab-content">
				
					 <%@ include file="/modifyStato.jsp"%> 
					
				</div>
				<script>
				 	
						$("#statoModifica").click();

				</script>
			</c:when>
			<c:otherwise>
				<%@ include file="/erroreRiunione.jsp"%>

			</c:otherwise>
			</c:choose>
        </div>
    </div>
</div>   
<script>
	function goToDettaglioAnnuncio(inputId, formId){
		$(inputId).val("annulla");
		$(formId).submit(); 
	}
</script>
 </c:when>

<c:otherwise>
	<%@ include file="/erroreRiunione.jsp"%> 

</c:otherwise>
</c:choose>
<%}else{ %>
<%@ include file="/erroreRiunione.jsp"%>
<%}%>