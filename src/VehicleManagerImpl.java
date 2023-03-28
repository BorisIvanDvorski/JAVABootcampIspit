import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class VehicleManagerImpl implements VehicleManager {
    public VehicleManagerImpl() {
        fleet = new ArrayList<>();
    }

    @Override
    public void addVehicle(Vehicle vehicle) throws DuplicateVehicleException {
        for (var v : fleet) {
            if (v.getVIN() == vehicle.getVIN()) {
                VehLogger.logError(new DuplicateVehicleException());
                throw new DuplicateVehicleException();
            }
        }
        fleet.add(vehicle);
        VehLogger.logInfo("Added vehicle "+vehicle.getVIN()+".");
    }
    @Override
    public void printOutVehicles(){
        for(var v : fleet){
            System.out.println(v.displayVehicle());
        }
        VehLogger.logInfo("Printed out all vehicles.");
    }
    @Override
    public void removeVehicle(long VIN) throws NoSuchVehicleException{
        boolean found=false;
        for (Iterator<Vehicle> iterator = fleet.iterator(); iterator.hasNext();) {
            Vehicle vehicle = iterator.next();
            if(vehicle.getVIN()==VIN) {
                iterator.remove();
                VehLogger.logInfo("Removed vehicle with VIN " + VIN + ".");
                found=true;
            }
        }
        if(!found){
            VehLogger.logError(new NoSuchVehicleException());
            throw new NoSuchVehicleException();
        }
    }
    @Override
    public void searchVehicleManufacturer(String manufacturer) throws NoSuchVehicleException{
        boolean found=false;
        for(var v : fleet){
            if(v.getManufacturer().equalsIgnoreCase(manufacturer)) {
                System.out.println(v.displayVehicle());
                VehLogger.logInfo("Displayed vehicle with manufacturer name "+manufacturer+".");
                found=true;
            }
        }
        if(!found){
            VehLogger.logError(new NoSuchVehicleException());
            throw new NoSuchVehicleException();
        }
    }
    @Override
    public void searchVehicleModel(String model) throws NoSuchVehicleException{
        boolean found=false;
        for(var v : fleet){
            if(v.getModel().equalsIgnoreCase(model)) {
                System.out.println(v.displayVehicle());
                VehLogger.logInfo("Displayed vehicle with manufacturer name "+model+".");
                found=true;
            }
        }
        if(!found){
            VehLogger.logError(new NoSuchVehicleException());
            throw new NoSuchVehicleException();
        }
    }
    @Override
    public void searchVehicleVIN(long VIN) throws NoSuchVehicleException{
        boolean found=false;
        for(var v : fleet){
                if(v.getVIN()==(VIN)) {
                System.out.println(v.displayVehicle());
                VehLogger.logInfo("Displayed vehicle with manufacturer name "+VIN+".");
                    found=true;
            }
        }
        if(!found){
            VehLogger.logError(new NoSuchVehicleException());
            throw new NoSuchVehicleException();
        }
    }

    private List<Vehicle> fleet;
}