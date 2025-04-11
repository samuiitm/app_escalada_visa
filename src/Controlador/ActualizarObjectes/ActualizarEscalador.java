package Controlador.ActualizarObjectes;

import Model.Constructors.Escalador;
import Model.DAO.EscaladorDAO;
import Model.DAO.ViaDAO;
import Vista.Vista;

import java.util.Scanner;

public class ActualizarEscalador {
    public static void actualizarEscalador() {
        EscaladorDAO escaladorDAO = new EscaladorDAO();
        ViaDAO viaDAO = new ViaDAO();

        Scanner scanner = new Scanner(System.in);

        Vista.mostrarMissatge("Introdueix el nom:");
        String nom = scanner.nextLine();

        Vista.mostrarMissatge("Àlies:");
        String alies = scanner.nextLine();

        Vista.mostrarMissatge("Edat:");
        int edat = Integer.parseInt(scanner.nextLine());

        Vista.mostrarMissatge("Nivell màxim:");
        String nivell = scanner.nextLine();

        Vista.mostrarMissatge("Via més difícil: (nom)");
        String viaMax = scanner.nextLine();
        int idViaMax = viaDAO.obtenirPerNom(viaMax);

        Vista.mostrarMissatge("Estil preferit (Esportiva, Clàssica, Gel):");
        String estil = scanner.nextLine();

        int id = escaladorDAO.obtenirPerNom(nom);
        Escalador escalador = new Escalador(id, nom, alies, edat, nivell, idViaMax, estil);

        escaladorDAO.actualitzar(escalador);

        Vista.mostrarMissatge("Escalador actualitzat correctament.");
    }
}
