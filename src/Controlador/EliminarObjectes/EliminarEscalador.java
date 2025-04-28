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

        List<Escalador> escaladors = EscaladorDAO.llistarPerNom(nom);

        if (escaladors.isEmpty()) {
            Vista.mostrarMissatge("No s'ha trobat cap escalador amb aquest nom.");
            return;
        }

        if (escaladors.size() > 1) {
            Vista.mostrarMissatge("S'han trobat múltiples escaladors amb aquest nom:");
            for (int i = 0; i < escaladors.size(); i++) {
                Escalador e = escaladors.get(i);
                Vista.mostrarMissatge((i + 1) + ". ID: " + e.getIdEscalador() + " | Àlies: " + e.getAlies() + " | Edat: " + e.getEdat());
            }

            Vista.mostrarMissatge("Selecciona el número de l'escalador que vols eliminar:");
            int eleccio = Integer.parseInt(scanner.nextLine());

            if (eleccio < 1 || eleccio > escaladors.size()) {
                Vista.mostrarMissatge("Selecció no vàlida.");
                return;
            }

            escaladorDAO.eliminar(escaladors.get(eleccio - 1).getIdEscalador());
        } else {
            escaladorDAO.eliminar(escaladors.get(0).getIdEscalador());
        }

        Vista.mostrarMissatge("Escalador eliminat correctament.");
    }
}