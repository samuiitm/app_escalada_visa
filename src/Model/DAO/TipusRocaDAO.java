package Model.DAO;

import Model.ConnexioBD;
import Model.Constructors.Tipus_Roca;
import Model.Exceptions.NoExisteix;
import Model.Interfaces.CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TipusRocaDAO implements CRUD<Tipus_Roca> {
    @Override
    public void inserir(Tipus_Roca tipusRoca) {
        String sql = "INSERT INTO tipus_roca (nom) VALUES (?)";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, tipusRoca.getNom());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    tipusRoca.setIdTipusRoca(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tipus_Roca obtenir(int id) {
        Tipus_Roca tipusRoca = null;
        String sql = "SELECT * FROM tipus_roca WHERE id_tipus_roca = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                tipusRoca = new Tipus_Roca(
                        rs.getInt("id_tipus_roca"),
                        rs.getString("nom")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tipusRoca;
    }

    @Override
    public List<Tipus_Roca> obtenirTots() {
        List<Tipus_Roca> llista = new ArrayList<>();
        String sql = "SELECT * FROM tipus_roca";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Tipus_Roca tipusRoca = new Tipus_Roca(
                        rs.getInt("id_tipus_roca"),
                        rs.getString("nom")
                );
                llista.add(tipusRoca);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return llista;
    }

    @Override
    public void actualitzar(Tipus_Roca tipusRoca) {
        String sql = "UPDATE tipus_roca SET nom=? WHERE id_tipus_roca=?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tipusRoca.getNom());
            stmt.setInt(2, tipusRoca.getIdTipusRoca());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM tipus_roca WHERE id_tipus_roca = ?";

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
        String sql = "SELECT id_tipus_roca FROM tipus_roca WHERE nom = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nom);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id_tipus_roca");
            } else {
                throw new NoExisteix("No existeix cap tipus roca amb el nom: " + nom);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
}