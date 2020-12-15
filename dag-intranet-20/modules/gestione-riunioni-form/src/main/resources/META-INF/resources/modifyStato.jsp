
<%

String obj = dettaglioRiunione.getOggetto();



Date dat =  dettaglioRiunione.getData_inizio();
String luog = (LuogoLocalServiceUtil.getLuogo(dettaglioRiunione.getId_luogo())).getNome();
String admin = (AmministrazioneConvocanteLocalServiceUtil.getAmministrazioneConvocante(dettaglioRiunione.getId_amministrazione_convocante())).getNome_amministrazione();
String prot = dettaglioRiunione.getProtocollo();

DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
String data = dateFormatter.format(dat);

DateFormat oraFormatter = new SimpleDateFormat("HH:mm");
String ora = oraFormatter.format(dat);

List<StatoRiunione> statiRiunioneDisp = (List<StatoRiunione>)request.getAttribute("StatiRiunione");

%>

<c:set value="<%=idRiunione%>" var="idRiunione" />
	
<portlet:actionURL var="modificaStatoRiunioneURL" name="modificaStatoRiunione">
	<portlet:param name="idRiunione" value="${idRiunione}" />
</portlet:actionURL>

<div id="riunioneModificaStato" class="tab-pane stato fade">
		<div class="tab-title-wrapper">
			<div class="title-wrapper">
				<h2 class="title text-uppercase"><%=obj%></h2>
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
		<div class="container-info-riunioni bg-gray">
			<div class="wrapper-info-riunioni">
				<div class="ama-row">
					<div id="dateTimeWrapperRO">
						<div class="ama-col-sm-3 ama-col-xs-6 text-left">
							<span class="icomoon-calendar-date"></span>
							<span class="text-bold mobile-hidden">
							<liferay-ui:message key="gestione-riunione-modifica-stato-data-inizio"/>:</span>
							<span> <%=data%> </span>
						</div>
						<div class="ama-col-sm-3 ama-col-xs-6 mobile-text-right">
							<span class="icomoon-time"></span>
							<span class="text-bold mobile-hidden">
							<liferay-ui:message key="gestione-riunione-modifica-stato-ora-inizio"/>:</span>
							<span> <%=ora%> </span>
						</div>
					</div>
					<div id="dateTimeWrapper" style="display: none;">
						<div class="ama-col-sm-3 ama-col-xs-6 text-left data-parsley-validated">
							<label for="date1" class="label-data-luogo">
							<liferay-ui:message key="gestione-riunione-modifica-stato-data-inizio"/>*</label> 
							<input id="newDate" type="text" name="<portlet:namespace/>date" class="datepicker-custom input-custom-light" placeholder="DD/MM/AAAA" value=""
								data-parsley-required="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
								data-parsley-pattern="/(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(20)\d\d/"
								data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>">
						</div>
						<div class="ama-col-sm-3 ama-col-xs-6 mobile-text-right data-parsley-validated">
							<label for="time" class="label-data-luogo">
							<liferay-ui:message key="gestione-riunione-modifica-stato-ora-inizio"/>*</label> 
							<input id="newTime" type="text" name="<portlet:namespace/>time" class="input-custom-light" placeholder="HH:mm" value=""
								data-parsley-required="true" 
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
								data-parsley-pattern="([0-1][0-9]|[2][0-4]):([0-5][0-9])" data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
								data-parsley-checkhour="#newDate">
						</div>
					</div>
				<div class="ama-col-sm-6 ama-col-xs-12 text-right mobile-text-center mt-20-xs mt-0-md">
					<span class="icomoon-pin"></span><span class="text-bold">
					<liferay-ui:message key="gestione-riunione-modifica-stato-luogo"/>:</span><span> <%=luog%></span>
				</div>
			</div>
		</div>
		<div class="wrapper-info-riunioni bg-white">
				<div class="ama-row">
					<div
						class="ama-col-xs-12 mobile-text-center">
						<span class="text-bold">
						<liferay-ui:message key="gestione-riunione-modifica-stato-amministrazione-convocante"/></span><span> <%=admin%></span>
					</div>
					<div class="ama-col-xs-12 mobile-text-center">
						<span class="text-bold">
						<liferay-ui:message key="gestione-riunione-modifica-luogo-protocollo"/></span><span> <%=prot%></span>
					</div>
				</div>
		</div>
	</div>
	<div class="tab-filtri filtro-categoria collapse-group"
			id="tabs-riunioni-stato">
			<div class="filtro-tabs-wrapper riunione-modifica-stato-tabs">
				<a href="" title='<liferay-ui:message key="gestione-riunione-modifica-stato-scegli-nuovo"/>' class="tab-title active" data-toggle="collapse" data-target="#filter-nuovo-stato" data-parent="#tabs-riunioni-stato">
				<liferay-ui:message key="gestione-riunione-modifica-stato-scegli-nuovo"/></a>
				<a href="" title='<liferay-ui:message key="gestione-riunione-modifica-stato-storico"/>' class="tab-title" data-toggle="collapse" data-target="#filter-storico-stato" data-parent="#tabs-riunioni-stato">
				<liferay-ui:message key="gestione-riunione-modifica-stato-storico"/></a>
			</div>
			<div id="filter-nuovo-stato" class="collapse in">
			<form data-parsley-validate="true" id="modificaStato" name="StatusForm" enctype="multipart/form-data" action="${modificaStatoRiunioneURL}" method="POST">

				<input
						type="hidden"
						id="inputStatoRiunione" 
						name="<portlet:namespace/>StatoRiunione" 
						required="true"
						value="">
					
					<div class="tab-riunioni-modifica-stato">
						<div class="content-tab">
							<div class="ama-row">
								<div class="ama-col-xs-12">
									<div class="ama-row">
	                                       <div class="ama-col-sm-3 ama-col-xs-12 mobile-no-padding">
	                                           <button name="indetta" id="indetta" title='<liferay-ui:message key="gestione-riunione-modifica-stato-indetta-title"/>' class="tab-type-item tab-scegli-stato" disabled>
	                                               <div class="type-item-icon">
	                                                   <span class="icomoon-meeting ico-meeting"></span>
	                                               </div>
	                                               <div class="type-item-text mt-20-sm">
	                                               <liferay-ui:message key="gestione-riunione-modifica-stato-indetta"/>
	                                               </div>
	                                           </button>
	                                       </div>                    
	                                       <div class="ama-col-sm-3 ama-col-xs-12 mobile-no-padding">
	                                           <button name="rinviata" title='<liferay-ui:message key="gestione-riunione-modifica-stato-rinviata-title"/>' id="rinviata" class="tab-type-item tab-scegli-stato" disabled>
	                                               <div class="type-item-icon">
	                                                   <span class="icomoon-hourglass ico-meeting"></span>
	                                               </div>
	                                               <div class="type-item-text mt-20-sm">
	                                               <liferay-ui:message key="gestione-riunione-modifica-stato-rinviata"/>
	                                               </div>
	                                           </button>
	                                       </div>                    
	                                       <div class="ama-col-sm-3 ama-col-xs-12 mobile-no-padding">
	                                           <button name="annullata" title='<liferay-ui:message key="gestione-riunione-modifica-stato-annullata-title"/>' id="annullata" class="tab-type-item tab-scegli-stato" disabled>
	                                               <div class="type-item-icon">
	                                                   <span class="icomoon-cancel ico-meeting"></span>
	                                               </div>
	                                               <div class="type-item-text mt-20-sm">
	                                               <liferay-ui:message key="gestione-riunione-modifica-stato-annullata"/>
	                                               </div>
	                                           </button>
	                                       </div>                    
	                                       <div class="ama-col-sm-3 ama-col-xs-12 mobile-no-padding">
	                                           <button name="effettuata" title='<liferay-ui:message key="gestione-riunione-modifica-stato-effettuata-title"/>' id="effettuata" class="tab-type-item tab-scegli-stato" disabled>
	                                               <div class="type-item-icon">
	                                                   <span class="icomoon-success-blu ico-meeting"></span>
	                                               </div>
	                                               <div class="type-item-text mt-20-sm">
	                                               <liferay-ui:message key="gestione-riunione-modifica-stato-effettuata"/>
	                                               </div>
	                                           </button>
	                                       </div>
									</div>
								</div>
							</div>
							
							
							
						</div>
					
					</div>
						<div class="ama-row mt-25-sm">
				<div class="ama-col-xs-12 ">
					<div class="wrapper-content-textarea">
						<label class="label-form margin-top" for="textarea-detail"><liferay-ui:message key="gestione-riunione-modifica-dati-note"/></label>
                        <textarea class="form-control textarea-custom-light textarea-note" id="textarea-note-stato" 
						placeholder='<liferay-ui:message key="gestione-riunione-modifica-dati-note"/>' 
                        data-parsley-maxlength="4000"  
						data-parsley-maxlength-message='<liferay-ui:message key="error-maxlength-char-message" arguments="<%=new String[]{\"4000\"}%>"/>'
						name="<portlet:namespace/>Note" onkeyup="changeInputStato()"><%=dettaglioRiunione.getNote()%></textarea>
                        <div class="content-textarea"> <%=dettaglioRiunione.getNote().length()%>/   
							<p class="color-gray">4000</p>
                        </div>
						
					</div>
				</div>
			</div>
					
					<input type="hidden" id="buttonValueStato" name="<portlet:namespace/>buttonValue">
					<input type="hidden" class="changeTab" name="<portlet:namespace/>changeTab">
					
					</form>
					<div class="ama-row">
						<div class="buttons-wrapper ama-col-xs-12 mt-55-xs mb-60-xs">
							<div class="ama-col-sm-6 ama-col-xs-12 text-center mobile-no-padding">
								<button class="button button-secondary" type="button" onclick="goToDettaglioAnnuncio('#buttonValueStato','#modificaStato')">
								<liferay-ui:message key="gestione-riunione-modifica-stato-annulla"/>
	                                       </button>
							</div>
							<div class="ama-col-sm-6 ama-col-xs-12 text-center mobile-no-padding">
								<button type="button" class="button button-primary" onclick="submitFormStato()">
								<liferay-ui:message key="gestione-riunione-modifica-stato-applica"/></button>
							</div>
							
						</div>
					</div>	
			</div>
			<div id="filter-storico-stato" class="collapse">
				<div class="tab-riunioni-modifica-stato">
					<div class="content-tab">
						<div class="ama-row">
							<div class="ama-col-xs-12">
								<div class="ama-row">
									<c:forEach items="${PassaggiDiStatoR1}" var="listItem1">
										<c:set var="listItem1" value="${listItem1}"/>
										<%
											StoricoStatoRiunione listItem1 = (StoricoStatoRiunione) pageContext.getAttribute("listItem1");
											long idStatoRiunioneCorrente = listItem1.getId_stato_riunione();
											String labelIdStatoRiunioneCorrente = (StatoRiunioneLocalServiceUtil.getStatoRiunione(idStatoRiunioneCorrente)).getLabel();
											String labelStatoOld = "INDETTA";
											if(labelIdStatoRiunioneCorrente.equals("indetta"))
												labelStatoOld = "RINVIATA";
											String dChange = dateFormatter.format(listItem1.getData());
											String oChange = oraFormatter.format(listItem1.getData());
										%>
			 
										<div class="ama-col-sm-4 ama-col-md-2 ama-col-xs-12 mobile-no-padding">
											<a href="" class="tab-type-item passaggio-di-stato">
												<div class="type-item-icon">
													<p class="icomoon-calendar-date"></p>
													<p class="tab-text-bold"><%= dChange %></p>
													<p><%= oChange %></p>
												</div>
												<div class="type-item-text tab-text">
													<span class="icomoon-evoluzione-stato icon-down"></span>
													<p><%=labelStatoOld%></p>
													<p class="tab-text-bold"><%=labelIdStatoRiunioneCorrente.toUpperCase()%></p>
												</div>
											</a>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
