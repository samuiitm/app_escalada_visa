package Controlador.ActualitzarObjectes;

import Model.Constructors.Escola;
import Model.DAO.EscolaDAO;
import Vista.Vista;
import Model.Exceptions.NoExisteix;

import java.util.Scanner;

public class ActualitzarEscola {
    public static void actualizarEscola() {
        Scanner scanner = new Scanner(System.in);
        EscolaDAO escolaDAO = new EscolaDAO();

        Vista.mostrarMissatge("Introdueix el nom de l'escola que vols actualitzar:");
        String nom = scanner.nextLine();

        Escola escola;
        try {
            int id = escolaDAO.obtenirPerNom(nom);
            escola = escolaDAO.obtenir(id);
        } catch (NoExisteix e) {
            Vista.mostrarMissatge(e.getMessage());
            return;
        }

        Vista.mostrarMissatge("Localització actual: " + escola.getIdLocalitzacio());
        Vista.mostrarMissatge("Introdueix nova localització (deixa buit per mantenir):");
        String novaLocalitzacio = scanner.nextLine();
        int idLocalitzacio = novaLocalitzacio.isEmpty() ? escola.getIdLocalitzacio() : Integer.parseInt(novaLocalitzacio);

        Vista.mostrarMissatge("Aproximació actual: " + escola.getAproximacio());
        Vista.mostrarMissatge("Nova aproximació (deixa buit per mantenir):");
        String aproximacio = scanner.nextLine();
        if (aproximacio.isEmpty()) aproximacio = escola.getAproximacio();

        Vista.mostrarMissatge("Número de vies actual: " + escola.getNumeroVies());
        Vista.mostrarMissatge("Nou número de vies (deixa buit per mantenir):");
        String nouNumeroVies = scanner.nextLine();
        int numeroVies = nouNumeroVies.isEmpty() ? escola.getNumeroVies() : Integer.parseInt(nouNumeroVies);

        Vista.mostrarMissatge("Popularitat actual: " + escola.getPopularitat());
        Vista.mostrarMissatge("Nova popularitat (deixa buit per mantenir):");
        String popularitat = scanner.nextLine();
        if (popularitat.isEmpty()) popularitat = escola.getPopularitat();

        Vista.mostrarMissatge("Restriccions actuals: " + escola.getRestriccions());
        Vista.mostrarMissatge("Noves restriccions (deixa buit per mantenir):");
        String restriccions = scanner.nextLine();
        if (restriccions.isEmpty()) restriccions = escola.getRestriccions();

        Escola escolaActualitzada = new Escola(escola.getIdEscola(), nom, idLocalitzacio, aproximacio, numeroVies, popularitat, restriccions);
        escolaDAO.actualitzar(escolaActualitzada);

        Vista.mostrarMissatge("Escola actualitzada correctament.");
    }
}