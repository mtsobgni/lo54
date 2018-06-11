$(document).ready(function() {
    $('#search').click(function() {
        $.ajax({
            url : 'find',
            data : {
                val : $('#keyword').val()
            },
            type:'POST',
            success : function(responseText) {
                $('#keyword').text(responseText);

            }
        });
    });
});
