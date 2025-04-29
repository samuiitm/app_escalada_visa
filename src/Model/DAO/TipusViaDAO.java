package Model.DAO;

import Model.ConnexioBD;
import Model.Constructors.Tipus_Via;
import Model.Exceptions.NoExisteix;
import Model.Interfaces.CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TipusViaDAO implements CRUD<Tipus_Via> {
    @Override
    public void inserir(Tipus_Via tipusVia) {
        String sql = "INSERT INTO tipus_vies (nom) VALUES (?)";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, tipusVia.getNom());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    tipusVia.setIdTipusVia(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tipus_Via obtenir(int id) {
        Tipus_Via tipusVia = null;
        String sql = "SELECT * FROM tipus_vies WHERE id_tipus_via = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                tipusVia = new Tipus_Via(
                        rs.getInt("id_tipus_via"),
                        rs.getString("nom")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tipusVia;
    }

    @Override
    public List<Tipus_Via> llistarTots() {
        List<Tipus_Via> llista = new ArrayList<>();
        String sql = "SELECT * FROM tipus_vies";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Tipus_Via tipusVia = new Tipus_Via(
                        rs.getInt("id_tipus_via"),
                        rs.getString("nom")
                );
                llista.add(tipusVia);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return llista;
    }

    @Override
    public void actualitzar(Tipus_Via tipusVia) {
        String sql = "UPDATE tipus_vies SET nom=? WHERE id_tipus_via=?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tipusVia.getNom());
            stmt.setInt(2, tipusVia.getIdTipusVia());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM tipus_vies WHERE id_tipus_via = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int obtenirPerNom(String nom) throws NoExisteix {
        int id = -1;
        String sql = "SELECT id_tipus_via FROM tipus_vies WHERE nom = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nom);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id_tipus_via");
            } else {
                throw new NoExisteix("No existeix cap tipus via amb el nom: " + nom);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    @Override
    public String obtenirPerId(int id) throws NoExisteix {
        String nomTipusVia = null;
        String sql = "SELECT nom FROM tipus_vies WHERE id_tipus_via = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                nomTipusVia = rs.getString("nom");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nomTipusVia;
    }
}