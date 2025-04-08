package Controlador.CrearObjectes;

import Model.Constructors.Escalador;
import Model.DAO.EscaladorDAO;
import Vista.Vista;

import java.util.Scanner;

public class CrearEscalador {
    public static void crearEscalador() {
        Scanner scanner = new Scanner(System.in);

        Vista.mostrarMissatge("Introdueix el nom:");
        String nom = scanner.nextLine();

        Vista.mostrarMissatge("Àlies:");
        String alies = scanner.nextLine();

        Vista.mostrarMissatge("Edat:");
        int edat = Integer.parseInt(scanner.nextLine());

        Vista.mostrarMissatge("Nivell màxim:");
        String nivell = scanner.nextLine();

        Vista.mostrarMissatge("ID de la via més difícil:");
        int viaMax = Integer.parseInt(scanner.nextLine());

        Vista.mostrarMissatge("Estil preferit (Esportiva, Clàssica, Gel):");
        String estil = scanner.nextLine();

        Escalador escalador = new Escalador(nom, alies, edat, nivell, viaMax, estil);

        EscaladorDAO escaladorDAO = new EscaladorDAO();
        escaladorDAO.inserir(escalador);

        Vista.mostrarMissatge("Escalador creat correctament.");
    }
}