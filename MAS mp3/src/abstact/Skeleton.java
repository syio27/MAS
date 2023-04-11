package abstact;

import multi_inheritance.Weapon;

public class Skeleton extends Mob{

    private Weapon weapon;

    public Skeleton(int hitPoint, double damage, Weapon weapon) {
        super(hitPoint, damage);
        setWeapon(weapon);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public double doDamage() {
        return switch (weapon) {
            case BOW -> getDamage();
            case SWORD -> getDamage() * 0.5;
            case CROSSBOW -> getDamage() * 2;
        };
    }

    @Override
    public String toString() {
        return "Skeleton{" +
                "weapon=" + weapon +
                '}';
    }
}
