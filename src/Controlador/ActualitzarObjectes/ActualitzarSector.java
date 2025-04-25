package Controlador.ActualitzarObjectes;

import Model.Constructors.Sector;
import Model.DAO.EscolaDAO;
import Model.DAO.SectorDAO;
import Model.Exceptions.NoExisteix;
import Vista.Vista;

import java.util.List;
import java.util.Scanner;

public class ActualitzarSector {
    public static void actualitzarSector() {
        Scanner scanner = new Scanner(System.in);
        SectorDAO sectorDAO = new SectorDAO();
        EscolaDAO escolaDAO = new EscolaDAO();

        Vista.mostrarMissatge("Introdueix el nom del sector que vols actualitzar:");
        String nom = scanner.nextLine();

        List<Sector> sectors = sectorDAO.llistarPerNom(nom);

        if (sectors.isEmpty()) {
            Vista.mostrarMissatge("No s'ha trobat cap sector amb aquest nom.");
            return;
        }

        if (sectors.size() > 1) {
            Vista.mostrarMissatge("S'ha trobat més d'un sector amb el nom '" + nom + "'. Selecciona el número del sector:");
            for (int i = 0; i < sectors.size(); i++) {
                Vista.mostrarMissatge((i + 1) + ". ID: " + sectors.get(i).getIdSector() + " | Coordenades: " + sectors.get(i).getCoordenades());
            }

            int eleccio = scanner.nextInt();
            scanner.nextLine();

            if (eleccio < 1 || eleccio > sectors.size()) {
                Vista.mostrarMissatge("Opció invàlida. No es pot actualitzar.");
                return;
            }

            Sector sector = sectors.get(eleccio - 1);
            actualitzarSectorDetails(sector, scanner, escolaDAO);
        } else {
            Sector sector = sectors.get(0);
            actualitzarSectorDetails(sector, scanner, escolaDAO);
        }
    }

    private static void actualitzarSectorDetails(Sector sector, Scanner scanner, EscolaDAO escolaDAO) {
        SectorDAO sectorDAO = new SectorDAO();

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
                sector.getNom(),
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