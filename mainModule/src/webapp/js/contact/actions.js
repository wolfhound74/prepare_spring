$(function () {

    $(".deleteContact").bind("click change", function () {
        var id = $(this).metadata().id;
        var url = "/contact/delete";
        PrepareSpring.postJSON(url, {id:id}, function (data) {
            if (data.object1){
                alert("buagaga")
            } else {
                alert("no bugaga!")
            }
            location.reload();
        });
    })
});