// Defining a lower case alias for window.jQuery
define('jquery', function () {
	return window.jQuery;
});

// Defining a capitalized alias for window.jQuery
define('jQuery', function () {
	return window.jQuery;
});

Loader.addModule({
    name: 'parsley',
    dependencies: ['jquery'],
    path: MODULE_PATH + '/js/vendor/parsley.js',
    anonymous: true
});