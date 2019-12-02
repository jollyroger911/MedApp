$(document).ready(function() {
    $('#sampleForm').submit(
        function(event) {
            var firstname = $('#arr').val();
            var data = 'firstname='
                + encodeURIComponent(firstname)
                + '&amp;lastname='
                + encodeURIComponent(lastname);
            $.ajax({
                url : $("#sampleForm").attr("action"),
                data : data,
                type : "GET",

                success : function(response) {
                    alert( response );
                },
                error : function(xhr, status, error) {
                    alert(xhr.responseText);
                }
            });
            return false;
        });
});