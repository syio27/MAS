package disjoint;

public class Dragon extends Mob{

    private int age;

    public Dragon(int hitPoint, double damage, int age) {
        super(hitPoint, damage);
        this.age = age;
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
                "age=" + age +
                '}';
    }
}
