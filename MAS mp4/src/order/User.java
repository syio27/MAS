package order;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class User {
    private static Long countId = 0L;
    private Long id;
    private String login;
    private String firstName, lastName;
    private int wallet;

    private final Set<Game> games = new TreeSet<>(new GameComparator());

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

    public void addGame(Game game){
        if(game == null){
            throw new IllegalArgumentException("User cannot purchase nullable game");
        }
        if(games.contains(game)){
            throw new IllegalArgumentException("User already has this game");
        }
        if(wallet >= game.getPrice()) {
            wallet -= game.getPrice();
            games.add(game);
        }
    }

    public void removeGame(Game game){
        if(game == null){
            throw new IllegalArgumentException("User cannot delete nullable game");
        }
        games.remove(game);
    }

    public Set<Game> getGames() {
        return Collections.unmodifiableSet(games);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
