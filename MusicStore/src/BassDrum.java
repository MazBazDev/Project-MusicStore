public class BassDrum extends AcousticPercussions {
    private String sound;

    BassDrum() {}

    BassDrum(String brand, String model, double price, double diameter, Percussions.Material material, String sound) {
        super(brand, model, price, diameter, material);
        this.sound = sound;
    }

    public String PlaySound() {
        return this.sound;
    }

    @Override
    public String toString() {
        return super.toString() + "| BassDrum " +
                "| sound='" + sound + " ]";
    }
}
