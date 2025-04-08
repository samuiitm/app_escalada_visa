package Controlador.CrearObjectes;

import Model.Constructors.Via;
import Model.DAO.ViaDAO;
import Vista.Vista;

import java.util.Scanner;

public class CrearVia {
    public static void crearVia() {
        Scanner scanner = new Scanner(System.in);

        Vista.mostrarMissatge("Introdueix el nom de la via:");
        String nom = scanner.nextLine();

        Vista.mostrarMissatge("ID del tipus de via:");
        int tipusVia = Integer.parseInt(scanner.nextLine());

        Vista.mostrarMissatge("Estat de la via (Ex: Bona, En mal estat):");
        String estat = scanner.nextLine();

        Vista.mostrarMissatge("Orientació de la via (Ex: Nord, Sud, Llevant, Ponent):");
        String orientacio = scanner.nextLine();

        Vista.mostrarMissatge("ID d'ancoratge:");
        int ancoratge = Integer.parseInt(scanner.nextLine());

        Vista.mostrarMissatge("ID del tipus de roca:");
        int tipusRoca = Integer.parseInt(scanner.nextLine());

        Vista.mostrarMissatge("ID del sector:");
        int sector = Integer.parseInt(scanner.nextLine());

        Vista.mostrarMissatge("ID del material utilitzat:");
        int material = Integer.parseInt(scanner.nextLine());

        Vista.mostrarMissatge("ID del creador:");
        int creador = Integer.parseInt(scanner.nextLine());

        Via via = new Via(nom, tipusVia, estat, orientacio, ancoratge, tipusRoca, sector, material, creador);

        ViaDAO viaDAO = new ViaDAO();
        viaDAO.inserir(via);

        Vista.mostrarMissatge("Via creada correctament.");
    }
}
