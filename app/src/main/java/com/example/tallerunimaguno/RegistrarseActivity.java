package com.example.tallerunimaguno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class RegistrarseActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    EditText nombre, apellido, correo, contraseña;
    Spinner sexo;
    Button guardar, volver;
    int spinpos;
    LinearLayout contenedor;
    TextView regExito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        nombre = findViewById(R.id.edtnombre);
        apellido = findViewById(R.id.edtapellido);
        correo = findViewById(R.id.edtcorreo);
        contraseña = findViewById(R.id.edtnewpassReg);
        sexo = findViewById(R.id.spinsexo);
        guardar = findViewById(R.id.btnguardarReg);
        volver = findViewById(R.id.btnvolver);
        contenedor = findViewById(R.id.contenedorform);
        regExito = findViewById(R.id.textvRegExi);
        guardar.setOnClickListener(this);
        volver.setOnClickListener(this);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
                R.array.sexo, android.R.layout.simple_spinner_dropdown_item);
        sexo.setAdapter(adapter);
        sexo.setOnItemSelectedListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnguardarReg:
                if (validar()){

                    if (spinpos!=0){

                        if (contraseña.getText().toString().trim().length()>=6 ){
                            Toast.makeText(getApplicationContext(),"¡ Usuario Registrado Con Exito !", Toast.LENGTH_LONG).show();

                            contenedor.setVisibility(View.GONE);
                            volver.setVisibility(View.VISIBLE);
                            regExito.setVisibility(View.VISIBLE);


                        }else{
                            Toast.makeText(getApplicationContext(),"La Contraseña Debe Tener Minimo 6 Caracteres ", Toast.LENGTH_LONG).show();

                        }

                    }else
                        Toast.makeText(getApplicationContext(),"Debe Seleccionar Sexo", Toast.LENGTH_LONG).show();







                }else{

                    Toast.makeText(getApplicationContext(),"Faltan Campos Por Rellenar", Toast.LENGTH_LONG).show();
                }






                break;
            case R.id.btnvolver:
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();

                break;


        }




    }
    public boolean validar(){
        if (TextUtils.isEmpty(nombre.getText().toString()) ){
            return false;
        }
        else {
            if (TextUtils.isEmpty(apellido.getText().toString()) ){
                return false;
            }
            else{
                if (TextUtils.isEmpty(correo.getText().toString()) ){
                    return false;
                }else{
                    if (TextUtils.isEmpty(contraseña.getText().toString()) ){
                        return false;
                    }else
                        return true;
                }

            }

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinpos = position;

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}