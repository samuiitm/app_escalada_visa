package Model.Constructors;

public class Escalador {
    int idEscalador;
    String nom;
    String alies;
    int edat;
    String nivell_maxim;
    int via_nivell_maxim;
    String estil_preferit;

    public Escalador(String nom, String alies, int edat, String nivell_maxim, int via_nivell_maxim, String estil_preferit) {
        this.idEscalador = 0;
        this.nom = nom;
        this.alies = alies;
        this.edat = edat;
        this.nivell_maxim = nivell_maxim;
        this.via_nivell_maxim = via_nivell_maxim;
        this.estil_preferit = estil_preferit;
    }

    public Escalador(int id, String nom, String alies, int edat, String nivell_maxim, int via_nivell_maxim, String estil_preferit) {
        this.idEscalador = id;
        this.nom = nom;
        this.alies = alies;
        this.edat = edat;
        this.nivell_maxim = nivell_maxim;
        this.via_nivell_maxim = via_nivell_maxim;
        this.estil_preferit = estil_preferit;
    }

    // Getter y Setters
    public int getIdEscalador() {
        return idEscalador;
    }
    public void setIdEscalador(int idEscalador) {
        this.idEscalador = idEscalador;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getAlies() {
        return alies;
    }
    public void setAlies(String alies) {
        this.alies = alies;
    }
    public int getEdat() {
        return edat;
    }
    public void setEdat(int edat) {
        this.edat = edat;
    }
    public String getNivellMaxim() {
        return nivell_maxim;
    }
    public void setNivellMaxim(String nivell_maxim) {
        this.nivell_maxim = nivell_maxim;
    }
    public int getViaNivellMaxim() {
        return via_nivell_maxim;
    }
    public void setViaNivellMaxim(int via_nivell_maxim) {
        this.via_nivell_maxim = via_nivell_maxim;
    }
    public String getEstilPreferit() {
        return estil_preferit;
    }
    public void setEstilPreferit(String estil_preferit) {
        this.estil_preferit = estil_preferit;
    }

    @Override
    public String toString() {
        return "Escalador{" +
                "nom='" + nom + '\'' +
                ", alies='" + alies + '\'' +
                ", edat=" + edat +
                ", nivell_maxim='" + nivell_maxim + '\'' +
                ", via_nivell_maxim=" + via_nivell_maxim +
                ", estil_preferit='" + estil_preferit + '\'' +
                '}';
    }
}
