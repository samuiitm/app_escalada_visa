import Controlador.*;
import Vista.Vista;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int opcio = -1;

        do {
            Vista.mostrarMenuPrincipal();

            String input = scanner.nextLine();

            try {
                opcio = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                Vista.mostrarMissatge("L'opció introduida no es vàlida. Si us plau, introdueix una opció del menú");
                continue;
            }

            switch (opcio) {
                // CAS 1: CREAR
                case 1:
                    MenuCrear.menuCrear();
                    break;

                // CAS 2: MODIFICAR
                case 2:
                    MenuActualitzar.menuActualitzar();
                    break;

                // CAS 3: LLISTAR UN
                case 3:
                    MenuLlistarObjecte.menuLlistarObjecte();
                    break;

                // CAS 4: LLISTAR TOT
                case 4:
                    MenuLlistarTots.menuLlistarTots();
                    break;

                // CAS 5: ELIMINAR
                case 5:
                    MenuEliminar.menuEliminar();
                    break;

                // CAS 6: CONSULTES PRECREADES
                case 6:
                    break;

                // CAS DEFAULT
                default:
                    Vista.mostrarMissatge("L'opció introduida no es vàlida. Si us plau, introdueix una opció del menú");
                    break;
            }
        } while (opcio != 0);
    }
}