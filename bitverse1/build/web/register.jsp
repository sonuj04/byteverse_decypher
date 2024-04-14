<%-- 
    Document   : login
    Created on : 13 Apr 2024, 5:40:12 pm
    Author     : vansh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    </head>
    <body style="background: url(img/img11.jpg);background-size: cover;background-attachment: fixed">
        <div class="container">
            <div class="row">
                <div class="col m6 offset-m3">
                    <div class="card">
                        <div class="card-content">
                            <h3 style="margin-top: 10px" class="center-align">Register here</h3>
                            <h5 id="msg" class="center-align"></h5>
                            <div class="form center-align">
                                <form action="register" method="post" id="myform">
                                    <input type="text" name="user_name" placeholder="Enter username">
                                    <input type="text" name="first_name" placeholder="Enter user first name">
                                    <input type="text" name="last_name" placeholder="Enter user last name">
                                    <input type="password" name="user_pass" placeholder="Enter password">
                                    <input type="number" name="user_phone" placeholder="Enter your phone number">
                                    <input type="text" name="user_address" placeholder="Enter your Address" size="50vw 10vh">
                                        <div class="file-field input-field">
                                        <div class="btn blue">
                                        <span>File</span>
                                        <input name="image" type="file">
                                        </div>
                                        <div class="file-path-wrapper">
                                        <input class="file-path validate" type="text">
                                        </div>
                                        </div>

                                    <button type="submit" class="btn blue">submit</button>
                                </form>
                            </div>
                            <div class="loader center-align" style="margin-top: 10px;display: none;">
                                <div class="preloader-wrapper big active">
                                    <div class="spinner-layer spinner-blue">
                                        <div class="circle-clipper left">
                                            <div class="circle"></div>
                                        </div><div class="gap-patch">
                                            <div class="circle"></div>
                                        </div><div class="circle-clipper right">
                                            <div class="circle"></div>
                                        </div>
                                    </div>

                                    <div class="spinner-layer spinner-red">
                                        <div class="circle-clipper left">
                                            <div class="circle"></div>
                                        </div><div class="gap-patch">
                                            <div class="circle"></div>
                                        </div><div class="circle-clipper right">
                                            <div class="circle"></div>
                                        </div>
                                    </div>

                                    <div class="spinner-layer spinner-yellow">
                                        <div class="circle-clipper left">
                                            <div class="circle"></div>
                                        </div><div class="gap-patch">
                                            <div class="circle"></div>
                                        </div><div class="circle-clipper right">
                                            <div class="circle"></div>
                                        </div>
                                    </div>

                                    <div class="spinner-layer spinner-green">
                                        <div class="circle-clipper left">
                                            <div class="circle"></div>
                                        </div><div class="gap-patch">
                                            <div class="circle"></div>
                                        </div><div class="circle-clipper right">
                                            <div class="circle"></div>
                                        </div>
                                    </div>

                                </div>
                             <h4 class="center-align">Please wait...</h4>
                            </div>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
        <script>
             $(document).ready(function(){
                 
                 $("#myform").on('submit',function(event){
                     event.preventDefault();
                     
//                     var f = $(this).serialize();
                     let f=new FormData(this);
                     console.log(f);
                     
                     $(".loader").show();
                     $(".form").hide();
                     
                     $.ajax({
                         url:"register",
                         data:f,
                         type:'POST',
                         success:function(data,textStatus,jqXHR){
                             console.log(data);
                             console.log("success");
                             $(".loader").hide();
                             $(".form").show();
                             if(data.trim()=== 'done'){
                                 $('#msg').html("Successfully Registered");
                                 $('#msg').addClass('green-text');
                             }
                             else{
                                 $('#msg').html("Something went wrong");
                                 $('#msg').addClass('red-text');
                             }
                         },
                         error: function(jqXHR,textStatus,errorThrown){
                             console.log(data);
                             console.log("error");
                             $(".loader").hide();
                             $(".form").show();
                             $('#msg').html("Something went wrong");
                             $('#msg').addClass('red-text');
                         },
                         processData: false,
                         contentType: false,
                     })
                     
                 })
                 
             })
        </script>
    </body>
</html>

