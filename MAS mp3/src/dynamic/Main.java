package dynamic;

import multi_inheritance.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        Mob m1 = new Dragon(10,40, stringList);
        System.out.println(m1.doDamage());
        Mob m2 = new Skeleton(m1, Weapon.Sword);
        System.out.println(m2.doDamage());
    }
}
