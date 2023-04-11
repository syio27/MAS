package multiaspect;

public abstract class Dragon {
    private int damage;
    private int hitPoint;
    private int age;
    private Fraction fraction;
    public Dragon(int damage, int hitPoint, int age, Fraction fraction) {
        this.damage = damage;
        this.hitPoint = hitPoint;
        this.age = age;
        setFraction(fraction);
    }

    public Fraction getFraction() {
        return fraction;
    }

    public void setFraction(Fraction fraction) {
        if (fraction == null){
            throw new IllegalArgumentException("Fraction cannot be null");
        }
        this.fraction = fraction;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dragon{" +
                "damage=" + damage +
                ", hitPoint=" + hitPoint +
                ", age=" + age +
                '}';
    }
}
