<#assign DLFileEntryLocalService = serviceLocator.findService("com.liferay.document.library.kernel.service.DLFileEntryLocalService")/>
<#assign layoutLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.LayoutLocalService")>
<#-- Category and Vovabolary services -->
<#assign catService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetCategoryService")>
<#assign vocService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetVocabularyLocalService")>
<#assign propCatService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetCategoryPropertyLocalService")>
<#assign queryUtil = staticUtil["com.liferay.portal.kernel.dao.orm.QueryUtil"]>



<#assign vocabularyService = vocService.getGroupVocabulary(themeDisplay.getScopeGroupId(), "Richieste e Servizi")>
<#assign vocvocabularyServiceID = vocabularyService.getVocabularyId()>
<#assign catServiceEntries = catService.getVocabularyCategories(vocvocabularyServiceID,queryUtil.ALL_POS,queryUtil.ALL_POS,null)>
<#assign CategoryServiceArray=[]>
<#list catServiceEntries as category>
    <#assign CategoryServiceArray=CategoryServiceArray+ [category.getCategoryId()]>
</#list>

<#-- Category and Vovabolary services Applicazioni-->

<#assign DLfolderService = serviceLocator.findService("com.liferay.document.library.kernel.service.DLFolderLocalService")>
<#assign DLfileService = serviceLocator.findService("com.liferay.document.library.kernel.service.DLFileEntryLocalService")>
<#assign vocabulary = vocService.getGroupVocabulary(themeDisplay.getScopeGroupId(), "Applicazioni")>
<#assign vocID = vocabulary.getVocabularyId()>
<#assign catEntries = catService.getVocabularyCategories(vocID,queryUtil.ALL_POS,queryUtil.ALL_POS,null)>
<#assign groupId = themeDisplay.getLayout().getGroupId()>
<#assign journalArticleLocalService = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService") />
<#assign applicazioniServiziService = serviceLocator.findService("autorizzazione.dir.mef.service.AutorizzazioneDirLocalService") />
<#assign user = themeDisplay.getPermissionChecker().getUser()>
<#assign userId = user.getUserId()>

<#-- setting Autorizzazione Diretta fields-->
<#assign codiceFiscale = user.getScreenName()>
<#assign codiceFiscaleAuthorized = codiceFiscale?upper_case>
<#assign idOrgChart = user.getExpandoBridge().getAttribute("idOrgChart")>
<#assign organizzazioneService = serviceLocator.findService("com.intranet.mef.job.siap.service.OrganizationChartLocalService")>
<#if idOrgChart ==''>
    <#assign idOrgChart = 847>
</#if>
<#assign Organizzazione = organizzazioneService.getOrganizationChart(idOrgChart?number)>
<#assign levelUser = Organizzazione.getLevel()>
<#if levelUser == 1>
	<#assign mefAuthorized = Organizzazione.getIdOrgChart()>
	<#assign dipartimentoAuthorized = 0>
	<#assign direzioneAuthorized = 0>
	<#assign ufficioAuthorized = 0>
<#elseif levelUser == 2>
    <#assign mefOrg = Organizzazione.getIdParent()>
    <#assign OrganizzazioneMEF = organizzazioneService.getOrganizationChart(mefOrg?number)>
    <#assign mefAuthorized = OrganizzazioneMEF.getIdOrgChart()>
    <#assign dipartimentoAuthorized = Organizzazione.getIdOrgChart()>
    <#assign direzioneAuthorized = 0>
    <#assign ufficioAuthorized = 0>
<#elseif levelUser == 3>
    <#assign dipOrg = Organizzazione.getIdParent()>
    <#assign OrganizzazioneDip = organizzazioneService.getOrganizationChart(dipOrg?number)>
    <#assign mefOrg = OrganizzazioneDip.getIdParent()>
    <#assign OrganizzazioneMEF = organizzazioneService.getOrganizationChart(mefOrg?number)>
    <#assign mefAuthorized = OrganizzazioneMEF.getIdOrgChart()>
    <#assign dipartimentoAuthorized = OrganizzazioneDip.getIdOrgChart()>
    <#assign direzioneAuthorized = Organizzazione.getIdOrgChart()>
    <#assign ufficioAuthorized = 0>
