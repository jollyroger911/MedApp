var flag = false;
var exchange = null;

// let list = document.getElementsByClassName("selectors");
// for(let i = 0; i < list.length; i++){
//     list[i].click();
// };
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
                //console.log(destDoctorId);
                destTime.value = target.value;
                //  console.log(destTime);
                //  destDoctorId.value = targer.id.toString();
                //  destTime.value = target.value.toString();
                // console.log(response.length);

                if ($(event.target).children().length === 0 || flag) {
                    exchange = target;
                    for (let i = 0; i < response.length; i++) {
                        document.getElementById(target.id).innerHTML += '<option id="childDiv"  value="1">'  + response[i] + '</option>';
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
                //let str = [[${your.chosenTime}]];
                alert(response);
                flag = true;
                console.log(response+"");
                // destDoctorId.value = target.id;
                // console.log(destDoctorId);
                // destTime.value = target.value;
                //  console.log(destTime);
                //  destDoctorId.value = targer.id.toString();
                //  destTime.value = target.value.toString();
                // console.log(response.length);
                // if ($(event.target).children().length === 0) {
                //     for (let i = 0; i < response.length; i++) {
                //         document.getElementById(target.id).innerHTML += '<option id="childDiv">' + response[i] + '</option>';
                //     }
                // }
            },
            error: function (data) {
                alert("opps error occured! " + data);
            }
        });
    });
});

// var callbacks = {
//     onReady: function () {
//         console.log('onReady', arguments[0]);
//     },
//     onStop: function () {
//         console.log('onStop', arguments[0]);
//     },
//     onItemHover: function () {
//         console.log('onItemHover', arguments[0]);
//     },
//     onItemOut: function () {
//         console.log('onItemOut', arguments[0]);
//     },
//     onMoveStart: function () {
//         console.log('onMoveStart', arguments[0]);
//     },
//     onMoveEnd: function () {
//         console.log('onMoveEnd', arguments[0]);
//     }
// };
//
// var MagicScrollOptions = {};
// magicJS.extend(MagicScrollOptions, callbacks);
//
// function isDefaultOption(o) {
//     return magicJS.$A(magicJS.$(o).byTag('option')).filter(function(opt){
//         return opt.selected && opt.defaultSelected;
//     }).length > 0;
// }
//
// function toOptionValue(v) {
//     if ( /^(true|false)$/.test(v) ) {
//         return 'true' === v;
//     }
//     if ( /^[0-9]{1,}$/i.test(v) ) {
//         return parseInt(v,10);
//     }
//     return v;
// }
//
// function makeOptions(optType) {
//     var  value = null, isDefault = true, newParams = Array(), newParamsS = '', options = {};
//     magicJS.$(magicJS.$A(magicJS.$(optType).getElementsByTagName("INPUT"))
//         .concat(magicJS.$A(magicJS.$(optType).getElementsByTagName('SELECT'))))
//         .forEach(function(param){
//             value = ('checkbox'==param.type) ? param.checked.toString() : param.value;
//
//             isDefault = ('checkbox'==param.type) ? value == param.defaultChecked.toString() :
//                 ('SELECT'==param.tagName) ? isDefaultOption(param) : value == param.defaultValue;
//
//             if ( null !== value && !isDefault) {
//                 options[param.name] = toOptionValue(value);
//             }
//         });
//
//     magicJS.extend(options, callbacks);
//     return options;
// }
//
// function updateScriptCode() {
//     var code = '&lt;script&gt;\nvar MagicScrollOptions = ';
//     code += JSON.stringify(MagicScrollOptions, null, 2).replace(/\"(\w+)\":/g,"$1:")+';';
//     code += '\n&lt;/script&gt;';
//
//     magicJS.$('app-code-sample-script').changeContent(code);
// }
//
// function updateInlineCode() {
//     var code = '&lt;div class="MagicScroll" data-options="';
//     code += JSON.stringify(MagicScrollOptions).replace(/\"(\w+)\":(?:\"([^"]+)\"|([^,}]+))(,)?/g, "$1: $2$3; ").replace(/\{([^{}]*)\}/,"$1").replace(/\s*$/,'');
//     code += '"&gt;';
//
//     magicJS.$('app-code-sample-inline').changeContent(code);
// }
//
// function applySettings() {
//     MagicScroll.stop('scroll-1');
//     MagicScrollOptions = makeOptions('params');
//     MagicScroll.start('scroll-1');
//     updateScriptCode();
//     updateInlineCode();
//     try {
//         prettyPrint();
//     } catch(e) {}
// }
//
// function copyToClipboard(src) {
//     var
//         copyNode,
//         range, success;
//
//     if (!isCopySupported()) {
//         disableCopy();
//         return;
//     }
//     copyNode = document.getElementById('code-to-copy');
//     copyNode.innerHTML = document.getElementById(src).innerHTML;
//
//     range = document.createRange();
//     range.selectNode(copyNode);
//     window.getSelection().addRange(range);
//
//     try {
//         success = document.execCommand('copy');
//     } catch(err) {
//         success = false;
//     }
//     window.getSelection().removeAllRanges();
//     if (!success) {
//         disableCopy();
//     } else {
//         new magicJS.Message('Settings code copied to clipboard.', 3000,
//             document.querySelector('.app-code-holder'), 'copy-msg');
//     }
// }
//
// function disableCopy() {
//     magicJS.$A(document.querySelectorAll('.cfg-btn-copy')).forEach(function(node) {
//         node.disabled = true;
//     });
//     new magicJS.Message('Sorry, cannot copy settings code to clipboard. Please select and copy code manually.', 3000,
//         document.querySelector('.app-code-holder'), 'copy-msg copy-msg-failed');
// }
//
// function isCopySupported() {
//     if ( !window.getSelection || !document.createRange || !document.queryCommandSupported ) { return false; }
//     return document.queryCommandSupported('copy');
// }