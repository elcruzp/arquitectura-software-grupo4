package sin_isp;

import java.util.List;

// Este servicio solo necesita leer, pero depende de la interfaz monolítica
public class ServicioLectura {
    private final Repositorio repositorio;

    public ServicioLectura(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario obtenerPorId(String id) {
        return repositorio.obtenerPorId(id);
    }

    public List<Usuario> listarUsuarios() {
        return repositorio.listar();
    }
}
