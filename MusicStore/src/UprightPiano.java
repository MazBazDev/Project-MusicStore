import java.util.Date;

public class UprightPiano extends KeyboardInstrument implements Tuneable{
    private double tuningPrice;
    private Date lastTuningDate;
    private hammerWoods hammerWood;

    UprightPiano() {}

    UprightPiano(double price, String brand, String model, int numberOfKeys, double tuningPrice, hammerWoods hammerWood) {
        super(brand, model, price, numberOfKeys);

        this.tuningPrice = tuningPrice;
        this.hammerWood = hammerWood;
        this.lastTuningDate = new Date();
    }
    enum hammerWoods {
        Cedar,
        Mahogany
    }

    public void setTuningPrice(double tuningPrice) {
        this.tuningPrice = tuningPrice;
    }

    public String getTuningPrice() {
        return tuningPrice + "$";
    }

    public hammerWoods getHammerWood() {
        return hammerWood;
    }

    public void setHammerWood(hammerWoods hammerWood) {
        this.hammerWood = hammerWood;
    }

    public Date getLastTuningDate() {
        return lastTuningDate;
    }

    public void setLastTuningDate(Date lastTunningDate) {
        this.lastTuningDate = lastTunningDate;
    }

    @Override
    public void Tune() {
        setLastTuningDate(new Date());
        System.out.println("Tuned for " + this.tuningPrice + "$");
    }

    @Override
    public String toString() {
        return super.toString() + "| Upright Piano " + " | tuningPrice=" + getTuningPrice() +
                "| lastTunningDate=" + getLastTuningDate() +
                "| hammerWood=" + getHammerWood() +
                " ]";
    }
}
