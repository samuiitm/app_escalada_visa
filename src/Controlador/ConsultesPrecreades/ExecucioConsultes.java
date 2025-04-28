package Controlador.ConsultesPrecreades;

import Vista.Vista;

import java.util.Scanner;

public class ExecucioConsultes {
    private static final Scanner scanner = new Scanner(System.in);

    public static void executarViesEscolaDisponible() {
        Vista.mostrarMissatge("Introdueix el nom de l'escola:");
        String nomEscola = scanner.nextLine();
        ConsultesPrecreades.mostrarViesEscolaDisponible(nomEscola);
    }

    public static void executarViesPerDificultat() {
        Vista.mostrarMissatge("Introdueix el nivell de dificultat:");
        String dificultat = scanner.nextLine();
        ConsultesPrecreades.cercarViesPerDificultat(dificultat);
    }

    public static void executarViesPerEstat() {
        Vista.mostrarMissatge("Introdueix l'estat de la via (exemple: Apte, En obres, Tancada):");
        String estat = scanner.nextLine();
        ConsultesPrecreades.cercarViesPerEstat(estat);
    }

    public static void executarEscolesAmbRestriccions() {
        ConsultesPrecreades.consultarEscolesAmbRestriccions();
    }

    public static void executarSectorsMesDeXVies() {
        Vista.mostrarMissatge("Introdueix el nombre mínim de vies:");
        int x = Integer.parseInt(scanner.nextLine());
        ConsultesPrecreades.mostrarSectorsAmbMesDeXVies(x);
    }

    public static void executarEscaladorsPerNivellMaxim() {
        Vista.mostrarMissatge("Introdueix el nivell màxim:");
        String nivellMaxim = scanner.nextLine();
        ConsultesPrecreades.mostrarEscaladorsAmbNivellMaxim(nivellMaxim);
    }

    public static void executarViesMesLlarguesEscola() {
        Vista.mostrarMissatge("Introdueix el nom de l'escola:");
        String nomEscola = scanner.nextLine();
        ConsultesPrecreades.mostrarViesMesLlarguesEscola(nomEscola);
    }
}