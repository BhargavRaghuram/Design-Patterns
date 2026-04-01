package creational.prototype.good;

import java.util.ArrayList;
import java.util.List;

class BikeConfig {
    public String model;
    public String color;
    public List<String> accessories = new ArrayList<>(); // mutable!
    public List<String> tags = new ArrayList<>();         // mutable!

    public BikeConfig(String model, String color) {
        this.model = model;
        this.color = color;
    }
}


// Make the prototype of the bike
class BikeConfigService {
    public BikeConfig copyForColor(BikeConfig base, String newColor) {
        BikeConfig c = new BikeConfig(base.model, newColor);
        c.accessories = new ArrayList<String>(base.accessories); 
        c.tags = new ArrayList<String>(base.tags);               
        return c;
    }
}

class Demo {
    public static void main(String[] args) {
        BikeConfig base = new BikeConfig("StreetRider", "Red");
        base.accessories.add("Bell");
        base.tags.add("Urban");



        BikeConfigService svc = new BikeConfigService();
        BikeConfig copy = svc.copyForColor(base, "Blue");


        copy.accessories.add("Phone Mount");
        copy.tags.add("Sale-2026");


        System.out.println(base.accessories); 
        System.out.println(base.tags);


        System.out.println(copy.accessories); 
        System.out.println(copy.tags);

    }
}



//    base:      {
//             model : "StreetRider",
//             color : "Red",
//             accessories : ["Bell", "Phone Mount"], 
//             tags :["Urban", "Sale-2026"]       
//         }


// For the mutable datatypes just use deepcopy or ifb they are immutable use the shallow copy 
// shallow copy - two objects will have the same reference and when u try to update both will be effetced
// deep copy - two objects are independent on each other 
// some times u will be also used to have some hybrid pattern (shallow+deep)