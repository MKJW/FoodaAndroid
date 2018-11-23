package com.mksoft.fooda2;

import android.os.Bundle;

import com.mksoft.fooda2.userPackage.UserProfileFragment;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    UserProfileFragment userProfileFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userProfileFragment = new UserProfileFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, userProfileFragment).commit();
    }
}
