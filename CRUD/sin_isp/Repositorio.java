package sin_isp;

import java.util.List;

/**
  Interfaz MONOLÍTICA que VIOLA ISP.
  
  Problema:
  - Una única interfaz con TODOS los métodos CRUD.
  - Los clientes que solo necesitan leer, dependen de métodos que NO usan (actualizar, eliminar).
  - Los clientes que solo crean, dependen de métodos que NO usan (leer, actualizar, eliminar).
  
  Consecuencias:
  - Alto acoplamiento: cambios en cualquier operación afectan a todos.
  - Interfaz "gorda": confusa, poco clara, mezcla responsabilidades.
  - Difícil testing: no puedes mockear solo lectura sin implementar también escritura.
  
 * Esto es lo que ISP busca evitar.
 */
public interface Repositorio {
    void crear(Usuario usuario);
    Usuario obtenerPorId(String id);
    List<Usuario> listar();
    void actualizar(Usuario usuario);
    void eliminar(String id);
}
