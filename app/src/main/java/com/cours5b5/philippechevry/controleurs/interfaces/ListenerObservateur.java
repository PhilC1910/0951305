package com.cours5b5.philippechevry.controleurs.interfaces;

import com.cours5b5.philippechevry.modeles.Modele;

public abstract class ListenerObservateur {

    public void reagirNouveauModele(Modele modele){
        reagirChangementAuModele(modele);
    }
    public abstract void reagirChangementAuModele(Modele modele);
}
