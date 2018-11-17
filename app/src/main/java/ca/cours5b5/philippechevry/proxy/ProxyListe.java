package ca.cours5b5.philippechevry.proxy;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.List;

import ca.cours5b5.philippechevry.controleurs.Action;
import ca.cours5b5.philippechevry.controleurs.interfaces.Fournisseur;
import ca.cours5b5.philippechevry.global.GCommande;

public class ProxyListe  extends Proxy implements Fournisseur {
    private ChildEventListener childEventListener;
    private Query requete;
    private Action actionNouvelItem;
    private List<DatabaseReference> noedsAjoutes;



    public ProxyListe(String cheminServeur) {
        super(cheminServeur);
    }

    public void setActionNouvelItem(GCommande commande){

    }
    public  void ajouterValeur(Object Valeur){

    }

    @Override
    public void connecterAuserveur() {
        super.connecterAuserveur();
    }
    private void creerListener(){

    }
    protected Query getRequete(){

        return null;
    }

    @Override
    public void deconnecterDuServeur() {
        super.deconnecterDuServeur();
    }

    @Override
    public void detruireValeurs() {

    }
}
