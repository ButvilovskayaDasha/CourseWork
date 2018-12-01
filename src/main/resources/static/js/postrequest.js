$(document).ready(() => {
  $('#realtorSubmit').click((event) => {
    event.preventDefault();
    doAjax();
  });
});

function doAjax () {
  var form = $('#fileUploadForm')[0];
  var data = new FormData(form);

  $.ajax({
    type: 'POST',
    enctype: 'multipart/form-data',
    url: '/main',
    data: data,
    processData: false,
    contentType: false,
    cache: false,
    error: (error) => {
      console.error(error);
    }
  });
}
