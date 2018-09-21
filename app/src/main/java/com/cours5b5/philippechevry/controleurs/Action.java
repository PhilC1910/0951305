package com.cours5b5.philippechevry.controleurs;

import com.cours5b5.philippechevry.controleurs.interfaces.Fournisseur;
import com.cours5b5.philippechevry.controleurs.interfaces.ListenerFournisseur;

public class Action {
    Fournisseur fournisseur;
    ListenerFournisseur listenerFournisseur;
    Object[] args;

    public void setArguments(Object[] args) {
        this.args = args;
    }

    public void executerDesQuePossible(){

        ControleurAction controleurAction = new ControleurAction();
            
    }

    public Action cloner(){
        Action actionNew = new Action();
        if(actionNew.args != null){
            actionNew.args = this.args;
        } else{
            actionNew.args =   this.args.clone();
        }


        return actionNew ;
    }
}
