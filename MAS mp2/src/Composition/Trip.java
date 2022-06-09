package Composition;

import java.util.HashSet;
import java.util.Set;

public class Trip {

    public static final Set<Trip> extent = new HashSet<>();

    private String name;
    private String description;

    private Country country;

    public Trip(String name, String description, Country country) {
        setName(name);
        setDescription(description);
        country.addTrip(this);
        extent.add(this);
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

    public Country getCountry() {
        return country;
    }

    private void setCountry(Country country) {
        this.country = country;
    }

    public static void delete(Trip trip){
        extent.remove(trip);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
