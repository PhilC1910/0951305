package ca.cours5b5.philippechevry.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import ca.cours5b5.philippechevry.R;
import ca.cours5b5.philippechevry.controleurs.Action;
import ca.cours5b5.philippechevry.controleurs.ControleurAction;
import ca.cours5b5.philippechevry.global.GCommande;


public class VMenuPrincipal extends Vue {

    private Button boutonParametres;
    private Action actionParametres;

    private Button boutonPartie;
    private Action actionPartie;

    private Button boutonConnexionFireBase;
    private Action actionConnexionFireBase;

    public VMenuPrincipal(Context context) {
        super(context);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();

        recupererControles();

        demanderActions();

        installerListeners();

    }


    private void recupererControles() {

        boutonParametres = findViewById(R.id.bouton_parametres);

        boutonPartie = findViewById(R.id.bouton_partie);
        boutonConnexionFireBase = findViewById(R.id.buttonConnexion);
    }

    private void demanderActions() {

        actionParametres = ControleurAction.demanderAction(GCommande.OUVRIR_MENU_PARAMETRES);

        actionPartie = ControleurAction.demanderAction(GCommande.DEMARRER_PARTIE);
        actionConnexionFireBase = ControleurAction.demanderAction(GCommande.CONNEXION_FIRE_BASE);

    }


    private void installerListeners() {

        installerListenerParametres();

        installerListenerPartie();
        installerListenerConexion();

    }

    private void installerListenerPartie() {

        boutonPartie.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionPartie.executerDesQuePossible();
            }
        });

    }

    private void installerListenerParametres() {

        boutonParametres.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionParametres.executerDesQuePossible();
            }
        });

    }

    private void installerListenerConexion() {

        boutonConnexionFireBase.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionConnexionFireBase.executerDesQuePossible();
            }
        });

    }

}
