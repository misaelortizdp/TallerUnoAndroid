package com.example.tallerunimaguno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FuerzaActivity extends AppCompatActivity  implements View.OnClickListener {

    EditText masa, aceleracion;
    TextView resultado;
    Button calcular, limpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuerza);

        masa = findViewById(R.id.edtmasa);
        aceleracion = findViewById(R.id.edtaceleracion);
        resultado = findViewById(R.id.textvResFu);
        calcular = findViewById(R.id.btncalcFu);
        limpiar = findViewById(R.id.btnlimpiarFu);
        calcular.setOnClickListener(this);
        limpiar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btncalcFu:

                if (!estavacio(masa)&&!estavacio(aceleracion)){

                    try{
                        float num1 = Float.parseFloat(masa.getText().toString());
                        float num2 = Float.parseFloat(aceleracion.getText().toString());

                        float res = num1*num2;

                        resultado.setText(res+" N");
                    }  catch (Exception ex){
                        Toast.makeText(getApplicationContext(),"Error en los datos", Toast.LENGTH_LONG).show();
                    }


                }else{
                    Toast.makeText(getApplicationContext(), "Faltan Campos Por Llenar", Toast.LENGTH_LONG).show();

                }

                break;


            case R.id.btnlimpiarFu:
                masa.setText("");
                aceleracion.setText("");
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