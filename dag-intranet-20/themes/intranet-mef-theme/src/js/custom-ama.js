require(['jquery', 'moment','it','datetimepicker','slick','parsley','selectpicker', 'dotdotdot','multiselect'], function ($) {
require(['photoswipe','photoswipeUiDefault'], function (PhotoSwipe,PhotoSwipeUI_Default) {

var bookmark = $('#bookmarkId').val();
if(bookmark != "-1"){
    $('.btn-star-bookmarks').removeClass("icomoon-star");
    $('.btn-star-bookmarks').addClass("icomoon-star-color");
    $('.btn-star-bookmarks').addClass("bookmark-active");
    $('.btn-star-bookmarks').attr("data-id-bookmark", bookmark);
}

$(".btn-star-bookmarks").off('click').on("click", function () {
    var btn = $(this);

    if(btn.hasClass('bookmark-active')){
        $('#modal-remove-bookmarks').modal('show');
        $('#btn-remove-bookmarks-ok').off('click').on('click',function(){
            btn.removeClass('bookmark-active');
            btn.removeClass('icomoon-star-color');
            btn.addClass('icomoon-star');

            Liferay.Service('/mefintranet.favourites/delete-favourite', {
                favourite_id: btn.attr("data-id-bookmark")
            }, function (obj) {
                $('#modal-remove-bookmarks').modal('hide');

                /* SCRIPT PER ELIMINARE DIV DA WIDGET HEADER */
                $.each($('#bookmark-widget-block .widget-favourites'),function(){
                    if($(this) != undefined && ($(this).find('span').attr('data-id-bookmark') === btn.attr("data-id-bookmark"))){
                        $(this).closest('.ama-col-md-3').remove();
                    }
                })
            });
        });

    }else{
        var setFavTitle = document.title;
        var setFavUrl = window.location.href;
        var setFavDate = new Date().toString();

        setFavTitle = $.trim(setFavTitle).substring(0, 49);

        $('#bookmark-url').val(setFavUrl);
        $('#bookmark-name').val(setFavTitle);
        $('#error-bookmark-url').removeClass('err-visible');
        $('#error-bookmark-name').removeClass('err-visible');

        $('#modal-bookmarks-edit').modal('show');


        $('#bookmark-save-edit').off('click').on("click", function () {
            $('#error-bookmark-url').removeClass('err-visible');
            $('#error-bookmark-name').removeClass('err-visible');

            setFavTitle = $('#bookmark-name').val();
            setFavUrl = $('#bookmark-url').val();

            if(setFavUrl == "" || setFavTitle == ""){
                if(setFavUrl == ""){
                    $('#error-bookmark-url').addClass('err-visible');
                }

                if(setFavTitle == ""){
                    $('#error-bookmark-name').addClass('err-visible');
                }
            }else{
                Liferay.Service('/mefintranet.favourites/set-favourite', {
                    user_id: $('#currentId').val(),
                    title_favourite: setFavTitle,
                    url_favourite: setFavUrl,
                    save_date: setFavDate
                }, function (obj) {

                    if (obj === true) {

                        Liferay.Service('/mefintranet.favourites/get-fav-by-url', {
                            user_id: $('#currentId').val(),
                            friendlyUrl_page: setFavUrl
                        }, function (ob) {
                            btn.attr("data-id-bookmark",ob);
                            var dialogbutton2 = $(".btnClass");
                            dialogbutton2.val(ob);
                            dialogbutton2.html("&#9733;");
                            setIdBookmark = ob;

                            /* SCRIPT PER AGGIUNGERE DIV A WIDGET HEADER 
                            $("#bookmark-widget-block").prepend("<div class=\"ama-col-md-3\">"+
                                "<a href=\""+ setFavUrl +"\" class=\"widget-white widget-favourites\">"+
                                "<p class=\"widget-title dot-point max-dot-85\" style=\"word-wrap: break-word;\">"+ setFavTitle +"</p>"+
                                "<span data-id-bookmark=\"" + ob + "\" class=\"icomoon-star-color\"></span>"+
                                "</a>"+
                                "</div>");
                            */
                            $("#bookmark-widget-block .widget-favourites span").off('click').on('click',function(e){
                                e.preventDefault();
                                e.stopPropagation();

                                deleteBookmarksOverlay(this);
                            });

                            $(".preferiti-elenco-wrapper .widget-favourites span").off('click').on('click',function(e){
                                e.preventDefault();
                                e.stopPropagation();

                                deleteBookmarksFromPage(this);
                            });
                        });
                        //window.alert("Succesfully saved in Favourites!");
                        $('#modal-bookmarks-edit').modal('hide');
                        $('#modal-add-bookmarks').modal('show');
                        btn.addClass('bookmark-active');
                        btn.addClass('icomoon-star-color');
                        btn.removeClass('icomoon-star');
                    }
                });

            }
        });
    }
});


function deleteBookmarksFromPage(obj){
    var btn = $(obj);

    $('#modal-remove-bookmarks').modal('show');
    $('#btn-remove-bookmarks-ok').off('click').on('click',function(){
        var id = btn.attr('data-id-bookmark');

        /* SCRIPT PER ELIMINARE DIV DA WIDGET HEADER */
        $.each($('#bookmark-widget-block .widget-favourites'),function(){
            if($(this).find('span').attr('data-id-bookmark') === id){
                $(this).closest('.ama-col-md-3').remove();
            }
        });


        btn.closest('.ama-col-md-3').remove();

        if($('.preferiti-elenco-wrapper').length > 0){
            $('#number-bookmark').html($('.preferiti-elenco-wrapper .item-pagination').length);
        }

        Liferay.Service('/mefintranet.favourites/delete-favourite', {
            favourite_id: id
        }, function (obj) {
            $('#modal-remove-bookmarks').modal('hide');
        });
    });
}

function deleteBookmarksOverlay(obj){
    var btn = $(obj);

    $('#modal-remove-bookmarks').modal('show');
    $('#btn-remove-bookmarks-ok').off('click').on('click',function(){
        var id = btn.attr('data-id-bookmark');

        if(id === $('.btn-star-bookmarks').attr('data-id-bookmark')){
            $('.btn-star-bookmarks').removeClass('bookmark-active');
            $('.btn-star-bookmarks').removeClass('icomoon-star-color');
            $('.btn-star-bookmarks').addClass('icomoon-star');
        }

        btn.closest('.ama-col-md-3').remove();

        if($('.preferiti-elenco-wrapper').length > 0){

            /* SCRIPT PER ELIMINARE DIV DA LISTA PREFERITI */
            $.each($('.preferiti-elenco-wrapper .widget-favourites'),function(){
                if($(this).find('span').attr('data-id-bookmark') === id){
                    $(this).closest('.ama-col-md-3').remove();
                }
            });

            $('#number-bookmark').html($('.preferiti-elenco-wrapper .item-pagination').length);
        }

        Liferay.Service('/mefintranet.favourites/delete-favourite', {
            favourite_id: id
        }, function (obj) {
            $('#modal-remove-bookmarks').modal('hide');
        });
    });
}

$("#bookmark-widget-block .widget-favourites span").off('click').on('click',function(e){
    e.preventDefault();
    e.stopPropagation();

    deleteBookmarksOverlay(this);
});

$(".preferiti-elenco-wrapper .widget-favourites span").off('click').on('click',function(e){
    e.preventDefault();
    e.stopPropagation();

    deleteBookmarksFromPage(this);
});


window.Parsley
    .addValidator('compareSumbissionExpirationDate',{
        requirementType : 'string',
        validateString : function(value, requirement) {
            var requirementSplit = $(requirement).val().split("/");
            var value = $("#Deadline");
            var valueSplit = $(value).val().split("/");

            submissionDate = new Date(requirementSplit[2], requirementSplit[1] - 1, requirementSplit[0]);
            expirationDate = new Date(valueSplit[2], valueSplit[1] - 1, valueSplit[0]);

            if ($(requirement).val() == null || $(requirement).val() == "") {
                $("#Deadline").val(null);
                $(value).val(null);
            }
            else {
                if (expirationDate < submissionDate) {
                    return false;
                }
                else {
                    return true;
                }
            }
        },
        messages : {
            it: Liferay.Language.get("error-check-expiration-date"),
            en: Liferay.Language.get("error-check-expiration-date")

        }
    })
    .addValidator('submissionDateCheck', {
        requirementType : 'string',
        validateString :function(value, requirement){
            var requirementSplit = $(requirement).val().split("/");
            submissionDate = new Date(requirementSplit[2], requirementSplit[1] - 1, requirementSplit[0]);
            var today = new Date();
            yesterday = today.setDate(today.getDate() - 1);

            if( submissionDate < yesterday) {
                return false;
            }

            return true;

        },
        messages : {
            it: Liferay.Language.get("error-compare-submission-expiration-date"),
            en: Liferay.Language.get("error-compare-submission-expiration-date")
        }
    })
    .addValidator('checkStartDate', {
        requirementType : 'string',
        validateString :function(value, requirement){
            if($(requirement).val() != null && $(requirement).val() != "") {
                return true;
            }

            return false;
        },
        messages : {
            it: Liferay.Language.get("error-check-submission-date"),
            en: Liferay.Language.get("error-check-submission-date")
        }
    })
    .addValidator('checkhour', {
        requirementType: 'string',
        validateString: function(value, requirement) {
            var hourDay = value.split(":");
            var to = $(requirement).val().split("/");
            submissionDate =  new Date(to[2], to[1] - 1, to[0]);
            submissionDate.setHours(hourDay[0], hourDay[1]);

            if (submissionDate < (new Date())) {
                return false;
            }
            else {
                return true;
            }
        },
        messages: {
            it: Liferay.Language.get("error-hour-compare-date"),
            en: Liferay.Language.get("error-hour-compare-date")
        }
    })
    .addValidator('checkYearAfterToday', {
        requirementType : 'string',
        validateString: function(value, required) {
            var today = new Date();

            var submissionDateSplit = value.split("/");

            valueYear = submissionDateSplit[2];

            if (valueYear == (today.getFullYear()-1)) {
                return true;
            }
            else {
                return false;
            }
        },
        messages: {
            it: Liferay.Language.get("error-check-year-after-today"),
            en: Liferay.Language.get("error-check-year-after-today")
        }
    })
    .addValidator('checkBirthdayChild', {
        requirementType : 'string',
        validateString: function(value, required) {
            var today = new Date();

            var submissionDateSplit = value.split("/");

            valueYear = submissionDateSplit[2];
            if (valueYear > (today.getFullYear()-1)) {
                return false;
            }
            else {
                return true;
            }
        },
        messages: {
            it: Liferay.Language.get("error-check-child-birthday"),
            en: Liferay.Language.get("error-check-child-birthday")
        }
    })
    .addValidator('filemaxmegabytes', {
        requirementType: 'string',
        validateString: function (value, requirement, parsleyInstance) {
        var file = parsleyInstance.$element[0].files;
        var maxBytes = requirement * 1048576;
        if (file.length == 0) {
            return true;
        }
        var flagReturn = file.length === 1 && file[0].size <= maxBytes;
        var stringMessage = Liferay.Language.get('error-max-dimension-file');
        if (requirement.toString()!="")
            stringMessage += " " + requirement.toString()+"MB";
            window.Parsley.addMessage('en', 'filemaxmegabytes',stringMessage);
            window.Parsley.addMessage('it', 'filemaxmegabytes',stringMessage);
            return flagReturn;
        }
    })
    .addValidator('filemimetypes', {
        requirementType: 'string',
        validateString: function (value, requirement, parsleyInstance) {


            var file = parsleyInstance.$element[0].files;

            if (file.length == 0) {
                return true;
            }

            var allowedMimeTypes = requirement.replace(/\s/g, "").split(',');
            var flagReturn = allowedMimeTypes.indexOf(file[0].type) !== -1;

            return flagReturn;

        },
        messages: {
            it: Liferay.Language.get('error-file-attach'),
            en: Liferay.Language.get('error-file-attach')
        }
    })
    .addValidator('checkDateRole', {
        requirementType: 'string',
        validate: function(value, requirement, istance){
            var esito = false;
            $(".box-beni-inventariati").each(function() {
                if ($(this).is(".active")){
                    esito = true;
                }
            });

            if(($("#nomeRichiedente").val()!=null && $("#nomeRichiedente").val()!="") || ($("#cognomeRichiedente").val()!=null && $("#cognomeRichiedente").val()!="") || ($("#dipartimento").val()!=null && $("#dipartimento").val()!="") || $("#idRichiestaResearch").val()!="" || $("#date-deadline").val()!="" || $("#tipologia")[0].selectedIndex > 0 || document.getElementById('squaredOne').checked || esito!=false) {
                return true;
            }
            else {
                return false;
            }
        },
        messages : {
            it: Liferay.Language.get('mandatory-field-error'),
            en: Liferay.Language.get('mandatory-field-error')
        }
    })
     .addValidator('filecheckwithoutextension', {
        requirementType: 'string',
            validateString: function (value, requirement, parsleyInstance) {
            var file = parsleyInstance.$element[0].files;
            var numberPoint = file[0].name.lastIndexOf(".");
            var ext = file[0].name.substring(numberPoint);
            ext = ext.toLowerCase();
            if (file.length == 0) {
                return true;
            }

            var allowedMimeTypes = requirement.replace(/\s/g, "").split(',');
            var flagReturn = allowedMimeTypes.indexOf(ext) !== -1;

            var stringMessage = Liferay.Language.get('error-file-attach-extensions');
            if (allowedMimeTypes.toString()!="")
                stringMessage += ": " + allowedMimeTypes.toString();

            window.Parsley.addMessage('en', 'filecheckwithoutextension',stringMessage);
            window.Parsley.addMessage('it', 'filecheckwithoutextension',stringMessage);
            return !flagReturn;
        }
    })
    .addValidator('checkTotalMegabyte', {
        requirementType: 'string',
        validateString: function (value, requirement, parsleyInstance) {
            var dimMaxFiles = requirement * 1048576;
            var countFilesDimension = 0;
            var count = 0;

            $(parsleyInstance.$element).find('.parsley-megabyte-total-validator').each(function(){
                if ($(this).length>0 && $(this)[0].files.length>0){
                    countFilesDimension += $(this)[0].files[0].size;
                }
            });

            if(countFilesDimension > dimMaxFiles) {
                return false;
            }
            else
                return true;
        },
        messages: {
            it: Liferay.Language.get('error-file-attach-max-dim'),
            en: Liferay.Language.get('error-file-attach-max-dim')
        }
    })
    .addValidator('checkChildren', {
        requirementType: 'integer',
        validate: function(value, requirement, instance) {
            for(var i = 1; i <= requirement; i++)
            if ($("#inputLastname").val()!="" || $("#qualification")[0].selectedIndex > 0 || $("#structure-one")[0].selectedIndex > 0)
            return true;
            return false;
        },
        messages : {
            it: '<liferay-ui:message key="error-rubrica-at-least-one-field-message"/>',
            en: '<liferay-ui:message key="error-rubrica-at-least-one-field-message"/>'
        }
    })
    .addValidator('checkFieldsOrValidator', {
        requirementType: 'string',
        validate: function(value, requirement, parsleyInstance){
            var esito = false;
            $(parsleyInstance.$element).find('.parsley-or-validator-field').each(function(){
                if ($(this).val()!=null &&  $(this).val()!=""){
                    esito = true;
                }
            });
            var arrayLabel = [];
            $(parsleyInstance.$element).find('.parsley-or-validator-label').each(function(){
                arrayLabel.push($(this).text());
            });
            var stringMessage = Liferay.Language.get('mandatory-field-error');
            if (arrayLabel.toString()!="") {
                stringMessage += ": " + arrayLabel.toString();
                stringMessage = stringMessage.replace(",",", ");
            }
            window.Parsley.addMessage('en', 'checkFieldsOrValidator',stringMessage);
            window.Parsley.addMessage('it', 'checkFieldsOrValidator',stringMessage);
            return esito;
        }
    })
    .addValidator('checkFileAttachExtension', {
        requirementType: 'string',
        validateString: function (value, requirement, parsleyInstance) {
            var file = parsleyInstance.$element[0].files;
            var numberPoint = file[0].name.lastIndexOf(".");
            var ext = file[0].name.substring(numberPoint);
            ext = ext.toLowerCase();
            if (file.length == 0) {
                return true;
            }
            var allowedMimeTypes = requirement.replace(/\s/g, "").split(',');
            var flagReturn = allowedMimeTypes.indexOf(ext) !== -1;
            var stringMessage = Liferay.Language.get('error-file-attach');
            if (allowedMimeTypes.toString()!="")
                stringMessage += ": " + allowedMimeTypes.toString();
            window.Parsley.addMessage('en', 'checkFileAttachExtension',stringMessage);
            window.Parsley.addMessage('it', 'checkFileAttachExtension',stringMessage);
            return flagReturn;
         }
    })
    .addValidator('submissionDateInizioFineCheck', {
        requirementType : 'string',
        validateString :function(value, requirement){
            var returnValue = true;
            if($('#start').val().includes(":") && $('#end').val().includes(":")){
                var oraInizioSplit = $('#start').val().split(":");
                var oraFineSplit = $('#end').val().split(":");
                if(oraInizioSplit[0] > oraFineSplit[0]){
                    returnValue = false;
                }else if(oraInizioSplit[0] == oraFineSplit[0]){
                    if(oraInizioSplit[1] >= oraFineSplit[1]){
                        returnValue = false;
                    }
                }
            }

            return returnValue;

        },
        messages : {
            it: Liferay.Language.get("error-compare-submission-expiration-hours"),
            en: Liferay.Language.get("error-compare-submission-expiration-hours")
        }
    })

    .addValidator('submissionPostiSalaCheck', {
        requirementType : 'string',
        validateString :function(value, requirement){
            var returnValue = true;
            var numeroPartecipanti = $(requirement).val();
            var capienza_sala = 0;
            var posti_sala_modifica = $("#numeroPostiSalaModifica").val();
            var posti_sala_inserimento = $("#numeroPostiSalaInserimento").val();
            if(posti_sala_modifica != null && posti_sala_modifica != 0){
                capienza_sala = posti_sala_modifica;
            }else if(posti_sala_inserimento != null && posti_sala_inserimento != ""){
                capienza_sala = posti_sala_inserimento;
            }
            if(parseInt(capienza_sala) < parseInt(numeroPartecipanti)){
                returnValue = false;
            }
            return returnValue;

        },
        messages : {
            it: Liferay.Language.get("error-check-posti-aula"),
            en: Liferay.Language.get("error-check-posti-aula")
        }
    })

    .addValidator('submissionDataInizioEqTodayCheck', {
        requirementType : 'string',
        validateString :function(value, requirement){
            var returnValue = true;
            var requirementSplit;
            var dataInizioId = requirement.concat("data");
            if(typeof dataInizioId !== "undefined" && $(dataInizioId).val().includes("/")){
                requirementSplit = $(dataInizioId).val().split("/");
            }else{
                var requirementValue = $("#data").val();
                if( typeof requirementValue !== "undefined" && requirementValue.includes("/")){
                    requirementSplit = requirementValue.split("/");
                }
            }
            submissionDate = new Date(requirementSplit[2], requirementSplit[1] - 1, requirementSplit[0]);
            var today = new Date();
            var todayDay = today.getDate();
            var todayMonth = today.getMonth() + 1;
            var todayYear = today.getFullYear();
            var submissionDateDay = submissionDate.getDate();
            var submissionDateMonth = submissionDate.getMonth() + 1;
            var submissionDateYear = submissionDate.getFullYear();
            if(todayDay == submissionDateDay && todayMonth == submissionDateMonth && todayYear == submissionDateYear){
                var oraInizioId = requirement.concat("oraInizio");
                var oraInizio = $(oraInizioId + " option:selected").text();
                var oraToday = today.getHours();
                if(oraInizio != null && oraToday != null && typeof oraInizio !== "undefined" && typeof oraToday !== "undefined"){
                    if(oraInizio.includes(":")){
                        var oraInizioSplit = oraInizio.split(":");
                        if(parseInt(oraInizioSplit[0]) <= parseInt(oraToday)){
                            returnValue = false;
                        }
                    }
                }
            }

            return returnValue;

        },
        messages : {
            it: Liferay.Language.get("error-check-data-ora-equals"),
            en: Liferay.Language.get("error-check-data-ora-equals")
        }
    })
    .addValidator('compareDataFineToInizio',{
        requirementType : 'string',
        validateString : function(value, requirement) {
            var requirementSplit = $(requirement).val().split("/");
            var value = $("#dataFineProrogaBadge");
            var valueSplit = $(value).val().split("/");
            submissionDate = new Date(requirementSplit[2], requirementSplit[1] - 1, requirementSplit[0]);
            expirationDate = new Date(valueSplit[2], valueSplit[1] - 1, valueSplit[0]);
            if ($(requirement).val() == null || $(requirement).val() == "") {
                $("#dataFineProrogaBadge").val(null);
                $(value).val(null);
            }
            else {
                if (expirationDate < submissionDate) {
                    return false;
                }
                else {
                    return true;
                }
            }
        },
        messages : {
            it: Liferay.Language.get('end-date-must-be-greater-than-start-date'),
            en: Liferay.Language.get('end-date-must-be-greater-than-start-date')
        }
    })
    .addValidator('newDeadlineCheck', {
      requirementType: 'string',
      validateString: function(value, requirement){
                var requirementSplit = $(requirement).val().split("/");
                newDeadline = new Date(requirementSplit[2], requirementSplit[1] - 1, requirementSplit[0]);
                var comparingValue = $("#validatorDataFine");
                var comparingValueSplit = $(comparingValue).val().split("/");
                comparingDate = new Date(comparingValueSplit[2], comparingValueSplit[1] - 1, comparingValueSplit[0]);
                if (newDeadline <= comparingDate) {
                    return false;
                } else {
                    return true;
                }
      },
        messages: {
                     it: Liferay.Language.get('new-deadline-must-be-greater-than-end-date'),
                     en: Liferay.Language.get('new-deadline-must-be-greater-than-end-date')
                   }
    });
    $('#ricercaAuleForm').parsley({
        inputs: Parsley.options.inputs + ',[data-parsley-check-date-role]'
    });

    $('#prenotaAula').parsley({
        inputs: Parsley.options.inputs + ',[data-parsley-check-date-role]'
    });

    $('#ricercaForm').parsley({
        inputs: Parsley.options.inputs + ',[data-parsley-check-date-role]'
    });

var user_id = $("#currentId").val();

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
    var  applicationIdAttr = btn.attr("data-journalArticleid");
    Liferay.Service('/mefserv.utilizzoapplicazioni/add-new-hit', {
        userId: userIdAttr,
        applicationId: applicationIdAttr
    }, function (obj) {
    });
});



/* Service application HomePage Box */
if($(".application-home-service").length > 0){
    $(".application-home-service").on("click", function () {
        var btn = $(this);
        var  userIdAttr = btn.attr("data-userid");
        var  applicationIdAttr = btn.attr("data-journalArticleid");
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
                });
            }
            catch(err) {
                console.log("error");
            }
        }
        /* Service add application HomePage Box */
        else{
            var objArray = $("button.remove-home-service.application-home-service").length;
            if(objArray < 8){
                var elem = btn.children(".icomoon-plus");
                elem.addClass("selected");
                btn.addClass("remove-home-service");
                Liferay.Service('/mefserv.scrivania/add-app-to-home', {
                    userId: userIdAttr,
                    applicationId: applicationIdAttr
                }, function (obj) {
                });
            }else{
                showError("Hai raggiunto il numero massimo di elementi previsti per ‘Scrivania Home’");
            }
        }
    });
};

