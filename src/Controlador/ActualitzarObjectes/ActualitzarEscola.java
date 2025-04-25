package Controlador.ActualitzarObjectes;

import Model.Constructors.Escola;
import Model.DAO.EscolaDAO;
import Model.Exceptions.NoExisteix;
import Vista.Vista;

import java.util.List;
import java.util.Scanner;

public class ActualitzarEscola {
    public static void actualizarEscola() {
        Scanner scanner = new Scanner(System.in);
        EscolaDAO escolaDAO = new EscolaDAO();

        Vista.mostrarMissatge("Introdueix el nom de l'escola que vols actualitzar:");
        String nom = scanner.nextLine();

        List<Escola> escoles = escolaDAO.llistarPerNom(nom);

        if (escoles.isEmpty()) {
            Vista.mostrarMissatge("No s'ha trobat cap escola amb aquest nom.");
            return;
        }

        if (escoles.size() > 1) {
            Vista.mostrarMissatge("S'ha trobat més d'una escola amb el nom '" + nom + "'. Selecciona el número de l'escola:");
            for (int i = 0; i < escoles.size(); i++) {
                Vista.mostrarMissatge((i + 1) + ". ID: " + escoles.get(i).getIdEscola() + " | Nom: " + escoles.get(i).getNom());
            }

            int eleccio = scanner.nextInt();
            scanner.nextLine();

            if (eleccio < 1 || eleccio > escoles.size()) {
                Vista.mostrarMissatge("Opció invàlida. No es pot actualitzar.");
                return;
            }

            Escola escola = escoles.get(eleccio - 1);
            actualizarEscolaDetails(escola, scanner);
        } else {
            Escola escola = escoles.get(0);
            actualizarEscolaDetails(escola, scanner);
        }
    }

    private static void actualizarEscolaDetails(Escola escola, Scanner scanner) {
        EscolaDAO escolaDAO = new EscolaDAO();

        Vista.mostrarMissatge("Nom actual: " + escola.getNom());
        Vista.mostrarMissatge("Nou nom (deixa buit per mantenir):");
        String nom = scanner.nextLine();
        if (nom.isEmpty()) nom = escola.getNom();

        Vista.mostrarMissatge("Aproximació actual: " + escola.getAproximacio());
        Vista.mostrarMissatge("Nova aproximació (deixa buit per mantenir):");
        String aproximacio = scanner.nextLine();
        if (aproximacio.isEmpty()) aproximacio = escola.getAproximacio();

        Vista.mostrarMissatge("Número de vies actual: " + escola.getNumeroVies());
        Vista.mostrarMissatge("Nou número de vies (deixa buit per mantenir):");
        String novaNumeroVies = scanner.nextLine();
        int numeroVies = novaNumeroVies.isEmpty() ? escola.getNumeroVies() : Integer.parseInt(novaNumeroVies);

        Vista.mostrarMissatge("Popularitat actual: " + escola.getPopularitat());
        Vista.mostrarMissatge("Nova popularitat (deixa buit per mantenir):");
        String popularitat = scanner.nextLine();
        if (popularitat.isEmpty()) popularitat = escola.getPopularitat();

        Escola escolaActualitzada = new Escola(
                escola.getIdEscola(),
                nom,
                escola.getIdLocalitzacio(),
                aproximacio,
                numeroVies,
                popularitat,
                escola.getRestriccions()
        );

        escolaDAO.actualitzar(escolaActualitzada);
        Vista.mostrarMissatge("Escola actualitzada correctament.");
    }
}