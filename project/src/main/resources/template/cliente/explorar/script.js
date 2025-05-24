const items = document.querySelectorAll('#menu li');
const late = document.getElementById('lateral');
const hamburger = document.getElementById('hamburger');

const token = localStorage.getItem('token');
console.log('Token guardado:', token);

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
.then(data => {
    console.log('Datos recibidos:', data);
    
    let datos = document.getElementById("dashboard")
    
    datos.innerHTML = ``

    data.forEach(a => {
        datos.innerHTML+=`
            <div id="card">
                <img id="image" src="${a.imagen}" alt="">
                <h3>${a.nombre}</h3>
                <button onclick='abrirPopup(${JSON.stringify(a)})' class="btn-edit">Ver detalles</button>
            </div>
        `;
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

function abrirPopup(herramienta){

    const popup = document.getElementById("detallesPopup");
    const contenido = popup.querySelector(".popup-contenido");

    contenido.innerHTML =`
        <h3>${herramienta.nombre}</h3><br>
        <img id="image" src="${herramienta.imagen}" alt="">
        <h3>${herramienta.descripcion}</h3>
        <h3>Precio:  ${herramienta.precio}</h3>
        <h3>Estado:  ${herramienta.estado}</h3><br>
        <button onclick="abrirPopupReserva('reservaPopup'); cerrarPopup('detallesPopup')" class="btn-edit">Reservar</button>
    `;

    popup.style.display = "flex";
}

function abrirPopupReserva(id){
    document.getElementById(id).style.display = 'block';
}

function cerrarPopup(id){
    document.getElementById(id).style.display = 'none';
}

//crear una reserva

const formCrearReserva = document.getElementById('form-crear-reserva');

formCrearReserva.addEventListener('submit', function(e){
    e.preventDefault();

    const nuevaReserva = {
        nombreHerramienta: document.getElementById('nombre-herramienta').value,
        nombreUsuario: document.getElementById('nombre-usuario').value,
        fecha_reserva: document.getElementById('fecha').value,
        estado_devolucion: document.getElementById('estado').value,
        fecha_expiracion: document.getElementById('fecha-devolucion').value
    };

    fetch('http://localhost:8080/construc/reserva',{
        method: 'POST',
        headers:{
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + token
        },
        body: JSON.stringify(nuevaReserva)
    })
    .then(response => {
        if(!response.ok){
            throw new Error('Error al crear reserva');
        }
        return response.json();
    })
    .then(data => {
        alert('Reserva creada exitosamente');
        cerrarPopup('reservaPopup');
        formCrearReserva.reset();
        location.reload();
    })
    .catch(error => {
        console.error('Error:', error);
        alert('No se pudo crear la reserva');
    });
});