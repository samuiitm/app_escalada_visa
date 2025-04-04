package Model.Constructors;

public class Escola extends Entitat {
    String nom;
    int id_localitzacio;
    String aproximacio;
    int numero_vies;
    String popularitat;
    String restriccions;

    public Escola(int id, String nom, int id_localitzacio, String aproximacio, int numero_vies, String popularitat, String restriccions) {
        super(id);
        this.nom = nom;
        this.id_localitzacio = id_localitzacio;
        this.aproximacio = aproximacio;
        this.numero_vies = numero_vies;
        this.popularitat = popularitat;
        this.restriccions = restriccions;
    }

    //Getters i Setters
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getId_localitzacio() {
        return id_localitzacio;
    }
    public void setId_localitzacio(int id_localitzacio) {
        this.id_localitzacio = id_localitzacio;
    }
    public String getAproximacio() {
        return aproximacio;
    }
    public void setAproximacio(String aproximacio) {
        this.aproximacio = aproximacio;
    }
    public int getNumero_vies() {
        return numero_vies;
    }
    public void setNumero_vies(int numero_vies) {
        this.numero_vies = numero_vies;
    }
    public String getPopularitat() {
        return popularitat;
    }
    public void setPopularitat(String popularitat) {
        this.popularitat = popularitat;
    }
    public String getRestriccions() {
        return restriccions;
    }
    public void setRestriccions(String restriccions) {
        this.restriccions = restriccions;
    }

    @Override
    public String toString() {
        return "Escoles{" +
                "nom='" + nom + '\'' +
                ", id_localitzacio=" + id_localitzacio +
                ", aproximacio='" + aproximacio + '\'' +
                ", numero_vies=" + numero_vies +
                ", popularitat='" + popularitat + '\'' +
                ", restriccions='" + restriccions + '\'' +
                '}';
    }
}
