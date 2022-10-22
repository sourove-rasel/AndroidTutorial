package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private TextView txtView;
    private Button clickButton;
    private ProgressBar pbar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         txtView = findViewById(R.id.textView);
         clickButton = findViewById(R.id.button);
         pbar = findViewById(R.id.progressBar);
         //pbar.setVisibility(View.GONE);

         clickButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 pbar.setVisibility(View.VISIBLE);
                 String txt = txtView.getText().toString();

                 if(!txt.isEmpty()){
                     new Thread(new Runnable() {
                         @Override
                         public void run() {
                             try {
                                 Thread.sleep(500);
                             } catch (InterruptedException e) {
                                 e.printStackTrace();
                             }
                             //clickButton.dismiss();
                         }
                     }).start();

                     final Handler handler = new Handler();
                     handler.postDelayed(new Runnable() {
                         @Override
                         public void run() {
                             Intent intent = new Intent(getApplicationContext(),ButtonClickActivity.class);

                             intent.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK);

                             startActivity(intent);
                             finish();
                             pbar.setVisibility(View.GONE);
                         }
                     },1000);



                 }



             }

         });



    }
}