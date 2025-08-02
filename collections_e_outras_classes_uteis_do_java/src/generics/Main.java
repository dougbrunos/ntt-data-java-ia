package generics;

public class Main {

    private final static GenericDAO<UserDomain> dao = new UserDAO();

    public static void main(String[] args) {
        var user = new UserDomain("Douglas", 12);
        System.out.println(dao.count());
        System.out.println(dao.save(user));
        System.out.println(dao.findAll());
        System.out.println(dao.count());
        dao.delete(user);
        System.out.println(dao.findAll());
        System.out.println(dao.count());
    }

}
