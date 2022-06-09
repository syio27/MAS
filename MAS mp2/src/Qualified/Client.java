package Qualified;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Client {
    private static int count_id = 0;
    private int id;
    private String firstName, lastName;
    private String email;
    private String telephone;

    private final Set<Trip> trips = new HashSet<>();

    public Client(String firstName, String lastName, String email, String telephone) {
        count_id++;
        setId(count_id);
        setFirstName(firstName);
        setLastName(lastName);
        setTelephone(telephone);
        setEmail(email);
    }

    public void addTrip(Trip trip) {
        if (trip == null) {
            throw new IllegalArgumentException("Trip cannot be null");
        }
        if (!trips.contains(trip)) {
            trips.add(trip);
            trip.addClient(this);
        }
    }

    public void removeTrip(Trip trip) {
        if (trip == null) {
            throw new IllegalArgumentException("Trip cannot be null");
        }
        if (trips.contains(trip)) {
            trips.remove(trip);
            trip.removeClient(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null){
            throw new IllegalArgumentException("FirstName cannot be null");
        }
        if(firstName.isEmpty()){
            throw new IllegalArgumentException("FirstName cannot be empty");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null){
            throw new IllegalArgumentException("LastName cannot be null");
        }
        if(lastName.isEmpty()){
            throw new IllegalArgumentException("LastName cannot be empty");
        }
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email == null){
            throw new IllegalArgumentException("Email cannot be null");
        }
        if(email.isEmpty()){
            throw new IllegalArgumentException("Email cannot be empty");
        }
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public Set<Trip> getTrips() {
        return Collections.unmodifiableSet(trips);
    }

    public void setTelephone(String telephone) {
        if(telephone == null){
            throw new IllegalArgumentException("Telephone cannot be null");
        }
        if(telephone.isEmpty()){
            throw new IllegalArgumentException("Telephone cannot be empty");
        }
        if(telephone.length() != 11){
            throw new IllegalArgumentException("Telephone is not valid");
        }
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
