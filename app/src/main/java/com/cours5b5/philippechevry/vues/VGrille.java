package com.cours5b5.philippechevry.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

public class VGrille extends GridLayout {
    public VGrille(Context context) {
        super(context);
    }

    public VGrille(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VGrille(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private int nombreRangees;
    private List<VEntete> entetes;
    private VCase[][] lesCases;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    void creerGrille(int hauteur, int largeur){

        initialiserTableauDeCases(hauteur,largeur);
        ajouterEnTetes(largeur);
        ajouterCases(hauteur,largeur);

    }

    private void initialiserTableauDeCases(int hauteur, int largeur){
        lesCases = new VCase[largeur][hauteur];
    }

    private void ajouterEnTetes(int largeur ){
        entetes = new ArrayList<>();

        for(int colonneEntete = 0; colonneEntete < largeur; colonneEntete++){
            VEntete vEntete = new VEntete(getContext(),colonneEntete);
            this.addView(vEntete,getMiseEnPageEntete(colonneEntete));
            entetes.add(vEntete);
        }
    }

    private LayoutParams getMiseEnPageEntete(int colonne){

         Spec specRangee = GridLayout.spec(0,2.0f);
         Spec specColonne = GridLayout.spec(colonne,1.0f);

        LayoutParams mesParams = new LayoutParams(specRangee,specColonne);
        mesParams.width = 0;
        mesParams.height = 0;
        mesParams.setGravity(Gravity.FILL);

        return mesParams;
    }

    private void ajouterCases(int hauteur, int largeur){
        nombreRangees = largeur;
        for (int  colonne =0; colonne < largeur; colonne++ ) {
            for (int rangerLigne = hauteur; rangerLigne > 0; rangerLigne--){

                VCase vCase = new VCase(getContext(),rangerLigne - (2*(rangerLigne - hauteur) - hauteur),colonne);

                this.addView(vCase,getMiseEnPageCase(rangerLigne ,colonne));
                lesCases[colonne][ rangerLigne] = vCase;
        }
        }

    }

    private LayoutParams getMiseEnPageCase(int rangee, int colonne){

        Spec specRangee = GridLayout.spec(rangee,1.0f);
        Spec specColonne = GridLayout.spec(colonne,1.0f);

        LayoutParams mesParams = new LayoutParams(specRangee,specColonne);
        mesParams.width = 1;
        mesParams.height = 1;
        mesParams.setGravity(Gravity.FILL);

        return mesParams;

    }
}
