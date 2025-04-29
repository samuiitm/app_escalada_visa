package Controlador;

import java.util.Scanner;

import Controlador.ActualitzarObjectes.ActualitzarEscalador;
import Controlador.ActualitzarObjectes.ActualitzarEscola;
import Controlador.ActualitzarObjectes.ActualitzarSector;
import Controlador.ActualitzarObjectes.ActualitzarVia;
import Controlador.ConsultesPrecreades.ExecucioConsultes;
import Vista.*;

public class MenuConsultes {
    public static void menuConsultes() {
        Scanner scanner = new Scanner(System.in);
        int opcio = -1;

        do {
            Vista.mostrarMenuConsultesPrecreades();
            String input = scanner.nextLine();

            try {
                opcio = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                Vista.mostrarMissatge("Opció no vàlida. Introdueix un número.");
                continue;
            }

            switch (opcio) {
                case 1:
                    ExecucioConsultes.executarViesEscolaDisponible();
                    break;
                case 2:
                    ExecucioConsultes.executarViesPerDificultat();
                    break;
                case 3:
                    ExecucioConsultes.executarViesPerEstat();
                    break;
                case 4:
                    ExecucioConsultes.executarEscolesAmbRestriccions();
                    break;
                case 5:
                    ExecucioConsultes.executarSectorsMesDeXVies();
                    break;
                case 6:
                    ExecucioConsultes.executarEscaladorsPerNivellMaxim();
                    break;
                case 7:
                    ExecucioConsultes.executarViesAptesRecentment();
                    break;
                case 8:
                    ExecucioConsultes.executarViesMesLlarguesEscola();
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