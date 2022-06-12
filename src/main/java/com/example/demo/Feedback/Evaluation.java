package com.example.demo.Feedback;

import org.springframework.data.annotation.Id;

public class Evaluation {
    @Id
    private String idEvaluation;
    private String idEvalue,idEvaluateur,nomEvaluateur,note,comment,date;

    public Evaluation(String idEvaluation, String idEvalue,String idEvaluateur ,String nomEvaluateur, String note, String comment, String date) {
        this.idEvaluation = idEvaluation;
        this.idEvalue = idEvalue;
        this.idEvaluateur=idEvaluateur;
        this.nomEvaluateur = nomEvaluateur;
        this.note = note;
        this.comment = comment;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIdEvaluation() {
        return idEvaluation;
    }

    public void setIdEvaluation(String idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public String getIdEvalue() {
        return idEvalue;
    }

    public void setIdEvalue(String idEvalue) {
        this.idEvalue = idEvalue;
    }
    public String getIdEvaluateur() {
        return idEvaluateur;
    }

    public void setIdEvaluateur(String idEvaluateur) {
        this.idEvaluateur = idEvaluateur;
    }

    public String getNomEvaluateur() {
        return nomEvaluateur;
    }

    public void setNomEvaluateur(String nomEvaluateur) {
        this.nomEvaluateur = nomEvaluateur;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
