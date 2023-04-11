package Composition;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Country {
    private static int count_id = 0;
    private int id;
    private String name;

    private final Set<Trip> trips = new HashSet<>();

    public Country(String name) {
        count_id++;
        setId(count_id);
        setName(name);
    }

    public void addTrip(Trip trip) {
        if (trip == null) {
            throw new IllegalArgumentException("Trip cannot be null");
        }
        if (!trips.contains(trip)) {
            trips.add(trip);
        }
    }

    public void removeTrip(Trip trip) {
        if (trip == null) {
            throw new IllegalArgumentException("Trip cannot be null");
        }
        if (trips.contains(trip)) {
            trips.remove(trip);
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

    public Set<Trip> getTrips() {
        return Collections.unmodifiableSet(trips);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
