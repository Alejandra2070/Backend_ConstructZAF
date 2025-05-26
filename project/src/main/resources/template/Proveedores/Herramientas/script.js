const items = document.querySelectorAll('#menu li');
const late = document.getElementById('lateral');
const hamburger = document.getElementById('hamburger');

const token = localStorage.getItem('token');
console.log('Token guardado:', token);

let herramienta =[];

fetch('http://localhost:8080/construc/herramientas', {
method: 'GET',
headers: {
    'Authorization': 'Bearer ' + token,
    'Content-Type': 'application/json'
}})

.then(res => {
if (!res.ok) throw new Error('No autorizado o error en la petición');
return res.json();
})

//mostrar datos en las tarjetas
.then(data => {
    console.log('Datos recibidos:', data);

    herramientas = data; // Guardamos los datos globalmente
    mostrarHerramientas(herramientas); // Función que renderiza las tarjetas
});

function mostrarHerramientas(lista){
    let datos = document.getElementById("dashboard")
    
    datos.innerHTML = ``

    lista.forEach(a => {
        datos.innerHTML+=`
            <div id="card">
                <h3>${a.nombre}</h3><br>
                <img id="image" src="${a.imagen}" alt="">
                <h3>${a.descripcion}</h3>
                <h3>Precio:  ${a.precio}</h3>
                <h3>Estado:  ${a.estado}</h3>

                <div class="btn-actions">
                    <button onclick="abrirPopup('editarPopup')" class="btn-detalles">Editar</button>
                    <button onclick="abrirPopup('eliminar')" class="btn-descargar">Eliminar</button>
                </div>
            </div>
        `
    })

}


//filtrar por id

const inputF = document.getElementById("search-item");

inputF.addEventListener("input", function() {
    const text = inputF.value.toLowerCase();

    const resultado = herramientas.filter(h => 
        h.nombre.toLowerCase().includes(text)
    );

    mostrarHerramientas(resultado); // Mostramos solo los resultados filtrados
});

//editar herramientas
const formEdit = document.querySelector('#editarPopup form');

formEdit.addEventListener('submit', function(e){
    e.preventDefault();

    const id = document.getElementById('id-herr').value;
    console.log(id);

    const infoActualizada = {
        nombre: document.getElementById('nombre').value,
        descripcion: document.getElementById('descripcion').value,
        estado: document.getElementById('estado').value,
        imagen: document.getElementById('imagen').value,
        precio: document.getElementById('precio').value
    };
    
    fetch(`http://localhost:8080/construc/herramientas/${id}`,{
        method: 'PATCH',
        headers:{
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + token
        },
        body: JSON.stringify(infoActualizada)
    })
    .then(res => {
        if(!res.ok) throw new Error('Error al actualizar herramienta');
        return res.json();
    })
    .then(() => {
        alert('Herramienta actualizada con éxito.');
        cerrarPopup('editarPopup');
        abrirPopup('exito');
        formEdit.reset();
        location.reload();
    })
    .catch(err => {
        console.error("Error:", err);
        alert('No se pudo actualizar el usuario');
    })
});

//eliminar herramienta

const formEliminar = document.querySelector('#eliminar form');

formEliminar.addEventListener('submit', function(e){
    e.preventDefault();

    const id = document.getElementById('id-eliminar').value;
    console.log(id);
    

    fetch(`http://localhost:8080/construc/herramientas/${id}`,{
        method: 'DELETE',
        headers:{
            'Authorization': 'Bearer ' + token
        }
    })
    .then(res => {
        console.log("Código de respuesta:", res.status);
        if (!res.ok) {
            return res.text().then(text => {
                console.error("Respuesta del servidor:", text);
                throw new Error('Error al eliminar herramienta');
            });
        }
        return res.text();
    })
    .then(() => {
        cerrarPopup('eliminar');
        abrirPopup('exitoE');
        formEliminar.reset();
        location.reload();
    })
    .catch(err => {
        console.error("Error:", err);
        alert('No se pudo eliminar la herramienta.');
    })
})

//crear herramienta

const formCrearHerr = document.getElementById('form-crear-herramienta');

formCrearHerr.addEventListener('submit', function(e){
    e.preventDefault();

    const newHerr = {
        nombre: document.getElementById('nombre').value,
        descripcion: document.getElementById('descripcion').value,
        estado: document.getElementById('estado').value,
        imagen: document.getElementById('imagen').value,
        precio: document.getElementById('precio').value
    };

    fetch('http://localhost:8080/construc/herramientas', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + token
        },
        body: JSON.stringify(newHerr)
    })
    .then(response => {
        if(!response.ok){
            throw new Error('Error al crear herramienta');
        } 
        return response.json();
    })
    .then(data => {
        cerrarPopup('crearH');
        abrirPopup('exitoG');
        formCrearHerr.reset();
        location.reload();
    })
    .catch(err => {
        console.error("Error:", err);
        alert('No se pudo crear la herramienta.');
    })
})

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