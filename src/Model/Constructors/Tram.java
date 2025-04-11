package Model.Constructors;

public class Tram {
    int idTram;
    private String nom;
    private int idDificultat;
    private int llargada;

    public Tram(String nom,int idDificultat, int llargada) {
        this.idTram = 0;
        this.nom = nom;
        this.idDificultat = idDificultat;
    }

    public Tram(int id, String nom,int idDificultat, int llargada) {
        this.idTram = id;
        this.nom = nom;
        this.idDificultat = idDificultat;
    }

    //Getters i Setters
    public int getIdTram() {
        return idTram;
    }
    public void setIdTram(int idTram) {
        this.idTram = idTram;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getIdDificultat() {
        return idDificultat;
    }
    public void setIdDificultat(int idDificultat) {
        this.idDificultat = idDificultat;
    }
    public int getLlargada() {
        return llargada;
    }
    public void setLlargada(int llargada) {
        this.llargada = llargada;
    }

    @Override
    public String toString() {
        return "Tram{" +
                "nom='" + nom + '\'' +
                ", idDificultat=" + idDificultat +
                ", Llargada=" + llargada +
                '}';
    }
}
