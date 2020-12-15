<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>

<%@page import="mef.organigramma.beans.StrutturaBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%
List<StrutturaBean> dipartimentiList = new ArrayList<StrutturaBean>(0);
if(request.getAttribute("listDipartimenti") != null)
{
dipartimentiList=(List<StrutturaBean>) request.getAttribute("listDipartimenti");
}

//List<StrutturaBean> direzioniUfficiList= new ArrayList<StrutturaBean>(0);
JSONArray direzioniUfficiList = null;

String listDir = (String)request.getAttribute("structureForDepartment"); 
if(listDir != null){
      //if(request.getAttribute("structureForDepartment") != null){    
//direzioniUfficiList = (List<StrutturaBean>) request.getAttribute("structureForDepartment");

   direzioniUfficiList =JSONFactoryUtil.createJSONArray(listDir);
}

String idDelDipartimento = new String();
if(request.getAttribute("idDelDipartimento") !=null) {
idDelDipartimento = (String) request.getAttribute("idDelDipartimento");
}

String nomeDelDipartimenti = new String();
if(request.getAttribute("nomeDipartimento") != null){
      nomeDelDipartimenti = (String) request.getAttribute("nomeDipartimento");
      
}

String parentDipartimenti = new String();
String tipoDirettore = new String();
if(nomeDelDipartimenti != null){
parentDipartimenti = nomeDelDipartimenti.replaceAll(" ","").toLowerCase();
parentDipartimenti = parentDipartimenti.replaceAll("[^a-zA-Z0-9]+",""); 
}

String nomeDirigente = new String();

nomeDirigente = (String) request.getAttribute("nomeDirigente"); 


%>


<c:set value="<%=dipartimentiList%>" var="dipartimentiList"></c:set>
<c:set value="<%=nomeDelDipartimenti%>" var="nomeDelDipartimenti"></c:set>
<c:set value="<%=nomeDirigente%>" var="nomeDirigente"></c:set>
<c:set value="<%=idDelDipartimento%>" var="idDelDipartimento"></c:set>
<c:set value="<%=parentDipartimenti%>" var="parentDipartimenti"></c:set>
<c:set value="<%=tipoDirettore%>" var="tipoDirettore"></c:set>



<portlet:actionURL name="structureForDepartmentId"
      var="structureForDepartmentId">


</portlet:actionURL>


<form action="<%=structureForDepartmentId%>" method="POST">


      <select id="selectDip" name="<portlet:namespace/>Dipartimento" required>
<option value="0" selected="true" hidden><liferay-ui:message key="scegli-dipartimento"/></option>
            <c:forEach items="${dipartimentiList}" var="dipItem">

                  <option value="${dipItem.getId()}">${dipItem.getNome()}</option>
            </c:forEach>
      </select>

      <button class="button button-primary" type="submit" id="generateHtml">
            <liferay-ui:message key="button-genera-html" />
      </button>


</form>
<div id="html-container">
      <div class="ama-col-xs-12 pl-25-sm pr-0-sm mobile-no-padding">   
