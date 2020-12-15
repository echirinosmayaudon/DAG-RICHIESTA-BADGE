<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@ page contentType="text/html; charset=UTF-8"%>



<%@ page import="java.util.*"%>
<%@ include file="./init.jsp"%>

<%
	JsonTweet jsonTweet = (JsonTweet) renderRequest.getAttribute("jsonTweet");
	JSONArray jsonArray = jsonTweet.getJsonArray();
	Map<String, Object> contextObjects = new HashMap<>();
	contextObjects.put("jsonTweet", jsonTweet);
	contextObjects.put("TweetPortletInstanceConfiguration", tweetPortletInstanceConfiguration);
	
	Log _log = LogFactoryUtil.getLog("view_jsp");
%>

<div class="ama-container-fluid">
    <div class="ama-row">
        <div class="ama-col-md-12">
            <div class="wrapper-title-tweet">
                <h2 class="title-box borders"><%=tweetPortletInstanceConfiguration.title()%></h2>
            </div>
        </div>
    </div>
</div>
<div class="ama-container-fluid wrapper-tweet">
    <div class="ama-row carousel-tweet" data-max="<%=tweetPortletInstanceConfiguration.numTweetForSlide()%>">
    <%
       if(jsonArray != null){
        int lengthJsonArray = jsonArray.length() > tweetPortletInstanceConfiguration.numTweetForSlide() ? tweetPortletInstanceConfiguration.numTweetForSlide() : jsonArray.length();
           for(int i=0; i<lengthJsonArray; i++){
               JSONObject tweet = jsonArray.getJSONObject(i);
               String dataTweet = tweet.getString("created_at");
               String name = tweet.getJSONObject("user").getString("name");
              
               String testo = "";
             
 			if(tweet.getString("full_text")!= null && !tweet.getString("full_text").equalsIgnoreCase("") ){
 				
 				testo = tweet.getString("full_text");
 	          }
 			else{
 				
 				testo = tweet.getString("text");
 			}
 			
               
               String nameRetweet = "";
               String labelRetweet = "";
               JSONObject entities = tweet.getJSONObject("entities");
               JSONArray hashtags = entities.getJSONArray("hashtags");
               JSONArray urls = entities.getJSONArray("urls");
               String id = tweet.getString("id_str");
               JSONObject retweeted_status = tweet.getJSONObject("retweeted_status");

               if(retweeted_status != null){
                   labelRetweet = "ha ritwittato";
                   dataTweet = retweeted_status.getString("created_at");
                   nameRetweet = retweeted_status.getJSONObject("user").getString("screen_name");
                
                   if(tweet.getString("full_text")!= null && !tweet.getString("full_text").equalsIgnoreCase("") ){
        				
        				testo = tweet.getString("full_text");
        	          }
        			else{
        				
        				testo = tweet.getString("text");
        			}
                  
                   hashtags = retweeted_status.getJSONObject("entities").getJSONArray("hashtags");
                   urls = retweeted_status.getJSONObject("entities").getJSONArray("urls");
               }
                for(int j=0; j<hashtags.length(); j++){
                    JSONObject hashtag = hashtags.getJSONObject(j);
                    String text = hashtag.getString("text");
                    testo = testo.replace("#" + text, "<span class=\"p-color\">" + "#" + text + "</span>");
                }
                for(int k=0; k<urls.length(); k++){
                    JSONObject url = urls.getJSONObject(k);
                    String urlString = url.getString("url");
                    testo = testo.replace(urlString, "<a href=\"" + urlString + "\" target=\"_blank\" class=\"p-color\">" + url.getString("display_url") + "</a>");
                }
                String dataTweetText = JsonTweet.parseTwitterDate(dataTweet);

               %>
                <div class="ama-col-md-4">
                <div class="box-body">
                <div class="title">
                <div class="icomoon-social-twitter"></div>
                <div class="body-twitter-box">
                <p><span class="p-color mr-5-xs"><%= name %></span><%= labelRetweet %></p>
                <p><span class="p-color mr-5-xs"><%= nameRetweet %></span><%= !nameRetweet.equals("") ? "- " : ""%><%=dataTweetText%></p>
                </div>
                </div>
                <div class="body dot-point dot-80 dot-mobile">
                <%=testo%>
                </div>
                <div class="ama-row">
                <div class="ama-col-md-6 ama-col-xs-6">
                <a href="https://twitter.com/intent/tweet?in_reply_to=<%=id%>" target="_blank"  title="commenta" class="icomoon-comment">
                <span class="sr-only">Commenta</span>
                </a>
                </div>
                <div class="ama-col-md-6 ama-col-xs-6">
                <a href="https://twitter.com/intent/retweet?tweet_id=<%=id%>" target="_blank" title="retweet" class="icomoon-retweet">
                <span class="sr-only">retweet</span>
                </a>
                </div>
                </div>
                </div>
                </div>
             <%}
        }
    %>
    </div>
</div>

