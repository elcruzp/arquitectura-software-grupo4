public class UserService {

    private UserRead reader;

    public UserService(UserRead reader) {
        this.reader = reader;
    }

    public void viewUser(int id) {
        System.out.println("Usuario: " + reader.read(id));
    }
}
