package com.example.juegoppt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Juego extends AppCompatActivity {

    Button btnPiedra,btnPapel,btnTijera;
    TextView txtMarcador;
    ImageView ImgJugador,ImgCPU;
    int puntuacionJugador=0;
    int puntacionCPU=0;
    int vidas=3;
    Bundle datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego);
        getSupportActionBar().hide();


        btnPiedra = (Button) findViewById(R.id.btnPiedra);
        btnPapel = (Button) findViewById(R.id.btnPapel);
        btnTijera = (Button) findViewById(R.id.btnTijera);

        txtMarcador = (TextView) findViewById(R.id.txtMarcador);

        ImgJugador = (ImageView) findViewById(R.id.Imgjugador);
        ImgCPU = (ImageView) findViewById(R.id.ImgCPU);


            btnPiedra.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ImgJugador.setImageResource(R.drawable.piedra);
                    String mensaaje =turno("Piedra");
                    Toast.makeText(Juego.this,mensaaje,Toast.LENGTH_SHORT).show();
                    txtMarcador.setText("Jugador : "+ Integer.toString(puntuacionJugador)+"\nCPU : "+Integer.toString(puntacionCPU)+"\nVidas :"+vidas);
                }
            });

            btnPapel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ImgJugador.setImageResource(R.drawable.papel);
                    String mensaaje =turno("Papel");
                    Toast.makeText(Juego.this,mensaaje,Toast.LENGTH_SHORT).show();
                    txtMarcador.setText("Jugador : "+ Integer.toString(puntuacionJugador)+"\nCPU : "+Integer.toString(puntacionCPU)+"\nVidas :"+vidas);
                }
            });

            btnTijera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ImgJugador.setImageResource(R.drawable.tijeras);
                    String mensaaje =turno("Tijeras");
                    Toast.makeText(Juego.this,mensaaje,Toast.LENGTH_SHORT).show();
                    txtMarcador.setText("Jugador : "+ Integer.toString(puntuacionJugador)+"\nCPU : "+Integer.toString(puntacionCPU)+"\nVidas :"+vidas);
                }
            });


    }

    public String turno(String elejido) {

        if(vidas>1){
            String dispositivoSeleccion = " ";
        Random r = new Random();

        int disposit_selecion_numero =r.nextInt(3)+1;

        if(disposit_selecion_numero==1){
            dispositivoSeleccion="Piedra";
        }else  if(disposit_selecion_numero==2){
            dispositivoSeleccion="Papel";
        }else if(disposit_selecion_numero==3){
            dispositivoSeleccion="Tijeras";
        }


        if(dispositivoSeleccion=="Piedra"){
            ImgCPU.setImageResource(R.drawable.piedra);
        }else
        if(dispositivoSeleccion=="Papel"){
            ImgCPU.setImageResource(R.drawable.papel);
        }else
        if(dispositivoSeleccion=="Tijeras"){
            ImgCPU.setImageResource(R.drawable.tijeras);
        }

        if (dispositivoSeleccion.equalsIgnoreCase(elejido)){
            return "Empate";
        }else if(dispositivoSeleccion.equalsIgnoreCase("Piedra") && elejido.equalsIgnoreCase("Tijeras")){
            puntacionCPU++;
            vidas--;
            return "La piedra gana a la tijera Perdiste";
        }
        else if(dispositivoSeleccion.equalsIgnoreCase("Tijeras") && elejido.equalsIgnoreCase("Piedra")){
            puntuacionJugador++;
            return "La piedra gana a la tijera Ganaste";
        }
        else if(dispositivoSeleccion.equalsIgnoreCase("Papel") && elejido.equalsIgnoreCase("Piedra")){
            puntacionCPU++;
            vidas--;
            return "El papel gana a la piedra perdiste";
        }else if(dispositivoSeleccion.equalsIgnoreCase("Piedra") && elejido.equalsIgnoreCase("Papel")) {
            puntuacionJugador++;
            return "El papel gana a la piedra ganaste";
        }else if(dispositivoSeleccion.equalsIgnoreCase("Tijeras") && elejido.equalsIgnoreCase("Papel")) {
            puntacionCPU++;
            vidas--;
            return "Las Tijeras ganan al papel perdiste";
        }else if(dispositivoSeleccion.equalsIgnoreCase("Papel") && elejido.equalsIgnoreCase("Tijeras")) {
            puntuacionJugador++;
            return "Las Tijeras ganan al papel ganaste";
        }
        }else {
            Intent nosVamos = new Intent(Juego.this, AñadirJugador.class);
            nosVamos.putExtra("puntuacion",puntuacionJugador);
            startActivity(nosVamos);

        }
         return "Has perdido pringado";

    }
}
