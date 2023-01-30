public abstract class Percussions extends Instruments {
    private double diameter;
    private Material material;
    public enum Material {
        Wood, Metal, Plastic
    }

    Percussions() {}

    Percussions(String brand, String model, double price, double diameter, Material material) {
        super(brand, model, price);
        this.diameter = diameter;
        this.material = material;
    }

    public double getDiameter() {
        return diameter;
    }

    public Material getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return super.toString() + "| Percussion " +
                "| diameter=" + diameter +
                "| material=" + material +
                " ";
    }
}
