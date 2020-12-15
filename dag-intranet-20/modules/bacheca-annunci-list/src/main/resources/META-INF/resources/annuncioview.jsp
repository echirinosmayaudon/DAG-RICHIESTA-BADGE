<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%> 
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>
<%@page import ="bacheca.annunci.list.utils.AnnunciUtils"%>
<%@page import ="com.liferay.journal.model.JournalArticle" %>
<%@ page import="com.liferay.journal.service.JournalArticleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.journal.exception.NoSuchArticleException"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import ="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@page import ="java.text.SimpleDateFormat"%>
<%@page import ="java.util.Date"%>


<portlet:defineObjects />
<%

//String zonaparam =ParamUtil.getString(request, "zonaparam");
Long annuncioId=ParamUtil.getLong(request, "annuncioId");
String itemSelectorURL = GetterUtil.getString(request.getAttribute("itemSelectorURL"));
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

AnnunciUtils util =new AnnunciUtils();

String titolo=new String();
String username=new String();
String type=new String();
String typevalue=new String();
String email=new String();
String topic=new String();
String body=new String();
String phoneNumber=new String();
String photo1=new String();
String photo2=new String();
String photo3=new String();
String photo4=new String();
String startDatestr=new String();
String deadlinestr=new String();
String imgowner=new String();
String zonastr= new String();
long userId=user.getUserId();
long userIdFromjournal=1L;
boolean nojournalFind=false;


                JournalArticle article =JournalArticleLocalServiceUtil.getArticle(annuncioId);
                //non è nel cestino
                if(article.getStatus()!=8){
                               String content = article.getContent();
                                               
                               userIdFromjournal = article.getUserId();
                
                               User owner= UserLocalServiceUtil.getUser(userIdFromjournal);
                               imgowner=owner.getPortraitURL(themeDisplay);
                               
                               // owner // getPortraitURL(themeDisplay);
                                 
                                 
                                username =  owner.getFirstName() + " " + owner.getLastName(); // util.getValueFromStructure(content,"User");
                               
                                titolo = util.getValueFromStructure(content,"Title");
                               //tipologia offresi....
                               type = util.getValueFromStructure(content,"Type");
                
                               email = util.getValueFromStructure(content,"Email");
                               //categoria
                               topic = util.getValueFromStructure(content,"Topic");
                
                               body = util.getValueFromStructure(content,"Body");    
                
                               phoneNumber = util.getValueFromStructure(content,"PhoneNumber");
                               //image url
                               photo1 = util.getValueFromStructure(content,"Photo1");                           
                               photo2 = util.getValueFromStructure(content,"Photo2");
                               photo3 = util.getValueFromStructure(content,"Photo3");
                               photo4 = util.getValueFromStructure(content,"Photo4");
                               startDatestr = util.getValueFromStructure(content,"StartDate");
                                               
                               deadlinestr = util.getValueFromStructure(content,"Deadline");
                               
                                zonastr = util.getValueFromStructure(content,"Zona");
                               
                                if(type.contains("cercasi"))
                                               typevalue="RICHIESTA";
                               if(type.contains("offresi"))
                                               typevalue="OFFERTA";
                               
                }else{
                               nojournalFind=true;
                }







//ricavo i ruoli utente
List<Role> listaRuoli=user.getRoles();
boolean moderatore= false;
for(Role ruolo: listaRuoli){
if(ruolo.getName().equalsIgnoreCase("Moderatore annunci")){
                moderatore=true;
                break;
}
}

String dialog="/dialog.jsp";
if(moderatore)
                dialog="/dialogmoderatore.jsp";             


%>



<portlet:renderURL var="goBackURL">
                                               <portlet:param name="redirect" value="/view.jsp" />
                                               <portlet:param name="added" value="false" />
</portlet:renderURL>


<c:set value="<%=nojournalFind%>" var="nojournalFind"></c:set>

<c:if test="${nojournalFind == true}">

<p>        <liferay-ui:message key="not-found-annuncio" /></p>

</c:if>

<c:if test="${nojournalFind == false}"> 
 
<c:set value="<%=moderatore%>" var="moderatore"></c:set>
<c:set value="<%=userId%>" var="userlogged"></c:set>
<c:set value="<%=userIdFromjournal%>" var="userfromjournal"></c:set>
<c:set value="<%=annuncioId%>" var="annuncioId"></c:set>



<portlet:renderURL var="dialogview"
windowState="<%=LiferayWindowState.POP_UP.toString()%>">
<portlet:param name="mvcPath" value="<%=dialog%>"/>
<portlet:param name="annuncioId" value="${annuncioId}" />
<portlet:param name="userId" value="${userlogged}" />
<portlet:param name="email" value="<%=email%>" />
</portlet:renderURL>



<portlet:actionURL name="dialogviewupdate" var="dialogviewupdate"></portlet:actionURL>


