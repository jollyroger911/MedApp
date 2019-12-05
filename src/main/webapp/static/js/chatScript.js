$(document).ready(function(){

    $(document.getElementsByClassName("send-button")).click(function(){
        $.ajax({ type: 'POST',
            url: "http://localhost:8080/MedicineApp/ajax/demo1",


            // data : JSON.stringify("developerData"),
            // dataType : 'json',
            // dataType: "html",
            // cache: false,
            // contentType: 'text',
            success : function(response) {
                console.log(response);
              //  alert(response);
                document.getElementById('messageArea').innerHTML += '<li>' + response + '</li>';
               // $("#p").html(response);
          //  }
            },
            error : function() {
                alert("opps error occured!");
            }
        });
        // $.get("http://localhost:8080/MedicineApp/chatMessages", function(data){
        //     alert("Data: " + data);
        // });
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
