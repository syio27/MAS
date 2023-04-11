package utility;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.*;


public abstract class ObjectPlusPlus extends ObjectPlus implements Serializable {

    private Map<String, Map<Object, ObjectPlusPlus>> links = new Hashtable<>();
    private static Set<ObjectPlusPlus> allParts = new HashSet<>();

    public ObjectPlusPlus() {
        super();
    }
    private void addLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject, Object qualifier, int counter) {
        Map<Object, ObjectPlusPlus> objectLinks;

        if(counter < 1) {
            return;
        }

        if(links.containsKey(roleName)) {
            objectLinks = links.get(roleName);
        }
        else {
            objectLinks = new HashMap<>();
            links.put(roleName, objectLinks);
        }

        if(!objectLinks.containsKey(qualifier)) {
            objectLinks.put(qualifier, targetObject);

            targetObject.addLink(reverseRoleName, roleName, this, this, counter - 1);
        }
    }

    public void addLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject, Object qualifier) {
        addLink(roleName, reverseRoleName, targetObject, qualifier, 2);
    }

    public void addLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject) {
        addLink(roleName, reverseRoleName, targetObject, targetObject);
    }

    public void addPart(String roleName, String reverseRoleName, ObjectPlusPlus partObject) throws Exception {
        if(allParts.contains(partObject)) {
            throw new Exception("The part is already connected to a whole!");
        }

        addLink(roleName, reverseRoleName, partObject);

        allParts.add(partObject);
    }

    public ObjectPlusPlus[] getLinks(String role) throws Exception {
        Map<Object, ObjectPlusPlus> objectLinks;

        if(!links.containsKey(role)) {
            throw new Exception("No links for the role: " + role);
        }

        objectLinks = links.get(role);

        return (ObjectPlusPlus[]) objectLinks.values().toArray(new ObjectPlusPlus[0]);
    }

    public void showLinks(String role, PrintStream stream) throws Exception {
        Map<Object, ObjectPlusPlus> objectLinks;

        if(!links.containsKey(role)) {
            throw new Exception("No links for the role: " + role);
        }

        objectLinks = links.get(role);

        Collection col = objectLinks.values();

        stream.println(this.getClass().getSimpleName() + " links, role '" + role + "':");

        for(Object obj : col) {
            stream.println("   " + obj);
        }
    }

    public ObjectPlusPlus getLinkedObject(String role, Object qualifier) throws Exception {
        Map<Object, ObjectPlusPlus> objectLinks;

        if(!links.containsKey(role)) {
            throw new Exception("No links for the role: " + role);
        }

        objectLinks = links.get(role);
        if(!objectLinks.containsKey(qualifier)) {
            throw new Exception("No link for the qualifer: " + qualifier);
        }

        return objectLinks.get(qualifier);
    }

    public boolean anyLink(String role) {
        if(!links.containsKey(role)) {
            return false;
        }

        Map<Object, ObjectPlusPlus> links = this.links.get(role);
        return links.size() > 0;
    }

    public boolean isLink(String role, ObjectPlusPlus targetObject) {
        Map<Object, ObjectPlusPlus> objectLink;

        if(!links.containsKey(role)) {
            return false;
        }

        objectLink = links.get(role);

        return objectLink.containsValue(targetObject);
    }
}
