

<%
Luogo luogo=LuogoLocalServiceUtil.getLuogo(dettaglioRiunione.getId_luogo());

List<Luogo> luoghi = creatorBean.getLuoghiList();

/*List<Luogo> luoghi_ord = (List<Luogo>) request.getAttribute("Luoghi");
List<Luogo> luoghi_disponibili = new ArrayList<Luogo>();

luoghi_disponibili.addAll(luoghi_ord);
Collections.sort(luoghi_disponibili, new Comparator<Luogo>() {				
	@Override
	public int compare(Luogo o1, Luogo o2) {
		return (o1.getNome().trim().toUpperCase().compareTo(o2.getNome().trim().toUpperCase()));
	}
});*/


%>

<c:set value="<%=idRiunione%>" var="idRiunione"></c:set>
<c:set value="<%=luogo.getNome()%>" var="nomeluogo"></c:set>

<portlet:actionURL var="modificaLuogoRiunioneURL" name="modificaLuogoRiunione">
      <portlet:param name="idRiunione" value="${idRiunione}" />
</portlet:actionURL>

<portlet:renderURL var="gestionLuoghiUrl">
      <portlet:param name="idRiunione" value="${idRiunione}" />
      <portlet:param name="mvcPath" value="/gestioneLuoghi.jsp" />
      <portlet:param name="subTitleLuoghiRiunione" value="<%=luoghiRiunionetxt%>" />
      <portlet:param name="titleLuoghiRiunione" value="<%=luoghiRiunionetitle%>" />
	  <portlet:param name="previousPage" value="modifyLuogo" /> 

</portlet:renderURL>


<div id="riunioneModificaDataLuogo" class="tab-pane luogo fade">
      <div class="tab-title-wrapper">
            <div class="title-wrapper">
                  <h2 class="title text-uppercase"><%=obj%></h2>
            </div>
            <div class="text-right gestione-data-luogo-icon-content">
                  <a href="${gestionLuoghiUrl}" title="Luoghi" class="gestione-riunioni-icon icomoon-location2"> 
                        <span class="sr-only"><liferay-ui:message key="gestione-riunione-modifica-luogo-luoghi"/></span>
                  </a>
            </div>
            <div class="div-button">
                  <span class="label-riunioni-state">
                        <span class="label-icon icomoon-meeting"></span>
                        <span class="label-state-name"><%= labelStatoRiu.toUpperCase() %></span>
                  </span>
				<c:if test="<%= !labelTipoRiu.equals("")%>">
				  <span class="label-riunioni-state ml-0-xs ml-20-sm">
						<span class="label-state-name"><%= labelTipoRiu.toUpperCase() %></span>
				  </span>
				</c:if>
            </div>
      </div>
      	<div class="gestione-riunioni-data-luogo-wrapper">
			<form data-parsley-validate="" id="modificaDatiLocation" action="${modificaLuogoRiunioneURL}" method="post" enctype="multipart/form-data">

				<div class="ama-row">
					<div class="wrapper-form">
						<div class="ama-col-xs-6 ama-col-md-3 mb-20-xs data-parsley-validated">
							<label for="setData" class="label-data-luogo"><liferay-ui:message key="gestione-riunione-modifica-luogo-data-inizio"/>*</label> 
							<input id="setData" data-parsley-required="true" 
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
								data-parsley-pattern="/(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(20)\d\d/"
								data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
								type="text" name="<portlet:namespace/>date" 
								class="datepicker-custom input-custom-light" 
								placeholder="DD/MM/AAAA" value="<%=data%>" onblur="changeInputLuogo()">
						</div>
						<div class="ama-col-xs-6  ama-col-md-3 mb-20-xs data-parsley-validated">
							<label for="time" class="label-data-luogo"><liferay-ui:message key="gestione-riunione-modifica-luogo-ora-inizio"/>*</label> 
							<input id="setHour" type="text" name="<portlet:namespace/>time" 
								data-parsley-required="true" 
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
								data-parsley-pattern="([0-1][0-9]|[2][0-4]):([0-5][0-9])" 
								data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
								class="input-custom-light" 
								placeholder="HH:mm" value="<%=ora%>"
								data-parsley-checkhour="#setData" onkeyup="changeInputLuogo()">
						</div>
						<div class="ama-col-xs-12 ama-col-md-6 mb-20-xs">
							<label for="location" class="label-data-luogo">
							<liferay-ui:message key="gestione-riunione-modifica-luogo-luogo"/>*</label>
							<select id="setLuogo" name="<portlet:namespace/>Luogo" id="location"
									data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
									class="option-select data-parsley-validated" showRequiredLabel=""
									data-parsley-required="true"
									data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>" onchange="changeInputLuogo()">
									<c:if test="<%=luoghi!=null %>">
									<option value="" hidden><liferay-ui:message key="scegli-elenco"/></option>
										<c:forEach items="<%=luoghi%>" var="luogoR">
												<c:if test="${nomeluogo == luogoR.getNome() }">
													<option selected="true" value="${luogoR.getId_luogo()}">${luogoR.getNome().toUpperCase()} </option>
												</c:if>
												<c:if test="${nomeluogo != luogoR.getNome()}">
													<option value="${luogoR.getId_luogo()}">${luogoR.getNome().toUpperCase()}</option>
												</c:if>
										</c:forEach>
									 </c:if>
						   </select>
					   </div>
					</div>
				</div>							 
				<div class="ama-row mt-30-xs">
					<div class="ama-col-xs-12">
						<div class="container-info-riunioni bg-gray">
							<div class="wrapper-info-riunioni bg-white">
								<div class="ama-row">
									<div class="ama-col-xs-12 mobile-text-center">
										<span class="text-bold">
										<liferay-ui:message key="gestione-riunione-modifica-luogo-amministrazione-convocante"/>:</span>
										<span> <%=admin%></span>
									</div>
									<div class="ama-col-xs-12 mobile-text-center">
										<span class="text-bold">
										<liferay-ui:message key="gestione-riunione-modifica-luogo-protocollo"/>:</span><span> <%=prot%></span>
									</div>
								</div>
							 </div>
						</div>
					 </div>
				</div>
				<input type="hidden" id="buttonValueLuogo" name="<portlet:namespace/>buttonValue">
				<input type="hidden" class="changeTab" name="<portlet:namespace/>changeTab">
				<div class="ama-row mt-25-sm" >
				<div class="ama-col-xs-12 ">
					<div class="wrapper-content-textarea">
						<label class="label-form margin-top" for="textarea-detail"><liferay-ui:message key="gestione-riunione-modifica-dati-note"/></label>
                        <textarea class="form-control textarea-custom-light textarea-note" id="textarea-note-luogo" 
						placeholder='<liferay-ui:message key="gestione-riunione-modifica-dati-note"/>' 
                        data-parsley-maxlength="4000"  
						data-parsley-maxlength-message='<liferay-ui:message key="error-maxlength-char-message" arguments="<%=new String[]{\"4000\"}%>"/>'
						name="<portlet:namespace/>Note" onkeyup="changeInputLuogo()"><%=dettaglioRiunione.getNote()%></textarea>
                        <div class="content-textarea"> <%=dettaglioRiunione.getNote().length()%>/   
							<p class="color-gray">4000</p>
                        </div>
						
					</div>
				</div>
			</div>
			</form>
			<div class="ama-row mt-30-xs">
            	<div class="buttons-wrapper ama-col-xs-12 mt-25-xs mb-40-xs ">
                	<div class="ama-col-sm-6 ama-col-xs-12 text-center mobile-no-padding">
                    	<button type="button" class="button button-secondary" onclick="goToDettaglioAnnuncio('#buttonValueLuogo', '#modificaDatiLocation')">
						<liferay-ui:message key="gestione-riunione-modifica-luogo-annulla"/></button>
                    </div>
                   	<div class="ama-col-sm-6 ama-col-xs-12 text-center mobile-no-padding">
                    	<button type="button" class="button button-primary" onclick="submitFormLuogo()">
						<liferay-ui:message key="gestione-riunione-modifica-luogo-salva"/></button>
                    </div>
                 </div>
            </div>
        </div>
		
