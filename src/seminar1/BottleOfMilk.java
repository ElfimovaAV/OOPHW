package seminar1;

public class BottleOfMilk extends Product {

    private double fat;

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        if (fat < 0) {
            throw new RuntimeException("Incorrect fat");
        }
        this.fat = fat;
    }

    public BottleOfMilk(String name, double price, double fat){
        super(name, price);
        this.fat = fat;
    }

    @Override
    public String displayInfo() {
        return String.format("%s - %s - %f - %f", name, brand, fat, price);
    }
}