<#elseif levelUser == 4>
    <#assign dirOrg = Organizzazione.getIdParent()>
    <#assign OrganizzazioneDir = organizzazioneService.getOrganizationChart(dirOrg?number)>
    <#assign dipOrg = OrganizzazioneDir.getIdParent()>
    <#assign OrganizzazioneDip = organizzazioneService.getOrganizationChart(dipOrg?number)>
    <#assign mefOrg = OrganizzazioneDip.getIdParent()>
    <#assign OrganizzazioneMEF = organizzazioneService.getOrganizationChart(mefOrg?number)>
    <#assign mefAuthorized = OrganizzazioneMEF.getIdOrgChart()>
    <#assign dipartimentoAuthorized = OrganizzazioneDip.getIdOrgChart()>
    <#assign direzioneAuthorized = OrganizzazioneDir.getIdOrgChart()>
    <#assign ufficioAuthorized = Organizzazione.getIdOrgChart()>
<#elseif levelUser == 5>
	<#assign ufficioAuthorized = Organizzazione.getIdParent()>
	<#assign ufficio = organizzazioneService.getOrganizationChart(ufficioAuthorized?number)>
	<#assign dirOrg = ufficio.getIdParent()>
	<#assign OrganizzazioneDir = organizzazioneService.getOrganizationChart(dirOrg?number)>
	<#assign dipOrg = OrganizzazioneDir.getIdParent()>
	<#assign OrganizzazioneDip = organizzazioneService.getOrganizationChart(dipOrg?number)>
	<#assign mefOrg = OrganizzazioneDip.getIdParent()>
	<#assign OrganizzazioneMEF = organizzazioneService.getOrganizationChart(mefOrg?number)>
	<#assign mefAuthorized = OrganizzazioneMEF.getIdOrgChart()>
	<#assign dipartimentoAuthorized = OrganizzazioneDip.getIdOrgChart()>
	<#assign direzioneAuthorized = OrganizzazioneDir.getIdOrgChart()>
</#if>
<#if !entries?has_content>
	<#if !themeDisplay.isSignedIn()>
		${renderRequest.setAttribute("PORTLET_CONFIGURATOR_VISIBILITY", true)}
	</#if>
</#if>










