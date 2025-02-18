package Controller;


import Model.*;
import Repository.Repository;

import java.util.ArrayList;
import java.util.Comparator;
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
    public void addProdukt(String name, int price, String universum){
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
    public void updateProdukt(String oldName, String name, int price, String universum){
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
//
//    public void filterCharaktere(String region){
//        ArrayList<Charaktere> all = charaktereRepository.getAllItems();
//        for (Charaktere entry : all){
//            long counted = 0;
//            counted = entry.getProdukte().stream().filter(p->p.getHerRegion().equals(region)).count();
//            if (counted != 0){
//                System.out.println(entry);
//            }
//        }
//    }
//
//    /**
//     * Prints the list of items for a given entity, sorted by a specified attribute.
//     * <p>
//     * The method retrieves all entities and filters by the given ID. Depending on the specified mode,
//     * it will print the items either in ascending or descending order of the specified attribute.
//     *
//     * @param id the ID of the entity whose items will be printed.
//     * @param modus the sorting mode (1 for ascending order, 2 for descending order).
//     */
//    public void print(int id, int modus) {
//
//        ArrayList<Charaktere> all = charaktereRepository.getAllItems();
//
//        for (Charaktere entry : all) {
//            if (entry.getId() == id) {
//                if (modus == 1)
//                {
//                    entry.getProdukte().stream().sorted(Comparator.comparing(Produkt::getPrice)).forEach(System.out::println);
//                }
//                else if (modus == 2){
//                    entry.getProdukte().stream().sorted(Comparator.comparing(Produkt::getPrice).reversed()).forEach(System.out::println);
//                }
//
//            }
//        }
//
//
//    }
//
//    public void add(){
//        Produkt p1 = new Produkt("masa", 12, "Cluj");
//        Produkt p2 = new Produkt("dulap", 80, "Cluj");
//        Produkt p3 = new Produkt("vaza", 3, "Timisoara");
//        Produkt p4 = new Produkt("carte", 25, "Bucuresti");
//        Produkt p5 = new Produkt("scaun", 45, "Cluj");
//        Produkt p6 = new Produkt("lampa", 15, "Iasi");
//        ArrayList<Produkt> produkts = new ArrayList<>();
//        produkts.add(p1);
//        produkts.add(p2);
//        produkts.add(p3);
//        ArrayList<Produkt> produkts2 = new ArrayList<>();
//        produkts2.add(p4);
//        produkts2.add(p1);
//
//        Charaktere c1 = new Charaktere(1,"Ana","Romania",produkts);
//        Charaktere c2 = new Charaktere(2,"Maia","Romania",produkts2);
//        Charaktere c3 = new Charaktere(3,"Mia","Olanda",produkts);
//        produktRepository.addItem(p1);
//        produktRepository.addItem(p2);
//        produktRepository.addItem(p3);
//        produktRepository.addItem(p4);
//        produktRepository.addItem(p5);
//        produktRepository.addItem(p6);
//
//        charaktereRepository.addItem(c1);
//        charaktereRepository.addItem(c2);
//        charaktereRepository.addItem(c3);
//
//    }




}

