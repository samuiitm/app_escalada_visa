package Controlador.ConsultesPrecreades;

import Model.ConnexioBD;
import Model.Constructors.Escola;
import Model.DAO.EscolaDAO;
import Vista.Vista;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultesPrecreades {
    private static Escola seleccionarEscolaPerNom(String nom) {
        Scanner scanner = new Scanner(System.in);
        EscolaDAO escolaDAO = new EscolaDAO();
        List<Escola> escoles = escolaDAO.llistarPerNom(nom);

        if (escoles.isEmpty()) {
            Vista.mostrarMissatge("No s'ha trobat cap escola amb aquest nom.");
            return null;
        } else if (escoles.size() == 1) {
            return escoles.get(0);
        } else {
            Vista.mostrarMissatge("S'han trobat múltiples escoles amb el nom '" + nom + "':");
            for (Escola escola : escoles) {
                String ubicacio = obtenirNomLocalitzacio(escola.getIdLocalitzacio());
                Vista.mostrarMissatge("ID: " + escola.getIdEscola() + " | Nom: " + escola.getNom() + " | Ubicació: " + ubicacio);
            }

            Vista.mostrarMissatge("Introdueix l'ID de l'escola que vols seleccionar:");
            int idSeleccionat = Integer.parseInt(scanner.nextLine());

            for (Escola escola : escoles) {
                if (escola.getIdEscola() == idSeleccionat) {
                    return escola;
                }
            }

            Vista.mostrarMissatge("ID introduït no vàlid.");
            return null;
        }
    }

    private static String obtenirNomLocalitzacio(int idLocalitzacio) {
        String sql = "SELECT nom FROM localitzacions WHERE id_localitzacio = ?";
        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idLocalitzacio);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("nom");
            } else {
                return "Localització descsoneguda";
            }
        } catch (SQLException e) {
            Vista.mostrarMissatge("Error en obtenir la localització: " + e.getMessage());
            return "Localització desconeguda";
        }
    }

    public static void mostrarViesEscolaDisponible(String nomEscola) {
        Escola escolaSeleccionada = seleccionarEscolaPerNom(nomEscola);
        if (escolaSeleccionada == null) return;

        String sql = "SELECT v.id_via, v.nom, v.estat FROM vies v " +
                "JOIN sectors s ON v.id_sector = s.id_sector " +
                "JOIN escoles e ON s.id_escola = e.id_escola " +
                "WHERE e.id_escola = ? AND v.estat = 'Apte'";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, escolaSeleccionada.getIdEscola());
            ResultSet rs = stmt.executeQuery();

            List<String> vies = new ArrayList<>();
            while (rs.next()) {
                vies.add("ID: " + rs.getInt("id_via") + " | Nom: " + rs.getString("nom") +
                        " | Estat: " + rs.getString("estat"));
            }

            if (vies.isEmpty()) {
                Vista.mostrarMissatge("No hi ha vies disponibles per a l'escola amb el nom: " + nomEscola + ".");
            } else {
                Vista.mostrarMissatge("Vies disponibles a l'escola " + escolaSeleccionada.getNom() + ":");
                for (String via : vies) {
                    Vista.mostrarMissatge(via);
                }
            }
        } catch (SQLException e) {
            Vista.mostrarMissatge("Error a la consulta: " + e.getMessage());
        }
    }

    public static void cercarViesPerDificultat(String dificultat) {
        String sql = "SELECT v.id_via, v.nom, d.nom AS dificultat FROM vies v " +
                "JOIN trams t ON v.id_via = t.id_via " +
                "JOIN dificultats d ON t.id_dificultat = d.id_dificultat " +
                "WHERE d.nom = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dificultat);
            ResultSet rs = stmt.executeQuery();

            List<String> vies = new ArrayList<>();
            while (rs.next()) {
                vies.add("ID: " + rs.getInt("id_via") + " | Nom: " + rs.getString("nom") +
                        " | Dificultat: " + rs.getString("dificultat"));
            }

            if (vies.isEmpty()) {
                Vista.mostrarMissatge("No hi ha vies amb la dificultat '" + dificultat + "'.");
            } else {
                Vista.mostrarMissatge("Vies amb la dificultat '" + dificultat + "':");
                for (String via : vies) {
                    Vista.mostrarMissatge(via);
                }
            }
        } catch (SQLException e) {
            Vista.mostrarMissatge("Error a la consulta: " + e.getMessage());
        }
    }

    public static void cercarViesPerEstat(String estat) {
        String sql = "SELECT id_via, nom, estat FROM vies WHERE estat = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, estat);
            ResultSet rs = stmt.executeQuery();

            List<String> vies = new ArrayList<>();
            while (rs.next()) {
                vies.add("ID: " + rs.getInt("id_via") + " | Nom: " + rs.getString("nom") +
                        " | Estat: " + rs.getString("estat"));
            }

            if (vies.isEmpty()) {
                Vista.mostrarMissatge("No hi ha vies amb l'estat '" + estat + "'.");
            } else {
                Vista.mostrarMissatge("Vies amb estat '" + estat + "':");
                for (String via : vies) {
                    Vista.mostrarMissatge(via);
                }
            }
        } catch (SQLException e) {
            Vista.mostrarMissatge("Error a la consulta: " + e.getMessage());
        }
    }

    public static void consultarEscolesAmbRestriccions() {
        String sql = "SELECT id_escola, nom, restriccions FROM escoles WHERE restriccions IS NOT NULL AND restriccions != ''";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            List<String> escoles = new ArrayList<>();
            while (rs.next()) {
                escoles.add("ID: " + rs.getInt("id_escola") + " | Nom: " + rs.getString("nom") +
                        " | Restriccions: " + rs.getString("restriccions"));
            }

            if (escoles.isEmpty()) {
                Vista.mostrarMissatge("No hi ha escoles amb restriccions actives.");
            } else {
                Vista.mostrarMissatge("Escoles amb restriccions actives:");
                for (String escola : escoles) {
                    Vista.mostrarMissatge(escola);
                }
            }
        } catch (SQLException e) {
            Vista.mostrarMissatge("Error a la consulta: " + e.getMessage());
        }
    }

    public static void mostrarSectorsAmbMesDeXVies(int x) {
        String sql = "SELECT id_sector, nom, numero_vies FROM sectors WHERE numero_vies > ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, x);
            ResultSet rs = stmt.executeQuery();

            List<String> sectors = new ArrayList<>();
            while (rs.next()) {
                sectors.add("ID: " + rs.getInt("id_sector") + " | Nom: " + rs.getString("nom") +
                        " | Vies disponibles: " + rs.getInt("numero_vies"));
            }

            if (sectors.isEmpty()) {
                Vista.mostrarMissatge("No hi ha sectors amb més de " + x + " vies disponibles.");
            } else {
                Vista.mostrarMissatge("Sectors amb més de " + x + " vies disponibles:");
                for (String sector : sectors) {
                    Vista.mostrarMissatge(sector);
                }
            }
        } catch (SQLException e) {
            Vista.mostrarMissatge("Error a la consulta: " + e.getMessage());
        }
    }

    public static void mostrarEscaladorsAmbNivellMaxim(String nivellMaxim) {
        String sql = "SELECT id_escalador, nom, nivell_maxim FROM escaladors WHERE nivell_maxim = ?";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nivellMaxim);
            ResultSet rs = stmt.executeQuery();

            List<String> escaladors = new ArrayList<>();
            while (rs.next()) {
                escaladors.add("ID: " + rs.getInt("id_escalador") + " | Nom: " + rs.getString("nom") +
                        " | Nivell màxim: " + rs.getString("nivell_maxim"));
            }

            if (escaladors.isEmpty()) {
                Vista.mostrarMissatge("No hi ha escaladors amb el nivell màxim '" + nivellMaxim + "'.");
            } else {
                Vista.mostrarMissatge("Escaladors amb nivell màxim '" + nivellMaxim + "':");
                for (String escalador : escaladors) {
                    Vista.mostrarMissatge(escalador);
                }
            }
        } catch (SQLException e) {
            Vista.mostrarMissatge("Error a la consulta: " + e.getMessage());
        }
    }

    public static void mostrarViesMesLlarguesEscola(String nomEscola) {
        Escola escolaSeleccionada = seleccionarEscolaPerNom(nomEscola);
        if (escolaSeleccionada == null) return;

        String sql = "SELECT v.id_via, v.nom, SUM(t.llargada) AS llargada_total FROM vies v " +
                "JOIN trams t ON v.id_via = t.id_via " +
                "JOIN sectors s ON v.id_sector = s.id_sector " +
                "JOIN escoles e ON s.id_escola = e.id_escola " +
                "WHERE e.id_escola = ? " +
                "GROUP BY v.id_via ORDER BY llargada_total DESC";

        try (Connection conn = ConnexioBD.getConnexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, escolaSeleccionada.getIdEscola());
            ResultSet rs = stmt.executeQuery();

            List<String> vies = new ArrayList<>();
            while (rs.next()) {
                vies.add("ID: " + rs.getInt("id_via") + " | Nom: " + rs.getString("nom") +
                        " | Longitud total: " + rs.getInt("llargada_total"));
            }

            if (vies.isEmpty()) {
                Vista.mostrarMissatge("No hi ha vies llargues per a l'escola amb el nom: " + nomEscola + ".");
            } else {
                Vista.mostrarMissatge("Vies més llargues de l'escola " + escolaSeleccionada.getNom() + ":");
                for (String via : vies) {
                    Vista.mostrarMissatge(via);
                }
            }
        } catch (SQLException e) {
            Vista.mostrarMissatge("Error a la consulta: " + e.getMessage());
        }
    }
}