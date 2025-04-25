package Controlador.ActualitzarObjectes;

import Model.Constructors.Via;
import Model.DAO.ViaDAO;
import Model.DAO.SectorDAO;
import Model.Exceptions.NoExisteix;
import Vista.Vista;

import java.util.List;
import java.util.Scanner;

public class ActualitzarVia {
    public static void actualitzarVia() {
        Scanner scanner = new Scanner(System.in);
        ViaDAO viaDAO = new ViaDAO();
        SectorDAO sectorDAO = new SectorDAO();

        Vista.mostrarMissatge("Introdueix el nom de la via que vols actualitzar:");
        String nom = scanner.nextLine();

        List<Via> vies = viaDAO.llistarPerNom(nom);

        if (vies.isEmpty()) {
            Vista.mostrarMissatge("No s'ha trobat cap via amb aquest nom.");
            return;
        }

        if (vies.size() > 1) {
            Vista.mostrarMissatge("S'ha trobat més d'una via amb el nom '" + nom + "'. Selecciona el número de la via:");
            for (int i = 0; i < vies.size(); i++) {
                Vista.mostrarMissatge((i + 1) + ". ID: " + vies.get(i).getIdVia() + " | Estat: " + vies.get(i).getEstat());
            }

            int eleccio = scanner.nextInt();
            scanner.nextLine();

            if (eleccio < 1 || eleccio > vies.size()) {
                Vista.mostrarMissatge("Opció invàlida. No es pot actualitzar.");
                return;
            }

            Via via = vies.get(eleccio - 1);
            actualitzarViaDetails(via, scanner);
        } else {
            Via via = vies.get(0);
            actualitzarViaDetails(via, scanner);
        }
    }

    private static void actualitzarViaDetails(Via via, Scanner scanner) {
        ViaDAO viaDAO = new ViaDAO();

        Vista.mostrarMissatge("ID del tipus de via actual: " + via.getIdTipusVia());
        Vista.mostrarMissatge("Nou ID de tipus de via (deixa buit per mantenir):");
        String nouTipusVia = scanner.nextLine();
        int idTipusVia = nouTipusVia.isEmpty() ? via.getIdTipusVia() : Integer.parseInt(nouTipusVia);

        Vista.mostrarMissatge("Estat actual: " + via.getEstat());
        Vista.mostrarMissatge("Nou estat (deixa buit per mantenir):");
        String estat = scanner.nextLine();
        if (estat.isEmpty()) estat = via.getEstat();

        Vista.mostrarMissatge("Orientació actual: " + via.getOrientacio());
        Vista.mostrarMissatge("Nova orientació (deixa buit per mantenir):");
        String orientacio = scanner.nextLine();
        if (orientacio.isEmpty()) orientacio = via.getOrientacio();

        Vista.mostrarMissatge("ID d'ancoratge actual: " + via.getIdAncoratge());
        Vista.mostrarMissatge("Nou ID d'ancoratge (deixa buit per mantenir):");
        String nouAncoratge = scanner.nextLine();
        int idAncoratge = nouAncoratge.isEmpty() ? via.getIdAncoratge() : Integer.parseInt(nouAncoratge);

        Vista.mostrarMissatge("ID de tipus de roca actual: " + via.getIdTipusRoca());
        Vista.mostrarMissatge("Nou ID de tipus de roca (deixa buit per mantenir):");
        String nouTipusRoca = scanner.nextLine();
        int idTipusRoca = nouTipusRoca.isEmpty() ? via.getIdTipusRoca() : Integer.parseInt(nouTipusRoca);

        Vista.mostrarMissatge("ID de sector actual: " + via.getIdSector());
        Vista.mostrarMissatge("Nou ID de sector (deixa buit per mantenir):");
        String nouSector = scanner.nextLine();
        int idSector = nouSector.isEmpty() ? via.getIdSector() : Integer.parseInt(nouSector);

        Vista.mostrarMissatge("ID de material actual: " + via.getIdMaterial());
        Vista.mostrarMissatge("Nou ID de material (deixa buit per mantenir):");
        String nouMaterial = scanner.nextLine();
        int idMaterial = nouMaterial.isEmpty() ? via.getIdMaterial() : Integer.parseInt(nouMaterial);

        Vista.mostrarMissatge("ID del creador actual: " + via.getCreador());
        Vista.mostrarMissatge("Nou ID del creador (deixa buit per mantenir):");
        String nouCreador = scanner.nextLine();
        int creador = nouCreador.isEmpty() ? via.getCreador() : Integer.parseInt(nouCreador);

        Via viaActualitzada = new Via(
                via.getIdVia(),
                via.getNom(),
                idTipusVia,
                estat,
                orientacio,
                idAncoratge,
                idTipusRoca,
                idSector,
                idMaterial,
                creador
        );

        viaDAO.actualitzar(viaActualitzada);
        Vista.mostrarMissatge("Via actualitzada correctament.");
    }
}