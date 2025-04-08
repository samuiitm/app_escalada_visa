package Model.DAO;

import Model.ConnexioBD;
import Model.Constructors.Escalador;
import Model.Interfaces.CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EscaladorDAO implements CRUD<Escalador> {
    @Override
    public void inserir(Escalador escalador) {
        String sql = "INSERT INTO escaladors (nom, alies, edat, nivell_maxim, via_nivell_max, estil_preferit) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, escalador.getNom());
            stmt.setString(2, escalador.getAlies());
            stmt.setInt(3, escalador.getEdat());
            stmt.setString(4, escalador.getNivell_maxim());
            stmt.setInt(5, escalador.getVia_nivell_maxim());
            stmt.setString(6, escalador.getEstil_preferit());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    escalador.setIdEscalador(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Pots mostrar-ho per consola amb la vista si vols
        }
    }

    @Override
    public Escalador obtenir(int id) {
        Escalador escalador = null;
        String sql = "SELECT * FROM escaladors WHERE id_escalador = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                escalador = new Escalador(
                        rs.getInt("id_escalador"),
                        rs.getString("nom"),
                        rs.getString("alies"),
                        rs.getInt("edat"),
                        rs.getString("nivell_maxim"),
                        rs.getInt("via_nivell_max"),
                        rs.getString("estil_preferit")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return escalador;
    }

    @Override
    public List<Escalador> obtenirTots() {
        List<Escalador> llista = new ArrayList<>();
        String sql = "SELECT * FROM escaladors";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Escalador escalador = new Escalador(
                        rs.getInt("id_escalador"),
                        rs.getString("nom"),
                        rs.getString("alies"),
                        rs.getInt("edat"),
                        rs.getString("nivell_maxim"),
                        rs.getInt("via_nivell_max"),
                        rs.getString("estil_preferit")
                );
                llista.add(escalador);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return llista;
    }

    @Override
    public void actualitzar(Escalador escalador) {
        String sql = "UPDATE escaladors SET nom=?, alies=?, edat=?, nivell_maxim=?, via_nivell_max=?, estil_preferit=? WHERE id_escalador=?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, escalador.getNom());
            stmt.setString(2, escalador.getAlies());
            stmt.setInt(3, escalador.getEdat());
            stmt.setString(4, escalador.getNivell_maxim());
            stmt.setInt(5, escalador.getVia_nivell_maxim());
            stmt.setString(6, escalador.getEstil_preferit());
            stmt.setInt(7, escalador.getIdEscalador());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM escaladors WHERE id_escalador = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
