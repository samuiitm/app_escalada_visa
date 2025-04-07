package Model.Constructors;

public class Localitzacio {
    int idLocalitzacio;
    String ciutat;
    String regio;
    String codipostal;

    public Localitzacio(String ciutat, String regio, String codipostal) {
        this.idLocalitzacio = 0;
        this.ciutat = ciutat;
        this.regio = regio;
        this.codipostal = codipostal;
    }

    public Localitzacio(int id, String ciutat, String regio, String codipostal) {
        this.idLocalitzacio = id;
        this.ciutat = ciutat;
        this.regio = regio;
        this.codipostal = codipostal;
    }

    //Getters i Setters
    public int getIdLocalitzacio() {
        return idLocalitzacio;
    }
    public void setIdLocalitzacio(int idLocalitzacio) {
        this.idLocalitzacio = idLocalitzacio;
    }
    public String getCiutat() {
        return ciutat;
    }
    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }
    public String getRegio() {
        return regio;
    }
    public void setRegio(String regio) {
        this.regio = regio;
    }
    public String getCodipostal() {
        return codipostal;
    }
    public void setCodipostal(String codipostal) {
        this.codipostal = codipostal;
    }

    @Override
    public String toString() {
        return "Localitzacio{" +
                "ciutat='" + ciutat + '\'' +
                ", regio='" + regio + '\'' +
                ", codipostal='" + codipostal + '\'' +
                '}';
    }
}
