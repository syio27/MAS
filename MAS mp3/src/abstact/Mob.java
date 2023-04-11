package abstact;

public abstract class Mob {
    private int hitPoint;
    private double damage;

    public Mob(int hitPoint, double damage) {
        super();
        this.hitPoint = hitPoint;
        this.damage = damage;
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

    public abstract double doDamage();
}
