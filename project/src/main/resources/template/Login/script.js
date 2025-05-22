console.log("Holaaa");

const boton = document.getElementById("botonI").addEventListener("click", login);


function login(){

    //let nombre = document.getElementById("inpuuut1");
    //let contrasena = document.getElementById("inpuuut2");

    var url = 'http://localhost:8080/auth/login';

    var data = {
        username: 'franco',
        password: 'franco123'
        /*
        username: 'franco',
        password: 'franco123'
        //username: nombre.value,
        //password: contrasena.value*/
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

        if(token){
            localStorage.setItem('token',token)
            console.log("token guardado")
        }else{
            console.log("no se recibio token")
        }
        
        
        console.log(token);
        
        //para que me redirija al otro archivo
        window.location.href = "http://127.0.0.1:5500/project/src/main/resources/template/admin/home/index.html";
    })
}