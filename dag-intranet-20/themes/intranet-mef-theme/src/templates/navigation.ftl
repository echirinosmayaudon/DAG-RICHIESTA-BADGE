<div class="main-nav-fixed">
    <div class="bottom-header">
        <div class="ama-container-fluid">
          <!-- Inserimento web content quick-link-mobile -->
          <#assign quickLinkWCname = "quick-link-mobile">
          <#assign quickLinkWC = JournalArticleLocalService.fetchLatestArticleByUrlTitle(themeDisplay.getScopeGroupId(),quickLinkWCname, 0)!"">
          <#if quickLinkWC == "">
            <#assign quickLinkWCname = "${quickLinkWCname}-private">
            <#assign quickLinkWC = JournalArticleLocalService.fetchLatestArticleByUrlTitle(themeDisplay.getScopeGroupId(),quickLinkWCname, 0)!"">
          </#if>
          <#if quickLinkWC != "">
            <#assign VOID = freeMarkerPortletPreferences.setValue("articleId", quickLinkWC.getArticleId() + "") />
            <@liferay_portlet["runtime"]
            defaultPreferences="${freeMarkerPortletPreferences}"
            portletProviderAction=portletProviderAction.VIEW
            instanceId="quick-link-mobile"
            portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet" />
            <#assign VOID = freeMarkerPortletPreferences.reset()>
          </#if>
           <!-- Inserimento web content quick-link-mobile END-->
            <div class="col-main-nav">
                <!--///// START NAVBAR /////-->
              <#if  has_navigation >
                <div class="main-navigation nav-desktop">
                    <div class="wrap-menu-mobile-right">

                        <div class="first-level wrap-level">
                            <div class="wrap-tablet">
                                <ul class="list-main-nav">
                                  <#assign countNav = 1/>
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
                                				nav_item_attr_selected = ""
                                				nav_item_css_class = "active"
                                			/>
                                		</#if>

                                    <li class="item-with-submenu"><a class="main-nav-first-level" href="${nav_item.getURL()}">
                                      <span class="ico-item-${countNav}"></span> ${nav_item.getName()}<span class="icon-stage_right"></span></a>
                                      <#if nav_item.hasChildren()>
                                        <div class="main-nav-sub-menu second-level wrap-level">
                                            <div class="box-go-section">
                                                <div class="ico-section ico-item-${countNav}"></div>
                                                <a href="${nav_item.getURL()}">VAI ALLA SEZIONE</a>
                                            </div>
                                            <div class="container-grid">
                                                <a href="#" class="btn-back-level js-btn-back-level"> <span class="icon-stage_left">
                                                  <span class="ico-item-${countNav}"></span> ${nav_item.getName()}</span></a>
                                                <div class="row-container">

                                                  <#list nav_item.getChildren() as nav_child>
                                                    <#assign
                                                      nav_child_attr_selected = ""
                                                      nav_child_css_class = ""
                                                    />

                                                    <#if nav_child.isSelected()>
                                                      <#assign
                                                        nav_child_attr_selected = "aria-selected='true'"
                                                        nav_child_css_class = "active"
                                                      />
                                                    </#if>

                                                    <div class="second-menu">
                                                        <div class="second-menu-link">
                                                            <a href="${nav_child.getURL()}" class="link-page">
                                                                <p class="typo-nav-second-level">${nav_child.getName()}</p>
                                                                <#if nav_child.hasChildren()>
                                                                    <span class="link-third-level"> <span class="icon-stage_right"> </span></span>
                                                                </#if>
                                                            </a>

                                                        </div>
                                                        <#if nav_child.hasChildren()>
                                                            <div class="third-level wrap-level">
                                                                <div class="container-third-level">
                                                                    <a href="#" class="btn-back-level js-btn-back-level"> <span class="icon-stage_left">${nav_child.getName()}</span></a>
                                                                    <div class="third-menu">
                                                                        <ul>
                                                                             <#list nav_child.getChildren() as nav_third_child>
                                                                                <li><a class="typo-nav-third-level" href="${nav_third_child.getURL()}">${nav_third_child.getName()}</a></li>
                                                                             </#list>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </#if>
                                                    </div>
                                                  </#list>

                                                </div>
                                            </div>
                                        </div>
                                        </#if>
                                    </li>
                                    <#assign countNav++>
                                  </#list>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                </#if>
                <!--///// END NAVBAR /////-->
            </div>

	        <#if themeDisplay.isSignedIn()>
            <#assign nameLinkToMyDeskWC = "linktomydesk">
            <#assign linkToMyDeskContent = JournalArticleLocalService.fetchLatestArticleByUrlTitle(themeDisplay.getScopeGroupId(),nameLinkToMyDeskWC, 0)!"">
            <#if linkToMyDeskContent == "">
            	<#assign nameLinkToMyDeskWC = "${nameLinkToMyDeskWC}-private">
            	<#assign linkToMyDeskContent = JournalArticleLocalService.fetchLatestArticleByUrlTitle(themeDisplay.getScopeGroupId(),nameLinkToMyDeskWC, 0)!"">
            </#if>

            <#if linkToMyDeskContent != "">
            	<#assign VOID = freeMarkerPortletPreferences.setValue("articleId", linkToMyDeskContent.getArticleId() + "") />
            <@liferay_portlet["runtime"]
            	defaultPreferences="${freeMarkerPortletPreferences}"
            	portletProviderAction=portletProviderAction.VIEW
            	instanceId="link-to-my-desk"
            	portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet" />
              <#assign VOID = freeMarkerPortletPreferences.reset()>
            </#if>

            </#if>
        </div>
    </div>
</div>
