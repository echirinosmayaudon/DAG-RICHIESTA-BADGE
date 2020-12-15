<%@ include file="/init.jsp" %>

<% 
	String nav= (String)request.getParameter("navigation");
%>





<c:if test='<%=nav!=null && !nav.equals("")%>'>
	<c:if test='<%=nav.equals("confirmRiunion") %>'>
		<%@ include file="/confermainvito.jsp"%>	

	</c:if>
	<c:if test='<%=nav.equals("detailRiunion") %>'>
			<%@ include file="/dettaglioRiunione.jsp"%>	

	</c:if>
	
</c:if>

<c:if test="<%=nav==null || nav.isEmpty() %>">

	<% if((request.getAttribute("mod")!=null && (((String)request.getAttribute("mod")).equals("modifica")))) {%>
	<%@ include file="/modifyRiunion.jsp"%>	
	
	<%	}else{%>
	<%@ include file="/gestioneRiunioni.jsp"%>
	<%	}%>


</c:if>

