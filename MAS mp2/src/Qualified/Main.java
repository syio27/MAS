package Qualified;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("Kim", "Tae", "qqqqq@q.com", "12345678901"); // id = 1
        Trip trip = new Trip("kz trip", ".........."); // id = 1
        trip.addClient(client); // t 1 -> t 2
        System.out.println(trip.getClients());
        System.out.println(trip.findById(1));

        trip.setNewId(3); // 1 -> 3
        System.out.println(trip.getClients());
        System.out.println(trip.findById(1));
        System.out.println(trip.findById(3));
    }
}
