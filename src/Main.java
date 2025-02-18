import Console.Console;
import Controller.Controller;
import Model.Charakter;
import Model.Produkt;
import Repository.Repository;

public class Main {
    public static void main(String[] args) {
        Repository<Produkt> produktRepository = new Repository<Produkt>();
        Repository<Charakter> charaktereRepository = new Repository<Charakter>();

        Controller controller = new Controller(produktRepository, charaktereRepository);
        Console console = new Console(controller);
        console.run();
    }
}