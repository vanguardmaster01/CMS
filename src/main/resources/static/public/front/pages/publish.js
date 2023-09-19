$(document).ready(function(){
	var base_url = window.location.origin;
	
    $('#publish').on('click', function(){
    	var id = $(this).data("blogid");
    	var title = $('#title').val();
    	var content = $('#content').val();
    	$.ajax({
            type:"POST",
            url : '/publishBlog',
            data: {
            	id: id,
            	title: title,
            	content: content
            },
            dataType: "JSON",
            success : function(response){
                if(response.status == 'success'){
                    alert("Successfully published!");
                }
               console.log("success");
            },
            error: function(response){
               
                console.log(response);
            }
        });
    });
    
    $('#cancel').on('click', function(){
    	history.back();
    });
    
})