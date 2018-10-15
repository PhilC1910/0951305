package com.cours5b5.philippechevry.controleurs;

import com.cours5b5.philippechevry.modeles.MPartie;
import com.cours5b5.philippechevry.modeles.Modele;

import java.util.Map;

public class ControleurObservation {
    private  static Map<Modele, ListenerObservation> observations;
    private static MPartie partie;

    static{

    }

    public static void observerModele(String nomModele, final ListenerObservation listenerObservation) {
        Modele modele = null;

        observations.put(modele,listenerObservation);
        try {
            modele = (Modele) Class.forName(nomModele).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
