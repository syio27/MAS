package dynamic;

import java.util.HashSet;
import java.util.Set;

public abstract class Mob {
    private static final Set<Mob> extent = new HashSet<>();
    private int hitPoint;
    private double damage;

    public Mob(int hitPoint, double damage) {
        super();
        this.hitPoint = hitPoint;
        this.damage = damage;
        extent.add(this);
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public static void delete(Mob mob){
        if(mob == null){
            throw new IllegalArgumentException("mob cannot not be null");
        }
        extent.remove(mob);
    }
    public abstract double doDamage();
}
