package com.example.trabajoweno;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Pantalla_Bajas extends AppCompatActivity {

    MediaPlayer mMediaPlayer;
    long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_bajas);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);

        mMediaPlayer = MediaPlayer.create(Pantalla_Bajas.this, R.raw.altas);


        /* se espera a la pulsacion del boton 2 para reproducir el audio*/

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.button2) {
                    mMediaPlayer.start();
                    startTime = System.currentTimeMillis(); /*esta variable sirve para medir el tiempo posteriormente*/
                }
            }
        });


        /* se espera a la pulsacion del boton 3 para parar el audio y mostrar el resultado a través de la función displaySeconds*/

        button3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (v.getId() == R.id.button3) {
                    mMediaPlayer.stop();
                    displaySeconds();
                }
            }
        });
    }

    public void displaySeconds () {

        long timeElapsed = System.currentTimeMillis() - startTime; /* tiempo que has tardado en escuchar el sonido*/

        /* según el tiempo que se tarde en escuchar salta una alerta u otra */
        if (timeElapsed < 5580) {
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