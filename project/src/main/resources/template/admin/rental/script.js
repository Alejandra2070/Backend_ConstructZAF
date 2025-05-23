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
                <td>${a.fecha_incio}</td>
                <td>${a.fecha_fin}</td>
                <td>${a.precio_total}</td>
                <td>${a.usuario}</td>
            </tr>
        `;
    });
})
.catch(err => {
    console.log('Error:', err);
    
});

//------------------------------------------------------------------------------------
// Mostrar Detalles del alquiler en el popup

function mostrarDetallerAlquiler(idAlquiler){
    fetch(`http://localhost:8080/construc/alquiler/${idAlquiler}`)
        .then(response => {
            if(!response.ok) throw new Error("No se pudo obtener el alquiler");
            return response.json();
        })
        .then(alquiler => {
            // mostrar popUp
            document.getElementById('verPopup').style.display= 'block';

            // Rellenar los datos del popUp
            document.getElementById('id-ver').value = alquiler.id_alquiler;
            document.getElementById('usuario-nombre').innerText = alquiler.usuario?.nombre || '-';
            document.getElementById('usuario-email').innerText = alquiler.usuario?.email || '-';
            document.getElementById('usuario-telefono').innerText = alquiler.usuario?.telefono || '-';
            document.getElementById('usuario-cedula').innerText = alquiler.usuario?.cedula || '-';

            // tabla 

            const tabla = document.querySelector('#Tabla-alqui-PopUp tbody');
            tabla.innerHTML = '';
            const fila = document.createElement('tr');
            fila.innerHTML = `
                <td> Herramienta </td>
                <td>${alquiler.fecha_incio}</td>
                <td>${alquiler.fecha_fin}</td>
                <td>${alquiler.precio_total}</td>
            `;
            tabla.appendChild(fila);
        })
        .catch(error => {
            alert("Error cargando datos del alquiler.");
            console.log(error);
            
        })
}