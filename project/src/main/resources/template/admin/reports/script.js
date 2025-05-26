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


// ------------------------------------------------------------------------------------------------

const token = localStorage.getItem('token');
console.log('Token guardado: ', token);

// ----------------------------------------------------------------------------------

fetch('http://localhost:8080/construct/reportes', {
  method: 'GET',
  headers: {
    'Authorization': 'Bearer ' + token,
    'Content-Type': 'application/json'
  }
})
.then(res => {
  if(!res.ok) throw new Error('No autorizado o error en la petición');
  return res.json();
})
.then(data => {
  console.log('Datos recibidos;', data);

  let datos = document.getElementById("miTablaReport")
  datos.innerHTML = ``

  data.forEach( a => {
    datos.innerHTML += `
      <tr>
        <td>${a.id_reporte}</td>
        <td>${a.inventario_id}</td>
        <td>${a.nombre}</td>
        <td>${a.herramientas_mas_usadas}</td>
      </tr>
    `;
  });
})
.catch(err => {
  console.log('Error', err);
  
});