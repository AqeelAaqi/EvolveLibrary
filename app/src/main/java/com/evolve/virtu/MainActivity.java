package com.evolve.virtu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.evolve.evolvear.Facebook;
import com.evolve.evolvear.Google;
import com.evolve.evolvear.SocialLoginConstant;
import com.evolve.evolvear.Tester;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity  implements Facebook.FacebookResponseListener, View.OnClickListener,
        Google.GoogleResponseListener{

    private Facebook facebook;
    private Google google;
    private Button fbLoginButton, googleLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tester.ShowToast(this,"Wow We did it");

        initView();
        facebook = new Facebook(this);
        google = new Google(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_fb:
                facebook.login();
                break;
//            case R.id.linkedInLoginButton:
//                try {
//                    linkedIn.login();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                break;
            case R.id.btn_google:
                google.login();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == SocialLoginConstant.GOOGLE_REQUEST_CODE) {
            google.activityResult(requestCode, resultCode, data);
        } else {
            facebook.activityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onFacebookResponseListener(JSONObject response, boolean error) {
        Log.d("Response", String.valueOf(response));
    }

    private void initView() {
        fbLoginButton = findViewById(R.id.btn_fb);
        fbLoginButton.setOnClickListener(this);

        googleLoginButton = findViewById(R.id.btn_google);
        googleLoginButton.setOnClickListener(this);
    }

    @Override
    public void onGoogleResponseListener(JSONObject response, boolean error) {
        Log.d("Response", String.valueOf(response));
    }
}