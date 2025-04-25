package Controlador.LlistarTots;

import Model.Constructors.Sector;
import Model.DAO.SectorDAO;
import Vista.Vista;

import java.util.List;

public class LlistarTotsSector {
    public static void llistarTotsSectors() {
        SectorDAO sectorDAO = new SectorDAO();
        List<Sector> sectors = sectorDAO.llistarTots();

        if (sectors.isEmpty()) {
            Vista.mostrarMissatge("No hi ha sectors per mostrar.");
        } else {
            Vista.mostrarMissatge("Llistat de tots els sectors:");
            for (Sector s : sectors) {
                Vista.mostrarMissatge("ID: " + s.getIdSector() + " | Nom: " + s.getNom() +
                        " | Coordenades: " + s.getCoordenades() + " | Aproximació: " + s.getAproximacio());
            }
        }
    }
}
