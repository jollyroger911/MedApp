$(document).ready(function(){
    $(document.getElementsByClassName("send-button")[0]).click(function(){
        $.ajax({ type: 'GET',
            url: "/MedicineApp/ajax/chatScript",
            success : function(response) {
                console.log(response);
                for(let i = 0; i < response.length; i++) {
                    document.getElementsByClassName("myBox")[0].innerHTML += '<li>' + response[i].message + '</li>';
                }
            },
            error : function() {
                alert("opps error occured!");
            }
        });
    });
});


// 'use strict';
//   //  var messages = document.getElementsByClassName("messages-list");
//
//     var buttonSend = document.getElementsByClassName("send-button")
//    // var area = document.getElementsByClassName("event-message");
//
//     // function displayMessages(){
//     //     for(let i = 0; i < messages.length; i++){
//     //         document.getElementsByClassName("event-message").innerHTML += '<li>' + messages[i] + '</li>';
//     //     }
//     // };
// $(document).ready(function(){
//     buttonSend.click(function (){
//         $.ajax("/chatMessage", success: function f (result){
//             $("#div1").html(result);
//         }});
// });
//
//     // buttonSend.addEventListener('onClick', () => {
//     //     let request = new XMLHttpRequest();
//     //     request.open('GET', "/chatMessages");
//     //     request.setRequestHeader('Content-type', 'string; charset=utf-8');
//     //     request.send();
//     //
//     //     request.addEventListener('readyStateChange', function(){
//     //         if(request.readyState === 4 && request.status == 200){
//     //             let data = request.response;
//     //             messages.add(data);
//     //             displayMessages();
//     //         }
//     //         else {
//     //             alert("Something gone wrong");
//     //         }
//     //     });
//     // });
