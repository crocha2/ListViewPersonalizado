package com.example.android.listviewpersonalizado;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;

public class Principal extends AppCompatActivity {

    private ListView ls;
    private Resources res;
    private String[] opc;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        ls = (ListView)findViewById(R.id.lvOpciones);
        res = this.getResources();
        opc = res.getStringArray(R.array.opciones);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, opc);

        ls.setAdapter(adapter);

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        i = new Intent(Principal.this, RegistroCarros.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(Principal.this, ListarCarros.class);
                        startActivity(i);
                        break;
                    case 2:
                        i = new Intent(Principal.this, Reportes.class);
                        startActivity(i);
                }
            }
        });
    }
}