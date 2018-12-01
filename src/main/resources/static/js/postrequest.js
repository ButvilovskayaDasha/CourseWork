$(document).ready( () => {
    $("#realtorSubmit").click((event) => {
    //stop submit the form, we will post it manually.
    event.preventDefault();
doAjax();
});

});

function doAjax() {

    // Get form
    var form = $('#fileUploadForm')[0];
    var data = new FormData(form);

    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/main",
        data: data,
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false
},
    error: (e) => {
        $("#listFiles").text(e.responseText);
    }
});
}