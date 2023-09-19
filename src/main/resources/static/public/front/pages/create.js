$(document).ready(function(){
	var base_url = window.location.origin;
	
    $('#create').on('click', function(){   	
    	
        $("#create_form").validate({
            rules: {
                title:{
                    required: true
                },
                content:{
                    required: true
                },
                metatags:{
                    required: true
                },
                alttags:{
                    required: true
                },
                metadescription:{
                    required: true
                },
                slug:{
                    required: true
                },
                tags:{
                    required: true
                }
            },
            messages: {
                title: "Please enter a Post Title",
                content: "Please enter a Post Content",
                metatags: "Please enter Meta Tags",
                alttags: "Please enter Alt Tags",
                metadescription: "Please enter Meta Description",
                slug: "Please enter a Slug",
                tags: "Please enter Tags"
            },
            submitHandler: function(form) {
            	var formData = new FormData();
            	formData.append("title", $('#title').val());
            	formData.append("content", $('#content').val());
//            	formData.append("content", $('#summernote').summernote('code'));
            	var props=$('#attachment').prop('files');
            	formData.append('attachfile', props[0]);
            	formData.append("metatags", $('#metatags').val());
            	formData.append("alttags", $('#alttags').val());                
            	formData.append("metadescription", $('#metadescription').val());                
            	formData.append("slug", $('#slug').val());                
            	formData.append("tags", $('#tags').val());
            	
            	$.ajax({
                    type:"POST",
                    url : '/createBlog',
                    data: formData,
                    enctype: 'multipart/form-data',
                    processData: false,
                    contentType: false,
                    cache: false,
                    success : function(response){
                        if(response.status == 'success'){
                        	console.log(response.maxid);
                            var link = base_url + "/preview?id=" + response.maxid + "&type=0";
                            $(location).attr('href',link);
                        }
                       console.log("success");
                    },
                    error: function(response){
                       
                        console.log(response);
                    }
                });
            }
        })        
    })
    
    $('.edit').on('click', function(){
        $('#update_email').val(5);
        $('#update_password').val(90);
        $('#update_userid').val(1);
        $('#updateModal').modal('show');
    })


    $('#update').on('click', function(){
        $("#update_form").validate({
            rules: {
                update_email:{
                    required: true,
                    email: true
                },
                update_password: {
                    required: true,
                    minlength: 5
                }
            },
            messages: {
                update_email: "Please enter a valid email adress",
                update_password: {
                    required: "Please provide a password",
                    minlength: 'Your password must be at least 5 characters long'
                }
            },
            submitHandler: function(form){
                $.ajax({
                    type:"POST",
                    url : '/updateUser',
                    data:{
                        email : $('#update_email').val(),
                        password : $('#update_password').val(),
                        userid : $('#update_userid').val()
                    },
                    dataType : 'JSON',
                    success : function(response){
                        if(response.status == 'success'){
                            $('#updateModal').modal('hide');
                        }
                       console.log("success");
                    },
                    error: function(response){
                       
                        console.log(response);
                    }
                });
            }
        }) 
        
    })

    
    $('.delete').on('click', function(){
        $.ajax({
            type:"POST",
            url : '/deleteUser',
            data:{
                userid :1
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