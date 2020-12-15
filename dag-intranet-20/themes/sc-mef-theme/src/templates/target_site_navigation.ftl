<#assign openMenuToggler = is_show_MenuToggler?then('open-md-lg','') />
<div id="target-navigation" class="${openMenuToggler}">
	<nav id="target-site-navigation" role="navigation">
		<h1 class="hide-accessible"><@liferay.language key="navigation" /></h1>
		<ul class="nav">
		    <li class="menu-toggler">
                <span class="bar"></span>
                <span class="bar"></span>
                <span class="bar"></span>
            </li>
			<li class="nav-user-item hidden-md hidden-lg">
				<span>${user_first_name} ${user_last_name}</span>
			</li>
			<#if is_company_supervisor || is_omni_admin>
				<li role="presentation">
					<a href="/group/dashboard" role="menuitem">
						<span>
							<span class="nav-icon icon-dashboard icon-monospaced"></span>
							<@liferay.language key="dashboard" />
						</span>
					</a>
				</li>
			</#if>
			<#list user_target_nav_items as nav_item>
				<#if !nav_item.getLayout().isHidden()>
					<#assign
						nav_item_attr_has_popup = ""
						nav_item_attr_selected = ""
						nav_item_css_class = ""
						nav_item_layout = nav_item.getLayout()
					/>
					<#if nav_item.isSelected()>
						<#assign
							nav_item_attr_has_popup = "aria-haspopup='true'"
							nav_item_attr_selected = "aria-selected='true'"
							nav_item_css_class = "selected"
						/>
					</#if>
					<#assign layout_icon = getLayoutIcon(nav_item.getLayout().getFriendlyURL(locale))!"" />
					<#assign frinedlyUrlNavItem = nav_item.getLayout().getFriendlyURL(locale) />
					<li ${nav_item_attr_selected} class="${nav_item_css_class}" id="layout_${nav_item.getLayoutId()}" role="presentation">
						<a aria-labelledby="layout_${nav_item.getLayoutId()}" ${nav_item_attr_has_popup} href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem">
							<span>
								<span class="nav-icon icomoon-${layout_icon}"></span>${nav_item.getName()}
							</span>
						</a>
						<#if frinedlyUrlNavItem == "/spaces_groups" || frinedlyUrlNavItem == "/spaces_personal" >
							<#if user_favorite_spaces?size gt 0>
								<ul class="nav">
								<!-- <li class="nav-space-title-item">
									<span><@liferay.language key="favorite-spaces" /></span>
								</li> -->
								<#list user_favorite_spaces as favorite_space>
									<#assign url = portal.getPathFriendlyURLPrivateGroup() + favorite_space.getFriendlyURL() />
									<#assign nav_item_css_class = "" />
									<#assign icon_css_class = scHelperLocalService.getSpaceTypeIconCssClass(favorite_space) />
									<#if group_id == favorite_space.getGroupId()>
										<#assign nav_item_css_class = "selected" />
									</#if>
								
									<#if (scHelperLocalService.isUserSpaceSite(favorite_space) && frinedlyUrlNavItem == "/spaces_personal")>
										<li class="${nav_item_css_class}">
											<#assign space_name = scHelperLocalService.getGroupSiteTitle(favorite_space) />
											<#if space_name == "">
												<#assign space_name = favorite_space.getDescriptiveName(locale) />
											</#if>
											<a href="${url}"}>
												<span>
													<span class="nav-icon icomoon-preferiti"></span>${space_name}
												</span>
											</a>
										</li>
									</#if>
                                   
								</#list>
								</ul>
							</#if>
						</#if>
					</li>
				</#if>
			</#list>
			<#if user_target_site?has_content && user_target_site??>
				<li class="hidden-md hidden-lg nav-public-profile-item">
					<a href="">
						<span class="icon-user" style="margin-right: 10px;"></span>
						<@liferay.language key="profile" />
					</a>
				</li>
			</#if>
			<li class="hidden-md hidden-lg nav-sign-out-item">
				<a href="${sign_out_url}">
					<span class="icon-signout " style="margin-right: 10px;"></span>
					<@liferay.language key="sign-out" />
				</a>
			</li>
		</ul>
	</nav>
</div>
