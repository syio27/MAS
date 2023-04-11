package bag;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class User_Game {
    private Game game;
    private User user;

    private long hoursPlayed;
    private LocalDate start;
    private LocalDate end;

    private static final Set<User_Game> extent = new HashSet<>();

    public User_Game(User user, Game game) {
        validate(user, game);
        setGame(game);
        setUser(user);
        setStart(LocalDate.now());
        user.addAssociation(this);
        game.addAssociation(this);
        extent.add(this);
    }

    public long getHoursPlayed() {
        return hoursPlayed;
    }

    public void setHoursPlayed(long hoursPlayed) {
        if(hoursPlayed < 0){
            throw new IllegalArgumentException("Hours Played cannot be less than 0");
        }
        this.hoursPlayed = hoursPlayed;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        if (start == null){
            throw new IllegalArgumentException("Start time cannot be null");
        }
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        if (end == null){
            throw new IllegalArgumentException("End time cannot be null");
        }
        this.end = end;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        if(game == null){
            throw new IllegalArgumentException("Game cannot be null");
        }
        this.game = game;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        if(user == null){
            throw new IllegalArgumentException("User cannot be null");
        }
        this.user = user;
    }

    public static Set<User_Game> getExtent() {
        return Collections.unmodifiableSet(extent);
    }

    public static void validate(User validatedUser, Game validateGame) {
        if (extent.stream().anyMatch(membership ->
                membership.user.equals(validatedUser)
                        && membership.game.equals(validateGame)
                        && membership.start == null)) {
            throw new IllegalArgumentException("Start time of game exists");
        }
    }

    public static void delete(User_Game user_game) {
        if (user_game == null) {
            throw new IllegalArgumentException("User_Game cannot be null");
        }
        user_game.user.removeAssociation(user_game);
        user_game.game.removeAssociation(user_game);
        extent.remove(user_game);
    }

    public void exitGame(){
        setEnd(LocalDate.now());
    }

    public void calculateHours(){
        long hours = ChronoUnit.HOURS.between(start, end);
        setHoursPlayed(hours);
    }

    @Override
    public String toString() {
        return "User_Game{" +
                "hoursPlayed=" + hoursPlayed +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
