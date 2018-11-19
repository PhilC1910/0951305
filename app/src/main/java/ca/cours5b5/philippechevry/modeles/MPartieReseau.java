package ca.cours5b5.philippechevry.modeles;

import java.util.Map;

import ca.cours5b5.philippechevry.controleurs.ControleurAction;
import ca.cours5b5.philippechevry.controleurs.ControleurPartieReseau;
import ca.cours5b5.philippechevry.controleurs.interfaces.Fournisseur;
import ca.cours5b5.philippechevry.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.philippechevry.exceptions.ErreurAction;
import ca.cours5b5.philippechevry.exceptions.ErreurSerialisation;
import ca.cours5b5.philippechevry.global.GCommande;
import ca.cours5b5.philippechevry.serialisation.AttributSerialisable;

public class MPartieReseau extends MPartie implements Fournisseur, Identifiable {

@AttributSerialisable
public String idJoueurInvite;
private String _idJoueurInvite = "idJoueurInvite";

@AttributSerialisable
public String idJoueurHote;
private String _idJoueurHote= "idJoueurHote";


    public MPartieReseau(MParametresPartie parametres) {

        super(parametres);
        fournirActionRecevoirCoup();

    }

    @Override
    public String getId() {
        return idJoueurHote;
    }

    private void fournirActionRecevoirCoup(){
        ControleurAction.fournirAction(this,GCommande.RECEVOIR_COUP_RESEAU, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {

                try {
                    int colonne = Integer.parseInt((String)args[0]);


                    recevoirCoupReseau( colonne);
                }catch (ClassCastException e){
                    throw new ErreurAction(e);
                }


            }
        });
    }

    @Override
    protected void fournirActionPlacerJeton() {
        super.fournirActionPlacerJeton();

        ControleurAction.fournirAction(this, GCommande.JOUER_COUP_ICI, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                try {

                    int colonne = (Integer) args[0];

                    jouerCoup(colonne);
                    ControleurPartieReseau.getInstance().transmettreCoup(colonne);
                }catch (ClassCastException e){
                    throw new ErreurAction(e);
                }
            }
        });
    }

    private void recevoirCoupReseau(int colonne){
        jouerCoup(colonne);
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {
        super.aPartirObjetJson(objetJson);
idJoueurHote = (String) objetJson.get(_idJoueurHote);
idJoueurInvite = (String) objetJson.get(_idJoueurInvite);

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation {
        Map<String,Object> objectJson = super.enObjetJson();
        objectJson.put(_idJoueurHote,idJoueurHote);
        objectJson.put(_idJoueurInvite,idJoueurInvite);
        return objectJson;
    }
}
