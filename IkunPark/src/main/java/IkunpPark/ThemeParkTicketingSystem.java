/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IkunpPark;



import java.util.ArrayList;
import java.util.Scanner;

// Parent class for all items in the theme park system
class ThemeParkItem {
    private String name;
    private double price;

    public ThemeParkItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Package class to define packages and the number of tickets included
class Package extends ThemeParkItem {
    private String details;
    private int numTickets;

    public static Package createPackage(String name, double price, String details, int numTickets) {
        return new Package(name, price, details, numTickets);
    }

    private Package(String name, double price, String details, int numTickets) {
        super(name, price);
        this.details = details;
        this.numTickets = numTickets;
    }

    public String getDetails() {
        return details;
    }

    public int getNumTickets() {
        return numTickets;
    }
}

// Food class to define menu items
class FoodItem extends ThemeParkItem {
    private String description;

    public static FoodItem createFoodItem(String name, double price, String description) {
        return new FoodItem(name, price, description);
    }

    private FoodItem(String name, double price, String description) {
        super(name, price);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

// Hotel class to select room and number of beds
class HotelRoom extends ThemeParkItem {
    private String roomType;
    private int numBeds;

    public static HotelRoom createHotelRoom(String name, double price, String roomType, int numBeds) {
        return new HotelRoom(name, price, roomType, numBeds);
    }

    private HotelRoom(String name, double price, String roomType, int numBeds) {
        super(name, price);
        this.roomType = roomType;
        this.numBeds = numBeds;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getNumBeds() {
        return numBeds;
    }
}

public class ThemeParkTicketingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create some sample theme park items
        Package package1 = Package.createPackage("Package 1", 50.0, "Includes access to all rides", 2);
        FoodItem food1 = FoodItem.createFoodItem("Burger", 10.0, "Delicious burger with fries");
        HotelRoom room1 = HotelRoom.createHotelRoom("Standard Room", 100.0, "Double", 2);

        // Store theme park items in an ArrayList (you can use a database in a real application)
        ArrayList<ThemeParkItem> themeParkItems = new ArrayList<>();
        themeParkItems.add(package1);
        themeParkItems.add(food1);
        themeParkItems.add(room1);

        // Main menu
        while (true) {
            System.out.println("Theme Park Ticketing System");
            System.out.println("1. View Packages");
            System.out.println("2. View Food Menu");
            System.out.println("3. View Hotel Rooms");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Display package information
                    System.out.println("Packages:");
                    for (ThemeParkItem item : themeParkItems) {
                        if (item instanceof Package) {
                            Package pkg = (Package) item;
                            System.out.println(pkg.getName() + ": " + pkg.getDetails() + " - $" + pkg.getPrice());
                        }
                    }
                    break;
                case 2:
                    // Display food menu
                    System.out.println("Food Menu:");
                    for (ThemeParkItem item : themeParkItems) {
                        if (item instanceof FoodItem) {
                            FoodItem food = (FoodItem) item;
                            System.out.println(food.getName() + ": " + food.getDescription() + " - $" + food.getPrice());
                        }
                    }
                    break;
                case 3:
                    // Display hotel rooms
                    System.out.println("Hotel Rooms:");
                    for (ThemeParkItem item : themeParkItems) {
                        if (item instanceof HotelRoom) {
                            HotelRoom room = (HotelRoom) item;
                            System.out.println(room.getName() + ": " + room.getRoomType() + " - $" + room.getPrice());
                        }
                    }
                    break;
                case 4:
                    // Exit the program
                    System.out.println("Exiting Theme Park Ticketing System. Thank you!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
