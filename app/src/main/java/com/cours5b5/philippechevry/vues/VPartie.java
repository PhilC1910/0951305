package com.cours5b5.philippechevry.vues;

import android.content.Context;
import android.util.AttributeSet;

import com.cours5b5.philippechevry.controleurs.ControleurObservation;
import com.cours5b5.philippechevry.controleurs.interfaces.ListenerObservateur;
import com.cours5b5.philippechevry.modeles.MPartie;
import com.cours5b5.philippechevry.modeles.Modele;

public class VPartie extends Vue {

private VGrille grille;



    public VPartie(Context context) {
        super(context);
    }

    public VPartie(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VPartie(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();


    }

    private MPartie  getPartie(Modele modele){

        return (MPartie) modele;
    }
    private void observerPartie(){
        ControleurObservation.observerModele(MPartie.class.getSimpleName(), new ListenerObservateur() {
            @Override
            public void reagirNouveauModele(Modele modele) {
                super.reagirNouveauModele(modele);

                MPartie partie = getPartie(modele);
                initialiserGrille( partie);
            }

            @Override
            public void reagirChangementAuModele(Modele modele) {

            }
        });
    }

    private void initialiserGrille(MPartie partie){
        grille.creerGrille(partie.getParametres().getHauteur(),partie.getParametres().getLargeur());
    }

}
