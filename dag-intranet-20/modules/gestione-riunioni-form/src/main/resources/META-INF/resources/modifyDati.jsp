<% 

AmministrazioneConvocante ammconv = AmministrazioneConvocanteLocalServiceUtil.getAmministrazioneConvocante(dettaglioRiunione.getId_amministrazione_convocante());
String descrizioneTipologia ="";
if(dettaglioRiunione.getId_tipo()>0){
	TipoRiunione tipologia = TipoRiunioneLocalServiceUtil.getTipoRiunione(dettaglioRiunione.getId_tipo());
	descrizioneTipologia =  tipologia.getDescrizione();
}



List<AmministrazioneConvocante> amministrazioni = creatorBean.getAmministrazioniConvocantiList();

/*List<AmministrazioneConvocante> amministrazioni_ord = (List<AmministrazioneConvocante>) request.getAttribute("Amministrazioni");
List<AmministrazioneConvocante> amministrazioni = new ArrayList<AmministrazioneConvocante>();
amministrazioni.addAll(amministrazioni_ord);
Collections.sort(amministrazioni, new Comparator<AmministrazioneConvocante>() {				
	@Override
	public int compare(AmministrazioneConvocante o1, AmministrazioneConvocante o2) {
		return (o1.getNome_amministrazione().trim().toUpperCase().compareTo(o2.getNome_amministrazione().trim().toUpperCase()));
	}
});*/

%>

<c:set value="<%=ammconv.getNome_amministrazione()%>"
	var="amministrazioneconv"></c:set>
<c:set value="<%=descrizioneTipologia%>" var="tipologiariunione"></c:set>
<c:set value="<%=idRiunione%>" var="idRiunione"></c:set>

<portlet:actionURL var="modificaDatiRiunioneURL"
	name="modificaDatiRiunione">
	<portlet:param name="idRiunione" value="${idRiunione}" />
</portlet:actionURL>

<portlet:renderURL var="gestionConvUrl">
	<portlet:param name="idRiunione" value="${idRiunione}" />
	<portlet:param name="mvcPath" value="/gestioneConvocanti.jsp" />
	<portlet:param name="titleConvocantiRiunione" value="<%=convocantiRiunionetitle%>" />
	<portlet:param name="subTitleConvocantiRiunione" value="<%=convocantiRiunionetxt%>" />
	
	<portlet:param name="previousPage" value="modifyDati" /> 

</portlet:renderURL>

<div id="riunioneModificaDati" class="tab-pane dati fade">
	<div class="dati-riunione-dati-personali-wrap">
		<a href="${gestionConvUrl}" 
		title='<liferay-ui:message key="gestione-riunione-modifica-dati-convocanti-title"/>' class="btn-convocanti">
			<span class="icomoon-convocanti"></span>
			<span class="sr-only">
			<liferay-ui:message key="gestione-riunione-modifica-dati-convocanti"/>
		</span>
		</a>
		<form data-parsley-validate="" action="${modificaDatiRiunioneURL}" method="POST" id="modificaDati" enctype="multipart/form-data" class="form-dati-personali">
			<div class="ama-row">
				<div class="ama-col-sm-6 ama-col-xs-12 data-parsley-validated">
                	<label class="label-form"><liferay-ui:message key="gestione-riunione-modifica-dati-amministrazione-convocante"/>*</label>
					<select id="setAmministrazione" name="<portlet:namespace/>AmministrazioneConvocante" showRequiredLabel="" 
						data-parsley-required="true"
						data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>" onchange="changeInputDati()">
						<c:if test="<%=amministrazioni!=null %>">
							<c:forEach items="<%=amministrazioni %>" var="amministrazioneC">
								<c:if test="${amministrazioneconv == amministrazioneC.getNome_amministrazione()}">
									<option value="${amministrazioneC.getId_amministrazione_convocante()}"
                                         selected="true">${amministrazioneC.getNome_amministrazione()}</option>
								</c:if>
								<c:if
									test="${amministrazioneconv != amministrazioneC.getNome_amministrazione()}">
									 <option
         								 value="${amministrazioneC.getId_amministrazione_convocante()}">${amministrazioneC.getNome_amministrazione()}</option>
								</c:if>
							</c:forEach>
						</c:if>
					</select>
				</div>
				
				<div class="ama-col-xs-12 ama-col-sm-6 ama-col-xs-12 data-parsley-validated">
				  <label class="label-form"><liferay-ui:message key="gestione-riunione-modifica-dati-tipologia"/></label>
                  	<select id="setTipo" name="<portlet:namespace/>Tipo" onchange="changeInputDati()">
						<option value="" hidden><liferay-ui:message key="gestione-riunione-modifica-tipologia-select" /></option>
                    	<c:if test="<%=request.getAttribute("TipiRiunione")!=null %>">
                      		<c:forEach items="<%=request.getAttribute("TipiRiunione") %>" var="tipoR">
                          		<c:if test="${tipologiariunione == tipoR.getDescrizione()}">
                                 	<option  value="${tipoR.getId_tipo()}" selected="true">${tipoR.getDescrizione()}</option>
                                </c:if>
                      			<c:if test="${tipologiariunione != tipoR.getDescrizione()}">
                             		<option  value="${tipoR.getId_tipo()}">${tipoR.getDescrizione()}</option>
                                </c:if>
                            </c:forEach>
                        </c:if>
                   </select>
				</div>
				
				
				
			</div>
			<div class="ama-row mt-25-sm">
				
				<div class="ama-col-sm-6 ama-col-xs-12">
					<div class="wrapper-content-textarea">
					 <label class="label-form"><liferay-ui:message key="gestione-riunione-modifica-dati-protocollo"/></label>
                     
					 <textarea class="form-control textarea-custom-light textarea-protocollo" 
						   	onkeypress="if (event.keyCode==13){return false;}"
							id="setProtocollo" 						
							data-parsley-maxlength="50" 
							data-parsley-maxlength-message='<liferay-ui:message key="error-maxlength-char-message" arguments="<%=new String[]{\"50\"}%>"/>'
                        placeholder='<liferay-ui:message key="gestione-riunione-modifica-dati-protocollo-placeholder"/>'

							name="<portlet:namespace/>Protocollo" onkeyup="changeInputDati()"><%=dettaglioRiunione.getProtocollo()%></textarea>
                        <div class="content-textarea"> <%=dettaglioRiunione.getProtocollo().length()%>/   
							<p class="color-gray">50</p>
                        </div>
						
					 
				</div>
				</div>

			</div>
			
			
			
			
