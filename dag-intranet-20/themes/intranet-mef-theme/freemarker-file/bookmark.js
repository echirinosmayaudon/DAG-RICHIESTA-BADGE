if (${permissionChecker.isSignedIn().toString()} === true) {
  currentId = ${permissionChecker.getUserId()};
  console.log("Current Id: " + currentId);
}



Liferay.Service('/mefintranet.favourites/get-fav-by-url', {
  user_id: currentId,
  friendlyUrl_page: window.location.href
}, function(obj) {
  console.log("Favourite Id is: " + obj);
  if (obj > -1) {
      console.log("Obj result is true");
      $('.title-star').removeClass("icomoon-star");
      $('.title-star').addClass("icomoon-star-color");
      $('.title-star').data("id-bookmark",obj);
  }
});


$("a.title-star.icomoon-star-color").on( "click", function() {
  if (confirm("Are you sure you want to delete this item from Favourites List?") == true) {
    console.log("Star is full");
    console.log("Fav Id inside if" + document.getElementById('favId').value);

    Liferay.Service('/mefintranet.favourites/delete-favourite', {
      favourite_id: this.data("id-bookmark")
    }, function(obj) {
      console.log("Deleted: " + obj);
    });
});

$("a.title-star.icomoon-star").on( "click", function() {

  console.log("Star is empty");
  var setFavTitle = document.title;
  var setFavUrl = window.location.href;
  var setFavDate = new Date().toString();

  Liferay.Service('/mefintranet.favourites/set-favourite', {
    user_id: currentId,
    title_favourite: setFavTitle,
    description_favourite: setFavDescription,
    url_favourite: setFavUrl,
    save_date: setFavDate
  }, function(obj) {

    if (obj === true) {

      Liferay.Service('/mefintranet.favourites/get-fav-by-url', {
        user_id: currentId,
        friendlyUrl_page: setFavUrl
      }, function(ob) {
        console.log("Favourite Id is: " + ob);
        console.log("Favourite setted: " + obj);
        var dialogbutton2 = $(".btnClass");
        dialogbutton2.val(ob);
        dialogbutton2.html("&#9733;");
      });
      window.alert("Succesfully saved in Favourites!");

    }
});

function submitStar(a) {

  console.log(a.value);
  if (a.value != "-1" || a.value > -1) {

    if (confirm("Are you sure you want to delete this item from Favourites List?") == true) {
      console.log("Star is full");
      console.log("Fav Id inside if" + document.getElementById('favId').value);

      Liferay.Service('/mefintranet.favourites/delete-favourite', {
        favourite_id: a.value
      }, function(obj) {
        console.log("Deleted: " + obj);
      });

      var dialogbutton1 = $(".btnClass");
      dialogbutton1.val(-1);
      dialogbutton1.html("&#9734;");
    }

  } else {
    console.log("Star is empty");
    var setFavTitle = document.title;
    var setFavUrl = window.location.href;
    var setFavDate = new Date().toString();

    Liferay.Service('/mefintranet.favourites/set-favourite', {
      user_id: currentId,
      title_favourite: setFavTitle,
      description_favourite: setFavDescription,
      url_favourite: setFavUrl,
      save_date: setFavDate
    }, function(obj) {

      if (obj === true) {

        Liferay.Service('/mefintranet.favourites/get-fav-by-url', {
          user_id: currentId,
          friendlyUrl_page: setFavUrl
        }, function(ob) {
          console.log("Favourite Id is: " + ob);
          console.log("Favourite setted: " + obj);
          var dialogbutton2 = $(".btnClass");
          dialogbutton2.val(ob);
          dialogbutton2.html("&#9733;");
        });
        window.alert("Succesfully saved in Favourites!");

      }

    });

  }

}
