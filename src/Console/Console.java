package Console;

import Controller.Controller;
import Model.Produkt;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

/**
 * This class provides a console-based user interface to interact with the application's controller.
 * The user can perform various operations based on the provided menu options.
 */
public class Console {
    public Controller controller;

    /**
     * Constructor that initializes the `Console` with the provided `Controller` instance.
     *
     * @param controller The controller that handles the business logic for the application.
     */
    public Console(Controller controller) {
        this.controller = controller;
    }

    /**
     * Displays the available menu options for the user. The menu lists the available operations that can be performed
     * on the entities managed by the application.
     */
    public void meniu() {
        System.out.println("Menü");
        System.out.println("1. Produkt hinzufügen");
        System.out.println("2. Produkt löschen");
        System.out.println("3. Produkt aktualisieren");
        System.out.println("4. Ein Produkt anzeigen");
        System.out.println("5. Alle Produkte anzeigen");

        System.out.println("6. Charakter hinzufügen");
        System.out.println("7. Charakter löschen");
        System.out.println("8. Charakter aktualisieren");
        System.out.println("9. Ein Charakter anzeigen");
        System.out.println("10. Alle Charaktere anzeigen");

        System.out.println("11. Charaktere nach Region filtern");
        System.out.println("12. Charaktere nach Universum des Produkts filtern");
        System.out.println("13. Produkte einer Charakter sortieren nach Preis ");
        System.out.println("14. Exit");

    }

    /**
     * Runs the console application, displaying the menu and processing user input for the various operations.
     * The user can interact with the application to perform the available actions.
     */
    public void run() {
        //controller.add();
        Scanner sc = new Scanner(System.in);
        boolean continueloop = true;
        while (continueloop) {
            meniu();
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Geben sie ein Name:");
                    String name = sc.next();
                    System.out.println("Geben sie ein Preis:");
                    int preis = sc.nextInt();
                    System.out.println("Geben sie ein universum:");
                    String universum = sc.next();
                    controller.addProdukt(name, preis, universum);
                    break;
                case 2:
                    System.out.println("Geben sie ein Name:");
                    controller.deleteProdukt(sc.next());
                    break;
                case 3:
                    System.out.println("Geben sie ein Name:");
                    String oldName = sc.next();
                    System.out.println("Geben sie ein Name:");
                    String name2 = sc.next();
                    System.out.println("Geben sie ein Preis:");
                    int preis2 = sc.nextInt();
                    System.out.println("Geben sie ein Universum:");
                    String region2 = sc.next();
                    controller.updateProdukt(oldName,name2,preis2,region2);
                    break;
                case 4:
                    System.out.println("Geben sie ein Name:");
                    String name4 = sc.next();
                    controller.getProduktByName(name4)
                            .ifPresentOrElse(
                                    produkt -> System.out.println("Gefunden: " + produkt),
                                    () -> System.out.println("Kein mit diesem Namen gefunden")
                            );

                    break;
                case 5:
                    controller.displayProdukts();
                    break;
                case 6:
                    System.out.println("Geben sie ein Id:");
                    int id6 = sc.nextInt();
                    System.out.println("Geben sie ein Namen:");
                    String name6 = sc.next();
                    System.out.println("Geben sie ein Region:");
                    String diagnose6 = sc.next();

                    ArrayList<Produkt> list = new ArrayList<>();
                    System.out.println("Geben sie eine Liste von Produkte namen");
                    sc.nextLine();
                    while(true){
                        String entry = sc.nextLine();
                        if (entry.isEmpty()) {
                            break;
                        }
                        Optional<Produkt> optionalMed = controller.getProduktByName(entry);
                        optionalMed.ifPresent(list::add);

                    }
                    controller.addCharaktere(id6,name6,diagnose6,list);
                    break;
                case 7:
                    System.out.println("Geben sie ein id:");
                    controller.deleteCharaktere(sc.nextInt());
                    break;
                case 8:
                    System.out.println("Geben sie ein old id:");
                    int oldId = sc.nextInt();
                    System.out.println("Geben sie ein id:");
                    int id8 = sc.nextInt();
                    System.out.println("Geben sie ein Namen:");
                    String name8 = sc.next();
                    System.out.println("Geben sie ein Region:");
                    String diagnose8 = sc.next();

                    ArrayList<Produkt> list8 = new ArrayList<>();
                    System.out.println("Geben sie eine Liste von Produkte namen");
                    sc.nextLine();
                    while(true){
                        String entry = sc.nextLine();
                        if (entry.isEmpty()) {
                            break;
                        }
                        Optional<Produkt> optionalMed = controller.getProduktByName(entry);
                        optionalMed.ifPresent(list8::add);

                    }
                    controller.updateCharakter(oldId,id8,name8,diagnose8,list8);
                    break;
                case 9:
                    System.out.println("Geben sie ein id:");
                    int id9 = sc.nextInt();
                    controller.getCharaktereById(id9)
                            .ifPresentOrElse(
                                    charaktere -> System.out.println("Gefunden: " + charaktere),
                                    () -> System.out.println("Kein mit dieser ID gefunden")
                            );

                    break;
                case 10:
                    controller.displayCharaktere();
                    break;
                case 11:
                    System.out.println("Gib Region");
                    String region11 = sc.next();
                    controller.filterRegion(region11);
                    break;
                case 12:
                    System.out.println("Gebe Universum");
                    String universum12 = sc.next();
                    controller.filterCharaktere(universum12);
                    break;
                case 13:
                    System.out.println("Geben sie ein Charakter Id");
                    int id13 = sc.nextInt();
                    System.out.println("Sortieren 1.aufsteigend/2.absteigend");
                    int mode = sc.nextInt();
                   // controller.print(id13,mode);
                    break;
                case 14:
                    continueloop = false;
                    break;

                default:
                    System.out.println("Invalid option");

            }


        }
    }
}
