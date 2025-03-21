public class Freighter extends Aircraft implements CargoCapable {
    private final int maxPayload;

    public Freighter(String name, String model, String tailNumber, int maxPayload) {
        super(name, model, tailNumber);
        this.maxPayload = maxPayload;
    }

    @Override
    public int getMaxPayload() {
        return maxPayload;
    }
}