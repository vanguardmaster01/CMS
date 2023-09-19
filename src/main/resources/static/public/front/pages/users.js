
//var datatableInit = function() {
//
//    var $table = $('#user_table');
//    $table.dataTable({
//        dom: '<"row"<"col-lg-6"l><"col-lg-6"f>><"table-responsive"t>p',
//        bProcessing: true,
//        sAjaxSource: $table.data('url')
//    });
//
//};

$(document).ready(function(){


//    $('#user_table').dataTable();

    $('#register').on('click', function(){
        $("#register_form").validate({
            rules: {
                register_email:{
                    required: true,
                    email: true
                },
                register_password: {
                    required: true,
                    minlength: 5
                }
            },
            messages: {
                register_email: "Please enter a valid email adress",
                register_password: {
                    required: "Please provide a password",
                    minlength: 'Your password must be at least 5 characters long'
                }
            },
            submitHandler: function(form){
                $.ajax({
                    type:"POST",
                    url : '/addUser',
                    data:{
                        email : $('#register_email').val(),
                        password : $('#register_password').val(),
                    },
                    dataType : 'JSON',
                    success : function(response){
                        if(response.status == 'success'){
                            $('#registerModal').modal('hide');
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