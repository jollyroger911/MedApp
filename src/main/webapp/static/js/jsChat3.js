// document.addEventListener('DOMContentLoaded', function () {
    // $('.card-header').on('click', '[data-fa-i2svg]', function () {
    //     $("#sidebar-content")
    //         .removeClass("w-100")
    //         .width($("#sidebar").width());
    //     $("#sidebar").css({"flex" : "none"});
    //     $("#sidebar").animate({
    //         width: "toggle"
    //     }, 600, function() {
    //         $("#sidebar").css({"flex" : '', "width" : ''});
    //         $("#sidebar-content")
    //             .css("width", "")
    //             .addClass("w-100");
    //     });
    // });
    //
    // $("#search").on("keyup", function() {
    //     var value = $(this).val().toLowerCase();
    //     $("#friend-list li .username").filter(function() {
    //         $(this).parent().toggle($(this).text().toLowerCase().indexOf(value) > -1);
    //     });
    // });
$(document).ready(function (e) {
    $("button").click(function (event){
        let message = document.getElementById("myInput").value;
       $.ajax({
           type: 'POST',
           url: "/MedicineApp/ajax/demo1",
           data: {
               selected: message
           },
           success: function (response) {
               // document.getElementsByClassName("messages-list")[0].load(
               let res = '<div class="card message-card m-1">'
                   + '<div class="card-body p-2">' + ' <span class="mx-2">' + message + '</span>'+ '<span class="float-right mx-1"><small><i class="fas fa-eye fa-fw"\n' +
                   '                                                                              style="color:#e64980"></i></small></span>'
                   + '</div>' + '</div>';
               $('row').html(res).load();

           },
           error: function (data) {
               alert("opps error occured! " + data);
           }
       });
    });

});