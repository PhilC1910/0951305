package ca.cours5b5.philippechevry.controleurs;

import ca.cours5b5.philippechevry.controleurs.interfaces.ListenerGetModele;
import ca.cours5b5.philippechevry.donnees.Serveur;
import ca.cours5b5.philippechevry.global.GCommande;
import ca.cours5b5.philippechevry.global.GConstantes;
import ca.cours5b5.philippechevry.modeles.MPartieReseau;
import ca.cours5b5.philippechevry.modeles.Modele;
import ca.cours5b5.philippechevry.proxy.ProxyListe;
import ca.cours5b5.philippechevry.usagers.UsagerCourant;

public class ControleurPartieReseau {
    private static final ControleurPartieReseau instance = new ControleurPartieReseau();

    public static ControleurPartieReseau getInstance() {
        return instance;
    }
    private ProxyListe proxyEmettreCoups;
    private ProxyListe proxyRecevoirCoups;

    public void connecterAuServer(){
       ControleurModeles.getModele(MPartieReseau.class.getSimpleName(), new ListenerGetModele() {
           @Override
           public void reagirAuModele(Modele modele) {
               MPartieReseau mPartieReseau =(MPartieReseau) modele;
               connecterAuServer(mPartieReseau.getId());
           }
       });
    }

    private void connecterAuServer(String idJoueurHote){
      String cheminCoupsJoeurHote = getCheminCoupsJoueurHote(idJoueurHote);
      String cheminCoupsJoeurInvite = getCheminCoupsJoueurInvite(idJoueurHote);
        if (UsagerCourant.getId().equals(idJoueurHote)){
            connecterEnTantQueJoueurHote(cheminCoupsJoeurHote,cheminCoupsJoeurInvite);
            }else{
            connecterEnTantQueJoueurInvite(cheminCoupsJoeurHote,cheminCoupsJoeurInvite);
            }
        proxyRecevoirCoups.setActionNouvelItem(GCommande.RECEVOIR_COUP_RESEAU);
        proxyEmettreCoups.connecterAuserveur();
        proxyRecevoirCoups.connecterAuserveur();;
    }

    private void connecterEnTantQueJoueurHote(String cheminCoupsJoueurHote, String cheminCoupsJoueurInvite){
        proxyEmettreCoups = new ProxyListe(cheminCoupsJoueurHote);
        proxyRecevoirCoups = new ProxyListe(cheminCoupsJoueurInvite);
    }

    private void connecterEnTantQueJoueurInvite(String cheminCoupsJoueurHote, String cheminCoupsJoueurInvite){
        proxyEmettreCoups = new ProxyListe(cheminCoupsJoueurInvite);
        proxyRecevoirCoups = new ProxyListe(cheminCoupsJoueurHote);
    }
    private String getCheminCoupsJoueurInvite(String idJoueurHote){
        return getCheminPartie(idJoueurHote) + "/" + GConstantes.CLE_COUPS_JOUEUR_INVITE;
    }
    private String getCheminCoupsJoueurHote(String idJoueurHote){
        return getCheminPartie(idJoueurHote) + "/" + GConstantes.CLE_COUPS_JOUEUR_HOTE;
    }
    private String getCheminPartie(String idJoueurHote){
        return MPartieReseau.class.getSimpleName() + "/" + idJoueurHote;
    }

    public void deconnecterDuServeur(){
        proxyEmettreCoups.deconnecterDuServeur();
        proxyRecevoirCoups.deconnecterDuServeur();
    }
    public void transmettreCoup(Integer idColonne){
        proxyEmettreCoups.ajouterValeur(idColonne);
    }

    public void detruireSauvegardeServeur(){


       // Serveur.getInstance().detruireSauvegarde();
    }
}