/* Service application Profile Box */
if($(".application-profile-service").length > 0){
    $(".application-profile-service").on("click", function () {
        var btn = $(this);
        var  userIdAttr = btn.attr("data-userid");
        var  applicationIdAttr = btn.attr("data-journalArticleid");
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
                }); 
            }
             catch(err) {
                console.log("error");
            }
        }
        /* Service add application Profile Box */
        else{
            var objArray = $("button.remove-profile-service.application-profile-service").length;
            console.log("Scrivania"+objArray);
            if(objArray < 17){
                var elem = btn.children(".icomoon-plus");
                elem.addClass("selected");
                btn.addClass("remove-profile-service");
                Liferay.Service('/mefserv.scrivania/add-app-to-profile', {
                    userId: userIdAttr,
                    applicationId: applicationIdAttr
                    }, function (obj) {
                });
            }else{
                showError("Hai raggiunto il numero massimo di elementi previsti per la ‘La Mia Scrivania’");
            }
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
                    var itemArticleId = $(this).attr("data-journalArticleid");
                    for (var i in objArray){
                         if(itemArticleId == objArray[i]){
                            $(this).addClass("remove-home-service");
                            $(this).children(".icomoon-plus").addClass("selected");
                         }
                    }
                });
            }
        });
    /* Service application Profile  */
    Liferay.Service('/mefserv.scrivania/get-profile-apps', {
        userId: user_id
        }, function (obj) {
             if(obj != ""){
                var objString = obj;
                var objArray = obj.split(";");
                $(".application-profile-service").each(function(elem){
                    var itemArticleId = $(this).attr("data-journalArticleid");
                    for (var i in objArray){
                         if(itemArticleId == objArray[i]){
                            $(this).addClass("remove-profile-service");
                            $(this).children(".icomoon-plus").addClass("selected");
                         }
                    }
                });
            }
        });
};
/* Service increase Hit counter for multimedia */
$(".click-multimedia-service").on("click", function () {
    var btn = $(this);
    var  applicationIdAttr = btn.attr("data-journalArticleid");
    Liferay.Service('/mefserv.utilizzoapplicazioni/add-new-media-hit', {
        applicationId: applicationIdAttr
    }, function (obj) {
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
        }
    );
}



 function initNavBar() {

     checkIsDevice();
     
     $('.js-hamburger-menu').on('click',function(){
         if($(this).hasClass('selected')){
             $(this).removeClass('selected');
             $('.main-nav-fixed').removeClass('menu-mobile-open');
             $('#overlay-megamenu').removeClass('opened');
             $('body, html').removeClass('fixed-nav-open');
             setTimeout(function(){
                 resetNavMobile();
             },300);
         }else{
             $(this).addClass('selected');
             $('.main-nav-fixed').addClass('menu-mobile-open');
             $('#overlay-megamenu').addClass('opened');
             $('body, html').addClass('fixed-nav-open');
         }

         if($('.js-search-menu').hasClass('selected')){
             $('.js-search-menu').removeClass('selected');
             $('.search-wrap-mobile').addClass('hide');
         }
     });

     $('.js-search-menu').on('click',function(){
         if($(this).hasClass('selected')){
             $(this).removeClass('selected');
             $('.search-wrap-mobile').addClass('hide');
             $('#overlay-megamenu').removeClass('opened');
         }else{
             $(this).addClass('selected');
             $('.search-wrap-mobile').removeClass('hide');
             $('#overlay-megamenu').addClass('opened');
         }

         if($('.js-hamburger-menu').hasClass('selected')){
             $('.js-hamburger-menu').removeClass('selected');
             $('.main-nav-fixed').removeClass('menu-mobile-open');
             setTimeout(function(){
                 resetNavMobile();
                 $('#overlay-megamenu').addClass('opened');
             },300);
         }
     });

     $(window).resize(function(){
         waitForFinalEvent(function(){
             checkIsDevice();
         }, 500, "checkIsDevice");
     });
 }


 function checkIsDevice(){
     if($(window).width() < 999 || $('body').hasClass('mobile-device')){
         initNavMobile();

         if($('.main-nav-fixed .main-nav-first-level.active').length > 0){
             closeMegaMenu();
         }
     }else{
         setClickDesktop();

         if($('body').hasClass('fixed-nav-open')){
             closeMenuMobile();
         }
     }
 }



 function closeMenuMobile(){
     $('.main-nav-fixed .wrap-level').removeClass('move-in').removeClass('move-out').removeClass('overflow-visible');
     $('.main-nav-fixede').removeClass('menu-mobile-open');
     $('#overlay-megamenu').removeClass('opened');
     $('.js-hamburger-menu').removeClass('selected');
     $('.main-nav-fixed').removeClass('menu-mobile-open');
     $('body, html').removeClass('fixed-nav-open');
 }


 function setClickDesktop(){
     $('.main-nav-fixed .item-with-submenu .main-nav-first-level').off('click').on('click', function(e){
         e.preventDefault();
         if($(this).hasClass('active')){
             closeMegaMenu();
         }else{
             $('header').off('click');
             openMegaMenu($(this).closest('.item-with-submenu'));
         }
     });
 }

 function openMegaMenu($btn){
     $('.main-nav-fixed .main-nav-first-level').removeClass('active');
     $('.main-nav-fixed .item-with-submenu .main-nav-first-level').removeClass('active');
     $('.main-nav-fixed .item-with-submenu .main-nav-sub-menu').removeClass('active');

     $('.main-nav-fixed .main-nav-first-level').removeClass('active');
     $btn.find('.main-nav-first-level').addClass('active');
     $btn.find('.main-nav-sub-menu').addClass('active');
     $('#overlay-megamenu').addClass('opened').on('click',function(){
         closeMegaMenu();
     })

     var hSubMenu = $(window).height() - $('.mef-header').innerHeight() - 20 - $('.main-nav-sub-menu.active .box-go-section').innerHeight();

     if($('#ControlMenu').length > 0){
         hSubMenu = $(window).height() - $('#ControlMenu').innerHeight() - $('.mef-header').innerHeight() - 20 - $('.main-nav-sub-menu.active .box-go-section').innerHeight();
     }

     $('.main-nav-sub-menu .container-grid').css('max-height',hSubMenu);

     setTimeout(function(){
         $('header').on('click',function(e){
            if ($(e.target).parents(".second-menu-link").size() || $(e.target).parents(".third-menu").size()) {}
            else { 
              closeMegaMenu();
            }
         });
     },200);


 }

 function closeMegaMenu(){
     $('.main-nav-fixed .main-nav-first-level').removeClass('active');
     $('.main-nav-fixed .item-with-submenu .main-nav-first-level').removeClass('active');
     $('.main-nav-fixed .item-with-submenu .main-nav-sub-menu').removeClass('active');
     $('#overlay-megamenu').removeClass('opened').off('click');
     $('header').off('click');
     $('.main-nav-sub-menu .container-grid').removeAttr('style');
 }

 function resetNavMobile(){
     //$('.main-navbar-mobile li.dropdown-item').removeClass('active');
     $('.main-nav-fixed .wrap-level').removeClass('move-in').removeClass('move-out').removeClass('overflow-visible');
     $('.main-nav-fixede').removeClass('menu-mobile-open');
     $('#overlay-megamenu').removeClass('opened');
     $('.js-hamburger-menu').removeClass('selected');

     $('#overlay-megamenu').on('click',function(){
         closeMegaMenu();
     })
 }

 function initNavMobile(){

     $('.main-nav-fixed .main-nav-sub-menu').removeAttr('style');

     $('.main-nav-fixed .item-with-submenu .main-nav-first-level').off('click');

     $('.main-nav-fixed li.item-with-submenu > a').off('click').on('click',function(e){
         e.stopPropagation();
         e.preventDefault();

         var levelTop = $(this).closest('.wrap-level');
         var levelNext = $(this).next('.wrap-level');


         if(levelNext.hasClass('second-level')){
             //$(this).parent('li').addClass('active');

             levelTop.addClass('overflow-visible').addClass('move-out');
             levelNext.addClass('move-in');
         }


     });


     $('.main-nav-fixed .second-menu-link .link-third-level').off('click').on('click',function(e) {
         e.stopPropagation();
         e.preventDefault();

         var levelTop = $(this).closest('.wrap-level');
         var levelNext = $(this).closest('.second-menu-link').next('.wrap-level');


         if (levelNext.hasClass('third-level')) {
             //$(this).parent('li').addClass('active');

             levelTop.addClass('overflow-visible').addClass('move-out');
             levelNext.addClass('move-in');
         }
     });


     $('.main-nav-fixed .js-btn-back-level').off('click').on('click',function(e){
         e.stopPropagation();
         e.preventDefault();


         if($('.main-nav-fixed .second-level.move-in').hasClass('move-out') == false){
             /* Secondo livello */
             //$('.main-nav-fixed .first-level .wrap-tablet > ul > li.dropdown-item').removeClass('active');

             var levelNow = $('.main-nav-fixed .second-level.move-in');
             var levelTop = levelNow.parent().closest('.wrap-level');


             levelTop.removeClass('move-out');

             setTimeout(function(){
                 levelNow.removeClass('move-in');
                 levelTop.removeClass('overflow-visible');
             },300);
         }else{
             /* Terzo livello */
             //$('.main-nav-fixed .second-level > ul > li.dropdown-item').removeClass('active');
             var levelNow = $('.main-nav-fixed .third-level.move-in');
             var levelTop = levelNow.parent().closest('.wrap-level');

             levelTop.removeClass('move-out');

             setTimeout(function(){
                 levelNow.removeClass('move-in');
                 levelTop.removeClass('overflow-visible');
             },300);
         }

     })
 }


 function initSearchOverlay(){
    $(".item-search a .icon-search-01, .js-search-menu").on("click",function(){
        $(".overlay-search").addClass("opened");
    });
    $(".overlay-search-input .btn-close").on("click",function(){
        $(".overlay-search").removeClass("opened");
    });
 }
 function initAppendMobile(){
    if($(".upper-link .nav.navbar-nav li").length <=0){
        $(".upper-header-nav ul li").each(function(){
            $(this).clone().appendTo($(".upper-link .nav.navbar-nav"));
                $(".nav.navbar-nav .item-location").remove();
                $(".nav.navbar-nav .item-search").remove();
        });
    }
 }

function responsiveNoticeBoard(){
        if ($(window).width() < 768){
            $('.carousel-notice-board').not('.slick-initialized').slick({
                centerMode: false,
                slidesToShow: 1,
                dots: true,
                arrows: false,
                variableWidth: false
            });
        };
    }

function resizeNoticeBoard() {
    $(window).resize(function(){
        if ($('.carousel-notice-board').length > 0){
            if( $('.carousel-notice-board').hasClass('slick-initialized') && ($(window).width() >= 768)){
            $('.carousel-notice-board').slick('unslick');
        }
        else{
            responsiveNoticeBoard();
        }
    }
    });
}



function bachecaAnnunciDettaglioInit (){
    if($(".bacheca-annunci-dettaglio-wrapper").length > 0) {
        $(".bacheca-annunci-dettaglio-slider").not('.slick-initialized').slick({
            arrows: "false",
            dots: true,
            infinite: true,
            speed: 500,
            fade: true
        })
    }
}
function responsivePhotos(){
        if (($(window).width() < 768) && ($('.carousel-photos').length > 0)){
            $('.carousel-photos').not('.slick-initialized').slick({
                centerMode: false,
                slidesToShow: 1,
                dots: true,
                arrows: false,
                variableWidth: false
            });
        };
    }

function resizePhotos() {
    $(window).resize(function(){
        if( $('.carousel-photos').hasClass('slick-initialized') && $(window).width() >= 768){
            $('.carousel-photos').slick('unslick');
        }
        else{
            responsivePhotos();
        }
    });
}



function responsivePost(){
        if (($(window).width() < 768) && ($('.carousel-post').length > 0)){
            $('.carousel-post').not('.slick-initialized').slick({
                centerMode: false,
                slidesToShow: 1,
                dots: true,
                arrows: false,
                variableWidth: false
            });
        };
    }

function resizePost(){
    $(window).resize(function(){
        if( $('.carousel-post').hasClass('slick-initialized') && $(window).width() >= 768){
            $('.carousel-post').slick('unslick');
        }
        else{
            responsivePost();
        }
    });
}


function carouselTweet() {
    if($(".carousel-tweet").length > 0){
    $('.carousel-tweet').empty();

    //var urlJson = "http://www.mef.gov.it/modules/links/tweets.json";
    //var urlJson = "data/twitter.json";
    var jsonTwitter = JSON.parse($('#urlTwiiter').text());
    
    var limite = Number($('.carousel-tweet').attr('data-max'));

    // var jqxhr = $.getJSON(urlJson, function () {
    //     })
    //     .done(function (data) {
            var items = [];

            $.each(jsonTwitter, function (key, item) {
                var dataTweet = item.created_at;
                var name = item.user.name;
                var testo = item.text;
                var nameRetweet = "";
                var labelRetweet = "";
                var hashtags = item.entities.hashtags;
                var urls = item.entities.urls;
                var id = item.id_str;

                if (item.retweeted_status) {
                    labelRetweet = 'ha ritwittato';
                    dataTweet = item.retweeted_status.created_at;
                    nameRetweet = item.retweeted_status.user.screen_name;
                    testo = item.retweeted_status.text;
                    hashtags = item.retweeted_status.entities.hashtags;
                    urls = item.retweeted_status.entities.urls;
                }

                $.each(hashtags, function (k, v) {
                    testo = testo.replace('#' + v.text, '<span class="p-color">' + ('#' + v.text) + '</span>');
                });

                $.each(urls, function (k, v) {
                    testo = testo.replace(v.url, '<a href="' + v.url + '" target="_blank" class="p-color">' + v.display_url + '</a>');
                });


                var dataTweetText = parseTwitterDate(dataTweet);

                var html = '<div class="ama-col-md-4">' +
                    '<div class="box-body">' +
                    '<div class="title">' +
                    '<div class="icomoon-social-twitter"></div>' +
                    '<div class="body-twitter-box">' +
                    '<p><span class="p-color mr-5-xs">' + name + ' </span>' + labelRetweet + ' </p>' +
                    '<p><span class="p-color mr-5-xs">' + nameRetweet + '</span>‏' + dataTweetText + '</p>' +
                    '</div>' +
                    '</div>' +
                    '<div class="body dot-point dot-80 dot-mobile">' +
                    testo +
                    '</div>' +
                    '<div class="ama-row">' +
                    '<div class="ama-col-md-6 ama-col-xs-6">' +
                    '<a href="https://twitter.com/intent/tweet?in_reply_to='+ id +'" target="_blank"  title="commenta" class="icomoon-comment">' +
                    '<span class="sr-only">Commenta</span>' +
                    '</a>' +
                    '</div>' +
                    '<div class="ama-col-md-6 ama-col-xs-6">' +
                    '<a href="https://twitter.com/intent/retweet?tweet_id='+ id +'" target="_blank" title="retweet" class="icomoon-retweet">' +
                    '<span class="sr-only">retweet</span>' +
                    '</a>' +
                    '</div>' +
                    '</div>' +
                    '</div>' +
                    '</div>';


                $('.carousel-tweet').append(html);
                if ((key+1) === limite) {
                    $('.carousel-tweet').slick({
                        slidesToShow: 3,
                        slidesToScroll: 1,
                        autoplay: true,
                        dots: true,
                        arrows: false,
                        autoplaySpeed: 6000,
                        responsive: [
                            {
                                breakpoint: 1024,
                                settings: {
                                    slidesToShow: 2,
                                    slidesToScroll: 2
                                }
                            },
                            {
                                breakpoint: 600,
                                settings: {
                                    slidesToShow: 1,
                                    slidesToScroll: 1
                                }
                            },
                            {
                                breakpoint: 480,
                                settings: {
                                    slidesToShow: 1,
                                    slidesToScroll: 1
                                }
                            }
                        ]
                    });

                    waitForFinalEvent(function () {
                        $(".dot-point").trigger('destroy');
                        initEllipsis();
                    }, 100, "checkEllipsis");

                    return false;
                }
            });
    };
}


function carouselTweetInit(){
    $('.carousel-tweet').slick({
        slidesToShow: 3,
        slidesToScroll: 1,
        autoplay: true,
        dots: true,
        arrows: false,
        autoplaySpeed: 6000,
        responsive: [
            {
                breakpoint: 1024,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 2
                }
            },
            {
                breakpoint: 600,
                settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1
                }
            },
            {
                breakpoint: 480,
                settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1
                }
            }
        ]
    });

    waitForFinalEvent(function () {
        $(".dot-point").trigger('destroy');
        initEllipsis();
    }, 100, "checkEllipsis");
}


