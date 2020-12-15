<%@ include file="./init.jsp" %>

<c:choose>
<c:when test="<%=request.getParameter("id_ufficio")!=null && request.getParameter("id_ufficio")!=""%>">
<%@ include file="/rubrica_scheda_uffici.jsp" %>
</c:when>
<c:otherwise>
<%@ include file="/ricerca.jsp" %>
</c:otherwise>
</c:choose>