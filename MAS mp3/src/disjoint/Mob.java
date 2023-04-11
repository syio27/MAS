package disjoint;

public class Mob {
    private int hitPoint;
    private double damage;

    public Mob(int hitPoint, double damage) {
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

    @Override
    public String toString() {
        return "Mob{" +
                "hitPoint=" + hitPoint +
                ", damage=" + damage +
                '}';
    }
}
