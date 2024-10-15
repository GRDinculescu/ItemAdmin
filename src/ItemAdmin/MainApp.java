package ItemAdmin;

import java.util.HashMap; // Import the HashMap class for storing items
import java.util.Scanner; // Import the Scanner class for user input

public class MainApp {
    public static HashMap<String, Items> hm = new HashMap<>(); // Create a HashMap to store items with their names as keys
    private static final Scanner sn = new Scanner(System.in); // Create a static Scanner instance for reading user input

    public static void main(String[] args) {
        int op; // Variable to store the user option [1-6]

        while (true) { // Continue until the user decides to stop
            op = getUserOption(); // Get a valid user option
            if (op == 6) {
                break; // Exit the program if the user chooses option 6
            }

            executeOption(op); // Execute the selected option
        }

        sn.close(); // Close the Scanner at the end to free resources
    }

    /**
     * Prompts the user to select an option and validates the input.
     *
     * @return the valid option selected by the user
     */
    private static int getUserOption() {
        int op = 0; // Initialize option variable
        while (true) { // Loop until a valid option is provided
            try {
                // Display the menu and prompt the user for input
                System.out.printf(""" 
                        %nWhat do you want to do:
                        [1] Add item
                        [2] Remove item
                        [3] Update amount in stock
                        [4] Show all items
                        [5] Search by name
                        [6] Exit%n""");
                op = sn.nextInt(); // Read the user input
                if (op >= 1 && op <= 6) {
                    return op; // Return the valid option
                } else {
                    System.out.println("You must choose from the previous options."); // Inform user of invalid choice
                }
            } catch (Exception e) {
                System.out.println("You must enter whole numbers."); // Handle invalid input
                sn.next(); // Clear the invalid input from the scanner
            }
        }
    }

    /**
     * Executes the action based on the user-selected option.
     *
     * @param op the option selected by the user
     */
    private static void executeOption(int op) {
        switch (op) { // Switch statement to handle different options
            case 1 -> Functions.addItem(); // Call method to add an item
            case 2 -> Functions.removeItem(); // Call method to remove an item
            case 3 -> Functions.updateStock(); // Call method to update stock quantity
            case 4 -> Functions.showAll(); // Call method to show all items
            case 5 -> Functions.searchItem(); // Call method to search for an item
        }
    }
}
