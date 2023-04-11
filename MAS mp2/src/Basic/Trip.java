package Basic;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Trip {
    private static final Set<Trip> extent = new HashSet<>();

    private static int count_id = 0;
    private int id;
    private String name;
    private String description;

    // basic
    private final Set<Country> countries = new HashSet<>();

    public Trip(String name, String description) {
        count_id++;
        setId(count_id);
        setName(name);
        setDescription(description);
        extent.add(this);
    }

    public void addCountry(Country country) {
        if (country == null) {
            throw new IllegalArgumentException("Country cannot be null");
        }
        if (!countries.contains(country)) {
            countries.add(country);
            country.addTrip(this);
        }
    }

    public void removeCountry(Country country) {
        if (country == null) {
            throw new IllegalArgumentException("Country cannot be null");
        }
        if (countries.contains(country)) {
            countries.remove(country);
            country.removeTrip(this);
        }
    }


    public Set<Country> getCountries() {
        return Collections.unmodifiableSet(countries);
    }

    public static Set<Trip> getExtent() {
        return Collections.unmodifiableSet(extent);
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

    public static void delete(Trip trip){
        Set<Country> countriesTemp = Set.copyOf(trip.countries);
        trip.countries.clear();
        countriesTemp.forEach(country -> country.removeTrip(trip));

        extent.remove(trip);
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
