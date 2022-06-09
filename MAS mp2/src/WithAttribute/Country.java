package WithAttribute;

import Basic.Trip;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Country {
    private final Set<Flight> flights = new HashSet<>();

    private static int count_id = 0;
    private int id;
    private String name;

    public Country(String name) {
        count_id++;
        setId(count_id);
        setName(name);
    }


    public void addFlight(Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException("Flight cannot be null");
        }
        if(flight.getCountry() != this){
            throw new IllegalArgumentException("Country is not related to this flight");
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

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
