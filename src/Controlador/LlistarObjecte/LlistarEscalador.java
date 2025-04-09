package Controlador.LlistarObjecte;

import Model.Constructors.Escalador;
import Model.DAO.EscaladorDAO;
import Vista.Vista;

import java.util.Scanner;


public class LlistarEscalador {
    public static void llistarEscalador() {
        Scanner scanner = new Scanner(System.in);

        Vista.mostrarMissatge("Digues el nom de l'escalador:");
        String nom = scanner.nextLine();

        EscaladorDAO escaladorDAO = new EscaladorDAO();

        int id = escaladorDAO.obtenirPerNom(nom);
        Escalador escalador = escaladorDAO.obtenir(id);

        if(escalador != null) {
            Vista.mostrarMissatge("Informació de l'escalador:");
            Vista.mostrarMissatge("Nom: " + escalador.getNom());
            Vista.mostrarMissatge("Àlies: " + escalador.getAlies());
            Vista.mostrarMissatge("Edat: " + escalador.getEdat());
            Vista.mostrarMissatge("Nivell màxim: " + escalador.getNivellMaxim());
            Vista.mostrarMissatge("ID de la via més difícil: " + escalador.getViaNivellMaxim());
            Vista.mostrarMissatge("Estil preferit: " + escalador.getEstilPreferit());
        } else {
            Vista.mostrarMissatge("Escalador no trobat.");
        }
    }
}
