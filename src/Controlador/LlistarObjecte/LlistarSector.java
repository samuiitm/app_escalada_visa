package Controlador.LlistarObjecte;

import Model.Constructors.Sector;
import Model.DAO.SectorDAO;
import Vista.Vista;

import java.util.Scanner;

public class LlistarSector {
    public static void llistarSector() {
        Scanner scanner = new Scanner(System.in);

        Vista.mostrarMissatge("Digues el nom del sector:");
        String nom = scanner.nextLine();

        SectorDAO sectorDAO = new SectorDAO();

        int id = sectorDAO.obtenirPerNom(nom);
        Sector sector = sectorDAO.obtenir(id);

        if (sector != null) {
            Vista.mostrarMissatge("Informació del sector:");
            Vista.mostrarMissatge("Nom: " + sector.getNom());
            Vista.mostrarMissatge("Coordenades: " + sector.getCoordenades());
            Vista.mostrarMissatge("Aproximació: " + sector.getAproximacio());
            Vista.mostrarMissatge("Nombre de vies: " + sector.getNumeroVies());
            Vista.mostrarMissatge("Popularitat: " + sector.getPopularitat());
            Vista.mostrarMissatge("Restriccions: " + sector.getRestriccions());
            Vista.mostrarMissatge("ID Escola: " + sector.getIdEscola());
        } else {
            Vista.mostrarMissatge("Sector no trobat.");
        }
    }
}