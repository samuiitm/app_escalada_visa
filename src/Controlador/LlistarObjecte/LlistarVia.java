package Controlador.LlistarObjecte;

import Model.Constructors.Via;
import Model.DAO.ViaDAO;

import java.util.List;
import java.util.Scanner;

public class LlistarVia {
    public static void llistarVia() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digues el nom de la via:");

        String nom = scanner.nextLine();

        ViaDAO viaDAO = new ViaDAO();

        List<Via> vies = viaDAO.llistarPerNom(nom);

        if (vies.isEmpty()) {
            System.out.println("No s'ha trobat cap via amb aquest nom.");
            return;
        }

        if (vies.size() > 1) {
            System.out.println("Vies trobades:");
            for (Via v : vies) {
                System.out.println("ID: " + v.getIdVia() + " | Nom: " + v.getNom() +
                        " | Orientació: " + v.getOrientacio());
            }

            System.out.println("Introdueix l'ID de la via que vols veure:");
            int idVia = Integer.parseInt(scanner.nextLine());

            Via via = viaDAO.obtenir(idVia);
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
                System.out.println("ID no vàlid.");
            }
        } else {
            Via via = vies.get(0);
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
        }
    }
}