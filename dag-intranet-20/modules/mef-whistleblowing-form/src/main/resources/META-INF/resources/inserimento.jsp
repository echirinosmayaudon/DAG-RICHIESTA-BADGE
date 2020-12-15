<%
List<Allegato> allegati_list =new ArrayList<Allegato>(0);
String size_allegati_string = "";
int size_allegati = 0;

if(moduloSegnalazione!=null && moduloSegnalazione.getAllegati()!=null) {
	allegati_list = (List<Allegato>) moduloSegnalazione.getAllegati();
	size_allegati_string = (String)request.getAttribute("count_allegati");
	size_allegati = Integer.parseInt(size_allegati_string);
}
%>

<c:set value="<%=richiedente%>" var="richiedente"></c:set>
 
 <portlet:actionURL name="riepilogoDati" var="riepilogoDati"></portlet:actionURL>
  
  <div class="trasporti-header">
    <div class="ama-container-fluid">
        <div class="ama-row">
            <div class="ama-col-xs-12">
                <div class="title-wrapper">
                    <h2 class="title"><%=formTitle%></h2>
                    <p class="subtitle dot-point dot-200"><%=formSubtitle%></p>
                </div>
            </div>
        </div>
    </div>
  </div>
     
  <div class="ama-container-fluid">
	
		<!-- DATI PERSONALI -->
	    <div class="ama-row">
	        <div class="ama-col-md-12">
	            <div class="wrapper-title-small">
	                <h2 class="title-box borders"><liferay-ui:message key="whistle-inserimento-lbl-dati-richiedente"/></h2>
	            </div>
	        </div>
	    </div>
	    <div class="ama-row">
	        <div class="ama-col-xs-12">
	            <div class="wrapper-whisteblowing">
	                <div class="ama-row">
	                    <div class="ama-col-xs-12">
	                        <form method="post" data-parsley-validate="true" id="<portlet:namespace/>formDatiPersonali" enctype="multipart/form-data">
	                            <div class="ama-row">
	                                 
                
                            	        <!-- NOME COGNOME -->
	                                    <div class="ama-col-xs-12 ama-col-md-4 mb-25-xs">
	                                        <label class="label-form"><liferay-ui:message key="whistle-inserimento-nome"/> (*)</label>
	                                        <c:if test="${richiedente.getUfficioRichiedente() == null}">
						                    	<input type="text" name="<portlet:namespace/>NomeCognome" 
						                    		id="<portlet:namespace/>NomeCognome" 
						                    		class="input-custom-light data-parsley-validated" 
						                    		placeholder="<liferay-ui:message key="whistle-inserimento-nome"/>" 
						                    		data-parsley-required="true" 
						                    		data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
						                    		readonly>
						                    </c:if>
						                    <c:if test="${richiedente.getUfficioRichiedente() != null}">
						                    	<input type="text" name="<portlet:namespace/>NomeCognome" 
						                    		id="<portlet:namespace/>NomeCognome" 
						                    		class="input-custom-light data-parsley-validated" 
						                    		value="${richiedente.getNome()} ${richiedente.getCognome()}" 
						                    		placeholder="<liferay-ui:message key="whistle-inserimento-nome"/>" 
						                    		data-parsley-required="true" 
						                    		data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
						                    		readonly>
						                    </c:if>
	                                    </div>
	                                    
	                                    <!-- QUALIFICA -->                
	                                    <div class="ama-col-xs-12 ama-col-md-4 mb-25-xs">
	                                        <label class="label-form"><liferay-ui:message key="whistle-inserimento-qualifica"/> (*)</label>
						                    <c:if test="${richiedente.getUfficioRichiedente() == null}">
							                    <input type="text" name="<portlet:namespace/>Qualifica" 
							                    	id="<portlet:namespace/>Qualifica" 
							                    	class="input-custom-light data-parsley-validated" 
							                    	placeholder="<liferay-ui:message key="whistle-inserimento-qualifica"/>" 
							                    	data-parsley-required="true" 
							                    	data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
							                    	readonly>
						                    </c:if>
						                    <c:if test="${richiedente.getUfficioRichiedente() != null}">
						                    	<input type="text" name="<portlet:namespace/>Qualifica" 
						                    		id="<portlet:namespace/>Qualifica" 
						                    		class="input-custom-light data-parsley-validated" 
						                    		value="${richiedente.getQualifica()}" 
						                    		placeholder="<liferay-ui:message key="whistle-inserimento-qualifica"/>" 
						                    		data-parsley-required="true" 
						                    		data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
						                    		readonly>
						                    </c:if>
	                                    </div>
	                                    
	                                    <!-- UFFICIO -->
	                                    <div class="ama-col-xs-12 ama-col-md-4 mb-25-xs">
	                                        <label class="label-form"><liferay-ui:message key="whistle-inserimento-ufficio"/> (*)</label>
                                            <c:if test="${richiedente.getUfficioRichiedente() == null}">
						                    	<input type="text" name="<portlet:namespace/>Struttura" 
						                    		id="<portlet:namespace/>Struttura" 
						                    		class="input-custom-light data-parsley-validated"  
						                    		placeholder="<liferay-ui:message key="whistle-inserimento-ufficio"/>" 
						                    		data-parsley-maxlength="30"
													data-parsley-maxlength-message="<liferay-ui:message key="whistle-max-length-dati-personali"/>"
						                    		data-parsley-required="true" 
						                    		data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
						                    </c:if>
						                    <c:if test="${richiedente.getUfficioRichiedente() != null}">
						                    	<input type="text" name="<portlet:namespace/>Struttura" 
						                    		id="<portlet:namespace/>Struttura" 
						                    		class="input-custom-light data-parsley-validated" 
						                    		value="<%=HtmlUtil.escape(richiedente.getUfficioRichiedente())%>" 
						                    		placeholder="<liferay-ui:message key="whistle-inserimento-ufficio"/>" 
						                    		data-parsley-maxlength="30"
													data-parsley-maxlength-message="<liferay-ui:message key="whistle-max-length-dati-personali"/>"
						                    		data-parsley-required="true" 
						                    		data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
						                    </c:if>
	                                    </div>
	                                    
	                                    <!-- TEL/CELL -->
	                                    <div class="ama-col-xs-12 ama-col-md-4 mb-25-xs">
	                                        <label class="label-form"><liferay-ui:message key="whistle-inserimento-tel-cell"/> (*)</label>
	                                        <c:if test="${richiedente.getUfficioRichiedente() == null}">
						                    	<input type="text" 
						                    		name="<portlet:namespace/>TellCell" id="<portlet:namespace/>TelCell" 
						                    		class="input-custom-light data-parsley-validated"
						                    		placeholder="<liferay-ui:message key="whistle-inserimento-tel-cell"/>" 
						                    		data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}"
													data-parsley-maxlength="30"
													data-parsley-maxlength-message="<liferay-ui:message key="whistle-max-length-dati-personali"/>"
													data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"  
						                    		data-parsley-required="true" 
						                    		data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
						                    </c:if>
						                    <c:if test="${richiedente.getUfficioRichiedente() != null}">
						                    	<input type="text" name="<portlet:namespace/>TelCell" 
						                    		id="<portlet:namespace/>TelCell" 
						                    		class="input-custom-light data-parsley-validated"
						                    		placeholder="<liferay-ui:message key="whistle-inserimento-tel-cell"/>" 
						                    		value="${richiedente.getTelefono()}"
						                    		data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}"
													data-parsley-maxlength="30"
													data-parsley-maxlength-message="<liferay-ui:message key="whistle-max-length-dati-personali"/>"
													data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
													data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"   
						                    		data-parsley-required="true" 
						                    		data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
						                    </c:if>
	                                    </div>
	                                    
	                                    <!-- EMAIL -->
	                                    <div class="ama-col-xs-12 ama-col-md-4 mb-25-xs">
	                                        <label class="label-form"><liferay-ui:message key="whistle-inserimento-email"/> (*)</label>
	                                        <c:if test="${richiedente.getUfficioRichiedente() == null}">
						                    	<input type="text" name="<portlet:namespace/>Email" 
						                    		id="<portlet:namespace/>Email" 
						                    		class="input-custom-light data-parsley-validated" 
						                    		placeholder="<liferay-ui:message key="whistle-inserimento-email"/>"
						                    		data-parsley-type="email"
													data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"   
													data-parsley-maxlength="320"
													data-parsley-maxlength-message="<liferay-ui:message key="whistle-max-length-email"/>"
						                    		data-parsley-required="true" 
						                    		data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
						                    </c:if>
						                    <c:if test="${richiedente.getUfficioRichiedente() != null}">
						                    	<input type="text" name="<portlet:namespace/>Email" 
						                    		id="<portlet:namespace/>Email" 
						                    		class="input-custom-light data-parsley-validated" 
						                    		value="${richiedente.getEmail()}" 
						                    		placeholder="<liferay-ui:message key="whistle-inserimento-email"/>"
         		                                    data-parsley-type="email"
													data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"  
													data-parsley-maxlength="320"
													data-parsley-maxlength-message="<liferay-ui:message key="whistle-max-length-email"/>"
						                    		data-parsley-required="true" 
						                    		data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>">
						                    </c:if>
	                                    </div>
	                                    
	                                    <!-- DATA FATTO -->
	                                    <div class="ama-col-xs-12 ama-col-md-4 mb-25-xs">
	                                        <label class="label-form"><liferay-ui:message key="whistle-inserimento-data-fatto"/> (*)</label>
	                                        <c:if test="<%=richiedente.getData_fatto()==null || "".equalsIgnoreCase(richiedente.getData_fatto())%>">
	                                        <input type="text" 
					                   		   name="<portlet:namespace/>DataFatto" 
					                   		   id="<portlet:namespace/>DataFatto" 
					                   		   class="input-custom-light datepicker-custom data-parsley-validated" 
					                     	   placeholder="<liferay-ui:message key="whistle-inserimento-data-fatto"/>"
					                     	   data-parsley-pattern="/(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(19)\d\d|(20)\d\d/"
											   data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>" 
					                           data-parsley-required="true" 
					                           data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
					                           data-parsley-check-date-before-today="#<portlet:namespace/>DataFatto">
					                        </c:if>
					                        <c:if test="<%=richiedente.getData_fatto()!=null && !"".equalsIgnoreCase(richiedente.getData_fatto())%>">
					                        <input type="text" 
					                   		   name="<portlet:namespace/>DataFatto" 
					                   		   id="<portlet:namespace/>DataFatto" 
					                   		   class="input-custom-light datepicker-custom data-parsley-validated" 
					                     	   value="${richiedente.getData_fatto()}" 
					                     	   placeholder="<liferay-ui:message key="whistle-inserimento-data-fatto"/>"
					                     	   data-parsley-pattern="/(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(19)\d\d|(20)\d\d/"
											   data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>" 
					                           data-parsley-required="true" 
					                           data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
					                           data-parsley-check-date-before-today="#<portlet:namespace/>DataFatto">
					                        </c:if>
	                                    </div>
	                                    
	                            </div>
	                        </form>
	                        
	                    </div>
	                </div>
	            </div> 
	        </div>          
	    </div>
	    
	    <form method="post" data-parsley-validate="true" id="<portlet:namespace/>formLuogo" enctype="multipart/form-data">
		    <!-- LUOGO -->
		    <div class="ama-row">
		        <div class="ama-col-md-12">
		            <div class="wrapper-title-small">
		                <h2 class="title-box borders"><liferay-ui:message key="whistle-inserimento-lbl-luogo"/> (*)</h2>
		            </div>
		        </div>
		    </div>    
		    <div class="ama-row">
		        <div class="ama-col-xs-12">
		            <div class="wrapper-whisteblowing">
		                <div class="ama-row">
		                    <div class="ama-col-xs-12">
		                        
		                            <div class="ama-row">
	                                    <div class="ama-col-xs-12">
	                                        <div class="box-gray">
	                                            <div class="box-white">
	                                            
	                                            	<!-- INTERNO -->
	                                                <div class="ama-row">
	                                                    <p class="mb-25-xs pl-10-xs pr-10-xs"><em><liferay-ui:message key="whistle-inserimento-inserire-dati"/></em></p>
	                                                    <div class="ama-col-xs-12 ama-col-md-12 mb-25-xs">
	                                                        <form class="form-inline">
	                                                            <div class="ama-row">
	                                                                <div class="ama-col-md-4">
	                                                                    <label class="label-form" for="ufficio"><liferay-ui:message key="whistle-inserimento-luogo-ufficio"/></label>
	                                                                </div>
	                                                                <div class="ama-col-md-8">
	                                                                    <div class="form-group">     
	                                                                    <c:if test="<%=moduloSegnalazione.getUfficio()==null || "".equalsIgnoreCase(moduloSegnalazione.getUfficio())%>">                                                                   
	                                                                        <input type="text" name="<portlet:namespace/>LuogoUfficio"
	                                                                        	oninput="onInputLuogo(event,this)" 
	                                                                        	placeholder="<liferay-ui:message key="whistle-inserimento-ph-luogo-ufficio"/>"
	                                                                        	data-parsley-maxlength="100"
																				data-parsley-maxlength-message="<liferay-ui:message key="whistle-max-length-luogo"/>"
	                                                                        	data-parsley-required="true"
	                                                                        	data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
	                                                                        	id="<portlet:namespace/>LuogoUfficio" 
	                                                                        	class="input-custom-light">
	                                                                    </c:if>
	                                                                    <c:if test="<%=moduloSegnalazione.getUfficio()!=null && !"".equalsIgnoreCase(moduloSegnalazione.getUfficio())%>">
	                                                                    	<input type="text" name="<portlet:namespace/>LuogoUfficio"
	                                                                        	oninput="onInputLuogo(event,this)" 
	                                                                        	placeholder="<liferay-ui:message key="whistle-inserimento-ph-luogo-ufficio"/>"
	                                                                        	data-parsley-maxlength="100"
																				data-parsley-maxlength-message="<liferay-ui:message key="whistle-max-length-luogo"/>"
	                                                                        	data-parsley-required="true"
	                                                                        	data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
	                                                                        	id="<portlet:namespace/>LuogoUfficio" 
	                                                                        	class="input-custom-light"
	                                                                        	value="<%=HtmlUtil.escape(moduloSegnalazione.getUfficio())%>">
	                                                                    </c:if>
	                                                                    </div>
	                                                                </div>
	                                                            </div>
	                                                        </form>                                                  
	                                                    </div>
	                                                </div>
	                                              
	    											<!-- ESTERNO -->
	                                                <div class="ama-row">
	                                                    <div class="ama-col-xs-12 ama-col-md-12 mb-25-xs">
	                                                        <form class="form-inline">
	                                                            <div class="ama-row">
	                                                                <div class="ama-col-md-4">
	                                                                    <label class="label-form" for="esterno-ufficio"><liferay-ui:message key="whistle-inserimento-luogo-esterno"/></label>
	                                                                </div>
	                                                                <div class="ama-col-md-8">
	                                                                    <div class="form-group">
	                                                                    <c:if test="<%=moduloSegnalazione.getUfficio_esterno()==null || "".equalsIgnoreCase(moduloSegnalazione.getUfficio_esterno())%>">
	                                                                        <input type="text" name="<portlet:namespace/>LuogoEsterno"
	                                                                        	oninput="onInputLuogo(event,this)"
	                                                                        	placeholder="<liferay-ui:message key="whistle-inserimento-ph-luogo-esterno"/>"
	                                                                        	data-parsley-maxlength="100"
																				data-parsley-maxlength-message="<liferay-ui:message key="whistle-max-length-luogo"/>"
	                                                                        	data-parsley-required="true"
	                                                                        	data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
	                                                                        	id="<portlet:namespace/>LuogoEsterno" 
	                                                                        	class="input-custom-light" >
	                                                                    </c:if>
	                                                                    <c:if test="<%=moduloSegnalazione.getUfficio_esterno()!=null && !"".equalsIgnoreCase(moduloSegnalazione.getUfficio_esterno())%>">
	                                                                    	<input type="text" name="<portlet:namespace/>LuogoEsterno"
	                                                                        	oninput="onInputLuogo(event,this)"
	                                                                        	placeholder="<liferay-ui:message key="whistle-inserimento-ph-luogo-esterno"/>"
	                                                                        	data-parsley-maxlength="100"
																				data-parsley-maxlength-message="<liferay-ui:message key="whistle-max-length-luogo"/>"
	                                                                        	data-parsley-required="true"
	                                                                        	data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
	                                                                        	id="<portlet:namespace/>LuogoEsterno" 
	                                                                        	class="input-custom-light"
	                                                                        	value="<%=HtmlUtil.escape(moduloSegnalazione.getUfficio_esterno())%>">
	                                                                    </c:if>
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
		                        
		                    </div>
		                </div>
		            </div> 
		        </div>          
		    </div>
	    </form>
	    
	    <!-- AZIONI/OMISSIONI -->
	    <div class="ama-row">
	        <div class="ama-col-md-12">
	            <div class="wrapper-title-small">
	                <h2 class="title-box borders"><liferay-ui:message key="whistle-inserimento-lbl-azioni-omissioni"/> (*)</h2>
	            </div>
	        </div>
	    </div>
	    <div class="ama-row">
	        <div class="ama-col-xs-12">
	            <div class="wrapper-whisteblowing">
	                <div class="ama-row">
	                    <div class="ama-col-xs-12">
	                    
	                            <div class="ama-row">
	    							<form method="post" data-parsley-validate="true" id="<portlet:namespace/>formAzioniOmissioni" enctype="multipart/form-data">
	                                    <div class="ama-col-md-12 ama-col-xs-12 pt-10-md pt-20-xs">
	                                        <div class="box-gray">
	                                            <div class="box-white">
	                                                <div class="ama-row">
	                                                
	                                                	<input style="display:none"
	                                                		id="<portlet:namespace/>AzioniOmissioniParsley"
	                                                		class="data-parsley-validated" 
	                                                		name="<portlet:namespace/>AzioniOmissioniParsley"
	                                                		data-parsley-required="true" 
					                           				data-parsley-required-message="<liferay-ui:message key="whistle-error-seleziona-checkbox"/>" >
	                                                
	                                                    <div class="ama-col-md-12 ama-col-xs-12 pb-10-md pb-10-xs pt-10-md pt-10-xs">
	                                                        <div class="checkbox-blue">
	                                                            <div class="squaredOne">
	                                                            <c:if test="<%=moduloSegnalazione.getCheck()==null || moduloSegnalazione.getCheck().isEmpty() || !moduloSegnalazione.getCheck().contains("penalmente rilevanti")%>">
	                                                                <input type="checkbox" value="<liferay-ui:message key="whistle-inserimento-penalmente-rilevanti"/>" 
	                                                                	id="penale"
	                                                                   	class="checkBoxAzioniOmissioni"
	                                                                   	onclick="onClickAzioniOmissioni(this)"
                                    									name="checkAzioniOmissioni">
                                    							</c:if>
                                    							<c:if test="<%=moduloSegnalazione.getCheck()!=null && !moduloSegnalazione.getCheck().isEmpty() && moduloSegnalazione.getCheck().contains("penalmente rilevanti")%>">
	                                                            	<input type="checkbox" value="<liferay-ui:message key="whistle-inserimento-penalmente-rilevanti"/>" 
	                                                                	id="penale"
	                                                                   	class="checkBoxAzioniOmissioni"
	                                                                   	onclick="onClickAzioniOmissioni(this)"
                                    									name="checkAzioniOmissioni"
                                    									checked>
	                                                            </c:if>
	                                                                <label for="penale"></label>
	                                                            </div>
	                                                            <p class="text-check ml-15-md ml-15-xs"><liferay-ui:message key="whistle-inserimento-penalmente-rilevanti"/></p>
	                                                        </div>
	                                                    </div>
	                                                    <div class="ama-col-md-12 ama-col-xs-12 pb-10-md pb-10-xs pt-10-md pt-10-xs">
	                                                        <div class="checkbox-blue">
	                                                            <div class="squaredOne">
	                                                            <c:if test="<%=moduloSegnalazione.getCheck()==null || moduloSegnalazione.getCheck().isEmpty() || !moduloSegnalazione.getCheck().contains("poste in essere in violazione dei Codici di comportamento o di altre disposizioni sanzionabili in via disciplinare")%>">
	                                                                <input type="checkbox" value="<liferay-ui:message key="whistle-inserimento-disciplinare"/>" 
	                                                                	id="codici" 
	                                                                	class="checkBoxAzioniOmissioni"
	                                                                	onclick="onClickAzioniOmissioni(this)"
                                    									name="checkAzioniOmissioni">
                                    							</c:if>
                                    							<c:if test="<%=moduloSegnalazione.getCheck()!=null && !moduloSegnalazione.getCheck().isEmpty() && moduloSegnalazione.getCheck().contains("poste in essere in violazione dei Codici di comportamento o di altre disposizioni sanzionabili in via disciplinare")%>">
	                                                            	<input type="checkbox" value="<liferay-ui:message key="whistle-inserimento-disciplinare"/>" 
	                                                                	id="codici" 
	                                                                	class="checkBoxAzioniOmissioni"
	                                                                	onclick="onClickAzioniOmissioni(this)"
                                    									name="checkAzioniOmissioni"
                                    									checked>
	                                                            </c:if>
	                                                               <label for="codici"></label>
	                                                            </div>
	                                                            <p class="text-check ml-15-md ml-15-xs"><liferay-ui:message key="whistle-inserimento-disciplinare"/></p>
	                                                        </div>
	                                                    </div>
	                                                    <div class="ama-col-md-12 ama-col-xs-12 pb-10-md pb-10-xs pt-10-md pt-10-xs">
	                                                        <div class="checkbox-blue">
	                                                            <div class="squaredOne">
	                                                             <c:if test="<%=moduloSegnalazione.getCheck()==null || moduloSegnalazione.getCheck().isEmpty() || !moduloSegnalazione.getCheck().contains("suscettibili ad arrecare un pregiudizio patrimoniale all'amministrazione di appartenenza o ad altro ente pubblico")%>">
	                                                                <input type="checkbox" value="<liferay-ui:message key="whistle-inserimento-pregiuzio-patrimoniale"/>" 
	                                                                	id="pregiudizio-patrimoniale"
	                                                                	class="checkBoxAzioniOmissioni"
	                                                                	onclick="onClickAzioniOmissioni(this)" 
	                                                                	name="check">
	                                                             </c:if>
                                    							 <c:if test="<%=moduloSegnalazione.getCheck()!=null && !moduloSegnalazione.getCheck().isEmpty() && moduloSegnalazione.getCheck().contains("suscettibili ad arrecare un pregiudizio patrimoniale all'amministrazione di appartenenza o ad altro ente pubblico")%>">
	                                                             	<input type="checkbox" value="<liferay-ui:message key="whistle-inserimento-pregiuzio-patrimoniale"/>" 
	                                                                	id="pregiudizio-patrimoniale"
	                                                                	class="checkBoxAzioniOmissioni"
	                                                                	onclick="onClickAzioniOmissioni(this)" 
	                                                                	name="check"
	                                                                	checked>
	                                                             </c:if>
	                                                               <label for="pregiudizio-patrimoniale"></label>
	                                                            </div>
	                                                            <p class="text-check ml-15-md ml-15-xs"><liferay-ui:message key="whistle-inserimento-pregiuzio-patrimoniale"/></p>
	                                                        </div>
	                                                    </div>
	                                                    <div class="ama-col-md-12 ama-col-xs-12 pb-10-md pb-10-xs pt-10-md pt-10-xs">
	                                                        <div class="checkbox-blue">
	                                                            <div class="squaredOne">
	                                                            <c:if test="<%=moduloSegnalazione.getCheck()==null || moduloSegnalazione.getCheck().isEmpty() || !moduloSegnalazione.getCheck().contains("suscettibili ad arrecare un pregiudizio all'immagine dell'amministrazione")%>">
	                                                                <input type="checkbox" value="<liferay-ui:message key="whistle-inserimento-pregiuzio-immagine"/>" 
	                                                                	id="pregiudizio-immagine" 
	                                                                	class="checkBoxAzioniOmissioni"
	                                                                	onclick="onClickAzioniOmissioni(this)" 
	                                                                	name="check">
	                                                            </c:if>
                                    							<c:if test="<%=moduloSegnalazione.getCheck()!=null && !moduloSegnalazione.getCheck().isEmpty() && moduloSegnalazione.getCheck().contains("suscettibili ad arrecare un pregiudizio all'immagine dell'amministrazione")%>">
	                                                            	<input type="checkbox" value="<liferay-ui:message key="whistle-inserimento-pregiuzio-immagine"/>" 
	                                                                	id="pregiudizio-immagine" 
	                                                                	class="checkBoxAzioniOmissioni"
	                                                                	onclick="onClickAzioniOmissioni(this)" 
	                                                                	name="check"
	                                                                	checked>
	                                                            </c:if>
	                                                               <label for="pregiudizio-immagine"></label>
	                                                            </div>
	                                                            <p class="text-check ml-15-md ml-15-xs"><liferay-ui:message key="whistle-inserimento-pregiuzio-immagine"/></p>
	                                                        </div>
	                                                    </div>
	                                                    <div class="ama-col-md-12 ama-col-xs-12 pb-10-md pb-10-xs pt-10-md pt-10-xs">
	                                                        <div class="checkbox-blue whistel-check-other">
	                                                            <div class="squaredOne">
	                                                            <c:if test="<%=moduloSegnalazione.getCheck()==null || moduloSegnalazione.getCheck().isEmpty() || !moduloSegnalazione.getCheck().contains("altro (specificare)")%>">
	                                                                <input type="checkbox" value="<liferay-ui:message key="whistle-inserimento-altro"/>" 
	                                                                	id="altro" 
	                                                                	class="checkBoxAzioniOmissioni" 
	                                                                	onclick="onClickAzioniOmissioni(this)"
	                                                                	name="check">
	                                                            </c:if>
	                                                            <c:if test="<%=moduloSegnalazione.getCheck()!=null && !moduloSegnalazione.getCheck().isEmpty() && moduloSegnalazione.getCheck().contains("altro (specificare)")%>">
	                                                            	<input type="checkbox" value="<liferay-ui:message key="whistle-inserimento-altro"/>" 
	                                                                	id="altro" 
	                                                                	class="checkBoxAzioniOmissioni" 
	                                                                	onclick="onClickAzioniOmissioni(this)"
	                                                                	name="check"
	                                                                	checked>
	                                                            </c:if>
	                                                               <label for="altro"></label>
	                                                            </div>
	                                                            <p class="text-check ml-15-md ml-15-xs"><liferay-ui:message key="whistle-inserimento-altro"/></p>
	                                                            <div class="whistel-input-div">
	                                                            <c:if test="<%=moduloSegnalazione.getAltro()==null || "".equalsIgnoreCase(moduloSegnalazione.getAltro())%>">
									                                <input style="display:none"
									                                	id="<portlet:namespace/>AltroSpecificare" 
									                                	class="input-custom-light data-parsley-validated"
									                                	placeholder="<liferay-ui:message key="whistle-inserimento-altro"/>"
									                                	data-parsley-maxlength="150"
																		data-parsley-maxlength-message="<liferay-ui:message key="whistle-max-length-altro"/>"
									                                	data-parsley-required="false"
									                                	data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" > 
									                            </c:if>
									                            <c:if test="<%=moduloSegnalazione.getAltro()!=null && !"".equalsIgnoreCase(moduloSegnalazione.getAltro())%>">
									                            <input id="<portlet:namespace/>AltroSpecificare" 
									                                	class="input-custom-light data-parsley-validated"
									                                	placeholder="<liferay-ui:message key="whistle-inserimento-altro"/>"
									                                	data-parsley-maxlength="150"
																		data-parsley-maxlength-message="<liferay-ui:message key="whistle-max-length-altro"/>"
									                                	data-parsley-required="false"
									                                	data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
									                                	value="<%=HtmlUtil.escape(moduloSegnalazione.getAltro())%>">
									                            </c:if>
	                                                            </div>
	                                                        </div>
	                                                    </div>
				                                        
				                                        <span><em><liferay-ui:message key="whistle-inserimento-span-rimostranze"/></em></span>
	                                                    
	                                                </div>
	                                            </div>
	                                        </div>
	                                    </div>
	                                </form>
	                                
	                                <form method="post" data-parsley-validate="true" id="<portlet:namespace/>formTextarea" enctype="multipart/form-data">
	                                    <!-- DESCRIZIONE DEL FATTO -->	
	                                    <div class="ama-col-md-12 ama-col-xs-12 mb-15-md mb-10-xs pt-40-md pb-20-md">
	                                        <div class="wrapper-content-textarea">
	                                            <label class="label-form margin-top" for="textarea-motivo"><liferay-ui:message key="whistle-inserimento-descrizione"/> (*)</label>
	                                            <c:if test="<%=moduloSegnalazione.getDescrizione()==null || "".equalsIgnoreCase(moduloSegnalazione.getDescrizione())%>">
	                                            <textarea class="form-control textarea-custom-light data-parsley-validated" 
	                                            	  placeholder="<liferay-ui:message key="whistle-inserimento-ph-aggiungi-motivazione"/>"
	                                            	  data-parsley-maxlength="1000"
													  data-parsley-maxlength-message="<liferay-ui:message key="whistle-max-length-textarea"/>"
						                   			  data-parsley-validation-threshold="10"
						                   			  data-parsley-required="true" 
						                    		  data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
						                   			  name="Descrizione" 
						                   			  id="<portlet:namespace/>textarea-descrizione"></textarea>
	                                            <div class="content-textarea">0/1000</div>
	                                            </c:if>
	                                            <c:if test="<%=moduloSegnalazione.getDescrizione()!=null && !"".equalsIgnoreCase(moduloSegnalazione.getDescrizione())%>">
	                                            <textarea class="form-control textarea-custom-light data-parsley-validated" 
	                                            	  placeholder="<liferay-ui:message key="whistle-inserimento-ph-aggiungi-motivazione"/>"
	                                            	  data-parsley-maxlength="1000"  
	                                            	  data-parsley-maxlength-message="<liferay-ui:message key="whistle-max-length-textarea"/>"
						                   			  data-parsley-validation-threshold="10"
						                   			  data-parsley-required="true" 
						                    		  data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
						                   			  name="Descrizione" 
						                   			  id="<portlet:namespace/>textarea-descrizione"><%=moduloSegnalazione.getDescrizione()%></textarea>
	                                            <div class="content-textarea"><%=moduloSegnalazione.getDescrizione().length()%>/1000</div>
	                                            </c:if>
	                                        </div>
	                                    </div>
	                                    <!-- AUTORE DEL FATTO -->
	                                    <div class="ama-col-md-12 ama-col-xs-12 mb-15-md mb-10-xs pt-20-md pb-20-md">
	                                        <div class="wrapper-content-textarea">
	                                            <label class="label-form margin-top" for="textarea-motivo">
	                                            	<liferay-ui:message key="whistle-inserimento-autore"/> 
				                                    <span class="disclaimer-italic" ><em><liferay-ui:message key="whistle-inserimento-span-identificazione"/></em></span>
	                                            </label>
	                                            <c:if test="<%=moduloSegnalazione.getAutore()==null || "".equalsIgnoreCase(moduloSegnalazione.getAutore())%>">
	                                            <textarea class="form-control textarea-custom-light data-parsley-validated" 
	                                             	  placeholder="<liferay-ui:message key="whistle-inserimento-ph-aggiungi-motivazione"/>"
	                                             	  data-parsley-maxlength="1000" 
	                                             	  data-parsley-maxlength-message="<liferay-ui:message key="whistle-max-length-textarea"/>"
						                   			  data-parsley-validation-threshold="10" 
						                   			  name="Autore" 
						                   			  id="<portlet:namespace/>textarea-autore"></textarea>
	                                            <div class="content-textarea">0/1000</div>
	                                            </c:if>
	                                            <c:if test="<%=moduloSegnalazione.getAutore()!=null && !"".equalsIgnoreCase(moduloSegnalazione.getAutore())%>">
	                                            <textarea class="form-control textarea-custom-light data-parsley-validated" 
	                                             	  placeholder="<liferay-ui:message key="whistle-inserimento-ph-aggiungi-motivazione"/>"
	                                             	  data-parsley-maxlength="1000" 
	                                             	  data-parsley-maxlength-message="<liferay-ui:message key="whistle-max-length-textarea"/>"
						                   			  data-parsley-validation-threshold="10" 
						                   			  name="Autore" 
						                   			  id="<portlet:namespace/>textarea-autore"><%=moduloSegnalazione.getAutore()%></textarea>
	                                            <div class="content-textarea"><%=moduloSegnalazione.getAutore().length()%>/1000</div>
	                                            </c:if>
	                                        </div>
	                                    </div>
	                                    
	                                    <div class="ama-col-md-12 ama-col-xs-12 mb-15-md mb-10-xs pt-20-md pb-20-md">
	                                        <div class="wrapper-content-textarea">
	                                            <label class="label-form margin-top" for="textarea-motivo">
	                                            	<liferay-ui:message key="whistle-inserimento-altri-soggetti"/>
	                                            	<span class="disclaimer-italic"><em><liferay-ui:message key="whistle-inserimento-span-identificazione"/></em></span>
	                                            </label>
	                                            
	                                            <c:if test="<%=moduloSegnalazione.getAltri_soggetti()==null || "".equalsIgnoreCase(moduloSegnalazione.getAltri_soggetti())%>">
	                                            <textarea class="form-control textarea-custom-light data-parsley-validated" 
	                                            	placeholder="<liferay-ui:message key="whistle-inserimento-ph-aggiungi-motivazione"/>"
	                                            	data-parsley-maxlength="1000" 
	                                            	data-parsley-maxlength-message="<liferay-ui:message key="whistle-max-length-textarea"/>"
						                   			data-parsley-validation-threshold="10" 
						                   			name="Altri-soggetti" 
						                   			id="<portlet:namespace/>textarea-altri-soggetti"></textarea>
	                                            <div class="content-textarea">0/1000</div>
	                                            </c:if>
	                                            <c:if test="<%=moduloSegnalazione.getAltri_soggetti()!=null && !"".equalsIgnoreCase(moduloSegnalazione.getAltri_soggetti())%>">
	                                            <textarea class="form-control textarea-custom-light data-parsley-validated" 
	                                            	placeholder="<liferay-ui:message key="whistle-inserimento-ph-aggiungi-motivazione"/>"
	                                            	data-parsley-maxlength="1000" 
	                                            	data-parsley-maxlength-message="<liferay-ui:message key="whistle-max-length-textarea"/>"
						                   			data-parsley-validation-threshold="10" 
						                   			name="Altri-soggetti" 
						                   			id="<portlet:namespace/>textarea-altri-soggetti"><%=moduloSegnalazione.getAltri_soggetti()%></textarea>
	                                            <div class="content-textarea"><%=moduloSegnalazione.getAltri_soggetti().length()%>/1000</div>
	                                            </c:if>
	                                        </div>
	                                    </div>
	                        		</form>
	                        		
                            </div>
	                    </div>
	                </div>
	            </div> 
	        </div>          
	    </div>
	    

    
    <!-- ALLEGATI -->
    <div class="ama-row">
        <div class="ama-col-md-12">
            <div class="wrapper-title-small">
                <h2 class="title-box borders"><liferay-ui:message key="whistle-inserimento-lbl-allegati"/></h2>
            </div>
        </div>
    </div>
    <div class="ama-row">
        <div class="ama-col-xs-12">
            <div class="wrapper-whisteblowing">
                <div class="ama-row">
                    <div class="ama-col-xs-12">
                            <div class="ama-row">
                                  
                                  <div class="ama-col-xs-12 mb-30-xs">
                                      <p class="mb-25-xs disclaimer-upload"><liferay-ui:message key="whistle-inserimento-allegati-info"/></p>
                                      <div class="box-gray">
                                          <div class="ama-row text-center">
                                              <div class="box-button">
                                                  <button href="#" type="button"
                                                  	id="<portlet:namespace/>addAttachFile" 
                                                  	onclick="selectAllegatoRichiestaBadge(event);" 
                                                  	class="button button-primary"><liferay-ui:message key="whistle-inserimento-bnt-seleziona-file"/></button>
                                              </div>
                                          </div>
                                      </div>
                                  </div>
                                  
                                  <div class="ama-col-xs-12 mobile-no-padding" id="<portlet:namespace/>allegatoDivBoxGray" style="display:none">
                                      <div class="wrapper-content-allegati">
                                      	 <div id="allegatoDiv">

								  		 </div>
                                      </div>
                                  </div>
                                  
                                  <form data-parsley-validate="true" action="<%=riepilogoDati%>" method="post" id="<portlet:namespace/>formSegnalazione" enctype="multipart/form-data">
								 	<input type="hidden" id="<portlet:namespace/>jsonSegnalante" data-parsley-required="true" name="<portlet:namespace/>jsonSegnalante">
								 	<input type="hidden" id="<portlet:namespace/>luogoUfficio" name="<portlet:namespace/>luogoUfficio">
								 	<input type="hidden" id="<portlet:namespace/>luogoEsterno" name="<portlet:namespace/>luogoEsterno">
								 	<input type="hidden" id="<portlet:namespace/>azioni_omissioni" name="<portlet:namespace/>azioni_omissioni">
								 	<input type="hidden" id="<portlet:namespace/>input_altro_specificare" name="<portlet:namespace/>input_altro_specificare">
								 	<input type="hidden" id="<portlet:namespace/>descrizione" name="<portlet:namespace/>descrizione">
								 	<input type="hidden" id="<portlet:namespace/>autore" name="<portlet:namespace/>autore">
								 	<input type="hidden" id="<portlet:namespace/>altri_testimoni" name="<portlet:namespace/>altri_testimoni">
								 	
								 	<input type="hidden" id="<portlet:namespace/>count_allegati" name="<portlet:namespace/>count_allegati">
								
								   	<div id="allegatoDivInput">
									</div>
							     </form>   
                                     
                                  <div class="ama-col-xs-12 text-right mb-40-xs mt-40-xs">
                                      <button href="#" type="button" onclick="vaiARiepilogo()" class="button button-primary"><liferay-ui:message key="whistle-inserimento-bnt-conferma"/></button>
                                  </div>
    
                            </div>
                    </div>
                </div>
            </div> 
        </div>          
    </div>
