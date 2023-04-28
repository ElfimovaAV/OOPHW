package seminar1;

public class Chocolate extends Product{

    String kind;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Chocolate(String name, double price, String kind){
        super(name, price);
        this.kind = kind;
    }

    @Override
    public String displayInfo() {
        return String.format("%s - %s - %s - %f", name, brand, kind, price);
    }
}
