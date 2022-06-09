package multi_inheritance;

public class SpiderJockey extends Skeleton implements WildSpiderInterface{
    private int webNumber;

    public SpiderJockey(int hitPoints, double damage, double expForKill, Weapon weapon, int webNumber) {
        super(hitPoints, damage, expForKill, weapon);
        setWebNumber(webNumber);
    }

    @Override
    public int getWebNumber() {
        return 0;
    }

    @Override
    public void setWebNumber(int webNumber) {
        if(webNumber < 0){
            throw new IllegalArgumentException("Web Number cannot less than 0");
        }
        this.webNumber = webNumber;
    }
}
