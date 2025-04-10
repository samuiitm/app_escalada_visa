package Controlador.LlistarTots;

import Model.DAO.*;

import Vista.Vista;

import java.util.Scanner;

public class MenuLlistarTots {
    public static void menuLlistarTots() {
        Scanner scanner = new Scanner(System.in);
        int opcio = -1;

        EscolaDAO escolaDAO = new EscolaDAO();
        EscaladorDAO escaladorDAO = new EscaladorDAO();
        ViaDAO viaDAO = new ViaDAO();
        SectorDAO sectorDAO = new SectorDAO();

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
                    escolaDAO.obtenirTots();
                    break;
                case 2:
                    sectorDAO.obtenirTots();
                    break;
                case 3:
                    viaDAO.obtenirTots();
                    break;
                case 4:
                    escaladorDAO.obtenirTots();
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