function parseTwitterDate(tdate) {
    var system_date = new Date(Date.parse(tdate));
    var user_date = new Date();
    if (checkIE.ie) {
        system_date = Date.parse(tdate.replace(/( \+)/, ' UTC$1'))
    }

    var diff = Math.floor((user_date - system_date) / 1000);

    if (diff <= 90) {
        return "adesso";
    }
    if (diff <= 3540) {
        return Math.round(diff / 60) + " minuti fa";
    }
    if (diff <= 5400) {
        return "1 ora fa";
    }
    if (diff <= 86400) {
        return Math.round(diff / 3600) + " ore fa";
    }
    if (diff <= 129600) {
        return "1 giorno fa";
    }
    if (diff > 129600) {
        var m = ['gen', 'feb', 'mar', 'apr', 'mag', 'giu', 'lug', 'ago', 'set', 'ott', 'nov', 'dic'];
        var dd = system_date.getDate();
        var mm = m[system_date.getMonth()];

        if (dd < 10) {
            dd = '0' + dd
        }
        if (mm < 10) {
            mm = '0' + mm
        }
        var day = dd + ' ' + mm;

        return day;
    }
    return "on " + system_date;
}

var checkIE = function () {
    var a = navigator.userAgent;
    return {
        ie: a.match(/MSIE\s([^;]*)/)
    }
}();


