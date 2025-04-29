package Controlador.LlistarObjecte;

import Model.Constructors.Via;
import Model.DAO.*;

import java.util.List;
import java.util.Scanner;

public class LlistarVia {
    public static void llistarVia() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digues el nom de la via:");

        String nom = scanner.nextLine();

        ViaDAO viaDAO = new ViaDAO();

        TipusViaDAO tipusViaDAO = new TipusViaDAO();
        AncoratgeDAO ancoratgeDAO = new AncoratgeDAO();
        TipusRocaDAO tipusRocaDAO = new TipusRocaDAO();
        SectorDAO sectorDAO = new SectorDAO();
        MaterialDAO materialDAO = new MaterialDAO();
        EscaladorDAO escaladorDAO = new EscaladorDAO();

        List<Via> vies = ViaDAO.llistarPerNom(nom);

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
                System.out.println("Tipus de via: " + tipusViaDAO.obtenirPerId(via.getIdTipusVia()));
                System.out.println("Estat: " + via.getEstat());
                System.out.println("Orientació: " + via.getOrientacio());
                System.out.println("Ancoratge: " + ancoratgeDAO.obtenirPerId(via.getIdAncoratge()));
                System.out.println("Tipus de roca: " + tipusRocaDAO.obtenirPerId(via.getIdTipusRoca()));
                System.out.println("Sector: " + sectorDAO.obtenirPerId(via.getIdSector()));
                System.out.println("Material: " + materialDAO.obtenirPerId(via.getIdMaterial()));
                System.out.println("Creador: " + escaladorDAO.obtenirPerId(via.getCreador()));
            } else {
                System.out.println("ID no vàlid.");
            }
        } else {
            Via via = vies.get(0);
            System.out.println("Informació de la via:");
            System.out.println("Nom: " + via.getNom());
            System.out.println("Tipus de via: " + tipusViaDAO.obtenirPerId(via.getIdTipusVia()));
            System.out.println("Estat: " + via.getEstat());
            System.out.println("Orientació: " + via.getOrientacio());
            System.out.println("Ancoratge: " + ancoratgeDAO.obtenirPerId(via.getIdAncoratge()));
            System.out.println("Tipus de roca: " + tipusRocaDAO.obtenirPerId(via.getIdTipusRoca()));
            System.out.println("Sector: " + sectorDAO.obtenirPerId(via.getIdSector()));
            System.out.println("Material: " + materialDAO.obtenirPerId(via.getIdMaterial()));
            System.out.println("Creador: " + escaladorDAO.obtenirPerId(via.getCreador()));
        }
    }
}