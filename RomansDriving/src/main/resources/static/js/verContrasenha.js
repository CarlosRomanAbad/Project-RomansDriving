document.getElementById('togglePassword').addEventListener('click', function () {
    var passwordInput = document.getElementById('password');
    if (passwordInput.type === 'password') {
        passwordInput.type = 'text';
        this.classList.remove('far', 'fa-eye');
        this.classList.add('fas', 'fa-eye-slash');
    } else {
        passwordInput.type = 'password';
        this.classList.remove('fas', 'fa-eye-slash');
        this.classList.add('far', 'fa-eye');
    }
});