/*AUI().use(
	'liferay-menu',
	function ( A ) {
		Liferay.Menu.register('userDropdownToggle');
		Liferay.Menu.handleFocus('userDropdownMenu');
		Liferay.Menu.register('userNotificationsToggle');
	}
);*/
require(['jquery', 'parsley'] , function ($) {
	$('body').trigger('parsleyok');

	$(window).resize(function(){
		$('#wrapper').removeAttr('style');
		$('#target-navigation').removeAttr('style');
		if($(window).width() > 991){
			var hm = $(window).height() - $('#footer').outerHeight() - $('.sc-dockbar').innerHeight();
			if(hm > $('#target-navigation').innerHeight()){
				$('#target-navigation').css('min-height',hm+'px');
			}

			var h = $('#target-navigation').innerHeight() + $('.sc-dockbar').innerHeight();
			var hd = $(window).height() - $('#footer').outerHeight(true);

			if(h > hd){
				$('#wrapper').css('min-height',h+'px');
			}else{
				$('#wrapper').css('min-height',hd+'px');
			}
		}
	});

	$(document).ready(function(){
		$('span.nav-icon.icomoon-community').parent().html('<span class="nav-icon icomoon-community"></span> Community Intranet MEF');
	});

	$(window).trigger('resize');
});

AUI().use('aui-base', 'aui-debounce', 'event-focus',"liferay-store", function (A) {

	var B = A.getBody();

	var OPEN_CSS_CLASS = 'open';

	var scDockbar = A.one('.sc-dockbar');
	B.setStyle('overflow', 'auto');

	var targetNavigation = A.one('#target-navigation');
	var menuToggler = A.one('.menu-toggler');
	//	var togglerIcon = A.one('#target-navigation .menu-toggler span');


	var body = A.one('body');

	if (targetNavigation) {
		menuToggler.on('click', function(event){

			if (!targetNavigation.hasClass('open-md-lg')) {
				targetNavigation.addClass('open-md-lg');

				if (body.hasClass('has-target-menu-closed')) {
					body.removeClass('has-target-menu-closed');
					body.addClass('has-target-menu');
				}

				Liferay.Store("sessionClickMenuToggler", true);
			} else {
				targetNavigation.removeClass('open-md-lg');

				if (body.hasClass('has-target-menu')) {
					body.removeClass('has-target-menu');
					body.addClass('has-target-menu-closed');
				}

				Liferay.Store("sessionClickMenuToggler", false);
			}

		});
	}

	if (scDockbar) {
		scDockbar.delegate(
			'click',
			function (event) {
				event.preventDefault();

				var id = event.currentTarget.get('id');

				var toggleTarget = A.one('[aria-labelledby="' + id + '"]');

				if (targetNavigation && targetNavigation.hasClass('open-xs')) {
					 targetNavigation.removeClass('open-xs');
				}

				if (!toggleTarget) {
					return;
				}

				var parentNode = toggleTarget.get('parentNode');

				if (!parentNode) {
					return;
				}

				if (parentNode.hasClass(OPEN_CSS_CLASS)) {
					parentNode.removeClass(OPEN_CSS_CLASS);

					event.currentTarget.setAttribute('aria-expanded', 'false');
				}
				else {
					A.all('.trap-focus.open').each(function(node){
						node.removeClass(OPEN_CSS_CLASS);
						node.one('a').setAttribute('aria-expanded', 'false');
					});

					parentNode.addClass(OPEN_CSS_CLASS);
					event.currentTarget.setAttribute('aria-expanded', 'true');

				}
			},
			'[data-toggle="aria"]'
		);

		scDockbar.delegate(
			'click',
			function (event) {
				var targetNavigation = A.one('#target-navigation');

				if (targetNavigation) {
					if (targetNavigation.hasClass('open-xs')) {
						targetNavigation.removeClass('open-xs');
						event.currentTarget.setAttribute(
							'aria-expanded', 'false');
					}
					else {
						targetNavigation.addClass('open-xs');
						event.currentTarget.setAttribute(
							'aria-expanded', 'true');

							A.all('.trap-focus.open').each(function(node){
								node.removeClass(OPEN_CSS_CLASS);
								node.one('a').setAttribute('aria-expanded', 'false');
							});

					}
				}
			},
			'.navbar-toggle'
		);

		var searchForm = A.one('#search-form');
		var overlayBackground = A.one('.overlay-bg');
		var searchScopeForm = A.one('#scope-form');

	    if (searchForm) {
			searchForm.on('click', function(event){
				//overlayBackground.setStyle('height', A.one('body').height());
				overlayBackground.setStyle('height', '100vh');

				overlayBackground.show();
				searchScopeForm.show();
				B.setStyle('overflow', 'hidden');
			});

			if (overlayBackground) {
				overlayBackground.on('click', function(e) {

					hideOverlayAndForm();
				});

				B.on(
					'key',
					function(event) {
						hideOverlayAndForm();
					},
					'esc'
				);
			}
		}
		
		
		function hideOverlayAndForm(){
			overlayBackground.hide();
			searchScopeForm.hide();
			B.setStyle('overflow', 'auto');

			if(scDockbar.hasClass('search-form-open')){
				scDockbar.removeClass('search-form-open');
			}
		};
		
		
	}

});

$(document).ready(function (){
	$(".lexicon-icon title").attr("aria-label"," ");
});
