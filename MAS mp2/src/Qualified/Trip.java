package Qualified;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Trip {
    private static int count_id = 0;
    private int id;
    private String name;
    private String description;

    private Map<Integer, Client> clients = new TreeMap<>();

    public Trip(String name, String description) {
        count_id++;
        setId(count_id);
        setName(name);
        setDescription(description);
    }

    public void addClient(Client client){
        if(client == null){
            throw new IllegalArgumentException("Client cannot be null");
        }
        if(!clients.containsKey(client.getId())){
            clients.put(client.getId(), client);
            client.addTrip(this);
        }
    }

    public void removeClient(Client client){
        if(client == null){
            throw new IllegalArgumentException("Client cannot be null");
        }
        if(clients.containsKey(client.getId())){
            clients.remove(client.getId());
            client.removeTrip(this);
        }
    }

    public Client findById(Integer id){
        if(id == null){
            throw new IllegalArgumentException("Id cannot be null");
        }
        if(!clients.containsKey(id)){
            throw new IllegalArgumentException("Client with such id doesnt exist");
        }
        return clients.get(id);
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

    public Map<Integer, Client> getClients() {
        return Collections.unmodifiableMap(clients);
    }

    private void setClients(Map<Integer, Client> clients) {
        this.clients = clients;
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
