package Controlador.LlistarObjecte;

import Model.Constructors.Escola;
import Model.DAO.EscolaDAO;
import Vista.Vista;

import java.util.Scanner;

public class LlistarEscola {
    public static void llistarEscola() {
        Scanner scanner = new Scanner(System.in);

        Vista.mostrarMissatge("Digues el nom de l'escola:");
        String nom = scanner.nextLine();

        EscolaDAO escolaDAO = new EscolaDAO();

        int id = escolaDAO.obtenirPerNom(nom);
        Escola escola = escolaDAO.obtenir(id);

        if (escola != null) {
            Vista.mostrarMissatge("Informació de l'escola:");
            Vista.mostrarMissatge("Nom: " + escola.getNom());
            Vista.mostrarMissatge("ID Localització: " + escola.getIdLocalitzacio());
            Vista.mostrarMissatge("Aproximació: " + escola.getAproximacio());
            Vista.mostrarMissatge("Nombre de vies: " + escola.getNumeroVies());
            Vista.mostrarMissatge("Popularitat: " + escola.getPopularitat());
            Vista.mostrarMissatge("Restriccions: " + escola.getRestriccions());
        } else {
            Vista.mostrarMissatge("Escola no trobada.");
        }
    }
}