<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>

<liferay-portlet:actionURL portletConfiguration="<%= true %>"
	var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%= true %>"
	var="configurationRenderURL" />

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">

	<aui:input name="<%= Constants.CMD %>" type="hidden"
		value="<%= Constants.UPDATE %>" />

	<aui:input name="redirect" type="hidden"
		value="<%= configurationRenderURL %>" />

		
			<liferay-ui:panel title="Impostazioni configurazione">

	<liferay-ui:tabs names="Configurazione" refresh="false">
	<liferay-ui:section>
	    <aui:input type="text" name="formTitle" label="TITOLO FORM" value="<%=formTitle%>" />
		
		<aui:input type="text" name="formSubTitle" label="SOTTOTITOLO FORM" value="<%=formSubTitle%>" />
		
		<aui:input type="text" name="formTitleRecap" label="TITOLO RECAP" value="<%=formTitleRecap%>" />
		
		<aui:input type="text" name="formSubTitleRecap" label="SOTTOTITOLO RECAP" value="<%=formSubTitleRecap%>" />
		
		<aui:input type="text" name="formTitleDettaglio" label="TITOLO DETTAGLIO" value="<%=formTitleDettaglio%>" />
		
		<aui:input type="text" name="formSubTitleDettaglio" label="SOTTOTITOLO DETTAGLIO" value="<%=formSubTitleDettaglio%>" />
		
		<aui:input type="text" name="formTitleSearch" label="TITOLO RICERCA" value="<%=formTitleSearch%>" />
		
		<aui:input type="text" name="formSubTitleSearch" label="SOTTOTITOLO RICERCA" value="<%=formSubTitleSearch%>" />
		
		<aui:input type="text" name="sender" label="MITTENTE" value="<%=sender%>" />
		
		<aui:input type="text" name="emailSubject" label="OGGETTO EMAIL" value="<%=emailSubject%>" />
		
		<aui:input type="text" name="emailToDipDT" label="DESTINATARIO EMAIL DIP DT" value="<%=emailToDipDT%>" />
		
		<aui:input type="text" name="emailToDipRGS" label="DESTINATARIO EMAIL DIP RGS" value="<%=emailToDipRGS%>" />
		
		<aui:input type="text" name="emailToDipDF" label="DESTINATARIO EMAIL DIP DF" value="<%=emailToDipDF%>" />
	     
	    <aui:input type="text" name="emailToDipDAG" label="DESTINATARIO EMAIL DIP DAG" value="<%=emailToDipDAG%>" />
		
		<aui:input type="text" name="bando" label="BANDO" value="<%=bando%>" />
		
		<aui:input type="text" name="regolamento" label="REGOLAMENTO" value="<%=regolamento%>" />
		
		<aui:input type="text" name="itemsPerPage" label="ELEMENTI PER PAGINA RICERCA" value="<%=itemsPerPage%>" />
		
		<liferay-ui:input-editor  name ='emailBodyEditor' initMethod="initEmailBodyEditor" height="50%"/>
	    <aui:input name="emailBody" type="hidden" value="" />
		
		<%
		  Log _log = LogFactoryUtil.getLog("configuration_jsp");
		
		  SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
		  Date date;
		  SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
		  Date time;
		  
		  Calendar calDateInizioInserimentoRichiesta = Calendar.getInstance();
		  if(dataInizioInserimentoRichiesta!=null && !"".equals(dataInizioInserimentoRichiesta)) {
			  date = sdfDate.parse(dataInizioInserimentoRichiesta);
			  calDateInizioInserimentoRichiesta.setTime(date);
		  }
		  Calendar calTimeInizioInserimentoRichiesta = Calendar.getInstance(); 
		  calTimeInizioInserimentoRichiesta.set(Calendar.HOUR_OF_DAY, 0);
		  calTimeInizioInserimentoRichiesta.set(Calendar.MINUTE, 0);
		  if(oraInizioInserimentoRichiesta!=null && !"".equals(oraInizioInserimentoRichiesta)) {
			  time = sdfTime.parse(oraInizioInserimentoRichiesta);
			  calTimeInizioInserimentoRichiesta.setTime(time);
		  }
		  Calendar calDateFineInserimentoRichiesta = Calendar.getInstance();
		  if(dataFineInserimentoRichiesta!=null && !"".equals(dataFineInserimentoRichiesta)) {
			  date = sdfDate.parse(dataFineInserimentoRichiesta);
			  calDateFineInserimentoRichiesta.setTime(date);
		  }
		  Calendar calTimeFineInserimentoRichiesta = Calendar.getInstance(); 
		  calTimeFineInserimentoRichiesta.set(Calendar.HOUR_OF_DAY, 0);
		  calTimeFineInserimentoRichiesta.set(Calendar.MINUTE, 0);
		  if(oraFineInserimentoRichiesta!=null && !"".equals(oraFineInserimentoRichiesta)) {
			  time = sdfTime.parse(oraFineInserimentoRichiesta);
			  calTimeFineInserimentoRichiesta.setTime(time);
		  }
		  Calendar calDateInizioInserimentoAllegato = Calendar.getInstance();
		  if(dataInizioInserimentoAllegato!=null && !"".equals(dataInizioInserimentoAllegato)) {
			  date = sdfDate.parse(dataInizioInserimentoAllegato);
			  calDateInizioInserimentoAllegato.setTime(date);
		  }
		  Calendar calTimeInizioInserimentoAllegato = Calendar.getInstance(); 
		  calTimeInizioInserimentoAllegato.set(Calendar.HOUR_OF_DAY, 0);
		  calTimeInizioInserimentoAllegato.set(Calendar.MINUTE, 0);
		  if(oraInizioInserimentoAllegato!=null && !"".equals(oraInizioInserimentoAllegato)) {
			  time = sdfTime.parse(oraInizioInserimentoAllegato);
			  calTimeInizioInserimentoAllegato.setTime(time);
		  }
		  Calendar calDateFineInserimentoAllegato = Calendar.getInstance();
		  if(dataFineInserimentoAllegato!=null && !"".equals(dataFineInserimentoAllegato)) {
			  date = sdfDate.parse(dataFineInserimentoAllegato);
			  calDateFineInserimentoAllegato.setTime(date);
		  }
		  Calendar calTimeFineInserimentoAllegato = Calendar.getInstance(); 
		  calTimeFineInserimentoAllegato.set(Calendar.HOUR_OF_DAY, 0);
		  calTimeFineInserimentoAllegato.set(Calendar.MINUTE, 0);
		  if(oraFineInserimentoAllegato!=null && !"".equals(oraFineInserimentoAllegato)) {
			  time = sdfTime.parse(oraFineInserimentoAllegato);
			  calTimeFineInserimentoAllegato.setTime(time);
		  }
		%>

		<label>
    	DATA INIZIO INSERIMENTO RICHIESTA
		    <liferay-ui:input-date
				dayParam="giornoInizioInserimentoRichiesta"
				dayValue="<%= calDateInizioInserimentoRichiesta.get(java.util.Calendar.DATE) %>"
				monthParam="meseInizioInserimentoRichiesta"
				monthValue="<%= calDateInizioInserimentoRichiesta.get(java.util.Calendar.MONTH) %>"
				yearParam="annoInizioInserimentoRichiesta"
				yearValue="<%= calDateInizioInserimentoRichiesta.get(java.util.Calendar.YEAR) %>"
				name='dataInizioInserimentoRichiesta'
			/>
		</label>
		<label>
    	ORA INIZIO INSERIMENTO RICHIESTA
			<liferay-ui:input-time 
				amPmParam="ampm" 
				hourParam="hourInizioInserimentoRichiesta" 
				hourValue="<%= calTimeInizioInserimentoRichiesta.get(java.util.Calendar.HOUR_OF_DAY) %>"
				minuteParam="minInizioInserimentoRichiesta" 
				minuteValue="<%= calTimeInizioInserimentoRichiesta.get(java.util.Calendar.MINUTE) %>"
				minuteInterval="10"
				name='oraInizioInserimentoRichiesta'
			/>
		</label>
		<br>
		<label>
    	DATA FINE INSERIMENTO RICHIESTA
		    <liferay-ui:input-date
				dayParam="giornoFineInserimentoRichiesta"
				dayValue="<%= calDateFineInserimentoRichiesta.get(java.util.Calendar.DATE) %>"
				monthParam="meseFineInserimentoRichiesta"
				monthValue="<%= calDateFineInserimentoRichiesta.get(java.util.Calendar.MONTH) %>"
				yearParam="annoFineInserimentoRichiesta"
				yearValue="<%= calDateFineInserimentoRichiesta.get(java.util.Calendar.YEAR) %>"
				name='dataFineInserimentoRichiesta'
			/>
		</label>
		<label>
    	ORA FINE INSERIMENTO RICHIESTA
			<liferay-ui:input-time 
				amPmParam="ampm" 
				hourParam="hourFineInserimentoRichiesta" 
				hourValue="<%= calTimeFineInserimentoRichiesta.get(java.util.Calendar.HOUR_OF_DAY) %>"
				minuteParam="minFineInserimentoRichiesta" 
				minuteValue="<%= calTimeFineInserimentoRichiesta.get(java.util.Calendar.MINUTE) %>"
				minuteInterval="10"
				name='oraFineInserimentoRichiesta'
			/>
		</label>
		<br>
		<label>
    	DATA INIZIO INSERIMENTO ALLEGATO
		    <liferay-ui:input-date
				dayParam="giornoInizioInserimentoAllegato"
				dayValue="<%= calDateInizioInserimentoAllegato.get(java.util.Calendar.DATE) %>"
				monthParam="meseInizioInserimentoAllegato"
				monthValue="<%= calDateInizioInserimentoAllegato.get(java.util.Calendar.MONTH) %>"
				yearParam="annoInizioInserimentoAllegato"
				yearValue="<%= calDateInizioInserimentoAllegato.get(java.util.Calendar.YEAR) %>"
				name='dataInizioInserimentoAllegato'
			/>
		</label>
		<label>
    	ORA INIZIO INSERIMENTO ALLEGATO
			<liferay-ui:input-time 
				amPmParam="ampm" 
				hourParam="hourInizioInserimentoAllegato" 
				hourValue="<%= calTimeInizioInserimentoAllegato.get(java.util.Calendar.HOUR_OF_DAY) %>"
				minuteParam="minInizioInserimentoAllegato" 
				minuteValue="<%= calTimeInizioInserimentoAllegato.get(java.util.Calendar.MINUTE) %>"
				minuteInterval="10"
				name='oraInizioInserimentoAllegato'
			/>
		</label>
		<br>
		<label>
    	DATA FINE INSERIMENTO ALLEGATO
		    <liferay-ui:input-date
				dayParam="giornoFineInserimentoAllegato"
				dayValue="<%= calDateFineInserimentoAllegato.get(java.util.Calendar.DATE) %>"
				monthParam="meseFineInserimentoAllegato"
				monthValue="<%= calDateFineInserimentoAllegato.get(java.util.Calendar.MONTH) %>"
				yearParam="annoFineInserimentoAllegato"
				yearValue="<%= calDateFineInserimentoAllegato.get(java.util.Calendar.YEAR) %>"
				name='dataFineInserimentoAllegato'
			/>
		</label>
		<label>
    	ORA FINE INSERIMENTO ALLEGATO
			<liferay-ui:input-time 
				amPmParam="ampm" 
				hourParam="hourFineInserimentoAllegato" 
				hourValue="<%= calTimeFineInserimentoAllegato.get(java.util.Calendar.HOUR_OF_DAY) %>"
				minuteParam="minFineInserimentoAllegato" 
				minuteValue="<%= calTimeFineInserimentoAllegato.get(java.util.Calendar.MINUTE) %>"
				minuteInterval="10"
				name='oraFineInserimentoAllegato'
			/>
		</label>
		
		<aui:input type="text" name="msgTerminiScaduti" label="MESSAGGIO DI TERMINI SCADUTI" value="<%=msgTerminiScaduti%>" />
		
		<aui:input type="text" name="msgNuovoAllegato" label="MESSAGGIO DI NUOVO ALLEGATO" value="<%=msgNuovoAllegato%>" />
		
	</liferay-ui:section>

	
</liferay-ui:tabs>
			
</liferay-ui:panel>



	<aui:button type="submit" onclick="extractCodeFromEditor()"></aui:button>

</aui:form>

<script type="text/javascript">

            function <portlet:namespace />initEmailBodyEditor() {
                 return "<%=emailBody%>";
            }
            
            function extractCodeFromEditor() {
                 var bodyEmail = document.<portlet:namespace />fm.<portlet:namespace />emailBody.value = window.<portlet:namespace />emailBodyEditor.getHTML().replace(/[\n\r]+/g, '').replace(/"/g, "'");
            }
</script>