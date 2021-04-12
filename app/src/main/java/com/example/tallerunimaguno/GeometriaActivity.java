package com.example.tallerunimaguno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class GeometriaActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    EditText xpunto1, xpunto2, ypunto1, ypunto2;
    TextView resultado;
    Spinner tipo;
    Button calcular, limpiar;
    int spinpos;
    String concat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geometria);

        xpunto1 = findViewById(R.id.edtxpto1);
        xpunto2 = findViewById(R.id.edtxpto2);
        ypunto1 = findViewById(R.id.edtypto1);
        ypunto2 = findViewById(R.id.edtypto2);
        resultado = findViewById(R.id.resulgeometria);
        tipo = findViewById(R.id.spingeometria);
        calcular = findViewById(R.id.btncalcgeo);
        limpiar = findViewById(R.id.btnlimpgeo);

        calcular.setOnClickListener(this);
        limpiar.setOnClickListener(this);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
                R.array.tipo_calculo, android.R.layout.simple_spinner_dropdown_item);
        tipo.setAdapter(adapter);
        tipo.setOnItemSelectedListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btncalcgeo:

                if (!estavacio(xpunto1) && !estavacio(xpunto2) && !estavacio(ypunto1) && !estavacio(ypunto2)){
                    if (spinpos!=0){
                        if (spinpos==1){
                            calcularcuadrante();
                        }else{
                            if (spinpos==2){
                                calcularpendiente();
                            }else{
                                if (spinpos==3){
                                    calculardistancia();
                                }
                            }

                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Seleccione El Tipo De Calculo", Toast.LENGTH_LONG).show();
                    }

                }else{

                    Toast.makeText(getApplicationContext(), "Faltan Campos Por Llenar", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnlimpgeo:

                xpunto1.setText("");
                xpunto2.setText("");
                ypunto1.setText("");
                ypunto2.setText("");
                resultado.setText("");
                tipo.setSelection(0);


                break;



        }



    }

    private void calculardistancia() {

        double x1 = Double.parseDouble(xpunto1.getText().toString().trim());
        double x2 = Double.parseDouble(xpunto2.getText().toString().trim());
        double y1 = Double.parseDouble(ypunto1.getText().toString().trim());
        double y2 = Double.parseDouble(ypunto2.getText().toString().trim());



        double dist = Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));


        resultado.setText("Distancia Entre Punto1 y Punto2:\n"+dist);

    }


    private void calcularpendiente() {
        float x1 = Float.parseFloat(xpunto1.getText().toString().trim());
        float x2 = Float.parseFloat(xpunto2.getText().toString().trim());
        float y1 = Float.parseFloat(ypunto1.getText().toString().trim());
        float y2 = Float.parseFloat(ypunto2.getText().toString().trim());

        float pend = ((y2-y1)/(x2-x1));

        resultado.setText("La Pendiente Entre Punto1 y Punto2: "+pend);


    }

    public boolean estavacio(EditText s){
        if (TextUtils.isEmpty(s.getText().toString().trim())){
            return true;
        }
        else {
            return false;
        }

    }

    public void calcularcuadrante(){
        float x1 = Float.parseFloat(xpunto1.getText().toString().trim());
        float x2 = Float.parseFloat(xpunto2.getText().toString().trim());
        float y1 = Float.parseFloat(ypunto1.getText().toString().trim());
        float y2 = Float.parseFloat(ypunto2.getText().toString().trim());

        if(x1<0 && y1<0){
            resultado.setText("PUNTO 1: Cuadrante 3\n");
        }else{
            if (x1>0 && y1<0){
                resultado.setText("PUNTO 1: Cuadrante 4\n");
            }else{
                if (x1<0 && y1>0){
                    resultado.setText("PUNTO 1: Cuadrante 2\n");
                }else{
                    if (x1>0 && y1>0){
                        resultado.setText("PUNTO 1: Cuadrante 1\n");
                    }else{
                        if(x1==0 && y1==0){

                            resultado.setText("PUNTO 1:  Ningun Cuadrante (X1 y Y1 Son Iguales a Cero) \n");
                        }else{
                            if (x1==0){
                                resultado.setText("PUNTO 1: Ningun Cuadrante (X1 Es Igual a Cero) \n");
                            }else{
                                if (y1==0){
                                    resultado.setText("PUNTO 1: Ningun Cuadrante (Y1 Es Igual a Cero) \n");
                                }

                            }

                        }

                    }

                }

            }

        }

        if(x2<0 && y2<0){
            concat = resultado.getText().toString().trim().concat("\nPUNTO 2: Cuadrante 3\n");
            resultado.setText(concat);
        }else{
            if (x2>0 && y2<0){
                concat = resultado.getText().toString().trim().concat("\nPUNTO 2: Cuadrante 4\n");
                resultado.setText(concat);
            }else{
                if (x2<0 && y2>0){
                    concat = resultado.getText().toString().trim().concat("\nPUNTO 2: Cuadrante 2\n");
                    resultado.setText(concat);
                }else{
                    if (x2>0 && y2>0){

                        concat = resultado.getText().toString().trim().concat("\nPUNTO 2: Cuadrante 1\n");
                        resultado.setText(concat);
                    }else{
                        if(x2==0 && y2==0){

                            concat = resultado.getText().toString().trim().concat
                                    ("\nPUNTO 2: Ningun Cuadrante (X2 y Y2 Son Iguales a Cero)\n");
                            resultado.setText(concat);

                        }else{
                            if (x2==0){
                                concat = resultado.getText().toString().trim().concat
                                        ("\nPUNTO 2: Ningun Cuadrante (X2 Es Igual a Cero)\n");
                                resultado.setText(concat);
                            }else{
                                if (y2==0){
                                    concat = resultado.getText().toString().trim().concat
                                            ("\nPUNTO 2: Ningun Cuadrante (Y2 Es Igual a Cero)\n");
                                    resultado.setText(concat);
                                }

                            }

                        }


                    }



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