package com.jpg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {
    fragment_universal fragment_universal;
    fragment_client fragment_client;
    fragment_commerce fragment_commerce;
    fragment_deliver fragment_deliver;
    animationBWATB animation;
    TextView btnNext;
    String type;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        btnNext = findViewById(R.id.next);

        fragment_universal = new fragment_universal();
        FragmentTransaction ft =  getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragments, fragment_universal);
        ft.commit();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String prueba = getVariable();
                animation = new animationBWATB();
                final FragmentTransaction ft =  getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragments, animation);
                ft.commit();
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        change(prueba);
                    }
                },1500);
            }
        });
    }
    public void setVariable(String valor){
        type = valor;
    }
    public String getVariable(){
        return type;
    }
    public void change(String prueba){
        FragmentTransaction ft =  getSupportFragmentManager().beginTransaction();

        switch (prueba){
            case "commerce":
                fragment_commerce = new fragment_commerce();
                ft =  getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragments, fragment_commerce);
                ft.addToBackStack(null);
                ft.commit();
                break;
            case "client":
                Intent intent = new Intent(RegistroActivity.this,userMenu.class);
                startActivityForResult(intent, 0);
                break;
            case "deliver":
                fragment_deliver = new fragment_deliver();
                ft =  getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragments, fragment_deliver);
                ft.addToBackStack(null);
                ft.commit();
                break;
        }
    }
}