function responsiveModuls(){
        if (($(window).width() < 768) && ($('.carousel-moduls').length > 0)){
            $('.carousel-moduls').not('.slick-initialized').slick({
                centerMode: false,
                slidesToShow: 1,
                dots: true,
                arrows: false,
                variableWidth: false
            });
        };
    }

function resizeModuls() {
    $(window).resize(function(){
        if( $('.carousel-moduls').hasClass('slick-initialized') && $(window).width() >= 768){
            $('.carousel-moduls').slick('unslick');
        }
        else{
            responsiveModuls();
        }
    });
}



function carouselRadiocor() {
    if ($('.carousel-radiocor').length > 0){
        $('.carousel-radiocor').slick({
            slidesToShow: 3,
            slidesToScroll: 1,
            autoplay: true,
            dots: true,
            arrows: false,
            autoplaySpeed: 2000,
            responsive: [
                {
                    breakpoint: 991,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 2
                    }
                },
                {
                    breakpoint: 767,
                    settings: {
                        slidesToShow: 1,
                        slidesToScroll: 1
                    }
                }
            ]
        });
    }
}


function carouselPrimoPiano() {
    if($('.carousel-primo-piano').length > 0){

        var slide = $('.carousel-primo-piano .slide-primo-piano');
        /*for(var i = 0; i < slide.length; i++){
            var target = Math.floor(Math.random() * slide.length -1) + 1;
            var target2 = Math.floor(Math.random() * slide.length -1) +1;
            slide.eq(target).before(slide.eq(target2));
        }
        */


        $('.carousel-primo-piano').slick({
            slidesToShow: 1,
            slidesToScroll: 1,
            autoplay: true,
            dots: true,
            arrows: false,
            autoplaySpeed: 4000,
            speed: 1000,
            appendDots:$('.dots-primo-piano')
        });
    }
}



function resizeApps() {
    $('.widgets-header-wrap li > a[data-overlay]').click(function() {
        var heightWidget=  $(this).closest('li').find('.wrap-box-widget').height();
        var heightTitle =   $(this).closest('li').find('.wrap-title-widget').height();
        var controlMenu =  $('.control-menu').height();
        var heightTop =   $('.top-header').height();
        var chatBar =  $('.chat-bar').height();
        var tot =  heightWidget + heightTitle + heightTop;
        var heightScroll = $(window).height() - heightTitle - heightTop - controlMenu - chatBar ;

        if (tot >= heightWidget ){
            $('.wrap-box-widget').addClass('scroll-wrap');
            $('.scroll-wrap').css({"max-height": heightScroll});
        }
        else {
            $('.wrap-box-widget').removeClass('scroll-wrap');
         }
    });
}
function initHeaderWidget() {
    $('body').attr("style", "");
    $('.widgets-header-wrap li > a[data-overlay]').on('click',function(e) {
    e.preventDefault();
        $('body').css({"overflow": "hidden"});
        $('.widgets-header-wrap li a.selected').removeClass('selected');
        $(this).addClass('selected');


        var widget = $(this).attr('data-overlay');

        $('.overlay-widget').addClass('hide');
        $('#' + widget).removeClass('hide').off('mouseleave').on('mouseleave', function () {
            $(this).addClass('hide');
            $('.widgets-header-wrap li a.selected').removeClass('selected');
            $('body').css({"overflow": "scroll"});
        });

        waitForFinalEvent(function () {
            $(".dot-point").trigger('destroy');
            initEllipsis();
        }, 100, "checkEllipsis");

    });

    //href desktop importato nel mobile
    var hrefDesktop = $(".wrap-box-widget").find('.widget-notifications').attr("href");
    $(".quick-link-mobile").find('.icomoon-notification').attr("href", hrefDesktop);
}






function responsiveKnowledge(){
        if (($(window).width() < 768) && ($('.carousel-knowledge').length > 0)){
            $('.carousel-knowledge').not('.slick-initialized').slick({
                centerMode: false,
                slidesToShow: 1,
                dots: true,
                arrows: false,
                variableWidth: false
            });
        };
    }

function resizeKnowledge(){
    $(window).resize(function(){
        if( $('.carousel-knowledge').hasClass('slick-initialized') && $(window).width() >= 768){
            $('.carousel-knowledge').slick('unslick');
        }
        else{
            responsiveKnowledge();
        }
    });
}

function responsiveAreaGroups(){
        if ($(window).width() < 768){
            $('.carousel-area-group').not('.slick-initialized').slick({
                slidesToShow: 1,
                dots: true,
                arrows: false
            });
        };
    }

function resizeAreaGroups() {
    $(window).resize(function(){
        if ($('.carousel-area-group').length > 0){
            if( $('.carousel-area-group').hasClass('slick-initialized') && ($(window).width() >= 768)){
            $('.carousel-area-group').slick('unslick');
        }
        else{
                responsiveAreaGroups();
        }
    }
    });
}



