package com.example.trabajoweno;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Pantalla_Altas extends AppCompatActivity {
    MediaPlayer mMediaPlayer;
    long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_altas);
        Button buttonstart = (Button) findViewById(R.id.buttonstart);
        Button buttonstop = (Button) findViewById(R.id.buttonstop);

        mMediaPlayer = MediaPlayer.create(Pantalla_Altas.this, R.raw.bajas);

        buttonstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.buttonstart) {
                    mMediaPlayer.start();
                    startTime = System.currentTimeMillis();
                }
            }
        });

        buttonstop.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (v.getId() == R.id.buttonstop) {
                    mMediaPlayer.stop();
                    displaySeconds();
                }
            }
        });
    }

    public void displaySeconds () {
        /*long startTime = System.currentTimeMillis();*/
        long timeElapsed = System.currentTimeMillis() - startTime;

        /*secondsText.setText(String.valueOf(Seconds));*/
        if (timeElapsed > 13000) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Resultado");
                builder.setMessage("Apto");
                builder.setPositiveButton("Aceptar", null);
                builder.create();
                builder.show();
        }

        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Resultado");
            builder.setMessage("No apto");
            builder.setPositiveButton("Aceptar", null);
            builder.create();
            builder.show();
        }
    }
}