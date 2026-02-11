package con_isp;

/**
 * Servicio administrativo que cumple ISP.
 * 
 * Inyección de dependencias segregadas:
 * - Recibe CrearRepositorio para crear.
 * - Recibe ActualizarRepositorio para actualizar.
 * - Recibe EliminarRepositorio para eliminar.
 * 
 * Ventaja ISP:
 * - Este servicio SOLO depende de las interfaces que usa.
 * - No tiene acceso a métodos de lectura (que no debería usar).
 * - Cambios en la lectura no lo afectan.
 * 
 * Nota: La misma implementación (RepositorioEnMemoria) cumple todas las interfaces.
 */
public class ServicioAdmin {
    private final CrearRepositorio creador;
    private final ActualizarRepositorio actualizador;
    private final EliminarRepositorio eliminador;

    public ServicioAdmin(CrearRepositorio creador, ActualizarRepositorio actualizador, EliminarRepositorio eliminador) {
        this.creador = creador;
        this.actualizador = actualizador;
        this.eliminador = eliminador;
    }

    public void crearUsuario(Usuario u) { 
        creador.crear(u); 
    }
    
    public void actualizarUsuario(Usuario u) { 
        actualizador.actualizar(u); 
    }
    
    public void eliminarUsuario(String id) { 
        eliminador.eliminar(id); 
    }
}
