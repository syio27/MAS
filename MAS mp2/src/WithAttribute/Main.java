package WithAttribute;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Country country = new Country("Poland");
        Trip trip = new Trip("pl trip", "...........");
        Flight flight = new Flight(LocalDate.now(), LocalDate.MAX,150 , country, trip);
        System.out.println(flight.getTrip() + " " + flight.getCountry());
    }
}
