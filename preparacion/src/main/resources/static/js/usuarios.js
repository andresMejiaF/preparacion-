// Call the dataTables jQuery plugin
$(document).ready(function() {

    cargarUsuarios();

  $('#usuarios').DataTable();
});


async function cargarUsuarios(){
    console.log("llega aqui");
    const request = await fetch('api/usuarios', {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    });
    const usuarios = await request.json();
    let listadoHtml = '';

    for (let usuario of usuarios){

        let botonEliminmar = '<a href=\"#\" onclick="eliminarUsuarioid('+usuario.id+')" class=\"btn btn-danger btclassNamecle btn-sm\"><i class=\"fas fa-trash\"></iclassName </a>';

        let usuarioHTML = '<tr></tr><td>'+ usuario.id +'</td><td>'+ usuario.nombre +' '+ usuario.apellido +'</td><td>'
            + usuario.email +'</td><td>'+usuario.telefono
            +'</td><td>'+ botonEliminmar +'</td></tr>';
        listadoHtml+= usuarioHTML;
    }

    document.querySelector('#usuarios tbody').outerHTML = listadoHtml;

}


async function eliminarUsuarioid(id) {

    if(!confirm('Desea eliminar este usuario')){
        return;
    }

    const request = await fetch('api/usuarios/'+ id, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    location.reload();
}


