import java.util.ArrayList;

public class ElectronicDrumKit extends DrumKit implements HasSound{
    private ArrayList<ElectronicPercussion> percussions;
    private String decoration;

    ElectronicDrumKit() {}

    ElectronicDrumKit(String brand, String model, double price, Status status, String decoration) {
        super(brand, model, price, status);
        this.decoration = decoration;
        this.percussions = new ArrayList<ElectronicPercussion>();
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }

    public String getDecoration() {
        return decoration;
    }

    public ArrayList<ElectronicPercussion> getPercussions() {
        return percussions;
    }

    public void addPercussion(ElectronicPercussion percussion) {
        this.percussions.add(percussion);
    }
    @Override
    public String PlaySound() {
        String temp = "";
        for (ElectronicPercussion i: this.percussions) {
            temp += i.PlaySound();
        }
        return temp;
    }

    @Override
    public String toString() {
        return super.toString() + " | ElectronicDrumKit |" +
                "| percussions=" + percussions +
                "| decoration='" + decoration + " ]";
    }
}
