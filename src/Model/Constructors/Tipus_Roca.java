package Model.Constructors;

public class Tipus_Roca {
    int idTipusRoca;
    String nom;

    public Tipus_Roca(String nom) {
        this.idTipusRoca = 0;
        this.nom = nom;
    }

    public Tipus_Roca(int id, String nom) {
        this.idTipusRoca = id;
        this.nom = nom;
    }

    //Getters i Setters
    public int getIdTipusRoca() {
        return idTipusRoca;
    }
    public void setIdTipusRoca(int idTipusRoca) {
        this.idTipusRoca = idTipusRoca;
    }
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
