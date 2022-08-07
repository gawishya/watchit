const baseUrl = "/v1/watch";

function watchit(time) {
    $.ajax({
        type: 'GET',
        url: baseUrl + "/interpreter?time=" + time,
        contentType: 'application/json',
        success: function(response) {
            $("#result").html(response);
        },
        error: function() {
            console.log("Error occurred");
        }
    });
}
