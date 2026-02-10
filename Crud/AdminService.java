public class AdminService {

    private UserCreate creator;
    private UserRead reader;
    private UserUpdate updater;
    private UserDelete deleter;

    public AdminService(UserCreate c, UserRead r, UserUpdate u, UserDelete d) {
        this.creator = c;
        this.reader = r;
        this.updater = u;
        this.deleter = d;
    }

    public void manageUsers() {
        creator.create("Carlos");
        updater.update(1, "Carlos Actualizado");
        System.out.println(reader.read(1));
        deleter.delete(1);
    }
}
