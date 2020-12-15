<#assign dateE = getterUtil.getString(DateEnds.getData())>
<#assign dateS = getterUtil.getString(DateStart.getData())>
<#assign dateSObj = (dateUtil.parseDate("yyyy-MM-dd", dateS, locale))>
<#assign dateEObj = (dateUtil.parseDate("yyyy-MM-dd", dateE, locale))>
<#assign printOutput = "false">
<#assign orario = (Orario.getData())!"">
<#assign format = "yyyy-MM-dd HH:mm">
<#assign orarioTrim = orario?replace(" ","")>
<#assign eventDescription = htmlUtil.escape(Description.getData())>

<#if orarioTrim?contains("-")>
    <#assign printOutput = "true">
</#if>
<#if printOutput == "true">
    <#assign startTime = Orario.getData()?trim?split("-")[0]>
    <#assign endTime = Orario.getData()?trim?split("-")[1]>
    <#assign millisStart = dateUtil.parseDate(format,dateS+" "+startTime,locale)>
    <#assign millisEnd = dateUtil.parseDate(format,dateE+" "+endTime,locale)>
    <#assign email = permissionChecker.getUser().getEmailAddress()>
    <#assign today = dateUtil.getCurrentDate("yyyy-MM-dd" ,locale)>
</#if>
     <#-- Get tags of this Web Content -->
<#assign tagsService = (serviceLocator.findService("com.liferay.asset.kernel.service.AssetTagLocalService")) >
<#assign journalArticleResourceService = (serviceLocator.findService("com.liferay.journal.service.JournalArticleResourceLocalService")) >
<#assign longGroupId = (getterUtil.getLong(groupId)) >
<#assign articleResourcePK = (journalArticleResourceService.getArticleResourcePrimKey(longGroupId , .vars['reserved-article-id'].data)) >
<#assign tagsEntries = (tagsService.getTags ("com.liferay.journal.model.JournalArticle", articleResourcePK )) >

<#assign fileService = (serviceLocator.findService("com.liferay.document.library.kernel.service.DLFileEntryLocalService")) >

<#-- Get last modified date fot this web content -->
<#assign lastModDate = .vars['reserved-article-modified-date'].data>
    <#-- Set the page locale to the portals default locale -->
<#setting locale = localeUtil.getDefault()>
    <#-- Parse the date to a date object -->
<#assign lastModDate = lastModDate?datetime("EEE, dd MMM yyyy hh:mm:ss Z")>
    <#-- Format date for conversion -->
<#assign dateTimeFormat = "dd/MM/yyyy">
<#assign dateParsed = (dateUtil.getDate(lastModDate, dateTimeFormat, locale))>




<div class="agenda-dettaglio-wrapper">
    <div class="page-title-wrapper">
        <div class="title-wrapper">
            <h2 class="title bread-title">${Title.getData()}</h2>
            <a class="icomoon-star title-star btn-star-bookmarks">
                <span class="sr-only">Aggiungi a preferiti</span>
            </a>
        </div>
    </div>
