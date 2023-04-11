package order;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("qwerty", "Kim", "Tae", 1000);
        Game game1 = new Game("CSGO", 40);
        Game game2 = new Game("Metro", 120);
        Game game3 = new Game("GTA5", 180);
        Game game4 = new Game("The Witcher 3", 190);
        Game game5 = new Game("Horizon Zero Dawn", 250);

        user1.addGame(game4);
        user1.addGame(game2);
        user1.addGame(game1);
        user1.addGame(game3);
        user1.addGame(game5);

        System.out.println(game3);

        System.out.println(user1.getWallet());
        System.out.println(user1.getGames());
    }
}
