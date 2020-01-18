$(document).ready(function (e) {
    $("#myInput").click(function (event){
        let message = document.getElementById("myInput").value;
        $.ajax({
            type: 'POST',
            url: "/MedicineApp/ajax/chatScript",
            data: {
                selected: message
            },
            success: function (response) {
                // document.getElementsByClassName("messages-list")[0].load(
                let res = '<div class="card message-card m-1">'
                    + '<div class="card-body p-2">' + ' <span class="mx-2">' + response + '</span>'+ '<span class="float-right mx-1"><small><i class="fas fa-eye fa-fw"\n' +
                    '                                                                              style="color:#e64980"></i></small></span>'
                    + '</div>' + '</div>';
                // alert(response);
                $(".message-scroll").append(res);
                $('#myInput').val("");
            },
            error: function (data) {
                alert("opps error occured! " + data);
            }
        });
    });

});