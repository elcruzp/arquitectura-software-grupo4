package sin_isp;

import java.util.List;

/**
  Servicio de lectura que VIOLA ISP.
  
  Problema clave:
  - Recibe la interfaz Repositorio COMPLETA (monolítica).
  - Solo usa los métodos de lectura (obtenerPorId, listar).
  - Pero depende de métodos que NO usa: crear, actualizar, eliminar.
  
  Consecuencia:
  - Acoplamiento innecesario: si Repositorio cambia (p.ej., se agrega deleteAll),
    ServicioLectura se ve afectado aunque no use ese método.
  - Violación de ISP: el cliente depende de interfaces que no necesita.
  
 * Contrastar con con_isp.ServicioConsulta que solo recibe LeerRepositorio.
 */
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
