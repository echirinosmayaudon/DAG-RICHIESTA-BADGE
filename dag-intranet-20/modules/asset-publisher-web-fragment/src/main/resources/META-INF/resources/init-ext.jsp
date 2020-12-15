<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="com.liferay.asset.kernel.service.persistence.AssetEntryQuery" %>

<%
	String keywords = ParamUtil.getString(request, "keywords", null);
	long[] categories = ParamUtil.getLongValues(request, "categories", null);
	AssetEntryQuery assetEntryQuery = assetPublisherDisplayContext.getAssetEntryQuery();
	assetEntryQuery.setKeywords(keywords);
	if (categories != null) {
		String op = PropsUtil.get("asset.publisher.categories.filter.operator");
		if("AND".equalsIgnoreCase(op)){
			assetEntryQuery.setAllCategoryIds(categories);
		} else {
			assetEntryQuery.setAnyCategoryIds(categories);
		}
	}
%>