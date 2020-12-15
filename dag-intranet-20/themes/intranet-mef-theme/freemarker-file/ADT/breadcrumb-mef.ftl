<#assign actualUrl = themeDisplay.getPortalURL()+themeDisplay.getURLCurrent()/>
<div class="breadcrumb-wrap hidden-sm hidden-xs">
    <div class="ama-container-fluid">
        <ul>
            <li>
                <a href="${themeDisplay.getSiteGroup().getExpandoBridge().getAttribute("home-main-portal-url",false)}"><span class="icomoon-home"></span></a>
            </li>
            <#list entries as entry>
                <li>
                <#assign entryUrl = entry.getURL()!""/>
                    <#if entry.isBrowsable() && entryUrl != actualUrl>
                    <a  href="${entry.getURL()!""}" title="${htmlUtil.escape(entry.getTitle())}"> ${htmlUtil.escape(entry.getTitle())}</a>
                    <#else>
                        <span class="current">${htmlUtil.escape(entry.getTitle())}</span>
                    </#if>

                </li>
            </#list>
        </ul>
    </div>

</div>