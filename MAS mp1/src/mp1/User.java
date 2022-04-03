package mp1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class User extends ObjectPlus implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id; // mandatory attribute
    private String login; // mandatory attribute
    private String password; // mandatory attribute
    private String accountName; // optional attribute
    private String mail; // mandatory attribute
    private Integer telephoneNumber; // optional attribute
    private Double accountWallet; // mandatory attribute
    private ArrayList<Game> gamesCollection = new ArrayList<>(); // Multi-value attribute
    private int accountLevel;
    private LocalDate registerDate; // Complex attribute
    private int numberOfGames; // derived attribute
    private static int numberOfUsers; // Class attribute

    public User(Long id, String login, String password, String mail, Integer telephoneNumber) throws Exception{
        super();
        this.id = id;
        this.login = login; //if Login already exists validation
        this.password = password;
        this.mail = mail;
        this.accountName = login; // if user do not provide an accountName it will be replaced by login
        this.telephoneNumber = telephoneNumber;
        this.registerDate = LocalDate.now();
        this.accountWallet = 0D;
        this.accountLevel = 0;
    }
    // method overloading
    public User(Long id, String login, String password, String mail, Integer telephoneNumber, String accountName){
        super();

        this.id = id; //if ID already exists validation
        this.login = login; //if Login already exists validation
        this.password = password;
        this.mail = mail;
        this.accountName = login; // if user do not provide an accountName it will be replaced by login
        this.telephoneNumber = telephoneNumber;
        this.registerDate = LocalDate.now();
        this.accountWallet = 0d;
        this.accountLevel = 0;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setAccountWallet(Double accountWallet) throws Exception {
        if(accountWallet == null){
            throw new Exception("wallet cannot be NULL");
        }
        this.accountWallet = accountWallet;
    }

    public void setTelephoneNumber(Integer telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Long getId() {
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

    public Integer getTelephoneNumber() {
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
        Iterable<User> userExtent = ObjectPlus.getExtent(User.class);
        ArrayList<User> users = new ArrayList<User>();
        for (User user : userExtent) {
            users.add(user);
        }
        numberOfUsers = users.size();
        return numberOfUsers;
    }

    public void buyGame(Game game) throws Exception{
        if(this.accountWallet <= game.getPrice()){
            throw new Exception("account does not have enough funds");
        }
        for(Game g : this.gamesCollection){
            if(this.gamesCollection.contains(game.getId())){
                throw new Exception("User already have this game");
            }
        }
        this.accountWallet -= game.getPrice();
        this.gamesCollection.add(game);
    }

    //method overriding
    @Override
    public String toString() {
        return id + ", " + login + ", " + accountName + ", " + mail + ", " + accountWallet + ". Games at account: " + gamesCollection;
    }
}
