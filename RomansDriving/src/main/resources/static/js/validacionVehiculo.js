  function validateForm() {
            const anhosAntiguedad = document.getElementById('anhosAntiguedad').value;
            const errorAlert = document.getElementById('errorAlert');

            if (anhosAntiguedad < 0) {
                errorAlert.style.display = 'block';
                return false;
            }

            errorAlert.style.display = 'none';
            return true;
        }