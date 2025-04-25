package Controlador.LlistarTots;

import Model.Constructors.Escalador;
import Model.DAO.EscaladorDAO;
import Vista.Vista;

import java.util.List;

public class LlistarTotsEscalador {
    public static void llistarTotsEscaladors() {
        EscaladorDAO escaladorDAO = new EscaladorDAO();
        List<Escalador> escaladors = escaladorDAO.llistarTots();

        if (escaladors.isEmpty()) {
            Vista.mostrarMissatge("No hi ha escaladors per mostrar.");
        } else {
            Vista.mostrarMissatge("Llistat de tots els escaladors:");
            for (Escalador e : escaladors) {
                Vista.mostrarMissatge("ID: " + e.getIdEscalador() + " | Nom: " + e.getNom() +
                        " | Àlies: " + e.getAlies() + " | Edat: " + e.getEdat());
            }
        }
    }
}