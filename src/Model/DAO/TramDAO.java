package Model.DAO;

import Model.ConnexioBD;
import Model.Constructors.Tram;
import Model.Exceptions.NoExisteix;
import Model.Interfaces.CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TramDAO implements CRUD<Tram> {
    @Override
    public void inserir(Tram tram) {
        String sql = "INSERT INTO trams (nom, id_dificultat, llargada) VALUES (?, ?, ?)";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, tram.getNom());
            stmt.setInt(2, tram.getIdDificultat());
            stmt.setInt(3, tram.getLlargada());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    tram.setIdTram(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tram obtenir(int id) {
        Tram tram = null;
        String sql = "SELECT * FROM trams WHERE id_tram = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                tram = new Tram(
                        rs.getInt("id_tram"),
                        rs.getString("nom"),
                        rs.getInt("id_dificultat"),
                        rs.getInt("llargada")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tram;
    }

    @Override
    public List<Tram> llistarTots() {
        List<Tram> llista = new ArrayList<>();
        String sql = "SELECT * FROM trams";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Tram tram = new Tram(
                        rs.getInt("id_tram"),
                        rs.getString("nom"),
                        rs.getInt("id_dificultat"),
                        rs.getInt("llargada")
                );
                llista.add(tram);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return llista;
    }

    @Override
    public void actualitzar(Tram tram) {
        String sql = "UPDATE trams SET nom=?, id_dificultat=?, llargada=? WHERE id_tram=?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tram.getNom());
            stmt.setInt(2, tram.getIdDificultat());
            stmt.setInt(3, tram.getLlargada());
            stmt.setInt(4, tram.getIdTram());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM trams WHERE id_tram = ?";

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
        String sql = "SELECT id_tram FROM trams WHERE nom = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nom);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id_tram");
            } else {
                throw new NoExisteix("No existeix cap tram amb el nom: " + nom);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
    @Override
    public String obtenirPerId(int id) throws NoExisteix {
        String nomTram = null;
        String sql = "SELECT nom FROM trams WHERE id_tram = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                nomTram = rs.getString("nom");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nomTram;
    }
}