</div>
 <textarea  id="noteDefault" style="display:none"><%=dettaglioRiunione.getNote()%></textarea>

<script type="text/javascript">
	
var note = $("#noteDefault").val();

	function openScegliStato() {
		var x = document.getElementById('ScegliStato').style.display = 'block';
		var y = document.getElementById('Storico').style.display = 'none';
	}
	
	function openStorico() {
	    var y = document.getElementById('Storico').style.display = 'block';
	    var x = document.getElementById('ScegliStato').style.display = 'none';
	}
	
	function setStato(idStato, labStato) {
		var input = $("#inputStatoRiunione");
		var divDt = $("#dateTimeWrapper");
		var divDtRo = $("#dateTimeWrapperRO");

		if(input.attr("value") == idStato){
			input.attr("value", "");
			divDt.attr("style", "display: none;");
			divDtRo.attr("style", "display: block;");
			$("#newDate").removeAttr("required");
			$("#newTime").removeAttr("required");
		}
		else{
			input.attr("value", idStato);
			if(labStato=="indetta"){
				divDt.attr("style", "display: block;");
				divDtRo.attr("style", "display: none;");
				$("#newDate").attr("required", "");
				$("#newTime").attr("required", "");
			}
		}
		
		$('#flagModal').val("openModal");
	}
	
	<% 
		if(statiRiunioneDisp != null){
			int statiSize = statiRiunioneDisp.size();
			for (int i=0; i<statiSize; i++) { 
				StatoRiunione stato = statiRiunioneDisp.get(i);%>
				var butt = $("button[name='<%=stato.getLabel()%>']");
				butt.removeAttr("disabled");
				butt.attr("onclick", "setStato(<%=stato.getId_stato_riunione()%>, '<%=stato.getLabel()%>')")
	<% 		} 
		}%>
		
		function resetStato(){
			$('#rinviata').attr("class","tab-type-item tab-scegli-stato");
			$('#indetta').attr("class","tab-type-item tab-scegli-stato");
			$('#effettuata').attr("class","tab-type-item tab-scegli-stato");
			$('#annullata').attr("class","tab-type-item tab-scegli-stato");
			$('#inputStatoRiunione').attr("value","");		
		}
		
		function submitFormStato() {
			if ($('#rinviata').hasClass("active") || $('#indetta').hasClass("active") || $('#effettuata').hasClass("active") || $('#annullata').hasClass("active")|| (note != $('#textarea-note-stato').val().trim())) {
				$('#textarea-note-stato').val($('#textarea-note-stato').val().trim());

				
				$('#flagModal').val("");
				$('#modificaStato').submit();
			}
			
		}
		
		
		function changeInputStato() {
	
			if ($('#rinviata').hasClass("active") || $('#indetta').hasClass("active") || $('#effettuata').hasClass("active") || $('#annullata').hasClass("active")|| (note != $('#textarea-note-stato').val().trim())) {
				$('#flagModal').val("openModal");
			}
			else {
				
				$('#flagModal').val("");

				
			}
		}
</script>