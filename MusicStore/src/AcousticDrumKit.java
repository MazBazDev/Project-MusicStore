import java.util.ArrayList;

public class AcousticDrumKit extends DrumKit implements HasSound{
    public ArrayList<AcousticPercussions> percussions;
    private String decoration;

    AcousticDrumKit() {}

    AcousticDrumKit(String brand, String model, double price, Status status, String decoration) {
        super(brand, model, price, status);
        this.decoration = decoration;
        this.percussions = new ArrayList<>();

    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }

    public String getDecoration() {
        return decoration;
    }

    public ArrayList<AcousticPercussions> getPercussions() {
        return percussions;
    }

    public void addPercussion(AcousticPercussions percussion) {
        this.percussions.add(percussion);
    }
    @Override
    public String PlaySound() {
        String temp = "";
        for (AcousticPercussions i: this.percussions) {
            temp += i.PlaySound();
        }
        return temp;
    }

    @Override
    public String toString() {
        return super.toString() + "| AcousticDrumKit " +
                "| percussion=" + getPercussions() +
                "| decoration='" + getDecoration() + " ";
    }
}
