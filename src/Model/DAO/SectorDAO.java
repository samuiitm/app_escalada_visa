package Model.DAO;

import Model.ConnexioBD;
import Model.Constructors.Escalador;
import Model.Constructors.Sector;
import Model.Exceptions.NoExisteix;
import Model.Interfaces.CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SectorDAO implements CRUD<Sector> {

    @Override
    public void inserir(Sector sector) {
        String sql = "INSERT INTO sectors (nom, coordenades, aproximacio, numero_vies, popularitat, restriccions, id_escola) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, sector.getNom());
            stmt.setString(2, sector.getCoordenades());
            stmt.setString(3, sector.getAproximacio());
            stmt.setInt(4, sector.getNumeroVies());
            stmt.setString(5, sector.getPopularitat());
            stmt.setString(6, sector.getRestriccions());
            stmt.setInt(7, sector.getIdEscola());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    sector.setIdSector(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Sector obtenir(int id) {
        Sector sector = null;
        String sql = "SELECT * FROM sectors WHERE id_sector = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                sector = new Sector(
                        rs.getInt("id_sector"),
                        rs.getString("nom"),
                        rs.getString("coordenades"),
                        rs.getString("aproximacio"),
                        rs.getInt("numero_vies"),
                        rs.getString("popularitat"),
                        rs.getString("restriccions"),
                        rs.getInt("id_escola")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sector;
    }

    @Override
    public List<Sector> obtenirTots() {
        List<Sector> llista = new ArrayList<>();
        String sql = "SELECT * FROM sectors";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Sector sector = new Sector(
                        rs.getInt("id_sector"),
                        rs.getString("nom"),
                        rs.getString("coordenades"),
                        rs.getString("aproximacio"),
                        rs.getInt("numero_vies"),
                        rs.getString("popularitat"),
                        rs.getString("restriccions"),
                        rs.getInt("id_escola")
                );
                llista.add(sector);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return llista;
    }

    @Override
    public void actualitzar(Sector sector) {
        String sql = "UPDATE sectors SET nom=?, coordenades=?, aproximacio=?, numero_vies=?, popularitat=?, restriccions=?, id_escola=? WHERE id_sector=?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sector.getNom());
            stmt.setString(2, sector.getCoordenades());
            stmt.setString(3, sector.getAproximacio());
            stmt.setInt(4, sector.getNumeroVies());
            stmt.setString(5, sector.getPopularitat());
            stmt.setString(6, sector.getRestriccions());
            stmt.setInt(7, sector.getIdEscola());
            stmt.setInt(8, sector.getIdSector());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM sectors WHERE id_sector = ?";

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
        String sql = "SELECT id_sector FROM sectors WHERE nom = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nom);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id_sector");
            } else {
                throw new NoExisteix("No existeix cap sector amb el nom: " + nom);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
}