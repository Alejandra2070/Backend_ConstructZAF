const items = document.querySelectorAll('#menu li');
const late = document.getElementById('lateral');
const hamburger = document.getElementById('hamburger');

const token = localStorage.getItem('token');
console.log('Token guardado:', token);

fetch('http://localhost:8080/construc/reserva', {
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
                <h3>${a.fecha_reserva}</h3>
                <h3>${a.estado_devolucion}</h3>
                <h3>${a.deposito}</h3>
                <h3>${a.fecha_expiracion}</h3>
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