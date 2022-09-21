package com.evolvear.evolve;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class Tester {

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;


    public static void ShowToast(Context context, String msg)
    {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public void onActivityResult(int requestCode, int responseCode, Intent intent){
//        if (requestCode == RC_SIGN_IN) {
//            if (responseCode != ((Activity)ctx).RESULT_OK) {
//                setSignInClicked(false);
//            }
//            setIntentInProgress(false);
//            reconnect();
//        }
    }

}
