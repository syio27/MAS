package bag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private static Long countId = 0L;
    private Long id;
    private String login;
    private String firstName, lastName;
    private int wallet;

    private List<User_Game> userGameList = new ArrayList<>();

    public User(String login, String firstName, String lastName, int wallet) {
        countId++;
        setId(countId);
        setLogin(login);
        setFirstName(firstName);
        setLastName(lastName);
        setWallet(wallet);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if(login == null){
            throw new IllegalArgumentException("login cannot be null");
        }
        if(login.isBlank()){
            throw new IllegalArgumentException("login cannot be empty");
        }
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null){
            throw new IllegalArgumentException("firstName cannot be null");
        }
        if(firstName.isBlank()){
            throw new IllegalArgumentException("firstName cannot be empty");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null){
            throw new IllegalArgumentException("lastName cannot be null");
        }
        if(lastName.isBlank()){
            throw new IllegalArgumentException("lastName cannot be empty");
        }
        this.lastName = lastName;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        if(wallet < 0){
            throw new IllegalArgumentException("Amount of money at wallet cannot be less than 0");
        }
        if(wallet > 4000){
            throw new IllegalArgumentException("Amount of money at wallet cannot exceed 4000 USD");
        }
        this.wallet = wallet;
    }

    public List<User_Game> getUserGameList() {
        return Collections.unmodifiableList(userGameList);
    }

    public void addAssociation(User_Game userGame) {
        if (userGame == null) {
            throw new IllegalArgumentException("membership cannot be null");
        }
        if (userGameList.contains(userGame)) {
            return;
        }
        userGameList.add(userGame);
    }

    public void removeAssociation(User_Game userGame) {
        if (userGame == null) {
            throw new IllegalArgumentException("userGame cannot be null");
        }
        if (!userGameList.contains(userGame)) {
            return;
        }
        userGameList.remove(userGame);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", wallet=" + wallet +
                '}';
    }
}
