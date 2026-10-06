public class LuxuryCar extends Car {

    // Luxury cars must be rented for at least 3 days
    private static final int MIN_RENTAL_DAYS = 3;

    // Extra insurance cost for luxury cars
    private double insuranceFee;

    public LuxuryCar(int id, String brand, String model, int year, double pricePerDay, double insuranceFee) {

        // Use the Car constructor for the common information
        super(id, brand, model, year, pricePerDay);

        this.insuranceFee = insuranceFee;
    }

    public static int getMinRentalDays() {
        return MIN_RENTAL_DAYS;
    }

    public double getInsuranceFee() {
        return insuranceFee;
    }

    public void setInsuranceFee(double insuranceFee) {
        this.insuranceFee = insuranceFee;
    }
}
