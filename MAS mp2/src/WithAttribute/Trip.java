package WithAttribute;

import java.util.HashSet;
import java.util.Set;

public class Trip {
    private final Set<Flight> flights = new HashSet<>();

    private static int count_id = 0;
    private int id;
    private String name;
    private String description;

    public Trip(String name, String description) {
        count_id++;
        setId(count_id);
        setName(name);
        setDescription(description);
    }

    public void addFlight(Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException("Flight cannot be null");
        }
        if(flight.getTrip() != this){
            throw new IllegalArgumentException("Trip is not related to this flight");
        }
        if (!flights.contains(flight)) {
            flights.add(flight);
        }
    }

    public void removeFlight(Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException("Flight cannot be null");
        }
        if (flights.contains(flight)) {
            flights.remove(flight);
            Flight.delete(flight);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null){
            throw new IllegalArgumentException("Name cannot be null");
        }
        if(name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description == null){
            throw new IllegalArgumentException("Description cannot be null");
        }
        if(description.isEmpty()){
            throw new IllegalArgumentException("Description cannot be empty");
        }
        this.description = description;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
