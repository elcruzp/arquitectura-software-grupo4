package con_isp;

import java.util.*;

/**
 Implementación en memoria del repositorio que cumple ISP.
  
  Características:
  - Implementa TODAS las interfaces segregadas (Crear, Leer, Actualizar, Eliminar).
  - Es la clase concreta que ejecuta la lógica CRUD.
  - Los datos se almacenan en un Map (para simplificar, no usa base de datos).
  
  Ventaja: si queremos usar solo lectura, inyectamos la interfaz LeerRepositorio.
 */
public class RepositorioEnMemoria implements CrearRepositorio, LeerRepositorio, ActualizarRepositorio, EliminarRepositorio {
    private final Map<String, Usuario> datos = new LinkedHashMap<>();

    @Override
    public void crear(Usuario usuario) {
        datos.put(usuario.getId(), usuario);
    }

    @Override
    public Usuario obtenerPorId(String id) {
        return datos.get(id);
    }

    @Override
    public List<Usuario> listar() {
        return new ArrayList<>(datos.values());
    }

    @Override
    public void actualizar(Usuario usuario) {
        if (datos.containsKey(usuario.getId())) {
            datos.put(usuario.getId(), usuario);
        }
    }

    @Override
    public void eliminar(String id) {
        datos.remove(id);
    }
}
