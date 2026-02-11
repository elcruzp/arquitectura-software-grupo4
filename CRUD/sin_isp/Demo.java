package sin_isp;

import java.util.List;

/**
  Demo de SIN ISP: Ejemplo INCORRECTO (viola ISP).
  
  Qué sucede aquí:
  1. Se crea RepositorioEnMemoria (implementa Repositorio monolítica).
  2. Se inyecta la interfaz Repositorio COMPLETA en ambos servicios.
  3. ServicioLectura recibe una interfaz con métodos que no usa.
  
  Problemas observables:
  - Alto acoplamiento: cambios en actualizar/eliminar afectan a lectura.
  - Interfaz confusa: ServicioLectura parece que podría actualizar/eliminar (aunque no lo hace).
  - Testing: si queremos mockear lectura, debemos implementar todos los métodos CRUD.
  - Mantenibilidad: difícil de entender qué métodos usa cada servicio.
  
 * Esta es la mala práctica que ISP evita.
 */
public class Demo {
    public static void run() {
        System.out.println("--- Ejemplo SIN ISP (mala práctica) ---");
        Repositorio repo = new RepositorioEnMemoria();
        ServicioAdmin admin = new ServicioAdmin(repo);
        ServicioLectura lectura = new ServicioLectura(repo);

        admin.crearUsuario(new Usuario("A1", "Ana"));
        admin.crearUsuario(new Usuario("B2", "Beto"));

        System.out.println("Lista inicial:");
        List<Usuario> lista = lectura.listarUsuarios();
        for (Usuario u : lista) System.out.println(u);

        // Notar que ServicioLectura depende de una interfaz con métodos que no usa
        System.out.println("(ServicioLectura depende de Repositorio monolítico)");
        System.out.println();
    }
}
