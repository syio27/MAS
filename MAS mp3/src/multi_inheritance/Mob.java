package multi_inheritance;

public class Mob {
    private int hitPoints;
    private double damage;
    private double expForKill;

    public Mob(int hitPoints, double damage, double expForKill) {
        setHitPoints(hitPoints);
        setDamage(damage);
        setExpForKill(expForKill);
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        if(hitPoints <= 0){
            throw new IllegalArgumentException("Hit Points cannot be 0 or less than 0");
        }
        this.hitPoints = hitPoints;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        if(damage < 0){
            throw new IllegalArgumentException("Damage cannot be less than 0");
        }
        this.damage = damage;
    }

    public double getExpForKill() {
        return expForKill;
    }

    public void setExpForKill(double expForKill) {
        if(expForKill < 0){
            throw new IllegalArgumentException("Exp for killing mob cannot be less than 0");
        }
        this.expForKill = expForKill;
    }

    @Override
    public String toString() {
        return "Mob{" +
                "hitPoints=" + hitPoints +
                ", damage=" + damage +
                ", expForKill=" + expForKill +
                '}';
    }
}
