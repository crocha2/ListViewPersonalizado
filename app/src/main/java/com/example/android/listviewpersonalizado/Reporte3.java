package com.example.android.listviewpersonalizado;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Reporte3 extends AppCompatActivity {

    private TextView reporte;
    private String aux;
    private Resources res;
    private ArrayList<Carro> carros;
    private Spinner comboCol;
    private String[] opc3;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte3);

        reporte = (TextView)findViewById(R.id.txtReporte3);
        comboCol = (Spinner)findViewById(R.id.cmbCol);
        res = this.getResources();

        opc3 = this.getResources().getStringArray(R.array.opciones_3);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opc3);
        comboCol.setAdapter(adapter);
    }

    public void reporte2(View v){
        String color = "";
        int cont = 0;

        carros = Datos.getCarros();
        color = comboCol.getSelectedItem().toString();

        for (int i = 0; i < carros.size() ; i++) {
            if(color == carros.get(i).getColor()) {
                cont = cont + 1;
            }else{
                i++;
            }
        }
        aux = res.getString(R.string.el_no_carros_marca)+" "+color+" "+res.getString(R.string.es)+" "+cont;
        reporte.setText(aux);
    }
}
