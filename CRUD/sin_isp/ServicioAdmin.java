package sin_isp;

/**
 * Servicio administrativo que VIOLA ISP.
 * 
 * Problema:
 * - Recibe la interfaz Repositorio COMPLETA (monolítica).
 * - Usa todos los métodos (crear, actualizar, eliminar), así que en este caso es menos problemático.
 * - Pero sigue siendo acoplamiento a más de lo necesario.
 * 
 * En sistemas grandes, esta interfaz "gorda" se vuelve problemática para otros servicios
 * que solo necesitan un subconjunto de operaciones.
 */
public class ServicioAdmin {
    private final Repositorio repositorio;

    public ServicioAdmin(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void crearUsuario(Usuario u) { 
        repositorio.crear(u); 
    }
    
    public void actualizarUsuario(Usuario u) { 
        repositorio.actualizar(u); 
    }
    
    public void eliminarUsuario(String id) { 
        repositorio.eliminar(id); 
    }
}
