package com.example.juegoppt;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;
import com.example.juegoppt.BaseDate;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AñadirJugador extends AppCompatActivity {

    private EditText Nombre;
    ArrayAdapter<String> arrayAdapter;
    public static ArrayList array_list_jugadores;
    int puntuacion1;


    BaseDate admin;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_jugador);
        //Para quitar el ActionBar
        getSupportActionBar().hide();

        Nombre =(EditText) findViewById(R.id.Nombre);

        Bundle extras = getIntent().getExtras();
        puntuacion1 = extras.getInt("puntuacion");
    }
    public void GuardarJugador(View view) {
        Integer numeroAleatorio = (int) (Math.random()*100+100); //Hago un MathRandom para que luego se le asigne un codigo a cada nota, de cara a eliminarlas despues

        admin = new BaseDate(this, "jugadores", null, 1);
        db = admin.getWritableDatabase();
        String nombre = Nombre.getText().toString();


        //Insertamos en la base de datos y en el arraylist
        ContentValues jugadores = new ContentValues();
        jugadores.put("Codigo",Integer.toString(numeroAleatorio));
        jugadores.put("Nombre", nombre);
        jugadores.put("Puntuacion" , String.valueOf(puntuacion1));
        db.insert("jugadores", null, jugadores); //Finalmente se introduce en la tabla Notas
        db.close(); //Cerramos la conexion con la base de datos

        Toast.makeText(this, "Puntuacion guardada  ", //Este mensaje se muestra en pantalla una vez que se ha guardado la nota con exito
                Toast.LENGTH_SHORT).show();

        startActivity(new Intent(AñadirJugador.this, MainActivity.class));


 //       Intent intent = new Intent(this, Juego.class);
 //       startActivity(intent);
    }
}
