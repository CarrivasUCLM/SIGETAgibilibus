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
});

    function comprobar(){
        var mail1 = $("#userMail").val();
        var username = $("#userName").val();
        var pass=$("#pwd1").val();
        var pass2=$("#pwd2").val();
        var mail2=$("#mail2").val();
        if(false!=(validarCampo("userMail") && validarCampo("userName") && validarCampo("pwd1")&& validarCampo("mail2") && validarCampo("userCompletName") && validarCampo("userApellidos") && validarCampo("userTelf")&& validarCampo("userDate"))){        
        	if(pass!==pass2){
        		alert("Las contraseñas no puede ser distintas");
        	}else if(mail1!==mail2){
        		alert("Los e-mails no pueden ser distintos");
        		}
        	else if(userTelf.value.length>9)
        		alert("El numero de telefono es demasiado largo");
        	else if(!fechaCorrecta())
        		alert("Debe tener al menos 16 años")
        	else 
        		register();
        		
        }	        
    }

    function validarCampo(campo) { // comprobar que no hay campos vacios
        var valido = new Boolean(true); 
        if (document.getElementById(campo).value == '') {
          alert('El campo ' +campo +' está vacio');
            valido=false;
        }
        return valido;
      };
      
      function fechaCorrecta() {// el emleado tiene al menos 16 años
    	    var correcto = new Boolean(true); 
    	    var fecha=$("#userDate").val();
    	    var diaFormulario = fecha.substring(8,10);
    	    var mesFormularo = fecha.substring(5,7);
    	    var añoFormulario = fecha.substring(0,4);
    	    var edad = 16;
    	    var fechaFormulario = new Date();
    	    fechaFormulario.setFullYear(añoFormulario, mesFormularo-1, diaFormulario);
    	    
    	    var fechaHoy = new Date();
    	    
    	    fechaHoy.setFullYear(fechaHoy.getFullYear() - edad);

    	     if (fechaHoy <fechaFormulario)
    	       correcto=false;
    	    return correcto;
    	  }
    function limpiarCampos(){ // resetear todos los campos
        document.getElementById("userCompletName").value="";
        document.getElementById("userDni").value="";
        document.getElementById("userName").value="";
        document.getElementById("userApellidos").value="";
        document.getElementById("userTelf").value="";
        document.getElementById("userMail").value="";
        document.getElementById("pwd1").value="";
        document.getElementById("userDate").value="";
        document.getElementById("pwd2").value="";
        document.getElementById("mail2").value="";
    };
    
    function register(){

        var info = {
            type : "Register",
            userCompletName : userCompletName.value,
            userName : userName.value,
            userApellidos : userApellidos.value,
            userDni : userDni.value,
            userDate : userDate.value,
            userTelf : userTelf.value,
            userMail : userMail.value,
            pwd1 : pwd1.value,
            pwd2 : pwd2.value
        };
        var data = {
                data : JSON.stringify(info),
                url : "register",
                type : "post",
                contentType: 'application/json',
                success: function(response){
                	var respuesta = JSON.parse(response);
                	if(respuesta.type==="OK"){
                		alert("Usuario registrado correctamente");
                    	limpiarCampos();
                    	window.location="Login.html";
                	}
                	else
                		alert("Error: El nombre de usuario ya existe");
                },
                error : function(response) {
                	var respuesta = JSON.parse(response);
                	alert(respuesta.message);
                	
                }
            };
            $.ajax(data);
    }
