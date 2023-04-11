package multi_inheritance;

public class Skeleton extends Mob{
    private Weapon weapon;

    public Skeleton(int hitPoints, double damage, double expForKill, Weapon weapon) {
        super(hitPoints, damage, expForKill);
        setWeapon(weapon);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        if(weapon == null){
            throw new IllegalArgumentException("Weapon cannot be null");
        }
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Skeleton{" +
                "weapon=" + weapon +
                '}';
    }
}
