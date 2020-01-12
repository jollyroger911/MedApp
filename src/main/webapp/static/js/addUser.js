$(document).ready(function (e) {
    let value = document.getElementById("exampleInputEmail5");
    var doc = $("#button-doc");
    doc.click(function (event)
    {
        value.value = 1;
    });
    $("#button-pat").click(function(ev){
       value.value = 0;
    });
});



// $(".pat")[0].click(function(){
//     pat.value = 0;
// });
