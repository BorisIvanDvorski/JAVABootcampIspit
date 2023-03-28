public class Truck extends Vehicle{
    public Truck(String manufacturer, String model, int year, String color, long VIN, String fuelType, int maxTowingCapacity) {
        super(manufacturer, model, year, color, VIN, fuelType);
        setMaxTowingCapacity(maxTowingCapacity);
    }

    @Override
    public String displayVehicle(){
        return super.displayVehicle()+String.format(" maxTowingCapacity=%d)",getMaxTowingCapacity());
    }
    public void setMaxTowingCapacity(int maxTowingCapacity) {
        if(maxTowingCapacity>=0){
            this.maxTowingCapacity = maxTowingCapacity;
        }
        else {
            throw new IllegalArgumentException("TowingCapacity cannot be less than 0!");
        }
    }
    public int getMaxTowingCapacity() {
        return maxTowingCapacity;
    }

    private int maxTowingCapacity;
}
