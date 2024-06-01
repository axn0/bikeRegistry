package ca.sfu.cmpt213.as1;

/**
 * Provides the main functionality of a bike registry with options
 * to list, add, remove, change, and dump objects the bikes
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
                    Bike.addNewBike();
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
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }
}