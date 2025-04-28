package Controlador.EliminarObjectes;

import Model.Constructors.Sector;
import Model.DAO.SectorDAO;
import Vista.Vista;

import java.util.List;
import java.util.Scanner;

public class EliminarSector {

    public static void eliminarSector() {
        Scanner scanner = new Scanner(System.in);
        SectorDAO sectorDAO = new SectorDAO();

        Vista.mostrarMissatge("Introdueix el nom del sector que vols eliminar:");
        String nom = scanner.nextLine();

        List<Sector> sectors = SectorDAO.llistarPerNom(nom);

        if (sectors.isEmpty()) {
            Vista.mostrarMissatge("No s'ha trobat cap sector amb aquest nom.");
            return;
        }

        if (sectors.size() > 1) {
            Vista.mostrarMissatge("Sectors trobats:");
            for (Sector s : sectors) {
                Vista.mostrarMissatge("ID: " + s.getIdSector() + " | Nom: " + s.getNom() +
                        " | Coordenades: " + s.getCoordenades());
            }

            Vista.mostrarMissatge("Introdueix l'ID del sector que vols eliminar:");
            int idSector = Integer.parseInt(scanner.nextLine());

            boolean trobat = sectors.stream().anyMatch(s -> s.getIdSector() == idSector);
            if (!trobat) {
                Vista.mostrarMissatge("ID no vàlid.");
                return;
            }

            sectorDAO.eliminar(idSector);
        } else {
            sectorDAO.eliminar(sectors.get(0).getIdSector());
        }

        Vista.mostrarMissatge("Sector eliminat correctament.");
    }
}