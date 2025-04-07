package Model.Constructors;

public class Ancoratge{
    String nom;

    public Ancoratge(String nom) {
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
        return "Ancoratge{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
