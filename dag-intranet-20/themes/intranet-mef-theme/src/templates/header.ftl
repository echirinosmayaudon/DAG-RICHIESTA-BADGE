<#assign groupId = themeDisplay.getScopeGroupId()>
<#assign groupLocalServiceUtil = serviceLocator.findService("com.liferay.portal.kernel.service.GroupLocalService")>
<#assign group = groupLocalServiceUtil.getGroup(groupId)>
<#assign headerInstanceApplicationIframe = group.getExpandoBridge().getAttribute("header-instance-application-iframe",false)>
<header class="mef-header">
    <div class="top-header">
        <div class="ama-container-fluid">
            <div class="ama-row">
                <div class="ama-col-xs-6 ama-col-md-3">
                    <a class="logo-mef" href="${homeUrl}" title="<@liferay.language_format arguments="HOME" key="go-to-x" />" >
                        <img alt="MEF" class="logo" src="${site_logo}">
                    </a>
                </div>

                <#assign aDateTime = .now?long>
                <div class="hidden-sm hidden-xs ama-col-md-9 top-header-menu">
                   <#if searchPageURL?has_content>
                    <form class="header-search"  id="search_fm" name="search_fm" method="post" action="${searchPageURL}" data-parsley-validate="true">
	               <#else>
                    <form class="header-search" id="search_fm" name="search_fm" method="post" action="" data-parsley-validate="true">
                   </#if>
	                    <div>
	                        <label for="cerca_nel_sito" class="sr-only">Cerca i contenuti e i documenti</label>
	                        <input data-parsley-minlength="3" data-parsley-validation-threshold="3" data-parsley-minlength-message="Inserire almeno 3 caratteri"  id="cerca_nel_sito" type="text" id="_com_liferay_portal_search_web_portlet_SearchPortlet_keywords" name="_com_liferay_portal_search_web_portlet_SearchPortlet_keywords" class="" aria-required="true" placeholder="Cerca i contenuti e i documenti">
	                        <button class="icomoon-search">
                                <span class="sr-only">Avvia la ricerca</span>
                          </button>
	                    </div>

	                    <input class="field form-control" id="_com_liferay_portal_search_web_portlet_SearchPortlet_scope" name="_com_liferay_portal_search_web_portlet_SearchPortlet_scope" type="hidden" value="this-site">
	                    <input type="hidden" value="${s_authToken}" name="p_p_auth">
	                    <input class="field form-control" id="_com_liferay_portal_search_web_portlet_SearchPortlet_formDate" name="_com_liferay_portal_search_web_portlet_SearchPortlet_formDate" type="hidden" value="${aDateTime}">
          						<input name="p_p_id" type="hidden" value="com_liferay_portal_search_web_portlet_SearchPortlet">
          						<input name="p_p_lifecycle" type="hidden" value="0">
          						<input name="p_p_state" type="hidden" value="maximized">
          						<input name="p_p_mode" type="hidden" value="view">
          						<input name="_com_liferay_portal_search_web_portlet_SearchPortlet_mvcPath" type="hidden" value="/search.jsp">
          						<input class="field form-control" id="_com_liferay_portal_search_web_portlet_SearchPortlet_cur" name="_com_liferay_portal_search_web_portlet_SearchPortlet_cur" type="hidden" value="1">
          						<input class="field form-control" id="_com_liferay_portal_search_web_portlet_SearchPortlet_format" name="_com_liferay_portal_search_web_portlet_SearchPortlet_format" type="hidden" value="">
                    </form>
                    <ul class="widgets-header-wrap">
                        <li>
                          <a id="btnWidgetApp" title="Widget Applicazioni" data-overlay="overlayWidgetApps" class="icomoon-apps">
                            <span class="sr-only">Applicazioni</span>
                          </a>
                          <#--
                          <#assign VOID = freeMarkerPortletPreferences.setValue("displayStyleGroupId", themeDisplay.getCompanyGroupId()?string)>
                          <#assign VOID = freeMarkerPortletPreferences.setValue("displayStyle", "ddmTemplate_100602")>
                            <@liferay_portlet["runtime"]
                              defaultPreferences="${freeMarkerPortletPreferences}"
                              instanceId="application-service-widget"
                              portletProviderAction=portletProviderAction.VIEW
                              portletProviderClassName="com.liferay.asset.kernel.model.AssetEntry"
                            />
                            <#assign VOID = freeMarkerPortletPreferences.reset()>
                            -->
                            <div id="overlayWidgetApps" class="overlay-widget animated fadeIn hide">
                              <div class="ama-container-fluid">
                                <div class="ama-row wrap-title-widget">
                                  <div class="ama-col-xs-12">
                                    <h3 class="title-overlay">Le mie applicazioni più utilizzate</h3>
                                  </div>
                                </div>
                                <div class="ama-row wrap-box-widget">
                                  <#if headerInstanceApplicationIframe != "">
                                    <#assign headerAppIframe = headerInstanceApplicationIframe>
                                    <input type="hidden" id="appIframe" value="${headerAppIframe}" />
                                    <iframe class="widget-application-instance" src="" id="widget-application-instance" title="widget Application Instance" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe>
                                  <#else>
                                    <div class="ama-col-md-3">
                                      <a href="${applicationManagementPage}" class="widget-blue widget-apps">
                                          <p class="widget-title">VEDI TUTTO</p>
                                          <span class="ico-vai icomoon-vai"></span>
                                      </a>
                                    </div>
                                  </#if>
                                </div>
                              </div>
                            </div>
                        </li>
                        <#--
                        <li>
                          <a id="btnWidgetNotification" title="Widget Notifiche" data-overlay="overlayWidgetNotification" class="icomoon-notification">
                              <span class="sr-only">Notifiche</span>
                              <#if validator.isNotNull(socialNotificationCount)>
                                <span class="notification-item">${socialNotificationCount}</span>
                              </#if>
                          </a>
                          <div id="overlayWidgetNotification" class="overlay-widget animated fadeIn hide">
                          <@liferay_portlet["runtime"]
                            portletProviderAction=portletProviderAction.VIEW
                            instanceId="notification-widget"
                            portletName="com_intranet_mef_conjuction_master_notification_INSTANCE" />
                          </div>
                        </li>
                        -->
                        <li>
                            <a id="btnWidgetFavourites" title="Widget Preferiti" data-overlay="overlayWidgetFavourites" class="icomoon-favourites">
                                <span class="sr-only">Preferiti</span>
                            </a>
                            <!-- Inserimento web content Bookmark-widget-->
                            <#assign nameBookmarkwidgetWC = "bookmark-widget">
                            <#assign bookmarkWidgetContent = JournalArticleLocalService.fetchLatestArticleByUrlTitle(themeDisplay.getScopeGroupId(),nameBookmarkwidgetWC, 0)!"">
                            <#if bookmarkWidgetContent == "">
                            	<#assign nameBookmarkwidgetWC = "${nameBookmarkwidgetWC}-private">
                            	<#assign bookmarkWidgetContent = JournalArticleLocalService.fetchLatestArticleByUrlTitle(themeDisplay.getScopeGroupId(),nameBookmarkwidgetWC, 0)!"">
                            </#if>
                            <#if bookmarkWidgetContent != "">
                            	<#assign VOID = freeMarkerPortletPreferences.setValue("articleId", bookmarkWidgetContent.getArticleId() + "") />
                            	<@liferay_portlet["runtime"]
                            	defaultPreferences="${freeMarkerPortletPreferences}"
                            	portletProviderAction=portletProviderAction.VIEW
                            	instanceId="bookmark-widget"
                            	portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet" />
                              <#assign VOID = freeMarkerPortletPreferences.reset()>
                            </#if>
                            <!-- Inserimento web content Bookmark-widget END-->
                        </li>
                        <li class="service-assistance">
                          <!-- Inserimento web content Servizio Form Assistenza -->
                          <#assign serviceAssistanceWCname = "service-assistance">
                          <#assign serviceAssistanceWC = JournalArticleLocalService.fetchLatestArticleByUrlTitle(themeDisplay.getScopeGroupId(),serviceAssistanceWCname, 0)!"">
                          <#if serviceAssistanceWC == "">
                            <#assign serviceAssistanceWCname = "${serviceAssistanceWCname}-private">
                            <#assign serviceAssistanceWC = JournalArticleLocalService.fetchLatestArticleByUrlTitle(themeDisplay.getScopeGroupId(),serviceAssistanceWCname, 0)!"">
                          </#if>
                          <#if serviceAssistanceWC != "">
                            <#assign VOID = freeMarkerPortletPreferences.setValue("articleId", serviceAssistanceWC.getArticleId() + "") />
                            <@liferay_portlet["runtime"]
                            defaultPreferences="${freeMarkerPortletPreferences}"
                            portletProviderAction=portletProviderAction.VIEW
                            instanceId="service-assistance"
                            portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet" />
                            <#assign VOID = freeMarkerPortletPreferences.reset()>
                          </#if>
                           <!-- Inserimento web content Servizio Form Assistenza END-->
                        </li>
                    </ul>
                </div>
                <div class="visible-xs visible-sm ama-col-xs-6 wrap-buttons-header">
                    <button type="button" class="hamburger-menu js-hamburger-menu">
                        <span class="ico-hamburger">
                            <span class="hamburger-bar"></span>
                        </span>
                    </button>
                    <button type="button" class="btn-search-mobile js-search-menu">
                        <span class="icomoon-search">
                        </span>
                    </button>
                </div>
            </div>
        </div>
    </div>
    <div class="search-wrap-mobile hide" aria-hidden="true">
      <#if searchPageURL?has_content>
       <form id="search_fm_mobile" name="search_fm_mobile" method="post" action="${searchPageURL}" data-parsley-validate="true">
    <#else>
       <form id="search_fm_mobile" name="search_fm_mobile" method="post" action="" data-parsley-validate="true">
      </#if>
            <div>
              <label for="cerca_nel_sito_mobile" class="sr-only">Cerca i contenuti e i documenti</label>
              <input data-parsley-required="true" data-parsley-minlength="3" data-parsley-validation-threshold="3" data-parsley-error-message="Inserire almeno 3 caratteri"  id="cerca_nel_sito" type="text" id="_com_liferay_portal_search_web_portlet_SearchPortlet_keywords" name="_com_liferay_portal_search_web_portlet_SearchPortlet_keywords" class="input-search" aria-required="true" placeholder="Cerca i contenuti e i documenti">
              <button class="btn-go-search icomoon-vai">
                  <span class="sr-only">Avvia la ricerca</span>
              </button>
            </div>
            <input class="field form-control" id="_com_liferay_portal_search_web_portlet_SearchPortlet_scope" name="_com_liferay_portal_search_web_portlet_SearchPortlet_scope" type="hidden" value="this-site">
            <input type="hidden" value="${s_authToken}" name="p_p_auth">
            <input class="field form-control" id="_com_liferay_portal_search_web_portlet_SearchPortlet_formDate" name="_com_liferay_portal_search_web_portlet_SearchPortlet_formDate" type="hidden" value="${aDateTime}">
            <input name="p_p_id" type="hidden" value="com_liferay_portal_search_web_portlet_SearchPortlet">
            <input name="p_p_lifecycle" type="hidden" value="0">
            <input name="p_p_state" type="hidden" value="maximized">
            <input name="p_p_mode" type="hidden" value="view">
            <input name="_com_liferay_portal_search_web_portlet_SearchPortlet_mvcPath" type="hidden" value="/search.jsp">
            <input class="field form-control" id="_com_liferay_portal_search_web_portlet_SearchPortlet_cur" name="_com_liferay_portal_search_web_portlet_SearchPortlet_cur" type="hidden" value="1">
            <input class="field form-control" id="_com_liferay_portal_search_web_portlet_SearchPortlet_format" name="_com_liferay_portal_search_web_portlet_SearchPortlet_format" type="hidden" value="">
        </form>
    </div>
    <#if is_setup_complete>
        <#include "${full_templates_path}/navigation.ftl" />
    </#if>
    <div id="overlay-megamenu" class="overlay-megamenu"></div>
