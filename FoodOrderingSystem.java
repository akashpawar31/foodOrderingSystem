package foodOrderingSystem;

import java.util.ArrayList;
import java.util.Scanner;

class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
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

class Order {
    private ArrayList<MenuItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public double getTotalPrice() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void displayOrder() {
        System.out.println("Ordered Items:");
        for (MenuItem item : items) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("Total: $" + getTotalPrice());
        double totalPrice = getTotalPrice();
        System.out.println("Subtotal: $" + totalPrice);
        double tax = totalPrice * 0.1; // Assuming 10% tax
        System.out.println("Tax (10%): $" + tax);
        double totalWithTax = totalPrice + tax;
        System.out.println("Total: $" + totalWithTax);
    }
    }

class Menu {
    private ArrayList<MenuItem> menuItems;

    public Menu() {
        menuItems = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        menuItems.add(item);
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - $" + item.getPrice());
        }
    }

    public MenuItem getItem(int index) {
        if (index >= 0 && index < menuItems.size()) {
            return menuItems.get(index);
        }
        return null;
    }
}

public class FoodOrderingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        menu.addItem(new MenuItem("Burger", 5.99));
        menu.addItem(new MenuItem("Pizza", 8.99));
        menu.addItem(new MenuItem("Fries", 2.99));
        menu.addItem(new MenuItem("paneer tikka", 7.99));
        menu.addItem(new MenuItem("samosa", 3.99));
        menu.addItem(new MenuItem("riceplate", 6.99));

        Order order = new Order();

        while (true) {
            menu.displayMenu();
            System.out.println("Enter item number to order (0 to finish):");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }

            MenuItem selectedItem = menu.getItem(choice - 1);

            if (selectedItem != null) {
                order.addItem(selectedItem);
                System.out.println(selectedItem.getName() + " added to the order.");
            } else {
                System.out.println("Invalid item number.");
            }
        }

        System.out.println("\nOrder Summary:");
        order.displayOrder();

        scanner.close();
    }
}

