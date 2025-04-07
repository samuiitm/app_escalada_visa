package Model.Constructors;

public class Tipus_Roca {
    String nom;

    public Tipus_Roca(String nom) {
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
        return "Tipus_Roca{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
