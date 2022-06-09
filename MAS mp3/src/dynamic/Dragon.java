package dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dragon extends Mob {

    private List<String> attackTypes = new ArrayList<>();

    public Dragon(int hitPoint, double damage, List<String> attackTypes) {
        super(hitPoint, damage);
        setAttackTypes(attackTypes);
    }
    public Dragon(Mob mob, List<String> attackTypes) {
        super(mob.getHitPoint(), mob.getDamage());
        setAttackTypes(attackTypes);
    }

    private void setAttackTypes(List<String> attackTypes) {
        attackTypes.add("fireBall");
        attackTypes.add("tailBlow");
        attackTypes.add("fireLaser");
        this.attackTypes = attackTypes;
    }

    public List<String> getAttackTypes() {
        return attackTypes;
    }

    @Override
    public double doDamage() {
        Random random = new Random();
        int minAttack = 1;
        int maxAttack = 4;
        double totalDamage = 0;
        int attackSeria = random.nextInt(maxAttack - minAttack) + minAttack;
        for(int i=0; i<attackSeria; i++){
            System.out.println(attackTypes.get(random.nextInt(attackTypes.size())));
            switch (attackTypes.get(random.nextInt(attackTypes.size()))) {
                case "fireBall" -> totalDamage += getDamage() * 2;
                case "tailBlow" -> totalDamage += getDamage();
                case "fireLaser" -> totalDamage += getDamage() * 10;
            };
        }
        return totalDamage;
    }
}
