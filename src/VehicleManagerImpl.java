import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Implementacija upravitelja flote vozila.
 */
public class VehicleManagerImpl implements VehicleManager {
    public VehicleManagerImpl() {
        fleet = new ArrayList<>();
        logger = new VehLogger();
    }

    /**
     * Metoda koja dodaje vozilo u flotu.
     * @param vehicle dobiven iz forme u main programu.
     * @throws DuplicateVehicleException u slučaju da vozilo s istim danim VIN-om već postoji.
     */
    @Override
    public void addVehicle(Vehicle vehicle) throws DuplicateVehicleException {
        for (var v : fleet) {
            if (v.getVIN() == vehicle.getVIN()) {
                logger.logError(new DuplicateVehicleException());
                throw new DuplicateVehicleException();
            }
        }
        fleet.add(vehicle);
        logger.logInfo("Added vehicle "+vehicle.getVIN()+".");
    }

    /**
     * Metoda za ispis svih vozila u floti, koja u slućaju da je flota prazna isto govori korisniku.
     */
    @Override
    public void printOutVehicles(){
        if(!fleet.isEmpty()){
            for(var v : fleet){
                System.out.println(v.displayVehicle());
            }
            logger.logInfo("Printed out all vehicles.");
        }
        else {
            System.out.println("Fleet is empty!");
            logger.logInfo("Attempted to print out empty fleet.");
        }
    }

    /**
     * Metoda za brisanje vozila iz flote.
     * @param VIN je VIN kod vozila kojega želimo izbrisati iz flote.
     * @throws NoSuchVehicleException U slučaju da ne postoji vozilo s danim VIN-om.
     */
    @Override
    public void removeVehicle(long VIN) throws NoSuchVehicleException{
        boolean found=false;
        for (Iterator<Vehicle> iterator = fleet.iterator(); iterator.hasNext();) {
            Vehicle vehicle = iterator.next();
            if(vehicle.getVIN()==VIN) {
                iterator.remove();
                logger.logInfo("Removed vehicle with VIN " + VIN + ".");
                found=true;
            }
        }
        if(!found){
            System.out.println("No vehicle with such VIN exists!");
            logger.logError(new NoSuchVehicleException());
            throw new NoSuchVehicleException();
        }
    }

    /**
     * Metoda za pretragu vozila po proizvođaču.
     * @param manufacturer je dani parametar iz main klase koji se traži u floti.
     * @throws NoSuchVehicleException u slučaju da ne postoje vozila s danim proizvođačem.
     */
    @Override
    public void searchVehicleManufacturer(String manufacturer) throws NoSuchVehicleException{
        boolean found=false;
        for(var v : fleet){
            if(v.getManufacturer().equalsIgnoreCase(manufacturer)) {
                System.out.println(v.displayVehicle());
                logger.logInfo("Displayed vehicle with manufacturer name "+manufacturer+".");
                found=true;
            }
        }
        if(!found){
            logger.logError(new NoSuchVehicleException());
            throw new NoSuchVehicleException();
        }
    }

    /**
     * Metoda za pretragu vozila po modelu.
     * @param model je dani parametar iz main klase koji se traži u floti.
     * @throws NoSuchVehicleException u slučaju da ne postoje vozila s danim modelom.
     */
    @Override
    public void searchVehicleModel(String model) throws NoSuchVehicleException{
        boolean found=false;
        for(var v : fleet){
            if(v.getModel().equalsIgnoreCase(model)) {
                System.out.println(v.displayVehicle());
                logger.logInfo("Displayed vehicle with manufacturer name "+model+".");
                found=true;
            }
        }
        if(!found){
            logger.logError(new NoSuchVehicleException());
            throw new NoSuchVehicleException();
        }
    }

    /**
     * Metoda za pretragu vozila po VIN-u.
     * @param VIN je dani parametar iz main klase koji se traži u floti.
     * @throws NoSuchVehicleException u slučaju da ne postoje vozila s danim VIN-om.
     */
    @Override
    public void searchVehicleVIN(long VIN) throws NoSuchVehicleException{
        boolean found=false;
        for(var v : fleet){
                if(v.getVIN()==(VIN)) {
                System.out.println(v.displayVehicle());
                logger.logInfo("Displayed vehicle with manufacturer name "+VIN+".");
                    found=true;
            }
        }
        if(!found){
            logger.logError(new NoSuchVehicleException());
            throw new NoSuchVehicleException();
        }
    }

    /**
     * Metoda koja prosljeđuje informaciju loggeru.
     * @param input je informacija koju želimo prosljediti.
     */
    public void infoThrough(String input){
        logger.logInfo(input);
    }
    /**
     * Metoda koja prosljeđuje iznimku loggeru.
     * @param th je iznimka koja se prosljeđuje.
     */
    public void errorThrough(Throwable th){
        logger.logUnexpected(th);
    }

    private final VehLogger logger;
    private final List<Vehicle> fleet;
}