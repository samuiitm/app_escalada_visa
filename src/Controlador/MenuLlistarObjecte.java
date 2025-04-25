package Controlador;

import java.util.Scanner;

import Controlador.LlistarObjecte.LlistarEscalador;
import Controlador.LlistarObjecte.LlistarEscola;
import Controlador.LlistarObjecte.LlistarSector;
import Controlador.LlistarObjecte.LlistarVia;
import Vista.*;

public class MenuLlistarObjecte {
    public static void menuLlistarObjecte() {
        Scanner scanner = new Scanner(System.in);
        int opcio = -1;

        do {
            Vista.mostrarMenuLlistarObjecte();
            String input = scanner.nextLine();

            try {
                opcio = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                Vista.mostrarMissatge("Opció no vàlida. Introdueix un número.");
                continue;
            }

            switch (opcio) {
                case 1:
                    LlistarEscalador.llistarEscalador();
                    break;
                case 2:
                    LlistarEscola.llistarEscola();
                    break;
                case 3:
                    LlistarSector.llistarSector();
                    break;
                case 4:
                    LlistarVia.llistarVia();
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