</header>
<div id="modal-add-bookmarks" class="modal modal-custom fade modal-icon-page" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <div class="modal-title-box">
                    <a href="#" class="icomoon-close-white" data-dismiss="modal"></a>
                    <div class="title-modal">
                        <h2 class="title">AGGIUNGI AI PREFERITI
                        </h2>
                    </div>
                </div>
                <h2 class="text">La pagina è stata aggiunta ai preferiti con successo!
                </h2>
                <div class="ama-row mb-50-xs buttons-bottom">
                    <div class="ama-col-xs-12 ama-col-sm-12">
                        <button class="button button-primary" data-dismiss="modal">CONFERMA</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="modal-remove-bookmarks" class="modal modal-custom fade modal-icon-page" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <div class="modal-title-box">
                    <a href="#" class="icomoon-close-white" data-dismiss="modal"></a>
                    <div class="title-modal">
                        <h2 class="title">RIMUOVI DAI PREFERITI
                        </h2>
                    </div>
                </div>
                <h2 class="text">Sei sicuro di voler rimuovere la pagina dalla lista dei preferiti?
                </h2>
                <div class="ama-row mb-50-xs buttons-bottom">
                    <div class="ama-col-xs-12 ama-col-sm-6">
                        <button id="btn-remove-bookmarks-ko" class="button button-secondary" data-dismiss="modal">ANNULLA</button>
                    </div>
                    <div class="ama-col-xs-12 ama-col-sm-6">
                        <button id="btn-remove-bookmarks-ok" class="button button-primary">CONFERMA</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="modal-bookmarks-edit" class="modal modal-custom fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <div class="modal-title-box">
                    <a href="#" class="icomoon-close-white" data-dismiss="modal"></a>
                    <div class="title-modal">
                        <h2 class="title">AGGIUNGI AI PREFERITI</h2>
                    </div>
                </div>
                <div class="modal-form-box">
                    <div class="form-bookmarks">
                        <label for="bookmark-url">URL</label>
                        <input type="text" id="bookmark-url" class="modal-input">
                        <p id="error-bookmark-url" class="bookmark-error-message">Campo obbligatorio</p>
                        <label for="bookmark-name">NOME</label>
                        <input type="text" maxlength="50" id="bookmark-name" class="modal-input">
                        <p id="error-bookmark-name" class="bookmark-error-message">Campo obbligatorio</p>
                        <div class="buttons-wrap">
                            <button data-dismiss="modal" class="button button-secondary">ANNULLA</button>
                            <button id="bookmark-save-edit" class="button button-primary modal-apply">AGGIUNGI</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
