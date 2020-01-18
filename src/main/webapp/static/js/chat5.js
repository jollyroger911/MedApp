'use strict';

var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');
var usernameForm = document.querySelector('#usernameForm');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');

var stompClient = null;
var username = null;
var destUsername = null;
var destId = null;
var senderId = null;
var destLogin = null;
var senderLogin = null;

var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];
connect();

function connect() {
    username = document.querySelector('#name').value.trim();
    destUsername = document.querySelector('#destName').value.trim();
    destId = document.querySelector('#destId').value.trim();
    senderId = document.querySelector('#senderId').value.trim();
    destLogin = document.querySelector('#destUsername').value.trim();
    senderLogin = document.querySelector('#senderUsername').value.trim();

    if (username) {
        usernamePage.classList.add('hidden');
        chatPage.classList.remove('hidden');

        var socket = new SockJS('/MedicineApp/ws');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected, onError);
    }
}


function onConnected() {
    stompClient.subscribe('/user/queue/reply', onMessageReceived);
    console.log("Subscribed");
    loadMessages();
    stompClient.send("/app/chat.addUser",
        {},
        JSON.stringify({sender: username, type: 'JOIN'})
    )
    connectingElement.classList.add('hidden');
}

function onError(error) {
    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    connectingElement.style.color = 'red';
}

function sendMessage(event) {
    var messageContent = messageInput.value.trim();
    if (messageContent && stompClient) {
        var chatMessage = {
            sender: username,
            content: messageInput.value,
            type: 'CHAT',
            dest: destUsername,
            destId: destId,
            senderId: senderId
        };
        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
    event.preventDefault();
}


function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);
    if (message.sender === destUsername || message.sender === username) {
        var messageElement = document.createElement('li');

        if (message.type === 'JOIN') {
            messageElement.classList.add('event-message');
            message.content = message.sender + ' joined!';
        } else if (message.type === 'LEAVE') {
            messageElement.classList.add('event-message');
            message.content = message.sender + ' left!';
        } else {
            messageElement.classList.add('chat-message');

            var avatarElement = document.createElement('i');
            var avatarText = document.createTextNode(message.sender[0]);
            avatarElement.appendChild(avatarText);
            avatarElement.style['background-color'] = getAvatarColor(message.sender);

            messageElement.appendChild(avatarElement);

            var usernameElement = document.createElement('span');
            var usernameText = document.createTextNode(message.sender);
            usernameElement.appendChild(usernameText);
            messageElement.appendChild(usernameElement);
        }

        var textElement = document.createElement('p');
        var messageText = document.createTextNode(message.content);
        textElement.appendChild(messageText);

        messageElement.appendChild(textElement);

        messageArea.appendChild(messageElement);
        messageArea.scrollTop = messageArea.scrollHeight;
    }
}


function getAvatarColor(messageSender) {
    var hash = 0;
    for (var i = 0; i < messageSender.length; i++) {
        hash = 31 * hash + messageSender.charCodeAt(i);
    }
    var index = Math.abs(hash % colors.length);
    if (messageSender === username)
        return colors[0];
    else
        return colors[6];
}

function sentMessagesLight() {
    for (let i = 0; i < sentMessages.length; i++) {
        if (sentMessages[i].sender === username) {
            avatarElements[i].style['background-color'] = colors[0];
        } else {
            avatarElements[i].style['background-color'] = colors[6];
        }
    }
}

//connect();
usernameForm.addEventListener('submit', connect, true);
messageForm.addEventListener('submit', sendMessage, true);


function loadMessages() {
    $(document).ready(function () {
        $.ajax({
            type: 'POST',
            url: "/MedicineApp/ajax/messagesLoadAjax",
            data: {
                idOne: senderId,
                idTwo: destId
            },
            success: function (response) {
                for (let i = 0; i < response.length; i++) {
                    var messageElement = document.createElement('li');
                    messageElement.classList.add('chat-message');
                    var avatarElement = document.createElement('i');
                    var avatarText = document.createTextNode(response[i].sender[0]);
                    avatarElement.appendChild(avatarText);
                    avatarElement.style['background-color'] = getAvatarColor(response[i].sender);
                    messageElement.appendChild(avatarElement);
                    var usernameElement = document.createElement('span');
                    var usernameText = document.createTextNode(response[i].sender);
                    usernameElement.appendChild(usernameText);
                    messageElement.appendChild(usernameElement);
                    var textElement = document.createElement('p');
                    var messageText = document.createTextNode(response[i].content);
                    textElement.appendChild(messageText);
                    messageElement.appendChild(textElement);
                    messageArea.appendChild(messageElement);
                    messageArea.scrollTop = messageArea.scrollHeight;
                }
            },
            error: function (data) {
                alert("opps error occured with loading messages! " + data);
            }
        });
    });
}
