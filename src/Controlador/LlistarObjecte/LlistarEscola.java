package Controlador.LlistarObjecte;

import Model.Constructors.Escola;
import Model.DAO.EscolaDAO;
import Model.DAO.LocalitzacioDAO;
import Vista.Vista;

import java.util.List;
import java.util.Scanner;

public class LlistarEscola {
    public static void llistarEscola() {
        Scanner scanner = new Scanner(System.in);

        Vista.mostrarMissatge("Digues el nom de l'escola:");
        String nom = scanner.nextLine();

        EscolaDAO escolaDAO = new EscolaDAO();
        LocalitzacioDAO localitzacioDAO = new LocalitzacioDAO();

        List<Escola> escoles = EscolaDAO.llistarPerNom(nom);

        if (escoles.isEmpty()) {
            Vista.mostrarMissatge("No s'ha trobat cap escola amb aquest nom.");
            return;
        }

        if (escoles.size() > 1) {
            Vista.mostrarMissatge("Escoles trobades:");
            for (Escola e : escoles) {
                Vista.mostrarMissatge("ID: " + e.getIdEscola() + " | Nom: " + e.getNom() +
                        " | Localització: " + escolaDAO.obtenirPerId(e.getIdLocalitzacio()));
            }

            Vista.mostrarMissatge("Introdueix l'ID de l'escola que vols veure:");
            int idEscola = Integer.parseInt(scanner.nextLine());

            Escola escola = escolaDAO.obtenir(idEscola);
            if (escola != null) {
                Vista.mostrarMissatge("Informació de l'escola:");
                Vista.mostrarMissatge("Nom: " + escola.getNom());
                Vista.mostrarMissatge("ID Localització: " + localitzacioDAO.obtenirPerId(escola.getIdLocalitzacio()));
                Vista.mostrarMissatge("Aproximació: " + escola.getAproximacio());
                Vista.mostrarMissatge("Nombre de vies: " + escola.getNumeroVies());
                Vista.mostrarMissatge("Popularitat: " + escola.getPopularitat());
                Vista.mostrarMissatge("Restriccions: " + escola.getRestriccions());
            } else {
                Vista.mostrarMissatge("ID no vàlid.");
            }
        } else {
            Escola escola = escoles.get(0);
            Vista.mostrarMissatge("Informació de l'escola:");
            Vista.mostrarMissatge("Nom: " + escola.getNom());
            Vista.mostrarMissatge("ID Localització: " + localitzacioDAO.obtenirPerId(escola.getIdLocalitzacio()));
            Vista.mostrarMissatge("Aproximació: " + escola.getAproximacio());
            Vista.mostrarMissatge("Nombre de vies: " + escola.getNumeroVies());
            Vista.mostrarMissatge("Popularitat: " + escola.getPopularitat());
            Vista.mostrarMissatge("Restriccions: " + escola.getRestriccions());
        }
    }
}