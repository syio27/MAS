package disjoint;

public class Zombie extends Mob{
    private Type typeOfZombie;

    public Zombie(int hitPoint, double damage, Type typeOfZombie) {
        super(hitPoint, damage);
        this.typeOfZombie = typeOfZombie;
    }

    public Type getTypeOfZombie() {
        return typeOfZombie;
    }

    public void setTypeOfZombie(Type typeOfZombie) {
        this.typeOfZombie = typeOfZombie;
    }

    @Override
    public String toString() {
        return "Zombie{" +
                "typeOfZombie=" + typeOfZombie +
                '}';
    }
}
