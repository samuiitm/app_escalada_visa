package Model.DAO;

import Model.ConnexioBD;
import Model.Constructors.Localitzacio;
import Model.Exceptions.NoExisteix;
import Model.Interfaces.CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocalitzacioDAO implements CRUD<Localitzacio> {

    @Override
    public void inserir(Localitzacio localitzacio) {
        String sql = "INSERT INTO localitzacions (ciutat, regio, codipostal) VALUES (?, ?, ?)";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, localitzacio.getCiutat());
            stmt.setString(2, localitzacio.getRegio());
            stmt.setString(3, localitzacio.getCodipostal());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    localitzacio.setIdLocalitzacio(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Localitzacio obtenir(int id) {
        Localitzacio localitzacio = null;
        String sql = "SELECT * FROM localitzacions WHERE id_localitzacio = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                localitzacio = new Localitzacio(
                        rs.getInt("id_localitzacio"),
                        rs.getString("ciutat"),
                        rs.getString("regio"),
                        rs.getString("codipostal")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return localitzacio;
    }

    @Override
    public List<Localitzacio> llistarTots() {
        List<Localitzacio> llista = new ArrayList<>();
        String sql = "SELECT * FROM localitzacions";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Localitzacio localitzacio = new Localitzacio(
                        rs.getInt("id_localitzacio"),
                        rs.getString("ciutat"),
                        rs.getString("regio"),
                        rs.getString("codipostal")
                );
                llista.add(localitzacio);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return llista;
    }

    @Override
    public void actualitzar(Localitzacio localitzacio) {
        String sql = "UPDATE localitzacions SET ciutat=?, regio=?, codipostal=? WHERE id_localitzacio=?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, localitzacio.getCiutat());
            stmt.setString(2, localitzacio.getRegio());
            stmt.setString(3, localitzacio.getCodipostal());
            stmt.setInt(4, localitzacio.getIdLocalitzacio());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM localitzacions WHERE id_localitzacio = ?";

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
        String sql = "SELECT id_localitzacio FROM localitzacions WHERE nom = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nom);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id_localitzacio");
            } else {
                throw new NoExisteix("No existeix cap localització amb el nom: " + nom);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
}

