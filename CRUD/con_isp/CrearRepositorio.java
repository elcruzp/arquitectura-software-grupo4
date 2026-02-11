package con_isp;

/**
 * Interfaz segregada para operaciones de CREACIÓN.
 * 
 * Principio ISP (Interface Segregation Principle):
 * - Los clientes que solo necesitan crear usuarios, dependen SOLO de esta interfaz.
 * - No dependen de métodos de lectura, actualización o eliminación que no usan.
 * 
 * Beneficios:
 * - Bajo acoplamiento: cambios en lectura no afectan al servicio de creación.
 * - Interfaz clara y específica: quien la implementa sabe exactamente qué debe hacer.
 */
public interface CrearRepositorio {
    void crear(Usuario usuario);
}
