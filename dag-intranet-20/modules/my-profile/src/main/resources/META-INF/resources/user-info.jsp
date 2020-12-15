<%@include file="./init.jsp"%>

<%
User u = themeDisplay.getUser();
String currentImageURL = u.getPortraitURL(themeDisplay);

String userAddress = (String) request.getAttribute("userAddress");
String piano = (String) request.getAttribute("piano");
String scala = (String) request.getAttribute("scala");
String stanza = (String) request.getAttribute("stanza");
String tel = (String) request.getAttribute("tel");
String fax = (String) request.getAttribute("fax");
String mobile = (String) request.getAttribute("mobile");
String userRole = (String) request.getAttribute("userRole");
String dirName = (String) request.getAttribute("dirName");
String dipName = (String) request.getAttribute("dipName");
String uffName = (String) request.getAttribute("uffName");
%>

<liferay-portlet:renderURL var="modifyPhotoURL">
	<portlet:param name="mvcRenderCommandName" value="/image_uploader/view" />
</liferay-portlet:renderURL>

<c:if test="<%=isShort %>">
	<div class="card-profile">
		<span class="avatar"
			style="background-image: url(<%=PortalUtil.getPortalURL(request)+currentImageURL%>);"></span>
		<div class="box-content">
			<h1 class="title-card dot-point max-dot-70"><%=u.getFullName() %></h1>
			<p class="role-card dot-point max-dot-70"><%=userRole %></p>
			<a data-toggle="modal" data-target="#modal-upload-image"
				title="" class="link-modified"> <span
				class="icomoon-camera-multim ico-photo"></span>
				<p class="text-modified"><liferay-ui:message key="my-profile-modify" /></p>
			</a>
		</div>
		<p>
			<span class="icon-card icon-card2 icomoon-e-mail"><span
				class="sr-only">Email</span> </span> <span class="text-card"><%=u.getEmailAddress()%></span>
		</p>
		<p>
			<span class="icon-card icon-card2 icomoon-profilo-mobile"><span
				class="sr-only">Cellulare</span></span> <span class="text-card"><liferay-ui:message key="my-profile-cell" />
				<%=mobile %></span>
		</p>
		<p>
			<span class="icon-card icon-card2 icomoon-rubrica-tel"><span
				class="sr-only">Telefono</span></span> <span class="text-card"><liferay-ui:message key="my-profile-tel" />
				<%=tel %></span>
		</p>
		<p>
			<span class="icon-card icon-card2 icomoon-fax"><span
				class="sr-only">Fax</span></span> <span class="text-card"><liferay-ui:message key="my-profile-fax" /> 
				<%=fax %></span>
		</p>
		<div class="text-center pt-10-xs">
			<a class="button-default" title="Scopri di più"
				href="<%="/group"+themeDisplay.getSiteGroup().getFriendlyURL() + profileDetailUrl.getFriendlyURL() %>" tabindex="0"><liferay-ui:message key="my-profile-find-out-more" /></a>
		</div>
	</div>
</c:if>
<c:if test="<%=!isShort %>">
<div class="bg-image-card-profile">
    <div class="primo-piano-profile-wrap">
        <article>
            <div class="ama-container-fluid">
                <div class="ama-row">
                    <div class="ama-col-md-12 pt-50-md pt-30-xs">
	<div class="card-profile card-profile-info">
		<div class="ama-row">
			<div class="ama-col-md-5">
				<span class="avatar"
					style="background-image: url(<%=PortalUtil.getPortalURL(request)+currentImageURL%>);"></span>
				<div class="box-content box-info">
					<h1 class="title-card dot-point max-dot-70"><%=u.getFullName() %></h1>
					<p class="role-card dot-point max-dot-70"><%=userRole%></p>
					<a data-toggle="modal" data-target="#modal-upload-image"
						 title="" class="link-modified"> <span
						class="icomoon-camera-multim ico-photo"></span>
						<p class="text-modified"><liferay-ui:message key="my-profile-modify" /></p>
					</a>
				</div>
				<div class="wrapper-content-ul">
					<p>
						<span class="icon-card icon-card2">CF</span> <span class="text-card"><%=u.getScreenName() %>
							</span>
					</p>
					<p>
						<span class="icon-card icon-card2 icomoon-e-mail"><span
							class="sr-only">Email</span> </span> <span class="text-card"><%=u.getEmailAddress()%></span>
					</p>
					<p>
						<span class="icon-card icon-card2 icomoon-profilo-mobile"><span
							class="sr-only">Cellulare</span></span> <span class="text-card"><liferay-ui:message key="my-profile-cell" />
							<%=mobile %></span>
					</p>
					<p>
						<span class="icon-card icon-card2 icomoon-rubrica-tel"><span
							class="sr-only">Telefono</span></span> <span class="text-card"><liferay-ui:message key="my-profile-tel" />
							<%=tel %></span>
					</p>
					<p>
						<span class="icon-card icon-card2 icomoon-fax"><span
							class="sr-only">Fax</span></span> <span class="text-card"><liferay-ui:message key="my-profile-fax" /> <%=fax %>
							</span>
					</p>
				</div>
			</div>

			<div class="ama-col-md-7">
				<h2 class="title borders"><%=dipName%><br><%=dirName%><br><%=uffName %></h2>

				<div class="wrapper-content-ul">
					<p>
						<span
							class="icon-card icon-card2 icomoon-placeholder-2"></span>
						<span class="text-card"><%=userAddress %></span>
					</p>
				
					<p>
						<span
							class="icon-card icon-card2 icomoon-piano"></span>
						<span class="text-card"><%=piano %></span>
					</p>
				
					<p>
						<span
							class="icon-card icon-card2 icomoon-scala"></span>
						<span class="text-card"><%=scala %></span>
					</p>
				
					<p>
						<span
							class="icon-card icon-card2 icomoon-stanza"></span>
						<span class="text-card"><%=stanza %></span>
					</p>
				</div>
			</div>
		</div>
	</div>
	</div>
                </div>
            </div>
        </article>
    </div>
</div>
</c:if>

<%@include file="./view.jspf"%>
