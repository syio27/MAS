package multi_inheritance;

public class Main {
    public static void main(String[] args) {

        //Multi-inheritance implemented through Interface
        //Mob is a superclass
        //Skeleton subclass extends directly from Mob
        //WildSpider implements interface WildSpiderInterface
        //SpiderJockey is a class which has wildSpider and Skeleton characteristics
        //it extends Skeleton and implements wildSpiderInterface
        //SpiderJockey has a number
        Mob skeleton = new Skeleton(50, 100, 3, Weapon.CROSSBOW);
        Mob wildSpider = new WildSpiderImpl(200, 20, 2, 100);
        SpiderJockey spiderJockey = new SpiderJockey(250, 120, 20, Weapon.CROSSBOW, 100, 400, true);
    }
}
