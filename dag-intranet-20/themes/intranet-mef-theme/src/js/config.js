// Defining a lower case alias for window.jQuery
define('jquery', function () {
	return window.jQuery;
});

// Defining a capitalized alias for window.jQuery
define('jQuery', function () {
	return window.jQuery;
});

Loader.addModule({
    name: 'moment',
    dependencies: ['jquery'],
    path: MODULE_PATH + '/js/vendor/moment.min.js',
    anonymous: true
});

Loader.addModule({
    name: 'it',
    dependencies: ['moment'],
    path: MODULE_PATH + '/js/vendor/it.js',
    anonymous: true
});

Loader.addModule({
    name: 'datetimepicker',
    dependencies: ['jquery','moment'],
    path: MODULE_PATH + '/js/vendor/bootstrap-datetimepicker.min.js',
    anonymous: true
});

Loader.addModule({
    name: 'slick',
    dependencies: ['jquery'],
    path: MODULE_PATH + "/js/vendor/slick.js",
    anonymous: true
});

Loader.addModule({
    name: 'photoswipe',
    dependencies: [],
    path: MODULE_PATH + "/js/vendor/photoswipe.js",
    anonymous: true
});

Loader.addModule({
    name: 'photoswipeUiDefault',
    dependencies: [],
    path: MODULE_PATH + "/js/vendor/photoswipe-ui-default.js",
    anonymous: true
});
Loader.addModule({
    name: 'jqphotoswipe',
    dependencies: ['jquery'],
    path: MODULE_PATH + "/js/vendor/jqPhotoSwipe.js",
    anonymous: true
});
Loader.addModule({
    name: 'selectpicker',
    dependencies: ['jquery'],
    path: MODULE_PATH + '/js/vendor/selectpicker.js',
    anonymous: true
});

Loader.addModule({
    name: 'dotdotdot',
    dependencies: ['jQuery'],
    path: MODULE_PATH + '/js/vendor/dotdotdot.js',
    anonymous: true
});

Loader.addModule({
    name: 'parsley',
    dependencies: ['jquery'],
    path: MODULE_PATH + '/js/vendor/parsley.js',
    anonymous: true
});

Loader.addModule({
    name: 'multiselect',
    dependencies: ['jQuery'],
    path: MODULE_PATH + '/js/vendor/bootstrap-multiselect.js',
    anonymous: true
});