<#if ((dateUtil.compareTo( dateSObj, dateEObj) )< 0)>
    <div class="ama-col-xs-12 agenda-event agenda-event-double-date agenda-event-double-date-dettaglio light mt-30-xs">
        <div class="ama-col-md-6 ama-col-xs-12 pt-10-md pl-35-md border-right">
            <div class="ama-row">
                <div class="ama-col-md-2 ama-col-xs-3 ama-col-sm-2 ama-col-xs-offset-2 pl-0-xs pr-0-xs ama-col-md-offset-0 ama-col-sm-offset-3">
                        <#assign daySNumber = (dateUtil.getDate(dateSObj, "dd", locale))>
                        <#assign daySName = (dateUtil.getDate(dateSObj, "EEEE", locale))>
                        <#assign daySMonth = (dateUtil.getDate(dateSObj, "MMMM yyyy", locale))>
                    <h2 class="day">${stringUtil.toUpperCase(daySName)}</h2>
                    <h2 class="number-date">${daySNumber}</h2>
                </div>
                <div class="ama-col-md-1 ama-col-xs-2 ama-col-sm-2 pl-10-md pt-25-xs"style="padding-right: 0px;">
                    <span class="icomoon-vai"></span>
                </div>
                <div class="ama-col-md-2 ama-col-xs-3 ama-col-sm-2 pl-0-xs pr-0-xs">
                        <#assign dateEObj = dateUtil.parseDate("yyyy-MM-dd",dateE, locale)>
                        <#assign dayENumber = (dateUtil.getDate(dateEObj, "dd", locale))>
                        <#assign dayEName = (dateUtil.getDate(dateEObj, "EEEE", locale))>
                        <#assign dayEMonth = (dateUtil.getDate(dateEObj, "MMMM yyyy", locale))>
                    <h2 class="day">${stringUtil.toUpperCase(dayEName)}</h2>
                    <h2 class="number-date">${dayENumber}</h2>
                </div>
                <div class="ama-col-md-7 ama-col-xs-12 pt-40-md pt-10-xs pb-25-xs pb-0-md pl-40-md border-bottom-mobile">
                <#if daySMonth == dayEMonth>
                    <h2 class="month">${stringUtil.toUpperCase(daySMonth)}</h2>
                <#else>
                    <h2 class="month">${stringUtil.toUpperCase(daySMonth)} - ${stringUtil.toUpperCase(dayEMonth)}</h2>
                </#if>
                </div>
            </div>
        </div>
        <div class="ama-col-md-6 ama-col-xs-12 pt-5-md pt-25-xs text-center">
            <div class="ama-row">
                <div class="ama-col-md-5">
                    <span class="event-banner-icon icomoon-time"></span><span class="banner-event-label">${Orario.getData()}</span>
                </div>
                <div class="ama-col-md-7 pt-15-xs pt-0-md">
                    <span class="event-banner-icon icomoon-pin"></span><span class="banner-event-label dot-point dot-70 dot-mobile">${Place.getData()}</span>
                </div>
            </div>
        </div>
    </div>
