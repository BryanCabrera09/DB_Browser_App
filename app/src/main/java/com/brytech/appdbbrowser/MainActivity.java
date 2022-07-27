package com.brytech.appdbbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.brytech.appdbbrowser.Modelo.Persona;

public class MainActivity extends AppCompatActivity {

    Button btn_guardar, btn_listar, btn_actualizar, btn_eliminar;
    String id = "", nombre = "", apellido = "", correo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_guardar = findViewById(R.id.Btn_Guardar);
        btn_guardar.setOnClickListener(Guardar);

        btn_listar = findViewById(R.id.Btn_Listar);
        btn_listar.setOnClickListener(Listar);

        btn_actualizar = findViewById(R.id.Btn_Actualizar);
        btn_actualizar.setOnClickListener(Actualizar);

        btn_eliminar = findViewById(R.id.Btn_Eliminar);
        btn_eliminar.setOnClickListener(Eliminar);
    }

    public void Listar_Datos() {

        ListView listView = (ListView) findViewById(R.id.listPersonas);
        Cursor cursor = Persona.listaPersonas(getApplicationContext());
        String[] desde = new String[]{"id", "nombre", "apellido", "correo"};
        int[] hasta = new int[]{R.id.txtID, R.id.txtNombre, R.id.txtApellido, R.id.txtCorreo};

        CursorAdapter cursorAdapter = new SimpleCursorAdapter(
                getApplicationContext(),
                R.layout.activity_detalle_persona,
                cursor,
                desde,
                hasta, 0
        );
        listView.setAdapter(cursorAdapter);
    }

    public void Limpiar_Campos() {

        EditText txtID = (EditText) findViewById(R.id.Txt_Identificacion);
        txtID.setText("");
        EditText txtNombre = (EditText) findViewById(R.id.Txt_Nombre);
        txtNombre.setText("");
        EditText txtApellido = (EditText) findViewById(R.id.Txt_Apellido);
        txtApellido.setText("");
        EditText txtCorreo = (EditText) findViewById(R.id.Txt_Correo);
        txtCorreo.setText("");
    }

    View.OnClickListener Listar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Listar_Datos();
        }
    };

    View.OnClickListener Guardar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText txtID = (EditText) findViewById(R.id.Txt_Identificacion);
            id = txtID.getText().toString();

            EditText txtNombre = (EditText) findViewById(R.id.Txt_Nombre);
            nombre = txtNombre.getText().toString();

            EditText txtApellido = (EditText) findViewById(R.id.Txt_Apellido);
            apellido = txtApellido.getText().toString();

            EditText txtCorreo = (EditText) findViewById(R.id.Txt_Correo);
            correo = txtCorreo.getText().toString();

            Persona persona = new Persona();
            persona.setId(txtID.getText().toString());
            persona.setNombre(txtNombre.getText().toString());
            persona.setApellido(txtApellido.getText().toString());
            persona.setCorreo(txtCorreo.getText().toString());

            if (!id.isEmpty() && !nombre.isEmpty() && !apellido.isEmpty() && !correo.isEmpty()) {

                persona.guardarPersona(getApplicationContext());
                Toast.makeText(getApplicationContext(), "Persona Creada", Toast.LENGTH_LONG).show();
                Limpiar_Campos();
                Listar_Datos();
            } else {
                Toast.makeText(getApplicationContext(), "Los Campos deben estar llenos", Toast.LENGTH_LONG).show();
            }
        }
    };

    View.OnClickListener Actualizar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText txtID = (EditText) findViewById(R.id.Txt_Identificacion);
            id = txtID.getText().toString();

            EditText txtNombre = (EditText) findViewById(R.id.Txt_Nombre);
            nombre = txtNombre.getText().toString();

            EditText txtApellido = (EditText) findViewById(R.id.Txt_Apellido);
            apellido = txtApellido.getText().toString();

            EditText txtCorreo = (EditText) findViewById(R.id.Txt_Correo);
            correo = txtCorreo.getText().toString();

            Persona persona = new Persona();
            persona.setId(txtID.getText().toString());
            persona.setNombre(txtNombre.getText().toString());
            persona.setApellido(txtApellido.getText().toString());
            persona.setCorreo(txtCorreo.getText().toString());

            if (!id.isEmpty() && !nombre.isEmpty() && !apellido.isEmpty() && !correo.isEmpty()) {
                persona.actualizarPersona(getApplicationContext());

                Toast.makeText(getApplicationContext(), "Persona Actualizada", Toast.LENGTH_LONG).show();
                Limpiar_Campos();
                Listar_Datos();
            } else {
                Toast.makeText(getApplicationContext(), "Los Campos deben estar llenos", Toast.LENGTH_LONG).show();
            }
        }
    };

    View.OnClickListener Eliminar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText txtID = (EditText) findViewById(R.id.Txt_Identificacion);

            Persona persona = new Persona();
            persona.setId(txtID.getText().toString());

            if (!id.isEmpty()) {
                persona.eliminarPersona(getApplicationContext());

                Toast.makeText(getApplicationContext(), "Persona Eliminada", Toast.LENGTH_LONG).show();
                Limpiar_Campos();
                Listar_Datos();
            } else {
                Toast.makeText(getApplicationContext(), "Especifique la Persona a Elminar", Toast.LENGTH_LONG).show();
            }
        }
    };
}