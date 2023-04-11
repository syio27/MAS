package disjoint;

import multi_inheritance.Weapon;

public class Skeleton extends Mob{

    private Weapon weapon;

    public Skeleton(int hitPoint, double damage, Weapon weapon) {
        super(hitPoint, damage);
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Skeleton{" +
                "weapon=" + weapon +
                '}';
    }
}
