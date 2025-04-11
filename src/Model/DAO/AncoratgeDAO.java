package Model.DAO;

import Model.ConnexioBD;
import Model.Constructors.Ancoratge;
import Model.Interfaces.CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AncoratgeDAO implements CRUD<Ancoratge> {

    @Override
    public void inserir(Ancoratge ancoratge) {
        String sql = "INSERT INTO ancoratges (nom) VALUES (?)";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, ancoratge.getNom());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    ancoratge.setIdAncoratge(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Ancoratge obtenir(int id) {
        Ancoratge ancoratge = null;
        String sql = "SELECT * FROM ancoratges WHERE id_ancoratge = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ancoratge = new Ancoratge(
                        rs.getInt("id_ancoratge"),
                        rs.getString("nom")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ancoratge;
    }

    @Override
    public List<Ancoratge> obtenirTots() {
        List<Ancoratge> llista = new ArrayList<>();
        String sql = "SELECT * FROM ancoratges";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Ancoratge ancoratge = new Ancoratge(
                        rs.getInt("id_ancoratge"),
                        rs.getString("nom")
                );
                llista.add(ancoratge);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return llista;
    }

    @Override
    public void actualitzar(Ancoratge ancoratge) {
        String sql = "UPDATE ancoratges SET nom=? WHERE id_ancoratge=?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ancoratge.getNom());
            stmt.setInt(2, ancoratge.getIdAncoratge());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM ancoratges WHERE id_ancoratge = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int obtenirPerNom(String nom) {
        int id = -1;
        String sql = "SELECT id_ancoratge FROM ancoratges WHERE nom = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nom);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id_ancoratge");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
}