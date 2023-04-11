package Composition;

public class Main {
    public static void main(String[] args) {
        Country country = new Country("Kazakhstan");
        Trip trip = new Trip("kz trip", "...........", country);
        System.out.println(country.getTrips());
        country.removeTrip(trip);
        System.out.println(country.getTrips());
    }
}
