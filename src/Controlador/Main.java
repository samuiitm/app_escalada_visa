package Controlador;
import Vista.Vista;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
                    crearObjecte();
                    break;

                // CAS 2: MODIFICAR
                case 2:
                    break;

                // CAS 3: LLISTAR UN
                case 3:
                    break;

                // CAS 4: LLISTAR TOT
                case 4:
                    break;

                // CAS 5: ELIMINAR
                case 5:
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

    public static void crearObjecte () {
        Vista.mostrarMenuCrear();
    }
}