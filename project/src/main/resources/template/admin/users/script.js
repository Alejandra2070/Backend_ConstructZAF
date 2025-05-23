const items = document.querySelectorAll('#menu li');
const late = document.getElementById('lateral');
const hamburger = document.getElementById('hamburger');



const token = localStorage.getItem('token');
console.log('Token guardado:', token);

// ------------------------------------------------------------------------
// Obtener

fetch('http://localhost:8080/construc/usuarios', {
    method: 'GET',
    headers: {
        'Authorization': 'Bearer ' + token,
        'Content-Type': 'application/json'
    }
})
.then(res => {
    if (!res.ok) throw new Error('No autorizado o error en la petición');
    return res.json();
})
.then(data => {
    console.log('Datos recibidos:', data);
    
    let datos = document.getElementById("miTabla-user")
    datos.innerHTML = ``

    data.forEach(a => {
        datos.innerHTML+=`
            <tr>
                <td>${a.id_usuario}</td>
                <td>${a.nombre}</td>
                <td>${a.apellido}</td>
                <td>${a.cedula}</td>
                <td>${a.telefono}</td>
                <td>${a.correo}</td>
                <td>${a.fecha_registro}</td>
                <td>${a.rol}</td>
            </tr>
        `;
    });
})
.catch(err => {
    console.error('Error:', err);
});

// --------------------------------------------------------------------------
// Crear

const formCrearUser = document.getElementById('form-crear-user');

formCrearUser.addEventListener('submit', function(e){
    e.preventDefault(); // Evita recarga de la pagina 

    const nuevoUsuario = {
        nombre: document.getElementById('nombre-crear').value,
        contraseña: document.getElementById('contrasena-crear').value,
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
            'Authorization': 'Bearer ' + token
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
        cerrarPopup('crearPopup');
        formCrearUser.reset();
        location.reload(); // Opcional: recargar la tabla
    })
    .catch(error => {
        console.error('Error:', error);
        alert('No se pudo crear el usuario');
    });
});

// --------------------------------------------------------------------------------------------------
// Eliminar 

const formEliminar = document.querySelector('#eliminarPopup form');

formEliminar.addEventListener('submit', function(e){
    e.preventDefault();

    const id = document.getElementById('id-eliminar').value;

    fetch(`http://localhost:8080/construc/usuarios/${id}`,{
        method: 'DELETE',
        headers:{
            'Authorization': 'Bearer ' + token 
        }
    })
    .then( res => {
        if (!res.ok) throw new Error('Error al eliminar usuario');
        return res.text();
    })
    .then(() => {
        alert('Usuario eliminado correctamente');
        cerrarPopup('eliminarPopup');
        formEliminar.reset();
        location.reload();
    })
    .catch(err => {
        console.error("Error:", err);
        alert('No se pudo eliminar el usuario');
    });
});
// ---------------------------------------------------------------------------------------------------
// Editar

const formEditar = document.querySelector('#editarPopup form');

formEditar.addEventListener('submit', function(e){
    e.preventDefault();

    const id = document.getElementById('id-editar').value;
    console.log(id);

    const datosActualizados= {
        nombre: document.getElementById('nombre-editar').value,
        apellido: document.getElementById('apellido-editar').value,
        correo: document.getElementById('correo-editar').value,
        telefono: parseInt(document.getElementById('telefono-editar').value)
    };

    fetch(`http://localhost:8080/construc/usuarios/${id}`,{
        method: 'PATCH',
        headers:{
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + token 
        },
        body: JSON.stringify(datosActualizados)
    })
    .then( res => {
        if(!res.ok) throw new Error('Error al actualizar usuario');
        return res.json();
    })
    .then(() => {
        alert('Usuario actualizado correctamente');
        cerrarPopup('editarPopup');
        formEditar.reset();
        location.reload();
    })
    .catch(err => {
        console.error("Error:", err);
        alert('No se pudo actualizar el usuario');
    });
});

// ---------------------------------------------------------------------------------------------------
// Filtar 

function searchUser(){
    const input = document.getElementById("search-item");
    const filter = input.value.toLowerCase();// pasa el texto del usuario a minuscula
    const table = document.getElementById("miTabla");// Obtiene la tabla HTML
    const trs = table.getElementsByTagName("tr");// Obtiene todas las filas de la tabla

    for(let i=1; i < trs.length; i++){
        const row = trs[i];
        const tds = row.getElementsByTagName("td");// Contiene las celdas de la fila actual
        let showRow = false;// booleano si se debe mostrar la fila

        for (let j=0; j < tds.length; j++){// for para cada celda de la fila
            const cell = tds[j];
            if(cell && cell.textContent.toLowerCase().includes(filter)){
                showRow = true;// Si el texto de la celda contiene lo que el usuario busco, se muestra
                break;// finalizar bucle
            }
        }

        row.style.display = showRow ? "" : "none";// se aculta la tabla si no coincide con lo que el usuario busco
    }
}

// Activar item seleccionado

items.forEach(item => {
    item.addEventListener('click', () => {
        items.forEach(i => i.classList.remove('active'));
        item.classList.add('active');

        // Cierra el menu en pantalla pequeñas
        if (window.innerWidth <= 768) {
            lateral.classList.remove('open');
        }
    });
});

// Abrir menu de la pantalla pequeña 
hamburger.addEventListener('click', () => {
    lateral.classList.toggle('open');
})

// Menu en pantalla pequeña

hamburger.addEventListener('click', () => {
    if (!lateral.contains(e.target) &&
        !hamburger.contains(e.target) &&
        window.innerWidth <= 768) {
        lateral.classList.remove('open');
    }
})

// Mostrar o ocultar los popUp

function abrirPopup(id){
    document.getElementById(id).style.display = 'block';
}

function cerrarPopup(id){
    document.getElementById(id).style.display = 'none';
}

// Mostrar y ocultar el menu del usuario 

document.getElementById("userName").addEventListener("click", function(event){
    event.stopPropagation(); // Evita el cierre inmediato
    const menu = document.getElementById("user-menu");
    menu.style.display = menu.style.display === "block" ? "none" : "block";
});

// Cierra el menu si se hace click afuera de el 
document.addEventListener("click", function(event){
    const menu = document.getElementById("user-menu");
    const name = document.getElementById("userName");

    if(!name.contains(event.target) && !menu.contains(event.target)){
        menu.style.display = "none";
    }
})