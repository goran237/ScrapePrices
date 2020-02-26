package car;

import java.util.HashMap;
import java.util.Map;

public class SingleAd {

    private Integer price;
    private Integer year;
    private Integer mileage;
    private FuelType fuelType;
    private Integer cubicCapacity;
    private Integer horsepower;
    private Gearbox gearbox;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getCubicCapacity() {
        return cubicCapacity;
    }

    public void setCubicCapacity(Integer cubicCapacity) {
        this.cubicCapacity = cubicCapacity;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    public Gearbox getGearbox() {
        return gearbox;
    }

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    @Override
    public String toString() {
        return this.price + "," + this.year + "," + this.mileage + "," + this.fuelType + "," + this.cubicCapacity + "," + this.horsepower + "," + gearbox;
    }

    public enum FuelType {
        PETROL("Benzin"),
        DIESEL("Dizel");
        private String fuel;

        FuelType(String fuel) {
            this.fuel = fuel;
        }

        public String getFuel() {
            return fuel;
        }

        private static final Map<String, FuelType> lookup = new HashMap<>();

        static {
            for (FuelType fuel : FuelType.values()) {
                lookup.put(fuel.getFuel(), fuel);
            }
        }

        public static FuelType get(String fuel) {
            return lookup.get(fuel);
        }
    }

    public enum Gearbox {
        MANUAL("Manuelni"),
        AUTOMATIC("Automatski");

        private final String gearbox;

        Gearbox(String gearbox) {
            this.gearbox = gearbox;
        }

        public String getGearbox() {
            return gearbox;
        }

        private static final Map<String, Gearbox> lookup = new HashMap<>();

        static {
            for (Gearbox gearbox : Gearbox.values()) {
                lookup.put(gearbox.getGearbox(), gearbox);
            }
        }

        public static Gearbox get(String gearbox) {
            return lookup.get(gearbox);
        }
    }
}


