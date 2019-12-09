
$(document).ready(function(){
    //
    // $("option > select").click(function (e) {
    //     e.stopPropagation();
        $("select").click(function (event) {
            let target = event.target;



                $.ajax({
                    type: 'POST',
                    url: "http://localhost:8080/MedicineApp/ajax/demo2",

                    // data: target.id,

                    data: {
                        id: target.id
                    },           //  data: "{id:'" + target.id + "'}",
                    //  dataType: 'json',
                    success: function (response) {
                        //  alert(response);
                        console.log(response.length);
                        $("select").empty();
                        //delete (content);
                        for (let i = 0; i < response.length; i++) {
                            document.getElementById(target.id).innerHTML += '<option>' + response[i] + '</option>';
                        }
                    },
                    error: function (data) {
                        alert("opps error occured! " + data);
                    }
                });
            // });
        });


    // alert(123);
    //
    // alert($("select"));

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