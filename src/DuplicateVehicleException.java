public class DuplicateVehicleException extends Exception {
    public DuplicateVehicleException() {
        super("Vehicle with given VIN already exists!");
    }
}
