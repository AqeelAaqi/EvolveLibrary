package com.evolvear.evolve;

import android.content.Context;
import android.widget.Toast;

public class Tester {

    public static void ShowToast(Context context, String msg)
    {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

}