function initPagination() {
    if($(".js-list-pagination").length > 0){
        $(".js-pagination").each(function(){
            var element = $(this);
            if($(this).attr('data-totpage-mobile')) {
                if($(window).width() <= 767) {
                    pagination(Number($(this).attr('data-totpage-mobile')),$(this));
                } else {
                    pagination(Number($(this).attr('data-totpage')),$(this));
                }
                $(window).resize(function(){
                    var currentPageSelected = Number(element.closest(".current-page").find("a").text());
                    if($(window).width() <= 767) {
                        pagination(Number(element.attr('data-totpage-mobile')),element);
                    } else {
                        pagination(Number(element.attr('data-totpage')),element);
                    }
                    //$(".pagination-numbers a")[currentPageSelected-1].click();
                    //element.find(".pagination-numbers a")[0].click();
                })  
            }else {
                pagination(Number(element.attr('data-totpage')),element);
            }  
        
        })
    }
}


function pagination(items, paginationElement){
    var itemForPage = items;
    var totItem = paginationElement.closest('.js-list-pagination').find('.item-pagination').length;
    var pag = Math.ceil(totItem/itemForPage);

    if(pag > 1){
        paginationElement.removeClass('hide');

        paginationElement.find('.pagination-numbers').empty();

        for(var i=0;i< pag;i++){
            var linkPag = '<li><a href="#">'+ (i+1) +'</a></li>';
            paginationElement.find('.pagination-numbers').append(linkPag);
        }

        paginationElement.find('.pagination-numbers li:eq(0)').addClass('current-page');

        for(var k=itemForPage;k < totItem;k++){
            paginationElement.closest('.js-list-pagination').find('.item-pagination:eq('+ k +')').addClass('hide');
        }

        paginationElement.find('.pagination-numbers a').off('click').on('click',function(e){
            e.preventDefault();
            scrollToList();
            paginationElement.find('.pagination-numbers li').removeClass('current-page');
            gotoPagePagination($(this).text(),itemForPage, paginationElement);

        });

        paginationElement.find('.btn-back-arrow').off('click').on('click',function(e){
            e.preventDefault();

            if(!$(this).hasClass('disabled')){
                var pageNow = paginationElement.find('.pagination-numbers li.current-page');
                var indexNow = pageNow.index();

                if(indexNow > 0){

                    paginationElement.find('.pagination-numbers li').removeClass('current-page');
                    paginationElement.find('.btn-back-arrow').removeClass('disabled');
                    gotoPagePagination(indexNow,itemForPage, paginationElement);

                    if(paginationElement.find('.pagination-numbers li.current-page').index() < 1){
                        paginationElement.find('.btn-back-arrow').addClass('disabled');
                    }
                }
                scrollToList();
            }
        });

        paginationElement.find('.btn-forward-arrow').off('click').on('click',function(e){
            e.preventDefault();

            if(!$(this).hasClass('disabled')){
                var pageNow = paginationElement.find('.pagination-numbers li.current-page');
                var indexNow = pageNow.index();
                var totItem = paginationElement.find('.pagination-numbers li').length-1;

                if((indexNow+1) <= totItem){

                    paginationElement.find('.pagination-numbers li').removeClass('current-page');
                    paginationElement.find('.btn-forward-arrow').removeClass('disabled');
                    gotoPagePagination(indexNow+2, itemForPage, paginationElement);

                    if((indexNow+1) == totItem){
                        paginationElement.find('.btn-forward-arrow').addClass('disabled');
                    }
                }
                scrollToList();
            }
        });


    }else{
        paginationElement.addClass('hide');
    }

}
function scrollToList(){
    if($(".top-paginator-scroll").length > 0){
        $('.top-paginator-scroll').scrollTop(0);
        var distanceTop = $(".top-paginator-scroll").offset().top;
        if($(window).width() <= 767){
            if($(".control-menu").length > 0){
                scrollPx = 140;
            }
            else{
                scrollPx = 100;
            }
            
        }
        else{
            if($(".control-menu").length > 0){
                scrollPx = 244;
            }
            else{
                scrollPx = 180;
            }
        }
        $("html, body").animate({ scrollTop: $(".top-paginator-scroll").offset().top - scrollPx}, 500);
    }
}
function gotoPagePagination(pageSelected, items, paginationElement){
    var itemForPage = items;
    var startItem = itemForPage * (pageSelected-1);
    var totItem = startItem+itemForPage;

    paginationElement.find('.pagination-numbers li:eq('+ (pageSelected-1) +')').addClass('current-page');

    paginationElement.closest('.js-list-pagination').find('.item-pagination').addClass('hide');

    for(var k=startItem;k < totItem;k++){
        paginationElement.closest('.js-list-pagination').find('.item-pagination:eq('+ k +')').removeClass('hide');
    }

    if(paginationElement.find('.pagination-numbers li.current-page').index() > 0){
        paginationElement.find('.btn-back-arrow').removeClass('disabled');
    }else{
        paginationElement.find('.btn-back-arrow').addClass('disabled');
    }

    if(paginationElement.find('.pagination-numbers li.current-page').index() < (paginationElement.find('.pagination-numbers li').length-1)){
        paginationElement.find('.btn-forward-arrow').removeClass('disabled');
    }else{
        paginationElement.find('.btn-forward-arrow').addClass('disabled');
    }

    waitForFinalEvent(function () {
        $(".dot-point").trigger('destroy');
        initEllipsis();
    }, 100, "checkEllipsis");
}
function modulisticaInit() {
    if($(".modulistica-wrapper").length > 0) {
        if($(".modules-hot-wrap").length > 0) {
            $(".modules-hot-wrap").slick({
                arrows: "false",
                dots: true,
                infinite: true,
                speed: 500
            });
        }
    }
}
function tabFiltriInit() {

    if($(".tab-filtri").length > 0){

        $(".show-filters-mobile-button").on("click",function(e){
            e.preventDefault();
            $(this).toggleClass("filters-opened");
            $(this).closest(".filtro-body-box").find(".mobile-click-open").toggleClass("open");
        })

        $(".hide-filters-mobile-button").on("click",function(e){
            e.preventDefault();
            $(this).closest(".filtro-body-box").find(".show-filters-mobile-button").toggleClass("filters-opened");
            $(this).closest(".filtro-body-box").find(".mobile-click-open").toggleClass("open");
            $(this).closest(".filtro-body-box").find(".collapse").collapse('hide');
            $(this).closest(".filtro-body-box").find(".open-tab").removeClass("active");
        })
        $(".open-tab").on("click",function(){
            var isActive;
            if($(this).hasClass("active")) {
                isActive = true;
            }
            $(this).removeClass("active");
            if(!isActive) {
                $(this).addClass("active");
            }
        })
        // ---
        $(".tab-title").on("click",function(e){
            e.preventDefault();

            if(!$(this).hasClass("active")) {
                $(".collapse").collapse('hide');
                $(".open-tab").removeClass("active");
                $(".tab-title").removeClass("active");
                $(this).addClass("active");
                $(window).trigger("resize");
            } else {
                e.stopPropagation();
            }
        });
        $(".open-tab").on("click",function(e){
            e.preventDefault();
            $(".filtro-body-box .collapse").collapse('hide');
        });
        $(".button-cancel.button-filtro").on("click",function(e){
            e.preventDefault();
            $(".filtro-body-box .collapse").collapse('hide');
            $(".open-tab").removeClass("active");
            $(".filter-category-item-box").removeClass("active");
        });
        $(".text-search").on("click",function(e){
            e.preventDefault();
            $(".filtro-body-box .collapse").collapse('hide');
            $(".open-tab").removeClass("active");
        })
        // ---/
        
        /*$(".text-search").on("click",function(){
            $(this).addClass("open-search");
        })*/

        // FILTRO CATEGORIA
        $(".filter-category-item-box").on("click",function(e){
            e.preventDefault();
            $(this).toggleClass("active");
        })
        //FILTRO TIPOLOGIA
        $(".filtro-type-item").on("click",function(e){
            e.preventDefault();
            var isActive;
            if($(this).hasClass("active")) {
                isActive = true;
            }
            $(".filtro-type-item").removeClass("active");
            if(!isActive) {
                $(this).addClass("active");
            }
        })
    }
}
function responsiveAgenda(){
        if (($(window).width() < 992) && ($('.carousel-agenda').length > 0)){
            $('.carousel-agenda').not('.slick-initialized').slick({
              slidesToShow: 2,
              slidesToScroll: 1,
              dots: true,
              arrows: false,
              responsive: [
                  {
                      breakpoint: 768,
                      settings: {
                          slidesToShow: 1,
                          slidesToScroll: 1
                      }
                  }
              ]
            });
        };
    }

function resizeAgenda(){
    $(window).resize(function(){
        if( $('.carousel-agenda').hasClass('slick-initialized') && $(window).width() >= 992){
            $('.carousel-agenda').slick('unslick');
        }
        else{
            responsiveAgenda();
        }
    });
}

function multimediaImageSliderInit() {

    if ($(".multimedia-foto-wrapper .internal-gallery-js").length > 0) {

        $('.container-foto').slick({
            slidesToShow: 1,
            slidesToScroll: 1,
            arrows: false,
            fade: true,
            asNavFor: '.slider-foto'
        });
        $('.slider-foto').slick({
            slidesToShow: 5,
            slidesToScroll: 1,
            asNavFor: '.container-foto',
            variableWidth: true,
            arrows: true,
            focusOnSelect: true,
            prevArrow: "<span class='icomoon-arrow prev-arrow'>",
            nextArrow: "<span class='icomoon-arrow next-arrow'>"
        });

        //Slick counter position
        document.getElementById('multimedia-num').textContent = $('.container-foto').slick('slickCurrentSlide') + 1 + '/' + $(".container-foto").slick("getSlick").slideCount;
        $('.container-foto').on('afterChange', function () {
            document.getElementById('multimedia-num').textContent = $('.container-foto').slick('slickCurrentSlide') + 1 + '/' + $(".container-foto").slick("getSlick").slideCount;
            var heightImg = $('.foto-item').height();
            $('.wrapper-overlay').css('height', heightImg);
        });

        //Play and pause slick
        $(".multimedia-btn-play").on("click", function (e) {
            e.preventDefault();

          if($(".multimedia-btn-play").hasClass('icomoon-play')){
            $(".container-foto").slick("getSlick").slickPlay();
            $(".multimedia-btn-play").addClass('icomoon-pause');
            $(".multimedia-btn-play").removeClass('icomoon-play');
          }else{
            if($(".multimedia-btn-play").hasClass('icomoon-pause')){
                $(".container-foto").slick("getSlick").slickPause();
                $(".multimedia-btn-play").addClass('icomoon-play');
                $(".multimedia-btn-play").removeClass('icomoon-pause');
              }
          }
        });

        //Full screen
        $('.multimedia-btn-overlay').click(function (e) {
            e.preventDefault();

              if($('.multimedia-btn-overlay').hasClass('icomoon-fullscreen')){
                $(".multimedia-btn-play").addClass('icomoon-play');
                $(".multimedia-btn-play").removeClass('icomoon-pause');
                $('.container-overlay').addClass("overlay");
                $('.wrapper-overlay').addClass("multimedia-box");
                $('.multimedia-btn-overlay').addClass('icomoon-reduct-screen');
                $('.multimedia-btn-overlay').removeClass('icomoon-fullscreen');
                var currentSlide = $('.container-foto').slick('slickCurrentSlide');
                $('.container-foto').slick('unslick');
                $('.container-foto').slick({
                            slidesToShow: 1,
                            slidesToScroll: 1,
                            initialSlide: currentSlide,
                            arrows: false,
                            fade: true,
                            asNavFor: '.slider-foto'
                          });
                $(window).trigger('resize');
              }else{
                    $(".multimedia-btn-play").addClass('icomoon-play');
                    $(".multimedia-btn-play").removeClass('icomoon-pause');
                    $('.multimedia-btn-overlay').addClass('icomoon-fullscreen');
                    $('.multimedia-btn-overlay').removeClass('icomoon-reduct-screen');
                    $('.container-overlay').removeClass('overlay');
                    $('.wrapper-overlay').removeClass('multimedia-box');
                    $('.wrapper-overlay').css('height', '100%');
                    var currentSlide = $('.container-foto').slick('slickCurrentSlide');
                    $('.container-foto').slick('unslick');
                    $('.container-foto').slick({
                                slidesToShow: 1,
                                slidesToScroll: 1,
                                initialSlide: currentSlide,
                                arrows: false,
                                fade: true,
                                asNavFor: '.slider-foto'
                              });
                    $(window).trigger('resize');
              }
        });

       $(window).resize(function () {
            if ($('.multimedia-box').length > 0) {
                var heightImg = $('.foto-item').height();
                $('.multimedia-box').css('height', heightImg);
            }
        });
        //Arrows fullscreen
        $('.multimedia-foto-arrow.arrow-left').click(function (e) {
            e.preventDefault();

            $('.container-foto').slick('slickPrev');
        });
        $('.multimedia-foto-arrow.arrow-right').click(function (e) {
            e.preventDefault();

            $('.container-foto').slick('slickNext');
        });

    }

}

