package Basic;

public class Main {
    public static void main(String[] args) {
        Country country = new Country("Kazakhstan");
        Trip trip = new Trip("kz trip", ".........");
        country.addTrip(trip);
        System.out.println(country.getTrips());
        System.out.println(trip.getCountries());

        Country country2 = new Country("Poland");
        Trip trip2 = new Trip("pl trip", ".........");
        country2.addTrip(trip2);
        System.out.println(country2.getTrips());
        System.out.println(trip2.getCountries());

        Country country3 = new Country("Poland");
        Trip trip3 = new Trip("pl1 trip", ".........");
        Trip trip4 = new Trip("pl2 trip", ".........");
        Trip trip5 = new Trip("pl3 trip", ".........");
        Trip trip6 = new Trip("pl4 trip", ".........");
        country3.addTrip(trip3);
        country3.addTrip(trip4);
        country3.addTrip(trip5);
        country3.addTrip(trip6);
        System.out.println(country3.getTrips());
        System.out.println(trip3.getCountries());
    }
}
