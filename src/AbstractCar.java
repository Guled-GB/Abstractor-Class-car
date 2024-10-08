package w7.d1;

public class AbstractCar {
    public static void main(String[] args) {
        Car car1 = new FourDoorToyotaTester("RXc76", 2020, 50000, 200);
        car1.run();
        System.out.println(car1.toString());
        System.out.println("Selling Price: $" + car1.sell());

        System.out.println("-----------------------");

        Car car2 = new TwoDoorToyotaTester("GX80-2", 2019, 60000, 180);
        car2.accident();
        car2.repair();
        car2.run();
        System.out.println(car2);
        System.out.println("Selling Price: $" + car2.sell());
    }
}

class FourDoorToyotaTester extends FourDoorToyota {
    public FourDoorToyotaTester(String carName, int year, int mileage, int power) {
        super(carName, year, mileage, power);
    }
}

class TwoDoorToyotaTester extends TwoDoorToyota {
    public TwoDoorToyotaTester(String carName, int year, int mileage, int power) {
        super(carName, year, mileage, power);
    }
}

interface Car {
    void run();
    void accident();
    void repair();
    void stop();

    // New sell method to calculate the selling price
    double sell();
}

abstract class FourDoorCar implements Car {
    String carName;
    int numOfDoors;
    double maxSpeed;
    double currentSpeed;
    boolean isWorking;
    int year;
    int mileage;
    int power;

    public FourDoorCar(String carName, double carMaxSpeed, int year, int mileage, int power) {
        this.carName = carName;
        this.numOfDoors = 4;
        this.maxSpeed = carMaxSpeed;
        this.currentSpeed = 0;
        this.isWorking = true;
        this.year = year;
        this.mileage = mileage;
        this.power = power;
    }

    @Override
    public void run() {
        if (isWorking) {
            System.out.println(carName + " is running");
            currentSpeed = maxSpeed;
        } else {
            System.out.println(carName + " can't run, needs repairs");
        }
    }

    @Override
    public void stop() {
        System.out.println(carName + " is stopping");
        currentSpeed = 0;
    }

    @Override
    public void repair() {
        System.out.println(carName + " is being repaired");
        isWorking = true;
    }

    @Override
    public void accident() {
        System.out.println(carName + " got into an accident");
        stop();
        isWorking = false;
    }

    @Override
    public String toString() {
        return "Car name: " + carName + ", Number of doors: " + numOfDoors + "\n\tCar max speed: " + maxSpeed
                + ", Car current speed: " + currentSpeed + "\n\tIs car OK: " + (isWorking ? "Yes" : "No");
    }

    // Implementation of the sell method
    @Override
    public double sell() {
        int currentYear = 2024;
        int age = currentYear - year;
        double basePrice = 20000;
        double price = basePrice - (age * 1000) - (mileage * 0.05) + (power * 10);
        return Math.max(price, 2000); // Ensuring a minimum price of $2000
    }
}

abstract class FourDoorToyota extends FourDoorCar {
    String smartTVModel;

    public FourDoorToyota(String carName, int year, int mileage, int power) {
        super(carName, 1700, year, mileage, power);
        this.smartTVModel = "SM-4k-2022";
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tSmart TV Model: " + smartTVModel;
    }
}

abstract class TwoDoorCar implements Car {
    String carName;
    int numOfDoors;
    double maxSpeed;
    double currentSpeed;
    boolean isWorking;
    int year;
    int mileage;
    int power;

    public TwoDoorCar(String carName, double carMaxSpeed, int year, int mileage, int power) {
        this.carName = carName;
        this.numOfDoors = 2;
        this.maxSpeed = carMaxSpeed;
        this.currentSpeed = 0;
        this.isWorking = true;
        this.year = year;
        this.mileage = mileage;
        this.power = power;
    }

    @Override
    public void run() {
        if (isWorking) {
            System.out.println(carName + " is running");
            currentSpeed = maxSpeed;
        } else {
            System.out.println(carName + " can't run, needs repairs");
        }
    }

    @Override
    public void stop() {
        System.out.println(carName + " is stopping");
        currentSpeed = 0;
    }

    @Override
    public void repair() {
        System.out.println(carName + " is being repaired");
        isWorking = true;
    }

    @Override
    public void accident() {
        System.out.println(carName + " got into an accident");
        stop();
        isWorking = false;
    }

    @Override
    public String toString() {
        return "Car name: " + carName + ", Number of doors: " + numOfDoors + "\n\tCar max speed: " + maxSpeed
                + ", Car current speed: " + currentSpeed + "\n\tIs car OK: " + (isWorking ? "Yes" : "No");
    }

    // Implementation of the sell method
    @Override
    public double sell() {
        int currentYear = 2024;
        int age = currentYear - year;
        double basePrice = 15000;
        double price = basePrice - (age * 800) - (mileage * 0.05) + (power * 8);
        return Math.max(price, 1500); // Ensuring a minimum price of $1500
    }
}

abstract class TwoDoorToyota extends TwoDoorCar {
    String miniChargerModel;

    public TwoDoorToyota(String carName, int year, int mileage, int power) {
        super(carName, 980, year, mileage, power);
        this.miniChargerModel = "SM-4k-2022";
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tMini charger model: " + miniChargerModel;
    }
}
