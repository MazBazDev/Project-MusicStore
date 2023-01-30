public abstract class KeyboardInstrument extends Instruments{
    private int numberOfKeys;

    KeyboardInstrument() {}

    KeyboardInstrument(String brand, String model, double price, int numberOfKeys) {
        super(brand, model, price);
        this.numberOfKeys = numberOfKeys;
    }
    public int getNumberOfKeys() {
        return numberOfKeys;
    }

    @Override
    public String toString() {
        return super.toString() + "| Keyboard Instrument " +
                "| numberOfKeys=" + numberOfKeys +
                ' ';
    }
}
