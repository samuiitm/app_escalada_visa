package model.constructors;

import model.Entitat;

public class Dificultat extends Entitat {
    String nom;

    public Dificultat(int id, String nom) {
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
        return "Dificultat{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
