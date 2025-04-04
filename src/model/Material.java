package model;

public class Material extends Entitat {
    String nom;

    public Material(int id, String nom) {
        super(id);
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
