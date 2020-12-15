<%@ include file="/init.jsp" %>
<portlet:renderURL var="viewUrl">
	<portlet:param name="utente" value="${utente}" />
    <portlet:param name="jspPage" value="/view.jsp" />
</portlet:renderURL>
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
<!-- CAMPO TESTO -->
<div class="ama-container-fluid">
<div class="testo-introduzione">
<div class="d-none d-md-block col-md-4">
<img class="img-testo" src="<%=request.getContextPath()%>/mefdona_interno.png" alt="icona-mef" width="180" style="max-width: 100%; width: 100%;">
</div>
<div class="wysiwyg-editor ">
<p><b><liferay-ui:message key="contributo-testo-introduzione"/></b></p>
<p><liferay-ui:message key="contributo-testo-introduzione1"/></p>
<p><liferay-ui:message key="contributo-testo-introduzione2"/></p>
<br>
<!-- <p><liferay-ui:message key="contributo-testo-introduzione3"/></p> -->
<p><liferay-ui:message key="contributo-testo-introduzione4"/></p>
<p><liferay-ui:message key="contributo-testo-introduzione5"/></p>
<p><liferay-ui:message key="contributo-testo-introduzione6"/></p>
<p><b><liferay-ui:message key="contributo-testo-attenzione"/></b></p> 
<p><liferay-ui:message key="contributo-testo-introduzione7"/></p>
<a class="link-form"  href="${viewUrl }" ><liferay-ui:message key="contributo-testo-introduzione-link"/></a>
</div>
</div>


</div>
<style>

.testo-introduzione{
    padding-top: 15px;
    padding-bottom: 15px;
}
.link-form{
	font-style: italic;
    text-decoration: underline;
    font-weight:600;
    font-size: 22px;
}

</style>