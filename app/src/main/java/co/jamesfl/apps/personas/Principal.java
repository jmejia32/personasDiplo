package co.jamesfl.apps.personas;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Principal extends AppCompatActivity {
    private ListView listOpciones;
    private Intent i;
    private Resources res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        listOpciones = (ListView) findViewById(R.id.lstOpciones);
        res = getResources();

        ArrayAdapter<String> adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, res.getStringArray(R.array.opciones));
        listOpciones.setAdapter(adp);

        listOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                switch (pos) {
                    case 0:
                        i = new Intent(Principal.this, CrearPersona.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(Principal.this, Listado.class);
                        startActivity(i);
                        break;
                }
            }
        });
    }
}
