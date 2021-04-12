package com.example.tallerunimaguno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VelocidadActivity extends AppCompatActivity implements View.OnClickListener {

    EditText distancia, tiempo;
    TextView resultado;
    Button calcular, limpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velocidad);
        distancia = findViewById(R.id.edtdistancia);
        tiempo = findViewById(R.id.edttiempo);
        resultado = findViewById(R.id.textvResVel);
        calcular = findViewById(R.id.btncalcvel);
        limpiar = findViewById(R.id.btnlimpiarvel);
        calcular.setOnClickListener(this);
        limpiar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btncalcvel:

                if (!estavacio(tiempo)&&!estavacio(distancia)){

                    try{
                        float num1 = Float.parseFloat(distancia.getText().toString());
                        float num2 = Float.parseFloat(tiempo.getText().toString());

                        float res = num1/num2;

                        resultado.setText(res+" m/s");
                    }  catch (Exception ex){
                        Toast.makeText(getApplicationContext(),"Error en los datos", Toast.LENGTH_LONG).show();
                    }


                }else{
                    Toast.makeText(getApplicationContext(), "Faltan Campos Por Llenar", Toast.LENGTH_LONG).show();

                }

                break;


            case R.id.btnlimpiarvel:
                distancia.setText("");
                tiempo.setText("");
                resultado.setText("");
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