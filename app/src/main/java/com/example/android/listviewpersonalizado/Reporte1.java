package com.example.android.listviewpersonalizado;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Reporte1 extends AppCompatActivity {

    private TextView reporte;
    private String aux;
    private Resources res;
    private ArrayList<Carro> carros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte1);

        reporte = (TextView)findViewById(R.id.txtReporte1);
        res = this.getResources();

    }

    public void reporte1(View v){
        //String aux2="";
        int cont = 0;

        carros = Datos.getCarros();
        for (int i = 0; i < carros.size() ; i++) {
            cont = cont + 1;
            //aux2 = ""+cont;
        }
        aux = res.getString(R.string.el_no_carros_es)+" "+cont;
        reporte.setText(aux);
    }

}
