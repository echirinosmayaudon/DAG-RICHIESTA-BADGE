<div class="ama-col-xs-12 riunioni-day-title-wrap">
		<div class="ama-row">
			
			<div class="ama-col-xs-4 text-right"><span class="riunioni-day-title"><span class="bold"><%=lista_res.size() %></span>
			<liferay-ui:message key="gestione-riunione-ricerca-segreteria-riunioni" /> </span></div>
		</div>
	</div>

	<c:forEach items="<%=lista_res %>" var="riunione">
<%
											
	RiunioneBean r =(RiunioneBean) pageContext.getAttribute("riunione");%>
		<portlet:actionURL name="goToConfermaInvitoUrl" var="goToConfermaInvitoUrl">
		
		<portlet:param name="idRiunione"
		value="${riunione.getId_riunione()}" />
		<portlet:param name="idSegreteria"
		value="${idSegreteria}" />
	</portlet:actionURL>
	
	<a href="<%=goToConfermaInvitoUrl%>">
	
		<div class="riunione-item segreteria-riunione-item item-pagination animated fadeIn">
			<div class="ama-col-md-12 no-padding">
				<div class="ama-col-md-12 header-background">
					<div class="riunione-item-header border">
						<div class="ama-col-md-2 pt-10-xs pt-0-md">
							<span class="header-title"><span class="bold">
							<liferay-ui:message key="gestione-riunione-ricerca-segreteria-id" />:</span> 
							${riunione.getId_riunione()}</span>
						</div>
						<div class="ama-col-md-3 text-center-no-mobile pt-10-xs pt-0-md">
							<span class="header-title"><span class="icomoon-calendar-date"></span><span class="bold">
							<%=sdfData.format(r.getData_inizio())%></span></span>
						</div>
						<div class="ama-col-md-2 text-center-no-mobile pt-10-xs pt-0-md">
							<span class="header-title"><span class="icomoon-time"></span><span class="bold"><%=sdfOra.format(r.getData_inizio())%></span></span>
						</div>
						<div class="ama-col-md-5 text-center-no-mobile pt-10-xs pb-10-xs pb-0-md pt-0-md segreteriaProtocollo">
							<span class="header-title segreteriaSpan"><span class="bold">
							<liferay-ui:message key="gestione-riunione-ricerca-segreteria-protocollo" />:</span> ${riunione.getProtocollo()}</span>
						</div>
					</div>
				</div>
				<div class="ama-col-md-12 body-border">
					<div class="riunione-item-body">
					<%
								String labelStato = r.getStatoRiunione();
							%>
					<span class="label-riunioni-state">
						<c:choose>
							<c:when test="<%= labelStato.equalsIgnoreCase("indetta") %>">
								<span class="label-icon icomoon-meeting"></span>
							</c:when>
							<c:when test="<%= labelStato.equalsIgnoreCase("rinviata")%>">
								<span class="label-icon icomoon-hourglass"></span>
							</c:when>
							<c:when test="<%= labelStato.equalsIgnoreCase("annullata") %>">
								<span class="label-icon icomoon-cancel"></span>
							</c:when>
							<c:when test="<%= labelStato.equalsIgnoreCase("effettuata") %>">
								<span class="label-icon icomoon-success-blu"></span>
							</c:when>
							<c:otherwise>
								
							</c:otherwise>
						</c:choose>
					<span class="label-state-name"><%= labelStato %></span></span>
					
					</span>
						<%	String tipoRiunione = r.getTipoRiunione();
							
							
							InvitatiRiunionePK invitatoRiunionePk= new InvitatiRiunionePK();
							invitatoRiunionePk.setId_riunione(r.getId_riunione());
							invitatoRiunionePk.setId_segreteria(Long.parseLong(idSegreteria));
							InvitatiRiunione invitatoRiunione = InvitatiRiunioneLocalServiceUtil.getInvitatiRiunione(invitatoRiunionePk);
						%>
						<c:if test="<%= !tipoRiunione.equals("")%>">
							<span  class="label-riunioni-state ml-0-xs ml-20-sm">
								<span class="label-state-name">
									<%=tipoRiunione%>
								</span>
							</span>
						</c:if>
						<c:if test="<%= labelStato.equalsIgnoreCase("indetta") %>">

						<span class="label-riunioni-state dark-label pull-right">

							<c:choose>
								<c:when test="<%=invitatoRiunione.getId_stato_invitato()>0%>" >
									<%
										StatoInvitato statoInvitatiDB = StatoInvitatoLocalServiceUtil.getStatoInvitato(invitatoRiunione.getId_stato_invitato());
									%>
									<c:choose>
										<c:when test="<%= statoInvitatiDB.getNome_stato().equalsIgnoreCase("accettata")%>">
											<span class="ico-label icomoon-riunione-ok"></span>
										</c:when>
										<c:when test="<%= statoInvitatiDB.getNome_stato().equalsIgnoreCase("rifiutata")%>">									
											<span class="ico-label icomoon-riunione-ko"></span>

										</c:when>
										<c:otherwise>
											
										
										</c:otherwise>
									</c:choose>
										<span class="label-state-name">	<%= statoInvitatiDB.getNome_stato().toUpperCase() %></span>
								</c:when>
								<c:otherwise>
									<span class="ico-label icomoon-riunione-wait"></span>
									<liferay-ui:message key='gestione-riunione-ricerca-segreteria-stato-in-attesa'/>

								</c:otherwise>
							</c:choose>
						</span>
					</c:if>

						<p class="riunione-item-name">${riunione.getOggetto()}</p>
					</div>
				</div>
			</div>
                                    
	</div>  
	</a>	
</c:forEach>