function multimediaGalleryInit() {
 
var initPhotoSwipeFromDOM = function(gallerySelector) {
  // parse slide data (url, title, size ...) from DOM elements 
  // (children of gallerySelector)
  var parseThumbnailElements = function(el) {
      var thumbElements = el.childNodes,
          numNodes = thumbElements.length,
          items = [],
          figureEl,
          linkEl,
          size,
          item;

      for(var i = 0; i < numNodes; i++) {

          figureEl = thumbElements[i]; // <figure> element

          // include only element nodes 
          if(figureEl.nodeType !== 1) {
              continue;
          }

          linkEl = figureEl.children[0]; // <a> element

          size = linkEl.getAttribute('data-size').split('x');

          // create slide object
          item = {
              src: linkEl.getAttribute('href'),
              w: parseInt(size[0], 10),
              h: parseInt(size[1], 10)
          };



          if(figureEl.children.length > 1) {
              // <figcaption> content
              item.title = figureEl.children[1].innerHTML; 
          }

          if(linkEl.children.length > 0) {
              // <img> thumbnail element, retrieving thumbnail url
              item.msrc = linkEl.children[0].getAttribute('data-src');
          } 

          item.el = figureEl; // save link to element for getThumbBoundsFn
          items.push(item);
      }

      return items;
  };

  // find nearest parent element
  var closest = function closest(el, fn) {
      return el && ( fn(el) ? el : closest(el.parentNode, fn) );
  };

  // triggers when user clicks on thumbnail
  var onThumbnailsClick = function(e) {
      e = e || window.event;
      e.preventDefault ? e.preventDefault() : e.returnValue = false;

      var eTarget = e.target || e.srcElement;

      // find root element of slide
      var clickedListItem = closest(eTarget, function(el) {
          return (el.tagName && el.tagName.toUpperCase() === 'FIGURE');
      });

      if(!clickedListItem) {
          return;
      }

      // find index of clicked item by looping through all child nodes
      // alternatively, you may define index via data- attribute
      var clickedGallery = clickedListItem.parentNode,
          childNodes = clickedListItem.parentNode.childNodes,
          numChildNodes = childNodes.length,
          nodeIndex = 0,
          index;

      for (var i = 0; i < numChildNodes; i++) {
          if(childNodes[i].nodeType !== 1) { 
              continue; 
          }

          if(childNodes[i] === clickedListItem) {
              index = nodeIndex;
              break;
          }
          nodeIndex++;
      }



      if(index >= 0) {
          // open PhotoSwipe if valid index found
          openPhotoSwipe( index, clickedGallery );
      }
      return false;
  };

  // parse picture index and gallery index from URL (#&pid=1&gid=2)
  var photoswipeParseHash = function() {
      var hash = window.location.hash.substring(1),
      params = {};

      if(hash.length < 5) {
          return params;
      }

      var vars = hash.split('&');
      for (var i = 0; i < vars.length; i++) {
          if(!vars[i]) {
              continue;
          }
          var pair = vars[i].split('=');  
          if(pair.length < 2) {
              continue;
          }           
          params[pair[0]] = pair[1];
      }

      if(params.gid) {
          params.gid = parseInt(params.gid, 10);
      }

      return params;
  };

  var openPhotoSwipe = function(index, galleryElement, disableAnimation, fromURL) {
      var pswpElement = document.querySelectorAll('.pswp')[0],
          gallery,
          options,
          items;

      items = parseThumbnailElements(galleryElement);

      // define options (if needed)
      options = {
          shareEl: false,
          // define gallery index (for URL)
          galleryUID: galleryElement.getAttribute('data-pswp-uid'),

          getThumbBoundsFn: function(index) {
              // See Options -> getThumbBoundsFn section of documentation for more info
              var thumbnail = items[index].el.getElementsByTagName('img')[0], // find thumbnail
                  pageYScroll = window.pageYOffset || document.documentElement.scrollTop,
                  rect = thumbnail.getBoundingClientRect(); 

              return {x:rect.left, y:rect.top + pageYScroll, w:rect.width};
          }

      };

      // PhotoSwipe opened from URL
      if(fromURL) {
          if(options.galleryPIDs) {
              // parse real index when custom PIDs are used 
              // http://photoswipe.com/documentation/faq.html#custom-pid-in-url
              for(var j = 0; j < items.length; j++) {
                  if(items[j].pid == index) {
                      options.index = j;
                      break;
                  }
              }
          } else {
              // in URL indexes start from 1
              options.index = parseInt(index, 10) - 1;
          }
      } else {
          options.index = parseInt(index, 10);
      }

      // exit if index not found
      if( isNaN(options.index) ) {
          return;
      }

      if(disableAnimation) {
          options.showAnimationDuration = 0;
      }

      // Pass data to PhotoSwipe and initialize it
      options.index = index;
      gallery = new PhotoSwipe( pswpElement, PhotoSwipeUI_Default, items, options);
      gallery.init();
  };

  // loop through all gallery elements and bind events
  var galleryElements = document.querySelectorAll( gallerySelector );

  for(var i = 0, l = galleryElements.length; i < l; i++) {
      galleryElements[i].setAttribute('data-pswp-uid', i+1);
      galleryElements[i].onclick = onThumbnailsClick;
  }

  // Parse URL and open gallery if it contains #&pid=3&gid=1
  var hashData = photoswipeParseHash();
  if(hashData.pid && hashData.gid) {
      openPhotoSwipe( hashData.pid ,  galleryElements[ hashData.gid - 1 ], true, true );
  }
};

// //Show more and show less image
var showmore = function(elements, tag, numElement){
  var maxShow = numElement;
  var galleryElements = document.querySelectorAll(".my-gallery figure")[0];
  var length = galleryElements.length;
  for(var i = 0; i < maxShow; i++){
    if(i === 0) galleryElements[i].style.height = '264px';
    else galleryElements[i].style.height = '80px';
    galleryElements[i].style.margin = '0 12px 12px 0';
  }
}

// execute above function
//showmore('.my-gallery', 'figure', displayImg);

initPhotoSwipeFromDOM('.my-gallery');
}

var gallery = $('.multimedia-gallery-wrapper');

gallery.each(function() {
  var galleryItem = $(this);
  var btnMore = galleryItem.find('.show-more-less');
  var ShowHideMore = galleryItem.find('.my-gallery');
  //Init btn
  ShowHideMore.each(function() {
    var times = $(this).children('figure');
    if (times.length > 10) {
        ShowHideMore.children(':nth-of-type(n+11)').addClass('moreShown').addClass("init-img");
        btnMore.addClass('more-times').html('Visualizza tutto');
    }
    else{
      btnMore.hide();
    }
  });
  //event click btn
  btnMore.on('click', function() {
    var that = $(this);
    if (that.hasClass('more-times')) {
      galleryItem.find('.moreShown').removeClass("init-img");
      that.toggleClass('more-times', 'less-times').html('Riduci');
    } else {
      galleryItem.find('.moreShown').addClass("init-img");
      that.toggleClass('more-times', 'less-times').html('Visualizza tutto');
      $('html,body').animate({
          scrollTop: $(".page-title-wrapper").offset().top},
          200);
    }  
  });

});

function scegliStato(){
    if($(".tab-scegli-stato").length > 0){
        $(".tab-type-item").on("click",function(e){
            e.preventDefault();
            var isActive;
            if($(this).hasClass("active")) {
                isActive = true;
            }
            $(".tab-type-item").removeClass("active");
            if(!isActive) {
                $(this).addClass("active");
            }
        })
    }
}
function responsivelatestResearch(){
        if (($(window).width() < 768) && ($('.carousel-research').length > 0)){
            $('.carousel-research').not('.slick-initialized').slick({
                centerMode: false,
                slidesToShow: 1,
                dots: true,
                arrows: false,
                variableWidth: false
            });
        };
    }

function resizelatestResearch(){
    $(window).resize(function(){
        if( $('.carousel-research').hasClass('slick-initialized') && $(window).width() >= 768){
            $('.carousel-research').slick('unslick');
        }
        else{
            responsivelatestResearch();
        }
    });
}


function selfServiceSiapCollapse(){
    if($(".self-service-siap-container").length > 0){
        $(".icomoon-plus").on("click", function(e){
           e.preventDefault();
            var elem = $(this).parent().parent();

            if(!elem.hasClass("processing")){    
                elem.addClass("processing");
                if(elem.hasClass("transition-collapse")){
                    elem.removeClass("transition-collapse");
                    elem.find(".self-service-container-icon").removeClass("icomoon-less self-service-icon-less");
                    elem.find(".self-service-container-icon").addClass("icomoon-plus");
                    setTimeout(function(){
                        elem.find(".self-service-siap-container-link").addClass("hidden");
                        elem.removeClass("processing");
                    },500);  
                }else{
                    elem.find(".self-service-siap-container-link").removeClass("hidden");
                    elem.addClass("transition-collapse");
                    elem.find(".self-service-container-icon").removeClass("icomoon-plus");
                    elem.find(".self-service-container-icon").addClass("icomoon-less self-service-icon-less");
                    elem.removeClass("processing");
                }
            }
            
        });
    }
}

function BancheDati() {

    $(document).ready(function() {
        /*$('.tag').each(function(){
            if($(this).attr("id")>2) {
                $(this).toggleClass("show-tag");
            }
        });

        $(".tag-open").on("click", function (e) {
            e.preventDefault();

            $(this).closest('.tags-container').find('.tag').each(function(){
                if($(this).attr("id")>2) {
                    $(this).toggleClass("show-tag");
                }
            })
        });*/
    });


}






