package com.cours5b5.philippechevry.vues;

import android.content.Context;

import android.util.AttributeSet;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.cours5b5.philippechevry.R;
import com.cours5b5.philippechevry.activites.AActivity;
import com.cours5b5.philippechevry.activites.AMenuPrincipal;
import com.cours5b5.philippechevry.global.gConstantes;
import com.cours5b5.philippechevry.modeles.MParametres;

public class VParametres extends Vue {

    static {

        Log.d("atelier4",AActivity.class.getSimpleName()+":: onFinishInflate");

    }
    public VParametres(Context context) {
        super(context);
    }

    public VParametres(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VParametres(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        try {
            MParametres.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        

    }




}
