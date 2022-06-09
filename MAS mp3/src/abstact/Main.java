package abstact;

import multi_inheritance.Weapon;

public class Main {
    public static void main(String[] args) {
        Mob mobDragon = new Dragon(10, 40);
        Mob mobSkeleton = new Skeleton(3, 10, Weapon.Bow);
        System.out.println(mobDragon.doDamage());
        System.out.println(mobSkeleton.doDamage());

    }
}
