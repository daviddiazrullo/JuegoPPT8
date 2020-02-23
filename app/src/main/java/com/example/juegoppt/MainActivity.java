package com.example.juegoppt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity{
    ListView listaView;
    BaseDate admin;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Para quitar el ActionBar
        getSupportActionBar().hide();

        ListView listaView = (ListView) findViewById(R.id.listaPuntuaciones); //Localizamos la ListView donde introduciremos nuestras notas

        //Llamo al metodo getAllRegistros que lista todos lo datos registrados de la base de datos.
        admin = new BaseDate(this, "jugadores", null, 1);
        ArrayList jugador= admin.getMejoresPuntuacios();
        ArrayAdapter<String> arrayAdapter=
                new ArrayAdapter<String>(
                        this,android.R.layout.simple_list_item_1, jugador);
        listaView.setAdapter(arrayAdapter);

    }

    //Metodo que nos llevara a la pantalla para crear un jugador o seguir con el que habiamos creado
    public void Juego(View view){
        startActivity(new Intent(MainActivity.this, Juego.class));
    }
}
