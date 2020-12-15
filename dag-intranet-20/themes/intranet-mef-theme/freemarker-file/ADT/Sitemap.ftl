<div class="mappa-sito-wrapper">
    <div class="ama-container-fluid">
        <#if entries?has_content>
            <div class="ama-row mb-100-xs ul-dynamic">
                <#list entries as entry>
                   <#if entry.getName(locale)?lower_case == "home">
                   <#else>
                        <div class="ama-col-xs-12 mappa-sito-section-wrapper">
                            <b>
                                <a href="${entry.getFriendlyURL()?remove_beginning('/')}">
                                    <p class="mappa-sito-section">${entry.getName(locale)}
                                    <span class="mappa-sito-section-icon icomoon-vai"></span>
                                    </p>
                                </a>
                            </b>
                        </div>
                        <@displayPages pages=entry.getChildren() />
                    </#if>
                </#list>
            </div>  
        </#if>
        <#macro displayPages
            pages
        >
            <#if pages?has_content>
                <div class="ama-col-xs-12 mappa-sito-subsection-wrapper">
                    <ul class="mappa-sito-list">
                        <#list pages as page>
                             <#assign layoutType = page.isHidden() />
                           
                             <#if layoutType?c == 'false'>
                                <li class="mappa-sito-subsection-li">
                                    <a href="${portalUtil.getLayoutURL(page, themeDisplay)}" class="mappa-sito-subsection">${page.getName(locale)}
                                    <span class="mappa-sito-subsection-icon icomoon-vai"></span>
                                </a>
                                </li>
                            </#if>
                        </#list>
                    </ul>
                </div>
            </#if>
        </#macro>
    </div>
</div>