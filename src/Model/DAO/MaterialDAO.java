package Model.DAO;

import Model.ConnexioBD;
import Model.Constructors.Material;
import Model.Exceptions.NoExisteix;
import Model.Interfaces.CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO implements CRUD<Material> {
    @Override
    public void inserir(Material material) {
        String sql = "INSERT INTO materials (nom) VALUES (?)";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, material.getNom());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    material.setIdMaterial(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Material obtenir(int id) {
        Material material = null;
        String sql = "SELECT * FROM materials WHERE id_material = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                material = new Material(
                        rs.getInt("id_material"),
                        rs.getString("nom")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return material;
    }

    @Override
    public List<Material> llistarTots() {
        List<Material> llista = new ArrayList<>();
        String sql = "SELECT * FROM materials";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Material material = new Material(
                        rs.getInt("id_material"),
                        rs.getString("nom")
                );
                llista.add(material);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return llista;
    }

    @Override
    public void actualitzar(Material material) {
        String sql = "UPDATE materials SET nom=? WHERE id_material=?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, material.getNom());
            stmt.setInt(2, material.getIdMaterial());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM materials WHERE id_material = ?";

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
        String sql = "SELECT id_material FROM materials WHERE nom = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nom);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id_material");
            } else {
                throw new NoExisteix("No existeix cap material amb el nom: " + nom);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    @Override
    public String obtenirPerId(int id) throws NoExisteix {
        String nomMaterial = null;
        String sql = "SELECT nom FROM materials WHERE id_material = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                nomMaterial = rs.getString("nom");
            } else {
                throw new NoExisteix("No existeix cap ancoratge amb l'id: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nomMaterial;
    }
}