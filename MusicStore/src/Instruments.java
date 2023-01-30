import java.util.ArrayList;

public abstract class Instruments {
    private double price;
    private String brand;
    private String model;
    private Status state;

    enum Status {
        stock,
        display
    }
    public Instruments() {}

    public Instruments(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.state = Status.stock;
    }
    public Instruments(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.state = Status.stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Status getState() {
        return state;
    }

    public void putInStock() {
        this.state = Status.stock;
    }

    public void exhibit() {
        this.state = Status.display;
    }

    public String toString() {
        return "[ Instruments |" + " price=" + price +
                "| brand='" + brand + ' ' +
                "| model='" + model + ' ' +
                "| state=" + state + ' ';
    }
}