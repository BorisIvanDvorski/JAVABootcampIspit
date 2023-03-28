public class Truck extends Vehicle{
    public Truck(String manufacturer, String model, int year, String color, long VIN, String fuelType, int maxPayload) {
        super(manufacturer, model, year, color, VIN, fuelType);
        setMaxPayload(maxPayload);
    }

    @Override
    public String displayVehicle(){
        return super.displayVehicle()+String.format(" maxPayload=%d)",getMaxPayload());
    }
    public void setMaxPayload(int maxPayload) {
        if(maxPayload>=0){
            this.maxPayload = maxPayload;
        }
        else {
            throw new IllegalArgumentException("Payload cannot be less than 0!");
        }
    }
    public int getMaxPayload() {
        return maxPayload;
    }

    private int maxPayload;
}
