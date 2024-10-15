package ItemAdmin;

import java.util.Scanner;

public class Functions {
    // Adds items to HashMap
    public static void addItem(){
        Scanner sn = new Scanner(System.in);
        System.out.print("\nIntroduce el nombre del producto: ");
        String nombre = sn.nextLine();

        double precio = getPrice();
        int cantidad = getAmount();

        Items item = new Items(precio, cantidad, nombre);

        if (MainApp.hm.containsKey(nombre)){
            System.out.println("Ya hay un producto con ese nombre.");
        } else {
            MainApp.hm.put(nombre, item);
        }

        System.out.println("Se agrego\nProducto: "+nombre+
                "\nPrecio: "+precio+
                "\nCantidad: "+cantidad);
    }

    // Removes items from HashMap
    public static void removeItem(){
        Scanner sn = new Scanner(System.in);

        System.out.print("Introduce el nombre del producto: ");
        String nombre = sn.nextLine();

        if(MainApp.hm.containsKey(nombre)){
            MainApp.hm.remove(nombre);
            System.out.println("El producto: "+nombre+" fue borrado correctamente.\n");
        } else {
            System.out.println("""
                    ------------- ERROR -------------
                    El producto introducido no existe.
                    """);
        }
    }

    // [3] Update items
    public static void updateItem(){
        Scanner sn = new Scanner(System.in);

        System.out.print("\nIntroduzca el nombre del producto a actualizar: ");
        String nombre = sn.nextLine();

        try {
            Items item = MainApp.hm.get(nombre);

            System.out.printf("""
                    Sus valores actuales son:
                    Nombre: %s
                    Precio: %.2f$
                    Cantidad: %d%n""", nombre, item.price, item.amount);
        } catch (Exception e) {
            System.out.printf("No se encontro el producto: %s%n", nombre);
            return;
        }

        do {
            int op;
            nombre = Items.name;
            try {
                System.out.println("""
                        
                        Que quieres cambiar:
                        [1] Nombre
                        [2] Precio
                        [3] Cantidad
                        [4] Volver""");
                op = sn.nextInt();
            } catch (Exception e) {
                System.out.println("Debes introducir numeros enteros.");
                sn.next();
                continue;
            }

            if (op == 4){
                return;
            }

            switch (op) {
                case 1 -> changeName(nombre, MainApp.hm.get(nombre));
                case 2 -> changePrice(nombre, MainApp.hm.get(nombre));
                case 3 -> changeAmount(nombre, MainApp.hm.get(nombre));
                default -> System.out.println("Debes introducir una de las opciones anteriores.");
            }
        } while (true);
    }

    public static void changeName (String nameO, Items item){
        Scanner sn = new Scanner(System.in);

        System.out.print("Cual seria el nuevo nombre: ");
        String name = sn.nextLine();

        MainApp.hm.put(name, item);
        MainApp.hm.remove(nameO);

        item.setName(name);
    }

    public static void changePrice (String name, Items item){
        double precio = getPrice();

        item.setPrice(precio);

        MainApp.hm.put(name, item);
    }

    public static void changeAmount (String name, Items item){
        int amount = getAmount();

        item.setAmount(amount);

        MainApp.hm.put(name, item);
    }


    // [4] Show all items
    public static void showAll(){
        for (String i : MainApp.hm.keySet()){
            Items item = MainApp.hm.get(i);
            System.out.printf("Producto: %s - Precio: %.2f - Cantidad: %d%n", i, item.price, item.amount);
        }
    }

    // [5] Search item by name
    public static void searchItem(){
        Scanner sn = new Scanner(System.in);

        System.out.print("Introduzca el nombre el producto: ");
        String producto = sn.nextLine();

        try {
            Items item = MainApp.hm.get(producto);
            System.out.println("Producto: " + producto +
                    " - Precio: " + item.price +
                    "$ - Cantidad: " + item.amount);
        } catch (Exception e) {
            System.out.printf("No se encuentra el producto: %s%n", producto);
        }
    }


    // -------↓↓↓------- DON'T TOUCH -------↓↓↓-------
    // Get the item's price
    public static double getPrice() {
        Scanner sn = new Scanner(System.in);
        double precio;

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

        return precio;
    }

    // Get the amount of items
    public static int getAmount() {
        Scanner sn = new Scanner(System.in);
        int cantidad;

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

        return cantidad;
    }
}