</div>
    

 
<script>

	var countAllegati = 0 + <%=size_allegati%>;
	var index = 0;

	var idFileAttach = "#<portlet:namespace/>allegato";
	var idSelectFile = "#<portlet:namespace/>selectFile";

	onInputLuogoParsley();
	onCheckAzioniOmissioniFromModifica();
	
	if(countAllegati > 0){
		generaAllegatifromModifica();
		$("#<portlet:namespace/>allegatoDivBoxGray").css("display","block");
	
		if(countAllegati >= 5){
			$("#<portlet:namespace/>addAttachFile").css("display","none");
		}
	}
    
    function onInputLuogoParsley ( ){
          if( !$("#<portlet:namespace/>LuogoUfficio").val() && !$("#<portlet:namespace/>LuogoEsterno").val() ){
                $("#<portlet:namespace/>LuogoUfficio").attr("data-parsley-required", "true");
                $("#<portlet:namespace/>LuogoEsterno").attr("data-parsley-required", "true");
          } else {
            if( $("#<portlet:namespace/>LuogoUfficio").val() ){
               $("#<portlet:namespace/>LuogoUfficio").attr("data-parsley-required", "true");                                                         
               $("#<portlet:namespace/>LuogoEsterno").attr("data-parsley-required", "false");
            } 
            if( $("#<portlet:namespace/>LuogoEsterno").val() ){
               $("#<portlet:namespace/>LuogoEsterno").attr("data-parsley-required", "true");
               $("#<portlet:namespace/>LuogoUfficio").attr("data-parsley-required", "false");
            }
          }
    }

	
	function onInputLuogo(event, input){
        event.preventDefault();
        if( input.id == "<portlet:namespace/>LuogoUfficio" ){
        	if( input.value.length > 0 ){
	           $(input).attr("data-parsley-required", "true");
	           $("#<portlet:namespace/>LuogoEsterno").val("");                                                          
	           $("#<portlet:namespace/>LuogoEsterno").attr("data-parsley-required", "false");
        	}
        } 
        
        if( input.id == "<portlet:namespace/>LuogoEsterno" ){
        	if( input.value.length > 0 ){
	           $(input).attr("data-parsley-required", "true");
	           $("#<portlet:namespace/>LuogoUfficio").val("");
	           $("#<portlet:namespace/>LuogoUfficio").attr("data-parsley-required", "false");
        	}
        }
	}
	
	function onClickAzioniOmissioni ( input ) {
		
		var parsleyRequired = true;
		
		if( input.checked ){
			 parsleyRequired = false;
		} else {
			 var inputElements = document.getElementsByClassName('checkBoxAzioniOmissioni');
			 for(var i=0; inputElements[i]; ++i){
		       if(inputElements[i].checked){
		    	   parsleyRequired = false;
		    	   break;
		       }
			 }
		}
		
		$("#<portlet:namespace/>AzioniOmissioniParsley").attr("data-parsley-required", parsleyRequired );
		
		if( $("#altro").is(":checked") ){
			$("#<portlet:namespace/>AltroSpecificare").attr("data-parsley-required", true );
			$("#<portlet:namespace/>AltroSpecificare").css("display","block");
		} else {
			$("#<portlet:namespace/>AltroSpecificare").attr("data-parsley-required", false );
			$("#<portlet:namespace/>AltroSpecificare").val("");
			$("#<portlet:namespace/>AltroSpecificare").css("display","none");
		}
		
	}
	
