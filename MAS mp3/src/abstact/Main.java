package abstact;

import multi_inheritance.Weapon;

public class Main {
    public static void main(String[] args) {
        Mob dragon = new Dragon(10, 40); //dragon subclass of abstract class mob
        Mob skeleton = new Skeleton(3, 10, Weapon.BOW); //skeleton subclass of abstract class mob
        // polymorphic call of methods of overriden methods
        // method doDamage of class dragon implements logic of dealing damage with seria attack of dragon with its attack types (skills)
        System.out.println(dragon.doDamage());
        // method doDamage of class skeleton deals damage with particular weapon, each weapon has its own damage stat
        System.out.println(skeleton.doDamage());
    }
}
