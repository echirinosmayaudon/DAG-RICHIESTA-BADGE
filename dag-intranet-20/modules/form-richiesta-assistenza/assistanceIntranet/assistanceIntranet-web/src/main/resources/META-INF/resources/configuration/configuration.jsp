

<%@ include file="./init.jsp" %>
<%
 String tabs = "Tabelle,Email";
%>

<div class="portlet-configuration-edit-sharing">
	<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL" />
	
	<aui:form action="<%= configurationActionURL %>" method="post" name="fm"  enctype = "multipart/form-data">
		<div class="portlet-configuration-body-content">
			<div class="container-fluid-1280">
				<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" persistState="<%= true %>" title="assistance-settings">
					<liferay-ui:tabs names="<%= tabs %>" refresh="<%= false %>" >
							<liferay-ui:section>
								<div class="row">
									<div class="col-md-12">
										<aui:input id="file" label="upload-table" name="fileTable" type="file" >
											<aui:validator name="acceptFiles" errorMessage="errorInputFile">
													'csv'
											</aui:validator>				
										</aui:input>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<aui:input id="file" label="upload-faq" name="fileFaq" type="file" >
											<aui:validator name="acceptFiles" errorMessage="errorInputFile">
													'csv'
											</aui:validator>	
										</aui:input>
									</div>
								</div>
							</liferay-ui:section>
					 
							<liferay-ui:section>
								<div class="row">
									<%
									String emailToAddresses= portletPreferences.getValue(AssistanceConfigurationKeys.EMAIL_ASSISTANCE_TO_ADDRESSES, AssistanceConfigurationValues.EMAIL_ASSISTANCE_TO_ADDRESSES);
									String emailTemplate = portletPreferences.getValue(AssistanceConfigurationKeys.EMAIL_ASSISTANCE_TEMPLATE, ContentUtil.get(AssistanceConfigurationUtil.class.getClassLoader(), AssistanceConfigurationValues.EMAIL_ASSISTANCE_TEMPLATE)); 
									%> 
									
									<div class="col-md-12">
										<aui:fieldset name="Address">
										 <aui:input label="address" class="lfr-input-text-container" helpMessage="a-help" name="<%= AssistanceConfigurationKeys.EMAIL_ASSISTANCE_TO_ADDRESSES %>" value="<%= emailToAddresses %>" style="width:600px;" >
											<aui:validator name="required"/>
												<aui:validator  name="custom"  errorMessage="a-help" >
												function (val, fieldNode, ruleValue) {
													var result = false
													var res = val.split(";");
													var patt =  /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
													for(var i = 0; i < res.length; i++) {
														result= patt.test(res[i]);
														if (!result)
															break;
														}
														return result;
												}
												</aui:validator>
										 </aui:input>
										</aui:fieldset>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<aui:fieldset name="template">
											<aui:input name="<%= AssistanceConfigurationKeys.EMAIL_ASSISTANCE_TEMPLATE %>" type="textarea" value="<%= emailTemplate %>" style="height:300px"/>
										</aui:fieldset>
									
									</div>

									<dl>
										<dt>[$CF_USER$]</dt>
										<dd>Codice fiscale utente richiedente</dd>
		
										<dt>[$FULLNAME_USER$]</dt>
										<dd>FullName utente richiedente</dd>
		
										<dt>[$EMAIL_USER$]</dt>
										<dd>Email utente richiedente</dd>
		
										<dt>[$DESCRIZIONE$]</dt>
										<dd>Descrizione richiesta</dd>
		
										<dt>[$SERVIZIO$]</dt>
										<dd>Servizio scelto per la richiesta di assistenza</dd>
		
										<dt>[$AREA$]</dt>
										<dd>Area scelta per la richiesta di assistenza</dd>
		
										<dt>[$TEMATICA$]</dt>
										<dd>Tematica scelta per la richiesta di assistenza</dd>
		
										<dt>[$TIPOLOGIA_PROBLEMATICA$]</dt>
										<dd>Tipologia problematica</dd>
		
										<dt>[$LIVELLO_ASSISTENZA$]</dt>
										<dd>Livello di assistenza della richiesta</dd>
									</dl>
							
								</div>
							</liferay-ui:section>
				 
						</liferay-ui:tabs>

				</liferay-ui:panel>
		 	</div>
		</div>
		<aui:button-row>
			<aui:button cssClass="btn-lg" type="submit" />
		</aui:button-row>
	</aui:form>
</div>