package unique;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("qwerty", "1234567", "qwer@c.c", "Kim", "Tae");
        System.out.println(user1);
        System.out.println(User.getExtent());
        User user2 = new User("qwerty", "1234uuytrfgn567", "qwer@c.c", "Yoi", "Bem");
        System.out.println(user2);
        System.out.println(User.getExtent());
    }
}
