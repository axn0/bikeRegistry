package ca.sfu.cmpt213.as1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BikeRegistry {
    
    private static List<Bike> bikes = new ArrayList<>();
    public void displayTitle(String title) {
        String str = "* " + title + " *";
        int len = str.length();
        String border = "*".repeat(len);
        System.out.println(border);
        System.out.println(str);
        System.out.println(border);
    }
    public void displayMainMenu() {
        System.out.println();
        displayTitle("Main Menu");
        System.out.println("1. List Bikes");
        System.out.println("2. Add a new Bike");
        System.out.println("3. Remove a Bike");
        System.out.println("4. Change Bike attribute");
        System.out.println("5. DEBUG: Dump objects (toString)");
        System.out.println("6. Exit");
    }
    public static void selectOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        String option = scanner.next();
        boolean run = true;
        while (run) {
            switch (option) {
                case "1":
                    run = false;
                    break;
                case "2":
                    run = false;
                    break;
                case "3":
                    run = false;
                    break;
                case "4":
                    run = false;
                    break;
                case "5":
                    run = false;
                    break;
                case "6":
                    run = false;
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
                    System.out.print("> ");
                    option = scanner.next();
            }
        }
    }
    public BikeRegistry() {
    }
}