<div class="pl-25-sm pl-0-xs ama-row servizi-richiesta-wrapper">
    <div class="ama-col-md-12 ama-col-xs-12">
        <h2 aria-label="Sezione Moduli" class="wrap-title mb-25-xs mt-30-xs">RICHIESTE ONLINE</h2>
    </div>
    <div class="attachments-generic-container mt-0-xs">
        <#if entries?has_content>
            <#list entries as curEntry>
                <#list curEntry.getCategories() as category>
                    <#assign categoryId = category.getCategoryId()>
                    <#if CategoryServiceArray?seq_contains(categoryId)>
                        <#assign asset = curEntry.getAssetRenderer() />
                        <#assign className = asset.getClassName() />
                        <#if className == "com.liferay.journal.model.JournalArticle" >
                            <#assign journalArticle = asset.getArticle() />
                            <#assign document = saxReaderUtil.read(journalArticle.getContent()) />
                            <#assign rootElement = document.getRootElement() />
                            <#assign titoloApplicazione = document.valueOf("//dynamic-element[@name='TitoloApplicazione']/dynamic-content[@language-id='${locale}']/text()") />
                            <#assign iconaApplicazione = document.valueOf("//dynamic-element[@name='IconaApplicazione']/dynamic-content[@language-id='${locale}']/text()") />
                            <#assign linkInterno = document.valueOf("//dynamic-element[@name='LinkInterno']/dynamic-content[@language-id='${locale}']/text()") />
                            <#assign linkEsterno = document.valueOf("//dynamic-element[@name='LinkEsterno']/dynamic-content[@language-id='${locale}']/text()") />
                            <#assign targetPage = document.valueOf("//dynamic-element[@name='TargetPage']/dynamic-content[@language-id='${locale}']/text()") />
                            <#assign SeoTitleText = document.valueOf("//dynamic-element[@name='TitleSeoLink']/dynamic-content[@language-id='${locale}']/text()") />
                            <#assign catalogoBoolean = document.valueOf("//dynamic-element[@name='Catalogo']/dynamic-content[@language-id='${locale}']/text()") />
                            <#assign privato = document.valueOf("//dynamic-element[@name='Privato']/dynamic-content[@language-id='${locale}']/text()") />
                            <#assign autorizzazioneDiretta = document.valueOf("//dynamic-element[@name='AutorizzazioneDiretta']/dynamic-content[@language-id='${locale}']/text()") />
                            <#assign entryCauName = document.valueOf("//dynamic-element[@name='CauName']/dynamic-content[@language-id='${locale}']/text()") />
                            <#assign entryObjClassName = document.valueOf("//dynamic-element[@name='ObjClassName']/dynamic-content[@language-id='${locale}']/text()") />
                            <#assign assetEntryPK = curEntry.getClassPK()>
                            <#assign journalArticleId = journalArticleLocalService.getLatestArticle(assetEntryPK)>
                            <#assign journalArticleIdFinal = journalArticleId.getArticleId()>
                            <#assign journalArticlePrimaryKey = journalArticleId.getId()>
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
                                <#assign linkServicePage = linkEsterno>
                            </#if>
                            <#assign displayApp = "false">
                            <#if catalogoBoolean == '["catalogo_si"]' && !getterUtil.getBoolean(privato)>
                            <#assign displayApp = "true">
                            <#elseif getterUtil.getBoolean(privato) && catalogoBoolean == '["catalogo_si"]'>
                                <#assign cauName = user.getExpandoBridge().getAttribute("cau-name")>
                                <#assign objectClassName = user.getExpandoBridge().getAttribute("obj-class-name")>
                                <#if objectClassName!= ''>
                                    <#list objectClassName?split(";") as singleList>
                                        <#assign singleResult = singleList?lower_case>
                                        <#if (singleResult == entryObjClassName?lower_case)>
                                            <#assign displayApp = "true">
                                        </#if>
                                    </#list>
                                </#if>
                                <#if !getterUtil.getBoolean(displayApp)>
                                    <#if cauName!= ''>
                                        <#list cauName?split(";") as singleList>
                                            <#assign singleResult = singleList?lower_case>
                                            <#if (singleResult == entryCauName?lower_case)>
                                                <#assign displayApp = "true">
                                            </#if>
                                        </#list>
                                    </#if>
                                </#if>
                                <#if !getterUtil.getBoolean(displayApp)>
                                    <#if getterUtil.getBoolean(autorizzazioneDiretta)>
                                        <#assign isVisible = applicazioniServiziService.isAuthorized(journalArticleIdFinal?number,mefAuthorized?number,dipartimentoAuthorized?number,direzioneAuthorized?number,ufficioAuthorized?number,codiceFiscaleAuthorized)>
                                        <#if getterUtil.getBoolean(isVisible)>
                                            <#assign displayApp = "true">
                                        </#if>
                                    </#if>
                                </#if>
                            </#if>
                            <#if getterUtil.getBoolean(displayApp)>
                                <div class="ama-col-md-4 ama-col-sm-4 ama-col-xs-12 hidden animated fadeIn richieste-online-box" data-category="${categoryId}">
                                    <div class="box-info mb-20-xs">
                                        <a data-userid="${userId}" data-primarykey="${journalArticlePrimaryKey}" data-journalArticleId="${journalArticleIdFinal}" href="${linkServicePage}" target="${targetPage}" title="${SeoTitleText}" class="click-favourites-service">
                                            <span class="title-info dot-point dot-60 dot-mobile mb-15-xs">
                                                ${titoloApplicazione}
                                            </span>
                                            <p class="dot-point dot-mobile dot-80">
                                                ${curEntry.getDescription(locale)}
                                            </p>
                                        </a>
                                        <div class="tags-container">
                                            <div class="tags-for-modal">
                                                <#assign tagCounter = 0 />
                                                <#list curEntry.getTags() as tag>
                                                    <#assign tagCounter =  tagCounter  +1 />
                                                    <#if ( tagCounter > 1)>
                                                        <div class="tag hidden text-uppercase" data-tag-text="${tag.name}">${tag.name}</div>
                                                    <#else>
                                                        <div class="tag js-length-check text-uppercase" data-tag-text="${tag.name}">${tag.name}</div>
                                                    </#if>
                                                </#list>
                                            </div>
                                            <button type="button" title="Vedi altri tag" data-toggle="modal" data-target="#modal-application-tags" class="tags-more-modal hidden">...</button>
                                        </div>
                                    </div>
                                </div>
                            </#if>
                        </#if>
                    </#if>
                </#list>
            </#list>
            <div id="modal-application-tags" class="modal modal-custom fade modal-application-tags" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-body">
                            <div class="modal-title-box">
                                <a href="#" class="icomoon-close-white" data-dismiss="modal"></a>
            
                                <div class="title-modal">
                                    <h2 class="title">TAG</h2>
                                </div>
                            </div>
                            <div class="tags-container">
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </#if>
    </div>
