function promedio(idalumno) {
    $.ajax({
        url: "../Notas?accion=PRO&idalumno="+idalumno,
        success: function(data) {
            alert(data);
        }
    });
}

function ins() {
    if(confirm("New country")) {
        window.location = "ContriesIns.jsp";
    }
}

function del(country_id) {
    if(confirm("¿Retirar Country?")) {
        window.location = "../Contries?accion=DEL&country_id="+country_id;
    }
}

function upd(country_id) {
    if(confirm("¿Actualizar Country?")) {
        window.location = "../Notas?accion=GET&idalumno="+country_id;
    }
}

function valida() {
    if($("#alumno").val().trim().length == 0) {
        alert("Ingrese Nombre de Alumno");
        return false;
    }

    return true;
}