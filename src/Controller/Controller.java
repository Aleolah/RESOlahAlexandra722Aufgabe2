package Controller;


import Model.*;
import Repository.Repository;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;



/**
 * The `Controller` class is the central component of the application's logic.
 * It is responsible for handling and processing the user's input from the console,
 * coordinating with other parts of the system to perform actions such as adding,
 * removing, and updating entities, and displaying information.
 */
public class Controller {
    Repository<Produkt> produktRepository;
    Repository<Charakter> charaktereRepository;

    public Controller(Repository<Produkt> produktRepository, Repository<Charakter> charaktereRepository) {
        this.produktRepository = produktRepository;
        this.charaktereRepository = charaktereRepository;
    }

    /**
     * Adds a new item.
     */
    public void addProdukt(String name, double price, String universum){
        Produkt p = new Produkt(name, price, universum);
        produktRepository.addItem(p);

    }

    /**
     * Deletes an item
     */
    public void deleteProdukt(String name){
        produktRepository.deleteItem(p -> p.getName().equals(name));
    }

    /**
     * Updates an item
     */
    public void updateProdukt(String oldName, String name, double price, String universum){
        produktRepository.updateItem(p -> p.getName().equals(oldName),new Produkt(name, price, universum));
    }

    /**
     * Displays all items
     */
    public void displayProdukts(){
        ArrayList<Produkt> all = produktRepository.getAllItems();
        for(Produkt entry : all){
            System.out.println(entry);
        }

    }
    /**
     * Adds a new item.
     */

    public void addCharaktere(int id, String name, String region, ArrayList<Produkt>produkte){
        charaktereRepository.addItem(new Charakter(id,name,region,produkte));

    }

    /**
     * Deletes an item
     */
    public void deleteCharaktere(int id){
        charaktereRepository.deleteItem(charaktere -> charaktere.getId() == id);
    }

    /**
     * Updates an item
     */
    public void updateCharakter(int oldId, int id, String name,String region, ArrayList<Produkt>produkte) {
        charaktereRepository.updateItem(charaktere -> charaktere.getId() == oldId, new Charakter(id, name, region, produkte));

    }
    /**
     * Displays all items
     */
    public void displayCharaktere(){
        ArrayList<Charakter> all = charaktereRepository.getAllItems();
        for(Charakter entry : all){
         System.out.println(entry);
        }

    }

    /**
     * Retrieves an item by its name from the repository.
     *
     * @param name the name of the item.
     * @return an {@link Optional} containing the item if found, or an empty {@link Optional}.
     */
    public Optional<Produkt> getProduktByName(String name){
        return produktRepository.findItem(produkt -> produkt.getName().equals(name));
    }

    /**
     * Retrieves an item by its id from the repository.
     *
     * @param id the id of the item.
     * @return an {@link Optional} containing the item if found, or an empty {@link Optional}.
     */
    public Optional<Charakter> getCharaktereById(int id){
        return charaktereRepository.findItem(charaktere -> charaktere.getId() == id);
    }

    public void filterRegion(String region){
        charaktereRepository.getAllItems().stream().filter(p -> p.getRegion().equals(region)).forEach(p-> System.out.println(p.getName()));

    }

    public void filterCharaktere(String universum){
        ArrayList<Charakter> all = charaktereRepository.getAllItems();
        ArrayList<Charakter> filtered = new ArrayList<>();
        for (Charakter entry : all){
            long counted = 0;
            counted = entry.getProdukte().stream().filter(p->p.getUniversum().equals(universum)).count();
            if (counted != 0){
                filtered.add(entry);
            }
        }
        filtered.sort(Comparator.comparing(Charakter::getName));
        for ( Charakter entry : filtered){
            System.out.println(entry.getName());
        }
    }

