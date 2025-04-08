package Controlador.EliminarObjectes;

import java.util.Scanner;
import Model.DAO.EscaladorDAO;
import Vista.Vista;

public class EliminarEscalador {

    public static void eliminarEscalador() {
        Scanner scanner = new Scanner(System.in);

        Vista.mostrarMissatge("Introdueix l'ID de l'escalador que vols eliminar:");
        int idEscalador = Integer.parseInt(scanner.nextLine());

        EscaladorDAO escaladorDAO = new EscaladorDAO();
        escaladorDAO.eliminar(idEscalador);

        Vista.mostrarMissatge("Escalador eliminat correctament.");
    }
}