<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm" %>


<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="it.accenture.twitter.configuration.TweetPortletInstanceConfiguration" %>
<%@ page import="it.accenture.twitter.model.JsonTweet" %>
<%@ page import="com.liferay.portal.kernel.json.JSONArray" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>


<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
    TweetPortletInstanceConfiguration tweetPortletInstanceConfiguration = portletDisplay.getPortletInstanceConfiguration(TweetPortletInstanceConfiguration.class);

    String title = StringPool.BLANK;
    
    int numTweetForSlide = 9;

   
    if (Validator.isNotNull(tweetPortletInstanceConfiguration)) {


        title = tweetPortletInstanceConfiguration.title();

        numTweetForSlide = tweetPortletInstanceConfiguration.numTweetForSlide();

    }

%>