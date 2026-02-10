package con_isp;

public class ServicioAdmin {
    private final CrearRepositorio creador;
    private final ActualizarRepositorio actualizador;
    private final EliminarRepositorio eliminador;

    public ServicioAdmin(CrearRepositorio creador, ActualizarRepositorio actualizador, EliminarRepositorio eliminador) {
        this.creador = creador;
        this.actualizador = actualizador;
        this.eliminador = eliminador;
    }

    public void crearUsuario(Usuario u) { creador.crear(u); }
    public void actualizarUsuario(Usuario u) { actualizador.actualizar(u); }
    public void eliminarUsuario(String id) { eliminador.eliminar(id); }
}
