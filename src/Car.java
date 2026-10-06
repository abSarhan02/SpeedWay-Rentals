public class Car {

    // Basic info about the car
    private String model;
    private String brand;
    private int id;
    private int year;
    private double pricePerDay;
    private boolean available;

    // Keep track of how many cars are created
    private static int carCount = 0;
    private static final double TAX_RATE = 0.14;


    public Car(int id, String brand, String model, int year, double pricePerDay) {
        this.model = model;
        this.brand = brand;
        this.id = id;
        this.year = year;
        this.pricePerDay = pricePerDay;

        // Every new car is available by default
        this.available = true;

        carCount++;
    }


    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public static int getCarCount() {
        return carCount;
    }
    
    public static double getTaxRate() {
        return TAX_RATE;
    }
}
