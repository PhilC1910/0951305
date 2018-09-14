package com.cours5b5.philippechevry.exceptions;

import android.util.Log;

public class ErreurDeSerialisation extends RuntimeException {
    public ErreurDeSerialisation(Exception e){

        Log.d("erreur",e.getMessage());

    }
}
