package con_isp;

import java.util.List;

/**
 * Demo de ISP: Ejemplo CORRECTO (con ISP aplicado).
 * 
 * Qué sucede aquí:
 * 1. Se crea RepositorioEnMemoria (implementa todas las interfaces segregadas).
 * 2. Se inyecta en ServicioAdmin SOLO las interfaces que necesita (crear, actualizar, eliminar).
 * 3. Se inyecta en ServicioConsulta SOLO la interfaz de lectura.
 * 
 * Ventajas observables:
 * - Bajo acoplamiento: cada servicio depende de lo mínimo.
 * - Responsabilidad clara: ServicioConsulta solo puede leer.
 * - Fácil testing: podemos mockear cada interfaz segregada por separado.
 * - Mantenibilidad: cambios en lectura no afectan a admin y viceversa.
 */
public class Demo {
    public static void run() {
        System.out.println("--- Ejemplo CON ISP (buena práctica) ---");
        RepositorioEnMemoria repo = new RepositorioEnMemoria();
        
        // Inyección de dependencias SEGREGADAS
        ServicioAdmin admin = new ServicioAdmin(repo, repo, repo);
        ServicioConsulta consulta = new ServicioConsulta(repo);

        // Crear usuarios
        admin.crearUsuario(new Usuario("1", "Juana"));
        admin.crearUsuario(new Usuario("2", "Carlos"));

        System.out.println("Lista inicial:");
        List<Usuario> lista = consulta.listarUsuarios();
        for (Usuario u : lista) System.out.println(u);

        System.out.println("(ServicioConsulta depende solo de LeerRepositorio)");
        System.out.println();
    }
}
