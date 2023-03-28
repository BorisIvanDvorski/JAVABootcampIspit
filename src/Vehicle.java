public abstract class Vehicle {
    public Vehicle(String manufacturer, String model, int year, String color, long VIN, String fuelType) {
        setManufacturer(manufacturer);
        setModel(model);
        setYear(year);
        setColor(color);
        setVIN(VIN);
        setFuelType(fuelType);
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setYear(int year) {
        if(1886>year&&year<2024){
            this.year = year;
        }
        else {
            throw new IllegalArgumentException("Year must be between 1886 and 2024.");
        }
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setVIN(long VIN) {
        this.VIN = VIN;
    }
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public String getColor() {
        return color;
    }
    public long getVIN() {
        return VIN;
    }
    public String getFuelType() {
        return fuelType;
    }

    private String manufacturer;
    private String model;
    private int year;
    private String color;
    private long VIN;
    private String fuelType;
}
