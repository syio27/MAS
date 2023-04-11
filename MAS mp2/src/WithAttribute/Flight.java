package WithAttribute;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Flight {
    private static final Set<Flight> extent = new HashSet<>();

    private LocalDate dateTo;
    private LocalDate dateFrom;
    private int maxPeople;

    private Country country;
    private Trip trip;

    public Flight(LocalDate dateTo, LocalDate dateFrom, int maxPeople, Country country, Trip trip) {
        exists(country, trip);
        setDateTo(dateTo);
        setDateFrom(dateFrom);
        setMaxPeople(maxPeople);
        setCountry(country);
        setTrip(trip);
        extent.add(this);
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        if(dateFrom == null){
            throw new IllegalArgumentException("DateFrom cannot be null");
        }
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        if(dateTo == null){
            throw new IllegalArgumentException("DateTo cannot be null");
        }
        this.dateTo = dateTo;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public Country getCountry() {
        return country;
    }

    private void setCountry(Country country) {
        if(country == null){
            throw new IllegalArgumentException("Country cannot be null");
        }
        this.country = country;
    }

    public Trip getTrip() {
        return trip;
    }

    private void setTrip(Trip trip) {
        if(trip == null){
            throw new IllegalArgumentException("Trip cannot be null");
        }
        this.trip = trip;
    }

    private static void exists(Country country, Trip trip){
        if (extent.stream().anyMatch(flight ->
                flight.getCountry().equals(country) && flight.getTrip().equals(trip))) {
            throw new IllegalArgumentException("This trip " + trip.getName() + " to " +  country.getName() + " country already exists");
        }
    }

    public static void delete(Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException("flight cannot not be null");
        }
        flight.country.removeFlight(flight);
        flight.trip.removeFlight(flight);
        extent.remove(flight);
    }
}
