import java.util.Scanner;

public class Main {


    static Scanner scanner = new Scanner(System.in);


    static Car[] cars = new Car[20];
    static Customer[] customers = new Customer[20];


    static int carIndex = 0;
    static int customerIndex = 0;


    static double totalIncome = 0;


    public static void main(String[] args) {


        int choice;


        System.out.println("========================================");
        System.out.println("     WELCOME TO SPEEDWAY RENTALS");
        System.out.println("========================================");


        do {


            printMenu();


            choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {


                case 1:
                    addRegularCar();
                    break;


                case 2:
                    addLuxuryCar();
                    break;


                case 3:
                    addCustomer();
                    break;


                case 4:
                    displayAllCars();
                    break;


                case 5:
                    displayAvailableCars();
                    break;


                case 6:
                    rentCar();
                    break;


                case 7:
                    returnCar();
                    break;


                case 8:
                    searchCarById();
                    break;


                case 9:
                    searchCarByBrand();
                    break;


                case 10:
                    displayAllCustomers();
                    break;


                case 0:

                    System.out.println();
                    System.out.println("Goodbye!");
                    System.out.println("Total cars: " + carIndex);
                    System.out.println("Total customers: " + customerIndex);
                    System.out.println("Total income: " + totalIncome);

                    break;


                default:

                    System.out.println("Invalid choice.");

            }


        } while (choice != 0);


        scanner.close();

    }


    public static void printMenu() {


        System.out.println();
        System.out.println("========================================");
        System.out.println("       SPEEDWAY RENTALS SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Add Regular Car");
        System.out.println("2. Add Luxury Car");
        System.out.println("3. Add Customer");
        System.out.println("4. Display All Cars");
        System.out.println("5. Display Available Cars");
        System.out.println("6. Rent a Car");
        System.out.println("7. Return a Car");
        System.out.println("8. Search Car by ID");
        System.out.println("9. Search Car by Brand");
        System.out.println("10. Display All Customers");
        System.out.println("0. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");

    }


    public static boolean carIdExists(int id) {


        for (int i = 0; i < carIndex; i++) {


            if (cars[i].getId() == id) {

                return true;
            }
        }


        return false;
    }


    public static boolean customerIdExists(int id) {


        for (int i = 0; i < customerIndex; i++) {


            if (customers[i].getId() == id) {

                return true;
            }
        }


        return false;
    }


    public static void addRegularCar() {


        System.out.println("\n--- Add Regular Car ---");


        if (carIndex >= 20) {

            System.out.println("Car list is full.");
            return;
        }


        System.out.print("ID: ");
        int id = scanner.nextInt();


        if (carIdExists(id)) {

            System.out.println("Car ID already exists.");
            return;
        }


        scanner.nextLine();


        System.out.print("Brand: ");
        String brand = scanner.nextLine();


        System.out.print("Model: ");
        String model = scanner.nextLine();


        System.out.print("Year: ");
        int year = scanner.nextInt();


        if (year < 1990 || year > 2026) {

            System.out.println("Invalid year.");
            return;
        }


        System.out.print("Price per day: ");
        double price = scanner.nextDouble();


        if (price <= 0) {

            System.out.println("Invalid price.");
            return;
        }


        cars[carIndex] = new Car(id, brand, model, year, price);

        carIndex++;


        System.out.println("Regular car added successfully.");

    }


    public static void addLuxuryCar() {


        System.out.println("\n--- Add Luxury Car ---");


        if (carIndex >= 20) {

            System.out.println("Car list is full.");
            return;
        }


        System.out.print("ID: ");
        int id = scanner.nextInt();


        if (carIdExists(id)) {

            System.out.println("Car ID already exists.");
            return;
        }


        scanner.nextLine();


        System.out.print("Brand: ");
        String brand = scanner.nextLine();


        System.out.print("Model: ");
        String model = scanner.nextLine();


        System.out.print("Year: ");
        int year = scanner.nextInt();


        if (year < 1990 || year > 2026) {

            System.out.println("Invalid year.");
            return;
        }


        System.out.print("Price per day: ");
        double price = scanner.nextDouble();


        if (price <= 0) {

            System.out.println("Invalid price.");
            return;
        }


        System.out.print("Insurance fee: ");
        double insurance = scanner.nextDouble();


        if (insurance < 0) {

            System.out.println("Invalid insurance fee.");
            return;
        }


        cars[carIndex] = new LuxuryCar(id, brand, model, year, price, insurance);


        carIndex++;


        System.out.println("Luxury car added successfully.");

    }


    public static void addCustomer() {


        System.out.println("\n--- Add Customer ---");


        if (customerIndex >= 20) {

            System.out.println("Customer list is full.");
            return;
        }


        System.out.print("ID: ");
        int id = scanner.nextInt();


        if (customerIdExists(id)) {

            System.out.println("Customer ID already exists.");
            return;
        }


        scanner.nextLine();


        System.out.print("Name: ");
        String name = scanner.nextLine();


        System.out.print("Phone: ");
        String phone = scanner.nextLine();


        customers[customerIndex] = new Customer(id, name, phone);


        customerIndex++;


        System.out.println("Customer added successfully.");

    }


