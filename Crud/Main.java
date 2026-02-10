public class Main {
    public static void main(String[] args) {

        InMemoryUserRepository repo = new InMemoryUserRepository();

        AdminService admin = new AdminService(repo, repo, repo, repo);
        UserService user = new UserService(repo);

        admin.manageUsers();
        user.viewUser(1);
    }
}
