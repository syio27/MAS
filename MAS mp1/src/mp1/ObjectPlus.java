package mp1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class ObjectPlus implements Serializable {
    private static final long serialVersionUID = 1L;
    private static Map<Class, ArrayList<ObjectPlus>> extentsCollection = new Hashtable<>();

    public ObjectPlus(){
        ArrayList<ObjectPlus> extent = null;
        Class theClass = this.getClass();

        if(extentsCollection.containsKey(theClass)){
            extent = extentsCollection.get(theClass);
        }
        else{
            extent = new ArrayList<>();
            extentsCollection.put(theClass, extent);
        }

        extent.add(this);
    }

    public static void writeExtents(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extentsCollection);
    }

    public static void readExtents(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        extentsCollection = (Hashtable) stream.readObject();
    }

    public static <T> Iterable<T> getExtent(Class<T> type) throws ClassNotFoundException{
        if(extentsCollection.containsKey(type)){
            return (Iterable<T>) extentsCollection.get(type);
        }

        throw new ClassNotFoundException(
                String.format("%s. Stored extents: %s", type.toString(), extentsCollection.keySet())
        );
    }

    public static void showExtent(Class theClass) throws Exception {
        List<ObjectPlus> extent = null;

        if(extentsCollection.containsKey(theClass)) {
            extent = extentsCollection.get(theClass);
        }
        else {
            throw new Exception("Unknown class " + theClass);
        }
        System.out.println("Extent of the class: " + theClass.getSimpleName());
        for(Object obj : extent) {
            System.out.println(obj + "\n");
        }
    }

    public User findUser(int id) throws ClassNotFoundException {
        Iterable<User> userExtent = ObjectPlus.getExtent(User.class);
        for(var user : userExtent){
            if(user.getId() == id){
                return user;
            }
        }
        throw new ClassNotFoundException();
    }
}
