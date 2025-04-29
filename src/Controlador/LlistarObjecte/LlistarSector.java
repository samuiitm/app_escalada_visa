package Controlador.LlistarObjecte;

import Model.Constructors.Sector;
import Model.DAO.EscolaDAO;
import Model.DAO.SectorDAO;
import Vista.Vista;

import java.util.List;
import java.util.Scanner;

public class LlistarSector {
    public static void llistarSector() {
        Scanner scanner = new Scanner(System.in);

        Vista.mostrarMissatge("Digues el nom del sector:");
        String nom = scanner.nextLine();

        SectorDAO sectorDAO = new SectorDAO();

        EscolaDAO escolaDAO = new EscolaDAO();

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

            Vista.mostrarMissatge("Introdueix l'ID del sector que vols veure:");
            int idSector = Integer.parseInt(scanner.nextLine());

            Sector sector = sectorDAO.obtenir(idSector);
            if (sector != null) {
                Vista.mostrarMissatge("Informació del sector:");
                Vista.mostrarMissatge("Nom: " + sector.getNom());
                Vista.mostrarMissatge("Coordenades: " + sector.getCoordenades());
                Vista.mostrarMissatge("Aproximació: " + sector.getAproximacio());
                Vista.mostrarMissatge("Nombre de vies: " + sector.getNumeroVies());
                Vista.mostrarMissatge("Popularitat: " + sector.getPopularitat());
                Vista.mostrarMissatge("Restriccions: " + sector.getRestriccions());
                Vista.mostrarMissatge("ID Escola: " + escolaDAO.obtenirPerId(sector.getIdEscola()));
            } else {
                Vista.mostrarMissatge("ID no vàlid.");
            }
        } else {
            Sector sector = sectors.get(0);
            Vista.mostrarMissatge("Informació del sector:");
            Vista.mostrarMissatge("Nom: " + sector.getNom());
            Vista.mostrarMissatge("Coordenades: " + sector.getCoordenades());
            Vista.mostrarMissatge("Aproximació: " + sector.getAproximacio());
            Vista.mostrarMissatge("Nombre de vies: " + sector.getNumeroVies());
            Vista.mostrarMissatge("Popularitat: " + sector.getPopularitat());
            Vista.mostrarMissatge("Restriccions: " + sector.getRestriccions());
            Vista.mostrarMissatge("ID Escola: " + escolaDAO.obtenirPerId(sector.getIdEscola()));
        }
    }
}