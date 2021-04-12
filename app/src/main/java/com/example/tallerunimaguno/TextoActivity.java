package com.example.tallerunimaguno;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TextoActivity extends AppCompatActivity implements View.OnClickListener {

    EditText texto;
    TextView resultado;
    CheckBox italica, negrita, subrayada;
    Button convertir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto);

        texto = findViewById(R.id.edttexto);
        resultado = findViewById(R.id.txtresuTex);
        italica = findViewById(R.id.checkItalica);
        negrita = findViewById(R.id.checknegrita);
        subrayada = findViewById(R.id.checkSubrayada);
        convertir = findViewById(R.id.btnConvertir);
        convertir.setOnClickListener(this);
        negrita.setOnClickListener(this);
        subrayada.setOnClickListener(this);
        italica.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnConvertir:

                if (negrita.isChecked()){
                    String text = texto.getText().toString();
                    resultado.setText(text);
                    resultado.setTypeface(null,Typeface.BOLD);
                    if (italica.isChecked())
                        resultado.setTypeface(null,Typeface.BOLD_ITALIC);;

                }else{
                    resultado.setTypeface(null,Typeface.NORMAL);
                    if (italica.isChecked()){
                        String text = texto.getText().toString();
                        resultado.setText(text);
                        resultado.setTypeface(null,Typeface.ITALIC);
                    }

                }



                if(subrayada.isChecked()){

                    String text = texto.getText().toString();
                    SpannableString mitexto = new SpannableString(text);
                    mitexto.setSpan(new UnderlineSpan(), 0 , mitexto.length(),0 );
                    resultado.setText(mitexto);


                }else{
                    String text = texto.getText().toString();
                    SpannableString mitexto = new SpannableString(text);
                    mitexto.setSpan(new UnderlineSpan(), 0 , 0,0 );
                    resultado.setText(mitexto);


                }


             //   String text = texto.getText().toString();
             //   resultado.setText(text);
              //  resultado.setTypeface(null,Typeface.BOLD);









                break;
        }

    }
}