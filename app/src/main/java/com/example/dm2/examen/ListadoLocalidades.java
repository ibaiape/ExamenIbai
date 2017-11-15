package com.example.dm2.examen;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListadoLocalidades extends AppCompatActivity {

    ArrayList<Localidad> arrayListLocalidades = new ArrayList<Localidad>();
    Localidad localidad;

    String provincia;
    String ubicacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_localidades);

        TextView txtProvincia = (TextView)findViewById(R.id.lblProvincia);
        txtProvincia.setText("-- "+getIntent().getExtras().getString("provincia")+" --");
        provincia = getIntent().getExtras().getString("provincia");
        ubicacion = getIntent().getExtras().getString("ubicacion");
        if(ubicacion.length()==0)
            ubicacion = "Interior";

        if(provincia.equals("Bizkaia") && ubicacion.equals("Interior")){
            localidad = new Localidad("Orduña", "Bizkaia", "Interior", ContextCompat.getDrawable(this, R.drawable.orduna),"http://www.urduna.com/");
            arrayListLocalidades.add(localidad);
        }

        if(provincia.equals("Bizkaia") && ubicacion.equals("Costa")) {
            localidad = new Localidad("Ondarroa", "Bizkaia", "Costa", ContextCompat.getDrawable(this, R.drawable.ondarroa), "http://www.ondarroa.eu/");
            arrayListLocalidades.add(localidad);
        }
        if(provincia.equals("Bizkaia") && ubicacion.equals("Interior")) {
            localidad = new Localidad("Areatza", "Bizkaia", "Interior", ContextCompat.getDrawable(this, R.drawable.areatza), "http://www.areatza.net/");
            arrayListLocalidades.add(localidad);
        }

        if(provincia.equals("Bizkaia") && ubicacion.equals("Interior")) {
            localidad = new Localidad("Gernika", "Bizkaia", "Interior", ContextCompat.getDrawable(this, R.drawable.gernika), "http://www.gernika-lumo.net/");
            arrayListLocalidades.add(localidad);
        }

        if(provincia.equals("Bizkaia") && ubicacion.equals("Costa")){
            localidad = new Localidad("Bermeo", "Bizkaia", "Costa", ContextCompat.getDrawable(this, R.drawable.bermeo),"http://www.bermeo.eus/");
            arrayListLocalidades.add(localidad);
        }

        if(provincia.equals("Gipuzkoa") && ubicacion.equals("Interior")) {
            localidad = new Localidad("Astigarraga", "Gipuzkoa", "Interior", ContextCompat.getDrawable(this, R.drawable.astigarraga), "http://astigarraga.eus");
            arrayListLocalidades.add(localidad);
        }

        if(provincia.equals("Gipuzkoa") && ubicacion.equals("Costa")) {
            localidad = new Localidad("Donostia", "Gipuzkoa", "Costa", ContextCompat.getDrawable(this, R.drawable.donostia), "http://www.donostia.eus");
            arrayListLocalidades.add(localidad);
        }

        if(provincia.equals("Araba") && ubicacion.equals("Interior")) {
            localidad = new Localidad("Vitoria-Gasteiz", "Araba", "Interior", ContextCompat.getDrawable(this, R.drawable.vitoria_gasteiz), "http://www.vitoria-gasteiz.org/");
            arrayListLocalidades.add(localidad);
        }

        if(provincia.equals("Araba") && ubicacion.equals("Interior")) {
            localidad = new Localidad("Añana", "Araba", "Interior", ContextCompat.getDrawable(this, R.drawable.anana), "http://www.cuadrilladeanana.es/anana/");
            arrayListLocalidades.add(localidad);
        }

        AdaptadorLocalidades adaptadorLista = new AdaptadorLocalidades(this, arrayListLocalidades);
        ListView lstOpciones = (ListView)findViewById(R.id.listaLocalidades);
        lstOpciones.setAdapter(adaptadorLista);
        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id){
                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse(arrayListLocalidades.get(position).getUrl()));
                startActivity(viewIntent);
            }
        });

    }



    class AdaptadorLocalidades extends ArrayAdapter<Localidad> {
        public AdaptadorLocalidades(Context context, ArrayList<Localidad> datos) {
            super(context, R.layout.listitem_localidad, datos);
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_localidad, null);

            TextView lblNombre = (TextView)item.findViewById(R.id.lblnombre);
            lblNombre.setText(arrayListLocalidades.get(position).getNombre());

            ImageView imgPag = (ImageView)item.findViewById(R.id.imgpag);
            imgPag.setImageDrawable(arrayListLocalidades.get(position).getImagen());

            return(item);
        }
    }

    public void volver(View v){
        finish();
    }
}
