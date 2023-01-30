public abstract class ElectronicPercussion extends Percussions implements HasSound{
    ElectronicPercussion() {}

    ElectronicPercussion(String brand, String model, double price, double diameter, Material material) {
        super(brand, model, price, diameter, material);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
