public class Car extends Vehicle {

    public Car(String manufacturer, String model, int year, String color, long VIN, String fuelType, int numDoors, String bodyType) {
        super(manufacturer, model, year, color, VIN, fuelType);
        setNumDoors(numDoors);
        setBodyType(bodyType);
    }

    @Override
    public String displayVehicle(){
        return super.displayVehicle()+String.format(" numDoors=%d, bodyType='%s')",getNumDoors(),getBodyType());
    }
    public void setNumDoors(int numDoors) {
        if(numDoors>0&&numDoors<7){
            this.numDoors = numDoors;
        }
        else {
            throw new IllegalArgumentException("Number of doors cannot be less than 1 or more than 6!");
        }
    }
    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }
    public int getNumDoors() {
        return numDoors;
    }
    public String getBodyType() {
        return bodyType;
    }

    private int numDoors;
    private String bodyType;
}