function scrivaniaClickPlus(){
    /* function showError(text){
        if($(".wrapper-added-notice.error-fixed").length > 0){
            $(".wrapper-added-notice.error-fixed").removeClass("hidden");
            $(".wrapper-added-notice.error-fixed").removeClass("fadeOut");
            $(".wrapper-added-notice.error-fixed").addClass("fadeIn");
            $(".wrapper-added-notice.error-fixed").find(".message-important").text(text);
        }
    }

    if($(".wrapper-added-notice.error-fixed").length > 0){
        $('.icon-close-error-fixed').on("click", function(){
            $(".wrapper-added-notice.error-fixed").removeClass("fadeIn"); 
            $(".wrapper-added-notice.error-fixed").addClass("fadeOut");
            setTimeout(function(){
                $(".wrapper-added-notice.error-fixed").addClass("hidden");
            },200);
            
        });
    }

    //prova
    $(".application-home-service").on("click",function(){
        showError("Errore Home Errore Home Errore Home Errore Home Errore Home");
    });
    $(".application-profile-service").on("click",function(){
        showError("Errore Profile Errore Profile Errore Profile Errore Profile Errore Profile");
    }); */
/*
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
    //prova
    $(".application-home-service").on("click",function(){
        showError("Hai raggiunto il numero massimo di elementi previsti per ‘La Mia Scrivania’");
    });
    $(".application-profile-service").on("click",function(){
        showError("Hai raggiunto il numero massimo di elementi previsti per la ‘Scrivania Home’");
    }); */
}

function organigrammaGrafico(){
    if($(".org-chart").length > 0) {
        $('.plus-click').click( function() {
            if($(this).attr("data-toggle")=="collapse-custom") {
                var targetId = $(this).attr("data-target");
                if($(targetId).hasClass("open")) {
                    $(targetId).removeClass("open");
                    $(".plus-click").removeClass("plus-open");
                } else {
                    $(".collapse-custom").removeClass("open");
                    $(".plus-click").removeClass("plus-open");
                    $(targetId).addClass("open");
                    $(this).addClass("plus-open");
                }
            }
        });
        $(".org-chart a").on("click",function(e){
            if($(this).attr("href")=="#") {
                e.preventDefault();
            }
        })
    }
}
function rubricaPersoneCollapse(){
    if($(".address-book-people").length > 0){
        $(".icomoon-plus").on("click", function(e){
            e.preventDefault();
            $(this).toggleClass("icomoon-less");
            var elem = $(this).parent();
            elem.find(".address-info-people").toggleClass("address-people-collapse");
        });
    }
}

function circularCollapse(){
    if($(".circular-container-link").length > 0){
        $(".icomoon-plus").on("click", function(e){

            var elem = $(this).parent().parent();

            if(elem.hasClass("transition-collapse")){
                elem.removeClass("transition-collapse");
                elem.find(".circular-container-icon").removeClass("icomoon-less self-service-icon-less");
                elem.find(".circular-container-icon").addClass("icomoon-plus");
            }else{
                elem.addClass("transition-collapse");
                elem.find(".circular-container-icon").removeClass("icomoon-plus");
                elem.find(".circular-container-icon").addClass("icomoon-less self-service-icon-less");
            }

        });
    }
}

function agendaEventInit(){
    if($('.agenda-month-selection').length > 0) {

        var months = ['GENNAIO','FEBBRAIO','MARZO','APRILE','MAGGIO','GIUGNO','LUGLIO','AGOSTO','SETTEMBRE','OTTOBRE','NOVEMBRE','DICEMBRE']

        var changeLabel = function(currentMonth, currentYear){
            var label = months[currentMonth-1]+" "+currentYear;
            $('.agenda-month-label').text(label);
        }

        var changeEventsVisible = function(currentMonth, currentYear){
            $('.event').removeClass('event-visible');
            $('.event').each(function(){
                if(parseInt($(this).attr('data-event-month')) == currentMonth && parseInt($(this).attr('data-event-year')) == currentYear) {
                    $(this).addClass('event-visible');
                }
            })
            $('.event-no-availability').removeClass('no-availability-show');
            
            if($('.event.event-visible').length == 0) {
                $('.event-no-availability').addClass('no-availability-show');
            }
            $('.agenda-event-results-label').find('.bold').text($('.event.event-visible').length);
        }

        $('.agenda-month-left-arrow').on('click',function(){
            var currentMonth = parseInt($('.agenda-month-selection').attr('data-current-month'));
            var currentYear = parseInt($('.agenda-month-selection').attr('data-current-year'));
            if(currentMonth == 1) {
                currentYear--;
                currentMonth = 12;
                $('.agenda-month-selection').attr('data-current-month',currentMonth);
                $('.agenda-month-selection').attr('data-current-year',currentYear);
            } else {
                currentMonth--;
                $('.agenda-month-selection').attr('data-current-month',currentMonth);
            }
            changeLabel(currentMonth, currentYear);
            changeEventsVisible(currentMonth, currentYear);
        });

        $('.agenda-month-right-arrow').on('click',function(){
            var currentMonth = parseInt($('.agenda-month-selection').attr('data-current-month'));
            var currentYear = parseInt($('.agenda-month-selection').attr('data-current-year'));
            if(currentMonth == 12) {
                currentYear++;
                currentMonth = 1;
                $('.agenda-month-selection').attr('data-current-month',currentMonth);
                $('.agenda-month-selection').attr('data-current-year',currentYear);
            } else {
                currentMonth++;
                $('.agenda-month-selection').attr('data-current-month',currentMonth);
            }
            changeLabel(currentMonth, currentYear);
            changeEventsVisible(currentMonth, currentYear);
        })

        changeEventsVisible(parseInt($('.agenda-month-selection').attr('data-current-month')), parseInt($('.agenda-month-selection').attr('data-current-year')));
        
    }
}
function tagsInit(){
    if($('.tags-container').length > 0) {
        // HIDE TAGS > 3
        $('.tags-container').each(function(){
            if($(this).find('.tags-more-click-js').length > 0) {
                var count = 0;
                $(this).find('.tag').each(function(){
                    count++;
                    if(count > 3) {
                        $(this).addClass('hide-tag');
                    }
                })
            }
        });
        $('.tags-more-click-js').on('click',function(e){
            e.preventDefault();
            e.stopPropagation();

            var count = 0;
            $(this).closest('.tags-container').find('.tag').each(function(){
                count++;
                if(count > 3) {
                    $(this).toggleClass('hide-tag');
                }
            })
        })
    }
}
function serviziRichiestaCollapse(){
    var $myGroup = $('.richiesta-collapse-wrap');
    $(".servizio-richiesta-button").on('click', function(e) {
        if($(this).hasClass("active")){
            $(this).removeClass("active");
            $(this).blur();
        }else{
            $(".servizio-richiesta-button").removeClass("active");
            $(this).addClass("active");
        }
        $myGroup.find('.collapse.in').collapse('hide');
    });
}

function gestioneRiunioniInit(){
    if($('.riunione-item').length > 0) {
        $('.riunione-label.more').on('click',function(){
            $(this).find('.more-box').toggleClass('more-box-open');
        });
        $('.riunione-label.more').blur(function() {
            $('.more-box').removeClass('more-box-open');
        });
    }
    $('.riunioni-switch-grid .cta-riunioni-grid').on("click",function (e) {
    	e.preventDefault();
    	if($(this).hasClass("compact-grid") && !$(this).hasClass("active")){
    		$(this).addClass("active").siblings().removeClass("active");
    		$("#filtro-riunioni").addClass("filtro-compact-grid");
            $("#filtro-riunioni").removeClass("filter-full-grid");
            disabledCLickCompact();
    	}
    	else if(!$(this).hasClass("compact-grid")){
    		$(this).addClass("active").siblings().removeClass("active");
    		$("#filtro-riunioni").removeClass("filtro-compact-grid");
            $("#filtro-riunioni").addClass("filter-full-grid");
            enableCLickCompact();
    	}
    });
}
function disabledCLickCompact(){
    $(".filtro-compact-grid .compact-grid-1 .container-link-grid,.filtro-compact-grid .compact-grid-3 .container-link-grid,.filtro-compact-grid .compact-grid-5 .container-link-grid").bind('click', function(e){
        e.preventDefault();
    });
}
function enableCLickCompact(){
    $(".filter-full-grid .compact-grid-1 .container-link-grid,.filter-full-grid .compact-grid-3 .container-link-grid,.filter-full-grid .compact-grid-5 .container-link-grid").unbind('click');
}
function tabRichiesta() {
    $(".box-gray-beni").on('click', function (e) {
        var isActive;

        if ($(this).hasClass("active")) {
            isActive = true;
        }
        $(this).removeClass("active");
        if (!isActive) {
            $(this).addClass("active");

        }
    })
}


function serviziHeader() {

    $(".box-white-beni").on('click', function(event) {
        event.preventDefault();
        document.getElementById("select").classList.toggle("show");

        if (!event.target.matches('.box-white-beni')) {

            var selects = document.getElementsByClassName("select-content");
        }
    });

    $(".back-image").on('click', function(event) {
        event.preventDefault();
        $(this).toggleClass("back-image-two");
        });

    $('.element-select').on('click', function(event){
        event.preventDefault();
        var currentClass = $(this).attr("data-icon-image");
        $('.current-selected').html('<span class="mr-0-xs current-icon file '+ $(this).attr("data-icon-image")+'"></span> ' + $(this).attr("data-name"));
        $('.element-select').each(function(){
            if($(this).hasClass('hidden')){
                $(this).removeClass('hidden');
            }
            $('.select-content').removeClass('show');
            $('.back-image').removeClass('back-image-two');
        });
        $(this).addClass('hidden');
    });

    $(".box-giudizio").on('click', function(event) {
        $('.wrap-giudizio').addClass('show-box-giudizio');

    })

    $(".hide-box-giudizio").on('click', function(event) {
        $('.wrap-giudizio').removeClass('show-box-giudizio');

    })

}


function collapseAule() {
    $('.ico-information').click(function(){
        $(this).next('.collapse-aule').toggleClass("open");
        $(this).toggleClass('icomoon-chiudi-dark');
    });

}