    /**
     * Prints the list of items for a given entity, sorted by a specified attribute.
     * <p>
     * The method retrieves all entities and filters by the given ID. Depending on the specified mode,
     * it will print the items either in ascending or descending order of the specified attribute.
     *
     * @param name the name of the entity whose items will be printed.
     * @param modus the sorting mode (1 for ascending order, 2 for descending order).
     */
    public void print(String name, int modus) {

        ArrayList<Charakter> all = charaktereRepository.getAllItems();

        for (Charakter entry : all) {
            if (entry.getName().equals(name)) {
                if (modus == 1)
                {
                    entry.getProdukte().stream().sorted(Comparator.comparing(Produkt::getPrice)).forEach(p->System.out.println(p.getName() + "-" + p.getPrice()));
                }
                else if (modus == 2){
                    entry.getProdukte().stream().sorted(Comparator.comparing(Produkt::getPrice).reversed()).forEach(p->System.out.println(p.getName() + "-" + p.getPrice()));
                }

            }
        }


    }

    public void add(){
        // Initialisierung der Produkte
        List<Produkt> produkte = new ArrayList<>();
        produkte.add(new Produkt("Mjolnir", 500.0, "Asgard"));
        produkte.add(new Produkt("Vibranium-Schild", 700.0, "Wakanda"));
        produkte.add(new Produkt("Infinity Gauntlet", 10000.0, "Titan"));
        produkte.add(new Produkt("Web-Shooter", 250.0, "Terra"));
        produkte.add(new Produkt("Arc-Reaktor", 1500.0, "Terra"));
        produkte.add(new Produkt("Norn Stones", 1200.0, "Asgard"));
        produkte.add(new Produkt("Quantum Suit", 3000.0, "Terra"));
        produkte.add(new Produkt("X-Gene Serum", 850.0, "X-Mansion"));
        produkte.add(new Produkt("Cosmic Cube", 9000.0, "Multiverse"));
        produkte.add(new Produkt("Darkhold", 2000.0, "Multiverse"));

        produktRepository.addItem(produkte.get(0));
        produktRepository.addItem(produkte.get(1));
        produktRepository.addItem(produkte.get(2));
        produktRepository.addItem(produkte.get(3));
        produktRepository.addItem(produkte.get(4));
        produktRepository.addItem(produkte.get(5));
        produktRepository.addItem(produkte.get(6));
        produktRepository.addItem(produkte.get(7));
        produktRepository.addItem(produkte.get(8));
        produktRepository.addItem(produkte.get(9));

        // Initialisierung der Charaktere
        List<Charakter> charaktere = new ArrayList<>();


        List<Produkt> produkte1 = new ArrayList<>();
        produkte1.add(produkte.get(0)); // Mjolnir
        produkte1.add(produkte.get(5)); // Norn Stones
        produkte1.add(produkte.get(9)); // Darkhold
        Charakter c1 = new Charakter(1, "Thor", "Asgard", produkte1);

        List<Produkt> produkte2 = new ArrayList<>();
        produkte2.add(produkte.get(1)); // Vibranium-Schild
        produkte2.add(produkte.get(7)); // X-Gene Serum
        Charakter c2 = new Charakter(2, "Black Panther", "Wakanda", produkte2);

        List<Produkt> produkte3 = new ArrayList<>();
        produkte3.add(produkte.get(4)); // Arc-Reaktor
        produkte3.add(produkte.get(6)); // Quantum Suit
        produkte3.add(produkte.get(3)); // Web-Shooter
        Charakter c3 = new Charakter(3, "Iron Man", "Terra",produkte3);

        List<Produkt> produkte4 = new ArrayList<>();
        produkte4.add(produkte.get(3)); // Web-Shooter
        produkte4.add(produkte.get(8)); // Cosmic Cube
        Charakter c4 = new Charakter(4, "Spider-Man", "Terra",produkte4);

        List<Produkt> produkte5 = new ArrayList<>();
        produkte5.add(produkte.get(9)); // Darkhold
        produkte5.add(produkte.get(8)); // Cosmic Cube
        produkte5.add(produkte.get(2)); // Infinity Gauntlet
        Charakter c5 = new Charakter(5, "Doctor Strange", "Multiverse",produkte5);

        charaktere.add(c1);
        charaktere.add(c2);
        charaktere.add(c3);
        charaktere.add(c4);
        charaktere.add(c5);

        charaktereRepository.addItem(c1);
        charaktereRepository.addItem(c2);
        charaktereRepository.addItem(c3);
        charaktereRepository.addItem(c4);
        charaktereRepository.addItem(c5);

    }




}

