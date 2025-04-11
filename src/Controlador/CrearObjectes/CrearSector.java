package Controlador.CrearObjectes;

import Model.Constructors.Sector;
import Model.DAO.EscolaDAO;
import Model.DAO.SectorDAO;
import Model.Exceptions.NoExisteix;
import Vista.Vista;

import java.util.Scanner;

public class CrearSector {
    public static void crearSector() {
        SectorDAO sectorDAO = new SectorDAO();
        EscolaDAO escolaDAO = new EscolaDAO();
        Scanner scanner = new Scanner(System.in);

        Vista.mostrarMissatge("Introdueix el nom del sector:");
        String nom = scanner.nextLine();

        Vista.mostrarMissatge("Coordenades del sector:");
        String coordenades = scanner.nextLine();

        Vista.mostrarMissatge("Aproximació al sector:");
        String aproximacio = scanner.nextLine();

        Vista.mostrarMissatge("Nombre de vies al sector:");
        int numeroVies = Integer.parseInt(scanner.nextLine());

        Vista.mostrarMissatge("Popularitat del sector (Ex: Alta, Mitjana, Baixa):");
        String popularitat = scanner.nextLine();

        Vista.mostrarMissatge("Restriccions del sector:");
        String restriccions = scanner.nextLine();

        int idEscola = -1;
        try {
            Vista.mostrarMissatge("Nom de l'escola associada al sector:");
            String nomEscola = scanner.nextLine();
            idEscola = escolaDAO.obtenirPerNom(nomEscola);
        } catch (NoExisteix e) {
            Vista.mostrarMissatge(e.getMessage());
            return;
        }

        Sector sector = new Sector(nom, coordenades, aproximacio, numeroVies, popularitat, restriccions, idEscola);
        sectorDAO.inserir(sector);

        Vista.mostrarMissatge("Sector creat correctament.");
    }
}