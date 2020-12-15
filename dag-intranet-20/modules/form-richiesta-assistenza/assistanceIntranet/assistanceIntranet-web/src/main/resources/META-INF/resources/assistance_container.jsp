
<%@page import="javax.portlet.RenderResponse"%>


<portlet:resourceURL id="/assistance/load" var="AssistanceLoadSelectURL" />
<portlet:resourceURL id="/assistance/attachment" var="AttachmentURL" />
 <portlet:resourceURL id="/assistance/details" var="DetailsURL" />
 
<portlet:actionURL name="/assistance/sendMail" var="sendMailURL" >
	<portlet:param name="mvcPath" value="/view.jsp" />
</portlet:actionURL>

<div class="wrapper-form-assistance">
	<aui:form action="<%= sendMailURL %>" method="post" name="fm" enctype = "multipart/form-data" data-parsley-validate="true" >
	
	 <div class="ama-row">
		<div class="ama-col-md-12 ama-col-sm-12 ama-col-xs-12">
			<div class="ama-row">
				<div class="ama-col-md-6">
					<label for="argument" class="label-form margin-top"><liferay-ui:message key="service" /> *</label>
					<select  class="option-select" name="<portlet:namespace />service" id="<portlet:namespace/>service" data-parsley-required="true" 
						data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
						onChange="loadSelect('service','area')"> 
					</select>
				</div>
				<div class="ama-col-md-6">
					<label for="argument" class="label-form margin-top"><liferay-ui:message key="area" /> *</label>
					
					<select  class="option-select" name="<portlet:namespace />area" id="<portlet:namespace/>area" data-parsley-required="true"
						data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
						onchange="loadSelect('area','topic')"> 	
					</select>
				</div>
			
				<div class="ama-col-md-6">
					<label for="argument" class="label-form margin-top"><liferay-ui:message key="topic" /> *</label>
					
					<select  class="option-select"  name="<portlet:namespace />topic" id="<portlet:namespace/>topic" data-parsley-required="true"
						data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
						onchange="loadSelect('topic','problem')"> 	
					</select>
				</div>
				<div class="ama-col-md-6">
					<label for="argument" class="label-form margin-top"><liferay-ui:message key="problem" /> *</label>
					
					<select  class="option-select" name="<portlet:namespace />problem" id="<portlet:namespace/>problem" data-parsley-required="true"
						data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
						onchange="loadFaq('problem')"> 
					</select>
				</div>
			
				<div class="mr-15-sm ml-15-sm no-padding">
					<div class="ama-col-md-12 content-box-collapse border mt-45-xs mb-70-xs hide" id="<portlet:namespace/>faqAssistenzaContainer2">
						<div class="ama-row">
							<div id="<portlet:namespace/>faqAssistenzaContainer" class="hide">
								<div class="title-box">
									<a href="javascript:void(0)" class="toggle-collapse" data-toggle="collapse" data-target="#faqAssistenza">
										<span class="title-box-icon icomoon-discuss-issue"></span>
										<span class="title-box-title">CONSULTA LE FAQ</span>
										<div class="container-vedi-dark">
											<span class="icomoon-vedi-dark icon-vedi"></span>
										</div>
									</a>
								</div>
								
								<div id="faqAssistenza" class="collapse in">
								
								</div>
							</div>
						</div>
					</div>
				</div>
			
				<div class="ama-col-md-12 ama-col-xs-12">
					<div class="wrapper-content-textarea">
						<label class="label-form margin-top" for="textarea-detail"><liferay-ui:message key="description-intranet" /> *</label>
						 <textarea data-parsley-required="true" data-parsley-maxlength="500"
							data-parsley-minlength="10" data-parsley-minlength-message="<liferay-ui:message key="error-minlength-message"/>"
							data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
							data-parsley-maxlenght-message="<liferay-ui:message key="error-maxlenght-message"/>"
							data-parsley-validation-threshold="10"
							name="<portlet:namespace/>description"
							class="form-control textarea-custom-light data-parsley-validated" 
							id="<portlet:namespace/>description"
							placeholder="Aggiungi la descrizione"></textarea>
						<div class="content-textarea" >
								0/
							<p class="color-gray">500</p>
						</div>
					</div>
					
				</div>
			</div>
		
		<div class="wrapper-allegati-general">
			<div class="ama-row">
				<div class="ama-col-md-12">
					<div class="wrapper-title-general">
						<h2 class="title-box borders"><liferay-ui:message key="assistence-container-attachment" /></h2>
						<a href="#" title="<liferay-ui:message key="tooltip-attachment" />" class="tooltip-field">
							<span class="icomoon-info ico-attachments"></span>
						</a>
					</div>
				</div>
			</div>
			
			<div class="ama-row" style="display:none" id="<portlet:namespace/>fileAttachDiv">
				<div class="ama-col-md-12 mobile-no-padding">					
					<div class="wrapper-content">
						<div class="wrapper-white">
							<p class="text" id="<portlet:namespace/>nomeFile">
								
							</p>
						</div>
					</div>
				</div>
			</div>

			
			<div class="ama-row" id="<portlet:namespace/>selectFile">
				<div class="ama-col-md-12 mobile-no-padding">
					<div class="box-button">
						<aui:input 
							id="fileAttachmentName" name="fileAttachmentName" type="hidden" />

						<input data-parsley-filemaxmegabytes="1" data-parsley-trigger ="change" 
								data-parsley-required-message="<liferay-ui:message key='error-mandatory-file'/>"
								type="file" id ="<portlet:namespace/>attachmentName" name="attachmentName"  accept=".*" 
								class="attachFileCustom hide" />   

 		
						<button href="#" type="button" id="<portlet:namespace/>addAttachFile" class="button button-primary">
							<liferay-ui:message key="selezione-file"/></button>
					</div>
				</div>
			</div>
					
			 
		

			<div class="hide">
				<select name="ambito" id='<portlet:namespace />ambito' > 	
						<aui:option value='<%=ambitoSelected %>' selected="selected"><%=ambitoSelected %></aui:option>
				</select>
			</div>
			
			<div class="container-button-general-allegati">
				<div class="ama-row">
					<div class="ama-col-sm-12">
						<aui:button cssClass="button button-primary margin-top" id='btnContinue'
							onClick="validateForm()"  value="btn-preview" />
					</div>
				</div>
			</div>
		</div>
	
	</aui:form>
	</div>
	</div>
</div>
