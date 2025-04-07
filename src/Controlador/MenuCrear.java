package Controlador;

import java.util.Scanner;

import Controlador.CrearObjectes.CrearEscalador;
import Controlador.CrearObjectes.CrearEscola;
import Controlador.CrearObjectes.CrearSector;
import Controlador.CrearObjectes.CrearVia;
import Vista.*;

public class MenuCrear {
    public static void menuCrear() {
        Scanner scanner = new Scanner(System.in);
        int opcio = -1;

        do {
            Vista.mostrarMenuCrear();
            String input = scanner.nextLine();

            try {
                opcio = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                Vista.mostrarMissatge("Opció no vàlida. Introdueix un número.");
                continue;
            }

            switch (opcio) {
                case 1:
                    CrearEscola.crearEscola();
                    break;
                case 2:
                    CrearSector.crearSector();
                    break;
                case 3:
                    CrearVia.crearVia();
                    break;
                case 4:
                    CrearEscalador.crearEscalador();
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
