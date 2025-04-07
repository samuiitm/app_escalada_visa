package Model.Constructors;

public class Tipus_Via {
    String nom;

    public Tipus_Via(String nom) {
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
        return "Tipus_Via{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
