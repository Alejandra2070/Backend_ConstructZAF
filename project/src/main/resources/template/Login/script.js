console.log("Holaaa");

const boton = document.getElementById("botonI").addEventListener("click", login);

function login(){

    var url = 'http://localhost:8080/auth/login';

    var data = {
        username: 'franco',
        password: 'franco123'
    };

    var options = {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {'Content-Type': 'application/json; charset=UTF-8'}
    }

    fetch(url, options)
    .then(response => response.json())
    .then(data => {
        let token = data.token;

        if(token) console.info('Login exitoso');
        else console.error('Datos incorrectos');
        
        console.log(token);

        window.location.href = "http://127.0.0.1:5500/project/src/main/resources/template/admin/home/index.html";
    })
}