package com.example.tallerunimaguno;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    Button matematicas, logout, estadistica, texto, ayuda, fisica;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        matematicas = findViewById(R.id.btnmatematicas);
        fisica = findViewById(R.id.btnfisica);
        texto = findViewById(R.id.btntexto);
        logout = findViewById(R.id.btnlogout);
        logout.setOnClickListener(this);
        texto.setOnClickListener(this);
        fisica.setOnClickListener(this);
        matematicas.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.mnugeometria:
            //    Toast.makeText(getApplicationContext(), "MENU GEOMETRIA", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), GeometriaActivity.class);
                startActivity(i);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnmatematicas:
                Intent i = new Intent(getApplicationContext(),MatematicasActivity.class);
                startActivity(i);
                break;

            case R.id.btnfisica:
                i = new Intent(getApplicationContext(),FisicaActivity.class);
                startActivity(i);
                break;


                
            case R.id.btnlogout:

                 i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Sesion Cerrada Con Exito", Toast.LENGTH_LONG).show();
                finish();
                break;
            case R.id.btnayuda:
                break;

            case R.id.btntexto:
                i = new Intent(getApplicationContext(),TextoActivity.class);
                startActivity(i);
                break;

        }
    }
}