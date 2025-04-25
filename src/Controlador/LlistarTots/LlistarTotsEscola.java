package Controlador.LlistarTots;

import Model.Constructors.Escola;
import Model.DAO.EscolaDAO;
import Vista.Vista;

import java.util.List;

public class LlistarTotsEscola {
    public static void llistarTotesEscoles() {
        EscolaDAO escolaDAO = new EscolaDAO();
        List<Escola> escoles = escolaDAO.llistarTots();

        if (escoles.isEmpty()) {
            Vista.mostrarMissatge("No hi ha escoles per mostrar.");
        } else {
            Vista.mostrarMissatge("Llistat de totes les escoles:");
            for (Escola e : escoles) {
                Vista.mostrarMissatge("ID: " + e.getIdEscola() + " | Nom: " + e.getNom() +
                        " | Localització: " + e.getIdLocalitzacio() + " | Aproximació: " + e.getAproximacio());
            }
        }
    }
}