    public static void displayAllCars() {


        System.out.println("\n--- All Cars ---");


        if (carIndex == 0) {

            System.out.println("No cars found.");
            return;
        }


        for (int i = 0; i < carIndex; i++) {


            Car c = cars[i];


            System.out.println("ID: " + c.getId() + " | " + c.getBrand() + " " + c.getModel() + " | Available: " + c.isAvailable());

        }

    }


    public static void displayAvailableCars() {


        int count = 0;


        System.out.println("\n--- Available Cars ---");


        for (int i = 0; i < carIndex; i++) {


            if (cars[i].isAvailable()) {


                System.out.println(cars[i].getBrand() + " " + cars[i].getModel());


                count++;
            }

        }


        System.out.println("Total available cars: " + count);

    }


    public static void searchCarById() {


        System.out.print("Car ID: ");

        int id = scanner.nextInt();


        for (int i = 0; i < carIndex; i++) {


            if (cars[i].getId() == id) {


                System.out.println(cars[i].getBrand() + " " + cars[i].getModel());

                return;

            }

        }


        System.out.println("Car not found.");

    }


    public static void searchCarByBrand() {


        scanner.nextLine();


        System.out.print("Brand: ");

        String brand = scanner.nextLine();


        int count = 0;


        for (int i = 0; i < carIndex; i++) {


            if (cars[i].getBrand().equalsIgnoreCase(brand)) {


                System.out.println(cars[i].getBrand() + " " + cars[i].getModel());


                count++;

            }

        }


        if (count == 0) {

            System.out.println("No cars found.");

        } else {

            System.out.println("Matches: " + count);

        }

    }


    public static void rentCar() {

        System.out.println("\n--- Rent a Car ---");


        System.out.print("Customer ID: ");
        int customerId = scanner.nextInt();


        Customer customer = null;


        for (int i = 0; i < customerIndex; i++) {

            if (customers[i].getId() == customerId) {
                customer = customers[i];
                break;
            }
        }


        if (customer == null) {

            System.out.println("Customer not found.");
            return;
        }


        if (customer.getRentedCarId() != -1) {

            System.out.println("Customer already has a car.");
            return;
        }


        System.out.print("Car ID: ");
        int carId = scanner.nextInt();


        Car car = null;


        for (int i = 0; i < carIndex; i++) {

            if (cars[i].getId() == carId) {

                car = cars[i];
                break;
            }
        }


        if (car == null) {

            System.out.println("Car not found.");
            return;
        }


        if (!car.isAvailable()) {

            System.out.println("Car is already rented.");
            return;
        }


        System.out.print("Number of days: ");
        int days = scanner.nextInt();


        if (days <= 0) {

            System.out.println("Days must be greater than zero.");
            return;
        }


        if (car instanceof LuxuryCar) {


            if (days < LuxuryCar.getMinRentalDays()) {

                System.out.println("Luxury car requires minimum 3 days.");

                return;
            }
        }


        double cost = car.getPricePerDay() * days;


        // tax 14%
        cost = cost + (cost * 0.14);


        if (car instanceof LuxuryCar) {


            LuxuryCar luxuryCar = (LuxuryCar) car;


            cost += luxuryCar.getInsuranceFee();

        }


        car.setAvailable(false);


        customer.setRentedCarId(car.getId());

        customer.setRentedDays(days);

        customer.setTotalPaid(customer.getTotalPaid() + cost);


        totalIncome += cost;


        System.out.println("\nRental completed!");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Car: " + car.getBrand() + " " + car.getModel());

        System.out.println("Days: " + days);

        System.out.println("Final cost: " + cost);
    }

    public static void returnCar() {

        System.out.println("\n--- Return a Car ---");


        System.out.print("Customer ID: ");
        int customerId = scanner.nextInt();


        Customer customer = null;


        for (int i = 0; i < customerIndex; i++) {

            if (customers[i].getId() == customerId) {

                customer = customers[i];
                break;
            }
        }


        if (customer == null) {

            System.out.println("Customer not found.");
            return;
        }


        if (customer.getRentedCarId() == -1) {

            System.out.println("Customer has no car.");
            return;
        }


        int carId = customer.getRentedCarId();


        for (int i = 0; i < carIndex; i++) {


            if (cars[i].getId() == carId) {


                cars[i].setAvailable(true);


                System.out.println("Returned: " + cars[i].getBrand() + " " + cars[i].getModel());


                break;
            }
        }


        customer.setRentedCarId(-1);

        customer.setRentedDays(0);

    }

    public static void displayAllCustomers() {


        System.out.println("\n--- Customers List ---");


        if (customerIndex == 0) {

            System.out.println("No customers.");
            return;
        }


        for (int i = 0; i < customerIndex; i++) {


            Customer customer = customers[i];


            System.out.print("ID: " + customer.getId() + " | Name: " + customer.getName());


            if (customer.getRentedCarId() == -1) {


                System.out.println(" | Car: None");


            } else {


                System.out.println(" | Rented Car ID: " + customer.getRentedCarId());

            }
        }
    }

}