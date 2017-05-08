package com.example.android.listviewpersonalizado;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Reporte2 extends AppCompatActivity {

    private TextView reporte;
    private String aux;
    private Resources res;
    private ArrayList<Carro> carros;
    private Spinner comboMar;
    private String[] opc1;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte2);

        reporte = (TextView)findViewById(R.id.txtReporte2);
        comboMar = (Spinner)findViewById(R.id.cmbMarcas);
        res = this.getResources();

        opc1 = this.getResources().getStringArray(R.array.opciones_1);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opc1);
        comboMar.setAdapter(adapter);

    }

    public void reporte2(View v){
        String marca = "";
        int cont = 0;

        carros = Datos.getCarros();
        marca = comboMar.getSelectedItem().toString();

        for (int i = 0; i < carros.size() ; i++) {
            if(carros.get(i).getMarca() == marca) {
                cont = cont + 1;
            }else{
                i++;
            }
        }
        aux = res.getString(R.string.el_no_carros_marca)+" "+marca+" "+res.getString(R.string.es)+" "+cont;
        reporte.setText(aux);
    }
























}
