$(document).ready(function (e) {
    $("input").click(function (event) {
        $.ajax({
            type: 'POST',
            url: "/MedicineApp/ajax/demo3",
            success: function (response) {
                console.log(response.length);
                alert(response);
            },
            error: function (data) {
                alert("opps error occured! " + data);
            }
        });
    });
});

