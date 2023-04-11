package mp1;

import org.jetbrains.annotations.NotNull;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class User extends ObjectPlus implements Serializable {
    private static final long serialVersionUID = 1L;

    private static int countId = 0; // mandatory attribute
    private int id;
    private String login; // mandatory attribute
    private String password; // mandatory attribute
    private String accountName; // optional attribute
    private String mail; // mandatory attribute
    private String telephoneNumber; // optional attribute
    private Double accountWallet; // mandatory attribute
    private ArrayList<Game> gamesCollection = new ArrayList<>(); // Multi-value attribute
    private int accountLevel;
    private LocalDate registerDate; // Complex attribute
    private int numberOfGames; // derived attribute
    private static int numberOfUsers = 0; // Class attribute

    // attributes for level upping
    private final Random random;
    private Integer exp = 0;
    private int maxExp = 1000;
    // default/free game for every user
    {
        random = new Random();
        try {
            gamesCollection.add(new Game("defaultGame", 0F, LocalDate.of(2011, 2, 21), "indieGameStudio", "sand", Rating.ZERO));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public User(String login, String password, String mail, String telephoneNumber) throws ClassNotFoundException {
        super();
        countId++;
        try{
            setId(countId);
            setLogin(login);
            setPassword(password);
            setMail(mail);
            setAccountName(login); // if user do not provide an accountName it will be replaced by login
            setTelephoneNumber(telephoneNumber);
            setRegisterDate(LocalDate.now());
            setAccountWallet(0D);
            setAccountLevel(0);
        }
        catch (IllegalArgumentException e){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String sStackTrace = sw.toString(); // stack trace as a string
            System.out.println(sStackTrace);
            ArrayList<User> users = (ArrayList<User>) ObjectPlus.getExtent(User.class);
            users.remove(this);
            System.out.println("user was deleted \n");
            countId--;
        }
    }

    // method overloading
    public User(String login, String password, String mail, String telephoneNumber, String accountName) throws ClassNotFoundException {
        super();
        countId++;
        try{
            setId(countId);
            setLogin(login);
            setPassword(password);
            setMail(mail);
            setAccountName(accountName); // if user do not provide an accountName it will be replaced by login
            setTelephoneNumber(telephoneNumber);
            setRegisterDate(LocalDate.now());
            setAccountWallet(0D);
            setAccountLevel(0);
        }
        catch (IllegalArgumentException e){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String sStackTrace = sw.toString(); // stack trace as a string
            System.out.println(sStackTrace);
            ArrayList<User> users = (ArrayList<User>) ObjectPlus.getExtent(User.class);
            users.remove(this);
            System.out.println("user was deleted \n");
            countId--;
        }
    }

    public void setPassword(String password) {
        if(password == null){
            throw new IllegalArgumentException("password cannot be null");
        }
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login){
        if(login.isEmpty()){
            throw new IllegalArgumentException("Login cannot be empty");
        }
        if(login == null){
            throw new IllegalArgumentException("Login cannot be null");
        }
        this.login = login;
    }

    public void setAccountLevel(int accountLevel) {
        this.accountLevel = accountLevel;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public void setAccountName(String accountName) {
        if(accountName.isEmpty()){
            throw new IllegalArgumentException("Account name cannot be valid");
        }
        this.accountName = accountName;
    }

    public void setMail(String mail) {
        if(mail.isEmpty()){
            throw new IllegalArgumentException("Mail cannot be null");
        }
        if(mail == null){
            throw new IllegalArgumentException("Mail cannot be null");
        }
        this.mail = mail;
    }

    public void setAccountWallet(Double accountWallet){
        if(accountWallet == null){
            throw new IllegalArgumentException("Wallet cannot be null");
        }
        if(accountWallet < 0){
            throw new IllegalArgumentException("Wallet cannot be negative");
        }
        this.accountWallet = accountWallet;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        if(telephoneNumber.length() != 12){
            throw new IllegalArgumentException("Telephone number is not valid");
        }
        this.telephoneNumber = telephoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public Double getAccountWallet() {
        return accountWallet;
    }

    public ArrayList<Game> getGamesCollection() {
        return gamesCollection;
    }

    public int getAccountLevel() {
        return accountLevel;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public int getNumberOfGames() {
        return this.gamesCollection.size();
    }

    public static int getNumberOfUsers() throws ClassNotFoundException {
        List<User> users = (ArrayList<User>) ObjectPlus.getExtent(User.class);
        numberOfUsers = users.size();
        return numberOfUsers;
    }

    // add game to collection
    public void buyGame(Game game) throws Exception{
        if(game == null){
            throw new IllegalArgumentException("game is null");
        }
        if(this.gamesCollection.contains(game)){
            throw new Exception("User already have this game");
        }
        if(this.accountWallet <= game.getPrice()){
            throw new Exception("account does not have enough funds");
        }
        this.accountWallet -= game.getPrice();
        this.gamesCollection.add(game);
        levelUp();
    }

    // remove game from collection
    public void removeGame(Game game){
        if(game == null){
            throw new IllegalArgumentException("game is null");
        }
        if (gamesCollection.contains(game)) {
            gamesCollection.remove(game);
        } else {
            throw new IllegalArgumentException("User doesnt have this game");
        }
    }

    // Object method
    // gains exp for buys games and levels up reaching the range of maxEXP
    private void levelUp(){
        exp += random.nextInt(50) + 250;
        if(exp >= maxExp){
            accountLevel++;
            maxExp +=200;
            exp = 0;
        }
    }

    public Integer getExp() {
        return exp;
    }

    public int getMaxExp() {
        return maxExp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login);
    }

    //method overriding
    @Override
    public String toString() {
        return "ID - " + id + ", account login - " + login + ", accont name - " + accountName + ", mail - " + mail + ", account level - " + accountLevel + ", wallet - " + accountWallet + ". Games at account: " + gamesCollection;
    }
}
