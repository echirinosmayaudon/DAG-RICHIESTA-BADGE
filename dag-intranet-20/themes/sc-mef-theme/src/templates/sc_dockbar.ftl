<#assign searchPortletId = "com_liferay_portal_search_web_portlet_SearchPortlet" />

<#assign searchPortletPlid = portal.getPlidFromPortletId(themeDisplay.scopeGroupId, searchPortletId)!0 />
<#if user_target_site?has_content && user_target_site??>
	<#assign searchPortletPlid = portal.getPlidFromPortletId(user_target_site.getGroupId(), searchPortletId)!0 />
</#if>

<#assign searchPortletNamespace = portal.getPortletNamespace(searchPortletId) />

<#assign searchCssClass = "" />

<#assign hasCssConnection = "" />
<#assign hasFeatureImap = scHelperLocalService.hasUserFeatureEmailImap(themeDisplay.companyId, themeDisplay.userId)/>

<#if (searchPortletPlid > 0) >

	<#assign searchPortletURL = portletURLFactory.create(request, searchPortletId, searchPortletPlid, "ACTION_PHASE") />
	<#assign VOID = searchPortletURL.setParameter(searchPortletNamespace + "mvcPath", "/search.jsp") />
	<#assign VOID = searchPortletURL.setParameter(searchPortletNamespace + "redirect", "${portalUtil.getCurrentURL(request)}") />
	<#assign VOID = searchPortletURL.setPortletMode("VIEW") />
	<#assign VOID = searchPortletURL.setWindowState("MAXIMIZED") />
	<#assign VOID = searchPortletURL.setLifecycle("0") />
	<#assign VOID = searchPortletURL.setPortletId(searchPortletId) />

	<#assign searchMobileURL =  portletURLFactory.create(request, searchPortletId, searchPortletPlid, "RENDER_PHASE") />

</#if>

<#assign searchScopeParam = paramUtil.getString(request, searchPortletNamespace + "scope", "everything") />
<#assign searchKeywordsParam = paramUtil.getString(request, searchPortletNamespace + "keywords", "") />

