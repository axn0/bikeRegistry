//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BikeRegistry menu = new BikeRegistry();
        menu.printTitle("Bike Registry by April Nguyen sn 301314527");
        System.out.println("\n");
        menu.printTitle("Main Menu");
        menu.printMenu();
        menu.selectOption();

    }
}