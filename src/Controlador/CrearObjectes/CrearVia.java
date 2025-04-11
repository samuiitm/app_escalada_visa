package Controlador.CrearObjectes;

import Model.Constructors.Via;
import Model.DAO.*;
import Model.Exceptions.NoExisteix;
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

        int idTipusVia = -1;
        try {
            Vista.mostrarMissatge("Nom del tipus de via:");
            String nomTipusVia = scanner.nextLine();
            idTipusVia = tipusViaDAO.obtenirPerNom(nomTipusVia);
        } catch (NoExisteix e) {
            Vista.mostrarMissatge(e.getMessage());
            return;
        }

        Vista.mostrarMissatge("Estat de la via (Ex: Bona, En mal estat):");
        String estat = scanner.nextLine();

        Vista.mostrarMissatge("Orientació de la via (Ex: Nord, Sud, Llevant, Ponent):");
        String orientacio = scanner.nextLine();

        int idAncoratge = -1;
        try {
            Vista.mostrarMissatge("Nom d'ancoratge:");
            String nomAncoratge = scanner.nextLine();
            idAncoratge = ancoratgeDAO.obtenirPerNom(nomAncoratge);
        } catch (NoExisteix e) {
            Vista.mostrarMissatge(e.getMessage());
            return;
        }

        int idTipusRoca = -1;
        try {
            Vista.mostrarMissatge("Nom del tipus de roca:");
            String nomTipusRoca = scanner.nextLine();
            idTipusRoca = tipusRocaDAO.obtenirPerNom(nomTipusRoca);
        } catch (NoExisteix e) {
            Vista.mostrarMissatge(e.getMessage());
            return;
        }

        int idSector = -1;
        try {
            Vista.mostrarMissatge("Nom del sector:");
            String nomSector = scanner.nextLine();
            idSector = sectorDAO.obtenirPerNom(nomSector);
        } catch (NoExisteix e) {
            Vista.mostrarMissatge(e.getMessage());
            return;
        }

        int idMaterial = -1;
        try {
            Vista.mostrarMissatge("Nom del material utilitzat:");
            String nomMaterial = scanner.nextLine();
            idMaterial = materialDAO.obtenirPerNom(nomMaterial);
        } catch (NoExisteix e) {
            Vista.mostrarMissatge(e.getMessage());
            return;
        }

        int idCreador = -1;
        try {
            Vista.mostrarMissatge("Nom del creador:");
            String nomCreador = scanner.nextLine();
            idCreador = escaladorDAO.obtenirPerNom(nomCreador);
        } catch (NoExisteix e) {
            Vista.mostrarMissatge(e.getMessage());
            return;
        }

        Via via = new Via(nom, idTipusVia, estat, orientacio, idAncoratge, idTipusRoca, idSector, idMaterial, idCreador);
        viaDAO.inserir(via);

        Vista.mostrarMissatge("Via creada correctament.");
    }
}