<div class="bacheca-annunci-dettaglio">
            <div class="bacheca-annunci-dettaglio-wrapper">
				<div class="ama-row">
                        <div class="ama-col-xs-12">

                <div class="title-wrapper mb-50-xs">
                    <h2 class="title"><%=topic.toUpperCase()%></h2>
                       
             <c:if test="${moderatore == true && userlogged == userfromjournal}"> 
			  <a title="Cancella annuncio" class="icomoon-delete"   data-toggle="modal" data-target="#modal-delete-notice" >
                            <span class="sr-only"><liferay-ui:message key="delete-annuncio" /></span>
				</a>
			 <a title="Modifica annuncio" class="icomoon-edit-border" href="javascript:goToDialogUpdateJsp()">
                            <span class="sr-only"><liferay-ui:message key="modify-annuncio" /></span>
                        </a>
                                   
                               
		</c:if>
	   
		 <c:if test="${moderatore == true && userlogged != userfromjournal}">                
			  <a title="Cancella annuncio" class="icomoon-delete"   data-toggle="modal" data-target="#modal-delete-notice" >
                            <span class="sr-only"><liferay-ui:message key="delete-annuncio" /></span>
				</a>		 </c:if>
		 
		  <c:if test="${moderatore == false && userlogged == userfromjournal}">                
																	 
			  <a title="Cancella annuncio" class="icomoon-delete"   data-toggle="modal" data-target="#modal-delete-notice" >
                            <span class="sr-only"><liferay-ui:message key="delete-annuncio" /></span>
				</a>
			 <a title="Modifica annuncio" class="icomoon-edit-border" href="javascript:goToDialogUpdateJsp()">
                            <span class="sr-only"><liferay-ui:message key="modify-annuncio" /></span>
                        </a>
                            
					   
		 </c:if>
		 </div>
</div>
                </div>
				<div class="ama-row">
                            <div class="ama-col-xs-12">
							    <div class="wrap-content-title-bacheca">

								   <div class="container-offerte-title">
										<span class="offer-title"><%=typevalue%></span>
									 </div>
									 
									<div class="container-location">
										<div class="location mr-10-sm">
										<span class="icomoon-calendar-date location-icon pr-5-xs"></span>
		                                <%Date startDatedt=sdf.parse(startDatestr);
		                                  Date deadlinedt=sdf.parse(deadlinestr);
		                                %>
										<fmt:formatDate pattern ="dd/MM/yyyy"  value ="<%=startDatedt%>"/>
										</div>
										<div class="location color-violet mr-10-sm">
										<span class="icomoon-calendar-scadenza location-icon icomoon-color-violet pr-5-xs"></span>
										
										<fmt:formatDate pattern ="dd/MM/yyyy"  value ="<%=deadlinedt%>"/>
										</div>
										<c:if test="<%=zonastr!=null && !zonastr.equalsIgnoreCase("")%>">
										<div class="city"><%=zonastr.toUpperCase()%><span class="icomoon-pin city-icon"></span></div>
									</c:if>
									</div>
								</div>
						   </div>
                        </div>
				
				
                <div class="ama-row annunci-dettaglio-content">
                    <div class="ama-col-xs-12 ama-col-sm-5">
                    
                       <!-- slider foto -->
                       <div class="bacheca-annunci-dettaglio-slider">
                        <c:if test="<%=!photo1.isEmpty()%>">
									  <div class="img-wrapper"><img alt="photo1" src="<%=photo1%>" class="item-slider"></div>
					  </c:if>  
					  <c:if test="<%=!photo2.isEmpty()%>">
									  <div class="img-wrapper"><img alt="photo2" src="<%=photo2%>" class="item-slider"></div>
					  </c:if>  
					  <c:if test="<%=!photo3.isEmpty()%>">
									  <div class="img-wrapper"><img alt="photo3" src="<%=photo3%>" class="item-slider"></div>
					  </c:if>  
					  <c:if test="<%=!photo4.isEmpty()%>">
									  <div class="img-wrapper"><img alt="photo4" src="<%=photo4%>" class="item-slider"></div>
					  </c:if>  
					</div>
                 </div>
                    <div class="ama-col-xs-12 ama-col-sm-7 offer-text-wrapper">
                        
                        <div class="ama-row">
                            <div class="ama-col-xs-12">
                                <p class="offer-text">
                                   <%=body %>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="ama-col-xs-12 no-padding-mobile">
                        <div class="author-banner">
                            <div class="col-sm-6 col-xs-12 left-side">
                                <span class="author-text"><liferay-ui:message key="postato-da" />:</span>
                                <span class="author-avatar" style="background-image:url(<%=imgowner%>)"></span>
                                <span class="author-name"> <%=username %></span>
                            </div>
                            <div class="col-sm-6 col-xs-12 right-side">
                                <div class="phone-box">
                                    <span class="icomoon-phone"></span>
                                    <span class="phone-number"><%=phoneNumber %></span>
                                </div>
                                <div class="contact-wrap">
                                 <c:if test="${userlogged == userfromjournal}"> 
                                    
                                                    <span class="icomoon-send-mail tuo_annuncio"></span>
                                                    <span class="button-label tuo_annuncio">   <%=email %></span>
                                  
                                                                                                          
                                                                                                        </c:if>
                                                                                                                              <c:if test="${userlogged != userfromjournal}"> 
                                                                                                           <a class="contact-button">
                                        <span class="icomoon-send-mail"></span>
                                        <span class="button-label" onclick="location.href='mailto:<%=email%>?subject=<%=body%>';" value="<%= LanguageUtil.get(themeDisplay.getLocale(), "send-email")%>"><liferay-ui:message key="contatta" /></span>
                                    </a>
                                                                                                        </c:if>
								</div>
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>
			
			
                  <div id="modal-delete-notice" class="modal modal-custom fade modal-icon-page" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-body">
                            <div class="modal-title-box">
                                <a href="#" class="icomoon-close-white" data-dismiss="modal"></a>
            
                                <div class="title-modal">
                                    <h2 class="title">
									<liferay-ui:message key="sicuro-cancellare-annuncio" />
									                  "<%=topic.toUpperCase()%>"?
                                    </h2>
                                </div>
                            </div>
            
                            <h2 class="text">
									<liferay-ui:message key="info-sicurezza" />
						
                            </h2>
            
                            <div class="ama-row mb-50-xs buttons-bottom">
                                <c:if test="${moderatore == true && userlogged != userfromjournal}">                

									<div class="ama-col-xs-12 ama-col-sm-12 mb-30-xs">
										<button class="button button-primary text-uppercase" 
										onclick="location.href='mailto:<%=email%>?subject=cancellazione annuncio id:<%=annuncioId%>, titolo:<%=titolo%>, autore:<%=username%>';" 
											
										 value="invia email">
										<liferay-ui:message key="send-email" />
										<span class="icomoon-mail pl-10-xs"></span>
										</button>
									</div>
								
								</c:if>
								
								<div class="ama-col-xs-12 ama-col-sm-6">
								
                                    <button class="button button-secondary" data-dismiss="modal"><liferay-ui:message key="annulla-button" /></button>
                                </div>
                                
								<div class="ama-col-xs-12 ama-col-sm-6">
                                    <button id="deleteAnnuncio" class="button button-primary">
										<liferay-ui:message key="elimina-button-annuncio" />

									</button>
									   		

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </div> 
         

                                         
                