function profileCalendarInfo(){
    if($('.profile-info-not-work').length > 0) {
        var paginatorList =  $('.js-list-pagination').length;
        var months = ['GENNAIO','FEBBRAIO','MARZO','APRILE','MAGGIO','GIUGNO','LUGLIO','AGOSTO','SETTEMBRE','OTTOBRE','NOVEMBRE','DICEMBRE'];
        var changeLabelProfile = function(currentMonth, currentYear){
            var label = months[currentMonth-1]+" "+currentYear;
            $('.box-calendar .month').text(label);
        }
        var changeEventsVisibleProfile = function(currentMonth, currentYear){
            $('.js-list-pagination').addClass('hide').removeClass("active-item-work");
            $('.js-list-pagination').each(function(index){
                if(parseInt($(this).attr('data-event-month')) == currentMonth && parseInt($(this).attr('data-event-year')) == currentYear) {
                    $(this).removeClass('hide').addClass("active-item-work");
                    if(index === 0){
                        $('.box-calendar .arrow-sx').removeClass("disabled-profile-work");
                        $('.box-calendar .arrow-dx').addClass("disabled-profile-work");
                    }
                    else if (index === paginatorList - 1){
                        $('.box-calendar .arrow-sx').addClass("disabled-profile-work");
                        $('.box-calendar .arrow-dx').removeClass("disabled-profile-work");
                    }
                    else{
                        $('.box-calendar .arrow-sx').removeClass("disabled-profile-work");
                        $('.box-calendar .arrow-dx').removeClass("disabled-profile-work");
                    }
                }
            })
        }
        $('.box-calendar .arrow-sx').on('click',function(){
            var currentMonth = parseInt($('.box-calendar').attr('data-current-month'));
            var currentYear = parseInt($('.box-calendar').attr('data-current-year'));
            if(currentMonth == 1) {
                currentYear--;
                currentMonth = 12;
                $('.box-calendar').attr('data-current-month',currentMonth);
                $('.box-calendar').attr('data-current-year',currentYear);
            } else {
                currentMonth--;
                $('.box-calendar').attr('data-current-month',currentMonth);
            }
            changeLabelProfile(currentMonth, currentYear);
            changeEventsVisibleProfile(currentMonth, currentYear);
        });

        $('.box-calendar .arrow-dx').on('click',function(){
            var currentMonth = parseInt($('.box-calendar').attr('data-current-month'));
            var currentYear = parseInt($('.box-calendar').attr('data-current-year'));
            if(currentMonth == 12) {
                currentYear++;
                currentMonth = 1;
                $('.box-calendar').attr('data-current-month',currentMonth);
                $('.box-calendar').attr('data-current-year',currentYear);
            } else {
                currentMonth++;
                $('.box-calendar').attr('data-current-month',currentMonth);
            }
            changeLabelProfile(currentMonth, currentYear);
            changeEventsVisibleProfile(currentMonth, currentYear);
        })

        changeEventsVisibleProfile(parseInt($('.box-calendar').attr('data-current-month')), parseInt($('.box-calendar').attr('data-current-year')));
    }
}
function scrivaniaInit() {
    if($('.box-scrivania-wrap .box-scrivania-mobile-icon').length > 0 ){
        $('.box-scrivania-wrap .box-scrivania-mobile-icon').on('click',function(){
            $(this).toggleClass('mobile-open');
            $('.mobile-box-scrivania-home').toggleClass('mobile-open');
        })
        $('.box-scrivania-wrap .box-scrivania-mobile-icon-close').on('click',function(){
            $('.box-scrivania-wrap .box-scrivania-mobile-icon').removeClass('mobile-open');
            $('.mobile-box-scrivania-home').removeClass('mobile-open');
        })
    }
}
function initAreaCollaboration(){
  $('.js-show-comments').click(function(){
    $('#' + $(this).attr('data-id')).toggleClass('hide');
  });
}
function prorogaBadgeDate (){
    $('#dateProroga').on("blur",function () {
        if ($(this).val() == '' || $(this).val() == 'DD/MM/AAAA' ) {
            //Check to see if there is any text entered
            // If there is no text within the input ten disable the button
            $('#cta-submit-proroga').prop('disabled', true);
        } else {
            //If there is text in the input, then enable the button
            $('#cta-submit-proroga').prop('disabled', false);
        }
    });
}
// Avoid `console` errors in browsers that lack a console.
(function () {
    var method;
    var noop = function () {
    };
    var methods = [
        'assert', 'clear', 'count', 'debug', 'dir', 'dirxml', 'error',
        'exception', 'group', 'groupCollapsed', 'groupEnd', 'info', 'log',
        'markTimeline', 'profile', 'profileEnd', 'table', 'time', 'timeEnd',
        'timeStamp', 'trace', 'warn'
    ];
    var length = methods.length;
    var console = (window.console = window.console || {});

    while (length--) {
        method = methods[length];

        // Only stub undefined methods.
        if (!console[method]) {
            console[method] = noop;
        }
    }
}());

var isMobile = {
    Android: function () {
        return navigator.userAgent.match(/Android/i);
    },
    BlackBerry: function () {
        return navigator.userAgent.match(/BlackBerry/i);
    },
    iOS: function () {
        return navigator.userAgent.match(/iPhone|iPad|iPod/i);
    },
    Opera: function () {
        return navigator.userAgent.match(/Opera Mini/i);
    },
    Windows: function () {
        return navigator.userAgent.match(/IEMobile/i);
    },
    any: function () {
        return (isMobile.Android() || isMobile.BlackBerry() || isMobile.iOS() || isMobile.Opera() || isMobile.Windows());
    }
};


if (isMobile.any()) {
    $('body').addClass('mobile-device');
}


function initEllipsis() {
    $(".dot-point").dotdotdot({
        ellipsis: '...',
        wrap: 'word'
    });
}
function placeholderIe(){
    if($("html").hasClass("ie10") || $("html").hasClass("ie11")){
        $('[placeholder]').focus(function() {
            var input = $(this);
            if (input.val() == input.attr('placeholder')) {
                input.val('');
                input.removeClass('placeholder');
            }
        }).blur(function() {
            var input = $(this);
            if (input.val() == '' || input.val() == input.attr('placeholder')) {
                input.addClass('placeholder');
                input.val('');
            }
        }).blur();
    }    
}
var waitForFinalEvent = (function () {
    var timers = {};
    return function (callback, ms, uniqueId) {
        if (!uniqueId) {
            uniqueId = "Don't call this twice without a uniqueId";
        }
        if (timers[uniqueId]) {
            clearTimeout(timers[uniqueId]);
        }
        timers[uniqueId] = setTimeout(callback, ms);
    };
})();


function closeCookieOverlay() {
    $('.js-cookie-overlay').addClass('bounceOutUp').removeClass('fadeInDown');
    $('.js-cookie-overlay').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function () {
        $('.js-cookie-overlay').remove();
    });
}

//Responsive of Box Navigation
function collapseBoxBgNavigation() {
    if($(".btn-box-navigation-collapse").length > 0) {
        $('.btn-box-navigation-collapse').on('click', function () {
            $(this).toggleClass("btn-box-navigation-collapse-closed");
            $('.wrapper-navigation').toggleClass('wrapper-navigation-collapsed');
            $('.section-step-three').toggleClass('hidden-section-step-three');
            if ($('.list-navigation').hasClass("section-step-three")){
                $('.bg-navigation').addClass("add-padding-bg-navigation");
            }else{
                $('.bg-navigation').removeClass("add-padding-bg-navigation");
            }
       });
    }
}
function assetPaginator() {
    if($(".asset-archive-js").length > 0) {
        $(".asset-archive-js").each(function(){
            var thisTotal = $(this).find(".searchTotal").val();
            $(this).find(".filtro-numbers span").text(thisTotal);
            if ($(this).find(".taglib-page-iterator").children().length == 0){
              $(this).find(".taglib-page-iterator").append('<div class="empty-asset-pagination"><p>Mostrati '+ thisTotal + ' risultati' + '</p></div>');
            }
            if ($(this).find(".taglib-page-iterator .lfr-pagination-buttons li.disabled").length == 4){$(this).find(".taglib-page-iterator .lfr-pagination-buttons").hide()}
        });
    }
}
function heightRubrica (){
    if($(".wrapper-content-total .wrapper-content .div-label-rubrica").length > 0) {
        if($(window).width() >767){
            var maxHeight = 0;
            $(".wrapper-content-total .wrapper-content").each(function(){
                if ($(this).height() > maxHeight) {
                    maxHeight = $(this).height();
                }
            });
            $(".wrapper-content-total .wrapper-content").height(maxHeight);
        }
        else{
            $(".wrapper-content-total .wrapper-content").css('height', '');
        }
        
    }
}
function TipHtml (){
    if($(".toolTip").length > 0) {
        $('.toolTip').each(function () {
            $(this).tooltip({
                html: true,
                title: $('#' + $(this).data('tip')).html()
            });
        });
    }
}

$(function () {
    responsivelatestResearch();
    resizelatestResearch();
    responsiveAreaGroups();
    resizeAreaGroups();
    responsivePhotos();
    resizePhotos();
    responsivePost();
    resizePost();
    responsiveModuls();
    resizeModuls();
    responsiveNoticeBoard();
    resizeNoticeBoard();
    carouselRadiocor();
    carouselPrimoPiano();
    initNavBar();
    initHeaderWidget();
    responsiveKnowledge();
    resizeKnowledge();
    bachecaAnnunciDettaglioInit();
    modulisticaInit();
    initPagination();
    resizeAgenda();
    responsiveAgenda();
    tabFiltriInit();
    multimediaImageSliderInit();
    scegliStato();
    selfServiceSiapCollapse();
    scrivaniaClickPlus();
    BancheDati();
    organigrammaGrafico();
    rubricaPersoneCollapse();
    circularCollapse();
    agendaEventInit();
    tagsInit();
    serviziRichiestaCollapse();
    gestioneRiunioniInit();
    tabRichiesta();
    serviziHeader();
    collapseAule();
    carouselTweetInit();
    resizeApps();
    profileCalendarInfo();
    scrivaniaInit();
    initAreaCollaboration();
    collapseBoxBgNavigation();
    assetPaginator();
    heightRubrica ();
    multimediaGalleryInit();
    prorogaBadgeDate ();
    TipHtml ();
    /* Application Iframe header section */
    $('.widgets-header-wrap #btnWidgetApp').on("click",function(){
        if($("#widget-application-instance").length > 0 && $("#widget-application-instance").attr('src') == ''){
            $('#widget-application-instance').attr('src', $('#appIframe').val()).show();
        }
    });
  $('.selectpicker').selectpicker({
        size: 4
    });

    $('.datepicker-custom').datetimepicker({
        format: 'DD/MM/YYYY'
    });

    $('#buttonSearch').hide();
    $('#aSearch').on('click', function (e) {
        e.preventDefault();
        $('#buttonSearch').click();
    });

    /* Ellipsis start */
    setTimeout(initEllipsis, 100);

    $(window).resize(function () {
        heightRubrica ();
        resizeApps();
        waitForFinalEvent(function () {
            $(".dot-point").trigger('destroy');
            initEllipsis();
        }, 100, "checkEllipsis");
    });
    /* Ellipsis end */
    $(window).on("resize", function(){
      var w = $(this).width();
      if((w < 992) && ($("#filtro-riunioni").hasClass("filtro-compact-grid"))){
        $("#filtro-riunioni").removeClass("filtro-compact-grid").addClass("filter-full-grid");
        $('.riunioni-switch-grid .cta-riunioni-grid').addClass("active");
        $('.riunioni-switch-grid .cta-riunioni-grid.compact-grid').removeClass("active");
      }
      if(w <768){

      }
 });
    /* Multiselect */
    if($(".init-multiselect").length > 0){
        $.each($(".init-multiselect"),function(){
           $(this).multiselect({
               includeSelectAllOption: true
           });
            // var form = $(this).closest('form');
            // if (typeof form.attr('data-parsley-validate') !== typeof undefined && form.attr('data-parsley-validate') !== false) {
            // }else{
            //     form.parsley();
            // }
        });
    }
    if($(".init-multiselect").length > 0){
        $.each($(".init-multiselect"),function(){
            var form = $(this).closest('form');
            if (typeof form.attr('data-parsley-validate') !== typeof undefined && form.attr('data-parsley-validate') !== false) {
            }else{
                form.parsley();
            }
        });
    }
   if ($(".form-control.textarea-custom-light").length > 0) {
        $(".form-control.textarea-custom-light").keyup(function(){
            element = $(this);
            var len = 0;
            var maxLength = $(element).attr("data-parsley-maxlength");
            if (element.val() != null){
                len = element.val().length;
            } else{
                len = element.length;
            }
            if(maxLength==null || maxLength=="" || maxLength<1 ){
                maxLength = 500;
            }
            if (len > maxLength) {
                element.val(element.val().substring(0,maxLength));
                len = maxLength;
            }
            $(element).parent(".wrapper-content-textarea").find(".content-textarea").text( (len)+ "/"+maxLength);
        });
        placeholderIe();
    }


    /* FIX ACCESSIBILITY */

    /* Set aria-label */
    $.each($('#main-content a'), function () {
        var arialabel = $(this).attr('aria-label');
        var title = $(this).attr('title');

        if (typeof arialabel === typeof undefined || arialabel === false) {
            if (typeof title !== typeof undefined && title !== false) {
                $(this).attr('aria-label', title);
            }
        }
    });

    /* Elimino h1 vuoti */
    $.each($('h1'),function(){
        if($(this).text() == ""){
            $(this).remove();
        }
    });

    /* Fix PACK53 Liferay class clearfix */
    $.each($(".aui .portlet .clearfix.journal-content-article"),function(){
        $(this).removeClass("clearfix");
    });
});

	});
});