package multi_inheritance;

public class WildSpiderImpl extends Mob implements WildSpiderInterface {
    private int webNumber;

    public WildSpiderImpl(int hitPoints, double damage, double expForKill, int webNumber) {
        super(hitPoints, damage, expForKill);
        setWebNumber(webNumber);
    }

    @Override
    public int getWebNumber() {
        return webNumber;
    }

    @Override
    public void setWebNumber(int webNumber) {
        if(webNumber < 0){
            throw new IllegalArgumentException("Web number cannot be less than 0");
        }
        this.webNumber = webNumber;
    }

    @Override
    public String toString() {
        return "WildSpiderImpl{" +
                "webNumber=" + webNumber +
                '}';
    }
}