<portlet:actionURL name="deleteAdv" var="deleteAdv">
<portlet:param name="annuncioId" value="${annuncioId}" />
<portlet:param name="userId" value="${userlogged}" />
</portlet:actionURL>    

<form id="<portlet:namespace/>fmDelete" action="<%=deleteAdv%>" method="POST"></form>

<form id="<portlet:namespace/>fmUpdate" action="<%=dialogviewupdate%>" method="POST" enctype="multipart/form-data">
	<input type="hidden" name="<portlet:namespace/>itemSelectorURL" value="<%=itemSelectorURL%>" />
	<input type="hidden" name="<portlet:namespace/>annuncioId" value="${annuncioId}" />
	<input type="hidden" name="<portlet:namespace/>titolo" value="<%=titolo%>" />
	<input type="hidden" name="<portlet:namespace/>userId" value="${userlogged}" />
	<input type="hidden" name="<portlet:namespace/>email" value="<%=email%>" />
	<input type="hidden" name="<portlet:namespace/>type" value="<%=type%>" />
	<input type="hidden" name="<portlet:namespace/>topic" value="<%=topic%>" />
	<input type="hidden" name="<portlet:namespace/>body" value="<%=HtmlUtil.escape(body)%>" />
	<input type="hidden" name="<portlet:namespace/>deadline" value="<%=deadlinestr%>" />
	<input type="hidden" name="<portlet:namespace/>startdate" value="<%=startDatestr%>" />
	<input type="hidden" name="<portlet:namespace/>phone" value="<%=phoneNumber%>" />
	<input type="hidden" name="<portlet:namespace/>username" value="<%=username%>" />
	<input type="hidden" name="<portlet:namespace/>zona" value="<%=zonastr%>" />
	<input type="hidden" name="<portlet:namespace/>zonaparam" value="<%=zona%>" />
	<input type="hidden" name="<portlet:namespace/>photo1" value="<%=photo1%>" />
	<input type="hidden" name="<portlet:namespace/>photo2" value="<%=photo2%>" />
	<input type="hidden" name="<portlet:namespace/>photo3" value="<%=photo3%>" />
	<input type="hidden" name="<portlet:namespace/>photo4" value="<%=photo4%>" />
</form>




    <script>
   
   
				$("#deleteAnnuncio").click(function(){
					    $("#<portlet:namespace/>fmDelete").submit();
						$("#modal-delete-notice").modal("hide");
						

					
				});
				
				function goToDialogUpdateJsp() {
					$("#<portlet:namespace/>fmUpdate").submit();
				}
	
               var hideHeaderBachecaAnnunci = function(){
                               jQuery("#header_bacheca_annunci").closest( "section" ).hide();
               }
               
  
                hideHeaderBachecaAnnunci();
               
                     
    </script>  


   
</c:if>
