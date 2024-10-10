package com.example.tricount;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tricount implements Serializable {
    private String titre;
    private String description;
    private String date;
    private double total_depense;
    private ArrayList<Depense> depenses;

    public Tricount(String titre, String description, String date, double total_depense) {
        this.titre = titre;
        this.description = description;
        this.date = date;
        this.total_depense = total_depense;
        this.depenses = new ArrayList<>();
    }

    public Tricount(String titre, String description, String date) {
        this.titre = titre;
        this.description = description;
        this.date = date;
        this.depenses = new ArrayList<>();
    }

    public void ajouterDepense(Depense depense){
        this.depenses.add(depense);
        this.total_depense += depense.getMontant();
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String toString(){
        return "Titre: " + this.titre + "\nDescription: " + this.description + "\nDate: " + this.date;
    }



}
