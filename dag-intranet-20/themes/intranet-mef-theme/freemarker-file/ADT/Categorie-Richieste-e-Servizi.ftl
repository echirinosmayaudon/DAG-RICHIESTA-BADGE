<#if entries?has_content>
    <#list entries as curVocabulary>

        <div class="pl-25-sm pl-0-xs mt-50-xs ama-row servizi-richiesta-wrapper">
            <#list curVocabulary.getCategories() as curCat>
                <#assign categoryName = curCat.getName()>
                <#assign categoryDescription = curCat.getDescription(locale)>
                <#assign categoryId = curCat.getCategoryId()>
                <div class="ama-col-md-4 ama-col-sm-4 ama-col-xs-12 button-wrapper align-text">
    		        <div class="container-button no-width">
    		        <a class="servizio-richiesta-button box-richieste-servizi" title="${categoryDescription?lower_case}" aria-label="${categoryDescription?lower_case}"data-category-wrapper="${categoryId}">
    		            <div class="icon-button tab-servizi">
    		                <#if categoryDescription!= "">
    		                <span class="icon-text icomoon-categoria-${categoryDescription?lower_case}"></span>
    		                <#else>
    		                    <span class="icon-text icomoon-settings"></span>
    		                </#if>
    		            </div>
    		            <div class="text-button ml-0-xs ml-20-sm">
    		                <span class="text dot-point text-uppercase dot-50 dot-mobile">Categoria ${categoryName}</span>
    		            </div>
    		        </a>
    		    </div>
    		</div>
            </#list>
        <div>
    </#list>
</#if>