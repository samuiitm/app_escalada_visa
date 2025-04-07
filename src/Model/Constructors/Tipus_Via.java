package Model.Constructors;

public class Tipus_Via {
    int idTipusVia;
    String nom;

    public Tipus_Via(String nom) {
        this.idTipusVia = 0;
        this.nom = nom;
    }

    public Tipus_Via(int id, String nom) {
        this.idTipusVia = id;
        this.nom = nom;
    }

    //Getters i Setters
    public int getIdTipusVia() {
        return idTipusVia;
    }
    public void setIdTipusVia(int idTipusVia) {
        this.idTipusVia = idTipusVia;
    }
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
