package co.jamesfl.apps.personas;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CrearPersona extends AppCompatActivity {
    private EditText etCedula, etNombre, etApellido;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_persona);

        etCedula = (EditText) findViewById(R.id.etCedula);
        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellido = (EditText) findViewById(R.id.etApellido);
        res = getResources();
    }

    public boolean valido() {
        if (etCedula.getText().toString().isEmpty()) {
            etCedula.setError(res.getString(R.string.errCedula));
            etCedula.requestFocus();
            return false;
        }
        if (etNombre.getText().toString().isEmpty()) {
            etNombre.setError(res.getString(R.string.errNombre));
            etNombre.requestFocus();
            return false;
        }
        if (etApellido.getText().toString().isEmpty()) {
            etApellido.setError(res.getString(R.string.errApellido));
            etApellido.requestFocus();
            return false;
        }
        return true;
    }

    public void crear(View v) {
        if (valido()) {
            String ced, nomb, ape;
            ced = etCedula.getText().toString();
            nomb = etNombre.getText().toString();
            ape = etApellido.getText().toString();

            Persona p = new Persona(ced, nomb, ape);
            p.guardar();

            Toast.makeText(this, res.getString(R.string.msjCrear), Toast.LENGTH_SHORT).show();
            limpiar(v);
        }
    }

    public void limpiar(View v) {
        etCedula.setText("");
        etNombre.setText("");
        etApellido.setText("");
        etCedula.requestFocus();
    }
}
