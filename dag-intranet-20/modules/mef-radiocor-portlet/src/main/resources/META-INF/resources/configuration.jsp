<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL"/>

<liferay-portlet:renderURL portletConfiguration="<%= true %>" var="configurationRenderURL"/>

<aui:form action="<%= configurationActionURL %>" method="post" name="fm"
          onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveConfiguration();" %>'>
    <aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>"/>
    <aui:input name="redirect" type="hidden" value="<%= configurationRenderURL %>"/>

    <div class="portlet-configuration-body-content">
        <div class="container-fluid-1280">

            <aui:fieldset-group markupView="lexicon">
                <aui:fieldset collapsible="<%= true %>" label="Header">
                    <div class="row">
                        <div class="col-md-4 col-xs-12">
                            <aui:input name="preferences--title--" type="text" value="<%= title%>"/>
                        </div>
                    </div>
                </aui:fieldset>
            </aui:fieldset-group>

            <aui:fieldset-group markupView="lexicon">
                <aui:fieldset collapsible="<%= true %>" label="options">
                    <aui:input name="preferences--numNewsForPage--" type="text" value="<%= numNewsForPage%>">
                        <aui:validator name="digits"></aui:validator>
                        <aui:validator name="min">0</aui:validator>
                    </aui:input>
                </aui:fieldset>
            </aui:fieldset-group>

        </div>
    </div>

    <aui:button-row>
        <aui:button cssClass="btn-lg" type="submit"/>
    </aui:button-row>
</aui:form>

<aui:script>
    function <portlet:namespace/>saveConfiguration() {
    var Util = Liferay.Util;

    var form = AUI.$(document.<portlet:namespace/>fm);

    submitForm(form);
    }
</aui:script>


