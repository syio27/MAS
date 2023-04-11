package dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dragon extends Mob {

    private List<String> attackTypes = new ArrayList<>();
    private int age;

    public Dragon(int hitPoint, double damage, int age) {
        super(hitPoint, damage);
        setAttackTypes(attackTypes);
        setAge(age);
    }
    public Dragon(Mob mob, int age) {
        super(mob.getHitPoint(), mob.getDamage());
        setAttackTypes(attackTypes);
        setAge(age);
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0){
            throw new IllegalArgumentException("Age cannot be less than 0");
        }
        this.age = age;
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

    @Override
    public String toString() {
        return "Dragon{" +
                "attackTypes=" + attackTypes +
                ", age=" + age +
                '}';
    }
}
