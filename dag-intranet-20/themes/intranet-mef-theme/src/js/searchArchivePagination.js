var currentUrl = location.href;
var baseUrl = currentUrl.split("?")[0];
/* Function show Ide Filter Bar */
function showHideFilterBar(){
    if(location.href.indexOf("keywords=") > -1 || location.href.indexOf("categories=") > -1){
        $(".filtro-body-box .labels-container").show();
    }
    else{
        $(".filtro-body-box .labels-container").hide();
    }
};

/* Reading Url and set custom item search bar */
function manageUrlParameter (){
	if(location.href.indexOf("categories=") !=-1){
		var categoryList = location.href.split("categories=")[1].split("&")[0];
		var singleCategory = categoryList.split(",");
		for (var i = 0; i < singleCategory.length; i++) {
			var aData = singleCategory[i];
			$(".filtro-body-box .filter-category-item-box").each(function(){
				if(aData == $(this).data("category-id")){
					$(this).addClass("active");
				}
			});
		}
		$(".filtro-body-box .filter-category-item-box").each(function(){
			if($(this).hasClass("active")){
				var thisText = $(this).text();
				$('.labels-container-title').append('<div class="filter-label-item text-uppercase"><h2>' + thisText + '</h2></div>');
			}
		});
	}
	if(location.href.indexOf("keywords=") !=-1){
        var keywordsList = location.href.split("keywords=")[1].split("&index=")[0];
        var singleKeywords = keywordsList.split(",");
        for (var i = 0; i < singleKeywords.length; i++) {
            var aKey = singleKeywords[i];
            var decoded = decodeURIComponent(aKey);
            $('.labels-container-title').append('<div class="filter-label-item text-uppercase"><h2>' + decoded + '</h2></div>');
        }
    }
};
function searchCategory (){
	if($('.filter-category-item-box.active').length > 0){
		var portletId = $(".filtro-body-box").parents("section").attr("id").substring(8);
	    var ppid = "p_p_id=" + portletId;
	    var pplifecycle = "p_p_lifecycle=0";
	    var ppstate = "p_p_state=normal";
	    var ppmode = "p_p_mode=view";
	    var costantsUrl = "&"+ppid+"&"+pplifecycle+"&"+ppstate+"&"+ppmode;
	    var indexTabActive = "&index="+$(".tab-filtri .filtro-tabs-wrapper .tab-title.active").index();
	    var categoryArray = [];
        $(".filtro-body-box .filter-category-item-box.active").each(function(){
            var categoryId = $(this).data("category-id");
            categoryArray.push(categoryId);
        });
        var categoriesItems = categoryArray.join(",");
        if(location.href.indexOf("_categories=") ==-1 && location.href.indexOf("keywords=") ==-1){
            var indexTabActive = "&index="+$(".tab-filtri .filtro-tabs-wrapper .tab-title.active").index();
            window.location = baseUrl+"?_"+portletId+"_categories="+categoriesItems+indexTabActive+costantsUrl;
        }
        else if(location.href.indexOf("_categories=") !=-1 && location.href.indexOf("keywords=") ==-1){
        	var indexTabActive = "&index="+$(".tab-filtri .filtro-tabs-wrapper .tab-title.active").index();
            window.location = baseUrl+"?_"+portletId+"_categories="+categoriesItems+indexTabActive+costantsUrl;
        }
        else if(location.href.indexOf("_categories=") !=-1 && location.href.indexOf("keywords=") !=-1){
        	var indexTabActive = "&index="+$(".tab-filtri .filtro-tabs-wrapper .tab-title.active").index();
        	var keywords = location.href.split("keywords=")[1].split("&index=")[0];
        	window.location = baseUrl+"?_"+portletId+"_categories="+categoriesItems+"&_"+portletId+"_keywords="+keywords+indexTabActive+costantsUrl;
        }
        else if(location.href.indexOf("_categories=") ==-1 && location.href.indexOf("keywords=") !=-1){
        	var indexTabActive = "&index="+$(".tab-filtri .filtro-tabs-wrapper .tab-title.active").index();
        	var keywords = location.href.split("keywords=")[1].split("&index=")[0];
        	window.location = baseUrl+"?_"+portletId+"_categories="+categoriesItems+"&_"+portletId+"_keywords="+keywords+indexTabActive+costantsUrl;
        }
	}
}
function searchKeywords(){
    if($('.text-search-wrap .text-search').val() != ""){
        var portletId = $(".filtro-body-box").parents("section").attr("id").substring(8);
	    var ppid = "p_p_id=" + portletId;
	    var pplifecycle = "p_p_lifecycle=0";
	    var ppstate = "p_p_state=normal";
	    var ppmode = "p_p_mode=view";
	    var costantsUrl = "&"+ppid+"&"+pplifecycle+"&"+ppstate+"&"+ppmode;
	    var indexTabActive = "&index="+$(".tab-filtri .filtro-tabs-wrapper .tab-title.active").index();
	    var categoryArray = [];
        $(".filtro-body-box .filter-category-item-box.active").each(function(){
            var categoryId = $(this).data("category-id");
            categoryArray.push(categoryId);
        });
        var categoriesItems = categoryArray.join(",");
        var keywords = $('.text-search-wrap .text-search').val();
        var replaceSpace = keywords.trim().replace(/[&|?|=]/g,'-').replace(/\s\s+/g, ' ').replace(/ +/g,",");
        if(location.href.indexOf("_categories=") ==-1 && location.href.indexOf("keywords=") ==-1){
            var indexTabActive = "&index="+$(".tab-filtri .filtro-tabs-wrapper .tab-title.active").index();
            window.location = baseUrl+"?_"+portletId+"_keywords="+replaceSpace+indexTabActive+costantsUrl;
        }
        else if(location.href.indexOf("_categories=") !=-1 && location.href.indexOf("keywords=") ==-1){
        	var indexTabActive = "&index="+$(".tab-filtri .filtro-tabs-wrapper .tab-title.active").index();
            window.location = baseUrl+"?_"+portletId+"_categories="+categoriesItems+"&_"+portletId+"_keywords="+replaceSpace+indexTabActive+costantsUrl;
        }
        else if(location.href.indexOf("_categories=") !=-1 && location.href.indexOf("keywords=") !=-1){
        	var indexTabActive = "&index="+$(".tab-filtri .filtro-tabs-wrapper .tab-title.active").index();
        	var keywords = location.href.split("keywords=")[1].split("&index=")[0];
        	window.location = baseUrl+"?_"+portletId+"_categories="+categoriesItems+"&_"+portletId+"_keywords="+replaceSpace+indexTabActive+costantsUrl;
        }
        else if(location.href.indexOf("_categories=") ==-1 && location.href.indexOf("keywords=") !=-1){
        	var indexTabActive = "&index="+$(".tab-filtri .filtro-tabs-wrapper .tab-title.active").index();
        	var keywords = location.href.split("keywords=")[1].split("&index=")[0];
            window.location = baseUrl+"?_"+portletId+"_keywords="+replaceSpace+indexTabActive+costantsUrl;
        	//window.location = baseUrl+"?_"+portletId+"_categories="+categoriesItems+"&_"+portletId+"_keywords="+replaceSpace+indexTabActive+costantsUrl;
        }
    }
};
$(window).on("load", function(){
    setTimeout(function(){
        if($(".tab-filtri .filtro-tabs-wrapper .tab-title").length > 1){
            var indexParam = location.href.split("index=")[1];
            $(".tab-filtri .filtro-tabs-wrapper .tab-title").each(function(index){
                if(indexParam == index){
                    $(this).click();
                }
            });
        }
    },200);
});
function modifyUrlPagination (){
	var URL = location.href;
	setTimeout(function(){
		if((location.href.indexOf("categories=") !=-1) || (location.href.indexOf("keywords=") !=-1)){
			var splittedURL = URL.split("&p_p_mode=view")[0];
			$(".taglib-page-iterator .lfr-pagination .lfr-pagination-buttons li").not(".disabled").each(function(){
				var pageLink = $(this).find("a").attr('href');
				var linkSPlitter = pageLink.split("&").pop();
				var finalUrl = splittedURL+"&p_p_mode=view&"+linkSPlitter;
				$(this).find("a").on("click",function(e){
					e.preventDefault();
					window.location =finalUrl;
				})
			});
		}
	},500);
}

$(document).ready(function(){
    showHideFilterBar();
    manageUrlParameter();
    modifyUrlPagination();

    $(".filtro-body-box .btn-filter-reset").on("click",function(){
        window.location = baseUrl;
    });
    $('.filtro-body-box .text-search').bind("enterKey",function(e){
        searchKeywords();
    });
    $('.filtro-body-box .text-search').keyup(function(e){
        if(e.keyCode == 13){
          $(this).trigger("enterKey");
          searchKeywords();
        }
    });
    $(".filtro-category .button-primary").on("click",function(){
        searchCategory();
    });
    $(".filtro-body-box .icomoon-search").on("click",function(){
        searchKeywords();
    });
});