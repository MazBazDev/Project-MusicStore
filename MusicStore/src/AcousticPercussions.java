public abstract class AcousticPercussions extends Percussions implements HasSound{
    AcousticPercussions() {}

    AcousticPercussions(String brand, String model, double price, double diameter, Material material) {
        super(brand, model, price, diameter, material);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
