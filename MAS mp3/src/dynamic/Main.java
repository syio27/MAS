package dynamic;

import multi_inheritance.Weapon;

public class Main {
    public static void main(String[] args) {
        //Dynamic inheritance achieved by coping the previous object data
        Mob dragon = new Dragon(10,40, 500);
        System.out.println(dragon);
        //dragon object created and then the its copied to skeletonDraton object
        Mob skeletonDragon = new SkeletonDragon(dragon, ArmourType.CHAIN);
        System.out.println(skeletonDragon.getHitPoint());
    }
}
