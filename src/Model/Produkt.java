package Model;

public class Produkt {
    private String name;
    private double price;
    private String universum;

    public Produkt(String name, double price, String universum) {
        this.name = name;
        this.price = price;
        this.universum = universum;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", universum='" + universum + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setUniversum(String universum) {
        this.universum = universum;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getUniversum() {
        return universum;
    }
}
