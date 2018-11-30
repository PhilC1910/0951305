package ca.cours5b5.philippechevry.vues;

import android.content.Context;
import android.util.AttributeSet;

import ca.cours5b5.philippechevry.R;
import ca.cours5b5.philippechevry.controleurs.ControleurObservation;
import ca.cours5b5.philippechevry.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.philippechevry.exceptions.ErreurObservation;
import ca.cours5b5.philippechevry.modeles.MParametresPartie;
import ca.cours5b5.philippechevry.modeles.MPartie;
import ca.cours5b5.philippechevry.modeles.MPartieReseau;
import ca.cours5b5.philippechevry.modeles.Modele;


public class VPartieReseau extends VPartie {


    private VGrille grille;


    public VPartieReseau(Context context) {
        super(context);
    }

    public VPartieReseau(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VPartieReseau(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected String getNomModele(){
        return MPartieReseau.class.getSimpleName();
    }

}
