import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class itemAdmin {
    public static HashMap<String, List<String>> hm = new HashMap<>();

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        do {
            int op;
            do {
                try {
                    System.out.println("Que quieres hacer:\n" +
                            "[1] Agregar un producto\n" +
                            "[2] Eliminar producto\n" +
                            "[3] Actualizar cantidad en stock\n" +
                            "[4] Mostrar todos los productos\n" +
                            "[5] Buscar producto por nombre\n" +
                            "[6] Salir");
                    op = sn.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Debes introducir numeros enteros.");
                    sn.next();
                }
            } while (true);

            switch (op){
                case 1 -> addItem();
                case 2 -> System.out.println("");
                default -> {
                    System.out.println("Debes elegir entre las opciones anteriores.");
                    continue;}
            }

            if (op == 6){
                break;
            }
        } while (true);
        System.out.println(hm);
        sn.close();
    }


    public static void addItem(){
        Scanner sn = new Scanner(System.in);
        double precio;
        int cantidad;

        System.out.print("Introduce el nombre del producto: ");
        String nombre = sn.nextLine();

        do {
            try {
                System.out.print("Introduce el precio del producto: ");
                precio = sn.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Solo puedes introducir numeros enteros o con decimales separados por punto.");
                sn.next();
            }
        } while (true);

        do {
            try {
                System.out.print("Introduce la cantidad del producto: ");
                cantidad = sn.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Solo puedes introducir numeros enteros.");
                sn.next();
            }
        } while (true);

        Producto p = new Producto(nombre, precio, cantidad);

        if (hm.containsKey(p.getName())){
            hm.get(p.getName()).add(p.getPrice()+"$ "+p.getAmount());
        } else {
            hm.put(p.getName(), new ArrayList<>());
            hm.get(p.getName()).add(p.getPrice()+"$ "+p.getAmount());
        }

        System.out.println("Nombre de Producto: "+p.getName()+
                "\nPrecio: "+p.getPrice()+
                "\nCantidad: "+p.getAmount());

        System.out.println(hm);
    }

    public static void removeItem(){
        Scanner sn = new Scanner(System.in);

        System.out.print("Introduce el nombre del producto: ");
        String nombre = sn.nextLine();

        if(hm.containsKey(nombre)){
            hm.remove(nombre);
        } else {
            System.out.println("El producto introducido no existe.");
        }
    }

}

class Producto{
    private String name;
    private double price;
    private int amount;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public int getAmount(){
        return amount;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    Producto(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }
}
