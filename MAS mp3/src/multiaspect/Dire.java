package multiaspect;

public class Dire {
    private boolean nightVision;

    public Dire(boolean nightVision) {
        this.nightVision = nightVision;
    }

    public boolean isNightVision() {
        return nightVision;
    }

    public void setNightVision(boolean nightVision) {
        this.nightVision = nightVision;
    }

    @Override
    public String toString() {
        return "Dire{" +
                "nightVision=" + nightVision +
                '}';
    }
}
