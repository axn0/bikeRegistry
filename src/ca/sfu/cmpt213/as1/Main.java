package ca.sfu.cmpt213.as1;

/**
 * Provides the main functionality to manage a bike registry
 * @author April Nguyen
 *  @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        Bike.displayTitle("Bike Registry by April Nguyen sn 301314527");
        boolean exit = false;
        while(!exit) {
            String option = Bike.selectOption();
            switch (option) {
                case "1":
                    if (Bike.getTotalBikes() > 0) {
                        Bike.displayAllBikes();
                    }
                    break;
                case "2":
                    try {
                        Bike.addNewBike();
                    }
                    catch(Exception e) {
                        System.out.println("Error: " + e.getMessage());
                        System.out.println("Unable to add new bike.");
                    }
                    break;
                case "3":
                    try {
                        Bike.deleteBike();
                    }
                    catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                        System.out.println("Invalid option. Try again.");
                    }
                    break;
                case "4":
                    try {
                        Bike.alterBike();
                    }
                    catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                        System.out.println("Invalid option. Try again.");
                    }
                    break;
                case "5":
                    Bike.dumpAllBikes();
                    break;
                case "6":
                    System.out.println("BYE!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }
}