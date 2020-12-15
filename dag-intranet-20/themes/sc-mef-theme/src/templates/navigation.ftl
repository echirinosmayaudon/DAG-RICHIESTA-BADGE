<nav class="${nav_css_class}" id="navigation" role="navigation">
	<h1 class="hide-accessible"><@liferay.language key="navigation" /></h1>

	<ul class="nav nav-pills pull-right" aria-label="<@liferay.language key="site-pages" />" role="menubar">
		<#list nav_items as nav_item>
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
			<#if !isSettingsLayout(nav_item.getLayout().getFriendlyURL(locale)) && !isMembersLayout(nav_item.getLayout().getFriendlyURL(locale))>
			    <#if !isCalendarLayout(nav_item.getLayout().getFriendlyURL(locale)) && !isSurveyLayout(nav_item.getLayout().getFriendlyURL(locale)) && !isTaskLayout(nav_item.getLayout().getFriendlyURL(locale))>
                    <li ${nav_item_attr_selected} class="${nav_item_css_class}" id="layout_${nav_item.getLayoutId()}" role="presentation">
                        <a aria-label="${nav_item.getName()}" ${nav_item_attr_has_popup} href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem">
                            <span>
                                <@liferay_theme["layout-icon"] layout=nav_item_layout />

                                <#if isTrashLayout(nav_item_layout.getFriendlyURL(locale)) >
                                    <span class="icomoon-cestino"></span>
                                <#-- <#elseif isSettingsLayout(nav_item_layout.getFriendlyURL(locale)) >
                                    <span class="icon-cog icon-2x"></span> -->
                                <#elseif isHomeLayout(nav_item_layout.getFriendlyURL(locale)) >
                                    <span class="icomoon-home"></span>
                                <#elseif isDocumentsLayout(nav_item_layout.getFriendlyURL(locale)) >
                                    <span class="icomoon-documenti"></span>
                                <#elseif isWikiLayout(nav_item_layout.getFriendlyURL(locale)) >
                                    <span class="icomoon-wiki"></span>
                                <#elseif isForumLayout(nav_item_layout.getFriendlyURL(locale)) >
                                    <span class="icomoon-forum"></span>
                                <#elseif isTaskLayout(nav_item_layout.getFriendlyURL(locale)) >
                                    <span class="icomoon-task"></span>
                                <#elseif isSurveyLayout(nav_item_layout.getFriendlyURL(locale)) >
                                    <span class="icomoon-survey"></span>
                                <#elseif isSocialSettingsLayout(nav_item_layout.getFriendlyURL(locale)) >
                                    <span class="icomoon-survey"></span>
                              <#--  <#elseif isMembersLayout(nav_item_layout.getFriendlyURL(locale)) >
                                    <span class="icomoon-user"></span> -->
                                <#elseif isCalendarLayout(nav_item_layout.getFriendlyURL(locale)) >
                                    <span class="icomoon-calendario"></span>
                                </#if>
                                ${nav_item.getName()}
                            </span>
                        </a>
                    </li>
                </#if>
			</#if>

				<#if nav_item.hasChildren()>
					<ul class="child-menu" role="menu">
						<#list nav_item.getChildren() as nav_child>
							<#assign
								nav_child_attr_selected = ""
								nav_child_css_class = ""
							/>

							<#if nav_item.isSelected()>
								<#assign
									nav_child_attr_selected = "aria-selected='true'"
									nav_child_css_class = "selected"
								/>
							</#if>

							<li ${nav_child_attr_selected} class="${nav_child_css_class}" id="layout_${nav_child.getLayoutId()}" role="presentation">
								<a aria-label="${nav_child.getName()}" href="${nav_child.getURL()}" ${nav_child.getTarget()} role="menuitem">${nav_child.getName()}</a>
							</li>
						</#list>
					</ul>
				</#if>
			</li>
		</#list>
		<#if is_space_site?has_content >
			<#if is_space_site == true >
				<li class="follow-space-link">
					<@liferay_portlet["runtime"]
						portletProviderAction=portletProviderAction.VIEW
						portletName="it_smc_osportal_sc_subscription_web_portlet_SubscriptionWebPortlet"
					/>
				</li>
			</#if>
		</#if>
	</ul>
</nav>
