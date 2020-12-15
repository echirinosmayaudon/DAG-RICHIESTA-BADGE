<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="./init.jsp" %>

<%@taglib uri="http://liferay.com/tld/aui" prefix="aui" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>

<%
JSONArray newsJsonArray = (JSONArray)request.getAttribute("news");
%>		
		<div class="wrapper-title-white">
        	<h2 class="title-box-white borders-white"><%=title %></h2>
        </div>
        <div class="wrapper-radiocor-box carousel-radiocor">
        	<%
        	if(newsJsonArray != null){
        		for(int i = 0; i < newsJsonArray.length(); i++){
        	      	JSONObject objects = newsJsonArray.getJSONObject(i);
        	      	String time = objects.getString("dateTime");
        	      	String subtitle = objects.getString("topic");
        	      	String description = objects.getString("headline");
        	%>
        	<div class="carousel-radiocor-item">
        		<span class="icomoon-time"></span>
        		<span class="radiocor-time typo-h4"><%=time %></span>
        		<h4 class="typo-box-subtitle dot-point dot-75 dot-mobile"><%=subtitle%></h3>
        		<p class="radiocor-description dot-point dot-60 dot-mobile"><%=description%></p>
        	</div>
        	<%	} 
        	 } 
        	%>
        </div>
