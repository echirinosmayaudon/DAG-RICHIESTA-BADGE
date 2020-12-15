<%--
/**
 * Unpublished Copyright SMC TREVISO SRL. All rights reserved.
 *
 * The contents of this file are subject to the terms of the SMC TREVISO's
 * "CONDIZIONI GENERALI DI LICENZA D'USO DI SOFTWARE APPLICATIVO STANDARD SMC"
 * ("License"). You may not use this file except in compliance with the License.
 * You can obtain a copy of the License by contacting SMC TREVISO. See the
 * License for the limitations under the License, including but not limited to
 * distribution rights of the Software. You may not - for example - copy,
 * modify, transfer, transmit or distribute the whole file or portion of it, or
 * derived works, to a third party, except as may be permitted by SMC in a
 * written agreement.
 * To the maximum extent permitted by applicable law, this file is provided
 * "as is" without warranty of any kind, either expressed or implied, including
 * but not limited to, the implied warranty of merchantability, non infringement
 * and fitness for a particular purpose. SMC does not guarantee that the use of
 * the file will not be interrupted or error free.
 */
--%>
  

<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ include file="/init.jsp" %>
 

<div class="ama-row">
	<div class="ama-col-md-6"> 
		<h5 class="title-information"><liferay-ui:message key="service" />:</h5>
		<p class="text-information" id="<portlet:namespace/>serviceDesc"> </p>
	</div>
	
	<div class="ama-col-md-6"> 
		<h5 class="title-information"><liferay-ui:message key="area" />:</h5>
		<p class="text-information" id="<portlet:namespace/>areaDesc"> </p>
	</div>

	<div class="ama-col-md-6"> 
		<h5 class="title-information"><liferay-ui:message key="topic" />:</h5>
		<p class="text-information" id="<portlet:namespace/>topicDesc"> </p>
	</div>
	<div class="ama-col-md-6"> 
		<h5 class="title-information"><liferay-ui:message key="problem" />:</h5>
		<p class="text-information" id="<portlet:namespace/>problemDesc"> </p>
	</div>
	

	<div class="ama-col-md-6"> 
		<h5 class="title-information"><liferay-ui:message key="description-intranet" />:</h5>
		<p class="text-information" id="<portlet:namespace/>descriptionDetail"> </p>
	</div>

</div>

<div class="wrapper-allegati-general">
	<div class="ama-row">
 		<div class="ama-col-md-12">
			<div class="wrapper-title-general">
				<h2 class="title-box borders">ALLEGATI</h2>
			</div>
		</div>
	</div>
	<div class="ama-row">
		<div class="ama-col-md-12 mobile-no-padding">
			<div class="wrapper-content">
				<div class="wrapper-white">
					<p class="text" id="<portlet:namespace/>fileNameAttachment"></p>
				</div>
			</div>
		</div>
	</div>
	
	<div class="container-button-allegati">
		<div class="ama-row">
			<div class="ama-col-sm-6">
				<aui:button cssClass="button button-primary"
					onClick='<%= renderResponse.getNamespace() + "backTo();" %>' value="btn-modify" />
				
			</div>
			<div class="ama-col-sm-6">
				<aui:button id="btnInvia" cssClass="button button-primary"
					onClick='<%= renderResponse.getNamespace() + "sendMail();" %>' value="btn-continue" />
			</div>
		</div>
	</div>
</div>




<script use="aui-base">
 
 function <portlet:namespace/>sendMail(){
	var A =AUI();
	var btnInvia = A.one("#<portlet:namespace/>btnInvia");
	btnInvia.set('disabled', true);
	var myForm = A.one("#<portlet:namespace/>fm");
	myForm.submit();
 }
 

 function <portlet:namespace/>backTo(){
	var A =AUI();
	var divForm=A.one("#<portlet:namespace/>assistanceForm");
	var divDetail=A.one("#<portlet:namespace/>assistanceDetail");
	divForm.show();
	divDetail.hide();
 }
 </script>