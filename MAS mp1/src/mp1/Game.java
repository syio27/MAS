package mp1;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Game extends ObjectPlus implements Serializable {
    private static final long serialVersionUID = 1L;

    private static int countId = 0;
    private int id;
    private String title;
    private Float price;
    private LocalDate releaseDate;
    private String studio;
    private String genre;
    private Rating ageRating;

    public Game(String title, Float price, LocalDate releaseDate, String studio, String genre, Rating ageRating) throws ClassNotFoundException {
        super();
        countId++;
        try {
            setId(countId);
            setTitle(title);
            setPrice(price);
            setReleaseDate(releaseDate);
            setStudio(studio);
            setGenre(genre);
            setAgeRating(ageRating);
        }
        catch (IllegalArgumentException e){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String sStackTrace = sw.toString(); // stack trace as a string
            System.out.println(sStackTrace);
            ArrayList<Game> games = (ArrayList<Game>) ObjectPlus.getExtent(Game.class);
            games.remove(this);
            System.out.println("game was deleted \n");
            countId--;
        }
    }

    public int getId() {
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
        if(title == null){
            throw new IllegalArgumentException("Title cannot be null");
        }
        if(title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        if (releaseDate == null){
            throw new IllegalArgumentException("Release cannot be null");
        }
        this.releaseDate = releaseDate;
    }

    public void setStudio(String studio) {
        if (studio == null){
            throw new IllegalArgumentException("Studio cannot be null");
        }
        if(studio.isEmpty()) {
            throw new IllegalArgumentException("Studio cannot be empty");
        }
        this.studio = studio;
    }

    public void setGenre(String genre) {
        if (genre == null){
            throw new IllegalArgumentException("Genre cannot be null");
        }
        if(genre.isEmpty()) {
            throw new IllegalArgumentException("Genre cannot be empty");
        }
        this.genre = genre;
    }

    public void setPrice(Float price) {
        if (price == null){
            throw new IllegalArgumentException("Genre cannot be null");
        }
        if(price < 0){
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public void setAgeRating(Rating ageRating) {
        this.ageRating = ageRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id + ", " + title + ", " + price + ", " + releaseDate + ", " + studio + ", " + genre + ", " + ageRating;
    }
}
