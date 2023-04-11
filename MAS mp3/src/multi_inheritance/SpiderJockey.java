package multi_inheritance;

public class SpiderJockey extends Skeleton implements WildSpiderInterface{
    private int webNumber;
    private int attackRange;
    private boolean wallClimbing;

    public SpiderJockey(int hitPoints, double damage, double expForKill, Weapon weapon, int webNumber, int attackRange, boolean wallClimbing) {
        super(hitPoints, damage, expForKill, weapon);
        setWebNumber(webNumber);
        setAttackRange(attackRange);
        setWallClimbing(wallClimbing);
    }

    @Override
    public int getWebNumber() {
        return webNumber;
    }

    @Override
    public void setWebNumber(int webNumber) {
        if(webNumber < 0){
            throw new IllegalArgumentException("Web Number cannot less than 0");
        }
        this.webNumber = webNumber;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        if(attackRange < 0){
            throw new IllegalArgumentException("Attack range cannot be less than 0");
        }
        this.attackRange = attackRange;
    }

    public boolean isWallClimbing() {
        return wallClimbing;
    }

    public void setWallClimbing(boolean wallClimbing) {
        this.wallClimbing = wallClimbing;
    }
}
