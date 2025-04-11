package Controlador.CrearObjectes;

import Model.Constructors.Via;
import Model.DAO.*;
import Vista.Vista;

import java.util.Scanner;

public class CrearVia {
    public static void crearVia() {
        ViaDAO viaDAO = new ViaDAO();
        TipusViaDAO tipusViaDAO = new TipusViaDAO();
        AncoratgeDAO ancoratgeDAO = new AncoratgeDAO();
        TipusRocaDAO tipusRocaDAO = new TipusRocaDAO();
        SectorDAO sectorDAO = new SectorDAO();
        MaterialDAO materialDAO = new MaterialDAO();
        EscaladorDAO escaladorDAO = new EscaladorDAO();
        Scanner scanner = new Scanner(System.in);

        Vista.mostrarMissatge("Introdueix el nom de la via:");
        String nom = scanner.nextLine();

        Vista.mostrarMissatge("Nom del tipus de via:");
        String nomTipusVia = scanner.nextLine();
        int idTipusVia = tipusViaDAO.obtenirPerNom(nomTipusVia);

        Vista.mostrarMissatge("Estat de la via (Ex: Bona, En mal estat):");
        String estat = scanner.nextLine();

        Vista.mostrarMissatge("Orientació de la via (Ex: Nord, Sud, Llevant, Ponent):");
        String orientacio = scanner.nextLine();

        Vista.mostrarMissatge("Nom d'ancoratge:");
        String nomAncoratge = scanner.nextLine();
        int idAncoratge = ancoratgeDAO.obtenirPerNom(nomAncoratge);

        Vista.mostrarMissatge("Nom del tipus de roca:");
        String nomTipusRoca = scanner.nextLine();
        int idTipusRoca = tipusRocaDAO.obtenirPerNom(nomTipusRoca);

        Vista.mostrarMissatge("Nom del sector:");
        String nomSector = scanner.nextLine();
        int idSector = sectorDAO.obtenirPerNom(nomSector);

        Vista.mostrarMissatge("Nom del material utilitzat:");
        String nomMaterial = scanner.nextLine();
        int idMaterial = materialDAO.obtenirPerNom(nomMaterial);

        Vista.mostrarMissatge("Nom del creador:");
        String nomCreador = scanner.nextLine();
        int idCreador = escaladorDAO.obtenirPerNom(nomCreador);

        Via via = new Via(nom, idTipusVia, estat, orientacio, idAncoratge, idTipusRoca, idSector, idMaterial, idCreador);
        viaDAO.inserir(via);

        Vista.mostrarMissatge("Via creada correctament.");
    }
}
