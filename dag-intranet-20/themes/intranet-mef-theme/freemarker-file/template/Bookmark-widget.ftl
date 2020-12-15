<#assign currentId = permissionChecker.getUserId()>
<#assign bookmarksLocalService = serviceLocator.findService("bookmarks.service.FavouritesLocalService")>
<#assign bookmarks = bookmarksLocalService.getFavouritesByUser(currentId)>
<#assign serviceContext = staticUtil["com.liferay.portal.kernel.service.ServiceContextThreadLocal"].getServiceContext()>
<div id="overlayWidgetFavourites" class="overlay-widget animated fadeIn hide">
  <div class="ama-container-fluid">
    <div class="ama-row wrap-title-widget">
      <div class="ama-col-xs-12">
        <h3 class="title-overlay">${title.getData()}</h3>
      </div>
    </div>
    <div id="bookmark-widget-block" class="ama-row wrap-box-widget">
      <#assign sizeBookmarks = numeroPreferiti.getData()>
      <#list bookmarks[0..*sizeBookmarks?number]?sort_by("favourite_id") as bookmark>

        <div class="ama-col-md-3">
          <#if bookmark.getUrl_favourite()?starts_with(serviceContext.getThemeDisplay().getURLPortal())>
            <a href="${bookmark.getUrl_favourite()}" class="widget-white widget-favourites" aria-label="${bookmark.getTitle_favourite()} - Collegamento a sito interno" title="Collegamento a sito interno" target="_self" >
          <#else>
		        <a href="${bookmark.getUrl_favourite()}" class="widget-white widget-favourites" aria-label="${bookmark.getTitle_favourite()} - Collegamento a sito esterno - Apertura in nuova scheda" title="Collegamento a sito esterno" target="_blank">
          </#if>
          <#--<a href="${bookmark.getUrl_favourite()}" class="widget-white widget-favourites" target title ariaLabel>-->
              <p class="widget-title dot-point max-dot-85" style="word-wrap: break-word;">${bookmark.getTitle_favourite()}</p>
              <span data-id-bookmark="${bookmark.getFavourite_id()}"  class="icomoon-star-color"></span>
            </a>
        </div>
      </#list>
      <div class="ama-col-md-3">
        <a href="${linkBookmarkPage.getFriendlyUrl()}" class="widget-blue widget-favourites">
          <p class="widget-title">${labelShowAll.getData()}<span class="icomoon-vai"></span></p>
        </a>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
/*
    if(${permissionChecker.isSignedIn()?string('true', 'false')} === true){
        currentId = ${permissionChecker.getUserId()};
        console.log(currentId);
    }


    Liferay.Service(
    '/mefintranet.favourites/get-favourites-by-user',
    {
        user_id: currentId
    },
        function(obj) {

        var orderArr = $.map(obj, function(key,value){
        var tit = key.title_favourite;
        var dt = key.save_date;
        var url = key.url_favourite;
        var id = key.favourite_id;
        return {title_favourite: tit, url_favourite: url, save_date: Date.parse(dt), favourite_id : id};
        });

        orderArr.sort(function(a, b) {
        return new Date(b.save_date) - new Date(a.save_date); });

        var limitArr = orderArr.slice(0, ${numeroPreferiti.getData()});

        $.each(limitArr, function(key, value) {

        var dat = new Date(value.save_date).toString();
        var target = "target=\"_self\"";
        var title= "title=\"Collegamento a sito interno\"";
        var ariaLabel= "aria-label=\""+value.title_favourite+" - Collegamento a sito interno\"";
        if(!value.url_favourite.startsWith(location.protocol+"//"+location.hostname)){
          target = "target=\"_blank\"";
          title= "title=\"Collegamento a sito esterno\"";
          ariaLabel= "aria-label=\""+value.title_favourite+" - Collegamento a sito esterno - Apertura in nuova scheda\"";
        }
        $("#bookmark-widget-block").prepend("<div class=\"ama-col-md-3\">"+
              "<a href=\""+ value.url_favourite +"\" class=\"widget-white widget-favourites\" "+target+" "+title+" "+ariaLabel+">"+
                "<p class=\"widget-title dot-point max-dot-85\" style=\"word-wrap: break-word;\">"+ value.title_favourite +"</p>"+
                "<span data-id-bookmark=\"" + value.favourite_id + "\" class=\"icomoon-star-color\"></span>"+
              "</a>"+
          "</div>");
            });
    });*/
</script>
