package multiaspect;

public class Radiant extends Fraction{
    private int heal;

    public Radiant(int heal) {
        this.heal = heal;
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    @Override
    public String toString() {
        return "Radiant{" +
                "heal=" + heal +
                '}';
    }
}
