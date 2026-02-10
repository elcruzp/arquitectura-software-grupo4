package con_isp;

import java.util.List;

public interface LeerRepositorio {
    Usuario obtenerPorId(String id);
    List<Usuario> listar();
}
