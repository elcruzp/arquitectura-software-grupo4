package con_isp;

/**
 * Interfaz segregada para operaciones de ACTUALIZACIÓN.
 * 
 * Principio ISP (Interface Segregation Principle):
 * - Los clientes que solo necesitan actualizar usuarios, dependen SOLO de esta interfaz.
 * - No dependen de métodos de creación, lectura o eliminación que no usan.
 */
public interface ActualizarRepositorio {
    void actualizar(Usuario usuario);
}
