import java.util.Date;

public abstract class StringsInstruments extends Instruments implements Tuneable {
    private int numberOfStrings;
    private WoodType bodyWood;
    private Date lastTuned;

    public enum WoodType {
        Alune, Frene, Maple, Spruce, Ebony
    }

    StringsInstruments() {}

    StringsInstruments(double price, String brand, String model, int numberOfStrings, WoodType bodyWood) {
        super(brand, model, price);
        this.numberOfStrings = numberOfStrings;
        this.bodyWood = bodyWood;
        this.tune();
    }
    public int getNumberOfStrings() {
        return numberOfStrings;
    }

    public WoodType getBodyWood() {
        return bodyWood;
    }

    public Date getLastTuned() {
        return lastTuned;
    }

    public void setLastTuned(Date lastTuned) {
        this.lastTuned = lastTuned;
    }

    public void tune() {
        this.lastTuned = new Date();
    }

    @Override
    public String toString() {
        return super.toString() + " | Amount of strings=" + numberOfStrings + "| body wood=" + bodyWood + "| lastTuned=" + lastTuned + ' ';
    }
}

