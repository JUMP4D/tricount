package com.example.tricount;

import java.io.Serializable;

public class Depense implements Serializable {
    private String titre;
    private String description;
    private double montant;
    private String date;

    public Depense(String titre, String description, double montant, String date) {
        this.titre = titre;
        this.description = description;
        this.montant = montant;
        this.date = date;
    }

    public String getTitre() {
        return titre;
    }


    public String getDescription() {
        return description;
    }

    public double getMontant() {
        return montant;
    }

    public String getDate() {
        return date;
    }

    public String toString() {
        return "Description: " + description + ", Date: " + date + ", Montant: " + montant;
    }

}
