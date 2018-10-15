package com.cours5b5.philippechevry.modeles;

import com.cours5b5.philippechevry.serialisation.AttributSerialisable;

import java.util.Map;

public class MPartie extends Modele {
    @AttributSerialisable
    public MParametresPartie parametres;
    private String _paramestresPartie = "parametres";

    public MParametresPartie getParametres() {
        return parametres;
    }
    public MPartie(MParametresPartie parametres){
        this.parametres = parametres;
    }
    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) {

    }

    @Override
    public Map<String, Object> enObjetJson() {
        return null;
    }
}
