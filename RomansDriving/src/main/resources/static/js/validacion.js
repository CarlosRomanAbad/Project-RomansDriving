function validarDNI() {
    let dni = document.getElementById('dni').value;    
    let letras = 'TRWAGMYFPDXBNJZSQVHLCKE';
    let numero = dni.substr(0, dni.length - 1);
    let letra = dni.charAt(dni.length - 1).toUpperCase();
    let indice = numero % 23;

    if (letras.charAt(indice) === letra) {
        document.getElementById("errorDNI").classList.remove("mostrar");
        document.getElementById("okDNI").classList.remove("ocultar");
        document.getElementById("login").disabled = false;
    } else {
        document.getElementById("errorDNI").classList.add("mostrar");
        document.getElementById("okDNI").classList.add("ocultar");
        document.getElementById("login").disabled = true;
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

