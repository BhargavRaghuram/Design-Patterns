package creational.prototype.ugly;

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

class BikeConfigService {
    // BAD: shallow copy — lists are SHARED
    public BikeConfig copyForColor(BikeConfig base, String newColor) {
        BikeConfig c = new BikeConfig(base.model, newColor);
        c.accessories = base.accessories; // shared reference 
        c.tags = base.tags;               // shared reference 
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

        // Mutate the copy
        copy.accessories.add("Phone Mount");
        copy.tags.add("Sale-2026");

        // Surprise! Base got mutated too (because of shared lists)
        System.out.println(base.accessories); // [Bell, Phone Mount]
        System.out.println(base.tags);        // [Urban, Sale-2026] 
    }
}



//Expected 
//         base:      {
//             model : "StreetRider",
//             color : "Red",
//             accessories : ["Bell"], 
//             tags : ["Urban"]        
//         }