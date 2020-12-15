<#assign currentId = permissionChecker.getUserId()>
<#assign bookmarksLocalService = serviceLocator.findService("bookmarks.service.FavouritesLocalService")>
<#assign bookmarks = bookmarksLocalService.getFavouritesByUser(currentId)>
<#assign serviceContext = staticUtil["com.liferay.portal.kernel.service.ServiceContextThreadLocal"].getServiceContext()>

<div class="preferiti-wrapper">
  <div class="preferiti-title-box">
    <div class="ama-container-fluid">
      <div class="ama-row">
        <div class="ama-col-xs-12">
          <div class="title-wrapper">
            <h2 class="title">${title.getData()}</h2>
            ${Description.getData()}
            <div class="button-wrapper">
              <a href="#" data-toggle="modal" data-target="#add-favourites-modal" class="add-favourite-button">
                        <span class="button-text">${labelButtonAddPage.getData()}</span>
                    </a>
            </div>
          </div>

          <div id="add-favourites-modal" class="modal fade modal-custom" role="dialog" style="display: none;">
            <div class="modal-dialog">

              <div class="modal-content">
                <div class="modal-body">
                  <div class="modal-title-box">
                    <a href="#" class="icomoon-close-white" data-dismiss="modal"></a>

                    <div class="title-modal">
                      <h2 class="title">${titleBookmarkAddPage.getData()}</h2>
                    </div>
                  </div>
                  <div class="modal-form-box" data-parsley-validate="true">
                    <form id="addBookmark">
                      <label>${labelUrl.getData()}</label>
                      <input id="url-bookmark"
                        data-parsley-required="true"
                        data-parsley-required-message="Il campo inserito è obbligatorio"
						data-parsley-type="url"
						data-parsley-type-message="Inserire un url valido http/https"
                        class="modal-input data-parsley-validated">
                      <label>${labelNameBookmark.getData()}</label>
                      <input id="name-bookmark"
						data-parsley-required="true"
                        data-parsley-required-message="Il campo inserito è obbligatorio"
                        type="text"
						class="modal-input data-parsley-validated">
                      <div class="buttons-wrap">
                        <input id="button-cancel" type="button" data-dismiss="modal" value="${labelCancelButton.getData()}" class="button button-secondary" onclick="document.location.reload(true)">
                        <input id="button-submit" type="button" value="${labaleAddPageButton.getData()}" class="button button-primary modal-apply">
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Lista preferiti-->
  <div class="preferiti-elenco-box">
    <div class="ama-container-fluid">
      <div class="ama-row">
        <div class="ama-col-xs-12">
          <div class="preferiti-elenco-wrapper">
            <div class="favourites-number-box">
              <span class="favourites-number"><span id="number-bookmark" class="bold">${bookmarks?size}</span> ${labelNumberBookmark.getData()}</span>
            </div>
            <div class="favourites-list">
              <div class="js-list-pagination">
                <#list bookmarks?sort_by("favourite_id") as bookmark>
                  <div id="value.favourite_id" class='ama-col-md-3 ama-col-sm-6 item-pagination animated fadeIn'>
                    <#if bookmark.getUrl_favourite()?starts_with(serviceContext.getThemeDisplay().getURLPortal())>
                      <a href="${bookmark.getUrl_favourite()}" class="widget-white widget-favourites" target="_self" >
                    <#else>
          		        <a href="${bookmark.getUrl_favourite()}" class="widget-white widget-favourites" target="_blank">
                    </#if>
                      <p class="widget-title dot-point max-dot-85" style="word-wrap: break-word;">${bookmark.getTitle_favourite()}</p>
                      <span data-id-bookmark="${bookmark.getFavourite_id()}"  class="icomoon-star-color"></span>
                    </a>
                  </div>
                </#list>
                <!-- <div class="ama-col-md-3 ama-col-sm-6 item-pagination animated fadeIn">
                  <a href="#" class="widget-white widget-favourites">
                    <p class="widget-title dot-point max-dot-85" style="word-wrap: break-word;">Ragioneria Generale dello Stato</p>
                    <span class="icomoon-star-color"></span>
                  </a>
                </div> -->
                <div class="ama-row">
                  <div class="ama-col-xs-12 text-align-center">
                    <div id="js-paginator" data-totpage="20" data-totpage-mobile="11" class="paginator-wrap-dark js-pagination paginator-wrap">
                      <div class="btn-back-arrow disabled">
                        <a href="#"><i class="icomoon-arrow"></i></a>
                      </div>
                      <ul class="pagination-numbers"></ul>
                      <div class="btn-forward-arrow">
                        <a href="#"><i class="icomoon-arrow"></i></a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="preferiti-msg-empty">
    <div class="ama-container-fluid">
      <h2>Non ci sono preferiti salvati. Salvane uno usando il tasto in alto.</h2>
    </div>
  </div>
</div>



<script type="text/javascript">
if(${bookmarks?size} == 0){
  $('.preferiti-elenco-box').hide();
  $('.preferiti-msg-empty').show();
}
/*
   if(${permissionChecker.isSignedIn()?string('true', 'false')} === true){
        currentId = ${permissionChecker.getUserId()};
        console.log("currentId"+currentId);
    }

    Liferay.Service(
    '/mefintranet.favourites/get-favourites-by-user',
    {
        user_id: currentId
    },
    function(obj) {
      console.log("Return obj "+obj);
      if(obj.length == 0){
        $('.preferiti-elenco-box').hide();
        $('.preferiti-msg-empty').show();
      }else {
        $('span#number-bookmark').text(obj.length);
      }
      var orderArr = $.map(obj, function(key,value){
      var tit = key.title_favourite;
      var dt = key.save_date;
      var url = key.url_favourite;
      var id = key.favourite_id;
      return {title_favourite: tit, url_favourite: url, save_date: Date.parse(dt), favourite_id : id};
      });
      orderArr.sort(function(a, b) {
      return new Date(b.save_date) - new Date(a.save_date); });

      $.each(orderArr, function(key, value) {
        var target = "target=\"_self\"";
        if(!value.url_favourite.startsWith(location.protocol+"//"+location.hostname)){
          target = "target=\"_blank\"";
        }

      $(".js-list-pagination").prepend(""+
      "<div id = '"+value.favourite_id+"' class='ama-col-md-3 ama-col-sm-6 item-pagination animated fadeIn'>"+
          "<a href='"+value.url_favourite+"' class='widget-white widget-favourites' "+target+">"+
            "<p class='widget-title dot-point max-dot-85' style='word-wrap: break-word;'>"+value.title_favourite+"</p>"+
            "<span data-id-bookmark=\"" + value.favourite_id + "\" class='icomoon-star-color'></span>"+
          "</a>"+
        "</div>");
      });

    }
);

*/

var d = new Date().toString();

$('#addBookmark').on('submit', function(e) {

	$("#addBookmark").parsley();
  //e.preventDefault();
	var inputUrl = $('#url-bookmark').val();
	if (!inputUrl.startsWith("http://") && !inputUrl.startsWith("https://")){
      inputUrl="http://"+($('#url-bookmark').val());
	}

	console.log("url inserito nel db: "+inputUrl);
	Liferay.Service(
		'/mefintranet.favourites/set-favourite',
		{
			user_id: $('#currentId').val(),
			title_favourite: $('#name-bookmark').val(),
			url_favourite: inputUrl,
			save_date: d
		},

	function(obj) {
		console.log(obj);
		//location.reload(true);
	});
	});

	$('#button-submit').on('click', function(e) {
		e.preventDefault();

		$("#addBookmark").parsley();

		$("#addBookmark").submit();
	});


</script>
