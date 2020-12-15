<#assign DLFileEntryLocalService = serviceLocator.findService("com.liferay.document.library.kernel.service.DLFileEntryLocalService")/>
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
        <h2 aria-label="Sezione Moduli" class="wrap-title mb-25-xs mt-30-xs">MODULI</h2>
    </div>
    <div class="attachments-generic-container mt-0-xs">
        <#if entries?has_content>
            <#list entries as curEntry>
                <#list curEntry.getCategories() as category>
                <#assign categoryId = category.getCategoryId()>
                    <#if CategoryServiceArray?seq_contains(categoryId)>
                        <#assign doc_Name = curEntry.getTitle(locale)/>
                        <#assign doc_NameEscape = doc_Name?html?replace(" ","-")/>
                        <#assign doc_Description = curEntry.getDescription(locale)/>
                        <#assign createDate = curEntry.getCreateDate()/>
                        <#assign dateEntry = createDate?date>
                        <#assign dateEntryFinal = (dateUtil.getDate(dateEntry, "dd/MM/yy HH:mm", locale))>
                        <#assign fileEntry = DLFileEntryLocalService.getFileEntry(curEntry.getClassPK())/>
                        <#assign fileEntryGroupId = fileEntry.getGroupId()>
                        <#assign fileEntryUuid = fileEntry.getUuid()>
                        <#assign fileEntryId = fileEntry.getFileEntryId()>
                        <#assign fileEntryFolderId = fileEntry.getFolderId()>
                        <#assign fileEntryVersion = fileEntry.getVersion()>
                        <#assign fileUrl = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + fileEntryGroupId + "/"+ fileEntryFolderId + "/" + doc_NameEscape  + "/"+ fileEntryUuid + "?version=" + fileEntryVersion>
                        <#assign extension = fileEntry.getExtension() />
                        <#assign groupId = curEntry.getGroupId()/>
                        <#if extension == 'pdf'>
                            <#assign iconItem = 'icomoon-pdf-file'>
                        <#elseif (extension == 'xls') || (extension == 'xlsx') >
                            <#assign iconItem = 'icomoon-xls-file'>
                        <#elseif extension == 'ppt'>
                            <#assign iconItem = 'icomoon-ppt-file'>
                        <#elseif (extension == 'png') || (extension == 'jpg')>
                            <#assign iconItem = 'icomoon-image-file'>
                        <#elseif (extension == 'doc') || (extension == 'docx')>
                            <#assign iconItem = 'icomoon-word-file'>
                        <#elseif (extension == 'mp3') || (extension == 'mp4')>
                            <#assign iconItem = 'icomoon-audio-file'>
                        <#elseif (extension == 'zip') || (extension == 'rar')>
                            <#assign iconItem = 'icomoon-zip-file'>
                        <#else>
                            <#assign iconItem = 'icomoon-generic-file'>
                        </#if>
                        <div class="ama-col-sm-4 ama-col-xs-12 hidden animated fadeIn" data-category="${categoryId}">
                            <div class="attachment-box attachment-box-servizi-richiesta">
                                <div class="attachment-text">
                                    <div class="tags-container pt-10-lg mb-30-xs mb-0-sm mb-0-md ml-10-xs">
                                        <div class="text-center-mobile">
                                            <#assign titleCount = 0>
                                            <#list curEntry.getCategories() as category>
                                                <#assign titleCount = titleCount + 1>
                                                <#if titleCount lte 2> 
                                                    <#assign title = category.getTitle(locale)>
                                                    <div class="tag tags-more-click-js">${title}</div>
                                                </#if>
                                            </#list>
                                        </div>
                                        <a class="tooltip-field tooltip-field-servizi" title="Modulo di Richiesta ${doc_Name}" aria-label="Modulo di Richiesta ${doc_Name}">
                                            <div class="ico-info icomoon-info"></div>
                                        </a>
                                    </div>
                                    <span class="mt-40-xs dot-point dot-70 dot-mobile">${doc_Name}</span>
                                </div>
                                <div class="attachment-download">
                                    <span class="icomoon-icon ${iconItem}"></span>
                                    <#assign doc_size = fileEntry.getSize()/>
                                    <#assign extensionName = extension?upper_case>
                                    <#if doc_size gte 1024>
                                        <#assign doc_size_Kilo = doc_size/1024 />
                                        <#if doc_size_Kilo gte 1024>
                                            <#assign doc_size_Mega = doc_size_Kilo/1024 />
                                            <span class="sr-only">Peso documento ${doc_size_Mega?floor}MB</span>
                                            <span class="file-name">${extensionName} ${doc_size_Mega?floor}MB</span>
                                            <a href="${fileUrl}" title="Scarica il file - ${doc_Name}" class="icomoon-download ico-down" download>
                                                <span class="sr-only">Scarica il file - ${doc_Name}</span>
                                            </a>
                                        <#else>
                                            <span class="sr-only">Peso documento ${doc_size_Kilo?floor}KB</span>
                                            <span class="file-name">${extensionName} ${doc_size_Kilo?floor}KB</span>
                                            <a href="${fileUrl}" title="Scarica il file - ${doc_Name}" class="icomoon-download ico-down" download>
                                                <span class="sr-only">Scarica il file - ${doc_Name}</span>
                                            </a>
                                        </#if>
                                    <#else>
                                        <span class="sr-only">Peso documento ${doc_size?floor}B</span>
                                        <span class="file-name">${extensionName} ${doc_size?floor}B</span>
                                        <a href="${fileUrl}" title="Scarica il file - ${doc_Name}" class="icomoon-download ico-down" download>
                                            <span class="sr-only">Scarica il file - ${doc_Name}</span>
                                        </a>
                                    </#if>
                                </div>
                            </div>
                        </div>
                    </#if>
                </#list>
            </#list>
        </#if>
    </div>
</div>