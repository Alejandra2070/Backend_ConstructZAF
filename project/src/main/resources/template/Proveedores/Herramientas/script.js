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

//mostrar datos en las tarjetas
.then(data => {
    console.log('Datos recibidos:', data);
    
    let datos = document.getElementById("dashboard")
    
    datos.innerHTML = ``

    data.forEach(a => {
        datos.innerHTML+=`
            <div id="card">
                <h3>${a.nombre}</h3><br>
                <img id="image" src="${a.imagen}" alt="">
                <h3>${a.descripcion}</h3>
                <h3>Precio:  ${a.precio}</h3>
                <h3>Estado:  ${a.estado}</h3><br>
            </div>
        `
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