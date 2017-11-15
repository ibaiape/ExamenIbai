package com.example.dm2.examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class Ejercicio2 extends AppCompatActivity {
    int posicion;
    final String[] datosSpinner = new String[] {"", "Bizkaia", "Araba", "Gipuzkoa", "Nafarroa", "Lapurdi", "Behe-Nafarroa", "Zuberoa"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);
        setTitle("LOCALIDADES CON ENCANTO");

        Spinner cmbOpciones2 =(Spinner) findViewById(R.id.spinnerProvincias);
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, datosSpinner);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbOpciones2.setAdapter(adaptador);


        cmbOpciones2.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener(){
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        posicion = i;
                        ((RadioGroup)findViewById(R.id.radGroup2)).clearCheck();
                        if(datosSpinner[i].equals("Bizkaia") || datosSpinner[i].equals("Gipuzkoa"))
                            findViewById(R.id.layUbicacion).setVisibility(View.VISIBLE);
                        else
                            findViewById(R.id.layUbicacion).setVisibility(View.INVISIBLE);
                        if(datosSpinner[i].length()>0)
                            findViewById(R.id.btnVisualizar).setVisibility(View.VISIBLE);
                        else
                            findViewById(R.id.btnVisualizar).setVisibility(View.INVISIBLE);
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                }
        );

    }

    public void volver(View v){
        finish();
    }

    public void mostrarLista(View v){
        Intent lista = new Intent(Ejercicio2.this, ListadoLocalidades.class);
        lista.putExtra("provincia", datosSpinner[posicion]);
        if(((RadioGroup)findViewById(R.id.radGroup2)).getCheckedRadioButtonId()!=-1)
            lista.putExtra("ubicacion", ((RadioButton)findViewById(((RadioGroup)findViewById(R.id.radGroup2)).getCheckedRadioButtonId())).getText());
        else
            lista.putExtra("ubicacion", "");
        startActivity(lista);
    }

}
