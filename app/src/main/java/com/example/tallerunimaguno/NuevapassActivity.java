package com.example.tallerunimaguno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NuevapassActivity extends AppCompatActivity implements View.OnClickListener {

    EditText newpass, newpassrepeat;
    Button restablecer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevapass);

        newpass = findViewById(R.id.edtnewpass);
        newpassrepeat = findViewById(R.id.edtnewpassrepeat);
        restablecer = findViewById(R.id.btnrestablecer);
        restablecer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnrestablecer:
                if(!estavacio(newpass) && !estavacio(newpassrepeat)){

                    if ( newpass.getText().toString().trim().length()>=6 && newpassrepeat.getText().toString().trim().length()>=6){

                        if(newpass.getText().toString().trim().equalsIgnoreCase(newpassrepeat.getText().toString().trim())){

                            // guardar contraseña nueva (por implemen)

                            Toast.makeText(getApplicationContext(), "Contraseña Restablecida Correctamente", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(i);
                            finish();


                        }else{
                            Toast.makeText(getApplicationContext(), "Las Contraseñas No Coinciden", Toast.LENGTH_LONG).show();

                        }
                    }else
                        Toast.makeText(getApplicationContext(), "Las Contraseña Debe Tener Mas de 6 Caracteres", Toast.LENGTH_LONG).show();


                }else{

                    Toast.makeText(getApplicationContext(), "Faltan Campos Por Rellenar", Toast.LENGTH_LONG).show();
                }



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