package Model.DAO;

import Model.ConnexioBD;
import Model.Constructors.Via;
import Model.Exceptions.NoExisteix;
import Model.Interfaces.CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViaDAO implements CRUD<Via> {

    @Override
    public void inserir(Via via) {
        String sql = "INSERT INTO vias (nom, id_tipus_via, estat, orientacio, id_ancoratge, id_tipus_roca, id_sector, id_material, creador) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, via.getNom());
            stmt.setInt(2, via.getIdTipusVia());
            stmt.setString(3, via.getEstat());
            stmt.setString(4, via.getOrientacio());
            stmt.setInt(5, via.getIdAncoratge());
            stmt.setInt(6, via.getIdTipusRoca());
            stmt.setInt(7, via.getIdSector());
            stmt.setInt(8, via.getIdMaterial());
            stmt.setInt(9, via.getCreador());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    via.setIdVia(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Via obtenir(int id) {
        Via via = null;
        String sql = "SELECT * FROM vias WHERE id_via = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                via = new Via(
                        rs.getInt("id_via"),
                        rs.getString("nom"),
                        rs.getInt("id_tipus_via"),
                        rs.getString("estat"),
                        rs.getString("orientacio"),
                        rs.getInt("id_ancoratge"),
                        rs.getInt("id_tipus_roca"),
                        rs.getInt("id_sector"),
                        rs.getInt("id_material"),
                        rs.getInt("creador")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return via;
    }

    @Override
    public List<Via> llistarTots() {
        List<Via> llista = new ArrayList<>();
        String sql = "SELECT * FROM vias";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Via via = new Via(
                        rs.getInt("id_via"),
                        rs.getString("nom"),
                        rs.getInt("id_tipus_via"),
                        rs.getString("estat"),
                        rs.getString("orientacio"),
                        rs.getInt("id_ancoratge"),
                        rs.getInt("id_tipus_roca"),
                        rs.getInt("id_sector"),
                        rs.getInt("id_material"),
                        rs.getInt("creador")
                );
                llista.add(via);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return llista;
    }

    @Override
    public void actualitzar(Via via) {
        String sql = "UPDATE vias SET nom=?, id_tipus_via=?, estat=?, orientacio=?, id_ancoratge=?, id_tipus_roca=?, id_sector=?, id_material=?, creador=? WHERE id_via=?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, via.getNom());
            stmt.setInt(2, via.getIdTipusVia());
            stmt.setString(3, via.getEstat());
            stmt.setString(4, via.getOrientacio());
            stmt.setInt(5, via.getIdAncoratge());
            stmt.setInt(6, via.getIdTipusRoca());
            stmt.setInt(7, via.getIdSector());
            stmt.setInt(8, via.getIdMaterial());
            stmt.setInt(9, via.getCreador());
            stmt.setInt(10, via.getIdVia());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM vias WHERE id_via = ?";

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
        String sql = "SELECT id_via FROM vies WHERE nom = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nom);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id_via");
            } else {
                throw new NoExisteix("No existeix cap via amb el nom: " + nom);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public List<Via> llistarPerNom(String nom) {
        List<Via> vies = new ArrayList<>();
        try {
            Connection conn = ConnexioBD.getConnexio();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Via WHERE nom = ?");
            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Via via = new Via(
                        rs.getInt("idVia"),
                        rs.getString("nom"),
                        rs.getInt("idTipusVia"),
                        rs.getString("estat"),
                        rs.getString("orientacio"),
                        rs.getInt("idAncoratge"),
                        rs.getInt("idTipusRoca"),
                        rs.getInt("idSector"),
                        rs.getInt("idMaterial"),
                        rs.getInt("idCreador")
                );
                vies.add(via);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vies;
    }
}