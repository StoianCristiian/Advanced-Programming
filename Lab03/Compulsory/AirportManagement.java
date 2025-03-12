public class AirportManagement {
    public static void main(String[] args) {
        Aircraft[] aircraftArray = {
            new Airliner("Boeing 737", "737-800", "N12345", 180),
            new Freighter("CargoMaster", "CM-200", "F67890", 5000),
            new Drone("SkyCourier", "SC-100", "D56789", 200, 120),
            new Airliner("Airbus A320", "A320-200", "N54321", 150),
            new Freighter("HeavyLifter", "HL-300", "F11223", 8000)
        };

        int cargoCount = 0;
        for (Aircraft aircraft : aircraftArray) {
            if (aircraft instanceof CargoCapable) {
                cargoCount++;
            }
        }
    }
}
