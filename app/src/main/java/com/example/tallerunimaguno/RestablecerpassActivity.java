package com.example.tallerunimaguno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class RestablecerpassActivity extends AppCompatActivity implements View.OnClickListener {

    EditText correo, codigo;
    Button enviarCod, validar;
    int A1,A2,A3,A4,A5,A6;
    String codAleatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restablecer_pass);
        correo = findViewById(R.id.edtcorreorecup);
        codigo = findViewById(R.id.edtcodigo);
        enviarCod = findViewById(R.id.btnenviarCod);
        validar = findViewById(R.id.btnvalidar);
        enviarCod.setOnClickListener(this);
        validar.setOnClickListener(this);
        validar.setEnabled(false);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btnenviarCod:

                if(!estavacio(correo)){
                    // guarda correo
                    // (por impementar)


                    //genera codigo, lo guarda en variable y lo envia
                    Random r = new Random();
                    A1 = r.nextInt(9 - 0) + 1;
                    A2 = r.nextInt(9 - 0) + 1;
                    A3 = r.nextInt(9 - 0) + 1;
                    A4 = r.nextInt(9 - 0) + 1;
                    A5 = r.nextInt(9 - 0) + 1;
                    A6 = r.nextInt(9 - 0) + 1;

                    codAleatorio = "" + A1 + A2 + A3 + A4 + A5 + A6;
                    Toast.makeText(getApplicationContext(), "codigo: " + codAleatorio.toString().trim(), Toast.LENGTH_LONG).show();
                     validar.setEnabled(true);
                }else {

                    Toast.makeText(getApplicationContext(), "Campo Vacio, Escriba Su Correo", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.btnvalidar:

                if (!estavacio(codigo)){
                    if (codigo.getText().toString().trim().equalsIgnoreCase(codAleatorio.trim())){

                        Intent i = new Intent(getApplicationContext(),NuevapassActivity.class);
                        startActivity(i);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(), "Codigo incorrecto", Toast.LENGTH_LONG).show();

                    }


                }else{
                    Toast.makeText(getApplicationContext(), "Campo Vacio, Escriba El Codigo De Verificacion", Toast.LENGTH_LONG).show();
                }

                break;

        }



    }

    public boolean estavacio(EditText s){
        if (TextUtils.isEmpty(s.getText().toString().trim())){
            return true;
        }
        else {
            return false;
        }
    }
}