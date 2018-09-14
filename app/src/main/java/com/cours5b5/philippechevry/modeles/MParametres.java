package com.cours5b5.philippechevry.modeles;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.cours5b5.philippechevry.R;

import com.cours5b5.philippechevry.global.gConstantes;
import com.cours5b5.philippechevry.serialisation.AttributSerialisable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MParametres extends Modele {

    public static  MParametres instance = new MParametres();

    @AttributSerialisable
    public Integer hauteur;
    private final String _hauteur = "hauteur";

    @AttributSerialisable
    public Integer largeur;
    private final String _largeur = "largeur";

    @AttributSerialisable
    public Integer pourGagner;
    private final String _pourGagner = "pourGagner";

    private List<Integer> choixHauteur;
    private List<Integer> choixLargeur;
    private List<Integer> choixPourGagner;

    public MParametres(){


      genererListeDeChoix();

    }

    public List<Integer> getChoixHauteur() {
        return choixHauteur;
    }
    public List<Integer> getChoixLargeur() {
        return choixLargeur;
    }

    public List<Integer> getChoixPourGagner() {
        return choixPourGagner;
    }

    public Integer getHauteur() {
        return hauteur;
    }

    public Integer getLargeur() {
        return largeur;
    }

    public Integer getPourGagner() {
        return pourGagner;
    }

    public void setHauteur(Integer hauteur) {
        this.hauteur = hauteur;
    }

    public void setLargeur(Integer largeur) {
        this.largeur = largeur;
    }

    public void setPourGagner(Integer pourGagner) {
        this.pourGagner = pourGagner;
    }

    public void genererListeDeChoix(){

        genererListeChoixHauteur();
        genererListeChoixLargeur();
        genererListeChoixPourGagner();

        setHauteur(gConstantes.hauteurDefault);
        setLargeur(gConstantes.largeurDefault);
        setPourGagner(gConstantes.pourGagnerDefault);

    }

    private List<Integer> genererListeDeChoix(int min, int max){
        List<Integer> list =new ArrayList<>();
        for(int indice = min ;indice <= max ;indice++) {
            list.add(indice);
        }
        return list;

    }


    public void genererListeChoixHauteur(){
        choixHauteur = genererListeDeChoix(gConstantes.hauteurMin,gConstantes.hauteurMax);
    }
    public void genererListeChoixLargeur(){
        choixLargeur = genererListeDeChoix(gConstantes.largeurMin,gConstantes.largeurMax);
    }
    public void genererListeChoixPourGagner(){
        choixPourGagner = genererListeDeChoix(gConstantes.pourGagnerMin,gConstantes.pourGagnerMax);
    }
    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) {
        for(Map.Entry<String,Object> entry :objetJson.entrySet()){
          String cle = entry.getKey();
          Object valeur = entry.getValue();

            if (cle.equals( _hauteur)){
             hauteur = Integer.valueOf((String) entry.getValue());
            }else if(cle.equals( _largeur)){

                largeur = Integer.valueOf((String) entry.getValue());

            }else{

                pourGagner = Integer.valueOf((String) entry.getValue());
            }
        }
    }

    @Override
    public Map<String, Object> enObjetJson() {

        Map<String,Object> objetJson  = new HashMap<>();
        objetJson.put(_hauteur,hauteur.toString());
        objetJson.put(_largeur,largeur.toString());
        objetJson.put(_pourGagner, pourGagner.toString());

        return  objetJson;
    }
}
