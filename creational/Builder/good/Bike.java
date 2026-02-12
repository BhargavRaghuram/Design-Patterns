// 1) Immutable main class with private fields  
// 2) Private constructor that takes the Builder  
// 3) Static inner Builder class  
// 4) Fluent methods + build()


class Bike {
    private String model;
    private int gears;
    private boolean carrier;
    private boolean discBrakes;
    private boolean gpsEnabled;
    private String color;


    private Bike(Builder builder) {
        this.model = builder.model;
        this.gears = builder.gears;
        this.carrier = builder.carrier;
        this.discBrakes = builder.discBrakes;
        this.gpsEnabled = builder.gpsEnabled;
        this.color = builder.color;
    }


    public static class Builder{
    private String model;
    private int gears;
    private boolean carrier;
    private boolean discBrakes;
    private boolean gpsEnabled;
    private String color;

    public Builder setModel (String model) {
        this.model = model;
        return this;
    }

    public Builder setGears (int gears) {
        this.gears = gears;
        return this;
    }

    public Builder setCarrier(boolean carrier) {
        this.carrier = carrier;
        return this;
    }

    public Builder setDiscBrakes(boolean discBrakes) {
        this.discBrakes = discBrakes;
        return this;
    }

    public Builder setGpsEnabled(boolean gpsEnabled) {
        this.gpsEnabled = gpsEnabled;
        return this;
    }

    public Builder setColor(String color) {
        this.color = color;
        return this;
    }

    public Bike build() {
        return new Bike(this);
    }
}
}


class Shop {
    Bike buildCustomerBike() {
        // no validations; random values everywhere
        Bike b = new Bike.Builder()
                .setModel("StreetRider")
                .setGears(6)
                .setCarrier(false)
                .setGpsEnabled(false)
                .setColor("Red")
                .build();

        // OOPS: someone turns on GPS later
        // b.gpsEnabled = true; //not possible now    

        // OOPS: someone sets gears to invalid value
        // b.gears = -10;  not possible now

        return b;
    }




}
