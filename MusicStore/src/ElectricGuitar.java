import java.util.Date;

public class ElectricGuitar extends StringsInstruments {
    private MicroType microType;
    private TuneType tuneType;

    public enum TuneType {
        Classic, OpenG, DropD
    }
    public enum MicroType {
        Fender, Gibson, SeymourDuncan
    }

    ElectricGuitar() {};

    ElectricGuitar(double price, String brand, String model, int numberOfStrings, WoodType bodyWood, MicroType microType, TuneType tuneType) {
        super(price, brand, model, numberOfStrings, bodyWood);
        this.microType = microType;
        this.tuneType = tuneType;
    }

    public MicroType getMicroType() {
        return microType;
    }

    public void setMicroType(MicroType microType) {
        this.microType = microType;
    }

    public TuneType getTuneType() {
        return tuneType;
    }

    public void setTuneType(TuneType tuneType) {
        this.tuneType = tuneType;
    }

    @Override
    public void Tune() {
        super.tune();
    }

    @Override
    public String toString() {
        return super.toString() +
                "| microType=" + microType +
                "| tuneType=" + tuneType + " ]";
    }
}
