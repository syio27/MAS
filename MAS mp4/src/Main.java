import bag.User_Game;
import custom_constraint.User;
import order.Game;
import subset.Chat;

public class Main {
    public static void main(String[] args) {
        //Custom constraint
        //Checks if the entered status is ok
        //Checks if the new status is not same as prev status
        User custom_constraint_user = new User("bgkim", "12345567", "NOTCONFIRMED");
        custom_constraint_user.newStatus("ACTIVE");
        System.out.println(custom_constraint_user.getStatus());

        //Unique constraint
        //Login must be unique in order to register(create) new user
        unique.User user1 = new unique.User("qwerty", "1234567", "qwer@c.c", "Kim", "Tae");
        System.out.println(user1);
        System.out.println(unique.User.getExtent());
        unique.User user2 = new unique.User("qwerty", "1234uuytrfgn567", "qwer@c.c", "Yoi", "Bem");
        System.out.println(user2);
        System.out.println(unique.User.getExtent());

        //Subset
        //User is able to be admin only if he owns the chat
        subset.User user_subset = new subset.User("bbbb", "23412341");
        subset.Chat chat = new Chat("chat", 1);
        user_subset.addLink("owns", "isOwned", chat);
        user_subset.addLink_subset("admins", "isAdmined", "owns", chat);

        //Order constraint
        //order games by price
        order.User user_order = new order.User("qwerty", "Kim", "Tae", 1000);
        Game game1 = new Game("CSGO", 40);
        Game game2 = new Game("Metro", 120);
        Game game3 = new Game("GTA5", 180);
        Game game4 = new Game("The Witcher 3", 190);
        Game game5 = new Game("Horizon Zero Dawn", 250);

        user_order.addGame(game4);
        user_order.addGame(game2);
        user_order.addGame(game1);
        user_order.addGame(game3);
        user_order.addGame(game5);

        System.out.println(game3);

        System.out.println(user_order.getWallet());
        System.out.println(user_order.getGames());



        //Dymanic is password -cannot be same as prev
        // Static is email
        for_an_attribute.User user_attribute = new for_an_attribute.User("login", "14324wkejhfkwEEFWQER%%%", "login@mail.com", "BG", "BG");

        //Bag
        // Game and User can have more than 1 associations
        bag.User user_bag = new bag.User("refqwef", "qwer", "qwerqwr", 132134);
        bag.Game game_bag = new bag.Game("refqwef", 132134);
        bag.User_Game user_game_bag = new User_Game(user_bag, game_bag);
        user_bag.addAssociation(user_game_bag);
    }
}
