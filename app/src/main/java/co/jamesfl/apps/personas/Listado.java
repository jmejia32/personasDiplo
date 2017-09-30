package co.jamesfl.apps.personas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.LinkedList;

public class Listado extends AppCompatActivity {
    private TableLayout tblListado;
    private LinkedList<Persona> personas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        tblListado = (TableLayout) findViewById(R.id.tblListado);
        personas = Datos.getPersonas();

        for (int i = 0; i < personas.size(); i++) {
            Persona p = personas.get(i);
            TableRow fila = new TableRow(this);
            TextView tvNum = new TextView(this);
            TextView tvCed = new TextView(this);
            TextView tvNomb = new TextView(this);
            TextView tvApe = new TextView(this);

            tvNum.setGravity(Gravity.CENTER);
            tvCed.setGravity(Gravity.CENTER);
            tvNomb.setGravity(Gravity.CENTER);
            tvApe.setGravity(Gravity.CENTER);

            tvNum.setText((i+1)+"");
            tvCed.setText(p.getCedula());
            tvNomb.setText(p.getNombre());
            tvApe.setText(p.getApellido());
            fila.addView(tvNum);
            fila.addView(tvCed);
            fila.addView(tvNomb);
            fila.addView(tvApe);
            tblListado.addView(fila);
        }
    }
}
