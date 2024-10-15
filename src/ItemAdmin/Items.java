package ItemAdmin;

public class Items {
    double price;
    int amount;
    static String name;


    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public static String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setName(String name){
        Items.name = name;
    }

    public Items(double price, int amount, String name){
        this.price = price;
        this.amount = amount;
        Items.name = name;
    }
}
