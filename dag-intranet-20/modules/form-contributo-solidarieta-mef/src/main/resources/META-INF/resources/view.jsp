<%@ include file="/init.jsp" %>
<liferay-ui:error key="mef.no.param" message="mef.no.param" />
 <liferay-ui:error key="mef.ko" message="mef.ko" />
<portlet:actionURL name="donate" var="donateURL" >
</portlet:actionURL>

<!-- 	HEADER -->
    <div class="trasporti-header">
    <div class="ama-container-fluid">
        <div class="ama-row">
            <div class="ama-col-xs-12">
                <div class="title-wrapper">
                     <h2 class="title"><liferay-ui:message key="contributo-header-titolo"/></h2>
                     <p class="subtitle dot-point dot-200"><liferay-ui:message key="contributo-header-sottotitolo"/></p>
                     
	          	</div>
            </div>
        </div>
    </div>
</div>
<!-- 	TESTO-FORM -->
<div class="ama-container-fluid">
<div class="testo-form">
<div class="wysiwyg-editor ">
<p><liferay-ui:message key="contributo-testo-form1"/></p>
<p><liferay-ui:message key="contributo-testo-form2"/></p>


</div>
</div>
 <!-- DATI RICHIEDENTE LABEL -->	
    <div class="ama-row">
        <div class="ama-col-md-12">
            <div class="wrapper-title-small">
                <h2 class="title-box borders"><liferay-ui:message key="contributo-dati-richiedente"/></h2>
            </div>
        </div>
    </div>
    
    <!-- DATI RICHIEDENTE -->
<div class="ama-container-fluid">
    
    <div class="ama-row">
        <div class="ama-col-xs-12">
            <div class="wrapper-badge-visitatore">
                <div class="box-gray no-margin">
                    <div class="box-white box-gray-mobile">
                        <div class="ama-row">
                        
                        <aui:form action="${donateURL}" method="post">
                        
                          <aui:fieldset>
                            <div class="ama-col-xs-12">
                                
                              	   <div class="ama-col-xs-12 ama-col-md-6 mb-25-xs">
                                            <label class="label-form"><liferay-ui:message key="contributo-form-nome"/></label>
                                       		
                                       		<input class="input-custom-light data-parsley-validated" name="" type="text" 
                                       			data-parsley-required="true" 
                                       			value="${utente.firstName }" readonly="true"></input>
                                        </div>
                                        
                                   <div class="ama-col-xs-12 ama-col-md-6 mb-25-xs">
                                            <label class="label-form"><liferay-ui:message key="contributo-form-cognome"/></label>
                                       		<input class="input-custom-light data-parsley-validated" name="" type="text" 
                                       			data-parsley-required="true" 
                                       			value="${utente.lastName }" readonly="true"></input>
                                        </div>
                                   <div class="ama-col-xs-12 ama-col-md-6 mb-25-xs">
                                            
                                            <label class="label-form"><liferay-ui:message key="contributo-form-email"/></label>
                                       		<input class="input-custom-light data-parsley-validated" name="" type="text" 
                                       			data-parsley-required="true" 
                                       			value="${utente.emailAddress }" readonly="true"></input>
                                        </div>
                                   <div class="ama-col-xs-12 ama-col-md-6 mb-25-xs">
                                            <label class="label-form"><liferay-ui:message key="contributo-form-codice-fiscale"/></label>
                                       		<input class="input-custom-light data-parsley-validated" name="" type="text" 
                                       			data-parsley-required="true" 
                                       			value="${fn:toUpperCase(utente.screenName) }" readonly="true"></input>
                                        </div>
                      <!-- 	IMPORTO RADIO -->
                    <div class="radio-importi">
						<div class="box-radio-custom">
						<input id="<portlet:namespace/>oggetto-importo-radio10" class="radio-custom-dark changeRadio" type="radio" 
	                    	   value="10" name="<portlet:namespace/>importoContributo">
	                	<label class="radio-custom-desc" for="<portlet:namespace/>oggetto-importo-radio10">
							<span>10 &euro;</span>
						</label>
						</div>
						<div class="box-radio-custom">
							<input id="<portlet:namespace/>oggetto-importo-radio20" class="radio-custom-dark changeRadio" type="radio" 
	                    	   value="20" name="<portlet:namespace/>importoContributo">
	                	<label class="radio-custom-desc" for="<portlet:namespace/>oggetto-importo-radio20">
							<span>20 &euro;</span>
						</label>
						</div>
						<div class="box-radio-custom">
							<input id="<portlet:namespace/>oggetto-importo-radio50" class="radio-custom-dark changeRadio" type="radio" 
	                    	   value="50" name="<portlet:namespace/>importoContributo">
	                	<label class="radio-custom-desc" for="<portlet:namespace/>oggetto-importo-radio50">
							<span>50 &euro;</span>
						</label>
						</div>
						<div class="box-radio-custom">
							<input id="<portlet:namespace/>oggetto-importo-radio100" class="radio-custom-dark changeRadio" type="radio" 
	                    	   value="100" name="<portlet:namespace/>importoContributo">
	                	<label class="radio-custom-desc" for="<portlet:namespace/>oggetto-importo-radio100">
							<span>100 &euro;</span>
						</label>
						</div>
						<!--                         ALTRO IMPORTO -->
                        <div class="inserisci-importo">
                        <aui:input cssClass="form-altro-importo" id="inputAltroImporto" class="inputAltroImporto" type="number" 
                               name="altroImporto" label="Inserisci un importo">
                               <aui:validator  name="range" errorMessage="L'importo deve essere compreso tra 1 e 1000 euro">[1,1000]</aui:validator>
                               <aui:validator name="number" errorMessage="Inserire solo numeri" />
                               </aui:input>
                            </div>

						</div>
						</div>
						</aui:fieldset>
						<!-- 		BOTTONE SUBMIT -->
							<div class="ama-row">
								<div class="ama-col-xs-12 text-center mb-20-xs mb-100-sm mt-20-xs mt-50-sm">
											<button class="button button-primary"
												id="<portlet:namespace/>conferma">
												<liferay-ui:message key="contributo-bottone-conferma" />
											</button>
										</div>
									</div>

								</aui:form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</div>
</div>



<style>
.testo-form{
padding-top:15px;
}
.wrapper-title-smal{
	padding-top:40px!important;
}
.control-label{
    display: block;
    font-weight: 400;
    font-size: 14px;
    line-height: 1.29;
    color: #003896;
}
}
.radio-importi{
	padding-left: 15px;
}
.inserisci-importo{
	
    padding-left: 15px;
    margin-top: 25px!important;

}
.box-radio-custom{
	margin-left: 20px!important;
}
.form-altro-importo{

    width: 48%!important;

}

</style>
<script>
$('#<portlet:namespace/>inputAltroImporto').on("click", function(){
    
    $('#<portlet:namespace/>oggetto-importo-radio10').prop('checked', false);
    $('#<portlet:namespace/>oggetto-importo-radio20').prop('checked', false);
    $('#<portlet:namespace/>oggetto-importo-radio50').prop('checked', false);
    $('#<portlet:namespace/>oggetto-importo-radio100').prop('checked', false);

    
});
$('.changeRadio').on("click",function(){
    $(".changeRadio").each(function(){
        $('#<portlet:namespace/>inputAltroImporto').val(null);
    });
});
</script>