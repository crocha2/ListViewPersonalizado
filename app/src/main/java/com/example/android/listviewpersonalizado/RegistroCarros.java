package com.example.android.listviewpersonalizado;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class RegistroCarros extends AppCompatActivity {

    private EditText cajaPlaca;
    private EditText cajaPrecio;
    private Intent i;
    private Spinner comboMarca;
    private Spinner comboModelo;
    private Spinner comboColor;
    private ArrayAdapter<String> adapter;
    private String[] opc1;
    private String[] opc2;
    private String[] opc3;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_carros);

        cajaPlaca = (EditText)findViewById(R.id.txtPlaca);
        cajaPrecio = (EditText)findViewById(R.id.txtPrecio);

        comboMarca = (Spinner)findViewById(R.id.cmbMarca);
        comboModelo = (Spinner)findViewById(R.id.cmbModelo);
        comboColor = (Spinner)findViewById(R.id.cmbColor);

        opc1 = this.getResources().getStringArray(R.array.opciones_1);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opc1);
        comboMarca.setAdapter(adapter);

        opc2 = this.getResources().getStringArray(R.array.opciones_2);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opc2);
        comboModelo.setAdapter(adapter);

        opc3 = this.getResources().getStringArray(R.array.opciones_3);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opc3);
        comboColor.setAdapter(adapter);

    }

    public void registrarCarro(View v){
        String foto;

        String aux="", placa, marca, modelo, color;
        double precio;

        if (validar()) {

            placa = cajaPlaca.getText().toString().trim();
            precio = Double.parseDouble(cajaPrecio.getText().toString().trim());
            marca = comboMarca.getSelectedItem().toString();
            modelo = comboModelo.getSelectedItem().toString();
            color = comboColor.getSelectedItem().toString();

            foto = String.valueOf(fotoAleatoria());
            Carro c = new Carro(foto, placa, marca, modelo, color, precio);
            c.guardar();

            //new AlertDialog.Builder(this).setMessage(res.getString(R.string.mensaje_1)).show();

            limpiar();
        }
    }

    public boolean validar(){
        if(cajaPlaca.getText().toString().isEmpty()){
            cajaPlaca.setError(getResources().getString(R.string.error_1));
            return false;
        }
        if(cajaPlaca.getText().toString().isEmpty()){
            cajaPrecio.setError(getResources().getString(R.string.error_2));
            return false;
        }
        return  true;
    }

    public void borrar(View v){
        limpiar();
    }

    public void limpiar(){
        cajaPlaca.setText("");
        cajaPrecio.setText("");
        comboMarca.setSelection(0);
        comboModelo.setSelection(0);
        comboColor.setSelection(0);
        cajaPlaca.requestFocus();
    }

    public int fotoAleatoria(){
        int  fotos[]={R.drawable.imag_1, R.drawable.imag_2, R.drawable.imag_3, R.drawable.imag_4};
        int numero = (int) (Math.random() *3);
        return fotos[numero];
    }

}