function onCheckAzioniOmissioniFromModifica() {
		
	var parsleyRequired = true;
	
	var inputElements = document.getElementsByClassName('checkBoxAzioniOmissioni');
	
	 for(var i=0; inputElements[i]; ++i){
       if(inputElements[i].checked){
    	   parsleyRequired = false;
    	   break;
       }
	 }
		
		$("#<portlet:namespace/>AzioniOmissioniParsley").attr("data-parsley-required", parsleyRequired );
		
		if( $("#altro").is(":checked") ){
			$("#<portlet:namespace/>AltroSpecificare").attr("data-parsley-required", true );
			$("#<portlet:namespace/>AltroSpecificare").css("display","block");
		} else {
			$("#<portlet:namespace/>AltroSpecificare").attr("data-parsley-required", false );
			$("#<portlet:namespace/>AltroSpecificare").val("");
			$("#<portlet:namespace/>AltroSpecificare").css("display","none");
		}
		
	}
	
	function selectAllegatoRichiestaBadge(event){
		
		 $('.parsley-filemaxmegabytes').remove();
	     event.preventDefault();
	     index = 1;
	     
	     if( countAllegati <= 5 ){
    		 for(var i=1; i<=5; i++){
    			index = i;
    			var allegatoHidden = document.getElementById("<portlet:namespace/>allegato"+i+"HiddenInput");
    			if( !allegatoHidden ){
    	   			var allegato = document.getElementById("<portlet:namespace/>allegato"+i+"Input");
       			    if( allegato ) {
       			    	if( allegato.files.length == 0 ){
       			    		$("#<portlet:namespace/>allegato"+i+"Input").remove();
    			   		    generateAllegatoInput( );
      			    		break;
       			    	}
       			    }
       			    else {
       			    	generateAllegatoInput( );
    		   		    break;
      			    } 
       			    allegato = null;
    			}
 
    		 }
	      	 $(idFileAttach+index+"Input").click();	
	     }
	 }
	
		
	 function generateAllegatoInput ( ){
	     
		 var input = document.createElement("input");
		 var name = "<portlet:namespace/>allegato"+index+"Input";
		 
		 $(input).attr("id",name);
	     $(input).addClass('data-parsley-validated');
	     
	     $(input).attr("name",name);
	     $(input).attr("type","file");
	     $(input).css("display","none");
	
	     $(input).attr("data-parsley-filemaxmegabytes","5");
	     $(input).attr("data-parsley-trigger","change");
	     
	     $(input).change(function() {
	    	 if( this.value != null && this.value != '' )
	           	changeDisplay(this.value,index);
	     });
	     
	     $("#allegatoDivInput").append(input); 
	 }
	 
	 function changeDisplay(val,index){
			 
		var isValidAllegato = $("#<portlet:namespace/>allegato"+index+"Input").parsley().isValid();
		$("#<portlet:namespace/>allegato"+index+"Input").parsley().validate();
		
		if( isValidAllegato ){
			
			$("#<portlet:namespace/>allegatoDivBoxGray").css("display","block");
			
			countAllegati++;
			if(countAllegati >= 5){
				$("#<portlet:namespace/>addAttachFile").css("display","none");
			}
			 
			var idAllegato = "<portlet:namespace/>allegato"+index;
			var index = val.lastIndexOf('\\');
	     	var value = val.substring(index+1, val.length);
	     	
	     	var divWrapperWhite = document.createElement("div");
	     	$(divWrapperWhite).attr("id",idAllegato);
	     	$(divWrapperWhite).addClass("wrapper-white");
	     	
	     	var ptext = document.createElement("p");
	     	$(ptext).addClass("text");
	     	
	        var aClose = "<a href='#' title='elimina file' onclick='removeAllegato(event,"; 
	        
	        aClose = aClose.concat('"');
	        aClose = aClose.concat(idAllegato);
	        aClose = aClose.concat('"');
	
	        aClose = aClose.concat(");' class='icomoon-close-white ico-delete'></a>");
							
			$(ptext).append(value);
			$(ptext).append(aClose);
			$(divWrapperWhite).append(ptext);
											
			$("#allegatoDiv").append(divWrapperWhite);
			
		} else {
			$("#<portlet:namespace/>allegato"+index+"Input").remove();
		}
		
	 }
	
	 function removeAllegato(event,idAllegato){
		event.preventDefault();

		$("#"+idAllegato).remove();
		$("#"+idAllegato+"Input").remove();
		countAllegati--;
		$("#<portlet:namespace/>addAttachFile").removeAttr('style'); 
		 
		if(countAllegati == 0){
			$("#<portlet:namespace/>allegatoDivBoxGray").css("display","none");
		}
	 }
	 
	 function vaiARiepilogo(){
		 
		 $('.parsley-filemaxmegabytes').remove();
		 
		 var isValidDatiPersonali = $("#<portlet:namespace/>formDatiPersonali").parsley().isValid();
		 $("#<portlet:namespace/>formDatiPersonali").parsley().validate();
		 
		 var isValidDatiLuogo = $("#<portlet:namespace/>formLuogo").parsley().isValid();
		 $("#<portlet:namespace/>formLuogo").parsley().validate();
		 
		 var isValidDatiAzioniOmissioni = $("#<portlet:namespace/>formAzioniOmissioni").parsley().isValid();
		 $("#<portlet:namespace/>formAzioniOmissioni").parsley().validate();
		 
		 var isValidDatiTextarea = $("#<portlet:namespace/>formTextarea").parsley().isValid();
		 $("#<portlet:namespace/>formTextarea").parsley().validate();
		 
		 if( isValidDatiPersonali ){
			 var jsonSegnalante = {
					nome_cognome: $("#<portlet:namespace/>NomeCognome").val(),
					qualifica: $("#<portlet:namespace/>Qualifica").val(),
					struttura: $("#<portlet:namespace/>Struttura").val(),
					telefono: $("#<portlet:namespace/>TelCell").val(),
					email: $("#<portlet:namespace/>Email").val(),
					dataFatto: $("#<portlet:namespace/>DataFatto").val()
			 }
			 
			 if( isValidDatiLuogo ){
				 var luogoUfficio = $("#<portlet:namespace/>LuogoUfficio").val(); 
				 var luogoEsterno = $("#<portlet:namespace/>LuogoEsterno").val();
			 
				 if( isValidDatiAzioniOmissioni ){
					 var azioni_omissioni = "";
					 var inputElements = document.getElementsByClassName('checkBoxAzioniOmissioni');
					 
					 for(var i=0; inputElements[i]; ++i){
				       if(inputElements[i].checked){
				    	   azioni_omissioni = azioni_omissioni.concat(inputElements[i].value+',');
				       }
					 }
					 azioni_omissioni = azioni_omissioni.substring(0, azioni_omissioni.length-1);
					 
					 var altro_specificare = $("#<portlet:namespace/>AltroSpecificare").val();
					 
					 if( isValidDatiTextarea ){
						 var descrizione = $("#<portlet:namespace/>textarea-descrizione").val();
						 var autore = $("#<portlet:namespace/>textarea-autore").val();
						 var altri_testimoni = $("#<portlet:namespace/>textarea-altri-soggetti").val();
						  
						 $("#<portlet:namespace/>jsonSegnalante").val( JSON.stringify(jsonSegnalante) );
						 $("#<portlet:namespace/>luogoUfficio").val(luogoUfficio);
						 $("#<portlet:namespace/>luogoEsterno").val(luogoEsterno);
						 $("#<portlet:namespace/>azioni_omissioni").val(azioni_omissioni);
						 $("#<portlet:namespace/>input_altro_specificare").val(altro_specificare);
						 $("#<portlet:namespace/>descrizione").val(descrizione);
						 $("#<portlet:namespace/>autore").val(autore); 
						 $("#<portlet:namespace/>altri_testimoni").val(altri_testimoni); 
						 $("#<portlet:namespace/>count_allegati").val(countAllegati);
						
						 $("#<portlet:namespace/>formSegnalazione").submit();
						 
					 }
				 }
			 }	 
		 }
		
	 }
	 
	 
	 
	 function generaAllegatifromModifica() {
		 
		 <% for (int i=1; i <= size_allegati; i++) { %>
		 
		 	 var path = "<%=allegati_list.get(i-1).getAllegato().toString()%>";
			 var input = document.createElement("input");
			 var name = "<portlet:namespace/>allegato"+<%=i%>+"HiddenInput";
			 
			 $(input).attr("id",name);
		     $(input).addClass('data-parsley-validated');
		     
		     $(input).attr("name",name);
		     $(input).attr("type","hidden");
		     $(input).css("display","none");
		
		     $(input).attr("data-parsley-filemaxmegabytes","5");
		     $(input).attr("data-parsley-trigger","change");
		     $(input).attr("value",path);
		     
		     $("#allegatoDivInput").append(input);
			 
			 var idAllegato = "<portlet:namespace/>allegato"+<%=i%>+"Hidden";
			 var indexVal = path.lastIndexOf('/');
	     	 var value = path.substring(indexVal+1, path.length);
	     	
	     	 var divWrapperWhite = document.createElement("div");
	     	 $(divWrapperWhite).attr("id",idAllegato);
	     	 $(divWrapperWhite).addClass("wrapper-white");
	     	
	     	 var ptext = document.createElement("p");
	     	 $(ptext).addClass("text");
	     	
	         var aClose = "<a href='#' title='elimina file' onclick='removeAllegato(event,"; 
	        
	         aClose = aClose.concat('"');
	         aClose = aClose.concat(idAllegato);
	         aClose = aClose.concat('"');
	         aClose = aClose.concat(");' class='icomoon-close-white ico-delete'></a>");
							
			 $(ptext).append(value);
			 $(ptext).append(aClose);
			 $(divWrapperWhite).append(ptext);
											
			$("#allegatoDiv").append(divWrapperWhite);
					
	 	<% } %>
	 }
	 
</script>