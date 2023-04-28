package seminar1;

import java.util.List;

public class VendingMachine {
    private final List<Product> products;

    public VendingMachine(List<Product> products) {
        this.products = products;
    }

    public BottleOfWater getBottleOfWater(String name, double volume){
        for (Product product: products) {
            if (product instanceof BottleOfWater){
                BottleOfWater bottle = ((BottleOfWater)product);
                if (bottle.name.equals(name) && bottle.getVolume() == volume)
                    return bottle;
            }
        }
        return null;
    }

    public BottleOfMilk getBottleOfMilk (String name, double fat){
        for (Product product: products) {
            if (product instanceof BottleOfMilk){
                BottleOfMilk bottle = ((BottleOfMilk)product);
                if (bottle.name.equals(name) && bottle.getFat() == fat)
                    return bottle;
            }
        }
        return null;
    }

    public Chocolate getChocolate(String name, String kind){
        for (Product product: products) {
            if (product instanceof Chocolate){
                Chocolate bar = ((Chocolate)product);
                if (bar.name.equals(name) && bar.kind.equals(kind))
                    return bar;
            }
        }
        return null;
    }
}
