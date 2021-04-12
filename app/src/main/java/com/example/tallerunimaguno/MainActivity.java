package com.example.tallerunimaguno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
 TextView olvidarC;
 EditText usuario, clave;
 Button ingresar, registrarse, limpiar;
 String usuarios[]={"admin", "misael","camila" };
 String contraseñas[]={"123456", "555555", "888888"};
 CheckBox recordar, terminos;
 Intent i;

 boolean sw;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = findViewById(R.id.edtusuario);
        clave = findViewById(R.id.edtclave);
        ingresar = findViewById(R.id.btningresar);
        registrarse = findViewById(R.id.btnregistrarse);
        limpiar = findViewById(R.id.btnlimpmain);
        olvidarC = findViewById(R.id.txtolvidar);
        recordar = findViewById(R.id.checkrecordardatos);
        terminos = findViewById(R.id.checkterminos);
        ingresar.setEnabled(false);

        limpiar.setOnClickListener(this);
        ingresar.setOnClickListener(this);
        registrarse.setOnClickListener(this);
        olvidarC.setOnClickListener(this);
        //recordar.setOnClickListener(this);
        terminos.setOnClickListener(this);
        sw=false;

        SpannableString mitexto = new SpannableString("Olvidar Contraseña");
        mitexto.setSpan(new UnderlineSpan(), 0 , mitexto.length(),0 );
        olvidarC.setText(mitexto);

        SharedPreferences preferences = getSharedPreferences("grdUsuarios", Context.MODE_PRIVATE);
        usuario.setText(preferences.getString("usuario", ""));
        clave.setText(preferences.getString("clave", ""));




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }



    @Override
    public void onClick(View v) {


        switch(v.getId()){

            case R.id.btningresar :



                   if(validarUsuarioyclave()){


                       if(recordar.isChecked()){
                           SharedPreferences preferences = getSharedPreferences("grdUsuarios", Context.MODE_PRIVATE);
                           SharedPreferences.Editor editor = preferences.edit();
                           editor.putString("usuario", usuario.getText().toString());
                           editor.putString("clave", clave.getText().toString());
                           editor.commit();

                       }


                       Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                       startActivity(i);
                       finish();
                   }
                   else{
                       Toast.makeText(getApplicationContext(), "Error credenciales", Toast.LENGTH_LONG).show();
                   }

                   break;


            case R.id.btnregistrarse:
                Intent i = new Intent(getApplicationContext(),RegistrarseActivity.class);
                startActivity(i);
                finish();

                   break;
            case R.id.txtolvidar:

                olvidarC.setTextColor(Color.parseColor("#9115A6"));
                i = new Intent(getApplicationContext(), RestablecerpassActivity.class);
                startActivity(i);
                finish();

                break;

            case R.id.checkterminos:
                if (terminos.isChecked()){
                    ingresar.setEnabled(true);
                }else{
                    ingresar.setEnabled(false);
                }

                break;
            case R.id.btnlimpmain:
                usuario.setText("");
                clave.setText("");
                recordar.setChecked(false);
                terminos.setChecked(false);
                ingresar.setEnabled(false);
                olvidarC.setTextColor(Color.parseColor("#0A1F9E"));


                break;


        }
    }

    public boolean validarUsuarioyclave(){

        for (int i=0;i< usuarios.length;i++){
            if(usuario.getText().toString().trim().equalsIgnoreCase(usuarios[i]) && clave.getText().toString().trim().equalsIgnoreCase(contraseñas[i]) ){
                sw =  true;
                break;

            }else{
                sw = false;
            }

        }
       return sw;
    }


}