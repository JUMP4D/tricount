package com.example.tricount;

import java.io.Serializable;
import java.util.ArrayList;

public class Tricount implements Serializable {
    private String titre;
    private String description;
    private String date;
    private double total_depense;
    private ArrayList<Depense> depenses;
    private ArrayList<User> membres;  // Liste de membres

    // Constructeur avec total dépense
    public Tricount(String titre, String description, String date, double total_depense) {
        this.titre = titre;
        this.description = description;
        this.date = date;
        this.total_depense = total_depense;
        this.depenses = new ArrayList<>();
        this.membres = new ArrayList<>();
    }

    // Constructeur sans total dépense
    public Tricount(String titre, String description, String date) {
        this.titre = titre;
        this.description = description;
        this.date = date;
        this.depenses = new ArrayList<>();
        this.membres = new ArrayList<>();
    }

    // Méthode pour ajouter une dépense
    public void ajouterDepense(Depense depense) {
        this.depenses.add(depense);
        this.total_depense += depense.getMontant();
    }

    // Méthode pour ajouter un membre
    public void ajouterMembre(User membre) {
        this.membres.add(membre);
    }

    // Getters
    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getTotal_depense() {
        return total_depense + "€";
    }

    // Liste des membres
    public ArrayList<User> getMembres() {
        return membres;
    }

    // toString() pour afficher les informations du Tricount
    @Override
    public String toString() {
        return "Titre: " + this.titre + "\nDescription: " + this.description + "\nDate: " + this.date;
    }
}
