package Model;

import java.util.List;

public class Charakter {
    private int id;
    private String name;
    private String region;
    private List<Produkt> produkte;

    public Charakter(int id, String name, String region, List<Produkt> produkte) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.produkte = produkte;
    }

    @Override
    public String toString() {
        return "Charakter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", produkte=" + produkte +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public List<Produkt> getProdukte() {
        return produkte;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setProdukte(List<Produkt> produkte) {
        this.produkte = produkte;
    }
}
