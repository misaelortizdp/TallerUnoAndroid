package com.example.tallerunimaguno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class VoltajeActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    EditText corriente, res1, res2, res3;
    TextView resultado;
    Spinner numRes;
    CheckBox paralelo;

    Button  calcular, limpiar;
    int posspinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voltaje);

        corriente = findViewById(R.id.edtcorriente);
        res1 = findViewById(R.id.edtres1);
        res2 = findViewById(R.id.edtres2);
        res3 = findViewById(R.id.edtres3);
        resultado = findViewById(R.id.textvResvol);
        numRes =  findViewById(R.id.spinresistencias);
        paralelo = findViewById(R.id.checkparalelo);
        limpiar = findViewById(R.id.btnlimpiarvol);
        calcular = findViewById(R.id.btncalcvol);
        calcular.setOnClickListener(this);
        limpiar.setOnClickListener(this);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
                R.array.resistencias, android.R.layout.simple_spinner_dropdown_item);
        numRes.setAdapter(adapter);
        numRes.setOnItemSelectedListener(this);





    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btncalcvol:

                if(posspinner!=0 ){
                    if (posspinner==1){
                        if (!estavacio(corriente)&& !estavacio(res1) && !estavacio(res2)){
                            calcularVoltaje2R();
                        }else{

                            Toast.makeText(getApplicationContext(), "Faltan Campos Por Llenar", Toast.LENGTH_LONG).show();
                        }

                    }else{
                        if (!estavacio(corriente)&& !estavacio(res1) && !estavacio(res2) && !estavacio(res3)){

                            calcularVoltaje3R();

                        }else{

                            Toast.makeText(getApplicationContext(), "Faltan Campos Por Llenar", Toast.LENGTH_LONG).show();
                        }



                    }




                }else{
                    Toast.makeText(getApplicationContext(), "Seleccione Numero de Resistencias Del Circuito", Toast.LENGTH_LONG).show();
                }




                break;
            case R.id.btnlimpiarvol:
                corriente.setText("");
                res1.setText("");
                res2.setText("");
                res3.setText("");
                resultado.setText("");
                numRes.setSelection(0);
                break;
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
         posspinner=position;
        //String numResi = parent.getItemAtPosition(position).toString();
        if (position==1){

            res1.setVisibility(View.VISIBLE);
            res2.setVisibility(View.VISIBLE);
            res3.setVisibility(View.INVISIBLE);


        }else{
            if (position==2){
                res1.setVisibility(View.VISIBLE);
                res2.setVisibility(View.VISIBLE);
                res3.setVisibility(View.VISIBLE);

            }else{
                res1.setVisibility(View.INVISIBLE);
                res2.setVisibility(View.INVISIBLE);
                res3.setVisibility(View.INVISIBLE);

            }

        }





    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }

    public boolean estavacio(EditText s){
        if (TextUtils.isEmpty(s.getText().toString().trim())){
            return true;
        }
        else {
            return false;
        }

    }

    public void calcularVoltaje2R(){
        if(paralelo.isChecked()){

            try{
                float corr = Float.parseFloat(corriente.getText().toString());
                float R1 = Float.parseFloat(res1.getText().toString());
                float R2 = Float.parseFloat(res2.getText().toString());

                float voltaje = corr*(1/((1/R1)+(1/R2)));

                resultado.setText(voltaje+" V");
            }  catch (Exception ex){
                Toast.makeText(getApplicationContext(),"Error en los datos", Toast.LENGTH_LONG).show();
            }


        }else{

            try{
                float corr = Float.parseFloat(corriente.getText().toString());
                float R1 = Float.parseFloat(res1.getText().toString());
                float R2 = Float.parseFloat(res2.getText().toString());

                float voltaje = corr*(R1+R2);

                resultado.setText(voltaje+" V");
            }  catch (Exception ex){
                Toast.makeText(getApplicationContext(),"Error en los datos", Toast.LENGTH_LONG).show();
            }


        }

    }
    public void calcularVoltaje3R(){
        if(paralelo.isChecked()){

            try{
                float corr = Float.parseFloat(corriente.getText().toString());
                float R1 = Float.parseFloat(res1.getText().toString());
                float R2 = Float.parseFloat(res2.getText().toString());
                float R3 = Float.parseFloat(res3.getText().toString());

                float voltaje = corr*(1/((1/R1)+(1/R2)+(1/R3)));

                resultado.setText(voltaje+" V");
            }  catch (Exception ex){
                Toast.makeText(getApplicationContext(),"Error en los datos", Toast.LENGTH_LONG).show();
            }


        }else{

            try{
                float corr = Float.parseFloat(corriente.getText().toString());
                float R1 = Float.parseFloat(res1.getText().toString());
                float R2 = Float.parseFloat(res2.getText().toString());
                float R3 = Float.parseFloat(res3.getText().toString());

                float voltaje = corr*(R1+R2+R3);

                resultado.setText(voltaje+" V");
            }  catch (Exception ex){
                Toast.makeText(getApplicationContext(),"Error en los datos", Toast.LENGTH_LONG).show();
            }


        }

    }

}