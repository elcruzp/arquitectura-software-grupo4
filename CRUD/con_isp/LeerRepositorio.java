package con_isp;

import java.util.List;

/*
 Interfaz segregada para operaciones de LECTURA.
  
  Principio ISP (Interface Segregation Principle):
  - Los clientes que solo necesitan leer usuarios, dependen SOLO de esta interfaz.
  - No dependen de métodos de creación, actualización o eliminación que no usan.
  
Ejemplo: ServicioConsulta solo recibe esta interfaz, lo que garantiza 
         que no puede (ni debe) modificar datos.
 */
public interface LeerRepositorio {
    Usuario obtenerPorId(String id);
    List<Usuario> listar();
}