<div class="ama-row mt-25-sm">
				<div class="ama-col-xs-12 ">
					<div class="wrapper-content-textarea">
					<label class="label-form"><liferay-ui:message key="gestione-riunione-modifica-dati-oggetto"/>*</label>
					      <textarea class="form-control textarea-custom-light textarea-oggetto" 
						   	data-parsley-required="true"
							onkeypress="if (event.keyCode==13){return false;}"
							data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>"
							id="setOggetto" 						
							data-parsley-maxlength="500" 
							data-parsley-maxlength-message='<liferay-ui:message key="error-maxlength-char-message" arguments="<%=new String[]{\"500\"}%>"/>'

							placeholder='<liferay-ui:message key="gestione-riunione-modifica-dati-oggetto-placeholder"/>' 
							name="<portlet:namespace/>Oggetto" onkeyup="changeInputDati()"><%=dettaglioRiunione.getOggetto()%></textarea>
                        <div class="content-textarea"> <%=dettaglioRiunione.getOggetto().length()%>/   
							<p class="color-gray">500</p>
                        </div>
					
                   
				</div>
							</div>
				</div>

			<div class="ama-row mt-25-sm">
				<div class="ama-col-xs-12 ">
					<div class="wrapper-content-textarea">
						<label class="label-form margin-top" for="textarea-detail"><liferay-ui:message key="gestione-riunione-modifica-dati-note"/></label>
                        <textarea class="form-control textarea-custom-light textarea-note" id="textarea-detail" 
						placeholder='<liferay-ui:message key="gestione-riunione-modifica-dati-note"/>' 
                        data-parsley-maxlength="4000"  
						data-parsley-maxlength-message='<liferay-ui:message key="error-maxlength-char-message" arguments="<%=new String[]{\"4000\"}%>"/>'
						name="<portlet:namespace/>Note" 
						onkeyup="changeInputDati()"><%=dettaglioRiunione.getNote()%></textarea>
                        <div class="content-textarea"> <%=dettaglioRiunione.getNote().length()%>/   
							<p class="color-gray">4000</p>
                        </div>
						
					</div>
				</div>
			</div>
				<input type="hidden" id="buttonValueDati" name="<portlet:namespace/>buttonValue">
				<input type="hidden" class="changeTab" name="<portlet:namespace/>changeTab">
			</form>
			<div class="ama-row">
				<div class="buttons-wrapper ama-col-xs-12 mt-55-xs mb-60-xs">
					 <div class="ama-col-sm-6 ama-col-xs-12 text-center mobile-no-padding">
                         <button class="button button-secondary"  type="button" onclick="goToDettaglioAnnuncio('#buttonValueDati','#modificaDati')">
						 <liferay-ui:message key ="gestione-riunione-modifica-dati-annulla"/></button>
                     </div>
				  <div class="ama-col-sm-6 ama-col-xs-12 text-center mobile-no-padding">
					   <button class="button button-primary" type="button" onclick="submitFormDati()">
					   <liferay-ui:message key ="gestione-riunione-modifica-dati-salva"/></button>
				  </div>
				  	
				</div>
			</div>
	</div>
</div>
 <textarea  id="noteDefault" style="display:none"><%=dettaglioRiunione.getNote()%></textarea>
 <textarea  id="protocolloDefault" style="display:none"><%=dettaglioRiunione.getProtocollo()%></textarea>
 <textarea  id="oggettoDefault" style="display:none"><%=dettaglioRiunione.getOggetto()%></textarea>

 <textarea  style="display:none" id="amministrazioneconvDefault">${amministrazioneconv}</textarea>



<script>

var ammConvocante = $("#amministrazioneconvDefault").val();
var oggetto = $("#oggettoDefault").val();
var tipo = "${tipologiariunione}";
if(tipo=="")
	tipo = "<liferay-ui:message key="gestione-riunione-modifica-tipologia-select" />";
var protocollo =$("#protocolloDefault").val();
var note = $("#noteDefault").val();

function changeInputDati() {
	
if ((ammConvocante != $('#setAmministrazione option:selected').text()) || (oggetto != $('#setOggetto').val().trim()) || (tipo != $('#setTipo option:selected').text()) || (protocollo != $('#setProtocollo').val().trim()) || (note != $('#textarea-detail').val().trim())) {
	$('#flagModal').val("openModal");
}
else {
	$('#flagModal').val("");
}
}

function submitFormDati() {
if ((ammConvocante != $('#setAmministrazione option:selected').text()) || (oggetto != $('#setOggetto').val().trim()) || (tipo != $('#setTipo option:selected').text()) || (protocollo != $('#setProtocollo').val().trim()) || (note != $('#textarea-detail').val().trim())) {
		$('#setOggetto').val($('#setOggetto').val().trim()); 		
		$('#setProtocollo').val($('#setProtocollo').val().trim()); 		
		$('#textarea-detail').val($('#textarea-detail').val().trim()); 		
		$('#modificaDati').submit();
	}
}
	

</script>