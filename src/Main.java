import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.LogManager;

public class Main {
    public static void main(String[] args) {
        LogManager.getLogManager().reset(); //reset LogManager-a tako da se logovi ne ispisuju na konzolu, već isključivo u logs.log.

        Scanner scanner = new Scanner(System.in);
        VehicleManagerImpl manager = new VehicleManagerImpl();

        /**
         * Glavni program sustava upravitelja flote vozila.
         */
        boolean working = true;
        while (working) {
            try {
                System.out.print("\nVehicle Fleet Management System\n--------------------------------------\n1. Add a vehicle to the fleet\n2. Search for vehicles by manufacturer or model\n3. Print all vehicles in the fleet\n4. Delete a vehicle from the fleet\n5. Quit\nEnter command: ");
                String option = scanner.next();
                String option2;
                switch (option.toLowerCase()) {
                    case "1","add vehicle":
                        do {
                            System.out.print("\nWhat type of vehicle would you like to add?\n1. Car\n2. Truck\nEnter command: ");
                            option2 = scanner.next();
                            switch (option2.toLowerCase()) {
                                case "1", "car":
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
                                    System.out.print("Enter number of doors: ");
                                    int numDoors = scanner.nextInt();
                                    System.out.print("Enter body style: ");
                                    String bodyType = scanner.next();
                                    manager.addVehicle(new Car(manufacturer, model, year, color, VIN, fuelType, numDoors, bodyType));
                                    break;
                                case "2", "truck":
                                    System.out.print("Enter manufacturer: ");
                                    manufacturer = scanner.next();
                                    System.out.print("Enter model: ");
                                    model = scanner.next();
                                    System.out.print("Enter year: ");
                                    year = scanner.nextInt();
                                    System.out.print("Enter color: ");
                                    color = scanner.next();
                                    System.out.print("Enter VIN: ");
                                    VIN = scanner.nextLong();
                                    System.out.print("Enter fuel type: ");
                                    fuelType = scanner.next();
                                    System.out.print("Enter maximum towing capacity: ");
                                    int maxTowingCapacity = scanner.nextInt();
                                    manager.addVehicle(new Truck(manufacturer, model, year, color, VIN, fuelType, maxTowingCapacity));
                                    break;
                                default:
                                    manager.infoThrough("Invalid user input in case 1.");
                                    System.out.println("Invalid input! Enter '1','2','car' or 'truck'!");
                            }
                        }
                            while (!option2.equals("1") && !option2.equalsIgnoreCase("car") && !option2.equals("2") && !option2.equalsIgnoreCase("truck"));
                        break;
                    case "2","search":
                        System.out.print("\nWhat would you like to search by?\n1. Manufacturer\n2. Model\n3. VIN\nEnter command: ");
                        option2 = scanner.next();
                        switch (option2.toLowerCase()) {
                            case "1","manufacturer":
                                System.out.print("Enter manufacturer: ");
                                String manufacturer = scanner.next();
                                manager.searchVehicleManufacturer(manufacturer);
                                break;
                            case "2","model":
                                System.out.print("Enter model: ");
                                String model = scanner.next();
                                manager.searchVehicleModel(model);
                                break;
                            case "3","vin":
                                System.out.print("Enter VIN: ");
                                long VIN = scanner.nextLong();
                                manager.searchVehicleVIN(VIN);
                                break;
                            default:
                                manager.infoThrough("Invalid user input in case 2.");
                                System.out.println("Invalid input!");
                                break;
                        }
                        break;
                    case "3","print":
                        System.out.println("\nAll vehicles in the fleet: ");
                        manager.printOutVehicles();
                        break;
                    case "4","delete":
                        System.out.print("\nEnter VIN: ");
                        long VIN = scanner.nextLong();
                        manager.removeVehicle(VIN);
                        System.out.println("Deleted vehicle with VIN " + VIN + ".");
                        break;
                    case "5","quit":
                        manager.infoThrough("Program closed.");
                        working = false;
                        break;
                    default:
                        manager.infoThrough("Invalid user input in main menu.");
                        System.out.println("Invalid input!");
                        break;
                    }
            }
            /**
             * Hvatanje iznimke u slučaju kada korisnik proslijedi krivi tip podatka.
             */
            catch (InputMismatchException e) {
                System.out.println("Invalid input type!");
                manager.errorThrough(e);
                scanner.next();
            }
            /**
             * Hvatanje iznimke u slučaju kada korisnik proslijedi argument izvan određenih granica.
             */
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                manager.errorThrough(e);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}