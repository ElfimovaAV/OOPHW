package seminar1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product bottleOfWater1 = new BottleOfWater("Drink", 50, 0.33);
        Product bottleOfWater2 = new BottleOfWater("Drink", 70, 0.5);
        Product bottleOfWater3 = new BottleOfWater("Fresh", 55, 0.3);
        Product bottleOfWater4 = new BottleOfWater("Fresh", 75, 0.5);
        Product bottleOfMilk1 = new BottleOfMilk("White lake", 100, 2.5);
        Product bottleOfMilk2 = new BottleOfMilk("White lake", 120, 3.2);
        Product bottleOfMilk3 = new BottleOfMilk("Tashlinskoye", 110, 2.5);
        Product bottleOfMilk4 = new BottleOfMilk("Tashlinskoye", 130, 3.2);
        Product chocolate1 = new Chocolate("AlpenGold", 49, "milk");
        Product chocolate2 = new Chocolate("AlpenGold", 59, "dark");
        Product chocolate3 = new Chocolate("AlpenGold", 69, "bitter");

        List<Product> products = new ArrayList<>();
        products.add(bottleOfWater1);
        products.add(bottleOfWater2);
        products.add(bottleOfWater3);
        products.add(bottleOfWater4);
        products.add(bottleOfMilk1);
        products.add(bottleOfMilk2);
        products.add(bottleOfMilk3);
        products.add(bottleOfMilk4);
        products.add(chocolate1);
        products.add(chocolate2);
        products.add(chocolate3);

        VendingMachine vendingMachine = new VendingMachine(products);

        BottleOfWater bottleOfWaterRes = vendingMachine.getBottleOfWater("Fresh", 0.5);
        if (bottleOfWaterRes != null){
            System.out.println("You bought: ");
            System.out.println(bottleOfWaterRes.displayInfo());
        }
        else {
            System.out.println("There is no such water bottle in the vending machine.");
        }

        BottleOfMilk bottleOMilkRes = vendingMachine.getBottleOfMilk("White lake", 3.2);
        if (bottleOMilkRes != null){
            System.out.println("You bought: ");
            System.out.println(bottleOMilkRes.displayInfo());
        }
        else {
            System.out.println("There is no such milk bottle in the vending machine.");
        }

        Chocolate chocolateRes = vendingMachine.getChocolate("AlpenGold", "white");
        if (chocolateRes != null){
            System.out.println("You bought: ");
            System.out.println(chocolateRes.displayInfo());
        }
        else {
            System.out.println("There is no such chocolate bar in the vending machine.");
        }
    }
}