function applicationsInit(){
    if($('.wrapper-applications-mobile').length > 0) {
        function truncateText (maxChar, elem){
            var textNew;
            var nCharOut;
            var textLength = elem.attr('data-tag-text').length;
            if( textLength > maxChar) {
                elem.addClass('js-truncated');
                nCharOut = textLength - maxChar;
                textNew = elem.attr('data-tag-text');
                textNew = textNew.substring(0, textNew.length-(nCharOut+2));
                elem.text(textNew+"..");
            }
        }
        var breakPointPrev = '';
        var breakPointNow = '';
        
        function checkTextTruncate(){
            $('.js-length-check').each(function(){
                // Media query JS
                if($(window).width() >= 1200) {
                    //Desktop Min
                    if(!$(this).hasClass('js-length-check-single')){
                        truncateText(20, $(this));
                    } else {
                        truncateText(50, $(this));
                    }   
                } else if($(window).width() >= 992) {
                    //MD min
                    if(!$(this).hasClass('js-length-check-single')){
                        truncateText(16, $(this));
                    } else {
                        truncateText(42, $(this));
                    } 
                } else if ($(window).width() >= 768) {
                    //Tablet min
                    if(!$(this).hasClass('js-length-check-single')){
                        truncateText(19, $(this));
                    } else {
                        truncateText(48, $(this));
                    } 
                } else if ($(window).width() >= 320) {
                    //Mobile min
                    if(!$(this).hasClass('js-length-check-single')){
                        truncateText(15, $(this));
                    } else {
                        truncateText(40, $(this));
                    } 
                }
            })
        }

        function checkBreakPoint() {
            if($(window).width() >= 1200) {
                //Desktop Min
                return 'desktop';
            } else if($(window).width() >= 992) {
                //MD min
                return 'md';
            } else if ($(window).width() >= 768) {
                //Tablet min
                return 'tablet';
            } else if ($(window).width() >= 320) {
                //Mobile min
                return 'mobile';
            }
        }

        // add particular class if there is only 1 tag for truncate maxChar change
        $('.tags-for-modal').each(function(){
            if($(this).find('.tag').length == 1) {
                $(this).find('.tag').addClass('js-length-check-single');
            }
        })

        checkTextTruncate();
        breakPointPrev = checkBreakPoint();

        $(window).resize(function(){
            breakPointNow = checkBreakPoint();
            if (breakPointNow != breakPointPrev){
                breakPointPrev = breakPointNow;
                checkTextTruncate();
            }
        })

        // Check if enable or not the modal button --> ENABLED if tags > 2 or there is one or more .js-truncated
        $('.tags-for-modal').each(function(){
            if($(this).find('.tag').length > 2 || $(this).find('.js-truncated').length > 0) {
                $(this).parent().find('.tags-more-modal').removeClass('hidden');
            }
        })
        $('.tags-more-modal').on('click',function(){
            var htmlContent = $(this).parent().find('.tags-for-modal').html();
            $('.modal-application-tags .tags-container').html(htmlContent);
            $('.modal-application-tags .tags-container .tag').each(function(){
                $(this).text($(this).attr('data-tag-text'));
            })
            $('.modal-application-tags .tags-container .tag').removeClass("hidden");
            $('.modal-application-tags .tags-container .tag').removeClass("js-length-check");
        })
    }
}