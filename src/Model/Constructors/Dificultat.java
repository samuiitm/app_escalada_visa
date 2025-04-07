package Model.Constructors;

public class Dificultat{
    String nom;

    public Dificultat(String nom) {
        this.nom = nom;
    }

    //Getters i Setters
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
