package com.jpg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class RegistroActivity extends AppCompatActivity {
    universal universal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        universal = new universal();
        FragmentTransaction ft =  getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragments,universal);
        ft.commit();
    }
}
