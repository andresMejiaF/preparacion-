package preparacion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import preparacion.dao.UsuarioDao;
import preparacion.models.Usuario;

import java.util.ArrayList;
import java.util.List;

@RestController
public class usuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable  Long id){

        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Santiago");
        usuario.setApellido("Mejia");
        usuario.setEmail("andress.mejiaf@gmail.com");
        usuario.setPassword("am5589uq");
        usuario.setTelefono("3104327744");
        return usuario;

    }

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();

    }
    /*
    @RequestMapping(value = "usuario")
    public Usuario editar(){

        Usuario usuario = new Usuario();
        usuario.setNombre("Santiago");
        usuario.setApellido("Mejia");
        usuario.setEmail("andress.mejiaf@gmail.com");
        usuario.setPassword("am5589uq");
        usuario.setTelefono("3104327744");
        return usuario;
    }
  */

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id){
        usuarioDao.eliminar(id);
    }
/*
    @RequestMapping(value = "usuario")
    public Usuario buscar(){

        Usuario usuario = new Usuario();
        usuario.setNombre("Santiago");
        usuario.setApellido("Mejia");
        usuario.setEmail("andress.mejiaf@gmail.com");
        usuario.setPassword("am5589uq");
        usuario.setTelefono("3104327744");
        return usuario;
    }
*/





}
