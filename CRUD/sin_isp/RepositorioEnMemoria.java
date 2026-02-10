package sin_isp;

import java.util.*;

public class RepositorioEnMemoria implements Repositorio {
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