<div class="sc-dockbar navbar navbar-inverse">
	<div class="container-fluid">

		<div class="navbar-header pull-left dockbar-logo col-xs-6 col-md-4 col-sm-3">
		    <#assign urlIntranteMef = portalUtil.getHomeURL(request) ?split("#")[1] />

            <a href="${urlIntranteMef}" title="Logo Intranet MEF" aria-label="Logo Intranet MEF - torna al tuo profilo">
                <img alt="${logo_description}" src="${site_logo}" />
            </a>
		</div>

		<span class="navbar-toggle icon-reorder visible-xs visible-sm menu-button"></span>

		<#if password_reset?has_content>
			<#if is_signed_in && !password_reset>
			<#if searchPortletURL?has_content>
			    <div class="hidden-xs col-md-4 col-sm-6">
                    <form action="${searchPortletURL}" method="POST" class="navbar-form navbar-left">

                        <#-- <div id="scope-form" class="form-group ${(searchKeywordsParam == "")?then("hide", "")}">

                            <select class="form-control search-select" id="scope" name="${searchPortletNamespace}scope" title="scope">
                                <option class="" ${(searchScopeParam == "everything")?then("selected", "")} value="everything"><@liferay.language key="everything" /></option>
                                <option class="" ${(searchScopeParam == "this-site")?then("selected", "")} value="this-site"><@liferay.language key="this-site" /></option>
                            </select>

                        </div> -->

                        <input type="hidden" name="${searchPortletNamespace}scope" value="everything" />

                        <div id ="search-form" class="form-group">
                            <input name="${searchPortletNamespace}keywords" class="form-control" placeholder="<@liferay.language key="search" />" title ="<@liferay.language key="search" />" value="${searchKeywordsParam}">
                        </div>

                        <button class="btn btn-primary search-btn" id="searchButton">
                            <span class="icomoon-search"></span>
                        </button>
                    </form>
                </div>
			</#if>

				<ul class="nav navbar-nav navbar-right col-xs-5 col-md-4 col-sm-2 pull-right">


					 <li class="trap-focus profile-menu-wrap pull-right hidden-xs hidden-sm" id="userItem">
						<a
							aria-haspopup="true"
							aria-expanded="false"
							data-toggle="aria"
							href="#!"
							id="userMenuToggle"
						>
						    <#if user.getPortraitId() == 0>
                                <span class="ico-user"></span>
                            <#else>
                                <img class="user-portrait" src="${user_logo}"/>
                            </#if>
							<span class="user-full-name visible-accessible-desktop hidden-xs">
								${user_first_name}<br/>${user_last_name}
							</span>
						</a>

						<ul
							aria-labelledby="userMenuToggle"
							class="dropdown-menu mega-dropdown-menu pull-right"
						>
							<#if user_target_site?has_content && user_target_site??>
								<li>
									<a href="${portalUtil.getPortalURL(request)}/web/user_${themeDisplay.getUserId()}">
										<span class="icon-user" style="margin-right: 10px;"></span>
										<@liferay.language key="profile" />
									</a>
								</li>
							</#if>
                        <#--
							<li>
								<a href="${sign_out_url}">
									<span class="icon-signout " style="margin-right: 10px;"></span>
									<@liferay.language key="sign-out" />
								</a>
							</li>
                        -->
						</ul>
					</li>

					<li class="trap-focus notification-alert pull-right" id="userItem">
						<a
							aria-haspopup="true"
							aria-expanded="false"
							data-toggle="aria"
							href="#!"
							id="userNotificationsToggle"
						>
							<span class="sc-dosckbar-icon ico-bell"></span>

							<span id="hasNotification" class="panel-notifications-count sticker sticker-right sticker-rounded sticker-sm sticker-warning hide">
							</span>
						</a>

						<div
							aria-labelledby="userNotificationsToggle"
							class="dropdown-menu notifications-dropdown-menu mega-dropdown-menu pull-right"
						>
							<#assign VOID = freeMarkerPortletPreferences.setValue("portletSetupPortletDecoratorId", "barebone")>

							<@liferay_portlet["runtime"]
								portletProviderAction=portletProviderAction.VIEW
								portletName="it_smc_osportal_sc_notifications_list_web_portlet_NotificationsListWebPortlet"
								queryString="&tabToRead=1"
							/>
						</div>
					</li>

					<li class="trap-focus pull-right" id="userItem">
						<#-- <a
							aria-haspopup="true"
							aria-expanded="false"
							data-toggle="aria"
							href="#!"
							id="userConnectionsToggle"
						>
							<span class="sc-dosckbar-icon icon-group icon-monospaced"></span>
							<#if has_connection_request_css_class == "0" >
								<#assign hasCssConnection = "hide" />
							</#if>
							<span id="hasConnection" class="panel-notifications-count sticker sticker-right sticker-rounded sticker-sm sticker-warning ${hasCssConnection}">
								${has_connection_request_css_class}
							</span>
						</a> -->

						<div
							aria-labelledby="userConnectionsToggle"
							class="dropdown-menu notifications-dropdown-menu mega-dropdown-menu pull-right"
						>

							<@liferay_portlet["runtime"]
								portletProviderAction=portletProviderAction.VIEW
								portletName="it_smc_osportal_sc_connection_requests_list_web_portlet_ConnectionRequestsListWebPortlet"
							/>
						</div>

					</li>

					<#if hasFeatureImap>
						<li id="imapTitleMessage" class="trap-focus pull-right hide">
							<a
								href=""
								id="linkMailExternal"
								target="_blank"
							>

								<span id="messageCount" class="panel-notifications-count sticker sticker-right sticker-rounded sticker-sm sticker-warning">
								</span>

								<span id="messageIcon" class="sc-dosckbar-icon icon-monospaced"></span>
							</a>
						</li>
					</#if>
					<#if searchMobileURL?has_content >
						<li class="trap-focus pull-right btn-search-mobile visible-xs">
							<a href="${searchMobileURL}" id="searchRedirect">
									<span class="ico-search"></span>
							</a>
						</li>
					</#if>
				</ul>
			</#if>
		</#if>
	</div>
</div>
<#if hasFeatureImap>
	<div id="imapPortletCountMail" class="hide">
		<@liferay_portlet["runtime"] portletName="it_smc_osportal_sc_mail_imap_user_web_portlet_UserViewCountMailPortlet"/>
	</div>
</#if>
