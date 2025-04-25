package Model.DAO;

import Model.ConnexioBD;
import Model.Constructors.Dificultat;
import Model.Exceptions.NoExisteix;
import Model.Interfaces.CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DificultatDAO implements CRUD<Dificultat> {

    @Override
    public void inserir(Dificultat dificultat) {
        String sql = "INSERT INTO dificultats (nom) VALUES (?)";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, dificultat.getNom());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    dificultat.setIdDificultat(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Dificultat obtenir(int id) {
        Dificultat dificultat = null;
        String sql = "SELECT * FROM dificultats WHERE id_dificultat = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                dificultat = new Dificultat(
                        rs.getInt("id_dificultat"),
                        rs.getString("nom")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dificultat;
    }

    @Override
    public List<Dificultat> llistarTots() {
        List<Dificultat> llista = new ArrayList<>();
        String sql = "SELECT * FROM dificultats";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Dificultat dificultat = new Dificultat(
                        rs.getInt("id_dificultat"),
                        rs.getString("nom")
                );
                llista.add(dificultat);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return llista;
    }

    @Override
    public void actualitzar(Dificultat dificultat) {
        String sql = "UPDATE dificultats SET nom=? WHERE id_dificultat=?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dificultat.getNom());
            stmt.setInt(2, dificultat.getIdDificultat());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM dificultats WHERE id_dificultat = ?";

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
        String sql = "SELECT id_dificultat FROM dificultats WHERE nom = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nom);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id_dificultat");
            } else {
                throw new NoExisteix("No existeix cap dificultat amb el nom: " + nom);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
}
