package Model.Constructors;

public class Material {
    int idMaterial;
    String nom;

    public Material(String nom) {
        this.idMaterial = 0;
        this.nom = nom;
    }

    public Material(int id, String nom) {
        this.idMaterial = id;
        this.nom = nom;
    }

    //Getters i Setters
    public int getIdMaterial() {
        return idMaterial;
    }
    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }
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
