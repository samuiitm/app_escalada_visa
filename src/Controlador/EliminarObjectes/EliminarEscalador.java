package Controlador.EliminarObjectes;

import java.util.List;
import java.util.Scanner;
import Model.Constructors.Escalador;
import Model.DAO.EscaladorDAO;
import Vista.Vista;

public class EliminarEscalador {

    public static void eliminarEscalador() {
        Scanner scanner = new Scanner(System.in);
        EscaladorDAO escaladorDAO = new EscaladorDAO();

        Vista.mostrarMissatge("Introdueix el nom de l'escalador que vols eliminar:");
        String nom = scanner.nextLine();

        List<Escalador> escaladors = escaladorDAO.llistarPerNom(nom);

        if (escaladors.isEmpty()) {
            Vista.mostrarMissatge("No s'ha trobat cap escalador amb aquest nom.");
            return;
        }

        Vista.mostrarMissatge("Escaladors trobats:");
        for (Escalador e : escaladors) {
            Vista.mostrarMissatge("ID: " + e.getIdEscalador() + " | Nom: " + e.getNom() +
                    " | Àlies: " + e.getAlies() + " | Edat: " + e.getEdat());
        }

        Vista.mostrarMissatge("Introdueix l'ID de l'escalador que vols eliminar:");
        int idEscalador = Integer.parseInt(scanner.nextLine());

        boolean trobat = escaladors.stream().anyMatch(e -> e.getIdEscalador() == idEscalador);
        if (!trobat) {
            Vista.mostrarMissatge("ID no vàlid.");
            return;
        }

        escaladorDAO.eliminar(idEscalador);
        Vista.mostrarMissatge("Escalador eliminat correctament.");
    }
}