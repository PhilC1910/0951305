package ca.cours5b5.philippechevry.exceptions;


public class ErreurAction extends RuntimeException {

    public ErreurAction(String message){
        super(message);
    }

    public ErreurAction(Exception e){
        super(e);
    }

}