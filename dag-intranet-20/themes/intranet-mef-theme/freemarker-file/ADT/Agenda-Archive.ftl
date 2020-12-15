<#assign counter= 0 />
<#assign iter= 0 />
<#assign length= 0 />
<#assign styleCol="light" />
<#assign dateCur  = dateUtil.getCurrentDate("yyyy-MM-dd",locale) />
<#assign dateObj = dateUtil.parseDate("yyyy-MM-dd",dateCur, locale)>
<#assign monthCur = (dateUtil.getDate(dateObj, "MMMM yyyy", locale)) />
<#assign curMonth = (dateUtil.getDate(dateObj, "MM", locale)) />
<#assign curYear = (dateUtil.getDate(dateObj, "yyyy", locale)) />
<#assign selMonth = (dateUtil.getDate(dateObj, "MMMM", locale)) />
<#assign mappedArray = [] />


<div class="agenda-wrapper">
        <div class="tab-filtri filtro-categoria collapse-group" id="tabs-bacheca">
            <div class="filtro-tabs-wrapper agenda-tab">
                <span class="tab-title active">ELENCO DEGLI EVENTI</span>
                <div class="agenda-month-selection text-center" data-current-month="${curMonth}" data-current-year="${curYear}">
		
			       
                    <a href="javascript:void(0)" class="agenda-month-left-arrow icomoon-arrow"></a>
                    <span class="agenda-month-label">${stringUtil.toUpperCase(monthCur)}</span>
                    <a href="javascript:void(0)" class="agenda-month-right-arrow icomoon-arrow"></a>
                </div>
            </div>
            <div class="agenda-event-results-box">
                <#list entries as curEntry>
                    <#assign counter= counter + 1 />
					
                </#list>
                <span class="agenda-event-results-label">
					<span class="bold"></span> eventi
				</span>
            </div>
        </div>

        <div class="ama-row ">
        <div class="ama-col-xs-12 mb-100-xs">
          <div class="event event-no-availability animated fadeIn text-center"><span>Nessun evento da mostrare</span></div>
        <#list entries as curEntry>
			<#assign docXml = saxReaderUtil.read(curEntry.getAssetRenderer().getArticle().getContent()) />
			<#assign title = docXml.valueOf("//dynamic-element[@name='Title']/dynamic-content[@language-id='${locale}']/text()") />
			<#assign description = docXml.valueOf("//dynamic-element[@name='Description']/dynamic-content[@language-id='${locale}']/text()") />
			<#assign dateS = docXml.valueOf("//dynamic-element[@name='DateStart']/dynamic-content/text()")  />
			<#assign dateE = docXml.valueOf("//dynamic-element[@name='DateEnds']/dynamic-content/text()") />
			<#assign time = docXml.valueOf("//dynamic-element[@name='Time']/dynamic-content/text()") />
			<#assign place = docXml.valueOf("//dynamic-element[@name='Place']/dynamic-content[@language-id='${locale}']/text()") />
			<#assign dateSObj = dateUtil.parseDate("yyyy-MM-dd", dateS, locale)>
			<#assign dateEObj = dateUtil.parseDate("yyyy-MM-dd", dateE, locale)>
			<#assign daySNumber = (dateUtil.getDate(dateSObj, "dd", locale))>
			<#assign daySName = (dateUtil.getDate(dateSObj, "EEEE", locale))>
			<#assign daySMonth = (dateUtil.getDate(dateSObj, "MMMM yyyy", locale))>
            <#assign entryMonth = (dateUtil.getDate(dateSObj, "MM", locale)) />
			<#assign entryYear = (dateUtil.getDate(dateSObj, "yyyy", locale)) />
            <#assign mappedArray += [""]>
		
            
			<#assign iter = iter +1 />
			
		    
        <#assign entryArchive = curEntry 
        assetRenderer = entryArchive.getAssetRenderer() 
        entryTitle = htmlUtil.escape(assetRenderer.getTitle(locale)) 
        viewURLArchive = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, entryArchive) />
                                 
        <#if assetLinkBehavior != "showFullContent">
          <#assign viewURLArchive = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, entryArchive, true) />
        </#if>
        <#assign viewURLArchive = viewURLArchive?split("&redirect")[0] />   
		
		
		
	
      
        <div class="event animated fadeIn" data-event-month="${entryMonth}" data-event-year="${entryYear}" >
        <#if ((dateUtil.compareTo(dateSObj,dateEObj))< 0)>
    		<#if iter%2 == 0 >
    			<#assign styleCol = "dark">
			<#else>
				<#assign styleCol = "light">
    		</#if>
        
    	
        <#assign dayENumber = (dateUtil.getDate(dateEObj, "dd", locale))>
        <#assign dayEName = (dateUtil.getDate(dateEObj, "EEEE", locale))>
        <#assign dayEMonth = (dateUtil.getDate(dateEObj, "MMMM yyyy", locale))>
		
					
  
					
					
                    <div class="ama-col-xs-12 agenda-event agenda-event-double-date ${styleCol} mt-30-xs">
                
                        <div class="ama-col-md-3 ama-col-xs-12 pt-10-md border-right">
                            <div class="ama-row">
                                <div class="ama-col-md-5 ama-col-xs-3 ama-col-sm-2 ama-col-xs-offset-2 ama-col-md-offset-0 ama-col-sm-offset-3" style="padding-right: 0px;">
                                
                                    
                                 
                                    <h2 class="day">${stringUtil.toUpperCase(daySName)}</h2>
                                    <h2 class="number-date">${daySNumber}</h2>
                                   
                                </div>

                                <div class="ama-col-md-2 ama-col-xs-2 ama-col-sm-2 pl-5-md pt-25-xs">
                                    <span class="icomoon-vai"></span>
                                </div>

                                <div class="ama-col-md-4 ama-col-xs-3 ama-col-sm-2 pl-25-xs pl-15-md" style="padding-right: 0px;padding-left: 0px !important;">
                                   
                                   

                                    <h2 class="day">${stringUtil.toUpperCase(dayEName)}</h2>
                                    <h2 class="number-date">${dayENumber}</h2>
                                </div>
                            </div>

                            <div class="ama-row">
                                <div class="ama-col-xs-12">
                                    <div class="number-divider"></div>
                                </div>
                                <div class="ama-col-xs-12 pt-10-md pb-25-xs pb-0-md border-bottom-mobile">
                                    
                                    <h2 class="month">${stringUtil.toUpperCase(daySMonth)}</h2>
                                   
                                </div>
                            </div>
                        </div>


                        <div class="ama-col-md-9 ama-col-xs-12 pt-5-md">
                            <div class="ama-row">
                                <#if title!= ''>
                                <div class="ama-col-xs-12 pt-20-xs pt-0-md">
                                <a href="${viewURLArchive}" class="event-title dot-point dot-30">
                                    <p>${title}</p>
                                </a>
                                </div>
                                </#if>
                                <#if description!= ''>
                                <div class="ama-col-xs-12 pt-15-xs">
                                    <div class="event-description dot-point dot-30">${description}</div>
                                </div>
                                </#if>
                            </div>
                            <div class="ama-row">
                                <div class="ama-col-xs-12 pt-10-xs">
                                    <div class="banner-event-info">
                                        <#if time!= ''>
                                        <div class="ama-col-md-4 ama-col-xs-12 pl-25-md">
                                            <span class="event-banner-icon icomoon-time"></span><span class="banner-event-label pl-15-xs">${time}</span>
                                        </div>
                                        </#if>
                                        <#if place!= ''>
                                        <div class="ama-col-md-8 ama-col-xs-12">
                                            <span class="event-banner-icon icomoon-pin"></span><span class="banner-event-label pl-15-xs">${place}</span>
                                        </div>
                                        </#if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
		
              

        <#else>
				
                    <div class="ama-col-xs-12 agenda-event agenda-event-single-date mt-30-xs white">
                        <div class="ama-col-md-3 ama-col-xs-12 pt-10-md pl-40-md border-right">  
                         <div class="ama-row">
                            <div class="ama-col-md-5 ama-col-xs-12" style="padding-left: 0px;padding-right: 0px;">

                                <h2 class="day">${stringUtil.toUpperCase(daySName)}</h2>
                                <h2 class="number-date">${daySNumber}</h2>
                                
                            </div>
                    </div>
                    <div class="ama-row">
                        <div class="ama-col-xs-12">
                            <div class="number-divider"></div>
                        </div>
                        <div class="ama-col-xs-12 pt-10-md pb-25-xs pb-0-md border-bottom-mobile">
                           
                            <h2 class="month">${stringUtil.toUpperCase(daySMonth)}</h2>
                          
                           
                            
                        </div>
                    </div>
                     
                </div>
                
                <div class="ama-col-md-9 ama-col-xs-12 pt-5-md">
                    <div class="ama-row">
                        <#if title!= ''>
                        <div class="ama-col-xs-12 pt-20-xs pt-0-md">
                        <a href="${viewURLArchive}" class="event-title dot-point dot-30">
                            <p>${title}</p>
                        </a>
                        </div>
                        </#if> 
                        <#if description!= ''>
                        <div class="ama-col-xs-12 pt-15-xs">
                            <div class="event-description dot-point dot-30">${description}</div>
                        </div>
                        </#if>   
                    </div>

                    <div class="ama-row">
                        <div class="ama-col-xs-12 pt-10-xs">
                            <div class="banner-event-info">
                            <#if time!= ''>
                                <div class="ama-col-md-4 ama-col-xs-12 pl-25-md">
                                    <span class="event-banner-icon icomoon-time"></span><span class="banner-event-label pl-15-xs">${time}</span>
                                </div>
                            </#if>
                            <#if place!= ''>
                                <div class="ama-col-md-8 ama-col-xs-12">
                                    <span class="event-banner-icon icomoon-pin"></span><span class="banner-event-label pl-15-xs">${place}</span>
                                </div>
                            </#if>
                            </div>
                        </div>
                    </div>
                </div>
               </div>
            </#if>
			</div>

        </#list>
        </div>
     </div>
</div>