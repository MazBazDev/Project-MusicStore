public class Violin extends StringsInstruments implements Tuneable{
    private BowWood bowWood;

    Violin() {};

    Violin(double price, String brand, String model, int numberOfStrings, WoodType bodyWood, BowWood bowWood) {
        super(price, brand, model, numberOfStrings, bodyWood);
        this.bowWood = bowWood;
    }
    public enum BowWood {
        FiberGlass,
        Carbon,
        Massaranduba,
    }

    public BowWood getBowWood() {
        return bowWood;
    }

    public void setBowWood(BowWood bowWood) {
        this.bowWood = bowWood;
    }

    @Override
    public void Tune() {
        super.tune();
    }

    @Override
    public String toString() {
        return super.toString() + "Violin | " + "Bow wood =" + getBowWood() + "]" ;
    }
}
