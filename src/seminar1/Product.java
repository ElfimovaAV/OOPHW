package seminar1;

public class Product {
    protected String name;
    protected String brand;
    protected double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new RuntimeException("Incorrect price");
        }
        this.price = price;
    }

    public Product(String name, String brand, double price) {
        if (name.length() < 3) {
            this.name = "Product";
        } else {
            this.name = name;
        }

        if (brand.length() < 3) {
            this.brand = "Nobrand";
        } else {
            this.brand = brand;
        }
        if (price <= 0) {
            throw new RuntimeException("Incorrect price");
        } else {
            this.price = price;
        }
    }

    public Product(String name, double price) {
        this(name, "Nobrand", price);
    }

    public Product(String name) {
        this(name, 1);
    }

    public Product() {
        this("Продукт");
    }

    /**
     * Получить информацию по продукту
     *
     * @return Информация по продукту
     */
    public String displayInfo() {
        return String.format("%s - %s - %f", name, brand, price);
    }
}