</div>
<script>
if($('.servizi-richiesta-wrapper .richieste-online-box').length > 0) {
    function truncateText (maxChar, elem){
        var textNew;
        var nCharOut;
        var textLength = elem.attr('data-tag-text').length;
        if( textLength > maxChar) {
            elem.addClass('js-truncated');
            nCharOut = textLength - maxChar;
            textNew = elem.attr('data-tag-text');
            textNew = textNew.substring(0, textNew.length-(nCharOut+2));
            elem.text(textNew+"..");
        }
    }
    var breakPointPrev = '';
    var breakPointNow = '';
    
    function checkTextTruncate(){
        $('.js-length-check').each(function(){
            // Media query JS
            if($(window).width() >= 1200) {
                //Desktop Min
                truncateText(23, $(this));
            } else if($(window).width() >= 992) {
                //MD min
                truncateText(18, $(this));
            } else if ($(window).width() >= 768) {
                //Tablet min
                truncateText(18, $(this));
            } else if ($(window).width() >= 320) {
                //Mobile min
                truncateText(28, $(this));
            }
        })
    }

    function checkBreakPoint() {
        if($(window).width() >= 1200) {
            //Desktop Min
            return 'desktop';
        } else if($(window).width() >= 992) {
            //MD min
            return 'md';
        } else if ($(window).width() >= 768) {
            //Tablet min
            return 'tablet';
        } else if ($(window).width() >= 320) {
            //Mobile min
            return 'mobile';
        }
    }

    checkTextTruncate();
    breakPointPrev = checkBreakPoint();

    $(window).resize(function(){
        breakPointNow = checkBreakPoint();
        if (breakPointNow != breakPointPrev){
            breakPointPrev = breakPointNow;
            checkTextTruncate();
        }
    })

    // Check if enable or not the modal button --> ENABLED if tags > 2 or there is one or more .js-truncated
    $('.tags-for-modal').each(function(){
        if($(this).find('.tag').length > 1 || $(this).find('.js-truncated').length > 0) {
            $(this).parent().find('.tags-more-modal').removeClass('hidden');
        }
    })
    $('.tags-more-modal').on('click',function(){
        var htmlContent = $(this).parent().find('.tags-for-modal').html();
        $('.modal-application-tags .tags-container').html(htmlContent);
        $('.modal-application-tags .tags-container .tag').each(function(){
            $(this).text($(this).attr('data-tag-text'));
        })
        $('.modal-application-tags .tags-container .tag').removeClass("hidden");
        $('.modal-application-tags .tags-container .tag').removeClass("js-length-check");
    })
}

</script>