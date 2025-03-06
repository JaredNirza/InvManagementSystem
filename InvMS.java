import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> Item = new HashMap<>();
        Map<String, Double> cost = new HashMap<>();

        Item.put("Laptop", 10);
        Item.put("Mouse", 50);
        Item.put("Keyboard", 30);

        cost.put("Laptop", 1200.00);
        cost.put("Mouse", 25.50);
        cost.put("Keyboard", 50.76);

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. Set Quantity");
            System.out.println("3. Display Inventory");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter item price: ");
                    double itemPrice = scanner.nextDouble();
                    System.out.print("Enter item quantity: ");
                    int itemQuantity = scanner.nextInt();

                    Item.put(itemName, Item.getOrDefault(itemName, 0) + itemQuantity);
                    cost.put(itemName, itemPrice);
                    System.out.println("Item added successfully.");
                    break;

                case 2:
                    System.out.print("Enter item name: ");
                    itemName = scanner.nextLine();
                    if (Item.containsKey(itemName)) {
                        System.out.print("Enter new quantity: ");
                        int newQuantity = scanner.nextInt();
                        if (newQuantity >= 0) {
                            Item.put(itemName, newQuantity);
                            System.out.println("Quantity updated.");
                        }
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 3:
                    System.out.printf("\n%-15s %-10s %-10s%n", "Item", "Price", "Quantity");
                    System.out.println("-------------------------------------");
                    for (Map.Entry<String, Integer> entry : Item.entrySet()) {
                        System.out.printf("%-15s %-9.2f %-10d%n", entry.getKey(), cost.get(entry.getKey()), entry.getValue());
                    }
                    break;

                case 4:
                    System.out.println("Program Closed.");
                    return;

                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }
}
