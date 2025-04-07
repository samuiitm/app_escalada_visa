package Controlador;

import java.util.Scanner;

import Controlador.CrearObjectes.CrearEscalador;
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
                    CrearEscalador.crearEscalador();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    break;
                default:
                    break;
            }

        } while (opcio != 0);
    }
}
