package Controlador;

import java.util.Scanner;
import Controlador.EliminarObjectes.EliminarEscalador;
import Controlador.EliminarObjectes.EliminarEscola;
import Controlador.EliminarObjectes.EliminarSector;
import Controlador.EliminarObjectes.EliminarVia;
import Vista.Vista;

public class MenuEliminar {
    public static void menuEliminar() {
        Scanner scanner = new Scanner(System.in);
        int opcio = -1;

        do {
            Vista.mostrarMenuEliminar();
            String input = scanner.nextLine();

            try {
                opcio = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                Vista.mostrarMissatge("Opció no vàlida. Introdueix un número.");
                continue;
            }

            switch (opcio) {
                case 1:
                    EliminarEscalador.eliminarEscalador();
                    break;
                case 2:
                    EliminarEscola.eliminarEscola();
                    break;
                case 3:
                    EliminarSector.eliminarSector();
                    break;
                case 4:
                    EliminarVia.eliminarVia();
                    break;
                case 0:
                    Vista.mostrarMissatge("Tornant al menú principal...\n");
                    break;
                default:
                    Vista.mostrarMissatge("L'opció introduida no es vàlida. Si us plau, introdueix una opció del menú");
                    break;
            }
        } while (opcio != 0);
    }
}