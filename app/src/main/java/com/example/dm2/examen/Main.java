package com.example.dm2.examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.app_name);
    }

    public void actividad1(View v){
        Intent Ejer1 = new Intent(Main.this, Ejercicio1.class);
        startActivity(Ejer1);
    }

    public void actividad2(View v){
        Intent Ejer2 = new Intent(Main.this, Ejercicio2.class);
        startActivity(Ejer2);
    }

    public void actividad3(View v){
        Toast.makeText(getApplication().getBaseContext(), R.string.noImplementado,
                Toast.LENGTH_LONG).show();
    }

    public void actividad4(View v){
        Toast.makeText(getApplication().getBaseContext(), R.string.noImplementado,
                Toast.LENGTH_LONG).show();
    }

    public void salir(View v){
        finish();
    }
}
