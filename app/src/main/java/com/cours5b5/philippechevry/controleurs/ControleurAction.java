package com.cours5b5.philippechevry.controleurs;

import com.cours5b5.philippechevry.controleurs.interfaces.Fournisseur;
import com.cours5b5.philippechevry.global.GCommande;

import java.util.List;
import java.util.Map;

public class ControleurAction {
    private static Map<GCommande, Action> Actions;
    private static List<Action>fileAttenteExecution;
    static {

    }
    public static Action demanderAction(GCommande commande){

        return null;
    }

    public static Action fournirAction(Fournisseur fournisseur, GCommande commande, ListenerFournisseur listenerFournisseur){

        return null;
    }
     static boolean siActionExecutable(Action action){

         return false;
     }
     private static synchronized void executerMaintenant(Action action){

     }

    private static void enregistrerFournisseur(Fournisseur fournisseur, GCommande commande, ListenerFournisseur listenerFournisseur){


    }

    private static void ajouterActionEnFileDAttente(Action action){


    }




}
