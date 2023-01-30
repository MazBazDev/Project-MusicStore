public class ArrangerKeyboards extends KeyboardInstrument{
    private int soundsAmount;

    ArrangerKeyboards() {}

    ArrangerKeyboards(double price, String brand, String model,  int numberOfKeys, int soundsAmount) {
        super(brand, model, price, numberOfKeys);
        this.soundsAmount = soundsAmount;
    }

    public int getSoundsAmount() {
        return soundsAmount;
    }

    @Override
    public String toString() {
        return super.toString() + " | ArrangerKeyboards " +
                "| soundsAmount=" + getSoundsAmount() + " ]";
    }
}
