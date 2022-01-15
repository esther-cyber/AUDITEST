package com.example.trabajoweno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class pantallaFrecuencias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pantalla_frecuencias);
        Button altas = (Button) findViewById(R.id.boton2);

        altas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent altas = new Intent(pantallaFrecuencias.this, Pantalla_Altas.class);
                startActivity(altas);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out); /* se aplican transiciones de pantalla */

            }
        });

        Button bajas = (Button) findViewById(R.id.boton3);

        /* se espera a la pulsación del boton bajas para cambiar de pantalla mediante un intent*/



        bajas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent bajas = new Intent(pantallaFrecuencias.this, Pantalla_Bajas.class);
                startActivity(bajas);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

            }
        });
    }
}