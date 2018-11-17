package ca.cours5b5.philippechevry.proxy;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.philippechevry.controleurs.Action;
import ca.cours5b5.philippechevry.controleurs.ControleurAction;
import ca.cours5b5.philippechevry.controleurs.interfaces.Fournisseur;
import ca.cours5b5.philippechevry.global.GCommande;
import ca.cours5b5.philippechevry.global.GConstantes;

public class ProxyListe  extends Proxy implements Fournisseur {
    private ChildEventListener childEventListener;
    private Query requete;
    private Action actionNouvelItem;
    private List<DatabaseReference> noedsAjoutes;



    public ProxyListe(String cheminServeur) {
        super(cheminServeur);
        noedsAjoutes = new ArrayList<>();

    }



    public void setActionNouvelItem(GCommande commande){
        actionNouvelItem = ControleurAction.demanderAction(commande);
    }
    public  void ajouterValeur(Object Valeur){
        DatabaseReference temporaire = super.noeudServeur.push();
        temporaire.setValue(Valeur);
        noedsAjoutes.add(temporaire);
    }

    @Override
    public void connecterAuserveur() {
        super.connecterAuserveur();
        creerListener();
        requete = getRequete();
        requete.addChildEventListener(childEventListener);
    }
    private void creerListener(){
        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                actionNouvelItem.setArguments(dataSnapshot.getValue().toString());
                actionNouvelItem.executerDesQuePossible();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
    }
    protected Query getRequete(){
        return  requete = noeudServeur.orderByValue().limitToLast(GConstantes.LIMITE_MAX);

    }

    @Override
    public void deconnecterDuServeur() {
        super.deconnecterDuServeur();
        requete.removeEventListener(childEventListener);
    }

    @Override
    public void detruireValeurs() {
        for (DatabaseReference neaudDataReference: noedsAjoutes){
                neaudDataReference.removeValue();
        }

    }
}
