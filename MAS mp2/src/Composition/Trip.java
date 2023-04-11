package Composition;

public class Trip {

    private String name;
    private String description;

    private Country country;

    public Trip(String name, String description, Country country) {
        setName(name);
        setDescription(description);
        country.addTrip(this);
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

    @Override
    public String toString() {
        return "Trip{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
