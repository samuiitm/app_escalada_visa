package Controlador.EliminarObjectes;

import java.util.Scanner;
import Model.DAO.ViaDAO;
import Vista.Vista;

public class EliminarVia {

    public static void eliminarVia() {
        Scanner scanner = new Scanner(System.in);

        Vista.mostrarMissatge("Introdueix l'ID de la via que vols eliminar:");
        int idVia = Integer.parseInt(scanner.nextLine());

        ViaDAO viaDAO = new ViaDAO();
        viaDAO.eliminar(idVia);

        Vista.mostrarMissatge("Via eliminada correctament.");
    }
}