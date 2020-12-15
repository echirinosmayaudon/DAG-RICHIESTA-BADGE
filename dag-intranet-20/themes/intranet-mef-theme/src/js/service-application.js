var user_id = $('.scivania-wrapper#currentId').attr("data-userid");

/* counter click*/
function showError(text){
    $('#modalErrorDesktop').modal({
        show: true
        });
    $("#modalErrorDesktop").find(".modal-body").find(".text").text(text);

    $(".icon-close-error-desktop").on("click", function(){
        $("#modalErrorDesktop").modal("hide");
    });
    $(".btn-close").on("click", function(){
        $("#modalErrorDesktop").modal("hide");
    });   
}

/* Service increase Hit counter for application */
$(".click-favourites-service").on("click", function () {
    var btn = $(this);
    var  userIdAttr = btn.attr("data-userid");
    var  applicationIdAttr = btn.attr("data-journalArticleId");
    Liferay.Service('/mefserv.utilizzoapplicazioni/add-new-hit', {
        userId: userIdAttr,
        applicationId: applicationIdAttr
    }, function (obj) {
        console.log(obj);
    });
});



/* Service application HomePage Box */
if($(".application-home-service").length > 0){
    $(".application-home-service").on("click", function () {
        var btn = $(this);
        var  userIdAttr = btn.attr("data-userid");
        var  applicationIdAttr = btn.attr("data-journalArticleId");
        /* Service remove  application HomePage Box */
        if(btn.hasClass('remove-home-service')){
            try{
                var elem = btn.children(".icomoon-plus");
                elem.removeClass("selected");
                btn.removeClass("remove-home-service");
                Liferay.Service('/mefserv.scrivania/remove-app-from-home', {
                    userId: userIdAttr,
                    applicationId: applicationIdAttr
                }, function (obj) {
                      console.log(obj);
                });
            }
            catch(err) {
                console.log("error");
            }
        }
        /* Service add application HomePage Box */
        else{
            Liferay.Service('/mefserv.scrivania/get-home-apps', {
                userId: user_id
                }, function (obj) {
                    var objString = obj;
                    // var objArray = obj.split(";").length;
                    var objArray = $("button.remove-home-service.application-home-service").length;
                    if(objArray < 8){
                        var elem = btn.children(".icomoon-plus");
                        elem.addClass("selected");
                        btn.addClass("remove-home-service");
                        Liferay.Service('/mefserv.scrivania/add-app-to-home', {
                            userId: userIdAttr,
                            applicationId: applicationIdAttr
                        }, function (obj) {
                              console.log(obj);
                        });
                    }else{
                        showError("Hai raggiunto il numero massimo di elementi previsti per ‘Scrivania Home’");
                    }
                });
            }
    });
};

/* Service application Profile Box */
if($(".application-profile-service").length > 0){
    $(".application-profile-service").on("click", function () {
        var btn = $(this);
        var  userIdAttr = btn.attr("data-userid");
        var  applicationIdAttr = btn.attr("data-journalArticleId");
        /* Service  remove application Profile Box */
        if(btn.hasClass('remove-profile-service')){
            try{
                var elem = btn.children(".icomoon-plus");
                elem.removeClass("selected");
                btn.removeClass("remove-profile-service");
               Liferay.Service('/mefserv.scrivania/remove-app-from-profile', {
                    userId: userIdAttr,
                    applicationId: applicationIdAttr
                }, function (obj) {
                      console.log(obj);
                }); 
            }
             catch(err) {
                console.log("error");
            }
        }
        /* Service add application Profile Box */
        else{
            Liferay.Service('/mefserv.scrivania/get-profile-apps', {
            userId: user_id
            }, function (obj) {
                var objString = obj;
                var objArray = obj.split(";").length;
                if(objArray < 17){
                    var elem = btn.children(".icomoon-plus");
                    elem.addClass("selected");
                    btn.addClass("remove-profile-service");
                    Liferay.Service('/mefserv.scrivania/add-app-to-profile', {
                        userId: userIdAttr,
                        applicationId: applicationIdAttr
                        }, function (obj) {
                              console.log(obj);
                    });
                }else{
                    showError("Hai raggiunto il numero massimo di elementi previsti per la ‘La Mia Scrivania’");
                }
            });
        }
    });
};
/* Service application HomePage  */
if($(".scivania-wrapper").length > 0){
    Liferay.Service('/mefserv.scrivania/get-home-apps', {
        userId: user_id
        }, function (obj) {
            if(obj != ""){
                var objString = obj;
                var objArray = obj.split(";");
                $(".application-home-service").each(function(elem){
                    var itemArticleId = $(this).attr("data-journalArticleId");
                    for (var i in objArray){
                         if(itemArticleId == objArray[i]){
                            $(this).addClass("remove-home-service");
                            $(this).children(".icomoon-plus").addClass("selected");
                         }
                    }
                });
            }
            console.log(obj)
        });
    /* Service application Profile  */
    Liferay.Service('/mefserv.scrivania/get-profile-apps', {
        userId: user_id
        }, function (obj) {
             if(obj != ""){
                var objString = obj;
                var objArray = obj.split(";");
                $(".application-profile-service").each(function(elem){
                    var itemArticleId = $(this).attr("data-journalArticleId");
                    for (var i in objArray){
                         if(itemArticleId == objArray[i]){
                            $(this).addClass("remove-profile-service");
                            $(this).children(".icomoon-plus").addClass("selected");
                         }
                    }
                });
            }
            console.log(obj);
        });
};
/* Service increase Hit counter for multimedia */
$(".click-multimedia-service").on("click", function () {
    var btn = $(this);
    var  applicationIdAttr = btn.attr("data-journalArticleId");
    Liferay.Service('/mefserv.utilizzoapplicazioni/add-new-media-hit', {
        applicationId: applicationIdAttr
    }, function (obj) {
        console.log(obj);
    });
});
/* Service invoce Hit  for multimedia */
if($(".multimedia-service").length > 0) {
    Liferay.Service(
        '/mefserv.utilizzoapplicazioni/fetch-last-media-hits',
        function (obj) {
                if($(".multimedia-service .multimedia-service-count").length > 0) {
                    obj.forEach(function (e) {
                        $(".multimedia-service .multimedia-service-count .hit-multimedia").each(function () {
                            var thisApplication = $(this).attr("data-service-it");
                            if (thisApplication == e.applicationId) {
                                if (e.hitsCount == "1") {
                                    var visualizzazioneText = "visualizzazione";
                                }
                                else {
                                    var visualizzazioneText = "visualizzazioni";
                                }
                                $(this).text(e.hitsCount + " " + visualizzazioneText);
                            }
                        });
                    });
                }
                if($(".multimedia-service .multimedia-service-item-count").length > 0) {
                    obj.forEach(function (e) {
                        $(".multimedia-service .multimedia-service-item-count").each(function () {
                            var thisApplication = $(this).find(".hit-multimedia").attr("data-service-it");
                            if (thisApplication == e.applicationId) {
                                if (e.hitsCount == "1") {
                                    var visualizzazioneText = " visita";
                                }
                                else {
                                    var visualizzazioneText = " visite";
                                }
                                $(this).find(".hit-multimedia").text(e.hitsCount);
                                $(this).find(".span-info").text(visualizzazioneText);
                            }
                        });
                    });
                };
            console.log(obj);
        }
    );
}

