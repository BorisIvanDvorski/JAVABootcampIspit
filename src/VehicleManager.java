import java.util.List;

public interface VehicleManager {
    void addVehicle(Vehicle vehicle) throws DuplicateVehicleException;
    void printOutVehicles();
    void removeVehicle(long VIN) throws NoSuchVehicleException;
    void searchVehicleManufacturer(String manufacturer) throws NoSuchVehicleException;
    void searchVehicleModel(String model) throws NoSuchVehicleException;
    void searchVehicleVIN(long VIN) throws NoSuchVehicleException;

}
