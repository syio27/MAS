package bag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private static Long countId = 0L;
    private Long id;
    private String title;
    private Integer price;

    private List<User_Game> userGameList = new ArrayList<>();

    public Game(String title, Integer price) {
        countId++;
        setId(countId);
        setPrice(price);
        setTitle(title);
    }

    public static Long getCountId() {
        return countId;
    }

    public static void setCountId(Long countId) {
        Game.countId = countId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null){
            throw new IllegalArgumentException("Title cannot be null");
        }
        if(title.isBlank()){
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        if(price == null){
            throw new IllegalArgumentException("Price of game cannot be null");
        }
        if(price < 0){
            throw new IllegalArgumentException("Price of game cannot be less than 0");
        }
        this.price = price;
    }

    public List<User_Game> getUserGameList() {
        return Collections.unmodifiableList(userGameList);
    }

    public void setUserGameList(List<User_Game> userGameList) {
        this.userGameList = userGameList;
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
        return "Game{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
