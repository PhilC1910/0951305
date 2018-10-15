package com.cours5b5.philippechevry.modeles;

import com.cours5b5.philippechevry.serialisation.AttributSerialisable;

import java.util.Map;

public class MParametresPartie extends Modele {
    @AttributSerialisable
    public Integer hauteur;
    protected  final String _hauteur = "hauteur";

    @AttributSerialisable
    public Integer largeur;
    protected  final String _largeur = "largeur";

    @AttributSerialisable
    public Integer pourGagner;
    protected  final String _pourGagner = "pourGagner";

    public static MParametresPartie aPartirMParametres(MParametres mParametres){
        MParametresPartie mParametresPartie = mParametres.getParametresPartie().cloner();
        return  mParametresPartie;
    }

    public Integer getHauteur() {
        return hauteur;
    }

    public void setHauteur(Integer hauteur) {
        this.hauteur = hauteur;
    }

    public Integer getLargeur() {
        return largeur;
    }

    public void setLargeur(Integer largeur) {
        this.largeur = largeur;
    }

    public Integer getPourGagner() {
        return pourGagner;
    }

    public void setPourGagner(Integer pourGagner) {
        this.pourGagner = pourGagner;
    }

    public MParametresPartie cloner(){
        MParametresPartie mParametresPartie = this;
        return  mParametresPartie;
    }
    public  MParametresPartie(){

    }


    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) {

    }

    @Override
    public Map<String, Object> enObjetJson() {
        return null;
    }
}
