package con_isp;

import java.util.List;

/*
  Servicio de consulta/lectura que cumple ISP.
  
  Punto clave:
  - Recibe SOLO la interfaz LeerRepositorio (no Repositorio monolítica).
  - No tiene acceso a métodos de creación, actualización o eliminación.
  
  Beneficio del ISP:
  - Este servicio es "blindado" contra cambios de escritura.
  - Si alguien intenta hacer admin.crearUsuario(), obtendrá error de compilación.
  - Mayor seguridad y claridad: el código documenta a sí mismo qué puede hacer.
 */
public class ServicioConsulta {
    private final LeerRepositorio lector;

    public ServicioConsulta(LeerRepositorio lector) {
        this.lector = lector;
    }

    public Usuario obtenerPorId(String id) { 
        return lector.obtenerPorId(id); 
    }
    
    public List<Usuario> listarUsuarios() { 
        return lector.listar(); 
    }
}
