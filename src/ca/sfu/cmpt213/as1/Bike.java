package ca.sfu.cmpt213.as1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a bike registry.
 * This class provides methods to manipulate the bike registry
 * @author April Nguyen
 * @version 1.0
 */
public class Bike {
    private final int id;
    private String owner;
    private String type;
    private String serial;
    private String brake;
    private int wheel;

    private static int idCounter = 1;
    private static List<Bike> bikes = new ArrayList<>();
    private static int totalBikes = 0;
    public static int getTotalBikes(){return totalBikes;}

    public void setOwner(String owner){
        this.owner = owner;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setSerial(String serial){
        this.serial = serial;
    }
    public void setBrake(String brake){
        this.brake = brake;
    }
    public void setWheel(int wheel){
        this.wheel = wheel;
    }

    public static void displayTitle(String title) {
        String str = "* " + title + " *";
        int len = str.length();
        String border = "*".repeat(len);
        System.out.println(border);
        System.out.println(str);
        System.out.println(border);
    }
    public static void displayMainMenu() {
        System.out.println();
        displayTitle("Main Menu");
        System.out.println("1. List Bikes");
        System.out.println("2. Add a new Bike");
        System.out.println("3. Remove a Bike");
        System.out.println("4. Change Bike attribute");
        System.out.println("5. DEBUG: Dump objects (toString)");
        System.out.println("6. Exit");
    }

    public static String selectOption() {
        Scanner scanner = new Scanner(System.in);
        displayMainMenu();
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
                    System.out.println("Invalid option. Try again.");
                    displayMainMenu();
                    System.out.print("> ");
                    option = scanner.next();
            }
        }
        return option;
    }

    public static void displayAllBikes() {
        System.out.println(bikes.size());
        displayTitle("List of Bikes:");
        System.out.printf("%-3s %-16s %-10s %-11s %-7s %-9s\n", "ID", "Owner,", "Type,","Serial,","Brake","WheelSize");
        for (Bike b : bikes) {
            System.out.printf("%-3s %-16s %-10s %-11s %-7s %-9d\n", b.id + ",", b.owner + ",", b.type + ",", b.serial + ",", b.brake + ",", b.wheel);
        }
    }

    public static Bike findBike(int id) {
        for (Bike b : bikes) {
            if (b.id == id) {
                return b;
            }
        }
        return null;
    }

    public static void addNewBike() throws Exception {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String owner;
        String type;
        String serial;
        String brake ;
        int wheel;
        System.out.printf("%-30s", "Enter Bike owner name:");
        owner = scanner.next();
        System.out.printf("%-30s", "Enter Bike type:");
        type = scanner.next();
        while (!(type.equals("Mountain") || type.equals("Road") || type.equals("Touring") ||
                type.equals("Commuter") || type.equals("Cruiser") || type.equals("Folding"))) {
            System.out.println("Invalid bike type. Try again.");
            type = scanner.next();
        }
        System.out.printf("%-30s", "Enter Bike's serial number:");
        serial = scanner.next();
        System.out.printf("%-30s", "Enter Bike's brake type:");
        brake = scanner.next();
        while (!(brake.equals("Rim") || brake.equals("Disc") || brake.equals("Drum"))) {
            System.out.println("Invalid brake type. Try again.");
            brake = scanner.next();
        }
        System.out.printf("%-30s", "Enter Bike's wheel size:");
        wheel = Integer.parseInt(scanner.next());

        Bike newBike = new Bike(owner,type,serial,brake,wheel);
        bikes.add(newBike);
    }

    public static void deleteBike() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int id;
        displayAllBikes();
        System.out.println("Enter ID (0 to cancel)");
        System.out.print("> ");
        id = Integer.parseInt(scanner.next());
        if (id == 0) {
            return;
        }
        Bike b = findBike(id);
        if (b == null) {
            System.out.println("Bike not found.");
            System.out.println("Returning to menu.");
        }
        else {
            bikes.remove(b);
            System.out.println("Removed!");
        }
    }

    public static void alterBike() throws Exception {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int id;
        String attribute;
        String newValue;
        System.out.println("Enter ID (0 to cancel)");
        System.out.print("> ");
        id = Integer.parseInt(scanner.next());
        if (id == 0) {
            return;
        }
        Bike b = findBike(id);
        if (b == null) {
            System.out.println("Bike not found.");
            System.out.println("Returning to menu.");
        }
        else {
            System.out.println("Which Attribute?");
            System.out.print("> ");
            attribute = scanner.next();
            System.out.println("New Value");
            System.out.print("> ");
            newValue = scanner.next();
            boolean valid = false;
            while (!valid) {
                switch (attribute) {
                    case "Owner":
                        b.owner = newValue;
                        valid = true;
                        break;
                    case "Type":
                        while (!(newValue.equals("Mountain") || newValue.equals("Road") || newValue.equals("Touring") ||
                                newValue.equals("Commuter") || newValue.equals("Cruiser") || newValue.equals("Folding"))) {
                            System.out.println("Invalid bike type. Try again.");
                            newValue = scanner.next();
                        }
                        b.type = newValue;
                        valid = true;
                        break;
                    case "Serial":
                        b.serial = newValue;
                        valid = true;
                        break;
                    case "Brake":
                        while (!(newValue.equals("Rim") || newValue.equals("Disc") || newValue.equals("Drum"))) {
                            System.out.println("Invalid brake type. Try again.");
                            newValue = scanner.next();
                        }
                        b.brake = newValue;
                        valid = true;
                        break;
                    case "Wheel Size":
                        b.wheel = Integer.parseInt(newValue);
                        valid = true;
                        break;
                    default:
                        System.out.println("Invalid Attribute");
                        System.out.println("Which Attribute?");
                        System.out.print("> ");
                        attribute = scanner.next();
                        System.out.println("New Value");
                        System.out.print("> ");
                        newValue = scanner.next();
                }
            }
            System.out.println("Saved!");
        }
    }

    @Override
    public String toString() {
        String location = this.getClass().getName();
        int _id = this.id;
        String id = "[Id:" + _id + ", ";
        String owner = "Owner:" + this.owner + ", ";
        String type = "type:" + this.type + ", ";
        String serial = "Serial:" + this.serial + ", ";
        String brake = "Brake:" + this.brake + ", ";
        String wheel = "WheelSize:" + this.wheel + "]";
        return location + id + owner + type + serial + brake + wheel;
    }

    public static void dumpAllBikes() {
        int i = 1;
        for (Bike b : bikes) {
            System.out.println(i + "." + b.toString());
            i++;
        }
    }

    public Bike(String owner, String type, String serial, String brake, int wheel) {
        this.id = idCounter;
        idCounter++;
        this.owner = owner;
        this.type = type;
        this.serial = serial;
        this.brake = brake;
        this.wheel = wheel;
        totalBikes++;
    }
}
