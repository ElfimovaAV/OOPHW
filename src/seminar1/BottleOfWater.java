package seminar1;

public class BottleOfWater extends Product {

    private double volume;

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        if (volume < 0.33){
            throw new RuntimeException("Incorrect volume");
        }
        this.volume = volume;
    }

    public BottleOfWater(String name, double price, double volume){
        super(name, price);
        this.volume = volume;
    }

    @Override
    public String displayInfo() {
        return String.format("%s - %s - %f - %f", name, brand, volume, price);
    }
}
