package con_isp;

import java.util.List;

public class Demo {
    public static void run() {
        System.out.println("--- Ejemplo CON ISP (buena práctica) ---");
        RepositorioEnMemoria repo = new RepositorioEnMemoria();
        ServicioAdmin admin = new ServicioAdmin(repo, repo, repo);
        ServicioConsulta consulta = new ServicioConsulta(repo);

        admin.crearUsuario(new Usuario("1", "Juana"));
        admin.crearUsuario(new Usuario("2", "Carlos"));

        System.out.println("Lista inicial:");
        List<Usuario> lista = consulta.listarUsuarios();
        for (Usuario u : lista) System.out.println(u);

        System.out.println("(ServicioConsulta depende solo de LeerRepositorio)");
        System.out.println();
    }
}
