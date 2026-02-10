package sin_isp;

import java.util.List;

// Interfaz monolítica que viola ISP: tiene todos los métodos CRUD
public interface Repositorio {
    void crear(Usuario usuario);
    Usuario obtenerPorId(String id);
    List<Usuario> listar();
    void actualizar(Usuario usuario);
    void eliminar(String id);
}
