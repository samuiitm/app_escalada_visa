package Controlador.EliminarObjectes;

import java.util.Scanner;
import Model.DAO.EscolaDAO;
import Vista.Vista;

public class EliminarEscola {

    public static void eliminarEscola() {
        Scanner scanner = new Scanner(System.in);

        Vista.mostrarMissatge("Introdueix l'ID de l'escola que vols eliminar:");
        int idEscola = Integer.parseInt(scanner.nextLine());

        EscolaDAO escolaDAO = new EscolaDAO();
        escolaDAO.eliminar(idEscola);

        Vista.mostrarMissatge("Escola eliminada correctament.");
    }
}