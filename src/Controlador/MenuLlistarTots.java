package Controlador;

import java.util.Scanner;

import Controlador.LlistarTots.LlistarTotsEscalador;
import Controlador.LlistarTots.LlistarTotsEscola;
import Controlador.LlistarTots.LlistarTotsSector;
import Controlador.LlistarTots.LlistarTotsVia;
import Vista.*;

public class MenuLlistarTots {
    public static void menuLlistarTots() {
        Scanner scanner = new Scanner(System.in);
        int opcio = -1;

        do {
            Vista.mostrarMenuLlistarTots();
            String input = scanner.nextLine();

            try {
                opcio = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                Vista.mostrarMissatge("Opció no vàlida. Introdueix un número.");
                continue;
            }

            switch (opcio) {
                case 1:
                    LlistarTotsEscalador.llistarTotsEscaladors();
                    break;
                case 2:
                    LlistarTotsEscola.llistarTotesEscoles();
                    break;
                case 3:
                    LlistarTotsSector.llistarTotsSectors();
                    break;
                case 4:
                    LlistarTotsVia.llistarTotesVies();
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