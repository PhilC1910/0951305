package ca.cours5b5.philippechevry.exceptions;


public class ErreurModele extends RuntimeException {

    public ErreurModele(Exception e) {super(e);}

    public ErreurModele(String message){
        super(message);
    }


}
