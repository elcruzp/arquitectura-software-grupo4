package sin_isp;

// Servicio administrativo que usa la misma interfaz monolítica
public class ServicioAdmin {
    private final Repositorio repositorio;

    public ServicioAdmin(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void crearUsuario(Usuario u) { repositorio.crear(u); }
    public void actualizarUsuario(Usuario u) { repositorio.actualizar(u); }
    public void eliminarUsuario(String id) { repositorio.eliminar(id); }
}
