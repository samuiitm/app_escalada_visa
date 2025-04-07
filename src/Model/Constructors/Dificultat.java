package Model.Constructors;

public class Dificultat {
    int idDificultat;
    String nom;

    public Dificultat(String nom) {
        this.idDificultat = 0;
        this.nom = nom;
    }

    public Dificultat(int id, String nom) {
        this.idDificultat = id;
        this.nom = nom;
    }

    //Getters i Setters
    public int getIdDificultat() {
        return idDificultat;
    }
    public void setIdDificultat(int idDificultat) {
        this.idDificultat = idDificultat;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Dificultat{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