</div>
 <textarea  id="noteDefaultLuogo" style="display:none"><%=dettaglioRiunione.getNote()%></textarea>
 <textarea  style="display:none" id="luogoDefault">${nomeluogo}</textarea>

<script>
 	
 	var data = "<%=data%>";
 	var ora = "<%=ora%>";
 	var luogo = $("#luogoDefault").val();;
	var note = $("#noteDefaultLuogo").val();

 	
	
 	function changeInputLuogo() {
 	if ((data.trim() != $('#setData').val().trim()) || (ora.trim() != $('#setHour').val().trim()) || (luogo.toUpperCase().trim() != $('#setLuogo option:selected').text().toUpperCase().trim())
		|| (note != $('#textarea-note-luogo').val().trim())) {
			
			
			
 		$('#flagModal').val("openModal");
 	}
 	else {
 		$('#flagModal').val("");
 	}
 	}

 	function submitFormLuogo() {
 	 	if ((data.trim() != $('#setData').val().trim()) || (ora.trim() != $('#setHour').val().trim()) || (luogo.toUpperCase().trim() != $('#setLuogo option:selected').text().toUpperCase().trim())|| (note != $('#textarea-note-luogo').val().trim())) {
 	 		$('#textarea-note-luogo').val($('#textarea-note-luogo').val().trim()); 		
			$('#setData').val($('#setData').val().trim());
			$('#setHour').val($('#setHour').val().trim());
			$('#modificaDatiLocation').parsley().validate();
			if($('#modificaDatiLocation').parsley().isValid()){
				$('#modificaDatiLocation').submit();

			}
			
 		}
 	}
	

 </script>
