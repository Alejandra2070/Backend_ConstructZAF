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

window.onload = function () {
  fetch('http://localhost:8080/reportes')  // Cambia si usas otro puerto o ruta
    .then(response => {
      if (!response.ok) {
        throw new Error("Respuesta no válida del servidor");
      }
      return response.json();
    })
    .then(data => {
      const tabla = document.getElementById("tabla-reportes");
      const cuerpo = document.getElementById("cuerpo-tabla");
      const mensaje = document.getElementById("mensaje");
      cuerpo.innerHTML = "";

      if (!data || data.length === 0) {
        mensaje.textContent = "No hay reportes disponibles.";
        return;
      }

      data.forEach(reporte => {
        const fila = document.createElement("tr");
        fila.innerHTML = `
          <td>${reporte.id_reporte}</td>
          <td>${reporte.inventario_id}</td>
          <td>${reporte.usuario_id}</td>
          <td>${reporte.herramientas_mas_usadas}</td>
        `;
        cuerpo.appendChild(fila);
      });

      tabla.style.display = "table";
    })
    .catch(error => {
      console.error("Error al cargar los reportes:", error);
      document.getElementById("mensaje").textContent = "Error al cargar los reportes.";
    });
};

