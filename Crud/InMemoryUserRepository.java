import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository
        implements UserCreate, UserRead, UserUpdate, UserDelete {

    private Map<Integer, String> users = new HashMap<>();
    private int counter = 1;

    @Override
    public void create(String user) {
        users.put(counter++, user);
        System.out.println("Usuario creado");
    }

    @Override
    public String read(int id) {
        return users.get(id);
    }

    @Override
    public void update(int id, String user) {
        users.put(id, user);
        System.out.println("Usuario actualizado");
    }

    @Override
    public void delete(int id) {
        users.remove(id);
        System.out.println("Usuario eliminado");
    }
}
