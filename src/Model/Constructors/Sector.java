package Model.Constructors;

public class Sector {
    String nom;
    String coordenades;
    String aproximacio;
    int numero_vies;
    String popularitat;
    String restriccions;
    int id_escola;

    public Sector(String nom, String coordenades, String aproximacio, int numero_vies, String popularitat, String restriccions, int id_escola) {
        this.nom = nom;
        this.coordenades = coordenades;
        this.aproximacio = aproximacio;
        this.numero_vies = numero_vies;
        this.popularitat = popularitat;
        this.restriccions = restriccions;
        this.id_escola = id_escola;
    }

    //Getters i Setters
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getCoordenades() {
        return coordenades;
    }
    public void setCoordenades(String coordenades) {
        this.coordenades = coordenades;
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
    public int getId_escola() {
        return id_escola;
    }
    public void setId_escola(int id_escola) {
        this.id_escola = id_escola;
    }

    @Override
    public String toString() {
        return "Sector{" +
                "nom='" + nom + '\'' +
                ", coordenades='" + coordenades + '\'' +
                ", aproximacio='" + aproximacio + '\'' +
                ", numero_vies=" + numero_vies +
                ", popularitat='" + popularitat + '\'' +
                ", restriccions='" + restriccions + '\'' +
                ", id_escola=" + id_escola +
                '}';
    }
}
