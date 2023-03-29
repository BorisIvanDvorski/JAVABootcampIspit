import java.util.Scanner;
import java.util.logging.LogManager;

public class Main {
    public static void main(String[] args) {
        LogManager.getLogManager().reset();

        Scanner scanner = new Scanner(System.in);
        VehicleManagerImpl manager = new VehicleManagerImpl();
        boolean working = true;
        try{
            while (working) {
                System.out.print("\nVehicle Fleet Management System\n--------------------------------------\n1. Add a vehicle to the fleet\n2. Search for vehicles by manufacturer or model\n3. Print all vehicles in the fleet\n4. Delete a vehicle from the fleet\n5. Quit\nEnter command: ");
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.print("\nWhat type of vehicle would you like to add?\nEnter 'car' or 'truck': ");
                        String option2 = scanner.next();
                        if(option2.equalsIgnoreCase("car") || option2.equalsIgnoreCase("truck")){
                            System.out.print("Enter manufacturer: ");
                            String manufacturer = scanner.next();
                            System.out.print("Enter model: ");
                            String model = scanner.next();
                            System.out.print("Enter year: ");
                            int year = scanner.nextInt();
                            System.out.print("Enter color: ");
                            String color = scanner.next();
                            System.out.print("Enter VIN: ");
                            long VIN = scanner.nextLong();
                            System.out.print("Enter fuel type: ");
                            String fuelType = scanner.next();
                            if(option2.equalsIgnoreCase("car")){
                                    System.out.print("Enter number of doors: ");
                                    int numDoors = scanner.nextInt();
                                    System.out.print("Enter body style: ");
                                    String bodyType = scanner.next();
                                    manager.addVehicle(new Car(manufacturer,model,year,color,VIN,fuelType,numDoors,bodyType));
                            }
                            else{
                                    System.out.print("Enter maximum towing capacity: ");
                                    int maxTowingCapacity = scanner.nextInt();
                                    manager.addVehicle(new Truck(manufacturer,model,year,color,VIN,fuelType,maxTowingCapacity));
                            }
                            System.out.println("Vehicle added successfully.");
                            break;
                        }
                        else {
                            VehLogger.logInfo("Invalid user input in case 1.");
                            System.out.println("Invalid input!");
                        }
                        break;
                    case 2:
                        System.out.print("\nWhat would you like to search by?\nEnter 'manufacturer','model' or 'VIN': ");
                        option2 = scanner.next();
                        switch(option2){
                            case "manufacturer":
                                System.out.print("Enter manufacturer: ");
                                String manufacturer = scanner.next();
                                manager.searchVehicleManufacturer(manufacturer);
                                break;
                            case "model":
                                System.out.print("Enter model: ");
                                String model = scanner.next();
                                manager.searchVehicleModel(model);
                                break;
                            case "VIN":
                                System.out.print("Enter VIN: ");
                                long VIN = scanner.nextLong();
                                manager.searchVehicleVIN(VIN);
                                break;
                            default:
                                VehLogger.logInfo("Invalid user input in case 2.");
                                System.out.println("Invalid input!");
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("\nAll vehicles in the fleet:");
                        manager.printOutVehicles();
                        break;
                    case 4:
                        System.out.print("\nEnter VIN: ");
                        long VIN = scanner.nextLong();
                        manager.removeVehicle(VIN);
                        System.out.println("Deleted vehicle with VIN "+VIN+".");
                        break;
                    case 5:
                        VehLogger.logInfo("Program closed.");
                        working=false;
                        break;
                    default:
                        VehLogger.logInfo("Invalid user input in main menu.");
                        System.out.println("Invalid input!");
                        break;
                }
            }
        }
        catch (Exception exception){
            VehLogger.logError(exception);
            System.out.println(exception);
        }
    }
}
