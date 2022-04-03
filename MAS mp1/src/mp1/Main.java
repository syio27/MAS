package mp1;

import java.io.*;
import java.time.LocalDate;

public class Main {

    public static void writeExtent(String extentFile){
        try{
            FileOutputStream fileOutput = new FileOutputStream(extentFile);
            ObjectOutputStream StreamOutput = new ObjectOutputStream(fileOutput);
            ObjectPlus.writeExtents(StreamOutput);
            StreamOutput.close();
            fileOutput.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void readExtent(String extentFile){
        try
        {
            FileInputStream fileInput = new FileInputStream(extentFile);
            ObjectInputStream streamInput = new ObjectInputStream(fileInput);

            ObjectPlus.readExtents(streamInput);
            streamInput.close();
            fileInput.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            System.out.println("Class not found.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        final String extentFile = "C:\\Users\\77076\\Desktop\\MAS mp1\\mp1.bin";
        writeExtent(extentFile);
        readExtent(extentFile);


        Game game1 = new Game(1L, "game1", 400f, LocalDate.now(), "studio1", "RPG", Rating.SIXTEEN);
        Game game2 = new Game(2L, "game2", 700f, LocalDate.now(), "studio2", "MMO", Rating.EIGHTEEN);
        Game game3 = new Game(3L, "game3", 500f, LocalDate.now(), "studio3", "MOBA", Rating.SIX);
        Game game4 = new Game(4L, "game4", 450f, LocalDate.now(), "studio4", "Horror", Rating.EIGHTEEN);
        Game game5 = new Game(5L, "game5", 140f, LocalDate.now(), "studio5", "MMO-RPG", Rating.ZERO);
        Game game6 = new Game(6L, "game6", 530f, LocalDate.now(), "studio6", "Sand", Rating.SIX);
        Game game7 = new Game(7L, "game7", 900f, LocalDate.now(), "studio7", "Sport", Rating.SIXTEEN);

        User user1 = new User(1L, "user1", "12345", "user1@user.com", 12345);
        User user2 = new User(2L, "user2", "qwerty", "user2@user.com", 7834562);
        User user3 = new User(3L, "user3", "asdfdsf", "user3@user.com", 246245);
        User user4 = new User(4L, "user4", "poiuyt", "user4@user.com", 67456);
        User user5 = new User(5L, "user5", "456436", "user5@user.com", 35467, "accountName5");
        User user6 = new User(6L, "user6", "etyey", "user6@user.com", 98765);
        User user7 = new User(7L, "user7", "dfghdh", "user7@user.com", 4565456);
        User user8 = new User(8L, "user8", "sdfh", "user8@user.com", 456567);
        User user9 = new User(9L, "user9", "xgnsg", "user9@user.com", 7689, "accountName9");
        User user10 = new User(10L, "user10", "awetqwt", "user10@user.com", 43543, "accountName10");

        ObjectPlus extents = new ObjectPlus();
        System.out.println(extents.findUser(3L));
        System.out.println(extents.findUser(5L));

        user1.setAccountWallet(7000D);
        System.out.println(user1.getAccountWallet());
        user1.buyGame(game3);
        user1.buyGame(game2);
        System.out.println(user1.getAccountWallet());

        System.out.println(extents.findUser(1L));

        System.out.println("number of existing Users: " + User.getNumberOfUsers());

        ObjectPlus.showExtent(User.class);
        ObjectPlus.showExtent(Game.class);
    }
}
