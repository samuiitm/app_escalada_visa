package Model.DAO;

import Model.Constructors.Escola;
import Model.ConnexioBD;
import Model.Interfaces.CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EscolaDAO implements CRUD<Escola> {

    @Override
    public void inserir(Escola escola) {
        String sql = "INSERT INTO escoles (nom, id_localitzacio, aproximacio, numero_vies, popularitat, restriccions) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connexio = ConnexioBD.getConnexio();
             PreparedStatement pst = connexio.prepareStatement(sql)) {

            pst.setString(1, escola.getNom());
            pst.setInt(2, escola.getIdLocalitzacio());
            pst.setString(3, escola.getAproximacio());
            pst.setInt(4, escola.getNumeroVies());
            pst.setString(5, escola.getPopularitat());
            pst.setString(6, escola.getRestriccions());

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en inserir escola: " + e.getMessage());
        }
    }

    @Override
    public Escola obtenir(int id) {
        Escola escola = null;
        String sql = "SELECT * FROM escoles WHERE id_escola = ?";

        try (Connection connexio = ConnexioBD.getConnexio();
             PreparedStatement pst = connexio.prepareStatement(sql)) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                escola = new Escola(
                        rs.getInt("id_escola"),
                        rs.getString("nom"),
                        rs.getInt("id_localitzacio"),
                        rs.getString("aproximacio"),
                        rs.getInt("numero_vies"),
                        rs.getString("popularitat"),
                        rs.getString("restriccions")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error en obtenir escola: " + e.getMessage());
        }

        return escola;
    }

    @Override
    public List<Escola> obtenirTots() {
        List<Escola> escoles = new ArrayList<>();
        String sql = "SELECT * FROM escoles";

        try (Connection connexio = ConnexioBD.getConnexio();
             Statement stmt = connexio.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Escola escola = new Escola(
                        rs.getInt("id_escola"),
                        rs.getString("nom"),
                        rs.getInt("id_localitzacio"),
                        rs.getString("aproximacio"),
                        rs.getInt("numero_vies"),
                        rs.getString("popularitat"),
                        rs.getString("restriccions")
                );
                escoles.add(escola);
            }

        } catch (SQLException e) {
            System.out.println("Error en obtenir totes les escoles: " + e.getMessage());
        }

        return escoles;
    }

    @Override
    public void actualitzar(Escola escola) {
        String sql = "UPDATE escoles SET nom = ?, id_localitzacio = ?, aproximacio = ?, numero_vies = ?, popularitat = ?, restriccions = ? WHERE id_escola = ?";

        try (Connection connexio = ConnexioBD.getConnexio();
             PreparedStatement pst = connexio.prepareStatement(sql)) {

            pst.setString(1, escola.getNom());
            pst.setInt(2, escola.getIdLocalitzacio());
            pst.setString(3, escola.getAproximacio());
            pst.setInt(4, escola.getNumeroVies());
            pst.setString(5, escola.getPopularitat());
            pst.setString(6, escola.getRestriccions());
            pst.setInt(7, escola.getIdEscola());

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en actualitzar escola: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM escoles WHERE id_escola = ?";

        try (Connection connexio = ConnexioBD.getConnexio();
             PreparedStatement pst = connexio.prepareStatement(sql)) {

            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en eliminar escola: " + e.getMessage());
        }
    }
}
