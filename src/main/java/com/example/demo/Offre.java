package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.*;

@Document
public class Offre {


    @Id
    private String id;
    private  String titre;
    private  String titresa;
    private  String description;
    private  float prix;
    private  String priorité;
    private  Statut status = Statut.active;
    private  String domaine;
    private String region;
    private String ville;
    private String dateP;
    private String dateS;
    private Compte utilisateur;
    private String employee;
    private String images;



    //COnstructeur, setters, getters, equals, hash et toString
    public Offre(){}

    public Offre(String id, String titre, String titresa, String description, Statut status, String domaine, String region, String ville, String dateP, String dateS, Compte utilisateur, String images, String Employee) {
        this.id = id;
        this.titre = titre;
        this.titresa = titresa;
        this.description = description;
        this.status = status;
        this.domaine = domaine;
        this.region = region;
        this.ville = ville;
        this.dateP = dateP;
        this.dateS = dateS;
        this.utilisateur = utilisateur;
        this.employee = Employee;
        this.images = images;
    }

    public String getDateP() {
        return dateP;
    }
    public void setStatus(Statut status) {
        this.status = status;
    }

    public String getDateS() {
        return dateS;
    }

    public Compte getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Compte utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getTitre() {
        return titre;
    }

    public String getTitresa() {
        return titresa;
    }

    public String getDescription() {
        return description;
    }


    public Statut getStatus() {
        return status;
    }

    public String getDomaine() {
        return domaine;
    }

    public String getId() {
        return id;
    }

    public String getRegion() {
        return region;
    }

    public String getVille() {
        return ville;
    }

    public String getDate() {
        return dateS;
    }

    public void setTitresa(){
        titresa = unaccentlowercase(getTitre());
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }


    public void setDateS() {
        Date dateloc = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(dateloc);
        this.dateS = strDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offre offre = (Offre) o;
        return Objects.equals(id, offre.id) && Objects.equals(titre, offre.titre) && Objects.equals(titresa, offre.titresa) && Objects.equals(description, offre.description) && Objects.equals(status, offre.status) && Objects.equals(domaine, offre.domaine) && Objects.equals(region, offre.region) && Objects.equals(ville, offre.ville) && Objects.equals(dateP, offre.dateP) && Objects.equals(dateS, offre.dateS) && Objects.equals(utilisateur, offre.utilisateur)&& Objects.equals(employee, offre.employee) && Objects.equals(images, offre.images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titre, titresa, description, prix, priorité, status, domaine, region, ville, dateP, dateS, utilisateur, images, employee);
    }

    @Override
    public String toString() {
        return "Offre{" +
                "id='" + id + '\'' +
                ", titre='" + titre + '\'' +
                ", titresa='" + titresa + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", domaine='" + domaine + '\'' +
                ", region='" + region + '\'' +
                ", ville='" + ville + '\'' +
                ", dateP='" + dateP + '\'' +
                ", dateS='" + dateS + '\'' +
                ", employeur=" + utilisateur + '\''+
                ",employee="+ employee + '\''+
                ", images=" + images +
                '}';
    }

    //methode de mise en forme du resultat
    public String unaccentlowercase(String s){
        String normalizedWord = Normalizer.normalize(s, Normalizer.Form.NFD);
        return normalizedWord.replaceAll("\\p{M}", "").toLowerCase();
    }
}