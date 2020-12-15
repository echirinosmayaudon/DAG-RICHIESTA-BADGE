<%@ include file="/init.jsp" %>
<%@page import="com.intranet.mef.bean.Richiedente"%>
<%@page import="com.intranet.mef.bean.ModuloRichiedente"%>
<%@page import="java.io.File"%>



<% 
String navigation ="home";
if(request.getAttribute("navigation")!=null)
	navigation = (String) request.getAttribute("navigation");

if(request.getAttribute("richiedente")!=null){
	Richiedente richiedente = (Richiedente)request.getAttribute("richiedente");

ModuloRichiedente moduloRichiedente = null; 
if(request.getAttribute("moduloRichiedente")!=null){
	moduloRichiedente = (ModuloRichiedente)request.getAttribute("moduloRichiedente");
	if (moduloRichiedente!=null && moduloRichiedente.getNomeFiglio()==null ){
		moduloRichiedente.setNomeFiglio("");
	} 
	if (moduloRichiedente!=null && 	moduloRichiedente.getCognomeFiglio()==null){
		moduloRichiedente.setCognomeFiglio("");
	} 
	if (moduloRichiedente!=null && 	moduloRichiedente.getCfFiglio()==null ){
		moduloRichiedente.setCfFiglio("");
	} 
	if (moduloRichiedente!=null && 	moduloRichiedente.getDataNascitaFiglio()==null){
		moduloRichiedente.setDataNascitaFiglio("");
	}
	
	if (moduloRichiedente!=null && 	moduloRichiedente.getIban()==null){
		moduloRichiedente.setIban("");
		navigation ="home";
	}
	if (moduloRichiedente!=null && 	moduloRichiedente.getImporto()==null){
		moduloRichiedente.setImporto("");
		navigation ="home";

	}
	if (moduloRichiedente!=null && 	moduloRichiedente.getTipoViaggio()==null){
		navigation="home";
		moduloRichiedente.setTipoViaggio("mensile");
	}
	if (moduloRichiedente!=null && 	moduloRichiedente.getNumeroViaggi()==null){
		moduloRichiedente.setNumeroViaggi("");
	}
	if (moduloRichiedente!=null && 	moduloRichiedente.getDataAcquistoViaggio()==null){
		moduloRichiedente.setDataAcquistoViaggio("");
	}
	if (moduloRichiedente!=null && 	moduloRichiedente.getDescrizione()==null){
		moduloRichiedente.setDescrizione("");
		navigation ="home";

	}
	if (moduloRichiedente!=null && 	moduloRichiedente.getFlagTipoSpesa()==null){
		moduloRichiedente.setFlagTipoSpesa("personale");
		navigation ="home";

	}
}
else{
	
	moduloRichiedente = new ModuloRichiedente();
	moduloRichiedente.setIban("");
	moduloRichiedente.setImporto("");
	moduloRichiedente.setTipoViaggio("mensile"); //mensile o annuale
	moduloRichiedente.setNumeroViaggi("");
	moduloRichiedente.setDataAcquistoViaggio("");
	moduloRichiedente.setDescrizione("");
	moduloRichiedente.setFlagTipoSpesa("personale"); //personale o figli
	moduloRichiedente.setNomeFiglio("");
	moduloRichiedente.setCognomeFiglio("");
	moduloRichiedente.setCfFiglio("");
	moduloRichiedente.setDataNascitaFiglio("");
	moduloRichiedente.setLuogoNascitaFiglio("");
	navigation ="home";
}
	
%>

<c:choose>
	<c:when test='<%=navigation.equalsIgnoreCase("home")%>'>
		<%@ include file="/servizi-trasporti.jsp" %>
	</c:when>
	<c:when test='<%=navigation.equalsIgnoreCase("riepilogo")%>'>
		<%@ include file="/servizi-trasporti-riepilogo.jsp" %>
	</c:when>
	<c:otherwise>
		<%@ include file="/errorPage.jsp" %>
	</c:otherwise>
</c:choose>

<% }else{%>
		<%@ include file="/errorPage.jsp" %>
<% } %>