package Controlador.EliminarObjectes;

import java.util.Scanner;
import Model.DAO.SectorDAO;
import Vista.Vista;

public class EliminarSector {

    public static void eliminarSector() {
        Scanner scanner = new Scanner(System.in);

        Vista.mostrarMissatge("Introdueix l'ID del sector que vols eliminar:");
        int idSector = Integer.parseInt(scanner.nextLine());

        SectorDAO sectorDAO = new SectorDAO();
        sectorDAO.eliminar(idSector);

        Vista.mostrarMissatge("Sector eliminat correctament.");
    }
}