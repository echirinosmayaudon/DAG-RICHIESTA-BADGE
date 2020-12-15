String content = StringPool.BLANK;
try{
  String articleName = "[NOME DEL WEB CONTENT]";
  ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
  JournalArticle journalArticle = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), articleName);
  String articleId = journalArticle.getArticleId();
  JournalArticleDisplay articleDisplay = JournalContentUtil.getDisplay (themeDisplay.getScopeGroupId(), articleId,"","",themeDisplay);
  content = articleDisplay.getContent();
}catch(Exception e){ content = PropsUtil.get("no.article.text"); } %>

<%= content %>
