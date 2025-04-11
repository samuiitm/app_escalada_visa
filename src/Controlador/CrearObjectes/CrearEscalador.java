package Controlador.CrearObjectes;

import Model.Constructors.Escalador;
import Model.DAO.EscaladorDAO;
import Model.DAO.ViaDAO;
import Vista.Vista;

import java.util.Scanner;

public class CrearEscalador {
    public static void crearEscalador() {
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

        Vista.mostrarMissatge("Nom de la via més difícil:");
        String nomViaMax = scanner.nextLine();
        int idViaMax = viaDAO.obtenirPerNom(nomViaMax);

        Vista.mostrarMissatge("Estil preferit (Esportiva, Clàssica, Gel):");
        String estil = scanner.nextLine();

        Escalador escalador = new Escalador(nom, alies, edat, nivell, idViaMax, estil);

        escaladorDAO.inserir(escalador);

        Vista.mostrarMissatge("Escalador creat correctament.");
    }
}