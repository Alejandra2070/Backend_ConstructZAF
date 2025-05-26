console.log("Holaaa");

const boton = document.getElementById("botonI").addEventListener("click", login);


function login(){
console.log("Holaaa");
    let nombre = document.getElementById("inpuuut1");
    let contrasena = document.getElementById("inpuuut2");
    

    var url = 'http://localhost:8080/auth/login';

    var data = {
        username: nombre.value,
        password: contrasena.value
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
        let rol = data.roles;

        if(token){
            localStorage.setItem('token',token)
            console.log("token guardado")
            if(rol == 'USER'){
                window.location.href = "http://127.0.0.1:5500/project/src/main/resources/template/cliente/explorar/index.html";
            }
            if(rol == 'ADMIN'){
                window.location.href = "http://127.0.0.1:5500/project/src/main/resources/template/admin/users/index.html";
            }
            if(rol == 'PROVEEDORES'){
                window.location.href = "http://127.0.0.1:5500/project/src/main/resources/template/Proveedores/Herramientas/index.html";
            }
        }else{
            alert("Usuario o contraseña incorrecta")
            console.log("no se recibio token")
        }
        
        
        console.log(token);
        
    })
}
