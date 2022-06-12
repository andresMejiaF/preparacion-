package preparacion.controllers;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();

    }
    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void getUsuarios(@RequestBody Usuario usuario){

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash= argon2.hash(1, 1024, 1,  usuario.getPassword());
        usuario.setPassword(hash);
         usuarioDao.registrar(usuario);

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
