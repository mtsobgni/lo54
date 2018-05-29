$(document).ready(function() {
    $('#rec').click(function() {
        $.ajax({
            url : 'find',
            data : {
                val : $('#s').val()
            },
            type:'POST',
            success : function(responseText) {
                $('#lo').text(responseText);

            }
        });
    });
});
