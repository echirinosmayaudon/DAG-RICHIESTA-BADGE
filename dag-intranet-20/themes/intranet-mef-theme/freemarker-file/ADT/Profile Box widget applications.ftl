<#assign JournalArticleLocalService = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService")!"">
<#assign layoutLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.LayoutLocalService")>
<#assign groupIdArticle = themeDisplay.getScopeGroupId()>
<#if !getterUtil.getBoolean(userInterno)>
    <#assign userInfo = "Esterno">
<#else>
    <#assign userInfo = "Interno">
</#if>
<div class="bg-image-card-profile">
        <div class="primo-piano-profile-wrap">
          <article>
            <div class="ama-container-fluid">
              <div class="ama-row">
                <div class="ama-col-md-4 pt-50-md pt-30-xs">
                  <#-- portelet Profile -->
                  <@liferay_portlet["runtime"]
                    portletProviderAction=portletProviderAction.VIEW
                    instanceId="profile"
                    portletName="com_intranet_mef_user_profile_portlet_ProfilePortlet" />
                </div>
                <#-- Asset Scrivania -->
                <#assign appProfileItem = 17>
                <#-- hit counter application -->
                <#assign user = themeDisplay.getPermissionChecker().getUser()>
                <#assign userId = user.getUserId()>
                <#assign scrivaniaApplicationService = serviceLocator.findService("autorizzazione.dir.mef.service.ScrivaniaLocalService") />
                <#assign listApplicazioniServiceProfile = scrivaniaApplicationService.getProfileApps(userId?number)>
                <#if !entries?has_content>
                    <#if !themeDisplay.isSignedIn()>
                        ${renderRequest.setAttribute("PORTLET_CONFIGURATOR_VISIBILITY", true)}
                    </#if>
                </#if>
                <#assign itemCount = 1>
                <div class="box-scrivania-wrap width-profile">
                  <div class="ama-row ">
                    <div class="ama-col-md-12">
                      <div class="title-wrapper title-wrapper-desk">
                        <h2 class="title borders visible-xs">LA MIA SCRIVANIA</h2>
                        <span class="borders-second visible-xs"></span>
                        <div id="open-list" class="collapse">
                          <ul class="component-profile">
                            <#list entries as appProfile>
                              <#assign asset = appProfile.getAssetRenderer() />
                              <#assign className = asset.getClassName() />
                                <#if className == "com.liferay.journal.model.JournalArticle" >
                                    <#assign journalArticle = asset.getArticle() />
                                    <#assign document = saxReaderUtil.read(journalArticle.getContent()) />
                                    <#assign rootElement = document.getRootElement() />
                                    <#assign assetEntryPK = appProfile.getClassPK()>
                                    <#assign journalArticleId = JournalArticleLocalService.getLatestArticle(assetEntryPK)>
                                    <#assign journalArticleIdFinal = journalArticleId.getArticleId()>
                                    <#if (listApplicazioniServiceProfile?contains(journalArticleIdFinal)) && (itemCount lte appProfileItem)>
                                      <#assign titoloApplicazione = document.valueOf("//dynamic-element[@name='TitoloApplicazione']/dynamic-content[@language-id='${locale}']/text()") />
                                      <#assign linkInterno = document.valueOf("//dynamic-element[@name='LinkInterno']/dynamic-content[@language-id='${locale}']/text()") />
                                      <#assign linkEsterno = document.valueOf("//dynamic-element[@name='LinkEsterno']/dynamic-content[@language-id='${locale}']/text()") />
                                      <#assign UrlEsterno = document.valueOf("//dynamic-element[@name='URLEsternoMEF']/dynamic-content[@language-id='${locale}']/text()") />
                                      <#assign targetPage = document.valueOf("//dynamic-element[@name='TargetPage']/dynamic-content[@language-id='${locale}']/text()") />
                                      <#assign SeoTitleText = document.valueOf("//dynamic-element[@name='TitleSeoLink']/dynamic-content[@language-id='${locale}']/text()") />
                                      <#assign iconaApplicazione = document.valueOf("//dynamic-element[@name='IconaApplicazione']/dynamic-content[@language-id='${locale}']/text()") />
                                      <#assign linkServicePage = "">
                                      <#if linkInterno != "" >
                                          <#list linkInterno?split("@") as item>
                                          <#if item_index == 0>
                                              <#assign LayOutId = item?number>
                                          </#if>
                                          <#if item_index == 1>
                                              <#if item != "public">
                                              <#assign linkPrivate = true>
                                              <#else>
                                              <#assign linkPrivate = false>
                                              </#if>
                                          </#if>
                                          <#if item_index = 2>
                                              <#assign GroupId = item?number>
                                          </#if>
                                          </#list>
                                          <#assign pageLayout = layoutLocalService.getLayout(GroupId?number, linkPrivate, LayOutId?number) />
                                          <#assign linkServicePage = pageLayout.getFriendlyURL()?remove_beginning("/")>
                                          <#assign targetPage = "_self">
                                      <#else>
                                          <#if userInfo == "Esterno">
                                              <#assign linkServicePage = UrlEsterno>
                                          <#else>
                                              <#assign linkServicePage = linkEsterno>
                                          </#if>
                                      </#if>
                                        <#assign itemCount = itemCount+1/>
                                        <li>
                                            <a target="${targetPage}" href="${linkServicePage}" data-userid="${userId}" data-journalArticleId="${journalArticleIdFinal}" title="${SeoTitleText}" class="widget-white widget-apps click-favourites-service">
                                                <span class="ico-scrivania icomoon-${iconaApplicazione}"></span>
                                                <span>${titoloApplicazione}</span>
                                            </a>
                                        </li>
                                    </#if>
                                </#if>
                            </#list>
                        <li>
                        <a title="PERSONALIZZA" href="${gestioneScrivaniePage}">
                            <span class="ico-scrivania icomoon-settings"></span>
                            <span>PERSONALIZZA</span>
                        </a>
                      </li>
                    </ul>
                  </div>
                  <span class="icomoon-vedi-dark icon-vedi-desk visible-xs collapsed" data-toggle="collapse" data-target="#open-list"></span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      </article>
      </div>
      </div>
