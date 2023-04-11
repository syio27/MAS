package dynamic;

public class SkeletonDragon extends Mob {

    private ArmourType armour;

    public SkeletonDragon(int hitPoint, double damage, ArmourType armour) {
        super(hitPoint, damage);
        setArmour(armour);
    }

    public SkeletonDragon(Mob mob, ArmourType armour) {
        super(mob.getHitPoint(), mob.getDamage());
        setArmour(armour);
    }

    public ArmourType getArmour() {
        return armour;
    }

    public void setArmour(ArmourType armour) {
        if(armour == null){
            throw new IllegalArgumentException("Armour cannot be null");
        }
        this.armour = armour;
    }

    @Override
    public double doDamage() {
        return switch (armour) {
            case LEATHER -> getDamage();
            case CHAIN -> getDamage() * 0.5;
            case IRON -> getDamage() * 2;
        };
    }

    @Override
    public String toString() {
        return "SkeletonDragon{" +
                "armour=" + armour +
                '}';
    }
}

