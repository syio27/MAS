package order;

import java.util.Objects;

public class Game {
    private static Long countId = 0L;
    private Long id;
    private String title;
    private Integer price;

    public Game(String title, Integer price) {
        countId++;
        setId(countId);
        setTitle(title);
        setPrice(price);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) && Objects.equals(title, game.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
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
