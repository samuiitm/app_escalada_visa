package Controlador.LlistarObjecte;

import Model.Constructors.Escalador;
import Model.DAO.EscaladorDAO;
import Vista.Vista;

import java.util.List;
import java.util.Scanner;

public class LlistarEscalador {
    public static void llistarEscalador() {
        Scanner scanner = new Scanner(System.in);

        Vista.mostrarMissatge("Digues el nom de l'escalador:");
        String nom = scanner.nextLine();

        EscaladorDAO escaladorDAO = new EscaladorDAO();

        List<Escalador> escaladors = EscaladorDAO.llistarPerNom(nom);

        if (escaladors.isEmpty()) {
            Vista.mostrarMissatge("No s'ha trobat cap escalador amb aquest nom.");
            return;
        }

        if (escaladors.size() > 1) {
            Vista.mostrarMissatge("Escaladors trobats:");
            for (Escalador e : escaladors) {
                Vista.mostrarMissatge("ID: " + e.getIdEscalador() + " | Nom: " + e.getNom() +
                        " | Àlies: " + e.getAlies() + " | Edat: " + e.getEdat());
            }

            Vista.mostrarMissatge("Introdueix l'ID de l'escalador que vols veure:");
            int idEscalador = Integer.parseInt(scanner.nextLine());

            Escalador escalador = escaladorDAO.obtenir(idEscalador);
            if (escalador != null) {
                Vista.mostrarMissatge("Informació de l'escalador:");
                Vista.mostrarMissatge("Nom: " + escalador.getNom());
                Vista.mostrarMissatge("Àlies: " + escalador.getAlies());
                Vista.mostrarMissatge("Edat: " + escalador.getEdat());
                Vista.mostrarMissatge("Nivell màxim: " + escalador.getNivellMaxim());
                Vista.mostrarMissatge("ID de la via més difícil: " + escalador.getViaNivellMaxim());
                Vista.mostrarMissatge("Estil preferit: " + escalador.getEstilPreferit());
            } else {
                Vista.mostrarMissatge("ID no vàlid.");
            }
        } else {
            Escalador escalador = escaladors.get(0);
            Vista.mostrarMissatge("Informació de l'escalador:");
            Vista.mostrarMissatge("Nom: " + escalador.getNom());
            Vista.mostrarMissatge("Àlies: " + escalador.getAlies());
            Vista.mostrarMissatge("Edat: " + escalador.getEdat());
            Vista.mostrarMissatge("Nivell màxim: " + escalador.getNivellMaxim());
            Vista.mostrarMissatge("ID de la via més difícil: " + escalador.getViaNivellMaxim());
            Vista.mostrarMissatge("Estil preferit: " + escalador.getEstilPreferit());
        }
    }
}