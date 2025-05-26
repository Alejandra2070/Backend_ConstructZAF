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
    
    let datos = document.getElementById("miTabla-reservas")
    
    datos.innerHTML = ``

    data.forEach(a => {
        datos.innerHTML+=`
            <tr>
                <td>${a.id_reserva}</td>
                <td>${a.nombreHerramienta}</td>
                <td>${a.nombreUsuario}</td>
                <td>${a.fecha_reserva}</td>
                <td>${a.fecha_expiracion}</td>
                <td>${a.deposito}</td>
                <td>
                    <button>
                        <img id="confirmar" src="/imagenes/confirmar.png" alt="">
                    </button>
                    <button>
                        <img id="confirmar" src="/imagenes/denegar.png" alt="">
                    </button>
                </td>
            </tr>
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