package Controlador;

import java.util.Scanner;

import Controlador.ActualitzarObjectes.ActualitzarEscalador;
import Controlador.ActualitzarObjectes.ActualitzarEscola;
import Controlador.ActualitzarObjectes.ActualitzarSector;
import Controlador.ActualitzarObjectes.ActualitzarVia;
import Vista.*;

public class MenuActualitzar {
    public static void menuActualitzar() {
        Scanner scanner = new Scanner(System.in);
        int opcio = -1;

        do {
            Vista.mostrarMenuActualitzar();
            String input = scanner.nextLine();

            try {
                opcio = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                Vista.mostrarMissatge("Opció no vàlida. Introdueix un número.");
                continue;
            }

            switch (opcio) {
                case 1:
                    ActualitzarEscola.actualizarEscola();
                    break;
                case 2:
                    ActualitzarSector.actualitzarSector();
                    break;
                case 3:
                    ActualitzarVia.actualitzarVia();
                    break;
                case 4:
                    ActualitzarEscalador.actualizarEscalador();
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