package com.example.videoplayer.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.videoplayer.R;
import com.example.videoplayer.view.ContentList;

public class MainActivity extends AppCompatActivity {

    private Intent SplashIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetStart();
    }

    private void GetStart() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    Thread.sleep(3000);

                   SplashIntent = new Intent(MainActivity.this, ContentList.class);
                    startActivity(SplashIntent);
                    finish();

                }
                catch (Exception e) {

                    Toast.makeText(getApplicationContext(), "The Exception" + e, Toast.LENGTH_LONG).show();
                }
            }
        });

        thread.start();

    }
}
