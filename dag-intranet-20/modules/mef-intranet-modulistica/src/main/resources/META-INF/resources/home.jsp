
<%
	List<DLFileEntry> list = (ArrayList<DLFileEntry>) renderRequest.getAttribute("topDocuments");
	if (itemsPerPage.isEmpty())
		itemsPerPage="10";
if (Integer.valueOf(itemsPerPage) > 0 && list.size() > Integer.valueOf(itemsPerPage)) {
		list = list.subList(0, Integer.valueOf(itemsPerPage));

	}
%>
<div class="bg-image-moduls">
    <div class="ama-container-fluid">
        <div class="ama-row">
            <div class="ama-col-md-12">
                <div class="wrapper-title-white title-with-arrow">
                    <h2 class="title-box-white borders-white"><liferay-ui:message key="modulistica-piu-richiesti"/></h2>
                    <a href="${modulisticaPage}" class="icomoon-vai"></a>
                </div>
            </div>
        </div>
    </div>
	<c:set value="<%=list%>" var="myList"></c:set>
	<%@ include file="/documents.jsp"%>
</div> 