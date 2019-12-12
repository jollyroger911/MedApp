$(document).ready(function () {
    let role;
    $.ajax({
        type: 'GET',
        url: "/MedicineApp/ajax/demo4",
        success: function (response) {
            role = response;
            console.log(role);
        },
        error: function () {
            alert("opps error occured!");
        }
    });
    let menuItems = document.getElementsByClassName("menu-item");
    if(role === 0){
        menuItems.hide();
        alert("hidden");
    }
});