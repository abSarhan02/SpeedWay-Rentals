public class LuxuryCar  extends Car{

    private static final int MIN_RENTAL_DAYS = 3;
    private double insuranceFee;

 public LuxuryCar (int id, String brand, String model, int year, double pricePerDay, double insuranceFee){
     super(id, brand,model, year,pricePerDay);
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
