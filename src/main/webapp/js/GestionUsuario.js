var buscador = $("#table").DataTable();

$(document).ready(function() {
    $("#input-search").keyup(function(){
        buscador.search($(this).val()).draw();

        if($("input-search").val()==""){
            $(".content-search").fadeout();
        }else{
            $(".content-search").fadeIn();
        }
    }).focus(function() {
        $("#table").show();
    }).blur(function() {
        $("#table").hide();
    });
});