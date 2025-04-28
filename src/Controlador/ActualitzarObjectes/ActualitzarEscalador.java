package Controlador.ActualitzarObjectes;

import Model.Constructors.Escalador;
import Model.DAO.EscaladorDAO;
import Model.DAO.ViaDAO;
import Model.Exceptions.NoExisteix;
import Vista.Vista;

import java.util.List;
import java.util.Scanner;

public class ActualitzarEscalador {
    public static void actualizarEscalador() {
        Scanner scanner = new Scanner(System.in);
        ViaDAO viaDAO = new ViaDAO();

        Vista.mostrarMissatge("Introdueix el nom de l'escalador que vols actualitzar:");
        String nom = scanner.nextLine();

        List<Escalador> escaladors = EscaladorDAO.llistarPerNom(nom);

        if (escaladors.isEmpty()) {
            Vista.mostrarMissatge("No s'ha trobat cap escalador amb aquest nom.");
            return;
        }

        if (escaladors.size() > 1) {
            Vista.mostrarMissatge("S'ha trobat més d'un escalador amb el nom '" + nom + "'. Selecciona el número de l'escalador:");
            for (int i = 0; i < escaladors.size(); i++) {
                Vista.mostrarMissatge((i + 1) + ". ID: " + escaladors.get(i).getIdEscalador() + " | Nom: " + escaladors.get(i).getNom());
            }

            int eleccio = scanner.nextInt();
            scanner.nextLine();

            if (eleccio < 1 || eleccio > escaladors.size()) {
                Vista.mostrarMissatge("Opció invàlida. No es pot actualitzar.");
                return;
            }

            Escalador escalador = escaladors.get(eleccio - 1);
            actualizarEscaladorDetails(escalador, scanner, viaDAO);
        } else {
            Escalador escalador = escaladors.get(0);
            actualizarEscaladorDetails(escalador, scanner, viaDAO);
        }
    }

    private static void actualizarEscaladorDetails(Escalador escalador, Scanner scanner, ViaDAO viaDAO) {
        EscaladorDAO escaladorDAO = new EscaladorDAO();

        Vista.mostrarMissatge("Àlies actual: " + escalador.getAlies());
        Vista.mostrarMissatge("Nou àlies (deixa buit per mantenir):");
        String alies = scanner.nextLine();
        if (alies.isEmpty()) alies = escalador.getAlies();

        Vista.mostrarMissatge("Edat actual: " + escalador.getEdat());
        Vista.mostrarMissatge("Nova edat (deixa buit per mantenir):");
        String novaEdat = scanner.nextLine();
        int edat = novaEdat.isEmpty() ? escalador.getEdat() : Integer.parseInt(novaEdat);

        Vista.mostrarMissatge("Nivell màxim actual: " + escalador.getNivellMaxim());
        Vista.mostrarMissatge("Nou nivell màxim (deixa buit per mantenir):");
        String nivell = scanner.nextLine();
        if (nivell.isEmpty()) nivell = escalador.getNivellMaxim();

        Vista.mostrarMissatge("ID via més difícil actual: " + escalador.getViaNivellMaxim());
        Vista.mostrarMissatge("Nom nova via més difícil (deixa buit per mantenir):");
        String via = scanner.nextLine();
        int idVia = escalador.getViaNivellMaxim();
        if (!via.isEmpty()) {
            try {
                idVia = viaDAO.obtenirPerNom(via);
            } catch (NoExisteix e) {
                Vista.mostrarMissatge("No s'ha trobat la via. Es manté la via anterior.");
            }
        }

        Vista.mostrarMissatge("Estil preferit actual: " + escalador.getEstilPreferit());
        Vista.mostrarMissatge("Nou estil preferit (deixa buit per mantenir):");
        String estil = scanner.nextLine();
        if (estil.isEmpty()) estil = escalador.getEstilPreferit();

        Escalador escaladorActualitzat = new Escalador(
                escalador.getIdEscalador(),
                escalador.getNom(),
                alies,
                edat,
                nivell,
                idVia,
                estil
        );

        escaladorDAO.actualitzar(escaladorActualitzat);
        Vista.mostrarMissatge("Escalador actualitzat correctament.");
    }
}