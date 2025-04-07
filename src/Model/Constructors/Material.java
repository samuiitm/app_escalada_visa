package Model.Constructors;

public class Material {
    String nom;

    public Material(String nom) {
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
        return "Material{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
