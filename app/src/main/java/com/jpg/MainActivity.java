package com.jpg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login2);

        mHandler.postDelayed(openNew, 1500);

    }
    private Runnable openNew = new Runnable() {
        @Override
        public void run() {

        }CAAALL MEEEEEEE
    }

}
