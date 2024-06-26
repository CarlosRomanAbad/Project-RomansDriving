

function validarDNI(){
    let dni = document.getElementById("dni").value;
    let dniError = document.getElementById("dniError");

    if(dni.length != 9){
        dniError.textContent = "El DNI debe tener 9 caracteres.";
        return false;
    } else {
        dniError.textContent = "";
        return true;
    }

}


document.addEventListener("DOMContentLoaded", function() {
    let emailInput = document.getElementById("email");
    let emailError = document.getElementById("emailError");

    function validarEmail() {
        let email = emailInput.value.trim();

     
        let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        if (!emailPattern.test(email)) {
            mostrarError("El correo electrónico no es válido.");
            return false;
        } else {
            ocultarError();
            return true;
        }
    }

    function mostrarError(mensaje) {
        emailError.textContent = mensaje;
        emailInput.classList.add("is-invalid");
    }

    function ocultarError() {
        emailError.textContent = "";
        emailInput.classList.remove("is-invalid");
    }

    emailInput.addEventListener("input", function() {
        validarEmail();
    });
});


    document.addEventListener("DOMContentLoaded", function() {
        let telefonoInput = document.getElementById("telefono");
        let telefonoError = document.getElementById("telefonoError");

        function validarTelefono() {
            let telefono = telefonoInput.value.trim();

            let telefonoPattern = /^\d+$/;

            if (!telefonoPattern.test(telefono)) {
                mostrarError("El teléfono solo puede contener números.");
                return false;
            } else {
                ocultarError();
                return true;
            }
        }

        function mostrarError(mensaje) {
            telefonoError.textContent = mensaje;
            telefonoInput.classList.add("is-invalid");
        }

        function ocultarError() {
            telefonoError.textContent = "";
            telefonoInput.classList.remove("is-invalid");
        }

        telefonoInput.addEventListener("input", function() {
            validarTelefono();
        });
    })

    document.addEventListener("DOMContentLoaded", function() {
        let fechaInput = document.getElementById("fechaNacimiento");
        let fechaError = document.getElementById("fechaError");

        function validarFecha() {
            let fechaSeleccionada = new Date(fechaInput.value);
            let fechaActual = new Date();

            if (fechaSeleccionada > fechaActual) {
                mostrarError("La fecha de nacimiento no puede ser una fecha futura.");
                return false;
            } else {
                ocultarError();
                return true;
            }
        }

        function mostrarError(mensaje) {
            fechaError.textContent = mensaje;
            fechaInput.classList.add("is-invalid");
        }

        function ocultarError() {
            fechaError.textContent = "";
            fechaInput.classList.remove("is-invalid");
        }

        fechaInput.addEventListener("input", function() {
            validarFecha();
        });
    });

