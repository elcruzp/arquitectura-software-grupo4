package con_isp;

import java.util.List;

public class ServicioConsulta {
    private final LeerRepositorio lector;

    public ServicioConsulta(LeerRepositorio lector) {
        this.lector = lector;
    }

    public Usuario obtenerPorId(String id) { return lector.obtenerPorId(id); }
    public List<Usuario> listarUsuarios() { return lector.listar(); }
}
