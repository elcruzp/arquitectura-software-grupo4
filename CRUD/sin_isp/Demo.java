package sin_isp;

import java.util.List;

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