<#else>
    <div class="ama-col-xs-12 agenda-event agenda-event-single-date agenda-event-single-date-dettaglio mt-30-xs white">
        <div class="ama-col-md-6 ama-col-xs-12 pt-10-md pl-35-md border-right">
            <div class="ama-row">
                <div class="ama-col-md-3 ama-col-xs-12 pl-0-xs">
                    <#assign dateObj = (dateUtil.parseDate("yyyy-MM-dd", dateS, locale))>
                    <#assign dayNumber = (dateUtil.getDate(dateObj, "dd", locale))>
                    <#assign dayName = (dateUtil.getDate(dateObj, "EEEE", locale))>
                    <#assign dayMonth = (dateUtil.getDate(dateObj, "MMMM yyyy", locale))>
                    <h2 class="day">${stringUtil.toUpperCase(dayName)}</h2>
                    <h2 class="number-date">${dayNumber}</h2>
                </div>
                <div class="ama-col-md-7 ama-col-xs-12 pt-40-md pt-10-xs pb-25-xs pb-0-md pl-40-md border-bottom-mobile">
                     <h2 class="month">${stringUtil.toUpperCase(dayMonth)}</h2>
                </div>
            </div>
        </div>
        <div class="ama-col-md-6 ama-col-xs-12 pt-5-md pt-25-xs text-center">
            <div class="ama-row">
                <div class="ama-col-md-5">
                    <span class="event-banner-icon icomoon-time"></span>
                    <span class="banner-event-label">${Orario.getData()}</span>
                </div>
                <div class="ama-col-md-7 pt-15-xs pt-0-md">
                    <span class="event-banner-icon icomoon-pin"></span>
                    <span class="banner-event-label dot-point dot-70 dot-mobile">${Place.getData()}</span>
                </div>
            </div>
        </div>
    </div>
 </#if>
    <div class="ama-row">
        <div class="ama-col-xs-12 agenda-dettaglio-description mt-20-xs wysiwyg-editor">
            ${Description.getData()}
        </div>
    </div>
    <div class="tags-container pt-25-md pt-20-xs mb-30-xs mb-0-sm mb-0-md">
            <div class="text-center-mobile">
                <#assign i = 0 />
                <#list tagsEntries as entry>
                        <#assign i =  i  +1 />
                            <div class="tag">${stringUtil.toUpperCase(entry.getName())}</div>
                </#list>
                <#if ( i > 3 ) >
                    <a href="javascript:void(0)" title="more Tags" class="tags-more-click-js">...</a>
                </#if>
            </div>
        </div>

            <#assign counter = 0 >
            <#list AttachmentInfo.getSiblings() as cur_AttachmentInfo>
                <#assign atDoc = (cur_AttachmentInfo.getData())>
                <#if atDoc != "">
                    <#if counter == 0>
                        <div class="title-wrapper title-small mt-40-xs">
                            <h2 class="title">Allegati</h2>
                        </div>
                    </#if>
                </#if>
                <#assign counter = counter+1 >
            </#list>

        <div class="attachments-generic-container">
        <div class="ama-row">
            <#if AttachmentInfo.getSiblings()?has_content>
                <#list AttachmentInfo.getSiblings() as cur_AttachmentInfo>
                    <#assign atDoc = (cur_AttachmentInfo.AttachmentDoc.getData())>
                    <#if atDoc != "">
                        <#assign counter = 0 >
                        <#list "${atDoc}"?split("/") as x>
                            <#if counter == 2>
                                <#assign groupId = x?number >
                            </#if>
                            <#if counter == 5>
                                 <#assign uuId = x?split("?") >
                                <#assign uuidSplit = uuId[0]>
                                <#assign uuId = x >
                            </#if>
                            <#assign counter = counter+1 >
                        </#list>
                        <#assign fileEntry = (fileService.getDLFileEntryByUuidAndGroupId(uuidSplit,groupId)) >
                        <#assign fileExt = (fileEntry.getExtension())! "" >
                        <#assign fileTitle = (fileEntry.getTitle())! "" >
                        <#assign fileSize = (fileEntry.getSize()/ 1024) >
                        <#assign iconItem = ''>
                        <#if fileExt == 'pdf'>
                            <#assign iconItem = 'icomoon-pdf-file'>
                        <#elseif (fileExt == 'xls') || (fileExt == 'xlsx') >
                            <#assign iconItem = 'icomoon-xls-file'>
                        <#elseif fileExt == 'ppt'>
                            <#assign iconItem = 'icomoon-ppt-file'>
                        <#elseif (fileExt == 'png') || (fileExt == 'jpg')>
                            <#assign iconItem = 'icomoon-image-file'>
                        <#elseif (fileExt == 'doc') || (fileExt == 'docx')>
                            <#assign iconItem = 'icomoon-word-file'>
                        <#elseif (fileExt == 'mp3') || (fileExt == 'mp4')>
                            <#assign iconItem = 'icomoon-audio-file'>
                        <#elseif (fileExt == 'zip') || (fileExt == 'rar')>
                            <#assign iconItem = 'icomoon-zip-file'>
                        <#else>
                            <#assign iconItem = 'icomoon-generic-file'>
                        </#if>
                        <div class="ama-col-sm-4 ama-col-xs-12">
                            <div class="attachment-box">
                                <div class="attachment-text">
                                    <span class="dot-point max-dot-80 dot-mobile">${fileTitle}</span>
                                </div>
                                <div class="attachment-download">
                                    <span class="icomoon-icon ${iconItem}"></span>
                                    <span class="file-name">${stringUtil.toUpperCase(fileExt)} ${fileSize?round} Kb</span>
                                    <a href="${atDoc}" data-ext=".${fileExt}" title=${fileTitle} download class="icomoon-download ico-down">
                                        <span class="sr-only">${fileTitle}</span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </#if>
                </#list>
            </#if>
        </div>
        </div>


    <div class="last-update-container">
            <span class="icomoon-update"></span>
            <span class="last-update-text"><span class="bold"><@liferay.language key="last-update" />: </span>${dateParsed}</span>
    </div>
    <#if printOutput == "true">
        <div class="ama-row text-center pb-60-xs">
            <a onclick="sendMail()" title="aggiungi al calendario" class="button button-primary">AGGIUNGI AL TUO CALENDARIO</a>
        </div>
    </#if>
</div>

<script>
function sendMail(){
    Liferay.Service(
      '/sendcalendar.logmail/send-mail-with-attachment',
      {
      mailTo: '${email}',
      timeStart: ${millisStart?long},
      timeFinish: ${millisEnd?long},
      eventTitle: '${Title.getData()}',
      eventDescription: '${htmlUtil.replaceNewLine(Description.getData())}'
      },
      function(obj) {
        console.log(obj);
      }
    );
}
</script>
<style>.detail-page-item{display:none;}</style>
<script>
    var titleContent = $(".page-title-wrapper .title-wrapper .bread-title").text();
    if(titleContent.length > 40){
        titleContent = titleContent.substring(0,40)+"...";
    }
    $(".breadcrumb-wrap ul").append("<li><span>"+titleContent+"</span></li>");
</script>
