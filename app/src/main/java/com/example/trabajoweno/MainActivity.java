package com.example.trabajoweno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        // AGREGAR ANIMACIONES
        Animation animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        Animation animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);
        TextView deTextView = findViewById(R.id.text1);
        TextView sorderaTextView = findViewById(R.id.SORDERA_IMAGE);
        ImageView logoImageView = findViewById(R.id.LOGO_IMAGE);


        /* se realizan las animaciones de texto e imagen */
        deTextView.setAnimation(animacion2);
        sorderaTextView.setAnimation(animacion2);
        logoImageView.setAnimation(animacion1);


        /* tras un delay de 4 segundos, se cambia de pantalla mediante una transición*/

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, prueba2.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                finish();
            }

        }, 4000);

    }
}