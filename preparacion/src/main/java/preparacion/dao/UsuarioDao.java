package preparacion.dao;

import preparacion.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    void eliminar(Long id);
    List<Usuario> getUsuarios();

    void registrar(Usuario usuario);

    boolean verificarEmailPassword(Usuario usuario);
}
