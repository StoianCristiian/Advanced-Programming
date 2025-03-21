public class Drone extends Aircraft implements CargoCapable {
    private final int maxPayload;
    private final int batteryLife;

    public Drone(String name, String model, String tailNumber, int maxPayload, int batteryLife) {
        super(name, model, tailNumber);
        this.maxPayload = maxPayload;
        this.batteryLife = batteryLife;
    }

    public int getBatteryLife() { return this.batteryLife; }

    @Override
    public int getMaxPayload() {
        return maxPayload;
    }
}