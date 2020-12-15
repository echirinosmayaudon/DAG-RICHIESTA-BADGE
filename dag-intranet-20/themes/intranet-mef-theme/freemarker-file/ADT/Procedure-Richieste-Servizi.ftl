<#-- Category and Vovabolary services -->
<#assign catService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetCategoryService")>
<#assign vocService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetVocabularyLocalService")>
<#assign propCatService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetCategoryPropertyLocalService")>
<#assign queryUtil = staticUtil["com.liferay.portal.kernel.dao.orm.QueryUtil"]>
<#assign vocabulary = vocService.getGroupVocabulary(themeDisplay.getScopeGroupId(), "Richieste e Servizi")>
<#assign vocID = vocabulary.getVocabularyId()>
<#assign catEntries = catService.getVocabularyCategories(vocID,queryUtil.ALL_POS,queryUtil.ALL_POS,null)>
<#assign CategoryServiceArray=[]>
<#list catEntries as category>
    <#assign CategoryServiceArray=CategoryServiceArray+ [category.getCategoryId()]>
</#list>
<div class="pl-25-sm pl-0-xs ama-row servizi-richiesta-wrapper">
    <div class="ama-col-md-12 ama-col-xs-12">
        <h2 aria-label="Sezione Moduli" class="wrap-title mb-25-xs mt-30-xs">PROCEDURE</h2>
    </div>
    <div class="attachments-generic-container mt-0-xs">
        <#if entries?has_content>
            <#list entries as curEntry>
                <#list curEntry.getCategories() as category>
                    <#assign categoryId = category.getCategoryId()>
                    <#if CategoryServiceArray?seq_contains(categoryId)>
                        <#assign docXml = saxReaderUtil.read(curEntry.getAssetRenderer().getArticle().getContent()) />
                        <#assign title = docXml.valueOf("//dynamic-element[@name='TitoloProcedura']/dynamic-content[@language-id='${locale}']/text()") />
                        <#assign description = docXml.valueOf("//dynamic-element[@name='Descrizione']/dynamic-content[@language-id='${locale}']/text()") />
                        <#assign linkInterno = docXml.valueOf("//dynamic-element[@name='Link']/dynamic-content[@language-id='${locale}']/text()") />
                        <#assign groupId = themeDisplay.getLayout().getGroupId()>
                        <#assign layoutLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.LayoutLocalService")>
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
                        <div class="ama-col-md-4 ama-col-sm-4 ama-col-xs-12 hidden animated fadeIn" data-category="${categoryId}">
                            <a  href="${linkServicePage}" title="${curEntry.getTitle(locale)}" aria-label="${curEntry.getTitle(locale)}" class="box-info mb-20-xs">
                                <span class="title-info mb-15-xs dot-point dot-50 dot-mobile">
                                    ${title}
                                </span>
                                <p class="dot-point dot-mobile dot-80">
                                    ${description}
                                </p>
                            </a>
                        </div>
                    </#if>
                </#list>
            </#list>
        </#if> 
    </div>
</div>

<script>
    $(document).ready(function(){
        if($('.servizi-richiesta-wrapper').length > 0 ){
            function hideOrShowTitle(){
                $('.wrap-title').each(function(){
                    var show = false;
                    $(this).parent().parent().find('.attachments-generic-container').find('[data-category]').each(function(){
                        if(!$(this).hasClass('hidden')) {
                            show = true;
                        }
                    })
                    if(show) {
                        $(this).removeClass('hidden');
                    } else {
                        $(this).addClass('hidden');
                    }
                })
            }
            hideOrShowTitle();
            $('.servizio-richiesta-button[data-category-wrapper]').on('click',function(){
                $('.servizi-richiesta-wrapper [data-category]').addClass('hidden');
                if(!$(this).hasClass('active')){
                    var id = $(this).attr('data-category-wrapper');
                    $('.servizi-richiesta-wrapper [data-category]').each(function(){
                        if($(this).attr('data-category') == id) {

                            $(this).removeClass('hidden');
                        }
                    })
                }
                hideOrShowTitle();
            })
        }
    })
</script>