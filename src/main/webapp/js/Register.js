$(document).ready(function() {
    $('input[type=password]').keyup(function() {
        var pswd = $(this).val();
        //length
        if ( pswd.length < 8 ) {
            $('#length').removeClass('valid').addClass('invalid');
        } else {
            $('#length').removeClass('invalid').addClass('valid');
        }
        //letter
        if ( pswd.match(/[A-z]/) ) {
            $('#letter').removeClass('invalid').addClass('valid');
        } else {
            $('#letter').removeClass('valid').addClass('invalid');
        }
        //validate number
        if ( pswd.match(/\d/) ) {
            $('#number').removeClass('invalid').addClass('valid');
        } else {
            $('#number').removeClass('valid').addClass('invalid');
        }
        //mayus
        if ( pswd.match(/[A-Z]/) ) {
            $('#capital').removeClass('invalid').addClass('valid');
        } else {
            $('#capital').removeClass('valid').addClass('invalid');
        }

    }).focus(function() {
        $('#alertPass').show();
    }).blur(function() {
        $('#alertPass').hide();
    });

    $("#registro").click(function(){//solo estan como necesarios mail usuario y contraseña como dijimos en el drive
        var mail1 = $("#mail1").val();
        var username = $("#username").val();
        var pass=$("#pass").val();

        if(mail1.length==0 || mail2.length==0 || username.length==0 || pass.length==0){
            alert("Rellena todos los campos");
        }else if(pass.length < 8 ||  !pass.match(/[A-z]/) || !pass.match(/\d/) || !pass.match(/[A-Z]/)){
            alert("La contraseña no tiene los requisitos requeridos");
        }
    });
});