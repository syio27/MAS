package Qualified;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("Kim", "Tae", "qqqqq@q.com", "12345678901");
        Trip trip = new Trip("kz trip", "..........");
        trip.addClient(client);
        System.out.println(trip.getClients());
        System.out.println(trip.findById(1));
    }
}
