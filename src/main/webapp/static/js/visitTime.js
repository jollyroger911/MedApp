var flag = false;
var exchange = null;

$(document).ready(function (e) {
    $("select").click(function (event) {
        var target = event.target;
        let destDoctorId = document.getElementById("destDocId");
        let destTime = document.getElementById("destVisitTime");

        $.ajax({
            type: 'POST',
            url: "/MedicineApp/ajax/demo2",
            data:  {
                id: target.id,
                selected: target.value
            },
            success: function (response) {
                destDoctorId.value = target.id;
                destTime.value = target.value;
                if ($(event.target).children().length === 0 || flag) {
                    exchange = target;
                    for (let i = 0; i < response.length; i++) {
                        document.getElementById(target.id).innerHTML += '<option id="childDiv">'  + response[i] + '</option>';
                    }

                    flag = false;
                }
            },
            error: function (data) {
                alert("opps error occured! " + data);
            }
        });
    });



});

$(document).ready(function (e) {
    $("input").click(function (event) {
        //  let target = event.target;

        let destDoctorId = document.getElementById("destDocId");
        let destTime = document.getElementById("destVisitTime");
        $(document.getElementById(exchange.id)).empty();
        $.ajax({
            type: 'POST',
            url: "/MedicineApp/ajax/demo3",
            data:  {
                id: destDoctorId.value,
                selected: destTime.value
            },
            success: function (response) {
                alert(response);
                flag = true;
                console.log(response+"");
            },
            error: function (data) {
                alert("opps error occured! " + data);
            }
        });
    });
});
