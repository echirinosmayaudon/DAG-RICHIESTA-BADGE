<%@ include file="./init.jsp" %>

<% 
Layout actualPage = LayoutLocalServiceUtil.getLayout(themeDisplay.getPlid());
Layout parentPage = actualPage;
if(actualPage.getParentPlid() >0){
	parentPage = LayoutLocalServiceUtil.getLayout(actualPage.getParentPlid());
}
List<Layout> childsActualPage = actualPage.getChildren(themeDisplay.getPermissionChecker());
List<Layout> childsParentPage = parentPage.getChildren(themeDisplay.getPermissionChecker());
Layout parentLink = null;
List<Layout> childsLink = null;
String classFirstLink = "padding-top";
String classLiDefault = "list-navigation";
String classLiFatherSecondLevel = "section-step-three";
String classLiActive = "bg-active";
String classLi = "";
String classA = "";
String classPt0Xs = "";
boolean hasFather = false;
%>
<div class="wrapper-navigation">
                <div class="ama-row">
                    <div class="ama-col-md-12">
<%
if(actualPage.hasChildren()){
	//second level with child
	//actual
		//childsActualPage
	parentLink = actualPage;
	childsLink = childsActualPage;
}else if(parentPage.isFirstParent()){
	//second level without child
	//childsParentPage
	parentLink = null;
	childsLink = childsParentPage;
}else{
	//third level
	//parentPage
		//childsParentPage
	parentLink = parentPage;
	childsLink = childsParentPage;
}
classPt0Xs = (parentLink != null && !parentLink.isRootLayout()) ? "pt-0-md" : "";
%>
					<ul class="bg-navigation <%=classPt0Xs%>">
<%
if(parentLink != null && !parentLink.isRootLayout() && !parentLink.isHidden()){
	hasFather = true;
	classLi = parentLink.isSelected(true, actualPage, actualPage.getPlid()) ? classLiActive : classLiDefault+" "+classLiFatherSecondLevel;
%>						
						<li class="<%=classLi%>">
							<a class="padding-a " href="/group<%=themeDisplay.getSiteGroup().getFriendlyURL()%><%=parentLink.getFriendlyURL(themeDisplay.getLocale())%>"  title="<%=parentLink.getName(themeDisplay.getLocale()).toUpperCase()%>">
								<%=parentLink.getName(themeDisplay.getLocale()).toUpperCase()%>
							</a>
						</li>
<%}
for(Layout currentChils : childsLink){
	classLi = currentChils.isSelected(true, actualPage, actualPage.getPlid()) ? classLiActive : classLiDefault;
	classA = currentChils.isFirstChild() && !hasFather ? classFirstLink : "";
	if(!currentChils.isHidden()){
%>	
						<li class="<%=classLi%>">
							<a class="padding-a <%=classA%>" href="/group<%=themeDisplay.getSiteGroup().getFriendlyURL()%><%=currentChils.getFriendlyURL(themeDisplay.getLocale())%>" title="<%=currentChils.getName(themeDisplay.getLocale())%>">
								<%=currentChils.getName(themeDisplay.getLocale())%>
							</a>
						</li>
<%} 
}%>
<li class="btn-box-navigation-collapse"><button class="icomoon-chiudi-dark"></button></li> 
					</ul>
				  </div>
                </div>
            </div>