function validarFormulario() {
    var nombre = document.getElementById("nombre").value;
    var dni = document.getElementById("dni").value;

    // Validación para el campo nombre (puede ser más compleja según tus requisitos)
    if (nombre === "") {
        alert("Por favor, ingresa tu nombre.");
        return false;
    }

    // Validación para el campo DNI
    if (!esNumero(dni)) {
        alert("El campo DNI debe contener solo números.");
        return false;
    }

    return true; // Se envía el formulario si todas las validaciones pasan
}

// Función para verificar si una cadena contiene solo números
function esNumero(valor) {
    return !isNaN(valor) && !isNaN(parseFloat(valor));
}