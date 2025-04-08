package Model.Constructors;

public class Via {
    int idVia;
    String nom;
    int id_tipus_via;
    String estat;
    String orientacio;
    int id_ancoratge;
    int id_tipus_roca;
    int id_sector;
    int id_material;
    int creador;

    public Via(String nom, int id_tipus_via, String estat, String orientacio, int id_ancoratge, int id_tipus_roca, int id_sector, int id_material, int creador) {
        this.idVia = 0;
        this.nom = nom;
        this.id_tipus_via = id_tipus_via;
        this.estat = estat;
        this.orientacio = orientacio;
        this.id_ancoratge = id_ancoratge;
        this.id_tipus_roca = id_tipus_roca;
        this.id_sector = id_sector;
        this.id_material = id_material;
        this.creador = creador;
    }

    public Via(int id, String nom, int id_tipus_via, String estat, String orientacio, int id_ancoratge, int id_tipus_roca, int id_sector, int id_material, int creador) {
        this.idVia = id;
        this.nom = nom;
        this.id_tipus_via = id_tipus_via;
        this.estat = estat;
        this.orientacio = orientacio;
        this.id_ancoratge = id_ancoratge;
        this.id_tipus_roca = id_tipus_roca;
        this.id_sector = id_sector;
        this.id_material = id_material;
        this.creador = creador;
    }

    //Getters i Setters
    public int getIdVia() {
        return idVia;
    }
    public void setIdVia(int idVia) {
        this.idVia = idVia;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getIdTipusVia() {
        return id_tipus_via;
    }
    public void setIdTipusVia(int id_tipus_via) {
        this.id_tipus_via = id_tipus_via;
    }
    public String getEstat() {
        return estat;
    }
    public void setEstat(String estat) {
        this.estat = estat;
    }
    public String getOrientacio() {
        return orientacio;
    }
    public void setOrientacio(String orientacio) {
        this.orientacio = orientacio;
    }
    public int getIdAncoratge() {
        return id_ancoratge;
    }
    public void setIdAncoratge(int id_ancoratge) {
        this.id_ancoratge = id_ancoratge;
    }
    public int getIdTipusRoca() {
        return id_tipus_roca;
    }
    public void setIdTipusRoca(int id_tipus_roca) {
        this.id_tipus_roca = id_tipus_roca;
    }
    public int getIdSector() {
        return id_sector;
    }
    public void setIdSector(int id_sector) {
        this.id_sector = id_sector;
    }
    public int getIdMaterial() {
        return id_material;
    }
    public void setIdMaterial(int id_material) {
        this.id_material = id_material;
    }
    public int getCreador() {
        return creador;
    }
    public void setCreador(int creador) {
        this.creador = creador;
    }

    @Override
    public String toString() {
        return "Via{" +
                "nom='" + nom + '\'' +
                ", id_tipus_via=" + id_tipus_via +
                ", estat='" + estat + '\'' +
                ", orientacio='" + orientacio + '\'' +
                ", id_ancoratge=" + id_ancoratge +
                ", id_tipus_roca=" + id_tipus_roca +
                ", id_sector=" + id_sector +
                ", id_material=" + id_material +
                ", creador=" + creador +
                '}';
    }
}