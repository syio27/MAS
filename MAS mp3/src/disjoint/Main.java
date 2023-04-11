package disjoint;

import multi_inheritance.Weapon;

public class Main {
    public static void main(String[] args) {
        // Zombie is a subclass of a superclass Mob with its own attribute type of zombie
        Mob zombie = new Zombie(100, 20, Type.CHEMICAL);
        // Dragon is a subclass of a superclass Mob with attribute age describing the age of particular dragon
        Mob dragon = new Dragon(1500, 200, 435);
        // Skeleton is a subclass of a superclass Mob with its own attribute Weapon describes the type of weapon skeleton holds
        Mob skeleton = new Skeleton(50, 100, Weapon.SWORD);
    }
}
