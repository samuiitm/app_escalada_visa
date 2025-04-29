package Controlador.LlistarTots;

import Model.Constructors.Via;
import Model.DAO.TipusViaDAO;
import Model.DAO.ViaDAO;
import Vista.Vista;

import java.util.List;

public class LlistarTotsVia {
    public static void llistarTotesVies() {
        ViaDAO viaDAO = new ViaDAO();
        TipusViaDAO tipusViaDAO = new TipusViaDAO();
        List<Via> vies = viaDAO.llistarTots();

        if (vies.isEmpty()) {
            Vista.mostrarMissatge("No hi ha vies per mostrar.");
        } else {
            Vista.mostrarMissatge("Llistat de totes les vies:");
            for (Via v : vies) {
                Vista.mostrarMissatge("ID: " + v.getIdVia() + " | Nom: " + v.getNom() +
                        " | Tipus: " + tipusViaDAO.obtenirPerId(v.getIdTipusVia()) + " | Estat: " + v.getEstat() +
                        " | Orientació: " + v.getOrientacio());
            }
        }
    }
}
