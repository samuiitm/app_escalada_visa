package Controlador.ActualitzarObjectes;

import Model.Constructors.Sector;
import Model.DAO.EscolaDAO;
import Model.DAO.SectorDAO;
import Model.Exceptions.NoExisteix;
import Vista.Vista;

import java.util.Scanner;

public class ActualitzarSector {
    public static void actualitzarSector() {
        Scanner scanner = new Scanner(System.in);
        SectorDAO sectorDAO = new SectorDAO();
        EscolaDAO escolaDAO = new EscolaDAO();

        Vista.mostrarMissatge("Introdueix el nom del sector que vols actualitzar:");
        String nom = scanner.nextLine();

        Sector sector;
        try {
            int id = sectorDAO.obtenirPerNom(nom);
            sector = sectorDAO.obtenir(id);
        } catch (NoExisteix e) {
            Vista.mostrarMissatge(e.getMessage());
            return;
        }

        Vista.mostrarMissatge("Coordenades actuals: " + sector.getCoordenades());
        Vista.mostrarMissatge("Noves coordenades (deixa buit per mantenir):");
        String coordenades = scanner.nextLine();
        if (coordenades.isEmpty()) coordenades = sector.getCoordenades();

        Vista.mostrarMissatge("Aproximació actual: " + sector.getAproximacio());
        Vista.mostrarMissatge("Nova aproximació (deixa buit per mantenir):");
        String aproximacio = scanner.nextLine();
        if (aproximacio.isEmpty()) aproximacio = sector.getAproximacio();

        Vista.mostrarMissatge("Número de vies actual: " + sector.getNumeroVies());
        Vista.mostrarMissatge("Nou número de vies (deixa buit per mantenir):");
        String nouNumeroVies = scanner.nextLine();
        int numeroVies = nouNumeroVies.isEmpty() ? sector.getNumeroVies() : Integer.parseInt(nouNumeroVies);

        Vista.mostrarMissatge("Popularitat actual: " + sector.getPopularitat());
        Vista.mostrarMissatge("Nova popularitat (deixa buit per mantenir):");
        String popularitat = scanner.nextLine();
        if (popularitat.isEmpty()) popularitat = sector.getPopularitat();

        Vista.mostrarMissatge("Restriccions actuals: " + sector.getRestriccions());
        Vista.mostrarMissatge("Noves restriccions (deixa buit per mantenir):");
        String restriccions = scanner.nextLine();
        if (restriccions.isEmpty()) restriccions = sector.getRestriccions();

        Vista.mostrarMissatge("Escola associada actual: " + sector.getIdEscola());
        Vista.mostrarMissatge("Nou nom d'escola associada (deixa buit per mantenir):");
        String novaEscola = scanner.nextLine();
        int idEscola = sector.getIdEscola();
        if (!novaEscola.isEmpty()) {
            try {
                idEscola = escolaDAO.obtenirPerNom(novaEscola);
            } catch (NoExisteix e) {
                Vista.mostrarMissatge("Escola no trobada. Es manté l'anterior.");
            }
        }

        Sector sectorActualitzat = new Sector(
                sector.getIdSector(),
                nom,
                coordenades,
                aproximacio,
                numeroVies,
                popularitat,
                restriccions,
                idEscola
        );

        sectorDAO.actualitzar(sectorActualitzat);
        Vista.mostrarMissatge("Sector actualitzat correctament.");
    }
}