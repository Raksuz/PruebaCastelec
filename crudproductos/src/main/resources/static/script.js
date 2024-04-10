$(document).ready(() => {

    const mostrarProductos = () => {
        $.ajax({
            url: 'http://localhost:8080/productos/obtener',
            type: 'GET',
            dataType: 'json',
            success: function(res) {
                let data = '';
                res.forEach(element => {
                    data += `
                    <tr productoId = ${element.id}>
                    <td>${element.id}</td>
                    <td>${element.nombre}</td>
                    <td>${elemen.descripcion}</td>
                    <td>${element.precio}</td>
                    <td>${element.categoria}</td>
                    <td><button id = "eliminar" class="btn btn-danger">Eliminar</td>
                    <td><button id = "editar" class="btn btn-primary">Editar</td>
                    </tr>
                    `
                });
                $('#tbody').html(data);
            }
        })
    }
    mostrarProductos();
});