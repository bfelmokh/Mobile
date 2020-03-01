package com.example.gestion_permission;

public class Autorisation {
    String nom;
    boolean etat;

    public Autorisation(String nom, boolean etat) {
        this.nom = nom;
        this.etat = etat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Autorisation{" +
                "nom='" + nom + '\'' +
                ", etat=" + etat +
                '}';
    }
}
