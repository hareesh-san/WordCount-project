$(document).ready(function () {
    $("#search-form button").click(function (event) {
        event.preventDefault();

        if($(this).attr("id") == "bth-search") {
            fire_ajax_submit();
        }

        if($(this).attr("id") == "bth-reset") {
            fire_ajax_reset();
        }
    });
});

function fire_ajax_submit() {

    var search = {}
    //alert("before ajax form submit");
    search["sentence"] = $("#sentence").val();
    //search["email"] = $("#email").val();

    $("#btn-search").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/search",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);
            $("#feedback").prop("hidden", false);

            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);


        }
    });
}


function fire_ajax_reset() {


    $("#btn-search").prop("disabled", true);

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/api/search",
        dataType: 'json',
        //cache: false,
        //timeout: 600000,
        success: function (data) {

            var json = "<h4>Response</h4><pre>"
                + JSON.stringify(null, null, 4) + "</pre>";
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);
            $("#feedback").prop("hidden", true);

        },
        error: function (e) {

            var json = "<h4>Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });
}
