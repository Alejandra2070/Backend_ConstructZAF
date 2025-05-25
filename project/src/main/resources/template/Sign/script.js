const boton = document.getElementById("registro")

const token = localStorage.getItem('token');
console.log(token);

function registro() {
    console.log("hola");

    const nuevoUsuario = {
        nombre: document.getElementById('nombre-crear').value,
        contraseña: document.getElementById('Contraseña').value,
        apellido: document.getElementById('apellido-crear').value,
        correo: document.getElementById('correo-crear').value,
        telefono: parseInt(document.getElementById('telefono-crear').value),
        cedula: parseInt(document.getElementById('cedula-crear').value),
        fecha_registro: document.getElementById('fecha-ingreso-crear').value,
        role: document.getElementById('rol-crear').value
    };

    fetch('http://localhost:8080/auth/registro', {
        method: 'POST',
        headers:{
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(nuevoUsuario)
    })
    .then(response => {
        if(!response.ok){
            throw new Error('Error al crear usuario');
        }
        return response.json();
    })
    .then(data => {
        alert('Usuario creado exitosamente');
    })
    .catch(error => {
        console.error('Error:', error);
        alert('No se pudo crear el usuario');
    });
};
