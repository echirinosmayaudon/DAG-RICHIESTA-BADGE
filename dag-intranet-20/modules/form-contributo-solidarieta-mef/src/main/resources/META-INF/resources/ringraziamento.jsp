<%@ include file="/init.jsp" %>
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

<div class="ama-container-fluid">
<div class="ama-row">
        <div class="ama-col-md-12">
            <div class="wrapper-title-small">
                <h2 class="title-box borders"><liferay-ui:message key="contributo-ringraziamento-titolo"/></h2>
                <div class="testo">
                <div class="wysiwyg-editor ">
            	<p><liferay-ui:message key="contributo-ringraziamento-testo1"/> <b>${donatore.importo}</b> <liferay-ui:message key="contributo-ringraziamento-testo2"/> </p>
            	<p><liferay-ui:message key="contributo-ringraziamento-testo3"/> </p>
            	<p><liferay-ui:message key="contributo-ringraziamento-testo4"/></p>
            	
            	</div>
            	</div>
            </div>
        </div>
    </div>
 </div>
<style>
.testo{

    padding-top: 15px;
  

}

</style>