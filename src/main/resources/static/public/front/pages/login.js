$(document).ready(function(){
    $('#loginBtn').on('click', function(){
        $("#loginForm").validate({
            rules:{
                email: {
                        required: true,
                        // email: true
                    },
                pwd:{
                        required: true
                    }
            },
            messages:{
                    password: {
                            required: "Please provide a password",
                        },
                    email: "Please enter a valid email address"

            },
            submitHandler: function(form){
                form.submit();
                // $.ajax({
                //     type:"POST",
                //     url : '/login',
                //     data:{
                //         email : $('#email').val(),
                //         pwd    : $('#pwd').val(),
                //     },
                //     dataType : 'JSON',
                //     success : function(response){
                //         // if(response.status == 'success'){
                //         //     // location.href = redirectUrl
                //         // }else if(response.status == 'no exist'){
                //         //     toastr["error"]("no email or password.")
                //         //     $('#email').select();
                //         //     $('#email').focus();
                //         // }else if(response.status == 'fail'){
                //         //     toastr["error"]("incorrect password.")
                //         //     $('#pwd').select();
                //         //     $('#pwd').focus();
                //         // }
                                              
                //     },
                //     error: function(response){
                       
                //         console.log(response);
                //     }
                // });
            }
        });
        
    })
    
})