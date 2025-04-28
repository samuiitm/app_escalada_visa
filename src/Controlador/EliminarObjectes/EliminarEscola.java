package Controlador.EliminarObjectes;

import Model.Constructors.Escola;
import Model.DAO.EscolaDAO;
import Vista.Vista;

import java.util.List;
import java.util.Scanner;

public class EliminarEscola {

    public static void eliminarEscola() {
        Scanner scanner = new Scanner(System.in);
        EscolaDAO escolaDAO = new EscolaDAO();

        Vista.mostrarMissatge("Introdueix el nom de l'escola que vols eliminar:");
        String nom = scanner.nextLine();

        List<Escola> escoles = EscolaDAO.llistarPerNom(nom);

        if (escoles.isEmpty()) {
            Vista.mostrarMissatge("No s'ha trobat cap escola amb aquest nom.");
            return;
        }

        if (escoles.size() > 1) {
            Vista.mostrarMissatge("Escoles trobades:");
            for (Escola e : escoles) {
                Vista.mostrarMissatge("ID: " + e.getIdEscola() + " | Nom: " + e.getNom() +
                        " | Localització: " + e.getIdLocalitzacio());
            }

            Vista.mostrarMissatge("Introdueix l'ID de l'escola que vols eliminar:");
            int idEscola = Integer.parseInt(scanner.nextLine());

            boolean trobat = escoles.stream().anyMatch(e -> e.getIdEscola() == idEscola);
            if (!trobat) {
                Vista.mostrarMissatge("ID no vàlid.");
                return;
            }

            escolaDAO.eliminar(idEscola);
        } else {
            escolaDAO.eliminar(escoles.get(0).getIdEscola());
        }

        Vista.mostrarMissatge("Escola eliminada correctament.");
    }
}