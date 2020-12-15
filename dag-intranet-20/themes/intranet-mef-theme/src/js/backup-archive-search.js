var urlLocation = location.origin+location.pathname;
function showHideFilterBar(){
    var assetArchiveJs = $(".asset-archive-js");
    assetArchiveJs.each(function(){
        var thisAsset = $(this);
        var inputKeywords = thisAsset.find(".inputKeywords").val();
        var inputCategory = thisAsset.find(".inputCategories").val();
        if(inputKeywords != '' && inputCategory == ''){
            var singleKeywords = inputKeywords.split(",");
            for (var i = 0; i < singleKeywords.length; i++) {
                var aKey = singleKeywords[i];
                var decoded = decodeURIComponent(aKey);
                thisAsset.find('.labels-container-title').append('<div class="filter-label-item text-uppercase"><h2>' + decoded + '</h2></div>');
                thisAsset.find(".filtro-body-box .labels-container").show();
            }
        }
        else if(inputCategory != '' && inputKeywords == ''){
            var singleCategory = inputCategory.split(",");
            for (var i = 0; i < singleCategory.length; i++) {
                var aKey = singleCategory[i];
                thisAsset.find(".filtro-body-box .filter-category-item-box").each(function(){
                    var item = $(this);
                    if(aKey == item.data("category-id")){
                        item.addClass("active");
                    }
                });
            }
            thisAsset.find(".filtro-body-box .filter-category-item-box").each(function(){
                var item = $(this);
                if(item.hasClass("active")){
                    var thisText = item.text();
                    thisAsset.find('.labels-container-title').append('<div class="filter-label-item text-uppercase"><h2>' + thisText + '</h2></div>');
                    thisAsset.find(".filtro-body-box .labels-container").show();
                }
            });
        }
        else if(inputCategory != '' && inputKeywords != ''){
            var singleKeywords = inputKeywords.split(",");
            var singleCategory = inputCategory.split(",");
            for (var i = 0; i < singleKeywords.length; i++) {
                var aKey = singleKeywords[i];
                var decoded = decodeURIComponent(aKey);
                thisAsset.find('.labels-container-title').append('<div class="filter-label-item text-uppercase"><h2>' + decoded + '</h2></div>');
                thisAsset.find(".filtro-body-box .labels-container").show();
            }
            for (var i = 0; i < singleCategory.length; i++) {
                var aKey = singleCategory[i];
                thisAsset.find(".filtro-body-box .filter-category-item-box").each(function(){
                    var item = $(this);
                    if(aKey == item.data("category-id")){
                        item.addClass("active");
                    }
                });
            }
            thisAsset.find(".filtro-body-box .filter-category-item-box").each(function(){
                var item = $(this);
                if(item.hasClass("active")){
                    var thisText = item.text();
                    thisAsset.find('.labels-container-title').append('<div class="filter-label-item text-uppercase"><h2>' + thisText + '</h2></div>');
                    thisAsset.find(".filtro-body-box .labels-container").show();
                }
            });
        }
        else{
            thisAsset.find(".filtro-body-box .labels-container").hide();
        }
    });
}
function manageUrlParameter(){
    if ($('.multitab-title').length > 0){
        var assetArchiveJs = $(".asset-archive-js");
        assetArchiveJs.each(function(){
            var assetPortletId = $(this).find("section").attr("id").substring(8);
            if(location.href.indexOf(assetPortletId) !=-1){
                var assetTabId = $(this).find(".tab-filtri").attr("id");
                assetArchiveJs.hide();
                $('#'+assetTabId).closest(".asset-archive-js").show();
                $('.multitab-title').removeClass("tab-active");
                $('.multitab-title[data-asset-id='+assetTabId+']').addClass("tab-active");
            }
        });
    }
};
function searchCategory (btn){
    if(btn.closest(".asset-archive-js").find('.filter-category-item-box.active').length > 0){
        var portletId = btn.closest("section").attr("id").substring(8);
        var ppid = "p_p_id=" + portletId;
        var pplifecycle = "p_p_lifecycle=0";
        var ppstate = "p_p_state=normal";
        var ppmode = "p_p_mode=view";
        var costantsUrl = "&"+ppid+"&"+pplifecycle+"&"+ppstate+"&"+ppmode;
        var urlLocation = location.origin+location.pathname;
        var categoryArray = [];
        btn.closest(".asset-archive-js").find(".filtro-body-box .filter-category-item-box.active").each(function(){
            var categoryId = $(this).data("category-id");
            categoryArray.push(categoryId);
        });
        var categorySearch = "_categories="+categoryArray.join(",");
        if(location.href.indexOf("keywords=") ==-1 && btn.closest(".asset-archive-js").find('.text-search-wrap .text-search').val() == ""){
            window.location = urlLocation+"?_" + portletId +categorySearch+costantsUrl;
        }
        else if(btn.closest(".asset-archive-js").find('.text-search-wrap .text-search').val() != ""){
            var keywords = btn.closest(".asset-archive-js").find('.text-search-wrap .text-search').val();
            var keywordsTrimReplace = keywords.trim().replace(/[&|?|=]/g,'-').replace(/\s\s+/g, ' ').replace(/ +/g,",");
            window.location = urlLocation+"?_" + portletId +categorySearch+'&_'+portletId+'_keywords='+keywordsTrimReplace+costantsUrl;
        }
        else if(location.href.indexOf("keywords=") !=-1 && btn.closest(".asset-archive-js").find('.text-search-wrap .text-search').val() == ""){
            var keywordsSplit = location.href.split("keywords=")[1].split("&")[0];
            window.location = urlLocation+"?_" + portletId +categorySearch+'&_'+portletId+'_keywords='+keywordsSplit+costantsUrl;
        }
    }
};
function searchKeywords(btn){
    if(btn.closest(".asset-archive-js").find('.text-search-wrap .text-search').val() != ""){
        var portletId = btn.closest("section").attr("id").substring(8);
        var ppid = "p_p_id=" + portletId;
        var pplifecycle = "p_p_lifecycle=0";
        var ppstate = "p_p_state=normal";
        var ppmode = "p_p_mode=view";
        var costantsUrl = "&"+ppid+"&"+pplifecycle+"&"+ppstate+"&"+ppmode;
        var categoryArray = [];
        btn.closest(".asset-archive-js").find(".filtro-body-box .filter-category-item-box.active").each(function(){
            var categoryId = $(this).data("category-id");
            categoryArray.push(categoryId);
        });
        var categorySearch = "_categories="+categoryArray.join(",");
        var keywords = btn.closest(".asset-archive-js").find('.text-search-wrap .text-search').val();
        var keywordsTrimReplace = keywords.trim().replace(/[&|?|=]/g,'-').replace(/\s\s+/g, ' ').replace(/ +/g,",");
        if(location.href.indexOf("?categories=") ==-1 && (categoryArray === undefined || categoryArray.length == 0)){
            window.location = urlLocation+"?_" + portletId + "_keywords="+keywordsTrimReplace+costantsUrl;
        }
        else{
            window.location = urlLocation+"?_" + portletId +categorySearch+'&_'+portletId+'_keywords='+keywordsTrimReplace+costantsUrl;
        }
    }
};
function assetCounter(){
    var assetArchiveJs = $(".asset-archive-js");
    assetArchiveJs.each(function(){
        var thisTotalEntry = $(this).find(".searchTotal").val();
        $(this).find(".filtro-numbers span").text(thisTotalEntry);
    });
}
function collapseMultiTab(){
    $('.multitab-title').on('click', function(e) {
        if(!$(this).hasClass("tab-active")){
            var assetReference = $(this).data("asset-id");
            $('.multitab-title').removeClass("tab-active");
            $(".asset-archive-js").hide();
            $("#" + assetReference).closest(".asset-archive-js").show();
            $(this).addClass("tab-active");
        }
    });
}
$(document).ready(function(){
    showHideFilterBar();
    manageUrlParameter ();
    assetCounter ();
    collapseMultiTab();

    $(".filtro-body-box .btn-filter-reset").on("click",function(){
        window.location = urlLocation;
    });
    $('.filtro-body-box .text-search').bind("enterKey",function(e){
        var btn = $(this);
        searchKeywords(btn);
    });
    $('.filtro-body-box .text-search').keyup(function(e){
        if(e.keyCode == 13){
          $(this).trigger("enterKey");
        }
    });
    $(".filtro-category .button-primary").on("click",function(){
        var btn = $(this);
        searchCategory(btn);
    });
    $(".filtro-body-box .icomoon-search").on("click",function(){
        var btn = $(this);
        searchKeywords(btn);
    });
});