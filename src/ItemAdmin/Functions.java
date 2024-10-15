package ItemAdmin;

import java.util.Scanner; // Import the Scanner class for user input

public class Functions {
    // Adds items to the HashMap
    public static void addItem() {
        Scanner sn = new Scanner(System.in); // Create a Scanner instance for user input
        System.out.print("\nEnter the product name: "); // Prompt for product name
        String name = sn.nextLine(); // Read the product name

        double price = getPrice(); // Get the price of the product
        int quantity = getQuantity(); // Get the quantity of the product

        Items item = new Items(price, quantity, name); // Create a new item object

        // Check if the product name already exists in the HashMap
        if (MainApp.hm.containsKey(name)) {
            System.out.println("A product with that name already exists."); // Inform the user if the product exists
        } else {
            MainApp.hm.put(name, item); // Add the item to the HashMap
        }

        // Display the details of the added item
        System.out.printf(""" 
                Added
                  - Product: %s
                  - Price: %.2f
                  - Quantity: %d
                """, name, price, quantity);
    }

    // Removes items from the HashMap
    public static void removeItem() {
        Scanner sn = new Scanner(System.in); // Create a Scanner instance for user input

        System.out.print("Enter the product name: "); // Prompt for product name
        String name = sn.nextLine(); // Read the product name

        // Check if the product name exists in the HashMap
        if (MainApp.hm.containsKey(name)) {
            MainApp.hm.remove(name); // Remove the item from the HashMap
            System.out.println("%nProduct: " + name + " was removed successfully.\n"); // Confirm removal
        } else {
            // Display an error message if the product does not exist
            System.out.println("""
                    ------------- ERROR -------------
                    The entered product does not exist.
                    """);
        }
    }

    // Updates the stock of items
    public static void updateStock() {
        Scanner sn = new Scanner(System.in); // Create a Scanner instance for user input

        System.out.print("\nEnter the name of the product to update: "); // Prompt for product name
        String name = sn.nextLine(); // Read the product name

        try {
            Items item = MainApp.hm.get(name); // Retrieve the item from the HashMap

            // Display the current values of the item
            System.out.printf(""" 
                    Its current values are:
                    Name: %s
                    Price: %.2f$
                    Quantity: %d%n""", name, item.price, item.quantity);
        } catch (Exception e) {
            // Display an error message if the product is not found
            System.out.printf(""" 
                    %n------------ ERROR ------------
                    The product [%s] was not found %n""", name);
            return; // Exit the method
        }

        changeQuantity(name, MainApp.hm.get(name)); // Call method to change the quantity
    }

    // Changes the quantity of an existing item
    public static void changeQuantity(String name, Items item) {
        int quantity = getQuantity(); // Get the new quantity from user input

        item.setQuantity(quantity); // Update the item's quantity

        MainApp.hm.put(name, item); // Put the updated item back in the HashMap
    }

    // Shows all items in the HashMap
    public static void showAll() {
        // Iterate over all keys in the HashMap
        for (String i : MainApp.hm.keySet()) {
            Items item = MainApp.hm.get(i); // Retrieve the item
            // Display the details of each item
            System.out.printf(""" 
                    %nProduct: %s
                      - Price: %.2f
                      - Quantity: %d%n
                    """, i, item.price, item.quantity);
        }
    }

    // Searches for an item by name
    public static void searchItem() {
        Scanner sn = new Scanner(System.in); // Create a Scanner instance for user input

        System.out.print("Enter the product name: "); // Prompt for product name
        String product = sn.nextLine(); // Read the product name

        try {
            Items item = MainApp.hm.get(product); // Retrieve the item from the HashMap
            // Display the details of the found item
            System.out.printf(""" 
                    %nProduct: %s
                      - Price: %.2f$
                      - Quantity: %d%n
                    """, product, item.price, item.quantity);
        } catch (Exception e) {
            // Display an error message if the product cannot be found
            System.out.printf("The product [%s] cannot be found%n", product);
        }
    }

    // -------↓↓↓------- DON'T TOUCH -------↓↓↓-------

    // Gets the item's price from user input
    public static double getPrice() {
        Scanner sn = new Scanner(System.in); // Create a Scanner instance for user input
        double price;

        do {
            try {
                System.out.print("Enter the product price: "); // Prompt for product price
                price = sn.nextDouble(); // Read the price input
                break; // Exit the loop if input is valid
            } catch (Exception e) {
                // Display an error message if input is invalid
                System.out.println("You can only enter whole numbers or decimals separated by a point.");
                sn.next(); // Clear the invalid input
            }
        } while (true);

        return price; // Return the valid price
    }

    // Gets the quantity of items from user input
    public static int getQuantity() {
        Scanner sn = new Scanner(System.in); // Create a Scanner instance for user input
        int quantity;

        do {
            try {
                System.out.print("Enter the product quantity: "); // Prompt for product quantity
                quantity = sn.nextInt(); // Read the quantity input
                break; // Exit the loop if input is valid
            } catch (Exception e) {
                // Display an error message if input is invalid
                System.out.println("You can only enter whole numbers.");
                sn.next(); // Clear the invalid input
            }
        } while (true);

        return quantity; // Return the valid quantity
    }
}
