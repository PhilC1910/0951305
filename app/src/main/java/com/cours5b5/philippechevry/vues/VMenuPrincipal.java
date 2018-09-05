package com.cours5b5.philippechevry.vues;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cours5b5.philippechevry.R;
import com.cours5b5.philippechevry.activites.AActivity;
import com.cours5b5.philippechevry.activites.AMenuPrincipal;

public class VMenuPrincipal extends  Vue {

    static {

        Log.d("atelier4",AMenuPrincipal.class.getSimpleName()+":: onFinishInflate");

    }
    public VMenuPrincipal(Context context) {
        super(context);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();



    }
}