<!-- iserire la classe mb-100-xs nel div sottostante solo perl'ultimo elemento dell'organigramma per consentire uno spazio fra l'elemento e il footer -->
            <div class="ama-col-xs-12 content-box-collapse border">
                  <div class="ama-row">
                  


                        <c:if test="<%=direzioniUfficiList != null%>">

                              <div class="ama-col-xs-12 wrapper-box" id="${parentDipartimenti}">
                                   <span class="title-box-icon-collapse icomoon-dipartimento"
                                         id="title">&nbsp;</span>
                                   <c:if test="${nomeDelDipartimenti!=null}">
                                         <span
                                               class="collapse-title-box-title dot-mobile dot-point max-dot-60">${nomeDelDipartimenti}</span>
                                   </c:if>
                                   <c:if test="${nomeDelDipartimenti==null}">
                                         <span
                                               class="collapse-title-box-title dot-mobile dot-point max-dot-60"><liferay-ui:message
                                                     key="inserire-dipartimento" />&nbsp;</span>
                                   </c:if>
                                   <a href="javascript:void(0)" class="icon-open icomoon-plus"
                                         data-toggle="collapse" data-target="#${idDelDipartimento}">&nbsp;</a>
                              </div>

                              <div class="ama-col-xs-12 box-content collapse"
                                   id="${idDelDipartimento}">
                                   <div
                                         class="ama-col-xs-10 ama-col-sm-offset-2 pl-35-sm pl-15-xs pt-25-xs pb-40-xs mobile-no-padding">
                                         <!--each time it will be changed according to the diparment-->
                                         <h2 class="role">
                                               <liferay-ui:message key="dirigente-due-punti" />
                                         </h2>
                                         <!--till here-->
                                         <c:if test="${nomeDirigente!=null}">
                                               <h2 class="name mb-35-xs">${nomeDirigente}</h2>
                                         </c:if>
                                         <c:if test="${nomeDirigente==null}">
                                               <h2 class="name mb-35-xs">
                                               <liferay-ui:message key="inserire-dirigente" />
                                               </h2>
                                         </c:if>


                                         <!--should be in for because it's generated all the time -->
                                         
                                         <%
                              for(int i=0;i<direzioniUfficiList.length();i++) {
                                         JSONObject dipUfficioItem = JSONFactoryUtil.createJSONObject(direzioniUfficiList.get(i).toString());
                                   %>
                                               <div class="office-wrapper mt-15-xs">
                                                     <a href="javascript:void(0)"
                                                           class="department-content-icon-open icomoon-plus"
                                                           data-toggle="collapse"
                                                           data-target="#<%=dipUfficioItem.getString("id")%>"
                                                           data-parent="${parentDipartimenti}">&nbsp;</a>
                                                     <c:if test="<%=dipUfficioItem.getString("nome") != null%>">
                                                           <a href="${linkLayoutmyUrl}&_${porletId_Rubrica}_id_ufficio=<%=dipUfficioItem.getString("id")%>">
                                                           <span class="office-name ml-10-xs"><%=dipUfficioItem.getString("nome")%></span></a>
                                                     </c:if>
                                                     <c:if test="<%=dipUfficioItem.getString("nome") == null%>">
                                                           <span class="office-name ml-10-xs"><liferay-ui:message
                                                                       key="inserire-dipartimento" />&nbsp;</span>
                                                     </c:if>
                                                     <div class="office-name-content collapse"
                                                           id="<%=dipUfficioItem.getString("id")%>">


                                        <%JSONArray strutture = JSONFactoryUtil.createJSONArray(dipUfficioItem.getString("strutture")); %>

                                                           <c:if test="<%=strutture.length() == 0%>">
                              
                                                                 <h2 class="office-name-content-title">
                                                                       <liferay-ui:message key="inserire-ufficio" />
                                                                 </h2>

                                                           </c:if>


                                        <c:if test="<%=strutture.length() > 0%>">
                                        
                                         <%
                                                for(int j=0;j<strutture.length();j++) {
                                                           JSONObject dipUfficiNome = JSONFactoryUtil.createJSONObject(strutture.get(j).toString());
                                                 %>
                                        
                                        
                                                     <c:if test="<%=dipUfficiNome.getString("nome") != null%>">
                                                                       
      
                                                                             <a
                                                                                   href="${linkLayoutmyUrl}&_${porletId_Rubrica}_id_ufficio=<%=dipUfficiNome.getString("id")%>"><h2
                                                                                         class="office-name-content-title"><%=dipUfficiNome.getString("nome")%></h2></a>
                                                                       </c:if>
                                                           <% } %>
                                                                 
                                                           </c:if>


                                                     </div>
                                               </div>

                                   
                                         <% } %>
                                   </div>
                              </div>


                        </c:if>

                  </div>
            </div>
      </div>
</div>

<c:if test="<%=direzioniUfficiList != null%>">
      <textarea class="textarea-white" id="html-viewer" readonly>
      </textarea>
</c:if>

<script>
function sethtml(){
      var htmlcode= $('#html-container').html();
      console.log(htmlcode);
      $('#html-viewer').text(htmlcode);  
}
$(document).ready(function(){
      
});
sethtml();
</script>

