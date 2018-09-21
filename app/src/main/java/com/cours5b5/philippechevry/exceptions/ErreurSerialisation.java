package com.cours5b5.philippechevry.exceptions;

import android.util.Log;

public class ErreurSerialisation extends RuntimeException {
    public ErreurSerialisation(Exception e){

        Log.d("erreur",e.getMessage());

    }
}
