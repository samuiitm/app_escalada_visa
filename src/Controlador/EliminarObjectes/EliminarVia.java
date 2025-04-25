package Controlador.EliminarObjectes;

import Model.Constructors.Via;
import Model.DAO.ViaDAO;
import Vista.Vista;

import java.util.List;
import java.util.Scanner;

public class EliminarVia {

    public static void eliminarVia() {
        Scanner scanner = new Scanner(System.in);
        ViaDAO viaDAO = new ViaDAO();

        Vista.mostrarMissatge("Introdueix el nom de la via que vols eliminar:");
        String nom = scanner.nextLine();

        List<Via> vies = viaDAO.llistarPerNom(nom);

        if (vies.isEmpty()) {
            Vista.mostrarMissatge("No s'ha trobat cap via amb aquest nom.");
            return;
        }

        Vista.mostrarMissatge("Vies trobades:");
        for (Via v : vies) {
            Vista.mostrarMissatge("ID: " + v.getIdVia() + " | Nom: " + v.getNom() +
                    " | Orientació: " + v.getOrientacio());
        }

        Vista.mostrarMissatge("Introdueix l'ID de la via que vols eliminar:");
        int idVia = Integer.parseInt(scanner.nextLine());

        boolean trobat = vies.stream().anyMatch(v -> v.getIdVia() == idVia);
        if (!trobat) {
            Vista.mostrarMissatge("ID no vàlid.");
            return;
        }

        viaDAO.eliminar(idVia);
        Vista.mostrarMissatge("Via eliminada correctament.");
    }
}