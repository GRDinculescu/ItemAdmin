package ItemAdmin;

/**
 * The Items class represents an item in an inventory management system.
 * Each item has a price, an available quantity, and a name.
 */
public class Items {
    // Price of the item
    double price;

    // Available quantity of the item
    int quantity;

    // Name of the item (static variable shared among all instances)
    static String name;

    /**
     * Gets the price of the item.
     *
     * @return the price of the item
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the available quantity of the item.
     *
     * @return the quantity of the item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Gets the name of the item.
     *
     * @return the name of the item
     */
    public static String getName() {
        return name;
    }

    /**
     * Sets the price of the item.
     *
     * @param price the new price of the item
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets the available quantity of the item.
     *
     * @param quantity the new quantity of the item
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Sets the name of the item.
     *
     * @param name the new name of the item
     */
    public void setName(String name){
        Items.name = name;
    }

    /**
     * Constructor for the Items class that initializes the price, quantity, and name of the item.
     *
     * @param price the price of the item
     * @param quantity the available quantity of the item
     * @param name the name of the item
     */
    public Items(double price, int quantity, String name){
        this.price = price;
        this.quantity = quantity;
        Items.name = name;
    }
}
