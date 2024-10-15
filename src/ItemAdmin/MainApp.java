package ItemAdmin;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static HashMap<String, Items> hm = new HashMap<>();

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        do {
            int op; // Option [1-6]
            do {
                try {
                    System.out.println("""
                            
                            Que quieres hacer:
                            [1] Agregar un producto
                            [2] Eliminar producto
                            [3] Actualizar cantidad en stock
                            [4] Mostrar todos los productos
                            [5] Buscar producto por nombre
                            [6] Salir""");
                    op = sn.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Debes introducir numeros enteros.");
                    sn.next();
                }
            } while (true);

            if (op == 6){
                break;
            }

            switch (op){
                case 1 -> Functions.addItem();
                case 2 -> Functions.removeItem();
                case 3 -> Functions.updateItem(); // todo Actualizar items
                case 4 -> Functions.showAll();
                case 5 -> Functions.searchItem();
                default -> {
                    System.out.println("Debes elegir entre las opciones anteriores.");
                    continue;}
            }
        } while (true);

        sn.close();
    }
}