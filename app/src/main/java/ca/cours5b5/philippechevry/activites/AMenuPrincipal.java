package ca.cours5b5.philippechevry.activites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.firebase.ui.auth.AuthUI;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.philippechevry.R;
import ca.cours5b5.philippechevry.controleurs.ControleurAction;
import ca.cours5b5.philippechevry.controleurs.interfaces.Fournisseur;
import ca.cours5b5.philippechevry.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.philippechevry.global.GCommande;

public class AMenuPrincipal extends Activite implements Fournisseur {
       private static int MA_CONSTANTE_CODE_CONNEXION = 123;

    private static List<AuthUI.IdpConfig> fournisseursDeConnexion = new ArrayList<>();

    static{

        fournisseursDeConnexion.add(new AuthUI.IdpConfig.GoogleBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.EmailBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.PhoneBuilder().build());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        fournirActions();

    }

    private void fournirActions() {

        fournirActionOuvrirMenuParametres();

        fournirActionDemarrerPartie();
        fournirActionConnextionFireBase();
    }

    private void fournirActionOuvrirMenuParametres() {

        ControleurAction.fournirAction(this,
                GCommande.OUVRIR_MENU_PARAMETRES,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionParametres();

                    }
                });
    }

    private void fournirActionDemarrerPartie() {

        ControleurAction.fournirAction(this,
                GCommande.DEMARRER_PARTIE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionPartie();

                    }
                });
    }
    private void fournirActionConnextionFireBase() {

        ControleurAction.fournirAction(this,
                GCommande.CONNEXION_FIRE_BASE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        connexionFirebase();
                    }
                });
    }

    private void transitionParametres(){

        Intent intentionParametres = new Intent(this, AParametres.class);
        startActivity(intentionParametres);

    }

    private void transitionPartie(){

        Intent intentionParametres = new Intent(this, APartie.class);
        startActivity(intentionParametres);

    }

    private void connexionFirebase(){

        Intent intentionConnexion = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(fournisseursDeConnexion)
                .build();
        this.startActivityForResult(intentionConnexion,MA_CONSTANTE_CODE_CONNEXION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == MA_CONSTANTE_CODE_CONNEXION){
            if(resultCode == RESULT_OK){
                Log.d("atelier11","Connexion réussi");
            } else{
                Log.d("atelier11","Connexion échouée");
            }
        }
    }
}
