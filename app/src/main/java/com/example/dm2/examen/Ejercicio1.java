package com.example.dm2.examen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Ejercicio1 extends AppCompatActivity {
    int num1;
    int num2;
    int operaciones = 10;
    int aciertos = 0;
    int resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);
        setTitle("CALCULO MATEMATICO");
    }

    public void empezar(View v){
        RadioGroup rad = (RadioGroup) findViewById(R.id.radGroup);
        int sel = rad.getCheckedRadioButtonId();

        if(sel == -1)
            Toast.makeText(getApplication().getBaseContext(), "Debes seleccionar una opcion, para empezar con los calculos",
                    Toast.LENGTH_LONG).show();
        else{
            rad.setEnabled(false);
            (findViewById(R.id.btnEmpezar)).setVisibility(View.INVISIBLE);
            nuevaOperacion();
            (findViewById(R.id.btnEvaluar)).setVisibility(View.VISIBLE);
            (findViewById(R.id.lblOperacion)).setVisibility(View.VISIBLE);
            (findViewById(R.id.txtResultado)).setVisibility(View.VISIBLE);
        }
    }

    public void nuevaOperacion(){
        RadioGroup rad = (RadioGroup) findViewById(R.id.radGroup);
        int sel = rad.getCheckedRadioButtonId();
        num1 = (int)(Math.random()*100);
        num2 = (int)(Math.random()*100);
        String operacion = "";
        switch(sel){
            case R.id.rad_suma:
                resultado = num1+num2;
                operacion = num1+" + "+num2+" = ";
                break;
            case R.id.rad_resta:
                resultado = num1-num2;
                operacion = num1+" - "+num2+" = ";
                break;
            case R.id.rad_multi:
                resultado = num1*num2;
                operacion = num1+" * "+num2+" = ";
                break;
        }
        ((TextView)findViewById(R.id.lblOperacion)).setText(operacion);
        ((EditText)findViewById(R.id.txtResultado)).setText("");
    }

    public void evaluar(View v){
        int respuesta = Integer.parseInt(((EditText)findViewById(R.id.txtResultado)).getText().toString());
        if(respuesta == resultado)
            aciertos++;
        if(operaciones>1){
            operaciones--;
            nuevaOperacion();
        }else{
            String num = "";
            if(aciertos>0)
                num = aciertos+"";
            Toast.makeText(getApplication().getBaseContext(), "Has tenido un "+num+"0% de aciertos",
                    Toast.LENGTH_LONG).show();
            ((TextView)findViewById(R.id.lblOperacion)).setText("");
            ((EditText)findViewById(R.id.txtResultado)).setText("");
            (findViewById(R.id.btnEmpezar)).setVisibility(View.VISIBLE);
            (findViewById(R.id.btnEvaluar)).setVisibility(View.INVISIBLE);
            (findViewById(R.id.lblOperacion)).setVisibility(View.INVISIBLE);
            (findViewById(R.id.txtResultado)).setVisibility(View.INVISIBLE);
            ((RadioGroup)findViewById(R.id.radGroup)).clearCheck();
            operaciones = 10;
            aciertos = 0;
        }
    }

    public void volver(View v){
        finish();
    }

}
