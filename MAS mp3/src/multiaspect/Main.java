package multiaspect;

public class Main {
    public static void main(String[] args) {
        //Multi-aspect inheritance implemented with composition
        //Fraction class is a part of whole Dragon
        //Depending on fraction of dragon, we would like to store some abilities of dragon
        //Radiant, Dire is a Fraction
        Fraction radiant = new Radiant(200);
        Dragon woodDragon = new WoodDragon(500, 100, 250, radiant);
    }
}
