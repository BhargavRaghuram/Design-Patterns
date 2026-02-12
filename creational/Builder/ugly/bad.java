
class Bike {
    // everything public -> can be changed anytime
    public String model;
    public int gears;
    public boolean carrier;
    public boolean discBrakes;
    public boolean gpsEnabled;
    public String color;

    // ugly telescoping constructor
    public Bike(String model, int gears, boolean carrier, boolean discBrakes, boolean gpsEnabled, String color) {
        this.model = model;
        this.gears = gears;
        this.carrier = carrier;
        this.discBrakes = discBrakes;
        this.gpsEnabled = gpsEnabled;
        this.color = color;
    }
}



class Shop {
    Bike buildCustomerBike() {
        // no validations; random values everywhere
        Bike b = new Bike("StreetRider", 6, false, false, false, "Red");

        // OOPS: someone turns on GPS later
        b.gpsEnabled = true;

        // OOPS: someone sets gears to invalid value
        b.gears = -10;

        return b;
    }
}


