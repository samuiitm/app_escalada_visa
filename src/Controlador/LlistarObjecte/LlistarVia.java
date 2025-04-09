package Controlador.LlistarObjecte;

import Model.Constructors.Via;
import Model.DAO.ViaDAO;

import java.util.Scanner;

public class LlistarVia {
    public static void llistarVia() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digues el nom de l'escalador:");

        String nom = scanner.nextLine();

        ViaDAO viaDAO = new ViaDAO();

        int id = viaDAO.obtenirPerNom(nom);
        Via via = viaDAO.obtenir(id);

        if (via != null) {
            System.out.println("Informació de la via:");
            System.out.println("Nom: " + via.getNom());
            System.out.println("Tipus de via: " + via.getIdTipusVia());
            System.out.println("Estat: " + via.getEstat());
            System.out.println("Orientació: " + via.getOrientacio());
            System.out.println("Ancoratge: " + via.getIdAncoratge());
            System.out.println("Tipus de roca: " + via.getIdTipusRoca());
            System.out.println("Sector: " + via.getIdSector());
            System.out.println("Material: " + via.getIdMaterial());
            System.out.println("Creador: " + via.getCreador());
        } else {
            System.out.println("Via no trobada.");
        }
    }
}