public abstract class DrumKit extends Instruments {
    private Status status;

    DrumKit() {}

    DrumKit(String brand, String model, double price, Status status) {
        super(brand, model, price);
        this.status = status;
    }
    enum Status {
        Mounted, Unmounted
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void mount() {
        this.status = Status.Mounted;
    }

    public void unMount() {
        this.status = Status.Unmounted;
    }

    @Override
    public String toString() {
        return super.toString() + "| DrumKit" +
                " | status=" + getStatus() +
                " ";
    }
}
