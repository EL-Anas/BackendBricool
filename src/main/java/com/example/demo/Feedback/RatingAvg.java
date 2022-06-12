package com.example.demo.Feedback;


import com.example.demo.Compte;

public class RatingAvg {
    private Compte utilisateur;
    private double rating;
    private int count;
    private double notefinale;

    public Compte getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Compte utilisateur) {
        this.utilisateur = utilisateur;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getNotefinale() {
        return notefinale;
    }

    public void setNotefinale(double notefinale) {
        this.notefinale = notefinale;
    }
}

