package Controlador.CrearObjectes;

import java.util.Scanner;
import Model.Constructors.Escola;
import Model.DAO.EscolaDAO;
import Model.DAO.LocalitzacioDAO;
import Vista.Vista;

public class CrearEscola {

    public static void crearEscola() {
        EscolaDAO escolaDAO = new EscolaDAO();
        LocalitzacioDAO localitzacioDAO = new LocalitzacioDAO();
        Scanner scanner = new Scanner(System.in);

        Vista.mostrarMissatge("Introdueix el nom de l'escola:");
        String nom = scanner.nextLine();

        Vista.mostrarMissatge("Nom de la localització:");
        String nomLocalitzacio = scanner.nextLine();
        int idLocalitzacio = localitzacioDAO.obtenirPerNom(nomLocalitzacio);

        Vista.mostrarMissatge("Aproximació a l'escola (Descripció de com arribar):");
        String aproximacio = scanner.nextLine();

        Vista.mostrarMissatge("Número de vies de l'escola:");
        int numeroVies = Integer.parseInt(scanner.nextLine());

        Vista.mostrarMissatge("Popularitat de l'escola (Baixa, Mitjana, Alta):");
        String popularitat = scanner.nextLine();

        Vista.mostrarMissatge("Restriccions (si n'hi ha):");
        String restriccions = scanner.nextLine();

        Escola escola = new Escola(nom, idLocalitzacio, aproximacio, numeroVies, popularitat, restriccions);
        escolaDAO.inserir(escola);

        Vista.mostrarMissatge("Escola creada correctament.");
    }
}