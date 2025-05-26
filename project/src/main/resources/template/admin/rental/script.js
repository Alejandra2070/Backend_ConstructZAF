const items = document.querySelectorAll('#menu li');
const late = document.getElementById('lateral');
const hamburger = document.getElementById('hamburger');

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

// Mostrar y ocultar popUp
function abrirPopupAlqui(id){
    document.getElementById(id).style.display = 'block';
}

function cerrarPopupAlqui(id){
    document.getElementById(id).style.display = 'none';
}

// Filtar 

function searchRental(){
    const input = document.getElementById("search-rental");
    const filter = input.value.toLowerCase();// pasa el texto del usuario a minuscula
    const table = document.getElementById("miTabla-alqui");// Obtiene la tabla HTML
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

// ------------------------------------------------------------------------------------------------

const token = localStorage.getItem('token');
console.log('Token guardado: ', token);

// ---------------------------------------------------------------------------------------------------

// Obtener

fetch('http://localhost:8080/construc/alquiler', {
    method: 'GET',
    headers:{
        'Authorization': 'Bearer ' + token,
        'Content-Type': 'application/json'
    }
})
.then(res => {
    if(!res.ok) throw new Error('No autorizado o error en la petición');
    return res.json();
})
.then(data => {
    console.log('Datos recibidos:', data);

    let datos = document.getElementById("miTablaAlqui")
    datos.innerHTML = ``

    data.forEach(a => {
        datos.innerHTML+=`
            <tr>
                <td>${a.id_alquiler}</td>
                <td>${a.nombre_usuario}</td>
                <td>${a.nombre_herramienta}</td>
                <td>${a.fecha_inicio}</td>
                <td>${a.fecha_fin}</td>
                <td>${a.estado}</td>
            </tr>
        `;
    });
})
.catch(err => {
    console.log('Error:', err);
    
});

//------------------------------------------------------------------------------------
// Mostrar Detalles del alquiler en el popup

function buscarAlquiler() {
    const id = document.getElementById('id-ver').value.trim();
    if (id === '') {
        alert('Por favor ingresa un ID de alquiler.');
        return;
    }
    mostrarDetallerAlquiler(id);
}

function mostrarDetallerAlquiler(idAlquiler) {
    fetch(`http://localhost:8080/construc/alquiler/${idAlquiler}`,{
        method: 'GET',
        headers:{
            'Authorization': 'Bearer ' + token,
            'Content-Type': 'application/json'
        }
    })
        .then(response => {
            if (!response.ok) throw new Error("No se pudo obtener el alquiler");
            return response.json();
        })
        .then(alquiler => {
            // Mostrar popup
            document.getElementById('verPopup').style.display = 'block';

            // Rellenar info del usuario
            const info = document.getElementById("info-usuario");
            info.innerHTML = `
                <p><strong>Usuario:</strong> ${alquiler.nombre_usuario|| '-'}</p>
            `;

            // Llenar tabla
            const tabla = document.querySelector('#Tabla-alqui-PopUp tbody');
            tabla.innerHTML = ''; // limpiar tabla primero

            const fila = document.createElement('tr');
            fila.innerHTML = `
                <td>${alquiler.nombre_herramienta}</td>
                <td>${alquiler.fecha_inicio || '-'}</td>
                <td>${alquiler.fecha_fin || '-'}</td>
                <td>${alquiler.precio_total || '-'}</td>
            `;
            tabla.appendChild(fila);
        })
        .catch(error => {
            alert("Error cargando datos del alquiler.");
            console.error(error);
            document.getElementById('verPopup').style.display = 'none';
        });
}

function cerrarPopupAlqui(id) {
    document.getElementById(id).style.display = 'none';
}


function devolver() {
    const id = document.getElementById("id-devolucion").value;

    fetch(`http://localhost:8080/construc/alquiler/${id}`, {
        method: 'PUT',
        headers: {
            'Authorization': 'Bearer ' + token,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ estado: "Devuelto" })
    })
     .then(response => {
        if (!response.ok) {
            throw new Error("Error al actualizar el estado.");
        }
        return response.json();
    })
    .then(data => {
        alert("Estado actualizado a 'Devuelto'.");
        cerrarPopupAlqui("devolverPopup");
    })

}