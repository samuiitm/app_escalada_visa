package Model.Constructors;

public class Ancoratge {
    int idAncoratge;
    String nom;

    public Ancoratge(String nom) {
        this.idAncoratge = 0;
        this.nom = nom;
    }

    public Ancoratge(int id, String nom) {
        this.idAncoratge = id;
        this.nom = nom;
    }

    //Getters i Setters
    public int getIdAncoratge() {
        return idAncoratge;
    }
    public void setIdAncoratge(int idAncoratge) {
        this.idAncoratge = idAncoratge;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Ancoratge{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
