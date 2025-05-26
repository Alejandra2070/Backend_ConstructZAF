const items = document.querySelectorAll('#menu li');
const late = document.getElementById('lateral');
const hamburger = document.getElementById('hamburger');

const token = localStorage.getItem('token');
console.log('Token guardado:', token);

//mostrar detalles de factura

function generarFactura(id_factura){
    fetch(`http://localhost:6060/construct/facturas/${id_factura}`, {
    method: 'GET',
    headers: {
        'Authorization': 'Bearer ' + token,
        'Content-Type': 'application/json'
    }})
    .then(response => {
        if(!response.ok){
            throw new Error("Error al obtener la factura");
        }
        return response.json();
    })
    .then(data => {
        const nombreU = data.nombre_usuario;
        const fecha = data.fecha_pago;
        const monto = `$${data.monto_total}`;
        const metodo = data.metodo_pago;

        abrirPopup('verFactura');
        generarFactura(nombreU, fecha, monto, metodo);
    })
    .catch(error => {
        console.error("Error al cargar la factura:", error);
        alert("No se pudo cargar la factura");
    })
}

/*
function generarFactura(nombre_usuario, fecha_pago, monto_total, metodo_pago){
    const factura = document.getElementById("cuerpo");
    /*factura.dataset.id = nombre_usuario;
    factura.dataset.id = fecha_pago;
    factura.dataset.id = monto_total;
    factura.dataset.id = metodo_pago;
    factura.innerHTML = `
        <div id="info">
            <strong>Nombre de Usuario: </strong><br>
            <strong>Fecha de pago: </strong><br>
            <strong>Valor total: </strong><br>
            <strong>Método de pago: </strong><br>
        </div>
        <div id="mensaje">
            <h3>Factura</h3>
            <p>${nombre_usuario}</p>
            <p>${fecha_pago}</p>
            <p>${monto_total}</p>
            <p>${metodo_pago}</p>
            <button class="btn-delete" onclick="descargar('${nombre_usuario}', '${fecha_pago}', '${monto_total}', '${metodo_pago}')">Descargar Factura</button> 
        </div>
    `;
}

function descargar(nombre_usuario, fecha_pago, monto_total, metodo_pago){
    const { jsPDF} = window.jspdf;
    const doc = new jsPDF();

    doc.setFont("Helvetica");
    doc.setFontSize(14);
    doc.text("Factura de pago", 20,20);

    doc.setFontSize(12);
    doc.text(`Nombre de Usuario: ${nombre_usuario}`, 20,40);
    doc.text(`Fecha de pago: ${fecha_pago}`, 20,50);
    doc.text(`Valor total: ${monto_total}`, 20,60);
    doc.text(`Método de pago: ${metodo_pago}`, 20,70);

    doc.save(`factura_${nombre_usuario}.pdf`);
}
*/
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

function search(){
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