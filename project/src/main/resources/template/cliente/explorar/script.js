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

/*
let dataHerramientas = data;
        
function mostrarDetalles(id){
    const herramienta = dataHerramientas.find(item => item.id === id);

    if (herramienta){
        console.log("Holaaaaaaaaaaaaaaaaa");
        
        const detalless = document.getElementById("detallesPopup");
        detalless.innerHTML = `
            <div class="popup-contenido">
            <h3>${a.nombre}</h3><br>
            <img id="image" src="${a.imagen}" alt="">
            <h3>${a.descripcion}</h3>
            <h3>Precio:  ${a.precio}</h3>
            <h3>Estado:  ${a.estado}</h3><br>
            
        </div>
        `;
        abrirPopup('detallesPopup')
    }
}
*/

/*.then(detalles => {
    console.log('Datos:', detalles);
    
    let details = document.getElementsByClassName("popup")
    details.innerHTML = ``

    detalles.forEach(e => {
        
    })
})*/

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