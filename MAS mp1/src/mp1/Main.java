package mp1;

import java.io.*;
import java.time.LocalDate;

public class Main {

    public static void writeExtent(String extentFile) throws IOException {
        FileOutputStream fileOutput = new FileOutputStream(extentFile);
        try (fileOutput; ObjectOutputStream StreamOutput = new ObjectOutputStream(fileOutput)) {
            ObjectPlus.writeExtents(StreamOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readExtent(String extentFile) throws IOException {
        FileInputStream fileInput = new FileInputStream(extentFile);
        try (fileInput; ObjectInputStream streamInput = new ObjectInputStream(fileInput)) {
            ObjectPlus.readExtents(streamInput);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        final String extentFile = "C:\\Users\\77076\\Desktop\\MAS mp1\\mp1.bin";


        Game game1 = new Game("game1", 400f, LocalDate.now(), "studio1", "RPG", Rating.SIXTEEN);
        Game game2 = new Game("game2", 700f, LocalDate.now(), "studio2", "MMO", Rating.EIGHTEEN);
        Game game3 = new Game("game3", 500f, LocalDate.now(), "studio3", "MOBA", Rating.SIX);
        Game game4 = new Game("game4", 450f, LocalDate.now(), "studio4", "Horror", Rating.EIGHTEEN);
        Game game5 = new Game("game5", 140f, LocalDate.now(), "studio5", "MMO-RPG", Rating.ZERO);
        Game game6 = new Game("game6", 530f, LocalDate.now(), "studio6", "Sand", Rating.SIX);
        Game game7 = new Game("game7", 900f, LocalDate.now(), "studio7", "Sport", Rating.SIXTEEN);


        User user1 = new User("user1", "12345", "user1@user.com", "+48576520151");
        User user2 = new User("user2", "qwerty", "user2@user.com", "7834562");
        User user3 = new User("user3", "123513251", "user3@user.com", "58763973");
        User user4 = new User("user4", "123513251", "user4@user.com", "+48576520151");

        ObjectPlus extents = new ObjectPlus();
        System.out.println(extents.findUser(1));
        System.out.println(extents.findUser(2));

        user1.setAccountWallet(7000D);
        System.out.println(user1.getAccountWallet());
        user1.buyGame(game1);
        System.out.println("USER's EXP - " + user1.getExp() + ", " + user1.getMaxExp() + ", ACCOUNT LEVEL - " + user1.getAccountLevel());
        user1.buyGame(game2);
        System.out.println(user1.getAccountWallet());
        System.out.println("USER's EXP - " + user1.getExp() + ", " + user1.getMaxExp() + ", ACCOUNT LEVEL - " + user1.getAccountLevel());
        user1.buyGame(game3);
        System.out.println(user1.getAccountWallet());
        System.out.println("USER's EXP - " + user1.getExp() + ", " + user1.getMaxExp() + ", ACCOUNT LEVEL - " + user1.getAccountLevel());
        user1.buyGame(game4);
        System.out.println("USER's EXP - " + user1.getExp() + ", " + user1.getMaxExp() + ", ACCOUNT LEVEL - " + user1.getAccountLevel());
        System.out.println(user1.getAccountWallet());
        user1.removeGame(game2);

//
//        System.out.println(extents.findUser(1));
//
        System.out.println("number of existing Users: " + User.getNumberOfUsers());

        writeExtent(extentFile);
        readExtent(extentFile);
//
        ObjectPlus.showExtent(User.class);
//        ObjectPlus.showExtent(Game.class);
    }
}
