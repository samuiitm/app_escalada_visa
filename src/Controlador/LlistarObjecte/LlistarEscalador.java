package Controlador.LlistarObjecte;

import Model.DAO.EscaladorDAO;
import Vista.Vista;

import java.util.Scanner;


public class LlistarEscalador {
    public static void llistarEscalador() {
        Scanner scanner = new Scanner(System.in);

        Vista.mostrarMissatge("Digues el nom de l'escalador:");
        String nom = scanner.nextLine();

        EscaladorDAO escaladorDAO = new EscaladorDAO();
    }
}
