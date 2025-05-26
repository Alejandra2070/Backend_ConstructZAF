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
function abrirPopupPago(id){
    document.getElementById(id).style.display = 'block';
}

function cerrarPopupPago(id){
    document.getElementById(id).style.display = 'none';
}

// Filtar 

function searchPay(){
    const input = document.getElementById("search-pay");
    const filter = input.value.toLowerCase();// pasa el texto del usuario a minuscula
    const table = document.getElementById("miTabla-pago");// Obtiene la tabla HTML
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

// ------------------------------------------------------------------------------------------------

const token = localStorage.getItem('token');
console.log('Token guardado: ', token);

// ---------------------------------------------------------------------------------------------------

// Obtener

fetch('http://localhost:8080/construc/pagos', {
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

    let datos = document.getElementById("miTablaPago")
    datos.innerHTML = ``

    data.forEach(a => {
        datos.innerHTML+=`
            <tr>
                <td>${a.id_pago}</td>
                <td>${a.nombre_usuario}</td>
                <td>${a.dias_alquilados}</td>
                <td>${a.monto_total}</td>
                <td>${a.estado}</td>
                <td>${a.fecha_pago}</td>
                <td>${a.metodo_pago}</td>
            </tr>
        `;
    });
})
.catch(err => {
    console.log('Error:', err);
    
});

let pagosData = []; // Aquí guardaremos los datos de pagos

// Al cargar la página, obtén los datos del backend
fetch('http://localhost:8080/construc/pagos', {
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
    pagosData = data; // Guardamos los datos globalmente
})
.catch(err => {
    console.log('Error:', err);
});

function buscarPagoPorId() {
    const idBuscado = document.getElementById("id-ver").value.trim();
    const pago = pagosData.find(p => p.id_pago == idBuscado);

    const infoDiv = document.getElementById("infoPago");

    if (!pago) {
        alert("No se encontró información para ese ID.");
        infoDiv.style.display = "none"; // Oculta si no hay datos válidos
        return;
    }

    // Mostrar y rellenar los datos
    document.getElementById("nombreUsuario").textContent = pago.nombre_usuario || "-";
    document.getElementById("emailUsuario").textContent = pago.correo || "-";
    document.getElementById("telefonoUsuario").textContent = pago.telefono || "-";
    document.getElementById("herramienta").textContent = pago.herramienta || "-";
    document.getElementById("diasAlquilados").textContent = pago.dias_alquilados || "-";
    document.getElementById("valorDiario").textContent = pago.precio ? `$${pago.precio}` : "-";
    document.getElementById("total").textContent = pago.monto_total ? `$${pago.monto_total}` : "-";
    document.getElementById("estado").textContent = pago.estado || "-";
    document.getElementById("metodoPago").textContent = pago.metodo_pago || "-";
    document.getElementById("fechaPago").textContent = pago.fecha_pago || "-";

    infoDiv.style.display = "block"; // Mostrar los datos encontrados
}

async function descargarPDF() {
    const { jsPDF } = window.jspdf;
    const doc = new jsPDF();

    const id = document.getElementById("id-ver").value.trim();
    const pago = pagosData.find(p => p.id_pago == id);

    if (!pago) {
        alert("No se encontró información para ese ID.");
        return;
    }

    // Encabezado
    doc.setFontSize(18);
    doc.text("Comprobante de Pago - Alquiler de Herramientas ConstructZAF", 14, 20);

    doc.setFontSize(12);
    doc.text(`ID de Pago: ${pago.id_pago}`, 14, 30);
    doc.text(`Fecha de Pago: ${pago.fecha_pago || "No disponible"}`, 14, 38);

    // Información del cliente
    doc.text("Información del Cliente:", 14, 50);
    doc.autoTable({
        startY: 55,
        head: [["Nombre", "Email", "Teléfono"]],
        body: [[
            pago.nombre_usuario || "No disponible",
            pago.email || "No disponible",
            pago.telefono || "No disponible"
        ]]
    });

    // Información del alquiler
    doc.text("Detalles del Alquiler:", 14, doc.lastAutoTable.finalY + 10);
    doc.autoTable({
        startY: doc.lastAutoTable.finalY + 15,
        head: [["Herramienta", "Días", "Valor Diario", "Total"]],
        body: [[
            pago.herramienta || "No disponible",
            pago.dias_alquilados || "No disponible",
            pago.valor_diario ? `$${pago.valor_diario.toLocaleString()}` : "No disponible",
            pago.monto_total ? `$${pago.monto_total.toLocaleString()}` : "No disponible"
        ]]
    });

    // Estado y método de pago
    doc.text("Información del Pago:", 14, doc.lastAutoTable.finalY + 10);
    doc.autoTable({
        startY: doc.lastAutoTable.finalY + 15,
        head: [["Estado", "Método de Pago"]],
        body: [[
            pago.estado || "No disponible",
            pago.metodo_pago || "No disponible"
        ]]
    });

    // Pie de página
    doc.setFontSize(10);
    doc.text("Gracias por su pago ContructZAF.", 14, 280);

    // Descargar PDF
    doc.save(`pago_${pago.id_pago}.pdf`);
}