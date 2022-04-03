package mp1;

import java.io.Serializable;
import java.time.LocalDate;

public class Game extends ObjectPlus implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private Float price;
    private LocalDate releaseDate;
    private String studio;
    private String genre;
    private Rating ageRating;

    public Game(Long id, String title, Float price, LocalDate releaseDate, String studio, String genre, Rating ageRating) {
        super();

        this.id = id;
        this.title = title;
        this.price = price;
        this.releaseDate = releaseDate;
        this.studio = studio;
        this.genre = genre;
        this.ageRating = ageRating;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Float getPrice() {
        return price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getStudio() {
        return studio;
    }

    public String getGenre() {
        return genre;
    }

    public Rating getAgeRating() {
        return ageRating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setAgeRating(Rating ageRating) {
        this.ageRating = ageRating;
    }

    @Override
    public String toString() {
        return id + ", " + title + ", " + price + ", " + releaseDate + ", " + studio + ", " + genre + ", " + ageRating;
    }
}
