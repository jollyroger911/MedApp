// $(document).ready(function (e) {
//     $(".date-selectors").click(function (event) {
//         let target = event.target;
//         $.ajax({
//             type: 'POST',
//             url: "/MedicineApp/ajax/demo6",
//             data: {
//                 id: target.id,
//                 selected: target.value
//             },
//             success: function (resp) {
//                 console.log(resp.length);
//                 if ($(event.target).children().length === 0) {
//                     for (let i = 0; i < resp.length; i++) {
//                         document.getElementById(target.id).innerHTML += '<option id="childDiv">' + resp[i] + '</option>';
//                     }
//                 }
//             },
//             error: function (data) {
//                 alert("opps error occured! " + data);
//             }
//         });
//     });
// });