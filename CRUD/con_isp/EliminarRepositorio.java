package con_isp;

/*
Interfaz segregada para operaciones de ELIMINACIÓN.
  
 Principio ISP (Interface Segregation Principle):
 - Los clientes que solo necesitan eliminar usuarios, dependen SOLO de esta interfaz.
 - No dependen de métodos de creación, lectura o actualización que no usan.
 */
public interface EliminarRepositorio {
    void eliminar(String id);
}
