$(document).ready(function(){
	var base_url = window.location.origin;
	
    $('.editblog-btn').on('click', function(){
    	var blogid = $(this).data("blogid");
    	var link = base_url + "/preview?id=" + blogid + "&type=1";
        $(location).attr('href',link);
    })
    
    $('.deleteblog-btn').on('click', function(){
    	var blogid = $(this).data("blogid");
        $.ajax({
            type:"POST",
            url : '/deleteBlog',
            data:{
                id :blogid
            },
            dataType : 'JSON',
            success : function(response){
                if(response.status == 'success'){
                    console.log("success");
                }
            },
            error: function(response){
               
                console.log(response);
            }
        });
    })
})